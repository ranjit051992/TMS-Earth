package com.zycus.automation.eproc.pageobjects.pages.settings.businessUnitMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageBusinessUnitMasterDataSettings
{
	final static String	ACTIVE				= "active";
	final static String	INACTIVE			= "inactivate";

	final UI_Elements	TEXTBOX_SEARCH_BU	= UIFactory.getElements("TEXTBOX_SEARCH_BU");
	final UI_Elements	BUTTON_GO_IN_BU		= UIFactory.getElements("BUTTON_GO_IN_BU");
	final UI_Elements	LINK_ACTIVE_BU		= UIFactory.getElements("LINK_ACTIVE_BU");
	final UI_Elements	LINK_INACTIVE_BU	= UIFactory.getElements("LINK_INACTIVE_BU");

	public String fillBUSearchName(WebDriver driver, String testCaseName, String buName) throws ActionBotException;

	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
