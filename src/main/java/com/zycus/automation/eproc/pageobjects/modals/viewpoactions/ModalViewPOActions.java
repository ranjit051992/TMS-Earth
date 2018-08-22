/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.viewpoactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalViewPOActions
{
	static Logger logger = Logger.getLogger(ModalViewPOActions.class);

	public static void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnPreviewPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPreviewPoLink " + e, e);
		}
	}

	public static void clickOnPrintPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnPrintPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPrintPoLink " + e, e);
		}
	}

	public static void clickOnPDFPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnPDFPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPDFPoLink " + e, e);
		}
	}

	public static void clickOnEmailPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnEmailPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEmailPoLink " + e, e);
		}
	}

	public static void clickOnCopyPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnCopyPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyPoLink " + e, e);
		}
	}

	public static void clickOnRemindPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnRemindPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemindPoLink " + e, e);
		}
	}

	public static void clickOnCreateReceiptPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnCreateReceiptPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReceiptPoLink " + e, e);
		}
	}

	public static void clickOnCreateInvoicePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnCreateInvoicePoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateInvoicePoLink " + e, e);
		}
	}

	public static void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnCancelPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelPoLink " + e, e);
		}
	}

	public static void clickOnClosePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnClosePoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClosePoLink " + e, e);
		}
	}

	public static void clickOnAmendPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnAmendPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmendPoLink " + e, e);
		}
	}
	
	public static void clickOnReleasePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnReleasePoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasePoLink " + e, e);
		}
	}
	
	public static void clickOnReleasePoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnReleasePOButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasePOButton " + e, e);
		}
	}

	/*
	 * author : bhakti.sawant
	 */
	public static void clickOnCreateReceiptViewPoDrpodownLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalViewPOActions modalViewPOActions = FactoryPage.getInstanceOf(IModalViewPOActionsImpl.class);
			modalViewPOActions.clickOnCreateReceiptViewPoDrpodownLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReceiptPoLink " + e, e);
		}
	}
}
