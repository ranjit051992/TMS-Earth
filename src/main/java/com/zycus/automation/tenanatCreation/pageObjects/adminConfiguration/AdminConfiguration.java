package com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface AdminConfiguration
{

	public static UI_Elements	HEADER_TAB_SETTING										= UIFactory.getElements("HEADER_TAB_SETTING");
	public static UI_Elements	DROPDOWN_CONFIGURATIONS									= UIFactory.getElements("DROPDOWN_CONFIGURATIONS");
	public static UI_Elements	DROPDOWN_TENANT_NAME									= UIFactory.getElements("DROPDOWN_TENANT_NAME");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_ADMIN_EMAIL						= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_ADMIN_EMAIL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_ADMIN_USER						= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_ADMIN_USER");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_INVOICE_ADMIN_USER				= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_INVOICE_ADMIN_USER");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_API_EMAIL							= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_API_EMAIL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_INVOICE_EVENT_URL					= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_INVOICE_EVENT_URL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_ISOURCE_EVENT_URL					= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_ISOURCE_EVENT_URL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_BASE_URL							= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_BASE_URL");
	public static UI_Elements	RADIOBUTTON_REGIONS_FOR_SCOPING_YES						= UIFactory.getElements("RADIOBUTTON_REGIONS_FOR_SCOPING_YES");
	public static UI_Elements	RADIOBUTTON_REGIONS_FOR_SCOPING_NO						= UIFactory.getElements("RADIOBUTTON_REGIONS_FOR_SCOPING_NO");
	public static UI_Elements	RADIOBUTTON_INVOICE_INTRGATED_YES						= UIFactory.getElements("RADIOBUTTON_INVOICE_INTRGATED_YES");
	public static UI_Elements	RADIOBUTTON_INVOICE_INTRGATED_NO						= UIFactory.getElements("RADIOBUTTON_INVOICE_INTRGATED_NO");
	public static UI_Elements	RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_YES				= UIFactory.getElements("RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_YES");
	public static UI_Elements	RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_NO				= UIFactory.getElements("RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_NO");
	public static UI_Elements	RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_YES				= UIFactory.getElements("RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_YES");
	public static UI_Elements	RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_NO				= UIFactory.getElements("RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_NO");
	public static UI_Elements	TEXTBOX_ANALYTICS_CRMS_INTEGRATION_URL					= UIFactory.getElements("TEXTBOX_ANALYTICS_CRMS_INTEGRATION_URL");
	public static UI_Elements	TEXTBOX_ATTEMPT_RETRIGGER_IN_MINS						= UIFactory.getElements("TEXTBOX_ATTEMPT_RETRIGGER_IN_MINS");
	public static UI_Elements	TEXTBOX_MAXIMUN_NO_OF_ATTEMPTS							= UIFactory.getElements("TEXTBOX_MAXIMUN_NO_OF_ATTEMPTS");
	public static UI_Elements	DROPDOWN_DIPLAYNAME_OF_PREDEFINED_FIELDS				= UIFactory.getElements("DROPDOWN_DIPLAYNAME_OF_PREDEFINED_FIELDS");
	public static UI_Elements	BUTTON_UPDATE											= UIFactory.getElements("BUTTON_UPDATE");
	public static UI_Elements	BUTTON_ADD_INTEGRATION									= UIFactory.getElements("BUTTON_ADD_INTEGRATION");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_AUTOCLASS_URL						= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_AUTOCLASS_URL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_AUTOCLASS_SCHEMA					= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_AUTOCLASS_SCHEMA");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_AUTOCLASS_PROJECT					= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_AUTOCLASS_PROJECT");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL					= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL_VERSION			= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL_VERSION");
	public static UI_Elements	RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_NO	= UIFactory.getElements("RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_NO");
	public static UI_Elements	RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_YES	= UIFactory.getElements("RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_YES");

	public static UI_Elements	DROPDOWN_ENTITY											= UIFactory.getElements("DROPDOWN_ENTITY");
	public static UI_Elements	TEXTBOX_TO_SYSTEM										= UIFactory.getElements("TEXTBOX_TO_SYSTEM");
	public static UI_Elements	TEXTBOX_TO_URL											= UIFactory.getElements("TEXTBOX_TO_URL");

	public static UI_Elements	TEXTBOX_TMS_PRODUCTS_NAME								= UIFactory.getElements("TEXTBOX_TMS_PRODUCTS_NAME");
	public static UI_Elements	TEXTBOX_SMTP_PRODUCTS_HOST								= UIFactory.getElements("TEXTBOX_SMTP_PRODUCTS_HOST");
	public static UI_Elements	TEXTBOX_DEFAULT_EMAIL_SENDER							= UIFactory.getElements("TEXTBOX_DEFAULT_EMAIL_SENDER");
	public static UI_Elements	TEXTBOX_API_EMAIL_ID									= UIFactory.getElements("TEXTBOX_API_EMAIL_ID");
	public static UI_Elements	TEXTBOX_FILE_SERVER_URL									= UIFactory.getElements("TEXTBOX_FILE_SERVER_URL");
	public static UI_Elements	TEXTBOX_ZSN_INTEGRATION_URL								= UIFactory.getElements("TEXTBOX_ZSN_INTEGRATION_URL");
	public static UI_Elements	RADIOBUTTON_CATALOG_ENABLE_SEARCH_YES					= UIFactory.getElements("RADIOBUTTON_CATALOG_ENABLE_SEARCH_YES");
	public static UI_Elements	RADIOBUTTON_CATALOG_ENABLE_SEARCH_NO					= UIFactory.getElements("RADIOBUTTON_CATALOG_ENABLE_SEARCH_NO");
	public static UI_Elements	RADIOBUTTON_USAGE_TRACKING_YES							= UIFactory.getElements("RADIOBUTTON_USAGE_TRACKING_YES");
	public static UI_Elements	RADIOBUTTON_USAGE_TRACKING_NO							= UIFactory.getElements("RADIOBUTTON_USAGE_TRACKING_NO");
	public static UI_Elements	TEXTBOX_CMD_PRODUCTS_URL								= UIFactory.getElements("TEXTBOX_CMD_PRODUCTS_URL");
	public static UI_Elements	SELECT_FILE_UPLOAD										= UIFactory.getElements("SELECT_FILE_UPLOAD");
	public static UI_Elements	BUTTON_UPLOAD_FILE										= UIFactory.getElements("BUTTON_UPLOAD_FILE");
	public static UI_Elements	BUTTON_UPDATE_EINVOICE									= UIFactory.getElements("BUTTON_UPDATE_EINVOICE");

	public static final String	xpath1_checkbox_add_language							= ".//*[@id='locale_dev_locale']//label[contains(text(),'";
	public static final String	xpath2_checkbox_add_language							= "')]/input";

	public static UI_Elements	TEXTBOX_SIM_CLIENT_ID									= UIFactory.getElements("TEXTBOX_SIM_CLIENT_ID");
	public static UI_Elements	TEXTBOX_SIM_URL											= UIFactory.getElements("TEXTBOX_SIM_URL");
	public static UI_Elements	TEXTBOX_SYSTEM_TENANT_SIM_SUPPLIER_ADD_URL				= UIFactory.getElements("TEXTBOX_SYSTEM_TENANT_SIM_SUPPLIER_ADD_URL");
	public static UI_Elements	LINK_SELECT_LANGUAGE_FOR_TRANSLATION					= UIFactory.getElements("LINK_SELECT_LANGUAGE_FOR_TRANSLATION");
	public static UI_Elements	RADIOBUTTON_BU_IN_GL_YES								= UIFactory.getElements("RADIOBUTTON_BU_IN_GL_YES");
	public static UI_Elements	RADIOBUTTON_BU_IN_GL_NO									= UIFactory.getElements("RADIOBUTTON_BU_IN_GL_NO");
	public static UI_Elements	RADIOBUTTON_DEPT_TO_OU_YES								= UIFactory.getElements("RADIOBUTTON_DEPT_TO_OU_YES");
	public static UI_Elements	RADIOBUTTON_DEPT_TO_OU_NO								= UIFactory.getElements("RADIOBUTTON_DEPT_TO_OU_NO");
	public static UI_Elements	RADIOBUTTON_MATCH_PT_WITH_UNICODE_YES					= UIFactory.getElements("RADIOBUTTON_MATCH_PT_WITH_UNICODE_YES");
	public static UI_Elements	RADIOBUTTON_MATCH_PT_WITH_UNICODE_NO					= UIFactory.getElements("RADIOBUTTON_MATCH_PT_WITH_UNICODE_NO");
	public static UI_Elements	BUTTON_SAVE_LANGUAGE									= UIFactory.getElements("BUTTON_SAVE_LANGUAGE");
	public static UI_Elements	BUTTON_CONFIRMATION_YES									= UIFactory.getElements("BUTTON_CONFIRMATION_YES");

	public void selectAllowSupplierForAdditionOfStockItem_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllowSupplierForAdditionOfStockItem_NO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public void goToSystemLevelTenantConfigurationPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillSystemTenantAdminUser(WebDriver driver, String testCaseName, String adminUser) throws ActionBotException;

	public void fillSystemTenantAdminUserEmailId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException;

	public void fillSystemTenantInvoiceAdminUser(WebDriver driver, String testCaseName, String user) throws ActionBotException;

	public void fillSystemTenantAPIEmail(WebDriver driver, String testCaseName, String apiUrl) throws ActionBotException;

	public void fillSystemTenantInvoiceEventUrl(WebDriver driver, String testCaseName, String eInvoiceEventUrl) throws ActionBotException;

	public void fillSystemTenantISourceEventUrl(WebDriver driver, String testCaseName, String iSourceEventUrl) throws ActionBotException;

	public void fillSystemTenantBaseUrl(WebDriver driver, String testCaseName, String baseUrl) throws ActionBotException;

	public void selectRegionForScoping_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectRegionForScoping_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectInvoiceIntegrated_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectInvoiceIntegrated_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAnalyticsCRMSIntegration_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAnalyticsCRMSIntegration_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillSystemTenantAutoClassUrl(WebDriver driver, String testCaseName, String autoClassUrl) throws ActionBotException;

	public void fillSystemTenantAutoClassSchema(WebDriver driver, String testCaseName, String autoClassSchema) throws ActionBotException;

	public void fillSystemTenantProject(WebDriver driver, String testCaseName, String project) throws ActionBotException;

	public void fillSystemTenantAutoClassModel(WebDriver driver, String testCaseName, String autoClassModel) throws ActionBotException;

	public void fillSystemTenantAutoclassModelVersion(WebDriver driver, String testCaseName, String autoClassVersion) throws ActionBotException;

	public void selectRetriggerFailedDocument_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectRetriggerFailedDocument_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillAnalyticsCRMSIntegrationUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public void fillAttempRetriggerUrlInMins(WebDriver driver, String testCaseName, int mins) throws ActionBotException;

	public void fillMaximumNoOfAttempts(WebDriver driver, String testCaseName, int attempts) throws ActionBotException;

	public void selectPreDefinedFields(WebDriver driver, String testCaseName, String predefinedFields) throws ActionBotException;

	public void clickButtonUpdate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void addIntegation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectEntity(WebDriver driver, String testCaseName, String entity, int index) throws ActionBotException;

	public void fillToSystem(WebDriver driver, String testCaseName, String toSystem, int index) throws ActionBotException;

	public void fillToUrl(WebDriver driver, String testCaseName, String toUrl, int index) throws ActionBotException;

	public void fillTmsProductName(WebDriver driver, String testCaseName, String tmsProductName) throws ActionBotException;

	public void fillSmtpHost(WebDriver driver, String testCaseName, String smtpHost) throws ActionBotException;

	public void fillDefaultEmailSender(WebDriver driver, String testCaseName, String defaultEmailSender) throws ActionBotException;

	public void fillApiEmailId(WebDriver driver, String testCaseName, String apiEmaidId) throws ActionBotException;

	public void fillFileServerUrl(WebDriver driver, String testCaseName, String fileServerUrl) throws ActionBotException;

	public void fillZsnIntegrationUrl(WebDriver driver, String testCaseName, String zsnIntegrationUrl) throws ActionBotException;

	public void selectCatalogEnableSearch_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectCatalogEnableSearch_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectUsageTracking_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectUsageTracking_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillCmdProductUrl(WebDriver driver, String testCaseName, String cmdProductUrl) throws ActionBotException;

	public void UploadFileForExchangeRates(WebDriver driver, String testCaseName, String filePath) throws ActionBotException;

	public void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterSimClientId(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterSimUrl(WebDriver driver, String testCaseName, String simUrl) throws ActionBotException;

	public void enterSimSupplierAddUrl(WebDriver driver, String testCaseName, String simSupplierAddUrl) throws ActionBotException;

	public void selectBUInGL_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectBUInGL_NO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectDeptToOU_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectDeptToOU_NO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void matchPTWithUnicode_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void matchPTWithUnicode_NO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectLanguageForTranslation(WebDriver driver, String testCaseName, String language) throws ActionBotException;

	public void clickOnLinkSelectLanguageForTranslation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveLanguagesForTransaltion(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateEinvoice(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public void clickOnConfirmation_Yes(WebDriver driver, String testCaseName) throws ActionBotException;
}
