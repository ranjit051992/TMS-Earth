package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class ITabCheckoutReqSummaryImpl implements ITabCheckoutReqSummary
{

	@Override
	public void clickBillingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BILLING_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Billing Tab");
	}

	@Override
	public void clickCostBookingTab(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, COSTBOOKING_TAB);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "Cost Booking Tab");
	}

	@Override
	public void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, DELIVERY_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Delivery Tab");

	}

}
