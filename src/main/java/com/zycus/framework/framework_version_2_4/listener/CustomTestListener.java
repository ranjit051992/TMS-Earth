package com.zycus.framework.framework_version_2_4.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.collections.Lists;
import org.testng.collections.Objects;
import org.testng.internal.IResultListener2;

import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * 
 * @author aryasindhu.sahu
 *
 */
public class CustomTestListener implements IResultListener2
{

	private final Logger				logger					= Logger.getLogger(CustomTestListener.class);
	private static int					testSuiteSize			= Startup.testMethodTestCaseMap.size() / Startup.browserEnvironments.size();
	private List<Object>				m_allTestMethods		= Collections.synchronizedList(Lists.newArrayList());

	private List<Object>				m_passedTests			= Collections.synchronizedList(Lists.newArrayList());
	private List<Object>				m_failedTests			= Collections.synchronizedList(Lists.newArrayList());
	private List<Object>				m_skippedTests			= Collections.synchronizedList(Lists.newArrayList());
	private List<Object>				m_failedButWSPerTests	= Collections.synchronizedList(Lists.newArrayList());
	private final List<ITestContext>	m_testContexts			= Collections.synchronizedList(new ArrayList<ITestContext>());
	private final List<Object>			m_failedConfs			= Collections.synchronizedList(Lists.newArrayList());
	private final List<Object>			m_skippedConfs			= Collections.synchronizedList(Lists.newArrayList());
	private final List<Object>			m_passedConfs			= Collections.synchronizedList(Lists.newArrayList());

	private static int					RETRY_LIMIT				= Integer.parseInt(ConfigProperty.getConfig("RETRY_LIMIT"));

	@Override
	public void onTestSuccess(ITestResult tr)
	{
		if (m_allTestMethods.size() == testSuiteSize)
		{
			m_allTestMethods.clear();
			m_passedTests.clear();
			m_failedTests.clear();
		}

		this.m_allTestMethods.add(tr.getMethod());
		this.m_passedTests.add(tr);
		int remainingCount = testSuiteSize - (m_passedTests.size() + m_failedTests.size());
		String log = "\n";
		log += "======================================================\n";
		log += "Test :" + tr.getMethod().getMethodName() + " Passed\n";
		log += "PASSED:" + m_passedTests.size() + " | FAILED: " + m_failedTests.size() + " | EXECUTED:" + m_allTestMethods.size() + " || TOTAL:" + testSuiteSize + " | REMAINING: "
			+ remainingCount;
		log += "\n======================================================";
		logger.info(log);
	}

	@Override
	public void onTestFailure(ITestResult tr)
	{
		String testSuiteName = tr.getTestContext().getSuite().getName();
		String retryMethodName = tr.getMethod().getMethodName();
		String key = testSuiteName + "_" + retryMethodName;
		boolean retry = false;
		int currentCount = 1;

		if (CustomRetryListener.methodRetryCountMap.containsKey(key))
		{
			currentCount = CustomRetryListener.methodRetryCountMap.get(key);
			currentCount++;
		}
		if (RETRY_LIMIT < currentCount)
		{
			retry = false;
		}
		else
		{
			retry = true;
		}

		// If The TC is going to be retried skip updating all, failed, etc
		// counts else update all, failed, etc counts.
		if (retry)
		{
			logger.info("TestCase [" + retryMethodName + "] shall be retried, not adding to List of all Testcases and failedTestCass.");
		}
		else
		{
			if (m_allTestMethods.size() == testSuiteSize)
			{
				m_allTestMethods.clear();
				m_passedTests.clear();
				m_failedTests.clear();
			}
			this.m_allTestMethods.add(tr.getMethod());
			this.m_failedTests.add(tr);
			int remainingCount = testSuiteSize - (m_passedTests.size() + m_failedTests.size());
			String log = "\n";
			log += "======================================================\n";
			log += "Test :" + tr.getMethod().getMethodName() + " Failed\n";
			log += "PASSED:" + m_passedTests.size() + " | FAILED: " + m_failedTests.size() + " | EXECUTED:" + m_allTestMethods.size() + " || TOTAL:" + testSuiteSize
				+ " | REMAINING: " + remainingCount;
			log += "\n======================================================";
			logger.info(log);
		}

		// TODO : New Code
		boolean isSkip = Boolean.valueOf(ConfigProperty.getConfig("MODULEWISE_SKIP"));
		if (isSkip)
		{
			String browser = testSuiteName.substring(0, testSuiteName.indexOf("-"));
			String version = testSuiteName.substring(1 + testSuiteName.indexOf("-"), testSuiteName.lastIndexOf("-"));
			TestCase testCase = Startup.testMethodTestCaseMap.get(retryMethodName + "*" + browser + "*" + version);
			String failedModuleName = testCase.getModuleName();
			logger.info("New FailedModule :" + failedModuleName);
			Startup.failedModuleNames.add(failedModuleName);
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr)
	{
		this.m_allTestMethods.add(tr.getMethod());
		this.m_skippedTests.add(tr);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr)
	{
		this.m_allTestMethods.add(tr.getMethod());
		this.m_failedButWSPerTests.add(tr);
	}

	protected ITestNGMethod[] getAllTestMethods()
	{
		return this.m_allTestMethods.toArray(new ITestNGMethod[this.m_allTestMethods.size()]);
	}

	@Override
	public void onStart(ITestContext testContext)
	{
		this.m_testContexts.add(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext)
	{
	}

	public List<Object> getFailedButWithinSuccessPercentageTests()
	{
		return this.m_failedButWSPerTests;
	}

	public List<Object> getFailedTests()
	{
		return this.m_failedTests;
	}

	public List<Object> getPassedTests()
	{
		return this.m_passedTests;
	}

	public List<Object> getSkippedTests()
	{
		return this.m_skippedTests;
	}

	public void setAllTestMethods(List<Object> allTestMethods)
	{
		this.m_allTestMethods = allTestMethods;
	}

	public void setFailedButWithinSuccessPercentageTests(List<Object> failedButWithinSuccessPercentageTests)
	{
		this.m_failedButWSPerTests = failedButWithinSuccessPercentageTests;
	}

	public void setFailedTests(List<Object> failedTests)
	{
		this.m_failedTests = failedTests;
	}

	public void setPassedTests(List<Object> passedTests)
	{
		this.m_passedTests = passedTests;
	}

	public void setSkippedTests(List<Object> skippedTests)
	{
		this.m_skippedTests = skippedTests;
	}

	@Override
	public void onTestStart(ITestResult result)
	{
	}

	public List<ITestContext> getTestContexts()
	{
		return this.m_testContexts;
	}

	public List<Object> getConfigurationFailures()
	{
		return this.m_failedConfs;
	}

	@Override
	public void onConfigurationFailure(ITestResult itr)
	{
		this.m_failedConfs.add(itr);
	}

	public List<Object> getConfigurationSkips()
	{
		return this.m_skippedConfs;
	}

	@Override
	public void beforeConfiguration(ITestResult tr)
	{
	}

	@Override
	public void onConfigurationSkip(ITestResult itr)
	{
		this.m_skippedConfs.add(itr);
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr)
	{
		this.m_passedConfs.add(itr);
	}

	@Override
	public String toString()
	{
		return Objects.toStringHelper(getClass()).add("passed", Integer.valueOf(getPassedTests().size())).add("failed", Integer.valueOf(getFailedTests().size()))
			.add("skipped", Integer.valueOf(getSkippedTests().size())).toString();
	}
}