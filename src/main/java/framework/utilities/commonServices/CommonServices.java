
package framework.utilities.commonServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import framework.frameworkUtilies.GlobalVariable;
import framework.frameworkUtilies.testResult.ReportingService;
import framework.frameworkUtilies.testResult.TestReportingBO;
import framework.startup.Startup;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.userListing.User;

public class CommonServices
{
	static Logger		logger			= Logger.getLogger(CommonServices.class);
	static Set<String>	classNameSet	= new TreeSet<String>();

	/**
	 * ;
	 * 
	 * @author om.pawar;
	 * @description: generateErrorLog generates a separate error log file with a
	 *               custom message;
	 * @param: Throwable;
	 * @return: String;
	 */
	public static String generateErrorLog(Throwable throwable) throws Exception
	{
		 String message = "";
		 String reportingMessage = "";
		 String testCaseID = MDC.get("TestCaseName").toString();
		 String fileName = "./output/log/testlog-Exception.xlsx";
		 String sheetName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf(".xlsx"));
		 int rowNum;
		 int cellCounter = 0;
		 FileInputStream is = null;
		 FileOutputStream fs = null;
		 Workbook workbook = null;
		 XSSFSheet sheet = null;
		 XSSFRow row = null;
		
		 File file = new File(fileName);
		 if (!file.exists())
		 {
			 fs = new FileOutputStream(fileName);
			 workbook = new XSSFWorkbook();
			 sheet = (XSSFSheet) workbook.createSheet(sheetName);
//			 sheet.autoSizeColumn(1000000);
			 rowNum = sheet.getLastRowNum();
			 row = sheet.createRow(rowNum);
			 
			 XSSFFont cellFont = (XSSFFont) workbook.createFont();
			 cellFont.setBold(true);
			 XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
			 cellStyle.setFont(cellFont);
			 
			 XSSFCell cell = row.createCell(cellCounter++);
			 cell.setCellStyle(cellStyle);
			 cell.setCellValue("Test Case ID");
			 
			 cell = row.createCell(cellCounter++);
			 cell.setCellStyle(cellStyle);
			 cell.setCellValue("Exception Name");
			 
			 cell = row.createCell(cellCounter++);
			 cell.setCellStyle(cellStyle);
			 cell.setCellValue("Exception Message");
			 
			 cell = row.createCell(cellCounter++);
			 cell.setCellStyle(cellStyle);
			 cell.setCellValue("Class and Method Name");
//			 row.createCell(cellCounter++).setCellValue("Test Case ID");
//			 row.createCell(cellCounter++).setCellValue("Exception Name");
//			 row.createCell(cellCounter++).setCellValue("Exception Message");
//			 row.createCell(cellCounter++).setCellValue("Class and Method Name");
			
			 rowNum++;
		 }
		 else
		 {
			 is = new FileInputStream(file);
			 workbook = new XSSFWorkbook(is);
			 sheet = (XSSFSheet) workbook.getSheet(sheetName);
			 rowNum = sheet.getLastRowNum() + 1;
		 }
		 
		 row = sheet.createRow(rowNum);
		
		 getClassNames(new File("./src/main/java"));
		
		 if (throwable.getClass().getCanonicalName().toLowerCase().contains("assertion"))
		 {
			 cellCounter = 0;
			 row.createCell(cellCounter++).setCellValue(testCaseID);
			 row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
			 row.createCell(cellCounter++).setCellValue(throwable.getLocalizedMessage());
			 logger.error(throwable.getClass().getCanonicalName() + " :: " + throwable.getLocalizedMessage(), throwable);
			
			 reportingMessage = throwable.getClass().getCanonicalName() + " \n " + throwable.getLocalizedMessage();
		 }
		 else
		 {
			 cellCounter = 0;
			
			 StackTraceElement[] stackElement = throwable.getStackTrace();
			 String exception = "";
			 exception = throwable.getLocalizedMessage();
			 if(exception != null) {
				 if (exception.contains("\n"))
				 {
					 exception = exception.substring(0, exception.indexOf("\n"));
				 }				 
			 }
			
			 for (int i = 0; i < stackElement.length; i++)
			 {
				 if (stackElement[i] != null)
				 {
					 Iterator<String> itr = classNameSet.iterator();
					 while (itr.hasNext())
					 {
						 if (stackElement[i].getClassName().contains(itr.next()))
						 {
							 if (message.isEmpty())
							 {
								 message += throwable.getClass().getCanonicalName() + " :: " + exception + " --> " + stackElement[i].getClassName() + " ==> " + stackElement[i].getMethodName() + "||";
								 row.createCell(cellCounter++).setCellValue(testCaseID);
								 row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
								 row.createCell(cellCounter++).setCellValue(exception);
							 }
							 else
							 {
								 message += stackElement[i].getClassName() + " ==> " + stackElement[i].getMethodName() + "||";
							 }
//							 stackElement[i + 1] = null;
							 break;
						 }
					 }
				 }
			 }
			
			 if (!message.isEmpty())
			 {
				 message = message.substring(0, message.lastIndexOf("||"));
				 if (message.contains("-->"))
				 {
					 row.createCell(cellCounter++).setCellValue(message.substring(message.indexOf("-->") + 4));
				 }
			 }
			 else
			 {
				 cellCounter = 0;
				 row.createCell(cellCounter++).setCellValue(testCaseID);
				 row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
				 row.createCell(cellCounter++).setCellValue(exception);
				 message = throwable.getClass().getCanonicalName() + " :: " + exception;
			 }
			 logger.error(message, throwable);
			 reportingMessage = throwable.getClass().getCanonicalName() + " \n " + exception;
		 }
		
