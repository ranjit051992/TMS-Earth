/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createbudget;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreateBudget
{
	static UI_Elements	INPUT_OWNER_NAME									= UIFactory.getElements("INPUT_OWNER_NAME");
	static UI_Elements	INPUT_COMPANY_NAME									= UIFactory.getElements("INPUT_COMPANY_NAME");
	static UI_Elements	INPUT_CURRENCY_TYPE									= UIFactory.getElements("INPUT_CURRENCY_TYPE");
	static UI_Elements	DATE_PICKER_VALIDITY_FROM							= UIFactory.getElements("DATE_PICKER_VALIDITY_FROM");
	static UI_Elements	DATE_PICKER_VALIDITY_TO								= UIFactory.getElements("DATE_PICKER_VALIDITY_TO");
	static UI_Elements	INPUT_FROM_VALIDITY_DATE							= UIFactory.getElements("INPUT_FROM_VALIDITY_DATE");
	static UI_Elements	INPUT_TO_VALIDITY_DATE								= UIFactory.getElements("INPUT_TO_VALIDITY_DATE");
	static UI_Elements	CHECKBOX_DISPLAY_UTILIZATION_OF_APPROVER			= UIFactory.getElements("CHECKBOX_DISPLAY_UTILIZATION_OF_APPROVER");
	static UI_Elements	CHECKBOX_DISPLAY_UTILIZATION_OF_REQUESTER			= UIFactory.getElements("CHECKBOX_DISPLAY_UTILIZATION_OF_REQUESTER");
	static UI_Elements	INPUT_OWNER_AS_OBSERVER_CONSUMPTION					= UIFactory.getElements("INPUT_OWNER_AS_OBSERVER_CONSUMPTION");
	static UI_Elements	INPUT_OWNER_AS_APPROVER_CONSUMPTION					= UIFactory.getElements("INPUT_OWNER_AS_APPROVER_CONSUMPTION");
	static UI_Elements	INPUT_EXCEED_PERCENT_TOLERANCE						= UIFactory.getElements("INPUT_EXCEED_PERCENT_TOLERANCE");
	static UI_Elements	INPUT_EXCEED_AMOUNT_TOLERANCE						= UIFactory.getElements("INPUT_EXCEED_AMOUNT_TOLERANCE");
	static UI_Elements	SELECT_DEFINED_BUDGET_BY							= UIFactory.getElements("SELECT_DEFINED_BUDGET_BY");
	static UI_Elements	INPUT_BUDGET_NAME									= UIFactory.getElements("INPUT_BUDGET_NAME");
	static UI_Elements	INPUT_BUDGET_NOTES									= UIFactory.getElements("INPUT_BUDGET_NOTES");
	static UI_Elements	BUTTON_SAVE_AND_FREEZE_BUDGET						= UIFactory.getElements("BUTTON_SAVE_AND_FREEZE_BUDGET");
	static UI_Elements	BUTTON_SAVE_AS_DRAFT_BUDGET							= UIFactory.getElements("BUTTON_SAVE_AS_DRAFT_BUDGET");
	static UI_Elements	BUTTON_CANCEL_BUDGET								= UIFactory.getElements("BUTTON_CANCEL_BUDGET");
	static UI_Elements	SELECT_BUDGET_PERIOD								= UIFactory.getElements("SELECT_BUDGET_PERIOD");
	static UI_Elements	BUTTON_GENETARE_DIMENSIONS							= UIFactory.getElements("BUTTON_GENETARE_DIMENSIONS");
	static UI_Elements	SELECT_FIRST_PERIOD_FOR_BUDGET						= UIFactory.getElements("SELECT_FIRST_PERIOD_FOR_BUDGET");
	static UI_Elements	BUTTON_ADD_BUDGET_LINE								= UIFactory.getElements("BUTTON_ADD_BUDGET_LINE");
	static UI_Elements	INPUT_BUSINESS_UNIT_FOR_BUDGET_LINE					= UIFactory.getElements("INPUT_BUSINESS_UNIT_FOR_BUDGET_LINE");
	static UI_Elements	INPUT_BUDGET_LINE_CODE								= UIFactory.getElements("INPUT_BUDGET_LINE_CODE");
	static UI_Elements	INPUT_BUDGET_LINE_NAME								= UIFactory.getElements("INPUT_BUDGET_LINE_NAME");
	static UI_Elements	INPUT_BUDGET_LINE_OWNER_NAME						= UIFactory.getElements("INPUT_BUDGET_LINE_OWNER_NAME");
	static UI_Elements	INPUT_PLANNED_AMOUNT_FOR_BUDGET_LINE				= UIFactory.getElements("INPUT_PLANNED_AMOUNT_FOR_BUDGET_LINE");
	static UI_Elements	BUTTON_SAVE_ROW_FOR_BUDGET_LINE						= UIFactory.getElements("BUTTON_SAVE_ROW_FOR_BUDGET_LINE");
	static UI_Elements	BUTTON_DELETE_ROW_FOR_BUDGET_LINE					= UIFactory.getElements("BUTTON_DELETE_ROW_FOR_BUDGET_LINE");
	static UI_Elements	BUTTON_ADD_ANOTHER_BUDGET_DIMENSIONS				= UIFactory.getElements("BUTTON_ADD_ANOTHER_BUDGET_DIMENSIONS");
	static UI_Elements	SELECT_BUDGET_DIMENSION								= UIFactory.getElements("SELECT_BUDGET_DIMENSION");
	static UI_Elements	INPUT_LOCATION_FOR_BUDGET_LINE						= UIFactory.getElements("INPUT_LOCATION_FOR_BUDGET_LINE");
	static UI_Elements	INPUT_COST_CENTER_FOR_BUDGET_LINE					= UIFactory.getElements("INPUT_COST_CENTER_FOR_BUDGET_LINE");
	static UI_Elements	SELECT_DEPARTMENT_FOR_BUDGET_LINE					= UIFactory.getElements("SELECT_DEPARTMENT_FOR_BUDGET_LINE");
	static UI_Elements	SELECT_DESIGNATION_FOR_BUDGET_LINE					= UIFactory.getElements("SELECT_DESIGNATION_FOR_BUDGET_LINE");
	static UI_Elements	LINK_AUTO_GENERATE_COMBINATIONS						= UIFactory.getElements("LINK_AUTO_GENERATE_COMBINATIONS");
	static UI_Elements	LINK_UPLOAD_BUDGET_LINE_VIA_FILE					= UIFactory.getElements("LINK_UPLOAD_BUDGET_LINE_VIA_FILE");
	static UI_Elements	LIST_OF_BUDGET_PERIODS								= UIFactory.getElements("LIST_OF_BUDGET_PERIODS");
	static UI_Elements	LABEL_TO_BUDGET_DATE_ON_VIEW_BUDGET_PAGE			= UIFactory.getElements("LABEL_TO_BUDGET_DATE_ON_VIEW_BUDGET_PAGE");
	UI_Elements			TEXTBOX_PROJECT_BUDGET_LINES						= UIFactory.getElements("TEXTBOX_PROJECT_BUDGET_LINES");
	// added by dnyanesh joshi
	static UI_Elements	BUTTON_ADD_DIMENSION								= UIFactory.getElements("BUTTON_ADD_DIMENSION");
	static UI_Elements	BUTTON_DEACTIVATE_BUDGET							= UIFactory.getElements("BUTTON_DEACTIVATE_BUDGET");
	static UI_Elements	ALERT_CONFIRM_DEACTIVATE							= UIFactory.getElements("ALERT_CONFIRM_DEACTIVATE");
	static UI_Elements	ALERT_CONFIRM_AUTOGENERATE							= UIFactory.getElements("ALERT_CONFIRM_AUTOGENERATE");
	static UI_Elements	ALERT_REVIEW_LINE									= UIFactory.getElements("ALERT_REVIEW_LINE");
	static UI_Elements	CHECKBOX_SELECT_ALL_BUDGET_LINE						= UIFactory.getElements("CHECKBOX_SELECT_ALL_BUDGET_LINE");
	static UI_Elements	BUTTON_SELECTED_BUDGET_LINE							= UIFactory.getElements("BUTTON_SELECTED_BUDGET_LINE");
	static UI_Elements	BUTTON_DELETE_DIMENSION								= UIFactory.getElements("BUTTON_DELETE_DIMENSION");
	static UI_Elements	INPUT_OWNER_NAME_SEARCH								= UIFactory.getElements("INPUT_OWNER_NAME_SEARCH");
	static UI_Elements	LABEL_IS_BUDGET_LINE_SEARCHED						= UIFactory.getElements("LABEL_IS_BUDGET_LINE_SEARCHED");
	static UI_Elements	BUTTON_DELETE_BUDGETLINE_FROM_ACTIONS				= UIFactory.getElements("BUTTON_DELETE_BUDGETLINE_FROM_ACTIONS");
	static UI_Elements	BUTTON_EDIT_BUDGETLINE_FROM_ACTIONS					= UIFactory.getElements("BUTTON_EDIT_BUDGETLINE_FROM_ACTIONS");
	static UI_Elements	BUTTON_AUDIT_BUDGETLINE_FROM_ACTIONS				= UIFactory.getElements("BUTTON_AUDIT_BUDGETLINE_FROM_ACTIONS");
	static UI_Elements	TEXT_AUTOPOPULATED_BUDGET_NAME						= UIFactory.getElements("TEXT_AUTOPOPULATED_BUDGET_NAME");
	static UI_Elements	BUTTON_UPLOAD_VIA_FILE								= UIFactory.getElements("BUTTON_UPLOAD_VIA_FILE");
	static UI_Elements	TEXTFIELD_BUSINESS_UNIT_FROM_BUDGETLINE				= UIFactory.getElements("TEXTFIELD_BUSINESS_UNIT_FROM_BUDGETLINE");
	static UI_Elements	TEXTFIELD_PROJECT_FROM_BUDGETLINE					= UIFactory.getElements("TEXTFIELD_PROJECT_FROM_BUDGETLINE");
	static UI_Elements	SELECT_AUTOPOPULATED_BUSINESS_UNIT					= UIFactory.getElements("SELECT_AUTOPOPULATED_BUSINESS_UNIT");
	static UI_Elements	TEXTFIELD_COST_CENTER_FROM_BUDGETLINE				= UIFactory.getElements("TEXTFIELD_COST_CENTER_FROM_BUDGETLINE");
	static UI_Elements	SELECT_AUTOPOPULATED_COST_CENTER					= UIFactory.getElements("SELECT_AUTOPOPULATED_COST_CENTER");
	static UI_Elements	TEXTFIELD_LOCATION_FROM_BUDGETLINE					= UIFactory.getElements("TEXTFIELD_LOCATION_FROM_BUDGETLINE");
	static UI_Elements	SELECT_AUTOPOPULATED_LOCATION						= UIFactory.getElements("SELECT_AUTOPOPULATED_LOCATION");
	static UI_Elements	TEXTFIELD_DEPARTMENT_FROM_BUDGETLINE				= UIFactory.getElements("TEXTFIELD_DEPARTMENT_FROM_BUDGETLINE");
	static UI_Elements	SELECT_AUTOPOPULATED_DEPARTMENT						= UIFactory.getElements("SELECT_AUTOPOPULATED_DEPARTMENT");
	static UI_Elements	TEXTFIELD_DESIGNATION_FROM_BUDGETLINE				= UIFactory.getElements("TEXTFIELD_DESIGNATION_FROM_BUDGETLINE");
	static UI_Elements	SELECT_AUTOPOPULATED_DESIGNATION					= UIFactory.getElements("SELECT_AUTOPOPULATED_DESIGNATION");
	static UI_Elements	BUTTON_ALLOW_BUDGETUTILIZATION_YES					= UIFactory.getElements("BUTTON_ALLOW_BUDGETUTILIZATION_YES");
	static UI_Elements	BUTTON_ALLOW_BUDGETUTILIZATION_NO					= UIFactory.getElements("BUTTON_ALLOW_BUDGETUTILIZATION_NO");
	static UI_Elements	BUTTON_ALLOW_BUDGETUTILIZATION_LET_USER_DECIDE		= UIFactory.getElements("BUTTON_ALLOW_BUDGETUTILIZATION_LET_USER_DECIDE");
	static UI_Elements	BUTTON_SAVE_COST_BOOKING							= UIFactory.getElements("BUTTON_SAVE_COST_BOOKING");

	static UI_Elements	SELECT_AUTOPOPULATED_OWNER_NAME						= UIFactory.getElements("SELECT_AUTOPOPULATED_OWNER_NAME");
	static UI_Elements	TEXT_FIRST_DIMENSION								= UIFactory.getElements("TEXT_FIRST_DIMENSION");
	static UI_Elements	TEXT_SECOND_DIMENSION								= UIFactory.getElements("TEXT_SECOND_DIMENSION");
	static UI_Elements	TEXT_THIRD_DIMENSION								= UIFactory.getElements("TEXT_THIRD_DIMENSION");
	static UI_Elements	TEXT_FOURTH_DIMENSION								= UIFactory.getElements("TEXT_FOURTH_DIMENSION");
	static UI_Elements	TEXT_FIFTH_DIMENSION								= UIFactory.getElements("TEXT_FIFTH_DIMENSION");
	static UI_Elements	TEXT_FIRST_DIMENSION_FROM_BUDGET_LINE				= UIFactory.getElements("TEXT_FIRST_DIMENSION_FROM_BUDGET_LINE");
	static UI_Elements	TEXT_SECOND_DIMENSION_FROM_BUDGET_LINE				= UIFactory.getElements("TEXT_SECOND_DIMENSION_FROM_BUDGET_LINE");
	static UI_Elements	TEXT_THIRD_DIMENSION_FROM_BUDGET_LINE				= UIFactory.getElements("TEXT_THIRD_DIMENSION_FROM_BUDGET_LINE");
	static UI_Elements	TEXT_FOURTH_DIMENSION_FROM_BUDGET_LINE				= UIFactory.getElements("TEXT_FOURTH_DIMENSION_FROM_BUDGET_LINE");
	static UI_Elements	TEXT_FIFTH_DIMENSION_FROM_BUDGET_LINE				= UIFactory.getElements("TEXT_FIFTH_DIMENSION_FROM_BUDGET_LINE");
	static UI_Elements	TEXT_FIRST_DIMENSION_FROM_AUTOGENERATE_COMBINATION	= UIFactory.getElements("TEXT_FIRST_DIMENSION_FROM_AUTOGENERATE_COMBINATION");
	static UI_Elements	TEXT_SECOND_DIMENSION_FROM_AUTOGENERATE_COMBINATION	= UIFactory.getElements("TEXT_SECOND_DIMENSION_FROM_AUTOGENERATE_COMBINATION");
	static UI_Elements	TEXT_THIRD_DIMENSION_FROM_AUTOGENERATE_COMBINATION	= UIFactory.getElements("TEXT_THIRD_DIMENSION_FROM_AUTOGENERATE_COMBINATION");
	static UI_Elements	TEXT_FOURTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION	= UIFactory.getElements("TEXT_FOURTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION");
	static UI_Elements	TEXT_FIFTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION	= UIFactory.getElements("TEXT_FIFTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION");

	static UI_Elements	BUTTON_DELETE_ICON_FOR_FIRST_DIMENSION				= UIFactory.getElements("BUTTON_DELETE_ICON_FOR_FIRST_DIMENSION");
	static UI_Elements	BUTTON_DELETE_ICON_FOR_SECOND_DIMENSION				= UIFactory.getElements("BUTTON_DELETE_ICON_FOR_SECOND_DIMENSION");
	static UI_Elements	BUTTON_DELETE_ICON_FOR_THIRD_DIMENSION				= UIFactory.getElements("BUTTON_DELETE_ICON_FOR_THIRD_DIMENSION");
	static UI_Elements	BUTTON_DELETE_ICON_FOR_FOURTH_DIMENSION				= UIFactory.getElements("BUTTON_DELETE_ICON_FOR_FOURTH_DIMENSION");
	static UI_Elements	BUTTON_DELETE_ICON_FOR_FIFTH_DIMENSION				= UIFactory.getElements("BUTTON_DELETE_ICON_FOR_FIFTH_DIMENSION");
	static UI_Elements	BUTTON_DELETE_SELECTED_BUDGET_LINE					= UIFactory.getElements("BUTTON_DELETE_SELECTED_BUDGET_LINE");
	static UI_Elements	BUTTON_CONFIRM_DELETE_BUDGET_LINE_POPUP				= UIFactory.getElements("BUTTON_CONFIRM_DELETE_BUDGET_LINE_POPUP");
	static UI_Elements	ALERT_DUPLICATE_BUDGET_LINE							= UIFactory.getElements("ALERT_DUPLICATE_BUDGET_LINE");

	static UI_Elements	ALERT_ENTER_ALL_PARAMETERS_OF_BUDGET_LINE			= UIFactory.getElements("ALERT_ENTER_ALL_PARAMETERS_OF_BUDGET_LINE");

	static UI_Elements	WINDOW_AUTOGENERATE_BUDGET_LINE						= UIFactory.getElements("WINDOW_AUTOGENERATE_BUDGET_LINE");

	static UI_Elements	TEXT_BUSIENSS_UNIT_AUTOGENERATE_BUDGET_LINE			= UIFactory.getElements("TEXT_BUSIENSS_UNIT_AUTOGENERATE_BUDGET_LINE");

	static UI_Elements	TEXT_COST_CENTER_AUTOGENERATE_BUDGET_LINE			= UIFactory.getElements("TEXT_COST_CENTER_AUTOGENERATE_BUDGET_LINE");

	static UI_Elements	CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1		= UIFactory.getElements("CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1");

	static UI_Elements	CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2		= UIFactory.getElements("CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2");
	static UI_Elements	CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_3		= UIFactory.getElements("CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_3");

	static UI_Elements	BUTTON_BOOK_COST_TO_SINGLE_COST_CENTER				= UIFactory.getElements("BUTTON_BOOK_COST_TO_SINGLE_COST_CENTER");

	static UI_Elements	BUTTON_BOOK_COST_TO_MULTIPLE_COST_CENTER			= UIFactory.getElements("BUTTON_BOOK_COST_TO_MULTIPLE_COST_CENTER");

	static UI_Elements	BUTTON_ADD_ANOTHER_BUDGET_IN_COST_ALLOCATION		= UIFactory.getElements("BUTTON_ADD_ANOTHER_BUDGET_IN_COST_ALLOCATION");

	static UI_Elements	TEXT_INFO_ICON_IN_COST_ALLOCATION					= UIFactory.getElements("TEXT_INFO_ICON_IN_COST_ALLOCATION");

	static UI_Elements	TEXTFEILD_BUDGET_LINE_CODE							= UIFactory.getElements("TEXTFEILD_BUDGET_LINE_CODE");

	static UI_Elements	INPUT_TEXTFEILD_BUDGET_LINE_CODE					= UIFactory.getElements("INPUT_TEXTFEILD_BUDGET_LINE_CODE");

	static UI_Elements	TEXTFEILD_BUSINESS_UNIT_ON_CHECKOUT					= UIFactory.getElements("TEXTFEILD_BUSINESS_UNIT_ON_CHECKOUT");

	static UI_Elements	SELECT_AUTOCOMPLETE_BUSINESS_UNIT_ON_CHECKOUT		= UIFactory.getElements("SELECT_AUTOCOMPLETE_BUSINESS_UNIT_ON_CHECKOUT");

	static UI_Elements	TEXT_FIRST_RESERVED_AMOUNT_ON_BUDGET_LISTING		= UIFactory.getElements("TEXT_FIRST_RESERVED_AMOUNT_ON_BUDGET_LISTING");

	static UI_Elements	BUTTON_GENERATE_AUTOGENRATE_BUDGET_LINES			= UIFactory.getElements("BUTTON_GENERATE_AUTOGENRATE_BUDGET_LINES");

	static UI_Elements	ALERT_PROPER_COMBINATIONS_IN_AUTOGENERATE			= UIFactory.getElements("ALERT_PROPER_COMBINATIONS_IN_AUTOGENERATE");

	static UI_Elements	TEXTFIELD_SEARCH_BUDGET_LINE_BY_BUSINESS_UNIT		= UIFactory.getElements("TEXTFIELD_SEARCH_BUDGET_LINE_BY_BUSINESS_UNIT");
	static UI_Elements	TEXTFIELD_SEARCH_BUDGET_LINE_BY_LOCATION			= UIFactory.getElements("TEXTFIELD_SEARCH_BUDGET_LINE_BY_LOCATION");
	static UI_Elements	TEXTFIELD_SEARCH_BUDGET_LINE_BY_COST_CENTER			= UIFactory.getElements("TEXTFIELD_SEARCH_BUDGET_LINE_BY_COST_CENTER");
	static UI_Elements	TEXTFIELD_SEARCH_BUDGET_LINE_BY_DEPARTMENT			= UIFactory.getElements("TEXTFIELD_SEARCH_BUDGET_LINE_BY_DEPARTMENT");
	static UI_Elements	TEXTFIELD_SEARCH_BUDGET_LINE_BY_DESIGNATION			= UIFactory.getElements("TEXTFIELD_SEARCH_BUDGET_LINE_BY_DESIGNATION");
	static UI_Elements	CHECKBOX_OF_FIRST_BUDGET_LINE						= UIFactory.getElements("CHECKBOX_OF_FIRST_BUDGET_LINE");
	static UI_Elements	TEXT_BUDGET_LINE_CODE								= UIFactory.getElements("TEXT_BUDGET_LINE_CODE");
	static UI_Elements	ALERT_DUPLICATE_DIMENSION							= UIFactory.getElements("ALERT_DUPLICATE_DIMENSION");
	static UI_Elements	ALERT_DUPLICATE_BUDGET_LINE_CODE					= UIFactory.getElements("ALERT_DUPLICATE_BUDGET_LINE_CODE");

	static UI_Elements	TEXTFIELD_BUDGET_LINE_CODE							= UIFactory.getElements("TEXTFIELD_BUDGET_LINE_CODE");

	static UI_Elements	TEXTFIELD_BUDGET_LINE_NAME							= UIFactory.getElements("TEXTFIELD_BUDGET_LINE_NAME");

	static UI_Elements	BUTTON_CHANGE_SEQUENCE								= UIFactory.getElements("BUTTON_CHANGE_SEQUENCE");

	public String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException;

	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public String fillCurrencyType(WebDriver driver, String testCaseName, String currencyType) throws ActionBotException;

	public String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException;

	public String fillBudgetNotes(WebDriver driver, String testCaseName, String budgetNotes) throws ActionBotException;

	public String selectBudgetValidityDateFrom(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectBudgetValidityDateTo(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public boolean selectDisplayUtilizationOfBudgetToApprovers(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean selectDisplayUtilizationOfBudgetToRequesters(WebDriver driver, String testCaseName) throws ActionBotException;

	public int fillPercentageConsumptionOfOwnerAsObserverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException;

	public int fillPercentageConsumptionOfOwnerAsApproverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException;

	public void clickOnAddAnotherBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGenerateBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddBudgetLineButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBusinessUnit(WebDriver driver, String testCaseName, String BU) throws ActionBotException;

	public String fillBudgetLineCode(WebDriver driver, String testCaseName, String budgetLineCode) throws ActionBotException;

	public String fillBudgetLineName(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public String fillBudgetLineOwner(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException;

	public String fillBudgetLineLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException;

	public String fillBudgetLineCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException;

	public String selectBudgetLineDepartment(WebDriver driver, String testCaseName, String department) throws ActionBotException;

	public String selectBudgetLineDesignation(WebDriver driver, String testCaseName, String department) throws ActionBotException;

	public String fillPlannedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void clickOnSaveBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFirstBudgetPeriod(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAndFreezeBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectBudgetDimension(WebDriver driver, String testCaseName, String designation, int index) throws ActionBotException;

	public void clickOnAutoGenerateCombinations(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUploadViaFile(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectBudgetPeriod(WebDriver driver, String testCaseName, String periodName) throws ActionBotException;

	public String getBusinessUnitOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getLocationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getCostCenterOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getDepartmentOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getDesignationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getBudgetLineCode(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getBudgetLineName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getOwnerOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getPlannedAmountOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void selectBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public void clickOnActionsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	// By Dnyanesh
	/*
	 * public void clickOnDeleteActionsOfBudgetLine(WebDriver driver, String
	 * testCaseName, String budgetLineName) throws ActionBotException;
	 */

	public boolean isBudgetLineDeleted(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public String getToBudgetDateOnBudgetViewPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSettingsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public String fillProjectBudgetLine(WebDriver driver, String testCaseName, String project) throws ActionBotException;

}
