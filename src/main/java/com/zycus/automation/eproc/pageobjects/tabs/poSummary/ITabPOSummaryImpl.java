package com.zycus.automation.eproc.pageobjects.tabs.poSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class ITabPOSummaryImpl implements ITabPOSummary
{

	@Override
	public void clickOnCostBookingPOSummary(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, TAB_COST_BOOKING_PO_SUMMARY);
	}

	@Override
	public void clickOnBillingPOSummary(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, TAB_BILLING_PO_SUMMARY);

	}

	@Override
	public void clickOnDeliveryPOSummary(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, TAB_DELIVERY_PO_SUMMARY);

	}

}
