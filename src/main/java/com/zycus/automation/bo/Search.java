package com.zycus.automation.bo;

public class Search
{

	private String	itemName;
	private float	searchQuantity;
	private String	id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public final String getItemName()
	{
		return itemName;
	}

	public final void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public final float getSearchQuantity()
	{
		return searchQuantity;
	}

	public final void setSearchQuantity(float searchQuantity)
	{
		this.searchQuantity = searchQuantity;
	}

	public Search()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Search(String itemName, float searchQuantity)
	{
		super();
		this.itemName = itemName;
		this.searchQuantity = searchQuantity;
	}

	@Override
	public String toString()
	{
		return "Search [itemName=" + itemName + ", searchQuantity=" + searchQuantity + "]";
	}

}
