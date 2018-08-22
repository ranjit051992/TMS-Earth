/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closeinvoice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalCloseInvoice
{

	static Logger logger = Logger.getLogger(ModalCloseInvoice.class);

	public static String fillCloseComments(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		try
		{
			IModalCloseInvoice modalCloseInvoice = FactoryPage.getInstanceOf(IModalCloseInvoiceImpl.class);
			return modalCloseInvoice.fillCloseComments(driver, testCaseName, closeComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCloseComments " + e, e);
		}
		return null;
	}

	public static void clickOnCloseInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCloseInvoice modalCloseInvoice = FactoryPage.getInstanceOf(IModalCloseInvoiceImpl.class);
			modalCloseInvoice.clickOnCloseInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseInvoiceButton " + e, e);
		}
	}

	public static void clickOnCancelInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCloseInvoice modalCloseInvoice = FactoryPage.getInstanceOf(IModalCloseInvoiceImpl.class);
			modalCloseInvoice.clickOnCancelInvoiceButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelInvoiceButton " + e, e);
		}
	}

}
