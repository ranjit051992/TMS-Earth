/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.usersettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageUserSettingsImpl implements IPageUserSettings
{

	Logger logger = Logger.getLogger(IPageUserSettingsImpl.class);

	@Override
	public String getUserEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String userEmailId = ActionBot.getTextWithInElement(driver, USER_EMAIL_ID);
		logger.info("User Email Id : " + userEmailId);
		// ScreenShot.screenshot(driver, testCaseName, "User Email Id");
		return userEmailId;

	}

	@Override
	public String fillUserFirstName(WebDriver driver, String testCaseName, String userFirstName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, USER_FIRST_NAME, userFirstName);
		// ScreenShot.screenshot(driver, testCaseName, "After filling user first
		// name");
		String firstName = ActionBot.findElement(driver, USER_FIRST_NAME).getAttribute("value");
		logger.info("User First Name : " + firstName);
		return firstName;
	}

	@Override
	public String getUserFirstName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "User first name");
		String firstName = ActionBot.findElement(driver, USER_FIRST_NAME).getAttribute("value");
		logger.info("User First Name : " + firstName);
		return firstName;
	}

	@Override
	public String fillUserDisplayName(WebDriver driver, String testCaseName, String userDisplayName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, USER_DISPLAY_NAME, userDisplayName);
		// ScreenShot.screenshot(driver, testCaseName, "After filling user
		// dispplay name");
		String displayName = ActionBot.findElement(driver, USER_DISPLAY_NAME).getAttribute("value");
		logger.info("User Display Name : " + displayName);
		return displayName;
	}

	@Override
	public String getUserDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "After filling user
		// dispplay name");
		String displayName = ActionBot.findElement(driver, USER_DISPLAY_NAME).getAttribute("value");
		logger.info("User Display Name : " + displayName);
		return displayName;
	}

	@Override
	public String selectDepartment(WebDriver driver, String testCaseName, String departmentName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DEPARTMENT));
		select.selectByValue(departmentName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// department");
		String selectedDepartmentName = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Department Name : " + selectedDepartmentName);

		return selectedDepartmentName;
	}

	@Override
	public String getSelectedDepartment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement dept = ActionBot.findElement(driver, SELECT_DEPARTMENT);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String selectedDepartmentName = (String) jse.executeScript("return userInfoData.departmentName", dept);

		logger.info("Selected Department Name : " + selectedDepartmentName);
		return selectedDepartmentName;
	}

	@Override
	public String selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		/*
		 * WebElement element = ActionBot.findElement(driver, SELECT_COMPANY);
		 * element.sendKeys(companyName); ActionBot.defaultSleep();
		 * element.sendKeys(Keys.ARROW_DOWN); element.sendKeys(Keys.ENTER);
		 */
		String selectedCompanyName = ActionBot.fillAutoCompleteField(driver, SELECT_COMPANY, companyName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting company
		// name");

		// String selectedCompanyName = ActionBot.findElement(driver,
		// SELECT_COMPANY).getAttribute("value");
		logger.info("Selected Company Name : " + selectedCompanyName);

		return selectedCompanyName;
	}

	@Override
	public String getSelectedCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement comp = ActionBot.findElement(driver, SELECT_COMPANY);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String selectedCompanyName = (String) jse.executeScript("return userInfoData.companyName", comp);
		logger.info("Selected Company Name : " + selectedCompanyName);

		return selectedCompanyName;
	}

	@Override
	public String selectLoaction(WebDriver driver, String testCaseName, String loactionName) throws ActionBotException
	{
		/*
		 * WebElement element = ActionBot.findElement(driver, SELECT_LOCATION);
		 * element.sendKeys(loactionName); ActionBot.defaultSleep();
		 * element.sendKeys(Keys.ARROW_DOWN); element.sendKeys(Keys.ENTER);
		 * ScreenShot.screenshot(driver, testCaseName,
		 * "After selecting Location name");
		 */
		String selectedLocationName = ActionBot.fillAutoCompleteField(driver, SELECT_LOCATION, loactionName);

		// String selectedLocationName = ActionBot.findElement(driver,
		// SELECT_LOCATION).getAttribute("value");
		logger.info("Selected Location Name : " + selectedLocationName);

		return selectedLocationName;
	}

	@Override
	public String getSelectedLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement loc = ActionBot.findElement(driver, SELECT_LOCATION);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String selectedLocationName = (String) jse.executeScript("return userInfoData.locationName", loc);

		logger.info("Selected Location Name : " + selectedLocationName);

		return selectedLocationName;
	}

	@Override
	public String selectPurchasingScope(WebDriver driver, String testCaseName, String purchasingScopeName) throws ActionBotException
	{
		String selectedPurchasingScope = ActionBot.fillAutoCompleteField(driver, PRUCHASING_SCOPE, purchasingScopeName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Purchasing Scope");

		// String selectedPurchasingScope = ActionBot.findElement(driver,
		// PRUCHASING_SCOPE).getAttribute("value");
		logger.info("Selected Purchasing Scope : " + selectedPurchasingScope);

		return selectedPurchasingScope;
	}

	@Override
	public String getSelectedPurchasingScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected Purchasing
		// Scope");

		String selectedPurchasingScope = null;
		if (ActionBot.isElementPresent(driver, PRUCHASING_SCOPE))
		{
			selectedPurchasingScope = ActionBot.findElement(driver, PRUCHASING_SCOPE).getAttribute("value");
		}
		logger.info("Selected Purchasing Scope : " + selectedPurchasingScope);

		return selectedPurchasingScope;
	}

	@Override
	public String selectDeliveryScope(WebDriver driver, String testCaseName, String deliveryScopeName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_SCOPE));
		select.selectByValue(deliveryScopeName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Delivery
		// Scope");
		String selectedDeliveryScope = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Delivery Scope : " + selectedDeliveryScope);

		return selectedDeliveryScope;
	}

	@Override
	public String getSelectedDeliveryScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_SCOPE));
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Delivery
		// Scope");
		String selectedDeliveryScope = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Delivery Scope : " + selectedDeliveryScope);

		return selectedDeliveryScope;
	}

	@Override
	public Float fillPurhcasingLimit(WebDriver driver, String testCaseName, Float purchasingLimit) throws ActionBotException
	{
		String purchasing_limit = Float.toString(purchasingLimit);
		purchasing_limit = ActionBot.sendKeys(driver, PURCHASING_LIMIT, purchasing_limit);
		// ScreenShot.screenshot(driver, testCaseName, "After filling purchasing
		// limit");
		// purchasing_limit = ActionBot.findElement(driver,
		// PURCHASING_LIMIT).getAttribute("value").trim();
		logger.info("Purchasing Limit : " + purchasing_limit);

		return Float.parseFloat(purchasing_limit);

	}

	@Override
	public Float getPurhcasingLimit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Purchasing limit");
		String purchasing_limit = ActionBot.findElement(driver, PURCHASING_LIMIT).getAttribute("value").trim();
		logger.info("Purchasing Limit : " + purchasing_limit);

		return Float.parseFloat(purchasing_limit);
	}

	@Override
	public String selectLocale(WebDriver driver, String testCaseName, String localeName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_LOCALE));
		select.selectByValue(localeName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Locale");
		String selectedLocale = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Locale : " + selectedLocale);

		return selectedLocale;
	}

	@Override
	public String getSelectedLocale(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_LOCALE));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Locale");
		String selectedLocale = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Locale : " + selectedLocale);

		return selectedLocale;
	}

	@Override
	public String selectTimezone(WebDriver driver, String testCaseName, String timezone) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_TIMEZONE));
		select.selectByValue(timezone);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Timezone");
		String selectedTimeZone = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Timezone : " + selectedTimeZone);

		return selectedTimeZone;
	}

	@Override
	public String getSelectedTimezone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_TIMEZONE));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Timezone");
		String selectedTimeZone = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Timezone : " + selectedTimeZone);

		return selectedTimeZone;
	}

	@Override
	public String selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_NUMBER_FORMAT));
		select.selectByValue(numberFormat);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Number
		// Format");
		String selectedNumberFormat = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Number Format : " + selectedNumberFormat);

		return selectedNumberFormat;
	}

	@Override
	public String getSelectedNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_NUMBER_FORMAT));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Number
		// Format");
		String selectedNumberFormat = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Number Format : " + selectedNumberFormat);

		return selectedNumberFormat;
	}

	@Override
	public String selectContolCurrency(WebDriver driver, String testCaseName, String contolCurrency) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, CONTROL_CURRENCY, contolCurrency);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Control
		// Currency");

		String selectedControlCurrency = ActionBot.findElement(driver, CONTROL_CURRENCY).getAttribute("value");
		logger.info("Selected Control Currency : " + selectedControlCurrency);

		return selectedControlCurrency;
	}

	@Override
	public String getSelectedContolCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected Control
		// Currency");

		String selectedControlCurrency = ActionBot.findElement(driver, CONTROL_CURRENCY).getAttribute("value");
		logger.info("Selected Control Currency : " + selectedControlCurrency);

		return selectedControlCurrency;
	}

	@Override
	public String selectSalutation(WebDriver driver, String testCaseName, String salutation) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SALUTATION));
		select.selectByValue(salutation);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Salutation");
		String selectedSalutation = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Salutation : " + selectedSalutation);

		return selectedSalutation;
	}

	@Override
	public String getSelectedSalutation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SALUTATION));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Salutation");
		String selectedSalutation = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Salutation : " + selectedSalutation);

		return selectedSalutation;
	}

	@Override
	public String fillUserLastName(WebDriver driver, String testCaseName, String userLastName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, USER_LAST_NAME, userLastName);
		// ScreenShot.screenshot(driver, testCaseName, "After filling user last
		// name");
		String lastName = ActionBot.findElement(driver, USER_LAST_NAME).getAttribute("value");
		logger.info("User Last Name : " + lastName);
		return lastName;
	}

	@Override
	public String getUserLastName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "User last name");
		String lastName = ActionBot.findElement(driver, USER_LAST_NAME).getAttribute("value");
		logger.info("User Last Name : " + lastName);
		return lastName;
	}

	@Override
	public String fillReportingManager(WebDriver driver, String testCaseName, String reportingManager) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, REPORTING_MANAGER, reportingManager);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Reporting Manager");

		String selectedReportingManager = ActionBot.findElement(driver, REPORTING_MANAGER).getAttribute("value");
		logger.info("Selected Reporting Manager : " + selectedReportingManager);

		return selectedReportingManager;
	}

	@Override
	public String getReportingManager(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected Reporting
		// Manager");

		String selectedReportingManager = ActionBot.findElement(driver, REPORTING_MANAGER).getAttribute("value");
		logger.info("Selected Reporting Manager : " + selectedReportingManager);

		return selectedReportingManager;
	}

	@Override
	public String selectDesignation(WebDriver driver, String testCaseName, String designation) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DESIGNATION));
		select.selectByValue(designation);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting
		// Designation");
		String selectedDesignation = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Designation : " + selectedDesignation);

		return selectedDesignation;
	}

	@Override
	public String getSelectedDesignation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DESIGNATION));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Designation");
		String selectedDesignation = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Designation : " + selectedDesignation);

		return selectedDesignation;
	}

	@Override
	public String selectBusinessUnit(WebDriver driver, String testCaseName, String businessUnitName) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, SELECT_BUSINESS_UNIT, businessUnitName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Business
		// Unit");

		String selectedBusinessUnit = ActionBot.findElement(driver, SELECT_BUSINESS_UNIT).getAttribute("value");
		logger.info("Selected Business Unit : " + selectedBusinessUnit);

		return selectedBusinessUnit;
	}

	@Override
	public String getSelectedBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected Business
		// Unit");

		String selectedBusinessUnit = ActionBot.findElement(driver, SELECT_BUSINESS_UNIT).getAttribute("value");
		logger.info("Selected Business Unit : " + selectedBusinessUnit);

		return selectedBusinessUnit;
	}

	@Override
	public String selectCostCenter(WebDriver driver, String testCaseName, String costCenterName) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, SELECT_COST_CENTER, costCenterName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Cost
		// Center");

		String selectedCostCenter = ActionBot.findElement(driver, SELECT_COST_CENTER).getAttribute("value");
		logger.info("Selected Cost Center : " + selectedCostCenter);

		return selectedCostCenter;
	}

	@Override
	public String getSelectedCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected Cost Center");

		String selectedCostCenter = ActionBot.findElement(driver, SELECT_COST_CENTER).getAttribute("value");
		logger.info("Selected Cost Center : " + selectedCostCenter);

		return selectedCostCenter;
	}

	@Override
	public String selectBeHalfScope(WebDriver driver, String testCaseName, String beHalfScopeName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_BEHALF_SCOPE));
		select.selectByVisibleText(beHalfScopeName);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Behalf
		// Scope");
		String selectedBehalfScope = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Behalf Scope : " + selectedBehalfScope);

		return selectedBehalfScope;
	}

	@Override
	public String getSelectedBeHalfScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_BEHALF_SCOPE));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Behalf Scope");
		String selectedBehalfScope = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Behalf Scope : " + selectedBehalfScope);

		return selectedBehalfScope;
	}

	@Override
	public Integer fillApprovalLimit(WebDriver driver, String testCaseName, int approvalLimit) throws ActionBotException
	{
		String approval_limit = Integer.toString(approvalLimit);
		ActionBot.sendKeys(driver, APPROVAL_LIMIT, approval_limit);
		// ScreenShot.screenshot(driver, testCaseName, "After filling Approval
		// Limit");
		approval_limit = ActionBot.findElement(driver, APPROVAL_LIMIT).getAttribute("value").trim();
		logger.info("Aproval Limit : " + approval_limit);

		return Integer.parseInt(approval_limit);
	}

	@Override
	public Integer getApprovalLimit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Approval Limit");
		String approval_limit = ActionBot.findElement(driver, APPROVAL_LIMIT).getAttribute("value").trim();
		logger.info("Aproval Limit : " + approval_limit);

		return Integer.parseInt(approval_limit);
	}

	@Override
	public String selectUserCurrency(WebDriver driver, String testCaseName, String userCurrency) throws ActionBotException
	{
		String selectedUserCurrency = ActionBot.fillAutoCompleteField(driver, USER_CURRENCY, userCurrency);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting User
		// Currency");

		// String selectedUserCurrency = ActionBot.findElement(driver,
		// USER_CURRENCY).getAttribute("value");
		logger.info("Selected User Currency : " + selectedUserCurrency);

		return selectedUserCurrency;
	}

	@Override
	public String getSelectedUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "Selected User
		// Currency");

		String selectedUserCurrency = ActionBot.findElement(driver, USER_CURRENCY).getAttribute("value");
		logger.info("Selected User Currency : " + selectedUserCurrency);

		return selectedUserCurrency;
	}

	@Override
	public String selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DATE_FORMAT));
		select.selectByValue(dateFormat);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Date
		// Format");
		String selectedDateFormat = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Date Format : " + selectedDateFormat);

		return selectedDateFormat;
	}

	@Override
	public String getSelectedDateFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DATE_FORMAT));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Date Format");
		String selectedDateFormat = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Date Format : " + selectedDateFormat);

		return selectedDateFormat;
	}

	@Override
	public String selectDecimalPlace(WebDriver driver, String testCaseName, String decimalPlace) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DECIMAL_PLACE));
		select.selectByValue(decimalPlace);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Decimal
		// Place");
		String selectedDecimalPlace = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Decimal Place : " + selectedDecimalPlace);

		return selectedDecimalPlace;
	}

	@Override
	public String getSelectedDecimalPlace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DECIMAL_PLACE));
		// ScreenShot.screenshot(driver, testCaseName, "Selected Decimal
		// Place");
		String selectedDecimalPlace = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Decimal Place : " + selectedDecimalPlace);

		return selectedDecimalPlace;
	}

	@Override
	public void clickOnUpdateUserButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UPDATE_USER_BUTTON);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESS_STATUS);
		// ActionBot.defaultSleep();
		ActionBot.threadSleep("10");
		ScreenShot.screenshot(driver, testCaseName, "After clicking on update user button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel button");
		ActionBot.click(driver, CANCEL_BUTTON_USER);
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel button");
	}

	@Override
	public void clickOnCloseWizardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close wizard button");
		ActionBot.click(driver, CLOSE_WIZARD_BUTTON);
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close wizard button");
	}

	@Override
	public String getRequestingScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requestingScope = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_REQUESTING_SCOPE))
		{
			requestingScope = ActionBot.findElement(driver, TEXTBOX_REQUESTING_SCOPE).getAttribute("value");

		}
		logger.info("Selected Requesting Scope : " + requestingScope);
		return requestingScope;
	}

	@Override
	public String getAdminScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String adminScope = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_ADMIN_SCOPE))
		{
			adminScope = ActionBot.findElement(driver, TEXTBOX_ADMIN_SCOPE).getAttribute("value");
		}
		logger.info("Selected Admin Scope : " + adminScope);

		return adminScope;
	}

}
