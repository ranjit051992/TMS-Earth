package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking;

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

public class ModelRequisitionSummaryCostBooking
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

	public static void clickNoAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickNoAssignToPurchaseCost(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickNoAssignToPurchaseCost " + e, e);
		}
	}

	public static void clickYesAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickYesAssignToPurchaseCost(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickYesAssignToPurchaseCost " + e, e);
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

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleBudget " + e, e);
		}
		return null;
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

	public static String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillCostBookingSingleCC(driver, testCaseName, costBookingSingleCC);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleCC " + e, e);
		}
		return null;
	}

	public static String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillMultiCostCenterBudget(driver, testCaseName, multiCostCenterBudget, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterBudget " + e, e);
		}
		return null;
	}

	public static String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillMultiCostCenterName(driver, testCaseName, multiCostCenterName, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterName " + e, e);
		}
		return null;
	}

	public static int fillMultiCostCenterPercent(WebDriver driver, String testCaseName, int multiCostCenterPercent, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillMultiCostCenterPercent(driver, testCaseName, multiCostCenterPercent, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterPercent " + e, e);
		}
		return 0;
	}

	public static String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostBookingItemLevelCCAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCAmount " + e, e);
		}
		return null;
	}

	public static String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostBookingItemLevelCCBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCBudget " + e, e);
		}
		return null;
	}

	public static String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostBookingItemLevelCCName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCName " + e, e);
		}
		return null;
	}

	public static String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostBookingMultiCostCenterAmount(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiCostCenterAmount " + e, e);
		}
		return null;
	}

	public static String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostBookingTotalAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingTotalAmount " + e, e);
		}
		return null;
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

	public static boolean isCostbookingSingleCCRadioBtnSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionSingleCC = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			optionSingleCC = reqSummary.isCostbookingSingleCCRadioBtnSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostbookingSingleCCRadioBtnSelected " + e, e);
		}
		return optionSingleCC;
	}

	public static boolean isAssingToPurchasOrderRedioBtnYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean AssignToPo = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			AssignToPo = reqSummary.isAssingToPurchasOrderRedioBtnYesSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssingToPurchasOrderRedioBtnYesSelected " + e, e);
		}
		return AssignToPo;
	}

	public static boolean isReqSummaryProjectToolTipContainsProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.isReqSummaryProjectToolTipContainsProjectDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqSummaryProjectToolTipContainsProjectDetails " + e, e);
		}
		return false;
	}

	public static boolean isAssingToPurchasOrderRedioDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean AssignToPo = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			AssignToPo = reqSummary.isAssingToPurchasOrderRedioDisabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssingToPurchasOrderRedioDisabled " + e, e);
		}
		return AssignToPo;
	}

	public static String fillMultiCostCenterProject(WebDriver driver, String testCaseName, String multiCostCenterProject, int index) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.fillMultiCostCenterProject(driver, testCaseName, multiCostCenterProject, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterProject " + e, e);
		}
		return null;
	}

	public static boolean isAssingToPurchasOrderRedioBtnNOSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.isAssingToPurchasOrderRedioBtnNOSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssingToPurchasOrderRedioBtnNOSelected " + e, e);
		}
		return false;

	}

	public static boolean isselectCostBookingOptionMultipleCCDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.isselectCostBookingOptionMultipleCCDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isselectCostBookingOptionMultipleCCDisplayed " + e, e);
		}
		return false;
	}

	public static List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getListOfCostCenters(driver, testCaseName);
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
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getListOfCostCentersNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfCostCentersNames " + e, e);
		}
		return null;
	}

	public static String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostCenterName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterName " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfPrjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getListOfPrjects(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfPrjects " + e, e);
		}
		return null;
	}

	public static List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getListOfProjectNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfProjectNames " + e, e);
		}
		return null;
	}

	public static String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getProjectName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProjectName " + e, e);
		}
		return null;
	}

	public static void clearCostCenterWithSpace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clearCostCenterWithSpace(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearCostCenterWithSpace " + e, e);
		}
	}

	public static void clearProjectWithSpace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clearProjectWithSpace(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearProjectWithSpace " + e, e);
		}
	}

	public static String getCostCenterLabelAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			return reqSummary.getCostCenterLabelAtHeaderLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterLabelAtHeaderLevel " + e, e);
		}
		return null;
	}

	public static void clickOnSinglePoject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickOnSinglePoject(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSinglePoject " + e, e);
		}
	}

	public static void clickNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickNoAllowBudgetUtilization(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickYesAssignToPurchaseCost " + e, e);
		}

	}

	public static void clickYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			reqSummary.clickYesAllowBudgetUtilization(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickYesAssignToPurchaseCost " + e, e);
		}

	}

	public static boolean isYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionSingleCC = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			optionSingleCC = reqSummary.isYesAllowBudgetUtilization(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostbookingSingleCCRadioBtnSelected " + e, e);
		}
		return optionSingleCC;
	}

	public static boolean isNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionSingleCC = false;
		try
		{
			IModelRequisitionSummaryCostBooking reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCostBooking();
			optionSingleCC = reqSummary.isNoAllowBudgetUtilization(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostbookingSingleCCRadioBtnSelected " + e, e);
		}
		return optionSingleCC;
	}
}