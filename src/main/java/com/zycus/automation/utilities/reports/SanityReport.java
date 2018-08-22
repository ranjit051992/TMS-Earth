package com.zycus.automation.utilities.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.zycus.automation.testresult.GenerateResults;
import com.zycus.automation.testresult.TestResults;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.MailReport;
import com.zycus.framework.framework_version_2_4.startup.Startup;
import com.zycus.framework.framework_version_2_4.testcaseMapping.SanityRegressionMapping;


/**
 * @author ankita.sawant
 *
 */
public class SanityReport extends MailReport implements FrameworkConstants
{

	static Logger														logger		= Logger.getLogger(SanityReport.class);

	private static String												destPath	= "output/reports/Sanity-Regression/";
	private static String												fileName	= null;
	private static String												suite_type	= ConfigProperty.getConfig("SUITE_TYPE");
	private static String												URL			= ConfigProperty.getConfig("URL");
	private static LinkedList<String>									browserName	= Startup.browserNames;
	private static Map<String, Map<String, LinkedList<TestResults>>>	testResults	= GenerateResults.finalResultSet;

	/*
	 * private static Map<String, Map<String, String>> regTC =
	 * SanityRegressionMapping.regTC(); private static Map<String, String>
	 * sanityTC = SanityRegressionMapping .sanityTC();
	 */

	public static Map<String, Map<String, Integer>>						tcsCountMap	= new HashMap<String, Map<String, Integer>>();

