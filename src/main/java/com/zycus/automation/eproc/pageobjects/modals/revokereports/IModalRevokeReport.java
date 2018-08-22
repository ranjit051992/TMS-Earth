/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.revokereports;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRevokeReport
{
	UI_Elements BUTTON_CLOSE_REVOKE_REPORT_MODAL = UIFactory.getElements("BUTTON_CLOSE_REVOKE_REPORT_MODAL");

	public boolean selectUserToRevokeReport(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException;

	public void clickOnRevokeReportButton(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException;

	public void clickOnCloseRevokeReportModalButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
