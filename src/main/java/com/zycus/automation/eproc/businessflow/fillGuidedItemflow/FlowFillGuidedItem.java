package com.zycus.automation.eproc.businessflow.fillGuidedItemflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.GuidedItemSuggestSupplier;
import com.zycus.automation.eproc.businessflow.FactoryBusinessFlow;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowFillGuidedItem
{
	static Logger logger = Logger.getLogger(FlowFillGuidedItem.class);

	public static GuidedItem fillGuidedItem(WebDriver driver, String testcaseName, GuidedItem guidedItem) throws Exception
	{
		GuidedItem guided_Item = new GuidedItem();
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			guided_Item = flowFillGuidedItemImpl.fillGuidedItem(driver, testcaseName, guidedItem);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGuidedItem " + e, e);
		}
		return guided_Item;

	}

	public static GuidedItem fillGuidedItemNAddToCart(WebDriver driver, String testcaseName, GuidedItem guidedItem) throws Exception
	{
		GuidedItem guided_Item = new GuidedItem();
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			guided_Item = flowFillGuidedItemImpl.fillGuidedItemNAddToCart(driver, testcaseName, guidedItem);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGuidedItemNAddToCart " + e, e);
		}
		return guided_Item;
	}

	public static void addGuidedItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			flowFillGuidedItemImpl.addGuidedItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addGuidedItem " + e, e);
		}
	}

	public static GuidedItemSuggestSupplier fillSuggestedSupplier(WebDriver driver, String testCaseName, GuidedItemSuggestSupplier guidedItemSuggestSupplier, String supplierType)
		throws Exception
	{
		GuidedItemSuggestSupplier itemSuggestSupplier = new GuidedItemSuggestSupplier();
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			itemSuggestSupplier = flowFillGuidedItemImpl.fillSuggestedSupplier(driver, testCaseName, guidedItemSuggestSupplier, supplierType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestedSupplier " + e, e);
		}
		return itemSuggestSupplier;

	}

	public static boolean fillExtraFields(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws Exception
	{
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			return flowFillGuidedItemImpl.fillExtraFields(driver, testCaseName, guidedItem);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestedSupplier " + e, e);
			return false;
		}
	}

	public static boolean fillExtraFieldsWithScriptedInput(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws Exception
	{
		try
		{
			IFlowFillGuidedItemImpl flowFillGuidedItemImpl = FactoryBusinessFlow.getInstanceOfIFlowFillGuidedItem();
			return flowFillGuidedItemImpl.fillExtraFieldsWithScriptedInput(driver, testCaseName, guidedItem);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillExtraFieldsWithScriptedInput " + e, e);
			return false;
		}
	}
}
