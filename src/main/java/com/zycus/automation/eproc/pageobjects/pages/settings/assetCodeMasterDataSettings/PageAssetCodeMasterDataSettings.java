package com.zycus.automation.eproc.pageobjects.pages.settings.assetCodeMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageAssetCodeMasterDataSettings
{
	public static String fillSearchAssetCodes(WebDriver driver, String testCaseName, String assetCode) throws ActionBotException, FactoryMethodException
	{
		IPageAssetCodeMasterDataSettings iPageAssetCodeMasterDataSettings = FactoryPage.getInstanceOf(IPageAssetCodeMasterDataSettingsImpl.class);
		return iPageAssetCodeMasterDataSettings.fillSearchAssetCodes(driver, testCaseName, assetCode);
	}

	public static void clickOnGOAssetCodes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAssetCodeMasterDataSettings iPageAssetCodeMasterDataSettings = FactoryPage.getInstanceOf(IPageAssetCodeMasterDataSettingsImpl.class);
		iPageAssetCodeMasterDataSettings.clickOnGOAssetCodes(driver, testCaseName);
	}

	public static void clickOnActiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAssetCodeMasterDataSettings iPageAssetCodeMasterDataSettings = FactoryPage.getInstanceOf(IPageAssetCodeMasterDataSettingsImpl.class);
		iPageAssetCodeMasterDataSettings.clickOnActiveLinkAssetCode(driver, testCaseName);
	}

	public static void clickOnDeactiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAssetCodeMasterDataSettings iPageAssetCodeMasterDataSettings = FactoryPage.getInstanceOf(IPageAssetCodeMasterDataSettingsImpl.class);
		iPageAssetCodeMasterDataSettings.clickOnDeactiveLinkAssetCode(driver, testCaseName);
	}

	public static String selectAssetOptions(WebDriver driver, String testCaseName, String asset) throws ActionBotException, FactoryMethodException
	{
		IPageAssetCodeMasterDataSettings iPageAssetCodeMasterDataSettings = FactoryPage.getInstanceOf(IPageAssetCodeMasterDataSettingsImpl.class);
		return iPageAssetCodeMasterDataSettings.selectAssetOptions(driver, testCaseName, asset);
	}
}
