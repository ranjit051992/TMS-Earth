package com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageLocationMasterDataSettings
{
	public static String fillSearchBox(WebDriver driver, String testCaseName, String location) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);
		return iPageLocationMasterDataSettings.fillSearchBox(driver, testCaseName, location);
	}

	public static void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);
		iPageLocationMasterDataSettings.clickOnGo(driver, testCaseName);
	}

	public static String getBillTOAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);
		return iPageLocationMasterDataSettings.getBillTOAddressLocationFromMasterData(driver, testCaseName);
	}

	public static String getDeliveryAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);
		return iPageLocationMasterDataSettings.getDeliveryAddressLocationFromMasterData(driver, testCaseName);
	}

	public static void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);

		iPageLocationMasterDataSettings.clickOnActiveLink(driver, testCaseName);
	}

	public static void clickOnInactiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageLocationMasterDataSettings iPageLocationMasterDataSettings = FactoryPage.getInstanceOf(IPageLocationMasterDataSettingsImpl.class);
		iPageLocationMasterDataSettings.clickOnInactiveLink(driver, testCaseName);
	}
}
