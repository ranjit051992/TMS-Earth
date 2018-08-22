/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class ApprovalAllRequests
{
	private String	documentNo;
	private String	documentType;
	private String	documentName;
	private String	initiatorName;
	private String	receivedOn;
	private String	actions;
	private String	comment;
	private String	delegateTo;

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getDelegateTo()
	{
		return delegateTo;
	}

	public void setDelegateTo(String delegateTo)
	{
		this.delegateTo = delegateTo;
	}

	private boolean result;

	public String getDocumentNo()
	{
		return documentNo;
	}

	public void setDocumentNo(String documentNo)
	{
		this.documentNo = documentNo;
	}

	public String getDocumentType()
	{
		return documentType;
	}

	public void setDocumentType(String documentType)
	{
		this.documentType = documentType;
	}

	public String getDocumentName()
	{
		return documentName;
	}

	public void setDocumentName(String documentName)
	{
		this.documentName = documentName;
	}

	public String getInitiatorName()
	{
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName)
	{
		this.initiatorName = initiatorName;
	}

	public String getReceivedOn()
	{
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn)
	{
		this.receivedOn = receivedOn;
	}

	public String getActions()
	{
		return actions;
	}

	public void setActions(String actions)
	{
		this.actions = actions;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	@Override
	public String toString()
	{
		return "ApprovalAllRequests [documentNo=" + documentNo + ", documentType=" + documentType + ", documentName=" + documentName + ", initiatorName=" + initiatorName
			+ ", receivedOn=" + receivedOn + ", actions=" + actions + ", comment=" + comment + ", delegateTo=" + delegateTo + ", result=" + result + "]";
	}

}
