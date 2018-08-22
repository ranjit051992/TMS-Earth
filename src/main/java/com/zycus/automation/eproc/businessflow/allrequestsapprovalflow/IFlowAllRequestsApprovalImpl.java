/**
 * 
 */
package com.zycus.automation.eproc.businessflow.allrequestsapprovalflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.bo.NewDiscussion;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions.ModalAllRequestsApprovalActions;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsstatusapprovalfilter.ModalAllRequestsStatusApprovalFilter;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove.ModalAllRequestsApprovalDocumentApprove;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate.ModalAllRequestsApprovalDocumentDelegate;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject.ModalAllRequestsApprovalDocumentReject;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.newdiscussion.ModalNewDiscussion;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IFlowAllRequestsApprovalImpl implements IFlowAllRequestsApproval
{

	static Logger logger = Logger.getLogger(IFlowAllRequestsApprovalImpl.class);

	@Override
	public ApprovalAllRequests searchAndPerformActions(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		approvalAllRequests = searchInAllRequestsApprovalTab(driver, testCaseName, approvalAllRequests);
		// assertTrue("Document is not searched in approval tab",
		// approvalAllRequests.isResult());
		if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.APPROVE))
		{
			return performApprove(driver, testCaseName, approvalAllRequests);
		}
		if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.REJECT))
		{
			return performReject(driver, testCaseName, approvalAllRequests);
		}
		if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.DELEGATE))
		{
			return performDelegate(driver, testCaseName, approvalAllRequests);
		}
		if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.PURCHASE_ORDER))
		{
			try
			{
				Thread.sleep(120000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return approvalAllRequests;

	}

	@Override
	public ApprovalAllRequests searchInAllRequestsApprovalTab(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		// click on all requests tab
		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);

		return searchInApprovalTab(driver, testCaseName, approvalAllRequests);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To search in Approval All Requests
	 * Tab </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param approvalAllRequests </font><b><br>
	 * @return ApprovalAllRequests </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public ApprovalAllRequests searchInApprovalTab(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		if (approvalAllRequests.getDocumentType() != null)
		{
			if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.PURCHASE_ORDER))
			{
				PageAllRequestsApproval.clickOnPurchaseOrderTab(driver, testCaseName);
			}
			else if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.INVOICE))
			{
				if (!PageAllRequestsApproval.isInvoiceNoFilterLinkPresent(driver, testCaseName))
				{
					PageAllRequestsApproval.clickOnInvoiceApprovalLink(driver, testCaseName);
				}
			}
			else if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.BPO))
			{
				PageAllRequestsApproval.clickOnBPOTab(driver, testCaseName);
			}
			else if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.CATALOG))
			{
				PageAllRequestsApproval.clickOnCatalogTab(driver, testCaseName);
			}
		}

		//changes made to handle if one of the approval is auto approved
		ActionBot.refreshPage(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		PageAllRequestsApproval.clickOnClearApprovalStatusFilterButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();

		// search using doc name
		if (approvalAllRequests.getDocumentName() != null)
		{
			PageAllRequestsApproval.clickOnClearApprovalNameFilterButton(driver, testCaseName);
			PageAllRequestsApproval.fillDocumentName(driver, testCaseName, approvalAllRequests.getDocumentName());
			// ActionBot.defaultMediumSleep();
			ActionBot.waitForPageLoad(driver);
			if (PageAllRequestsApproval.getListOfApprovalStatus(driver, testCaseName).size() != 1)
			{
				// ActionBot.defaultMediumSleep();
				ActionBot.waitForPageLoad(driver);
			}
			PageAllRequestsApproval.waitTillAllRequestsGridLoads(driver, testCaseName);
			// ActionBot.defaultMediumSleep();

			String searchedDocName = PageAllRequestsApproval.getFirstRowDocumentName(driver, testCaseName);
			if (searchedDocName != null)
			{
				approvalAllRequests.setResult(searchedDocName.contains(approvalAllRequests.getDocumentName().trim()));
			}
			return approvalAllRequests;
		}

		// search using doc no
		if (approvalAllRequests.getDocumentNo() != null)
		{
			PageAllRequestsApproval.clickOnClearApprovalNumberFilterButton(driver, testCaseName);
			if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.INVOICE))
			{
				IFlowAllRequestsApprovalUtilies.searchInvoice(driver, testCaseName, approvalAllRequests.getDocumentNo());
			}
			else
			{
				PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, approvalAllRequests.getDocumentNo());
			}
			if (PageAllRequestsApproval.getListOfApprovalStatus(driver, testCaseName).size() != 1)
			{
				// ActionBot.defaultMediumSleep();
				ActionBot.waitForPageLoad(driver);
			}

			PageAllRequestsApproval.waitTillAllRequestsGridLoads(driver, testCaseName);

			String searchedDocNo = PageAllRequestsApproval.getFirstRowDocumentNo(driver, testCaseName);
			if (searchedDocNo != null)
			{
				approvalAllRequests.setResult(searchedDocNo.equalsIgnoreCase(approvalAllRequests.getDocumentNo().trim()));
			}
			return approvalAllRequests;
		}

		// search using initiator
		if (approvalAllRequests.getInitiatorName() != null)
		{
			PageAllRequestsApproval.fillInitiatorName(driver, testCaseName, approvalAllRequests.getInitiatorName().trim());
			if (PageAllRequestsApproval.getListOfApprovalStatus(driver, testCaseName).size() != 1)
			{
				// ActionBot.defaultMediumSleep();
				ActionBot.waitForPageLoad(driver);
			}

			PageAllRequestsApproval.waitTillAllRequestsGridLoads(driver, testCaseName);

			String searchedInitiatorName = PageAllRequestsApproval.getFirstRowInitiatorName(driver, testCaseName);
			if (searchedInitiatorName != null)
			{
				approvalAllRequests.setResult(searchedInitiatorName.equalsIgnoreCase(approvalAllRequests.getInitiatorName().trim()));
			}
			return approvalAllRequests;
		}

		/*
		 * try { Thread.sleep(50 * 1000); } catch (InterruptedException e) {
		 * logger.info("Exception in sleep method"); }
		 */

		return approvalAllRequests;
	}

	private ApprovalAllRequests performApprove(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		return IFlowAllRequestsApprovalUtilies.performApprove(driver, testCaseName, approvalAllRequests);
	}

	private ApprovalAllRequests performReject(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		return IFlowAllRequestsApprovalUtilies.performReject(driver, testCaseName, approvalAllRequests);
	}

	private ApprovalAllRequests performDelegate(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		IFlowAllRequestsApprovalUtilies.performDelegate(driver, testCaseName, approvalAllRequests);
		searchInApprovalTab(driver, testCaseName, approvalAllRequests);
		String finalStatus = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
		approvalAllRequests.setResult(finalStatus.equalsIgnoreCase(IConstantsData.DELEGATED_FILTER_STATUS));
		return approvalAllRequests;
	}

	@Override
	public ApprovalAllRequestsStatusFilter applyApprovalAllRequestsStatusFilter(WebDriver driver, String testCaseName,
		ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter) throws ActionBotException
	{

		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		PageAllRequestsApproval.clickOnClearApprovalStatusFilterButton(driver, testCaseName);
		PageAllRequestsApproval.clickOnStatusFilter(driver, testCaseName);

		if (approvalAllRequestsStatusFilter.isPending())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyPendingStatusFilter(driver, testCaseName);
		}
		else if (approvalAllRequestsStatusFilter.isApproved())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyApprovedStatusFilter(driver, testCaseName);
		}
		else if (approvalAllRequestsStatusFilter.isRejected())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyRejectedStatusFilter(driver, testCaseName);
		}
		else if (approvalAllRequestsStatusFilter.isDelegated())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyDelegatedStatusFilter(driver, testCaseName);
		}
		else if (approvalAllRequestsStatusFilter.isUrgentRequestsOnly())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyUrgentRequestsOnlyStatusFilter(driver, testCaseName);
		}
		else if (approvalAllRequestsStatusFilter.isPendingSince())
		{
			ModalAllRequestsStatusApprovalFilter.clickToApplyPendingSinceStatusFilter(driver, testCaseName);
			ModalAllRequestsStatusApprovalFilter.fillPendingSinceDaysInput(driver, testCaseName, approvalAllRequestsStatusFilter.getPendingSinceDays());
		}
		else
		{
			logger.info("Invalid filter is selected");
		}

		ModalAllRequestsStatusApprovalFilter.clickOnApplyStatusFilterButton(driver, testCaseName);

		approvalAllRequestsStatusFilter.setResult(IFlowAllRequestsApprovalUtilies.checkForApprovalStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter));
		return approvalAllRequestsStatusFilter;
	}

	@Override
	public NewDiscussion fillNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException
	{
		if (newDiscussion.getTo() != null)
		{
			newDiscussion.setTo(ModalNewDiscussion.fillToFieldForNewDiscussion(driver, testCaseName, newDiscussion.getTo()));
		}
		if (newDiscussion.getMessage() != null)
		{
			newDiscussion.setMessage(ModalNewDiscussion.fillMessageForNewDiscussion(driver, testCaseName, newDiscussion.getMessage()));
		}

		if (newDiscussion.isSharedWithAll())
		{
			ModalNewDiscussion.selectAllOptionForSharedWith(driver, testCaseName);
		}
		else
		{
			if (newDiscussion.isSharedWithRequester())
			{
				ModalNewDiscussion.selectRequesterOptionForSharedWith(driver, testCaseName);
			}
			if (newDiscussion.isSharedWithApprover())
			{
				ModalNewDiscussion.selectApproverOptionForSharedWith(driver, testCaseName);
			}
			if (newDiscussion.isSharedWithBuyer())
			{
				ModalNewDiscussion.selectBuyerOptionForSharedWith(driver, testCaseName);
			}
		}

		if (newDiscussion.getFileName() != null)
		{
			ModalNewDiscussion.fillAttachmentFileName(driver, testCaseName, newDiscussion.getFileName());
		}
		return newDiscussion;
	}

	@Override
	public NewDiscussion startNewDiscussion(WebDriver driver, String testCaseName, NewDiscussion newDiscussion) throws ActionBotException
	{
		PageAllRequestsApproval.clickOnActionsLink(driver, testCaseName);
		ModalAllRequestsApprovalActions.clickOnMoreInfoOption(driver, testCaseName);

		NewDiscussion newDiscussion2 = fillNewDiscussion(driver, testCaseName, newDiscussion);

		if (newDiscussion.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT))
		{
			ModalNewDiscussion.clickOnSubmitButton(driver, testCaseName);
		}
		if (newDiscussion.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalNewDiscussion.clickOnCancelButton(driver, testCaseName);
		}
		return newDiscussion2;
	}

	@Override
	public ApprovalAllRequests performActionOnMultipleItems(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{

		ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter = new ApprovalAllRequestsStatusFilter();
		approvalAllRequestsStatusFilter.setPending(true);

		applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

		ActionBot.defaultSleep();

		if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.APPROVE))
		{
			approvalAllRequests.setResult(ModalAllRequestsApprovalDocumentApprove.approveMultipleItems(driver, testCaseName));
		}
		else if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.REJECT))
		{
			approvalAllRequests.setResult(ModalAllRequestsApprovalDocumentReject.rejectMultipleItems(driver, testCaseName));
		}
		else if (approvalAllRequests.getActions().equalsIgnoreCase(IConstantsData.DELEGATE))
		{
			approvalAllRequests.setResult(ModalAllRequestsApprovalDocumentDelegate.delegateMultipleItems(driver, testCaseName));
		}
		else
		{
			logger.info("Incorrect option provided.");
		}

		return approvalAllRequests;
	}

}
