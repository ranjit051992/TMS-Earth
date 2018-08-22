package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class ITabCheckoutItemSummaryImpl implements ITabCheckoutItemSummary
{

	@Override
	public void clickItemSummaryAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_SUMMARY_ACCOUNTING_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Accounting Tab");
	}

	@Override
	public void clickItemSummaryAttachmentTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_SUMMARY_ATTACHMENTS_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Attachment Tab");
	}

	@Override
	public void clickItemSummaryCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, ITEM_SUMMARY_COSTBOOKING_TAB);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Navigating to Cost Booking Tab");
	}

	@Override
	public void clickItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, ITEM_SUMMARY_DELIVERY_TAB);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Delivery Tab");
	}

	@Override
	public void clickItemSummaryMiscellaneousTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, ITEM_SUMMARY_MISCELLANEOUS_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Miscellaneous Tab");

	}

	@Override
	public void clickItemSummaryAssignedBuyerTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ITEM_SUMMARY_ASSIGNED_BUYER_TAB);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);

		//ActionBot.click(driver, ITEM_SUMMARY_ASSIGNED_BUYER_TAB);
		ScreenShot.screenshot(driver, testCaseName, "Miscellaneous Tab");
	}

}
