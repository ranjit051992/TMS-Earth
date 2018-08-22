package com.zycus.automation.eproc.pageobjects.popups.alertSubmitPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopUpAlertSubmitPOImpl implements IPopUpAlertSubmitPO
{

	@Override
	public boolean isAlertPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_ALERT_ZERO_PRICE_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAlertMessageCorrect(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String message = ActionBot.getTextWithInElement(driver, POPUP_ALERT_ZERO_PRICE_MESSAGE_PO);
		if (message.equalsIgnoreCase("	Item gross total should not be zero"))
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
		// ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ALERT_OK_ZERO_PRICE_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on ok");

	}

	@Override
	public boolean isAlertOKPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Alert");
		return ActionBot.isElementPresent(driver, BUTTON_ALERT_OK_ZERO_PRICE_PO);
	}

	@Override
	public boolean clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_POPUP_ZERO_PRICE_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Yes");
		ActionBot.defaultSleep();
		return true;
	}

}
