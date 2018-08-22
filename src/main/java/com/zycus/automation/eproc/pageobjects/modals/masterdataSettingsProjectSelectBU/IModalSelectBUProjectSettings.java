package com.zycus.automation.eproc.pageobjects.modals.masterdataSettingsProjectSelectBU;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalSelectBUProjectSettings
{
	final static UI_Elements BUTTON_SAVE_SELECTED_BU = UIFactory.getElements("BUTTON_SAVE_SELECTED_BU");

	public void clickOnBUCheckbox(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnBUCheckbox(WebDriver driver, String testCaseName, String BUName) throws ActionBotException;

	public void clickOnSaveSelectedBU(WebDriver driver, String testCaseName) throws ActionBotException;
}
