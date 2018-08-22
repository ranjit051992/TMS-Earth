/**
 * 
 */
package com.zycus.automation.utilities.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

import com.zycus.automation.constants.IConstants;
import com.zycus.framework.framework_version_2_4.bo.TestCaseResult;
import com.zycus.framework.framework_version_2_4.bo.TestSuiteResult;
import com.zycus.framework.framework_version_2_4.framework.MailReport;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * @author ankita.sawant
 *
 */
public class CreateMailContentReport
{
	static Logger			logger		= Logger.getLogger(CreateEmailReport.class);

	private static String	destPath	= "output/reports/";
	private static String	fileName	= "MailContentReport.html";

	public static void createMailContentReoprt() throws Exception
	{
		String productURL = null, product = null;
		try
		{
			File emailReport = new File(destPath + fileName);
			productURL = IConstants.productURL;
			product = IConstants.product_name;
			logger.info("#######################--GENERATING REPORT--#######################");
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(emailReport));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");
			// writeOnHtmlPage.write("Email Report");
			writeOnHtmlPage.write("</head>");
			writeOnHtmlPage.write("<body>");

			writeOnHtmlPage.write("<H3>");
			writeOnHtmlPage.write("Test Automation Report for <strong>" + product + "</strong> executed on <strong>" + productURL + "</strong>");
			writeOnHtmlPage.write("<hr align=\"LEFT\" width=\"50%\" />");
			writeOnHtmlPage.write("</H3>");
			writeOnHtmlPage.write("<div id=symmary>");
			writeOnHtmlPage.write("<table align=\"left\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\" width=\"40%\">");
			writeOnHtmlPage.write("<tbody>");
			writeOnHtmlPage.write("<tr style=\"background-color: cyan\">");
			writeOnHtmlPage.write("<td><strong>BROWSER</strong></td>");
			writeOnHtmlPage.write("<td><strong>TOTAL</strong></td>");
			writeOnHtmlPage.write("<td><strong>PASSED</strong></td>");
			writeOnHtmlPage.write("<td><strong>FAILED</strong></td>");
			writeOnHtmlPage.write("<td><strong>SKIPPED</strong></td>");
			writeOnHtmlPage.write("</tr>");
			if (Startup.result != null)
			{
				for (TestSuiteResult testSuiteResult : Startup.result)
				{
					writeOnHtmlPage.write("<tr>");
					writeOnHtmlPage.write("<td>" + testSuiteResult.getBrowserVersion() + "</td>");
					writeOnHtmlPage.write("<td>" + testSuiteResult.getTotal() + "</td>");
					writeOnHtmlPage.write("<td style=\"color: green\">" + testSuiteResult.getPassed() + "</td>");
					writeOnHtmlPage.write("<td style=\"font-weight: bold; color: red\">" + testSuiteResult.getFailed() + "</td>");
					writeOnHtmlPage.write("<td style=\"font-weight: bold; color: blue\">" + testSuiteResult.getSkipped() + "</td>");
					writeOnHtmlPage.write("</tr>");
				}
			}
			writeOnHtmlPage.write("</tbody>");
			writeOnHtmlPage.write("</table>");
			writeOnHtmlPage.write("</div>");
			writeOnHtmlPage.write("<br />");
			writeOnHtmlPage.write("<br />");
			writeOnHtmlPage.write("<br />");
			writeOnHtmlPage.write("<br />");
			writeOnHtmlPage.write("<br />");
			writeOnHtmlPage.write("<div id=failed_report></div>");

			String failedTestCases = "";
			String skippedTestCases = "";
			if (Startup.result != null)
			{
				for (TestSuiteResult eachSuite : Startup.result)
				{
					// for failed tcs
					if (eachSuite.getFailedTests().size() != 0)
					{
						failedTestCases += "<table style=\"background-color:#F6CED8;\" border=\"1\" width=\"50%\">";
						failedTestCases += "<tr style=\"background-color:#F7819F; color:black; font-weight:bold;\"><td colspan=\"5\" align=\"left\">Failed TestCases in "
							+ MailReport.trimBrowserVersion(eachSuite.getBrowserVersion()) + "</td></tr>";
						failedTestCases += "<tr>" + "<th>Serial No.</th>" + "<th>TestCaseID</th>" + "<th>Summary</th>" + "<th>Failure Message</th>" + "<th>Mapped With</th>"
							+ "</tr>";
					}
					int serialNo = 0;
					for (TestCaseResult failedTestResult : eachSuite.getFailedTests())
					{
						failedTestCases += "<tr>";
						failedTestCases += "<td>" + ++serialNo + "</td>";
						failedTestCases += "<td>" + failedTestResult.getTestMethodName() + "</td>";
						failedTestCases += "<td>" + failedTestResult.getTestDescription() + "</td>";
						String exceptionMessage = failedTestResult.getExceptionMessage();
						if (exceptionMessage != null)
						{
							if (exceptionMessage.length() > 0)
							{
								failedTestCases += "<td>"
									+ exceptionMessage.substring(0, exceptionMessage.length() > 300 ? 300 : (exceptionMessage.length() == 0 ? 0 : exceptionMessage.length() - 1))
									+ (exceptionMessage.length() > 300 ? "..." : "") + "</td>";
							}
						}
						else
						{
							failedTestCases += "<td>&nbsp;</td>";
						}
						if (failedTestResult.getMappedWith() != null)
						{
							failedTestCases += "<td>" + failedTestResult.getMappedWith() + "</td>";
						}
						else
						{
							failedTestCases += "<td> NA </td>";
						}
						failedTestCases += "</tr>";
					} // end of failed test result for loop
					if (failedTestCases.length() != 0)
					{
						failedTestCases += "</table><br/>";
					}

					// for skipped tcs
					if (eachSuite.getSkippedTests().size() != 0)
					{
						skippedTestCases += "<table style=\"background-color:#F6CED8;\" border=\"1\" width=\"50%\">";
						skippedTestCases += "<tr style=\"background-color:#F7819F; color:black; font-weight:bold;\"><td colspan=\"5\" align=\"left\">Skipped TestCases in "
							+ MailReport.trimBrowserVersion(eachSuite.getBrowserVersion()) + "</td></tr>";
						skippedTestCases += "<tr>" + "<th>Serial No.</th>" + "<th>TestCaseID</th>" + "<th>Summary</th>" + "<th>Mapped With</th>" + "<th>Skipped Message</th>"
							+ "</tr>";
					}
					serialNo = 0;
					for (TestCaseResult skippedTestResult : eachSuite.getSkippedTests())
					{
						skippedTestCases += "<tr>";
						skippedTestCases += "<td>" + ++serialNo + "</td>";
						skippedTestCases += "<td>" + skippedTestResult.getTestMethodName() + "</td>";
						if (skippedTestResult.getTestDescription() != null)
						{
							skippedTestCases += "<td>" + skippedTestResult.getTestDescription() + "</td>";
						}
						else
						{
							skippedTestCases += "<td>&nbsp;</td>";
						}
						if (skippedTestResult.getMappedWith() != null)
						{
							skippedTestCases += "<td>" + skippedTestResult.getMappedWith() + "</td>";
						}
						else
						{
							skippedTestCases += "<td>&nbsp;</td>";
						}
						skippedTestCases += "<td>&nbsp;</td>";
						skippedTestCases += "</tr>";
					}
					if (skippedTestCases.length() != 0)
					{
						skippedTestCases += "</table><br/>";
					}

				} // end of suite for loop
			}

			writeOnHtmlPage.write(failedTestCases);
			writeOnHtmlPage.write(skippedTestCases);

			writeOnHtmlPage.write("</body>");
			writeOnHtmlPage.write("</html>");
			writeOnHtmlPage.close();
			Boolean success = emailReport.exists();
			if (success)
			{
				logger.info("#######################--REPORT  GENERATED--#######################");

			}
			else
			{
				logger.info("#######################--REPORT GENERATION FAILED--#######################");
			}
		}
		catch (Exception e)
		{
			logger.error("Exception  Occured While Creating:" + e, e);
		}
	}
}
