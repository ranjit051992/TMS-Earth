/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PagePOInvoiceListing
{

	public static String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		return poInvoiceListing.getFirstInvoiceNo(driver, testCaseName);
	}

	public static String getFirstInvoiceDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		return poInvoiceListing.getFirstInvoiceDate(driver, testCaseName);
	}

	public static String getFirstInvoiceDueDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		return poInvoiceListing.getFirstInvoiceDueDate(driver, testCaseName);
	}

	public static String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		return poInvoiceListing.getFirstInvoiceStatus(driver, testCaseName);
	}

	public static void clickOnPOInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		poInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
	}

	public static void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		poInvoiceListing.clickOnFirstInvoiceNo(driver, testCaseName);
	}

	public static void clickOnCreateInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		poInvoiceListing.clickOnCreateInvoice(driver, testCaseName);
	}

	public static void clickOnReturnInvoiceAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePOInvoiceListing poInvoiceListing = FactoryPage.getInstanceOf(IPagePOInvoiceListingImpl.class);
		poInvoiceListing.clickOnReturnInvoiceAction(driver, testCaseName);
	}

}
