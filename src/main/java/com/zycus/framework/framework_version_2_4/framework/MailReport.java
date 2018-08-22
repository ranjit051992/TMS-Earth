package com.zycus.framework.framework_version_2_4.framework;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.framework.framework_version_2_4.bo.TestCaseResult;
import com.zycus.framework.framework_version_2_4.bo.TestSuiteResult;

/**
 * Contains methods to send summary of TestCases run as mail to a list of
 * recipients.
 * 
 * @author aryasindhu.sahu
 *
 */
public class MailReport
{
	private static Logger				logger						= Logger.getLogger(MailReport.class);
	private static String				subject						= "{PRODUCT-NAME} : Total {TOTAL} TCs | Passed/Failed/Skipped {BROWSER-VERSION}:{PASSED}/{FAILED}/{SKIPPED} ";

	private static int					STATUS_FAIL_PERCENTAGE		= 90;
	private static int					STATUS_UNSTABLE_PERCENTAGE	= 50;
	private static int					STATUS_SUCCESS_PERCENTAGE	= 0;

	private static String				STATUS_FAIL					= " [FAILED]";
	private static String				STATUS_UNSTABLE				= " [UNSTABLE]";
	private static String				STATUS_SUCCESS				= " [SUCCESS]";

	private static int					totalCount					= 0, failCount = 0, skippedCount = 0;

	private static final String			TEST_SUITE					= "suite";
	private static final String			TEST_SUITE_NAME				= "name";

	private static final String			TEST						= "test";

	private static final String			TEST_CLASS					= "class";
	private static final String			TEST_CLASS_NAME				= "name";

	private static final String			TEST_METHOD					= "test-method";
	private static final String			TEST_METHOD_STATUS			= "status";
	private static final String			TEST_METHOD_NAME			= "name";
	private static final String			TEST_METHOD_STARTED_AT		= "started-at";
	private static final String			TEST_METHOD_FINISHED_AT		= "finished-at";

	private static final String			EXCEPTION_NODE				= "exception";
	private static final String			FULL_STACKTRACE_NODE		= "full-stacktrace";
	private static final String			PARAMS_NODE					= "params";
	private static final String			PARAM_NODE					= "param";
	private static final String			VALUE_NODE					= "value";
	private static final String			MESSAGE_NODE				= "message";

	public static List<TestSuiteResult>	result						= new ArrayList<TestSuiteResult>();
	private static String				productName					= null;
	private static String				productURL					= null;

