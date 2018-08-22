/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.popups.FactoryPopUp;
import com.zycus.automation.eproc.pageobjects.popups.defaults.IPopUpDefaultOperations;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author puneet.sharma
 *
 */
public class PopUpEmptyCartConfirmation
{

	static Logger logger = Logger.getLogger(PopUpEmptyCartConfirmation.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean isPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultOperations iPopUpEmptyCartConfirmation = FactoryPopUp.getInstanceOfIPopUpEmptyCartConfirmation();
			iPopUpEmptyCartConfirmation.isPopUpPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPopUpPresent " + e, e);
		}
		return false;
	}

	public static void yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultOperations iPopUpEmptyCartConfirmation = FactoryPopUp.getInstanceOfIPopUpEmptyCartConfirmation();
			iPopUpEmptyCartConfirmation.accept(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  yes" + e, e);
		}

	}

	public static void no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultOperations iPopUpEmptyCartConfirmation = FactoryPopUp.getInstanceOfIPopUpEmptyCartConfirmation();
			iPopUpEmptyCartConfirmation.reject(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  no" + e, e);
		}

	}

	public static void closePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultOperations iPopUpEmptyCartConfirmation = FactoryPopUp.getInstanceOfIPopUpEmptyCartConfirmation();
			iPopUpEmptyCartConfirmation.closePopUp(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  close" + e, e);
		}

	}

	public static void moveOnPop(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpDefaultOperations iPopUpEmptyCartConfirmation = FactoryPopUp.getInstanceOfIPopUpEmptyCartConfirmation();
			iPopUpEmptyCartConfirmation.moveOnPop(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  moveOnPop" + e, e);
		}

	}

}
