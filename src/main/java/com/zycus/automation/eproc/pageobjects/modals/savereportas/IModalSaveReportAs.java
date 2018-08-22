/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.savereportas;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalSaveReportAs
{
	static UI_Elements	TEXTBOX_REPORT_NAME							= UIFactory.getElements("TEXTBOX_REPORT_NAME");
	static UI_Elements	SELECT_FOLDER_NAME							= UIFactory.getElements("SELECT_FOLDER_NAME");
	static UI_Elements	BUTTON_CREATE_NEW_FOLDER					= UIFactory.getElements("BUTTON_CREATE_NEW_FOLDER");
	static UI_Elements	CHECKBOX_SCHEDULE_REPORT					= UIFactory.getElements("CHECKBOX_SCHEDULE_REPORT");
	static UI_Elements	BUTTON_SAVE_REPORT_ON_SAVE_AS_REPORT_MODAL	= UIFactory.getElements("BUTTON_SAVE_REPORT_ON_SAVE_AS_REPORT_MODAL");
	static UI_Elements	BUTTON_CLOSE_SAVE_AS_REPORT_MODAL			= UIFactory.getElements("BUTTON_CLOSE_SAVE_AS_REPORT_MODAL");
	static UI_Elements	TEXTBOX_NEW_FOLDER_NAME						= UIFactory.getElements("TEXTBOX_NEW_FOLDER_NAME");

	public String fillReportName(WebDriver driver, String testCaseName, String reportName) throws ActionBotException;

	public String fillFolderName(WebDriver driver, String testCaseName, String folderName) throws ActionBotException;

	public void clickOnCreateNewFolder(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnScheduleReportCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnCloseSaveReportAsModal(WebDriver driver, String testCaseName) throws ActionBotException;

}
