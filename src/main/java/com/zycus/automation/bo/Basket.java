package com.zycus.automation.bo;

/**
 * <b>Author: prateek.khandelwal </b> <b><br>
 * <font color="blue">Method :</b>Basket BO class including data members for every basket action.
 */
public class Basket
{
	private String	basketName;
	private Item	item;
	private boolean	result;
	private String	basketAction;
	private String	sharingScope;
	private String	departmentCode;
	private String	companyCode;
	private boolean	viewBasket;

	public boolean isResult()
	{
		return this.result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getBasketName()
	{
		return this.basketName;
	}

	public void setBasketName(String basketName)
	{
		this.basketName = basketName;
	}

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public String getBasketAction()
	{
		return basketAction;
	}

	public void setBasketAction(String basketAction)
	{
		this.basketAction = basketAction;
	}

	public String getSharingScope()
	{
		return sharingScope;
	}

	public void setSharingScope(String sharingScope)
	{
		this.sharingScope = sharingScope;
	}

	public String getDepartmentCode()
	{
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode)
	{
		this.departmentCode = departmentCode;
	}

	public String getCompanyCode()
	{
		return companyCode;
	}

	public void setCompanyCode(String companyCode)
	{
		this.companyCode = companyCode;
	}

	public boolean isViewBasket()
	{
		return viewBasket;
	}

	public void setViewBasket(boolean viewBasket)
	{
		this.viewBasket = viewBasket;
	}

}