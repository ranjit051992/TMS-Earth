/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicenofilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.invoiceactions.ModalInvoiceActions;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceNoFilter
{
	static Logger logger = Logger.getLogger(ModalInvoiceActions.class);

	public static String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		try
		{
			IModalInvoiceNoFilter invoiceNoFilter = FactoryPage.getInstanceOf(IModalInvoiceNoFilterImpl.class);
			return invoiceNoFilter.fillInvoiceNo(driver, testCaseName, invoiceNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInvoiceNo " + e, e);
		}
		return null;
	}

	public static void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceNoFilter invoiceNoFilter = FactoryPage.getInstanceOf(IModalInvoiceNoFilterImpl.class);
			invoiceNoFilter.clickOnInvoiceNoFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInvoiceNoFilterButton " + e, e);
		}
	}

}
