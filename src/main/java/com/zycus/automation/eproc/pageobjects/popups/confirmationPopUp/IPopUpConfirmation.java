package com.zycus.automation.eproc.pageobjects.popups.confirmationPopUp;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpConfirmation
{
	final static UI_Elements BUTTON_YES_PO = UIFactory.getElements("BUTTON_YES_PO");

	public void clickOnConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException;
}
