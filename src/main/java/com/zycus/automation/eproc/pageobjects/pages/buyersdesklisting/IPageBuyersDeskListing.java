/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public interface IPageBuyersDeskListing
{
	final static UI_Elements		TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NO				= UIFactory.getElements("TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NO");
	final static UI_Elements		TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NAME			= UIFactory.getElements("TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NAME");

	final static UI_Elements		TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_REQUESTER		= UIFactory.getElements("TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_REQUESTER");

	final static UI_Elements		BUTTON_BUYERS_DESK_LISTING_CLEAR_STATUS_FILTER			= UIFactory.getElements("BUTTON_BUYERS_DESK_LISTING_CLEAR_STATUS_FILTER");
	final static UI_Elements		LINK_BUYERS_DESK_LISTING_FIRST_ROW_REQ_NO				= UIFactory.getElements("LINK_BUYERS_DESK_LISTING_FIRST_ROW_REQ_NO");
	final static UI_Elements		BUYERS_DESK_LISTING_FIRST_ROW_REQ_NAME					= UIFactory.getElements("BUYERS_DESK_LISTING_FIRST_ROW_REQ_NAME");
	final static UI_Elements		BUYERS_DESK_LISTING_FIRST_ROW_REQUESTER					= UIFactory.getElements("BUYERS_DESK_LISTING_FIRST_ROW_REQUESTER");
	final static UI_Elements		BUYERS_DESK_LISTING_FIRST_STATUS						= UIFactory.getElements("BUYERS_DESK_LISTING_FIRST_STATUS");
	final static UI_Elements		BUYERS_DESK_LISTING_PROCESSING_DIV						= UIFactory.getElements("BUYERS_DESK_LISTING_PROCESSING_DIV");
	final static UI_Elements		BUYERS_DESK_LISTING_ACTION_LINK							= UIFactory.getElements("BUYERS_DESK_LISTING_ACTION_LINK");
	static UI_Elements				BUTTON_CONVERT_TO_PO_BUYERS_DESK_LISTING				= UIFactory.getElements("BUTTON_CONVERT_TO_PO_BUYERS_DESK_LISTING");
	static UI_Elements				CONVERT_TO_PO_REQUISITION_PROCESSING_DIV				= UIFactory.getElements("CONVERT_TO_PO_REQUISITION_PROCESSING_DIV");
	static UI_Elements				PROCESSING_DIV_UPCOMING_REQUISITION						= UIFactory.getElements("PROCESSING_DIV_UPCOMING_REQUISITION");

	static UI_Elements				LABEL_ASSIGNED_BUYER_ON_LISTING_PAGE					= UIFactory.getElements("LABEL_ASSIGNED_BUYER_ON_LISTING_PAGE");

	static UI_Elements				PROCESSING_DIV_SAVING_BUYER								= UIFactory.getElements("PROCESSING_DIV_SAVING_BUYER");
	static UI_Elements				LINK_STATUS_FILTER_BUYERS_DESK_LISTING					= UIFactory.getElements("LINK_STATUS_FILTER_BUYERS_DESK_LISTING");
	static UI_Elements				CHECKBOX_PROCESSED_FILTER								= UIFactory.getElements("CHECKBOX_PROCESSED_FILTER");
	static UI_Elements				BUTTON_STATUS_FILTER									= UIFactory.getElements("BUTTON_STATUS_FILTER");
	static UI_Elements				CHECKBOX_PENDING_ORDER_FILTER							= UIFactory.getElements("CHECKBOX_PENDING_ORDER_FILTER");
	static UI_Elements				LINK_CONVERT_TO_PO_ACTION								= UIFactory.getElements("LINK_CONVERT_TO_PO_ACTION");
	static UI_Elements				LINK_EDIT_ACTION										= UIFactory.getElements("LINK_EDIT_ACTION");
	static UI_Elements				EXPAND_PENDING_ORDER_FILTER								= UIFactory.getElements("EXPAND_PENDING_ORDER_FILTER");
	static UI_Elements				CHECKBOX_PARTIALLY_ORDERED_FILTER						= UIFactory.getElements("CHECKBOX_PARTIALLY_ORDERED_FILTER");
	static UI_Elements				CHECKBOX_AWAITING_QUEUE_FILTER							= UIFactory.getElements("CHECKBOX_AWAITING_QUEUE_FILTER");
	static UI_Elements				BUTTON_NEXT_PAGE										= UIFactory.getElements("BUTTON_NEXT_PAGE");
	static UI_Elements				VALIDATION_GLOBAL_ERROR_MESSAGE							= UIFactory.getElements("VALIDATION_GLOBAL_ERROR_MESSAGE");
	static UI_Elements				EXPAND_PROCESSED_FILTER									= UIFactory.getElements("EXPAND_PROCESSED_FILTER");
	static UI_Elements				CHECKBOX_RETURNED_WITH_QUOTE_FILTER						= UIFactory.getElements("CHECKBOX_RETURNED_WITH_QUOTE_FILTER");
	static UI_Elements				CHECKBOX_RETURNED_FOR_MODIFICATION_FILTER				= UIFactory.getElements("CHECKBOX_RETURNED_FOR_MODIFICATION_FILTER");
	static UI_Elements				LINK_ASSIGNED_BUYER_FILTER								= UIFactory.getElements("LINK_ASSIGNED_BUYER_FILTER");
	static UI_Elements				RADIO_BUTTON_UNASSIGNED_FILTER							= UIFactory.getElements("RADIO_BUTTON_UNASSIGNED_FILTER");
	static UI_Elements				BUTTON_ASSIGNED_BUYER_FILTER							= UIFactory.getElements("BUTTON_ASSIGNED_BUYER_FILTER");
	static UI_Elements				INFO_OF_FIRST_REQ_ON_TOOLTIP							= UIFactory.getElements("INFO_OF_FIRST_REQ_ON_TOOLTIP");
	static UI_Elements				BUTTON_BUYERS_DESK_LISTING_CLEAR_REQ_NO_FILTER			= UIFactory.getElements("BUTTON_BUYERS_DESK_LISTING_CLEAR_REQ_NO_FILTER");
	static UI_Elements				RADIO_BUTTON_ME_ASSIGNED_BUYER_FILTER					= UIFactory.getElements("RADIO_BUTTON_ME_ASSIGNED_BUYER_FILTER");
	static UI_Elements				RADIO_BUTTON_WITH_ASSIGNED_BUYER						= UIFactory.getElements("RADIO_BUTTON_WITH_ASSIGNED_BUYER");
	static UI_Elements				ICON_CLEAR_ASSIGNED_BUYER_FILTER						= UIFactory.getElements("ICON_CLEAR_ASSIGNED_BUYER_FILTER");
	static UI_Elements				ICON_CLEAR_REQ_NAME_FILTER								= UIFactory.getElements("ICON_CLEAR_REQ_NAME_FILTER");
	static UI_Elements				ICON_CLEAR_REQUESTOR_FILTER								= UIFactory.getElements("ICON_CLEAR_REQUESTOR_FILTER");
	static UI_Elements				LINK_PURCHASE_AMOUNT_FILTER								= UIFactory.getElements("LINK_PURCHASE_AMOUNT_FILTER");
	static UI_Elements				CHECKBOX_INR_AMOUNT_FILTER								= UIFactory.getElements("CHECKBOX_INR_AMOUNT_FILTER");
	static UI_Elements				CHECKBOX_AMOUNT_FILTER									= UIFactory.getElements("CHECKBOX_AMOUNT_FILTER");
	static UI_Elements				BUTTON_PURCHASE_AMOUNT_FILTER							= UIFactory.getElements("BUTTON_PURCHASE_AMOUNT_FILTER");
	UI_Elements						BUTTON_STATUS_FILTER_AT_BUYERS_DESK_LISTING				= UIFactory.getElements("BUTTON_STATUS_FILTER_AT_BUYERS_DESK_LISTING");
	UI_Elements						SUCCESS_ERROR_BOX_BUYERS_DESK_LISTING					= UIFactory.getElements("SUCCESS_ERROR_BOX_BUYERS_DESK_LISTING");
	static UI_Elements				BUTTON_APPLY_STATUS_FILTER_BUYERS_DESK_LISTING			= UIFactory.getElements("BUTTON_APPLY_STATUS_FILTER_BUYERS_DESK_LISTING");

	final static UI_Elements		SEARCH_REQUISITION_NAME									= UIFactory.getElements("SEARCH_REQUISITION_NAME");

	final static UI_Elements		SEARCH_REQUISITION_NUMBER								= UIFactory.getElements("SEARCH_REQUISITION_NUMBER");

	final static UI_Elements		INFO_REQ_SAVE_MESSAGE									= UIFactory.getElements("INFO_REQ_SAVE_MESSAGE");

	final static UI_Elements		CHECKBOX_CAN_RESUBMIT									= UIFactory.getElements("CHECKBOX_CAN_RESUBMIT");

	final static UI_Elements		TEXT_BOX_RETURN_COMMENT									= UIFactory.getElements("TEXT_BOX_RETURN_COMMENT");

	final static UI_Elements		TEXT_BOX_RETURN_COMMENT_UNDER_ACTION_TAB_BUYERS_DESK	= UIFactory.getElements("TEXT_BOX_RETURN_COMMENT_UNDER_ACTION_TAB_BUYERS_DESK");

	final static UI_Elements		BUTTON_RETURN_REQUISITION								= UIFactory.getElements("BUTTON_RETURN_REQUISITION");

	final static UI_Elements		TEXT_BOX_RETURN_COMMENT_BUYER_DESK						= UIFactory.getElements("TEXT_BOX_RETURN_COMMENT_BUYER_DESK");

	final static UI_Elements		BUYERS_DESK_CLEAR_FILTER											= UIFactory.getElements("BUYERS_DESK_CLEAR_FILTER");

	public final static UI_Elements	BUYER_AMOUNT_FILTER										= UIFactory.getElements("BUYER_AMOUNT_FILTER");
	public final static UI_Elements	BUYER_MINIMUM_AMOUNT_RANGE								= UIFactory.getElements("BUYER_MINIMUM_AMOUNT_RANGE");
	public final static UI_Elements	BUYER_MAX_AMOUNT_RANGE									= UIFactory.getElements("BUYER_MAX_AMOUNT_RANGE");
	public final static UI_Elements	BUYER_AMOUNT_FILTER_Button								= UIFactory.getElements("BUYER_AMOUNT_FILTER_Button");
	public final static UI_Elements	BUYER_CHECK_INR_INPUT_CURRENCIES						= UIFactory.getElements("BUYER_CHECK_INR_INPUT_CURRENCIES");

	// FILTER STATUS UiELEMENTS
	public final static UI_Elements	AWAITING_QUOTE_BUYERS_DESK_STATUS_FILTER				= UIFactory.getElements("AWAITING_QUOTE_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	AWAITING_REVIEW_BUYERS_DESK_STATUS_FILTER				= UIFactory.getElements("AWAITING_REVIEW_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	PENDING_ORDER_BUYERS_DESK_STATUS_FILTER					= UIFactory.getElements("PENDING_ORDER_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	UNORDERED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("UNORDERED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	PARTIALLY_ORDERED_BUYERS_DESK_STATUS_FILTER				= UIFactory.getElements("PARTIALLY_ORDERED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	PROCESSED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("PROCESSED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	RETURNED_WITH_QUOTE_BUYERS_DESK_STATUS_FILTER			= UIFactory.getElements("RETURNED_WITH_QUOTE_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	RETURNED_FOR_MODIFICATION_BUYERS_DESK_STATUS_FILTER		= UIFactory.getElements("RETURNED_FOR_MODIFICATION_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	ORDERING_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("ORDERING_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	RELEASED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("RELEASED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	REJECTED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("REJECTED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	SOURCING_STATUS_BUYERS_DESK_STATUS_FILTER				= UIFactory.getElements("SOURCING_STATUS_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	BUYER_NEGOTIATED_PRICE_BUYERS_DESK_STATUS_FILTER		= UIFactory.getElements("BUYER_NEGOTIATED_PRICE_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	QUOTED_BY_SUPPLIER_BUYERS_DESK_STATUS_FILTER			= UIFactory.getElements("QUOTED_BY_SUPPLIER_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	ESTIMATED_PRICE_BUYERS_DESK_STATUS_FILTER				= UIFactory.getElements("ESTIMATED_PRICE_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	NEED_A_QUOTE_BUYERS_DESK_STATUS_FILTER					= UIFactory.getElements("NEED_A_QUOTE_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	CANCELLED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("CANCELLED_BUYERS_DESK_STATUS_FILTER");
	public final static UI_Elements	CLOSED_BUYERS_DESK_STATUS_FILTER						= UIFactory.getElements("CLOSED_BUYERS_DESK_STATUS_FILTER");

	public final static UI_Elements	RECORDS_PER_PAGE										= UIFactory.getElements("RECORDS_PER_PAGE");
	public final static UI_Elements	FOUND_RECORDS											= UIFactory.getElements("FOUND_RECORDS");
	public final static UI_Elements	LAST_PAGE												= UIFactory.getElements("LAST_PAGE");
	public final static UI_Elements	FIRST_PAGE												= UIFactory.getElements("FIRST_PAGE");
	public final static UI_Elements	SHOWING_PAGE_NO											= UIFactory.getElements("SHOWING_PAGE_NO");
	public final static UI_Elements	REQ_LIST_PER_PAGE										= UIFactory.getElements("REQ_LIST_PER_PAGE");
	public final static UI_Elements	DELIVER_BY_DATE											= UIFactory.getElements("DELIVER_BY_DATE");
	public final static UI_Elements	UI_DATE_PICKER											= UIFactory.getElements("UI_DATE_PICKER");
	public final static UI_Elements	REQUISITIONS_STATUS										= UIFactory.getElements("REQUISITIONS_STATUS");
	public final static UI_Elements	BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION					= UIFactory.getElements("BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION");
	public final static UI_Elements	ICON_CLEAR_ASSIGNED_BUYER_FILTER_UPCOMING_REQUISITION	= UIFactory.getElements("ICON_CLEAR_ASSIGNED_BUYER_FILTER_UPCOMING_REQUISITION");
	public final static UI_Elements	CHECKBOX_FIRST_REQ_ON_BUYERS_DESK						= UIFactory.getElements("CHECKBOX_FIRST_REQ_ON_BUYERS_DESK");
	public final static UI_Elements	COLUMN_NAMES_BUYERS_DESK_TABLE							= UIFactory.getElements("COLUMN_NAMES_BUYERS_DESK_TABLE");
	public final static UI_Elements	RECEIVED_ON_SORTING_BUTTON								= UIFactory.getElements("RECEIVED_ON_SORTING_BUTTON");
	final static UI_Elements		IN_PROCESS_EXPAND										= UIFactory.getElements("IN_PROCESS_EXPAND");

	public String fillRequisitionNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException;

	public String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException;

	public String fillRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException;

	public void clickOnClearStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isClearStatusFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstReqNoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowReqName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowRequester(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowReqStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getStatusOfAllReq(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstActionButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllReqNos(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConvertToPoButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void waitTillConvertToPoProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPendingOrderStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConvertToPOFromAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandPendingOrderFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAwaitingQueueFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextPageIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isValidationGlobalErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandProcessedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnedWithQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnedForModificationFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUnassignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckboxOfReqToBeSelected(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void hoverOnFirstReqNoToGetReqInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearReqNoFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMeAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBuyerInAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearIconOfAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearIconOfRequisitionNameFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearIconOfRequesterFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnINRcheckboxOfAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckboxOfAmountFilter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssignedBuyerFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuccessErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyEditAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public String searchRequisitionNameInFilter(WebDriver driver, String testCaseName, String reqName) throws ActionBotException;

	public String searchRequisitionNumberInFilter(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException;

	public boolean isReqSaveMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyLinkConvertToPoDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionNumberinBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickReturActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnCheckResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckNoResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillCommentForReturningByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException;

	public void fillCommentForReturningUnderActionTabByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException;

	public void clickReturnSubmitFromBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnReturnLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public void clickOnReqIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean verifyAvailablityOfEditAction(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean verifyReturnActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnAwaitingQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnAwaitingReviewStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnUnorderedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnPendingOrderStatusFilter_1(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnPartiallyOrderedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnReturnedWithQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnReturnedWithModificationStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnOrderingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnReleasedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSourcingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnBuyerNegotiatedPriceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnQuotedBySupplierStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnEstimatedPriceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnNeedAQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnClosedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnProcessedStatusFilter_1(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnProcessedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;	

	String getFilterCount(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPageItemCount(WebDriver driver, String testCaseName) throws ActionBotException;

	void naviagteToFirstPage(WebDriver driver, String testCaseName) throws ActionBotException;

	void naviagteToLastPage(WebDriver driver, String testCaseName) throws ActionBotException;

	String getShowingPageNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	int getNumberOfReqOnPage(WebDriver driver, String testCaseName) throws ActionBotException;	

	boolean isDeliverByDateEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException;

	String getReqStatusIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnClearIconOfAssignedBuyerFilterUpcomingRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isAssignedBuyerFilterUpcomingRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFirstReqInBuyersDeskListing(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getBuyersDeskListingTableColumnNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRecievedOnSortingStatus(WebDriver driver, String testCaseName) throws ActionBotException;
}
