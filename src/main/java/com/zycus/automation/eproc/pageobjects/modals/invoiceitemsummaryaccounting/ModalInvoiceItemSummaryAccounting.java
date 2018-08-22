/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummaryaccounting;

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
public class ModalInvoiceItemSummaryAccounting
{

	static Logger logger = Logger.getLogger(ModalInvoiceCostBookingSummary.class);

	public static String fillAccountingGLType(WebDriver driver, String testCaseName, String accountingGLType) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryAccounting itemSummaryAccounting = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryAccountingImpl.class);
			return itemSummaryAccounting.fillAccountingGLType(driver, testCaseName, accountingGLType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAccountingGLType " + e, e);
		}
		return null;
	}

	public static String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryAccounting itemSummaryAccounting = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryAccountingImpl.class);
			return itemSummaryAccounting.fillAccountingGLAccount(driver, testCaseName, accountingGLAccountCode);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAccountingGLAccount " + e, e);
		}
		return null;
	}

	public static String getGlAccountType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryAccounting itemSummaryAccounting = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryAccountingImpl.class);
			return itemSummaryAccounting.getGlAccountType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGlAccountType " + e, e);
		}
		return null;
	}

	public static String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryAccounting itemSummaryAccounting = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryAccountingImpl.class);
			return itemSummaryAccounting.getGlAccount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGlAccount " + e, e);
		}
		return null;
	}

}
