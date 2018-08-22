package com.zycus.automation.eproc.pageobjects.pages.settings.documentinformationsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageDocumentInformationSettings
{
	public static void clickOnRequisitionInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		iPageDocumentInformationSettings.clickOnRequisitionInfo(driver, testCaseName);
	}

	public static void clickOnPOInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		iPageDocumentInformationSettings.clickOnPOInfo(driver, testCaseName);
	}

	public static String fillPODetailsTemplate(WebDriver driver, String testCaseName, String detailsTemplate) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		return iPageDocumentInformationSettings.fillPODetailsTemplate(driver, testCaseName, detailsTemplate);
	}

	public static String fillPOItemRowTemplate(WebDriver driver, String testCaseName, String itemRowTemplate) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		return iPageDocumentInformationSettings.fillPOItemRowTemplate(driver, testCaseName, itemRowTemplate);
	}

	public static void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		iPageDocumentInformationSettings.clickOnSave(driver, testCaseName);
	}

	public static String getDetailsTemplate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		return iPageDocumentInformationSettings.getDetailsTemplate(driver, testCaseName);
	}

	public static String getItemRowTemplate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageDocumentInformationSettings iPageDocumentInformationSettings = FactoryPage.getInstanceOf(IPageDocumentInformationSettingsImpl.class);
		return iPageDocumentInformationSettings.getItemRowTemplate(driver, testCaseName);
	}
}
