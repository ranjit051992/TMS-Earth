package com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPageBudgetSettingsImpl implements IPageBudgetSettings
{

	@Override
	public boolean clickOnAllowBudgetUtilizationYES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUDGET_UTILIZATION_YES);
		return ActionBot.isElementSelected(driver, ALLOW_BUDGET_UTILIZATION_YES);

	}

	@Override
	public boolean clickOnAllowBudgetUtilizationNO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUDGET_UTILIZATION_NO);
		return ActionBot.isElementSelected(driver, ALLOW_BUDGET_UTILIZATION_NO);

	}

	@Override
	public boolean clickOnAllowBudgetUtilizationLetUserDecide(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUDGET_UTILIZATION_LET_USER_DECIDE);
		return ActionBot.isElementSelected(driver, ALLOW_BUDGET_UTILIZATION_YES);
	}

}
