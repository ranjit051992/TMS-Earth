/**
 * 
 */
package com.zycus.automation.eproc.businessflow.receiptflow;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.pageobjects.modals.cancelreceipt.ModalCancelReceipt;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.pages.createreceipt.PageCreateReceipt;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.IPageReceiptListing;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.PageReceiptListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowReceipt
{
	static Logger logger = Logger.getLogger(FlowReceipt.class);

	public static Receipt createReceiptFromStandardPO(WebDriver driver, String testCaseName, Receipt receipt) throws Exception
	{
		boolean flag = false;
		String url = driver.getCurrentUrl();

		receipt.setStandardPO(FlowStandardPo.createStandardPo(driver, testCaseName, receipt.getStandardPO()));
		driver.navigate().refresh();
		ActionBot.defaultSleep();
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		driver.get(url);
		// search po
		flag = FlowPoListing.searchPo(driver, testCaseName, receipt.getStandardPO().getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		// to approve the PO
		ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
		approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, receipt.getStandardPO().getPoNumber(), IConstantsData.PURCHASE_ORDER,
			IConstantsData.APPROVE);

		/*
		 * approvalAllRequests.setDocumentNo(receipt.getStandardPO().getPoNumber
		 * ()); approvalAllRequests.setActions(IConstantsData.APPROVE);
		 * approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
		 */
		FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

		// search po
		flag = FlowPoListing.searchPo(driver, testCaseName, receipt.getStandardPO().getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		// to create receipt
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

		// fill receipt form
		receipt.setReceiptComment(PageCreateReceipt.fillReceiptComments(driver, testCaseName, receipt.getReceiptComment()));
		PageCreateReceipt.clickOnSelectAllReceiptItems(driver, testCaseName);

		PageCreateReceipt.selectRatingForItem(driver, testCaseName, "1", "2");

		PageCreateReceipt.fillReceivedQuantityForItem(driver, testCaseName, "1", 2);

		if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_INVOICE))
		{
			submitReceipt(driver, testCaseName);
		}
		else if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_INVOICE))
		{
			PageCreateReceipt.clickOnSaveReceiptAsDraftButton(driver, testCaseName);
		}
		else if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateReceipt.clickOnCancelReceiptButton(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid Option");
		}

		ActionBot.defaultMediumSleep();
		receipt.setReceiptNo(PageReceiptListing.getFirstReceiptNo(driver, testCaseName));
		receipt.setStatus(PageReceiptListing.getFirstReceiptStatus(driver, testCaseName));
		return receipt;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create receipt <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param receipt </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static Receipt createReceipt(WebDriver driver, String testCaseName, Receipt receipt) throws ActionBotException
	{
		// fill receipt form
		if (receipt.getReceiptComment() != null)
		{
			receipt.setReceiptComment(PageCreateReceipt.fillReceiptComments(driver, testCaseName, receipt.getReceiptComment()));
		}
		else
		{
			receipt.setReceiptComment(PageCreateReceipt.fillReceiptComments(driver, testCaseName, null));
		}
		PageCreateReceipt.clickOnSelectAllReceiptItems(driver, testCaseName);

		PageCreateReceipt.selectRatingForItem(driver, testCaseName, "1", "2");

		if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_INVOICE))
		{
			submitReceipt(driver, testCaseName);
		}
		else if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_INVOICE)) 
		{
			PageCreateReceipt.clickOnSaveReceiptAsDraftButton(driver, testCaseName);
		}
		else if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateReceipt.clickOnCancelReceiptButton(driver, testCaseName);
		}
		else if (receipt.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("Action was set as None");
			return receipt;
		}
		else
		{
			logger.info("Invalid Option" + receipt.getNextAction());
		}

		ActionBot.defaultMediumSleep();
		ActionBot.defaultSleep();
		receipt.setReceiptNo(PageReceiptListing.getFirstReceiptNo(driver, testCaseName));
		receipt.setStatus(PageReceiptListing.getFirstReceiptStatus(driver, testCaseName));
		return receipt;
	}

	public static boolean cancelReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		PageReceiptListing.clickOnCancelReceiptButton(driver, testCaseName);
		ModalCancelReceipt.fillCancelReceiptComment(driver, testCaseName, IConstantsData.CANCEL_RECEIPT_COMMENT);
		ModalCancelReceipt.clickOnCancelReceiptButton(driver, testCaseName);

		ActionBot.defaultSleep();
		String status = PageReceiptListing.getFirstReceiptStatus(driver, testCaseName);
		flag = status.equalsIgnoreCase(IConstantsData.CANCELLED_FILTER_LABEL);
		return flag;
	}

	public static void submitReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageCreateReceipt.clickOnSubmitReceiptButton(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create receipt from PO and PO from Req
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @param receipt </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static Receipt createReceiptFromReqToPO(WebDriver driver, String testCaseName, Requisition requisition, Receipt receipt) throws Exception
	{
		List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
		boolean flag = false;
		// re to buyers desk
		requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
		// to view the req
		FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

		// convert To Po
		FlowBuyersDesk.convertToPo(driver, testCaseName);

		// submit all POs
		purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

		// to search po
		for (PurchaseOrder purchaseOrder : purchaseOrders)
		{
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			purchaseOrder.setRequisition(requisition);
			assertTrue("Purchase order was not created", flag);
		}

		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
		{
			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(purchaseOrders.size() - 1).getPoNo(),
				IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);

			/*
			 * approvalAllRequests.setDocumentNo(purchaseOrders.get(
			 * purchaseOrders.size() - 1).getPoNo());
			 * approvalAllRequests.setActions(IConstantsData.APPROVE);
			 * approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			 */FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(purchaseOrders.size() - 1).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of PO was not released", flag);
		}
		// to create receipt
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

		receipt = createReceipt(driver, testCaseName, receipt);
		receipt.setPurchaseOrder(purchaseOrders.get(purchaseOrders.size() - 1));

		return receipt;
	}
}
