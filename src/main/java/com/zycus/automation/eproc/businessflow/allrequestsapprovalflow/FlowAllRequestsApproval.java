package com.zycus.automation.eproc.businessflow.allrequestsapprovalflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.bo.NewDiscussion;
import com.zycus.automation.eproc.businessflow.FactoryBusinessFlow;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class FlowAllRequestsApproval
{
	static Logger logger = Logger.getLogger(FlowAllRequestsApproval.class);

	public static ApprovalAllRequests searchInAllRequestsApprovalTab(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		ApprovalAllRequests allRequests = new ApprovalAllRequests();
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			allRequests = allRequestsApprovalImpl.searchInAllRequestsApprovalTab(driver, testCaseName, approvalAllRequests);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchInAllRequestsApprovalTab " + e, e);
		}
		return allRequests;
	}

	public static ApprovalAllRequests searchAndPerformActions(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		ApprovalAllRequests allRequests = new ApprovalAllRequests();
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			allRequests = allRequestsApprovalImpl.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchAndPerformActions " + e, e);
		}
		return allRequests;
	}

	public static ApprovalAllRequestsStatusFilter applyApprovalAllRequestsStatusFilter(WebDriver driver, String testCaseName,
		ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter) throws ActionBotException
	{
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			return allRequestsApprovalImpl.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method applyApprovalAllRequestsStatusFilter " + e, e);
		}
		return approvalAllRequestsStatusFilter;
	}

	public static ApprovalAllRequests searchInApprovalTab(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			return allRequestsApprovalImpl.searchInApprovalTab(driver, testCaseName, approvalAllRequests);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchInApprovalTab " + e, e);
		}
		return approvalAllRequests;
	}

	public static NewDiscussion fillNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException
	{
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			return allRequestsApprovalImpl.fillNewDiscussion(driver, testCaseName, newDiscussion);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillNewDiscussion " + e, e);
		}
		return null;
	}

	public static NewDiscussion startNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException

	{
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			return allRequestsApprovalImpl.startNewDiscussion(driver, testCaseName, newDiscussion);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method startNewDiscussion " + e, e);
		}
		return null;
	}

	public static ApprovalAllRequests performActionOnMultipleItems(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{

		ApprovalAllRequests allRequests = new ApprovalAllRequests();
		try
		{
			IFlowAllRequestsApprovalImpl allRequestsApprovalImpl = FactoryBusinessFlow.getInstanceOfIFlowAllRequestsApproval();
			allRequests = allRequestsApprovalImpl.performActionOnMultipleItems(driver, testCaseName, approvalAllRequests);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchInAllRequestsApprovalTab " + e, e);
		}
		return allRequests;

	}

	/*************************************
	 * Ignore below methods for time-being
	 ************************************************/

	public static boolean approveSingleRequisition(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException, FactoryMethodException
	{
		boolean flag_req_approval = false;
		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		PageAllRequestsApproval.enterReqNoFilter(driver, testCaseName, reqNumber);
		PageAllRequestsApproval.clickActionButton(driver, testCaseName);
		flag_req_approval = PageAllRequestsApproval.approveRequisition(driver, testCaseName);
		return flag_req_approval;
	}

	public static void toFilterOutRejectedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.clickOnStatusFilter(driver, testCaseName);
		PageAllRequestsApproval.clickRejectedStatusFilter(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
	}

	public static void toFilterOutApprovedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.clickOnStatusFilter(driver, testCaseName);
		PageAllRequestsApproval.clickApprovedStatusFilter(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
	}

	public static void toFilterOutPendingReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.clickOnStatusFilter(driver, testCaseName);
		PageAllRequestsApproval.clickPendingStatusFilter(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
	}

	public static void toFilterOutDelegatedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.clickOnStatusFilter(driver, testCaseName);
		PageAllRequestsApproval.clickDelegatedStatusFilter(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
	}

	public static void toApproveRequisitionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.clickOnActionsLinkIindexwise(driver, testCaseName, index);
		PageAllRequestsApproval.clickOnApproveLinkIndexwise(driver, testCaseName, index);
		PageAllRequestsApproval.fillApprovalComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
		PageAllRequestsApproval.clickApproveButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toSearchAndApproveRequisition(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException, InterruptedException
	{
		PageAllRequestsApproval.searchRequition(driver, testCaseName, reqNo);
		PageAllRequestsApproval.clickOnActionsLinkIindexwise(driver, testCaseName, 1);
		PageAllRequestsApproval.clickOnApproveLinkIndexwise(driver, testCaseName, 1);
		PageAllRequestsApproval.fillApprovalComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
		PageAllRequestsApproval.clickApproveButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void SearchAndClickRequisition(WebDriver driver, String testCaseName, String reqName)
	{
		try
		{
			ActionBot.defaultSleep();
			By reqNameSearchBox = By.xpath("//input[@placeholder='Search Name']");
			ActionBot.click(driver, reqNameSearchBox);
			ActionBot.defaultHighSleep();
			ActionBot.clear(driver, reqNameSearchBox);
			ActionBot.sendKeys(driver, reqNameSearchBox, reqName);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			ActionBot.defaultSleep();
			PageAllRequestsApproval.clickOnFirstRowApprovalDocumentNo(driver, testCaseName);
			ActionBot.defaultHighSleep();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
