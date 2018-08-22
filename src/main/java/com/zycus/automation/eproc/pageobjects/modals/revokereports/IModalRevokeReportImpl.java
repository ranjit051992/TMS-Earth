/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.revokereports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalRevokeReportImpl implements IModalRevokeReport
{

	@Override
	public boolean selectUserToRevokeReport(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//table[@id='dataTable_RMS']/tbody[@id='alreadyShareduserData']/tr[@id='" + userEmailId + "']//input"));

		return ActionBot.isElementSelected(driver, By.xpath(".//table[@id='dataTable_RMS']/tbody[@id='alreadyShareduserData']/tr[@id='" + userEmailId + "']//input"));
	}

	@Override
	public void clickOnRevokeReportButton(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on revoke report button");
		ActionBot.click(driver,
			By.xpath(".//table[@id='dataTable_RMS']/tbody[@id='alreadyShareduserData']/tr[@id='" + userEmailId + "']//a[contains(@class,'revokeSingle revokReport_RMS')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on revoke report button");
	}

	@Override
	public void clickOnCloseRevokeReportModalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close revoke report button");
		ActionBot.click(driver, BUTTON_CLOSE_REVOKE_REPORT_MODAL);
		ActionBot.defaultSleep();
	}

}
