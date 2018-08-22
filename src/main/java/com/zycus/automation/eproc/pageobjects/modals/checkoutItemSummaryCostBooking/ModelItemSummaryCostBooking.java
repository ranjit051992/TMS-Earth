package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class ModelItemSummaryCostBooking
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

	public static void clickOnBookCostTOSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnBookCostTOSingleCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBookCostTOSingleCostCenter " + e, e);
		}

	}

	public static String fillCostBookingItemSplitBudget(WebDriver driver, String testCaseName, String itemSplitBudget, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillCostBookingItemSplitBudget(driver, testCaseName, itemSplitBudget, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitBudget " + e, e);
		}
		return null;
	}

	public static String fillCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemSplitCostCenter, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillCostBookingItemSplitCostCenter(driver, testCaseName, itemSplitCostCenter, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitCostCenter " + e, e);
		}
		return null;
	}

	public static int fillCostBookingItemSplitPercentage(WebDriver driver, String testCaseName, int itemSplitPercentage, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillCostBookingItemSplitPercentage(driver, testCaseName, itemSplitPercentage, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingItemSplitPercentage " + e, e);
		}
		return 0;
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

	public static String fillCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemSplitProject, String itemID, int index) throws ActionBotException
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

	public static String getCostCenterForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getCostCenterForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterForCCSplitPropotionalToDelivery " + e, e);
		}
		return null;
	}

	public static String getDeliverToForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getDeliverToForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverToForCCSplitPropotionalToDelivery " + e, e);
		}
		return null;
	}

	public static String getDeliveryAddressForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getDeliveryAddressForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryAddressForCCSplitPropotionalToDelivery " + e, e);
		}
		return null;
	}

	public static int getQuantityForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getQuantityForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantityForCCSplitPropotionalToDelivery " + e, e);
		}
		return 0;
	}

	public static String getAmountForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getAmountForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAmountForCCSplitPropotionalToDelivery " + e, e);
		}
		return null;
	}

	// changed as per accounting-cost booking merging feature
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

	public static String getSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getSubTotalPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSubTotalPrice " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfAvailableGLAccounts(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfAvailableGLAccounts " + e, e);
		}
		return null;
	}

	public static List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfNamesAvailableGLAccounts(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfNamesAvailableGLAccounts " + e, e);
		}
		return null;
	}

	public static void clearGLAccounts(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clearGLAccounts(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearGLAccounts " + e, e);
		}
	}

	public static String fillAssetCode(WebDriver driver, String testCaseName, String assetCode, String itemID) throws ActionBotException, TestCaseException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillAssetCode(driver, testCaseName, assetCode, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssetCode " + e, e);
		}
		return null;
	}

	public static boolean isAssetCodeTextboxPresent(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.isAssetCodeTextboxPresent(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssetCodeTextboxPresent " + e, e);
		}
		return false;
	}

	public static String getAssetCode(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getAssetCode(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssetCode " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfCostCenters(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfCostCenters " + e, e);
		}
		return null;
	}

	public static List<String> getListOfCostCentersNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfCostCentersNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfCostCentersNames " + e, e);
		}
		return null;
	}

	public static String getCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getCostBookingItemSplitCostCenter(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemSplitCostCenter " + e, e);
		}
		return null;
	}

	public static void clearCostCenterWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clearCostCenterWithSpace(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearCostCenterWithSpace " + e, e);
		}
	}

	public static List<WebElement> getListOfProjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfProjects(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfProjects " + e, e);
		}
		return null;
	}

	public static List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getListOfProjectNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfProjectNames " + e, e);
		}
		return null;
	}

	public static String getCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getCostBookingItemSplitProject(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemSplitProject " + e, e);
		}
		return null;
	}

	public static void clearProjectWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clearProjectWithSpace(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearProjectWithSpace " + e, e);
		}
	}

	public static String getGLAccountHeaderAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getGLAccountHeaderAtItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGLAccountHeaderAtItemLevel " + e, e);
		}
		return null;
	}

	public static boolean isGeneralLedgerDetailsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.isGeneralLedgerDetailsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGeneralLedgerDetailsPresent " + e, e);
		}
		return false;
	}

	public static boolean isGLAccountPresent(WebDriver driver, String testCaseName, String id, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.isGLAccountPresent(driver, testCaseName, id, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGLAccountPresent " + e, e);
		}
		return false;
	}

	public static boolean isGlAccountMandatorySignPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.isGlAccountMandatorySignPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGlAccountMandatorySignPresent " + e, e);
		}
		return false;
	}

	public static void waitTillCOAFormLoaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.waitTillCOAFormLoaderDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillCOAFormLoaderDisplayed " + e, e);
		}
	}

	public static String fillBU_CoaForm(WebDriver driver, String testCaseName, String businessUnit, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillBU_CoaForm(driver, testCaseName, businessUnit, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBU_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillGeneralLedger_CoaForm(WebDriver driver, String testCaseName, String generalLedger, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillGeneralLedger_CoaForm(driver, testCaseName, generalLedger, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGeneralLedger_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillCostCenter_CoaForm(WebDriver driver, String testCaseName, String costCenter, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillCostCenter_CoaForm(driver, testCaseName, costCenter, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostCenter_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillProject_CoaForm(WebDriver driver, String testCaseName, String project, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillProject_CoaForm(driver, testCaseName, project, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProject_CoaForm " + e, e);
		}
		return null;
	}

	public static String clickCostBookingOnRadioButton_CoaForm(WebDriver driver, String testCaseName, String radioButtonName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.clickCostBookingOnRadioButton_CoaForm(driver, testCaseName, radioButtonName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCostBookingOnRadioButton_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillSubAccount_CoaForm(WebDriver driver, String testCaseName, String subAccount, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillSubAccount_CoaForm(driver, testCaseName, subAccount, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSubAccount_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillProduct_CoaForm(WebDriver driver, String testCaseName, String product, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillProduct_CoaForm(driver, testCaseName, product, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProduct_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillGeoAccount_CoaForm(WebDriver driver, String testCaseName, String geoAccount, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillGeoAccount_CoaForm(driver, testCaseName, geoAccount, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGeoAccount_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillOperationalUnit_CoaForm(WebDriver driver, String testCaseName, String operationalUnit, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillOperationalUnit_CoaForm(driver, testCaseName, operationalUnit, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOperationalUnit_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillPercentage_CoaForm(WebDriver driver, String testCaseName, String percentage, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillPercentage_CoaForm(driver, testCaseName, percentage, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPercentage_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillQuantity_CoaForm(WebDriver driver, String testCaseName, String quantity, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillQuantity_CoaForm(driver, testCaseName, quantity, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillAmount_CoaForm(WebDriver driver, String testCaseName, String amount, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillAmount_CoaForm(driver, testCaseName, amount, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAmount_CoaForm " + e, e);
		}
		return null;
	}

	public static boolean clickAddButton_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.clickAddButton_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddButton_CoaForm " + e, e);
		}
		return false;
	}

	public static String fillBookCostTo_CoaForm(WebDriver driver, String testCaseName, String bookCostTo, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillBookCostTo_CoaForm(driver, testCaseName, bookCostTo, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBookCostTo_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillClient_CoaForm(WebDriver driver, String testCaseName, String client, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillClient_CoaForm(driver, testCaseName, client, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillClient_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillEmployeeTimekeeper_CoaForm(WebDriver driver, String testCaseName, String empTimeKeeper, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillEmployeeTimekeeper_CoaForm(driver, testCaseName, empTimeKeeper, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillEmployeeTimekeeper_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillCostDisbursementCode_CoaForm(WebDriver driver, String testCaseName, String costDisCode, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillCostDisbursementCode_CoaForm(driver, testCaseName, costDisCode, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostDisbursementCode_CoaForm " + e, e);
		}
		return null;
	}

	public static String fillDepartment_CoaForm(WebDriver driver, String testCaseName, String department, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillDepartment_CoaForm(driver, testCaseName, department, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDepartment_CoaForm " + e, e);
		}
		return null;
	}

	public static void fillTransactionDate_CoaForm(WebDriver driver, String testCaseName, int day, int month, int year, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.fillTransactionDate_CoaForm(driver, testCaseName, day, month, year, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTransactionDate_CoaForm " + e, e);
		}
	}

	public static String fillDescription_CoaForm(WebDriver driver, String testCaseName, String description, boolean editForm) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.fillDescription_CoaForm(driver, testCaseName, description, editForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDescription_CoaForm " + e, e);
		}
		return null;
	}

	public static int getQuantityFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getQuantityFromItemSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantityFromItemSummary " + e, e);
		}
		return 0;
	}

	public static double getTotalAmountFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getTotalAmountFromItemSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalAmountFromItemSummary " + e, e);
		}
		return 0;
	}

	public static void updateQuantityFromItemSummary(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.updateQuantityFromItemSummary(driver, testCaseName, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTransactionDate_CoaForm " + e, e);
		}
	}

	public static void clickOnEditIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnEditIcon_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditIcon_CoaForm " + e, e);
		}
	}

	public static void clickOnDeleteIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnDeleteIcon_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteIcon_CoaForm " + e, e);
		}
	}

	public static void clickOnSaveIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnSaveIcon_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveIcon_CoaForm " + e, e);
		}
	}

	public static void clickOnCancelIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			itemSummary.clickOnCancelIcon_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelIcon_CoaForm " + e, e);
		}
	}

	public static String getErrorMessage_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCostBooking itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCostBooking();
			return itemSummary.getErrorMessage_CoaForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getErrorMessage_CoaForm " + e, e);
		}
		return null;
	}
}
