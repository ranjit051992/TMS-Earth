/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BudgetPeriod
{
	private CustomDate	periodStartDate	= null;
	private CustomDate	periodEndDate	= null;
	private String		periodName		= null;
	private String		nextAction		= null;
	private boolean		result			= false;

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public CustomDate getPeriodStartDate()
	{
		return periodStartDate;
	}

	public void setPeriodStartDate(CustomDate periodStartDate)
	{
		this.periodStartDate = periodStartDate;
	}

	public CustomDate getPeriodEndDate()
	{
		return periodEndDate;
	}

	public void setPeriodEndDate(CustomDate periodEndDate)
	{
		this.periodEndDate = periodEndDate;
	}

	public String getPeriodName()
	{
		return periodName;
	}

	public void setPeriodName(String periodName)
	{
		this.periodName = periodName;
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
