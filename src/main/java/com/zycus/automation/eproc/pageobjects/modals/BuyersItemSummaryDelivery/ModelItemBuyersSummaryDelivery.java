package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryDelivery;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery.IModelItemSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelItemBuyersSummaryDelivery
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

		String address = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			address = itemSummary.fillDeliveryMultiSplitAddress(driver, testCaseName, multiSplitAddress, itemID, index);
			if (address.equalsIgnoreCase(multiSplitAddress))
			{
				return address;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitAddress " + e, e);
		}
		return null;
	}

	public static String fillDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String multiSplitDeliverTo, String itemID, int index) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			deliverTo = itemSummary.fillDeliveryMultiSplitDeliverTo(driver, testCaseName, multiSplitDeliverTo, itemID, index);
			if (deliverTo.equalsIgnoreCase(multiSplitDeliverTo))
			{
				return deliverTo;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitDeliverTo " + e, e);
		}
		return null;
	}

	public static int fillDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, int multiSplitQuantity, String itemID, int index) throws ActionBotException
	{

		int quantity = 0;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			quantity = itemSummary.fillDeliveryMultiSplitQuantity(driver, testCaseName, multiSplitQuantity, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMultiSplitQuantity " + e, e);
		}
		return quantity;
	}

	public static String getDeliveryMultiSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String amount = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			amount = itemSummary.getDeliveryMultiSplitAmount(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitAmount " + e, e);
		}
		return amount;
	}

	public static String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String reqDate = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			reqDate = itemSummary.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemID, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitRequiredDate " + e, e);
		}
		return reqDate;
	}

	public static String getDeliverySingleSplitDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
			deliverTo = itemSummary.getDeliverySingleSplitDeliverTo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverySingleSplitDeliverTo " + e, e);
		}
		return deliverTo;
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

	public static int fillQuantityOrAmountOfDelivery(WebDriver driver, String testCaseName, int amount) throws ActionBotException, FactoryMethodException
	{
		IModelItemSummaryDelivery itemSummary = FactoryModal.getInstanceOfIModelItemSummaryDelivery();
		return itemSummary.fillQuantityOrAmountOfDelivery(driver, testCaseName, amount);
	}

}
