/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addbudgetperiod;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAddBudgetPeriod
{
	static Logger logger = Logger.getLogger(ModalAddBudgetPeriod.class);

	public static String selectStartDateForPeriod(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.selectStartDateForPeriod(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in selectStartDateForPeriod method " + e, e);
		}
		return null;
	}

	public static String selectEndDateForPeriod(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.selectEndDateForPeriod(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in selectEndDateForPeriod method " + e, e);
		}
		return null;
	}

	public static String fillPeriodName(WebDriver driver, String testCaseName, String periodName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.fillPeriodName(driver, testCaseName, periodName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in fillPeriodName method " + e, e);
		}
		return null;
	}

	public static String fillPeriodDescription(WebDriver driver, String testCaseName, String periodDescription) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.fillPeriodDescription(driver, testCaseName, periodDescription);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in fillPeriodDescription method " + e, e);
		}
		return null;
	}

	public static void clickOnAddPeriodButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			addBudgetPeriod.clickOnAddPeriodButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in clickOnAddPeriodButton method " + e, e);
		}
	}

	public static void clickOnClosePeriodButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			addBudgetPeriod.clickOnClosePeriodButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in clickOnClosePeriodButton method " + e, e);
		}
	}

	public static String getPeriodName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.getPeriodName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in getPeriodName method " + e, e);
		}
		return null;
	}

	public static boolean isAddPeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.isAddPeriodButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in isAddPeriodButtonPresent method " + e, e);
		}
		return false;
	}

	public static boolean isClosePeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddBudgetPeriod addBudgetPeriod = FactoryPage.getInstanceOf(IModalAddBudgetPeriodImpl.class);
			return addBudgetPeriod.isClosePeriodButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exeption in isClosePeriodButtonPresent method " + e, e);
		}
		return false;
	}
}
