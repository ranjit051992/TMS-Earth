/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpDefaultConfirmation
{
	static UI_Elements	BUTTON_YES_CONFIRM_BUYERS_DESK	= UIFactory.getElements("BUTTON_YES_CONFIRM_BUYERS_DESK");
	static UI_Elements	BUTTON_NO_CONFIRM				= UIFactory.getElements("BUTTON_NO_CONFIRM");
	UI_Elements			LABEL_POP_UP_MSG				= UIFactory.getElements("LABEL_POP_UP_MSG");
	UI_Elements			SPAN_YES_CONFIRM				= UIFactory.getElements("SPAN_YES_CONFIRM");
	UI_Elements			SPAN_NO_CONFIRM					= UIFactory.getElements("SPAN_NO_CONFIRM");
	static UI_Elements	BUTTON_OK_CONFIRM				= UIFactory.getElements("BUTTON_OK_CONFIRM");

	public void clickOnConfirmYesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfirmNoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isConfirmYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isConfirmNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPopUpMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfYesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnConfirmYesButtonSpanType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfNoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
