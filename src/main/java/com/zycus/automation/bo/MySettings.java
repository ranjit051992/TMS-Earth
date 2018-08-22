/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class MySettings
{
	private String		delegateUserFrom	= null;
	private String		delegateUserTo		= null;
	private CustomDate	delegateDateFrom	= new CustomDate();
	private CustomDate	delegateDateTo		= new CustomDate();
	private String		revokeFrom			= null;
	private String		action				= null;
	private String		nextAction			= null;
	private boolean		result				= false;

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getDelegateUserFrom()
	{
		return delegateUserFrom;
	}

	public void setDelegateUserFrom(String delegateUserFrom)
	{
		this.delegateUserFrom = delegateUserFrom;
	}

	public String getDelegateUserTo()
	{
		return delegateUserTo;
	}

	public void setDelegateUserTo(String delegateUserTo)
	{
		this.delegateUserTo = delegateUserTo;
	}

	public CustomDate getDelegateDateFrom()
	{
		return delegateDateFrom;
	}

	public void setDelegateDateFrom(CustomDate delegateDateFrom)
	{
		this.delegateDateFrom = delegateDateFrom;
	}

	public CustomDate getDelegateDateTo()
	{
		return delegateDateTo;
	}

	public void setDelegateDateTo(CustomDate delegateDateTo)
	{
		this.delegateDateTo = delegateDateTo;
	}

	public String getRevokeFrom()
	{
		return revokeFrom;
	}

	public void setRevokeFrom(String revokeFrom)
	{
		this.revokeFrom = revokeFrom;
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
