package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryCostBooking;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.IModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelBuyersdeskSummaryCostBooking
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickMultiAddCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickMultiAddCostCenter " + e, e);
		}
	}

	public static void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickMultiDeleteCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickMultiDeleteCostCenter " + e, e);
		}
	}

	public static String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException
	{

		String budget = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			budget = reqSummary.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget);
			if (budget.equalsIgnoreCase(costBookingSingleBudget))
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
			logger.error("Factory Method Exception in method fillCostBookingSingleBudget " + e, e);
		}
		return null;
	}

	public static String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException
	{

		String cc = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			cc = reqSummary.fillCostBookingSingleCC(driver, testCaseName, costBookingSingleCC);
			if (cc.equalsIgnoreCase(costBookingSingleCC))
			{
				return cc;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleCC " + e, e);
		}
		return null;
	}

	public static String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException
	{

		String ccBudget = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccBudget = reqSummary.fillMultiCostCenterBudget(driver, testCaseName, multiCostCenterBudget, index);
			if (ccBudget.equalsIgnoreCase(multiCostCenterBudget))
			{
				return ccBudget;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterBudget " + e, e);
		}
		return null;
	}

	public static String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException
	{

		String ccName = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccName = reqSummary.fillMultiCostCenterName(driver, testCaseName, multiCostCenterName, index);
			if (ccName.equalsIgnoreCase(multiCostCenterName))
			{
				return ccName;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterName " + e, e);
		}
		return null;
	}

	public static int fillMultiCostCenterPercent(WebDriver driver, String testCaseName, int multiCostCenterPercent, int index) throws ActionBotException
	{

		int ccPercent = 0;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccPercent = reqSummary.fillMultiCostCenterPercent(driver, testCaseName, multiCostCenterPercent, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterPercent " + e, e);
		}
		return ccPercent;
	}

	public static String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccAmount = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccAmount = reqSummary.getCostBookingItemLevelCCAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCAmount " + e, e);
		}
		return ccAmount;
	}

	public static String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccBudget = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccBudget = reqSummary.getCostBookingItemLevelCCBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCBudget " + e, e);
		}
		return ccBudget;
	}

	public static String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccName = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccName = reqSummary.getCostBookingItemLevelCCName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCName " + e, e);
		}
		return ccName;
	}

	public static String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, String multiCostCenterAmount, int index) throws ActionBotException
	{

		String ccAmount = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			ccAmount = reqSummary.getCostBookingMultiCostCenterAmount(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiCostCenterAmount " + e, e);
		}
		return ccAmount;
	}

	public static String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String totalAmount = null;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			totalAmount = reqSummary.getCostBookingTotalAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingTotalAmount " + e, e);
		}
		return totalAmount;
	}

	public static boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean sendtoAddress = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			sendtoAddress = reqSummary.selectCostBookingOptionLineItemCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionLineItemCC " + e, e);
		}
		return sendtoAddress;
	}

	public static boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionMultipleCC = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			optionMultipleCC = reqSummary.selectCostBookingOptionMultipleCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionMultipleCC " + e, e);
		}
		return optionMultipleCC;
	}

	public static boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionSingleCC = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			optionSingleCC = reqSummary.selectCostBookingOptionSingleCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionSingleCC " + e, e);
		}
		return optionSingleCC;
	}

	public static String fillCostBookingSingleProject(WebDriver driver, String testCaseName, String costBookingSingleProject) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleProject " + e, e);
		}
		return null;
	}

	public static boolean isCCSplitAtItemLevelContentPresentAtHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Boolean CCSplitContent = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			CCSplitContent = reqSummary.isCCSplitAtItemLevelContentPresentAtHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionSingleCC " + e, e);
		}
		return CCSplitContent;
	}

}
