/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlineactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBudgetLineActions
{
	static Logger logger = Logger.getLogger(ModalBudgetLineActions.class);

	public static void clickOnEditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IModalBudgetLineActions budgetLineActions = FactoryPage.getInstanceOf(IModalBudgetLineActionsImpl.class);
			budgetLineActions.clickOnEditAction(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnEditAction method");
		}
	}

	public static void clickOndeleteAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IModalBudgetLineActions budgetLineActions = FactoryPage.getInstanceOf(IModalBudgetLineActionsImpl.class);
			budgetLineActions.clickOndeleteAction(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOndeleteAction method");
		}
	}

	public static void clickOnAuditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IModalBudgetLineActions budgetLineActions = FactoryPage.getInstanceOf(IModalBudgetLineActionsImpl.class);
			budgetLineActions.clickOnAuditAction(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnAuditAction method");
		}
	}
}
