package com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface TmsCompanyCreationPage
{

	public static UI_Elements	CREATE_NEW_COMPANY_BUTTON						= UIFactory.getElements("CREATE_NEW_COMPANY_BUTTON");
	public static UI_Elements	DROPDOWN_SEARCH_BY								= UIFactory.getElements("DROPDOWN_SEARCH_BY");
	public static UI_Elements	TEXTBOX_COMPANY_NAME							= UIFactory.getElements("TEXTBOX_COMPANY_NAME");
	public static UI_Elements	CHECKBOX_IS_SAAS_COMPANY						= UIFactory.getElements("CHECKBOX_IS_SAAS_COMPANY");
	public static UI_Elements	CHECKBOX_IS_DELEGATED_COMPANY					= UIFactory.getElements("CHECKBOX_IS_DELEGATED_COMPANY");
	public static UI_Elements	TEXTBOX_BRIDGE_URL								= UIFactory.getElements("TEXTBOX_BRIDGE_URL");
	public static UI_Elements	TEXTBOX_DOMAIN_URL								= UIFactory.getElements("TEXTBOX_DOMAIN_URL");
	public static UI_Elements	CHECKBOX_LOGIN_THROUGH_UNIQUE_ID				= UIFactory.getElements("CHECKBOX_LOGIN_THROUGH_UNIQUE_ID");
	public static UI_Elements	CHECKBOX_ENABLE_SCOPE							= UIFactory.getElements("CHECKBOX_ENABLE_SCOPE");
	public static UI_Elements	TEXTBOX_LOCATION_NAME							= UIFactory.getElements("TEXTBOX_LOCATION_NAME");
	public static UI_Elements	TEXTBOX_ADDRESS1								= UIFactory.getElements("TEXTBOX_ADDRESS1");
	public static UI_Elements	TEXTBOX_ADDRESS2								= UIFactory.getElements("TEXTBOX_ADDRESS2");
	public static UI_Elements	TEXTBOX_CITY									= UIFactory.getElements("TEXTBOX_CITY");
	public static UI_Elements	TEXTBOX_STATE									= UIFactory.getElements("TEXTBOX_STATE");
	public static UI_Elements	TEXTBOX_ZIP_CODE								= UIFactory.getElements("TEXTBOX_ZIP_CODE");
	public static UI_Elements	DROPDOWN_COUNTRY								= UIFactory.getElements("DROPDOWN_COUNTRY");
	public static UI_Elements	BUTTON_CONTINUE									= UIFactory.getElements("BUTTON_CONTINUE");
	public static UI_Elements	CHECKBOX_COMPONENT_RAINBOW						= UIFactory.getElements("CHECKBOX_COMPONENT_RAINBOW");
	public static UI_Elements	CHECKBOX_COMPONENT_CRMS							= UIFactory.getElements("CHECKBOX_COMPONENT_CRMS");
	public static UI_Elements	CHECKBOX_COMPONENT_ONEVIEW						= UIFactory.getElements("CHECKBOX_COMPONENT_ONEVIEW");
	public static UI_Elements	TEXTBOX_PRODUCT_CIVIL_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_CIVIL_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_CRMS_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_CRMS_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_CENTRAL_RMS_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_CENTRAL_RMS_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_DASHBOARD_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_DASHBOARD_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_FIELD_LIBRARY_URL				= UIFactory.getElements("TEXTBOX_PRODUCT_FIELD_LIBRARY_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_FLEXIFORM_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_FLEXIFORM_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_MAS_URL							= UIFactory.getElements("TEXTBOX_PRODUCT_MAS_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_NOTIFICATION_URL				= UIFactory.getElements("TEXTBOX_PRODUCT_NOTIFICATION_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_ONE_VIEW_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_ONE_VIEW_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_SIM_URL							= UIFactory.getElements("TEXTBOX_PRODUCT_SIM_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_SPM_URL							= UIFactory.getElements("TEXTBOX_PRODUCT_SPM_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_SUPPLIER_PORTAL_URL				= UIFactory.getElements("TEXTBOX_PRODUCT_SUPPLIER_PORTAL_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_TMS_URL							= UIFactory.getElements("TEXTBOX_PRODUCT_TMS_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_WORKFLOW_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_WORKFLOW_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_EINVOICE_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_EINVOICE_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_EPROC_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_EPROC_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_IANALYZE_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_IANALYZE_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_ICONTRACT_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_ICONTRACT_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_ICOST_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_ICOST_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_IMANAGE_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_IMANAGE_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_IREQUEST_URL					= UIFactory.getElements("TEXTBOX_PRODUCT_IREQUEST_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_ISAVE_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_ISAVE_URL");
	public static UI_Elements	TEXTBOX_PRODUCT_ISOURCE_URL						= UIFactory.getElements("TEXTBOX_PRODUCT_ISOURCE_URL");
	public static UI_Elements	BUTTON_PRODUCT_ALLOCATION_PAGE_CONTINUE			= UIFactory.getElements("BUTTON_PRODUCT_ALLOCATION_PAGE_CONTINUE");
	public static UI_Elements	TEXTBOX_COMPANY_ADMIN_FIRST_NAME				= UIFactory.getElements("TEXTBOX_COMPANY_ADMIN_FIRST_NAME");
	public static UI_Elements	TEXTBOX_COMPANY_ADMIN_LAST_NAME					= UIFactory.getElements("TEXTBOX_COMPANY_ADMIN_LAST_NAME");
	public static UI_Elements	TEXTBOX_COMPANY_ADMIN_DISPLAY_NAME				= UIFactory.getElements("TEXTBOX_COMPANY_ADMIN_DISPLAY_NAME");
	public static UI_Elements	TEXTBOX_COMPANY_ADMIN_EMAIL_ID					= UIFactory.getElements("TEXTBOX_COMPANY_ADMIN_EMAIL_ID");
	public static UI_Elements	DROPDOWN_UNIQUE_KEY_TYPE						= UIFactory.getElements("DROPDOWN_UNIQUE_KEY_TYPE");
	public static UI_Elements	TEXTBOX_UNIQUE_KEY_VALUE						= UIFactory.getElements("TEXTBOX_UNIQUE_KEY_VALUE");
	public static UI_Elements	BUTTON_UNIQUE_KEY_ADD							= UIFactory.getElements("BUTTON_UNIQUE_KEY_ADD");
	public static UI_Elements	BUTTON_COMPANYADMIN_PAGE_SAVE					= UIFactory.getElements("BUTTON_COMPANYADMIN_PAGE_SAVE");
	public static UI_Elements	TEXTBOX_TIMEZONE								= UIFactory.getElements("TEXTBOX_TIMEZONE");
	public static UI_Elements	DROPDOWN_NUMBERFORMAT							= UIFactory.getElements("DROPDOWN_NUMBERFORMAT");
	public static UI_Elements	DROPDOWN_DATEFORMAT								= UIFactory.getElements("DROPDOWN_DATEFORMAT");
	public static UI_Elements	DROPDOWN_TIMEFORMAT								= UIFactory.getElements("DROPDOWN_TIMEFORMAT");
	public static UI_Elements	DROPDOWN_CURRENCY								= UIFactory.getElements("DROPDOWN_CURRENCY");
	public static UI_Elements	DROPDOWN_LOCALE									= UIFactory.getElements("DROPDOWN_LOCALE");
	public static UI_Elements	TEXTBOX_SMTP_SERVERID							= UIFactory.getElements("TEXTBOX_SMTP_SERVERID");
	public static UI_Elements	TEXTBOX_PORTNUMBER								= UIFactory.getElements("TEXTBOX_PORTNUMBER");
	public static UI_Elements	DROPDOWN_DECIMAL_PRECISION						= UIFactory.getElements("DROPDOWN_DECIMAL_PRECISION");
	public static UI_Elements	BUTTON_PREFERNCE_PAGE_CONTINUE					= UIFactory.getElements("BUTTON_PREFERNCE_PAGE_CONTINUE");
	public static UI_Elements	BUTTON_DEFINE_COMPANY							= UIFactory.getElements("BUTTON_DEFINE_COMPANY");
	public static UI_Elements	BUTTON_OK										= UIFactory.getElements("BUTTON_OK");
	public static UI_Elements	TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE		= UIFactory.getElements("TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE");
	public static UI_Elements	EDIT_COMPANY_ICON								= UIFactory.getElements("EDIT_COMPANY_ICON");
	public static UI_Elements	MANAGE_USERS_AND_ROLES_COMPANY_ICON				= UIFactory.getElements("MANAGE_USERS_AND_ROLES_COMPANY_ICON");
	public static UI_Elements	LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE	= UIFactory.getElements("LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE");
	public static UI_Elements	TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE		= UIFactory.getElements("TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE");
	public static UI_Elements	LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE		= UIFactory.getElements("LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE");
	public static UI_Elements	TAB_MASTER_DATA									= UIFactory.getElements("TAB_MASTER_DATA");

	public static UI_Elements	TEXTBOX_KEY_REGISTRY							= UIFactory.getElements("TEXTBOX_KEY_REGISTRY");
	public static UI_Elements	TEXTBOX_VALUE_REGISTRY							= UIFactory.getElements("TEXTBOX_VALUE_REGISTRY");
	public static UI_Elements	BUTTON_ADD_REGISTRY								= UIFactory.getElements("BUTTON_ADD_REGISTRY");
	public static UI_Elements	LINK_BACK_TO_SUMMARY_PAGE						= UIFactory.getElements("LINK_BACK_TO_SUMMARY_PAGE");
	public static UI_Elements	BUTTON_UPDATE_USER								= UIFactory.getElements("BUTTON_UPDATE_USER");

	public static String		xpath1_Activate_Button_productUrl				= ".//*[contains(@id,'url_') and @name='";
	public static String		xpath2_Activate_Button_productUrl				= "_Url']/../../..//a[@class='deactivateIcon']";
	public static String		xpath1_Registry_URL_productwise					= ".//a[contains(@href,'";
	public static String		xpath2_Registry_URL_productwise					= "') and contains(@class,'scLnk')]";
	public static String		xpath_no_of_companies							= ".//*[@id='company-grid']/tbody/tr/td[1]";

	public void clickOnCreateNewCompanyButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public boolean selectCheckBoxSaasCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean selectCheckBoxdelegateCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBridgeURL(WebDriver driver, String testCaseName, String bridgeUrl) throws ActionBotException;

	public String fillDomailURL(WebDriver driver, String testCaseName, String domailUrl) throws ActionBotException;

	public boolean selectCheckBoxLoginThroughUniqueId(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean selectCheckBoxEnableScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillLocationName(WebDriver driver, String testCaseName, String locationName) throws ActionBotException;

	public String fillAddress1(WebDriver driver, String testCaseName, String address1) throws ActionBotException;

	public String fillAddress2(WebDriver driver, String testCaseName, String address2) throws ActionBotException;

	public String fillCity(WebDriver driver, String testCaseName, String city) throws ActionBotException;

	public String fillState(WebDriver driver, String testCaseName, String state) throws ActionBotException;

	public String fillZipCode(WebDriver driver, String testCaseName, int zipCode) throws ActionBotException;

	public String fillCountry(WebDriver driver, String testCaseName, String country) throws ActionBotException;

	public void selectComponentRainbow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectComponentCRMS(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectComponentOneView(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillProductUrlCivil(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlCRMS(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlCentralRms(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlDashBoard(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlFieldLibrary(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlFlexiForm(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlMAS(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlNotification(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlOneView(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlSIM(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlSPM(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlSupplierPortal(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlTMS(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlWorkFlow(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlEInvoice(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlEPROC(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlIAnalyze(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlIContract(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlICost(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlIManage(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlISave(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlIRequest(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillProductUrlISource(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public String fillAdminFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException;

	public String fillAdminLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException;

	public String fillAdminDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException;

	public String fillAdminEmaidId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException;

	public String selectUniqueKeyType(WebDriver driver, String testCaseName, String uniqueKeyType) throws ActionBotException;

	public String fillUniqueKeyValue(WebDriver driver, String testCaseName, String uniqueKeyValue) throws ActionBotException;

	public void clickOnAddUniqueKeyButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTimeZone(WebDriver driver, String testCaseName, String timeZone) throws ActionBotException;

	public void selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException;

	public void selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException;

	public String selectTimeFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException;

	public void selectCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public void selectLocale(WebDriver driver, String testCaseName, String locale) throws ActionBotException;

	public String fillSMTPServerId(WebDriver driver, String testCaseName, String smtpServerId) throws ActionBotException;

	public String fillPortNumber(WebDriver driver, String testCaseName, String portNumber) throws ActionBotException;

	public String fillDecimalPrecision(WebDriver driver, String testCaseName, String decimalPrecision) throws ActionBotException;

	public void clickOnContinueCompanyFormPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueProductAllocationPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueOnCompanyAdminPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueOnCompanyPreferencePage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDefineCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String searchCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public void addRegistryKeyValue(WebDriver driver, String testCaseName, Map<String, String> keyValue) throws ActionBotException;

	public void clickOnBackToSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSearchBy(WebDriver driver, String testCaseName, String searchBy) throws ActionBotException;

	public void clickOnOk(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnHeaderMasterTab(WebDriver driver, String testCaseName) throws ActionBotException;
}
