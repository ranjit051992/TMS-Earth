/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewreportdetails;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageViewReportDetails
{
	static UI_Elements	BUTTON_REFRESH_REPORT				= UIFactory.getElements("BUTTON_REFRESH_REPORT");
	static UI_Elements	BUTTON_MODIFY_REPORT				= UIFactory.getElements("BUTTON_MODIFY_REPORT");
	static UI_Elements	BUTTON_FILTER_REPORT				= UIFactory.getElements("BUTTON_FILTER_REPORT");
	static UI_Elements	BUTTON_SAVE_AS_REPORT				= UIFactory.getElements("BUTTON_SAVE_AS_REPORT");
	static UI_Elements	LINK_EXPORT_REPORT					= UIFactory.getElements("LINK_EXPORT_REPORT");
	static UI_Elements	LINK_EXPORT_REPORT_IN_EXCEL			= UIFactory.getElements("LINK_EXPORT_REPORT_IN_EXCEL");
	static UI_Elements	LINK_EXPORT_REPORT_IN_PDF			= UIFactory.getElements("LINK_EXPORT_REPORT_IN_PDF");
	static UI_Elements	BUTTON_PRINT_REPORT					= UIFactory.getElements("BUTTON_PRINT_REPORT");
	static UI_Elements	BUTTON_CLOSE_REPORT					= UIFactory.getElements("BUTTON_CLOSE_REPORT");
	static UI_Elements	LOADING_DIV_VIEW_REPORT_DETAILS		= UIFactory.getElements("LOADING_DIV_VIEW_REPORT_DETAILS");
	static UI_Elements	LABEL_REPORT_SUMMARY_HEADER			= UIFactory.getElements("LABEL_REPORT_SUMMARY_HEADER");
	static UI_Elements	LABEL_REPORT_SUMMARY_ADDED_COLUMNS	= UIFactory.getElements("LABEL_REPORT_SUMMARY_ADDED_COLUMNS");
	static UI_Elements	LABEL_APPLIED_FILTER				= UIFactory.getElements("LABEL_APPLIED_FILTER");
	static UI_Elements	LABEL_REPORT_NAME_ON_HEADER			= UIFactory.getElements("LABEL_REPORT_NAME_ON_HEADER");
	static UI_Elements	BUTTON_SAVE_REPORT					= UIFactory.getElements("BUTTON_SAVE_REPORT");
	static UI_Elements	LINK_MORE_OPTIONS					= UIFactory.getElements("LINK_MORE_OPTIONS");
	static UI_Elements	LINK_SHARE_REPORTS					= UIFactory.getElements("LINK_SHARE_REPORTS");
	static UI_Elements	LINK_REVOKE_REPORTS					= UIFactory.getElements("LINK_REVOKE_REPORTS");
	static UI_Elements	LINK_DELETE_REPORTS					= UIFactory.getElements("LINK_DELETE_REPORTS");

	public String clickOnRefreshButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModifyButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnMoreOptionsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRevokeReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReportName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSummaryHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAppliedFilterInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getAddedColumnNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillPageIsLoading(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
