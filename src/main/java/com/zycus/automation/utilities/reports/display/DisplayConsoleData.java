package com.zycus.automation.utilities.reports.display;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class DisplayConsoleData
{

	static Logger				logger			= Logger.getLogger(DisplayConsoleData.class);

	static String				destPath		= "reporting/";
	static String				fileName		= "infoOnUI.html";
	static String				dispFileName	= "displayOnUI.html";
	public static final String	description		= "description";

	public static void writeInfoOnUI(WebDriver driver, TestCase testCase, List<MappedTestCase> mappedTestCases)
	{
		File infoOnUI = new File(destPath + fileName);
		try
		{
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(infoOnUI));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");

			writeOnHtmlPage.write("<style>");
			writeOnHtmlPage.write("div.ex");
			writeOnHtmlPage.write("{");
			writeOnHtmlPage.write("width:80%;");
			writeOnHtmlPage.write("border:5px solid gray;");
			writeOnHtmlPage.write("margin:100px;");
			writeOnHtmlPage.write("font-size:18pt;");
			writeOnHtmlPage.write("font-weight:bold;");
			writeOnHtmlPage.write("color:#23238e;");
			writeOnHtmlPage.write("}");
			writeOnHtmlPage.write("</style>");

			writeOnHtmlPage.write("</head>");

			writeOnHtmlPage.write("<body>");
			writeOnHtmlPage.write("<div class=\"ex\">");
			writeOnHtmlPage.write("<table border=1 , width=100%>");
			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("Name");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("Info");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("</tr>");
			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write("TestCase Name : ");
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write(testCase.getTestMethodName());
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("</tr>");

			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write("TestCase Description : ");
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write(testCase.getDescription());
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("</tr>");

			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write("TestCase ModuleName : ");
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write(testCase.getModuleName());
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("</tr>");

			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write("Browser : ");
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write(testCase.getBrowser());
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("</tr>");

			writeOnHtmlPage.write("<tr>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write("Version : ");
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("<td>");
			writeOnHtmlPage.write(testCase.getVersion());
			writeOnHtmlPage.write("</td>");
			writeOnHtmlPage.write("</tr>");

			if (mappedTestCases != null)
			{
				if (!mappedTestCases.isEmpty())
				{
					writeOnHtmlPage.write("<tr>");
					writeOnHtmlPage.write("<td colspan=\"2\">");
					writeOnHtmlPage.write("<center>List Of Map TestCase</center>");
					writeOnHtmlPage.write("</td>");
					writeOnHtmlPage.write("</tr>");

					for (MappedTestCase mappedTestCase : mappedTestCases)
					{
						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<td>");
						writeOnHtmlPage.write(mappedTestCase.getTestCaseName());
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("<td>");
						writeOnHtmlPage.write(mappedTestCase.getDescription());
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("</tr>");
					}
				}

			}

			writeOnHtmlPage.write("</table>");
			writeOnHtmlPage.write("</div>");
			writeOnHtmlPage.write("</body>");
			writeOnHtmlPage.write("</html>");
			writeOnHtmlPage.close();

			String url = infoOnUI.getAbsolutePath();
			driver.get(url);
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Display Of TestData");
			ActionBot.threadSleep("10");
			driver.manage().deleteAllCookies();
			boolean success = new File(destPath + fileName).delete();
			if (success)
			{
				logger.info("The file has been successfully deleted");
			}

		}
		catch (IOException e)
		{
			logger.error("Exception Occurred While Displaying Data On UI" + e, e);
		}
	}

	public static void displayDataOnUI(WebDriver driver, TestCase testCase, Map<String, String> displayData) throws Exception
	{
		File displayOnUI = new File(destPath + dispFileName);
		try
		{
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(displayOnUI));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");

			writeOnHtmlPage.write("<style>");
			writeOnHtmlPage.write("div.ex");
			writeOnHtmlPage.write("{");
			writeOnHtmlPage.write("width:80%;");
			writeOnHtmlPage.write("border:5px solid gray;");
			writeOnHtmlPage.write("margin:100px;");
			writeOnHtmlPage.write("font-size:18pt;");
			writeOnHtmlPage.write("font-weight:bold;");
			writeOnHtmlPage.write("color:#23238e;");
			writeOnHtmlPage.write("}");
			writeOnHtmlPage.write("</style>");

			writeOnHtmlPage.write("</head>");

			writeOnHtmlPage.write("<body>");

			writeOnHtmlPage.write("<div class=\"ex\">");
			if (displayData != null)
			{
				writeOnHtmlPage.write("<br>");
				writeOnHtmlPage.write("<b><u> TestCase Name : ");
				writeOnHtmlPage.write(testCase.getTestMethodName());
				writeOnHtmlPage.write("</u></b>");
				writeOnHtmlPage.write("<br><br>");

				writeOnHtmlPage.write("<table>");

				for (Map.Entry entry : displayData.entrySet())
				{
					if (((String) entry.getKey()).contains("Header"))
					{
						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<th>");
						writeOnHtmlPage.write("<b>");
						writeOnHtmlPage.write((String) entry.getValue());
						writeOnHtmlPage.write("</b>");
						writeOnHtmlPage.write("</th>");
						writeOnHtmlPage.write("</tr>");
					}
					else
					{
						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<td>");
						String key = ((String) entry.getKey()).toString();
						if (key.contains(":"))
						{
							String[] temp = ((String) entry.getKey()).split(":");
							key = temp[1];
						}
						writeOnHtmlPage.write(key);
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("<td>");
						writeOnHtmlPage.write((String) entry.getValue());
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("</tr>");
					}
				}
				writeOnHtmlPage.write("</table>");
			}

			if (testCase.getTestData() != null)
			{
				writeOnHtmlPage.write("<table border=\"1\">");

				writeOnHtmlPage.write("<tr>");
				writeOnHtmlPage.write("<td colspan=\"2\">");
				writeOnHtmlPage.write("<center>TestCase Data</center>");
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("</tr>");

				for (Map.Entry map : testCase.getTestData().entrySet())
				{
					writeOnHtmlPage.write("<tr>");
					writeOnHtmlPage.write("<td>");
					writeOnHtmlPage.write((String) map.getKey());
					writeOnHtmlPage.write("</td>");
					writeOnHtmlPage.write("<td>");
					writeOnHtmlPage.write((String) map.getValue());
					writeOnHtmlPage.write("</td>");
					writeOnHtmlPage.write("</tr>");
				}

				writeOnHtmlPage.write("</table>");
			}
			else
			{
				logger.error("TestCase Data is null");
			}

			writeOnHtmlPage.write("</body>");
			writeOnHtmlPage.write("</div>");
			writeOnHtmlPage.write("</html>");

			writeOnHtmlPage.close();

			String url = displayOnUI.getAbsolutePath();
			driver.get(url);
			ActionBot.threadSleep("5");
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Data validation");
			driver.manage().deleteAllCookies();
			boolean success = new File(destPath + dispFileName).delete();

			if (success)
			{
				logger.info("The file has been deleted");
			}

		}
		catch (Exception e)
		{
			logger.info("Exception message :" + e, e);
		}
	}

	public static void printMappedTestCaseDataOnConsole(TestCase testCase, List<MappedTestCase> mappedTestCases)
	{
		try
		{
			if (mappedTestCases != null)
			{
				int i = 1;

				for (MappedTestCase mappedTestCase : mappedTestCases)
				{
					// int i = 1;
					logger.info("\n \n ******************************************************************** \n MAPPED TESTCASENAME	|	DESCRIPTION	|	JIRA ID\n\n"
						+ String.format("%02d", i) + " ) " + mappedTestCase.getTestCaseName() + "  |  " + mappedTestCase.getDescription() + "  |  " + mappedTestCase.getJiraId()
						+ "\n ********************************************************************");
					i++;
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Exception While Displaying InFo On Console " + e);
		}
	}

	public static void displayDataOnUI(WebDriver driver, TestCase testCase, LinkedHashMap<String, String> displayData) throws Exception
	{
		File displayOnUI = new File(destPath + dispFileName);
		try
		{
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(displayOnUI));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");

			writeOnHtmlPage.write("<style>");
			writeOnHtmlPage.write("div.ex");
			writeOnHtmlPage.write("{");
			writeOnHtmlPage.write("width:80%;");
			writeOnHtmlPage.write("border:5px solid gray;");
			writeOnHtmlPage.write("margin:100px;");
			writeOnHtmlPage.write("font-size:18pt;");
			writeOnHtmlPage.write("font-weight:bold;");
			writeOnHtmlPage.write("color:#23238e;");
			writeOnHtmlPage.write("}");
			writeOnHtmlPage.write("</style>");

			writeOnHtmlPage.write("</head>");

			writeOnHtmlPage.write("<body>");

			writeOnHtmlPage.write("<div class=\"ex\">");
			if (displayData != null)
			{
				writeOnHtmlPage.write("<br>");
				writeOnHtmlPage.write("<b><u> TestCase Name : ");
				writeOnHtmlPage.write(testCase.getTestMethodName());
				writeOnHtmlPage.write("</u></b>");
				writeOnHtmlPage.write("<br><br>");

				writeOnHtmlPage.write("<table border=1 , width=100%>");

				for (Map.Entry entry : displayData.entrySet())
				{
					if (((String) entry.getKey()).contains("Header"))
					{
						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<th>");
						writeOnHtmlPage.write("<b>");
						writeOnHtmlPage.write((String) entry.getValue());
						writeOnHtmlPage.write("</b>");
						writeOnHtmlPage.write("</th>");
						writeOnHtmlPage.write("</tr>");
					}
					else
					{
						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<td>");
						String key = ((String) entry.getKey()).toString();
						if (key.contains(":"))
						{
							String[] temp = ((String) entry.getKey()).split(":");
							key = temp[1];
						}
						writeOnHtmlPage.write(key);
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("<td>");
						writeOnHtmlPage.write((String) entry.getValue());
						writeOnHtmlPage.write("</td>");
						writeOnHtmlPage.write("</tr>");
					}
				}
				writeOnHtmlPage.write("</table>");
			}

			/*
			 * if (testCase.getTestData() != null) { writeOnHtmlPage.write(
			 * "<table border=\"1\">");
			 * 
			 * writeOnHtmlPage.write("<tr>"); writeOnHtmlPage.write(
			 * "<td colspan=\"2\">"); writeOnHtmlPage.write(
			 * "<center>TestCase Data</center>");
			 * writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write("</tr>");
			 * 
			 * for (Map.Entry map : testCase.getTestData().entrySet()) {
			 * writeOnHtmlPage.write("<tr>"); writeOnHtmlPage.write("<td>");
			 * writeOnHtmlPage.write((String) map.getKey());
			 * writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write("<td>");
			 * writeOnHtmlPage.write((String) map.getValue());
			 * writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write("</tr>"); }
			 * 
			 * writeOnHtmlPage.write("</table>"); } else { logger.error(
			 * "TestCase Data is null"); }
			 */

			writeOnHtmlPage.write("</body>");
			writeOnHtmlPage.write("</div>");
			writeOnHtmlPage.write("</html>");

			writeOnHtmlPage.close();

			String url = displayOnUI.getAbsolutePath();
			driver.get(url);
			ActionBot.threadSleep("5");
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Data validation");
			driver.manage().deleteAllCookies();
			boolean success = new File(destPath + dispFileName).delete();

			if (success)
			{
				logger.info("The file has been deleted");
			}

		}
		catch (Exception e)
		{
			logger.info("Exception message :" + e, e);
		}
	}

}
