/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.sharereport;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageShareReport
{
	static UI_Elements	LABEL_EMAIL_ID_OF_SELECTED_USER		= UIFactory.getElements("LABEL_EMAIL_ID_OF_SELECTED_USER");
	static UI_Elements	BUTTON_SHARE_REPORT					= UIFactory.getElements("BUTTON_SHARE_REPORT");
	static UI_Elements	BUTTON_REMOVE_ALL_SELECTED_USERS	= UIFactory.getElements("BUTTON_REMOVE_ALL_SELECTED_USERS");
	static UI_Elements	LINK_BACK_TO_REPORT_LISTING			= UIFactory.getElements("LINK_BACK_TO_REPORT_LISTING");

	public String selectUserForSharingReport(WebDriver driver, String testCaseName, String emailId) throws ActionBotException;

	public String getEmailIdOfSelectedUser(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveAllSelectedUsersButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSharedWithIconPresent(WebDriver driver, String testCaseName, String sharedWith) throws ActionBotException;

	public void clickOnBackToReportListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;
}
