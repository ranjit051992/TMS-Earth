package com.zycus.automation.eproc.pageobjects.popups.confirmationPopUp;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPopUpConfirmationImpl implements IPopUpConfirmation
{

	@Override
	public void clickOnConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_PO);
		ActionBot.defaultSleep();

	}

}
