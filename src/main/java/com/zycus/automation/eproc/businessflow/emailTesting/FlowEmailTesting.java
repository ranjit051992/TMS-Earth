/**
 * 
 */
package com.zycus.automation.eproc.businessflow.emailTesting;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.DocumentInformation;
import com.zycus.automation.bo.EmailDetails;
import com.zycus.automation.bo.EmailResult;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.eproc.testdata.IEmailTestingConstants;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 *
 */
public class FlowEmailTesting
{
	static Logger			logger								= Logger.getLogger(FlowEmailTesting.class);
	public static String	Email_Body_For_Requisition			= null;
	public static String	Email_Body_For_PO					= null;
	public static String	Email_Body_For_BuyersDesk			= null;
	public static String	Email_Body_For_PO_Released			= null;
	public static String	Email_Body_For_Item_Row_Template	= null;

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To read email from subject <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param emailDetails </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */
	public static EmailDetails readEmail(EmailDetails emailDetails) throws Exception
	{
		EmailDetails emailDetails2 = new EmailDetails();
		try
		{
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("outlook.office365.com", emailDetails.getUsername(), emailDetails.getPassword());

			emailDetails2.setUsername(emailDetails.getUsername());
			emailDetails2.setPassword(emailDetails.getPassword());

			// to get folder
			Folder testEmailFolder = store.getFolder(emailDetails.getFolderName());
			testEmailFolder.open(Folder.READ_WRITE);
			// to get all msgs
			Message[] messages = testEmailFolder.getMessages();
			Message message1 = null;
			// to find message of particular subject
			for (int i = messages.length; i != 0; i--)
			{
				Message message = messages[i - 1];
				// logger.info("@@@@@@@@@@@@@@@@@ Subject : " +
				// message.getSubject() + " @@@@@@@@@@@@@@@@@");
				if (message.getSubject().contains(emailDetails.getSubject()))
				{
					message1 = message;
					break;
				}
			}
			if (message1 != null)
			{
				MimeMessage recentMessage = (MimeMessage) message1;
				logger.info("Subject of found mail : " + recentMessage.getSubject());
				emailDetails2.setSubject(message1.getSubject());
				emailDetails2.setMessage(recentMessage);
			}
			else
			{
				logger.info("Mail with subject " + emailDetails.getSubject() + " was not found");
			}
			return emailDetails2;
		}
		catch (MessagingException e)
		{
			throw new MessagingException("Messaging Exception while reading email from outlook : Email with " + emailDetails.getSubject() + " subject was not found", e);
		}
		catch (Exception ex)
		{
			throw new Exception("Exception while reading email from outlook", ex);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To read contents of email <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param emailDetails </font><b><br>
	 * @return </b> <br>
	 */
	public static EmailDetails readContentsOfMail(EmailDetails emailDetails)
	{
		String result = null;
		Message message = null;
		List<FileAttachment> attachments = new ArrayList<>();
		try
		{
			if (emailDetails != null)
			{
				message = emailDetails.getMessage();
				if (message instanceof MimeMessage)
				{
					MimeMessage m = (MimeMessage) message;
					Object contentObject;
					contentObject = m.getContent();
					if (contentObject instanceof Multipart)
					{
						BodyPart clearTextPart = null;
						BodyPart htmlTextPart = null;
						Multipart content = (Multipart) contentObject;
						int count = content.getCount();
						for (int i = 0; i < count; i++)
						{
							clearTextPart = null;
							htmlTextPart = null;
							BodyPart part = content.getBodyPart(i);
							if (part.isMimeType("text/plain"))
							{
								clearTextPart = part;
								// break;
							}
							else if (part.isMimeType("text/html"))
							{
								htmlTextPart = part;
							}
							// for attachment
							else if (part.isMimeType("application/octet-stream"))
							{
								FileAttachment attachment = new FileAttachment();
								// System.out.println("@@@@@@@@ File Name : " +
								// part.getFileName());
								attachment.setFileName(part.getFileName());
								attachments.add(attachment);
							}

							if (clearTextPart != null)
							{
								result = (String) clearTextPart.getContent();
							}
							else if (htmlTextPart != null)
							{
								String html = (String) htmlTextPart.getContent();
								// result =
								// StringEscapeUtils.unescapeHtml4(html);
								// result = Jsoup.parse(html, "ISO-8859-1",
								// "").text();
								// result = Jsoup.parse(html).text();
								result = Jsoup.parse(htmlTextPart.getInputStream(), "UTF-8", "").text();
								result = result.replace("\u00a0", " ");
								// result = StringEscapeUtils.escapeHtml4(html);

								Jsoup.parse(html);
							}
						} // end of for
					}
					else if (contentObject instanceof String) // a simple text
																// message
					{
						result = (String) contentObject;
					}
					else
					// not a mime message
					{
						result = null;
					}
				}
				if (result != null)
				{
					logger.info("Email body : " + result);
					// to get all anchor tag elements
					Document document = Jsoup.parse(result);
					Elements elements = document.getElementsByTag("a");
					emailDetails.setElements(elements);
					emailDetails.setEmailBody(result);
					emailDetails.setAttachments(attachments);
				}
				else
				{
					logger.info("Email was not present");
				}

				return emailDetails;
			}
			else
			{
				logger.info("Email was not present");
			}
		}
		catch (IOException e)
		{
			logger.error("IOException while reading contents of email : " + e, e);
		}
		catch (MessagingException e)
		{
			logger.error("Messaging Exception while reading contents if email : " + e, e);
		}
		return emailDetails;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get body of email from properties
	 * file. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param bodyTemplate </font><b><br>
	 * @param documentInformation </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ParseException
	 */
	public static String getBodyOfEmailFromBodyTemplate(String bodyTemplate, DocumentInformation documentInformation) throws ParseException
	{
		String emailBody = null;

		emailBody = bodyTemplate;
		int totalNoOfItems = 0;
		if (documentInformation.getItem().getCatelogItems() != null)
		{
			totalNoOfItems = totalNoOfItems + documentInformation.getItem().getCatelogItems().size();

		}
		if (documentInformation.getItem().getGuidedItems() != null)
		{
			totalNoOfItems = totalNoOfItems + documentInformation.getItem().getGuidedItems().size();
		}

		if (documentInformation.getDocType().equalsIgnoreCase(DocumentInformation.docType_Requisition))
		{
			documentInformation.setItem(documentInformation.getRequisition().getItems());
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_DETAILS))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_DETAILS, IEmailTestingConstants.Body_For_Requisition);
			}
			if (bodyTemplate.contains(IEmailTestingConstants.ITEMS))
			{
				String itemTemplate = "";
				for (int i = 0; i < totalNoOfItems; i++)
				{
					itemTemplate += IEmailTestingConstants.Body_For_Req_Item_Row_Template + " \n";
				}

				emailBody = emailBody.replace(IEmailTestingConstants.ITEMS, itemTemplate);

				bodyTemplate = bodyTemplate.replace(IEmailTestingConstants.ITEMS, itemTemplate);
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TOTAL))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TOTAL, documentInformation.getRequisition().getTotalPrice());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TYPE))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TYPE, documentInformation.getDocType());
			}
		}

		if (documentInformation.getDocType().equalsIgnoreCase(DocumentInformation.docType_PO))
		{
			// documentInformation.setItem(documentInformation.getPurchaseOrder().getRequisition().getItems());
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_DETAILS))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_DETAILS, IEmailTestingConstants.Body_For_PO);
			}
			if (bodyTemplate.contains(IEmailTestingConstants.ITEMS))
			{
				String itemTemplate = "";
				for (int i = 0; i < totalNoOfItems; i++)
				{
					itemTemplate += IEmailTestingConstants.Body_For_PO_Item_Row_Template + " \n";
				}

				emailBody = emailBody.replace(IEmailTestingConstants.ITEMS, itemTemplate);

				bodyTemplate = bodyTemplate.replace(IEmailTestingConstants.ITEMS, itemTemplate);
			}
			/*
			 * if (bodyTemplate.contains(IEmailTestingConstants.DOC_TOTAL)) {
			 * emailBody = emailBody.replace(IEmailTestingConstants.DOC_TOTAL,
			 * documentInformation.getStandardPO() .getPoTotal()); } if
			 * (bodyTemplate.contains(IEmailTestingConstants.PO_NO_LIST)) {
			 * emailBody = emailBody.replace(IEmailTestingConstants.PO_NO_LIST,
			 * documentInformation.getStandardPO() .getPoNumber()); }
			 */
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TOTAL))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TOTAL, documentInformation.getPurchaseOrder().getPoTotal());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.PO_NO_LIST))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.PO_NO_LIST, documentInformation.getPurchaseOrder().getPoNo());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TYPE))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TYPE, documentInformation.getDocType());
			}
		}
		if (documentInformation.getDocType().equalsIgnoreCase(DocumentInformation.docType_STANDARD_PO))
		{
			documentInformation.setItem(documentInformation.getStandardPO().getItems());
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_DETAILS))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_DETAILS, IEmailTestingConstants.Body_For_PO);
			}
			if (bodyTemplate.contains(IEmailTestingConstants.ITEMS))
			{
				String itemTemplate = "";
				for (int i = 0; i < totalNoOfItems; i++)
				{
					itemTemplate += IEmailTestingConstants.Body_For_PO_Item_Row_Template + " \n";
				}

				emailBody = emailBody.replace(IEmailTestingConstants.ITEMS, itemTemplate);
				bodyTemplate = bodyTemplate.replace(IEmailTestingConstants.ITEMS, itemTemplate);
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TOTAL))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TOTAL, documentInformation.getStandardPO().getPoTotal());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.PO_NO_LIST))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.PO_NO_LIST, documentInformation.getStandardPO().getPoNumber());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.SUPPLIER_NAME))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.SUPPLIER_NAME, documentInformation.getStandardPO().getSupplierName());
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DELIVERY_DATE))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DELIVERY_DATE,
					CommonUtilities.getProperDateForEmailTesting(documentInformation.getStandardPO().getCustomDate().getDate()));
			}
			if (bodyTemplate.contains(IEmailTestingConstants.DOC_TYPE))
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DOC_TYPE, DocumentInformation.docType_PO);
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.NEXT_ACTION))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.NEXT_ACTION, "");
		}
		if (bodyTemplate.contains(IEmailTestingConstants.DOC_NO))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.DOC_NAME))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.DOC_NAME, documentInformation.getDocName());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.REQUESTOR))
		{
			if (documentInformation.getRequester() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.REQUESTOR, documentInformation.getRequester());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.POSTED_ON))
		{
			if (documentInformation.getCreatedOn() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.POSTED_ON, CommonUtilities.getProperDateForEmailTesting(documentInformation.getCreatedOn()));
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.INITIATOR))
		{
			if (documentInformation.getRequester() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.INITIATOR, documentInformation.getRequester());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.BUYING_JUSTIFICATION))
		{
			if (documentInformation.getRequisition().getReasonForOrdering() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.BUYING_JUSTIFICATION, documentInformation.getRequisition().getReasonForOrdering());
			}
			else
			{
				emailBody = emailBody.replace(IEmailTestingConstants.BUYING_JUSTIFICATION, "-");
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.COMMENTS))
		{
			if (documentInformation.getStandardPO() != null)
			{
				if (documentInformation.getStandardPO().getPoChange() != null)
				{
					emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, documentInformation.getStandardPO().getPoChange());
				}
				else if (documentInformation.getStandardPO().getNotes() != null)
				{
					emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, documentInformation.getStandardPO().getNotes());
				}
				else
				{
					emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, "-");
				}
			}
			else if (documentInformation.getPurchaseOrder() != null)
			{
				if (documentInformation.getPurchaseOrder().getComment() != null)
				{
					emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, documentInformation.getPurchaseOrder().getComment());
				}
				else
				{
					emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, "-");
				}
			}
			else
			{
				emailBody = emailBody.replace(IEmailTestingConstants.COMMENTS, "-");
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.RECALLED_ACTOR))
		{
			if (documentInformation.getRequester() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.RECALLED_ACTOR, documentInformation.getRequester());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.DESIGNATION))
		{
			if (documentInformation.getUser().getUserSettings().getDesignation() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DESIGNATION, documentInformation.getUser().getUserSettings().getDesignation());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTOR_DESIGNATION))
		{
			if (documentInformation.getUser().getUserSettings().getDesignation() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.ACTOR_DESIGNATION, "(" + documentInformation.getUser().getUserSettings().getDesignation().trim() + ","
					+ documentInformation.getUser().getUserSettings().getDepartmentName().trim() + ")");
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.DEPARTMENT))
		{
			if (documentInformation.getUser().getUserSettings().getDepartmentName() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.DEPARTMENT, documentInformation.getUser().getUserSettings().getDepartmentName());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTION_COMMENTS))
		{
			if (documentInformation.getCommentForActionPerformed() != null)
			{
				emailBody = emailBody.replace(IEmailTestingConstants.ACTION_COMMENTS, documentInformation.getCommentForActionPerformed());
			}
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTOR))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.ACTOR, documentInformation.getUser().getDisplayName());
		}

		if (bodyTemplate.contains(IEmailTestingConstants.DOC_LINK))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.DOC_LINK, documentInformation.getDocNo());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.SIGNATURE))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.SIGNATURE, IEmailTestingConstants.Email_signature);
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTOR_DELEGATE))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.ACTOR_DELEGATE, documentInformation.getMySettingsForApproval().getDelegateUserTo());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.DELEGATED_FROM))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.DELEGATED_FROM, documentInformation.getMySettingsForApproval().getDelegateUserFrom());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.FROM_DATE))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.FROM_DATE, documentInformation.getMySettingsForApproval().getDelegateDateFrom().getDate());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.TO_DATE))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.TO_DATE, documentInformation.getMySettingsForApproval().getDelegateDateTo().getDate());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTOR_WHO_RETURNED))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.ACTOR_WHO_RETURNED, documentInformation.getUser().getDisplayName());
		}
		if (bodyTemplate.contains(IEmailTestingConstants.ACTOR_WHO_RECALLED))
		{
			emailBody = emailBody.replace(IEmailTestingConstants.ACTOR_WHO_RECALLED, documentInformation.getUser().getDisplayName());
		}

		// logic for items
		/*
		 * if (bodyTemplate.contains(IEmailTestingConstants.
		 * Body_For_Req_Item_Row_Template) ||
		 * bodyTemplate.contains(IEmailTestingConstants.
		 * Body_For_PO_Item_Row_Template)) {
		 */
		if (documentInformation.getItem() != null)
		{
			if (documentInformation.getItem().getCatelogItems() != null)
			{
				for (CatelogItem catelogItem : documentInformation.getItem().getCatelogItems())
				{
					String unitPrice = catelogItem.getUnit_Price();
					String[] temp1 = StringUtils.split(unitPrice, " ");
					if (documentInformation.getDocType().equalsIgnoreCase(DocumentInformation.docType_STANDARD_PO))
					{
						if (temp1[1].contains(","))
						{
							temp1[1] = temp1[1].replace(",", "");
						}
						if (temp1[1].contains("."))
						{
							String[] temp = StringUtils.split(temp1[1], ".");
							if (temp[1].contains("0"))
							{
								temp[1] = temp[1].replace("0", "");
							}
							temp1[1] = temp[0].trim() + "." + temp[1].trim();
						}
					}
					unitPrice = temp1[0].trim() + temp1[1].trim();
					if (bodyTemplate.contains(IEmailTestingConstants.ITEM_NAME))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.ITEM_NAME, catelogItem.getItemName());
					}
					if (bodyTemplate.contains(IEmailTestingConstants.UNIT_PRICE))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.UNIT_PRICE, unitPrice);
					}
					if (bodyTemplate.contains(IEmailTestingConstants.QTY))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.QTY, Integer.toString(catelogItem.getQuantity()));
					}
					if (bodyTemplate.contains(IEmailTestingConstants.UOM))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.UOM, "EA");
					}
				}
			}
			if (documentInformation.getItem().getGuidedItems() != null)
			{
				for (GuidedItem guidedItem : documentInformation.getItem().getGuidedItems())
				{
					String unitPrice = Float.toString(guidedItem.getPrice());
					if (documentInformation.getDocType().equalsIgnoreCase(DocumentInformation.docType_STANDARD_PO))
					{
						if (unitPrice.contains(","))
						{
							unitPrice = unitPrice.replace(",", "");
						}
						if (unitPrice.contains("."))
						{
							String[] temp = StringUtils.split(unitPrice, ".");
							if (temp[1].contains("0"))
							{
								temp[1] = temp[1].replace("0", "");
							}
							unitPrice = temp[0].trim() + "." + temp[1].trim();
						}
					}
					if (bodyTemplate.contains(IEmailTestingConstants.ITEM_NAME))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.ITEM_NAME, guidedItem.getShortDescription());
					}
					if (bodyTemplate.contains(IEmailTestingConstants.UNIT_PRICE))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.UNIT_PRICE, guidedItem.getCurrency() + unitPrice);
					}
					if (bodyTemplate.contains(IEmailTestingConstants.QTY))
					{
						if (guidedItem.getUom().equalsIgnoreCase("EA") || guidedItem.getUom().equalsIgnoreCase("EACH"))
						{
							emailBody = emailBody.replaceFirst(IEmailTestingConstants.QTY, Integer.toString(guidedItem.getQuantity().intValue()));
						}
						else
						{
							emailBody = emailBody.replaceFirst(IEmailTestingConstants.QTY, Double.toString(guidedItem.getQuantity()));
						}
					}
					if (bodyTemplate.contains(IEmailTestingConstants.UOM))
					{
						emailBody = emailBody.replaceFirst(IEmailTestingConstants.UOM, guidedItem.getUom());
					}
				}
			}
		}
		// }

		logger.info("################ Body of email created from template : ################\n" + emailBody);

		return emailBody;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if email sent or not <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param emailDetails </font><b><br>
	 * @param emailDetailsForEvent </font><b><br>
	 * @param errorMsg </font><b><br>
	 * @param dataStorageMsg </font><b><br>
	 * @param map </font><b><br>
	 * @return </b> <br>
	 */
	public static EmailResult checkIfEmailSent(EmailDetails emailDetails, EmailDetails emailDetailsForEvent, String dataStorageMsg, String eventType)
	{
		boolean flag = false, emailSentFlag = false;
		EmailResult emailResult = new EmailResult();
		Map<String, String> map = new HashMap<String, String>();
		if (emailDetails != null)
		{
			logger.info("Subject : " + emailDetails.getSubject());
			map.put(dataStorageMsg, emailDetails.getSubject() + ",");
			if (emailDetails.getSubject() != null)
			{
				emailSentFlag = true;
				flag = emailDetails.getSubject().contains(emailDetailsForEvent.getSubject());
			}
			else
			{
				emailSentFlag = false;
			}
			if (!emailSentFlag)
			{
				emailResult.setMessage("Email was not sent for Event Type : " + eventType + ". || Subject : " + emailDetailsForEvent.getSubject());
			}
			else if (!flag)
			{
				emailResult.setMessage("Subject of email for " + eventType + " was wrong. || Subject : " + emailDetails.getSubject());
			}
		}
		else
		{
			logger.info("Email was not sent for " + emailDetailsForEvent.getSubject() + " subject");
			map.put(dataStorageMsg, "Email was not sent" + ",");
			if (!flag)
			{
				emailResult.setMessage("Email was not sent for Event Type : " + eventType + ". || Subject : " + emailDetailsForEvent.getSubject());
			}
		}
		emailResult.setResult(flag);
		emailResult.setMap(map);
		emailDetails.setEmailResultForSubject(emailResult);
		emailDetails.setEventType(eventType);
		return emailResult;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if email sent or not <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param emailDetails </font><b><br>
	 * @param emailDetailsForEvent </font><b><br>
	 * @param errorMsg </font><b><br>
	 * @param dataStorageMsg </font><b><br>
	 * @param map </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean checkIfEmailSend(EmailDetails emailDetails, EmailDetails emailDetailsForEvent)
	{
		boolean flag = false;
		if (emailDetails != null)
		{
			logger.info("Subject : " + emailDetails.getSubject());
			flag = emailDetails.getSubject().contains(emailDetailsForEvent.getSubject());
		}
		else
		{
			logger.info("Email was not sent for " + emailDetailsForEvent.getSubject() + " subject");
		}
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if body of email is right or wrong
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param bodyOfEmailReadFromMails </font><b><br>
	 * @param bodyOfEmailFromBodyTemplate </font><b><br>
	 * @param splitChar </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static EmailResult checkIfBodyOfEmailIsRight(String bodyOfEmailReadFromMails, String bodyOfEmailFromBodyTemplate, String splitChar, String eventType)
		throws ActionBotException
	{
		String message;
		EmailResult emailResult = new EmailResult();
		Map<String, String> map = new HashMap<>();
		emailResult = checkIfBodyOfEmailIsRight(bodyOfEmailReadFromMails, bodyOfEmailFromBodyTemplate, splitChar);
		map.put("Email body for " + eventType + " : ", bodyOfEmailReadFromMails + ",");
		if (!emailResult.isResult())
		{
			/*
			 * message = "Email body for " + eventType +
			 * " was wrong. || Email Body : " + bodyOfEmailReadFromMails + "\n"
			 * + emailResult.getMessage();
			 */
			message = "Email body for " + eventType + " was wrong. \n" + emailResult.getMessage();
			emailResult.setMessage(message);
		}
		emailResult.setMap(map);
		return emailResult;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if body of email is right or wrong
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param bodyOfEmailReadFromMails </font><b><br>
	 * @param bodyOfEmailFromBodyTemplate </font><b><br>
	 * @param splitChar </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static EmailResult checkIfBodyOfEmailIsRight(String bodyOfEmailReadFromMails, String bodyOfEmailFromBodyTemplate, String splitChar) throws ActionBotException
	{
		EmailResult emailResult = new EmailResult();
		String[] temp1 = StringUtils.split(bodyOfEmailFromBodyTemplate, splitChar);
		boolean flag = true;
		String log = "", msg = "Body Part which does not match with email body : \n";
		if (bodyOfEmailReadFromMails != null)
		{
			for (String str : temp1)
			{
				/*
				 * System.out.println("#### Str : " + str.trim());
				 * System.out.println("%%%% Compared With : " +
				 * bodyOfEmailReadFromMails.trim());
				 */

				if (!bodyOfEmailReadFromMails.trim().contains(str.trim()))
				{
					flag = false;
					log += str + " \n";
				}
			}
		}
		else
		{
			flag = false;
		}
		if (log != "")
		{
			log = msg + log;
		}
		emailResult.setResult(flag);
		emailResult.setMessage(log);

		return emailResult;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if attachments in email body are
	 * right or wrong <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param listOfFileAttachments </font><b><br>
	 * @param listOfFileAttahcmentsFromMail </font><b><br>
	 * @return </b> <br>
	 */
	public static EmailResult checkIfAttachmentsInBodyAreRight(List<FileAttachment> listOfFileAttachments, List<FileAttachment> listOfFileAttahcmentsFromMail)
	{
		EmailResult emailResult = new EmailResult();
		boolean flag = false;
		List<Boolean> listOfResults = new ArrayList<>();
		String log = "";
		for (FileAttachment attachment : listOfFileAttachments)
		{
			for (FileAttachment attachmentFromMail : listOfFileAttahcmentsFromMail)
			{
				if (attachmentFromMail.getFileName().contains(attachment.getFileName()))
				{
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				log += attachment.getFileName() + " was not present in mail \n";
			}
			listOfResults.add(flag);
		}
		logger.info(log);
		for (Boolean flag1 : listOfResults)
		{
			flag = flag && flag1;
		}
		emailResult.setMessage(log);
		emailResult.setResult(flag);
		return emailResult;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if attachments in email body are
	 * right or wrong <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param listOfFileAttachments </font><b><br>
	 * @param listOfFileAttahcmentsFromMail </font><b><br>
	 * @return </b> <br>
	 */
	public static EmailResult checkIfGivenAttachmentsAreNotPresentInBody(List<FileAttachment> listOfFileAttachments, List<FileAttachment> listOfFileAttahcmentsFromMail)
	{
		EmailResult emailResult = new EmailResult();
		boolean flag = true;
		List<Boolean> listOfResults = new ArrayList<>();
		String log = "";
		for (FileAttachment attachment : listOfFileAttachments)
		{
			for (FileAttachment attachmentFromMail : listOfFileAttahcmentsFromMail)
			{
				if (attachmentFromMail.getFileName().contains(attachment.getFileName()))
				{
					flag = false;
					break;
				}
			}
			if (!flag)
			{
				log += attachment.getFileName() + " was present in mail. Which should not present in mail. \n";
			}
			listOfResults.add(flag);
		}
		logger.info(log);
		for (Boolean flag1 : listOfResults)
		{
			flag = flag && flag1;
		}
		emailResult.setMessage(log);
		emailResult.setResult(flag);
		return emailResult;
	}
}
