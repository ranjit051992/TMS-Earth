/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreport;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreateReport
{
	static UI_Elements	BUTTON_NEXT_MODIFY_REPORT					= UIFactory.getElements("BUTTON_NEXT_MODIFY_REPORT");
	static UI_Elements	BUTTON_CANCEL_MODIFY_REPORT					= UIFactory.getElements("BUTTON_CANCEL_MODIFY_REPORT");
	static UI_Elements	BUTTON_RUN_REPORT							= UIFactory.getElements("BUTTON_RUN_REPORT");
	static UI_Elements	RADIO_BUTTON_TABULAR_REPORT					= UIFactory.getElements("RADIO_BUTTON_TABULAR_REPORT");
	static UI_Elements	RADIO_BUTTON_SUMMARY_REPORT					= UIFactory.getElements("RADIO_BUTTON_SUMMARY_REPORT");
	static UI_Elements	RADIO_BUTTON_MATRIX_REPORT					= UIFactory.getElements("RADIO_BUTTON_MATRIX_REPORT");
	static UI_Elements	RADIO_BUTTON_SHOW_ALL_GROUPS				= UIFactory.getElements("RADIO_BUTTON_SHOW_ALL_GROUPS");
	static UI_Elements	RADIO_BUTTON_SHOW_TOP_LEVEL_GROUPS			= UIFactory.getElements("RADIO_BUTTON_SHOW_TOP_LEVEL_GROUPS");
	static UI_Elements	BUTTON_BACK_MODIFY_REPORT					= UIFactory.getElements("BUTTON_BACK_MODIFY_REPORT");
	static UI_Elements	LIST_OF_CHECKBOX_COLUMN_GROUP1				= UIFactory.getElements("LIST_OF_CHECKBOX_COLUMN_GROUP1");
	static UI_Elements	LIST_OF_CHECKBOX_COLUMN_GROUP2				= UIFactory.getElements("LIST_OF_CHECKBOX_COLUMN_GROUP2");
	static UI_Elements	LIST_OF_CHECKBOX_COLUMN_GROUP3				= UIFactory.getElements("LIST_OF_CHECKBOX_COLUMN_GROUP3");
	static UI_Elements	LIST_OF_CHECKBOX_COLUMN_GROUP4				= UIFactory.getElements("LIST_OF_CHECKBOX_COLUMN_GROUP4");
	static UI_Elements	LIST_OF_CHECKBOX_COLUMN_GROUP5				= UIFactory.getElements("LIST_OF_CHECKBOX_COLUMN_GROUP5");
	static UI_Elements	LINK_SELECT_ALL_COLUMN						= UIFactory.getElements("LINK_SELECT_ALL_COLUMN");
	static UI_Elements	LINK_DESELECT_ALL_COLUMN					= UIFactory.getElements("LINK_DESELECT_ALL_COLUMN");
	static UI_Elements	CHECKBOX_SUMMARIZE_REPORT_BY_SUM			= UIFactory.getElements("CHECKBOX_SUMMARIZE_REPORT_BY_SUM");
	static UI_Elements	CHECKBOX_SUMMARIZE_REPORT_BY_AVERAGE		= UIFactory.getElements("CHECKBOX_SUMMARIZE_REPORT_BY_AVERAGE");
	static UI_Elements	CHECKBOX_SUMMARIZE_REPORT_BY_MAXIMUM_VALUE	= UIFactory.getElements("CHECKBOX_SUMMARIZE_REPORT_BY_MAXIMUM_VALUE");
	static UI_Elements	CHECKBOX_SUMMARIZE_REPORT_BY_MINIMUM_VALUE	= UIFactory.getElements("CHECKBOX_SUMMARIZE_REPORT_BY_MINIMUM_VALUE");
	static UI_Elements	BUTTON_ORDER_REPORT_COLUMN_TOP				= UIFactory.getElements("BUTTON_ORDER_REPORT_COLUMN_TOP");
	static UI_Elements	BUTTON_ORDER_REPORT_COLUMN_UP				= UIFactory.getElements("BUTTON_ORDER_REPORT_COLUMN_UP");
	static UI_Elements	BUTTON_ORDER_REPORT_COLUMN_DOWN				= UIFactory.getElements("BUTTON_ORDER_REPORT_COLUMN_DOWN");
	static UI_Elements	BUTTON_ORDER_REPORT_COLUMN_BOTTOM			= UIFactory.getElements("BUTTON_ORDER_REPORT_COLUMN_BOTTOM");
	static UI_Elements	SELECT_DURATION_FILTER_ON					= UIFactory.getElements("SELECT_DURATION_FILTER_ON");
	static UI_Elements	SELECT_PERIOD_DURATION_FILTER				= UIFactory.getElements("SELECT_PERIOD_DURATION_FILTER");
	static UI_Elements	TEXTBOX_DURATION_START_DATE					= UIFactory.getElements("TEXTBOX_DURATION_START_DATE");
	static UI_Elements	TEXTBOX_DURATION_END_DATE					= UIFactory.getElements("TEXTBOX_DURATION_END_DATE");
	static UI_Elements	DATE_PICKER_DURATION_START_DATE				= UIFactory.getElements("DATE_PICKER_DURATION_START_DATE");
	static UI_Elements	DATE_PICKER_DURATION_END_DATE				= UIFactory.getElements("DATE_PICKER_DURATION_END_DATE");
	static UI_Elements	SELECT_DURATION_MONTH						= UIFactory.getElements("SELECT_DURATION_MONTH");
	static UI_Elements	SELECT_DURATION_YEAR						= UIFactory.getElements("SELECT_DURATION_YEAR");
	static UI_Elements	RADIO_BUTTON_FILTER_MATCH_ALL_CONDITIONS	= UIFactory.getElements("RADIO_BUTTON_FILTER_MATCH_ALL_CONDITIONS");
	static UI_Elements	RADIO_BUTTON_FILTER_MATCH_ANY_CONDITIONS	= UIFactory.getElements("RADIO_BUTTON_FILTER_MATCH_ANY_CONDITIONS");
	static UI_Elements	SELECT_CHART_TYPE							= UIFactory.getElements("SELECT_CHART_TYPE");

	public void selectTabularReportType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSummaryReportType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectMatrixReportType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnRunReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void selectShowAllGroups(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectShowTopLevelGroups(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCloumnGroup1CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCloumnGroup2CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCloumnGroup3CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCloumnGroup4CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCloumnGroup5CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSummarizeReportBySum(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSummarizeReportByAverage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSummarizeReportByMaximumValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSummarizeReportByMinimumValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDurationFilterOn(WebDriver driver, String testCaseName, String durationFilterOn) throws ActionBotException;

	public String selectDurationFilterPeriod(WebDriver driver, String testCaseName, String period) throws ActionBotException;

	public void clickOnStartDatePicker(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEndDatePicker(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStartDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getEndDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectStartDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public void clickOnMatchAllConditions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMatchAnyOfConditions(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectChartType(WebDriver driver, String testCaseName, String chartType) throws ActionBotException;

	public boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedChartType(WebDriver driver, String testCaseName) throws ActionBotException;

}
