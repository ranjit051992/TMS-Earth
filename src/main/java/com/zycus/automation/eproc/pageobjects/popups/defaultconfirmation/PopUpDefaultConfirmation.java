/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpDefaultConfirmation
{

	static Logger logger = Logger.getLogger(PopUpDefaultConfirmation.class);

	public static void clickOnConfirmYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			defaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmYesButton " + e, e);
		}
	}

	public static void clickOnConfirmNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			defaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmNoButton " + e, e);
		}
	}

	public static boolean isConfirmYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			return defaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isConfirmYesButtonPresent " + e, e);
		}
		return false;
	}

	public static boolean isConfirmNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			return defaultConfirmation.isConfirmNoButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isConfirmNoButtonPresent " + e, e);
		}
		return false;
	}

	public static String getPopUpMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			return defaultConfirmation.getPopUpMsg(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPopUpMsg " + e, e);
		}
		return null;
	}

	public static String getTextOfYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			return defaultConfirmation.getTextOfYesButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTextOfYesButton " + e, e);
		}
		return null;
	}

	public static String getTextOfNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
			return defaultConfirmation.getTextOfNoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTextOfNoButton " + e, e);
		}
		return null;
	}

	public static void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpDefaultConfirmation defaultConfirmation = FactoryPage.getInstanceOf(IPopUpDefaultConfirmationImpl.class);
		defaultConfirmation.clickOnOkButton(driver, testCaseName);
	}

}
