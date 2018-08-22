package com.zycus.automation.eproc.pageobjects.popups.rollBackAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpRollBackAmmendedPO
{
	final UI_Elements	BUTTON_ROLL_BACK_CANCEL		= UIFactory.getElements("BUTTON_ROLL_BACK_CANCEL");
	final UI_Elements	BUTTON_ROLL_BACK_CONTINUE	= UIFactory.getElements("BUTTON_ROLL_BACK_CONTINUE");

	public boolean isRollBackCancelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRollBackContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelRollBack(WebDriver driver, String testCaseName) throws ActionBotException;
}
