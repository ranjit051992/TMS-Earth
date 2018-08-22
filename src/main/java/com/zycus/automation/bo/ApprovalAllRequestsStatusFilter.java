/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class ApprovalAllRequestsStatusFilter
{

	private boolean	pending;
	private boolean	approved;
	private boolean	rejected;
	private boolean	delegated;
	private boolean	urgentRequestsOnly;
	private boolean	pendingSince;
	private int		pendingSinceDays;
	private String	nextAction;
	private boolean	result;
	private String	statusOfFilter;

	public String getStatusOfFilter()
	{
		return statusOfFilter;
	}

	public void setStatusOfFilter(String statusOfFilter)
	{
		this.statusOfFilter = statusOfFilter;
	}

	public boolean isPending()
	{
		return pending;
	}

	public void setPending(boolean pending)
	{
		this.pending = pending;
	}

	public boolean isApproved()
	{
		return approved;
	}

	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}

	public boolean isRejected()
	{
		return rejected;
	}

	public void setRejected(boolean rejected)
	{
		this.rejected = rejected;
	}

	public boolean isDelegated()
	{
		return delegated;
	}

	public void setDelegated(boolean delegated)
	{
		this.delegated = delegated;
	}

	public boolean isUrgentRequestsOnly()
	{
		return urgentRequestsOnly;
	}

	public void setUrgentRequestsOnly(boolean urgentRequestsOnly)
	{
		this.urgentRequestsOnly = urgentRequestsOnly;
	}

	public boolean isPendingSince()
	{
		return pendingSince;
	}

	public void setPendingSince(boolean pendingSince)
	{
		this.pendingSince = pendingSince;
	}

	public int getPendingSinceDays()
	{
		return pendingSinceDays;
	}

	public void setPendingSinceDays(int pendingSinceDays)
	{
		this.pendingSinceDays = pendingSinceDays;
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
