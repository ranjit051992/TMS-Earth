/**
 * 
 */
package com.zycus.automation.integration.testopia;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.Helper;


/**
 * @author ankita.sawant
 *
 */

public class MailExecutionStatus
{
	private static Logger logger = Logger.getLogger(MailExecutionStatus.class);

	public static void sendMail()
	{
		try
		{
			logger.info("Sending Mail .....");
			String from = ConfigProperty.getConfig("MAIL_FROM").trim();
			String host = ConfigProperty.getConfig("Mail_Server_Host_Name").trim();
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			List<String> mailRecipients = getMailRecipients();
			InternetAddress[] toAddress = new InternetAddress[mailRecipients.size()];
			int index = 0;
			for (String recipient : getMailRecipients())
			{
				toAddress[(index++)] = new InternetAddress(recipient);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);
			message.setFrom(new InternetAddress(from));

			String messageText = getMailMessage();
			String subject = getMailSubject();

			message.setSubject(subject);

			MimeBodyPart wrap = new MimeBodyPart();

			MimeMultipart cover = new MimeMultipart("alternative");
			MimeBodyPart html = new MimeBodyPart();
			html.setContent(messageText, "text/html");
			cover.addBodyPart(html);
			wrap.setContent(cover);
			MimeMultipart content = new MimeMultipart("related");
			message.setContent(content);
			content.addBodyPart(wrap);

			String filename = new StringBuilder().append("output/htmlContent.html").toString();
			String[] attachmentsFiles = { filename };

			for (String attachmentFileName : attachmentsFiles)
			{
				String id = UUID.randomUUID().toString();

				MimeBodyPart attachment = new MimeBodyPart();
				DataSource fds = new FileDataSource(attachmentFileName);
				attachment.setDataHandler(new DataHandler(fds));
				attachment.setHeader("Content-ID", new StringBuilder().append("<").append(id).append(">").toString());
				attachment.setFileName(fds.getName());
				content.addBodyPart(attachment);
			}

			message.setSentDate(new Date());
			Transport.send(message);
			logger.info("Sent mail successfully....");
		}
		catch (Exception e)
		{
			logger.error("Error while sending mail: " + e, e);
		}
	}

	private static List<String> getMailRecipients()
	{
		List<String> recipients = new ArrayList<String>();
		String configRecipients = Helper.returnKeyValuePair("MAIL_RECIPIENTS");
		StringTokenizer stringTokenizer = new StringTokenizer(configRecipients, ",");
		while (stringTokenizer.hasMoreTokens())
		{
			String recipient = stringTokenizer.nextToken().trim();
			recipients.add(recipient);
		}
		return recipients;
	}

	private static String getMailSubject()
	{
		String subject = "eProc_Automation(" + Helper.returnKeyValuePair("SUITE_TYPE") + ") Testopia Execution Status | No.of FAILED TesCases : "
			+ TestopiaIntegration.getFailedTestCases().size();

		return subject;
	}

	private static String getMailMessage() throws Exception
	{
		FileReader reader = null;
		String mailMessage = null;
		File file = null;
		try
		{
			file = new File("input/mailContent.html");
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);

			mailMessage = new String(chars);

			mailMessage = mailMessage.replace("{Execution Percentage}", TestopiaIntegration.getExecutionPercentage());
			mailMessage = mailMessage.replace("{FAILED}", Integer.toString(TestopiaIntegration.getFailedTestCases().size()));
			mailMessage = mailMessage.replace("{PASS-FAIL}", Integer.toString(TestopiaIntegration.getPassToFail().size()));
			mailMessage = mailMessage.replace("{FAIL-PASS}", Integer.toString(TestopiaIntegration.getFailToPass().size()));
		}
		catch (Exception e)
		{
			logger.info("Error while reading file", e);
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e1)
				{
				}
			}
		}

		return mailMessage;
	}
}
