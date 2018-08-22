package com.zycus.automation.eproc.pageobjects.popups.masterdataprojectsetting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopupMasterDataProjectSettings
{
	final static UI_Elements	BUTTON_YES_ACTIVE_PROJECT	= UIFactory.getElements("BUTTON_YES_ACTIVE_PROJECT");
	final static UI_Elements	BUTTON_YES_DELETE_PROJECT	= UIFactory.getElements("BUTTON_YES_DELETE_PROJECT");

	public void clickOnYesActiveProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnYesDeleteProject(WebDriver driver, String testCaseName) throws ActionBotException;
}
