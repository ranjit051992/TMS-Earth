/**
 * 
 */
package com.zycus.automation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ankita.sawant
 *
 */
@Entity
@Table(name = "AccountingItemSummary")
public class AccountingItemSummary
{
	@Id
	@GeneratedValue
	private int		id;
	// private int itemId;
	private String	glAccountType;
	private String	glAccount;
	private String	nextAction;
	private String	assetCode;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	/*
	 * public int getItemId() { return itemId; }
	 * 
	 * public void setItemId(int itemId) { this.itemId = itemId; }
	 */

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getGlAccountType()
	{
		return glAccountType;
	}

	public void setGlAccountType(String glAccountType)
	{
		this.glAccountType = glAccountType;
	}

	public String getGlAccount()
	{
		return glAccount;
	}

	public void setGlAccount(String glAccount)
	{
		this.glAccount = glAccount;
	}

	public String getAssetCode()
	{
		return assetCode;
	}

	public void setAssetCode(String assetCode)
	{
		this.assetCode = assetCode;
	}

	@Override
	public String toString()
	{
		return "AccountingItemSummary [glAccountType=" + glAccountType + ", glAccount=" + glAccount + ", nextAction=" + nextAction + ", assetCode=" + assetCode + "]";
	}

}
