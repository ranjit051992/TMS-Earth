/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoiceitemsummary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class TabInvoiceItemSummary
{
	static Logger logger = Logger.getLogger(TabInvoiceItemSummary.class);

	public static void clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceItemSummary invoiceItemSummary = FactoryPage.getInstanceOf(ITabInvoiceItemSummaryImpl.class);
			invoiceItemSummary.clickOnItemTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemTab " + e, e);
		}
	}

	public static void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceItemSummary invoiceItemSummary = FactoryPage.getInstanceOf(ITabInvoiceItemSummaryImpl.class);
			invoiceItemSummary.clickOnCostBookingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostBookingTab " + e, e);
		}
	}

	public static void clickOnAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceItemSummary invoiceItemSummary = FactoryPage.getInstanceOf(ITabInvoiceItemSummaryImpl.class);
			invoiceItemSummary.clickOnAccountingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAccountingTab " + e, e);
		}
	}

	public static void clickOnAttachmentsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceItemSummary invoiceItemSummary = FactoryPage.getInstanceOf(ITabInvoiceItemSummaryImpl.class);
			invoiceItemSummary.clickOnAttachmentsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAttachmentsTab " + e, e);
		}
	}

	public static void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceItemSummary invoiceItemSummary = FactoryPage.getInstanceOf(ITabInvoiceItemSummaryImpl.class);
			invoiceItemSummary.clickOnTaxesTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnTaxesTab " + e, e);
		}
	}

}
