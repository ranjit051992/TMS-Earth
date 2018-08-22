/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public interface IModalSelectCompaniesAndBU
{
	static UI_Elements	CHECK_BOX_SELECT_OU								= UIFactory.getElements("CHECK_BOX_SELECT_OU");
	static UI_Elements	BUTTON_SAVE_OU									= UIFactory.getElements("BUTTON_SAVE_OU");
	static UI_Elements	BUTTON_CANCEL_OU								= UIFactory.getElements("BUTTON_CANCEL_OU");
	UI_Elements			BUTTON_EXPAND_TREE								= UIFactory.getElements("BUTTON_EXPAND_TREE");
	UI_Elements			TAB_CATALOG_SCOPE_REGIONS						= UIFactory.getElements("TAB_CATALOG_SCOPE_REGIONS");
	UI_Elements			TAB_CATALOG_SCOPE_COMPANIES						= UIFactory.getElements("TAB_CATALOG_SCOPE_COMPANIES");
	UI_Elements			TAB_CATALOG_SCOPE_BUSINESS_UNITS				= UIFactory.getElements("TAB_CATALOG_SCOPE_BUSINESS_UNITS");
	UI_Elements			TAB_CATALOG_SCOPE_LOCATIONS						= UIFactory.getElements("TAB_CATALOG_SCOPE_LOCATIONS");
	UI_Elements			LINK_SELECT_ORGANIZATION_UNIT_IN_COMPANIES_TAB	= UIFactory.getElements("LINK_SELECT_ORGANIZATION_UNIT_IN_COMPANIES_TAB");
	UI_Elements			CHECK_BOX_SELECT_ALL_OUS_IN_COMPANIES_TAB		= UIFactory.getElements("CHECK_BOX_SELECT_ALL_OUS_IN_COMPANIES_TAB");
	UI_Elements			BUTTON_SAVE_SELECTED_OUS						= UIFactory.getElements("BUTTON_SAVE_SELECTED_OUS");
	UI_Elements			BUTTON_CANCEL_SELECTED_OUS						= UIFactory.getElements("BUTTON_CANCEL_SELECTED_OUS");
	UI_Elements			PROCESSING_DIV_OU_LISTING_TABLE					= UIFactory.getElements("PROCESSING_DIV_OU_LISTING_TABLE");
	UI_Elements			LINK_SELECT_ALL_BUSINESS_UNIT					= UIFactory.getElements("LINK_SELECT_ALL_BUSINESS_UNIT");
	UI_Elements			LINK_SELECT_ALL_LOCATIONS						= UIFactory.getElements("LINK_SELECT_ALL_LOCATIONS");
	UI_Elements			LOADING_DIV										= UIFactory.getElements("LOADING_DIV");
	UI_Elements			BUTTON_SAVE_SELECTED_SCOPE						= UIFactory.getElements("BUTTON_SAVE_SELECTED_SCOPE");
	UI_Elements			BUTTON_CANCEL_SELECTED_SCOPE					= UIFactory.getElements("BUTTON_CANCEL_SELECTED_SCOPE");
	// select OU-catalog
	UI_Elements			CHECKBOX_SELECT_OU_IST_COMPANY					= UIFactory.getElements("CHECKBOX_SELECT_OU_IST_COMPANY");
	UI_Elements			CHECKBOX_SELECT_OU_SEC_COMPANY					= UIFactory.getElements("CHECKBOX_SELECT_OU_SEC_COMPANY");
	UI_Elements			TAB_BUSINESS_UNIT								= UIFactory.getElements("TAB_BUSINESS_UNIT");

	UI_Elements			LINK_SELECT_ALL_BUS								= UIFactory.getElements("LINK_SELECT_ALL_BUS");

	UI_Elements			TAB_OU_LOCATION									= UIFactory.getElements("TAB_OU_LOCATION");
	UI_Elements			LINK_CLICK_HERE_TO_EDIT							= UIFactory.getElements("LINK_CLICK_HERE_TO_EDIT");
	UI_Elements			LINK_SELECT_ALL_LOCATION						= UIFactory.getElements("LINK_SELECT_ALL_LOCATION");
	UI_Elements			LINK_SELECT_OU_UNDER_BU_TAB						= UIFactory.getElements("LINK_SELECT_OU_UNDER_BU_TAB");
	UI_Elements			LINK_SELECT_OU_UNDER_LOCATIONS_TAB				= UIFactory.getElements("LINK_SELECT_OU_UNDER_LOCATIONS_TAB");
	UI_Elements			CHECKBOX_SELECT_OU_THIRD_COMPANY				= UIFactory.getElements("CHECKBOX_SELECT_OU_THIRD_COMPANY");
	UI_Elements			LIST_OF_ALL_COMPANIES							= UIFactory.getElements("LIST_OF_ALL_COMPANIES");
	UI_Elements			LIST_OF_ALL_BUS									= UIFactory.getElements("LIST_OF_ALL_BUS");
	UI_Elements			LIST_OF_ALL_LOCATIONS							= UIFactory.getElements("LIST_OF_ALL_LOCATIONS");
	UI_Elements			LINK_SELECT_OU_BU_TAB							= UIFactory.getElements("LINK_SELECT_OU_BU_TAB");
	UI_Elements			BTN_SAVE_SELECTED_OUS							= UIFactory.getElements("BTN_SAVE_SELECTED_OUS");
	UI_Elements			FIRST_BU_CHECKBOX								= UIFactory.getElements("FIRST_BU_CHECKBOX");
	UI_Elements			LINK_SELECT_OU_LOCATIONS_TAB					= UIFactory.getElements("LINK_SELECT_OU_LOCATIONS_TAB");

	public void selectAllOU(WebDriver driver, String testCaseName, String regionName) throws ActionBotException;

	public String selectOU(WebDriver driver, String testCaseName, String ou) throws ActionBotException;

	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRegionsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRegionsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectIstCompanies(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSecCompanies(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCompaniesTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLcoationsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean selectRegion(WebDriver driver, String testCaseName, String region) throws ActionBotException;

	public void clickOnSelectOULink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllOUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllBUsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllLocationsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkSelecteAllBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkOnLinkHereToEditAllBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOUUnderBUTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOUUnderLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectThirdCompanies(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getAllCompanies(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getAllBUs(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getAllLocations(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectOUInBUTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveSelectedOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstBUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnselectOUInLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSaveSelectedOUButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCompaniesTabPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBusinessUnitsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isLocationsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectAllBUsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectAllLocationsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
