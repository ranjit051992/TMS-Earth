package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalSelectCategory
{
	final static UI_Elements	SELECT_CATEGORY_FIELD		= UIFactory.getElements("SELECT_CATEGORY_FIELD");
	final static UI_Elements	CROSS_BTN					= UIFactory.getElements("CROSS_BTN");
	final static UI_Elements	CANCEL_BTN					= UIFactory.getElements("CANCEL_BTN");
	final static UI_Elements	CLEAR_SEARCH_RESULTS		= UIFactory.getElements("CLEAR_SEARCH_RESULTS");
	final static UI_Elements	SELECT_EFORM				= UIFactory.getElements("SELECT_EFORM");
	final static UI_Elements	SELECT_THIS_CATEGORY		= UIFactory.getElements("SELECT_THIS_CATEGORY");
	final static UI_Elements	CHANGE_CATEGORY				= UIFactory.getElements("CHANGE_CATEGORY");
	final static UI_Elements	SEE_ALL_EFORM_LINK			= UIFactory.getElements("SEE_ALL_EFORM_LINK");
	final static UI_Elements	SEARCH_EFORM				= UIFactory.getElements("SEARCH_EFORM");
	final static UI_Elements	CATEGORY_EFORM_ITEMS		= UIFactory.getElements("CATEGORY_EFORM_ITEMS");
	final static UI_Elements	CATEGORY_EFORM_LINK			= UIFactory.getElements("CATEGORY_EFORM_LINK");
	final static UI_Elements	LINK_CANCEL_GUIDE_ME_POPUP	= UIFactory.getElements("LINK_CANCEL_GUIDE_ME_POPUP");

	String fillSelectCategory(WebDriver driver, String testcaseName, String selectCategory) throws ActionBotException;

	void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCrossBtnAtHeader(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickSelectThisCategoryLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickClearSearchResults(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isSelectEformIsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSelectEform(WebDriver driver, String testCaseName) throws ActionBotException;

	void selectCategoryEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException;

	void clickOnSeeAlleForms(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillSelectEform(WebDriver driver, String testcaseName, String eFormName) throws ActionBotException;

	void clickOnCategoryEformItem(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCategoryEform(WebDriver driver, String testCaseName) throws ActionBotException;

}
