package com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageGLAccountsMasterDataSettings
{
	public static String enterGLAccountInSearch(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, glaccount);
	}

	public static int selectGlAccountCode(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.selectGlAccountCode(driver, testCaseName, index);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
	}

	public static void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
	}

	public static void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
	}

	public static void clickOnAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnAddGLAccount(driver, testCaseName);
	}

	public static String enterGLAccountName(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.enterGLAccountName(driver, testCaseName, glAccount);
	}

	public static String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.selectCompany(driver, testCaseName, company);
	}

	public static String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.selectGLAccountType(driver, testCaseName, glAccountType);
	}

	public static Integer enterGLAccountCode(WebDriver driver, String testCaseName, int code) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.enterGLAccountCode(driver, testCaseName, code);
	}

	public static void clickOnApplyAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnApplyAddGLAccount(driver, testCaseName);
	}

	public static void clickOnDeleteGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		iPageGLAccountsMasterDataSettings.clickOnDeleteGLAccount(driver, testCaseName);
	}

	public static String getFirstListedGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageGLAccountsMasterDataSettings iPageGLAccountsMasterDataSettings = FactoryPage.getInstanceOf(IPageGLAccountsMasterDataSettingsImpl.class);
		return iPageGLAccountsMasterDataSettings.getFirstListedGLAccount(driver, testCaseName);
	}
}
