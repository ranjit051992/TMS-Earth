/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deletereport;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalDeleteReportImpl implements IModalDeleteReport
{

	@Override
	public void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on delete button");
		ActionBot.focusAndclick(driver, BUTTON_DELETE_REPORT);
		ActionBot.defaultSleep();
		// ScreenShot.screenshot(driver, testCaseName, "After clicking on delete
		// button");
	}

	@Override
	public void clickOnCloseDeleteReportModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close delete report modal");
		ActionBot.click(driver, BUTTON_CLOSE_DELETE_REPORT_MODAL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close delete report modal");
	}

}
