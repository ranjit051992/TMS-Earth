package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCommon;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.IModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelItemBuyersSummaryCommon
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickItemSummaryCancle(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemSummary.clickItemSummaryCancle(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryCancle " + e, e);
		}

	}

	public static void clickItemSummarySave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemSummary.clickItemSummarySave(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummarySave " + e, e);
		}

	}

	public static String getItemSummaryItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String itemName = null;
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemName = itemSummary.getItemSummaryItemName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSummaryItemName " + e, e);
		}
		return itemName;
	}

	public static String getItemSummaryItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String itemQty = null;
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemQty = itemSummary.getItemSummaryItemQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSummaryItemQuantity " + e, e);
		}
		return itemQty;
	}

	public static String getItemSummaryItemSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String itemSupplier = null;
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemSupplier = itemSummary.getItemSummaryItemSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSummaryItemSupplier " + e, e);
		}
		return itemSupplier;
	}

	public static String getItemSummaryItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String itemTotalPrice = null;
		try
		{
			IModelItemSummaryCommon itemSummary = FactoryModal.getInstanceOfIModelItemSummaryCommon();
			itemTotalPrice = itemSummary.getItemSummaryItemTotalPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSummaryItemTotalPrice " + e, e);
		}
		return itemTotalPrice;
	}

}
