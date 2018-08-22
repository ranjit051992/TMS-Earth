package com.zycus.automation.tenanatCreation.pageObjects.simConfiguration;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface SimConfigurations
{

	public static UI_Elements	HEADER_TAB_SETTING						= UIFactory.getElements("HEADER_TAB_SETTING");
	public static UI_Elements	TAB_MANAGE_ROLES						= UIFactory.getElements("TAB_MANAGE_ROLES");
	public static UI_Elements	HEADER_TAB_MANAGE_CLIENTS				= UIFactory.getElements("HEADER_TAB_MANAGE_CLIENTS");
	public static UI_Elements	LINK_EDIT_ROLE_MDM						= UIFactory.getElements("LINK_EDIT_ROLE_MDM");
	public static UI_Elements	TAB_VIEW_ACCESSES						= UIFactory.getElements("TAB_VIEW_ACCESSES");
	public static UI_Elements	HEADER_TAB_MASTERDATA_CONFIG			= UIFactory.getElements("HEADER_TAB_MASTERDATA_CONFIG");
	public static UI_Elements	HEADER_TAB_MANAGE_VIEWS					= UIFactory.getElements("HEADER_TAB_MANAGE_VIEWS");
	public static UI_Elements	BUTTON_SAVE_VIEW_ACCESSES_PAGE			= UIFactory.getElements("BUTTON_SAVE_VIEW_ACCESSES_PAGE");
	public static UI_Elements	BUTTON_CREATE_NEW_MASTER				= UIFactory.getElements("BUTTON_CREATE_NEW_MASTER");
	public static UI_Elements	TEXTBOX_TABLENAME						= UIFactory.getElements("TEXTBOX_TABLENAME");
	public static UI_Elements	TEXTBOX_DISPLAYNAME						= UIFactory.getElements("TEXTBOX_DISPLAYNAME");
	public static UI_Elements	TEXTBOX_COLUMNNAME						= UIFactory.getElements("TEXTBOX_COLUMNNAME");
	public static UI_Elements	TEXTBOX_DISPLAY_FIELD					= UIFactory.getElements("TEXTBOX_DISPLAY_FIELD");
	public static UI_Elements	DROPDOWN_FIELD_TYPE						= UIFactory.getElements("DROPDOWN_FIELD_TYPE");
	public static UI_Elements	TEXTBOX_FIELD_LENGTH					= UIFactory.getElements("TEXTBOX_FIELD_LENGTH");
	public static UI_Elements	CHECKBOX_IS_REQUIRED					= UIFactory.getElements("CHECKBOX_IS_REQUIRED");
	public static UI_Elements	DROPDOWN_CONTRAINT						= UIFactory.getElements("DROPDOWN_CONTRAINT");
	public static UI_Elements	BUTTON_ADD_NEW_FIELD					= UIFactory.getElements("BUTTON_ADD_NEW_FIELD");
	public static UI_Elements	BUTTON_DONE								= UIFactory.getElements("BUTTON_DONE");
	public static UI_Elements	BUTTON_CONFIGURE_NEW_CLIENT				= UIFactory.getElements("BUTTON_CONFIGURE_NEW_CLIENT");
	public static UI_Elements	DROPDOWN_CLIENT_NAME					= UIFactory.getElements("DROPDOWN_CLIENT_NAME");
	public static UI_Elements	TEXTBOX_CLIENT_IDENTIFIER				= UIFactory.getElements("TEXTBOX_CLIENT_IDENTIFIER");
	public static UI_Elements	TEXTBOX_CLIENT_DESCRIPTION				= UIFactory.getElements("TEXTBOX_CLIENT_DESCRIPTION");
	public static UI_Elements	BUTTON_SUBMIT_MANAGE_CLIENTS			= UIFactory.getElements("BUTTON_SUBMIT_MANAGE_CLIENTS");

	public static UI_Elements	BUTTON_BROWSE							= UIFactory.getElements("BUTTON_BROWSE");
	public static UI_Elements	BUTTON_UPLOAD							= UIFactory.getElements("BUTTON_UPLOAD");
	public static UI_Elements	BUTTON_FINISH							= UIFactory.getElements("BUTTON_FINISH");

	public static UI_Elements	ACTION_FACILITY_MASTER					= UIFactory.getElements("ACTION_FACILITY_MASTER");
	public static UI_Elements	UPLOAD_ACTION_FACILITY_MASTER			= UIFactory.getElements("UPLOAD_ACTION_FACILITY_MASTER");
	public static UI_Elements	ACTION_SYSTEM_FACILITY_RELATION			= UIFactory.getElements("ACTION_SYSTEM_FACILITY_RELATION");
	public static UI_Elements	UPLOAD_ACTION_SYSTEM_FACILITY_MASTER	= UIFactory.getElements("UPLOAD_ACTION_SYSTEM_FACILITY_MASTER");
	public static UI_Elements	ACTION_SYSTEM_MASTER					= UIFactory.getElements("ACTION_SYSTEM_MASTER");
	public static UI_Elements	UPLOAD_ACTION_SYSTEM_MASTER				= UIFactory.getElements("UPLOAD_ACTION_SYSTEM_MASTER");
	public static UI_Elements	ACTION_INCO_TERMS						= UIFactory.getElements("ACTION_INCO_TERMS");
	public static UI_Elements	UPLOAD_ACTION_INCO_TERMS				= UIFactory.getElements("UPLOAD_ACTION_INCO_TERMS");
	public static UI_Elements	ACTION_LEGAL_STRUCTURE					= UIFactory.getElements("ACTION_LEGAL_STRUCTURE");
	public static UI_Elements	UPLOAD_ACTION_LEGAL_STRUCTURE			= UIFactory.getElements("UPLOAD_ACTION_LEGAL_STRUCTURE");
	public static UI_Elements	ACTION_PAYMENT_TERMS					= UIFactory.getElements("ACTION_PAYMENT_TERMS");
	public static UI_Elements	UPLOAD_ACTION_PAYMENT_TERMS				= UIFactory.getElements("UPLOAD_ACTION_PAYMENT_TERMS");
	public static UI_Elements	ACTION_PAYMENT_TYPE						= UIFactory.getElements("ACTION_PAYMENT_TYPE");
	public static UI_Elements	UPLOAD_ACTION_PAYMENT_TYPE				= UIFactory.getElements("UPLOAD_ACTION_PAYMENT_TYPE");
	public static UI_Elements	ACTION_PO_SUBMISSION					= UIFactory.getElements("ACTION_PO_SUBMISSION");
	public static UI_Elements	UPLOAD_ACTION_PO_SUBMISSION				= UIFactory.getElements("UPLOAD_ACTION_PO_SUBMISSION");
	public static UI_Elements	ACTION_SUPPLIER_TYPE					= UIFactory.getElements("ACTION_SUPPLIER_TYPE");
	public static UI_Elements	UPLOAD_ACTION_SUPPLIER_TYPE				= UIFactory.getElements("UPLOAD_ACTION_SUPPLIER_TYPE");
	public static UI_Elements	ACTION_TRANSACTION_COUNT				= UIFactory.getElements("ACTION_TRANSACTION_COUNT");
	public static UI_Elements	UPLOAD_ACTION_TRANSACTION_COUNT			= UIFactory.getElements("UPLOAD_ACTION_TRANSACTION_COUNT");
	public static UI_Elements	BUTTON_CANCEL_UPLOAD					= UIFactory.getElements("BUTTON_CANCEL_UPLOAD");

	//MANAGE VIEW TAB
	public static UI_Elements	LINK_EXPAND_VIEW_PURCHASING				= UIFactory.getElements("LINK_EXPAND_VIEW_PURCHASING");
	public static UI_Elements	MANAGE_FIELDS_PURCHASING_DETAILS		= UIFactory.getElements("MANAGE_FIELDS_PURCHASING_DETAILS");
	public static UI_Elements	MANAGE_FIELDS_PAYMENT_TERMS				= UIFactory.getElements("MANAGE_FIELDS_PAYMENT_TERMS");
	public static UI_Elements	MANAGE_FIELDS_GLOBAL_PAYMENT_TERMS		= UIFactory.getElements("MANAGE_FIELDS_GLOBAL_PAYMENT_TERMS");

	public static UI_Elements	LINK_EDIT_FIELD_CONTRACTED_SUPPLIER		= UIFactory.getElements("LINK_EDIT_FIELD_CONTRACTED_SUPPLIER");
	public static UI_Elements	TEXTBOX_DISPLAY_NAME					= UIFactory.getElements("TEXTBOX_DISPLAY_NAME");
	public static UI_Elements	TEXTBOX_FIELD_NAME						= UIFactory.getElements("TEXTBOX_FIELD_NAME");
	public static UI_Elements	RADIOBUTTON_MANDATORY_YES				= UIFactory.getElements("RADIOBUTTON_MANDATORY_YES");
	public static UI_Elements	RADIOBUTTON_MANDATORY_NO				= UIFactory.getElements("RADIOBUTTON_MANDATORY_NO");
	public static UI_Elements	RADIOBUTTON_VALUE_STATIC				= UIFactory.getElements("RADIOBUTTON_VALUE_STATIC");
	public static UI_Elements	TEXTBOX_VALUE_FORMAT					= UIFactory.getElements("TEXTBOX_VALUE_FORMAT");
	public static UI_Elements	BUTTON_SAVE_FIELD						= UIFactory.getElements("BUTTON_SAVE_FIELD");
	public static UI_Elements	LINK_EDIT_FIELD_PURCHASING_DETAILS		= UIFactory.getElements("LINK_EDIT_FIELD_PURCHASING_DETAILS");
	public static UI_Elements	LINK_EDIT_FIELD_PAYMENT_TERMS			= UIFactory.getElements("LINK_EDIT_FIELD_PAYMENT_TERMS");
	public static UI_Elements	DROPDOWN_FIELD_TYPE_MANAGE_VIEW			= UIFactory.getElements("DROPDOWN_FIELD_TYPE_MANAGE_VIEW");
	public static UI_Elements	BUTTON_CREATE_NEW_FIELD					= UIFactory.getElements("BUTTON_CREATE_NEW_FIELD");
	public static UI_Elements	TEXTBOX_MAXIMUN_COLUMN_LENGTH			= UIFactory.getElements("TEXTBOX_MAXIMUN_COLUMN_LENGTH");
	public static UI_Elements	RADIOBUTTON_CHARACTER_TYPE_TEXT			= UIFactory.getElements("RADIOBUTTON_CHARACTER_TYPE_TEXT");
	public static UI_Elements	LINK_BACK_TO_MANAGE_VIEWS				= UIFactory.getElements("LINK_BACK_TO_MANAGE_VIEWS");
	public static UI_Elements	DROPDOWN_MAIN_ROLE						= UIFactory.getElements("DROPDOWN_MAIN_ROLE");

	public static UI_Elements	BUTTON_CREATE_VIEW						= UIFactory.getElements("BUTTON_CREATE_VIEW");
	public static UI_Elements	TEXTBOX_VIEW_NAME						= UIFactory.getElements("TEXTBOX_VIEW_NAME");
	public static UI_Elements	RADIOBUTTON_SUB_VIEW					= UIFactory.getElements("RADIOBUTTON_SUB_VIEW");
	public static UI_Elements	TEXTBOX_VIEW_DISPLAY_NAME				= UIFactory.getElements("TEXTBOX_VIEW_DISPLAY_NAME");
	public static UI_Elements	TEXTBOX_VIEW_DISPLAY_RANK				= UIFactory.getElements("TEXTBOX_VIEW_DISPLAY_RANK");
	public static UI_Elements	RADIOBUTTON_VIEWLAYOUT_2_COLUMN			= UIFactory.getElements("RADIOBUTTON_VIEWLAYOUT_2_COLUMN");
	public static UI_Elements	DROPDOWN_PARENT_VIEW					= UIFactory.getElements("DROPDOWN_PARENT_VIEW");
	public static UI_Elements	DROPDOWN_VIEW_SCOPE						= UIFactory.getElements("DROPDOWN_VIEW_SCOPE");
	public static UI_Elements	BUTTON_SAVE_VIEW						= UIFactory.getElements("BUTTON_SAVE_VIEW");
	public static UI_Elements	RADIOBUTTON_ADD_TO_LIST_VIEW_NO			= UIFactory.getElements("RADIOBUTTON_ADD_TO_LIST_VIEW_NO");

	public static UI_Elements	RADIOBUTTON_VALUE_REFERENCE_MASTER		= UIFactory.getElements("RADIOBUTTON_VALUE_REFERENCE_MASTER");
	public static UI_Elements	DROPDOWN_REFRENCE_MASTER				= UIFactory.getElements("DROPDOWN_REFRENCE_MASTER");
	public static UI_Elements	DROPDOWN_DISPLAY_CODE					= UIFactory.getElements("DROPDOWN_DISPLAY_CODE");
	public static UI_Elements	DROPDOWN_DISPLAY_VALUE					= UIFactory.getElements("DROPDOWN_DISPLAY_VALUE");
	public static UI_Elements	DROPDOWN_SETTING_SIM					= UIFactory.getElements("DROPDOWN_SETTING_SIM");

	public static UI_Elements	EDI_DELIVERY_METHOD						= UIFactory.getElements("EDI_DELIVERY_METHOD");
	public static UI_Elements	EDI_COMMENT								= UIFactory.getElements("EDI_COMMENT");
	public static UI_Elements	SUPPLIER_INDICATOR						= UIFactory.getElements("SUPPLIER_INDICATOR");
	public static UI_Elements	EDI_OBJECT_MODE							= UIFactory.getElements("EDI_OBJECT_MODE");
	public static UI_Elements	EDI_PARTNER_ID							= UIFactory.getElements("EDI_PARTNER_ID");
	public static UI_Elements	EDI_GS_QUALIFIER						= UIFactory.getElements("EDI_GS_QUALIFIER");
	public static UI_Elements	JUSTIFICATION_STATEMENT					= UIFactory.getElements("JUSTIFICATION_STATEMENT");
	public static UI_Elements	EDI_GS_ADDRESS							= UIFactory.getElements("EDI_GS_ADDRESS");
	public static UI_Elements	GOODS_RECEIPTS_BASED_INVOICE			= UIFactory.getElements("GOODS_RECEIPTS_BASED_INVOICE");
	public static UI_Elements	COMPETITOR_FLAG							= UIFactory.getElements("COMPETITOR_FLAG");
	public static UI_Elements	USED_AT									= UIFactory.getElements("USED_AT");

	public static UI_Elements	DEACTIVATE_DIVERSITY					= UIFactory.getElements("DEACTIVATE_DIVERSITY");
	public static UI_Elements	DEACTIVATE_FINANCIAL					= UIFactory.getElements("DEACTIVATE_FINANCIAL");
	public static UI_Elements	DEACTIVATE_INSURANCE					= UIFactory.getElements("DEACTIVATE_INSURANCE");
	public static UI_Elements	BUTTON_ACTIVATE_AND_DEPLOY				= UIFactory.getElements("BUTTON_ACTIVATE_AND_DEPLOY");

	public static UI_Elements	HEADER_TAB_MANAGE_USERS					= UIFactory.getElements("HEADER_TAB_MANAGE_USERS");
	public static UI_Elements	SIDE_PANNEL_MANAGE_USERS				= UIFactory.getElements("SIDE_PANNEL_MANAGE_USERS");
	public static UI_Elements	LINK_EDIT_USER_DETAIL_MANAGE_USERS		= UIFactory.getElements("LINK_EDIT_USER_DETAIL");
	public static UI_Elements	BUTTON_SAVE_CHANGES_TO_PROFILE			= UIFactory.getElements("BUTTON_SAVE_CHANGES_TO_PROFILE");
	public static UI_Elements	BUTTON_ADD_FACILITY_USER_PROFILE		= UIFactory.getElements("BUTTON_ADD_FACILITY_USER_PROFILE");
	public static UI_Elements	BUTTON_SYNC_USERS						= UIFactory.getElements("BUTTON_SYNC_USERS");

	public static String		xpath1_viewAccesses_input				= "(.//*[@id='viewsListing']//td[contains(text(),'";
	public static String		xpath2_viewAccesses_input				= "')])[1]/..//input";
	public static String		xpath1_dropdown_MappingField			= ".//*[@name='selOracleField_";
	public static String		xpath2_dropdown_MappingField			= "']";

	public static String		xpath_dropdown_facilites_user_profile	= ".//*[@id='Plants']";

	public void selectMainRole(WebDriver driver, String testCaseName) throws ActionBotException;

	public void goToSettingTabInSim(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickonManageRoles(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditMDM(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Company(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Address(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_ProductAndServices(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_SpendInformation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Diversity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Financial(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Insurance(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCheckboxesForView_Purchasing(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSave_ViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMasterDataConfigHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateNewMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterTableName(WebDriver driver, String testCaseName, String tableName) throws ActionBotException;

	public void enterDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException;

	public void enterColumnName(WebDriver driver, String testCaseName, String columnName) throws ActionBotException;

	public void enterDisplayField(WebDriver driver, String testCaseName, String displayField) throws ActionBotException;

	public void selectFieldType(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException;

	public void enterFieldLength(WebDriver driver, String testCaseName, String fieldLength) throws ActionBotException;

	public void selectContraint(WebDriver driver, String testCaseName, String constraint) throws ActionBotException;

	public void selectIsRequired(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddNewField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDone(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectClient(WebDriver driver, String testCaseName, String clientName) throws ActionBotException;

	public void enterClientIdentifier(WebDriver driver, String testCaseName, String clientIdentifier) throws ActionBotException;

	public void enterClientDescription(WebDriver driver, String testCaseName, String clientDescription) throws ActionBotException;

	public void clickOnSubmit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnManageClientHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfigureNewClient(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterFileForUpload(WebDriver driver, String testCaseName, String fileName) throws ActionBotException;

	public void selectFieldsForFacilityMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForSystemFacilityRelation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForINCOTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForLegalStructure(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForPaymentType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForPoSubmission(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForSupplierType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldsForSystemMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFinish(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandViewPurchasing(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickManageFieldsPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickManageFieldsPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickManageFieldsGlobalPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditContractedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillDisplayName(WebDriver driver, String testCaseName, String displayValue) throws ActionBotException;

	public void fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public void selectMandatoryField_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectValueFormat_Static(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillValueFormat(WebDriver driver, String testCaseName, String valueFormat) throws ActionBotException;

	public void clickOnSaveField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFieldType_manageView(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException;

	public void clickOnCreateNewField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillMaximunColumnLength(WebDriver driver, String testCaseName, String length) throws ActionBotException;

	public void selectCharacterType_Text(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnManageViewsHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkBackToManageViews(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateViews(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectMandatoryField_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillViewName(WebDriver driver, String testCaseName, String viewName) throws ActionBotException;

	public void selectView_SubView(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectParentView(WebDriver driver, String testCaseName, String parentView) throws ActionBotException;

	public void selectAddToViewList_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectViewScope(WebDriver driver, String testCaseName, String scope) throws ActionBotException;

	public void fillDisplayName_View(WebDriver driver, String testCaseName, String displayName) throws ActionBotException;

	public void fillDisplayRank(WebDriver driver, String testCaseName, String displayRank) throws ActionBotException;

	public void selectViewLayout_2Columns(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveView(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectValue_ReferenceMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectReferenceMaster(WebDriver driver, String testCaseName, String refrenceMaster) throws ActionBotException;

	public void selectReferenceDisplayCode(WebDriver driver, String testCaseName, String displayCode) throws ActionBotException;

	public void selectReferenceDisplayValue(WebDriver driver, String testCaseName, String displayValue) throws ActionBotException;

	public void deactivateEdiDeliveryMethod(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiComment(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateSupplierIndicator(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiObjectMode(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiPartnerId(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiGsQualifier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateJustificationStatement(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiGsAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateEdiGoodsReceiptBasesInvoice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateCompetitorFlag(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateUsedAt(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateViewDiversity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateViewFinancial(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deactivateViewInsurance(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActivateAndDeploy(WebDriver driver, String testCaseName) throws ActionBotException;

	public void goToHeaderManageUserTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnManageUserSidePanel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditUserDetails_ManageUser(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllFacilities(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveChangeToProfile(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

}
