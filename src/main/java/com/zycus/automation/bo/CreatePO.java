package com.zycus.automation.bo;

public class CreatePO
{
	String	supplierName;
	String	supplierAddress;
	String	paymentTerms;
	String	currencyType;
	Double	currencyValue;
	String	deliveryTerms;
	String	purchaseType;
	int		contractNo;
	String	orderDescription;
	String	buyer;

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getSupplierAddress()
	{
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress)
	{
		this.supplierAddress = supplierAddress;
	}

	public String getPaymentTerms()
	{
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms)
	{
		this.paymentTerms = paymentTerms;
	}

	public String getCurrencyType()
	{
		return currencyType;
	}

	public void setCurrencyType(String currencyType)
	{
		this.currencyType = currencyType;
	}

	public Double getCurrencyValue()
	{
		return currencyValue;
	}

	public void setCurrencyValue(Double currencyValue)
	{
		this.currencyValue = currencyValue;
	}

	public String getDeliveryTerms()
	{
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms)
	{
		this.deliveryTerms = deliveryTerms;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public int getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(int contractNo)
	{
		this.contractNo = contractNo;
	}

	public String getOrderDescription()
	{
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription)
	{
		this.orderDescription = orderDescription;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	@Override
	public String toString()
	{
		return "CreatePO [supplierName=" + supplierName + ", supplierAddress=" + supplierAddress + ", paymentTerms=" + paymentTerms + ", currencyType=" + currencyType
			+ ", currencyValue=" + currencyValue + ", deliveryTerms=" + deliveryTerms + ", purchaseType=" + purchaseType + ", contractNo=" + contractNo + ", orderDescription="
			+ orderDescription + ", buyer=" + buyer + "]";
	}
}
