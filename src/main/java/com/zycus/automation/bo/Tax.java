package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class Tax
{
	private String	taxType	= null;
	private String	taxName	= null;
	private float	taxRate;

	public String getTaxType()
	{
		return taxType;
	}

	public void setTaxType(String taxType)
	{
		this.taxType = taxType;
	}

	public String getTaxName()
	{
		return taxName;
	}

	public void setTaxName(String taxName)
	{
		this.taxName = taxName;
	}

	public float getTaxRate()
	{
		return taxRate;
	}

	public void setTaxRate(float taxRate)
	{
		this.taxRate = taxRate;
	}

}
