package com.zycus.automation.eproc.pageobjects.pages.settings.accountingCostBookingSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageAccountingCostBookingSettings
{
	public static void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_YES(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAccountingCostBookingSettings iPageAccountingCostBookingSettings = FactoryPage.getInstanceOf(IPageAccountingCostBookingSettingsImpl.class);
		iPageAccountingCostBookingSettings.clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_YES(driver, testCaseName);
	}

	public static void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_NO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAccountingCostBookingSettings iPageAccountingCostBookingSettings = FactoryPage.getInstanceOf(IPageAccountingCostBookingSettingsImpl.class);
		iPageAccountingCostBookingSettings.clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_NO(driver, testCaseName);
	}
}
