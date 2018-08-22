package com.zycus.automation.eproc.pageobjects.popups.errorAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpErrorAmmendedPO
{
	final UI_Elements	ERROR_MESSAGE	= UIFactory.getElements("ERROR_MESSAGE");
	final UI_Elements	BUTTON_OK		= UIFactory.getElements("BUTTON_OK");

	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOK(WebDriver driver, String testCaseName) throws ActionBotException;

}
