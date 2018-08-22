/**
 * 
 */
package com.zycus.automation.eproc.businessflow.allrequestsapprovalflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions.ModalAllRequestsApprovalActions;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove.ModalAllRequestsApprovalDocumentApprove;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate.ModalAllRequestsApprovalDocumentDelegate;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject.ModalAllRequestsApprovalDocumentReject;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode.PageApprovalDocumentViewMode;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IFlowAllRequestsApprovalUtilies
{
	static Logger logger = Logger.getLogger(IFlowAllRequestsApprovalUtilies.class);

	public static ApprovalAllRequests performApprove(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		int counter = 0;
		String doc = null, searchedDoc = null;
		List<String> docStatus = null;
		int index = 0;
		do
		{
			// approve the doc

			docStatus = PageAllRequestsApproval.getDocumentAllStatus(driver, testCaseName);
			index = docStatus.indexOf(IConstantsData.PENDING_FILTER_STATUS);

			if (index != -1)
			{
				if (approvalAllRequests.getDocumentNo() != null)
				{
					doc = approvalAllRequests.getDocumentNo();
					searchedDoc = (PageAllRequestsApproval.getListOfDocumentNos(driver, testCaseName).get(index)).getText().trim();
				}
				else if (approvalAllRequests.getDocumentName() != null)
				{
					doc = approvalAllRequests.getDocumentName();

					searchedDoc = PageAllRequestsApproval.getDocumentName(driver, testCaseName);
				}

				logger.info("Document : " + doc);
				logger.info("Searched Doc : " + searchedDoc);
				if (searchedDoc.contains(doc))
				{
					if (counter == 1)
					{
						approvalAllRequests = performApproveThroughToolTip(driver, testCaseName, approvalAllRequests, index);
					}
					else if (counter == 2)
					{
						approvalAllRequests = performApproveThroughDocumentViewPage(driver, testCaseName, approvalAllRequests, index);
					}
					else
					{
						approvalAllRequests = performApproveThroughActionsDropdown(driver, testCaseName, approvalAllRequests, index + 1);
					}
					counter = (counter + 1) % 3;
				}
			}
			else
			{
				break;
			}

			// changes made to handle subprocess workflow
			approvalAllRequests = FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);
		} while (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 0);

		logger.info("Document is approved " + counter + " times");
		approvalAllRequests.setResult(true);

		return approvalAllRequests;
	}

	public static ApprovalAllRequests performReject(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		// approve the doc
		PageAllRequestsApproval.clickOnActionsLink(driver, testCaseName);
		ModalAllRequestsApprovalActions.clickOnRejectOption(driver, testCaseName);

		// enter approval comments and approve it
		ModalAllRequestsApprovalDocumentReject.fillRejectComment(driver, testCaseName, IConstantsData.REJECT_COMMENT);
		ModalAllRequestsApprovalDocumentReject.clickOnRejectButton(driver, testCaseName);

		// PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);

		String status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
		approvalAllRequests.setResult(status.equalsIgnoreCase(IConstantsData.REJECTED_FILTER_LABEL));

		return approvalAllRequests;
	}

	public static ApprovalAllRequests performDelegate(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		// approve the doc
		PageAllRequestsApproval.clickOnActionsLink(driver, testCaseName);
		ModalAllRequestsApprovalActions.clickOnDelegateOption(driver, testCaseName);

		// delegation
		approvalAllRequests = delegateDocument(driver, testCaseName, approvalAllRequests);

		return approvalAllRequests;
	}

	public static boolean checkForApprovalStatusFilter(WebDriver driver, String testCaseName, ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter)
		throws ActionBotException
	{
		boolean statusFilterResult = false;
		int i = 0, totalReqCount = 0;
		String statusName, log = "";

		// list of status
		List<String> statusList = PageAllRequestsApproval.getListOfApprovalStatus(driver, testCaseName);
		totalReqCount = statusList.size();
		logger.info("After appying filter Total Requisition Count : " + totalReqCount);

		// list of status taken from ApprovalAllRequestsStatusFilter bo
		statusName = approvalAllRequestsStatusFilter.getStatusOfFilter();

		if (totalReqCount != 0)
		{
			for (String status : statusList)
			{
				if (status.equalsIgnoreCase(statusName))
				{
					log += status + "\n";
					i++;
					if (i == totalReqCount)
					{
						statusFilterResult = true;
						break;
					}
				}
			}
			logger.info("Status of Requisitions are : \n " + log);
		}
		else
		{
			statusFilterResult = true;
			logger.info("No requisition found");
		}

		return statusFilterResult;
	}

	public static ApprovalAllRequests performApproveThroughDocumentViewPage(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests, int index)
		throws ActionBotException
	{
		// enter approval comments and approve it
		ActionBot.click(driver, PageAllRequestsApproval.getListOfDocumentNos(driver, testCaseName).get(index));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
		PageApprovalDocumentViewMode.fillApprovalComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);
		PageApprovalDocumentViewMode.clickOnApproveButton(driver, testCaseName);
		PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);

		// to search again
		// FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName,
		// approvalAllRequests);
		return approvalAllRequests;
	}

	public static ApprovalAllRequests performApproveThroughToolTip(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests, int index)
		throws ActionBotException
	{
		PageAllRequestsApproval.clickOnApproveRequestOnToolTip(driver, testCaseName, index);
		// enter approval comments and approve it
		ModalAllRequestsApprovalDocumentApprove.fillApprovalComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);

		// to change approved amount for invoice approval
		if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.INVOICE))
		{
			String approvedAmount = ModalAllRequestsApprovalDocumentApprove.getApprovedAmount(driver, testCaseName);
			ModalAllRequestsApprovalDocumentApprove.fillApprovedAmount(driver, testCaseName, approvedAmount.substring(0, approvedAmount.length() - 2));
		}

		ModalAllRequestsApprovalDocumentApprove.clickOnApproveButton(driver, testCaseName);
		// PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);
		return approvalAllRequests;
	}

	public static ApprovalAllRequests performApproveThroughActionsDropdown(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests, int index)
		throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
		PageAllRequestsApproval.clickOnActionsLinkIindexwise(driver, testCaseName, index);
		ModalAllRequestsApprovalActions.clickOnApproveOption(driver, testCaseName);

		// to change approved amount for invoice approval
		if (approvalAllRequests.getDocumentType().equalsIgnoreCase(IConstantsData.INVOICE))
		{
			String approvedAmount = ModalAllRequestsApprovalDocumentApprove.getApprovedAmount(driver, testCaseName);
			ModalAllRequestsApprovalDocumentApprove.fillApprovedAmount(driver, testCaseName, approvedAmount.substring(0, approvedAmount.length() - 2));
		}

		// enter approval comments and approve it
		ModalAllRequestsApprovalDocumentApprove.fillApprovalComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);

		ModalAllRequestsApprovalDocumentApprove.clickOnApproveButton(driver, testCaseName);
		// PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);
		ActionBot.defaultSleep();
		return approvalAllRequests;
	}

	public static ApprovalAllRequests delegateDocument(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		// delegation
		ModalAllRequestsApprovalDocumentDelegate.fillDelegateToName(driver, testCaseName, approvalAllRequests.getDelegateTo());
		ModalAllRequestsApprovalDocumentDelegate.fillDelegateComments(driver, testCaseName, IConstantsData.DELEGATE_COMMENT);
		ModalAllRequestsApprovalDocumentDelegate.clickOnDelegateSaveButton(driver, testCaseName);

		// PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);

		approvalAllRequests.setResult(true);
		return approvalAllRequests;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search invoice by no <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param invoiceNo
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void searchInvoice(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		PageAllRequestsApproval.clickOnInvoiceNoFilterLink(driver, testCaseName);
		PageAllRequestsApproval.fillInvoiceNo(driver, testCaseName, invoiceNo);
		PageAllRequestsApproval.clickOnInvoiceNoFilterButton(driver, testCaseName);
		/*
		 * ModalInvoiceNoFilter.fillInvoiceNo(driver, testCaseName, invoiceNo);
		 * ModalInvoiceNoFilter.clickOnInvoiceNoFilterButton(driver,
		 * testCaseName);
		 */

	}

}
