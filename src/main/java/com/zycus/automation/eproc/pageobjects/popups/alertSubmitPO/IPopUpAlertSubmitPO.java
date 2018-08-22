package com.zycus.automation.eproc.pageobjects.popups.alertSubmitPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpAlertSubmitPO
{
	final UI_Elements	POPUP_ALERT_ZERO_PRICE_PO			= UIFactory.getElements("POPUP_ALERT_ZERO_PRICE_PO");
	final UI_Elements	BUTTON_ALERT_OK_ZERO_PRICE_PO		= UIFactory.getElements("BUTTON_ALERT_OK_ZERO_PRICE_PO");
	final UI_Elements	POPUP_ALERT_ZERO_PRICE_MESSAGE_PO	= UIFactory.getElements("POPUP_ALERT_ZERO_PRICE_MESSAGE_PO");
	final UI_Elements	BUTTON_YES_POPUP_ZERO_PRICE_PO		= UIFactory.getElements("BUTTON_YES_POPUP_ZERO_PRICE_PO");

	public boolean isAlertPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertMessageCorrect(WebDriver driver, String testCaseName) throws ActionBotException;;

	public void clickOnOK(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertOKPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException;
}
