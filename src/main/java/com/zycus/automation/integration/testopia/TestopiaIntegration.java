package com.zycus.automation.integration.testopia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.testresult.GenerateResults;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class TestopiaIntegration implements TestopiaIntegrationObjects
{

	static Logger											logger						= Logger.getLogger(TestopiaIntegration.class);
	private static Map<String, LinkedList<TestopiaData>>	testopiaDataList			= GenerateResults.testopiaDataList;
	private static List<String>								unchanged					= new ArrayList<String>();
	private static List<String>								passToFail					= new ArrayList<String>();
	private static List<String>								failToPass					= new ArrayList<String>();
	private static List<String>								failedTestCases				= new ArrayList<String>();
	private static List<String>								notFoundTcs					= new ArrayList<String>();
	private static List<String>								notMarked					= new ArrayList<String>();
	private static String									executionPercentage;
	private static String									destPath					= "output/";
	private static String									fileName					= "htmlContent.html";
	private static String									testopiaResultSrcFilePath	= "reporting/";
	private static String									testopiaResultFileName		= "TestopiaExecutionResult.xls";
	private static String									testopiaResultDestFilePath	= "output/reports/";

	public static void markedTestCaseExecution() throws Exception
	{
		logger.info("\n\n/********************* Updating results in testopia **************************/");
		WebDriver driver = TestopiaUtil.getDriver();
		try
		{

			int i = 0;
			boolean summaryFoundFlag = false;
			testopiaLogin(driver);
			driver.get(testopiaRunUrl);
			ActionBot.findElement(driver, runlist);
			ActionBot.waitTillPopUpIsPresent(driver, loadingPopUp);
			TestopiaScreenShot.screenshot(driver, "Landing page");
			for (Map.Entry<String, LinkedList<TestopiaData>> testdata : testopiaDataList.entrySet())
			{
				if (testdata.getKey().contains("FF"))
				{
					for (i = 0; i < testdata.getValue().size(); i++)
					{
						String tcSummary = testdata.getValue().get(i).getTcSummary();
						boolean testResult = testdata.getValue().get(i).isTcResult();
						String tcName = testdata.getValue().get(i).getTcName();
						String status = null;

						// to apply filter on testcase summary
						WebElement element = driver.findElement(case_Summary_Input);
						element.clear();
						element.sendKeys(tcSummary);
						driver.findElement(filterButton).click();
						ActionBot.waitTillPopUpIsPresent(driver, loadingPopUp);
						ActionBot.defaultSleep();
						TestopiaScreenShot.screenshot(driver, "After applying filter");

						if (ActionBot.isElementPresent(driver, testCaseStatus))
						{
							// to check exact match of summary
							List<WebElement> rowResults = ActionBot.findElements(driver, By.cssSelector(".x-grid3-row-body>p"));
							int rowCount = rowResults.size();
							// for more than one filtered results
							if (rowCount > 1)
							{
								for (WebElement ele : rowResults)
								{
									String summary = ele.getText().trim();

									String[] temp = StringUtils.split(summary, ":");
									summary = temp[1].trim();
									if (summary.equalsIgnoreCase(tcSummary.trim()))
									{
										element = ele;
										summaryFoundFlag = true;
										break;
									}
								}
								if (summaryFoundFlag) // if summary found
								{
									driver.switchTo().defaultContent();
									ActionBot.defaultSleep();

									try
									{
										WebElement parentElement = element.findElement(By.xpath("ancestor::table"));
										status = parentElement.findElement(testCaseStatus).getAttribute("title");
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Before Changing Status");

										parentElement.findElement(testCaseStatus).click();
									}
									catch (Exception e)
									{
										status = "NotMarked";
										notMarked.add(tcSummary);
										logger.info("Error :=>" + e, e);
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
									}
								}
								else
								// if summary not found
								{
									status = "NotPresent";
									logger.info("\n\n For " + tcSummary + " summary was not matched");
									notFoundTcs.add(tcSummary);
								}

							}
							else
							{
								try
								{
									status = ActionBot.findElement(driver, testCaseStatus).getAttribute("title");
									ActionBot.click(driver, testCaseStatus);
								}
								catch (Exception e)
								{
									status = "NotMarked";
									notMarked.add(tcSummary);
									logger.info("Error :=>" + e, e);
									TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
								}
							}

							TestopiaScreenShot.screenshot(driver, tcName + "_" + "After updating status");
							// for pass result
							if (testResult)
							{
								// no change in status(Pass to pass)
								if (status.equalsIgnoreCase(PASSED))
								{
									unchanged.add(tcSummary);
								}
								// fail to pass status change
								else if (status.equalsIgnoreCase(FAILED))
								{
									failToPass.add(tcSummary);
									try
									{
										ActionBot.click(driver, markedPass);
									}
									catch (Exception e)
									{
										logger.info("Error :=>" + e, e);
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
									}
								}
								else if (status.equalsIgnoreCase("NotPresent"))
								{
									logger.info("\n\n" + tcSummary + " is Passed but summary was not found in Run");
								}
								else if (status.equalsIgnoreCase("NotMarked"))
								{
									logger.info("\n\n" + tcSummary + " is Passed but not marked in Run");
								}
								else
								{
									try
									{
										ActionBot.click(driver, markedPass);
									}
									catch (Exception e)
									{
										logger.info("Error :=>" + e, e);
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
									}
								}
							}
							// for fail result
							else
							{
								failedTestCases.add(tcSummary);
								// no change in status(fail to fail)
								if (status.equalsIgnoreCase(FAILED))
								{
									unchanged.add(tcSummary);
								}
								// pass to fail change
								else if (status.equalsIgnoreCase(PASSED))
								{
									passToFail.add(tcSummary);
									try
									{
										ActionBot.click(driver, markedFailed);
									}
									catch (Exception e)
									{
										logger.info("Error :=>" + e, e);
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
									}
								}
								else if (status.equalsIgnoreCase("NotPresent"))
								{
									logger.info("\n\n" + tcSummary + " is Failed but summary was not found in Run");
								}
								else if (status.equalsIgnoreCase("NotMarked"))
								{
									logger.info("\n\n" + tcSummary + " is Failed but not marked in Run");
								}
								else
								{
									try
									{
										ActionBot.click(driver, markedFailed);
									}
									catch (Exception e)
									{
										logger.info("Error :=>" + e, e);
										TestopiaScreenShot.screenshot(driver, tcName + "_" + "Exception");
									}
								}
							}
							// wait for pop up disappear
							ActionBot.waitTillPopUpIsPresent(driver, successfulUpdationMessage);
						} // end of if testcases found
						else
						{
							logger.info("\n\n" + tcSummary + "not present");
							notFoundTcs.add(tcSummary);
						}
					} // end of inner for
				} // end of if
			} // end of outer for
			executionPercentage = ActionBot.getTextWithInElement(driver, execution_Percentage);
		}
		catch (Exception e)
		{
			logger.info("Error :=>" + e, e);
			TestopiaScreenShot.screenshot(driver, "Exception");
			testopiaLogout(driver);
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		finally
		{
			testopiaLogout(driver);
			// to display output
			logger.info("\n\n Execution percentage : " + executionPercentage);
			logger.info("\n\n List of unchanged testcases : ");
			if (unchanged != null)
			{
				for (String str : unchanged)
				{
					logger.info("\n\n" + str);
				}
			}

			logger.info("\n\n List of testcases status changed from pass to fail : ");
			if (passToFail != null)
			{
				for (String str : passToFail)
				{
					logger.info("\n\n" + str);
				}
			}

			logger.info("\n\n List of testcases status changed from fail to pass : ");
			if (failToPass != null)
			{
				for (String str : failToPass)
				{
					logger.info("\n\n" + str);
				}
			}

			logger.info("\n\n List of testcases not found in run : ");
			if (notFoundTcs != null)
			{
				for (String str : notFoundTcs)
				{
					logger.info("\n\n" + str);
				}
			}

			logger.info("\n\n List of testcases not marked in run : ");
			if (notMarked != null)
			{
				for (String str : notMarked)
				{
					logger.info("\n\n" + str);
				}
			}
			writeTestopiaResultInExcel();
			createHTMLMail();
			MailExecutionStatus.sendMail();
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	private static void testopiaLogin(WebDriver driver) throws Exception
	{
		logger.info("\n\n/************************ Login into testopia *****************************/");

		driver.get(testopiaUrl);
		ActionBot.click(driver, loginLink);
		ActionBot.clear(driver, bugzilla_login);
		ActionBot.sendKeys(driver, bugzilla_login, testopiaLogin);
		ActionBot.clear(driver, bugzilla_Password);
		ActionBot.sendKeys(driver, bugzilla_Password, testopiaPassword);
		ActionBot.click(driver, log_In_Button);
		TestopiaScreenShot.screenshot(driver, "After Login");
		/*
		 * ActionBotBot.findElement(driver, runlist);
		 * ActionBotBot.waitTillPopUpIsPresent(driver, loadingPopUp);
		 */
	}

	private static void testopiaLogout(WebDriver driver)
	{
		logger.info("\n\n/***************************** Log out *****************************/");
		driver.get("http://192.168.2.106/smtbz/index.cgi?logout=1");
		TestopiaScreenShot.screenshot(driver, "After Logout");
	}

	private static void createHTMLMail() throws IOException
	{
		logger.info("\n\n Creating mail attachment ");
		int i = 0;
		File htmlContent = new File(destPath + fileName);
		BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(htmlContent));
		writeOnHtmlPage.write("<!DOCTYPE html><html><head>");

		writeOnHtmlPage.write("</head>");
		writeOnHtmlPage.write("<body>");
		writeOnHtmlPage.write("<b><u><center>");
		writeOnHtmlPage.write("<h1>Report of Testopia Execution</h1><hr>");
		writeOnHtmlPage.write("</center></u></b>");
		writeOnHtmlPage.write("<br><br>");
		writeOnHtmlPage.write("<h3>List of the test cases whose previous status was <b> PASS </b> and current status is <b> FAIL <b/></h3>");

		if (passToFail.size() == 0)
		{
			writeOnHtmlPage.write("<br>");
			writeOnHtmlPage.write("None OF TestCase Changed from Pass to fail");
		}
		else
		{
			for (i = 0; i < passToFail.size(); i++)
			{
				writeOnHtmlPage.write("<br>");
				writeOnHtmlPage.write(passToFail.get(i));
			}
		}

		writeOnHtmlPage.write("<br><br>");
		writeOnHtmlPage.write("<h3>List of the test cases whose previous status was <b> FAIL </b> and current status is <b> PASS <b/></h3>");

		if (failToPass.size() == 0)
		{
			writeOnHtmlPage.write("<br>");
			writeOnHtmlPage.write("None Of The TestCase Changed From Fail To Pass");
		}
		else
		{
			for (i = 0; i < failToPass.size(); i++)
			{
				writeOnHtmlPage.write("<br>");
				writeOnHtmlPage.write(failToPass.get(i));
			}
		}

		writeOnHtmlPage.write("<br><br>");
		writeOnHtmlPage.write("<h3>List of the test cases <b> No Found </b> in testopia </h3>");

		if (notFoundTcs.size() == 0)
		{
			writeOnHtmlPage.write("<br>");
			writeOnHtmlPage.write("N/A");
		}
		else
		{
			for (i = 0; i < notFoundTcs.size(); i++)
			{
				writeOnHtmlPage.write("<br>");
				writeOnHtmlPage.write(notFoundTcs.get(i));
			}
		}

		writeOnHtmlPage.write("</body>");
		writeOnHtmlPage.write("</html>");

		writeOnHtmlPage.close();

		boolean success = htmlContent.exists();
		if (success)
		{
			System.out.println("File is created");
		}
		else
		{
			System.out.println("File not created");
		}
	}

	public static String getExecutionPercentage()
	{
		return executionPercentage;
	}

	public static List<String> getFailedTestCases()
	{
		return failedTestCases;
	}

	public static List<String> getPassToFail()
	{
		return passToFail;
	}

	public static List<String> getFailToPass()
	{
		return failToPass;
	}

	public static List<String> getNoFoundTcs()
	{
		return notFoundTcs;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To write testopia result in excel <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * </b> <br>
	 */
	public static void writeTestopiaResultInExcel()
	{
		File srcFile = new File(testopiaResultSrcFilePath + testopiaResultFileName);
		File destFile = new File(testopiaResultDestFilePath + testopiaResultFileName);
		File destDir = new File(testopiaResultDestFilePath);
		try
		{
			if (!destFile.exists())
			{
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}
			FileInputStream fi = new FileInputStream(destFile);
			Workbook w = Workbook.getWorkbook(fi);
			w.getSheet(0);

			// to get blank row
			int rows = 1;
			fi.close();

			FileOutputStream fout = new FileOutputStream(destFile);
			WritableWorkbook wout = Workbook.createWorkbook(fout, w);
			WritableSheet wsheet = wout.getSheet(0);

			// to add unchanged tcs : column : 0
			if (unchanged != null)
			{
				for (String str : unchanged)
				{
					Label unchangedTcs = new Label(0, rows++, str);
					wsheet.addCell(unchangedTcs);
				}
			}

			rows = 1;
			// to add pass to fail tcs : column : 1
			if (passToFail != null)
			{
				for (String str : passToFail)
				{
					Label passToFailTcs = new Label(1, rows++, str);
					wsheet.addCell(passToFailTcs);
				}
			}

			rows = 1;
			// to add fail to pass tcs : column : 2
			if (failToPass != null)
			{
				for (String str : failToPass)
				{
					Label failToPassTcs = new Label(2, rows++, str);
					wsheet.addCell(failToPassTcs);
				}
			}

			rows = 1;
			// to add not found tcs : column : 3
			if (notFoundTcs != null)
			{
				for (String str : notFoundTcs)
				{
					Label notFoundTcs = new Label(3, rows++, str);
					wsheet.addCell(notFoundTcs);
				}
			}

			rows = 1;
			// to add not marked tcs : column : 4
			if (notMarked != null)
			{
				for (String str : notMarked)
				{
					Label notMarkedTcs = new Label(4, rows++, str);
					wsheet.addCell(notMarkedTcs);
				}
			}

			wout.write();
			wout.close();
		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (RowsExceededException e)
		{
			logger.error("RowsExceededException Exception Occured " + e, e);
		}
		catch (WriteException e)
		{
			logger.error("WriteException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		catch (BiffException e)
		{
			logger.error("BiffException Exception Occured " + e, e);
		}
	}
}
