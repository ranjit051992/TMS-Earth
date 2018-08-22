/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class CostBookingRequisitionSummary
{
	private String				assignedProjectToPurchaseCost;
	private boolean				bookCostToSingleCostCenter;
	private boolean				splitCostToMultipleCostCenter;
	private boolean				splitCostAtLineItemLevel;
	private String				costCenter;
	private String				budget;
	private String				project;
	private String				nextAction;
	List<CostCenterSplitInfo>	listOfSplitedCostCenters	= new ArrayList<CostCenterSplitInfo>();
	private String				glAccount					= null;

	//client specific- QTS
	private String				allowBudgetUtilization;

	public String getAllowBudgetUtilization()
	{
		return allowBudgetUtilization;
	}

	public void setAllowBudgetUtilization(String allowBudgetUtilization)
	{
		this.allowBudgetUtilization = allowBudgetUtilization;
	}

	public String getGlAccount()
	{
		return glAccount;
	}

	public void setGlAccount(String glAccount)
	{
		this.glAccount = glAccount;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public String getAssignedProjectToPurchaseCost()
	{
		return assignedProjectToPurchaseCost;
	}

	public void setAssignedProjectToPurchaseCost(String assignedProjectToPurchaseCost)
	{
		this.assignedProjectToPurchaseCost = assignedProjectToPurchaseCost;
	}

	public boolean isBookCostToSingleCostCenter()
	{
		return bookCostToSingleCostCenter;
	}

	public void setBookCostToSingleCostCenter(boolean bookCostToSingleCostCenter)
	{
		this.bookCostToSingleCostCenter = bookCostToSingleCostCenter;
	}

	public boolean isSplitCostToMultipleCostCenter()
	{
		return splitCostToMultipleCostCenter;
	}

	public void setSplitCostToMultipleCostCenter(boolean splitCostToMultipleCostCenter)
	{
		this.splitCostToMultipleCostCenter = splitCostToMultipleCostCenter;
	}

	public boolean isSplitCostAtLineItemLevel()
	{
		return splitCostAtLineItemLevel;
	}

	public void setSplitCostAtLineItemLevel(boolean splitCostAtLineItemLevel)
	{
		this.splitCostAtLineItemLevel = splitCostAtLineItemLevel;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(String costCenter)
	{
		this.costCenter = costCenter;
	}

	public String getBudget()
	{
		return budget;
	}

	public void setBudget(String budget)
	{
		this.budget = budget;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public List<CostCenterSplitInfo> getListOfSplitedCostCenters()
	{
		return listOfSplitedCostCenters;
	}

	public void setListOfSplitedCostCenters(List<CostCenterSplitInfo> listOfSplitedCostCenters)
	{
		this.listOfSplitedCostCenters = listOfSplitedCostCenters;
	}

	@Override
	public String toString()
	{
		return "CostBookingRequisitionSummary [assignedProjectToPurchaseCost=" + assignedProjectToPurchaseCost + ", bookCostToSingleCostCenter=" + bookCostToSingleCostCenter
			+ ", splitCostToMultipleCostCenter=" + splitCostToMultipleCostCenter + ", splitCostAtLineItemLevel=" + splitCostAtLineItemLevel + ", costCenter=" + costCenter
			+ ", budget=" + budget + ", project=" + project + ", nextAction=" + nextAction + ", listOfSplitedCostCenters=" + listOfSplitedCostCenters + ", glAccount=" + glAccount
			+ ", allowBudgetUtilization=" + allowBudgetUtilization + "]";
	}
	
	

}
