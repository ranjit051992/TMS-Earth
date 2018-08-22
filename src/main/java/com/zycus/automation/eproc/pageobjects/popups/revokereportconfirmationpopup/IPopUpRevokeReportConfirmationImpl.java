/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.revokereportconfirmationpopup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IPopUpRevokeReportConfirmationImpl implements IPopUpRevokeReportConfirmation
{
	static Logger logger = Logger.getLogger(IPopUpRevokeReportConfirmationImpl.class);

	@Override
	public void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_CONFIRMATION_TO_REVOKE_REPORT);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CONFIRMATION_TO_REVOKE_REPORT);
	}

	@Override
	public String getConfirmationMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String confirmationMsg = ActionBot.getTextWithInElement(driver, LABEL_CONFIRMATION_MESSAGE_TO_REVOKE_REPORT);
		logger.info("Revoke confirmation message : " + confirmationMsg);
		return confirmationMsg;
	}

}