		 try
		 {
			 if(file.exists()) {
				 fs = new FileOutputStream(file);
			 }
			 workbook.write(fs);
			 fs.close();
			 workbook.close();
		 }
		 catch (FileNotFoundException fe)
		 {
			 Runtime.getRuntime().exec("cmd /c taskkill /f /im excel.exe");
			 Thread.sleep(5000);
			 if(file.exists()) {
				 fs = new FileOutputStream(file);
			 }
			 workbook.write(fs);
			 fs.close();
			 workbook.close();
		 }
		 logger.info("Hey nitin returning error message : " + reportingMessage);
		 return reportingMessage;
	}

	/**
	 * ;
	 * 
	 * @author om.pawar;
	 * @description: getClassNames retrieves all the file names from the File
	 *               parameter passed to it;
	 * @param: File;
	 * @return: void;
	 */
	public static void getClassNames(File file) throws Exception
	{
		File[] fileArray = file.listFiles();
		for (int i = 0; i < fileArray.length; i++)
		{
			if (fileArray[i].isDirectory())
			{
				getClassNames(fileArray[i]);
			}
			else if (fileArray[i].isFile())
			{
				if (fileArray[i].getName().contains(".java"))
				{
					String fileName = fileArray[i].getName().replace(".java", "");
					classNameSet.add(fileName);
				}
			}
		}
	}

	/**
	 * ;
	 * 
	 * @author om.pawar;
	 * @description: generateErrorLog generates a separate error log file with a
	 *               custom message;
	 * @param: Throwable;
	 * @return: void;
	 */
	public static void analyzeLog(WebDriver driver) throws Exception
	{
		if (GlobalVariable.isAnalyzeLog)
		{
			List<String> urlList = new ArrayList<String>();
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			for (LogEntry entry : logEntries)
			{
				/*
				 * ; String url = ""; String completeLog=entry.getMessage();
				 * completeLog = new Date(entry.getTimestamp()) + " " +
				 * entry.getLevel() + " " + entry.getMessage(); String urlTemp =
				 * completeLog.substring(completeLog.indexOf("https://"),
				 * completeLog.lastIndexOf("-")); urlList.add(urlTemp); String
				 * browserConsoleOutput = new Date(entry.getTimestamp()) + " " +
				 * entry.getLevel() + " " + entry.getMessage();
				 * logger.warn(entry.getMessage());
				 */
			}
			((JavascriptExecutor) driver).executeScript("console.clear();");
		}
	}

	/**
	 * @author nitin.chourey;
	 * @description: screenShotFileOperations removes existing directory and
	 *               creates new directory(execute before every suite);
	 * @param: TestSuiteContext;
	 * @return: nil;
	 * @throws Exception
	 * @throws SQLException
	 */

	public static void screenShotFileOperations(String suitname) throws Exception
	{

		if (GlobalVariable.TAKE_SCREEN_SHOT)
		{
			Screenshot.removeDir(GlobalVariable.SCREENSHOT_PATH);
			Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH);
			Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/");
			logger.info("Created directory with name  :" + GlobalVariable.SCREENSHOT_PATH + "ScreenShot");

			Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/");
			logger.info("Created directory with name  :" + GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/");

			Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/" + "Passed");
			logger.info("Created directory with name  :" + GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/" + "Passed");

			Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/" + "Failed");
			logger.info("Created directory with name  :" + GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/" + "Failed");

			GlobalVariable.SCREENSHOT_PATH = GlobalVariable.SCREENSHOT_PATH + "ScreenShot" + "/" + suitname + "/";
			logger.info("New ScreenShot path :  " + GlobalVariable.SCREENSHOT_PATH);
		}

	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description: dirCreationForScreenShot removes existing directory and
	 *               creates new directory for test cases(execute before every
	 *               test case);
	 * @param: TestCaseContext;
	 * @return: nil;
	 * @throws Exception
	 */

	public static void dirCreationForScreenShot(String TestCaseName) throws Exception
	{

		// creating folder for every testcase
		if (GlobalVariable.TAKE_SCREEN_SHOT == true)
		{
			Screenshot.removeDir(GlobalVariable.SCREENSHOT_PATH + TestCaseName + "/");
			logger.info("Directory created for  " + TestCaseName + " : " + Screenshot.createDir(GlobalVariable.SCREENSHOT_PATH + TestCaseName + "/"));
			logger.info("Created directory with name  :" + GlobalVariable.SCREENSHOT_PATH + TestCaseName + "/");
		}

	}

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
