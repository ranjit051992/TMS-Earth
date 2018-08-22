package com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageBudgetSettings
{
	public static boolean clickOnAllowBudgetUtilizationYES(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBudgetSettings iPageBudgetSettings = FactoryPage.getInstanceOf(IPageBudgetSettingsImpl.class);
		return iPageBudgetSettings.clickOnAllowBudgetUtilizationYES(driver, testCaseName);
	}

	public static boolean clickOnAllowBudgetUtilizationNO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBudgetSettings iPageBudgetSettings = FactoryPage.getInstanceOf(IPageBudgetSettingsImpl.class);
		return iPageBudgetSettings.clickOnAllowBudgetUtilizationNO(driver, testCaseName);
	}

	public static boolean clickOnAllowBudgetUtilizationLetUserDecide(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBudgetSettings iPageBudgetSettings = FactoryPage.getInstanceOf(IPageBudgetSettingsImpl.class);
		return iPageBudgetSettings.clickOnAllowBudgetUtilizationLetUserDecide(driver, testCaseName);
	}
}
