package com.zycus.automation.eproc.pageobjects.pages.myrequisition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageMyRequisition
{

	final static UI_Elements		ADD_BUTTON													= UIFactory.getElements("ADD_BUTTON");
	final static UI_Elements		REQUISITION_NUMBER_ON_MY_REQ								= UIFactory.getElements("REQUISITION_NUMBER_ON_MY_REQ");
	final static UI_Elements		REQUISITION_SEARCH_NAME_ON_MY_REQ							= UIFactory.getElements("REQUISITION_SEARCH_NAME_ON_MY_REQ");
	final static UI_Elements		REQUESTER_ON_MYREQ											= UIFactory.getElements("REQUESTER_ON_MYREQ");
	final static UI_Elements		CLEAR_STATUS_FILTER											= UIFactory.getElements("CLEAR_STATUS_FILTER");
	final static UI_Elements		CLEAR_SUBMITTED_ON_FILTER									= UIFactory.getElements("CLEAR_SUBMITTED_ON_FILTER");
	final static UI_Elements		CLEAR_AMOUNT_FILTER											= UIFactory.getElements("CLEAR_AMOUNT_FILTER");
	final static UI_Elements		REQ_NUMBER_LINK_ON_MYREQ									= UIFactory.getElements("REQ_NUMBER_LINK_ON_MYREQ");
	final static UI_Elements		REQ_NUMBER_LIST_ON_MYREQ									= UIFactory.getElements("REQ_NUMBER_LIST_ON_MYREQ");
	final static UI_Elements		REQUESTER_LIST_ON_MYREQ										= UIFactory.getElements("REQUESTER_LIST_ON_MYREQ");
	final static UI_Elements		ACTION_BUTTON												= UIFactory.getElements("ACTION_BUTTON");
	final static UI_Elements		REQ_NUMBER_LABEL_ON_HEADER									= UIFactory.getElements("REQ_NUMBER_LABEL_ON_HEADER");
	final static UI_Elements		SUBMITTED_ON_LABEL_ON_HEADER								= UIFactory.getElements("SUBMITTED_ON_LABEL_ON_HEADER");
	final static UI_Elements		AMOUNT_LABEL_ON_HEADER										= UIFactory.getElements("AMOUNT_LABEL_ON_HEADER");
	final static UI_Elements		STATUS_FILTER_BTN											= UIFactory.getElements("STATUS_FILTER_BTN");

	final static UI_Elements		REASON_FOR_ORDERING											= UIFactory.getElements("REASON_FOR_ORDERING");
	final static UI_Elements		COMMENT_FOR_SUPPLIER										= UIFactory.getElements("COMMENT_FOR_SUPPLIER");
	final static UI_Elements		ON_BEHALF_OF												= UIFactory.getElements("ON_BEHALF_OF");

	final static UI_Elements		SUBMITTED_ON_FILTER_BTN										= UIFactory.getElements("SUBMITTED_ON_FILTER_BTN");
	final static UI_Elements		AMOUNT_FILTER_BTN											= UIFactory.getElements("AMOUNT_FILTER_BTN");
	final static UI_Elements		DATA_TABLE_EMPTY											= UIFactory.getElements("DATA_TABLE_EMPTY");
	final static UI_Elements		MY_REQUISITION_STATUS										= UIFactory.getElements("MY_REQUISITION_STATUS");
	final static UI_Elements		ADD_REQ_BUTTON												= UIFactory.getElements("ADD_REQ_BUTTON");
	final static UI_Elements		FIRST_REQ_NO_LINK											= UIFactory.getElements("FIRST_REQ_NO_LINK");
	final static UI_Elements		FIRST_REQ_NAME												= UIFactory.getElements("FIRST_REQ_NAME");
	final static UI_Elements		FIRST_REQ_REQUESTER											= UIFactory.getElements("FIRST_REQ_REQUESTER");
	final static UI_Elements		FIRST_REQ_SUBMITTED_ON										= UIFactory.getElements("FIRST_REQ_SUBMITTED_ON");
	final static UI_Elements		FIRST_REQ_TOTAL_AMOUNT										= UIFactory.getElements("FIRST_REQ_TOTAL_AMOUNT");
	final static UI_Elements		REQ_LIST_PROCESSING											= UIFactory.getElements("REQ_LIST_PROCESSING");
	final static UI_Elements		STATUS_ICON													= UIFactory.getElements("STATUS_ICON");
	final static UI_Elements		TEXTBOX_COMMENT_MYREQUITION									= UIFactory.getElements("TEXTBOX_COMMENT_MYREQUITION");
	final static UI_Elements		BUTTON_RECALL												= UIFactory.getElements("BUTTON_RECALL");
	final static UI_Elements		RECALL_APPROVAL_REQUEST_LINK								= UIFactory.getElements("RECALL_APPROVAL_REQUEST_LINK");
	final static UI_Elements		NAVIGATE_TO_NEXT_ACTIVE_PAGE								= UIFactory.getElements("NAVIGATE_TO_NEXT_ACTIVE_PAGE");
	final static UI_Elements		SELECT_RETURNED_FOR_AMENDMENT_STATUS_FILTER					= UIFactory.getElements("SELECT_RETURNED_FOR_AMENDMENT_STATUS_FILTER");
	final static UI_Elements		SELECT_EDIT_IN_REQ_ACTION									= UIFactory.getElements("SELECT_EDIT_IN_REQ_ACTION");
	final static UI_Elements		SELECT_CANCEL_IN_REQ_ACTION									= UIFactory.getElements("SELECT_CANCEL_IN_REQ_ACTION");
	final static UI_Elements		PERFORM_FILTER_ON_CLICK										= UIFactory.getElements("PERFORM_FILTER_ON_CLICK");

	final static UI_Elements		SELECT_IN_APPROVAL_STATUS_FILTER							= UIFactory.getElements("SELECT_IN_APPROVAL_STATUS_FILTER");
	final static UI_Elements		SELECT_IN_BUYERS_DESK_STATUS_FILTER							= UIFactory.getElements("SELECT_IN_BUYERS_DESK_STATUS_FILTER");
	final static UI_Elements		SELECT_IN_REJECTED_STATUS_FILTER							= UIFactory.getElements("SELECT_IN_REJECTED_STATUS_FILTER");
	final static UI_Elements		SELECT_IN_RELEASED_STATUS_FILTER							= UIFactory.getElements("SELECT_IN_RELEASED_STATUS_FILTER");
	final static UI_Elements		SELECT_ORDERING_STATUS_FILTER								= UIFactory.getElements("SELECT_ORDERING_STATUS_FILTER");
	final static UI_Elements		SELECT_DRAFT_STATUS_FILTER									= UIFactory.getElements("SELECT_DRAFT_STATUS_FILTER");
	public final static UI_Elements	searchReqByNo												= UIFactory.getElements("SEARCH_REQ_BY_NO");
	public final static UI_Elements	SEARCH_REQ_BY_NO_TEXT										= UIFactory.getElements("SEARCH_REQ_BY_NO_TEXT");
	public final static UI_Elements	SEARCH_REQ_BY_REQUISITER_TEXT								= UIFactory.getElements("SEARCH_REQ_BY_REQUISITER_TEXT");
	public final static UI_Elements	SUCCESS_MESSAGE												= UIFactory.getElements("SUCCESS_MESSAGE");
	public final static UI_Elements	PROCEED_WITH_ONLY_REQ_ITEMS									= UIFactory.getElements("PROCEED_WITH_ONLY_REQ_ITEMS");
	public final static UI_Elements	CONFIRMATION_OPTIONS										= UIFactory.getElements("CONFIRMATION_OPTIONS");
	public final static UI_Elements	ITEM_DETAILS_POPUP_FIELD									= UIFactory.getElements("ITEM_DETAILS_POPUP_FIELD");
	public final static UI_Elements	Cat_ITEM_DETAILS_POPUP_FIELD								= UIFactory.getElements("CAT_ITEM_DETAILS_POPUP_FIELD");
	public final static UI_Elements	CANCEL_REQUISITION_BUTTON									= UIFactory.getElements("CANCEL_REQUISITION_BUTTON");
	public final static UI_Elements	TEXT_CANCEL_COMMENT											= UIFactory.getElements("TEXT_CANCEL_COMMENT");
	public final static UI_Elements	SUCCESSFUL_SAVING_PROCESS									= UIFactory.getElements("SUCCESSFUL_SAVING_PROCESS");
	public final static UI_Elements	RECALL_APPROVAL_REQUEST										= UIFactory.getElements("RECALL_APPROVAL_REQUEST");
	public final static UI_Elements	CLEAR_FILTER_STATUS											= UIFactory.getElements("CLEAR_FILTER_STATUS");
	public final static UI_Elements	AMOUNT_FILTER												= UIFactory.getElements("AMOUNT_FILTER");
	public final static UI_Elements	AMOUNT_FILTER_MYREQ											= UIFactory.getElements("AMOUNT_FILTER_MYREQ");
	public final static UI_Elements	MINIMUM_AMOUNT_RANGE										= UIFactory.getElements("MINIMUM_AMOUNT_RANGE");
	public final static UI_Elements	MAX_AMOUNT_RANGE											= UIFactory.getElements("MAX_AMOUNT_RANGE");
	public final static UI_Elements	AMOUNT_FILTER_Button										= UIFactory.getElements("AMOUNT_FILTER_Button");
	public final static UI_Elements	CHECK_INR_INPUT_CURRENCIES									= UIFactory.getElements("CHECK_INR_INPUT_CURRENCIES");
	public final static UI_Elements	DRAFT_STATUS_IN_PROCESS										= UIFactory.getElements("DRAFT_STATUS_IN_PROCESS");
	final static UI_Elements		STATUS_LIST_MY_REQ											= UIFactory.getElements("STATUS_LIST_MY_REQ");

	public final static UI_Elements	SENT_FOR_QUOTE												= UIFactory.getElements("SENT_FOR_QUOTE");
	public final static UI_Elements	RETURNED_WITH_QUOTE											= UIFactory.getElements("RETURNED_WITH_QUOTE");
	public final static UI_Elements	CANCELED													= UIFactory.getElements("CANCELED");
	public final static UI_Elements	CLOSED														= UIFactory.getElements("CLOSED");

	public final static UI_Elements	VIEW_COMMENTS												= UIFactory.getElements("VIEW_COMMENTS");

	public final static UI_Elements	GRID_ITEM_SUMMARY_MAYER										= UIFactory.getElements("GRID_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	GRID_ITEM_SUMMARY_PAGINATION								= UIFactory.getElements("GRID_ITEM_SUMMARY_PAGINATION");

	public final static UI_Elements	EXPAND_IN_PROCESS											= UIFactory.getElements("EXPAND_IN_PROCESS");
	public final static UI_Elements	READY_FOR_APPROVAL_IN_PROCESS								= UIFactory.getElements("READY_FOR_APPROVAL_IN_PROCESS");
	public final static UI_Elements	TRANSFERRED_TO_ME											= UIFactory.getElements("TRANSFERRED_TO_ME");
	public final static UI_Elements	CLOSED_STATUS_FILTER										= UIFactory.getElements("CLOSED_STATUS_FILTER");
	public final static UI_Elements	CANCELLED_STATUS_FILTER										= UIFactory.getElements("CANCELLED_STATUS_FILTER");
	public final static UI_Elements	RECALL_APPROVE_REQUEST										= UIFactory.getElements("RECALL_APPROVE_REQUEST");
	public final static UI_Elements	CLEAR_REQUISITION_NAME_FILTER								= UIFactory.getElements("CLEAR_REQUISITION_NAME_FILTER");
	public final static UI_Elements	EXPAND_RELEASED_IN_PROCESS_FILTER							= UIFactory.getElements("EXPAND_RELEASED_IN_PROCESS_FILTER");
	public final static UI_Elements	EXPAND_IN_PROCESS_FILTER									= UIFactory.getElements("EXPAND_IN_PROCESS_FILTER");
	public final static UI_Elements	CLEAR_REQUISITION_NUMBER_FILTER								= UIFactory.getElements("CLEAR_REQUISITION_NUMBER_FILTER");
	public final static UI_Elements	AUDIT_TRAIL_VERSION_LINK									= UIFactory.getElements("AUDIT_TRAIL_VERSION_LINK");
	public final static UI_Elements	AUDIT_TRAIL_VERSION_ONE_LINK								= UIFactory.getElements("AUDIT_TRAIL_VERSION_ONE_LINK");
	public final static UI_Elements	AUDIT_TRAIL_VERSION_TWO_LINK								= UIFactory.getElements("AUDIT_TRAIL_VERSION_TWO_LINK");
	public final static UI_Elements	RELEASED_FULLY_RECIEVED										= UIFactory.getElements("RELEASED_FULLY_RECIEVED");
	public final static UI_Elements	RELEASED_PARTIALLY_RECIEVED									= UIFactory.getElements("RELEASED_PARTIALLY_RECIEVED");
	public final static UI_Elements	RELEASED_NOT_RECIEVED										= UIFactory.getElements("RELEASED_NOT_RECIEVED");
	public final static UI_Elements	RELEASED_PARTIALLY_ORDERED									= UIFactory.getElements("RELEASED_PARTIALLY_ORDERED");
	public final static UI_Elements	EXPAND_RELEASED_ORDER_STATUS								= UIFactory.getElements("EXPAND_RELEASED_ORDER_STATUS");
	public final static UI_Elements	REQ_LIST_PAGE_MY_REQUISTION									= UIFactory.getElements("REQ_LIST_PAGE_MY_REQUISTION");
	public final static UI_Elements	LINK_REMIND_APPROVER_MY_REQ									= UIFactory.getElements("LINK_REMIND_APPROVER_MY_REQ");
	public final static UI_Elements	POPUP_CONFIRMATION_REMIND_APPROVER							= UIFactory.getElements("POPUP_CONFIRMATION_REMIND_APPROVER");
	public final static UI_Elements	BUTTON_SUBMIT_MY_REQ										= UIFactory.getElements("BUTTON_SUBMIT_MY_REQ");
	public final static UI_Elements	POPUP_SUBMIT_GROUP_MY_REQ									= UIFactory.getElements("POPUP_SUBMIT_GROUP_MY_REQ");
	public final static UI_Elements	CLICK_FILTER_GENERIC										= UIFactory.getElements("CLICK_FILTER_GENERIC");
	public final static UI_Elements	LINK_RECALL_APPROVAL_REQUEST_ON_REQ_HOVER					= UIFactory.getElements("LINK_RECALL_APPROVAL_REQUEST_ON_REQ_HOVER");
	public final static UI_Elements	RELEASED_PARTIALLY_RECEVIED_OUT								= UIFactory.getElements("RELEASED_PARTIALLY_RECEVIED_OUT");

	//client - saWater specific
	public final static UI_Elements	BUTTON_YES_CONFIRM_PROCEED_WITH_REQ_AND_EXISTING_CART_ITEMS	= UIFactory
		.getElements("BUTTON_YES_CONFIRM_PROCEED_WITH_REQ_AND_EXISTING_CART_ITEMS");
	public final static UI_Elements	BUTTON_NO_CONFIRM_PROCEED_ONLY_WITH_REQ_ITEMS				= UIFactory.getElements("BUTTON_NO_CONFIRM_PROCEED_ONLY_WITH_REQ_ITEMS");

	//client Carlson
	final static UI_Elements		SUBMITTED_ON_FILTER_BTN_MY_REQ								= UIFactory.getElements("SUBMITTED_ON_FILTER_BTN_MY_REQ");
	final static UI_Elements		AMOUNT_FILTER_BTN_MY_REQ									= UIFactory.getElements("AMOUNT_FILTER_BTN_MY_REQ");

	final static UI_Elements		STATUS_DRAFT_MY_REQUISITION									= UIFactory.getElements("STATUS_DRAFT_MY_REQUISITION");
	final static UI_Elements		BUTTON_FILTER_MY_REQUISITION								= UIFactory.getElements("BUTTON_FILTER_MY_REQUISITION");
	final static UI_Elements		EXPAND_RELEASED_FILTER_MY_REQ								= UIFactory.getElements("EXPAND_RELEASED_FILTER_MY_REQ");
	final static UI_Elements		IN_APPROVAL_FILTER_MY_REQ									= UIFactory.getElements("IN_APPROVAL_FILTER_MY_REQ");

	void toClickOnAddBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillReqNumberOnMyReq(WebDriver driver, String testcaseName, String reqNo) throws ActionBotException;

	String fillRecallApprovalComment(WebDriver driver, String testcaseName, String recallcommnet) throws ActionBotException;

	// Match the req no that is entered and that is displayed on listing
	String getReqNoFromMyReq(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillReqName(WebDriver driver, String testcaseName, String reqName) throws ActionBotException;

	// get the req name
	String getReqNameFromMyReq(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillRequester(WebDriver driver, String testcaseName, String requesterName) throws ActionBotException;

	public String getReqRequester(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void clearStatusFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	void clearAllStatusFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	void clearSubmittedOnFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	void clearAmountFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnReqNoLink(WebDriver driver, String testcaseName) throws ActionBotException;

	List<String> getReqNoList(WebDriver driver, String testcaseName) throws ActionBotException;

	List<String> getRequesterList(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnActionBtnOfFirstReq(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnRecallApprocalRequestLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnReqNumberOnHeader(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnSubmittedOnHeader(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnAmountOnHeader(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnSubmittedOnFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnAmountFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public List<String> getRequisitionStatusList(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getRequisitionStatusListSize(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddReqButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstReqName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRequester(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSubmittedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatusOfFirstReq(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReqAction(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnDeleteReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isRecallReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isDeleteReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToNaviagteToNextPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCreateRecieptActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnReturnedForAmendInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isEditPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCancelPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPerformFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnInApprovalInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnBuyersDeskInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnRejectedInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnReleasedInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnOrderingInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnCopyActionReq(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	public void clickOnDraftInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isCopyActionReqAvailable(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	public void searchRequisitionByReqNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException;

	public boolean isDeletedReqPresent(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException;

	public boolean isReqPresentInCart(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public void clickOnProceedWithReqItemsOnlyButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReqNumberRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnReqItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean clickOnReqAuditVerIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnCancelActionReq(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickCancelActionReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCancelComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException;

	public boolean isReqSuccessfullySubmitted(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickApprovalReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean toHoverUponRequistionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fetchRequisitionBillingAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqStatusPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqNamePresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqRequesterPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqSubmittedonPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqAmountPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToApplyAscendingSort(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToApplyDescendingSort(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToApplyAscendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToApplyDescendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionSubumitionDateIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqStatusPresentInStatusFilter(WebDriver driver, String testCaseName, String id) throws ActionBotException;

	void clickOnExpandReleasedInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	List<WebElement> fetchRequisitionNumbers(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnLinkRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if status filter is present
	public boolean isStatusFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if requisition number filter is present
	public boolean isRequisitionNumberFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if Requisition Name filter is present
	public boolean isRequisitionNameFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if Requester filter is present
	public boolean isRequesterFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if submittedOn filter is present
	public boolean isSubmittedOnFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if Amount filter is present
	public boolean isAmountFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//to check if Actions filter is present
	public boolean isActionsFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequisitionExternalId(WebDriver driver, String testCaseName, String requisitonId) throws ActionBotException;

	public String getRequisitionId(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecallLink_ReqHover(WebDriver driver, String testCaseName) throws ActionBotException;

	void clearRequisitionNameFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnExpandInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandReleasedInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearRequisitionNumberFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isPopUpProceedWithReqAndExistingCartItemsPreset(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickProceedWithReqAndExistingCartItems(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isPopUpProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException;

}
