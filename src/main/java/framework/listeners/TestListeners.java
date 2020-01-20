package framework.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import framework.frameworkUtilies.testResult.ReportingService;
import framework.utilities.commonServices.CommonServices;
import product.constants.iConstants;

public class TestListeners implements ITestListener
{
	static Logger logger = Logger.getLogger(TestListeners.class);

	// executes before every testcase
	public void onTestStart(ITestResult result)
	{
		try
		{

			String methodName = result.getMethod().getMethodName();
			logger.info("on test start : " + methodName);
			iConstants.totalCases.add(methodName);
			ReportingService.beforeCase(methodName);
			CommonServices.dirCreationForScreenShot(methodName);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void onTestSuccess(ITestResult result)
	{
		logger.info("onTestSuccess   : ");

	}

	public void onTestFailure(ITestResult result)
	{
		logger.info("onTestFailure   ");

	}

	public void onTestSkipped(ITestResult result)
	{
		logger.info("onTestSkipped  ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		logger.info("");
	}

	public void onStart(ITestContext context)
	{
		try
		{
			logger.info("on start ");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context)
	{
		logger.info("  onFinish  ");
	}

}
