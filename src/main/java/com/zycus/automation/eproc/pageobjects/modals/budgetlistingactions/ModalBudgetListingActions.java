/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlistingactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBudgetListingActions
{
	static Logger logger = Logger.getLogger(ModalBudgetListingActions.class);

	public static void clickOnViewBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			budgetListingActions.clickOnViewBudgetAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnViewBudgetAction method " + e, e);
		}
	}

	public static void clickOnDeactivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			budgetListingActions.clickOnDeactivateBudgetAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnDeactivateBudgetAction method " + e, e);
		}
	}

	public static void clickOnUpdateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			budgetListingActions.clickOnUpdateBudgetAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnUpdateBudgetAction method " + e, e);
		}
	}

	public static void clickOnAnalyzeBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			budgetListingActions.clickOnAnalyzeBudgetAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnAnalyzeBudgetAction method " + e, e);
		}
	}

	public static void clickOnActivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			budgetListingActions.clickOnActivateBudgetAction(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnActivateBudgetAction method " + e, e);
		}
	}

	public static boolean isUpdateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			return budgetListingActions.isUpdateBudgetActionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in isUpdateBudgetActionPresent method " + e, e);
		}
		return false;
	}

	public static boolean isDeactivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			return budgetListingActions.isDeactivateBudgetActionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in isDeactivateBudgetActionPresent method " + e, e);
		}
		return false;
	}

	public static boolean isViewBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			return budgetListingActions.isViewBudgetActionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in isViewBudgetActionPresent method " + e, e);
		}
		return false;
	}

	public static boolean isActivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBudgetListingActions budgetListingActions = FactoryPage.getInstanceOf(IModalBudgetListingActionsImpl.class);
			return budgetListingActions.isActivateBudgetActionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in isActivateBudgetActionPresent method " + e, e);
		}
		return false;
	}
}