	public static void main(String args[])
	{
		productName = args[0];
		try
		{
			productURL = ConfigProperty.getConfig("Product_URL").trim();
			String from = ConfigProperty.getConfig("MAIL_FROM").trim();
			// String host = "inmail.zycus.com";
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
				toAddress[index++] = new InternetAddress(recipient);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);
			message.setFrom(new InternetAddress(from));

			// String messageText = parseTestResultXML();
			String messageText = getMailContent();
			// String subject = getMailSubject();
			String subject = getMailSubject1();

			// write the mail html contents to file
			try
			{
				File outFile = new File("output/reports/mail-report.html");
				FileWriter fileWriter = new FileWriter(outFile);
				fileWriter.write("<html><head><title>" + subject + "</title></head><body>");
				fileWriter.write(messageText);
				fileWriter.write("</body></html>");
				fileWriter.close();
			}
			catch (Exception e)
			{
				logger.info("Error while writing mail html contents to a file.");
			}

			message.setSubject(subject);

			// COVER WRAP
			MimeBodyPart wrap = new MimeBodyPart();

			// ALTERNATIVE TEXT/HTML CONTENT
			MimeMultipart cover = new MimeMultipart("alternative");
			MimeBodyPart html = new MimeBodyPart();
			html.setContent(messageText, "text/html");
			cover.addBodyPart(html);
			wrap.setContent(cover);
			MimeMultipart content = new MimeMultipart("related");
			message.setContent(content);
			content.addBodyPart(wrap);

			String filename = "output/reports/" + getReportArtifactsFileName();
			String[] attachmentsFiles = new String[] { filename };

			StringBuilder sb = new StringBuilder();

			for (String attachmentFileName : attachmentsFiles)
			{
				String id = UUID.randomUUID().toString();
				sb.append("<img src=\"cid:");
				sb.append(id);
				sb.append("\" alt=\"ATTACHMENT\"/>\n");

				MimeBodyPart attachment = new MimeBodyPart();
				DataSource fds = new FileDataSource(attachmentFileName);
				attachment.setDataHandler(new DataHandler(fds));
				attachment.setHeader("Content-ID", "<" + id + ">");
				attachment.setFileName(fds.getName());
				content.addBodyPart(attachment);
			}

			message.setSentDate(new Date());
			Transport.send(message);
		}
		catch (Exception e)
		{
			logger.error("Error while sending mail: ", e);
		}
	}

	private static List<String> getMailRecipients()
	{
		List<String> recipients = new ArrayList<String>();
		String configRecipients = ConfigProperty.getConfig("MAIL_RECIPIENTS");
		StringTokenizer stringTokenizer = new StringTokenizer(configRecipients, ",");
		while (stringTokenizer.hasMoreTokens())
		{
			String recipient = stringTokenizer.nextToken().trim();
			recipients.add(recipient);
		}
		return recipients;
	}

	public static String parseTestResultXML()
	{
		String mailContent = "";
		File file = null;
		FileReader reader = null;

		String templateFilePath = "input/mail-template.html";
		String resultXMLFilePath = ConfigProperty.getConfig("testNG_Output_Directory") + "/testng-results.xml";
		if ("new".equalsIgnoreCase(ConfigProperty.getConfig("MAIL_REPORT_TYPE")) && Integer.parseInt(ConfigProperty.getConfig("RETRY_LIMIT")) > 0)
		{
			resultXMLFilePath = ConfigProperty.getConfig("testNG_Output_Directory") + "/testng-results-new.xml";
		}
		try
		{
			// Get template contents

			file = new File(templateFilePath); // for ex foo.txt
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			mailContent = new String(chars);

			// parse the xml file for result
			File resultXMLFile = new File(resultXMLFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(resultXMLFile);

			doc.getDocumentElement().normalize();

			// Get the Root Node i.e. :
			Element rootElement = doc.getDocumentElement();
			totalCount = Integer.parseInt(rootElement.getAttribute("total"));
			failCount = Integer.parseInt(rootElement.getAttribute("failed"));
			skippedCount = Integer.parseInt(rootElement.getAttribute("skipped"));

			NodeList suites = doc.getElementsByTagName(TEST_SUITE);
			for (int index = 0; index < suites.getLength(); index++)
			{
				// <suite>
				Node suite = suites.item(index);
				NamedNodeMap suiteAttributes = suite.getAttributes();
				Node suiteNameNode = suiteAttributes.getNamedItem(TEST_SUITE_NAME);
				TestSuiteResult testSuiteResult = new TestSuiteResult();
				// <suite name=""> ---> suiteNameNode.getNodeValue()
				testSuiteResult.setBrowserVersion(suiteNameNode.getNodeValue());

				// group, test, test, etc..
				NodeList suiteChildren = suite.getChildNodes();

				for (int suiteChildrenIndex = 0; suiteChildrenIndex < suiteChildren.getLength(); suiteChildrenIndex++)
				{
					// group or test
					Node testNode = suiteChildren.item(suiteChildrenIndex);

					if (testNode.getNodeType() == Node.ELEMENT_NODE)
					{
						String suiteChildName = testNode.getNodeName();
						if (TEST.equalsIgnoreCase(suiteChildName))
						{
							// Now we have the <test> Node i.e. : suiteChild
							// Get the classname of the testMethod

							NodeList classNodeList = testNode.getChildNodes();
							for (int i = 0; i < classNodeList.getLength(); i++)
							{
								Node classNode = classNodeList.item(i);
								if (classNode.getNodeType() == Node.ELEMENT_NODE)
								{
									String nodeTagName = classNode.getNodeName();
									// if node is <class>
									if (TEST_CLASS.equalsIgnoreCase(nodeTagName))
									{
										NamedNodeMap attrsMap = classNode.getAttributes();
										String testClassName = getElementAttribute(attrsMap, TEST_CLASS_NAME);

										// Loop over classNode's children for
										// <test-method>
										NodeList testMethodNodeList = classNode.getChildNodes();
										for (int testMethodIndex = 0; testMethodIndex < testMethodNodeList.getLength(); testMethodIndex++)
										{
											TestCaseResult testCaseResult = new TestCaseResult();
											// Set classname in TestCaseResult
											// as the name attribute of <class>
											testCaseResult.setTestClassName(testClassName);

											Node testMethodNode = testMethodNodeList.item(testMethodIndex);
											if (testMethodNode.getNodeType() == Node.ELEMENT_NODE)
											{
												String testMethodTagName = testMethodNode.getNodeName();
												// if node is <test-method>
												if (TEST_METHOD.equalsIgnoreCase(testMethodTagName))
												{
													NamedNodeMap testMethodAttrsMap = testMethodNode.getAttributes();
													// if method name !=
													// beforeClass or
													// beforeMethod or
													// beforeSuite etc...
													String testMethodName = getElementAttribute(testMethodAttrsMap, TEST_METHOD_NAME);
													if (!testMethodName.equals("beforeClass") && !testMethodName.equals("beforeMethod") && !testMethodName.equals("beforeSuite")
														&& !testMethodName.equals("beforeTest") && !testMethodName.equals("beforeGroups") && !testMethodName.equals("afterClass")
														&& !testMethodName.equals("afterMethod") && !testMethodName.equals("afterSuite") && !testMethodName.equals("afterTest")
														&& !testMethodName.equals("afterGroups"))
													{
														testCaseResult.setTestMethodName(testMethodName);
														testCaseResult.setTestStatus(getElementAttribute(testMethodAttrsMap, TEST_METHOD_STATUS));
														testCaseResult.setStartedAt(getElementAttribute(testMethodAttrsMap, TEST_METHOD_STARTED_AT));
														testCaseResult.setEndedAt(getElementAttribute(testMethodAttrsMap, TEST_METHOD_FINISHED_AT));

														/**
														 * Get the exception
														 * traces and messages
														 * from within the
														 * <test-method>
														 */

														// update total
														testSuiteResult.setTotal(testSuiteResult.getTotal() + 1);
														// Add the
														// TestCaseResult to the
														if (testCaseResult.getTestStatus().equals(TestCaseResult.STATUS_PASS))
														{
															// increment pass
															// count
															testSuiteResult.setPassed(testSuiteResult.getPassed() + 1);
															// add the passed
															// Test to
															// passedTestList
															List<TestCaseResult> passedTests = testSuiteResult.getPassedTests();
															passedTests.add(testCaseResult);
															testSuiteResult.setPassedTests(passedTests);
														}
														else if (testCaseResult.getTestStatus().equals(TestCaseResult.STATUS_FAIL))
														{
															// Add the exception
															// message and trace
															String exceptionMessage = getExceptionMessgae(testMethodNode);
															String exceptionTrace = getFullStackTrace(testMethodNode);
															testCaseResult.setExceptionMessage(exceptionMessage);
															testCaseResult.setExceptionTrace(exceptionTrace);
															// increment fail
															// count
															testSuiteResult.setFailed(testSuiteResult.getFailed() + 1);
															// add the failed
															// Test to
															// failedTestList
															List<TestCaseResult> FailedTests = testSuiteResult.getFailedTests();
															FailedTests.add(testCaseResult);
															testSuiteResult.setFailedTests(FailedTests);
														}
														else if (testCaseResult.getTestStatus().equals(TestCaseResult.STATUS_SKIPPED))
														{
															testSuiteResult.setSkipped(testSuiteResult.getSkipped() + 1);
															List<TestCaseResult> skippedTests = testSuiteResult.getSkippedTests();
															skippedTests.add(testCaseResult);
															testSuiteResult.setSkippedTests(skippedTests);
														}
													}
												} // end of <test-method>
											}
										} // end of loop over <test-method>
									}
								}
							} // end of loop over <class>
						}
					}
				} // end of loop over <suite>
				result.add(testSuiteResult);
			}
			mailContent = mailContent.replace("{PRODUCT}", productName);
			mailContent = mailContent.replace("{PRODUCT_URL}", productURL);

			String templateRowContent = mailContent.substring(mailContent.indexOf("<tr id="), 5 + mailContent.lastIndexOf("</tr>"));

			String finalRowContent = "";
			String failedTestCases = "";
			String skippedTestCases = "";
			for (TestSuiteResult eachSuite : result)
			{
				String suiteRowContent = templateRowContent;
				suiteRowContent = suiteRowContent.replace("{BROWSER-VERSION}", trimBrowserVersion(eachSuite.getBrowserVersion()));
				suiteRowContent = suiteRowContent.replace("{TOTAL}", "" + eachSuite.getTotal());
				suiteRowContent = suiteRowContent.replace("{PASSED}", "" + eachSuite.getPassed());
				suiteRowContent = suiteRowContent.replace("{FAILED}", "" + eachSuite.getFailed());
				suiteRowContent = suiteRowContent.replace("{SKIPPED}", "" + eachSuite.getSkipped());

				finalRowContent += suiteRowContent;

				if (eachSuite.getFailedTests().size() != 0)
				{
					failedTestCases += "<table style=\"background-color:#F6CED8;\" border=\"1\" width=\"50%\">";
					failedTestCases += "<tr style=\"background-color:#F7819F; color:black; font-weight:bold;\"><td colspan=\"3\" align=\"left\">Failed TestCases in "
						+ trimBrowserVersion(eachSuite.getBrowserVersion()) + "</td></tr>";
					failedTestCases += "<tr>" + "<th>Serial No.</th>" + "<th>TestCase</th>" + "<th>Failure Message</th>" + "</tr>";
				}
				int serialNo = 0;
				for (TestCaseResult failedTestResult : eachSuite.getFailedTests())
				{
					failedTestCases += "<tr>";
					failedTestCases += "<td>" + ++serialNo + "</td>";
					failedTestCases += "<td>" + failedTestResult.getTestMethodName() + "</td>";
					String exceptionMessage = failedTestResult.getExceptionMessage();
					if (exceptionMessage.length() > 0)
					{
						failedTestCases += "<td>"
							+ exceptionMessage.substring(0, exceptionMessage.length() > 300 ? 300 : (exceptionMessage.length() == 0 ? 0 : exceptionMessage.length() - 1))
							+ (exceptionMessage.length() > 300 ? "..." : "") + "</td>";
					}
					else
					{
						failedTestCases += "<td>&nbsp;</td>";
					}
					failedTestCases += "</tr>";
				}
				if (failedTestCases.length() != 0)
				{
					failedTestCases += "</table><br/>";
				}

				if (eachSuite.getSkippedTests().size() != 0)
				{
					skippedTestCases += "<table style=\"background-color:#F6CED8;\" border=\"1\" width=\"50%\">";
					skippedTestCases += "<tr style=\"background-color:#F7819F; color:black; font-weight:bold;\"><td colspan=\"3\" align=\"left\">Skipped TestCases in "
						+ trimBrowserVersion(eachSuite.getBrowserVersion()) + "</td></tr>";
					skippedTestCases += "<tr>" + "<th>Serial No.</th>" + "<th>TestCase</th>" + "<th>Skipped Message</th>" + "</tr>";
				}
				serialNo = 0;
				for (TestCaseResult skippedTestResult : eachSuite.getSkippedTests())
				{
					skippedTestCases += "<tr>";
					skippedTestCases += "<td>" + ++serialNo + "</td>";
					skippedTestCases += "<td>" + skippedTestResult.getTestMethodName() + "</td>";
					skippedTestCases += "<td>&nbsp;</td>";
					skippedTestCases += "</tr>";
				}
				if (skippedTestCases.length() != 0)
				{
					skippedTestCases += "</table><br/>";
				}
			}

			mailContent = mailContent.replace("<div id=\"failed_report\"></div>", failedTestCases).replace(templateRowContent, finalRowContent);

		}
		catch (Exception e)
		{
			logger.error("Error while parsing report result XML :", e);
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
		return mailContent;
	}

	private static String getElementAttribute(NamedNodeMap attrMap, String attrName)
	{
		Node attrNode = attrMap.getNamedItem(attrName);
		if (attrNode == null)
		{
			return null;
		}
		else
		{
			return attrNode.getNodeValue();
		}
	}

	public static String trimBrowserVersion(String browserVersion)
	{
		if (browserVersion.contains("Internet Explorer"))
		{
			return browserVersion.replace("-" + productName + "_TestSuite", "").replace("Internet Explorer", "IE");
		}
		else if (browserVersion.contains("Firefox"))
		{
			return browserVersion.replace("-" + productName + "_TestSuite", "").replace("Firefox", "FF");
		}
		else
		{
			return browserVersion.replace("-" + productName + "_TestSuite", "");
		}
	}

	private static String getReportArtifactsFileName()
	{
		String fileName = "";
		File dir = new File("output/reports");
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".zipp");
			}
		};
		String[] children = dir.list(filter);
		if (children == null)
		{
			logger.error("Either dir:" + dir.getName() + " does not exist or is not a directory");
		}
		else
		{
			fileName = children[0];
		}
		return fileName;
	}

	private static String getFullStackTrace(Node testMethodNode)
	{
		String exceptionMessage = "";
		NodeList testMethodNodeList = testMethodNode.getChildNodes();
		for (int testMethodIndex = 0; testMethodIndex < testMethodNodeList.getLength(); testMethodIndex++)
		{
			Node exceptionNode = testMethodNodeList.item(testMethodIndex);
			if (exceptionNode.getNodeType() == Node.ELEMENT_NODE)
			{
				String exceptionTagName = exceptionNode.getNodeName();
				// if node is <exception>
				if (EXCEPTION_NODE.equalsIgnoreCase(exceptionTagName))
				{
					NodeList fullStackTraceNodeList = exceptionNode.getChildNodes();
					for (int messageNodeIndex = 0; messageNodeIndex < fullStackTraceNodeList.getLength(); messageNodeIndex++)
					{
						Node fullStackTraceNode = fullStackTraceNodeList.item(messageNodeIndex);
						if (fullStackTraceNode.getNodeType() == Node.ELEMENT_NODE)
						{
							String fullStackTraceTagName = fullStackTraceNode.getNodeName();
							// if node is <message>
							if (FULL_STACKTRACE_NODE.equalsIgnoreCase(fullStackTraceTagName))
							{
								exceptionMessage = getCharacterDataFromElement(fullStackTraceNode);
							}
						}
					}
				}
			}
		}
		return exceptionMessage;
	}

	private static String getCharacterDataFromElement(Node node)
	{
		String cDataText = null;
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			if (nodeList.item(i).getNodeType() == Node.CDATA_SECTION_NODE)
			{
				cDataText = nodeList.item(i).getNodeValue().trim();
				break;
			}
		}
		return cDataText;
	}

	protected static String parseTestResultXML(boolean isCallFromMain)
	{
		String mailContent = "";
		File file = null;
		FileReader reader = null;

		String templateFilePath = "input/mail-template.html";
		String resultXMLFilePath = ConfigProperty.getConfig("testNG_Output_Directory") + "/testng-results.xml";
		if ("new".equalsIgnoreCase(ConfigProperty.getConfig("MAIL_REPORT_TYPE")) && Integer.parseInt(ConfigProperty.getConfig("RETRY_LIMIT")) > 0)
		{
			resultXMLFilePath = ConfigProperty.getConfig("testNG_Output_Directory") + "/testng-results-new.xml";
		}
		try
		{
			// Get template contents

			file = new File(templateFilePath); // for ex foo.txt
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			mailContent = new String(chars);

			// parse the xml file for result
			File resultXMLFile = new File(resultXMLFilePath);
			// InputStream inputStream= new FileInputStream(resultXMLFile);
			// Reader xmlReader = new InputStreamReader(inputStream,"UTF-8");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(resultXMLFile);

			doc.getDocumentElement().normalize();

			// Get the Root Node i.e. :
			Element rootElement = doc.getDocumentElement();
			totalCount = Integer.parseInt(rootElement.getAttribute("total"));
			failCount = Integer.parseInt(rootElement.getAttribute("failed"));

			NodeList suites = doc.getElementsByTagName(TEST_SUITE);
			for (int index = 0; index < suites.getLength(); index++)
			{
				// <suite>
				Node suite = suites.item(index);
				NamedNodeMap suiteAttributes = suite.getAttributes();
				Node suiteNameNode = suiteAttributes.getNamedItem(TEST_SUITE_NAME);
				TestSuiteResult testSuiteResult = new TestSuiteResult();
				// <suite name=""> ---> suiteNameNode.getNodeValue()
				testSuiteResult.setBrowserVersion(suiteNameNode.getNodeValue());

				// group, test, test, etc..
				NodeList suiteChildren = suite.getChildNodes();

				for (int suiteChildrenIndex = 0; suiteChildrenIndex < suiteChildren.getLength(); suiteChildrenIndex++)
				{
					// group or test
					Node testNode = suiteChildren.item(suiteChildrenIndex);

					if (testNode.getNodeType() == Node.ELEMENT_NODE)
					{
						String suiteChildName = testNode.getNodeName();
						if (TEST.equalsIgnoreCase(suiteChildName))
						{
							// Now we have the <test> Node i.e. : suiteChild
							// Get the classname of the testMethod

							NodeList classNodeList = testNode.getChildNodes();
							for (int i = 0; i < classNodeList.getLength(); i++)
							{
								Node classNode = classNodeList.item(i);
								if (classNode.getNodeType() == Node.ELEMENT_NODE)
								{
									String nodeTagName = classNode.getNodeName();
									// if node is <class>
									if (TEST_CLASS.equalsIgnoreCase(nodeTagName))
									{
										NamedNodeMap attrsMap = classNode.getAttributes();
										String testClassName = getElementAttribute(attrsMap, TEST_CLASS_NAME);

										// Loop over classNode's children for
										// <test-method>
										NodeList testMethodNodeList = classNode.getChildNodes();
										for (int testMethodIndex = 0; testMethodIndex < testMethodNodeList.getLength(); testMethodIndex++)
										{
											TestCaseResult testCaseResult = new TestCaseResult();
											// Set classname in TestCaseResult
											// as the name attribute of <class>
											testCaseResult.setTestClassName(testClassName);

											Node testMethodNode = testMethodNodeList.item(testMethodIndex);
											if (testMethodNode.getNodeType() == Node.ELEMENT_NODE)
											{
												String testMethodTagName = testMethodNode.getNodeName();
												// if node is <test-method>
												if (TEST_METHOD.equalsIgnoreCase(testMethodTagName))
												{
													NamedNodeMap testMethodAttrsMap = testMethodNode.getAttributes();
													// if method name !=
													// beforeClass or
													// beforeMethod or
													// beforeSuite etc...
													String testMethodName = getElementAttribute(testMethodAttrsMap, TEST_METHOD_NAME);
													if (!testMethodName.equals("beforeClass") && !testMethodName.equals("beforeMethod") && !testMethodName.equals("beforeSuite")
														&& !testMethodName.equals("beforeTest") && !testMethodName.equals("beforeGroups") && !testMethodName.equals("afterClass")
														&& !testMethodName.equals("afterMethod") && !testMethodName.equals("afterSuite") && !testMethodName.equals("afterTest")
														&& !testMethodName.equals("afterGroups"))
													{
														testCaseResult.setTestMethodName(testMethodName);
														testCaseResult.setTestStatus(getElementAttribute(testMethodAttrsMap, TEST_METHOD_STATUS));
														testCaseResult.setStartedAt(getElementAttribute(testMethodAttrsMap, TEST_METHOD_STARTED_AT));
														testCaseResult.setEndedAt(getElementAttribute(testMethodAttrsMap, TEST_METHOD_FINISHED_AT));

														/**
														 * Get the exception
														 * traces and messages
														 * from within the
														 * <test-method>
														 */

														// update total
														testSuiteResult.setTotal(testSuiteResult.getTotal() + 1);
														// Add the
														// TestCaseResult to the
														if (testCaseResult.getTestStatus().equals(TestCaseResult.STATUS_PASS))
														{
															// increment pass
															// count
															testSuiteResult.setPassed(testSuiteResult.getPassed() + 1);
															// add the passed
															// Test to
															// passedTestList
															List<TestCaseResult> passedTests = testSuiteResult.getPassedTests();
															passedTests.add(testCaseResult);
															testSuiteResult.setPassedTests(passedTests);
														}
														else if (testCaseResult.getTestStatus().equals(TestCaseResult.STATUS_FAIL))
														{
															// Add the exception
															// message and trace
															String exceptionMessage = getExceptionMessgae(testMethodNode);
															String exceptionTrace = getFullStackTrace(testMethodNode);
															testCaseResult.setExceptionMessage(exceptionMessage);
															testCaseResult.setExceptionTrace(exceptionTrace);
															// increment fail
															// count
															testSuiteResult.setFailed(testSuiteResult.getFailed() + 1);
															// add the passed
															// Test to
															// passedTestList
															List<TestCaseResult> FailedTests = testSuiteResult.getFailedTests();
															FailedTests.add(testCaseResult);
															testSuiteResult.setFailedTests(FailedTests);
														}
													}
												} // end of <test-method>
											}
										} // end of loop over <test-method>
									}
								}
							} // end of loop over <class>
						}
					}
				} // end of loop over <suite>
				result.add(testSuiteResult);
			}
			if (isCallFromMain)
			{
				mailContent = mailContent.replace("{PRODUCT}", productName);
				String templateRowContent = mailContent.substring(mailContent.indexOf("<tr id="), 5 + mailContent.lastIndexOf("</tr>"));

				String finalRowContent = "";
				String failedTestCases = "";
				for (TestSuiteResult eachSuite : result)
				{
					String suiteRowContent = templateRowContent;
					suiteRowContent = suiteRowContent.replace("{BROWSER-VERSION}", trimBrowserVersion(eachSuite.getBrowserVersion()));
					suiteRowContent = suiteRowContent.replace("{TOTAL}", "" + eachSuite.getTotal());
					suiteRowContent = suiteRowContent.replace("{PASSED}", "" + eachSuite.getPassed());
					suiteRowContent = suiteRowContent.replace("{FAILED}", "" + eachSuite.getFailed());

					finalRowContent += suiteRowContent;

					if (eachSuite.getFailedTests().size() != 0)
					{
						failedTestCases += "<table style=\"background-color:#F6CED8;\" border=\"1\" width=\"50%\">";
						failedTestCases += "<tr style=\"background-color:#F7819F; color:black; font-weight:bold;\"><td colspan=\"3\" align=\"left\">Failed TestCases in "
							+ trimBrowserVersion(eachSuite.getBrowserVersion()) + "</td></tr>";
						failedTestCases += "<tr>" + "<th>Serial No.</th>" + "<th>TestCase</th>" + "<th>Failure Message</th>" + "</tr>";
					}
					int serialNo = 0;
					for (TestCaseResult failedTestResult : eachSuite.getFailedTests())
					{
						failedTestCases += "<tr>";
						failedTestCases += "<td>" + ++serialNo + "</td>";
						failedTestCases += "<td>" + failedTestResult.getTestMethodName() + "</td>";
						String exceptionMessage = failedTestResult.getExceptionMessage();
						if (exceptionMessage.length() > 0)
						{
							failedTestCases += "<td>"
								+ exceptionMessage.substring(0, exceptionMessage.length() > 300 ? 300 : (exceptionMessage.length() == 0 ? 0 : exceptionMessage.length() - 1))
								+ (exceptionMessage.length() > 300 ? "..." : "") + "</td>";
						}
						else
						{
							failedTestCases += "<td>&nbsp;</td>";
						}
						failedTestCases += "</tr>";
					}
					if (failedTestCases.length() != 0)
					{
						failedTestCases += "</table><br/>";
					}
				}

				mailContent = mailContent.replace("<div id=\"failed_report\"></div>", failedTestCases).replace(templateRowContent, finalRowContent);
			}
		}
		catch (Exception e)
		{
			logger.error("Error while parsing report result XML :", e);
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
		return mailContent;
	}

	private static String getParams(Node testMethodNode)
	{
		String paramValue = "";
		NodeList testMethodNodeList = testMethodNode.getChildNodes();
		for (int testMethodIndex = 0; testMethodIndex < testMethodNodeList.getLength(); testMethodIndex++)
		{
			Node paramsNode = testMethodNodeList.item(testMethodIndex);
			if (paramsNode.getNodeType() == Node.ELEMENT_NODE)
			{
				String paramsTagName = paramsNode.getNodeName();
				// if node is <exception>
				if (PARAMS_NODE.equalsIgnoreCase(paramsTagName))
				{
					NodeList paramsNodeList = paramsNode.getChildNodes();
					for (int paramsNodeIndex = 0; paramsNodeIndex < paramsNodeList.getLength(); paramsNodeIndex++)
					{
						Node paramNode = paramsNodeList.item(paramsNodeIndex);
						if (paramNode.getNodeType() == Node.ELEMENT_NODE)
						{
							String paramTagName = paramNode.getNodeName();
							// if node is <exception>
							if (PARAM_NODE.equalsIgnoreCase(paramTagName))
							{
								NodeList paramNodeList = paramNode.getChildNodes();
								for (int paramNodeIndex = 0; paramNodeIndex < paramNodeList.getLength(); paramNodeIndex++)
								{
									Node valueNode = paramNodeList.item(paramNodeIndex);
									if (valueNode.getNodeType() == Node.ELEMENT_NODE)
									{
										String valueTagName = paramNode.getNodeName();
										// if node is <exception>
										if (VALUE_NODE.equalsIgnoreCase(valueTagName))
										{
											paramValue = getCharacterDataFromElement(paramNode);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return paramValue;
	}

	public static String getMailContent()
	{
		String mailContent = "";
		File file = null;
		FileReader reader = null;

		String templateFilePath = "output/reports/MailContentReport.html";
		try
		{
			// Get contents from MailContentReport.html
			file = new File(templateFilePath);
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			mailContent = new String(chars);
		}
		catch (Exception e)
		{
			logger.error("Error while parsing report MailContentReport.html :", e);
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
		return mailContent;
	}

	private static String getMailSubject1()
	{
		// Subject Format : productName : Total X TCs | Passed/Failed (B-V:a/b,
		// B'-V':c/d)
		String mailSubject = subject;
		String templateSubjectContent = "{BROWSER-VERSION}:{PASSED}/{FAILED}/{SKIPPED} ";
		String finalSubjectContent = "(";
		String total = "";
		List<TestSuiteResult> results = ExcelReader.readSummaryReportResult();
		for (TestSuiteResult eachSuite : results)
		{
			total = String.valueOf(eachSuite.getTotal());
			String suiteSubjectContent = templateSubjectContent;
			suiteSubjectContent = suiteSubjectContent.replace("{BROWSER-VERSION}", trimBrowserVersion(eachSuite.getBrowserVersion()));
			suiteSubjectContent = suiteSubjectContent.replace("{PASSED}", "" + eachSuite.getPassed());
			suiteSubjectContent = suiteSubjectContent.replace("{FAILED}", "" + eachSuite.getFailed());
			suiteSubjectContent = suiteSubjectContent.replace("{SKIPPED}", "" + eachSuite.getSkipped());
			finalSubjectContent += suiteSubjectContent + ", ";
		}
		String subjectAndStatus = productName;
		double failPercent = ((double) failCount / (double) totalCount) * 100.0;
		if (failPercent >= STATUS_FAIL_PERCENTAGE)
		{
			subjectAndStatus += STATUS_FAIL;
		}
		else if (failPercent >= STATUS_UNSTABLE_PERCENTAGE && failPercent < STATUS_FAIL_PERCENTAGE)
		{
			subjectAndStatus += STATUS_UNSTABLE;
		}
		else if (failPercent >= STATUS_SUCCESS_PERCENTAGE && failPercent < STATUS_UNSTABLE_PERCENTAGE)
		{
			subjectAndStatus += STATUS_SUCCESS;
		}

		return mailSubject.replace("{PRODUCT-NAME}", subjectAndStatus).replace("{TOTAL}", total).replace(templateSubjectContent,
			finalSubjectContent.substring(0, finalSubjectContent.length() - 2) + ")");
	}

	private static String getExceptionMessgae(Node testMethodNode)
	{
		String exceptionMessage = "";
		NodeList testMethodNodeList = testMethodNode.getChildNodes();
		for (int testMethodIndex = 0; testMethodIndex < testMethodNodeList.getLength(); testMethodIndex++)
		{
			Node exceptionNode = testMethodNodeList.item(testMethodIndex);
			if (exceptionNode.getNodeType() == Node.ELEMENT_NODE)
			{
				String exceptionTagName = exceptionNode.getNodeName();
				// if node is <exception>
				if (EXCEPTION_NODE.equalsIgnoreCase(exceptionTagName))
				{
					NodeList messageNodeList = exceptionNode.getChildNodes();
					for (int messageNodeIndex = 0; messageNodeIndex < messageNodeList.getLength(); messageNodeIndex++)
					{
						Node messageNode = messageNodeList.item(messageNodeIndex);
						if (messageNode.getNodeType() == Node.ELEMENT_NODE)
						{
							String messageTagName = messageNode.getNodeName();
							// if node is <message>
							if (MESSAGE_NODE.equalsIgnoreCase(messageTagName))
							{
								exceptionMessage = getCharacterDataFromElement(messageNode);
							}
							else if (FULL_STACKTRACE_NODE.equalsIgnoreCase(messageTagName))
							{
								exceptionMessage = getCharacterDataFromElement(messageNode);
							}
						}
					}
				}
			}
		}
		return exceptionMessage;
	}
}
