package com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPagePurchaseOrderListing
{

	final static UI_Elements	PURCHASE_ORDER_FILTER_STATUS_LINK				= UIFactory.getElements("PURCHASE_ORDER_FILTER_STATUS_LINK");

	final static UI_Elements	PURCHASE_ORDER_STATUS_RELEASED					= UIFactory.getElements("PURCHASE_ORDER_STATUS_RELEASED");
	final static UI_Elements	PURCHASE_ORDER_STATUS_INPROGRESS				= UIFactory.getElements("PURCHASE_ORDER_STATUS_INPROGRESS");

	final static UI_Elements	PURCHASE_ORDER_STATUS_FILTER_LINK				= UIFactory.getElements("PURCHASE_ORDER_STATUS_FILTER_LINK");

	final static UI_Elements	PURCHASE_ORDER_ACTIONS_BOX						= UIFactory.getElements("PURCHASE_ORDER_ACTIONS_BOX");

	final static UI_Elements	PURCHASE_ORDER_STATUS_DRAFT						= UIFactory.getElements("PURCHASE_ORDER_STATUS_DRAFT");
	final static UI_Elements	PURCHASE_ORDER_STATUS_RETURNED					= UIFactory.getElements("PURCHASE_ORDER_STATUS_RETURNED");
	static UI_Elements			TEXT_BOX_PO_NO									= UIFactory.getElements("TEXT_BOX_PO_NO");
	final static UI_Elements	TEXTBOX_ORDER_DESCRIPTION						= UIFactory.getElements("TEXTBOX_ORDER_DESCRIPTION");
	static UI_Elements			FIRST_PO_LINK									= UIFactory.getElements("FIRST_PO_LINK");
	final static UI_Elements	FIRST_PO_ORDER_DESCRIPTION						= UIFactory.getElements("FIRST_PO_ORDER_DESCRIPTION");
	static UI_Elements			STATUS_OF_FIRST_PO								= UIFactory.getElements("STATUS_OF_FIRST_PO");
	static UI_Elements			FIRST_ROW_SUPPLIER_NAME_PO_LISTING				= UIFactory.getElements("FIRST_ROW_SUPPLIER_NAME_PO_LISTING");
	static UI_Elements			FIRST_ROW_TOTAL_AMOUNT_PO_LISTING				= UIFactory.getElements("FIRST_ROW_TOTAL_AMOUNT_PO_LISTING");
	static UI_Elements			SORT_PURCHASE_NUMBER_PO_LISTING					= UIFactory.getElements("SORT_PURCHASE_NUMBER_PO_LISTING");
	static UI_Elements			SORT_RELEASED_DATE_PO_LISTING					= UIFactory.getElements("SORT_RELEASED_DATE_PO_LISTING");
	static UI_Elements			STATUS_PO_CLEAR_FILTER							= UIFactory.getElements("STATUS_PO_CLEAR_FILTER");
	static UI_Elements			DATE_PO_CLEAR_FILTER							= UIFactory.getElements("DATE_PO_CLEAR_FILTER");
	static UI_Elements			AMOUNT_PO_CLEAR_FILTER							= UIFactory.getElements("AMOUNT_PO_CLEAR_FILTER");
	static UI_Elements			TYPE_PO_CLEAR_FILTER							= UIFactory.getElements("TYPE_PO_CLEAR_FILTER");

	static UI_Elements			BUYER_PO_LISTING								= UIFactory.getElements("BUYER_PO_LISTING");
	static UI_Elements			PO_NO_CLEAR_FILTER								= UIFactory.getElements("PONO_CLEAR_FILTER");

	static UI_Elements			TEXT_BOX_SUPPLIER								= UIFactory.getElements("TEXT_BOX_SUPPLIER");

	static UI_Elements			BUYER_PO_CLEAR_FILTER							= UIFactory.getElements("BUYER_PO_CLEAR_FILTER");

	static UI_Elements			SUPPLIER_PO_CLEAR_FILTER						= UIFactory.getElements("SUPPLIER_PO_CLEAR_FILTER");

	final static UI_Elements	PURCHASE_ORDER_STATUS_REJECTED					= UIFactory.getElements("PURCHASE_ORDER_STATUS_REJECTED");

	final static UI_Elements	PURCHASE_ORDER_STATUS_CANCEL					= UIFactory.getElements("PURCHASE_ORDER_STATUS_CANCEL");

	final static UI_Elements	PURCHASE_ORDER_STATUS_CLOSED					= UIFactory.getElements("PURCHASE_ORDER_STATUS_CLOSED");

	final static UI_Elements	PURCHASE_ORDER_STATUS_EXPIRED					= UIFactory.getElements("PURCHASE_ORDER_STATUS_EXPIRED");

	final static UI_Elements	PURCHASE_ORDER_STATUS_SCHEDULE					= UIFactory.getElements("PURCHASE_ORDER_STATUS_SCHEDULED");

	final static UI_Elements	PURCHASE_ORDER_STATUS_PAYMENTSTATUS				= UIFactory.getElements("PURCHASE_ORDER_STATUS_PAYMENTSTATUS");

	static UI_Elements			RECALLING_PROCESSING_DIV						= UIFactory.getElements("RECALLING_PROCESSING_DIV");
	static UI_Elements			LINK_PO_ACTIONS									= UIFactory.getElements("LINK_PO_ACTIONS");
	static UI_Elements			PO_LISTING_PROCESSING							= UIFactory.getElements("PO_LISTING_PROCESSING");

	final static UI_Elements	HEADER_PO_NO									= UIFactory.getElements("HEADER_PO_NO");
	final static UI_Elements	HEADER_PO_DATE									= UIFactory.getElements("HEADER_PO_DATE");
	final static UI_Elements	HEADER_PO_AMOUNT								= UIFactory.getElements("HEADER_PO_AMOUNT");
	final static UI_Elements	PO_DATE_FILTER_STATUS							= UIFactory.getElements("PO_DATE_FILTER_STATUS");
	final static UI_Elements	PO_DATE_FIELD									= UIFactory.getElements("PO_DATE_FIELD");
	final static UI_Elements	PO_DATE_FIELD_MAX								= UIFactory.getElements("PO_DATE_FIELD_MAX");
	final static UI_Elements	PO_DATE_FILTER_BUTTON							= UIFactory.getElements("PO_DATE_FILTER_BUTTON");
	final static UI_Elements	REQUIRED_BY_DATE_PICKER							= UIFactory.getElements("REQUIRED_BY_DATE_PICKER");
	final static UI_Elements	SELECT_MONTH									= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements	SELECT_YEAR										= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements	REQUIRED_BY_DATE								= UIFactory.getElements("REQUIRED_BY_DATE");
	final static UI_Elements	STAUS_BASED_FILTER								= UIFactory.getElements("STAUS_BASED_FILTER");
	final static UI_Elements	TEXT_BOX_BUYER									= UIFactory.getElements("TEXT_BOX_BUYER");
	final static UI_Elements	FIRST_BUYER_NAME								= UIFactory.getElements("FIRST_BUYER_NAME");
	final static UI_Elements	STATUS_FILTER_CANCEL_BUTTOM						= UIFactory.getElements("STATUS_FILTER_CANCEL_BUTTOM");

	final static UI_Elements	PO_LISTING_NO_OF_RECORDS_LABEL					= UIFactory.getElements("PO_LISTING_NO_OF_RECORDS_LABEL");
	final static UI_Elements	CHECKBOX_TYPE_FILTER_STANDARD					= UIFactory.getElements("CHECKBOX_TYPE_FILTER_STANDARD");
	final static UI_Elements	CHECKBOX_TYPE_FILTER_RELEASE					= UIFactory.getElements("CHECKBOX_TYPE_FILTER_RELEASE");
	final static UI_Elements	CHECKBOX_TYPE_FILTER_BLANKET					= UIFactory.getElements("CHECKBOX_TYPE_FILTER_BLANKET");

	final static UI_Elements	PO_FILTER_STATUS_TEXT							= UIFactory.getElements("PO_FILTER_STATUS_TEXT");

	final static UI_Elements	BUTTON_TYPE_FILTER								= UIFactory.getElements("BUTTON_TYPE_FILTER");
	final static UI_Elements	TAB_TYPE_FILTER									= UIFactory.getElements("TAB_TYPE_FILTER");
	final static UI_Elements	TAB_AMOUNT_FILTER								= UIFactory.getElements("TAB_AMOUNT_FILTER");
	final static UI_Elements	CHECKBOX_AMOUNT_FILTER_INR_CURRENCY				= UIFactory.getElements("CHECKBOX_AMOUNT_FILTER_INR_CURRENCY");
	final static UI_Elements	CHECKBOX_AMOUNT_FILTER_USD_CURRENCY				= UIFactory.getElements("CHECKBOX_AMOUNT_FILTER_USD_CURRENCY");
	final static UI_Elements	BUTTON_AMOUNT_FILTER							= UIFactory.getElements("BUTTON_AMOUNT_FILTER");
	final UI_Elements			TEXTBOX_CLOSE_COMMENT_PO						= UIFactory.getElements("TEXTBOX_CLOSE_COMMENT_PO");
	final UI_Elements			CHECKBOX_ALLOW_CREATING_INVOICE					= UIFactory.getElements("CHECKBOX_ALLOW_CREATING_INVOICE");
	final UI_Elements			BUTTON_CLOSE_PO									= UIFactory.getElements("BUTTON_CLOSE_PO");
	final UI_Elements			BUTTON_CANCEL_CLOSE_PO_BOX						= UIFactory.getElements("BUTTON_CANCEL_CLOSE_PO_BOX");
	final UI_Elements			LINK_DOWNLOAD_PO_FROM_TOOLTIP					= UIFactory.getElements("LINK_DOWNLOAD");
	final UI_Elements			LINK_AMEND_PO_FROM_TOOLTIP						= UIFactory.getElements("LINK_AMEND_PO_FROM_TOOLTIP");
	final UI_Elements			LINK_PO_NUMBER									= UIFactory.getElements("LINK_PO_NUMBER");
	final UI_Elements			LINK_DELETE_ACTIONS								= UIFactory.getElements("LINK_DELETE_ACTIONS");
	final UI_Elements			HOVER_MESSAGE_PARKED_PO							= UIFactory.getElements("HOVER_MESSAGE_PARKED_PO");
	final UI_Elements			RECORDS_INFO_BEFORE_FILTER						= UIFactory.getElements("RECORDS_INFO_BEFORE_FILTER");
	final UI_Elements			RECORDS_INFO_AFTER_FILTER						= UIFactory.getElements("RECORDS_INFO_AFTER_FILTER");
	static UI_Elements			EXPAND_RELEASED_STATUS							= UIFactory.getElements("EXPAND_RELEASED_STATUS");
	final UI_Elements			CHECKBOX_STATUS_FILTER_IN_APPROVAL				= UIFactory.getElements("CHECKBOX_STATUS_FILTER_IN_APPROVAL");
	final UI_Elements			EXPAND_IN_PROGRESS_STATUS_FILTER				= UIFactory.getElements("EXPAND_IN_PROGRESS_STATUS_FILTER");
	final UI_Elements			SUCCESSFULL_AMENDED_PO_MESSAGE					= UIFactory.getElements("SUCCESSFULL_AMENDED_PO_MESSAGE");
	final UI_Elements			LINK_VIEW_AMMENDED_PO_ON_PO_LISTING				= UIFactory.getElements("LINK_VIEW_AMMENDED_PO_ON_PO_LISTING");
	static UI_Elements			LABEL_FIRST_PO_TYPE								= UIFactory.getElements("LABEL_FIRST_PO_TYPE");
	static UI_Elements			EXPAND_RELEASE_NODE								= UIFactory.getElements("EXPAND_RELEASE_NODE");
	static UI_Elements			TEXTBOX_MIN_AMOUNT_FILTER						= UIFactory.getElements("TEXTBOX_MIN_AMOUNT_FILTER");
	static UI_Elements			TEXYBOX_MAX_AMOUNT_FILTER						= UIFactory.getElements("TEXYBOX_MAX_AMOUNT_FILTER");
	static UI_Elements			PO_NO_EXCEED_ERROR_MSG							= UIFactory.getElements("PO_NO_EXCEED_ERROR_MSG");

	static UI_Elements			PURCHASE_ORDER_STATUS_UNCONFIRMED				= UIFactory.getElements("PURCHASE_ORDER_STATUS_UNCONFIRMED");
	static UI_Elements			ICON_INVOICED_PO_STATUS							= UIFactory.getElements("ICON_INVOICED_PO_STATUS");
	static UI_Elements			PO_WAITING_FOR_APPROVAL_ALERT					= UIFactory.getElements("PO_WAITING_FOR_APPROVAL_ALERT");
	UI_Elements					ICON_NOT_SENT_TO_SUPPLIER						= UIFactory.getElements("ICON_NOT_SENT_TO_SUPPLIER");
	UI_Elements					LABEL_STATUS_DETAILS_ON_MOUSE_HOVER				= UIFactory.getElements("LABEL_STATUS_DETAILS_ON_MOUSE_HOVER");

	UI_Elements					BUTTON_EXPAND_FOR_CONFIRMATION_FILER			= UIFactory.getElements("BUTTON_EXPAND_FOR_CONFIRMATION_FILER");
	UI_Elements					CHECKBOX_NOT_SENT_TO_SUPPLIER_FILTER			= UIFactory.getElements("CHECKBOX_NOT_SENT_TO_SUPPLIER_FILTER");
	UI_Elements					LINK_EXPAND_PAYMENT_STATUS_FILTER				= UIFactory.getElements("LINK_EXPAND_PAYMENT_STATUS_FILTER");
	UI_Elements					CHECKBOX_NOT_PAID_STATUS_FILTER					= UIFactory.getElements("CHECKBOX_NOT_PAID_STATUS_FILTER");
	UI_Elements					CHECKBOX_PARTIALLY_PAID_STATUS_FILTER			= UIFactory.getElements("CHECKBOX_PARTIALLY_PAID_STATUS_FILTER");
	UI_Elements					CHECKBOX_FULLY_PAID_STATUS_FILTER				= UIFactory.getElements("CHECKBOX_FULLY_PAID_STATUS_FILTER");
	UI_Elements					CHECKBOX_PAYMENT_NOT_APPLICABLE_STATUS_FILTER	= UIFactory.getElements("CHECKBOX_PAYMENT_NOT_APPLICABLE_STATUS_FILTER");
	UI_Elements					CHECKBOX_CONFIRMED_STATUS_FILTER				= UIFactory.getElements("CHECKBOX_CONFIRMED_STATUS_FILTER");

	String						xpath1_polisting_row							= ".//*[@id='polisting']//tr[.//*[contains(text(),'";
	String						xpath2_supplierName								= "')]]/td[contains(@class,'supplier')]";
	String						xpath2_totalAmount								= "')]]/td[contains(@class,'grossTotalAmount')]";

	static UI_Elements			RELEASE_PO_LINK									= UIFactory.getElements("RELEASE_PO_LINK");
	static UI_Elements			CANCEL_PO_LINK									= UIFactory.getElements("CANCEL_PO_LINK");
	static UI_Elements			POPUP_ALERT_CONTINUE							= UIFactory.getElements("POPUP_ALERT_CONTINUE");

	static UI_Elements			PO_NUMBER_SORTING								= UIFactory.getElements("PO_NUMBER_SORTING");
	static UI_Elements			PO_DATE_SORTING									= UIFactory.getElements("PO_DATE_SORTING");
	static UI_Elements			PO_AMOUNT_SORITNG								= UIFactory.getElements("PO_AMOUNT_SORTING");
	static UI_Elements			PURCHASE_ORDER_STATUS_APPLY						= UIFactory.getElements("PURCHASE_ORDER_STATUS_APPLY");

	static UI_Elements			TEXTBOX_ORDER_DESCRIPTION_PO_LISTING_PAGE		= UIFactory.getElements("TEXTBOX_ORDER_DESCRIPTION_PO_LISTING_PAGE");
	static UI_Elements			STATUS_DETAILS									= UIFactory.getElements("STATUS_DETAILS");
	static UI_Elements			DELIVERY_ICON									= UIFactory.getElements("DELIVERY_ICON");
	static UI_Elements			INVOICE_ICON									= UIFactory.getElements("INVOICE_ICON");
	static UI_Elements			STATUS_FILTER_TAB_PO							= UIFactory.getElements("STATUS_FILTER_TAB_PO");
	static UI_Elements			STATUS_DRAFT_PO									= UIFactory.getElements("STATUS_DRAFT_PO");
	static UI_Elements			FILTER_BUTTON_PO								= UIFactory.getElements("FILTER_BUTTON_PO");
	static UI_Elements			STATUS_IN_PROGRESS_PO							= UIFactory.getElements("STATUS_IN_PROGRESS_PO");
	static UI_Elements			STATUS_RELEASED_PO								= UIFactory.getElements("STATUS_RELEASED_PO");
	static UI_Elements			STATUS_CLOSED_PO								= UIFactory.getElements("STATUS_CLOSED_PO");
	static UI_Elements			STATUS_CANCELLED_PO								= UIFactory.getElements("STATUS_CANCELLED_PO");
	static UI_Elements			STATUS_REJECTED_PO								= UIFactory.getElements("STATUS_REJECTED_PO");
	static UI_Elements			STATUS_EXPIRED_PO								= UIFactory.getElements("STATUS_EXPIRED_PO");
	static UI_Elements			STATUS_RETURNED_PO								= UIFactory.getElements("STATUS_RETURNED_PO");
	final static UI_Elements	EXPAND_DELIVERY_STATUS_FILTER					= UIFactory.getElements("EXPAND_DELIVERY_STATUS_FILTER");
	final static UI_Elements	CHECKBOX_NOT_DELIVERED_STATUS_FILTER			= UIFactory.getElements("CHECKBOX_NOT_DELIVERED_STATUS_FILTER");
	final static UI_Elements	CHECKBOX_PARTIALLY_RECEIVED_STATUS_FILTER		= UIFactory.getElements("CHECKBOX_PARTIALLY_RECEIVED_STATUS_FILTER");
	final static UI_Elements	CHECKBOX_FULLY_RECEIVED_STATUS_FILTER			= UIFactory.getElements("CHECKBOX_FULLY_RECEIVED_STATUS_FILTER");
	final static UI_Elements	CLEAR_STATUS_FILTER_PO_LISTING					= UIFactory.getElements("CLEAR_STATUS_FILTER_PO_LISTING");

	public void clickOnActionsDropdownLink(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnClosed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDateFilterStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDraftPOLink(WebDriver driver, String testCaseName, int index) throws Exception;

	boolean clickOnDraftStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnExpired(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterDateButtom(WebDriver driver, String testCaseName) throws Exception;

	public void clickOnFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterStatusCancelButtom(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterStatusLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnInProgressStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnPayements(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPoActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPoLink(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean clickOnRejected(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnReleasedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnReturned(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnSchdule(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBuyer(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String fillSupplier(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String fillPoDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillPoNo(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String fillOrderDescription(WebDriver driver, String testCaseName, String orderDesc) throws ActionBotException;

	public String getFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstPoOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstPoStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowBuyerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowPoDate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getFirstRowSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRowTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeleteOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDraftStatusBasedFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMaxAndMinDateRangeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoOfRecordsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfPONos(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTypeFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStandardFilterOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReleaseFilterOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBlanketFilterOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmountFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnINRCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUSDCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCommentBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowCreatingInvoiceOptionPrsent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPoNOExceedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelClosePOBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDownloadPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmmendPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOParkedMessageDisplayedCorrectly(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoOfRecordsBeforeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoOfRecordsAfterFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandInProgressStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInApprovalStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearFilter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnExpandReleaseFilterNode(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSuccessfulAmendedMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFilterDateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException;

	public int enterMinAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int minAmount) throws ActionBotException;

	public int enterMaxAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int maxAmount) throws ActionBotException;

	public void clickOnExpandConfirmationStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUnConfirmedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverAndClickOnIconInvoicedPOStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpiredStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertOfPOWaitingForApprovalPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierName(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String getTotalAmount(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String fillCloseCommentBox(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException;

	public void clickOnClosePOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNotSentToSupplierIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatusDetailsOfNotSentToSupplierIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNotSentToSupplierFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfIconsOfNotSentToSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnNotPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnPartiallyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnFullyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnPayementNotApplicablePaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandPaymentStatusFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOWithGivenAmountPresentInListing(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public String getPOWithGivenAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	boolean clickonReleaseActionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickonCancelActionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAlertContinueButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPONumberSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPoDateSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPOAmountSorting(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPurchaseOrderExternalId(WebDriver driver, String testCaseName, String purchaseOrderId) throws ActionBotException;

	void clickOnHeaderPoDate(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnHeaderPoAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandDeliveryStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public boolean clickOnNotDeliveredStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPartiallyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnFullyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPOId(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getPoActionsLinks(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStatusFilterTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

}
