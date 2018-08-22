package com.zycus.automation.eproc.pageobjects.pages.settings.glmapsmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageGLMapsMasterDataSettings
{
	final static UI_Elements	TEXTBOX_SEARCH_GL_MAPS									= UIFactory.getElements("TEXTBOX_SEARCH_GL_MAPS");

	final static UI_Elements	SELECT_FROM_OPTIONS_GL_MAPS								= UIFactory.getElements("SELECT_FROM_OPTIONS_GL_MAPS");

	final static UI_Elements	BUTTON_GO_GL_MAPS										= UIFactory.getElements("BUTTON_GO_GL_MAPS");

	final static UI_Elements	LINK_DELETE_GL_MAPS										= UIFactory.getElements("LINK_DELETE_GL_MAPS");

	final static UI_Elements	LINK_ADD_GL_RULES_MAP									= UIFactory.getElements("LINK_ADD_GL_RULES_MAP");

	final static UI_Elements	TEXTBOX_FILL_CATEGORY_IN_GL_MAP							= UIFactory.getElements("TEXTBOX_FILL_CATEGORY_IN_GL_MAP");

	final static UI_Elements	SELECT_COMPANY_IN_GL_MAP								= UIFactory.getElements("SELECT_COMPANY_IN_GL_MAP");

	final static UI_Elements	SELECT_PURCHASE_TYPE_IN_GL_MAP							= UIFactory.getElements("SELECT_PURCHASE_TYPE_IN_GL_MAP");

	final static UI_Elements	CHECKBOX_ANY_PURCHASE_TYPE_IN_GL_MAP					= UIFactory.getElements("CHECKBOX_ANY_PURCHASE_TYPE_IN_GL_MAP");

	final static UI_Elements	SELECT_GL_ACCOUNT_TYPE_IN_GL_MAP						= UIFactory.getElements("SELECT_GL_ACCOUNT_TYPE_IN_GL_MAP");

	final static UI_Elements	TEXTBOX_FILL_GL_ACCOUNT_IN_GL_MAP						= UIFactory.getElements("TEXTBOX_FILL_GL_ACCOUNT_IN_GL_MAP");

	final static UI_Elements	BUTTON_SAVE_ADD_GL_CATEGORY_GENERAL_LEDGER_IN_GL_MAP	= UIFactory.getElements("BUTTON_SAVE_ADD_GL_CATEGORY_GENERAL_LEDGER_IN_GL_MAP");

	final static UI_Elements	LINK_SELECT_ORGANIZATION_UNIT_GL_RULEMAP				= UIFactory.getElements("LINK_SELECT_ORGANIZATION_UNIT_GL_RULEMAP");

	final static UI_Elements	DROPDOWN_COMPANY_SEARCH_BY								= UIFactory.getElements("DROPDOWN_COMPANY_SEARCH_BY");

	final static UI_Elements	TEXTBOX_SEARCH_COMPANY_OU_PAGE							= UIFactory.getElements("TEXTBOX_SEARCH_COMPANY_OU_PAGE");

	final static UI_Elements	BUTTON_GO_SELECT_COMPANY								= UIFactory.getElements("BUTTON_GO_SELECT_COMPANY");

	final static UI_Elements	SELECT_COMPANY_FIRST_RADIO_BUTTON						= UIFactory.getElements("SELECT_COMPANY_FIRST_RADIO_BUTTON");

	final static UI_Elements	TAB_BUSINESS_UNIT_OU_PAGE								= UIFactory.getElements("TAB_BUSINESS_UNIT_OU_PAGE");

	final static UI_Elements	SELECT_OU_AGAINST_COMPANY								= UIFactory.getElements("SELECT_OU_AGAINST_COMPANY");

	final static UI_Elements	LINK_SELECT_ALL_OU										= UIFactory.getElements("LINK_SELECT_ALL_OU");

	final static UI_Elements	SAVE_OU													= UIFactory.getElements("SAVE_OU");

	final static UI_Elements	SAVE_COMPANY											= UIFactory.getElements("SAVE_COMPANY");

	public String fillSearch(WebDriver driver, String testCaseName, String glmap) throws ActionBotException;

	public String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException;

	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelete(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException;

	public String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException;

	public void clickOnAnyPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException;

	public String enterGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException;

	public void clickOnSaveAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCompanyAndBussinessUnitForGLRuleMap(WebDriver driver, String testCaseName, String company) throws ActionBotException;
}
