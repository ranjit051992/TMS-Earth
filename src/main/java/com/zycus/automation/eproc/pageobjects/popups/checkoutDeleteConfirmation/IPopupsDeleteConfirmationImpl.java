package com.zycus.automation.eproc.pageobjects.popups.checkoutDeleteConfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopupsDeleteConfirmationImpl implements IPopupsDeleteConfirmation
{

	@Override
	public void clickDeleteConfirmationNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, CHECKOUT_DELETE_NO);
		ScreenShot.screenshot(driver, testCaseName, "Delete Confirmation No");

	}

	@Override
	public void clickDeleteConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, CHECKOUT_DELETE_YES);
		ScreenShot.screenshot(driver, testCaseName, "Delete Confirmation Yes");
	}

	@Override
	public String getDeleteItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String str = ActionBot.findElement(driver, CHECKOUT_DELETE_ITEM_NAME).getText();
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

}
