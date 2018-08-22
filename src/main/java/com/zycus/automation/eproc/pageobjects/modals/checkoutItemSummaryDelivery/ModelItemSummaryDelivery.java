package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelItemSummaryDelivery
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickDeliveryAddMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			itemSummary.clickDeliveryAddMultiSplit(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryAddMultiSplit " + e, e);
		}
	}

	public static void clickDeliveryDeleteMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			itemSummary.clickDeliveryDeleteMultiSplit(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryDeleteMultiSplit " + e, e);
		}

	}

	public static String fillDeliveryMultiSplitAddress(WebDriver driver, String testCaseName, String multiSplitAddress, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillDeliveryMultiSplitAddress(driver, testCaseName, multiSplitAddress, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitAddress " + e, e);
		}
		return null;
	}

	public static String fillDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String multiSplitDeliverTo, String itemID, int index) throws ActionBotException
	{

		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillDeliveryMultiSplitDeliverTo(driver, testCaseName, multiSplitDeliverTo, itemID, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitDeliverTo " + e, e);
		}
		return null;
	}

	public static int fillDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, int multiSplitQuantity, String itemID, int index) throws ActionBotException
	{

		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillDeliveryMultiSplitQuantity(driver, testCaseName, multiSplitQuantity, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitQuantity " + e, e);
		}
		return 0;
	}

	public static String getDeliveryMultiSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliveryMultiSplitAmount(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitAmount " + e, e);
		}
		return itemID;
	}

	public static String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitRequiredDate " + e, e);
		}
		return null;
	}

	public static String getDeliverySingleSplitDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliverySingleSplitDeliverTo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverySingleSplitDeliverTo " + e, e);
		}
		return null;
	}

	public static String getDeliverySingleSplitDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String add = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			add = itemSummary.getDeliverySingleSplitDeliveryAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverySingleSplitDeliveryAddress " + e, e);
		}
		return add;
	}

	public static String getDeliverySingleSplitRequiredDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String date = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			date = itemSummary.getDeliverySingleSplitRequiredDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverySingleSplitRequiredDate " + e, e);
		}
		return date;
	}

	public static boolean selectDeliveryOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean multiSplit = false;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			multiSplit = itemSummary.selectDeliveryOptionMultiSplit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOptionMultiSplit " + e, e);
		}
		return multiSplit;
	}

	public static boolean selectDeliveryOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		boolean split = false;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			split = itemSummary.selectDeliveryOptionSingleSplit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOptionSingleSplit " + e, e);
		}
		return split;
	}

	public static String selectRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.selectRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliveryMultiSplitDeliverTo(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitDeliverTo " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliveryMultiSplitDeliveryAddress(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitDeliveryAddress " + e, e);
		}
		return null;
	}

	public static boolean isDeliveryOnDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isDeliveryOnDatePresentForSelection(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryOnDatePresentForSelection " + e, e);
		}
		return false;
	}

	public static boolean isDeliveryUptoDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isDeliveryUptoDatePresentForSelection(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryUptoDatePresentForSelection " + e, e);
		}
		return false;
	}

	public static String selectDeliveryUptoDate(WebDriver driver, String testCaseName, int day, int month, int year, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.selectDeliveryUptoDate(driver, testCaseName, "" + day, "" + month, "" + year, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryUptoDate " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitUptoDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getDeliveryMultiSplitUptoDate(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitUptoDate " + e, e);
		}
		return null;
	}

	public static boolean isFromDateRequiredErrorPresent(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isFromDateRequiredErrorPresent(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFromDateRequiredErrorPresent " + e, e);
		}
		return false;
	}

	public static String getFromDateRequiredError(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getFromDateRequiredError(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFromDateRequiredError " + e, e);
		}
		return null;
	}

	public static String fillQuantityAtHeaderLevel(WebDriver driver, String testCaseName, String quantity) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillQuantityAtHeaderLevel(driver, testCaseName, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method quantity " + e, e);
		}
		return null;
	}

	public static String getInvalidQuantityError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getInvalidQuantityError(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getInvalidQuantityError " + e, e);
		}
		return null;
	}

	public static boolean isInvalidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isInvalidQuantityErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvalidQuantityErrorPresent " + e, e);
		}
		return false;
	}

	public static boolean isEnableAssetTaggingCheckboxEnabledOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isEnableAssetTaggingCheckboxEnabledOrNot(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEnableAssetTaggingCheckboxEnabledOrNot " + e, e);
		}
		return false;
	}

	public static boolean isEnableAssetTaggingCheckboxSelectedOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.isEnableAssetTaggingCheckboxSelectedOrNot(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEnableAssetTaggingCheckboxSelectedOrNot " + e, e);
		}
		return false;
	}

	public static String getLabelValueOfEnableAssetTaggingCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.getLabelValueOfEnableAssetTaggingCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLabelValueOfEnableAssetTaggingCheckbox " + e, e);
		}
		return null;
	}

	public static void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			itemSummary.clickOnTagAssetsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnTagAssetsLink " + e, e);
		}
	}

	public static String fillAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillAssetNo(driver, testCaseName, assetNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssetNo " + e, e);
		}
		return null;
	}

	public static String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manufacturerSrNo) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillManufacturerSrNo(driver, testCaseName, manufacturerSrNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerSrNo " + e, e);
		}
		return null;
	}

	public static String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			return itemSummary.fillNotes(driver, testCaseName, notes);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillNotes " + e, e);
		}
		return null;
	}

	/*
	 * author :bhakti.sawant
	 */
	public static void clickCreateAssetTagsForThisItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			itemSummary.clickCreateAssetTagsForThisItemCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCreateAssetTagsForThisItemCheckBox " + e, e);
		}

	}

}
