/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createbudget;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreateBudget
{
	static Logger logger = Logger.getLogger(PageCreateBudget.class);

	public static String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillOwnerName(driver, testCaseName, ownerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillOwnerName method " + e, e);
		}
		return null;
	}

	public static String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillCompanyName(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillCompanyName method " + e, e);
		}
		return null;
	}

	public static String fillCurrencyType(WebDriver driver, String testCaseName, String currencyType) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillCurrencyType(driver, testCaseName, currencyType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillCurrencyType method " + e, e);
		}
		return null;
	}

	public static String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetName(driver, testCaseName, budgetName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetName method " + e, e);
		}
		return null;
	}

	public static String fillBudgetNotes(WebDriver driver, String testCaseName, String budgetNotes) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetNotes(driver, testCaseName, budgetNotes);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetNotes method " + e, e);
		}
		return null;
	}

	public static String selectBudgetValidityDateFrom(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetValidityDateFrom(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetValidityDateFrom method " + e, e);
		}
		return null;
	}

	public static String selectBudgetValidityDateTo(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetValidityDateTo(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetValidityDateTo method " + e, e);
		}
		return null;
	}

	public static boolean selectDisplayUtilizationOfBudgetToApprovers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectDisplayUtilizationOfBudgetToApprovers(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectDisplayUtilizationOfBudgetToApprovers method " + e, e);
		}
		return false;
	}

	public static boolean selectDisplayUtilizationOfBudgetToRequesters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectDisplayUtilizationOfBudgetToRequesters(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectDisplayUtilizationOfBudgetToRequesters method " + e, e);
		}
		return false;
	}

	public static int fillPercentageConsumptionOfOwnerAsObserverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillPercentageConsumptionOfOwnerAsObserverToRequest(driver, testCaseName, percentageConsumption);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillPercentageConsumptionOfOwnerAsObserverToRequest method " + e, e);
		}
		return 0;
	}

	public static int fillPercentageConsumptionOfOwnerAsApproverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillPercentageConsumptionOfOwnerAsApproverToRequest(driver, testCaseName, percentageConsumption);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillPercentageConsumptionOfOwnerAsApproverToRequest method " + e, e);
		}
		return 0;
	}

	public static void clickOnAddAnotherBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnAddAnotherBudgetDimension method " + e, e);
		}
	}

	public static void clickOnGenerateBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnGenerateBudgetDimension method " + e, e);
		}
	}

	public static void clickOnAddBudgetLineButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnAddBudgetLineButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnAddBudgetLineButton method " + e, e);
		}
	}

	public static String fillBusinessUnit(WebDriver driver, String testCaseName, String BU) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBusinessUnit(driver, testCaseName, BU);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBusinessUnit method " + e, e);
		}
		return null;
	}

	public static String fillBudgetLineCode(WebDriver driver, String testCaseName, String budgetLineCode) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetLineCode(driver, testCaseName, budgetLineCode);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetLineCode method " + e, e);
		}
		return null;
	}

	public static String fillBudgetLineName(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetLineName(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetLineName method " + e, e);
		}
		return null;
	}

	public static String fillBudgetLineOwner(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetLineOwner(driver, testCaseName, ownerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetLineOwner method " + e, e);
		}
		return null;
	}

	public static String fillPlannedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillPlannedAmount(driver, testCaseName, amount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillPlannedAmount method " + e, e);
		}

		return null;
	}

	public static void clickOnSaveBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnSaveBudgetLine(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnSaveBudgetLine method " + e, e);
		}
	}

	public static void clickOnDeleteBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnDeleteBudgetLine(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnDeleteBudgetLine method " + e, e);
		}
	}

	public static String selectFirstBudgetPeriod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectFirstBudgetPeriod(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectFirstBudgetPeriod method " + e, e);
		}
		return null;
	}

	public static void clickOnSaveAndFreezeBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnSaveAndFreezeBudgetButton method " + e, e);
		}
	}

	public static void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnSaveAsDraftButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnSaveAsDraftButton method " + e, e);
		}
	}

	public static void clickOnCancelBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnCancelBudgetButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnCancelBudgetButton method " + e, e);
		}
	}

	public static String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getFromValidityDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getFromValidityDate method " + e, e);
		}
		return null;
	}

	public static String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getToValidityDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getToValidityDate method " + e, e);
		}
		return null;
	}

	public static String selectBudgetDimension(WebDriver driver, String testCaseName, String dimension, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetDimension(driver, testCaseName, dimension, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetDimension method " + e, e);
		}
		return null;
	}

	public static String fillBudgetLineLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetLineLocation(driver, testCaseName, location);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetLineLocation method " + e, e);
		}
		return null;
	}

	public static String fillBudgetLineCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillBudgetLineCostCenter(driver, testCaseName, costCenter);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillBudgetLineCostCenter method " + e, e);
		}
		return null;
	}

	public static String selectBudgetLineDepartment(WebDriver driver, String testCaseName, String department) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetLineDepartment(driver, testCaseName, department);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetLineDepartment method " + e, e);
		}
		return null;
	}

	public static String selectBudgetLineDesignation(WebDriver driver, String testCaseName, String designation) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetLineDesignation(driver, testCaseName, designation);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetLineDesignation method " + e, e);
		}
		return null;
	}

	public static void clickOnAutoGenerateCombinations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnAutoGenerateCombinations method " + e, e);
		}

	}

	public static void clickOnUploadViaFile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnUploadViaFile(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnUploadViaFile method " + e, e);
		}

	}

	public static String selectBudgetPeriod(WebDriver driver, String testCaseName, String periodName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.selectBudgetPeriod(driver, testCaseName, periodName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetPeriod method " + e, e);
		}
		return null;
	}

	public static String getBusinessUnitOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getBusinessUnitOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getBusinessUnitOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getLocationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getLocationOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getLocationOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getCostCenterOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getCostCenterOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getCostCenterOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getDepartmentOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getDepartmentOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getDepartmentOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getDesignationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getDesignationOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getDesignationOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getBudgetLineCode(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getBudgetLineCode(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getBudgetLineCode method " + e, e);
		}
		return null;
	}

	public static String getBudgetLineName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getBudgetLineName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getBudgetLineName method " + e, e);
		}
		return null;
	}

	public static String getOwnerOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getOwnerOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getOwnerOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static String getPlannedAmountOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getPlannedAmountOfBudgetLine(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getPlannedAmountOfBudgetLine method " + e, e);
		}
		return null;
	}

	public static void selectBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.selectBudgetLine(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in selectBudgetLine method " + e, e);
		}
	}

	public static void clickOnActionsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnActionsOfBudgetLine(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnActionsOfBudgetLine method " + e, e);
		}
	}

	public static boolean isBudgetLineDeleted(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.isBudgetLineDeleted(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in isBudgetLineDeleted method " + e, e);
		}
		return false;
	}

	public static String getToBudgetDateOnBudgetViewPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.getToBudgetDateOnBudgetViewPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in getToBudgetDateOnBudgetViewPage method " + e, e);
		}
		return null;
	}

	public static void clickOnSettingsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			createBudget.clickOnSettingsOfBudgetLine(driver, testCaseName, budgetLineName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in clickOnSettingsOfBudgetLine method " + e, e);
		}
	}

	public static String fillProjectBudgetLine(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		try
		{
			IPageCreateBudget createBudget = FactoryPage.getInstanceOf(IPageCreateBudgetImpl.class);
			return createBudget.fillProjectBudgetLine(driver, testCaseName, project);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in fillProjectBudgetLine method " + e, e);
		}
		return null;
	}

}
