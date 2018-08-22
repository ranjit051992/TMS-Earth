/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBuersDeskListingActions
{

	static Logger logger = Logger.getLogger(ModalBuersDeskListingActions.class);

	public static void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
			buersDeskListingActions.clickOnEditAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditAction " + e, e);
		}
	}

	public static void clickOnConvertToPOAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
			buersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConvertToPOAction " + e, e);
		}
	}

	public static void clickOnChangeBuyerAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
			buersDeskListingActions.clickOnChangeBuyerAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnChangeBuyerAction " + e, e);
		}
	}

	public static void clickOnRejectAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
			buersDeskListingActions.clickOnRejectAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectAction " + e, e);
		}
	}

	public static boolean isRejectActionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
		return buersDeskListingActions.isRejectActionPresent(driver, testCaseName);
	}

	public static boolean isEditActionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
		return buersDeskListingActions.isEditActionPresent(driver, testCaseName);
	}

	public static boolean isViewActionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
		return buersDeskListingActions.isViewActionPresent(driver, testCaseName);
	}

	public static boolean isConvertToPOActionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
		return buersDeskListingActions.isConvertToPOActionPresent(driver, testCaseName);
	}

	public static boolean isChangeBuyerActionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuersDeskListingActions buersDeskListingActions = FactoryPage.getInstanceOf(IModalBuersDeskListingActionsImpl.class);
		return buersDeskListingActions.isChangeBuyerActionPresent(driver, testCaseName);
	}

}
