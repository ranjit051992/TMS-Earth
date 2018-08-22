/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.continueshopping;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.popups.FactoryPopUp;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author puneet.sharma
 *
 */
public class PopUpContinueShopping
{

	static Logger logger = Logger.getLogger(PopUpContinueShopping.class);

	public static boolean isPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.isPopUpPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  isPopUpPresent" + e, e);
		}
		return false;
	}

	public static void accept(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.accept(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  accept" + e, e);
		}
	}

	public static void reject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.reject(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  reject" + e, e);
		}
	}

	public static void closePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.closePopUp(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  closePopUp" + e, e);
		}
	}

	public static void moveOnPop(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.moveOnPop(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  moveOnPop" + e, e);
		}
	}

	public static void continueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpContinueShopping iPopUpContinueShopping = FactoryPopUp.getInstanceOfIPopUpContinueShopping();
			iPopUpContinueShopping.continueShopping(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  continueShopping" + e, e);
		}

	}

}
