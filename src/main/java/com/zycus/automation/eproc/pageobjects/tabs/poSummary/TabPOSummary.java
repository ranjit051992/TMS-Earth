package com.zycus.automation.eproc.pageobjects.tabs.poSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.tabs.FactoryTabs;
import com.zycus.automation.exception.ActionBotException;

public class TabPOSummary
{
	public static void clickOnCostBookingPOSummary(WebDriver driver) throws ActionBotException
	{
		ITabPOSummary iTabPOSummary = FactoryTabs.getInstanceOfTabPOSummary();
		iTabPOSummary.clickOnCostBookingPOSummary(driver);
	}

	public static void clickOnBillingPOSummary(WebDriver driver) throws ActionBotException
	{
		ITabPOSummary iTabPOSummary = FactoryTabs.getInstanceOfTabPOSummary();
		iTabPOSummary.clickOnBillingPOSummary(driver);
	}

	public static void clickOnDeliveryPOSummary(WebDriver driver) throws ActionBotException
	{
		ITabPOSummary iTabPOSummary = FactoryTabs.getInstanceOfTabPOSummary();
		iTabPOSummary.clickOnDeliveryPOSummary(driver);
	}
}
