package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelItemSummaryCommonImpl implements IModelItemSummaryCommon
{

	@Override
	public void clickItemSummaryCancle(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, ITEMSUMMARY_CANCLE);
		ScreenShot.screenshot(driver, testCaseName, "Item Summary Cancle");
	}

	@Override
	public void clickItemSummarySave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Item Summary Save");
		ActionBot.click(driver, ITEMSUMMARY_SAVE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Item Summary Save");
	}

	@Override
	public String getItemSummaryItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.findElement(driver, ITEMSUMMARY_ITEM_NAME).getText();
	}

	@Override
	public String getItemSummaryItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.findElement(driver, ITEMSUMMARY_ITEM_QUANTITY).getText();
	}

	@Override
	public String getItemSummaryItemSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.findElement(driver, ITEMSUMMARY_ITEM_SUPPLIER).getText();
	}

	@Override
	public String getItemSummaryItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.findElement(driver, ITEMSUMMARY_ITEM_TOTALPRICE).getText();
	}

}
