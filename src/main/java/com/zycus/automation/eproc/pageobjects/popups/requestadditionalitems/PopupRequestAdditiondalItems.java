/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.requestadditionalitems;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopupRequestAdditiondalItems
{
	static Logger logger = Logger.getLogger(PopupRequestAdditiondalItems.class);

	public static void clickOnKeepItemAsItIsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupRequestAdditiondalItems additiondalItems = FactoryPage.getInstanceOf(IPopupRequestAdditiondalItemsImpl.class);
			additiondalItems.clickOnKeepItemAsItIsButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnKeepItemAsItIsButton " + e, e);
		}
	}

	public static void clickOnDeleteItemInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupRequestAdditiondalItems additiondalItems = FactoryPage.getInstanceOf(IPopupRequestAdditiondalItemsImpl.class);
			additiondalItems.clickOnDeleteItemInCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteItemInCart " + e, e);
		}
	}

	public static void clickOnCreateDraftReauisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupRequestAdditiondalItems additiondalItems = FactoryPage.getInstanceOf(IPopupRequestAdditiondalItemsImpl.class);
			additiondalItems.clickOnCreateDraftReauisition(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateDraftReauisition " + e, e);
		}
	}

}
