package com.zycus.automation.bo;

public class TMS_paymentTermsSettings
{
	String	paymentTermSearch;
	String	paymentTermOption;
	String	changeStatus;
	String	paymentTermName;

	public String getPaymentTermSearch()
	{
		return paymentTermSearch;
	}

	public void setPaymentTermSearch(String paymentTermSearch)
	{
		this.paymentTermSearch = paymentTermSearch;
	}

	public String getPaymentTermOption()
	{
		return paymentTermOption;
	}

	public void setPaymentTermOption(String paymentTermOption)
	{
		this.paymentTermOption = paymentTermOption;
	}

	public String getChangeStatus()
	{
		return changeStatus;
	}

	public void setChangeStatus(String changeStatus)
	{
		this.changeStatus = changeStatus;
	}

	public String getPaymentTermName()
	{
		return paymentTermName;
	}

	public void setPaymentTermName(String paymentTermName)
	{
		this.paymentTermName = paymentTermName;
	}

	@Override
	public String toString()
	{
		return "TMS_paymentTermsSettings [paymentTermSearch=" + paymentTermSearch + ", paymentTermOption=" + paymentTermOption + ", changeStatus=" + changeStatus
			+ ", paymentTermName=" + paymentTermName + "]";
	}

}
