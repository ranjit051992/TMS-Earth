package com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageUserManagement
{
	final static UI_Elements	SEARCH_FIELD					= UIFactory.getElements("SEARCH_FIELD");
	final static UI_Elements	SEARCH_TYPE						= UIFactory.getElements("SEARCH_TYPE");
	final static UI_Elements	SEARCH_GO						= UIFactory.getElements("SEARCH_GO");
	final static UI_Elements	SEARCHED_USER_NAME_FIRST_ROW	= UIFactory.getElements("SEARCHED_USER_NAME_FIRST_ROW");
	final static UI_Elements	FIRST_ROW_EDIT_BUTTON			= UIFactory.getElements("FIRST_ROW_EDIT_BUTTON");
	final static UI_Elements	RETURN_TO_SET_UP_MODULE_USER	= UIFactory.getElements("RETURN_TO_SET_UP_MODULE_USER");
	final static UI_Elements	USER_INFO_LIST_PROCESSING		= UIFactory.getElements("USER_INFO_LIST_PROCESSING");
	UI_Elements					LINK_ADD_USER					= UIFactory.getElements("LINK_ADD_USER");
	final static UI_Elements	USER_CURRENCY					= UIFactory.getElements("USER_CURRENCY");

	public String fillSearchData(WebDriver driver, String testCaseName, String userToBeSearched) throws ActionBotException;

	public String selectSearchedUserByType(WebDriver driver, String testCaseName, String searchUserByType) throws ActionBotException;

	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedUserNameFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditSearchedUserButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddUserLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditUserLinkRowise(WebDriver driver, String testCaseName, int i) throws ActionBotException;

	public String getUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException;
}
