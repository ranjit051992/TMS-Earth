/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deletereport;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalDeleteReport
{
	static UI_Elements	BUTTON_DELETE_REPORT				= UIFactory.getElements("BUTTON_DELETE_REPORT");
	static UI_Elements	BUTTON_CLOSE_DELETE_REPORT_MODAL	= UIFactory.getElements("BUTTON_CLOSE_DELETE_REPORT_MODAL");

	public void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseDeleteReportModal(WebDriver driver, String testCaseName) throws ActionBotException;
}
