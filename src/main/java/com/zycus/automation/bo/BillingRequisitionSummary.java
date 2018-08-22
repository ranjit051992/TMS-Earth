/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BillingRequisitionSummary
{
	private String	currency;
	private String	company;
	private String	businessUnit;
	private String	location;
	private String	nextAction;
	private String	deliveryAddress;
	private String	billToAddress;

	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public String getBillToAddress()
	{
		return billToAddress;
	}

	public void setBillToAddress(String billToAddress)
	{
		this.billToAddress = billToAddress;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

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

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
