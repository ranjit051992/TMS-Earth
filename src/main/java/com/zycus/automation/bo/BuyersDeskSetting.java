package com.zycus.automation.bo;

public class BuyersDeskSetting
{

	private String	allowPrPercentTotalAmount;
	private String	allowPrCurrenctUnits;

	public void setAllowPrPercentTotalAmount(String allowPrPercentTotalAmount)
	{
		this.allowPrPercentTotalAmount = allowPrPercentTotalAmount;
	}

	public String getAllowPrPercentTotalAmount()
	{
		return allowPrPercentTotalAmount;
	}

	public void setAllowPrCurrenctUnits(String allowPrCurrenctUnits)
	{
		this.allowPrCurrenctUnits = allowPrCurrenctUnits;
	}

	public String getallowPrCurrenctUnits()
	{
		return allowPrCurrenctUnits;
	}
}
