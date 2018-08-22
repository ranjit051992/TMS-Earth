package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsstatusapprovalfilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApproval;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalAllRequestsStatusApprovalFilterImpl implements IModalAllRequestsStatusApprovalFilter
{

	Logger logger = Logger.getLogger(IModalAllRequestsStatusApprovalFilterImpl.class);

	@Override
	public boolean clickToApplyPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PENDING_STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting pending status filter");
		return ActionBot.isElementSelected(driver, PENDING_STATUS_FILTER);

	}

	@Override
	public boolean clickToApplyApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, APPROVED_STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting approved status filter");
		return ActionBot.isElementSelected(driver, APPROVED_STATUS_FILTER);
	}

	@Override
	public boolean clickToApplyRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECTED_STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting rejected status filter");
		return ActionBot.isElementSelected(driver, REJECTED_STATUS_FILTER);
	}

	@Override
	public boolean clickToApplyDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELEGATED_STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting delegated status filter");
		return ActionBot.isElementSelected(driver, DELEGATED_STATUS_FILTER);
	}

	@Override
	public boolean clickToApplyUrgentRequestsOnlyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, URGENT_REQUESTS_ONLY_STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting Urgent Requestes Only Status filter");
		return ActionBot.isElementSelected(driver, URGENT_REQUESTS_ONLY_STATUS_FILTER);
	}

	@Override
	public boolean clickToApplyPendingSinceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PENDING_SINCE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After selecting Pending Since Status filter");
		return ActionBot.isElementSelected(driver, PENDING_SINCE_FILTER);
	}

	@Override
	public boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Pending Status filter");
		return ActionBot.isElementSelected(driver, PENDING_STATUS_FILTER);
	}

	@Override
	public boolean isApprovedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Approved Status filter");
		return ActionBot.isElementSelected(driver, APPROVED_STATUS_FILTER);
	}

	@Override
	public boolean isRejectedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Rejected Status filter");
		return ActionBot.isElementSelected(driver, REJECTED_STATUS_FILTER);
	}

	@Override
	public boolean isDelegatedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Delegated Status filter");
		return ActionBot.isElementSelected(driver, DELEGATED_STATUS_FILTER);
	}

	@Override
	public boolean isUrgentRequestsOnlyStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Urgent Requests Only Status filter");
		return ActionBot.isElementSelected(driver, URGENT_REQUESTS_ONLY_STATUS_FILTER);
	}

	@Override
	public boolean isPendingSinceStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Pending Since Status filter");
		return ActionBot.isElementSelected(driver, PENDING_SINCE_FILTER);
	}

	@Override
	public int fillPendingSinceDaysInput(WebDriver driver, String testCaseName, int pendingSinceDays) throws ActionBotException
	{
		String pendingSince_days = Integer.toString(pendingSinceDays);
		ActionBot.sendKeys(driver, PENDING_SINCE_DAYS_INPUT_TEXT, pendingSince_days);

		ScreenShot.screenshot(driver, testCaseName, "After filling Pending since days input");
		pendingSince_days = ActionBot.findElement(driver, PENDING_SINCE_DAYS_INPUT_TEXT).getAttribute("value");
		logger.info("Pending since days input : " + pendingSince_days);

		return Integer.parseInt(pendingSince_days);

	}

	@Override
	public int getPendingSinceDaysInput(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After filling Pending since days input");
		String pendingSince_days = ActionBot.findElement(driver, PENDING_SINCE_DAYS_INPUT_TEXT).getAttribute("value");
		logger.info("Pending since days input : " + pendingSince_days);

		return Integer.parseInt(pendingSince_days);
	}

	@Override
	public void clickOnApplyStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, STATUS_FILTER_BUTTON);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, IPageAllRequestsApproval.APPROVAL_PROCESSING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Apply Status Filter Button");
	}

	@Override
	public void clickOnCancelStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

	@Override
	public void clickOnClearStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_FILTER_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Clear Status Button");
	}

}
