package com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelChangeMultiple
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickChangeMultipleApply(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			checkout.clickChangeMultipleApply(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickChangeMultipleApply " + e, e);
		}
	}

	public static void clickChangeMultipleClose(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			checkout.clickChangeMultipleClose(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickChangeMultipleClose " + e, e);
		}

	}

	public static void clickClearChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			checkout.clickClearChangeMultipleDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickClearChangeMultipleDate " + e, e);
		}
	}

	public static String fillChangeMultipleBudget(WebDriver driver, String testCaseName, String changeMultipleBudget) throws ActionBotException
	{
		String budget = null;
		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			budget = checkout.fillChangeMultipleBudget(driver, testCaseName, changeMultipleBudget).trim();
			if (budget.trim().equalsIgnoreCase(changeMultipleBudget))
			{
				return budget;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillChangeMultipleBudget " + e, e);
		}
		return null;
	}

	public static String fillChangeMultipleCostCenter(WebDriver driver, String testCaseName, String changeMultipleCostCenter) throws ActionBotException
	{
		String costCenter = null;

		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			costCenter = checkout.fillChangeMultipleCostCenter(driver, testCaseName, changeMultipleCostCenter);
			if (costCenter.equalsIgnoreCase(changeMultipleCostCenter))
			{
				return costCenter;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillChangeMultipleCostCenter " + e, e);
		}
		return null;
	}

	public static String getChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String date = null;
		try
		{
			IModelChangeMultiple checkout = FactoryModal.getInstanceOfIModelChangeMultiple();
			checkout.getChangeMultipleDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getChangeMultipleDate " + e, e);
		}
		return date;
	}

	public static List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.getListOfAvailableGLAccounts(driver, testCaseName);
	}

	public static List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.getListOfNamesAvailableGLAccounts(driver, testCaseName);
	}

	public static String fillChangeMultipleGLAccount(WebDriver driver, String testCaseName, String changeMultipleGLAccount) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.fillChangeMultipleGLAccount(driver, testCaseName, changeMultipleGLAccount);
	}

	public static void clearChangeMultipleGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		changeMultiple.clearChangeMultipleGLAccount(driver, testCaseName);
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.fillSupplierName(driver, testCaseName, supplierName);
	}

	public static String fillChangeMultipleProject(WebDriver driver, String testCaseName, String project) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.fillChangeMultipleProject(driver, testCaseName, project);
	}

	public static String selectRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		return changeMultiple.selectRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		changeMultiple.clickDeliveryTab(driver, testCaseName);
	}

	public static void clickSupplierTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModelChangeMultiple changeMultiple = FactoryPage.getInstanceOf(IModelChangeMultipleImpl.class);
		changeMultiple.clickSupplierTab(driver, testCaseName);
	}
}
