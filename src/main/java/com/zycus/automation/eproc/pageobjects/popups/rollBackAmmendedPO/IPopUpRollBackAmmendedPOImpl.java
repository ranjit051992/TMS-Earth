package com.zycus.automation.eproc.pageobjects.popups.rollBackAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopUpRollBackAmmendedPOImpl implements IPopUpRollBackAmmendedPO
{

	@Override
	public boolean isRollBackCancelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ROLL_BACK_CANCEL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isRollBackContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ROLL_BACK_CONTINUE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCancelRollBack(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ROLL_BACK_CANCEL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel roll back");

	}

}
