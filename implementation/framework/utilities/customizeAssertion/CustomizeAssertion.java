package framework.utilities.customizeAssertion;

import framework.reporting.TestReportingBO;
import framework.startup.Startup;
import org.apache.log4j.Logger;
import org.testng.Assert;
import eProc.productUtilities.constants.Constants;

public class CustomizeAssertion
{
	public static Logger logger = Logger.getLogger(CustomizeAssertion.class);

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description assertTrue is wrapper on testNG assertTrue and updates
	 *              status in Reporting BO;
	 * @param *Boolean
	 *            test case status, String assertion Message, String testcase
	 *            JiraID;
	 * @return Nil;
	 */
	public static void assertTrue(boolean status, String message, String JiraId) throws Exception
	{
		if (status)
		{
			Constants.testCaseStatus.put(JiraId, "PASSED");
		}
		else
		{
			Constants.testCaseStatus.put(JiraId, "FAILED");
		}

		TestReportingBO ReportingBO = Startup.testMethodTestCaseMap.get(JiraId);
		if (ReportingBO != null)
		{
			if (status == true)
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("PASSED");
				Constants.passedCases.add(JiraId);
			}
			else
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("FAILED");
				Constants.failedCases.add(JiraId);
			}
			Startup.testMethodTestCaseMap.put(JiraId, ReportingBO);
			ReportingBO = null;
		}
		else
		{
			logger.info(" incorrect jiraid ...can't update status");
		}
		Assert.assertTrue(status, message);
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description softAssertTrue is wrapper on testNG softAssertTrue and
	 *              updates status in Reporting BO;
	 * @param *Boolean
	 *            test case status, String assertion Message, String testcase
	 *            JiraID;
	 * @return Nil;
	 */
	public static void softAssertTrue(boolean status, String message, String JiraId) throws Exception
	{
		if (status)
		{
			Constants.testCaseStatus.put(JiraId, "PASSED");
		}
		else
		{
			Constants.testCaseStatus.put(JiraId, "FAILED");
		}
		TestReportingBO ReportingBO = Startup.testMethodTestCaseMap.get(JiraId);
		org.testng.asserts.SoftAssert softassert = new org.testng.asserts.SoftAssert();
		if (ReportingBO != null)
		{
			if (status)
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("PASSED");
				Constants.passedCases.add(JiraId);
			}
			else
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("FAILED");
				ReportingBO.setMessage("Assertion Exception : " + message);
				Constants.failedCases.add(JiraId);
			}
			Startup.testMethodTestCaseMap.put(JiraId, ReportingBO);
			ReportingBO = null;
		}
		else
		{
			logger.info(" incorrect jiraid ...can't update status");
		}
		softassert.assertTrue(status, message);
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description assertFalse is wrapper on testNG assertFalse and updates
	 *              status in Reporting BO;
	 * @param *Boolean
	 *            test case status, String assertion Message, String testcase
	 *            JiraID;
	 * @return Nil;
	 */
	public static void assertFalse(boolean status, String message, String JiraId) throws Exception
	{
		if (status)
		{
			Constants.testCaseStatus.put(JiraId, "FAILED");
		}
		else
		{
			Constants.testCaseStatus.put(JiraId, "PASSED");
		}

		TestReportingBO ReportingBO = Startup.testMethodTestCaseMap.get(JiraId);
		if (ReportingBO != null)
		{
			if (status)
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("FAILED");
				Constants.failedCases.add(JiraId);
			}
			else
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("PASSED");
				Constants.passedCases.add(JiraId);
			}
			Startup.testMethodTestCaseMap.put(JiraId, ReportingBO);
			ReportingBO = null;
		}
		else
		{
			logger.info(" incorrect jiraid ...can't update status");
		}
		Assert.assertFalse(status, message);
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description softAssertFalse is wrapper on testNG softAssertFalse and
	 *              updates status in Reporting BO;
	 * @param *Boolean
	 *            test case status, String assertion Message, String testcase
	 *            JiraID;
	 * @return Nil;
	 */
	public static void softAssertFalse(boolean status, String message, String JiraId) throws Exception
	{
		if (status)
		{
			Constants.testCaseStatus.put(JiraId, "FAILED");
		}
		else
		{
			Constants.testCaseStatus.put(JiraId, "PASSED");
		}

		TestReportingBO ReportingBO = Startup.testMethodTestCaseMap.get(JiraId);
		org.testng.asserts.SoftAssert softassert = new org.testng.asserts.SoftAssert();
		if (ReportingBO != null)
		{
			if (status)
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("FAILED");
				ReportingBO.setMessage("Assertion Exception : " + message);
				Constants.failedCases.add(JiraId);
			}
			else
			{
				ReportingBO.setTestCaseName(JiraId);
				ReportingBO.setExecutionResult("PASSED");
				Constants.passedCases.add(JiraId);
			}
			Startup.testMethodTestCaseMap.put(JiraId, ReportingBO);
			ReportingBO = null;
		}
		else
		{
			logger.info(" incorrect jiraid ...can't update status");
		}
		softassert.assertFalse(status, message);
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @descriptionassertAll is just a Wrapper on testNG assertAll;
	 * @param *Nil;
	 * @return Nil;
	 */
	public static void assertAll()
	{
		org.testng.asserts.SoftAssert softassert = new org.testng.asserts.SoftAssert();
		softassert.assertAll();
	}
}
