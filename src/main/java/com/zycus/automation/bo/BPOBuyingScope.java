/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BPOBuyingScope
{
	private String	businessUnit	= null;
	private String	location		= null;
	private String	costCenter		= null;
	private String	nextAction		= null;

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(String costCenter)
	{
		this.costCenter = costCenter;
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
