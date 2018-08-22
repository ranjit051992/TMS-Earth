package com.zycus.framework.dom_parser.framework;

import org.openqa.selenium.By;

public class UI_Elements
{

	String	product;
	String	fileName;
	String	key;
	By		by;
	String	value;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public By getBy()
	{
		return by;
	}

	public void setBy(By by)
	{
		this.by = by;
	}

	public String getProduct()
	{
		return product;
	}

	public void setProduct(String product)
	{
		this.product = product;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
