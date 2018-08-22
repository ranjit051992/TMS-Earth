/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invoicelisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageInvoiceListing
{
	static Logger logger = Logger.getLogger(PageInvoiceListing.class);

	public static void clickOnFromPurchaseOrderButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			invoiceListing.clickOnFromPurchaseOrderButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFromPurchaseOrderButton " + e, e);
		}
	}

	public static void clickOnCreateNonInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			invoiceListing.clickOnCreateNonInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateNonInvoiceButton " + e, e);
		}
	}

	public static void clickOnFilterInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			invoiceListing.clickOnFilterInvoiceNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFilterInvoiceNo " + e, e);
		}
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			return invoiceListing.fillSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierName " + e, e);
		}
		return null;
	}

	public static void clickOnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			invoiceListing.clickOnInvoiceActions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInvoiceActions " + e, e);
		}
	}

	public static String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			return invoiceListing.getFirstInvoiceStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstInvoiceStatus " + e, e);
		}
		return null;
	}

	public static String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			return invoiceListing.getFirstInvoiceNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstInvoiceNo " + e, e);
		}
		return null;
	}

	public static void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageInvoiceListing invoiceListing = FactoryPage.getInstanceOf(IPageInvoiceListingImpl.class);
			invoiceListing.clickOnFirstInvoiceNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstInvoiceNo " + e, e);
		}
	}

}
