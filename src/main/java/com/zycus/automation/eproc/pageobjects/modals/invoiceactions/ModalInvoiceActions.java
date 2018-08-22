/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceActions
{
	static Logger logger = Logger.getLogger(ModalInvoiceActions.class);

	public static void clickOnVoidInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnVoidInVoiceAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnVoidInVoiceAction " + e, e);
		}
	}

	public static void clickOnCloseInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnCloseInVoiceAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseInVoiceAction " + e, e);
		}
	}

	public static void clickOnReturnInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnReturnInVoiceAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnInVoiceAction " + e, e);
		}
	}

	public static void clickOnViewInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnViewInVoiceAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewInVoiceAction " + e, e);
		}
	}

	public static void clickOnConfirmAndMatchInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnConfirmAndMatchInVoiceAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmAndMatchInVoiceAction " + e, e);
		}
	}

	public static void clickOnRecallApprovalRequest(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceActions invoiceActions = FactoryPage.getInstanceOf(IModalInvoiceActionsImpl.class);
			invoiceActions.clickOnRecallApprovalRequest(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallApprovalRequest " + e, e);
		}
	}

}
