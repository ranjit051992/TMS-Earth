/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poinvoicelistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPOInvoiceListingActions
{
	public static void clickOnViewInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnViewInvoiceActions(driver, testCaseName);
	}

	public static void clickOnConfirmAndMatchInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnConfirmAndMatchInvoiceActions(driver, testCaseName);
	}

	public static void clickOnReturnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnReturnInvoiceActions(driver, testCaseName);
	}

	public static void clickOnVoidInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnVoidInvoiceActions(driver, testCaseName);
	}

	public static void clickOnRecallInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnRecallInvoiceActions(driver, testCaseName);
	}

	public static void clickOnEditInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnEditInvoiceActions(driver, testCaseName);
	}

	public static void clickOnCloseInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOInvoiceListingActions poInvoiceListingActions = FactoryPage.getInstanceOf(IModalPOInvoiceListingActionsImpl.class);
		poInvoiceListingActions.clickOnCloseInvoiceActions(driver, testCaseName);
	}
}
