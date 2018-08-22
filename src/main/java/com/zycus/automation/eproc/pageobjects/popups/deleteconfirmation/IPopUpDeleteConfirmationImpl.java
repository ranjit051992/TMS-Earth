package com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopUpDeleteConfirmationImpl implements IPopUpDeleteConfirmation
{

	@Override
	public void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Yes Button");
	}

	@Override
	public void clickOnNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on No Button");
	}

	@Override
	public boolean isYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_YES);
	}

	@Override
	public boolean isNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_NO);
	}

	@Override
	public void clickOnPODeleteYES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PO_CONFIRM_DELETE_YES);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnPODeleteNO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PO_CONFIRM_DELETE_NO);

	}

	@Override
	public boolean isDeleteConfirmationMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, CONFIRM_DELETE_MSG);
		String msg = ActionBot.getTextWithInElement(driver, CONFIRM_DELETE_MSG);
		if (msg.equalsIgnoreCase("Are you sure you want to delete this Purchase Order?"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
