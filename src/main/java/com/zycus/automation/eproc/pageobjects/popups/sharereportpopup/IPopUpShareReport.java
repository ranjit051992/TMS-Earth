/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.sharereportpopup;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpShareReport
{
	static UI_Elements	BUTTON_GO_TO_REPORT					= UIFactory.getElements("BUTTON_GO_TO_REPORT");
	static UI_Elements	BUTTON_STAY_ON_SHARE_PAGE			= UIFactory.getElements("BUTTON_STAY_ON_SHARE_PAGE");
	static UI_Elements	LABEL_SHARE_REPORT_SUCCESS_MESSAGE	= UIFactory.getElements("LABEL_SHARE_REPORT_SUCCESS_MESSAGE");

	public void clickOnGoToReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnStayOnSharePage(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getShareReportSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException;
}
