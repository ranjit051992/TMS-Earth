package com.zycus.tenantCreation.bo;

public class ElementBO
{
	private String	key			= "";
	private String	value		= "";
	private String	locatorType	= "";
	private String	productName	= "";

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getLocatorType()
	{
		return locatorType;
	}

	public void setLocatorType(String locatorType)
	{
		this.locatorType = locatorType;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

}
