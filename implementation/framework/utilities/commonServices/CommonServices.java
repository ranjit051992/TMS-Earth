
package framework.utilities.commonServices;

import framework.frameworkUtilies.GlobalVariable;
import framework.frameworkUtilies.testResult.ReportingService;
import framework.frameworkUtilies.testResult.TestReportingBO;
import framework.startup.Startup;
import framework.utilities.screenshot.Screenshot;
import eProc.productUtilities.userListing.User;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.*;

public class CommonServices
{
	static Logger		logger			= Logger.getLogger(CommonServices.class);
	static Set<String>	classNameSet	= new TreeSet<String>();

	/**
	 * 
	 * @author nitin.chourey;
	 * @description: afterSuccessfulExecution will mark testcase as passed;
	 * @param: webdriver
	 *             instance, User object;
	 * @return: nil;
	 */

	public static void afterSuccessfulExecution(WebDriver driver, TestReportingBO testCase, User user)
	{
		logger.info("===================================" + testCase.getTestCaseName() + "  Executed successfully===================================");
		Startup.remainingMethods.remove(testCase.getTestCaseName());
		logger.info("Remaining cases : " + Startup.remainingMethods);

	}

	/**
	 * @author nitin.chourey;
	 * @description: afterexecution will logout from application and release the
	 *               user;
	 * @param: webdriver
	 *             instance, User object;
	 * @return: nil;
	 */
	public static synchronized void afterexecution(WebDriver driver, TestReportingBO testcase, User user)
	{
		try
		{
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ReportingService.afterCase();
			Screenshot.moveDirectory(testcase.getTestCaseName());
			Startup.remainingMethods.remove(testcase.getTestCaseName());
			logger.info("Remaining cases : " + Startup.remainingMethods);
			logger.info("====================================================================================");
			logger.info("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");

		}
	}

	/**
	 * 
	 * 
	 * @author nitin.chourey;
	 * @description:assertionMethod marks testcase as failedand captures screen
	 *                              shot;
	 * @param: Webdriver
	 *             instance, Testcase object, User object, Assertion object;
	 * @return: nil;
	 * @throws Exception
	 */
	public static void assertionMethod(WebDriver driver, TestReportingBO testcase, User user, AssertionError ae)
	{
		try
		{
			Screenshot.captureScreenshot(driver, testcase.getTestCaseName(), "Assertion occurred");
			String exception_message = "";
			logger.info(ae);
			// KeywordUtil.markFailed(ae.message);
			exception_message = CommonServices.generateErrorLog(ae);
			Startup.testMethodTestCaseMap.get(testcase.getTestCaseName()).setMessage("Exception Occured : " + exception_message);
			Startup.testMethodTestCaseMap.get(testcase.getTestCaseName()).setExecutionResult("FAILED");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author nitin.chourey; exceptionMethod marks testcase as failed and
	 *         captures screen shot;
	 * @param: Webdriver
	 *             instance, Testcase object, User object, Assertion object;
	 * @return: nil;
	 * @throws Exception
	 */

	public static void exceptionMethod(WebDriver driver, TestReportingBO testcase, User user, Exception e)
	{
		try
		{
			Screenshot.captureScreenshot(driver, testcase.getTestCaseName(), "Exception occurred");
			String exception_message = "";
			exception_message = CommonServices.generateErrorLog(e);
			Startup.testMethodTestCaseMap.get(testcase.getTestCaseName()).setMessage("Exception Occured : " + exception_message);
			Startup.testMethodTestCaseMap.get(testcase.getTestCaseName()).setExecutionResult("FAILED");
			e.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();

		}
	}

}
