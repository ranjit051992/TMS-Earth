/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.voidinvoice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalVoidInvoice
{
	static Logger logger = Logger.getLogger(ModalVoidInvoice.class);

	public static String fillVoidInvoiceComment(WebDriver driver, String testCaseName, String voidComment) throws ActionBotException
	{
		try
		{
			IModalVoidInvoice modalVoidInvoice = FactoryPage.getInstanceOf(IModalVoidInvoiceImpl.class);
			return modalVoidInvoice.fillVoidInvoiceComment(driver, testCaseName, voidComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillVoidInvoiceComment " + e, e);
		}
		return null;
	}

	public static void clickOnVoidInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalVoidInvoice modalVoidInvoice = FactoryPage.getInstanceOf(IModalVoidInvoiceImpl.class);
			modalVoidInvoice.clickOnVoidInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnVoidInvoiceButton " + e, e);
		}
	}

	public static void clickOnCancelVoidButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalVoidInvoice modalVoidInvoice = FactoryPage.getInstanceOf(IModalVoidInvoiceImpl.class);
			modalVoidInvoice.clickOnCancelVoidButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelVoidButton " + e, e);
		}
	}

}
