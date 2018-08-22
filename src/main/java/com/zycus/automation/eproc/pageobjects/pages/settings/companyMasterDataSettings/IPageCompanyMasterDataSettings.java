package com.zycus.automation.eproc.pageobjects.pages.settings.companyMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageCompanyMasterDataSettings
{
	final static String	ACTIVE					= "active";
	final static String	INACTIVE				= "inactivate";

	final UI_Elements	TEXTBOX_SEARCH_COMPANY	= UIFactory.getElements("TEXTBOX_SEARCH_COMPANY");
	final UI_Elements	BUTTON_GO_IN_COMPANY	= UIFactory.getElements("BUTTON_GO_IN_COMPANY");
	final UI_Elements	LINK_ACTIVE_COMPANY		= UIFactory.getElements("LINK_ACTIVE_COMPANY");
	final UI_Elements	LINK_INACTIVE_COMPANY	= UIFactory.getElements("LINK_INACTIVE_COMPANY");

	public String fillSearchCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
