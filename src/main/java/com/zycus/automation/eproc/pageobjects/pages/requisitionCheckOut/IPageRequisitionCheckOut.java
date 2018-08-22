package com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.IPageMyFavorites;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageRequisitionCheckOut
{

	final static UI_Elements		TEXTBOX_REQUISITION_NAME						= UIFactory.getElements("TEXTBOX_REQUISITION_NAME");
	final static UI_Elements		URGENT_REQUIREMENT								= UIFactory.getElements("URGENT_REQUIREMENT");
	final static UI_Elements		REASON_FOR_ORDERING								= UIFactory.getElements("REASON_FOR_ORDERING");
	final static UI_Elements		TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE		= UIFactory.getElements("TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE");
	final static UI_Elements		ON_BEHALF_OF									= UIFactory.getElements("ON_BEHALF_OF");
	final static UI_Elements		TEXTBOX_ASSIGNED_BUYER							= UIFactory.getElements("TEXTBOX_ASSIGNED_BUYER");
	final static UI_Elements		PURCHASE_TYPE									= UIFactory.getElements("PURCHASE_TYPE");
	final static UI_Elements		EDIT_BILLING_DELIVERY_COSTBOOKING_INFO			= UIFactory.getElements("EDIT_BILLING_DELIVERY_COSTBOOKING_INFO");
	final static UI_Elements		DELIVERY_ADDRESS								= UIFactory.getElements("DELIVERY_ADDRESS");
	final static UI_Elements		BILL_TO_ADDRESS									= UIFactory.getElements("BILL_TO_ADDRESS");
	final static UI_Elements		COST_CENTER_HEADER								= UIFactory.getElements("COST_CENTER_HEADER");
	final static UI_Elements		BUDGET_HEADER									= UIFactory.getElements("BUDGET_HEADER");
	final static UI_Elements		DELIVER_TO_HEADER								= UIFactory.getElements("DELIVER_TO_HEADER");
	final static UI_Elements		ORGANIZATION_UNIT								= UIFactory.getElements("ORGANIZATION_UNIT");
	final static UI_Elements		CLEAR_REQUIRED_BY_DATE							= UIFactory.getElements("CLEAR_REQUIRED_BY_DATE");
	final static UI_Elements		REQUIRED_BY_DATE								= UIFactory.getElements("REQUIRED_BY_DATE");
	final static UI_Elements		RETROSPECTIVE_PURCHASE							= UIFactory.getElements("RETROSPECTIVE_PURCHASE");
	final static UI_Elements		EXPAND_ALL										= UIFactory.getElements("EXPAND_ALL");
	final static UI_Elements		CHANGE_MULTIPLE									= UIFactory.getElements("CHANGE_MULTIPLE");
	final static UI_Elements		ADD_ITEM_ON_CHECKOUT							= UIFactory.getElements("ADD_ITEM_ON_CHECKOUT");
	final static UI_Elements		CURRENCY_WISE_TOTAL								= UIFactory.getElements("CURRENCY_WISE_TOTAL");
	final static UI_Elements		I_AM_DONE										= UIFactory.getElements("I_AM_DONE");
	final static UI_Elements		SAVE_AS_DRAFT									= UIFactory.getElements("SAVE_AS_DRAFT");
	final static UI_Elements		CANCLE_REQUISITION								= UIFactory.getElements("CANCLE_REQUISITION");
	final static UI_Elements		CONTINUE_REQUISITION							= UIFactory.getElements("CONTINUE_REQUISITION");
	final static UI_Elements		REQUIRED_BY_DATE_PICKER							= UIFactory.getElements("REQUIRED_BY_DATE_PICKER");
	final static UI_Elements		SELECT_MONTH									= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements		SELECT_YEAR										= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements		SELECT_APPROVER_LIST							= UIFactory.getElements("SELECT_APPROVER_LIST");
	final static UI_Elements		MSGBOX											= UIFactory.getElements("MSGBOX");
	final static UI_Elements		SELECT_APPROVAL_BUTTON							= UIFactory.getElements("SELECT_APPROVAL_BUTTON");
	final static UI_Elements		CONFIRM_REQ										= UIFactory.getElements("CONFIRM_REQ");
	final static UI_Elements		SUBMIT_REQ_YES									= UIFactory.getElements("SUBMIT_REQ_YES");
	final static UI_Elements		SETTLEMENT_VIA									= UIFactory.getElements("SETTLEMENT_VIA");
	final static UI_Elements		DRAFT_SAVED_SUCCESS								= UIFactory.getElements("DRAFT_SAVED_SUCCESS");
	final static UI_Elements		REQUISITION_SUBMIT_PROCESSING_DIV				= UIFactory.getElements("REQUISITION_SUBMIT_PROCESSING_DIV");
	static UI_Elements				SELECT_PCARD									= UIFactory.getElements("SELECT_PCARD");
	static UI_Elements				LABEL_PEFORM_SECTION_ON_CHECKOUT_PAGE			= UIFactory.getElements("LABEL_PEFORM_SECTION_ON_CHECKOUT_PAGE");
	static UI_Elements				LABEL_PEFORM_FIELD_ON_CHECKOUT_PAGE				= UIFactory.getElements("LABEL_PEFORM_FIELD_ON_CHECKOUT_PAGE");

	static UI_Elements				TEXTBOX_PEFORM_FIELD_ON_CHECKOUT_PAGE			= UIFactory.getElements("TEXTBOX_PEFORM_FIELD_ON_CHECKOUT_PAGE");
	static UI_Elements				LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE			= UIFactory.getElements("LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE");
	static UI_Elements				LINK_DELETE_ATTACHMENT_ON_CHECKOUT_PAGE			= UIFactory.getElements("LINK_DELETE_ATTACHMENT_ON_CHECKOUT_PAGE");
	static UI_Elements				ATTACHED_FILE_NAME_REQ							= UIFactory.getElements("ATTACHED_FILE_NAME_REQ");
	static UI_Elements				ATTACHMENT_ITEM_LEVEL_FILE_NAME					= UIFactory.getElements("ATTACHMENT_ITEM_LEVEL_FILE_NAME");

	static UI_Elements				LABEL_WORKFLOW_FOR_FORKING						= UIFactory.getElements("LABEL_WORKFLOW_FOR_FORKING");
	static UI_Elements				CHECKBOX_MODIFY_WORKFLOW_SETTING				= UIFactory.getElements("CHECKBOX_MODIFY_WORKFLOW_SETTING");

	static UI_Elements				LABEL_PAYMENT_METHOD_ON_CHECKOUT_PAGE			= UIFactory.getElements("LABEL_PAYMENT_METHOD_ON_CHECKOUT_PAGE");

	static UI_Elements				PROGRESSING_DIV_STATUS_OVERLAY_PLEASE_WAIT		= UIFactory.getElements("PROGRESSING_DIV_STATUS_OVERLAY_PLEASE_WAIT");
	static UI_Elements				LABEL_TOAL_PRICE_CHECKOUT_HEAD					= UIFactory.getElements("LABEL_TOAL_PRICE_CHECKOUT_HEAD");
	static UI_Elements				LABEL_FIRST_APPROVER_NAME_AS_ON_CHECKOUT_PAGE	= UIFactory.getElements("LABEL_FIRST_APPROVER_NAME_AS_ON_CHECKOUT_PAGE");
	static UI_Elements				SHOW_ALL_PO_BTN									= UIFactory.getElements("SHOW_ALL_PO_BTN");

	static UI_Elements				DELIVERY_ITEM_EDIT								= UIFactory.getElements("DELIVERY_ITEM_EDIT");
	static UI_Elements				REQ_CAN_NOT_BE_LINKED_ERROR_MSG					= UIFactory.getElements("REQ_CAN_NOT_BE_LINKED_ERROR_MSG");
	static UI_Elements				HEADER_LEVEL_PROJECT_DETAILS					= UIFactory.getElements("HEADER_LEVEL_PROJECT_DETAILS");
	static UI_Elements				ACCOUNTING_DETAILS								= UIFactory.getElements("ACCOUNTING_DETAILS");
	static UI_Elements				HEADER_CHECKOUT_ICON							= UIFactory.getElements("HEADER_CHECKOUT_ICON");
	static UI_Elements				CLOSE_MODAL_CURRENCY_WISE_TOTAL_LINK			= UIFactory.getElements("CLOSE_MODAL_CURRENCY_WISE_TOTAL_LINK");
	static String					xpath1_item_summary								= ".//*[@id='item_summary_";
	static String					xpath2_accountingData_expandAll					= "']//*[contains(@class,'accounting qtipCss')][string-length(text()) >0]";
	static String					xpath1_item_details								= ".//*[@id='itemName_";													//".//*[@id='item_";//eProc version R17.11.1.0
	static String					xpath2_item_name								= "']//a[contains(@class,'itemName')]";
	static String					xpath1_itemId									= ".//a[contains(@class,'itemName')][contains(text(),'";
	static String					xpath2_itemId									= "')]/parent::td/parent::tr";
	static UI_Elements				CLICK_HERE_LINK_TO_SHOW_ERRORS					= UIFactory.getElements("CLICK_HERE_LINK_TO_SHOW_ERRORS");
	static UI_Elements				LABEL_ITEM_LEVEL_ACCOUNTING_INFO_GL_ACCOUNT		= UIFactory.getElements("LABEL_ITEM_LEVEL_ACCOUNTING_INFO_GL_ACCOUNT");
	static UI_Elements				DROPDOWN_ASSIGNED_BUYER							= UIFactory.getElements("DROPDOWN_ASSIGNED_BUYER");
	static UI_Elements				SELECT_ASSIGNED_BUYER_SINGLE_ICON				= UIFactory.getElements("SELECT_ASSIGNED_BUYER_SINGLE_ICON");
	static UI_Elements				SELECT_ASSIGNED_BUYER_GROUP_ICON				= UIFactory.getElements("SELECT_ASSIGNED_BUYER_GROUP_ICON");
	static UI_Elements				ALERT_AND_ERROR_VALIDATION_CHECKOUT				= UIFactory.getElements("ALERT_AND_ERROR_VALIDATION_CHECKOUT");
	static UI_Elements				BUTTON_OK_FOR_VALIDATION_POPUP_CHECKOUT			= UIFactory.getElements("BUTTON_OK_FOR_VALIDATION_POPUP_CHECKOUT");
	static UI_Elements				BUTTON_SEND_FOR_APPROVAL_NO						= UIFactory.getElements("BUTTON_SEND_FOR_APPROVAL_NO");
	static UI_Elements				ICON_REMOVE_ASSIGNED_BUYER_CHECKOUT_PAGE		= UIFactory.getElements("ICON_REMOVE_ASSIGNED_BUYER_CHECKOUT_PAGE");

	static String					xpath1_itemLevelCurrency						= ".//*[@id='item_";
	static String					xpath2_itemLevelCurrency						= "']/td[contains(@class,'price')]/span[contains(@class,'lblCurrency')]";
	UI_Elements						LABEL_REQUESTER_NODE_WORKFLOW_EDIT_REQ			= UIFactory.getElements("LABEL_REQUESTER_NODE_WORKFLOW_EDIT_REQ");
	UI_Elements						LABEL_ASSIGNED_BUYER_ON_CHECKOUT_PAGE			= UIFactory.getElements("LABEL_ASSIGNED_BUYER_ON_CHECKOUT_PAGE");

	UI_Elements						LABEL_COST_CENTER_AT_HEADER_SUMMARY				= UIFactory.getElements("LABEL_COST_CENTER_AT_HEADER_SUMMARY");
	UI_Elements						ERROR_ICON_SOURCING_STATUS						= UIFactory.getElements("ERROR_ICON_SOURCING_STATUS");
	UI_Elements						TEXTBOX_ASSIGNED_BUYER_GROUP					= UIFactory.getElements("TEXTBOX_ASSIGNED_BUYER_GROUP");

	UI_Elements						BUTTON_EDIT_ITEM_SUMMARY						= UIFactory.getElements("BUTTON_EDIT_ITEM_SUMMARY");
	UI_Elements						ICON_MISMATCH_IN_SETTLEMENT_VIA_ERROR_MSG		= UIFactory.getElements("ICON_MISMATCH_IN_SETTLEMENT_VIA_ERROR_MSG");
	UI_Elements						LABEL_EFORM_SUB_SECTION							= UIFactory.getElements("LABEL_EFORM_SUB_SECTION");
	UI_Elements						LABEL_EFORM_TITLE_SECTION						= UIFactory.getElements("LABEL_EFORM_TITLE_SECTION");
	UI_Elements						TEXTBOX_EFORM_FIELD_CHECKOUT_ITEM_DETAILS		= UIFactory.getElements("TEXTBOX_EFORM_FIELD_CHECKOUT_ITEM_DETAILS");
	UI_Elements						ERROR_PO_NO_ATTACHMENT							= UIFactory.getElements("ERROR_PO_NO_ATTACHMENT");
	UI_Elements						LINK_EFORM_ADD_ATTACHMENT_CHECKOUT				= UIFactory.getElements("LINK_EFORM_ADD_ATTACHMENT_CHECKOUT");
	UI_Elements						PROGRESSING_DIV_UPDATE_REQUISITION				= UIFactory.getElements("PROGRESSING_DIV_UPDATE_REQUISITION");
	UI_Elements						LOADING_DIV_WORKFLOW_TRAIL						= UIFactory.getElements("LOADING_DIV_WORKFLOW_TRAIL");
	UI_Elements						LINK_VIEW_WORKFLOW								= UIFactory.getElements("LINK_VIEW_WORKFLOW");
	UI_Elements						BUTTON_CONTINUE_CONFIRM_POPUP					= UIFactory.getElements("BUTTON_CONTINUE_CONFIRM_POPUP");

	UI_Elements						BUDGET_LINE_ERROR_MESSAGE						= UIFactory.getElements("BUDGET_LINE_ERROR_MESSAGE");

	static String					xpath1_qtyAmtCurrency							= ".//*[@id='item_";
	static String					xpath2_qtyAmtCurrency							= "']//span[contains(@class,'lblCurrencyQty')]";

	final static UI_Elements		DELIVERY_DELIVER_TO								= UIFactory.getElements("DELIVERY_DELIVER_TO");

	final static UI_Elements		DELIVERY_OU_ADDRESS								= UIFactory.getElements("DELIVERY_OU_ADDRESS");

	final static UI_Elements		BUSINESS_UNIT									= UIFactory.getElements("BUSINESS_UNIT");

	final static UI_Elements		COSTBOOKING_SINGLE_CC							= UIFactory.getElements("COSTBOOKING_SINGLE_CC");

	final static UI_Elements		TEXTBOX_ITEM_DETAILS_GL_ACCOUNT					= UIFactory.getElements("TEXTBOX_ITEM_DETAILS_GL_ACCOUNT");
	final static UI_Elements		COST_ALLOCATION									= UIFactory.getElements("COST_ALLOCATION");

	final static UI_Elements		BILLING_CURRENCY								= UIFactory.getElements("BILLING_CURRENCY");

	final static UI_Elements		CLOSE_REQUISTION_SUMMARY						= UIFactory.getElements("CLOSE_REQUISTION_SUMMARY");

	final static UI_Elements		COSTBOOKING_SINGLE_PROJECT						= UIFactory.getElements("COSTBOOKING_SINGLE_PROJECT");

	final static UI_Elements		COSTBOOKING_SINGLE_BUDGET						= UIFactory.getElements("COSTBOOKING_SINGLE_BUDGET");

	final static UI_Elements		SAVEREQSUMMARY									= UIFactory.getElements("SAVEREQSUMMARY");

	final static UI_Elements		DELIVERY_OPTION_MULTI_SPLIT						= UIFactory.getElements("DELIVERY_OPTION_MULTI_SPLIT");

	final static UI_Elements		ITEMSUMMARY_SAVE								= UIFactory.getElements("ITEMSUMMARY_SAVE");
	public final static UI_Elements	GET_PURCHASE_TYPE1								= UIFactory.getElements("GET_PURCHASE_TYPE1");
	public final static UI_Elements	GET_ATTACHMENTS1								= UIFactory.getElements("GET_ATTACHMENTS1");
	public final static UI_Elements	GET_COMMENTS1									= UIFactory.getElements("GET_COMMENTS1");
	public final static UI_Elements	GET_DELIVERY_LOCATION1							= UIFactory.getElements("GET_DELIVERY_LOCATION1");
	public final static UI_Elements	GET_DELIVERY_NAME1								= UIFactory.getElements("GET_DELIVERY_NAME1");
	public final static UI_Elements	GET_COST_CENTER1								= UIFactory.getElements("COST_CENTER1");
	public final static UI_Elements	GET_GL_ACCOUNT1									= UIFactory.getElements("GL_ACCOUNT1");
	public final static UI_Elements	FETCH_ITEM_LEVEL_GLACCOUNT						= UIFactory.getElements("FETCH_ITEM_LEVEL_GL-ACCOUNT");

	public final static UI_Elements	EXPAND_ITEM										= UIFactory.getElements("EXPAND_ITEM");

	public final static UI_Elements	REQUIRED_BY_DELIVERY_DATE						= UIFactory.getElements("REQUIRED_BY_DELIVERY_DATE");

	public final static UI_Elements	ITEM_EDIT_BUTTON								= UIFactory.getElements("ITEM_EDIT_BUTTON");

	public final static UI_Elements	EDIT_DELIVERY_REQUISITION_SUMMARY				= UIFactory.getElements("EDIT_DELIVERY_REQUISITION_SUMMARY");

	public final static UI_Elements	BILLING_ALLOCATION								= UIFactory.getElements("BILLING_ALLOCATION");

	public final static UI_Elements	MY_ADDRESS										= UIFactory.getElements("MY_ADDRESS");

	public final static UI_Elements	ENTER_NEW_ADDRESS								= UIFactory.getElements("ENTER_NEW_ADDRESS");

	public final static UI_Elements	DELIVERY_MY_ADDRESS_NAME						= UIFactory.getElements("DELIVERY_MY_ADDRESS_NAME");

	public final static UI_Elements	DELIVERY_MY_ADDRESS_STREET1						= UIFactory.getElements("DELIVERY_MY_ADDRESS_STREET1");

	public final static UI_Elements	DELIVERY_MY_ADDRESS_COUNTRY						= UIFactory.getElements("DELIVERY_MY_ADDRESS_COUNTRY");

	public final static UI_Elements	DELIVERY_MY_ADDRESS_CITY						= UIFactory.getElements("DELIVERY_MY_ADDRESS_CITY");

	public final static UI_Elements	YES_CONFIRMATION								= IPageMyFavorites.YES_CONFIRMATION;

	public final static UI_Elements	NO_CONFIRMATION									= IPageMyFavorites.NO_CONFIRMATION;

	public final static UI_Elements	COSTBOOKING_OPTION_MULTIPLE_CC					= UIFactory.getElements("COSTBOOKING_OPTION_MULTIPLE_CC");

	public final static UI_Elements	COST_CENTER1									= UIFactory.getElements("COST_CENTER1");

	public final static UI_Elements	MY_ADDRESS_OPTION								= UIFactory.getElements("MY_ADDRESS_OPTION");

	public final static UI_Elements	CAT_ITEM_POP_DETAILS							= UIFactory.getElements("CAT_ITEM_POP_DETAILS");

	public final static UI_Elements	GUIDED_ITEM_POPUP								= UIFactory.getElements("GUIDED_ITEM_POPUP");

	public final static UI_Elements	REQUIRED_BY_DATE_ERROR_MESSAGE					= UIFactory.getElements("REQUIRED_BY_DATE_ERROR_MESSAGE");

	public final static UI_Elements	PURCHASE_AMOUNT									= UIFactory.getElements("PURCHASE_AMOUNT");

	public final static UI_Elements	EDIT_ITEM_REQUISTION_COST_ALLOCATION			= UIFactory.getElements("EDIT_ITEM_REQUISTION_COST_ALLOCATION");

	public final static UI_Elements	COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT			= UIFactory.getElements("COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT");

	public final static UI_Elements	COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY			= UIFactory.getElements("COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY");

	public final static UI_Elements	HEADER_LEVEL_COST_CENTER_SUMMARY				= UIFactory.getElements("HEADER_LEVEL_COST_CENTER_SUMMARY");

	public final static UI_Elements	HEADER_LEVEL_PROJECT_SUMMARY					= UIFactory.getElements("HEADER_LEVEL_PROJECT_SUMMARY");

	public final static UI_Elements	HEADER_LEVEL_BUDGET_SUMMARY						= UIFactory.getElements("HEADER_LEVEL_BUDGET_SUMMARY");

	public final static UI_Elements	DELIVERY_OPTION_SINGLE_SPLIT					= UIFactory.getElements("DELIVERY_OPTION_SINGLE_SPLIT");

	public final static UI_Elements	DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS			= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS");

	public final static UI_Elements	DELIVERY_SINGLE_SPLIT_DELIVER_TO				= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_DELIVER_TO");

	public final static UI_Elements	DELIVERY_SINGLE_SPLIT_REQUIRED_DATE				= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_REQUIRED_DATE");

	public final static UI_Elements	CHECKOUT_CART_ITEM_QUANTITY						= UIFactory.getElements("CHECKOUT_CART_ITEM_QUANTITY");

	public final static UI_Elements	BILLING_COMPANY									= UIFactory.getElements("BILLING_COMPANY");

	public final static UI_Elements	BILLING_BU										= UIFactory.getElements("BILLING_BU");

	public final static UI_Elements	BILLING_LOCATION								= UIFactory.getElements("BILLING_LOCATION");

	public final static UI_Elements	DELIVERY_MY_ADDRESS_STATE						= UIFactory.getElements("DELIVERY_MY_ADDRESS_STATE");

	public final static UI_Elements	BUTTON_SAVE_GUIDED_ITEM							= UIFactory.getElements("BUTTON_SAVE_GUIDED_ITEM");

	public final static UI_Elements	CATEGORY_GUIDED_FREE_TEXT						= UIFactory.getElements("CATEGORY_GUIDED_FREE_TEXT");
	public final static UI_Elements	DESCRIPTION_GUIDED_FREE_TEXT					= UIFactory.getElements("DESCRIPTION_GUIDED_FREE_TEXT");
	public final static UI_Elements	QUANTITY_GUIDED_FREE_TEXT						= UIFactory.getElements("QUANTITY_GUIDED_FREE_TEXT");
	public final static UI_Elements	PRICE_GUIDED_FREE_TEXT							= UIFactory.getElements("PRICE_GUIDED_FREE_TEXT");
	public final static UI_Elements	BUTTON_CANCEL_GUIDED_ITEM						= UIFactory.getElements("BUTTON_CANCEL_GUIDED_ITEM");
	public final static UI_Elements	CURRENCY_ITEM_DETAIL_POPUP						= UIFactory.getElements("CURRENCY_ITEM_DETAIL_POPUP");

	public final static UI_Elements	BUTTON_YES_CONFIRM_POPUP						= UIFactory.getElements("BUTTON_YES_CONFIRM_POPUP");
	public final static UI_Elements	COST_BOOKING_ITEM_EDIT							= UIFactory.getElements("COST_BOOKING_ITEM_EDIT");
	public final static UI_Elements	HEADER_ERROR_MSG_CHECKOUT_PAGE					= UIFactory.getElements("HEADER_ERROR_MSG_CHECKOUT_PAGE");

	public final static UI_Elements	BUTTON_KEEP_ALL_ITEMS							= UIFactory.getElements("BUTTON_KEEP_ALL_ITEMS");
	public final static UI_Elements	LINK_DELETE_ALL_ITEMS							= UIFactory.getElements("LINK_DELETE_ALL_ITEMS");
	public final static UI_Elements	VIEW_ON_BEHALF_OF								= UIFactory.getElements("VIEW_ON_BEHALF_OF");
	public final static UI_Elements	INPUT_SHARE_POINT_URL_EFORM						= UIFactory.getElements("INPUT_SHARE_POINT_URL_EFORM");
	public final static UI_Elements	SELECT_INTERNAL_DELIVERY_LOCATION_EFORM			= UIFactory.getElements("SELECT_INTERNAL_DELIVERY_LOCATION_EFORM");
	public final static UI_Elements	TEXTAREA_DELIVERY_INSTRUCTION_EFORM				= UIFactory.getElements("TEXTAREA_DELIVERY_INSTRUCTION_EFORM");
	public final static UI_Elements	INPUT_ESTIMATED_FREIGHT_EFORM					= UIFactory.getElements("INPUT_ESTIMATED_FREIGHT_EFORM");
	public final static UI_Elements	TEXTAREA_PURCHASING_INSTRUCTIONS_EFORM			= UIFactory.getElements("TEXTAREA_PURCHASING_INSTRUCTIONS_EFORM");
	public final static UI_Elements	WORKFLOW_EXTERNAL_AGENT_TEXT					= UIFactory.getElements("WORKFLOW_EXTERNAL_AGENT_TEXT");

	//CLIENT SPECIFIC- qts
	public final static UI_Elements	IS_PURCHASE_BUDGETED							= UIFactory.getElements("IS_PURCHASE_BUDGETED");
	public final static UI_Elements	WHAT_IS_PURCHASED_AND_WHY						= UIFactory.getElements("WHAT_IS_PURCHASED_AND_WHY");
	public final static UI_Elements	IS_PURCHASED_BEFORE								= UIFactory.getElements("IS_PURCHASED_BEFORE");
	public final static UI_Elements	IS_PRICE_INCREASE								= UIFactory.getElements("IS_PRICE_INCREASE");
	public final static UI_Elements	IS_ADDITIONAL_SAVINGS							= UIFactory.getElements("IS_ADDITIONAL_SAVINGS");
	public final static UI_Elements	SAVINGS_ACHIEVED								= UIFactory.getElements("SAVINGS_ACHIEVED");

	UI_Elements						ERROR_GLOBAL_MSG_CHECKOUT						= UIFactory.getElements("ERROR_GLOBAL_MSG_CHECKOUT");
	UI_Elements						PCARD_ERROR_CONTAINER							= UIFactory.getElements("PCARD_ERROR_CONTAINER");
	UI_Elements						PCARD_TRANSACTION_COUNT							= UIFactory.getElements("PCARD_TRANSACTION_COUNT");

	public final static UI_Elements	OU_LOCATION										= UIFactory.getElements("OU_LOCATION");
	public final static UI_Elements	OU_COMPANY										= UIFactory.getElements("OU_COMPANY");

	public final static UI_Elements	CHECKBOX_ALL_ITEMS								= UIFactory.getElements("CHECKBOX_ALL_ITEMS");

	public final static UI_Elements	ERROR_PLEASE_SELECT_A_COST_CENTER				= UIFactory.getElements("ERROR_PLEASE_SELECT_A_COST_CENTER");
	public final static UI_Elements	ERROR_PLEASE_SELECT_A_PROJRCT					= UIFactory.getElements("ERROR_PLEASE_SELECT_A_PROJRCT");
	public final static UI_Elements	ERROR_PLEASE_SELECT_A_BUDGET_LINE				= UIFactory.getElements("ERROR_PLEASE_SELECT_A_BUDGET_LINE");
	public final static UI_Elements	ERROR_PLEASE_SELECT_A_COMPANY					= UIFactory.getElements("ERROR_PLEASE_SELECT_A_COMPANY");
	public final static UI_Elements	ERROR_PLEASE_SELECT_A_BUSINESS_UNIT				= UIFactory.getElements("ERROR_PLEASE_SELECT_A_BUSINESS_UNIT");
	public final static UI_Elements	ERROR_PLEASE_SELECT_A_LOCATION					= UIFactory.getElements("ERROR_PLEASE_SELECT_A_LOCATION");

	boolean checkRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean checkUrgentRequirement(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickAddAttachment(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	void clickOnCloseCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickAddComments(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	void clickAddItemOnCheckout(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCancleRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickChangeMultiple(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickClearRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickContinueRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCurrencyWiseTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDeleteItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	void clickEditHeaderInfo(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException;

	void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	void clickExpandAll(WebDriver driver, String testCaseName) throws Exception;

	void clickIAmDone(WebDriver driver, String testCaseName) throws ActionBotException;

	String clickSaveAsDraft(WebDriver driver, String testCaseName) throws Exception;

	void clickOnItemNameToViewItemDetails(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyer) throws ActionBotException;

	String fillCheckoutReqName(WebDriver driver, String testCaseName, String checkoutReqName) throws ActionBotException;

	String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException;

	Integer fillItemQuantity(WebDriver driver, String testCaseName, Integer itemQty, String itemID) throws ActionBotException;

	String fillOnBehalfOf(WebDriver driver, String testCaseName, String onBehalfOf) throws ActionBotException;

	String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException;

	String fillReasonForOrdering(WebDriver driver, String testCaseName, String reasonForOrdering) throws ActionBotException;

	String getAccountingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	String getBillToAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBudgetHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBudgetInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	String getCostBookingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	String getCostCenterHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliverToHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemSupplier(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	String getOrganizationUnitHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	String getGLAccountInfoInExpandAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public boolean isApproverListPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfApprovers(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfMessages(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeliveryItemEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCostBookingItemEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isConfirmReqPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfirmReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShowAllPosBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSubmitReqYesPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfirmContinueButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectSettlementVia(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException;

	String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillReqSubmitProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectPCard(WebDriver driver, String testCaseName, String pcard) throws ActionBotException;

	public String getSelectedPCard(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSectionNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFieldNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFieldValueOfPEForm(WebDriver driver, String testCaseName, String fieldValue) throws ActionBotException;

	public String getFieldValueOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	int getDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getCostBookingMultiSplitAtItemLevelCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getCostBookingMultiSplitAtItemLevelBudget(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getCostBookingMultiSplitAtItemLevelProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getCostBookingMultiSplitAtItemLevelPrice(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getWorkflowMessageForForking(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModifyWorkFlowSettings(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	String getTotalPriceAtCheckoutHead(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemLevelTotalPriceAtCheckoutPage(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getFirstApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModifyWorkFlowSettingSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isHeaderLevelProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isHeaderCheckoutIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReqCanNotBeLinkedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClickHereLinkToShowErrors(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnAssignedBuyerDropdown(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSingleAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGroupAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isValidationAlertPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOKForAlertPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendItBackToMe(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequisitionNameTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemLevelCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getRequesterInWorkflowTrail(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterLabelInHeaderSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSourcingStatusErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssignedBuyerLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getQuantityAmountCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAssignedBuyerGroup(WebDriver driver, String testCaseName, String buyer) throws ActionBotException;

	public boolean isMisMatchSettlementViaErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getMisMatchSettlementViaErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGivenSettlementViaOptionPresent(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException;

	public String getEformTitleSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getEformSubSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterEformDetail(WebDriver driver, String testCaseName, String eForm) throws ActionBotException;

	public boolean isPONoErrorOnAttachmentPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEformAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEformAddAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSourcingStatusError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemPresentOnCheckoutPage(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public void waitForUpdateRequisitionProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitForLoadingDivOfWorkFlowTrail(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickContinueButtonForConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAssetNoError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String fillDeliveryRecipientName(WebDriver driver, String testCaseName, String assignedBuyer) throws ActionBotException;

	public String fetchDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchFetchBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchDeliveryRecipientName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchCostCenterHeaderIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickCostAllocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCommentForItemAvailable(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fetchRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionAmountWithCurrencyForItems(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fetchPurchaseAmountWithCurrencyForItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCloseRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillCostbookingSingleProject(WebDriver driver, String testCaseName, String projectName) throws ActionBotException;

	public void fillCostbookingSingleBudget(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException;

	public void clickSaveRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostAllocationTabVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryTabVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBillingTabVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryRecipientNameEdited(WebDriver driver, String testCaseName, String deliveryName) throws ActionBotException;

	public boolean isEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRowPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean clickEditItemRequisitionindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException;

	public void clickDeliveryMultiOptionSplit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterDeliverToNameInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, String name) throws ActionBotException;

	public void increaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException;

	public void decreaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException;

	public void increaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException;

	public void decreaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException;

	public void clickToAddADeliverySplitIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToExpandItemDetailsIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String[] getApprovalWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssignedBuyerTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequiredByDateEmpty(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickDeliveryEditRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickMyAddressRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToEnterNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillMyCustomDeliveryAddressName(WebDriver driver, String testCaseName, String name) throws Exception;

	public void fillMyCustomDeliveryStreetAddress(WebDriver driver, String testCaseName, String adderss) throws Exception;

	public void fillMyCustomDeliveryCountry(WebDriver driver, String testCaseName) throws Exception;

	void fillMyCustomDeliveryCity(WebDriver driver, String testCaseName) throws Exception;

	public boolean deleteReqItemInCart(WebDriver driver, String testCaseName, int index) throws Exception;

	public void toAddNewReqItemInCart(WebDriver driver, String testCaseName, int index) throws Exception;

	public void toSplitIntoMultipleCostCenter(WebDriver driver, String testCaseName) throws Exception;

	public void clicktoAddCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public void toIncreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	void toDecreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public boolean toSelectBillingCurrencyChoiceWise(WebDriver driver, String testCaseName, int choice, String currency) throws Exception;

	public boolean isCurrencyWiseTotalLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNumberPresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNameSupplierNamePresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemUnitPricePresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemQtyPresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMyAddressPresentInDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyWiseAmmountPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws Exception;

	public boolean isTotalAmmountPresent(WebDriver driver, String testCaseName) throws Exception;

	public boolean deleteItemInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void selectCostCenter(WebDriver driver, String testCaseName, int index) throws Exception;

	public void toSelectProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void toSelectBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isCatLogItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception;

	public void clickOnYesConfirmationLink(WebDriver driver, String testCaseName) throws Exception;

	public boolean isGuidedItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception;

	public boolean isRequiredByDateMissingValueErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBillingCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSubTotalrowise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getPurchaseTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemUnitCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickEditItemRequisition(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isOptionCopyCostCenterInfoPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostBookingOptionPercentageSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostBookingOptionQuantityPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCopyCostBookingAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void autoFillCostBookingAtItemLevel(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickItemLevelCostCenterSplitIndexWise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToSaveItemSummaryRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemLevelCostCenterIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemLevelProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemLevelBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getHeaderLevelBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderLevelProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderLevelCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryInformationFromRequisitionSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clicktoAddItemLevelCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public String fetchCheckoutItemQuantity(WebDriver driver, String testCaseName) throws Exception;

	public void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public String fetchBillingAddressFromHeader(WebDriver driver, String testCaseName) throws Exception;

	public void fillBillingCompanyName(WebDriver driver, String testCaseName, String ComapnyName) throws ActionBotException;

	public void fillBillingBusinessUnitName(WebDriver driver, String testCaseName, String bu) throws ActionBotException;

	public void fillBillingLocationName(WebDriver driver, String testCaseName, String loc) throws ActionBotException;

	public boolean isValidState(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContractNumberPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCloseItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName) throws Exception;

	public void clickSaveFreeTextButton(WebDriver driver, String testCaseName) throws Exception;

	public String getQuantityFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDescriptionFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPriceFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCancelFreeTextButton(WebDriver driver, String testCaseName) throws Exception;

	void fillScriptedBillingLocationName(WebDriver driver, String testCaseName, String loc) throws ActionBotException;

	void fillCurrencyForItemDetailPopup(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public boolean isItemWithQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isEditRequistionSummaryVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isRequisitionSummaryButtonVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	void searchCategoryinGuidedItemPopup(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	boolean isSubmitionSuccessfullyDone(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyFinalAmountGenerated_COA(WebDriver driver, String testCaseName, CostBookingAndAccountingItemSummaryCOA costbookigitemsummary)
		throws ActionBotException, NumberFormatException;

	public void clickButtonKeepAllItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickLinkDeleteAllItems(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isHeaderErrorMsgPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	String getOnBehalfOf(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectItemIDwise(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	/**
	 * <b>Author: akashdeep.singh || swet.shah </b><br>
	 * </b><br>
	 * <font color="blue">Method :</b>Filling the eForm in Requisition [SAWater]<br>
	 */
	//Client specific: SAWater

	public String fillSharePointURL_EForm(WebDriver driver, String testCaseName, String sharePointURL) throws ActionBotException;

	public String fillInternalDeliveryLocation_EForm(WebDriver driver, String testCaseName, String internalDeliveryLocation) throws ActionBotException;

	public String fillDeliveryInstructions_EForm(WebDriver driver, String testCaseName, String deliveryInstructions) throws ActionBotException;

	public String fillEstimatedFreight_EForm(WebDriver driver, String testCaseName, String estimatedFreight) throws ActionBotException;

	public String fillPurchasingInstructions_EForm(WebDriver driver, String testCaseName, String purchasingInstructions) throws ActionBotException;

	public boolean checkForExternalAgent(WebDriver driver, String testCaseName) throws ActionBotException;

	/**
	 * <b>Author: bhakti.sawant </b><br>
	 * </b><br>
	 * <font color="blue">Method :</b>Filling the eForm in Requisition [QTS]<br>
	 */
	//Client specific: 
	public String fillIsPurchaseBudgeted(WebDriver driver, String testCaseName, String isThePurchaseBudgeted) throws ActionBotException;

	public String fillWhatIsPurchasedAndWhy(WebDriver driver, String testCaseName, String whatIsPurchasedandWHY) throws ActionBotException;

	public String fillIsPurchasedBefore(WebDriver driver, String testCaseName, String isPurchasedBefore) throws ActionBotException;

	public String fillIsPriceIncrease(WebDriver driver, String testCaseName, String isPriceIncrease) throws ActionBotException;

	public String fillIsAdditionalSavings(WebDriver driver, String testCaseName, String isAdditionalSavings) throws ActionBotException;

	public String fillSavingsAchieved(WebDriver driver, String testCaseName, String SavingsAchieved) throws ActionBotException;

	/**
	 * @author sanjay.kundu
	 */
	public String getGlobelErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPcardErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPcardTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException;

	/*
	 * @author: bhakti.sawant : to add/ delete attachment
	 */
	String addAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException;

	String deleteAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException;

	String deleteItemSummaryAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException;

	String getOULocation(WebDriver driver, String testCaseName) throws ActionBotException;

	String getOUCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isErrorMessagePresentInRequisitionSummaryPopUp(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	void clickCheckboxAllItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfItemIdsOfCheckoutPageItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public String getItemIdByNameAtRequisitionCheckout(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException;

}