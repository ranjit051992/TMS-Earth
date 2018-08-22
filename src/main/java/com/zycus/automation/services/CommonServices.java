package com.zycus.automation.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


import com.zycus.automation.bo.EmailDetails;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.User;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelDatabaseReader;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.GenerateResultsException;
import com.zycus.automation.integration.testopia.TestopiaData;
import com.zycus.automation.testresult.GenerateResults;
import com.zycus.automation.testresult.TestResults;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.loginlogout.Logout;
import com.zycus.automation.utilities.reports.CreateEmailReport;
import com.zycus.automation.utilities.reports.SanityReport1;
import com.zycus.automation.utilities.reports.display.DisplayConsoleData;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.bo.TestCaseResult;
import com.zycus.framework.framework_version_2_4.bo.TestSuiteResult;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.startup.Startup;

public class CommonServices
{

	static Logger										logger			= Logger.getLogger(CommonServices.class);

	public static Map<String, LinkedList<TestResults>>	testCaseResult	= new LinkedHashMap<String, LinkedList<TestResults>>();
	public static Map<String, Map<String, TestResults>>	finalResultSet	= new LinkedHashMap<String, Map<String, TestResults>>();

	public static void successfulExecutionOfTestCase(WebDriver driver, TestCase testCase)
	{
		String testCaseName = testCase.getTestMethodName();
		try
		{
			testCase.setResultOfTC(true);
			logger.info("\n\n ************************* Testcase " + testCaseName + " Executed Successfully *************************** \n \n");
			GenerateResults.setResult(driver, testCase, true);
			ExcelReader.writeResult("PASS", testCase, null, null, null, null);

			ScreenShot.screenshot(driver, testCaseName, "Successful_Execution_Of_TestCase".toUpperCase() + testCaseName);

			ExcelDatabaseReader.insertResult(testCase, null, null, true, null);
		}
		catch (GenerateResultsException e)
		{
			logger.error("Error in Generate Results : " + e, e);
		}
		catch (Exception e)
		{
			logger.error("Error in Successful Execution Of TestCases" + e, e);
		}
	}

	public static void assertionMethod(WebDriver driver, TestCase testCase, User user, AssertionError e) throws GenerateResultsException
	{
		String testCaseName = null, errorMsg = "";
		try
		{
			testCaseName = testCase.getTestMethodName();
			testCase.setResultOfTC(false);
			ExcelReader.writeResult("FAIL", testCase, null, null, null, e);
			errorMsg = printErrorMessage(driver, testCaseName, e, null);
			testCase.setExceptionMessage(errorMsg);
			GenerateResults.setResult(driver, testCase, false, e);

			ExcelDatabaseReader.insertResult(testCase, null, null, false, null);
		}
		catch (GenerateResultsException ex)
		{
			logger.error("Error in Generate Results : " + ex, ex);
		}
		catch (WebDriverException ex)
		{
			testCase.setExceptionMessage("============ WEBDRIVER IS NOT AVALIABLE TO PROCEED ============");
			logger.error("Webdriver exception has occurred : " + ex, ex);
		}
		catch (Exception ex)
		{
			logger.info("Exception occurred in assertionMethod : " + ex, ex);
		}
		finally
		{
			ScreenShot.exceptionScreenshot(driver, testCaseName, "Assertion Occurced");
			Assert.fail("Assertion Failure occcured in Method in : " + testCaseName + e);
		}
	}

