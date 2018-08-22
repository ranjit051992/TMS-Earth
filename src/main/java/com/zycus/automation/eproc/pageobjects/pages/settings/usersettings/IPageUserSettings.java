/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.usersettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageUserSettings
{
	final static UI_Elements	USER_EMAIL_ID				= UIFactory.getElements("USER_EMAIL_ID");
	final static UI_Elements	USER_FIRST_NAME				= UIFactory.getElements("USER_FIRST_NAME");
	final static UI_Elements	USER_DISPLAY_NAME			= UIFactory.getElements("USER_DISPLAY_NAME");
	final static UI_Elements	SELECT_DEPARTMENT			= UIFactory.getElements("SELECT_DEPARTMENT");
	final static UI_Elements	SELECT_COMPANY				= UIFactory.getElements("SELECT_COMPANY");
	final static UI_Elements	SELECT_LOCATION				= UIFactory.getElements("SELECT_LOCATION");
	final static UI_Elements	PRUCHASING_SCOPE			= UIFactory.getElements("PRUCHASING_SCOPE");
	final static UI_Elements	SELECT_DELIVERY_SCOPE		= UIFactory.getElements("SELECT_DELIVERY_SCOPE");
	final static UI_Elements	PURCHASING_LIMIT			= UIFactory.getElements("PURCHASING_LIMIT");
	final static UI_Elements	SELECT_LOCALE				= UIFactory.getElements("SELECT_LOCALE");
	final static UI_Elements	SELECT_TIMEZONE				= UIFactory.getElements("SELECT_TIMEZONE");
	final static UI_Elements	SELECT_NUMBER_FORMAT		= UIFactory.getElements("SELECT_NUMBER_FORMAT");
	final static UI_Elements	CONTROL_CURRENCY			= UIFactory.getElements("CONTROL_CURRENCY");
	final static UI_Elements	SALUTATION					= UIFactory.getElements("SALUTATION");
	final static UI_Elements	USER_LAST_NAME				= UIFactory.getElements("USER_LAST_NAME");
	final static UI_Elements	REPORTING_MANAGER			= UIFactory.getElements("REPORTING_MANAGER");
	final static UI_Elements	SELECT_DESIGNATION			= UIFactory.getElements("SELECT_DESIGNATION");
	final static UI_Elements	SELECT_BUSINESS_UNIT		= UIFactory.getElements("SELECT_BUSINESS_UNIT");
	final static UI_Elements	SELECT_COST_CENTER			= UIFactory.getElements("SELECT_COST_CENTER");
	final static UI_Elements	SELECT_BEHALF_SCOPE			= UIFactory.getElements("SELECT_BEHALF_SCOPE");
	final static UI_Elements	APPROVAL_LIMIT				= UIFactory.getElements("APPROVAL_LIMIT");
	final static UI_Elements	USER_CURRENCY				= UIFactory.getElements("USER_CURRENCY");
	final static UI_Elements	SELECT_DATE_FORMAT			= UIFactory.getElements("SELECT_DATE_FORMAT");
	final static UI_Elements	SELECT_DECIMAL_PLACE		= UIFactory.getElements("SELECT_DECIMAL_PLACE");
	final static UI_Elements	UPDATE_USER_BUTTON			= UIFactory.getElements("UPDATE_USER_BUTTON");
	final static UI_Elements	CANCEL_BUTTON_USER			= UIFactory.getElements("CANCEL_BUTTON_USER");
	final static UI_Elements	PROGRESS_STATUS				= UIFactory.getElements("PROGRESS_STATUS");
	final static UI_Elements	CLOSE_WIZARD_BUTTON			= UIFactory.getElements("CLOSE_WIZARD_BUTTON");
	static UI_Elements			TEXTBOX_REQUESTING_SCOPE	= UIFactory.getElements("TEXTBOX_REQUESTING_SCOPE");
	static UI_Elements			TEXTBOX_ADMIN_SCOPE			= UIFactory.getElements("TEXTBOX_ADMIN_SCOPE");

	public String getUserEmailId(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillUserFirstName(WebDriver driver, String testCaseName, String userFirstName) throws ActionBotException;

	public String getUserFirstName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillUserDisplayName(WebDriver driver, String testCaseName, String userDisplayName) throws ActionBotException;

	public String getUserDisplayName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDepartment(WebDriver driver, String testCaseName, String departmentName) throws ActionBotException;

	public String getSelectedDepartment(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public String getSelectedCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectLoaction(WebDriver driver, String testCaseName, String loactionName) throws ActionBotException;

	public String getSelectedLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectPurchasingScope(WebDriver driver, String testCaseName, String purchasingScopeName) throws ActionBotException;

	public String getSelectedPurchasingScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDeliveryScope(WebDriver driver, String testCaseName, String deliveryScopeName) throws ActionBotException;

	public String getSelectedDeliveryScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public Float fillPurhcasingLimit(WebDriver driver, String testCaseName, Float purchasingLimit) throws ActionBotException;

	public Float getPurhcasingLimit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectLocale(WebDriver driver, String testCaseName, String localeName) throws ActionBotException;

	public String getSelectedLocale(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectTimezone(WebDriver driver, String testCaseName, String timezone) throws ActionBotException;

	public String getSelectedTimezone(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException;

	public String getSelectedNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectContolCurrency(WebDriver driver, String testCaseName, String contolCurrency) throws ActionBotException;

	public String getSelectedContolCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectSalutation(WebDriver driver, String testCaseName, String salutation) throws ActionBotException;

	public String getSelectedSalutation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillUserLastName(WebDriver driver, String testCaseName, String userLastName) throws ActionBotException;

	public String getUserLastName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillReportingManager(WebDriver driver, String testCaseName, String reportingManager) throws ActionBotException;

	public String getReportingManager(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDesignation(WebDriver driver, String testCaseName, String designation) throws ActionBotException;

	public String getSelectedDesignation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectBusinessUnit(WebDriver driver, String testCaseName, String businessUnitName) throws ActionBotException;

	public String getSelectedBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCostCenter(WebDriver driver, String testCaseName, String costCenterName) throws ActionBotException;

	public String getSelectedCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectBeHalfScope(WebDriver driver, String testCaseName, String beHalfScopeName) throws ActionBotException;

	public String getSelectedBeHalfScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillApprovalLimit(WebDriver driver, String testCaseName, int approvalLimit) throws ActionBotException;

	public Integer getApprovalLimit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectUserCurrency(WebDriver driver, String testCaseName, String userCurrency) throws ActionBotException;

	public String getSelectedUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException;

	public String getSelectedDateFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDecimalPlace(WebDriver driver, String testCaseName, String decimalPlace) throws ActionBotException;

	public String getSelectedDecimalPlace(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateUserButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseWizardButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequestingScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAdminScope(WebDriver driver, String testCaseName) throws ActionBotException;

}
