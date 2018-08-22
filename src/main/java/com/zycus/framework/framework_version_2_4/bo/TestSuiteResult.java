package com.zycus.framework.framework_version_2_4.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aryasindhu.sahu
 *
 */
public class TestSuiteResult
{

	private String					browserVersion		= null;
	private int						total				= 0;
	private int						passed				= 0;
	private int						failed				= 0;
	private int						skipped				= 0;
	private int						actualFailure		= 0;
	private int						falseAlert			= 0;
	private List<TestCaseResult>	passedTests			= new ArrayList<TestCaseResult>();
	private List<TestCaseResult>	failedTests			= new ArrayList<TestCaseResult>();
	private List<TestCaseResult>	skippedTests		= new ArrayList<TestCaseResult>();
	private List<TestCaseResult>	falseAlertTests		= new ArrayList<TestCaseResult>();
	private List<TestCaseResult>	actualFailureTests	= new ArrayList<TestCaseResult>();

	public List<TestCaseResult> getSkippedTests()
	{
		return skippedTests;
	}

	public void setSkippedTests(List<TestCaseResult> skippedTests)
	{
		this.skippedTests = skippedTests;
	}

	public int getSkipped()
	{
		return skipped;
	}

	public void setSkipped(int skipped)
	{
		this.skipped = skipped;
	}

	public String getBrowserVersion()
	{
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion)
	{
		this.browserVersion = browserVersion;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getPassed()
	{
		return passed;
	}

	public void setPassed(int passed)
	{
		this.passed = passed;
	}

	public int getFailed()
	{
		return failed;
	}

	public void setFailed(int failed)
	{
		this.failed = failed;
	}

	public int getActualFailure()
	{
		return actualFailure;
	}

	public void setActualFailure(int actualFailure)
	{
		this.actualFailure = actualFailure;
	}

	public int getFalseAlert()
	{
		return falseAlert;
	}

	public void setFalseAlert(int falseAlert)
	{
		this.falseAlert = falseAlert;
	}

	public List<TestCaseResult> getPassedTests()
	{
		return passedTests;
	}

	public void setPassedTests(List<TestCaseResult> passedTests)
	{
		this.passedTests = passedTests;
	}

	public List<TestCaseResult> getFailedTests()
	{
		return failedTests;
	}

	public void setFailedTests(List<TestCaseResult> failedTests)
	{
		this.failedTests = failedTests;
	}

	public List<TestCaseResult> getFalseAlertTests()
	{
		return falseAlertTests;
	}

	public void setFalseAlertTests(List<TestCaseResult> falseAlertTests)
	{
		this.falseAlertTests = falseAlertTests;
	}

	public List<TestCaseResult> getActualFailureTests()
	{
		return actualFailureTests;
	}

	public void setActualFailureTests(List<TestCaseResult> actualFailureTests)
	{
		this.actualFailureTests = actualFailureTests;
	}

	@Override
	public String toString()
	{
		return "TestSuiteResult [browserVersion=" + browserVersion + ", total=" + total + ", passed=" + passed + ", failed=" + failed + ", skipped=" + skipped + ", actualFailure="
			+ actualFailure + ", falseAlert=" + falseAlert + ", passedTests=" + passedTests + ", failedTests=" + failedTests + ", skippedTests=" + skippedTests
			+ ", falseAlertTests=" + falseAlertTests + ", actualFailureTests=" + actualFailureTests + "]";
	}

}
