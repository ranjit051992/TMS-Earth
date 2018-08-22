/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.returninvoice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalReturnInvoice
{
	static Logger logger = Logger.getLogger(ModalReturnInvoice.class);

	public static String fillReturnInvoiceComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException
	{
		try
		{
			IModalReturnInvoice returnInvoice = FactoryPage.getInstanceOf(IModalReturnInvoiceImpl.class);
			return returnInvoice.fillReturnInvoiceComment(driver, testCaseName, returnComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnInvoiceComment " + e, e);
		}
		return null;
	}

	public static void clickOnReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalReturnInvoice returnInvoice = FactoryPage.getInstanceOf(IModalReturnInvoiceImpl.class);
			returnInvoice.clickOnReturnInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnInvoiceButton " + e, e);
		}
	}

	public static void clickOnCancelReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalReturnInvoice returnInvoice = FactoryPage.getInstanceOf(IModalReturnInvoiceImpl.class);
			returnInvoice.clickOnCancelReturnInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelReturnInvoiceButton " + e, e);
		}
	}

}
