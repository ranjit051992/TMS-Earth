package com.zycus.automation.eproc.pageobjects.pages.settings.businessUnitMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageBusinessUnitMasterDataSettings
{
	public static String fillBUSearchName(WebDriver driver, String testCaseName, String buName) throws ActionBotException, FactoryMethodException
	{
		IPageBusinessUnitMasterDataSettings iPageBusinessUnitMasterDataSettings = FactoryPage.getInstanceOf(IPageBusinessUnitMasterDataSettingsImpl.class);
		return iPageBusinessUnitMasterDataSettings.fillBUSearchName(driver, testCaseName, buName);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBusinessUnitMasterDataSettings iPageBusinessUnitMasterDataSettings = FactoryPage.getInstanceOf(IPageBusinessUnitMasterDataSettingsImpl.class);
		iPageBusinessUnitMasterDataSettings.clickOnGO(driver, testCaseName);
	}

	public static void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBusinessUnitMasterDataSettings iPageBusinessUnitMasterDataSettings = FactoryPage.getInstanceOf(IPageBusinessUnitMasterDataSettingsImpl.class);
		iPageBusinessUnitMasterDataSettings.clickOnActiveLink(driver, testCaseName);
	}

	public static void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBusinessUnitMasterDataSettings iPageBusinessUnitMasterDataSettings = FactoryPage.getInstanceOf(IPageBusinessUnitMasterDataSettingsImpl.class);
		iPageBusinessUnitMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
	}
}
