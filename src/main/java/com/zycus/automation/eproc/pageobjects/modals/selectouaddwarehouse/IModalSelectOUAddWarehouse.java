package com.zycus.automation.eproc.pageobjects.modals.selectouaddwarehouse;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * 
 * @author t.amarnath
 *
 */
public interface IModalSelectOUAddWarehouse
{
	static UI_Elements	COMPANY_TAB_SELECT_OU_ADD_WAREHOUSE						= UIFactory.getElements("COMPANY_TAB_SELECT_OU_ADD_WAREHOUSE");
	static UI_Elements	BUSINESS_UNITS_SELECT_OU_ADD_WAREHOUSE					= UIFactory.getElements("BUSINESS_UNITS_SELECT_OU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_OU_1ST_COMPANY_SELECT_OU_ADD_WAREHOUSE	= UIFactory.getElements("CHECKBOX_SELECT_OU_1ST_COMPANY_SELECT_OU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_OU_2ND_COMPANY_SELECT_OU_ADD_WAREHOUSE	= UIFactory.getElements("CHECKBOX_SELECT_OU_2ND_COMPANY_SELECT_OU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_OU_ADD_WAREHOUSE						= UIFactory.getElements("CHECKBOX_SELECT_OU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_1ST_BU_ADD_WAREHOUSE					= UIFactory.getElements("CHECKBOX_SELECT_1ST_BU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_2ND_BU_ADD_WAREHOUSE					= UIFactory.getElements("CHECKBOX_SELECT_2ND_BU_ADD_WAREHOUSE");
	static UI_Elements	CHECKBOX_SELECT_3RD_BU_ADD_WAREHOUSE					= UIFactory.getElements("CHECKBOX_SELECT_3RD_BU_ADD_WAREHOUSE");
	static UI_Elements	BUTTON_SAVE_SELECTED_UNITS_ADD_WAREHOUSE				= UIFactory.getElements("BUTTON_SAVE_SELECTED_UNITS_ADD_WAREHOUSE");
	static UI_Elements	BUTTON_SAVE_SELECTED_SCOPE_ADD_WAREHOUSE				= UIFactory.getElements("BUTTON_SAVE_SELECTED_SCOPE_ADD_WAREHOUSE");
	static UI_Elements	BUTTON_CANCEL_SELECTED_SCOPE_ADD_WAREHOUSE				= UIFactory.getElements("BUTTON_CANCEL_SELECTED_SCOPE_ADD_WAREHOUSE");

	public void clickOnCompanyTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSecondCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectOUInBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSecondBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnThirdBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveSelectedUnitsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
