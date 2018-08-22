package com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageProjectsMasterDataSettings
{
	static Logger logger = Logger.getLogger(IPageProjectsMasterDataSettings.class);

	public static String getSearch(WebDriver driver, String testCaseName, String search) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.getSearch(driver, testCaseName, search);
	}

	public static void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
	}

	public static String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.getProjectName(driver, testCaseName);
	}

	public static void clickOnActive(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
	}

	public static void clickOnDelete(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnDelete(driver, testCaseName);
	}

	public static boolean isProjectActive(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.isProjectActive(driver, testCaseName);

	}

	public static boolean isProjectOutdated(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.isProjectOutdated(driver, testCaseName);
	}

	public static String fillProjectSearchBox(WebDriver driver, String testCaseName, String SearchItem) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);

	}

	public static void clickOnEdit(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
	}

	public static String getProjectManagername(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.getProjectManagername(driver, testCaseName);
	}

	public static String getDurationDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.getDurationDate(driver, testCaseName);
	}

	public static String getProjectCode(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.getProjectCode(driver, testCaseName);
	}

	public static void clickOnActiveProjectToDeactivateIt(WebDriver driver, String testCaseName, int id) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnActiveProjectToDeactivateIt(driver, testCaseName, id);
	}

	public static void clickOnDeActive(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
	}

	public static void clickOnAddProjectLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnAddProjectLink(driver, testCaseName);
	}

	public static int fillProjectNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.fillProjectNumber(driver, testCaseName, index);
	}

	public static String fillProjectName(WebDriver driver, String testCaseName, String name) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.fillProjectName(driver, testCaseName, name);
	}

	public static String fillProjectEndDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
			reqDate = iPageProjectsMasterDataSettings.fillProjectEndDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectprojectEndDate " + e, e);
		}
		return reqDate;
	}

	public static String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.selectCompany(driver, testCaseName, company);
	}

	public static void clickOnSaveAddedProject(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
	}

	public static void clickOnSelectBU(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnSelectBU(driver, testCaseName);
	}

	public static void clickOnClearDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		iPageProjectsMasterDataSettings.clickOnClearDate(driver, testCaseName);
	}

	public static String selectSearchProjectIn(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.selectSearchProjectIn(driver, testCaseName, searchIn);
	}

	public static boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.isDataTableEmptyPresent(driver, testCaseName);
	}

	public static boolean isProjectDeactive(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageProjectsMasterDataSettings iPageProjectsMasterDataSettings = FactoryPage.getInstanceOf(IPageProjectsMasterDataSettingsImpl.class);
		return iPageProjectsMasterDataSettings.isProjectDeactive(driver, testCaseName);
	}
}
