package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.tabs.FactoryTabs;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class TabCheckoutItemSummary
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickItemSummaryAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryAccountingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryAccountingTab " + e, e);
		}

	}

	public static void clickItemSummaryAttachmentTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryAttachmentTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryAttachmentTab " + e, e);
		}

	}

	public static void clickItemSummaryCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryCostBookingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryCostBookingTab " + e, e);
		}

	}

	public static void clickItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryDeliveryTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryDeliveryTab " + e, e);
		}

	}

	public static void clickItemSummaryMiscellaneousTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryMiscellaneousTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryMiscellaneousTab " + e, e);
		}

	}

	public static void clickItemSummaryAssignedBuyerTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutItemSummary itemSumm = FactoryTabs.getInstanceOfITabCheckoutItemSummary();
			itemSumm.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemSummaryAssignedBuyerTab " + e, e);
		}

	}

}
