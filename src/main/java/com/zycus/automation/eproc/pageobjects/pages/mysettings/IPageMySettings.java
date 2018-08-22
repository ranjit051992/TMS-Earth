/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mysettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageMySettings
{
	UI_Elements	TEXTBOX_DELEGATE_FROM			= UIFactory.getElements("TEXTBOX_DELEGATE_FROM");
	UI_Elements	TEXTBOX_DELEGATE_TO				= UIFactory.getElements("TEXTBOX_DELEGATE_TO");
	UI_Elements	DATE_PICKER_DELEGATE_FROM		= UIFactory.getElements("DATE_PICKER_DELEGATE_FROM");
	UI_Elements	DATE_PICKER_DELEGATE_TO			= UIFactory.getElements("DATE_PICKER_DELEGATE_TO");
	UI_Elements	TEXTBOX_DELEGATE_FROM_DATE		= UIFactory.getElements("TEXTBOX_DELEGATE_FROM_DATE");
	UI_Elements	TEXTBOX_DELEGATE_TO_DATE		= UIFactory.getElements("TEXTBOX_DELEGATE_TO_DATE");
	UI_Elements	BUTTON_ENABLE_DELEGATION		= UIFactory.getElements("BUTTON_ENABLE_DELEGATION");
	UI_Elements	BUTTON_CANCEL_DELEGATION		= UIFactory.getElements("BUTTON_CANCEL_DELEGATION");
	UI_Elements	TEXTBOX_DELEGATE_REVOKE_FROM	= UIFactory.getElements("TEXTBOX_DELEGATE_REVOKE_FROM");
	UI_Elements	LABEL_REVOKE_FROM_DATE			= UIFactory.getElements("LABEL_REVOKE_FROM_DATE");
	UI_Elements	LABEL_REVOKE_TO_DATE			= UIFactory.getElements("LABEL_REVOKE_TO_DATE");
	UI_Elements	BUTTON_REVOKE_DELEGATE			= UIFactory.getElements("BUTTON_REVOKE_DELEGATE");

	public String fillDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException;

	public String fillDelegateApprovalTo(WebDriver driver, String testCaseName, String delegateToUserName) throws ActionBotException;

	public String getFromDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getToDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEnableButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRevokeDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException;

	public void clickOnRevokeButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
