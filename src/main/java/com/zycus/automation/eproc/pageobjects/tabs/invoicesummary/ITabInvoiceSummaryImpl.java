/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoicesummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class ITabInvoiceSummaryImpl implements ITabInvoiceSummary
{

	@Override
	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_COST_BOOKING_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cost Booking Tab");
	}

	@Override
	public void clickOnBillingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_BILLING_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Billing Tab");
	}

}
