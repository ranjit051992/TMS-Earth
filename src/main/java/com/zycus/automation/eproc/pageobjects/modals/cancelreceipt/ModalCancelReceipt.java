/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cancelreceipt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalCancelReceipt
{

	static Logger logger = Logger.getLogger(ModalCancelReceipt.class);

	public static String fillCancelReceiptComment(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException
	{
		try
		{
			IModalCancelReceipt cancelReceipt = FactoryPage.getInstanceOf(IModalCancelReceiptImpl.class);
			return cancelReceipt.fillCancelReceiptComment(driver, testCaseName, receiptComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCancelReceiptComment " + e, e);
		}
		return null;
	}

	public static void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCancelReceipt cancelReceipt = FactoryPage.getInstanceOf(IModalCancelReceiptImpl.class);
			cancelReceipt.clickOnCancelReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelReceiptButton " + e, e);
		}
	}

	public static void clickOnCloseCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCancelReceipt cancelReceipt = FactoryPage.getInstanceOf(IModalCancelReceiptImpl.class);
			cancelReceipt.clickOnCloseCancelReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseCancelReceiptButton " + e, e);
		}
	}

}
