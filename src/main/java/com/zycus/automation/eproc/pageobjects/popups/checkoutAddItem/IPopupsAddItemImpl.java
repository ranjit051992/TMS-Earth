package com.zycus.automation.eproc.pageobjects.popups.checkoutAddItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopupsAddItemImpl implements IPopupsAddItem
{

	@Override
	public void clickAddItemDontSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, CHECKOUT_ADD_ITEM_DONTSAVE);
		ScreenShot.screenshot(driver, testCaseName, "Dont Save previous Req");

	}

	@Override
	public void clickAddItemSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, CHECKOUT_ADD_ITEM_SAVE);
		ScreenShot.screenshot(driver, testCaseName, "Save previous Req");
	}

}
