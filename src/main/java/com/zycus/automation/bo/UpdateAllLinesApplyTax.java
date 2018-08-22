package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author ankita.sawant
 *
 */
public class UpdateAllLinesApplyTax
{
	private List<Tax>	taxes								= new ArrayList<Tax>();
	private boolean		applyWhereApplicableAndNotDefined	= false;
	private boolean		applyWhereNotApplicable				= false;
	private boolean		overrideWhereDefined				= false;
	private boolean		taxesInclusiveOrNotApplicable		= false;
	private String		nextAction							= null;

	public List<Tax> getTaxes()
	{
		return taxes;
	}

	public void setTaxes(List<Tax> taxes)
	{
		this.taxes = taxes;
	}

	public boolean isApplyWhereApplicableAndNotDefined()
	{
		return applyWhereApplicableAndNotDefined;
	}

	public void setApplyWhereApplicableAndNotDefined(boolean applyWhereApplicableAndNotDefined)
	{
		this.applyWhereApplicableAndNotDefined = applyWhereApplicableAndNotDefined;
	}

	public boolean isApplyWhereNotApplicable()
	{
		return applyWhereNotApplicable;
	}

	public void setApplyWhereNotApplicable(boolean applyWhereNotApplicable)
	{
		this.applyWhereNotApplicable = applyWhereNotApplicable;
	}

	public boolean isOverrideWhereDefined()
	{
		return overrideWhereDefined;
	}

	public void setOverrideWhereDefined(boolean overrideWhereDefined)
	{
		this.overrideWhereDefined = overrideWhereDefined;
	}

	public boolean isTaxesInclusiveOrNotApplicable()
	{
		return taxesInclusiveOrNotApplicable;
	}

	public void setTaxesInclusiveOrNotApplicable(boolean taxesInclusiveOrNotApplicable)
	{
		this.taxesInclusiveOrNotApplicable = taxesInclusiveOrNotApplicable;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
