package com.zycus.automation.eproc.pageobjects.pages.settings.glmapsmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageGLMapsMasterDataSettings
{
	public static String fillSearch(WebDriver driver, String testCaseName, String glmap) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, glmap);
	}

	public static String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.selectOption(driver, testCaseName, option);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
	}

	public static void clickOnDelete(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.clickOnDelete(driver, testCaseName);
	}

	public static void clickOnLinkAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.clickOnLinkAddGLRulesMap(driver, testCaseName);
	}

	public static String enterCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.enterCategory(driver, testCaseName, category);
	}

	public static String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.selectCompany(driver, testCaseName, company);
	}

	public static String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.selectPurchaseType(driver, testCaseName, purchaseType);
	}

	public static void clickOnAnyPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.clickOnAnyPurchaseType(driver, testCaseName);
	}

	public static String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.selectGLAccountType(driver, testCaseName, glAccountType);
	}

	public static String enterGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		return iPageGLMapsMasterDataSettings.enterGLAccount(driver, testCaseName, glAccount);
	}

	public static void clickOnSaveAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.clickOnSaveAddGLRulesMap(driver, testCaseName);
	}

	public static void selectCompanyAndBussinessUnitForGLRuleMap(WebDriver driver, String testCaseName, String company) throws ActionBotException, FactoryMethodException
	{
		IPageGLMapsMasterDataSettings iPageGLMapsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLMapsMasterDataSettingsImpl.class);
		iPageGLMapsMasterDataSettings.selectCompanyAndBussinessUnitForGLRuleMap(driver, testCaseName, company);
	}
}
