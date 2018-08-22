/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.budgetlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageBudgetListing
{
	static Logger logger = Logger.getLogger(PageBudgetListing.class);

	public static void clickOnAddBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.clickOnAddBudgetButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnAddBudgetButton method : " + e, e);
		}
	}

	public static String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.fillBudgetName(driver, testCaseName, budgetName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillBudgetName method : " + e, e);
		}
		return null;
	}

	public static String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.fillCompanyName(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillCompanyName method : " + e, e);
		}
		return null;
	}

	public static String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.fillOwnerName(driver, testCaseName, ownerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillOwnerName method : " + e, e);
		}
		return null;
	}

	public static void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.clickOnActions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnActions method : " + e, e);
		}
	}

	public static String getStatusOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getStatusOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getStatusOfFirstBudget method : " + e, e);
		}
		return null;
	}

	public static void clickOnAddPeriod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.clickOnAddPeriod(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnAddPeriod method : " + e, e);
		}
	}

	public static String getBudgetNameOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getBudgetNameOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getBudgetNameOfFirstBudget method : " + e, e);
		}
		return null;
	}

	public static String getCompanyOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getCompanyOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getCompanyOfFirstBudget method : " + e, e);
		}
		return null;
	}

	public static String getOwnerOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getOwnerOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getOwnerOfFirstBudget method : " + e, e);
		}
		return null;
	}

	public static String getPlannedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getPlannedAmountOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getPlannedAmountOfFirstBudget method : " + e, e);
		}
		return null;
	}

	public static void waitTillSuccessMsgIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.waitTillSuccessMsgIsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in waitTillSuccessMsgIsPresent method : " + e, e);
		}
	}

	public static void clickOnFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.clickOnFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnFirstBudget method : " + e, e);
		}
	}

	public static void fillBudgetBU(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			budgetListing.fillBudgetBU(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnFirstBudget method : " + e, e);
		}
	}

	public static String getBudgetBUOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getBudgetBUOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnFirstBudget method : " + e, e);
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	public static String getBudgetReservedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getBudgetReservedAmountOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnFirstBudget method : " + e, e);
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	public static String getBudgetBalanceAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBudgetListing budgetListing = FactoryPage.getInstanceOf(IPageBudgetListingImpl.class);
			return budgetListing.getBudgetBalanceAmountOfFirstBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnFirstBudget method : " + e, e);
		}
		return null;
	}

}
