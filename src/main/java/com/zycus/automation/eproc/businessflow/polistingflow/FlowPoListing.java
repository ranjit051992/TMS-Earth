package com.zycus.automation.eproc.businessflow.polistingflow;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.PoStatusFilter;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest.ModalPORecallApprovalRequest;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.IPagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class FlowPoListing
{

	static Logger logger = Logger.getLogger(FlowPoListing.class);

	public static PoStatusFilter applyPoStatusFilter(WebDriver driver, String testCaseName, PoStatusFilter poStatusFilter) throws ActionBotException, FactoryMethodException
	{

		MainPageHeaderLevelTab.clickOnPOTab(driver);
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);

		poStatusFilter = applyPOStatusFilter(driver, testCaseName, poStatusFilter);

		ScreenShot.screenshot(driver, testCaseName, "After applying filter");
		ActionBot.focusAndclick(driver, IPagePurchaseOrderListing.TEXT_BOX_PO_NO);
		return poStatusFilter;
	}

	public static boolean checkIfPORecalled(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		return status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
	}

	// Filter All Released PO

	public static boolean checkIfPurchaseOrderSearched(WebDriver driver, String testCaseName, String searchText, String searchBy) throws ActionBotException
	{
		boolean flag = false;

		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_PO_NO))
		{
			flag = searchText.equalsIgnoreCase(PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName));

			String poStatus = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			if (poStatus.equalsIgnoreCase(IConstantsData.PARKED_FILTER_LABEL))
			{
				ActionBot.defaultMediumSleep();
				driver.navigate().refresh();
			}
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_ORDER_DESCRIPTION))
		{
			flag = PagePurchaseOrderListing.getFirstPoOrderDescription(driver, testCaseName).toLowerCase().contains(searchText.toLowerCase());
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_SUPPLIER))
		{

		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_BUYER))
		{
			flag = searchText.equalsIgnoreCase(PagePurchaseOrderListing.getFirstRowBuyerName(driver, testCaseName));
		}
		else
		{
			logger.info("Invalid Search Option");
		}
		return flag;
	}

	// Filter All Draft PO
	public static void filterAllDraftPO(WebDriver driver, String testCaseName) throws Exception
	{
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
		ActionBot.defaultSleep();
		PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
		ActionBot.defaultSleep();
		PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);

	}

	public static void filterAllInProgressPO(WebDriver driver, String testCaseName) throws Exception

	{
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
		ActionBot.defaultSleep();
		PagePurchaseOrderListing.clickOnInProgressStatusCheckbox(driver, testCaseName);

		PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);

		ActionBot.defaultSleep();
		PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
		// click on copy link
		ActionBot.defaultSleep();
		// PagePurchaseOrderListing.clickOnCopyLink(driver, testCaseName);
		ModalPOListingActions.clickOnCopyLink(driver, testCaseName);

	}

	public static void filterAllReleasedPO(WebDriver driver, String testCaseName) throws Exception
	{
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);

		PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);

		PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
		/*
		 * PagePurchaseOrderListing.clickOnActionsDropdownLink(driver,
		 * testCaseName, 1); //click on copy link ActionBot.defaultSleep();
		 * PagePurchaseOrderListing.clickOnCopyLink(driver, testCaseName);
		 */
	}

	public static void recallApprovalRequestForPurchaseOrder(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ActionBot.defaultSleep();
		ModalPOListingActions.clickOnRecallApprovalRequestLink(driver, testCaseName);

		ModalPORecallApprovalRequest.fillRecallComments(driver, testCaseName, IConstantsData.RECALL_APPROVAL_REQUEST_COMMENT);
		ModalPORecallApprovalRequest.clickOnRecallButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchText </font><b><br>
	 * @param searchBy </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean searchPo(WebDriver driver, String testCaseName, String searchText, String searchBy) throws ActionBotException
	{
		// ActionBot.defaultSleep();
		MainPageHeaderLevelTab.clickOnPOTab(driver);
		boolean flag = false;
		flag = searchPO(driver, testCaseName, searchText, searchBy);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchText </font><b><br>
	 * @param searchBy </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean searchPO(WebDriver driver, String testCaseName, String searchText, String searchBy) throws ActionBotException
	{
		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_PO_NO))
		{
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_ORDER_DESCRIPTION))
		{
			PagePurchaseOrderListing.fillOrderDescription(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_SUPPLIER))
		{

		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_BUYER))
		{
			PagePurchaseOrderListing.fillBuyer(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else
		{
			logger.info("Invalid Search Option");
		}

		return checkIfPurchaseOrderSearched(driver, testCaseName, searchText, searchBy);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void viewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static String approveAndReleasePO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		boolean flag = FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
		{
			//MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(poNumber);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			ActionBot.defaultSleep();
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);
			/*
			 * flag = PagePurchaseOrderListing.getFirstPoStatus(driver,
			 * testCaseName).equalsIgnoreCase(
			 * IConstantsData.COMPLETE_RELEASED_FILTER_LABEL); assertTrue(
			 * "Status of PO was not Released", flag);
			 */
		}
		return poNumber;
	}

	public static String approveAndReleaseAmmendedPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		//MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		// to approve the PO
		ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
		approvalAllRequests.setDocumentNo(poNumber);
		approvalAllRequests.setActions(IConstantsData.APPROVE);
		approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
		approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
		FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

		ActionBot.defaultSleep();
		ActionBot.defaultHighSleep();
		driver.navigate().refresh();
		driver.navigate().refresh();
		// search po
		FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
		return PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
	}

	public static String approveAndReleaseBPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		boolean flag = FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
		{
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(poNumber);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.BPO);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			ActionBot.defaultSleep();
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);
		}
		return poNumber;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search BPO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchText </font><b><br>
	 * @param searchBy </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean searchBPO(WebDriver driver, String testCaseName, String searchText, String searchBy, String docType) throws ActionBotException, FactoryMethodException
	{
		ActionBot.defaultHighSleep();
		MainPageHeaderLevelTab.clickOnPOTab(driver);
		boolean flag = false;

		// apply type filter

		PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
		if (docType.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnBlanketFilterOption(driver, testCaseName);

		}
		else if (docType.equalsIgnoreCase(IConstantsData.STANDARD_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnReleaseFilterOption(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid Doc Type");
		}
		PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);

		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_PO_NO))
		{

			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_SUPPLIER))
		{

		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_BUYER))
		{
			PagePurchaseOrderListing.fillBuyer(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else
		{
			logger.info("Invalid Search Option");
		}

		logger.info("Searching PO with PO Number");
		flag = checkIfPurchaseOrderSearched(driver, testCaseName, searchText, searchBy);

		return flag;
	}

	public static void filterAllInApprovalPO(WebDriver driver, String testCaseName) throws Exception
	{
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
		PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
		PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
		PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
	}

	public static void filterStandardTypePO(WebDriver driver, String testCaseName) throws Exception
	{
		PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
		PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
		PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Apply doc type filter <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param docType </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void applyTypeFilter(WebDriver driver, String testCaseName, String docType) throws ActionBotException, FactoryMethodException
	{
		// apply type filter
		PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
		if (docType.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnBlanketFilterOption(driver, testCaseName);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.STANDARD_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE))
		{
			PagePurchaseOrderListing.clickOnReleaseFilterOption(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid Doc Type");
		}
		PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Apply status filter with doc filter <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poStatusFilter </font><b><br>
	 * @param docType </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static PoStatusFilter applyPOStatusFilterWithDocFilter(WebDriver driver, String testCaseName, PoStatusFilter poStatusFilter, String docType)
		throws ActionBotException, FactoryMethodException
	{

		MainPageHeaderLevelTab.clickOnPOTab(driver);

		// apply type filter
		applyTypeFilter(driver, testCaseName, docType);

		// apply status filter
		poStatusFilter = applyPOStatusFilter(driver, testCaseName, poStatusFilter);

		ScreenShot.screenshot(driver, testCaseName, "After applying filter");
		ActionBot.focusAndclick(driver, IPagePurchaseOrderListing.TEXT_BOX_PO_NO);
		return poStatusFilter;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Apply PO status filter <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poStatusFilter </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static PoStatusFilter applyPOStatusFilter(WebDriver driver, String testCaseName, PoStatusFilter poStatusFilter) throws ActionBotException, FactoryMethodException
	{
		// apply status filter
		PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);

		if (poStatusFilter.isDraftFilter())
		{
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isInprogress())
		{
			PagePurchaseOrderListing.clickOnInProgressStatusCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isReleased())
		{
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isNotSentToSupplier())
		{
			PagePurchaseOrderListing.clickOnExpandReleaseFilterNode(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandConfirmationStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnNotSentToSupplierFilterCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isClosed())
		{
			PagePurchaseOrderListing.clickOnClosed(driver, testCaseName);
		}
		if (poStatusFilter.isCanceled())
		{
			PagePurchaseOrderListing.clickOnCancel(driver, testCaseName);
		}
		if (poStatusFilter.isRejected())
		{
			PagePurchaseOrderListing.clickOnRejected(driver, testCaseName);
		}
		if (poStatusFilter.isReturned())
		{
			PagePurchaseOrderListing.clickOnReturned(driver, testCaseName);
		}
		if (poStatusFilter.isSchdule())
		{
			PagePurchaseOrderListing.clickOnSchdule(driver, testCaseName);
		}
		if (poStatusFilter.isPayments())
		{
			PagePurchaseOrderListing.clickOnPayements(driver, testCaseName);
		}
		if (poStatusFilter.isExpired())
		{
			PagePurchaseOrderListing.clickOnExpired(driver, testCaseName);
		}
		if (poStatusFilter.isNotPaid())
		{
			PagePurchaseOrderListing.clickOnExpandPaymentStatusFilterOptions(driver, testCaseName);
			PagePurchaseOrderListing.clickOnNotPaidPaymentStatusFilterCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isPartiallyPaid())
		{
			PagePurchaseOrderListing.clickOnExpandPaymentStatusFilterOptions(driver, testCaseName);
			PagePurchaseOrderListing.clickOnPartiallyPaidPaymentStatusFilterCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isFullyPaid())
		{
			PagePurchaseOrderListing.clickOnExpandPaymentStatusFilterOptions(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFullyPaidPaymentStatusFilterCheckbox(driver, testCaseName);
		}
		if (poStatusFilter.isPaymentNotApplicable())
		{
			PagePurchaseOrderListing.clickOnExpandPaymentStatusFilterOptions(driver, testCaseName);
			PagePurchaseOrderListing.clickOnPayementNotApplicablePaymentStatusFilterCheckbox(driver, testCaseName);
		}

		PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After applying filter");
		ActionBot.focusAndclick(driver, IPagePurchaseOrderListing.TEXT_BOX_PO_NO);
		return poStatusFilter;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check if status filer is applied or not
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poStatusFilter </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean checkIfStatusFilterIsApplied(WebDriver driver, String testCaseName, PoStatusFilter poStatusFilter) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		String statusName, statusName2 = null, log = "", errorMsg = "";
		int i = 0, totalPOCount = 0, count = 0;
		// list of status taken from PO listing page
		List<String> listOfStatusObtainedFromPage = PagePurchaseOrderListing.getListOfStatus(driver, testCaseName);
		totalPOCount = listOfStatusObtainedFromPage.size();
		logger.info("After appying filter Total PO Count : " + totalPOCount);

		// list of status taken from MyRequisitionFilter bo
		List<String> statusOfFilter = poStatusFilter.getStatus();
		statusName = statusOfFilter.get(0);
		if (statusOfFilter.size() > 1)
		{
			statusName2 = statusOfFilter.get(1);
		}
		if (totalPOCount != 0)
		{
			for (String status : listOfStatusObtainedFromPage)
			{
				if (status.equalsIgnoreCase(statusName) || status.equalsIgnoreCase(statusName2) && statusName2 != null)
				{
					log += status + "\n";
					i++;
					if (i == totalPOCount)
					{
						flag = true;
						break;
					}
				}
			}
			logger.info("Status of Requisitions are : \n " + log);
		}
		else
		{
			logger.info("No requisition found");
			flag = true;
		}
		// for not sent to supplier
		if (poStatusFilter.isNotSentToSupplier())
		{
			List<WebElement> notSentToSupplierIcon = PagePurchaseOrderListing.getListOfIconsOfNotSentToSupplier(driver, testCaseName);
			count = notSentToSupplierIcon.size();
			if (count != totalPOCount)
			{
				errorMsg += "Not Sent to supplier filter was not applied properly. Icon for Not Sent to Supplier was not shown for all POs";
				flag = false;
			}
			else
			{
				flag = true;
			}
			logger.info(errorMsg);
		}
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To copy po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void copyPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// to copy PO
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnCopyLink(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Amend PO Link <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void amendPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnAmendPOLink(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Remind Approver Link <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean remindPOApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ActionBot.scroll(driver, "2000");

		// click on workflow link and remind approver
		// PageViewPurchaseOrder.clickonLinkWorkflow(driver, testCaseName);
		boolean flag = PageViewPurchaseOrder.clickRemindApprover(driver, testCaseName);
		return flag;

	}

	/**
	 * <b>Author: Omkar.Jagdale </b> <b><br>
	 * <font color="blue">Method :</b>Get the status of PO(Fully/Partially received)
	 */

	public static String getPODeliveryStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, IPagePurchaseOrderListing.DELIVERY_ICON);
		String deliveryStatus = ActionBot.getTextWithInElement(driver, IPagePurchaseOrderListing.STATUS_DETAILS);
		return deliveryStatus;
	}

	/**
	 * <b>Author: Omkar.Jagdale </b> <b><br>
	 * <font color="blue">Method :</b>Get the status of Invoice(Fully/Partially invoiced)
	 */

	public static String getInvocieIconStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, IPagePurchaseOrderListing.INVOICE_ICON);
		String invocieIconStatus = ActionBot.getTextWithInElement(driver, IPagePurchaseOrderListing.STATUS_DETAILS);
		return invocieIconStatus;
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method :</b>To delete draft <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void deleteDraft(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// to delete draft
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnDeleteLink(driver, testCaseName);
		PageStandardPO.clickOnItemDeleteYesPopup(driver);
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method :</b>To delete drafts <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void deleteMutipleDraft(WebDriver driver, String testCaseName) throws ActionBotException
	{
		while (ActionBot.isElementPresent(driver, IPagePurchaseOrderListing.LINK_PO_ACTIONS))
		{
			// to delete draft
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnDeleteLink(driver, testCaseName);
			PageStandardPO.clickOnItemDeleteYesPopup(driver);
			ActionBot.waitForPageLoad(driver);
		}
	}

	/*
	 * author: bhakti sawant
	 */
	public static void verifyPOStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// to delete draft
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnDeleteLink(driver, testCaseName);
	}
}
