package com.zycus.automation.bo;

import java.util.List;

/**
 * 
 * @author ankita.sawant
 *
 */
public class BuyersDeskFilter
{
	private boolean			partiallyOrderFilter	= false;
	private String			nextAction;
	private boolean			result;
	private List<String>	statusOfFilter;

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public List<String> getStatusOfFilter()
	{
		return statusOfFilter;
	}

	public void setStatusOfFilter(List<String> statusOfFilter)
	{
		this.statusOfFilter = statusOfFilter;
	}

	public boolean isPartiallyOrderFilter()
	{
		return partiallyOrderFilter;
	}

	public void setPartiallyOrderFilter(boolean partiallyOrderFilter)
	{
		this.partiallyOrderFilter = partiallyOrderFilter;
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
