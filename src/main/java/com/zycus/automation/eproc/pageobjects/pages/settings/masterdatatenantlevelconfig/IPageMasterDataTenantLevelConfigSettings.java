package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageMasterDataTenantLevelConfigSettings
{
	final static UI_Elements	TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE									= UIFactory.getElements("TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE");

	final static UI_Elements	BUTTON_SAVE_TENANT_LEVEL_CONFIG										= UIFactory.getElements("BUTTON_SAVE_TENANT_LEVEL_CONFIG");
	final static UI_Elements	ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_YES			= UIFactory
		.getElements("ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_YES");
	final static UI_Elements	ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_NO			= UIFactory
		.getElements("ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_NO");
	final static UI_Elements	PURCHASE_TYPE_FIELD													= UIFactory.getElements("PURCHASE_TYPE_FIELD");
	final static UI_Elements	ALLOW_SPLITTING_COST_TO_MULTIPLE_COST_CENTER_YES					= UIFactory.getElements("ALLOW_SPLITTING_COST_TO_MULTIPLE_COST_CENTER_YES");
	final static UI_Elements	USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_YES				= UIFactory
		.getElements("USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_YES");
	final static UI_Elements	USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_NO				= UIFactory.getElements("USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_NO");
	final static UI_Elements	MANAGE_STOCK_AT_WAREHOUSE_LEVEL_YES									= UIFactory.getElements("MANAGE_STOCK_AT_WAREHOUSE_LEVEL_YES");
	final static UI_Elements	MANAGE_STOCK_AT_WAREHOUSE_LEVEL_NO									= UIFactory.getElements("MANAGE_STOCK_AT_WAREHOUSE_LEVEL_NO");
	final static UI_Elements	RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_YES		= UIFactory
		.getElements("RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_YES");
	final static UI_Elements	RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_NO			= UIFactory
		.getElements("RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_NO");

	final static UI_Elements	ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_YES							= UIFactory.getElements("ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_YES");
	final static UI_Elements	ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_NO							= UIFactory.getElements("ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_NO");

	final static UI_Elements	ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_YES						= UIFactory.getElements("ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_YES");
	final static UI_Elements	ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_NO						= UIFactory.getElements("ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_NO");

	final static UI_Elements	ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_YES					= UIFactory.getElements("ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_YES");
	final static UI_Elements	ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_NO						= UIFactory.getElements("ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_NO");

	final static UI_Elements	RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_YES						= UIFactory.getElements("RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_YES");
	final static UI_Elements	RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_NO						= UIFactory.getElements("RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_NO");

	final static UI_Elements	RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_YES	= UIFactory
		.getElements("RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_YES");
	final static UI_Elements	RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_NO	= UIFactory
		.getElements("RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_NO");

	public void removePurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String addPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException;

	public boolean clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnEnforcePTBasedValidationOfGLAccountsYES(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEnforcePTBasedValidationOfGLAccountsYESNOSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowsplittingcosttomultiplecostcentersYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnEnforcePTBasedValidationOfGLAccountsNO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEnforcePTBasedValidationOfGLAccountYESEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEditingPurchaseTypeLineLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEditingPurchaseTypeLineLevel_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowProjectOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowProjectOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowMultipleCatagoryOwners_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowMultipleCatagoryOwners_No(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public boolean clickOnPreventSupplierNotEntendedToOrderingLocation_Yes(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public boolean clickOnPreventSupplierNotEntendedToOrderingLocation_No(WebDriver driver, String testCaseName) throws ActionBotException;

}
