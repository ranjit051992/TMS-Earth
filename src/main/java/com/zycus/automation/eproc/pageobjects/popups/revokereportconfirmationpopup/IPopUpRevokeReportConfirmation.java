/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.revokereportconfirmationpopup;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpRevokeReportConfirmation
{
	static UI_Elements	BUTTON_YES_CONFIRMATION_TO_REVOKE_REPORT	= UIFactory.getElements("BUTTON_YES_CONFIRMATION_TO_REVOKE_REPORT");

	static UI_Elements	BUTTON_CANCEL_CONFIRMATION_TO_REVOKE_REPORT	= UIFactory.getElements("BUTTON_CANCEL_CONFIRMATION_TO_REVOKE_REPORT");

	static UI_Elements	LABEL_CONFIRMATION_MESSAGE_TO_REVOKE_REPORT	= UIFactory.getElements("LABEL_CONFIRMATION_MESSAGE_TO_REVOKE_REPORT");

	public void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getConfirmationMessage(WebDriver driver, String testCaseName) throws ActionBotException;

}
