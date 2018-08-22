package com.zycus.automation.eproc.pageobjects.pages.settings.costbookingsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageCostBookingSettings
{
	public static void clickOnProjects(WebDriver driver) throws FactoryMethodException
	{
		IPageCostBookingSettings iPageCostBookingSettings = FactoryPage.getInstanceOf(IPageCostBookingSettingsImpl.class);
		iPageCostBookingSettings.clickOnProjects(driver);

	}

	public static void clickOnBudget(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageCostBookingSettings iPageCostBookingSettings = FactoryPage.getInstanceOf(IPageCostBookingSettingsImpl.class);
		iPageCostBookingSettings.clickOnBudget(driver);
	}

	public static void clickOnAccounting(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostBookingSettings iPageCostBookingSettings = FactoryPage.getInstanceOf(IPageCostBookingSettingsImpl.class);
		iPageCostBookingSettings.clickOnAccounting(driver, testCaseName);
	}
}
