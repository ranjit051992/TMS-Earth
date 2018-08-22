/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoiceitemsummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class ITabInvoiceItemSummaryImpl implements ITabInvoiceItemSummary
{

	@Override
	public void clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Item Tab");
	}

	@Override
	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_COST_BOOKING_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Item Cost Booking Tab");
	}

	@Override
	public void clickOnAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_ACCOUNTING_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Accounting Tab");
	}

	@Override
	public void clickOnAttachmentsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_ATTACHMENTS_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Attachments Tab");
	}

	@Override
	public void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_TAXES_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Taxes Tab");
	}

}
