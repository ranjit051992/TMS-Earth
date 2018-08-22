/**
 * 
 */
package com.zycus.automation.eproc.businessflow.allrequestsapprovalflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.bo.NewDiscussion;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public interface IFlowAllRequestsApproval
{
	public ApprovalAllRequests searchInAllRequestsApprovalTab(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException;

	public ApprovalAllRequests searchAndPerformActions(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException;

	public ApprovalAllRequestsStatusFilter applyApprovalAllRequestsStatusFilter(WebDriver driver, String testCaseName,
		ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter) throws ActionBotException;

	public NewDiscussion fillNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException;

	public NewDiscussion startNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException;

	public ApprovalAllRequests performActionOnMultipleItems(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException;

}
