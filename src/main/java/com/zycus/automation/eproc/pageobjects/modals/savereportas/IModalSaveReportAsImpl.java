/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.savereportas;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalSaveReportAsImpl implements IModalSaveReportAs
{
	static Logger logger = Logger.getLogger(IModalSaveReportAsImpl.class);

	@Override
	public String fillReportName(WebDriver driver, String testCaseName, String reportName) throws ActionBotException
	{
		String enteredReportName = ActionBot.sendKeys(driver, TEXTBOX_REPORT_NAME, reportName);
		logger.info("Entered report name : " + enteredReportName);
		return enteredReportName;
	}

	@Override
	public String fillFolderName(WebDriver driver, String testCaseName, String folderName) throws ActionBotException
	{
		String enteredFolderName = ActionBot.sendKeys(driver, TEXTBOX_NEW_FOLDER_NAME, folderName);
		logger.info("Entered folder name : " + enteredFolderName);
		return enteredFolderName;
	}

	@Override
	public void clickOnCreateNewFolder(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_NEW_FOLDER);
	}

	@Override
	public void clickOnScheduleReportCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SCHEDULE_REPORT);
	}

	@Override
	public void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save report button");
		ActionBot.click(driver, BUTTON_SAVE_REPORT_ON_SAVE_AS_REPORT_MODAL);
		ActionBot.defaultSleep();
		// PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		// ScreenShot.screenshot(driver, testCaseName, "After clicking on save
		// report button");
	}

	@Override
	public void clickOnCloseSaveReportAsModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close report button");
		ActionBot.click(driver, BUTTON_CLOSE_SAVE_AS_REPORT_MODAL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close report button");
	}

}
