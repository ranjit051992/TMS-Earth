/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BudgetLineSetting
{
	private int		budgetExceptionWorkflowUtilizationPercentage	= 0;
	private float	ownerInclusionUtilizationLimit					= 0;
	private int		exceedPercentTolerance							= 0;
	private float	exceedAmountTolerance							= 0;
	private boolean	exceedPercentToleranceToInfinite				= false;
	private boolean	exceedAmountToleranceToInfinite					= false;
	private String	nextAction										= null;

	public boolean isExceedPercentToleranceToInfinite()
	{
		return exceedPercentToleranceToInfinite;
	}

	public void setExceedPercentToleranceToInfinite(boolean exceedPercentToleranceToInfinite)
	{
		this.exceedPercentToleranceToInfinite = exceedPercentToleranceToInfinite;
	}

	public boolean isExceedAmountToleranceToInfinite()
	{
		return exceedAmountToleranceToInfinite;
	}

	public void setExceedAmountToleranceToInfinite(boolean exceedAmountToleranceToInfinite)
	{
		this.exceedAmountToleranceToInfinite = exceedAmountToleranceToInfinite;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public int getBudgetExceptionWorkflowUtilizationPercentage()
	{
		return budgetExceptionWorkflowUtilizationPercentage;
	}

	public void setBudgetExceptionWorkflowUtilizationPercentage(int budgetExceptionWorkflowUtilizationPercentage)
	{
		this.budgetExceptionWorkflowUtilizationPercentage = budgetExceptionWorkflowUtilizationPercentage;
	}

	public float getOwnerInclusionUtilizationLimit()
	{
		return ownerInclusionUtilizationLimit;
	}

	public void setOwnerInclusionUtilizationLimit(float ownerInclusionUtilizationLimit)
	{
		this.ownerInclusionUtilizationLimit = ownerInclusionUtilizationLimit;
	}

	public int getExceedPercentTolerance()
	{
		return exceedPercentTolerance;
	}

	public void setExceedPercentTolerance(int exceedPercentTolerance)
	{
		this.exceedPercentTolerance = exceedPercentTolerance;
	}

	public float getExceedAmountTolerance()
	{
		return exceedAmountTolerance;
	}

	public void setExceedAmountTolerance(float exceedAmountTolerance)
	{
		this.exceedAmountTolerance = exceedAmountTolerance;
	}

}
