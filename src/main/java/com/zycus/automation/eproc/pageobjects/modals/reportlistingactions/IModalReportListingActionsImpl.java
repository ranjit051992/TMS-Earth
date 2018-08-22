/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.reportlistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalReportListingActionsImpl implements IModalReportListingActions
{

	@Override
	public void clickOnViewReportDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_REPORT_DETAILS_ACTIONS);
	}

	@Override
	public void clickOnShareReportLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SHARE_REPORT_ACTIONS);
	}

	@Override
	public void clickOnDeleteReportLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, LINK_DELETE_REPORT_ACTIONS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnShareReportLinkToShareAgain(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SHARE_REPORT_ACTIONS_AFTER_SHARING);
	}

}
