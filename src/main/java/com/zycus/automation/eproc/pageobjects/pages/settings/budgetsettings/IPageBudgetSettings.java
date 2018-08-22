package com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageBudgetSettings
{
	final static UI_Elements	ALLOW_BUDGET_UTILIZATION_YES				= UIFactory.getElements("ALLOW_BUDGET_UTILIZATION_YES");

	final static UI_Elements	ALLOW_BUDGET_UTILIZATION_LET_USER_DECIDE	= UIFactory.getElements("ALLOW_BUDGET_UTILIZATION_LET_USER_DECIDE");

	final static UI_Elements	ALLOW_BUDGET_UTILIZATION_NO					= UIFactory.getElements("ALLOW_BUDGET_UTILIZATION_NO");

	public boolean clickOnAllowBudgetUtilizationYES(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBudgetUtilizationNO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBudgetUtilizationLetUserDecide(WebDriver driver, String testCaseName) throws ActionBotException;

}
