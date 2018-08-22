package com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageGLAccountsMasterDataSettings
{
	final static String			ACTIVE							= "active";
	final static String			INACTIVE						= "inactive";

	final static UI_Elements	TEXTBOX_SEARCH_GL_ACCOUNTS		= UIFactory.getElements("TEXTBOX_SEARCH_GL_ACCOUNTS");
	final static UI_Elements	BUTTON_GO_GL_ACCOUNTS			= UIFactory.getElements("BUTTON_GO_GL_ACCOUNTS");
	final static UI_Elements	LINK_ACTIVE_GL_ACCOUNTS			= UIFactory.getElements("LINK_ACTIVE_GL_ACCOUNTS");
	final static UI_Elements	LINK_DEACTIVE_GL_ACCOUNTS		= UIFactory.getElements("LINK_DEACTIVE_GL_ACCOUNTS");
	final static UI_Elements	GL_ACCOUNT_SEARCH_OPTION		= UIFactory.getElements("GL_ACCOUNT_SEARCH_OPTION");
	final static UI_Elements	LINK_ADD_NEW_GL_ACCOUNT			= UIFactory.getElements("LINK_ADD_NEW_GL_ACCOUNT");
	final static UI_Elements	SELECT_COMPANY_GL_ACCOUNT		= UIFactory.getElements("SELECT_COMPANY_GL_ACCOUNT");
	final static UI_Elements	SELECT_GL_ACCOUNT_TYPE			= UIFactory.getElements("SELECT_GL_ACCOUNT_TYPE");
	final static UI_Elements	TEXTBOX_GL_ACCOUNT_CODE			= UIFactory.getElements("TEXTBOX_GL_ACCOUNT_CODE");
	final static UI_Elements	BUTTON_ADD_GL_ACCOUNT			= UIFactory.getElements("BUTTON_ADD_GL_ACCOUNT");
	final static UI_Elements	TEXTBOX_NAME					= UIFactory.getElements("TEXTBOX_NAME");
	final static UI_Elements	LINK_DELETE_GL_ACCOUNTS			= UIFactory.getElements("LINK_DELETE_GL_ACCOUNTS");
	final static UI_Elements	GL_ACCOUNT_NAME_FIRST_LISTED	= UIFactory.getElements("GL_ACCOUNT_NAME_FIRST_LISTED");

	public String enterGLAccountInSearch(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException;

	public int selectGlAccountCode(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterGLAccountName(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException;

	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException;

	public String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException;

	public Integer enterGLAccountCode(WebDriver driver, String testCaseName, int code) throws ActionBotException;

	public void clickOnApplyAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstListedGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

}
