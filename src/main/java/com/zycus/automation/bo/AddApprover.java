/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class AddApprover
{
	private String	approverName		= null;
	private String	addApproverAfter	= null;
	private String	nextAction			= null;
	private boolean	result				= false;

	public String getApproverName()
	{
		return approverName;
	}

	public void setApproverName(String approverName)
	{
		this.approverName = approverName;
	}

	public String getAddApproverAfter()
	{
		return addApproverAfter;
	}

	public void setAddApproverAfter(String addApproverAfter)
	{
		this.addApproverAfter = addApproverAfter;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

}
