package com.zycus.automation.eproc.pageobjects.pages.settings.configurationSetting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageConfigurationSetting
{
	public static void clickOnCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnCompany(driver, testCaseName);
	}

	public static String selectCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectCompanyName(driver, testCaseName, companyName);
	}

	public static String enterDefaultBuyerForCompany(WebDriver driver, String testCaseName, String defaultBuyer) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.enterDefaultBuyerForCompany(driver, testCaseName, defaultBuyer);
	}

	public static void clickOnUpdateCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnUpdateCompany(driver, testCaseName);
	}

	public static void clickOnBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnBusinessUnit(driver, testCaseName);
	}

	public static String selectCompanyForBU(WebDriver driver, String testCaseName, String companyForBU) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectCompanyForBU(driver, testCaseName, companyForBU);
	}

	public static String selectBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectBU(driver, testCaseName, BU);
	}

	public static String enterDefaultBuyerForBU(WebDriver driver, String testCaseName, String BUBuyer) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.enterDefaultBuyerForBU(driver, testCaseName, BUBuyer);
	}

	public static void clickOnUpdateBU(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnUpdateBU(driver, testCaseName);
	}

	public static void clickOnLocation(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnLocation(driver, testCaseName);
	}

	public static String selectCompanyForLocation(WebDriver driver, String testCaseName, String companyForLocation) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectCompanyForLocation(driver, testCaseName, companyForLocation);
	}

	public static String selectBUForLocation(WebDriver driver, String testCaseName, String BUForLocation) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectBUForLocation(driver, testCaseName, BUForLocation);
	}

	public static String selectLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.selectLocation(driver, testCaseName, location);
	}

	public static String enterDefaultBuyerForLocation(WebDriver driver, String testCaseName, String LocationBuyer) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.enterDefaultBuyerForLocation(driver, testCaseName, LocationBuyer);
	}

	public static void clickOnUpdateLocation(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		iPageConfigurationSetting.clickOnUpdateLocation(driver, testCaseName);
	}

	public static String enterMaxTermsAndConditions(WebDriver driver, String testCaseName, String termsAndConditions) throws ActionBotException, FactoryMethodException
	{
		IPageConfigurationSetting iPageConfigurationSetting = FactoryPage.getInstanceOf(IPageConfigurationSettingImpl.class);
		return iPageConfigurationSetting.enterMaxTermsAndConditions(driver, testCaseName, termsAndConditions);
	}
}
