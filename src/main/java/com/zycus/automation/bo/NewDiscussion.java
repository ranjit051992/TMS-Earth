/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class NewDiscussion
{
	private String	to					= null;
	private String	message				= null;
	private boolean	sharedWithAll		= false;
	private boolean	sharedWithRequester	= false;
	private boolean	sharedWithApprover	= false;
	private boolean	sharedWithBuyer		= false;
	private String	fileName			= null;
	private String	nextAction			= null;

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isSharedWithAll()
	{
		return sharedWithAll;
	}

	public void setSharedWithAll(boolean sharedWithAll)
	{
		this.sharedWithAll = sharedWithAll;
	}

	public boolean isSharedWithRequester()
	{
		return sharedWithRequester;
	}

	public void setSharedWithRequester(boolean sharedWithRequester)
	{
		this.sharedWithRequester = sharedWithRequester;
	}

	public boolean isSharedWithApprover()
	{
		return sharedWithApprover;
	}

	public void setSharedWithApprover(boolean sharedWithApprover)
	{
		this.sharedWithApprover = sharedWithApprover;
	}

	public boolean isSharedWithBuyer()
	{
		return sharedWithBuyer;
	}

	public void setSharedWithBuyer(boolean sharedWithBuyer)
	{
		this.sharedWithBuyer = sharedWithBuyer;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
