package com.zycus.automation.eproc.pageobjects.pages.settings.addressmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageAddressMasterDataSettings
{
	public static void clickOnAddAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAddressMasterDataSettings iPageAddressMasterDataSettings = FactoryPage.getInstanceOf(IPageAddressMasterDataSettingsImpl.class);
		iPageAddressMasterDataSettings.clickOnAddAddress(driver, testCaseName);
	}

	public static String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException, FactoryMethodException
	{
		IPageAddressMasterDataSettings iPageAddressMasterDataSettings = FactoryPage.getInstanceOf(IPageAddressMasterDataSettingsImpl.class);
		return iPageAddressMasterDataSettings.enterCity(driver, testCaseName, city);
	}

	public static String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException, FactoryMethodException
	{
		IPageAddressMasterDataSettings iPageAddressMasterDataSettings = FactoryPage.getInstanceOf(IPageAddressMasterDataSettingsImpl.class);
		return iPageAddressMasterDataSettings.enterCounty(driver, testCaseName, county);
	}

	public static String enterFreeTextCounty(WebDriver driver, String testCaseName, String freeTextCounty) throws ActionBotException, FactoryMethodException
	{
		IPageAddressMasterDataSettings iPageAddressMasterDataSettings = FactoryPage.getInstanceOf(IPageAddressMasterDataSettingsImpl.class);
		return iPageAddressMasterDataSettings.enterFreeTextCounty(driver, testCaseName, freeTextCounty);
	}
}
