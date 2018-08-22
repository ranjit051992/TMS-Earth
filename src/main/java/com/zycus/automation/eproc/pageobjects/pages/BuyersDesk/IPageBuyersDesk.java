package com.zycus.automation.eproc.pageobjects.pages.BuyersDesk;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public interface IPageBuyersDesk
{
	final static UI_Elements	REQUISITION_NAME										= UIFactory.getElements("REQUISITION_NAME");
	final static UI_Elements	LINK_UPDATE_ALL_LINES_BUYERS_DESK						= UIFactory.getElements("LINK_UPDATE_ALL_LINES_BUYERS_DESK");
	final static UI_Elements	GLACCOUNT_TEXT_BOX										= UIFactory.getElements("GLACCOUNT_TEXT_BOX");
	final static UI_Elements	BUTTON_APPLY_ALL_LINES									= UIFactory.getElements("BUTTON_APPLY_ALL_LINES");

	final static UI_Elements	REASON_FOR_ORDERING										= UIFactory.getElements("REASON_FOR_ORDERING");

	final static UI_Elements	COMMENTS_FOR_SUPPLIER									= UIFactory.getElements("COMMENTS_FOR_SUPPLIER");

	final static UI_Elements	ASSIGNED_BUYER											= UIFactory.getElements("ASSIGNED_BUYER");

	final static UI_Elements	DELIVERY_ADDRESS										= UIFactory.getElements("DELIVERY_ADDRESS");
	final static UI_Elements	BILL_TO_ADDRESS											= UIFactory.getElements("BILL_TO_ADDRESS");

	final static UI_Elements	REQUISITION_ITEM_EXPAND_ALL								= UIFactory.getElements("REQUISITION_ITEM_EXPAND_ALL");
	// final static UI_Elements ITEM_NO_CHECKBOX =
	// UIFactory.getElements("ITEM_NO_CHECKBOX");
	final static UI_Elements	ITEM_NO													= UIFactory.getElements("ITEM_NO");

	final static UI_Elements	UNIT_PRICE												= UIFactory.getElements("UNIT_PRICE");
	final static UI_Elements	TEXTBOX_UNIT_PRICE										= UIFactory.getElements("TEXTBOX_UNIT_PRICE");
	final static UI_Elements	QTY														= UIFactory.getElements("QTY");
	final static UI_Elements	REQUISTION_CHANGE_COMMENTS								= UIFactory.getElements("REQUISTION_CHANGE_COMMENTS");
	final static UI_Elements	CONVERT_TO_PO											= UIFactory.getElements("CONVERT_TO_PO");
	final static UI_Elements	SAVE_REQUISITION										= UIFactory.getElements("SAVE_REQUISITION");

	final static UI_Elements	RETURN_REQUISITION										= UIFactory.getElements("RETURN_REQUISITION");
	final static UI_Elements	CANCEL_REQUISITION										= UIFactory.getElements("CANCEL_REQUISITION");
	final static UI_Elements	BDC_EDITLINK											= UIFactory.getElements("BDC_EDITLINK");

	final static UI_Elements	BUTTON_ADD_ITEMS										= UIFactory.getElements("BUTTON_ADD_ITEMS");

	final static UI_Elements	LINK_CREATE_FREE_TEXT_ITEM								= UIFactory.getElements("LINK_CREATE_FREE_TEXT_ITEM");

	static UI_Elements			UPDATE_REQUISITION_PROCESSING_DIV						= UIFactory.getElements("UPDATE_REQUISITION_PROCESSING_DIV");
	static UI_Elements			TEXTBOX_COMMENT_FOR_SUPPLIER							= UIFactory.getElements("TEXTBOX_COMMENT_FOR_SUPPLIER");
	static UI_Elements			ALERT_VALIDATION_AND_ERROR								= UIFactory.getElements("ALERT_VALIDATION_AND_ERROR");
	static UI_Elements			BUTTON_OK_FOR_VALIDATION_ALERT_POPUP					= UIFactory.getElements("BUTTON_OK_FOR_VALIDATION_ALERT_POPUP");
	static UI_Elements			ITEM_NAME												= UIFactory.getElements("ITEM_NAME");
	static UI_Elements			CHECKBOX_MODIFY_WORKFLOW_SETTING						= UIFactory.getElements("CHECKBOX_MODIFY_WORKFLOW_SETTING");
	static UI_Elements			QTIP_MODIFY_WORKFLOW_SETTING							= UIFactory.getElements("QTIP_MODIFY_WORKFLOW_SETTING");
	static UI_Elements			LABEL_MODIFY_WORKFLOW_SETTING							= UIFactory.getElements("LABEL_MODIFY_WORKFLOW_SETTING");
	static UI_Elements			BUTTON_SEND_FOR_APPROVAL								= UIFactory.getElements("BUTTON_SEND_FOR_APPROVAL");
	static UI_Elements			BUTTON_RETURN_TO_REQUESTER								= UIFactory.getElements("BUTTON_RETURN_TO_REQUESTER");
	static UI_Elements			LINK_REMOVE_ASSIGNED_BUYER								= UIFactory.getElements("LINK_REMOVE_ASSIGNED_BUYER");
	static UI_Elements			LABLE_ASSIGNED_BUYER_AT_BUYERS_DESK						= UIFactory.getElements("LABLE_ASSIGNED_BUYER_AT_BUYERS_DESK");
	static UI_Elements			LINK_EDIT_FIRST_ITEM									= UIFactory.getElements("LINK_EDIT_FIRST_ITEM");
	static UI_Elements			HEADER_TOTAL_PRICE										= UIFactory.getElements("HEADER_TOTAL_PRICE");
	static UI_Elements			LINK_COLLPASE_ALL_ITEMS									= UIFactory.getElements("LINK_COLLPASE_ALL_ITEMS");
	static UI_Elements			HELP_TEXT_FOR_NEED_A_QUOTE_SOURCING_STATUS				= UIFactory.getElements("HELP_TEXT_FOR_NEED_A_QUOTE_SOURCING_STATUS");

	static String				xpath1_itemNameLink										= ".//*[@id='item_";
	static String				xpath2_itemNameLink										= "']//a[contains(@class,'itemName')]";

	static String				xpath1_itemSubTotalPrice								= ".//*[@id='item_subTotalPrice_";
	static String				xpath2_itemSubTotalPrice								= "']";

	static String				xpath1_itemAccountingLevelPrice							= ".//*[@id='item_summary_";
	static String				xpath2_itemAccountingLevelPrice							= "']//tr[2]/td[contains(@class,'price')]";

	static String				xpath1_item_supplier									= ".//*[@id='item_supplier_";
	static String				xpath2_item_supplier									= "']";

	static String				xpath1_itemNeedAQuoteIcon								= ".//*[@id='guidedItemDetailsForm_";
	static String				xpath2_itemNeedAQuoteIcon								= "']//label[contains(@class,'SourcingStatus')]/a[contains(@class,'helpQuote')]";
	static UI_Elements			BUTTON_CREATE_SOURCING_EVENT							= UIFactory.getElements("BUTTON_CREATE_SOURCING_EVENT");

	// Add Items Pop-up on Edit Req page of Buyers Desk
	final static UI_Elements	TEXT_ITEM_NUMBER										= UIFactory.getElements("TEXT_ITEM_NUMBER");
	final static UI_Elements	TEXT_SHORT_DESCRIPTION									= UIFactory.getElements("TEXT_SHORT_DESCRIPTION");
	final static UI_Elements	TEXT_LONG_DESCRIPTION									= UIFactory.getElements("TEXT_LONG_DESCRIPTION");
	final static UI_Elements	TEXT_PRODUCT_CATEGORY									= UIFactory.getElements("TEXT_PRODUCT_CATEGORY");
	final static UI_Elements	TEXT_QUANTITY											= UIFactory.getElements("TEXT_QUANTITY");
	final static UI_Elements	TEXT_PRICE												= UIFactory.getElements("TEXT_PRICE");
	final static UI_Elements	TEXT_UOM												= UIFactory.getElements("TEXT_UOM");
	final static UI_Elements	BUTTON_ADD_ITEMS_POPUP									= UIFactory.getElements("BUTTON_ADD_ITEMS_POPUP");
	final static UI_Elements	TAB_SUPPLIERS											= UIFactory.getElements("TAB_SUPPLIERS");
	final static UI_Elements	TAB_ITEM												= UIFactory.getElements("TAB_ITEM");
	final static UI_Elements	TEXT_SUPPLIER_NAME										= UIFactory.getElements("TEXT_SUPPLIER_NAME");
	final static UI_Elements	LINK_CANCEL												= UIFactory.getElements("LINK_CANCEL");
	final static UI_Elements	BUTTON_CANCEL_AND_GO_BACK_ADD_ITEM						= UIFactory.getElements("BUTTON_CANCEL_AND_GO_BACK_ADD_ITEM");
	final static UI_Elements	LINK_CANCEL_AND_GO_BACK									= UIFactory.getElements("LINK_CANCEL_AND_GO_BACK");
	final static UI_Elements	TAB_REQUIREMENT_DETAILS									= UIFactory.getElements("TAB_REQUIREMENT_DETAILS");
	final static UI_Elements	HEADER_SECTION_NAME_REQUIREMENT_TAB						= UIFactory.getElements("HEADER_SECTION_NAME_REQUIREMENT_TAB");
	final static UI_Elements	HEADER_FIELD_NAME_REQUIREMENT_TAB						= UIFactory.getElements("HEADER_FIELD_NAME_REQUIREMENT_TAB");
	final static UI_Elements	DIALOG_EFORM											= UIFactory.getElements("DIALOG_EFORM");
	final static UI_Elements	EFORM_COUNT												= UIFactory.getElements("EFORM_COUNT");
	final static UI_Elements	EFORM_LIST												= UIFactory.getElements("EFORM_LIST");
	final static UI_Elements	LINK_CANCEL_DIALOG_EFORM								= UIFactory.getElements("LINK_CANCEL_DIALOG_EFORM");
	final static UI_Elements	ERROR_ITEM_QUANTITY										= UIFactory.getElements("ERROR_ITEM_QUANTITY");
	final static UI_Elements	TEXT_SOURCING_STATUS									= UIFactory.getElements("TEXT_SOURCING_STATUS");
	final static UI_Elements	TEXT_CURRENCY											= UIFactory.getElements("TEXT_CURRENCY");
	final static UI_Elements	LINK_SHOW_EXTRA_FIELDS									= UIFactory.getElements("LINK_SHOW_EXTRA_FIELDS");
	final static UI_Elements	TEXT_MANUFACTURER_NAME									= UIFactory.getElements("TEXT_MANUFACTURER_NAME");
	final static UI_Elements	TEXT_MANUFACTURER_PART_ID								= UIFactory.getElements("TEXT_MANUFACTURER_PART_ID");
	final static UI_Elements	TEXT_SPECIFICATION_NAME									= UIFactory.getElements("TEXT_SPECIFICATION_NAME");
	final static UI_Elements	TEXT_SPECIFICATION_KEY									= UIFactory.getElements("TEXT_SPECIFICATION_KEY");
	final static UI_Elements	TEXT_SPECIFICATION_VALUE								= UIFactory.getElements("TEXT_SPECIFICATION_VALUE");
	final static UI_Elements	BUTTON_SPECIFICATION_ADD								= UIFactory.getElements("BUTTON_SPECIFICATION_ADD");
	final static UI_Elements	TEXT_IMAGE_URL											= UIFactory.getElements("TEXT_IMAGE_URL");
	final static UI_Elements	TEXT_PRODUCT_URL										= UIFactory.getElements("TEXT_PRODUCT_URL");
	final static UI_Elements	TEXT_MANUFACTURER_URL									= UIFactory.getElements("TEXT_MANUFACTURER_URL");
	final static UI_Elements	ERROR_SUPPLIER_NAME										= UIFactory.getElements("ERROR_SUPPLIER_NAME");
	final static UI_Elements	TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB					= UIFactory.getElements("TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB");
	final static UI_Elements	ERROR_IN_REQUIREMENT_TAB								= UIFactory.getElements("ERROR_IN_REQUIREMENT_TAB");
	final static UI_Elements	BUTTON_SHOW_ALL											= UIFactory.getElements("BUTTON_SHOW_ALL");
	final static UI_Elements	TEXT_FILTER_PO_NUMBER									= UIFactory.getElements("TEXT_FILTER_PO_NUMBER");
	final static UI_Elements	RADIOBUTTON_SELECT_PO									= UIFactory.getElements("RADIOBUTTON_SELECT_PO");
	final static UI_Elements	BUTTON_OK_PO											= UIFactory.getElements("BUTTON_OK_PO");
	final static UI_Elements	TEXT_CONTRACT_NUMBER									= UIFactory.getElements("TEXT_CONTRACT_NUMBER");
	final static UI_Elements	BUTTON_RETURN_TO_REQUESTER_EDIT_REQ						= UIFactory.getElements("BUTTON_RETURN_TO_REQUESTER_EDIT_REQ");
	final static UI_Elements	TEXTAREA_REQ_CHANGE_COMMENTS							= UIFactory.getElements("TEXTAREA_REQ_CHANGE_COMMENTS");
	final static UI_Elements	BUTTON_CONFIRM_YES										= UIFactory.getElements("BUTTON_CONFIRM_YES");
	final static UI_Elements	BUTTON_CONFIRM_SAVE										= UIFactory.getElements("BUTTON_CONFIRM_SAVE");
	final static UI_Elements	TEXT_GL_ACCOUNT											= UIFactory.getElements("TEXT_GL_ACCOUNT");
	final static UI_Elements	BUTTON_OK_COST_ALLOCATION_TAB							= UIFactory.getElements("BUTTON_OK_COST_ALLOCATION_TAB");
	final static UI_Elements	BUTTON_ADD_ITEMS_TO_REQ									= UIFactory.getElements("BUTTON_ADD_ITEMS_TO_REQ");
	final static UI_Elements	LINK_EDIT_BILLING_DELIVERY_SUMMARY						= UIFactory.getElements("LINK_EDIT_BILLING_DELIVERY_SUMMARY");
	final static UI_Elements	TAB_COST_ALLOCATION										= UIFactory.getElements("TAB_COST_ALLOCATION");
	final static UI_Elements	TEXT_COST_CENTER_SUMMARY								= UIFactory.getElements("TEXT_COST_CENTER_SUMMARY");
	final static UI_Elements	TEXT_PROJECT_SUMMARY									= UIFactory.getElements("TEXT_PROJECT_SUMMARY");
	final static UI_Elements	TEXT_BUDGET_SUMMARY										= UIFactory.getElements("TEXT_BUDGET_SUMMARY");
	final static UI_Elements	BUTTON_OK_REQ_SUMMARY									= UIFactory.getElements("BUTTON_OK_REQ_SUMMARY");
	final static UI_Elements	TITLE_CREATE_FREE_TEXT_ITEM_MODAL						= UIFactory.getElements("TITLE_CREATE_FREE_TEXT_ITEM_MODAL");
	final static UI_Elements	VALUE_COST_CENTER										= UIFactory.getElements("VALUE_COST_CENTER");
	final static UI_Elements	VALUE_PROJECT											= UIFactory.getElements("VALUE_PROJECT");
	final static UI_Elements	VALUE_BUDGET											= UIFactory.getElements("VALUE_BUDGET");
	final static UI_Elements	BUTTON_CONFIRM_DONT_SAVE								= UIFactory.getElements("BUTTON_CONFIRM_DONT_SAVE");
	final static UI_Elements	TEXT_DELIVERY_ADDRESS_HEADER							= UIFactory.getElements("TEXT_DELIVERY_ADDRESS_HEADER");
	final static UI_Elements	TEXT_COST_CENTER_HEADER									= UIFactory.getElements("TEXT_COST_CENTER_HEADER");
	final static UI_Elements	TEXT_OU_COMPANY											= UIFactory.getElements("TEXT_OU_COMPANY");
	final static UI_Elements	TEXT_OU_BUSINESS_UNIT									= UIFactory.getElements("TEXT_OU_BUSINESS_UNIT");
	final static UI_Elements	TEXT_OU_LOCATION										= UIFactory.getElements("TEXT_OU_LOCATION");
	final static UI_Elements	RADIO_BUTTON_COST_LINE_LEVEL							= UIFactory.getElements("RADIO_BUTTON_COST_LINE_LEVEL");
	final static UI_Elements	LINK_EDIT_COST_BOOKING_ITEM_LEVEL						= UIFactory.getElements("LINK_EDIT_COST_BOOKING_ITEM_LEVEL");
	final static UI_Elements	TEXT_GL_ACCOUNT_COST_BOOKING_ITEM_LEVEL					= UIFactory.getElements("TEXT_GL_ACCOUNT_COST_BOOKING_ITEM_LEVEL");
	final static UI_Elements	TEXT_PROJECT_COST_BOOKING_ITEM_LEVEL					= UIFactory.getElements("TEXT_PROJECT_COST_BOOKING_ITEM_LEVEL");
	final static UI_Elements	TEXT_BUDGET_COST_BOOKING_ITEM_LEVEL						= UIFactory.getElements("TEXT_BUDGET_COST_BOOKING_ITEM_LEVEL");
	final static UI_Elements	TEXT_COST_CENTER_COST_BOOKING_ITEM_LEVEL				= UIFactory.getElements("TEXT_COST_CENTER_COST_BOOKING_ITEM_LEVEL");
	final static UI_Elements	ERROR_TOLERANCE_LEVEL_FOR_ALLOW_PRS						= UIFactory.getElements("ERROR_TOLERANCE_LEVEL_FOR_ALLOW_PRS");
	final static UI_Elements	TEXT_SUPPLIER_ADDRESS									= UIFactory.getElements("TEXT_SUPPLIER_ADDRESS");
	final static UI_Elements	TEXT_ITEM_DESCRIPTION									= UIFactory.getElements("TEXT_ITEM_DESCRIPTION");
	final static UI_Elements	BUTTON_CLOSE_ITEM_POPUP									= UIFactory.getElements("BUTTON_CLOSE_ITEM_POPUP");

	final static UI_Elements	FREE_TEXT_CATEGORY										= UIFactory.getElements("FREE_TEXT_CATEGORY");
	final static UI_Elements	FREE_TEXT_SUPPLIER_TAB									= UIFactory.getElements("FREE_TEXT_SUPPLIER_TAB");

	final static UI_Elements	TEXT_PURCHASE_AMOUNT									= UIFactory.getElements("TEXT_PURCHASE_AMOUNT");
	final static UI_Elements	LINK_AUDIT_TRAIL										= UIFactory.getElements("LINK_AUDIT_TRAIL");
	final static UI_Elements	TEXT_AUDIT_TRAIL_COMMENT								= UIFactory.getElements("TEXT_AUDIT_TRAIL_COMMENT");
	final static UI_Elements	LINK_EDIT_ASSIGNED_BUYER_ITEM_LEVEL						= UIFactory.getElements("LINK_EDIT_ASSIGNED_BUYER_ITEM_LEVEL");
	final static UI_Elements	RADIO_ITEM_TYPE_GOODS									= UIFactory.getElements("RADIO_ITEM_TYPE_GOODS");
	final static UI_Elements	RADIO_ITEM_TYPE_SERVICES								= UIFactory.getElements("RADIO_ITEM_TYPE_SERVICES");
	final static UI_Elements	RADIO_RECEIVE_BY_QUANTITY								= UIFactory.getElements("RADIO_RECEIVE_BY_QUANTITY");
	final static UI_Elements	RADIO_RECEIVE_BY_AMOUNT									= UIFactory.getElements("RADIO_RECEIVE_BY_AMOUNT");
	final static UI_Elements	RADIO_RECEIVE_BY_NO_RECEPIT								= UIFactory.getElements("RADIO_RECEIVE_BY_NO_RECEPIT");
	final static UI_Elements	RADIO_IS_GREEN_YES										= UIFactory.getElements("RADIO_IS_GREEN_YES");
	final static UI_Elements	RADIO_IS_GREEN_NO										= UIFactory.getElements("RADIO_IS_GREEN_NO");
	final static UI_Elements	RADIO_IS_PREFERRED_YES									= UIFactory.getElements("RADIO_IS_PREFERRED_YES");
	final static UI_Elements	RADIO_IS_PREFERRED_NO									= UIFactory.getElements("RADIO_IS_PREFERRED_NO");
	final static UI_Elements	TEXT_AUDIT_TRAIL_VERSION								= UIFactory.getElements("TEXT_AUDIT_TRAIL_VERSION");
	final static UI_Elements	BUTTON_SHOW_ALL_PO										= UIFactory.getElements("BUTTON_SHOW_ALL_PO");
	final static UI_Elements	LINK_FIRST_PO_NUMBER_POMODAL							= UIFactory.getElements("LINK_FIRST_PO_NUMBER_POMODAL");
	final static UI_Elements	RADIO_SELECT_FIRST_PO_POMODAL							= UIFactory.getElements("RADIO_SELECT_FIRST_PO_POMODAL");
	final static UI_Elements	BUTTON_SELECT_PO_LIST_POMODAL							= UIFactory.getElements("BUTTON_SELECT_PO_LIST_POMODAL");
	final static UI_Elements	FILTER_PO_NUMBER_POMODAL								= UIFactory.getElements("FILTER_PO_NUMBER_POMODAL");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_NAME			= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_NAME");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_URL			= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_URL");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_IMAGE_URL					= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_IMAGE_URL");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_PROD_URL					= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_PROD_URL");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_NAME			= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_NAME");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_ID			= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_ID");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_KEY			= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_KEY");
	final static UI_Elements	GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_VALUE		= UIFactory.getElements("GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_VALUE");
	final static UI_Elements	SHOW_EXTRA_FIELDS										= UIFactory.getElements("SHOW_EXTRA_FIELDS");
	final static UI_Elements	CONVERT_TO_PO_ITEM_SELECT_CHECKBOX						= UIFactory.getElements("CONVERT_TO_PO_ITEM_SELECT_CHECKBOX");
	final static UI_Elements	RELEASE_PO_BUTTON										= UIFactory.getElements("RELEASE_PO_BUTTON");
	final static UI_Elements	PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK					= UIFactory.getElements("PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK");
	final static UI_Elements	REQ_NUMBER_FOR_PO_RELEASE								= UIFactory.getElements("REQ_NUMBER_FOR_PO_RELEASE");
	final static UI_Elements	PO_NUMBER_FOR_RELEASE									= UIFactory.getElements("PO_NUMBER_FOR_RELEASE");

	final static UI_Elements	DELIVERY_TAB_UPDATE_ALL_LINES							= UIFactory.getElements("DELIVERY_TAB_UPDATE_ALL_LINES");
	final static UI_Elements	ERROR_LIST_BUYERS_DESK									= UIFactory.getElements("ERROR_LIST_BUYERS_DESK");
	final static UI_Elements	MULTIDELIVERY_ON_UPDATE_ALL_LINES						= UIFactory.getElements("MULTIDELIVERY_ON_UPDATE_ALL_LINES");
	final static UI_Elements	LIST_OF_PURCHASE_ORDER_TAB								= UIFactory.getElements("LIST_OF_PURCHASE_ORDER_WINDOW");
	final static UI_Elements	RADIO_ASSIGN_COST_TO_PROJECT_YES						= UIFactory.getElements("RADIO_ASSIGN_COST_TO_PROJECT_YES");
	final static UI_Elements	RADIO_ASSIGN_COST_TO_PROJECT_NO							= UIFactory.getElements("RADIO_ASSIGN_COST_TO_PROJECT_NO");
	final static UI_Elements	RADIO_BUDGET_UTILIZATION_YES							= UIFactory.getElements("RADIO_BUDGET_UTILIZATION_YES");
	final static UI_Elements	RADIO_BUDGET_UTILIZATION_NO								= UIFactory.getElements("RADIO_BUDGET_UTILIZATION_NO");
	final static UI_Elements	BUTTON_ACTIONS											= UIFactory.getElements("BUTTON_ACTIONS");
	final static UI_Elements	LINK_RETURN												= UIFactory.getElements("LINK_RETURN");
	final static UI_Elements	RADIO_BUYER_NEGOTIATED_PRICE							= UIFactory.getElements("RADIO_BUYER_NEGOTIATED_PRICE");
	final static UI_Elements	RADIO_NEED_A_QUOTE										= UIFactory.getElements("RADIO_NEED_A_QUOTE");
	final static UI_Elements	SAVE_GUIDED_ITEM_BUTTON									= UIFactory.getElements("SAVE_GUIDED_ITEM_BUTTON");
	final static UI_Elements	SAVE_REQUISITION_BUTTON									= UIFactory.getElements("SAVE_REQUISITION_BUTTON");

	final static UI_Elements	LOADER_ITEM_NAME										= UIFactory.getElements("LOADER_ITEM_NAME");
	final static UI_Elements	CLOSE_ICON_MODAL_ADD_FREE_TEXT_ITEM						= UIFactory.getElements("CLOSE_ICON_MODAL_ADD_FREE_TEXT_ITEM");
	final static UI_Elements	SHOW_HIDE_ADVANCED_ITEM_DETAILS_MODAL_FREE_TEXT_ITEM	= UIFactory.getElements("SHOW_HIDE_ADVANCED_ITEM_DETAILS_MODAL_FREE_TEXT_ITEM");
	final static UI_Elements	REQUISITION_ITEMS										= UIFactory.getElements("REQUISITION_ITEMS");
	final static UI_Elements	UOM_DESCRIPTION											= UIFactory.getElements("UOM_DESCRIPTION");
	final static UI_Elements	PRICE_ERROR												= UIFactory.getElements("PRICE_ERROR");
	final static UI_Elements	SOURCING_STATUS_LABEL									= UIFactory.getElements("SOURCING_STATUS_LABEL");
	final static UI_Elements	MANDATORY_SUPPLIER_NAME									= UIFactory.getElements("MANDATORY_SUPPLIER_NAME");
	final static UI_Elements	MANDATORY_SUPPLIER_ADDRESS								= UIFactory.getElements("MANDATORY_SUPPLIER_ADDRESS");
	final static UI_Elements	NAME_ERROR												= UIFactory.getElements("NAME_ERROR");
	final static UI_Elements	PRODUCT_CATEGORY_ERROR									= UIFactory.getElements("PRODUCT_CATEGORY_ERROR");
	final static UI_Elements	QUANTITY_ERROR											= UIFactory.getElements("QUANTITY_ERROR");
	final static UI_Elements	REQUIREMENT_DETAILS_TEXTBOX								= UIFactory.getElements("REQUIREMENT_DETAILS_TEXTBOX");
	final static UI_Elements	REQUIREMENT_DETAILS_ERROR								= UIFactory.getElements("REQUIREMENT_DETAILS_ERROR");
	final static UI_Elements	ADDED_ITEM_SUCCESS_MESSAGE								= UIFactory.getElements("ADDED_ITEM_SUCCESS_MESSAGE");
	final static UI_Elements	REQUISITION_DELIVERY_ADDRESS							= UIFactory.getElements("REQUISITION_DELIVERY_ADDRESS");
	final static UI_Elements	REQUISITION_ITEM_DELIVERY_ADDRESS						= UIFactory.getElements("REQUISITION_ITEM_DELIVERY_ADDRESS");
	final static UI_Elements	REQUISITION_ITEM_COST_CENTER							= UIFactory.getElements("REQUISITION_ITEM_COST_CENTER");
	final static UI_Elements	ACTION_BUTTON_EDIT_REQUISITION							= UIFactory.getElements("ACTION_BUTTON_EDIT_REQUISITION");
	final static UI_Elements	BUTTON_ADD_ITEMS_EDIT_REQUISITION						= UIFactory.getElements("BUTTON_ADD_ITEMS_EDIT_REQUISITION");

	String getRequistionNanme(WebDriver driver, String testCaseName) throws ActionBotException;

	String getResonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnExpandAllLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnUpdateAllLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnItemNoLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnConvertToPo(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean verifyButtonConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSave(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnApplyallLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnReturn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCancel(WebDriver driver, String testcaseName) throws ActionBotException;

	String getUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	String getQty(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillReqChangeComment(WebDriver driver, String testcaseName, String requeComment) throws ActionBotException;

	void clickOnBDCLINK(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentForSupplier) throws ActionBotException;

	int fillItemPrice(WebDriver driver, String testCaseName, int itemPrice, String itemId) throws ActionBotException, TestCaseException;

	String fillGLAccount(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException;

	String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException;

	void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public void waitTillUpdateProcessingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertPopupForValidationPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOKForAlert(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnModifyWorkflowSetting(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModifyWorkflowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModifyWorkflowSettingQtipPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendForApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnToRequester(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAssignedBuyerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstItemEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReplaceItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clearAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUnitPriceExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isQuantityExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity) throws ActionBotException, TestCaseException;

	public String getReqChangeComments(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostingSplitPresentAtItemLevel(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getHeaderTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemLevelSubTotalPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemAccountingLevelPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnCollapseAllItemsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isConvertToPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemSupplierPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getNeedAQuoteHelpText(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isExpandAllLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectItemToUncheck(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemNameLinkPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnCreateSourcingEventButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnCreateFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyButtonAddItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public String enterItemShortDescription(WebDriver driver, String testCaseName, String itemShortDescription) throws ActionBotException;

	public String enterItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException;

	public String enterProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException;

	public String enterItemQuantity(WebDriver driver, String testCaseName, String itemQuantity) throws ActionBotException;

	public String enterItemPrice(WebDriver driver, String testCaseName, String itemPrice) throws ActionBotException;

	public String enterItemCurrency(WebDriver driver, String testCaseName, String itemCurrency) throws ActionBotException;

	public String enterItemUOM(WebDriver driver, String testCaseName, String uom) throws ActionBotException;

	public void clickAddItemsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSuppliersTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void selectSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFreeTextItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public boolean isCatalogItemAdded(WebDriver driver, String testCaseName, String searchItemName) throws ActionBotException;

	public boolean clickOnCancelLinkInAddItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAndGoBackButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAndGoBackLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDuplicateItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public boolean verifyProductCategoryFieldDefaultValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickRequirementDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEformPresentInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickItemTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEformDialogPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getEformCount(WebDriver driver, String testCaseName, int eformCount) throws ActionBotException;

	public int getEformListCount(WebDriver driver, String testCaseName, int eformListCount) throws ActionBotException;

	public void clickEformFromList(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCategoryOnEformDisplayed(WebDriver driver, String testCaseName, String productCategory_1) throws ActionBotException;

	public void clickOnCancelLinkEformDialog(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkForQuantityError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifySourcingStatusValue(WebDriver driver, String testCaseName, String sourcingStatus) throws ActionBotException;

	public void clickShowExtraFieldsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException;

	public String enterManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException;

	public String enterSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException;

	public String enterSpecificationKey(WebDriver driver, String testCaseName, String specificationKey) throws ActionBotException;

	public String enterSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException;

	public void clickAddSpecificationButton(WebDriver driver, String testCaseName, String specificationCount) throws ActionBotException;

	public String enterImageUrl(WebDriver driver, String testCaseName, String imageUrl) throws ActionBotException;

	public String enterProductUrl(WebDriver driver, String testCaseName, String productUrl) throws ActionBotException;

	public String enterManufacturerUrl(WebDriver driver, String testCaseName, String manufacturerUrl) throws ActionBotException;

	public boolean checkForSupplierNameError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterAddressRequirementTab(WebDriver driver, String testCaseName, String addressRequirementTab) throws ActionBotException;

	public void clearAddressRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyErrorInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickShowAllButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectBPONumber(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException;

	public boolean verifyBPOSelected(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException;

	public String enterContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException;

	public void clickReturnToRequestorButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterReqChangeComments(WebDriver driver, String testCaseName, String reqChangeComments) throws ActionBotException;

	public void clickConfirmReturnToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickConfimSave_Save(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickConfirmSave_DontSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickAccountingEditLinkForFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException;

	public void clickAddItemsButtonToReq(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditLinkForBillingDeliverySummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterCostCenterSummary(WebDriver driver, String testCaseName, String costCenterSummary) throws ActionBotException;

	public String enterProjectSummary(WebDriver driver, String testCaseName, String projectSummary) throws ActionBotException;

	public String enterBudgetSummary(WebDriver driver, String testCaseName, String budgetSummary) throws ActionBotException;

	public void clickOkButtonForReqSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyCreateFreeTextItemModal(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyCostcenterProjectBudgetUpdatedValues(WebDriver driver, String testCaseName, String costCenterSummary, String projectSummary, String budgetSummary)
		throws ActionBotException;

	public boolean verifyReplaceIconEnabledForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public boolean verifyReplaceIconEnabled(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public String getFreeTextItemDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFreeTextItemCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReqDeliveryAddressHeaderlevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReqCostCenterHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReqOUCompany(WebDriver driver, String testCaseName, String ouCompany) throws ActionBotException;

	public String getReqOUBusinessUnit(WebDriver driver, String testCaseName, String ouBusinessUnit) throws ActionBotException;

	public String getReqOULocation(WebDriver driver, String testCaseName, String ouLocation) throws ActionBotException;

	public String getCreatedReqNumber(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException;

	public void clickCostAtLineLevelRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditLinkForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditLinkForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public void enterGLAccountForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterProjectForCostBookingItemLevel(WebDriver driver, String testCaseName, String project) throws ActionBotException;

	public String enterBudgetForCostBookingItemLevel(WebDriver driver, String testCaseName, String budget) throws ActionBotException;

	public String enterCostCenterForCostBookingItemLevel(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException;

	public void clickButtonOkCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void updateFreeTextItemPrice(WebDriver driver, String testCaseName, String itemPrice, String itemNumber) throws ActionBotException;

	public void updateFreeTextItemQuantity(WebDriver driver, String testCaseName, String itemQuantity, String itemNumber) throws ActionBotException;

	public boolean isToleranceErrorDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReqDefaultItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFreeTextItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public String getReqPurchaseCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException;

	public int clickItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickAuditTrailLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAuditTrailMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditLinkForAssignedBuyerItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedItemType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemLinkDiscriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getSelectedReceivedBy(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierTabInFreeText(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFreeTextSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean editContractNumber(WebDriver driver, String testCaseName, String newContractNumber) throws ActionBotException;

	public String getSelectedIsGreen(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedIsPreferred(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRadioButtonReceiveByNoReceiptEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickDeleteItemIcon(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public int getAuditTrailVersion(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonShowAllPo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstPoNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFirstPoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonSelectOnPoModal(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReqItemDisplayedOnPOPage(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException;

	public void fillPoNumberFilterPomodal(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException;

	public void clickReqRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickCloseItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillManufacturerNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException;

	public void fillManufacturerUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public void fillManufacturerIdInGuidedItemPopup(WebDriver driver, String testCaseName, String id) throws ActionBotException;

	public void fillImageUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public void fillProductUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public void fillSpecificationNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException;

	public void fillSpecificationkeyInGuidedItemPopup(WebDriver driver, String testCaseName, String key) throws ActionBotException;

	public void fillSpecificationValueInGuidedItemPopup(WebDriver driver, String testCaseName, String value) throws ActionBotException;

	public void clickShowMoreExtraFields(WebDriver driver, String testCaseName) throws ActionBotException;

	void searchAndFillCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	boolean isEFormFieldVisible(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	void clickReqSelectedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickItemCheckboxIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickEditItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void selectItemCheckBoxToConvertToPO(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickReleasePOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void waitForLoadingPurchaseOrders(WebDriver driver, String testCaseName) throws ActionBotException;

	String fetchReqNumberForPORelease(WebDriver driver, String testCaseName) throws ActionBotException;

	String fetchPONumberForRelease(WebDriver driver, String testCaseName) throws ActionBotException;

	List<WebElement> fetchErrorLists(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDeliveryTabInUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException;

	void fillMultiDeliveryOnUpdateAllLines(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	String fetchGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isPurchaseOrderListingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void enterSourcingStatus(WebDriver driver, String testCaseName, String itemSourcingStatus) throws ActionBotException;

	boolean clickOnOkLinkInAddItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnOkSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnCloseIconModalAddFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfRequisitionItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemUOMDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkForPriceError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSourcingStatusLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getManufacturerPartId(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSpecificationKey(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSpecificationValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getImageURL(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProductURL(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddSpecificationButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContractNumberEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkForItemNameError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkForProductCategoryError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRequirementDetails(WebDriver driver, String testCaseName, String requirementDetails) throws ActionBotException;

	public boolean isRequirementDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddedItemSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequisitionDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequisitionItemDeliveryAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getRequisitionItemCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void selectEFormForCategoryNamewise(WebDriver driver, String testcaseName, String eformName) throws ActionBotException;

}
