/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalClosePO
{

	static Logger logger = Logger.getLogger(ModalClosePO.class);

	public static String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		try
		{
			IModalClosePO modalClosePO = FactoryPage.getInstanceOf(IModalClosePOImpl.class);
			return modalClosePO.fillCloseComment(driver, testCaseName, closeComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCloseComment " + e, e);
		}
		return null;
	}

	public static void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalClosePO modalClosePO = FactoryPage.getInstanceOf(IModalClosePOImpl.class);
			modalClosePO.clickOnClosePO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClosePO " + e, e);
		}
	}

	public static void clickOnCancelClosePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalClosePO modalClosePO = FactoryPage.getInstanceOf(IModalClosePOImpl.class);
			modalClosePO.clickOnCancelClosePO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelClosePO " + e, e);
		}
	}

	public static void clickOnCheckBoxAllowCreatingInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalClosePO modalClosePO = FactoryPage.getInstanceOf(IModalClosePOImpl.class);
			modalClosePO.clickOnCheckBoxAllowCreatingInvoice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckBoxAllowCreatingInvoice " + e, e);
		}
	}

}
