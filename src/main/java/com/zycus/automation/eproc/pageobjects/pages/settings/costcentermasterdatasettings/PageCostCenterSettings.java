package com.zycus.automation.eproc.pageobjects.pages.settings.costcentermasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageCostCenterSettings
{
	public static void clickOnGoBtn(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnGoBtn(driver);

	}

	public static void clickOnActiveCCLin(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnActiveCCLin(driver);

	}

	public static void clickOnDeActivateCCLink(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnDeActiveCCLin(driver);

	}

	public static String fillSearchCostCenter(WebDriver driver, String testCaseName, String search) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		return iPageCostcenterSettings.fillSearchCostCenter(driver, testCaseName, search);
	}

	public static String selectSearchCCIn(WebDriver driver, String testCaseName, String selectCCIn) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		return iPageCostcenterSettings.selectSearchCCIn(driver, testCaseName, selectCCIn);
	}

	public static void clickOnEditCC(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnEditCC(driver, testCaseName);
	}

	public static void clickOnAllSelectedBUsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnAllSelectedBUsLink(driver, testCaseName);
	}

	public static String getFirstCostCenterSearched(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		return iPageCostcenterSettings.getFirstCostCenterSearched(driver, testCaseName);
	}

	public static void clickOnUpdateCostCenter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnUpdateCostCenter(driver, testCaseName);
	}

	public static void clickOnImportCCViaFiles(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnImportCCViaFiles(driver, testCaseName);
	}

	public static String fillFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		return iPageCostcenterSettings.fillFileName(driver, testCaseName, fileName);
	}

	public static void clickOnUploadCCButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCostCenterSettings iPageCostcenterSettings = FactoryPage.getInstanceOf(IPageCostCenterSettingsImpl.class);
		iPageCostcenterSettings.clickOnUploadCCButton(driver, testCaseName);
	}
}
