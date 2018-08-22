/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageMasterDataSettings
{
	final static UI_Elements	USERS_LINK							= UIFactory.getElements("USERS_LINK");
	final static UI_Elements	GL_ACCOUNT_TYPES_LINK				= UIFactory.getElements("GL_ACCOUNT_TYPES_LINK");
	final static UI_Elements	GL_ACCOUNTS_LINK					= UIFactory.getElements("GL_ACCOUNTS_LINK");
	final static UI_Elements	CATEGORY_PURCHASE_TYPE_GL_MAPS_LINK	= UIFactory.getElements("CATEGORY_PURCHASE_TYPE_GL_MAPS_LINK");
	final static UI_Elements	RETURN_TO_SET_UP_MODULE				= UIFactory.getElements("RETURN_TO_SET_UP_MODULE");
	final static UI_Elements	PROJECTS_LINK						= UIFactory.getElements("PROJECTS_LINK");
	final static UI_Elements	LOCATION_LINK						= UIFactory.getElements("LOCATION_LINK");
	final static UI_Elements	TAX_RATES_LINK						= UIFactory.getElements("TAX_RATES_LINK");
	final static UI_Elements	ADDRESSES_LINK						= UIFactory.getElements("ADDRESSES_LINK");
	final static UI_Elements	COMPANIES_LINK						= UIFactory.getElements("COMPANIES_LINK");
	final static UI_Elements	BACK_TO_SUMMARY_LINK				= UIFactory.getElements("BACK_TO_SUMMARY_LINK");
	final static UI_Elements	COSTCENTER_LINK						= UIFactory.getElements("COSTCENTER_LINK");
	final static UI_Elements	BUSINESS_UNIT_LINK					= UIFactory.getElements("BUSINESS_UNIT_LINK");
	UI_Elements					LINK_ENTITY_OWNERSHIP				= UIFactory.getElements("LINK_ENTITY_OWNERSHIP");
	final static UI_Elements	ASSET_CODES_LINK					= UIFactory.getElements("ASSET_CODES_LINK");
	final static UI_Elements	SUPPLIER_CODES_MAP_LINK				= UIFactory.getElements("SUPPLIER_CODES_MAP_LINK");
	UI_Elements					LINK_STATISTICAL_PROJECTS			= UIFactory.getElements("LINK_STATISTICAL_PROJECTS");
	UI_Elements					BUTTON_PROCEED_WITH_WIZARD			= UIFactory.getElements("BUTTON_PROCEED_WITH_WIZARD");
	final static UI_Elements	TAB_USER_MANAGEMENT					= UIFactory.getElements("TAB_USER_MANAGEMENT");

	final static UI_Elements	USERS_LINK_IN_USER_MANAGEMENT		= UIFactory.getElements("USERS_LINK_IN_USER_MANAGEMENT");

	public void clickOnUsersLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGLAccountTypesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGLAccountsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCategoryPurchaseType_GL_Maps_Link(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProjectsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCostCenterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLocationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxRatesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddressLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCompaniesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCompanyActivateAndDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnBackToSummaryLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnBusinessUnitLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEntityOwnershiplink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAssetCodesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierCodesMapLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProceedWithWizardButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUsersLinkInUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException;

}
