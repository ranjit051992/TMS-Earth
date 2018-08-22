/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageRequisitionSettings
{

	static Logger logger = Logger.getLogger(PageRequisitionSettings.class);

	public static String fillRequisitionNumberFormat(WebDriver driver, String testCaseName, String reqNumberFormat) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillRequisitionNumberFormat(driver, testCaseName, reqNumberFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitionNumberFormat " + e, e);
		}
		return result;
	}

	public static String getRequisitionNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getRequisitionNumberFormat(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionNumberFormat " + e, e);
		}
		return result;
	}

	public static Integer fillSequenceNumberStartsAt(WebDriver driver, String testCaseName, int seqNoStartsAt) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillSequenceNumberStartsAt(driver, testCaseName, seqNoStartsAt);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSequenceNumberStartsAt " + e, e);
		}
		return result;
	}

	public static Integer getSequenceNumberStartsAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getSequenceNumberStartsAt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSequenceNumberStartsAt " + e, e);
		}
		return result;
	}

	public static Integer fillSequenceNumberEndsAt(WebDriver driver, String testCaseName, int seqNoEndsAt) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillSequenceNumberEndsAt(driver, testCaseName, seqNoEndsAt);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSequenceNumberEndsAt " + e, e);
		}
		return result;
	}

	public static Integer getSequenceNumberEndsAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getSequenceNumberEndsAt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSequenceNumberEndsAt " + e, e);
		}
		return result;
	}

	public static String fillRequisitionNameFormat(WebDriver driver, String testCaseName, String reqNameFormat) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillRequisitionNameFormat(driver, testCaseName, reqNameFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitionNameFormat " + e, e);
		}
		return result;
	}

	public static String getRequisitionNameFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getRequisitionNameFormat(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionNameFormat " + e, e);
		}
		return result;
	}

	public static String fillMostFreqentlySearchedItems(WebDriver driver, String testCaseName, String mostFrequentlySearchedItems) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillMostFreqentlySearchedItems(driver, testCaseName, mostFrequentlySearchedItems);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMostFreqentlySearchedItems " + e, e);
		}
		return result;
	}

	public static String getMostFreqentlySearchedItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getMostFreqentlySearchedItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getMostFreqentlySearchedItems " + e, e);
		}
		return result;
	}

	public static Integer fillItemQuantityThreshold(WebDriver driver, String testCaseName, int itemQuantityThreshold) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.fillItemQuantityThreshold(driver, testCaseName, itemQuantityThreshold);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemQuantityThreshold " + e, e);
		}
		return result;
	}

	public static Integer getItemQuantityThreshold(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getItemQuantityThreshold(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemQuantityThreshold " + e, e);
		}
		return result;
	}

	public static boolean clickOnOrderFreeTextItemsAlways(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnOrderFreeTextItemsAlways(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderFreeTextItemsAlways " + e, e);
		}
		return result;
	}

	public static String getAllowRequetserToOrderFreeTextItemsType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowRequetserToOrderFreeTextItemsType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowRequetserToOrderFreeTextItemsType " + e, e);
		}
		return result;
	}

	public static boolean clickOnOrderFreeTextItemsNever(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnOrderFreeTextItemsNever(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderFreeTextItemsNever " + e, e);
		}
		return result;
	}

	public static boolean clickOnOrderFreeTextItemsPermissionBased(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnOrderFreeTextItemsPermissionBased(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderFreeTextItemsPermissionBased " + e, e);
		}
		return result;
	}

	public static boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes " + e, e);
		}
		return result;
	}

	public static String getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFreeTextItemsRequestedWithoutSelectingCategory_no " + e, e);
		}
		return result;
	}

	public static boolean clickOnReqToBeSubmittedWithoutRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqToBeSubmittedWithoutRequiredByDate_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnReqToBeSubmittedWithoutRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqToBeSubmittedWithoutRequiredByDate_no " + e, e);
		}
		return result;
	}

	public static String getAllowReqToBeSubmittedWithoutRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowReqToBeSubmittedWithoutRequiredByDateOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowReqToBeSubmittedWithoutRequiredByDateOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowBuyerToModifyRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowBuyerToModifyRequiredByDate_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToModifyRequiredByDate_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowBuyerToModifyRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowBuyerToModifyRequiredByDate_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToModifyRequiredByDate_no " + e, e);
		}
		return result;
	}

	public static String getAllowBuyerToModifyRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowBuyerToModifyRequiredByDateOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowBuyerToModifyRequiredByDateOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no " + e, e);
		}
		return result;
	}

	public static String getAllowReqToBeSubmittedWithoutCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowReqToBeSubmittedWithoutCostCenterInfoOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowReqToBeSubmittedWithoutCostCenterInfoOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowBuyerToModifyCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowBuyerToModifyCostCenterInfo_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToModifyCostCenterInfo_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowBuyerToModifyCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowBuyerToModifyCostCenterInfo_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToModifyCostCenterInfo_no " + e, e);
		}
		return result;
	}

	public static String getAllowBuyerToModifyCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowBuyerToModifyCostCenterInfoOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowBuyerToModifyCostCenterInfoOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnDisplayAccountingInfoToRequester_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnDisplayAccountingInfoToRequester_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDisplayAccountingInfoToRequester_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnDisplayAccountingInfoToRequester_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnDisplayAccountingInfoToRequester_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDisplayAccountingInfoToRequester_no " + e, e);
		}
		return result;
	}

	public static String getDisplayAccountingInfoToRequesterOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getDisplayAccountingInfoToRequesterOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDisplayAccountingInfoToRequesterOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnRequesterIsRequiredToProvideAccountingInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequesterIsRequiredToProvideAccountingInfo_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnRequesterIsRequiredToProvideAccountingInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequesterIsRequiredToProvideAccountingInfo_no " + e, e);
		}
		return result;
	}

	public static String getRequesterIsRequiredToProvideAccountingInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getRequesterIsRequiredToProvideAccountingInfoOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequesterIsRequiredToProvideAccountingInfoOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowRequesterToOverrideDefaultGLAccount_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToOverrideDefaultGLAccount_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnAllowRequesterToOverrideDefaultGLAccount_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToOverrideDefaultGLAccount_no " + e, e);
		}
		return result;
	}

	public static String getAllowRequesterToOverrideDefaultGLAccountOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getAllowRequesterToOverrideDefaultGLAccountOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowRequesterToOverrideDefaultGLAccountOption " + e, e);
		}
		return result;
	}

	public static String getRequesterRequiredToAssignBuyerOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getRequesterRequiredToAssignBuyerOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequesterRequiredToAssignBuyerOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnApplyCategoryBasedWorkflow_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnApplyCategoryBasedWorkflow_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApplyCategoryBasedWorkflow_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnApplyCategoryBasedWorkflow_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnApplyCategoryBasedWorkflow_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApplyCategoryBasedWorkflow_no " + e, e);
		}
		return result;
	}

	public static String getApplyCategoryBasedWorkflowOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getApplyCategoryBasedWorkflowOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApplyCategoryBasedWorkflowOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnEnableRequisitionForking_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnEnableRequisitionForking_yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEnableRequisitionForking_yes " + e, e);
		}
		return result;
	}

	public static boolean clickOnEnableRequisitionForking_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnEnableRequisitionForking_no(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEnableRequisitionForking_no " + e, e);
		}
		return result;
	}

	public static boolean getEnableRequisitionForkingOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.getEnableRequisitionForkingOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getEnableRequisitionForkingOption " + e, e);
		}
		return false;
	}

	public static boolean clickOnSplitReqAsPerCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnSplitReqAsPerCategories(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSplitReqAsPerCategories " + e, e);
		}
		return result;
	}

	public static boolean clickOnSplitReqAsPerPriceType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnSplitReqAsPerPriceType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSplitReqAsPerPriceType " + e, e);
		}
		return result;
	}

	public static String getSplitReqTypeOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.getSplitReqTypeOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSplitReqTypeOption " + e, e);
		}
		return result;
	}

	public static boolean clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveButton " + e, e);
		}
		return result;
	}

	public static boolean clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
		return result;
	}

	public static boolean clickOnRequesterRequiredToAssignBuyer_Required(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnRequesterRequiredToAssignBuyer_Required(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequesterRequiredToAssignBuyer_Required " + e, e);
		}
		return result;
	}

	public static boolean clickOnRequesterRequiredToAssignBuyer_Optional(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnRequesterRequiredToAssignBuyer_Optional(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequesterRequiredToAssignBuyer_Optional " + e, e);
		}
		return result;
	}

	public static boolean clickOnRequesterRequiredToAssignBuyer_Hidden(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			result = requisitionSettings.clickOnRequesterRequiredToAssignBuyer_Hidden(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequesterRequiredToAssignBuyer_Hidden " + e, e);
		}
		return result;
	}

	public static void clickOnSourcingStatus_QuotedBySupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnSourcingStatus_QuotedBySupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSourcingStatus_QuotedBySupplier " + e, e);
		}
	}

	public static void clickOnSourcingStatus_EstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnSourcingStatus_EstimatedPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSourcingStatus_EstimatedPrice " + e, e);
		}
	}

	public static void clickOnSourcingStatus_NeedAQuote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnSourcingStatus_NeedAQuote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSourcingStatus_NeedAQuote " + e, e);
		}
	}

	public static boolean clickOnAddDisbursementAsSettlementViaOptionYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnAddDisbursementAsSettlementViaOptionYes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddDisbursementAsSettlementViaOptionYes " + e, e);
		}
		return false;
	}

	public static boolean clickOnAddDisbursementAsSettlementViaOptionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnAddDisbursementAsSettlementViaOptionNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddDisbursementAsSettlementViaOptionNo " + e, e);
		}
		return false;
	}

	public static boolean clickOnSendPOToSupplierOptionYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			 return requisitionSettings.clickOnSendPOToSupplierOptionYes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSendPOToSupplierOptionYes " + e, e);
		}
		return false;
	}

	public static boolean clickOnSendPOToSupplierOptionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnSendPOToSupplierOptionNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSendPOToSupplierOptionNo " + e, e);
		}
		return false;
	}

	public static boolean isSendPOToSupplierOptionYesEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.isSendPOToSupplierOptionYesEnabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSendPOToSupplierOptionYesEnabled " + e, e);
		}
		return false;
	}

	public static boolean isSendPOToSupplierOptionNoEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.isSendPOToSupplierOptionNoEnabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSendPOToSupplierOptionNoEnabled " + e, e);
		}
		return false;
	}

	public static void clickOnQuotedBySupplierSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnQuotedBySupplierSourcingStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnQuotedBySupplierSourcingStatus " + e, e);
		}
	}

	public static void clickOnEstimatedPriceSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnEstimatedPriceSourcingStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEstimatedPriceSourcingStatus " + e, e);
		}
	}

	public static void clickOnNeedAQuoteSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			requisitionSettings.clickOnNeedAQuoteSourcingStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNeedAQuoteSourcingStatus " + e, e);
		}
	}

	public static boolean isQuotedBySupplierSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.isQuotedBySupplierSourcingStatusSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isQuotedBySupplierSourcingStatusSelected " + e, e);
		}
		return false;
	}

	public static boolean isEstimatedPriceSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.isEstimatedPriceSourcingStatusSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEstimatedPriceSourcingStatusSelected " + e, e);
		}
		return false;
	}

	public static boolean isNeedAQuoteSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.isNeedAQuoteSourcingStatusSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isNeedAQuoteSourcingStatusSelected " + e, e);
		}
		return false;
	}

	public static boolean clickOnBuyerDefaultOption_Buyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnBuyerDefaultOption_Buyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBuyerDefaultOption_Buyer " + e, e);
		}
		return false;
	}

	public static boolean clickOnBuyerDefaultOption_BuyerGroup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnBuyerDefaultOption_BuyerGroup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBuyerDefaultOption_BuyerGroup " + e, e);
		}
		return false;
	}

	public static boolean clickOnPoToReqTagging_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnPoToReqTagging_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoToReqTagging_Yes " + e, e);
		}
		return false;
	}

	public static boolean clickOnPoToReqTagging_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnPoToReqTagging_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoToReqTagging_No " + e, e);
		}
		return false;
	}

	public static boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes " + e, e);
		}
		return false;
	}

	public static boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnAllowRequesterToSuggestSupplierForBuyersReview_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToSuggestSupplierForBuyersReview_No " + e, e);
		}
		return false;
	}

	public static boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToSuggestSupplierForBuyersReview_No " + e, e);
		}
		return false;
	}

	public static boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowRequesterToSuggestSupplierForBuyersReview_No " + e, e);
		}
		return false;
	}

	public static boolean allowSplitDeliveryLocationAtItemLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.allowSplitDeliveryLocationAtItemLevel_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method allowSplitDeliveryLocationAtItemLevel_Yes " + e, e);
		}
		return false;
	}

	public static boolean allowSplitDeliveryLocationAtItemLevel_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.allowSplitDeliveryLocationAtItemLevel_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method allowSplitDeliveryLocationAtItemLevel_Yes " + e, e);
		}
		return false;
	}
	
	public static Integer enterQuantityToAlertUserWhenShoppingCartIsBeyondQuantity(WebDriver driver, Integer quantity) throws ActionBotException
	{
		try
		{
			IPageRequisitionSettings requisitionSettings = FactoryPage.getInstanceOfIPageRequisitionSettings();
			return requisitionSettings.enterQuantityToAlertUserWhenShoppingCartIsBeyondQuantity(driver, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method allowSplitDeliveryLocationAtItemLevel_Yes " + e, e);
		}
		return null;
	}
}
