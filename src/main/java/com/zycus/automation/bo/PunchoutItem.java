/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class PunchoutItem
{
	private String	punchoutItemName	= null;
	private String	unitPrice			= null;
	private String	totalPrice			= null;
	private int		quantity			= 0;
	private String	nextAction			= null;
	private boolean	result				= false;
	private String	itemCategory		= null;
	private String	itemId				= null;

	public boolean isResult()
	{
		return result;
	}

	public String getItemId()
	{
		return itemId;
	}

	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getPunchoutItemName()
	{
		return punchoutItemName;
	}

	public void setPunchoutItemName(String punchoutItemName)
	{
		this.punchoutItemName = punchoutItemName;
	}

	public String getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public String getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getPunchoutItemcategory()
	{
		return itemCategory;
	}

	public void setPunchoutItemCategory(String itemCategory)
	{
		this.itemCategory = itemCategory;
	}

}
