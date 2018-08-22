package com.zycus.automation.eproc.pageobjects.popups.errorAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopUpErrorAmmendedPOImpl implements IPopUpErrorAmmendedPO
{

	@Override
	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ERROR_MESSAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnOK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OK");

	}

}
