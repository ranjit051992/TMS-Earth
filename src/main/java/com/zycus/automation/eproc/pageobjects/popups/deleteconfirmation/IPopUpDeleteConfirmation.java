/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpDeleteConfirmation
{
	final UI_Elements	BUTTON_YES						= UIFactory.getElements("BUTTON_YES");
	final UI_Elements	BUTTON_NO						= UIFactory.getElements("BUTTON_NO");
	final UI_Elements	BUTTON_PO_CONFIRM_DELETE_NO		= UIFactory.getElements("BUTTON_PO_CONFIRM_DELETE_NO");
	final UI_Elements	BUTTON_PO_CONFIRM_DELETE_YES	= UIFactory.getElements("BUTTON_PO_CONFIRM_DELETE_YES");
	final UI_Elements	CONFIRM_DELETE_MSG				= UIFactory.getElements("CONFIRM_DELETE_MSG");

	public void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPODeleteYES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPODeleteNO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeleteConfirmationMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
