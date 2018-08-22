package com.zycus.automation.tenanatCreation.pageObjects.masterData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface MasterData
{
	public static UI_Elements	TAB_MASTER_DATA									= UIFactory.getElements("TAB_MASTER_DATA");
	public static UI_Elements	TAB_CUSTOMIZE_MASTER_DATA						= UIFactory.getElements("TAB_CUSTOMIZE_MASTER_DATA");
	public static UI_Elements	LINK_CURRENCY									= UIFactory.getElements("LINK_CURRENCY");
	public static UI_Elements	LINK_EXCHANGE_RATES								= UIFactory.getElements("LINK_EXCHANGE_RATES");
	public static UI_Elements	LINK_UNIT_OF_MEASURE							= UIFactory.getElements("LINK_UNIT_OF_MEASURE");
	public static UI_Elements	LINK_COUNTRIES									= UIFactory.getElements("LINK_COUNTRIES");
	public static UI_Elements	LINK_STATE										= UIFactory.getElements("LINK_STATE");
	public static UI_Elements	LINK_CATEGORIES									= UIFactory.getElements("LINK_CATEGORIES");
	public static UI_Elements	LINK_CATEGORY_GROUPS							= UIFactory.getElements("LINK_CATEGORY_GROUPS");
	public static UI_Elements	LINK_DELIVERY_TERMS								= UIFactory.getElements("LINK_DELIVERY_TERMS");
	public static UI_Elements	LINK_PAYMENT_TERMS								= UIFactory.getElements("LINK_PAYMENT_TERMS");
	public static UI_Elements	LINK_PURCHASE_TYPES								= UIFactory.getElements("LINK_PURCHASE_TYPES");
	public static UI_Elements	LINK_SUPPLIER_CODES_MAP							= UIFactory.getElements("LINK_SUPPLIER CODES_MAP");
	public static UI_Elements	LINK_CUSTOM_MASTER								= UIFactory.getElements("LINK_CUSTOM_MASTER");
	public static UI_Elements	LINK_REGIONS									= UIFactory.getElements("LINK_REGIONS");
	public static UI_Elements	LINK_ADDRESSES									= UIFactory.getElements("LINK_ADDRESSES");
	public static UI_Elements	LINK_LOCATIONS									= UIFactory.getElements("LINK_LOCATIONS");
	public static UI_Elements	LINK_ORGANIZATION_UNITS							= UIFactory.getElements("LINK_ORGANIZATION_UNITS");
	public static UI_Elements	LINK_COMPANY									= UIFactory.getElements("LINK_COMPANY");
	public static UI_Elements	LINK_BUSINESS_UNIT								= UIFactory.getElements("LINK_BUSINESS_UNIT");
	public static UI_Elements	LINK_DEPARTMENTS								= UIFactory.getElements("LINK_DEPARTMENTS");
	public static UI_Elements	LINK_COST_CENTERS								= UIFactory.getElements("LINK_COST_CENTERS");
	public static UI_Elements	LINK_PROJECTS									= UIFactory.getElements("LINK_PROJECTS");
	public static UI_Elements	LINK_PROCUREMENT_SCOPE_CONFIGURATION			= UIFactory.getElements("LINK_PROCUREMENT_SCOPE_CONFIGURATION");

	public static UI_Elements	CHECKBOX_ALL_MASTER_DATA						= UIFactory.getElements("CHECKBOX_ALL_MASTER_DATA");
	public static UI_Elements	ACTIVATE_LINK_MASTER_DATA						= UIFactory.getElements("ACTIVATE_LINK_MASTER_DATA");
	public static UI_Elements	BUTTON_POPUP_YES_MASTER_DATA					= UIFactory.getElements("BUTTON_POPUP_YES_MASTER_DATA");
	public static UI_Elements	TEXTBOX_OU_NAME_LEVEL							= UIFactory.getElements("TEXTBOX_OU_NAME_LEVEL");
	public static UI_Elements	BUTTON_ADD_LEVEL								= UIFactory.getElements("BUTTON_ADD_LEVEL");
	public static UI_Elements	LINK_BACK_TO_SUMMARY_MASTER_DATA				= UIFactory.getElements("LINK_BACK_TO_SUMMARY_MASTER_DATA");
	public static UI_Elements	DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE				= UIFactory.getElements("DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE");
	public static UI_Elements	TEXTAREA_SCOPE_DESCRIPTION_BUSINESS_SCOPE		= UIFactory.getElements("TEXTAREA_SCOPE_DESCRIPTION_BUSINESS_SCOPE");
	public static UI_Elements	CHECKBOX_REGION_SCOPE_BUSINESS_SCOPE			= UIFactory.getElements("CHECKBOX_REGION_SCOPE_BUSINESS_SCOPE");
	public static UI_Elements	CHECKBOX_ORGANIZATION_STRUCTURE_BUSINESS_SCOPE	= UIFactory.getElements("CHECKBOX_ORGANIZATION_STRUCTURE_BUSINESS_SCOPE");
	public static UI_Elements	CHECKBOX_LOCATION_STRUCTURE_BUSINESS_SCOPE		= UIFactory.getElements("CHECKBOX_LOCATION_STRUCTURE_BUSINESS_SCOPE");
	public static UI_Elements	CHECKBOX_COST_CENTER_STRUCTURE_BUSINESS_SCOPE	= UIFactory.getElements("CHECKBOX_COST_CENTER_STRUCTURE_BUSINESS_SCOPE");
	public static UI_Elements	BUTTON_ADD_BUSINESS_SCOPE						= UIFactory.getElements("BUTTON_ADD_BUSINESS_SCOPE");
	public static UI_Elements	LINK_ADD_NEW_SCOPE								= UIFactory.getElements("LINK_ADD_NEW_SCOPE");
	public static UI_Elements	BUTTON_FILE_UPLOAD								= UIFactory.getElements("BUTTON_FILE_UPLOAD");
	public static UI_Elements	BUTTON_UPLOAD_CMD_FILE							= UIFactory.getElements("BUTTON_UPLOAD_CMD_FILE");
	public static UI_Elements	BUTTON_BROWSE_CMD								= UIFactory.getElements("BUTTON_BROWSE_CMD");
	public static UI_Elements	LINK_ADD_OU_LEVEL								= UIFactory.getElements("LINK_ADD_OU_LEVEL");

	public void selectAllCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllExchangeRates(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllCountries(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllStates(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void uploadPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadCatagories(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void createOrganizationUnits(WebDriver driver, String testCaseName, String organizationUnitName) throws ActionBotException;

	public void createProcurementScopeConfiguration(WebDriver driver, String testCaseName, String procurementScopeConfigurationName) throws ActionBotException;

	public void uploadRegions(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadAddresses(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadLocations(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadDepartment(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadCostCenters(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadDesignation(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

	public void uploadWorkOrder(WebDriver driver, String testCaseName) throws ActionBotException, IOException;

}
