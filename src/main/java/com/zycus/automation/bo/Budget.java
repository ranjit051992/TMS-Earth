/**
 * 
 */
package com.zycus.automation.bo;

import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class Budget
{
	private String				ownerName									= null;
	private String				companyName									= null;
	private String				currencyType								= null;
	private String				budgetName									= null;
	private String				budgetNotes									= null;
	private CustomDate			fromValidityDate							= null;
	private CustomDate			toValidityDate								= null;
	private boolean				displayUtilizationOfBudgetsToApprovers		= false;
	private boolean				displayUtilizationOfBudgetsToRequesters		= false;
	private int					percentageConsumpationForOwnerAsObserver	= 0;
	private int					percentageConsumpationForOwnerAsApprover	= 0;
	private boolean				isAddPeriod									= false;
	private boolean				isAddBudgetLine								= false;
	private BudgetPeriod		budgetPeriod								= null;
	private List<BudgetLine>	budgetLines									= null;
	private String				nextAction									= null;
	private boolean				isAddBudgetDimensions						= false;
	private BudgetDimension		budgetDimension								= null;

	public BudgetDimension getBudgetDimension()
	{
		return budgetDimension;
	}

	public void setBudgetDimension(BudgetDimension budgetDimension)
	{
		this.budgetDimension = budgetDimension;
	}

	public boolean isAddBudgetDimensions()
	{
		return isAddBudgetDimensions;
	}

	public void setAddBudgetDimensions(boolean isAddBudgetDimensions)
	{
		this.isAddBudgetDimensions = isAddBudgetDimensions;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public BudgetPeriod getBudgetPeriod()
	{
		return budgetPeriod;
	}

	public void setBudgetPeriod(BudgetPeriod budgetPeriod)
	{
		this.budgetPeriod = budgetPeriod;
	}

	public List<BudgetLine> getBudgetLines()
	{
		return budgetLines;
	}

	public void setBudgetLines(List<BudgetLine> budgetLines)
	{
		this.budgetLines = budgetLines;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getCurrencyType()
	{
		return currencyType;
	}

	public void setCurrencyType(String currencyType)
	{
		this.currencyType = currencyType;
	}

	public String getBudgetName()
	{
		return budgetName;
	}

	public void setBudgetName(String budgetName)
	{
		this.budgetName = budgetName;
	}

	public String getBudgetNotes()
	{
		return budgetNotes;
	}

	public void setBudgetNotes(String budgetNotes)
	{
		this.budgetNotes = budgetNotes;
	}

	public CustomDate getFromValidityDate()
	{
		return fromValidityDate;
	}

	public void setFromValidityDate(CustomDate fromValidityDate)
	{
		this.fromValidityDate = fromValidityDate;
	}

	public CustomDate getToValidityDate()
	{
		return toValidityDate;
	}

	public void setToValidityDate(CustomDate toValidityDate)
	{
		this.toValidityDate = toValidityDate;
	}

	public boolean isDisplayUtilizationOfBudgetsToApprovers()
	{
		return displayUtilizationOfBudgetsToApprovers;
	}

	public void setDisplayUtilizationOfBudgetsToApprovers(boolean displayUtilizationOfBudgetsToApprovers)
	{
		this.displayUtilizationOfBudgetsToApprovers = displayUtilizationOfBudgetsToApprovers;
	}

	public boolean isDisplayUtilizationOfBudgetsToRequesters()
	{
		return displayUtilizationOfBudgetsToRequesters;
	}

	public void setDisplayUtilizationOfBudgetsToRequesters(boolean displayUtilizationOfBudgetsToRequesters)
	{
		this.displayUtilizationOfBudgetsToRequesters = displayUtilizationOfBudgetsToRequesters;
	}

	public int getPercentageConsumpationForOwnerAsObserver()
	{
		return percentageConsumpationForOwnerAsObserver;
	}

	public void setPercentageConsumpationForOwnerAsObserver(int percentageConsumpationForOwnerAsObserver)
	{
		this.percentageConsumpationForOwnerAsObserver = percentageConsumpationForOwnerAsObserver;
	}

	public int getPercentageConsumpationForOwnerAsApprover()
	{
		return percentageConsumpationForOwnerAsApprover;
	}

	public void setPercentageConsumpationForOwnerAsApprover(int percentageConsumpationForOwnerAsApprover)
	{
		this.percentageConsumpationForOwnerAsApprover = percentageConsumpationForOwnerAsApprover;
	}

	public boolean isAddPeriod()
	{
		return isAddPeriod;
	}

	public void setAddPeriod(boolean isAddPeriod)
	{
		this.isAddPeriod = isAddPeriod;
	}

	public boolean isAddBudgetLine()
	{
		return isAddBudgetLine;
	}

	public void setAddBudgetLine(boolean isAddBudgetLine)
	{
		this.isAddBudgetLine = isAddBudgetLine;
	}

}
