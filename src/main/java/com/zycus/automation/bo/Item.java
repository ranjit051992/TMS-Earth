/**
 * 
 */
package com.zycus.automation.bo;

import java.util.List;

/**
 * @author puneet.sharma
 *
 */
public class Item
{

	private List<CatelogItem>		catelogItems;

	private List<GuidedItem>		guidedItems;

	private List<PunchoutItem>		punchoutItems;
	private List<ItemMasterItem>	itemMasterItems;
	private boolean					isEmptyCart	= true;

	public List<ItemMasterItem> getItemMasterItems()
	{
		return itemMasterItems;
	}

	public void setItemMasterItems(List<ItemMasterItem> itemMasterItems)
	{
		this.itemMasterItems = itemMasterItems;
	}

	public boolean isEmptyCart()
	{
		return isEmptyCart;
	}

	public void setEmptyCart(boolean isEmptyCart)
	{
		this.isEmptyCart = isEmptyCart;
	}

	public List<PunchoutItem> getPunchoutItems()
	{
		return punchoutItems;
	}

	public void setPunchoutItems(List<PunchoutItem> punchoutItems)
	{
		this.punchoutItems = punchoutItems;
	}

	public List<CatelogItem> getCatelogItems()
	{
		return catelogItems;
	}

	public void setCatelogItems(List<CatelogItem> catelogItems)
	{
		this.catelogItems = catelogItems;
	}

	public List<GuidedItem> getGuidedItems()
	{
		return guidedItems;
	}

	public void setGuidedItems(List<GuidedItem> guidedItems)
	{
		this.guidedItems = guidedItems;
	}

	@Override
	public String toString()
	{
		return "Item [catelogItems=" + catelogItems + ", guidedItems=" + guidedItems + ", punchoutItems=" + punchoutItems + ", itemMasterItems=" + itemMasterItems
			+ ", isEmptyCart=" + isEmptyCart + "]";
	}

}
