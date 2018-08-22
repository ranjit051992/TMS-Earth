/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class CategoryManagerMap
{
	private String	category		= null;
	private String	buyer			= null;
	private String	purpose			= null;
	private String	childCategory	= null;

	public String getChildCategory()
	{
		return childCategory;
	}

	public void setChildCategory(String childCategory)
	{
		this.childCategory = childCategory;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	public String getPurpose()
	{
		return purpose;
	}

	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

}
