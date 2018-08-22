/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAllRequestsApprovalActionsImpl implements IModalAllRequestsApprovalActions
{

	@Override
	public void clickOnViewOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_VIEW_OPTION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on View Option");
	}

	@Override
	public void clickOnApproveOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_APPROVE_OPTION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Approve Option");
	}

	@Override
	public void clickOnRejectOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_REJECT_OPTION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Reject Option");
	}

	@Override
	public void clickOnDelegateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_DELEGATE_OPTION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delegate Option");
	}

	@Override
	public void clickOnMoreInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_MORE_INFO_OPTION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on More Info Option");
	}

	@Override
	public void clickOnApproveOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVE_ACTION_FOR_MULTIPLE_DOC);
	}

	@Override
	public void clickOnRejectOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REJECT_ACTION_FOR_MULTIPLE_DOC);
	}

	@Override
	public void clickOnDelegateOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELEGATE_ACTION_FOR_MULTIPLE_DOC);
	}

}
