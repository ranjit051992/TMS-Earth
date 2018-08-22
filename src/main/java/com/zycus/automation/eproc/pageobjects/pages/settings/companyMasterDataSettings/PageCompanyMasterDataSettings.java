package com.zycus.automation.eproc.pageobjects.pages.settings.companyMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageCompanyMasterDataSettings
{
	public static String fillSearchCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException, FactoryMethodException
	{
		IPageCompanyMasterDataSettings iPageCompanyMasterDataSettings = FactoryPage.getInstanceOf(IPageCompanyMasterDataSettingsImpl.class);
		return iPageCompanyMasterDataSettings.fillSearchCompanyName(driver, testCaseName, companyName);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCompanyMasterDataSettings iPageCompanyMasterDataSettings = FactoryPage.getInstanceOf(IPageCompanyMasterDataSettingsImpl.class);
		iPageCompanyMasterDataSettings.clickOnGO(driver, testCaseName);
	}

	public static void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCompanyMasterDataSettings iPageCompanyMasterDataSettings = FactoryPage.getInstanceOf(IPageCompanyMasterDataSettingsImpl.class);
		iPageCompanyMasterDataSettings.clickOnActiveLink(driver, testCaseName);
	}

	public static void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCompanyMasterDataSettings iPageCompanyMasterDataSettings = FactoryPage.getInstanceOf(IPageCompanyMasterDataSettingsImpl.class);
		iPageCompanyMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
	}
}
