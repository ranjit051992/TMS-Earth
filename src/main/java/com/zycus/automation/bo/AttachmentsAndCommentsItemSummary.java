package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttachmentsAndCommentsItemSummary")
public class AttachmentsAndCommentsItemSummary
{
	@Id
	@GeneratedValue
	private int						id;
	// private int itemId;
	private String					internalComments;
	private String					commentsForSupplier;
	// private String attachmentFileName;
	private List<FileAttachment>	attachments	= new ArrayList<FileAttachment>();
	private String					nextAction;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	/*
	 * public int getItemId() { return itemId; }
	 * 
	 * public void setItemId(int itemId) { this.itemId = itemId; }
	 */

	/*
	 * public String getAttachmentFileName() { return attachmentFileName; }
	 * 
	 * public void setAttachmentFileName(String attachmentFileName) {
	 * this.attachmentFileName = attachmentFileName; }
	 */

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getInternalComments()
	{
		return internalComments;
	}

	public void setInternalComments(String internalComments)
	{
		this.internalComments = internalComments;
	}

	public String getCommentsForSupplier()
	{
		return commentsForSupplier;
	}

	public void setCommentsForSupplier(String commentsForSupplier)
	{
		this.commentsForSupplier = commentsForSupplier;
	}

	public List<FileAttachment> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(List<FileAttachment> attachments)
	{
		this.attachments = attachments;
	}

	@Override
	public String toString()
	{
		return "AttachmentsAndCommentsItemSummary [internalComments=" + internalComments + ", commentsForSupplier=" + commentsForSupplier + "]";
	}

}
