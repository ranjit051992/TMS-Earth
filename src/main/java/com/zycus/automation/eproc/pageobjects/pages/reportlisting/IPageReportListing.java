/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.reportlisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageReportListing
{
	static UI_Elements	SELECT_SEARCH_REPORT_BY							= UIFactory.getElements("SELECT_SEARCH_REPORT_BY");
	static UI_Elements	TEXTBOX_SEARCH_REPORT							= UIFactory.getElements("TEXTBOX_SEARCH_REPORT");
	static UI_Elements	BUTTON_SEARCH_REPORT							= UIFactory.getElements("BUTTON_SEARCH_REPORT");
	static UI_Elements	LINK_FIRST_REPORT_NAME_IN_REPORT_LISTING_TABLE	= UIFactory.getElements("LINK_FIRST_REPORT_NAME_IN_REPORT_LISTING_TABLE");
	static UI_Elements	LABEL_NO_REPORTS_FOUND							= UIFactory.getElements("LABEL_NO_REPORTS_FOUND");
	static UI_Elements	LINK_REPORTS_ACTIONS							= UIFactory.getElements("LINK_REPORTS_ACTIONS");
	static UI_Elements	LABEL_FOLDER_NAME_ON_REPORT_LISTING				= UIFactory.getElements("LABEL_FOLDER_NAME_ON_REPORT_LISTING");

	static UI_Elements	LABEL_LAST_REFRESH_ON_REPORT_LISTING			= UIFactory.getElements("LABEL_LAST_REFRESH_ON_REPORT_LISTING");

	public String selectSearchReportBy(WebDriver driver, String testCaseName, String searchReportBy) throws ActionBotException;

	public String fillSearchReportName(WebDriver driver, String testCaseName, String reportToBeSearch) throws ActionBotException;

	public String getFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSearchReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstReportActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReportNotFoundLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteFolderIcon(WebDriver driver, String testCaseName, String folderName) throws ActionBotException;

	public String getFirstFolderNameInReportListing(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstLastRefreshOnInReportListing(WebDriver driver, String testCaseName) throws ActionBotException;

}
