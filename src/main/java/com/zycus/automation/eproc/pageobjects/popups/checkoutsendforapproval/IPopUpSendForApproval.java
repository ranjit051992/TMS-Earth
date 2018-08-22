/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpSendForApproval
{
	static UI_Elements	BUTTON_SEND_FOR_APPROVAL_YES	= UIFactory.getElements("BUTTON_SEND_FOR_APPROVAL_YES");
	static UI_Elements	BUTTON_SEND_FOR_APPROVAL_NO		= UIFactory.getElements("BUTTON_SEND_FOR_APPROVAL_NO");

	public boolean isSendForApprovalYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSendForApprovalNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendForApprovalYesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendForApprovalNoButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
