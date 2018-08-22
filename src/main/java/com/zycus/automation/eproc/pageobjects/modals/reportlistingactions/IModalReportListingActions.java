/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.reportlistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalReportListingActions
{
	static UI_Elements	LINK_VIEW_REPORT_DETAILS_ACTIONS		= UIFactory.getElements("LINK_VIEW_REPORT_DETAILS_ACTIONS");
	static UI_Elements	LINK_SHARE_REPORT_ACTIONS				= UIFactory.getElements("LINK_SHARE_REPORT_ACTIONS");
	static UI_Elements	LINK_DELETE_REPORT_ACTIONS				= UIFactory.getElements("LINK_DELETE_REPORT_ACTIONS");
	static UI_Elements	LINK_SHARE_REPORT_ACTIONS_AFTER_SHARING	= UIFactory.getElements("LINK_SHARE_REPORT_ACTIONS_AFTER_SHARING");

	public void clickOnViewReportDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShareReportLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShareReportLinkToShareAgain(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteReportLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
