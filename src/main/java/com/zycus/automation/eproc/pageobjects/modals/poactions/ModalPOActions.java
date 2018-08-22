package com.zycus.automation.eproc.pageobjects.modals.poactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalPOActions
{
	public static void clickOnCopyFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnCopyFromActions(driver, testCaseName);
	}

	public static void clickOnCreateReceiptFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
	}

	public static void clickOnCreateInvoiceFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
	}

	public static void clickOnClosePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnClosePOFromActions(driver, testCaseName);
	}

	public static void clickOnDeleteFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnDeleteFromActions(driver, testCaseName);
	}

	public static void clickOnDownloadFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnDownloadFromActions(driver, testCaseName);
	}

	public static void clickOnAmendPOFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
	}

	public static boolean isCopyPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		return iModalPOActions.isCopyPOFromActionsPresent(driver, testCaseName);
	}

	public static boolean isCreateReceiptFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		return iModalPOActions.isCreateReceiptFromActionsPresent(driver, testCaseName);
	}

	public static void clickOnReleasePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
	}

	public static void clickOnRecallApprovalRequestFromActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		iModalPOActions.clickOnRecallApprovalRequestFromActions(driver, testCaseName);
	}

	public static boolean isDownloadPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOActions iModalPOActions = FactoryPage.getInstanceOf(IModalPOActionsImpl.class);
		return iModalPOActions.isDownloadPOFromActionsPresent(driver, testCaseName);
	}

}
