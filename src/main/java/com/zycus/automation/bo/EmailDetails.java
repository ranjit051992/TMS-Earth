/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;

import org.jsoup.select.Elements;

/**
 * @author ankita.sawant
 *
 */
public class EmailDetails
{
	private String					subject					= null;
	private Map<String, String>		emailBodyPart			= new HashMap<String, String>();
	private String					username				= null;
	private String					password				= null;
	private Message					message					= null;
	private String					folderName				= null;
	private String					emailBody				= null;
	private String					eventType				= null;
	private EmailResult				emailResultForSubject	= new EmailResult();
	private EmailResult				emailResultForBody		= new EmailResult();
	private List<FileAttachment>	attachments				= new ArrayList<FileAttachment>();
	private Elements				elements				= null;

	public Elements getElements()
	{
		return elements;
	}

	public void setElements(Elements elements)
	{
		this.elements = elements;
	}

	public List<FileAttachment> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(List<FileAttachment> attachments)
	{
		this.attachments = attachments;
	}

	public EmailResult getEmailResultForSubject()
	{
		return emailResultForSubject;
	}

	public void setEmailResultForSubject(EmailResult emailResultForSubject)
	{
		this.emailResultForSubject = emailResultForSubject;
	}

	public EmailResult getEmailResultForBody()
	{
		return emailResultForBody;
	}

	public void setEmailResultForBody(EmailResult emailResultForBody)
	{
		this.emailResultForBody = emailResultForBody;
	}

	public String getEventType()
	{
		return eventType;
	}

	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public String getEmailBody()
	{
		return emailBody;
	}

	public void setEmailBody(String emailBody)
	{
		this.emailBody = emailBody;
	}

	public String getFolderName()
	{
		return folderName;
	}

	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage(Message message)
	{
		this.message = message;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public Map<String, String> getEmailBodyPart()
	{
		return emailBodyPart;
	}

	public void setEmailBodyPart(Map<String, String> emailBodyPart)
	{
		this.emailBodyPart = emailBodyPart;
	}

}
