package com.zycus.automation.testresult;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.exception.GenerateResultsException;
import com.zycus.automation.integration.testopia.TestopiaData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.reports.SanityReport;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;

/**
 * 
 * @author puneet.sharma
 *
 */
public class GenerateResults implements FrameworkConstants
{
	static Logger													logger				= Logger.getLogger(GenerateResults.class);

	public static Map<String, LinkedList<TestResults>>				testCaseResult		= new LinkedHashMap<String, LinkedList<TestResults>>();
	public static Map<String, Map<String, LinkedList<TestResults>>>	finalResultSet		= new LinkedHashMap<String, Map<String, LinkedList<TestResults>>>();
	public static Map<String, LinkedList<TestopiaData>>				testopiaDataList	= new LinkedHashMap<String, LinkedList<TestopiaData>>();

	public static void setResult(WebDriver driver, TestCase testCase, boolean testResult) throws GenerateResultsException
	{
		try
		{
			// TestResults For Testopia
			/*
			 * if (!PreRequisite.getPreRequisiteMethods().contains(testCase.
			 * getTestMethodName())) {
			 */
			TestopiaData testopiaData = new TestopiaData();
			testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
			testopiaData.setTcName(testCase.getTestMethodName());
			testopiaData.setTcSummary(testCase.getDescription());
			testopiaData.setTcResult(testResult);
			// testopiaDataList.add(testopiaData);
			LinkedList<TestopiaData> tempdata = null;
			if (testopiaDataList.containsKey(testCase.getBrowserVersionID()))
			{
				tempdata = testopiaDataList.get(testCase.getBrowserVersionID());
				tempdata.add(testopiaData);
			}
			else
			{
				tempdata = new LinkedList<TestopiaData>();
				tempdata.add(testopiaData);
			}
			testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
			/*
			 * } else { logger.info("It is a Pre Requisite Method"
			 * .toUpperCase()); }
			 */
			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.getTestMethodName();
			}
			// testResult For Reporting
			TestResults result = new TestResults();
			String regTCName = testCase.getTestMethodName();
			String TC = testCase.getTestMethodName();
			/*
			 * if (testCase.isPrerequisiteMethod()) {
			 * result.isPrerequisiteMethod(true); } else {
			 * result.isPrerequisiteMethod(false); }
			 */
			String browserVersionID = testCase.getBrowserVersionID();
			result.setNodeAddress(testCase.getNodeAddress());
			result.setTestCaseName(regTCName);
			result.setSummary(testCase.getDescription());
			result.setIsSanityTC(testCase.isSanityTC());
			result.setStatus("EXECUTED");
			result.setParentTC(getMappingID(testCase));
			result.setResultOfTC(testResult);
			result.setModuleName(testCase.getModuleName());
			result.setTestData(testCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);
				if (tempMap.containsKey(browserVersionID))
				{
					regTC = tempMap.get(browserVersionID);
				}
				else
				{
					regTC = new LinkedList<TestResults>();
				}
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{
				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}

			ScreenShot.screenshot(driver, testCase.getTestMethodName(), testCase.getTestMethodName());
			finalResultSet.put(TC, tempMap);

			// to set tcsCountMap
			toAddDataToTcsCounterMap("EXECUTED", testResult, browserVersionID);

		}
		catch (Exception e)
		{
			logger.error("GenerateResultsException Occured");
			throw new GenerateResultsException("TestCase Result Exception Generated", e);
		}
		// displayResults(testCase);
	}

	public static void setResult(WebDriver driver, TestCase testCase, boolean testResult, Exception e) throws GenerateResultsException
	{
		try
		{

			// TestResults For Testopia
			/*
			 * if (!PreRequisite.getPreRequisiteMethods().contains(testCase.
			 * getTestMethodName())) {
			 */TestopiaData testopiaData = new TestopiaData();
			testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
			testopiaData.setTcName(testCase.getTestMethodName());
			testopiaData.setTcSummary(testCase.getDescription());
			testopiaData.setTcResult(testResult);
			// testopiaDataList.add(testopiaData);
			LinkedList<TestopiaData> tempdata = null;
			if (testopiaDataList.containsKey(testCase.getBrowserVersionID()))
			{
				tempdata = testopiaDataList.get(testCase.getBrowserVersionID());
				tempdata.add(testopiaData);
			}
			else
			{
				tempdata = new LinkedList<TestopiaData>();
				tempdata.add(testopiaData);
			}
			testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
			/*
			 * } else { logger.info("It is a Pre Requisite Method"); }
			 */// TestResult For Reporting
			TestResults result = new TestResults();
			String regTCName = testCase.getTestMethodName();
			String TC = testCase.getTestMethodName();
			/*
			 * if (testCase.isPrerequisiteMethod()) {
			 * result.isPrerequisiteMethod(true); } else {
			 * result.isPrerequisiteMethod(false); }
			 */String browserVersionID = testCase.getBrowserVersionID();
			result.setTestCaseName(regTCName);
			result.setSummary(testCase.getDescription());
			result.setNodeAddress(testCase.getNodeAddress());
			result.setIsSanityTC(testCase.isSanityTC());
			result.setModuleName(testCase.getModuleName());
			result.setParentTC(getMappingID(testCase));
			result.setResultOfTC(testResult);
			result.setStatus("EXECUTED");
			result.setTestData(testCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			result.setException(e.toString());
			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);

				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{
				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.setTestMethodName(testCase.getTestMethodName());
			}
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Screenshot");
			finalResultSet.put(TC, tempMap);
			String Exception = "!!!!!!!Exception : ".toUpperCase();
			if (testCase.getTestData().containsKey(Exception))
			{
				logger.info("Removing Exception Of Previous Failure".toUpperCase());
				testCase.getTestData().remove(Exception);
			}

			// to set tcsCountMap
			toAddDataToTcsCounterMap("EXECUTED", testResult, browserVersionID);

			CommonServices.addTestData(testCase, Exception, e.toString());
		}
		catch (Exception a)
		{
			logger.error("GenerateResultsException Occured");
			throw new GenerateResultsException("TestCase Result Exception Generated", e);
		}

		// displayResults(testCase);
	}

	public static void setResult(WebDriver driver, TestCase testCase, boolean testResult, SkipException e) throws GenerateResultsException
	{
		try
		{

			// TestResults For Testopia
			/*
			 * if (!PreRequisite.getPreRequisiteMethods().contains(testCase.
			 * getTestMethodName())) {
			 */
			TestopiaData testopiaData = new TestopiaData();
			testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
			testopiaData.setTcName(testCase.getTestMethodName());
			testopiaData.setTcSummary(testCase.getDescription());
			testopiaData.setTcResult(testResult);
			// testopiaDataList.add(testopiaData);
			LinkedList<TestopiaData> tempdata = null;
			if (testopiaDataList.containsKey(testCase.getBrowserVersionID()))
			{
				tempdata = testopiaDataList.get(testCase.getBrowserVersionID());
				tempdata.add(testopiaData);
			}
			else
			{
				tempdata = new LinkedList<TestopiaData>();
				tempdata.add(testopiaData);
			}
			testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
			/*
			 * } else { logger.info("It is a Pre Requisite Method"); }
			 */// TestResult For Reporting
			TestResults result = new TestResults();
			String regTCName = testCase.getTestMethodName();
			String TC = testCase.getTestMethodName();
			/*
			 * if (testCase.isPrerequisiteMethod()) {
			 * result.isPrerequisiteMethod(true); } else {
			 * result.isPrerequisiteMethod(false); }
			 */
			String browserVersionID = testCase.getBrowserVersionID();
			result.setTestCaseName(regTCName);
			result.setSummary(testCase.getDescription());
			result.setIsSanityTC(testCase.isSanityTC());
			result.setModuleName(testCase.getModuleName());
			result.setParentTC(getMappingID(testCase));
			result.setNodeAddress(testCase.getNodeAddress());
			result.setResultOfTC(testResult);
			result.setStatus("EXECUTED");
			// result.setLinkToScreenShot(testCase.getLinkToScreenShot());
			result.setTestData(testCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			result.setSkipException(e.toString());
			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{
				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.setTestMethodName(testCase.getTestMethodName());
			}
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), testCase.getTestMethodName());
			finalResultSet.put(TC, tempMap);

			String Exception = "!!!!!!!Exception : SKIP ".toUpperCase();
			if (testCase.getTestData().containsKey(Exception))
			{
				logger.info("Removing Exception Of Previous Failure".toUpperCase());
				testCase.getTestData().remove(Exception);
			}

			CommonServices.addTestData(testCase, Exception, e.toString());
		}
		catch (Exception a)
		{
			logger.error("GenerateResultsException Occured");
			throw new GenerateResultsException("TestCase Result Exception Generated", e);
		}
		// displayResults(testCase);
	}

	public static void setResult(WebDriver driver, TestCase testCase, boolean testResult, AssertionError e) throws GenerateResultsException
	{
		try
		{

			// TestResults For Testopia
			/*
			 * if (!PreRequisite.getPreRequisiteMethods().contains(testCase.
			 * getTestMethodName())) {
			 */
			TestopiaData testopiaData = new TestopiaData();
			testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
			testopiaData.setTcName(testCase.getTestMethodName());
			testopiaData.setTcSummary(testCase.getDescription());
			testopiaData.setTcResult(testResult);
			// testopiaDataList.add(testopiaData);
			LinkedList<TestopiaData> tempdata = null;
			if (testopiaDataList.containsKey(testCase.getBrowserVersionID()))
			{
				tempdata = testopiaDataList.get(testCase.getBrowserVersionID());
				tempdata.add(testopiaData);
			}
			else
			{
				tempdata = new LinkedList<TestopiaData>();
				tempdata.add(testopiaData);
			}
			testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
			/*
			 * } else { logger.info("It is a Pre Requisite Method"); }
			 */
			// TestResult For Reporting
			TestResults result = new TestResults();
			String regTCName = testCase.getTestMethodName();
			String TC = testCase.getTestMethodName();
			/*
			 * if (testCase.isPrerequisiteMethod()) {
			 * result.isPrerequisiteMethod(true); } else {
			 * result.isPrerequisiteMethod(false); }
			 */String browserVersionID = testCase.getBrowserVersionID();
			result.setTestCaseName(regTCName);
			result.setSummary(testCase.getDescription());
			result.setIsSanityTC(testCase.isSanityTC());
			result.setModuleName(testCase.getModuleName());
			// result.setLinkToScreenShot(testCase.getLinkToScreenShot());
			result.setNodeAddress(testCase.getNodeAddress());
			result.setParentTC(getMappingID(testCase));
			result.setResultOfTC(testResult);
			result.setStatus("EXECUTED");
			result.setTestData(testCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			result.setAssertError(e.toString());
			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);
				if (tempMap.containsKey(browserVersionID))
				{
					regTC = tempMap.get(browserVersionID);
				}
				else
				{
					regTC = new LinkedList<TestResults>();
				}
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{

				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.setTestMethodName(testCase.getTestMethodName());
			}
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), testCase.getTestMethodName());
			finalResultSet.put(TC, tempMap);

			String Exception = "!!!!!!!Exception : Assertion ".toUpperCase();
			if (testCase.getTestData().containsKey(Exception))
			{
				logger.info("Removing Exception Of Previous Failure".toUpperCase());
				testCase.getTestData().remove(Exception);
			}

			// to set tcsCountMap
			toAddDataToTcsCounterMap("EXECUTED", testResult, browserVersionID);

			CommonServices.addTestData(testCase, Exception, e.toString());
		}
		catch (Exception a)
		{
			logger.error("GenerateResultsException Occured " + e, e);
			throw new GenerateResultsException("TestCase Result Exception Generated", e);
		}
		// displayResults(testCase);
	}

	public static void displayResults(TestCase testCase) throws GenerateResultsException
	{
		String log1 = null, log2 = null, log3 = null;

		log1 = "\n####################################################\n";
		log1 += "\n|---------------------------------------------------|\n";
		log1 += "|                     TestData                      |";
		log2 = "";
		log3 = "\n";
		try
		{
			/*
			 * if (!PreRequisite.getPreRequisiteMethods().contains(testCase.
			 * getTestMethodName())) {
			 */
			for (TestResults results : finalResultSet.get(testCase.getTestMethodName()).get(testCase.getBrowserVersionID()))
			{
				for (Map.Entry<String, String> testData : results.getTestData().entrySet())
				{
					log3 += testData.getKey() + " : " + testData.getValue() + "\n";
				}
				log1 += "\n|---------------------------------------------------|\n";
				String result = null;
				if (results.getResultOfTC())
				{
					result = "PASSED";
				}
				else
				{
					result = "FAILED";
				}
				log2 += log1 + "\nTestCase Name : " + results.getTestCaseName() + "\nTestCase Summary : " + results.getSummary() + "\nParent TestCase Mapping ID : "
					+ results.getParentTC() + "\nRunning On Node : " + results.getNodeAddress() + "\nBrowser Version ID : " + results.getBrowserVersionID()
					+ "\nResult OF TestCase : " + result + "\nModule Name OF TestCase : " + results.getModuleName() + log3;
				log2 += "\n####################################################";

			}
			// }

		}
		catch (Exception e)
		{
			logger.error("GenerateResultsException Occured While Displaying Result" + e, e);
			// throw new GenerateResultsException("TestCase Result Exception
			// Generated " + e, e);
		}
		logger.info(log2);
	}

	public static boolean getSanityResult(TestCase testCase)
	{
		boolean resultOfTC = false;
		for (Map.Entry<String, LinkedList<TestResults>> testData : finalResultSet.get(testCase.getTestMethodName()).entrySet())
		{
			for (TestResults results : testData.getValue())
			{
				if (results.getResultOfTC())
				{
					resultOfTC = true;
				}
				else
				{
					resultOfTC = false;
					break;
				}
			}
		}
		return resultOfTC;
	}

	public static String getSanityResult(String testMethod, String browserVersionId)
	{
		String resultOfTC = null;
		for (TestResults results : finalResultSet.get(testMethod).get(browserVersionId))
		{
			if (results.getResultOfTC())
			{
				resultOfTC = "PASS";
			}
			else
			{
				resultOfTC = "FAIL";
				break;
			}
		}
		return resultOfTC;
	}

	public static void resultOfMapTestCase(WebDriver driver, TestCase testCase, String testCaseName, String desc, boolean testResult, String status) throws GenerateResultsException
	{
		try
		{

			// TestResults For Testopia
			if (status.equalsIgnoreCase("SKIPPED"))
			{
				/*
				 * if
				 * (!PreRequisite.getPreRequisiteMethods().contains(testCaseName
				 * .trim())) {
				 */
				TestopiaData testopiaData = new TestopiaData();
				testopiaData.setBrowserVersionID(testCase.getBrowserVersionID());
				testopiaData.setTcName(testCase.getTestMethodName());
				testopiaData.setTcSummary(testCase.getDescription());
				testopiaData.setTcResult(testResult);
				// testopiaDataList.add(testopiaData);
				LinkedList<TestopiaData> tempdata = null;
				if (testopiaDataList.containsKey(testCase.getBrowserVersionID()))
				{
					tempdata = testopiaDataList.get(testCase.getBrowserVersionID());
					tempdata.add(testopiaData);
				}
				else
				{
					tempdata = new LinkedList<TestopiaData>();
					tempdata.add(testopiaData);
				}
				testopiaDataList.put(testCase.getBrowserVersionID(), tempdata);
			}
			else
			{
				logger.info("It is a Pre Requisite Method");
			}
			// }
			// TestResult For Reporting
			TestResults result = new TestResults();
			String regTCName = testCaseName;
			String TC = testCaseName;
			/*
			 * if (testCase.isPrerequisiteMethod()) {
			 * result.isPrerequisiteMethod(true); } else {
			 * result.isPrerequisiteMethod(false); }
			 */
			String browserVersionID = testCase.getBrowserVersionID();
			result.setTestCaseName(regTCName);
			result.setSummary(desc);
			result.setIsSanityTC(testCase.isSanityTC());
			result.setStatus(status);
			result.setModuleName(testCase.getModuleName());
			// result.setLinkToScreenShot(testCase.getLinkToScreenShot());
			result.setNodeAddress(testCase.getNodeAddress());
			// Setting Parrent TestCase Name
			result.setParentTC(testCase.getTestMethodName());
			result.setResultOfTC(testResult);
			result.setTestData(testCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());
			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{
				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			if (testCase.getTestMethodName() == null)
			{
				logger.info("TestMethodName Set To Null");
				testCase.setTestMethodName(testCase.getTestMethodName());
			}
			ScreenShot.screenshot(driver, testCase.getDescription(), testCase.getTestMethodName());
			finalResultSet.put(TC, tempMap);

			if (testResult)
			{
				CommonServices.addTestData(testCase, testCaseName, "PASS");
			}
			else
			{
				CommonServices.addTestData(testCase, testCaseName, "FAIL");
			}
		}
		catch (Exception a)
		{
			logger.error("GenerateResultsException Occured");
			throw new GenerateResultsException("TestCase Result Exception Generated", a);
		}
	}

	public static String getMappingID(TestCase testCase)
	{

		if (SUITE_TYPE.equalsIgnoreCase("regression"))
		{
			return "N/A";
		}
		else if (SUITE_TYPE.equalsIgnoreCase("sanity"))
		{
			// return testCase.getTestCaseMappingID();
		}
		else
		{
			// return testCase.getTestCaseMappingID();
		}
		return "N/A";
	}

	@Override
	public String toString()
	{
		return "GenerateResults [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void setResultOfMappedTcs(WebDriver driver, TestCase testCase, MappedTestCase mappedTestCase) throws GenerateResultsException
	{
		try
		{
			// testResult For Reporting
			TestResults result = new TestResults();
			String TC = mappedTestCase.getTestCaseName();

			String browserVersionID = testCase.getBrowserVersionID();
			result.setNodeAddress(testCase.getNodeAddress());
			result.setTestCaseName(mappedTestCase.getTestCaseName());
			result.setSummary(mappedTestCase.getDescription());
			result.setIsSanityTC(testCase.isSanityTC());

			if (mappedTestCase.isTestSkipped())
			{
				result.setStatus("SKIPPED");
				result.setResultOfTC(false);
				// to set tcsCountMap
				toAddDataToTcsCounterMap("SKIPPED", false, browserVersionID);
			}
			else
			{
				result.setStatus("EXECUTED");
				result.setResultOfTC(mappedTestCase.isTestResult());
				// to set tcsCountMap
				toAddDataToTcsCounterMap("EXECUTED", mappedTestCase.isTestResult(), browserVersionID);
			}
			result.setParentTC(testCase.getTestMethodName());
			result.setModuleName(mappedTestCase.getModuleName());
			result.setTestData(mappedTestCase.getTestData());
			result.setBrowserVersionID(testCase.getBrowserVersionID());

			LinkedList<TestResults> regTC = null;
			Map<String, LinkedList<TestResults>> tempMap = null;
			if (finalResultSet.containsKey(TC))
			{
				tempMap = finalResultSet.get(TC);
				if (tempMap.containsKey(browserVersionID))
				{
					regTC = tempMap.get(browserVersionID);
				}
				else
				{
					regTC = new LinkedList<TestResults>();
				}
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}
			else
			{
				tempMap = new LinkedHashMap<String, LinkedList<TestResults>>();
				regTC = new LinkedList<TestResults>();
				regTC.add(result);
				testCaseResult.put(browserVersionID, regTC);
				tempMap.put(browserVersionID, regTC);
			}

			ScreenShot.screenshot(driver, testCase.getDescription(), testCase.getTestMethodName());
			finalResultSet.put(TC, tempMap);
		}
		catch (Exception e)
		{
			logger.error("GenerateResultsException Occured");
			throw new GenerateResultsException("TestCase Result Exception Generated", e);
		}
		// displayResults(testCase);
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
			if (SanityReport.tcsCountMap.get(browserVersionID) != null)
			{
				int cnt = SanityReport.tcsCountMap.get(browserVersionID).get("passedTcsCounter");
				cnt = cnt + 1;
				SanityReport.tcsCountMap.get(browserVersionID).put("passedTcsCounter", cnt);
			}
			else
			{
				Map<String, Integer> counterMap = new HashMap<>();
				counterMap.put("passedTcsCounter", 1);
				counterMap.put("failedTcsCounter", 0);
				counterMap.put("skippedTcsCounter", 0);
				SanityReport.tcsCountMap.put(browserVersionID, counterMap);
			}
		}
		else
		{
			if (SanityReport.tcsCountMap.get(browserVersionID) != null)
			{
				if (status.equalsIgnoreCase("SKIPPED"))
				{
					int cnt = SanityReport.tcsCountMap.get(browserVersionID).get("skippedTcsCounter");
					cnt = cnt + 1;
					SanityReport.tcsCountMap.get(browserVersionID).put("skippedTcsCounter", cnt);
				}
				else
				{
					int cnt = SanityReport.tcsCountMap.get(browserVersionID).get("failedTcsCounter");
					cnt = cnt + 1;
					SanityReport.tcsCountMap.get(browserVersionID).put("failedTcsCounter", cnt);
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
				SanityReport.tcsCountMap.put(browserVersionID, counterMap);
			}
		}
	}
}
