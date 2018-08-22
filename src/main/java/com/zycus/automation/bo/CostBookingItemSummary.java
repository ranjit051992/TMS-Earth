package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CostBookingItemSummary")
public class CostBookingItemSummary
{
	@Id
	@GeneratedValue
	private int							id;
	// private int itemId;
	private boolean						splitCostCenterAtItemLevel;
	private boolean						splitCostCenterAtItemLevel_percentage;
	private boolean						splitCostCenterAtItemLevel_quantity;
	private boolean						splitCostCenterAtItemLevel_quantityProportionalToDelivery;
	private String						nextAction;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CostCenterSplitInfo>	costCenterSplitInfo		= new ArrayList<CostCenterSplitInfo>();

	@OneToOne(cascade = CascadeType.ALL)
	private AccountingItemSummary		accountingItemSummary	= new AccountingItemSummary();
	private String						subTotalPrice			= null;

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

	public String getSubTotalPrice()
	{
		return subTotalPrice;
	}

	public void setSubTotalPrice(String subTotalPrice)
	{
		this.subTotalPrice = subTotalPrice;
	}

	public AccountingItemSummary getAccountingItemSummary()
	{
		return accountingItemSummary;
	}

	public void setAccountingItemSummary(AccountingItemSummary accountingItemSummary)
	{
		this.accountingItemSummary = accountingItemSummary;
	}

	public boolean isSplitCostCenterAtItemLevel_quantityProportionalToDelivery()
	{
		return splitCostCenterAtItemLevel_quantityProportionalToDelivery;
	}

	public void setSplitCostCenterAtItemLevel_quantityProportionalToDelivery(boolean splitCostCenterAtItemLevel_quantityProportionalToDelivery)
	{
		this.splitCostCenterAtItemLevel_quantityProportionalToDelivery = splitCostCenterAtItemLevel_quantityProportionalToDelivery;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public boolean isSplitCostCenterAtItemLevel()
	{
		return splitCostCenterAtItemLevel;
	}

	public void setSplitCostCenterAtItemLevel(boolean splitCostCenterAtItemLevel)
	{
		this.splitCostCenterAtItemLevel = splitCostCenterAtItemLevel;
	}

	public boolean isSplitCostCenterAtItemLevel_percentage()
	{
		return splitCostCenterAtItemLevel_percentage;
	}

	public void setSplitCostCenterAtItemLevel_percentage(boolean splitCostCenterAtItemLevel_percentage)
	{
		this.splitCostCenterAtItemLevel_percentage = splitCostCenterAtItemLevel_percentage;
	}

	public boolean isSplitCostCenterAtItemLevel_quantity()
	{
		return splitCostCenterAtItemLevel_quantity;
	}

	public void setSplitCostCenterAtItemLevel_quantity(boolean splitCostCenterAtItemLevel_quantity)
	{
		this.splitCostCenterAtItemLevel_quantity = splitCostCenterAtItemLevel_quantity;
	}

	public List<CostCenterSplitInfo> getCostCenterSplitInfo()
	{
		return costCenterSplitInfo;
	}

	public void setCostCenterSplitInfo(List<CostCenterSplitInfo> costCenterSplitInfo)
	{
		this.costCenterSplitInfo = costCenterSplitInfo;
	}

	@Override
	public String toString()
	{
		return "CostBookingItemSummary [id=" + id + ", splitCostCenterAtItemLevel=" + splitCostCenterAtItemLevel + ", splitCostCenterAtItemLevel_percentage="
			+ splitCostCenterAtItemLevel_percentage + ", splitCostCenterAtItemLevel_quantity=" + splitCostCenterAtItemLevel_quantity
			+ ", splitCostCenterAtItemLevel_quantityProportionalToDelivery=" + splitCostCenterAtItemLevel_quantityProportionalToDelivery + ", nextAction=" + nextAction
			+ ", costCenterSplitInfo=" + costCenterSplitInfo + ", accountingItemSummary=" + accountingItemSummary + ", subTotalPrice=" + subTotalPrice + "]";
	}
	
	

}
