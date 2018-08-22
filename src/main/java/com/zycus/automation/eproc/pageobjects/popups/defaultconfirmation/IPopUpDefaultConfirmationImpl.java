/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPopUpDefaultConfirmationImpl implements IPopUpDefaultConfirmation
{
	static Logger logger = Logger.getLogger(IPopUpDefaultConfirmationImpl.class);

	@Override
	public void clickOnConfirmYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Before clicking on
		// Confirm Yes Button");
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUTTON_YES_CONFIRM_BUYERS_DESK))
		{
			ActionBot.click(driver, BUTTON_YES_CONFIRM_BUYERS_DESK);
			//ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Confirm Yes Button");
	}

	@Override
	public void clickOnConfirmNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Before clicking on
		// Confirm No Button");
		if (ActionBot.isElementPresent(driver, BUTTON_NO_CONFIRM))
		{
			ActionBot.click(driver, BUTTON_NO_CONFIRM);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Confirm No Button");
	}

	@Override
	public boolean isConfirmYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, BUTTON_YES_CONFIRM_BUYERS_DESK);
	}

	@Override
	public boolean isConfirmNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_NO_CONFIRM);
	}

	@Override
	public String getPopUpMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, LABEL_POP_UP_MSG);
		logger.info("Pop Up Message : " + msg);
		return msg;
	}

	@Override
	public String getTextOfYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, SPAN_YES_CONFIRM);
		logger.info("Label Value of Yes Button : " + labelValue);
		return labelValue;
	}

	@Override
	public String getTextOfNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, SPAN_NO_CONFIRM);
		logger.info("Label Value of No Button : " + labelValue);
		return labelValue;
	}

	@Override
	public void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_OK_CONFIRM))
		{
			ActionBot.click(driver, BUTTON_OK_CONFIRM);
			ScreenShot.screenshot(driver, testCaseName, "After clicking OK Button");
		}

	}

	@Override
	public boolean clickOnConfirmYesButtonSpanType(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, SPAN_YES_CONFIRM))
		{
			ActionBot.click(driver, SPAN_YES_CONFIRM);
			return true;
			//ActionBot.defaultSleep();
		}

		return false;
	}
}
