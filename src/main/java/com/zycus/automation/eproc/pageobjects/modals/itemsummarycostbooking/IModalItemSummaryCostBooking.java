package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostbooking;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemSummaryCostBooking
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
	final UI_Elements	ITEM_LEVEL_BUDGET_DETAILS						= UIFactory.getElements("ITEM_LEVEL_BUDGET_DETAILS");

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

	public String getItemlevelBudgetdetails(WebDriver driver) throws ActionBotException, FactoryMethodException;

}
