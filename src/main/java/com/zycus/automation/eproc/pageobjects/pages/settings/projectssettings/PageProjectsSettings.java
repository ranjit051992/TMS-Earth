package com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageProjectsSettings
{
	static Logger logger = Logger.getLogger(PageProjectsSettings.class);

	public static boolean clickOnAlways(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		boolean result = false;

		IPageProjectsSettings projectsSettings = FactoryPage.getInstanceOfProjectsSettings();
		result = projectsSettings.clickOnAlways(driver);
		return result;
	}

	public static boolean clickOnNever(WebDriver driver) throws ActionBotException
	{
		boolean result = false;

		IPageProjectsSettings projectsSettings = FactoryPage.getInstanceOfProjectsSettings();
		result = projectsSettings.clickOnNever(driver);
		return result;
	}

	public static boolean clickOnLetUsersDecide(WebDriver driver) throws ActionBotException
	{

		boolean result = false;
		IPageProjectsSettings projectsSettings = FactoryPage.getInstanceOfProjectsSettings();
		result = projectsSettings.clickOnLetUsersDecide(driver);
		return result;
	}

	public static String getAssignProjectToPurchaseCost(WebDriver driver) throws ActionBotException
	{
		String result = null;
		IPageProjectsSettings projectsSettings = FactoryPage.getInstanceOfProjectsSettings();
		result = projectsSettings.getAssignProjectToPurchaseCost(driver);
		return result;
	}

	public static boolean clickOnSave(WebDriver driver) throws ActionBotException
	{
		IPageProjectsSettings projectsSettings = FactoryPage.getInstanceOfProjectsSettings();
		return projectsSettings.clickOnSave(driver);
	}

	public static boolean isAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.isAssignProjectToPurchaseCost(driver, testCaseName);
	}

	public static boolean isYesSelected(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.isYesSelected(driver, testCaseName);
	}

	public static boolean isNoSelected(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.isNoSelected(driver, testCaseName);
	}

	public static boolean assignProjectSettingEnabledOrDisabled(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.assignProjectSettingEnabledOrDisabled(driver, testCaseName);
	}
	
	public static boolean clickOnDisplayAssetCodeForAssigningCodeToItem_Yes(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.clickOnDisplayAssetCodeForAssigningCodeToItem_Yes(driver);
	}

	public static boolean clickOnDisplayAssetCodeForAssigningCodeToItem_No(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageProjectsSettings IPageProjectsSettings;
		IPageProjectsSettings = FactoryPage.getInstanceOf(IPageProjectsSettingsImpl.class);
		return IPageProjectsSettings.clickOnDisplayAssetCodeForAssigningCodeToItem_No(driver);
	}
}