	public static void exceptionMethod(WebDriver driver, TestCase testCase, User user, Exception e) throws GenerateResultsException
	{
		String testCaseName = null, errorMsg = "";
		try
		{
			testCaseName = testCase.getTestMethodName();
			testCase.setResultOfTC(false);
			ExcelReader.writeResult("FAIL", testCase, null, null, null, null);
			errorMsg = printErrorMessage(driver, testCaseName, null, e);
			testCase.setExceptionMessage(errorMsg);
			GenerateResults.setResult(driver, testCase, false, e);

			ExcelDatabaseReader.insertResult(testCase, null, null, false, null);
		}
		catch (GenerateResultsException ex)
		{
			logger.error("Error in Generate Results : " + ex, ex);
		}
		catch (WebDriverException ex)
		{
			testCase.setExceptionMessage("============ WEBDRIVER IS NOT AVALIABLE TO PROCEED ============");
			logger.error("Webdriver exception has occurred : " + ex, ex);
		}
		catch (Exception ex)
		{
			logger.error("Exception occurred in exceptionMethod : " + ex, ex);
		}
		finally
		{
			ScreenShot.exceptionScreenshot(driver, testCaseName, "Error Occurred");
			Assert.fail("Assertion Failure occcured in Method in : " + testCaseName);
		}
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, Map<String, String> map, User user)
		throws  WebDriverException, Exception
	{
		String testCaseName = testCase.getTestMethodName(), result;
		try
		{
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");

			printBlankPageErrorMsg(driver, testCaseName);

			LoginLogoutServices.logout(driver, testCase, user);
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}

			String testData = "";
			// to write the testdata in excel
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				testData = testData + entry.getKey() + "=" + entry.getValue() + ", ";
			}

