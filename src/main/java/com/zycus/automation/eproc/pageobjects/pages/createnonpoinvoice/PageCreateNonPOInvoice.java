/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreateNonPOInvoice
{
	static Logger logger = Logger.getLogger(PageCreateNonPOInvoice.class);

	public static void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnAddItemButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddItemButton " + e, e);
		}
	}

	public static void clickOnCancelEditingButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnCancelEditingButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelEditingButton " + e, e);
		}
	}

	public static void clickOnEditBillingAndDeliveryInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnEditBillingAndDeliveryInfo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditBillingAndDeliveryInfo " + e, e);
		}
	}

	public static void clickOnExpandAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnExpandAll(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandAll " + e, e);
		}
	}

	public static void clickOnIgnoreAndSubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnIgnoreAndSubmit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnIgnoreAndSubmit " + e, e);
		}
	}

	public static void clickOnitemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnitemCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnitemCheckBox " + e, e);
		}
	}

	public static void clickOnSavAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnSavAsDraftButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSavAsDraftButton " + e, e);
		}
	}

	public static void clickOnSubmitForConfirmation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnSubmitForConfirmation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitForConfirmation " + e, e);
		}
	}

	public static void clickOnSubmitInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnSubmitInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitInvoiceButton " + e, e);
		}
	}

	public static String fillBaseExchangeRate(WebDriver driver, String testCaseName, String baseExchangeRate) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.fillBaseExchangeRate(driver, testCaseName, baseExchangeRate);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBaseExchangeRate " + e, e);
		}
		return null;
	}

	public static String fillBuyer(WebDriver driver, String testCaseName, String buyerName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.fillBuyer(driver, testCaseName, buyerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBuyer " + e, e);
		}
		return null;
	}

	public static String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.fillCurrency(driver, testCaseName, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCurrency " + e, e);
		}
		return null;
	}

	public static void fillInvoiceItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.fillInvoiceItemQuantity(driver, testCaseName, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInvoiceItemQuantity " + e, e);
		}

	}

	public static String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.fillInvoiceNo(driver, testCaseName, invoiceNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInvoiceNo " + e, e);
		}
		return null;
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.fillSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierName " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfItemsAdded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.getListOfItemsAdded(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemsAdded " + e, e);
		}
		return null;
	}

	public static String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.selectFirstSupplierAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFirstSupplierAddress " + e, e);
		}
		return null;
	}

	public static String selectInvoiceDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.selectInvoiceDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectInvoiceDate " + e, e);
		}
		return null;
	}

	public static String selectInvoiceDueDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.selectInvoiceDueDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectInvoiceDueDate " + e, e);
		}
		return null;
	}

	public static String selectPaymentTerms(WebDriver driver, String testCaseName, String paymentTerms) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.selectPaymentTerms(driver, testCaseName, paymentTerms);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPaymentTerms " + e, e);
		}
		return null;
	}

	public static String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.selectPurchaseType(driver, testCaseName, purchaseType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPurchaseType " + e, e);
		}
		return null;
	}

	public static void clickOnSelectAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnSelectAllItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectAllItems " + e, e);
		}
	}

	public static void clickOnFirstItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnFirstItemCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstItemCheckbox " + e, e);
		}
	}

	/**
	 * @author Omkar.Jagdale
	 *         Invoice page add attachment link
	 */
	public static void clickOnAddAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.clickOnAddAttachments(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddAttachments " + e, e);
		}
	}

	/**
	 * @author bhakti.sawant
	 *         Invoice page add attachment
	 */
	public static void addAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			createNonPOInvoice.addAttachment(driver, testCaseName, fileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddAttachments " + e, e);
		}
	}

	public static String getPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateNonPOInvoice createNonPOInvoice = FactoryPage.getInstanceOf(IPageCreateNonPOInvoiceImpl.class);
			return createNonPOInvoice.getPONumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPONumber " + e, e);
		}
		return null;
	}
}
