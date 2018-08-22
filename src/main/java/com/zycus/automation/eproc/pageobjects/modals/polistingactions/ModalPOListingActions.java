/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.polistingactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPOListingActions
{

	static Logger logger = Logger.getLogger(ModalPOListingActions.class);

	public static void clickOnRecallApprovalRequestLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnRecallApprovalRequestLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallApprovalRequestLink " + e, e);
		}
	}

	public static void clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnRemindApproverLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemindApproverLink " + e, e);
		}
	}

	public static void clickOnCopyLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnCopyLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyLink " + e, e);
		}
	}

	public static void clickOnDownloadLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnDownloadLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDownloadLink " + e, e);
		}
	}

	public static void clickOnCreateReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReceiptLink " + e, e);
		}
	}

	public static void clickOnCreateInvoiceLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnCreateInvoiceLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateInvoiceLink " + e, e);
		}
	}

	public static void clickOnCloseLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnCloseLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseLink " + e, e);
		}
	}

	public static void clickOnDeleteLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnDeleteLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteLink " + e, e);
		}
	}

	public static void clickOnAmendPOLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
			modalPOListingActions.clickOnAmendPOLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmendPOLink " + e, e);
		}
	}

	public static boolean isAmendPOLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOListingActions modalPOListingActions = FactoryPage.getInstanceOf(IModalPOListingActionsImpl.class);
		return modalPOListingActions.isAmendPOEnable(driver, testCaseName);
	}

}
