/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addtobasket;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAddToBasket
{

	static Logger logger = Logger.getLogger(ModalAddToBasket.class);

	public static void clickOnSelectExistingBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			addToBasket.clickOnSelectExistingBasket(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectExistingBasket " + e, e);
		}
	}

	public static String selectExistingBasket(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			return addToBasket.selectExistingBasket(driver, testCaseName, basketName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectExistingBasket " + e, e);
		}
		return null;
	}

	public static void clickOnCreateNewBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			addToBasket.clickOnCreateNewBasket(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateNewBasket " + e, e);
		}
	}

	public static String fillNewBasketName(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			return addToBasket.fillNewBasketName(driver, testCaseName, basketName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillNewBasketName " + e, e);
		}
		return null;
	}

	public static void clickOnAddToBasketButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			addToBasket.clickOnAddToBasketButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToBasketButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			addToBasket.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

	public static void waitTillAddToBasketSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddToBasket addToBasket = FactoryPage.getInstanceOf(IModalAddToBasketImpl.class);
			addToBasket.waitTillAddToBasketSuccessMessage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillAddToBasketSuccessMessage " + e, e);
		}

	}

}
