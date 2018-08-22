package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCostBooking;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.IModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class ModelItemBuyersdeskSummaryCostBooking
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickCostBookingItemSplitAdd(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickCostBookingItemSplitAdd(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCostBookingItemSplitAdd " + e, e);
		}

	}

	public static void clickCostBookingItemSplitDelete(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickCostBookingItemSplitDelete(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCostBookingItemSplitDelete " + e, e);
		}

	}

	public static String fillCostBookingItemSplitBudget(WebDriver driver, String testCaseName, String itemSplitBudget, String itemID, int index) throws ActionBotException
	{

		String budget = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			budget = itemSummary.fillCostBookingItemSplitBudget(driver, testCaseName, itemSplitBudget, itemID, index);
			if (budget.equalsIgnoreCase(itemSplitBudget))
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
			logger.error("Factory Method Exception in method fillCostBookingItemSplitBudget " + e, e);
		}
		return null;
	}

	public static String fillCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemSplitCostCenter, String itemID, int index) throws ActionBotException
	{

		String costcenter = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			costcenter = itemSummary.fillCostBookingItemSplitCostCenter(driver, testCaseName, itemSplitCostCenter, itemID, index);
			if (costcenter.equalsIgnoreCase(itemSplitCostCenter))
			{
				return costcenter;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitCostCenter " + e, e);
		}
		return null;
	}

	public static int fillCostBookingItemSplitPercentage(WebDriver driver, String testCaseName, int itemSplitPercentage, String itemID, int index) throws ActionBotException
	{

		int percentage = 0;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			percentage = itemSummary.fillCostBookingItemSplitPercentage(driver, testCaseName, itemSplitPercentage, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitPercentage " + e, e);
		}
		return percentage;
	}

	public static int fillCostBookingItemSplitQuantity(WebDriver driver, String testCaseName, int itemSplitQty, String itemID, int index) throws ActionBotException
	{

		int quantity = 0;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			quantity = itemSummary.fillCostBookingItemSplitQuantity(driver, testCaseName, itemSplitQty, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitQuantity " + e, e);
		}
		return quantity;
	}

	public static String getCostBookingItemSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String amount = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			amount = itemSummary.getCostBookingItemSplitAmount(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemSplitAmount " + e, e);
		}
		return amount;
	}

	public static String getCostBookingSingleSplitAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String amount = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			amount = itemSummary.getCostBookingSingleSplitAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingSingleSplitAmount " + e, e);
		}
		return amount;
	}

	public static String getCostBookingSingleSplitBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String budget = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			budget = itemSummary.getCostBookingSingleSplitBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingSingleSplitBudget " + e, e);
		}
		return budget;
	}

	public static String getCostBookingSingleSplitCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String costcenter = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			costcenter = itemSummary.getCostBookingSingleSplitCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingSingleSplitCostCenter " + e, e);
		}
		return costcenter;
	}

	public static boolean selectCostBookingOptionItemSplitPercent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean itemSplitPercent = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSplitPercent = itemSummary.selectCostBookingOptionItemSplitPercent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionItemSplitPercent " + e, e);
		}
		return itemSplitPercent;
	}

	public static boolean selectCostBookingOptionItemSplitQtyDelivery(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean deliveryQty = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			deliveryQty = itemSummary.selectCostBookingOptionItemSplitQtyDelivery(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionItemSplitQtyDelivery " + e, e);
		}
		return deliveryQty;
	}

	public static boolean selectCostBookingOptionItemSplitQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean splitQty = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			splitQty = itemSummary.selectCostBookingOptionItemSplitQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionItemSplitQuantity " + e, e);
		}
		return splitQty;
	}

	public static boolean selectCostBookingOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean multiSplit = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			multiSplit = itemSummary.selectCostBookingOptionMultiSplit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionMultiSplit " + e, e);
		}
		return multiSplit;
	}

	public static boolean selectCostBookingOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean singleSplit = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			singleSplit = itemSummary.selectCostBookingOptionSingleSplit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionSingleSplit " + e, e);
		}
		return singleSplit;
	}

	public String fillCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemSplitProject, String itemID, int index) throws ActionBotException
	{
		String project = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			project = itemSummary.fillCostBookingItemSplitProject(driver, testCaseName, itemSplitProject, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitProject " + e, e);
		}
		return project;
	}

	public static String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode, String itemID, int index) throws ActionBotException
	{
		String glAccount = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			glAccount = itemSummary.fillAccountingGLAccount(driver, testCaseName, accountingGLAccountCode, itemID, index);
			return glAccount;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAccountingGLAccount " + e, e);
		}
		return null;
	}

	public static String getMessageOfAccountingInfoFromQtip(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String message = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			message = itemSummary.getMessageOfAccountingInfoFromQtip(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getMessageOfAccountingInfoFromQtip " + e, e);
		}
		return message;
	}

	public static void clickOnSaveItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = new IModelItemBuyersdeskSummaryCostBookingImpl();
			// FactoryModal.getInstanceOfIModelItemSummaryCostBooking();

			itemSummary.clickOnSaveItemSummary(driver, testCaseName);

		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method clickOnSaveItemSummary " + e, e);
		}
	}

	public static void clickOnCancelItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = new IModelItemBuyersdeskSummaryCostBookingImpl();
			// FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnCancelItemSummary(driver, testCaseName);

		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method clickOnCancelItemSummary " + e, e);
		}
	}

	public static boolean isGLAccountPresent(WebDriver driver, String testCaseName, String id, int index) throws ActionBotException
	{
		boolean account = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = new IModelItemBuyersdeskSummaryCostBookingImpl();
			// FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			account = itemSummary.isGLAccountPresent(driver, testCaseName, id, index);

		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isGLAccountPresent " + e, e);
		}
		return account;
	}

	public static String getGLAccount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		String account = null;
		try
		{
			IModelItemSummaryCostBooking itemSummary = new IModelItemBuyersdeskSummaryCostBookingImpl();
			// FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			account = itemSummary.getGLAccount(driver, testCaseName, itemID, index);

		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method getGLAccount " + e, e);
		}
		return account;
	}

	public static boolean isProjectNonEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean project = false;
		try
		{
			IModelItemSummaryCostBooking itemSummary = new IModelItemBuyersdeskSummaryCostBookingImpl();
			// FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			project = itemSummary.isProjectNonEditable(driver, testCaseName);

		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isProjectNonEditable " + e, e);
		}
		return project;
	}

}
