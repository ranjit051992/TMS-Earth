/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemdetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.invoicesummarycostbooking.ModalInvoiceCostBookingSummary;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceItemDetails
{

	static Logger logger = Logger.getLogger(ModalInvoiceCostBookingSummary.class);

	public static int fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.fillLineNo(driver, testCaseName, lineNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillLineNo " + e, e);
		}
		return 0;
	}

	public static String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.fillShortDescription(driver, testCaseName, shortDesc);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillShortDescription " + e, e);
		}
		return null;
	}

	public static String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.fillProductCategory(driver, testCaseName, productCategory);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductCategory " + e, e);
		}
		return null;
	}

	public static boolean clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.clickOnItemTypeGoods(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemTypeGoods " + e, e);
		}
		return false;
	}

	public static boolean clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.clickOnItemTypeServices(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemTypeServices " + e, e);
		}
		return false;
	}

	public static float fillMarketPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.fillMarketPrice(driver, testCaseName, price);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMarketPrice " + e, e);
		}
		return 0;
	}

	public static float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemDetails itemDetails = FactoryPage.getInstanceOf(IModalInvoiceItemDetailsImpl.class);
			return itemDetails.fillQuantity(driver, testCaseName, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
		return 0;
	}

}