			// to write result in excel
			ExcelReader.writeTestCaseData(testData, testCase, testCaseName);
		}
		catch (WebDriverException ex)
		{
			logger.error("Webdriver exception has occurred : " + ex, ex);
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				// to add testResult
				if (testCase.isResultOfTC())
				{
					result = IConstants.PASS;
				}
				else
				{
					result = IConstants.FAIL;
				}
				addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());

				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	public static void startTestCase(WebDriver driver, TestCase testCase)
	{
		try
		{
			MDC.put("TestCaseName", testCase.getTestMethodName());
			String nodeAddress = "LOCAL";
			if (testCase.getNodeAddress() != null)
			{
				nodeAddress = testCase.getNodeAddress();
			}
			logger.info("\n \n ******************************************  AUTOMATION TESTCASE =>> " + testCase.getTestMethodName().toUpperCase()
				+ "  ******************************************" + "\n \t \t \t \t USING BROWSER : " + testCase.getBrowser() + ":" + testCase.getVersion() + " || NODE ADDRESS : "
				+ nodeAddress + "\n \t \t \t \t DESCRIPTION OF TESTCASE : " + testCase.getDescription() + "\n  \t \t \t \t JIRA IDs : " + testCase.getJiraId()
				+ "\n ******************************************************************************************************************************************" + "\n \n");
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.writeInfoOnUI(driver, testCase, null);
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred in startTestCase method : " + e, e);
		}
	}

	public static void startTestCase(WebDriver driver, TestCase testCase, List<MappedTestCase> mappedTestCases)
	{
		try
		{
			MDC.put("TestCaseName", testCase.getTestMethodName());
			String nodeAddress = "LOCAL";
			if (testCase.getNodeAddress() != null)
			{
				nodeAddress = testCase.getNodeAddress();
			}
			logger.info("\n \n ******************************************  AUTOMATION TESTCASE =>> " + testCase.getTestMethodName().toUpperCase()
				+ "  ******************************************" + "\n \t \t \t \t USING BROWSER : " + testCase.getBrowser() + ":" + testCase.getVersion() + " || NODE ADDRESS : "
				+ nodeAddress + "\n \t \t \t \t DESCRIPTION OF TESTCASE : " + testCase.getDescription() + "\n  \t \t \t \t JIRA IDs : " + testCase.getJiraId()
				+ "\n ******************************************************************************************************************************************" + "\n \n");

			DisplayConsoleData.printMappedTestCaseDataOnConsole(testCase, mappedTestCases);
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.writeInfoOnUI(driver, testCase, mappedTestCases);
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred in startTestCase method : " + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get test data combination from excel
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static String getTestData(String key) throws Exception
	{
		String getValue = null;
		try
		{
			getValue = ExcelReader.getTestDataCombo(key);
		}
		catch (Exception e)
		{
			logger.error("NO TESTDATA FOUND");
			throw e;
		}
		return getValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get test data combination from excel
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static String getTestData(String key, int index) throws Exception
	{
		String getValue = null;
		try
		{
			getValue = ExcelReader.getTestDataCombo(key, index);
		}
		catch (Exception e)
		{
			logger.error("NO TESTDATA FOUND");
			throw e;
		}
		return getValue;
	}

	/**
	 * added data in testData map
	 * 
	 * @param testCase
	 * @param key
	 * @param value
	 * @throws Exception
	 */

	public static void addTestData(TestCase testCase, String key, String value)
	{
		// testCase.setMergedMap(key, value);
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, Map<String, String> map, User user, List<MappedTestCase> mappedTestCases)
		throws  Exception
	{
		String testCaseName = testCase.getTestMethodName();
		try
		{
			String result = null;
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);

			printBlankPageErrorMsg(driver, testCaseName);

			// to add testResult
			if (testCase.isResultOfTC())
			{
				result = IConstants.PASS;
			}
			else
			{
				result = IConstants.FAIL;
			}
			addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

			/** To write the result in excel **/
			for (MappedTestCase mappedTestCase : mappedTestCases)
			{
				// ExcelDatabaseReader.insertResult(testCase, null, null, true,
				// null);
				if (mappedTestCase.isTestSkipped())
				{
					result = IConstants.SKIPPED;
				}
				else
				{
					if (mappedTestCase.isTestResult())
					{
						result = IConstants.PASS;
					}
					else
					{
						result = IConstants.FAIL;
					}
				}

				addResultInTestSuite(testCase, result, mappedTestCase.getTestCaseName(), mappedTestCase.getDescription(), mappedTestCase.getError(), mappedTestCase.getJiraId(),
					true);

				ExcelReader.writeResult(result, testCase, mappedTestCase.getTestCaseName(), mappedTestCase.getDescription(), mappedTestCase.getError(),
					mappedTestCase.getAssertionError());

				/** To create testresult for testopia **/
				TestopiaData testopiaData = new TestopiaData();
				testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
				testopiaData.setTcName(mappedTestCase.getTestCaseName());
				testopiaData.setTcSummary(mappedTestCase.getDescription());
				testopiaData.setTcResult(mappedTestCase.isTestResult());

				LinkedList<TestopiaData> tempdata = null;
				if (GenerateResults.testopiaDataList.containsKey(testCase.getBrowserVersionID()))
				{
					tempdata = GenerateResults.testopiaDataList.get(testCase.getBrowserVersionID());
					tempdata.add(testopiaData);
				}
				else
				{
					tempdata = new LinkedList<TestopiaData>();
					tempdata.add(testopiaData);
				}
				GenerateResults.testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
				GenerateResults.setResultOfMappedTcs(driver, testCase, mappedTestCase);
			}

			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");
			LoginLogoutServices.logout(driver, testCase, user);
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());
				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, LinkedHashMap<String, String> map, User user) throws  Exception
	{
		String testCaseName = testCase.getTestMethodName(), result;
		try
		{
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");

			printBlankPageErrorMsg(driver, testCaseName);

			LoginLogoutServices.logout(driver, testCase, user);
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}

			String testData = "";
			// to write the testdata in excel
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				testData = testData + entry.getKey() + "=" + entry.getValue() + ", ";
			}

			ExcelReader.writeTestCaseData(testData, testCase, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				// to add testResult
				if (testCase.isResultOfTC())
				{
					result = IConstants.PASS;
				}
				else
				{
					result = IConstants.FAIL;
				}
				addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());
				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To set the result of mapped testcases <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param flag </font><b><br>
	 * @param mappedTestCase </font><b><br>
	 * @param error </font><b><br>
	 * @return </b> <br>
	 */
	public static MappedTestCase setMappedTestCaseResult(boolean flag, MappedTestCase mappedTestCase, String error)
	{
		try
		{
			mappedTestCase.setTestResult(flag);
			Assert.assertTrue(error, flag);
		}
		catch (AssertionError e)
		{
			mappedTestCase.setError(error);
			mappedTestCase.setAssertionError(e);
			logger.error("Error in Mapped TestCases : " + mappedTestCase.getTestCaseName() + " :->" + e, e);
		}
		return mappedTestCase;
	}

	public static void successfulExecution(WebDriver driver, TestCase testCase)
	{
		String testCaseName = testCase.getTestMethodName();
		try
		{
			logger.info("\n\n ************************* Testcase " + testCaseName + " Executed Successfully *************************** \n \n");

			ScreenShot.screenshot(driver, testCaseName, "Successful_Execution_Of_TestCase".toUpperCase() + testCaseName);

			testCase.setResultOfTC(true);
		}
		catch (Exception e)
		{
			logger.error("Error in Successful Execution Of TestCases" + e, e);
		}
	}

	public static void assertionOccurred(WebDriver driver, TestCase testCase, User user, AssertionError e) throws GenerateResultsException
	{
		String testCaseName = testCase.getTestMethodName();
		ScreenShot.exceptionScreenshot(driver, testCaseName, "Assertion Occurced");
		logger.error("\n\n************************* Testcase => " + testCaseName + " Execution failed *************************** ");
		logger.error("Error in Assertion Method" + e, e);

		testCase.setResultOfTC(false);
		Assert.fail("Assertion Failure occcured in Method in : " + testCaseName + e);
	}

	public static void exceptionOccurred(WebDriver driver, TestCase testCase, User user, Exception e) throws GenerateResultsException
	{
		String testCaseName = testCase.getTestMethodName();
		ScreenShot.exceptionScreenshot(driver, testCaseName, "Error Occurced");
		logger.error("\n \n************************* Testcase => " + testCaseName + " Execution failed *************************** ");
		logger.error("Error in Exception Method" + e, e);

		testCase.setResultOfTC(false);
		Assert.fail("Assertion Failure occcured in Method in : " + testCaseName);
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, User user) throws  Exception
	{
		String testCaseName = testCase.getTestMethodName();
		try
		{
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");

			printBlankPageErrorMsg(driver, testCaseName);

			LoginLogoutServices.logout(driver, testCase, user);
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());

				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, Map<String, String> map, User user, LinkedList<EmailDetails> emailResultDetails)
		throws  Exception
	{
		String testCaseName = testCase.getTestMethodName(), result;
		try
		{
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");
			printBlankPageErrorMsg(driver, testCaseName);
			LoginLogoutServices.logout(driver, testCase, user);
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}

			String testData = "";
			// to write the testdata in excel
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				testData = testData + entry.getKey() + "=" + entry.getValue() + ", ";
			}

			ExcelReader.writeTestCaseData(testData, testCase, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				// to add testResult
				if (testCase.isResultOfTC())
				{
					result = IConstants.PASS;
				}
				else
				{
					result = IConstants.FAIL;
				}
				addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

				CreateEmailReport.emailResultMap.put(testCase.getTestMethodName(), emailResultDetails);
				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());

				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Print blank page error msg <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void printBlankPageErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			String title = driver.getTitle();
			String url = driver.getCurrentUrl();
			logger.info("############### Title : " + title + " ####################");
			logger.info("############### URL : " + url + " ####################");
			if (title.equalsIgnoreCase("Zycus Procure-to-Pay"))
			{
				if (!ActionBot.isElementPresent(driver, MainPageHeaderLevelTab.REQUISITION))
				{
					logger.info("############### BLANK PAGE ####################");
					ScreenShot.screenshot(driver, testCaseName, "Blank Page Screenshot");
				}
			}
			else
			{
				if (!ActionBot.isElementPresent(driver, MainPageHeaderLevelTab.REQUISITION))
				{
					logger.info("############### BLANK PAGE ####################");
					ScreenShot.screenshot(driver, testCaseName, "Blank Page Screenshot");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred in printBlankPageErrorMsg method : " + e, e);
		}

	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, Map<String, String> map, User user, String productName)
		throws Exception
	{
		String testCaseName = testCase.getTestMethodName(), result;
		try
		{
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");

			printBlankPageErrorMsg(driver, testCaseName);

			if (productName.equalsIgnoreCase(IConstants.product_name_iSource))
			{

			}
			else if (productName.equalsIgnoreCase(IConstants.product_name_iContract))
			{

			}
			else
			{
				LoginLogoutServices.logout(driver, testCase, user);
			}
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}

			String testData = "";
			// to write the testdata in excel
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				testData = testData + entry.getKey() + "=" + entry.getValue() + ", ";
			}

			ExcelReader.writeTestCaseData(testData, testCase, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				// to add testResult
				if (testCase.isResultOfTC())
				{
					result = IConstants.PASS;
				}
				else
				{
					result = IConstants.FAIL;
				}
				addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());

				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	public static void afterExecutionOfTestcase(WebDriver driver, TestCase testCase, Map<String, String> map, User user, List<MappedTestCase> mappedTestCases, String productName)
		throws  Exception
	{
		String testCaseName = testCase.getTestMethodName();
		try
		{
			String result = null;
			logger.info("TESTING COMPLETE TestCase : " + testCaseName);

			printBlankPageErrorMsg(driver, testCaseName);

			// to add testResult
			if (testCase.isResultOfTC())
			{
				result = IConstants.PASS;
			}
			else
			{
				result = IConstants.FAIL;
			}
			addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), null, testCase.getJiraId(), false);

			/** To write the result in excel **/
			for (MappedTestCase mappedTestCase : mappedTestCases)
			{
				// ExcelDatabaseReader.insertResult(testCase, null, null, true,
				// null);
				if (mappedTestCase.isTestSkipped())
				{
					result = "SKIPPED";
				}
				else
				{
					if (mappedTestCase.isTestResult())
					{
						result = "PASS";
					}
					else
					{
						result = "FAIL";
					}
				}
				ExcelReader.writeResult(result, testCase, mappedTestCase.getTestCaseName(), mappedTestCase.getDescription(), mappedTestCase.getError(),
					mappedTestCase.getAssertionError());

				addResultInTestSuite(testCase, result, testCaseName, testCase.getDescription(), mappedTestCase.getError(), testCase.getJiraId(), true);//Kunal

				/** To create testresult for testopia **/
				TestopiaData testopiaData = new TestopiaData();
				testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
				testopiaData.setTcName(mappedTestCase.getTestCaseName());
				testopiaData.setTcSummary(mappedTestCase.getDescription());
				testopiaData.setTcResult(mappedTestCase.isTestResult());

				LinkedList<TestopiaData> tempdata = null;
				if (GenerateResults.testopiaDataList.containsKey(testCase.getBrowserVersionID()))
				{
					tempdata = GenerateResults.testopiaDataList.get(testCase.getBrowserVersionID());
					tempdata.add(testopiaData);
				}
				else
				{
					tempdata = new LinkedList<TestopiaData>();
					tempdata.add(testopiaData);
				}
				GenerateResults.testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
				GenerateResults.setResultOfMappedTcs(driver, testCase, mappedTestCase);
			}

			ScreenShot.screenshot(driver, testCaseName, "Before_Logging_Out");
			if (productName.equalsIgnoreCase(IConstants.product_name_iSource))
			{

			}
			else if (productName.equalsIgnoreCase(IConstants.product_name_iContract))
			{

			}
			else
			{
				LoginLogoutServices.logout(driver, testCase, user);
			}
			if (ConfigProperty.getConfig("demo").equalsIgnoreCase("yes"))
			{
				DisplayConsoleData.displayDataOnUI(driver, testCase, map);
			}
		}
		catch (Exception e)
		{
			logger.error("Logout Failed in utility=>" + e, e);
		}
		finally
		{
			try
			{
				Logout logout = new Logout();
				logout.afterLogout(driver, testCase, user);
				if (ActionBot.driverStatus(driver, testCase.getTestMethodName()))
				{
					driver.manage().deleteAllCookies();
					driver.quit();
					// driver.close();
				}
				ScreenShot.moveTestCase(testCase, testCase.isResultOfTC());
				GenerateResults.displayResults(testCase);
				MDC.remove("TestCaseName");
			}
			catch (Exception e)
			{
				logger.error("Error in afterExecutionOfTestCases method =>");
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Print Application Error Message <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </b> <br>
	 * 
	 * @throws WebDriverException,
	 *         Exception
	 */
	public static String printErrorMessage(WebDriver driver, String testCaseName, AssertionError e, Exception ex) throws WebDriverException, Exception
	{
		String currentURL = null, errorMsg = "";
		String formatedDate = "";
		try
		{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm:ss a zzz");
			formatedDate = dateFormat.format(date);
			logger.error("\n\n************************* Testcase => " + testCaseName + " Execution failed *************************** ");

			if (ActionBot.driverStatus(driver, testCaseName))
			{
				currentURL = driver.getCurrentUrl();
			}
			else
			{
				currentURL = "";
				errorMsg = "============ WebDriver is Not Avaliable To Proceed!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			if (currentURL.contains("/error_500"))
			{
				errorMsg = "============ Server Error Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else if (currentURL.contains("/error_404"))
			{
				errorMsg = "============ Error 404 Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else if (currentURL.contains("/error_not_found"))
			{
				errorMsg = "============ Error Not Found Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else if (currentURL.contains("/error_nodefault"))
			{
				errorMsg = "============ Error Node Default Has Occurred : Account configuration pending!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else if (currentURL.contains("/error_403"))
			{
				errorMsg = "============ Error Access Denied Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[text()='504 Gateway Time-out']")))
			{
				errorMsg = "============ Gateway Time-out Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}
			else
			{
				errorMsg = "============ Selenium/Java error Has Occurred!!! [" + formatedDate + "]============ \n\n";
				logger.error(errorMsg);
			}

			if (e != null)
			{
				logger.error("Error in Assertion Method" + e, e);
			}
			if (ex != null)
			{
				if (ex.getStackTrace().toString().contains("Error forwarding the new session"))
				{
					logger.error("============ Selenium Grid was not proper : Node was not available for given configuration [" + formatedDate + "]============ \n\n");
					errorMsg = "============ Selenium Grid was not proper : Node was not available for given configuration [" + formatedDate + "]============ \n\n";
				}
				logger.error("Error in Exception Method" + ex, ex);
			}
		}
		catch (WebDriverException exx)
		{
			errorMsg = "WEBDRIVER IS NOT AVALIABLE TO PROCEED [" + formatedDate + "]";
			throw new WebDriverException(errorMsg, exx);
		}
		catch (Exception exx)
		{
			throw new Exception("Exception occurred in printErrorMessage method : ", exx);
		}
		return errorMsg;
	}

	public synchronized static void addResultInTestSuite(TestCase testCase, String result, String testName, String desc, String error, String jiraID, boolean isMappedTestCase)
	{
		TestSuiteResult testSuiteResult = null;
		boolean suiteResultExist = false;
		try
		{
			// to add result in finalResultSet
			addResultInFinalResultSet(testCase, result, testName, desc, error, jiraID, isMappedTestCase);

			if (Startup.result == null)
			{
				Startup.result = new ArrayList<>();
			}
			// check if result is empty
			if (Startup.result.size() != 0)
			{
				// check for existing suite result
				for (TestSuiteResult suiteResult : Startup.result)
				{
					if (suiteResult.getBrowserVersion().equalsIgnoreCase(testCase.getBrowserVersionID()))
					{
						suiteResultExist = true;
						testSuiteResult = suiteResult;
						break;
					}
					else
					{
						suiteResultExist = false;
					}
				}

				if (!suiteResultExist)
				{
					testSuiteResult = new TestSuiteResult();
					testSuiteResult.setBrowserVersion(testCase.getBrowserVersionID());
				}
			}
			else
			{
				testSuiteResult = new TestSuiteResult();
				testSuiteResult.setBrowserVersion(testCase.getBrowserVersionID());
			}

			List<TestCaseResult> testCaseResults = null;
			// get list of test case results from suite result
			if (result.equalsIgnoreCase(IConstants.PASS))
			{
				testCaseResults = testSuiteResult.getPassedTests();
			}
			else if (result.equalsIgnoreCase(IConstants.FAIL))
			{
				testCaseResults = testSuiteResult.getFailedTests();
			}
			else if (result.equalsIgnoreCase(IConstants.SKIPPED))
			{
				testCaseResults = testSuiteResult.getSkippedTests();
			}

			// add testCaseResult in testCaseResults list
			TestCaseResult caseResultRemove = null;
			if (testCaseResults != null)
			{
				if (testCaseResults.size() != 0)
				{
					// check if testcaseresult present in list : if so delete it
					// from list
					for (TestCaseResult caseResult : testCaseResults)
					{
						logger.info("Case Result: "+caseResult);
						logger.info("TestMethodName: "+caseResult.getTestMethodName());
						logger.info("TestName: "+testName);
						
						if(caseResult.getTestMethodName()!=null)
						{
							if (caseResult.getTestMethodName().equalsIgnoreCase(testName))
							{
								caseResultRemove = caseResult;
								break;
							}
						}						
					}
					if (caseResultRemove != null)
					{
						testCaseResults.remove(caseResultRemove);
					}
				}
			}
			else
			{
				testCaseResults = new ArrayList<>();
			}

			TestCaseResult testCaseResult = new TestCaseResult();
			testCaseResult.setTestMethodName(testName);
			testCaseResult.setTestDescription(desc);
			testCaseResult.setTestStatus(result);

			// if mapped testcase and set exception message
			if (isMappedTestCase)
			{
				testCaseResult.setMappedWith(testCase.getTestMethodName());
				if (error != null)
				{
					testCaseResult.setExceptionMessage(error);
				}
			}
			else
			{
				if (testCase.getExceptionMessage() != null)
				{
					testCaseResult.setExceptionMessage(testCase.getExceptionMessage());
				}
			}

			testCaseResults.add(testCaseResult);
			// to set testCaseResults in proper list

			if (result.equalsIgnoreCase(IConstants.PASS))
			{
				testSuiteResult.setPassedTests(testCaseResults);
				testSuiteResult.setPassed(testSuiteResult.getPassed() + 1);
			}
			else if (result.equalsIgnoreCase(IConstants.FAIL))
			{
				testSuiteResult.setFailedTests(testCaseResults);
				testSuiteResult.setFailed(testSuiteResult.getFailed() + 1);
			}
			else if (result.equalsIgnoreCase(IConstants.SKIPPED))
			{
				testSuiteResult.setSkippedTests(testCaseResults);
				testSuiteResult.setSkipped(testSuiteResult.getSkipped() + 1);
			}
			// set total
			testSuiteResult.setTotal(testSuiteResult.getTotal() + 1);
			if (!suiteResultExist)
			{
				Startup.result.add(testSuiteResult);
			}
		}
		catch (Exception e)
		{
			logger.error("\n Exception occurred while adding test result in test suite : " + e, e);
		}
	}

	public static void addResultInFinalResultSet(TestCase testCase, String testResult, String testName, String desc, String error, String jiraID, boolean isMappedTestCase)
	{
		try
		{
			TestResults result = new TestResults();
			String tc = testName, status = "";
			boolean result1 = false;
			String browserVersionID = testCase.getBrowserVersionID();
			result.setTestCaseName(testName);			
			result.setSummary(desc);
			result.setNodeAddress(testCase.getNodeAddress());
			result.setIsSanityTC(testCase.isSanityTC());
			result.setModuleName(testCase.getModuleName());
			if (testResult.equalsIgnoreCase(IConstants.PASS))
			{
				result.setResultOfTC(true);
				result.setStatus("EXECUTED");
				result1 = true;
				status = "EXECUTED";
			}
			else if (testResult.equalsIgnoreCase(IConstants.FAIL))
			{
				result.setResultOfTC(false);
				result.setStatus("EXECUTED");
				result1 = false;
				status = "EXECUTED";
			}
			else if (testResult.equalsIgnoreCase(IConstants.SKIPPED))
			{
				result.setResultOfTC(false);
				result.setStatus("SKIPPED");
				result1 = false;
				status = "SKIPPED";
			}
			// if mapped testcase and set exception message
			if (isMappedTestCase)
			{
				result.setParentTC(testCase.getTestMethodName());
				result.setJiraId(jiraID);
				if (error != null)
				{
					result.setException(error);
				}
			}
			else
			{
				result.setParentTC("N/A");
				result.setJiraId(jiraID);
				if (testCase.getExceptionMessage() != null)
				{
					result.setException(testCase.getExceptionMessage());
				}
			}
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			//result.setJiraId(testCase.getJiraId());
			LinkedList<TestResults> listTestResult = null;
			Map<String, TestResults> tempMap = null;
			if (finalResultSet.containsKey(tc))
			{
				tempMap = finalResultSet.get(tc);
				tempMap.put(browserVersionID, result);
			}
			else
			{
				tempMap = new LinkedHashMap<String, TestResults>();
				tempMap.put(browserVersionID, result);
			}
			if (testCaseResult.get(browserVersionID) != null)
			{
				listTestResult = testCaseResult.get(browserVersionID);
			}
			else
			{
				listTestResult = new LinkedList<>();
			}
			listTestResult.add(result);
			testCaseResult.put(browserVersionID, listTestResult);

			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.setTestMethodName(testCase.getTestMethodName());
			}
			finalResultSet.put(tc, tempMap);
			logger.info("Final Result Set: "+finalResultSet);

			// to set tcsCountMap
			toAddDataToTcsCounterMap(status, result1, browserVersionID);
		}
		catch (Exception e)
		{
			logger.error("\n Exception occurred while adding test result in finalResultSet : " + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add data to tcsCounterMap <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testResult </font><b><br>
	 * @param browserVersionID </b> <br>
	 */
	public static void toAddDataToTcsCounterMap(String status, boolean testResult, String browserVersionID)
	{
		if (testResult)
		{
			if (SanityReport1.tcsCountMap.get(browserVersionID) != null)
			{
				int cnt = SanityReport1.tcsCountMap.get(browserVersionID).get("passedTcsCounter");
				cnt = cnt + 1;
				SanityReport1.tcsCountMap.get(browserVersionID).put("passedTcsCounter", cnt);
			}
			else
			{
				Map<String, Integer> counterMap = new HashMap<>();
				counterMap.put("passedTcsCounter", 1);
				counterMap.put("failedTcsCounter", 0);
				counterMap.put("skippedTcsCounter", 0);
				SanityReport1.tcsCountMap.put(browserVersionID, counterMap);
			}
		}
		else
		{
			if (SanityReport1.tcsCountMap.get(browserVersionID) != null)
			{
				if (status.equalsIgnoreCase("SKIPPED"))
				{
					int cnt = SanityReport1.tcsCountMap.get(browserVersionID).get("skippedTcsCounter");
					cnt = cnt + 1;
					SanityReport1.tcsCountMap.get(browserVersionID).put("skippedTcsCounter", cnt);
				}
				else
				{
					int cnt = SanityReport1.tcsCountMap.get(browserVersionID).get("failedTcsCounter");
					cnt = cnt + 1;
					SanityReport1.tcsCountMap.get(browserVersionID).put("failedTcsCounter", cnt);
				}
			}
			else
			{
				Map<String, Integer> counterMap = new HashMap<>();
				counterMap.put("passedTcsCounter", 0);
				if (status.equalsIgnoreCase("SKIPPED"))
				{
					counterMap.put("skippedTcsCounter", 1);
					counterMap.put("failedTcsCounter", 0);
				}
				else
				{
					counterMap.put("failedTcsCounter", 1);
					counterMap.put("skippedTcsCounter", 0);
				}
				SanityReport1.tcsCountMap.put(browserVersionID, counterMap);
			}
		}
	}
}
