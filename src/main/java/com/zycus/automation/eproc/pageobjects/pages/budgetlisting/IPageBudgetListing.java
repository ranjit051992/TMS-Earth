/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.budgetlisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageBudgetListing
{
	static UI_Elements	BUTTON_ADD_BUDGET					= UIFactory.getElements("BUTTON_ADD_BUDGET");
	static UI_Elements	INPUT_SEARCH_BUDGET_NAME			= UIFactory.getElements("INPUT_SEARCH_BUDGET_NAME");
	static UI_Elements	INPUT_SEARCH_BUDGET_COMPANY			= UIFactory.getElements("INPUT_SEARCH_BUDGET_COMPANY");
	static UI_Elements	INPUT_SEARCH_BUDGET_OWNER			= UIFactory.getElements("INPUT_SEARCH_BUDGET_OWNER");
	static UI_Elements	LABEL_STATUS_OF_BUDGET				= UIFactory.getElements("LABEL_STATUS_OF_BUDGET");
	static UI_Elements	BUTTON_STATUS_FILTER				= UIFactory.getElements("BUTTON_STATUS_FILTER");
	static UI_Elements	CHECKBOX_CLOSED_BUDGET				= UIFactory.getElements("CHECKBOX_CLOSED_BUDGET");
	static UI_Elements	BUTTON_FILTER_BUDGET				= UIFactory.getElements("BUTTON_FILTER_BUDGET");
	static UI_Elements	LABEL_NAME_OF_BUDGET				= UIFactory.getElements("LABEL_NAME_OF_BUDGET");
	static UI_Elements	LABEL_COMPANY_OF_BUDGET				= UIFactory.getElements("LABEL_COMPANY_OF_BUDGET");
	static UI_Elements	LABEL_OWNER_OF_BUDGET				= UIFactory.getElements("LABEL_OWNER_OF_BUDGET");
	static UI_Elements	LABEL_PLANNED_AMOUNT_OF_BUDGET		= UIFactory.getElements("LABEL_PLANNED_AMOUNT_OF_BUDGET");
	static UI_Elements	LABEL_RESERVED_AMOUNT_OF_BUDGET		= UIFactory.getElements("LABEL_RESERVED_AMOUNT_OF_BUDGET");
	static UI_Elements	LINK_ACTIONS_FOR_BUDGET				= UIFactory.getElements("LINK_ACTIONS_FOR_BUDGET");
	static UI_Elements	LINK_ADD_BUDGET_PERIOD				= UIFactory.getElements("LINK_ADD_BUDGET_PERIOD");
	static UI_Elements	LINK_PERIOD_DETAILS					= UIFactory.getElements("LINK_PERIOD_DETAILS");
	static UI_Elements	LINK_DROP_DOWN_ALL_PERIODS			= UIFactory.getElements("LINK_DROP_DOWN_ALL_PERIODS");
	static UI_Elements	LINK_VIEW_BUDGET_ACTIONS			= UIFactory.getElements("LINK_VIEW_BUDGET_ACTIONS");
	static UI_Elements	LINK_DEACTIVE_BUDGET_ACTIONS		= UIFactory.getElements("LINK_DEACTIVE_BUDGET_ACTIONS");
	static UI_Elements	LINK_UPDATE_BUDGET_ACTIONS			= UIFactory.getElements("LINK_UPDATE_BUDGET_ACTIONS");
	static UI_Elements	LINK_ANALYZE_BUDGET_ACTIONS			= UIFactory.getElements("LINK_ANALYZE_BUDGET_ACTIONS");
	static UI_Elements	SUCCESS_MSG_DIV						= UIFactory.getElements("SUCCESS_MSG_DIV");
	static UI_Elements	PROCESSING_DIV_BUDGET_LISTING		= UIFactory.getElements("PROCESSING_DIV_BUDGET_LISTING");
	static UI_Elements	BUDGET_BUSINESS_UNIT_SEARCH_TEXTBOX	= UIFactory.getElements("BUDGET_BUSINESS_UNIT_SEARCH_TEXTBOX");
	static UI_Elements	FISRT_BUDGET_BU						= UIFactory.getElements("FISRT_BUDGET_BU");
	static UI_Elements	BUDGET_BU_RESERVED_AMOUNT			= UIFactory.getElements("BUDGET_BU_RESERVED_AMOUNT");
	static UI_Elements	FIRST_BUDGET_LINE_BALANCE_AMOUNT	= UIFactory.getElements("FIRST_BUDGET_LINE_BALANCE_AMOUNT");
	static UI_Elements	BUDGET_BUNIT_RESERVED_AMOUNT		= UIFactory.getElements("BUDGET_BUNIT_RESERVED_AMOUNT");

	public void clickOnAddBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException;

	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException;

	public void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatusOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddPeriod(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetNameOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCompanyOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOwnerOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPlannedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillSuccessMsgIsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBudgetBU(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public String getBudgetBUOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	/*
	 * author: bhakti.sawant
	 */
	public String getBudgetReservedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetBalanceAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException;

}
