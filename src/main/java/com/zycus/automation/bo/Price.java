/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author puneet.sharma
 *
 */
public class Price
{

	private String	priceType;

	private double	priceValue;
	private String	price;

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPriceType()
	{
		return priceType;
	}

	public void setPriceType(String priceType)
	{
		this.priceType = priceType;
	}

	public double getPriceValue()
	{
		return priceValue;
	}

	public void setPriceValue(double priceValue)
	{
		this.priceValue = priceValue;
	}

	@Override
	public String toString()
	{
		return "Price [priceType=" + priceType + ", priceValue=" + priceValue + "]";
	}

}
