package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsstatusapprovalfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalAllRequestsStatusApprovalFilter
{

	UI_Elements	PENDING_STATUS_FILTER				= UIFactory.getElements("PENDING_STATUS_FILTER");
	UI_Elements	APPROVED_STATUS_FILTER				= UIFactory.getElements("APPROVED_STATUS_FILTER");
	UI_Elements	REJECTED_STATUS_FILTER				= UIFactory.getElements("REJECTED_STATUS_FILTER");
	UI_Elements	DELEGATED_STATUS_FILTER				= UIFactory.getElements("DELEGATED_STATUS_FILTER");
	UI_Elements	URGENT_REQUESTS_ONLY_STATUS_FILTER	= UIFactory.getElements("URGENT_REQUESTS_ONLY_STATUS_FILTER");
	UI_Elements	PENDING_SINCE_FILTER				= UIFactory.getElements("PENDING_SINCE_FILTER");
	UI_Elements	PENDING_SINCE_DAYS_INPUT_TEXT		= UIFactory.getElements("PENDING_SINCE_DAYS_INPUT_TEXT");
	UI_Elements	STATUS_FILTER_BUTTON				= UIFactory.getElements("STATUS_FILTER_BUTTON");
	UI_Elements	CANCEL_BUTTON						= UIFactory.getElements("CANCEL_BUTTON");
	UI_Elements	CLEAR_FILTER_BUTTON					= UIFactory.getElements("CLEAR_FILTER_BUTTON");

	public boolean clickToApplyPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyUrgentRequestsOnlyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyPendingSinceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isApprovedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRejectedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDelegatedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUrgentRequestsOnlyStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPendingSinceStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public int fillPendingSinceDaysInput(WebDriver driver, String testCaseName, int pendingSinceDays) throws ActionBotException;

	public int getPendingSinceDaysInput(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
