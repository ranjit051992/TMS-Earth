package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOSummaryCostBooking
{
	final UI_Elements	ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY		= UIFactory.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY");
	final UI_Elements	ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY_TEXT	= UIFactory.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY_TEXT");
	final UI_Elements	RADIO_BUTTON_YES_PO_SUMMARY						= UIFactory.getElements("RADIO_BUTTON_YES_PO_SUMMARY");
	final UI_Elements	RADIO_BUTTON_NO_PO_SUMMARY						= UIFactory.getElements("RADIO_BUTTON_NO_PO_SUMMARY");
	final UI_Elements	FIELD_PROJECT_PO_SUMMARY						= UIFactory.getElements("FIELD_PROJECT_PO_SUMMARY");

	final UI_Elements	FIELD_BUDGET_PO_SUMMARY							= UIFactory.getElements("FIELD_BUDGET_PO_SUMMARY");

	final UI_Elements	BUTTON_SAVE_PO_SUMMARY							= UIFactory.getElements("BUTTON_SAVE_PO_SUMMARY");

	final UI_Elements	FIELD_COST_CENTER_PO_SUMMARY					= UIFactory.getElements("FIELD_COST_CENTER_PO_SUMMARY");
	final UI_Elements	FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY			= UIFactory.getElements("FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY");
	final UI_Elements	FIELD_PROJECT_INFO								= UIFactory.getElements("FIELD_PROJECT_INFO");

	final UI_Elements	INFO_PROJECTCODE_INFO							= UIFactory.getElements("INFO_PROJECTCODE_INFO");

	final UI_Elements	INFO_PROJECTNAME_INFO							= UIFactory.getElements("INFO_PROJECTNAME_INFO");

	final UI_Elements	INFO_PROJECTMANAGER_INFO						= UIFactory.getElements("INFO_PROJECTMANAGER_INFO");
	final UI_Elements	INFO_TOOLTIP_ICON								= UIFactory.getElements("INFO_TOOLTIP_ICON");

	final UI_Elements	INFO_PROJECTDURATION_INFO						= UIFactory.getElements("INFO_PROJECTDURATION_INFO");
	final UI_Elements	PROJECT_INFOICON								= UIFactory.getElements("PROJECT_INFOICON");
	final UI_Elements	TASK_INFOICON									= UIFactory.getElements("TASK_INFOICON");

	final UI_Elements	PROJECT_TEXT									= UIFactory.getElements("PROJECT_TEXT");
	final UI_Elements	INFO_ICON										= UIFactory.getElements("INFO_ICON");

	final UI_Elements	PROJECT_CODE_AND_NAME_INFO_ICON					= UIFactory.getElements("PROJECT_CODE_AND_NAME_INFO_ICON");
	final UI_Elements	PROJECT_ICON									= UIFactory.getElements("PROJECT_ICON");

	final UI_Elements	ASSIGN_COST_PROJECT_BLOCK						= UIFactory.getElements("ASSIGN_COST_PROJECT_BLOCK");

	final UI_Elements	BUTTON_CANCEL_PO_SUMMARY						= UIFactory.getElements("BUTTON_CANCEL_PO_SUMMARY");
	final UI_Elements	BUTTON_RADIO_SINGLE_COSTCENTER					= UIFactory.getElements("BUTTON_RADIO_SINGLE_COSTCENTER");
	final UI_Elements	CONFIRM_ITEM_LEVEL_SUBMIT_BOTTOM				= UIFactory.getElements("CONFIRM_ITEM_LEVEL_SUBMIT_BOTTOM");
	final UI_Elements	NON_EDITABLE_CC_PO_SUMMARY						= UIFactory.getElements("NON_EDITABLE_CC_PO_SUMMARY");
	final UI_Elements	HEADER_LEVEL_COSTING_DETAILS					= UIFactory.getElements("HEADER_LEVEL_COSTING_DETAILS");
	final UI_Elements	HEADER_LEVEL_PREOJECT_DETAILS					= UIFactory.getElements("HEADER_LEVEL_PREOJECT_DETAILS");
	UI_Elements			LABEL_PROJECT_AT_HEADER_LEVEL_PO				= UIFactory.getElements("LABEL_PROJECT_AT_HEADER_LEVEL_PO");
	UI_Elements			ERROR_PROJECT_SUMMARY							= UIFactory.getElements("ERROR_PROJECT_SUMMARY");

	UI_Elements			RADIO_ASSIGN_COST_TO_PROJECT_YES_PO_PAGE		= UIFactory.getElements("RADIO_ASSIGN_COST_TO_PROJECT_YES_PO_PAGE");

	UI_Elements			RADIO_ASSIGN_COST_TO_PROJECT_NO_PO_PAGE			= UIFactory.getElements("RADIO_ASSIGN_COST_TO_PROJECT_NO_PO_PAGE");

	final UI_Elements	HEADER_LEVEL_BUDGET_DETAILS						= UIFactory.getElements("HEADER_LEVEL_BUDGET_DETAILS");

	public void clearAndclickOnProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public String clearandfillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException;

	public String clearProjectField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException;

	public String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException;

	public String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException;

	public String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjecduration(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjecmanagerInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjecmanagerInfoField(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderLevelCostingDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderLevelProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectCodeInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectFieldname(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectNameInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAutocompleteFieldProjectNotDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDurationFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index1) throws ActionBotException;

	public boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFieldReset(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectCodeAndProjectNameFieldPresentInInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectFieldEmpty(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectManagerFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isProjectOrTaskIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRadioBottomSingleCostCenterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTaskInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInfoIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNonEditableCCFromReqToPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnYESradioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearCostCenterField(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfProjectField(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRadioBottonSingleCostCenterEnable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderLevelBudgetDetails(WebDriver driver, String testCaseName) throws ActionBotException;

}
