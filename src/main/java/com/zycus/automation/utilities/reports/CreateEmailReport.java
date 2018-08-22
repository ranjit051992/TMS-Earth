/**
 * 
 */

package com.zycus.automation.utilities.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.zycus.automation.bo.EmailDetails;
import com.zycus.automation.bo.FileAttachment;

/**
 * @author ankita.sawant
 *
 */

public class CreateEmailReport
{
	static Logger										logger			= Logger.getLogger(CreateEmailReport.class);
	public static Map<String, LinkedList<EmailDetails>>	emailResultMap	= new HashMap<>();

	private static String								destPath		= "output/reports/";
	private static String								fileName		= "EmailReport.html";

	public static void createEmailReoprt() throws Exception
	{
		File emailReport = new File(destPath + fileName);
		try
		{
			logger.info("#######################--GENERATING REPORT--#######################");
			BufferedWriter writeOnHtmlPage = new BufferedWriter(new FileWriter(emailReport));
			writeOnHtmlPage.write("<!DOCTYPE html>");
			writeOnHtmlPage.write("<html>");
			writeOnHtmlPage.write("<head>");
			// writeOnHtmlPage.write("Email Report");
			writeOnHtmlPage.write("</head>");
			writeOnHtmlPage.write("<body>");
			//
			writeOnHtmlPage.write("<br><b><u><center>");
			writeOnHtmlPage.write("<h2>Email Report</h2><hr></u>");

			writeOnHtmlPage.write("</center></b>");
			writeOnHtmlPage.write("<br>");
			writeOnHtmlPage.write("<table border=1>");
			writeOnHtmlPage.write("<tr bgcolor=#C2FFFF>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("Sr No");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("TESTCASE ID");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("EVENT NAME");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("SUBJECT");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("BODY");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("ERRORS IN SUBJECT");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("<th>");
			writeOnHtmlPage.write("ERRORS IN BODY");
			writeOnHtmlPage.write("</th>");
			writeOnHtmlPage.write("</tr>");
			int i = 0, k = 1, noOfRowsSpan;
			String colorCode_forSubject = "", colorCode_forBody = "";
			for (Entry<String, LinkedList<EmailDetails>> map : emailResultMap.entrySet())
			{
				noOfRowsSpan = map.getValue().size();
				writeOnHtmlPage.write("<tr>");
				// sr no
				writeOnHtmlPage.write("<td rowspan =" + noOfRowsSpan + ">");
				writeOnHtmlPage.write(Integer.toString(++i) + " )");
				writeOnHtmlPage.write("</td>");
				// tcs id
				writeOnHtmlPage.write("<td rowspan =" + noOfRowsSpan + ">");
				writeOnHtmlPage.write(map.getKey());
				writeOnHtmlPage.write("</td>");

				for (EmailDetails emailDetails : map.getValue())
				{
					if (emailDetails != null)
					{
						if (k != 1)
						{
							writeOnHtmlPage.write("<tr>");
						}

						// to decide color code for Subject
						if (emailDetails.getEmailResultForSubject().isResult())
						{
							colorCode_forSubject = "#ADEBAD";
						}
						else
						{
							colorCode_forSubject = "#FFC2C2";
						}

						// to decide color code for Body
						if (emailDetails.getEmailResultForBody().isResult())
						{
							colorCode_forBody = "#ADEBAD";
						}
						else
						{
							colorCode_forBody = "#FFC2C2";
						}

						// Event name
						writeOnHtmlPage.write("<td>");
						if (emailDetails.getEventType() != null)
						{
							writeOnHtmlPage.write(emailDetails.getEventType());
						}
						else
						{
							writeOnHtmlPage.write("NA");
						}
						writeOnHtmlPage.write("</td>");

						// subject name
						writeOnHtmlPage.write("<td bgcolor=" + colorCode_forSubject + ">");
						if (emailDetails.getSubject() != null)
						{
							writeOnHtmlPage.write(emailDetails.getSubject());
						}
						else
						{
							writeOnHtmlPage.write("NA");
						}
						writeOnHtmlPage.write("</td>");

						// email body
						writeOnHtmlPage.write("<td bgcolor=" + colorCode_forBody + ">");
						if (emailDetails.getEmailBody() != null)
						{
							writeOnHtmlPage.write(emailDetails.getEmailBody());
							// for attachments in body
							if (emailDetails.getAttachments() != null)
							{
								if (emailDetails.getAttachments().size() > 0)
								{
									writeOnHtmlPage.write("\n Attachments : ");
									for (FileAttachment attachment : emailDetails.getAttachments())
									{
										writeOnHtmlPage.write("\n" + attachment.getFileName());
									}
								}
							}
						}
						else
						{
							writeOnHtmlPage.write("NA");
						}
						writeOnHtmlPage.write("</td>");

						// ERROR IN SUBJECT
						writeOnHtmlPage.write("<td bgcolor=" + colorCode_forSubject + ">");
						if (emailDetails.getEmailResultForSubject().getMessage() != null)
						{
							writeOnHtmlPage.write(emailDetails.getEmailResultForSubject().getMessage());
						}
						else
						{
							writeOnHtmlPage.write("NA");
						}
						writeOnHtmlPage.write("</td>");

						// ERROR IN BODY
						writeOnHtmlPage.write("<td bgcolor=" + colorCode_forBody + ">");
						if (emailDetails.getEmailResultForBody().getMessage() != null)
						{
							writeOnHtmlPage.write(emailDetails.getEmailResultForBody().getMessage());
						}
						else
						{
							writeOnHtmlPage.write("NA");
						}
						writeOnHtmlPage.write("</td>");

						writeOnHtmlPage.write("</tr>");
					}
				}
				writeOnHtmlPage.write("</tr>");
			}
			writeOnHtmlPage.write("</table>");
			writeOnHtmlPage.write("</div>");
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
