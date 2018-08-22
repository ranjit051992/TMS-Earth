package com.zycus.automation.eproc.pageobjects.popups.alertAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpAlertAmmendedPO
{
	final UI_Elements	POPUP_ALERT				= UIFactory.getElements("POPUP_ALERT");
	final UI_Elements	POPUP_ALERT_MESSAGE		= UIFactory.getElements("POPUP_ALERT_MESSAGE");
	final UI_Elements	POPUP_ALERT_CONTINUE	= UIFactory.getElements("POPUP_ALERT_CONTINUE");
	final UI_Elements	POPUP_ALERT_CANCEL		= UIFactory.getElements("POPUP_ALERT_CANCEL");

	public boolean isAlertPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertMessageSameAsDescribed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCancelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

}
