package com.zycus.automation.bo;

public class OnlineStore
{

	private String	searchItem;
	private String	itemID;
	private int		quantity;
	private String	itemTitleInPopup;
	private String	itemName;
	private String	addItemTo;
	private String	itemType;
	private boolean	result;
	private String	nextAction;
	private boolean	categoryDisplayed	= false;

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getSearchItem()
	{
		return searchItem;
	}

	public void setSearchItem(String searchItem)
	{
		this.searchItem = searchItem;
	}

	public String getItemId()
	{
		return itemID;
	}

	public void setItemId(String itemID)
	{
		this.itemID = itemID;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getItemTitleInPopup()
	{

		return itemTitleInPopup;
	}

	public void setItemTitleInPopup(String itemTitleInPopup)
	{
		this.itemTitleInPopup = itemTitleInPopup;
	}

	public String getItemName()
	{

		return itemName;
	}

	public void setitemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getAddItemTo()
	{
		return addItemTo;
	}

	public void setAddItemTo(String addItemTo)
	{
		this.addItemTo = addItemTo;
	}

	public String getItemType()
	{
		return itemType;
	}

	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}

	public boolean isCategoryDisplayed()
	{
		return categoryDisplayed;
	}

	public void setCategoryDisplayed(boolean categoryDisplayed)
	{
		this.categoryDisplayed = categoryDisplayed;
	}
}
