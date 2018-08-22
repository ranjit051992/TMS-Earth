/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class PopUpSendForApprovalImpl implements IPopUpSendForApproval
{

	@Override
	public boolean isSendForApprovalYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SEND_FOR_APPROVAL_YES);
	}

	@Override
	public boolean isSendForApprovalNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SEND_FOR_APPROVAL_NO);
	}

	@Override
	public void clickOnSendForApprovalYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_FOR_APPROVAL_YES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Send for approval Yes button");
	}

	@Override
	public void clickOnSendForApprovalNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_FOR_APPROVAL_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Send for approval No Button");
	}

}
