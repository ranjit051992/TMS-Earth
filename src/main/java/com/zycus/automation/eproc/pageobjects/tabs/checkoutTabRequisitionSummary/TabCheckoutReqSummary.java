package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.tabs.FactoryTabs;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;

public class TabCheckoutReqSummary
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickBillingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutReqSummary reqSumm = FactoryTabs.getInstanceOfITabCheckoutReqSummary();
			reqSumm.clickBillingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBillingTab " + e, e);
		}

	}

	public static void clickCostBookingTab(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException
	{
		try
		{
			ITabCheckoutReqSummary reqSumm = FactoryTabs.getInstanceOfITabCheckoutReqSummary();
			reqSumm.clickCostBookingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCostBookingTab " + e, e);
		}

	}

	public static void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabCheckoutReqSummary reqSumm = FactoryTabs.getInstanceOfITabCheckoutReqSummary();
			reqSumm.clickDeliveryTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryTab " + e, e);
		}

	}

}
