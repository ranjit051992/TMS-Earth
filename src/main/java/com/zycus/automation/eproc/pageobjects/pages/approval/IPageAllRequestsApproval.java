/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approval;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public interface IPageAllRequestsApproval
{
	final static UI_Elements	DOCUMENT_NO											= UIFactory.getElements("DOCUMENT_NO");
	final static UI_Elements	NO_RECORDS_FOUND_TEXT								= UIFactory.getElements("NO_RECORDS_FOUND_TEXT");
	final static UI_Elements	ACTIONS_APPROVE_OPTION								= UIFactory.getElements("ACTIONS_APPROVE_OPTION");
	final static UI_Elements	DOCUMENT_NAME										= UIFactory.getElements("DOCUMENT_NAME");
	final static UI_Elements	INITIATOR											= UIFactory.getElements("INITIATOR");
	final static UI_Elements	STATUS_FILTER										= UIFactory.getElements("STATUS_FILTER");
	final static UI_Elements	PENDING_SINCE_FILTER								= UIFactory.getElements("PENDING_SINCE_FILTER");
	final static UI_Elements	COMMENTS_TEXTAREA_WORKFLOW_APPROVAL_ALL_REQUIEST	= UIFactory.getElements("COMMENTS_TEXTAREA_WORKFLOW_APPROVAL_ALL_REQUIEST");
	final static UI_Elements	APPROVE_UNDER_WORKFLOW_APPROVAL_ALL_REQUEST			= UIFactory.getElements("APPROVE_UNDER_WORKFLOW_APPROVAL_ALL_REQUEST");
	final static UI_Elements	REJECT_UNDER_WORKFLOW_APPROVAL_ALL_REQUEST			= UIFactory.getElements("REJECT_UNDER_WORKFLOW_APPROVAL_ALL_REQUEST");

	final static UI_Elements	DOCUMENT_TYPE_FILTER								= UIFactory.getElements("DOCUMENT_TYPE_FILTER");
	final static UI_Elements	RECEIVED_ON_FILTER									= UIFactory.getElements("RECEIVED_ON_FILTER");
	final static UI_Elements	AMOUNT_FILTER										= UIFactory.getElements("AMOUNT_FILTER");
	final static UI_Elements	ACTIONS_LINK										= UIFactory.getElements("ACTIONS_LINK");
	final static UI_Elements	AUTO_CHECK_ALL										= UIFactory.getElements("AUTO_CHECK_ALL");
	final static UI_Elements	AUTO_CHECK_ITEM										= UIFactory.getElements("AUTO_CHECK_ITEM");
	final static UI_Elements	APPROVAL_STATUS										= UIFactory.getElements("APPROVAL_STATUS");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUMENT_NO						= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUMENT_NO");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUMENT_TYPE					= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUMENT_TYPE");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUMENT_NAME					= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUMENT_NAME");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUMENT_INITIATOR				= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUMENT_INITIATOR");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUEMNT_RECEIVED_ON				= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUEMNT_RECEIVED_ON");
	final static UI_Elements	FIRST_ROW_APPROVAL_DOCUMENT_AMOUNT					= UIFactory.getElements("FIRST_ROW_APPROVAL_DOCUMENT_AMOUNT");
	final static UI_Elements	ALL_APPROVAL_DOCUMENT_NOS							= UIFactory.getElements("ALL_APPROVAL_DOCUMENT_NOS");
	final static UI_Elements	ALL_APPROVAL_DOCUMENT_RECEIVED_ON					= UIFactory.getElements("ALL_APPROVAL_DOCUMENT_RECEIVED_ON");
	final static UI_Elements	ALL_APPROVAL_DOCUMENT_AMOUNT						= UIFactory.getElements("ALL_APPROVAL_DOCUMENT_AMOUNT");
	final static UI_Elements	DOCUMENT_NO_SORT_LINK								= UIFactory.getElements("DOCUMENT_NO_SORT_LINK");
	final static UI_Elements	DOCUMENT_NO_ACTIVATED_SORT_LINK						= UIFactory.getElements("DOCUMENT_NO_ACTIVATED_SORT_LINK");
	final static UI_Elements	ALL_APPROVAL_DOCUMENT_NOS_AFTER_SORTING				= UIFactory.getElements("ALL_APPROVAL_DOCUMENT_NOS_AFTER_SORTING");
	final static UI_Elements	RECEIVED_ON_SORT_LINK								= UIFactory.getElements("RECEIVED_ON_SORT_LINK");
	final static UI_Elements	RECEIVED_ON_ACTIVATED_SORT_LINK						= UIFactory.getElements("RECEIVED_ON_ACTIVATED_SORT_LINK");
	final static UI_Elements	ALL_APPROVAL_DOCUEMNT_RECEIVED_ON_AFTER_SORTING		= UIFactory.getElements("ALL_APPROVAL_DOCUEMNT_RECEIVED_ON_AFTER_SORTING");
	final static UI_Elements	AMOUNT_SORT_LINK									= UIFactory.getElements("AMOUNT_SORT_LINK");
	final static UI_Elements	AMOUNT_ACTIVATED_SORT_LINK							= UIFactory.getElements("AMOUNT_ACTIVATED_SORT_LINK");
	final static UI_Elements	ALL_APPROVAL_DOCUMENT_AMOUNT_AFTER_SORTING			= UIFactory.getElements("ALL_APPROVAL_DOCUMENT_AMOUNT_AFTER_SORTING");
	final static UI_Elements	CLEAR_ALL_FILTERS									= UIFactory.getElements("CLEAR_ALL_FILTERS");

	final static UI_Elements	APPROVAL_PROCESSING									= UIFactory.getElements("APPROVAL_PROCESSING");
	final static UI_Elements	APPROVAL_TABLE_EMPTY								= UIFactory.getElements("APPROVAL_TABLE_EMPTY");
	final static UI_Elements	ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE				= UIFactory.getElements("ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE");
	static UI_Elements			BUTTON_CLEAR_APPROVAL_STATUS_FILTER					= UIFactory.getElements("BUTTON_CLEAR_APPROVAL_STATUS_FILTER");
	static UI_Elements			APPROVAL_ACTION_PROCESSING_DIV						= UIFactory.getElements("APPROVAL_ACTION_PROCESSING_DIV");
	static UI_Elements			LINK_APPROVE_REQUEST_ON_TOOL_TIP					= UIFactory.getElements("LINK_APPROVE_REQUEST_ON_TOOL_TIP");
	static UI_Elements			LINK_LIST_OF_ALL_DOCUMENT_NOS						= UIFactory.getElements("LINK_LIST_OF_ALL_DOCUMENT_NOS");
	static UI_Elements			BUTTON_PURCHASE_ORDER_TAB							= UIFactory.getElements("BUTTON_PURCHASE_ORDER_TAB");
	static UI_Elements			LINK_EXTERNAL_PRODUCTS								= UIFactory.getElements("LINK_EXTERNAL_PRODUCTS");
	static UI_Elements			BUTTON_BPO_TAB										= UIFactory.getElements("BUTTON_BPO_TAB");
	static UI_Elements			TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE		= UIFactory.getElements("TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE");
	static UI_Elements			BUTTON_FILTER_SEARCH_INVOICE_ALL_APPROVAL_PAGE		= UIFactory.getElements("BUTTON_FILTER_SEARCH_INVOICE_ALL_APPROVAL_PAGE");

	static UI_Elements			LINK_FILTER_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE	= UIFactory.getElements("LINK_FILTER_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE");
	static UI_Elements			BUTTON_CLEAR_APPROVAL_NUMBER_FILTER					= UIFactory.getElements("BUTTON_CLEAR_APPROVAL_NUMBER_FILTER");

	static UI_Elements			BUTTON_CLEAR_APPROVAL_NAME_FILTER					= UIFactory.getElements("BUTTON_CLEAR_APPROVAL_NAME_FILTER");
	static UI_Elements			BUTTON_CATALOG_TAB									= UIFactory.getElements("BUTTON_CATALOG_TAB");

	static UI_Elements			TEXT_REQ_NO_FILTER									= UIFactory.getElements("TEXT_REQ_NO_FILTER");

	static UI_Elements			BUTTON_ACTION										= UIFactory.getElements("BUTTON_ACTION");

	static UI_Elements			LINK_APPROVE										= UIFactory.getElements("LINK_APPROVE");

	static UI_Elements			TEXTAREA_APPROVAL_COMMENTS							= UIFactory.getElements("TEXTAREA_APPROVAL_COMMENTS");

	static UI_Elements			BUTTON_APPROVE										= UIFactory.getElements("BUTTON_APPROVE");

	static UI_Elements			APPROVAL_COMMENT									= UIFactory.getElements("APPROVAL_COMMENTS");

	static UI_Elements			REJECT_COMMENT										= UIFactory.getElements("REJECT_COMMENT");

	static UI_Elements			APPROVE_BUTTON										= UIFactory.getElements("APPROVE_BUTTON");

	static UI_Elements			REJECT_BUTTON										= UIFactory.getElements("REJECT_BUTTON");

	static UI_Elements			REJECT_LINK											= UIFactory.getElements("REJECT_LINK");

	public static UI_Elements	SUCCESSFUL_ACTION									= UIFactory.getElements("SUCCESSFUL_ACTION");

	public static UI_Elements	PENDING_STATUS_FILTER								= UIFactory.getElements("PENDING_STATUS_FILTER");

	public static UI_Elements	REJECTED_STATUS_FILTER								= UIFactory.getElements("REJECTED_STATUS_FILTER");

	public static UI_Elements	DELEGATED_STATUS_FILTER								= UIFactory.getElements("DELEGATED_STATUS_FILTER");

	public static UI_Elements	APPROVED_STATUS_FILTER								= UIFactory.getElements("APPROVED_STATUS_FILTER");

	public static UI_Elements	TEXTBOX_SEARCH_REQ_NUMBER							= UIFactory.getElements("TEXTBOX_SEARCH_REQ_NUMBER");
	public static UI_Elements	TEXTBOX_SEARCH_REQ_NAME								= UIFactory.getElements("TEXTBOX_SEARCH_REQ_NAME");
	public static UI_Elements	MY_APPROVAL_VIEW_ITEM_COMMENTS						= UIFactory.getElements("APPROVAL_VIEW_ITEM_COMMENTS");

	public static UI_Elements	VIEW_WORKFLOW_ON_REQUISITION_NO_CLICK				= UIFactory.getElements("VIEW_WORKFLOW_ON_REQUISITION_NO_CLICK");

	public static UI_Elements	AUDIT_TRAIL_ON_REQUISITION_NO_CLICK					= UIFactory.getElements("AUDIT_TRAIL_ON_REQUISITION_NO_CLICK");

	public static UI_Elements	APPROVE_OF_WORKFLOW_SECTION							= UIFactory.getElements("APPROVE_OF_WORKFLOW_SECTION");

	public static UI_Elements	REJECT_OF_WORKFLOW_SECTION							= UIFactory.getElements("REJECT_OF_WORKFLOW_SECTION");

	public static UI_Elements	DELEGATE_OF_WORKFLOW_SECTION						= UIFactory.getElements("DELEGATE_OF_WORKFLOW_SECTION");

	public static UI_Elements	DELEGATE_REQUSITION									= UIFactory.getElements("DELEGATE_REQUSITION");

	public static UI_Elements	DELEGATE_REQUSITION_APPROVAL_TO						= UIFactory.getElements("DELEGATE_REQUSITION_APPROVAL_TO");

	public static UI_Elements	DELEGATE_REQUSITION_COMMENT							= UIFactory.getElements("DELEGATE_REQUSITION_COMMENT");

	public static UI_Elements	DELEGATE_REQUSITION_POPUP_SUBMIT					= UIFactory.getElements("DELEGATE_REQUSITION_POPUP_SUBMIT");

	public static UI_Elements	TEXTBOX_REPLACE_AD_HOC_APPROVER						= UIFactory.getElements("TEXTBOX_REPLACE_AD_HOC_APPROVER");

	UI_Elements					PENDING_SINCE_DAYS_INPUT_TEXT						= UIFactory.getElements("PENDING_SINCE_DAYS_INPUT_TEXT");
	UI_Elements					URGENT_REQUESTS_ONLY_STATUS_FILTER					= UIFactory.getElements("URGENT_REQUESTS_ONLY_STATUS_FILTER");
	UI_Elements					STATUS_FILTER_BUTTON								= UIFactory.getElements("STATUS_FILTER_BUTTON");

	public static UI_Elements	URGENT_ITEM_SYMBOL									= UIFactory.getElements("URGENT_ITEM_SYMBOL");
	public static UI_Elements	REQUISITION_NAME_ALL_REQUESTS_APPROVAL				= UIFactory.getElements("REQUISITION_NAME_ALL_REQUESTS_APPROVAL");
	public static UI_Elements	LABLE_ALL_REQUESTS_APPROVAL_PAGE_NO					= UIFactory.getElements("LABLE_ALL_REQUESTS_APPROVAL_PAGE_NO");
	public static UI_Elements	BUTTON_NEXT_PAGE_ALL_REQUESTS_APPROVAL_PAGE			= UIFactory.getElements("BUTTON_NEXT_PAGE_ALL_REQUESTS_APPROVAL_PAGE");

	public void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActionsLinkIindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnAmountActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmountSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApproveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearAllFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearApprovalStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentNoActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentNoSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceivedOnFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecivedOnActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecivedOnSortLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillDocumentName(WebDriver driver, String testCaseName, String documentName) throws ActionBotException;

	public String fillDocumentNo(WebDriver driver, String testCaseName, String documentNo) throws ActionBotException;

	public String fillInitiatorName(WebDriver driver, String testCaseName, String initiatorName) throws ActionBotException;

	public List<WebElement> getAllDocumentAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllDocumentAmountAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllDocumentNosAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllDocumentReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllDocumentRecivedOnAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getApprovalEmptyTableSize(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDocumentName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDocumentStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowDocumentName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowDocumentType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfApprovalStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoDataRecordsMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillAllRequestsGridLoads(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillApprovalActionProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApproveRequestOnToolTip(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnFirstRowApprovalDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPurchaseOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getMessageOnEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInvoiceApprovalLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBPOTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInvoiceNoFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException;

	public void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearApprovalNumberFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearApprovalNameFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvoiceNoFilterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCatalogTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterReqNoFilter(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException;

	public void clickActionButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean approveRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillApprovalComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException;

	public void fillRejectComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException;

	public void clickApproveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickRejectButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickRejectLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isActionPerformedSuccessful(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean rejectRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String searchRequition(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException;

	void clickOnApproveLinkIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean delegateFirstRequsition(WebDriver driver, String testCaseName, String DelegateTo) throws Exception;

	public List<String> getDocumentAllStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyUrgentRequestSymbol(WebDriver driver, String testCaseName) throws ActionBotException;

	public void searchRequisitionByName(WebDriver driver, String testCaseName, String requisitionName) throws ActionBotException;
}
