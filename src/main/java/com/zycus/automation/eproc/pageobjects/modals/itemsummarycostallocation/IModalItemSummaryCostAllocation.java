package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostallocation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemSummaryCostAllocation
{
	final UI_Elements	BUTTON_COST_BOOKING_ITEM_SUMMARY				= UIFactory.getElements("BUTTON_COST_BOOKING_ITEM_SUMMARY");
	final UI_Elements	LABEL_PROJECT_ITEM_SUMMARY						= UIFactory.getElements("LABEL_PROJECT_ITEM_SUMMARY");
	final UI_Elements	PROJECT_OR_TASK_ICON_ITEM_SUMMARY				= UIFactory.getElements("PROJECT_OR_TASK_ICON_ITEM_SUMMARY");
	final UI_Elements	PROJECT_INFO_ICON_ITEM_SUMMARY					= UIFactory.getElements("PROJECT_INFO_ICON_ITEM_SUMMARY");
	final UI_Elements	ITEM_LEVEL_PROJECT_DETAILS						= UIFactory.getElements("ITEM_LEVEL_PROJECT_DETAILS");
	final UI_Elements	ITEM_LEVEL_COSTING_DETAILS						= UIFactory.getElements("ITEM_LEVEL_COSTING_DETAILS");
	final UI_Elements	LABEL_AMOUNT_ASSIGNED_COST_BOOKING_ITEM_SUMMARY	= UIFactory.getElements("LABEL_AMOUNT_ASSIGNED_COST_BOOKING_ITEM_SUMMARY");
	final UI_Elements	TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC				= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC");
	final UI_Elements	TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT		= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT");
	final UI_Elements	TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET			= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET");
	final UI_Elements	TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY					= UIFactory.getElements("TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY");
	final UI_Elements	ACCOUNTING_ERROR_MSG							= UIFactory.getElements("ACCOUNTING_ERROR_MSG");
	final UI_Elements	BUTTON_SAVE_ITEM_SUMMARY						= UIFactory.getElements("BUTTON_SAVE_ITEM_SUMMARY");
	final UI_Elements	BUTTON_CANCEL_ITEM_SUMMARY						= UIFactory.getElements("BUTTON_CANCEL_ITEM_SUMMARY");

	public void clickOnCostBooking(WebDriver driver) throws ActionBotException;

	public String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException;

	public String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException;

	public String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException;

	public boolean isProjectFieldALabel(WebDriver driver) throws Exception;

	public boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException;

	public boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException;

	public String getAmountAssigned(WebDriver driver) throws ActionBotException;

	public String fillCostCenter(WebDriver driver, String testCaseName, String CC) throws ActionBotException;

	public String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException;

	public String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException;

	public void clickOnCancel(WebDriver driver) throws ActionBotException;

	public void clickOnSave(WebDriver driver) throws ActionBotException;

	public String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException;

	public String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException;

	public boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException;

	public boolean isGLAccountFieldEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

}
