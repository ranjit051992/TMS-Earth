package com.zycus.automation.eproc.pageobjects.pages.standardpo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public interface IPageStandardPO
{

	final static UI_Elements	BUTTON_EDIT											= UIFactory.getElements("BUTTON_EDIT");
	final static UI_Elements	LINK_CREATE_RECEIPT									= UIFactory.getElements("LINK_CREATE_RECEIPT");
	final static UI_Elements	TEXT_CONTRACT_NUMBER								= UIFactory.getElements("TEXT_CONTRACT_NUMBER");
	final static UI_Elements	FREIGHT_CURRENCY									= UIFactory.getElements("FREIGHT_CURRENCY");
	final static UI_Elements	BUDGET_HEADER_FIELD									= UIFactory.getElements("BUDGET_HEADER_FIELD");
	final static UI_Elements	CURRENCY_FIELD_BUDGET_TOOLTIP						= UIFactory.getElements("CURRENCY_FIELD_BUDGET_TOOLTIP");
	final static UI_Elements	FIRST_ROW_MANUFACTURER_NAME							= UIFactory.getElements("FIRST_ROW_MANUFACTURER_NAME");
	final static UI_Elements	SEARCH_BY_MANUFACTURER_NAME_TEXT_BOX				= UIFactory.getElements("SEARCH_BY_MANUFACTURER_NAME_TEXT_BOX");
	final static UI_Elements	CURRENCY_ERROR_MSG									= UIFactory.getElements("CURRENCY_ERROR_MSG");
	final static UI_Elements	HEADER_FREIGHT_TAX									= UIFactory.getElements("HEADER_FREIGHT_TAX");
	final static UI_Elements	ITEM_PRICE											= UIFactory.getElements("ITEM_PRICE");
	final static UI_Elements	CATELOG_ITEM_NO										= UIFactory.getElements("CATELOG_ITEM_NO");
	final static UI_Elements	LIST_ITEM_SUPPLIER_NAME								= UIFactory.getElements("LIST_ITEM_SUPPLIER_NAME");
	final static UI_Elements	ITEM_NOT_ADDED_AS_FREE_TEXT_ITEM_MSG				= UIFactory.getElements("ITEM_NOT_ADDED_AS_FREE_TEXT_ITEM_MSG");
	final static UI_Elements	POP_UP_ITEM_DIFF_SUPPLIERS_CANCEL_LINK				= UIFactory.getElements("POP_UP_ITEM_DIFF_SUPPLIERS_CANCEL_LINK");
	final static UI_Elements	POP_UP_ITEM_DIFF_SUPPLIERS							= UIFactory.getElements("POP_UP_ITEM_DIFF_SUPPLIERS");
	final static UI_Elements	POP_UP_ITEM_DIFF_SUPPLIERS_OK_LINK					= UIFactory.getElements("POP_UP_ITEM_DIFF_SUPPLIERS_OK_LINK");
	final static UI_Elements	POP_UP_ITEM_SUBTOTAL_OK_BUTTON						= UIFactory.getElements("POP_UP_ITEM_SUBTOTAL_OK_BUTTON");
	final static UI_Elements	POP_UP_ITEM_SUBTOTAL_MSG							= UIFactory.getElements("POP_UP_ITEM_SUBTOTAL_MSG");
	final static UI_Elements	FIRST_ITEM_NAME										= UIFactory.getElements("FIRST_ITEM_NAME");
	final static UI_Elements	FIRST_SUPPLIER_NAME									= UIFactory.getElements("FIRST_SUPPLIER_NAME");
	final static UI_Elements	ITEM_QUANTITY_LEVEL									= UIFactory.getElements("ITEM_QUANTITY_LEVEL");
	final static UI_Elements	SEARCH_ITEM_NAME									= UIFactory.getElements("SEARCH_ITEM_NAME");
	final static UI_Elements	SEARCH_SUPPLIER_NAME								= UIFactory.getElements("SEARCH_SUPPLIER_NAME");
	final static UI_Elements	RESET_LINE_ITEM_LEVEL_BUTTON						= UIFactory.getElements("RESET_LINE_ITEM_LEVEL_BUTTON");
	final static UI_Elements	BUTTON_ADD_ITEM										= UIFactory.getElements("BUTTON_ADD_ITEM");
	final static UI_Elements	BUTTON_SEARCH_ITEM									= UIFactory.getElements("BUTTON_SEARCH_ITEM");
	final static UI_Elements	TEXTBOX_ADD_ITEMS_TO_PO								= UIFactory.getElements("TEXTBOX_ADD_ITEMS_TO_PO");
	final static UI_Elements	BUTTON_SEARCH										= UIFactory.getElements("BUTTON_SEARCH");
	final static UI_Elements	TAX_NAME											= UIFactory.getElements("TAX_NAME");
	final static UI_Elements	TAX_RATE											= UIFactory.getElements("TAX_RATE");
	final static UI_Elements	BUTTON_ITEM_SUMMARY_EDIT							= UIFactory.getElements("BUTTON_ITEM_SUMMARY_EDIT");
	final static UI_Elements	BUTTON_EXPAND_ALL									= UIFactory.getElements("BUTTON_EXPAND_ALL");
	final static UI_Elements	LABEL_ITEM_NAMES									= UIFactory.getElements("LABEL_ITEM_NAMES");
	final static UI_Elements	SEARCHALL_TEXT										= UIFactory.getElements("SEARCHALL_TEXT");
	final static UI_Elements	TEXT_QUANTITY_INPUT									= UIFactory.getElements("TEXT_QUANTITY_INPUT");
	final static UI_Elements	ADD_ITEM											= UIFactory.getElements("ADD_ITEM");
	final static UI_Elements	ITEM_POPUP_CONFORMATION_MSG							= UIFactory.getElements("ITEM_POPUP_CONFORMATION_MSG");
	final static UI_Elements	BUTTOM_AMEND_ITEM_SUMMARY_EDIT						= UIFactory.getElements("BUTTOM_AMEND_ITEM_SUMMARY_EDIT");
	final static UI_Elements	BUTTON_SUBMIT_PO_FOR_PROCESSING						= UIFactory.getElements("BUTTON_SUBMIT_PO_FOR_PROCESSING");
	final static UI_Elements	BUTTON_SAVE_SUBMIT_FOR_APPROVAL						= UIFactory.getElements("BUTTON_SAVE_SUBMIT_FOR_APPROVAL");
	final static UI_Elements	REQUIRED_BY_DATE_PICKER								= UIFactory.getElements("REQUIRED_BY_DATE_PICKER");
	final static UI_Elements	SELECT_MONTH										= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements	SELECT_YEAR											= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements	REQUIRED_BY_DATE_PO_PAGE							= UIFactory.getElements("REQUIRED_BY_DATE_PO_PAGE");
	final static UI_Elements	PO_OTHER_ADDRESSES									= UIFactory.getElements("PO_OTHER_ADDRESSES");
	final static UI_Elements	PO_MY_ADDRESS										= UIFactory.getElements("PO_MY_ADDRESS");
	final static UI_Elements	BUTTON_SUBMIT_PO_STD_PO								= UIFactory.getElements("BUTTON_SUBMIT_PO_STD_PO");

	final static UI_Elements	TEXTBOX_SUPPLIER_NAME								= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME");
	final static UI_Elements	TEXTBOX_SUPPLIER_ADDRESS							= UIFactory.getElements("TEXTBOX_SUPPLIER_ADDRESS");
	final static UI_Elements	TEXTBOX_PAYMENT_TERMS								= UIFactory.getElements("TEXTBOX_PAYMENT_TERMS");
	final static UI_Elements	TEXTBOX_CURRENCY_TYPE								= UIFactory.getElements("TEXTBOX_CURRENCY_TYPE");
	final static UI_Elements	TEXTBOX_CURRENCY_VALUE								= UIFactory.getElements("TEXTBOX_CURRENCY_VALUE");
	final static UI_Elements	TEXTBOX_DELIVERY_TERMS								= UIFactory.getElements("TEXTBOX_DELIVERY_TERMS");
	final static UI_Elements	TEXTBOX_PURCHASE_TYPE								= UIFactory.getElements("TEXTBOX_PURCHASE_TYPE");
	final static UI_Elements	TEXTBOX_CONTRACT_NO									= UIFactory.getElements("TEXTBOX_CONTRACT_NO");
	final static UI_Elements	LABEL_ITEM_REFERENCE_CONTRACT						= UIFactory.getElements("LABEL_ITEM_REFERENCE_CONTRACT");
	final static UI_Elements	TEXTBOX_BUYER										= UIFactory.getElements("TEXTBOX_BUYER");
	final static UI_Elements	LINK_REVIEW_PO										= UIFactory.getElements("LINK_REVIEW_PO");
	final static UI_Elements	AMEND_MODAL_QUANTITY_ERRORMSG_LABEL					= UIFactory.getElements("AMEND_MODAL_QUANTITY_ERRORMSG_LABEL");
	final static UI_Elements	SUPPLIER_PAYMENT_TERMS_LABEL						= UIFactory.getElements("SUPPLIER_PAYMENT_TERMS_LABEL");

	final static UI_Elements	TEXTBOX_ORDER_DESCRIPTION							= UIFactory.getElements("TEXTBOX_ORDER_DESCRIPTION");
	final static UI_Elements	SUBMIT_PO_PROCESSING_DIV							= UIFactory.getElements("SUBMIT_PO_PROCESSING_DIV");
	final static UI_Elements	BUTTON_FREE_TEXT_ITEM								= UIFactory.getElements("BUTTON_FREE_TEXT_ITEM");
	final static UI_Elements	SEARCH_TEXT											= UIFactory.getElements("SEARCH_TEXT");
	final static UI_Elements	QUANTITY_INPUTS										= UIFactory.getElements("QUANTITY_INPUTS");
	final static UI_Elements	ADD_BOTTONS											= UIFactory.getElements("ADD_BOTTONS");
	final static UI_Elements	ANCSESTOR_TR										= UIFactory.getElements("ANCSESTOR_TR");
	final static UI_Elements	ADD_ITEM_VIA_FILES_LINK								= UIFactory.getElements("ADD_ITEM_VIA_FILES_LINK");
	final static UI_Elements	ITEM_NAMES_PO										= UIFactory.getElements("ITEM_NAMES_PO");
	final static UI_Elements	CANCEL_PO											= UIFactory.getElements("CANCEL_PO");
	final static UI_Elements	NO_ITEMS_AVAILABLE_MSG								= UIFactory.getElements("NO_ITEMS_AVAILABLE_MSG");

	static UI_Elements			PURCHASE_ORDER_CREATED_SUCCESS_MESSAGE				= UIFactory.getElements("PURCHASE_ORDER_CREATED_SUCCESS_MESSAGE");

	final static UI_Elements	COMPANY_PO											= UIFactory.getElements("COMPANY_PO");
	final static UI_Elements	BUSINESS_UNIT_PO									= UIFactory.getElements("BUSINESS_UNIT_PO");
	final static UI_Elements	LOCATION_PO											= UIFactory.getElements("LOCATION_PO");
	final static UI_Elements	LINK_MODIFY_DISCOUNT								= UIFactory.getElements("LINK_MODIFY_DISCOUNT");
	final static UI_Elements	CHECKBOX_NO_TAX_APPLICABLE							= UIFactory.getElements("CHECKBOX_NO_TAX_APPLICABLE");
	final static UI_Elements	DROPDOWN_TAX_TYPE									= UIFactory.getElements("DROPDOWN_TAX_TYPE");
	final static UI_Elements	TEXTBOX_TAX_NAME									= UIFactory.getElements("TEXTBOX_TAX_NAME");
	final static UI_Elements	DROPDOWN_TAX_TYPE_CHANGE_MULTIPLE					= UIFactory.getElements("DROPDOWN_TAX_TYPE_CHANGE_MULTIPLE");
	final static UI_Elements	TEXTBOX_TAX_NAME_CHANGE_MULTIPLE					= UIFactory.getElements("TEXTBOX_TAX_NAME_CHANGE_MULTIPLE");
	final static UI_Elements	RADIO_BUTTON_TAX_NOT_APPLICABLE						= UIFactory.getElements("RADIO_BUTTON_TAX_NOT_APPLICABLE");

	final static UI_Elements	BUTTON_APPLY_TAX									= UIFactory.getElements("BUTTON_APPLY_TAX");
	final static UI_Elements	LABEL_TOTAL_TAX										= UIFactory.getElements("LABEL_TOTAL_TAX");

	final static UI_Elements	TEXTBOX_SUPPLIER_CONTACT							= UIFactory.getElements("TEXTBOX_SUPPLIER_CONTACT");
	final static UI_Elements	TEXTBOX_REQUESTER_PO								= UIFactory.getElements("TEXTBOX_REQUESTER_PO");
	final static UI_Elements	TEXTBOX_TERMS_AND_CONDITIONS						= UIFactory.getElements("TEXTBOX_TERMS_AND_CONDITIONS");
	final static UI_Elements	RADIO_REQUIRE_RECEIPT								= UIFactory.getElements("CHECKBOX_REQUIRE_RECEIPT");
	final static UI_Elements	TEXTBOX_NOTES										= UIFactory.getElements("TEXTBOX_NOTES");
	final static UI_Elements	ERROR_PURCHASE_ORDER								= UIFactory.getElements("ERROR_PURCHASE_ORDER");
	final static UI_Elements	BUTTON_YES_PO										= UIFactory.getElements("BUTTON_YES_PO");
	final static UI_Elements	DELIVERY_ADDRESS_HEADER								= UIFactory.getElements("DELIVERY_ADDRESS_HEADER");
	final static UI_Elements	CHECKBOX_COMPOUND_TAX								= UIFactory.getElements("CHECKBOX_COMPOUND_TAX");
	final static UI_Elements	COMPOUND_TAX_ERROR_MESSAGE							= UIFactory.getElements("COMPOUND_TAX_ERROR_MESSAGE");
	final static UI_Elements	POPUP_WAIT_AFTER_ADD								= UIFactory.getElements("POPUP_WAIT_AFTER_ADD");
	final static UI_Elements	TAX_NON_EDITABLE_FIELDS								= UIFactory.getElements("TAX_NON_EDITABLE_FIELDS");
	final static UI_Elements	LINK_UPDATE_ALL_LINES								= UIFactory.getElements("LINK_UPDATE_ALL_LINES");
	final static UI_Elements	BUTTON_EDIT_COPY_PO									= UIFactory.getElements("BUTTON_EDIT_COPY_PO");

	final static UI_Elements	SAVE_AS_DRAFT_PO									= UIFactory.getElements("SAVE_AS_DRAFT_PO");
	final static UI_Elements	TEXTBOX_STANDARD_PO_NO								= UIFactory.getElements("TEXTBOX_STANDARD_PO_NO");
	final static UI_Elements	LABEL_STANDARD_PO_NO								= UIFactory.getElements("LABEL_STANDARD_PO_NO");
	final static UI_Elements	DELIVERY_ADDRESS									= UIFactory.getElements("DELIVERY_ADDRESS");
	final static UI_Elements	AMEND_ITEM_COPY_LINK								= UIFactory.getElements("AMEND_ITEM_COPY_LINK");
	final static UI_Elements	SUPPLIER_CURRENCY_LABEL								= UIFactory.getElements("SUPPLIER_CURRENCY_LABEL");
	final static UI_Elements	DELETE_ITEM_ICON									= UIFactory.getElements("DELETE_ITEM_ICON");
	final static UI_Elements	AUTO_GENERATED_DEFAULT_PO_NO						= UIFactory.getElements("AUTO_GENERATED_DEFAULT_PO_NO");
	final static UI_Elements	AMEND_MODAL_ITEM_QUANTITY							= UIFactory.getElements("AMEND_MODAL_ITEM_QUANTITY");
	final static UI_Elements	DELIVERY_OUADDRESS_RADIO_BTM						= UIFactory.getElements("DELIVERY_OUADDRESS_RADIO_BTM");
	final static UI_Elements	DELIVERY_MYADDRESS_RADIO_BTM						= UIFactory.getElements("DELIVERY_MYADDRESS_RADIO_BTM");
	final static UI_Elements	DELIVERY_OTHERADDRESS_RADIO_BTM						= UIFactory.getElements("DELIVERY_OTHERADDRESS_RADIO_BTM");
	final static UI_Elements	SET_REQUIREDBY_DATE									= UIFactory.getElements("SET_REQUIREDBY_DATE");
	final static UI_Elements	ITEM_POPUP_DELETE_YES_BUTTON						= UIFactory.getElements("ITEM_POPUP_DELETE_YES_BUTTON");
	final static UI_Elements	REFERENCE_TEXT_BOX									= UIFactory.getElements("REFERENCE_TEXT_BOX");
	final static UI_Elements	SELECT_DELIVERY_TERMS								= UIFactory.getElements("SELECT_DELIVERY_TERMS");
	final static UI_Elements	CONTACT_SUPPLIER									= UIFactory.getElements("CONTACT_SUPPLIER");
	final static UI_Elements	TAX_TYPE											= UIFactory.getElements("TAX_TYPE");
	final static UI_Elements	NEW_TAX_TYPE										= UIFactory.getElements("NEW_TAX_TYPE");
	final static UI_Elements	PO_EFORM_FIELD										= UIFactory.getElements("PO_EFORM_FIELD");
	final static UI_Elements	TOTAL_DISCOUNT										= UIFactory.getElements("TOTAL_DISCOUNT");
	final static UI_Elements	LINK_MODIFY											= UIFactory.getElements("LINK_MODIFY");
	final static UI_Elements	PO_NOTES											= UIFactory.getElements("PO_NOTES");
	final static UI_Elements	PO_LEVEL_COMMENTS									= UIFactory.getElements("PO_LEVEL_COMMENTS");
	final static UI_Elements	UOM_ITEM_DETAILS_FIELD								= UIFactory.getElements("UOM_ITEM_DETAILS_FIELD");
	final static UI_Elements	LIST_ITEM_NAMES_PO									= UIFactory.getElements("LIST_ITEM_NAMES_PO");
	final static UI_Elements	BUTTON_PO_NO_ERROR_MSG_POPUP						= UIFactory.getElements("BUTTON_PO_NO_ERROR_MSG_POPUP");
	final static UI_Elements	DUPLICATE_PO_NO_ERROR_MSG							= UIFactory.getElements("DUPLICATE_PO_NO_ERROR_MSG");
	final static UI_Elements	SUPPLIER_DELIVERY_TERMS_LABEL						= UIFactory.getElements("SUPPLIER_DELIVERY_TERMS_LABEL");

	final static UI_Elements	REQUIRE_RECEIPT_CHECKBOX							= UIFactory.getElements("REQUIRE_RECEIPT_CHECKBOX");
	final static UI_Elements	CHECKBOX_RECEIPT_CREATION_AT_HEADER_LEVEL			= UIFactory.getElements("CHECKBOX_RECEIPT_CREATION_AT_HEADER_LEVEL");
	final static UI_Elements	PO_TERMSANDCONDITON_FIELD							= UIFactory.getElements("PO_TERMSANDCONDITON_FIELD");
	final static UI_Elements	DISCOUNT_MODAL_SAVE_BOTTOM							= UIFactory.getElements("DISCOUNT_MODAL_SAVE_BOTTOM");
	final static UI_Elements	ITEM_TOTAL_PRICE_PO									= UIFactory.getElements("ITEM_TOTAL_PRICE_PO");
	final static UI_Elements	DISCOUNTED_PRICE									= UIFactory.getElements("DISCOUNTED_PRICE");
	final static UI_Elements	ITEM_NO_PO											= UIFactory.getElements("ITEM_NO_PO");
	final static UI_Elements	TEXTBOX_QUANTITY_COPY_PO							= UIFactory.getElements("TEXTBOX_QUANTITY_COPY_PO");
	final static UI_Elements	BUTTON_ADD_ITEM_COPY_PO								= UIFactory.getElements("BUTTON_ADD_ITEM_COPY_PO");
	final static UI_Elements	LINK_PO_ATTACHMENTS									= UIFactory.getElements("LINK_PO_ATTACHMENTS");
	final static UI_Elements	TOTAL_ITEM_LEVEL_SUB_TAX							= UIFactory.getElements("TOTAL_ITEM_LEVEL_SUB_TAX");
	final static UI_Elements	LINK_REMOVE_ALL_TAXES_PO							= UIFactory.getElements("LINK_REMOVE_ALL_TAXES_PO");
	final static UI_Elements	LABEL_PLUS_SPECIFIC_TAXES_ON_X_LINE_ITEMS_PO		= UIFactory.getElements("LABEL_PLUS_SPECIFIC_TAXES_ON_X_LINE_ITEMS_PO");
	final static UI_Elements	NET_ITEM_PRICE_PO									= UIFactory.getElements("NET_ITEM_PRICE_PO");
	final static UI_Elements	LABEL_TOTAL_DISCOUNT_ON_ITEM_SUB_TOTAL				= UIFactory.getElements("LABEL_TOTAL_DISCOUNT_ON_ITEM_SUB_TOTAL");
	final static UI_Elements	SELECT_ALL_ITEMS_LINES_CHECKBOX						= UIFactory.getElements("SELECT_ALL_ITEMS_LINES_CHECKBOX");
	final static UI_Elements	DUPLICATE_TAXES_ERROR_MSG							= UIFactory.getElements("DUPLICATE_TAXES_ERROR_MSG");
	final static UI_Elements	TEXTBOX_SPECIFICATIONS								= UIFactory.getElements("TEXTBOX_SPECIFICATIONS");
	final static UI_Elements	LABEL_COSTBOOKING_EXPAND_ALL						= UIFactory.getElements("LABEL_COSTBOOKING_EXPAND_ALL");
	final static UI_Elements	BUTTON_COLLAPSE_ALL									= UIFactory.getElements("BUTTON_COLLAPSE_ALL");
	final static UI_Elements	FREIGHT_CHARGES										= UIFactory.getElements("FREIGHT_CHARGES");
	final static UI_Elements	ITEM_BLOCK											= UIFactory.getElements("ITEM_BLOCK");
	final static UI_Elements	ERROR_UNIT_PRICE_EXCEEDING_TOLERANCE				= UIFactory.getElements("ERROR_UNIT_PRICE_EXCEEDING_TOLERANCE");
	final static UI_Elements	ERROR_ENTER_ACCOUNTING_INFORMATION					= UIFactory.getElements("ERROR_ENTER_ACCOUNTING_INFORMATION");
	final static UI_Elements	ERROR_TEXT_BASE_EXCHANGE_RATE						= UIFactory.getElements("ERROR_TEXT_BASE_EXCHANGE_RATE");
	final static UI_Elements	ERROR_VALID_QUANTITY								= UIFactory.getElements("ERROR_VALID_QUANTITY");
	final static UI_Elements	INVALID_FILE_FORMAT_ERROR_MSG						= UIFactory.getElements("INVALID_FILE_FORMAT_ERROR_MSG");
	final static UI_Elements	SELECT_OTHER_SUPPLIER_ADDRESS						= UIFactory.getElements("SELECT_OTHER_SUPPLIER_ADDRESS");
	final static UI_Elements	DROPDOWN_SUPPLIER_ADDRESS							= UIFactory.getElements("DROPDOWN_SUPPLIER_ADDRESS");
	final static UI_Elements	PO_CONTACT_EMAIL_ID									= UIFactory.getElements("PO_CONTACT_EMAIL_ID");
	final static UI_Elements	TEXTBOX_SEARCH_SUPPLIER_FOR_ITEM					= UIFactory.getElements("TEXTBOX_SEARCH_SUPPLIER_FOR_ITEM");
	final static UI_Elements	ERROR_FOR_PURCHASE_TYPE_INACTIVE_ENTITY				= UIFactory.getElements("ERROR_FOR_PURCHASE_TYPE_INACTIVE_ENTITY");
	final static UI_Elements	BUTTON_OK_FOR_CLICK_HERE_ERROR						= UIFactory.getElements("BUTTON_OK_FOR_CLICK_HERE_ERROR");
	final static UI_Elements	EXPAN_ACCOUNTING_DETAILS							= UIFactory.getElements("EXPAN_ACCOUNTING_DETAILS");
	final static UI_Elements	AUTO_UPDATED_TAX_NAME								= UIFactory.getElements("AUTO_UPDATED_TAX_NAME");
	final static UI_Elements	ERROR_MESSAGE_FOR_VALIDATION_MAP_CHECK				= UIFactory.getElements("ERROR_MESSAGE_FOR_VALIDATION_MAP_CHECK");
	final static UI_Elements	DUPLICATE_TAXES_ERROR_ICON							= UIFactory.getElements("DUPLICATE_TAXES_ERROR_ICON");
	final static UI_Elements	LIST_OF_BUTTONS_ITEM_LEVEL_EDIT						= UIFactory.getElements("LIST_OF_BUTTONS_ITEM_LEVEL_EDIT");
	final static UI_Elements	POPUP_SUBMIT_FOR_APPROVAL							= UIFactory.getElements("POPUP_SUBMIT_FOR_APPROVAL");
	final static UI_Elements	BUTTON_CANCEL_SUBMIT_FOR_APPROVAL_WORKFLOW			= UIFactory.getElements("BUTTON_CANCEL_SUBMIT_FOR_APPROVAL_WORKFLOW");
	final static UI_Elements	ALERT_MESSAGE_TO_ADD_ITEM_TO_SUBMIT					= UIFactory.getElements("ALERT_MESSAGE_TO_ADD_ITEM_TO_SUBMIT");
	final static UI_Elements	INVALID_FILE_FORMAT_ERROR_POP_UP					= UIFactory.getElements("INVALID_FILE_FORMAT_ERROR_POP_UP");
	final static UI_Elements	ITEM_NAME_MISSING_MSG_DISPLAYED						= UIFactory.getElements("ITEM_NAME_MISSING_MSG_DISPLAYED");
	final static UI_Elements	ITEM_PRODUCT_CATAGORY_MISSING						= UIFactory.getElements("ITEM_PRODUCT_CATAGORY_MISSING");
	final static UI_Elements	UNIT_PRICE_MISSING_MSG_DISPLAYED					= UIFactory.getElements("UNIT_PRICE_MISSING_MSG_DISPLAYED");
	final static UI_Elements	UOM_MISSING_MSG_DISPLAYED							= UIFactory.getElements("UOM_MISSING_MSG_DISPLAYED");
	final static UI_Elements	LABEL_ITEM_SUPPLIER_NAME							= UIFactory.getElements("LABEL_ITEM_SUPPLIER_NAME");
	final static UI_Elements	POPUP_INVALID_CHECKOUT_BUYER						= UIFactory.getElements("POPUP_INVALID_CHECKOUT_BUYER");
	final static UI_Elements	ITEM_UPLOAD_DULICATE_LINE_NO_MSG					= UIFactory.getElements("ITEM_UPLOAD_DULICATE_LINE_NO_MSG");
	final static UI_Elements	PURCHASE_TYPE_ERROR_MSG								= UIFactory.getElements("PURCHASE_TYPE_ERROR_MSG");
	final static UI_Elements	DIFF_DELIVERY_DATE_ERROR_MSG						= UIFactory.getElements("DIFF_DELIVERY_DATE_ERROR_MSG");
	final static UI_Elements	ITEM_EXPAND_COSTBOOKING_EDIT						= UIFactory.getElements("ITEM_EXPAND_COSTBOOKING_EDIT");
	final static UI_Elements	LABEL_AUTOMATICALLY_APPLY_TAX						= UIFactory.getElements("LABEL_AUTOMATICALLY_APPLY_TAX");
	final static UI_Elements	HEADER_PO_TOTAL										= UIFactory.getElements("HEADER_PO_TOTAL");
	final static UI_Elements	HEADER_COST_CENTER									= UIFactory.getElements("HEADER_COST_CENTER");
	final static UI_Elements	HEADER_CC_QTIP										= UIFactory.getElements("HEADER_CC_QTIP");
	final static UI_Elements	TAX_ITEM_GRID										= UIFactory.getElements("TAX_ITEM_GRID");
	final static UI_Elements	MORE_THAN_25_ITEM_ERROR_MSG							= UIFactory.getElements("MORE_THAN_25_ITEM_ERROR_MSG");
	final static UI_Elements	MAX_ITEM_ALERT_OK_BTN								= UIFactory.getElements("MAX_ITEM_ALERT_OK_BTN");
	final static UI_Elements	BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE	= UIFactory.getElements("BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE");
	final static UI_Elements	LINK_DEFINE_BUYING_SCOPE							= UIFactory.getElements("LINK_DEFINE_BUYING_SCOPE");
	final static UI_Elements	ERROR_QUANTITY_EXCEEDING_MAX_VALUE					= UIFactory.getElements("ERROR_QUANTITY_EXCEEDING_MAX_VALUE");
	final static UI_Elements	AUDIT_TRAIL_FIRST_ACTION							= UIFactory.getElements("AUDIT_TRAIL_FIRST_ACTION");
	final static UI_Elements	AUDIT_TRAIL_FIRST_VERSION							= UIFactory.getElements("AUDIT_TRAIL_FIRST_VERSION");

	UI_Elements					LABEL_RELEASE_NO_ERROR								= UIFactory.getElements("LABEL_RELEASE_NO_ERROR");
	UI_Elements					TEXTBOX_RELEASE_NO									= UIFactory.getElements("TEXTBOX_RELEASE_NO");
	UI_Elements					LABEL_RELEASE_NO									= UIFactory.getElements("LABEL_RELEASE_NO");
	UI_Elements					BUTTON_COPY_ITEM_PO_PAGE							= UIFactory.getElements("BUTTON_COPY_ITEM_PO_PAGE");
	UI_Elements					LINK_ADD_ITEMS_FROM_REQUISITION						= UIFactory.getElements("LINK_ADD_ITEMS_FROM_REQUISITION");
	UI_Elements					CHECKBOX_MARK_FOR_ADDING_APPROVERS_IN_PO			= UIFactory.getElements("CHECKBOX_MARK_FOR_ADDING_APPROVERS_IN_PO");
	UI_Elements					AUDIT_TRAIL_FIRST_ACTION_IN_VIEW_PO					= UIFactory.getElements("AUDIT_TRAIL_FIRST_ACTION_IN_VIEW_PO");

	String						xpath1_editItemSummary								= ".//tr[.//*[contains(text(),'";
	String						xpath2_editItemSummary								= "')]]//a[contains(@class,'edit')]";
	UI_Elements					ERROR_MSG_BUDGET_EXHAUSTED_ON_PO					= UIFactory.getElements("ERROR_MSG_BUDGET_EXHAUSTED_ON_PO");
	UI_Elements					LABEL_BUDGET_LINE_FOR_BUDGET_EXHAUSTED_ON_PO		= UIFactory.getElements("LABEL_BUDGET_LINE_FOR_BUDGET_EXHAUSTED_ON_PO");
	UI_Elements					ERROR_MSG_ON_PO										= UIFactory.getElements("ERROR_MSG_ON_PO");
	UI_Elements					ERROR_MSG_ON_ALERT_POP_UP_FOR_PO					= UIFactory.getElements("ERROR_MSG_ON_ALERT_POP_UP_FOR_PO");
	UI_Elements					LABEL_SUPPLIER_CURRENCY								= UIFactory.getElements("LABEL_SUPPLIER_CURRENCY");
	UI_Elements					PAGINATION_NEXT_ITEM_SEARCH_PO						= UIFactory.getElements("PAGINATION_NEXT_ITEM_SEARCH_PO");
	UI_Elements					LABEL_SUPPLIER_CURRENCY_VALUE						= UIFactory.getElements("LABEL_SUPPLIER_CURRENCY_VALUE");
	final static UI_Elements	LINK_CREATE_NEW_ADDRESS_PO_SUMMARY					= UIFactory.getElements("LINK_CREATE_NEW_ADDRESS_PO_SUMMARY");

	final static UI_Elements	NEW_ADDRESS_NAME									= UIFactory.getElements("NEW_ADDRESS_NAME");
	final static UI_Elements	NEW_ADDRESS_STREET_NAME								= UIFactory.getElements("NEW_ADDRESS_STREET_NAME");
	final static UI_Elements	NEW_ADDRESS_COUNTRY_NAME							= UIFactory.getElements("NEW_ADDRESS_COUNTRY_NAME");
	final static UI_Elements	TEXTBOX_CITY_PO_SUMMARY								= UIFactory.getElements("TEXTBOX_CITY_PO_SUMMARY");
	final static UI_Elements	BUTTON_POPUP_ADDRESS_CHANGED_YES					= UIFactory.getElements("BUTTON_POPUP_ADDRESS_CHANGED_YES");
	final static UI_Elements	LABEL_ERROR_MSG_AMEND_PO_UPON_SUBMIT				= UIFactory.getElements("LABEL_ERROR_MSG_AMEND_PO_UPON_SUBMIT");

	final static UI_Elements	EMAIL_SUPPLIER										= UIFactory.getElements("EMAIL_SUPPLIER");
	final static UI_Elements	TEXT_ITEM_SUB_TOTAL									= UIFactory.getElements("TEXT_ITEM_SUB_TOTAL");
	final static UI_Elements	ITEM_TABLE_HEADER_PO_VIEW							= UIFactory.getElements("ITEM_TABLE_HEADER_PO_VIEW");
	final static UI_Elements	TEXT_COMPANY_CURRENCY								= UIFactory.getElements("TEXT_COMPANY_CURRENCY");
	final static UI_Elements	AMOUNT_AT_COST_BOOKING_AFTER_EXPAND_ALL				= UIFactory.getElements("AMOUNT_AT_COST_BOOKING_AFTER_EXPAND_ALL");
	final static UI_Elements	AMOUNT_AT_ACCOUNTING_AFTER_EXPAND_ALL				= UIFactory.getElements("AMOUNT_AT_ACCOUNTING_AFTER_EXPAND_ALL");
	final static UI_Elements	ACCOUNTING_ERROR_BLANK								= UIFactory.getElements("ACCOUNTING_ERROR_BLANK");
	final static UI_Elements	PO_FIRST_ADDED_ITEM									= UIFactory.getElements("PO_FIRST_ADDED_ITEM");
	final static UI_Elements	CURRENCY_EXCHANGE_RATE								= UIFactory.getElements("CURRENCY_EXCHANGE_RATE");
	final static UI_Elements	ALERT_MESSAGE_INVALID_ATTACHMENT					= UIFactory.getElements("ALERT_MESSAGE_INVALID_ATTACHMENT");
	final static UI_Elements	ERROR_QUANTITY_ITEM_SUMMARY							= UIFactory.getElements("ERROR_QUANTITY_ITEM_SUMMARY");
	final static UI_Elements	TAX_SUB_TOTAL										= UIFactory.getElements("TAX_SUB_TOTAL");
	final static UI_Elements	TEXTBOX_TAX_TYPE									= UIFactory.getElements("TEXTBOX_TAX_TYPE");
	final static UI_Elements	ITEM_CONTRACT_NUMBER_PAGE_PO						= UIFactory.getElements("ITEM_CONTRACT_NUMBER_PAGE_PO");
	final static UI_Elements	INVALID_AMOUNT_ERROR								= UIFactory.getElements("INVALID_AMOUNT_ERROR");

	public List<WebElement> getAddItemButtons(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEdit(WebDriver driver) throws ActionBotException;

	public void clickOnResetlineCrossButton(WebDriver driver) throws ActionBotException;

	public String clickOnAdd(WebDriver driver, int index) throws ActionBotException;

	public void clickOnOkMoreItemAlertPopUp(WebDriver driver) throws ActionBotException;

	public void clickOnAddItem(WebDriver driver) throws ActionBotException;

	// Item Summary Edit locator Not same as standard po page
	public void clickOnAmendItemSummaryEdit(WebDriver driver) throws ActionBotException;

	public void clickOnCancelPo(WebDriver driver) throws ActionBotException;

	public void clickOnIstRowManufacturer(WebDriver driver) throws ActionBotException;

	public void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException;

	public void clickOnCopedItemSummaryEdit(WebDriver driver, int index) throws ActionBotException;

	public void clickOnDiscountModalSaveBtm(WebDriver driver) throws ActionBotException;

	public void clickOnErrorModalCloseBtn(WebDriver driver) throws ActionBotException;

	public void clickOnErrorMsgPopupYesButton(WebDriver driver) throws ActionBotException;

	public void clickOnExpandAll(WebDriver driver) throws ActionBotException;

	public void clickOnFreeTextItem(WebDriver driver) throws ActionBotException;

	public List<WebElement> getListOfItemNames(WebDriver driver) throws ActionBotException;

	public void clickOnItemCopyLink(WebDriver driver) throws ActionBotException;

	public void clickOnItemDeleteLink(WebDriver driver) throws ActionBotException;

	public void clickOnItemDeleteYesPopup(WebDriver driver) throws ActionBotException;

	public void clickOnItemSummaryEdit(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public void clickOnModifyLink(WebDriver driver) throws ActionBotException;

	public void clickOnMyDeliveryAddressRadioBtm(WebDriver driver) throws ActionBotException;

	public void clickOnRequireReceiptChkbox(WebDriver driver) throws ActionBotException;

	public void clickOnReViewPoLink(WebDriver driver) throws ActionBotException;

	public void clickOnSaveAsDraftPo(WebDriver driver) throws ActionBotException;

	public void clickOnSearch(WebDriver driver) throws ActionBotException;

	public void clickOnSearchItem(WebDriver driver) throws ActionBotException;

	public void clickOnRemoveTaxBtn(WebDriver driver, int index) throws ActionBotException;

	public String selectDeliveryTerms(WebDriver driver, String deliveryTerms) throws ActionBotException;

	public void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	// click on submitPoForProcessing
	public void clickOnSubmitPOForProcessing(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterBuyer(WebDriver driver, String buyer) throws ActionBotException;

	public String getBuyer(WebDriver driver) throws ActionBotException;

	public String getItemlevelTax(WebDriver driver) throws ActionBotException;

	public int enterContractNo(WebDriver driver, int contractNo) throws ActionBotException;

	public String enterCurrencyType(WebDriver driver, String currencyType) throws ActionBotException;

	public String fillSearchByManufacturerName(WebDriver driver, String manufacturerName) throws ActionBotException;

	public Double enterCurrencyValue(WebDriver driver, Double CurrencyValue) throws ActionBotException;

	public String enterDeliveryTerms(WebDriver driver, String deliveryTerms) throws ActionBotException;

	public int enterInQuantity(WebDriver driver, int index) throws ActionBotException;

	public String enterOrderDescription(WebDriver driver, String orderDescription) throws ActionBotException;

	public String enterPaymentTerms(WebDriver driver, String paymentTerms) throws ActionBotException;

	public String enterPurchaseType(WebDriver driver, String purchaseType) throws ActionBotException;

	public String enterSupplierAddress(WebDriver driver, String supplierAddress) throws ActionBotException;

	public String enterSupplierName(WebDriver driver, String supplierName) throws ActionBotException;

	public String fillAddItemsToPOField(WebDriver driver, String addItemsToPOfield) throws ActionBotException;

	public String clearAndfillPoNo(WebDriver driver, String poNo) throws ActionBotException;

	public int clearAndfillFreightTax(WebDriver driver, String testCaseName, int Freight) throws ActionBotException;

	public String fillItemName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException;

	public String fillPoEformTextField(WebDriver driver, String testCaseName, String searchText) throws ActionBotException;

	public String clearAndfillPoEformTextField(WebDriver driver, String testCaseName, String text) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException;

	public String fillAmendPoItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public String fillAmendPoNotes(WebDriver driver, String testCaseName, String Notes) throws ActionBotException;

	public String fillDiscountField(WebDriver driver, String testCaseName, int rates) throws ActionBotException;

	public String fillPoNoWithDuplicatepoNo(WebDriver driver, String duplicatePonNo) throws ActionBotException;

	public List<WebElement> fillQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillPreviousdate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillSupplierContractNo(WebDriver driver, String contractNo) throws ActionBotException;

	public String fillTaxTypeRATE(WebDriver driver, String taxrate) throws ActionBotException;

	public String getAutogeneratedPoNo(WebDriver driver, String autogeneratedpo) throws ActionBotException;

	public String getFirstItemName(WebDriver driver) throws ActionBotException;

	public String getFirstSupplierName(WebDriver driver) throws ActionBotException;

	public String getBudgetInItem(WebDriver driver, String id) throws ActionBotException;

	public String getCostCenterInItem(WebDriver driver, String id) throws ActionBotException;

	public String getDeleteConformationMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDuplicatePoNoErrorMsg(WebDriver driver, String errorMsg) throws ActionBotException;

	List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getContractNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectInItem(WebDriver driver, String id) throws ActionBotException;

	public boolean isCancelLinkPresent(WebDriver driver) throws ActionBotException;

	public boolean isContractNoCopied(WebDriver driver) throws ActionBotException;

	public boolean isCurrencyTypeFieldBlank(WebDriver driver) throws ActionBotException;

	public boolean isCurrencyValueFieldBlank(WebDriver driver) throws ActionBotException;

	public boolean isconvertedpricedisplayed(WebDriver driver) throws ActionBotException;

	public boolean isDeliveryDateBlank(WebDriver driver) throws ActionBotException;

	public String isDeliveryDateEditable(WebDriver driver) throws ActionBotException;

	public String fillPOChangeField(WebDriver driver, String Comments) throws ActionBotException;

	boolean isEditableDeliveryAddress(WebDriver driver, String address) throws ActionBotException;

	public boolean isEditableDiscountField(WebDriver driver) throws ActionBotException;

	public boolean isAccountingDetailsPresentAftersItemExpand(WebDriver driver) throws ActionBotException;

	public boolean isAddItemViaFileLinkPresent(WebDriver driver) throws ActionBotException;

	public boolean isEditableDraftpoNoField(WebDriver driver) throws ActionBotException;

	boolean isEditableOtherDeliveryAddress(WebDriver driver, String otheraddress) throws ActionBotException;

	public boolean isEditablePoNotesField(WebDriver driver, String poNotes) throws ActionBotException;

	public boolean isEditableReference(WebDriver driver, String reference) throws ActionBotException;

	public boolean isEditableRequireReceiptCheckBox(WebDriver driver) throws ActionBotException;

	public boolean isEditableSupplierContact(WebDriver driver, String contact) throws ActionBotException;

	public boolean isRemovalTaxBtnPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isEditableSupplierPaymentTerms(WebDriver driver) throws ActionBotException;

	public boolean isEditableTaxType(WebDriver driver) throws ActionBotException;

	public boolean isEditableTearmsAndConditonSFiled(WebDriver driver, String termsAndConditions) throws ActionBotException;

	public boolean isEnabledAddTax(WebDriver driver) throws ActionBotException;

	public boolean isQuantityErrorMessagedisplayed(WebDriver driver) throws ActionBotException;

	public boolean isResultOfItemDisplayed(WebDriver driver) throws ActionBotException;

	public boolean isReviewPoLinkPresent(WebDriver driver) throws ActionBotException;

	public boolean isSaveAsDraftlinkpresent(WebDriver driver) throws ActionBotException;

	public boolean isSubmitPoForProcessingButtomPresent(WebDriver driver) throws ActionBotException;

	public boolean isSupplierCurrencydisplayedAslabel(WebDriver driver) throws ActionBotException;

	public boolean isSupplierDeliveryTermsdisplayedAslabel(WebDriver driver) throws ActionBotException;

	public boolean isSupplierPaymentTermsdisplayedAslabel(WebDriver driver) throws ActionBotException;

	public String isUOMfieldItemDetailsEditable(WebDriver driver, String UOM) throws ActionBotException;

	public String getCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModify(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPreloadedTaxTypePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isPreloadedTaxTypeNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isPreloadedTaxNamePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isDeleteItemDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPreloadedTaxNameNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isPreloadedTaxRatePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isInvalidFileFormatErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPreloadedTaxRateNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public void clickOnUpdateAllLinesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAllItemLineCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTotalTaxNull(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemSummaryEditPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException;

	public String getTermsAndConditions(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequireReceiptOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException;

	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String changeCurrencyOfSupplier(WebDriver driver, String testCaseName, String changedCurrency) throws ActionBotException;

	public String getCurrencyAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDeliveryAddressOfHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCompoundTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;

	public String enterTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException;

	public String enterFreeTextTaxName(WebDriver driver, String testCaseName, String freeTextTaxName, int index) throws ActionBotException;

	public Integer enterTaxRate(WebDriver driver, String testCaseName, int taxRate, int index) throws ActionBotException;

	public void clickOnTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public Integer getTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnAddSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnRemoveSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnAddCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnRemoveCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemPriceOfItem(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getIstRowManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void compareCurrencyType(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean checkForZeroTaxRateValidation(WebDriver driver, String testCaseName, int index, int taxRate) throws ActionBotException, TestCaseException;

	public void hoverOnErrorIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isNoItemAvailableMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNotAddedAsFreeTextItemMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInlineSectionpresentUnderItemGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPopUpForItemDiffSupplierPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNewFreeTextItemCreated(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkForMaximumTaxRate(WebDriver driver, String testCaseName, int index, long taxRate) throws ActionBotException, TestCaseException;

	public boolean arePredefinedTaxFieldsNonEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditItemCopyPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getHeaderLineNo(WebDriver driver, String testCaseName, int no) throws ActionBotException;

	public String getAddedItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getCatelogItemNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean getItemSubTotalShouldNotBeZeroMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterSimpleTaxName(WebDriver driver, String testCaseName, String simpleTaxName, int index) throws ActionBotException;

	public List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public Double getTotalAmountWithoutSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSubmitPOForProcessing(WebDriver driver) throws ActionBotException;

	public String getSimpleTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getTotalItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalAmountBeforeAddingCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnAddNewTaxType(WebDriver driver) throws ActionBotException;

	public void clickOnItemSubTotalShouldNotBeZeroPopUp(WebDriver driver) throws ActionBotException;

	public void clickOnPopItemDiffSupplierCancelLink(WebDriver driver) throws ActionBotException;

	public void clickOnPopItemDiffSupplierOkLink(WebDriver driver) throws ActionBotException;

	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer enterQuantityOfItem(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public void clickOnAddItemInPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getOrderedQuantityTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPONumberAfterAmmendingPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddCompoundTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public Double enterDecimalFormatTaxRate(WebDriver driver, String testCaseName, int index, double taxRate) throws ActionBotException;

	public void clickOnPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemLevelTotalTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTaxTypeFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isTaxNameFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isTaxRateFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isTaxAmountFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isRemoveAllTaxesOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveAllTaxesOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPlusSpecificTaxesOnXLineItemsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPlusSpecificTaxesOnXLineItemsALabel(WebDriver driver, String testCaseName) throws ActionBotException, Exception;

	public String getItemNetPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isLabelTotalDiscountOnItemSubTotalPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public int enterTaxAmount(WebDriver driver, String testCaseName, int index, int taxAmount) throws ActionBotException;

	public boolean isDuplicateTaxesErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRemovalTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierContactByFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException;

	public String fillSupplierContactByLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException;

	public String getCostBookingSectionDetailsAfterExpandingInfoAtHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCollapseAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFreightCharges(WebDriver driver, String testCaseName, String freight) throws ActionBotException;

	public boolean isItemBlockPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrencyValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUnitPriceExceedingToleranceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorToEnterAccountingInformationPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearCurrencyValueField(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBaseExchangrRateErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidFileFormatPop_upDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEnterValidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnCopyButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public List<WebElement> getListOFSearchedItemNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean arePredefinedTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemNetTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierContactValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectSupplierAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException;

	public void clickOnDropdownSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOContactEmailIDPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyItem(WebDriver driver, String testCaseName, String id) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getMarketPriceOfAddedItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getHeaderCcPoTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchSupplierForItem(WebDriver driver, String testCaseName, String supplier) throws ActionBotException;

	public void clickOnClickHereErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemExpandCostbookingEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOKForClickHereError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isValidationMapCheckErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDuplicateTaxErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAutoUpdatedTaxNameName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFreightCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHeaderPoTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException;

	public List<WebElement> getListOfItemLevelEditButtons(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSubmitForApprovalWorkflowPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelOnSubmitForApprovalPopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddItemViaFileLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertAddItemToContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAlertMessageOfAddItemToContinue(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditableCommentsFields(WebDriver driver, String Comments) throws ActionBotException;

	public boolean isPOChangeCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNameMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItempopUpDuplicateLineErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductCatagoryMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUnitPriceMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUoMMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getInvalidCheckoutBuyerText(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidCheckoutBuyerPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPurchaseTypeErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDiffDeliveryDateErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTaxDisplayedAsLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMaxNoItemErrorMasgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDefineBuyingScopeLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isQuantityExceedingMaxValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReleaseNoError(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String fillReleaseNo(WebDriver driver, String testCaseName, String releaseNo) throws ActionBotException;

	public String getValueOfLabelReleaseNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isLabelReleaseNoPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillOrderDescription(WebDriver driver, String testCaseName, String orderDescription) throws ActionBotException;

	public void clickOnAddItemFromRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnEditItemSummaryButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnMarkForAddingApprovers(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetLineForBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBudgetExhaustedErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorMsgPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getErrorMsgOnAlertBoxPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getItemUOM(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public boolean isItemPresentUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getSelectedDeliveryTerm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierDeliveryTermFromLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectSupplierDeliveryTermPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNextPaginationPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextPagination(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrencyOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickLinkCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCustomAddressName(WebDriver driver, String testCaseName, String newAddress) throws ActionBotException;

	public String fillCustomAddressStreet1(WebDriver driver, String testCaseName, String newStreet1) throws ActionBotException;

	public void fillCustomAddressCountry(WebDriver driver, String testCaseName, String newCountry) throws ActionBotException;

	public String fillCustomAddressCity(WebDriver driver, String testCaseName, String newCity) throws ActionBotException;

	public boolean clickAddressChangeButtonYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplieremailId(WebDriver driver, String testCaseName, String testData) throws ActionBotException;

	public void clickOnSubmitPOForProcessingStandardPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSubTotalPriceIndexWise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getCompanyDefaultCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;

	public String getAmountAtCostBookingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAmountAtAccountingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBlankAccountingErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCurrencyExchangeRate(WebDriver driver, String testCaseName, int exchangeRate) throws ActionBotException, FactoryMethodException;

	public void deleteItemByItemId(WebDriver driver, String testCaseName, String itemId) throws FactoryMethodException, ActionBotException;

	public boolean isDeliveryMyAddressRadioButtonEnabled(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException;

	public String getSubTotalTax(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException;

	public String getTaxRateIndexWise(WebDriver driver, String testCaseName, int index) throws FactoryMethodException, ActionBotException;

	String fillTermsAndConditions(WebDriver driver, String testCaseName, String termsAndCondition) throws ActionBotException;

	public boolean isSupplierAddressEditable(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException;

	public String getItemContractNumber(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException;

	public boolean checkInvalidAmountError(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException;
}