	public static void createSanityReoprt() throws Exception
	{
		if (suite_type.equalsIgnoreCase("sanity"))
		{
			fileName = "sanityReport.html";
		}
		else if (suite_type.equalsIgnoreCase("regression"))
		{
			fileName = "regression.html";
		}

		File sanityReport = new File(destPath + fileName);
		try
		{
			logger.info("#######################--GENERATING REPORT--#######################");
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(sanityReport));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");
			/**
			 * Import jquery file
			 */
			writeOnHtmlPage.write("<script type='text/javascript' src='../../../reporting/jquery-2.0.2.min.js'></script>");

			writeOnHtmlPage.write("<script language=\"JavaScript\">");
			// Writing JSON to HTML
			for (Map.Entry<String, Map<String, LinkedList<TestResults>>> TC : testResults.entrySet())
			{

				for (Map.Entry<String, LinkedList<TestResults>> testCaseData : TC.getValue().entrySet())
				{
					for (TestResults results : testCaseData.getValue())
					{
						String tc_id = results.getTestCaseName() + "_" + results.getBrowserVersionID();

						// RESULT == TRUE
						if (results.getResultOfTC() == true)
						{

							writeOnHtmlPage.write("var " + tc_id + " = '{\"TC\":[{\"testCaseName\":\"" + results.getTestCaseName() + "\",\"moduleName\":\""
								+ results.getModuleName() + "\",\"linkToScreenShot\":\"" + results.getLinkToScreenShot() + "\",\"summary\":\""
								// +
								// regTC.get(results.getTestCaseName()).get(SanityRegressionMapping.description)
								+ results.getSummary() + "\",\"result\":\"" + markPassFail(results.getResultOfTC()) + "\" }]}';");
						}

						else
						{
							// RESULT == FALSE
							if (results.getResultOfTC() == false)
							{
								if (results.getAssertError() != null)
								{
									writeOnHtmlPage.write("var " + tc_id + " = '{\"TC\":[{\"testCaseName\":\"" + results.getTestCaseName() + "\",\"moduleName\":\""
										+ results.getModuleName() + "\",\"linkToScreenShot\":\"" + results.getLinkToScreenShot() + "\",\"summary\":\"" + results.getSummary()
										+ "\",\"result\":\"" + markPassFail(results.getResultOfTC()) + "\" }]}';");
								}
								// EXCEPTION
								else if (results.getException() != null)
								{
									writeOnHtmlPage.write("var " + tc_id + " = '{\"TC\":[{\"testCaseName\":\"" + results.getTestCaseName() + "\",\"moduleName\":\""
										+ results.getModuleName() + "\",\"linkToScreenShot\":\"" + results.getLinkToScreenShot() + "\",\"summary\":\"" + results.getSummary()
										+ "\",\"result\":\"" + markPassFail(results.getResultOfTC()) + "\" }]}';");
								}
							}

						}
						JSONObject jsonObject = new JSONObject(results.getTestData());
						writeOnHtmlPage.write("var map_" + tc_id + " = " + jsonObject + ";");
					}
				}
			}
			// writeOnHtmlPage.write("w.document.write(\"\";");
			writeOnHtmlPage.write("function openNewWindow(tc_id,map)");
			writeOnHtmlPage.write("{");
			writeOnHtmlPage.write("var w=window.open(\"\",\"Test Case Info\",\" scrollbars=yes,width=500,height=500,top=150,left=500\");");
			writeOnHtmlPage.write("w.document.open();");
			writeOnHtmlPage.write("var obj = $.parseJSON( eval (\"(\" + tc_id + \")\"));");
			writeOnHtmlPage.write("w.document.write(\"<table align=center border=1>\");");

			// writeOnHtmlPage.write("w.document.write(\"<tr><td>\");");
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(\"TESTCASE NAME :\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(obj['TC'][0]['testCaseName']);");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");

			// writeOnHtmlPage.write("w.document.write(\"<tr><td>\");");
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(\"MODULE NAME :\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(obj['TC'][0]['moduleName']);");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");
			//

			//
			// writeOnHtmlPage.write("w.document.write(\"<tr><td>\");");
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(\"TESTCASE SUMMARY :\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(obj['TC'][0]['summary']);");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");
			//

			//
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(\"TESTCASE RESULT :\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(obj['TC'][0]['result']);");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");
			// Writing Map of Json
			// writeOnHtmlPage.write("var jsonObj = $.parseJSON( eval (\"(\" +
			// map + \")\"));");
			writeOnHtmlPage.write("for (i in map) {");
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("var key = i;");
			writeOnHtmlPage.write("var val=map[i];");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(key +\":\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(val);");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");
			writeOnHtmlPage.write("}");
			//
			writeOnHtmlPage.write("w.document.write(\"<tr><td bgcolor=#D1D1D1>\");");
			writeOnHtmlPage.write("w.document.write(\"<b>\");");
			writeOnHtmlPage.write("w.document.write(\"SCREENSHOTS :\");");
			writeOnHtmlPage.write("w.document.write(\"</b>\");");
			writeOnHtmlPage.write("w.document.write(\"</td><td bgcolor=#FFE6CC>\");");
			writeOnHtmlPage.write("w.document.write(\"<a href=\"+obj['TC'][0]['linkToScreenShot']+\">CLICK</a>\");");
			writeOnHtmlPage.write("w.document.write(\"</td></tr>\");");
			//
			writeOnHtmlPage.write("w.document.write(\"</table>\");");
			writeOnHtmlPage.write("w.document.close();");
			writeOnHtmlPage.write("}");
			writeOnHtmlPage.write("</script>");
			writeOnHtmlPage.write("</head>");
			writeOnHtmlPage.write("<body>");
			//
			writeOnHtmlPage.write("<br><b><u><center>");
			if (suite_type.equalsIgnoreCase("regression") || !(suite_type.equalsIgnoreCase("sanity")))
			{
				writeOnHtmlPage.write("<h2>Regression Report for All browsers</h2></u>");
			}
			else
			{
				writeOnHtmlPage.write("<h2>Sanity Report for All browsers</h2><hr></u>");
			}
			writeOnHtmlPage.write("<br><b><u><center>");
			writeOnHtmlPage.write("<h3>Executed on : " + URL + "</h3></u>");

			writeOnHtmlPage.write("<table border=1 align=center>");
			writeOnHtmlPage.write("<tr bgcolor=#C2FFFF>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("BROWSER");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("PASSED");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("FAILED");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("SKIPPED");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("TOTAL");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("</tr>");
			MailReport.parseTestResultXML(false);
			/*
			 * for (TestSuiteResult suiteContent : MailReport.result) {
			 * writeOnHtmlPage.write("<tr>"); writeOnHtmlPage.write(
			 * "<td align=center>");
			 * writeOnHtmlPage.write(trimBrowserVersion(suiteContent.
			 * getBrowserVersion())); writeOnHtmlPage.write("</td>");
			 * writeOnHtmlPage.write("<td bgcolor=\"#ADEBAD\" align=center>");
			 * writeOnHtmlPage.write(Integer.toString(suiteContent.getPassed()))
			 * ; writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write(
			 * "<td bgcolor=\"#FFC2C2\" align=center>");
			 * writeOnHtmlPage.write(Integer.toString(suiteContent.getFailed()))
			 * ; writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write(
			 * "<td align=center>");
			 * writeOnHtmlPage.write(Integer.toString(suiteContent.getTotal()));
			 * writeOnHtmlPage.write("</td>"); writeOnHtmlPage.write("</tr>"); }
			 */

			for (Entry<String, Map<String, Integer>> map : tcsCountMap.entrySet())
			{
				writeOnHtmlPage.write("<tr>");
				writeOnHtmlPage.write("<td align=center>");
				writeOnHtmlPage.write(trimBrowserVersion(map.getKey()));
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("<td bgcolor=\"#ADEBAD\" align=center>");
				writeOnHtmlPage.write(Integer.toString(map.getValue().get("passedTcsCounter")));
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("<td bgcolor=\"#FFC2C2\" align=center>");
				writeOnHtmlPage.write(Integer.toString(map.getValue().get("failedTcsCounter")));
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("<td bgcolor=\"#FFC2C2\" align=center>");
				writeOnHtmlPage.write(Integer.toString(map.getValue().get("skippedTcsCounter")));
				writeOnHtmlPage.write("</td>");
				int total = map.getValue().get("passedTcsCounter") + map.getValue().get("failedTcsCounter") + map.getValue().get("skippedTcsCounter");
				writeOnHtmlPage.write("<td align=center>");
				writeOnHtmlPage.write(Integer.toString(total));
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("</tr>");
			}

			writeOnHtmlPage.write("</table>");
			writeOnHtmlPage.write("</center></b>");
			writeOnHtmlPage.write("<br>");
			writeOnHtmlPage.write("<table border=1 align=center>");
			writeOnHtmlPage.write("<tr bgcolor=#C2FFFF>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("Sr No");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("TESTCASE ID");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("SUMMARY");
			writeOnHtmlPage.write("</th>");

			for (int i = 0; i < browserName.size(); i++)
			{

				writeOnHtmlPage.write("<th>");
				/****/
				writeOnHtmlPage.write("<table border=\"0\">");
				writeOnHtmlPage.write("<th>");
				writeOnHtmlPage.write(browserName.get(i));
				writeOnHtmlPage.write("</th>");
				writeOnHtmlPage.write("<th>");
				writeOnHtmlPage.write(" | STATUS");
				writeOnHtmlPage.write("</th>");
				/****/
				writeOnHtmlPage.write("</table>");
				writeOnHtmlPage.write("</th>");
			}

			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("MAPPED TESTCASE");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("</tr>");
			int i = 0;
			for (Map.Entry<String, Map<String, LinkedList<TestResults>>> TC : testResults.entrySet())
			{
				writeOnHtmlPage.write("<tr>");
				// sr no
				writeOnHtmlPage.write("<td>");
				writeOnHtmlPage.write(Integer.toString(++i) + " )");
				writeOnHtmlPage.write("</td>");
				// tcs id
				writeOnHtmlPage.write("<td>");
				writeOnHtmlPage.write(TC.getKey());
				writeOnHtmlPage.write("</td>");
				// summary
				writeOnHtmlPage.write("<td>");
				if (SanityRegressionMapping.getSanityTC().containsKey(TC.getKey()))
				{
					writeOnHtmlPage.write(SanityRegressionMapping.getSanityTC().get(TC.getKey()));
				}
				else
				{
					writeOnHtmlPage.write(testResults.get(TC.getKey()).get(Startup.browserNames.get(0)).getFirst().getSummary());
				}
				writeOnHtmlPage.write("</td>");

				String mapTC = null;
				for (Map.Entry<String, LinkedList<TestResults>> testCaseData : TC.getValue().entrySet())
				{
					writeOnHtmlPage.write("<td>");
					writeOnHtmlPage.write("<table align=center,border=\"0\">");

					String stat = null;
					for (TestResults results : testCaseData.getValue())
					{
						String colorCode = null;
						boolean status = results.getResultOfTC();
						results.getBrowserVersionID();

						if (results.getResultOfTC())
						{
							colorCode = "#ADEBAD";
						}
						else
						{
							colorCode = "#FFC2C2";
						}

						results.isPrerequisiteMethod();
						mapTC = results.getParentTC();

						writeOnHtmlPage.write("<tr>");
						writeOnHtmlPage.write("<td bgcolor=" + colorCode + ">");
						writeOnHtmlPage.write("<a href='#' style=\"text-decoration:none\"; onclick=\"openNewWindow('" + results.getTestCaseName() + "_"
							+ results.getBrowserVersionID() + "'," + "map_" + results.getTestCaseName() + "_" + results.getBrowserVersionID() + ") \">");
						if (suite_type.equalsIgnoreCase("regression") || !(suite_type.equalsIgnoreCase("sanity")))
						{
							writeOnHtmlPage.write(markPassFail(status));
						}
						else
						{
							writeOnHtmlPage.write(results.getTestCaseName());
						}
						writeOnHtmlPage.write("</a>");
						writeOnHtmlPage.write("</td>");

						/** Change For Skipped Status **/
						stat = results.getStatus();
						/** Change For Skipped Status **/
						if (stat.trim().equalsIgnoreCase("SKIPPED"))
						{
							writeOnHtmlPage.write("<td bgcolor=\"#FFFF00\">");
							writeOnHtmlPage.write(stat.trim());
						}
						else
						{
							writeOnHtmlPage.write("<td bgcolor=\"#FFE6CE\">");
							writeOnHtmlPage.write(stat.trim());
						}
						writeOnHtmlPage.write("</td>");
						/** Change For Skipped Status **/
						/** Change For Skipped Status **/
						writeOnHtmlPage.write("</tr>");

					}
					writeOnHtmlPage.write("</table>");
					writeOnHtmlPage.write("</td>");

				} // end of outer for loop

				writeOnHtmlPage.write("<td align=center>");
				writeOnHtmlPage.write(mapTC);
				writeOnHtmlPage.write("</td>");
				writeOnHtmlPage.write("</tr>");

			}
			writeOnHtmlPage.write("</table>");
			writeOnHtmlPage.write("</div>");
			writeOnHtmlPage.write("</body>");
			writeOnHtmlPage.write("</html>");
			writeOnHtmlPage.close();
			Boolean success = sanityReport.exists();
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

	private static String markPassFail(boolean status)
	{
		if (status)
		{
			return "PASS |";
		}
		else
		{
			return "FAIL  |";

		}
	}
}
