package com.zycus.automation.eproc.pageobjects.popups.alertAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPopUpAlertAmmendedPOImpl implements IPopUpAlertAmmendedPO
{

	@Override
	public boolean isAlertPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_ALERT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAlertMessageSameAsDescribed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, POPUP_ALERT_MESSAGE);
		if (str.equalsIgnoreCase("This purchase order has already been amended by another Buyer."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_ALERT_CONTINUE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCancelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_ALERT_CANCEL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, POPUP_ALERT_CANCEL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel");

	}

	@Override
	public void clickOnContinueButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		if (ActionBot.isElementDisplayed(driver, POPUP_ALERT_CONTINUE))
		{
			ActionBot.click(driver, POPUP_ALERT_CONTINUE);
			ActionBot.waitForPageLoad(driver);
		}

	}

}
