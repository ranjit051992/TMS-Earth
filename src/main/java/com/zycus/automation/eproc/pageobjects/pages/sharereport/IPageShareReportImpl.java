/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.sharereport;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageShareReportImpl implements IPageShareReport
{
	static Logger logger = Logger.getLogger(IPageShareReportImpl.class);

	@Override
	public String selectUserForSharingReport(WebDriver driver, String testCaseName, String emailId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//table[@class='shareListTable_RMS']//tr[.//*[contains(text(),'" + emailId + "')]]/td[1]/input"));
		return emailId;
	}

	@Override
	public String getEmailIdOfSelectedUser(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String emailId = ActionBot.getTextWithInElement(driver, LABEL_EMAIL_ID_OF_SELECTED_USER);
		logger.info("Email id of selected user : " + emailId);
		return emailId;
	}

	@Override
	public void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before sharing report");
		ActionBot.click(driver, BUTTON_SHARE_REPORT);
		ScreenShot.screenshot(driver, testCaseName, "After sharing report");
	}

	@Override
	public void clickOnRemoveAllSelectedUsersButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_REMOVE_ALL_SELECTED_USERS);
	}

	@Override
	public boolean isSharedWithIconPresent(WebDriver driver, String testCaseName, String sharedWith) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "Report shared or not");
		return ActionBot.isElementPresent(driver,
			By.xpath(".//*[@id='shareDashList']//tr[.//*[contains(text(),'" + sharedWith + "')]]/td[4]/label[contains(@class,'shareReports_RMS')]"));
	}

	@Override
	public void clickOnBackToReportListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on back to report listing");
		ActionBot.click(driver, LINK_BACK_TO_REPORT_LISTING);
		PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on back to report listing");
	}

}
