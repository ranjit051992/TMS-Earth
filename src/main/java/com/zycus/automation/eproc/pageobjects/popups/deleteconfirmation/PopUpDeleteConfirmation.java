/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpDeleteConfirmation
{
	static Logger logger = Logger.getLogger(PopUpDeleteConfirmation.class);

	public static void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
			deleteConfirmation.clickOnYesButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnYesButton " + e, e);
		}
	}

	public static void clickOnNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
			deleteConfirmation.clickOnNoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnYesButton " + e, e);
		}
	}

	public static boolean isYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
			return deleteConfirmation.isYesButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isYesButtonPresent " + e, e);
		}
		return false;
	}

	public static boolean isNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
			return deleteConfirmation.isNoButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isNoButtonPresent " + e, e);
		}
		return false;
	}

	public static void clickOnPODeleteYES(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
		deleteConfirmation.clickOnPODeleteYES(driver, testCaseName);
	}

	public static void clickOnPODeleteNO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
		deleteConfirmation.clickOnPODeleteNO(driver, testCaseName);
	}

	public static boolean isDeleteConfirmationMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpDeleteConfirmation deleteConfirmation = FactoryPage.getInstanceOf(IPopUpDeleteConfirmationImpl.class);
		return deleteConfirmation.isDeleteConfirmationMessagePresent(driver, testCaseName);
	}

}
