/**
 * 
 */
package com.zycus.automation.eproc.testdata;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 */
public interface IConstantsData
{
	// hibernate configuration
	String				connection_url														= ConfigProperty.getConfig("Connection_URL");
	String				connection_username													= ConfigProperty.getConfig("Connection_Username");
	String				connection_password													= ConfigProperty.getConfig("Connection_Password");

	// role names
	String				Delegate_Role														= "Delegate_Role";
	String				Buyer_Role															= "Buyer_Role";
	String				Approver_Role														= "Approver_Role";
	String				Requisitioner_Role													= "Requisitioner_Role";
	final static String	ALL																	= "ALL";

	// Email Testing Constants
	final static String	Email_Testing_Username												= ConfigProperty.getConfig("Email_Testing_Username");
	final static String	Email_Testing_Password												= ConfigProperty.getConfig("Email_Testing_Password");
	final static String	Email_Testing_Default_Folder_Of_Emails								= ConfigProperty.getConfig("Email_Testing_Default_Folder_Of_Emails");
	final static String	Approval_Actor_Name													= ConfigProperty.getConfig("Approval_Actor_Name");

	// REQUISITION APPROVE ACTIONS
	final static String	VIEW																= "VIEW";
	final static String	APPROVE																= "APPROVE";
	final static String	REJECT																= "REJECT";
	final static String	DELEGATE															= "DELEGATE";
	final static String	REVOKE																= "REVOKE";

	// All Requests Approval
	final static String	APPROVED															= "Approved";
	final static String	APPROVE_COMMENT														= "This is auto generated comment for approval";
	final static String	REJECT_COMMENT														= "This is auto generated comment for rejection";
	final static String	DELEGATE_COMMENT													= "This is auto generated comment for delegation";

	// My requisition action comments
	final static String	RECALL_COMMENT														= "This is auto generated comment for Recall Approval Request";

	// PO Comment
	static String		CONVERT_TO_PO_COMMENT												= "This is auto generated comment for convert to PO";
	static String		RECALL_APPROVAL_REQUEST_COMMENT										= "This is auto generated comment for Recall approval Request";
	static String		PO_CHANGE_COMMENT													= "This is auto generated comment for PO change";

	// Buyers desk comment
	static String		COMMENT_FOR_SUPPLIER												= "This is auto generated comment for supplier";
	static String		COMMENT_FOR_RETURN_REQUISITION										= "This is auto generated comment for returning requisition";
	static String		COMMENT_FOR_CHANGE_IN_REQUISITION									= "This is auto generated comment for change in requisition";
	static String		COMMENT_FOR_CHANGE_ASSIGNED_BUYER									= "This is auto generated comment for change assigned buyer";
	static String		COMMENT_FOR_REPLACE_ITEM											= "This is auto generated comment for replace of an item";

	// All Requests Approval Filter status
	final static String	PENDING_FILTER_STATUS												= "Pending";
	final static String	APPROVED_FILTER_STATUS												= "Approved";
	final static String	REJECTED_FILTER_STATUS												= "Rejected";
	final static String	DELEGATED_FILTER_STATUS												= "Delegated";

	// Buyer's Desk Filter Status
	final static String	PENDING_ORDER														= "Pending Order";
	final static String	UNORDERED															= "Unordered";
	final static String	PARTIALLY_ORDERED													= "Partially Ordered";

	final static String	PROCESSED															= "Processed";
	final static String	RETURNED_WITH_QUOTE													= "Returned with Quote";
	final static String	RETURNED_FOR_MODIFICATION											= "Returned for modification";
	final static String	ORDERED																= "Ordering";
	final static String	RELEASED															= "Released";
	final static String	REJECTED															= "Rejected";

	final static String	SOURCING_STATUS														= "Sourcing Status";
	final static String	BUYER_NEGOTIATED_PRICE												= "Buyer Negotiated Price";
	final static String	QUOTED_BY_SUPPLIER													= "Quoted by supplier";
	final static String	ESTIMATED_PRICE														= "Estimated price";
	final static String	NEED_A_QUOTE														= "Need a Quote";
	final static String	ASSET_NUMBERING_REQUIRED											= "Asset numbering required";

	final static String	RECALL																= "Recall";
	final static String	CANCELLED															= "Cancelled";
	final static String	CLOSED																= "Closed";
	final static String	AWAITING_QUOTE														= "Awaiting Quote";
	final static String	AWAITING_REVIEW														= "Awaiting Review";

	// guided Item form Fill
	// item type
	final static String	Goods																= "Goods";
	final static String	Services															= "Services";

	// sourcing status
	final static String	Quoted_by_supplier													= "Quoted by supplier";
	final static String	Estimated_price														= "Estimated price";
	final static String	Need_a_Quote														= "Need a Quote";

	// received by
	final static String	Quantity															= "Quantity";
	final static String	Amount																= "Amount";
	final static String	No_Receipt															= "No Receipt";

	final static String	Is_Green															= "Is Green";
	final static String	Is_Preferred														= "Is Preferred";

	// req setting for assigned buyer
	final static String	REQUIRED															= "Required";
	final static String	OPTIONAL															= "Optional";
	final static String	HIDDEN																= "Hidden";

	// My Requisition Filter
	final static String	IN_PROCESS_FILTER_LABEL												= "In Process";
	final static String	DRAFT_FILTER_LABEL													= "Draft";
	final static String	READY_FOR_APPROVAL_FILTER_LABEL										= "Ready for approval";
	final static String	IN_APPROVAL_FILTER_LABEL											= "In Approval";
	// status
	// changed
	// from
	// ready
	// for
	// approval
	// to
	// in
	// process
	final static String	WITH_BUYER_FILTER_LABEL												= "With buyer";
	final static String	RETURNED_FOR_AMENDMENT_FILTER_LABEL									= "Returned For Amendment";
	final static String	SCHEDULED_FILTER_LABEL												= "Scheduled";
	final static String	COMPLETE_RELEASED_FILTER_LABEL										= "Released";
	final static String	PARTIALLY_ORDERED_FILTER_LABEL										= "Partially Ordered";
	final static String	NOT_RECEIVED_FILTER_LABEL											= "Not Received";
	final static String	PARTIALLY_RECEIVED_FILTER_LABEL										= "Partially Received";
	final static String	FULLY_RECEIVED_FILTER_LABEL											= "Fully Received";
	final static String	REJECTED_FILTER_LABEL												= "Rejected";
	final static String	CLOSED_FILTER_LABEL													= "Closed";
	final static String	CANCELLED_FILTER_LABEL												= "Cancelled";
	final static String	RETURNED_WITH_QUOTE_FILTER_LABEL									= "Returned with Quote";
	final static String	SENT_FOR_QUOTE_FILTER_LABEL											= "Sent for Quote";
	String				NOT_SENT_TO_SUPPLIER												= "Not sent to supplier";
	final static String	ORDERING_FILTER_LABEL												= "Ordering";
	final static String	TRANSFERRED_TO_ME_FILTER_LABEL										= "transferredToMe";
	final static String	SENT_FOR_BUYER_REVIEW_FILTER_LABEL									= "sent For Buyer Review";

	//Label Text
	final static String	TRANSFERRED_TO_ME_FILTER_LABEL_TEXT									= "Transferred to me";
	final static String	SENT_FOR_BUYER_REVIEW_FILTER_LABEL_TEXT								= "Sent for Buyer Review";
	final static String	WITH_BUYER_FILTER_LABEL_TEXT										= "With Buyer";

	// PO filter
	final static String	PARKED_FILTER														= "Parked";

	// buyers desk filter
	final static String	PARKED_FILTER_LABEL													= "parked";
	final static String	ORDERED_FILTER_LABEL												= "ordered";
	final static String	AWAITING_QUOTE_FILTER_LABEL											= "Awaiting Quote";
	final static String	PENDIN_ORDER_FILTER_LABEL											= "Pending Order";

	// Search user options
	final static String	SEARCH_USER_BY_NAME													= "Name";
	final static String	SEARCH_USER_BY_EMAIL_ID												= "Email Id";

	// Billing Requisition Summary Actions
	final static String	SAVE																= "SAVE";
	final static String	CANCEL																= "CANCEL";
	final static String	NONE																= "NONE";
	final static String	DELETE																= "DELETE";

	final static String	ContinueShopping													= "ContinueShopping";
	// Guided Item Activities
	final static String	Checkout															= "Checkout";
	final static String	ViewItem															= "ViewItem";
	final static String	AddAnotherItem														= "AddAnotherItem";
	final static String	SUGGEST_SUPPLIER													= "SUGGEST_SUPPLIER";
	final static String	SUGGEST_NEW_SUPPLIER												= "SUGGEST_NEW_SUPPLIER";
	final static String	SUGGEST_EXISTING_SUPPLIER											= "SUGGEST_EXISTING_SUPPLIER";
	final static String	EXISTING_SUPPLIER													= "EXISTING_SUPPLIER";
	final static String	NEW_SUPPLIER														= "NEW_SUPPLIER";
	final static String	SUGGEST																= "SUGGEST";
	final static String	ADD_SUGGEST_SUPPLIER												= "ADD_SUGGEST_SUPPLIER";

	final static String	ApprovalComment														= "Auto generated comment for Approval";
	final static String	SupplierComment														= "Auto generated comment for Supplier ";

	// select approver list messages
	final static String	SELECT_APPROVER_LIST_MESSAGE										= "This requisition is not submitted for approval. Please select approvers";

	// Item type for default object creation
	final static String	CATALOG_ITEM														= "catalogItem";
	final static String	GUIDED_ITEM															= "guidedItem";
	final static String	BOTH																= "both";
	final static String	ITEM_MASTER_ITEM													= "itemMasterItem";

	// Purchase order
	final static String	LABEL_ASSIGN_PROJECT_TO_PURCHASE_COST								= "Assign project to purchase cost";
	final static String	PO_TO_BE_GENERATED_NOTES											= "Auto generated description for PO.Auto generated description for PO.Auto generated description for PO.Auto generated description for PO.Auto generated description for PO.Auto generated description for PO.";

	// Settlement via option
	final static String	SETTLEMENT_VIA_OPTION_INVOICE										= "SETTLEMENT_VIA_OPTION_INVOICE";
	final static String	SETTLEMENT_VIA_OPTION_PCARD											= "SETTLEMENT_VIA_OPTION_PCARD";
	final static String	SETTLEMENT_VIA_OPTION_DISBURSEMENT									= "SETTLEMENT_VIA_OPTION_DISBURSEMENT";
	String				DISBURSEMENT_SETTLEMENT_VIA_OPTION									= "Disbursement";
	String				PCARD_SETTLEMENT_VIA_OPTION											= "User P-card";
	String				INVOICE_SETTLEMENT_VIA_OPTION										= "Invoice";

	// submit req options
	final static String	SUBMIT_REQ															= "SUBMIT_REQ";
	final static String	SAVE_AS_DRAFT_REQ													= "SAVE_AS_DRAFT_REQ";
	final static String	CANCEL_REQ															= "CANCEL_REQ";
	final static String	SUBMIT_REQ_FOR_APPROVAL												= "SUBMIT_REQ_FOR_APPROVAL";

	// my favorite page
	final static String	SEARCH_FAVORITE_BY_ITEM_NO											= "Item No";
	final static String	SEARCH_FAVORITE_BY_ITEM_NAME										= "Item Name";
	final static String	SEARCH_FAVORITE_BY_SUPPLIER_NAME									= "Supplier Name";
	final static String	ADD_ITEM_TO_PO_FIELD												= "searchFor";
	String				Relevance_SortBy_Option												= "Relevance";
	String				Price_Low_To_High_SortBy_Option										= "Price: Low to High";
	String				Price_High_To_Low_SortBy_Option										= "Price: High to Low";
	String				Rating_SortBy_Option												= "Rating";

	// my basket page
	final static String	SEARCH_BY_BASKET_NAME												= "Basket Name";
	final static String	ADD_BASKET_TO_CART													= "Add Basket to Cart";
	final static String	DELETE_BASKET														= "Delete";
	final static String	SHARE_BASKET														= "Share";
	final static String	UNSHARE_BASKET														= "Unshare";
	final static String	SHARING_SCOPE														= "Sharing Scope";
	final static String	UPDATE_SHARING_SCOPE												= "Update Sharing Scope";
	final static String	PURCHASING_SCOPE													= "Purchasing Scope";
	final static String	COMPANY_SCOPE														= "Company";
	final static String	BUSINESS_UNIT_SCOPE													= "Business Unit";
	final static String	LOCATION_SCOPE														= "Location";
	final static String	DEPARTMENT_SCOPE													= "Department";
	final static String	ORGANIZATION_UNITS_SCOPE											= "Organization Units";
	final static String	DEPARTMENT_CODE														= "Department Code";
	final static String	COMPANY_CODE														= "Company Code";
	final static String	DEPT_CODE															= "Dept Code";
	final static String	COMP_CODE															= "Comp Code";

	// date property key
	final static String	REC_CHANGE_COMM														= PropertyReader.dataProperty.getProperty("REC_CHANGE_COMM");
	final static String	DELIVER_TO_FIELD													= "deliverTo";
	final static String	DUPLICATE_PO_NO_ERROR_MSG											= PropertyReader.messageProperty.getProperty("AllreadyexitPoNoerrormsg");
	final static String	DUPLICATE_PO_NO														= PropertyReader.dataProperty.getProperty("Alreadyexitpono");
	final static String	MODAL_ACCOUNTIN_ERROR_MSG											= PropertyReader.messageProperty.getProperty("ModalAccountingErrorMsg");
	final static String	MODAL_WINDOW_TITLE_TEXT												= PropertyReader.messageProperty.getProperty("modalwindowtitletext");
	final static String	ITEM_UOM_FILL														= "fill_item_UOM";
	final static String	ALERT_ADD_ITEM_IN_PO_TO_CONTINUE									= PropertyReader.messageProperty.getProperty("AddItemToContinue");
	final static String	INVALID_CHECKOUT_BUYER												= PropertyReader.messageProperty.getProperty("InvalidCheckoutBuyer");
	final static String	REMIND_SUPPLIER_TITLE												= PropertyReader.dataProperty.getProperty("modalremindsuppliertitletext");
	final static String	ACCOUNTING_INFO_ON_QTIP												= PropertyReader.messageProperty.getProperty("AccountingInfoOnQtip");
	String				Delivery_Date_Required_Error										= PropertyReader.messageProperty.getProperty("Delivery_Date_Required_Error");
	String				Mismatch_In_Settlement_via_Error_Msg								= PropertyReader.messageProperty.getProperty("Mismatch_In_Settlement_via_Error_Msg");
	String				Mismatch_In_Settlement_via_Error_Msg2								= PropertyReader.messageProperty.getProperty("Mismatch_In_Settlement_via_Error_Msg2");
	String				ErrorMsg_AssetNoRequired											= PropertyReader.messageProperty.getProperty("ErrorMsg_AssetNoRequired");
	String				ErrorMsg_AssetNoMissing												= PropertyReader.messageProperty.getProperty("ErrorMsg_AssetNoMissing");
	final static String	ERROR_MSG_DUPLICATE_ITEM_MASTER										= PropertyReader.messageProperty.getProperty("ErrorMsg_Duplicate_Catalog_Name");
	final static String	ADDQUANTITY_AMOUNT													= "Quantity";
	String				ErrorMsg_BudgetLineAlertMessage										= PropertyReader.messageProperty.getProperty("ErrorMsg_BudgetLineAlertMessage");

	// po listing
	final static String	SEARCH_BY_PO_NO														= "SEARCH_BY_PO_NO";
	final static String	SEARCH_BY_ITEM_NAME													= "SEARCH_BY_ITEM_NAME";
	final static String	SEARCH_BY_SUPPLIER													= "SEARCH_BY_SUPPLIER";
	final static String	SEARCH_BY_BUYER														= "SEARCH_BY_BUYER";
	final static String	SEARCH_BY_ORDER_DESCRIPTION											= "SEARCH_BY_ORDER_DESCRIPTION";
	// email po
	final static String	EMAIL_PO_MESSAGE													= "Auto generated PO Message";

	// close PO
	final static String	CLOSE_PO_COMMENT													= "Auto Generated Comment for Closing PO";

	// cancel PO
	final static String	CANCEL_PO_COMMENT													= "Auto Generated Comment for Cancelling PO";

	// invoice
	final static String	SUBMIT_INVOICE														= "SUBMIT_INVOICE";
	final static String	SAVE_AS_DRAFT_INVOICE												= "SAVE_AS_DRAFT_INVOICE";
	final static String	CANCEL_EDITING_INVOICE												= "CANCEL_EDITING_INVOICE";
	final static String	INVOICE_CLOSE_COMMENT												= "Auto Generated Comment for Closing Invoice";
	final static String	INVOICE_VOID_COMMENT												= "Auto Generated Comment for Void Invoice";
	final static String	INVOICE_RETURN_COMMENT												= "Auto Generated Comment for Returning Invoice";
	final static String	INVOICE_RECALL_APPROVAL_REQUEST_COMMENT								= "Auto Generated Comment for Recalling Approval Invoice";

	// invoice filter
	final static String	SUBMITTED_FILTER_LABEL												= "Submitted";
	final static String	RETURNED_FLITER_LABEL												= "Returned";

	// select field value
	final static String	SELECT_OPTION_DEFAULT_VALUE											= "--Select--";

	// create catalog
	final static String	CATALOG_UPLOAD_ATTACHMENT											= ConfigProperty.getConfig("catalogUploadAttachment");
	final static String	ITEM_FILE_OTHERTHAN_XLS												= ConfigProperty.getConfig("file_other_than_xls_format");
	final static String	FREE_TEXT_ITEM_ATTACHMENT											= ConfigProperty.getConfig("free_text_item_Attachment");
	final static String	ITEM_WITHOUT_HEADER													= ConfigProperty.getConfig("item_without_header");
	final static String	ITEM_ATTACHMENT_VALIDATION											= ConfigProperty.getConfig("item_missing_character");
	final static String	ITEM_ATTACHMENT_ODD_VALIDATION										= ConfigProperty.getConfig("item_upload_xl_missing_validation");
	final static String	ITEM_FILE_WITH_DISTURBED_STRUCTURE									= ConfigProperty.getConfig("file_with_disturbed_structure");
	final static String	ITEM_FILE_WITH_MAXCHAR												= ConfigProperty.getConfig("item_with_maxchar");
	final static String	ITEM_WITH_DUPLICATE_LINE_NO											= ConfigProperty.getConfig("item_with_duplicate_lineNo");
	final static String	ITEM_WITH_SPECIAL_CHARS												= ConfigProperty.getConfig("item_with_special_char");
	final static String	ITEM_WITH_DATA_VALIDATION											= ConfigProperty.getConfig("item_with_data_validation");
	final static String	ITEM_WITH_DATA_VALIDATION_FOR_ERROR_CHECK							= ConfigProperty.getConfig("item_with_data_validation_for_error_check");
	final static String	ITEM_FOR_AMEND_PO_ITEM_ERROR_CHECK									= ConfigProperty.getConfig("item_for_amend_po_item_error_check");
	final static String	ITEMS_WITH_BLANK_LINE_NO											= ConfigProperty.getConfig("items_with_blank_line_no");
	final static String	ITEM_WITH_INVALID_URLS												= ConfigProperty.getConfig("items_with_invalid_urls");

	final static String	FILE_WITH_MULTIPLE_ITEMS											= ConfigProperty.getConfig("File_with_multiple_item");
	final static String	FILE_WITH_25_ITEMS													= ConfigProperty.getConfig("File_with_25_item");
	final static String	FILE_FOR_COST_CENTER_UPLOAD											= IConstants.ATTACHMENT_FILES_PATH
		+ ConfigProperty.getConfig("upload_cost_center_file");

	String				FILE_ITEM_MASTER_TEMPLATE											= ConfigProperty.getConfig("item_master_template_nonStock");
	String				FILE_ITEM_MASTER_CSV												= ConfigProperty.getConfig("item_master_template_stock");

	final static String	NEXT																= "NEXT";
	final static String	SUBMIT_CATALOG														= "SUBMIT_CATALOG";
	final static String	DISCARD_CATALOG														= "DISCARD_CATALOG";
	final static String	CLOSE_CATALOG														= "CLOSE_CATALOG";

	String				Inventory_Item_Master_Type											= "Inventory";
	String				NonInventory_Item_Master_Type										= "NonInventory";

	String				Search_By_ERP_Part_No												= "ERP Part No";
	String				Search_By_Manufacturer_Part_No										= "Manufacturer Part Id";
	String				Search_By_Item_Master_Item_Name										= "Item Name";
	String				Search_By_Category													= "Category";
	String				Search_By_Supplier													= "Supplier";

	// add item to catalog
	final static String	ADD_ITEM_TO_CATALOG													= "ADD_ITEM_TO_CATALOG";
	final static String	ADD_ITEM_TO_CATALOG_AND_CONTINUE									= "ADD_ITEM_TO_CATALOG_AND_CONTINUE";
	final static String	CANCEL_ADD_ITEM_TO_CATALOG											= "CANCEL_ADD_ITEM_TO_CATALOG";

	// receipt
	final static String	CANCEL_RECEIPT_COMMENT												= "Auto generated comment for cancelling receipt";
	final static String	CONFIRMED_STATUS													= "Confirmed";
	final static String	RETURNED_STATUS														= "Returned";

	// ceform
	final static String	PUBLISH_EFORM														= "PUBLISH_EFORM";
	final static String	SAVE_AS_DRAFT_EFORM													= "SAVE_AS_DRAFT_EFORM";
	final static String	PREVIEW_EFORM														= "PREVIEW_EFORM";
	final static String	SAVE_AND_CONTINUE_EFORM												= "SAVE_AND_CONTINUE_EFORM";
	final static String	eFormCategory1														= "eFormCategory1";
	final static String	eFormCategory2														= "eFormCategory2";
	final static String	eFormCategory3														= "eFormCategory3";

	// QTS
	final static String	IMPORT_PEFORM														= "Import";

	// peform
	final static String	REQUISITION_FORMS													= "Requisition Forms";
	final static String	PO_FORMS															= "PO Forms";
	final static String	FIELD_VALUE															= "Auto Generated Field Value";
	final static String	ACTIVE_STATUS														= "Active";
	final static String	INACTIVE_STATUS														= "Inactive";

	// requisition comments
	static String		REASON_FOR_ORDERING													= "This is auto generated reason for ordering";

	// catalog status
	static String		DEACTIVATED_CATALOG_LABEL											= "Deactivated";
	static String		PUBLISHED_CATALOG_LABEL												= "Published";

	// select by type
	static String		SELECT_BY_VALUE														= "SELECT_BY_VALUE";
	static String		SELECT_BY_INDEX														= "SELECT_BY_INDEX";
	static String		SELECT_BY_VISIBLE_TEXT												= "SELECT_BY_VISIBLE_TEXT";
	static String		SELECT_BY_PARTIAL_VISIBLE_TEXT										= "SELECT_BY_PARTIAL_VISIBLE_TEXT";

	static String		Uploaded															= "Uploaded";
	static String		Label_Value_Of_Attachment											= "1 attachment";

	// cc_budget_project map keys
	static String		costCenter															= "costCenter";
	static String		budget																= "budget";
	static String		project																= "project";

	// item level discount types
	static String		PERCENTAGE															= "Percentage";
	static String		AMOUNT																= "Amount";
	static String		PER_ITEM															= "per item";

	// customize-->purchase order setting-->release PO
	static String		AFTER_EVERY_DAY														= "after every days";
	static String		DATES_OF_THE_MONTH													= "dates of the month";
	static String		DAYS_OF_THE_WEEK													= "days of the week";

	// customize -->workflow settings
	static String		BLOCK																= "Block";
	static String		DISPLAY_WARNING														= "Display warning";

	// master data settings -->Asset code options
	static String		ASSET_CODE_OPTION													= "Assets Code";

	// common keys
	static String		SUBMIT																= "SUBMIT";

	// document type
	static String		REQUISITION															= "Requisition";
	static String		PURCHASE_ORDER														= "Purchase Order";
	static String		BPO																	= "BPO";
	static String		INVOICE																= "INVOICE";
	static String		CATALOG																= "CATALOG";

	// document search type
	static String		DOC_NO																= "DOC_NO";
	static String		DOC_NAME															= "DOC_NAME";
	static String		INITIATOR_NAME														= "INITIATOR_NAME";

	// split type
	static String		CC_SPLIT_AT_HEADER_LEVEL											= "CC_SPLIT_AT_HEADER_LEVEL";
	static String		CC_SPLIT_AT_ITEM_LEVEL												= "CC_SPLIT_AT_ITEM_LEVEL";

	// budget period action
	static String		ADD																	= "ADD";
	static String		CLOSE																= "CLOSE";

	// budget dimensions
	static String		BUDGET_DIMENSION_BUSINESS_UNIT										= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_BUSINESS_UNIT");
	static String		BUDGET_DIMENSION_LOCATION											= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_LOCATION");
	static String		BUDGET_DIMENSION_COST_CENTER										= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_COST_CENTER");
	static String		BUDGET_DIMENSION_DEPARTMENT											= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_DEPARTMENT");
	static String		BUDGET_DIMENSION_DESIGNATION										= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_DESIGNATION");
	static String		BUDGET_DIMENSION_PROJECT											= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_PROJECT");
	static String		BUDGET_DIMENSION_GENERAL_LEDGER										= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_GENERAL_LEDGER");
	static String		BUDGET_DIMENSION_CATEGORY											= PropertyReader.dataProperty.getProperty("BUDGET_DIMENSION_CATEGORY");
	static String		DESIGNATION															= "Designation";
	// budget next actions
	static String		SAVE_AND_FREEZE_BUDGET												= "SAVE_AND_FREEZE_BUDGET";
	static String		SAVE_AS_DRAFT														= "SAVE_AS_DRAFT";

	// buget search by
	static String		SEARCH_BUDGET_BY_BUDGET_NAME										= "SEARCH_BUDGET_BY_BUDGET_NAME";
	static String		SEARCH_BUDGET_BY_COMPANY											= "SEARCH_BUDGET_BY_COMPANY";
	static String		SEARCH_BUDGET_BY_OWNER												= "SEARCH_BUDGET_BY_OWNER";
	static String		SEARCH_BUDGET_LINE_BY_BU											= "SEARCH_BUDGET_LINE_BY_BU";

	// status
	static String		DEACTIVATED															= "Deactivated";
	static String		IN_USE																= "In use";

	// PO Types
	final static String	BLANKET_PO_TYPE														= "Blanket";
	final static String	STANDARD_PO_TYPE													= "Standard";
	final static String	RELEASE_PO_TYPE														= "Release";
	final static String	ANY																	= "ANY";

	// GL Map selection option
	final static String	CATEGORY_gl_map_option												= "Category";
	final static String	PT_gl_map_option													= "Purchase Type";
	final static String	CC_gl_map_option													= "Cost Center";
	final static String	AMOUNT_LESS_THAN_gl_map_option										= "Amount less than";
	final static String	AMOUNT_GREATER_THAN_gl_map_option									= "Amount greater than";
	final static String	GL_ACCOUNT_TYPE_gl_map_option										= "GL Account Type";
	final static String	GL_ACCOUNT_NAME_gl_map_option										= "GL Account";
	final static String	GL_ACCOUNT_CODE														= "GL_ACCOUNT_CODE";

	// Tax selection option
	final static String	NAME_tax_option														= "Name";
	final static String	TYPE_tax_option														= "Type";
	final static String	COUNTRY_tax_option													= "Country";
	final static String	STATE_tax_option													= "State";
	final static String	CITY_tax_option														= "City";
	final static String	COUNTY_tax_option													= "County";
	final static String	APPLICABLE_tax_option												= "Applicable";

	// Supplier Code Map Options
	final static String	TYPE_OF_MAP_supplier_code_map_option								= "Type of Map";
	final static String	SUPPLIER_ID_supplier_code_map_option								= "Supplier Id";
	final static String	SUPPLIER_NAME_supplier_code_map_option								= "Supplier Name";
	final static String	SUPPLIER_SIDE_CODE_supplier_code_map_option							= "Supplier Side Code";
	final static String	SUPPLIER_SIDE_DESCRIPTION_supplier_code_map_option					= "Supplier Side Description";
	final static String	SYSTEM_CODE_supplier_code_map_option								= "System Code";
	final static String	APPLICABLE_FOR_supplier_code_map_option								= "Applicable for";
	final static String	UOM_supplier_code_map_option										= "UOM";
	final static String	CATEGORY_supplier_code_map_option									= "Category";
	final static String	CURRENCY_supplier_code_map_option									= "Currency";

	// PCard Values
	final static String	PCARD_TYPE_MASTER_CARD												= "MasterCard";
	final static String	PCARD_TYPE_VISA														= "Visa";
	final static String	PCARD_TYPE_AMEX														= "Amex";

	final static String	STATEMENT_FREQUENCY_MONTHLY											= "MONTHLY";
	final static String	STATEMENT_FREQUENCY_BI_MONTHLY										= "BI_MONTHLY";
	final static String	STATEMENT_FREQUENCY_QUARTELY										= "QUARTERLY";

	final static String	ACTIVATE_PCARD														= "ACTIVATE_PCARD";

	final static String	ISSUED_TO_USER														= "ISSUED_TO_USER";
	final static String	ISSUED_TO_SUPPLIER													= "ISSUED_TO_SUPPLIER";

	final static String	EXPIRED																= "Expired";
	final static String	LOST																= "Lost";
	final static String	DISPUTED															= "Disputed";
	final static String	TEMPORARY_BLOCKED													= "Temporarily Blocked";
	final static String	OTHERS																= "Others";

	final static String	DEACTIVATE_COMMENT_FOR_PCARD										= "Auto generated comment for deactivating PCard";
	final static String	ARCHIVE_COMMENT_FOR_PCARD											= "Auto generated comment for archiving PCard";

	// report data
	final static String	SEARCH_REPORT_BY_ALL												= "All";
	final static String	SEARCH_REPORT_BY_PRE_PACKAGED_REPORTS								= "Pre-Packaged Reports";
	final static String	SEARCH_REPORT_BY_SHARED_REPORTS										= "Shared Reports";

	final static String	TABULAR_REPORT_TYPE													= "TABULAR_REPORT_TYPE";
	final static String	SUMMARY_REPORT_TYPE													= "TABULAR_REPORT_TYPE";
	final static String	MATRIX_REPORT_TYPE													= "TABULAR_REPORT_TYPE";

	final static String	FILTER_ON_PO_DELIVERY_DATE											= "PO.DELIVER_ON";
	final static String	FILTER_ON_PO_SUBMITTED_ON											= "PO.SUBMITTED_ON";
	final static String	FILTER_ON_PO_APPROVED_ON											= "PO.APPROVED_ON";
	final static String	FILTER_ON_PO_RELEASED_ON											= "PO.RELEASED_ON";
	final static String	FILTER_ON_PO_CLOSED_ON												= "PO.CLOSED_ON";
	final static String	FILTER_ON_PO_ESTIMATED_DELIVERY_ON									= "PO.ESTIMATED_DELIVER_ON";
	final static String	FILTER_ON_PO_VALIDITY_START_DATE									= "PO.VALIDITY_FROM";
	final static String	FILTER_ON_PO_VALIDITY_END_DATE										= "PO.VALIDITY_TO";
	final static String	FILTER_ON_PO_INVIOCE_UNTIL_DATE										= "PO.INVOICE_UNTILDATE";
	final static String	FILTER_ON_PO_ITEM_DELIVERY_DATE										= "POITEM.DELIVERY_ON";

	final static String	FILTER_PERIOD_CUSTOM												= "custom";
	final static String	CHART_TYPE_PIE_CHART_2D												= "PIE_CHART_2D";

	final static String	RUN_REPORT															= "RUN_REPORT";
	final static String	BACK_REPORT															= "BACK_REPORT";
	final static String	CANCEL_REPORT														= "CANCEL_REPORT";

	final static String	NoReportsFoundMessage												= PropertyReader.messageProperty.getProperty("NoReportsFoundMessage");
	final static String	NotSharedWithAnyUser												= PropertyReader.messageProperty.getProperty("NotSharedWithAnyUser");

	final static String	AUDIT_TRAIL_ACTION_READY_FOR_APPROVAL								= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_ACTION_READY_FOR_APPROVAL");

	final static String	AUDIT_TRAIL_ACTION_MODIFIED_WORKFLOW								= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_ACTION_MODIFIED_WORKFLOW");

	final static String	AUDIT_TRAIL_ACTION_ROLE												= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_ACTION_ROLE");

	final static String	AUDIT_TRAIL_ACTION_MESSAGE											= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_ACTION_MESSAGE");

	final static String	SUBMITTING_REQS_ON_FORKING_SCREEN_ALERT_MESSAGE						= PropertyReader.messageProperty.getProperty("AlertMessageForSubmittingForkedReqs");

	// invite suppliers
	final static String	SUPPLIER_SEARCH_BY_NAME												= "name";
	final static String	SUPPLIER_SEARCH_BY_CATEGORY_NAME									= "categoryName";
	final static String	SEND_INVITATION														= "SEND_INVITATION";
	final static String	BACK_SUPPLIER_INVITE												= "BACK_SUPPLIER_INVITE";
	final static String	CANCEL_SUPPLIER_INVITE												= "CANCEL_SUPPLIER_INVITE";

	// punchout next action
	final static String	ADD_TO_CART_AND_CHECKOUT											= "ADD_TO_CART_AND_CHECKOUT";
	final static String	ADD_TO_CART_AND_CONTINUE_SHOPPING									= "ADD_TO_CART_AND_CONTINUE_SHOPPING";
	final static String	DISCARD_ALL_ITEMS													= "DISCARD_ALL_ITEMS";

	// add approver node after
	final static String	Requester															= "Requester";
	final static String	Requisiter															= "Requisiter";
	final static String	Approver															= "Approver";

	// ready for approval events
	final static String	Requisition_Ready_For_Approval										= "Requisition ready for approval";
	final static String	Added_Approver_In_Ready_For_Approval_Requisition					= "Added_Approver_In_Ready_For_Approval_Requisition";
	final static String	Removed_Approver_From_Ready_For_Approval_Requisition				= "Removed_Approver_From_Ready_For_Approval_Requisition";

	final static String	Label_Change_Buyer													= "Change buyer";
	final static String	Label_Change_Buyer_Multiple											= "Multiple";

	// messaging properties
	String				Release_No_Error													= "Release_No_Error";
	String				AlreadyExisting_ReleaseNo_ErrorMsg									= "AlreadyExisting_ReleaseNo_ErrorMsg";
	String				Already_Amended_By_Another_Buyer_ErrorMsg							= PropertyReader.messageProperty
		.getProperty("Already_Amended_By_Another_Buyer_ErrorMsg");
	String				BPO_Amended_Successfully_Msg										= "BPO_Amended_Successfully_Msg";

	// data properties
	String				AUDIT_TRAIL_ACTION_AMENDMENT_CONFIRMED								= "AUDIT_TRAIL_ACTION_AMENDMENT_CONFIRMED";

	// entity ownership
	String				search_entity_in_status												= "Status";
	String				search_entity_in_req_number											= "Requisition Number";
	String				search_entity_in_name												= "Name";

	// comment
	String				search_entity_comment												= "Auto Generated Comment for Entity Selection";

	// AUDIT TRAIL
	String				AUDIT_TRAIL_REQ_OWNERSHIP_CHANGED									= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_REQ_OWNERSHIP_CHANGED");
	String				AUDIT_TRAIL_REQ_ORDERED												= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_REQ_ORDERED");

	String				AUDIT_TRAIL_REQ_APPROVED											= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_REQ_APPROVED");
	String				AUDIT_TRAIL_REQ_WAITING_ON_BUYERS_DESK								= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_REQ_WAITING_ON_BUYERS_DESK");

	String				CostCenter_Bu_not_linked_Validation_Error_Msg1						= PropertyReader.messageProperty
		.getProperty("CostCenter_Bu_not_linked_Validation_Error_Msg1");
	String				CostCenter_Bu_not_linked_Validation_Error_Msg2						= PropertyReader.messageProperty
		.getProperty("CostCenter_Bu_not_linked_Validation_Error_Msg2");
	String				Project_Bu_not_linked_Validation_Error_Msg1							= PropertyReader.messageProperty
		.getProperty("Project_Bu_not_linked_Validation_Error_Msg1");
	String				AUDIT_TRAIL_ACTION_ASSIGNED_BUYER									= PropertyReader.dataProperty.getProperty("AUDIT_TRAIL_ACTION_ASSIGNED_BUYER");
	String				ErrorMsg_ForMandatorySupplierDetails								= PropertyReader.messageProperty.getProperty("ErrorMsg_ForMandatorySupplierDetails");

	// add item from req - search options
	String				Search_By_Req_No													= "Search_By_Req_No";
	String				Search_By_Item_Name													= "Search_By_Item_Name";
	String				Search_By_Requester													= "Search_By_Requester";
	String				Search_By_Supplier_Name												= "Search_By_Supplier_Name";

	// select keyword for supplier action
	String				Select																= "Select";
	String				Type_SuggestSuppliersTableHeader									= "Type";
	String				Name_SuggestSuppliersTableHeader									= "Name";
	String				Address_SuggestSuppliersTableHeader									= "Address";
	String				View_Contracts_SuggestSuppliersTableHeader							= "View Contracts";
	String				Actions_SuggestSuppliersTableHeader									= "Actions";

	String				ErrorMsg_ForDeactivatedSourcingStatus								= PropertyReader.messageProperty.getProperty("ErrorMsg_ForDeactivatedSourcingStatus");
	String				ErrorMsg_InvalidQuantity											= PropertyReader.messageProperty.getProperty("ErrorMsg_InvalidQuantity");

	String				ErrorMsg_BudgetExhausted											= PropertyReader.messageProperty.getProperty("ErrorMsg_BudgetExhausted");

	String				CreateEvent															= "Create Event";

	// TMS payment terms select options
	String				CODE_TMS															= "Code";
	String				PAYMENT_TERM_TMS													= "Payment Term";
	String				CREDIT_DAYS_TMS														= "Credit Days";
	String				DAYS_TO_AVAIL_DISCOUNT_TMS											= "Days to avail discount";
	String				PERCENT_DISCOUNT_TMS												= "% Discount";
	String				ERP_ID_TMS															= "ERP ID";
	String				STATUS_TMS															= "Status";

	// TMS project select options //USE CODE_TMS AND IN_USE FOR OTHER OPTIONS
	String				PROJECT_TASK_NUMBER													= "Project/Task No.";
	String				PROJECT_TASK_NAME													= "Project/Task Name";

	// TMS company select options //USE CODE_TMS FOR OTHER OPTIONS
	String				COMPANY																= "Company";
	String				PARENT_LEVEL														= "Parent Level";
	String				ERP_ID																= "ERP ID";
	String				STATUS																= "Status";

	// TMS business unit select options //USE CODE_TMS,PARENT_LEVEL,ERP_ID AND
	// STATUS FOR OTHER OPTIONS
	String				BUSINESS_UNIT														= "Business Units";
	String				BUSINESS_UNIT_TEXT													= "Business Unit";
	String				DRAFT																= "Draft";
	// TMS cost center select options //USE CODE_TMS and STATUS_TMS FOR OTHER
	// OPTIONS
	String				NAME																= "Name";
	String				COST_CENTER_CODE													= "Cost Center Code";
	String				COST_CENTER_OWNER													= "Cost Center Owners";

	// TMS locations select options //USE CODE_TMS, NAME, ERP_ID and STATUS_TMS
	// FOR OTHER OPTIONS
	String				REGION																= "Region";
	String				BILL_TO_ADDRESS														= "Bill-to address";
	String				INVOICE_DELIVERY_ADDRESS											= "Invoice delivery address";
	String				SHIP_TO_ADDRESS														= "Ship-to address";

	// tax type
	String				applyTax_UpdateAllLines												= "applyTax_UpdateAllLines";
	String				removeAllTaxes_UpdateAllLines										= "removeAllTaxes_UpdateAllLines";
	String				close_UpdateAllLines												= "close_UpdateAllLines";

	// add approver values
	String				Add_Approver_After_PO_Creator										= "PO Creator";
	String				Add_Approver_After_Reporting_Manager								= "Reporting Manager";

	// visibility of files
	String				internal_file_visibility											= "Internal";
	String				supplier_file_visibility											= "Supplier";

	// email po details
	String				EMAIL_PO_TO															= "EMAIL_PO_TO";
	String				EMAIL_MESSAGE														= "EMAIL_MESSAGE";
	String				EMAIL_PO_ATTACHMENT_NAME											= "EMAIL_PO_ATTACHMENT_NAME";

	// isource data
	String				next_action_after_creating_sourcing_event_OK						= "OK";
	String				next_action_after_creating_sourcing_event_GO_TO_ISource				= "Go To ISource";
	String				Event_Type_RFQ														= "RFQ";
	String				Event_Type_AUCTION													= "AUCTION";

	String				ErrorMsg_SourcingEvent_For_Catalog_Item								= PropertyReader.messageProperty.getProperty("ErrorMsg_SourcingEvent_For_Catalog_Item");
	String				ErrorMsg_SourcingEvent_For_Item_With_Different_Currency				= PropertyReader.messageProperty
		.getProperty("ErrorMsg_SourcingEvent_For_Item_With_Different_Currency");
	String				ErrorMsg_SourcingEvent_For_Decimal_Value_In_Quantity				= PropertyReader.messageProperty
		.getProperty("ErrorMsg_SourcingEvent_For_Decimal_Value_In_Quantity");
	String				ErrorMsg_ReqAlreadyModifiedByOtherUser								= PropertyReader.messageProperty.getProperty("ErrorMsg_ReqAlreadyModifiedByOtherUser");
	// bpo settings
	String				BPO_AUTH_TYPE_RELEASE_ORDER											= "BPO_AUTH_TYPE_RELEASE_ORDER";
	String				BPO_AUTH_TYPE_DIRECT_INVOINCING										= "BPO_AUTH_TYPE_DIRECT_INVOINCING";
	String				BPO_AUTH_TYPE_LET_USER_DECIDE										= "BPO_AUTH_TYPE_LET_USER_DECIDE";

	// TestData Keys
	final static String	ITEM_NAME_FOR_SEARCHING												= "ITEM_NAME_FOR_SEARCHING";
	final static String	OTHER_ITEM_NAME_FOR_SEARCHING										= "OTHER_ITEM_NAME_FOR_SEARCHING";
	final static String	ITEM_NAME_FOR_CREATING_NEW_CATALOG									= "CatalogItem";
	final static String	SEARCH																= "searchFor";
	final static String	ITEM_WITH_DIFFERENT_CURRENCY										= "itemWithDiffrentCurrency";
	final static String	SHORT_DESC_FOR_GUIDED_ITEM											= "shortDescForFreeTextItem";
	final static String	PART_NO_FOR_GUIDED_ITEM												= "partNoForGuidedItem";
	final static String	ITEM_TYPE_OPTION													= "itemTypeOption";
	final static String	RECEIVE_BY_OPTION													= "receiveByOption";
	final static String	SOURCING_STATUS_OPTION												= "sourcingStatusOption";
	final static String	SUPPLIER_NAME														= "supplierName";
	final static String	SUPPLIER_ERP_ID														= "supplierERPId";
	final static String	GL_Type																= "GL_Type";
	final static String	GL_ACCOUNT															= "GL_Account";
	final static String	SET_PURCHASE_TYPE													= "set-PurchaseType";
	final static String	COST_CENTER															= "Cost Center";
	final static String	ON_BEHALF_OF														= "onBehalfOfScope,onBehalfOFWithRightUser,WrongUser";
	final static String	CC_PROJECT_BUDGET													= "CC,PROJECT,BUDGET";
	final static String	CONTRACT_NO															= "contractNo";
	final static String	PURCHASE_TYPE														= "purchaseType";
	final static String	PURCHASE_TYPE_2														= "purchaseType2";
	final static String	BUYER_NAME															= "BUYER_NAME";
	final static String	ORDER_DESCRIPTION													= "orderDescription";
	final static String	PO_NUMBER															= "poNumber";
	final static String	LEVEL_TO_USE_PO_NUMBER_FORMAT_COMPANY								= "CompanylevelToUsePoNoFormat";
	final static String	LEVEL_TO_USE_PO_NUMBER_FORMAT_BU									= "BUlevelToUsePoNoFormat";
	final static String	LEVEL_TO_USE_PO_NUMBER_FORMAT_LOCATION								= "LocationlevelToUsePoNoFormat";
	final static String	LEVEL_TO_USE_PO_NUMBER_FORMAT_TENANT								= "TenantlevelToUsePoNoFormat";
	final static String	CATALOG_ITEM_WITH_LARGE_PARAMETRICDATA								= "catalogItemWithLargeParametricData";
	final static String	OTHER_PURCHASE_TYPE													= "other_purchaseType";
	final static String	DELIVERY_NAME														= "DELIVERY_NAME";

	final static String	DELIVERY_NAME2														= "Auto";
	final static String	DeliveryAddress_OtherAddress										= "otherAddress";
	final static String	DeliveryAddress_MyAddress											= "myAddress";

	final static String	TASK_NAME															= "Task Name";
	final static String	FILLPROJECTFIELD_WITHOUTMANAGERFIELD								= "Project Without Manager";
	final static String	FILL_PROJECT_NAME													= "Project Name";
	final static String	SUPPLIER_ADDRESS													= "supplierAddress";
	final static String	PAYMENT_TERMS														= "paymentTerms";
	final static String	PAYMENT_TERMS_OTHER_SUPPLIER										= "paymentTerms other than supplier";
	final static String	CURRENCY_TYPE														= "currencyType";
	final static String	CURRENCY_VALUE														= "currencyValue";
	final static String	DELIVERY_TERMS														= "deliveryTerms";
	final static String	BASKET_NAME															= "basketName";
	final static String	FREE_TEXT_CATEGORY													= "freeTextCategory";
	final static String	SUBMIT_PO_FOR_PROCESSING											= "SUBMIT_PO_FOR_PROCESSING";
	final static String	SAVE_PO_AS_DRAFT													= "SAVE_PO_AS_DRAFT";
	final static String	MAX_CHARACTER_ITEMNAME												= "Max Char Item Name";
	final static String	SPECIAL_CHARACTER_ITEMNAME											= "Special Char Item Name";
	final static String	MULTILINGUAL_CHARACTER_ITEMNAME										= "Multilingual Char Item Name";

	final static String	Script_char_item_name												= "Script_char_item_name";

	final static String	TYPE_HEAD_LIST_SUPPLIER_CONTACTS									= "$NAME$ <$EMAIL$>";

	final static String	DIFFERENT_LOCATION													= "differentLocation";
	final static String	OTHER_SUPPLIER_NAME													= "OTHER_SUPPLIER_NAME";
	final static String	SUPPLIER_WITH_DIFF_CURRENCY											= "SUPPLIER_WITH_DIFF_CURRENCY";
	final static String	TAX_NAME															= "taxName";
	final static String	TAX_NAME_SPECIAL_CHARACTERS											= "taxNameSpecialCharacters";
	final static String	TAX_NAME_MULTILINGUAL_CHAR											= "taxNameMultilingualCharacters";
	final static String	TAX_TYPE															= "taxType";
	final static String	SALES_TAX															= "SALES_TAX";
	final static String	DIFF_TAX_TYPE														= "DIFF_TAX_TYPE";
	final static String	TAX_RATE															= "taxRate";
	final static String	TAX_NAME_SECOND														= "SecondTaxName";
	final static String	FREE_TEXT_CITY														= "freeTextCity";
	final static String	MULTILINGUAL_CHAR													= "Multilingual Char Item Name";
	final static String	SPECIAL_CHAR														= "Special Char Item Name";
	final static String	MAX_CHAR															= "maxCharItemName";
	final static String	INTERNAL_COMMENTS_PO												= "internalComments";
	final static String	COMMENTS_FOR_SUPPLIER_PO											= "commentsForSupplier";
	final static String	OTHER_ADDRESS														= "OtherDelivery Add";
	final static String	CHANGED_CURRENCY													= "changedCurrency";
	final static String	TO_FIELD_VALUE_FOR_SENDING_PO_EMAIL									= "TO_FIELD_VALUE_FOR_SENDING_PO_EMAIL";
	final static String	TO_FIELD_VALUE_FOR_VALIDATING_PO_EMAIL								= "TO_FIELD_VALUE_FOR_VALIDATING_PO_EMAIL";
	final static String	DELIVERS_TO_OR_OWNER												= "Deliveres To/Owner";
	final static String	Other_Company_Name													= "Other_Company_Name";
	final static String	Other_BusinessUnit													= "Other_BusinessUnit";
	final static String	Other_BusinessUnit1													= "Other_BusinessUnit1";
	final static String	Other_Location														= "Other_Location";
	final static String	Other_Location2														= "Other_Location2";

	String				BusinessUnit_Name1													= "BusinessUnit_Name1";
	String				Catalog_Item_with_Diff_Unit_AND_Market_Price						= "Catalog_Item_with_Diff_Unit_AND_Market_Price";

	final static String	INVOICE_QUANTITY													= "invoicequantity";
	final static String	AUTO_GENERATED_PONO_FORMAT											= "Auto generated poNo Format";
	final static String	PO_NO_FORMAT_AS_PER_SETTING											= "PO_NO_FORMAT_SETTING";

	final static String	PO_MY_ADDRESS														= "PO_MY_ADDRESS";
	final static String	PO_OTHER_ADDRESS													= "PO_OTHER_ADDRESS";
	final static String	PO_SUPPLIER_CONTACT													= "PO_SUPPLIER_CONTACT";
	final static String	ITEM_IMAGE_URL														= "ITEM_IMAGE_URL";
	final static String	ITEM_INVALID_IMAGE_URL												= "ITEM_INVALID_IMAGE_URL";
	String				Display_Name_For_Pre_Defined_Fields									= "Display_Name_For_Pre_Defined_Fields";

	final static String	CATALOG_NAME														= "Catalog_Name";

	final static String	BU_NAME_FOR_CEFORM													= "BusinessUnitNameForCategoryEform";
	final static String	NEW_SUPPLIER_NAME													= "newSupplierName";
	final static String	NEW_SUPPLIER_LOCATION												= "supplierLocation";
	final static String	NEW_SUPPLIER_CONTACT_PERSON											= "supplier_ContactPerson";
	final static String	NEW_SUPPLIER_EMAIL_ID												= "supplier_Email";
	final static String	NEW_SUPPLIER_PHONE_NO												= "New_Supplier_Phone_No";
	final static String	CITY																= "City";
	final static String	COUNTY																= "county";
	final static String	MARKET_PRICE														= "Market Price";
	final static String	Email_OUTSIDE_COMPANY												= "Email_OUTSIDE_COMPANY";
	final static String	ITEM_WITH_DIFFERENT_SUPPLIER										= "itemWithDiffrentSupplier";
	final static String	SEARCH_BY_ITEM_NO													= "SEARCH_BY_ITEM_NO";
	final static String	SPECIFICATION_DATA_KEY												= "SPECIFICATION_DATA_KEY";
	final static String	SPECIFICATION_DATA_VALUE											= "SPECIFICATION_DATA_VALUE";
	final static String	VALID_PCARD_NO_FOR_CHECKOUT											= "VALID_PCARD_NO_FOR_CHECKOUT";
	final static String	TAX_AMOUNT															= "TAX_AMOUNT";
	final static String	ORGANIZATION_UNIT_OR_COMPANY_NAME									= "OrganizationUnit/Company_Name";
	final static String	BU																	= "differentBusinessUnit";
	final static String	MY_ADDRESS_STREET1													= "myAddress_Street1";
	final static String	MY_ADDRES_ZIP														= "myAddress_zip";
	final static String	PO_NO_FORMAT_TEMP													= "PO_NO_FORMAT_TEMP";
	final static String	LOCATION															= "differentLocation";
	final static String	DIFF_COST_CENTER													= "DIFF_COST_CENTER";
	final static String	OTHER_COMPANY_CC													= "OtherCompanyCC";
	final static String	OTHER_PROJECT														= "OtherProject";
	final static String	other_CC_other_project_other_budget									= "other_CC,other_project,other_budget";

	final static String	SUPPLIER_CONTACT_FIRST_NAME											= "supplierContactFirstName";
	final static String	SUPPLIER_CONTACT_LAST_NAME											= "supplierContactLastName";
	final static String	SEARCH_ITEM															= "searchFor3";
	final static String	FREIGHT_CHARGES														= "Freight Charges";
	final static String	TAX_FREE_DELIVERY_ADDRESS											= "taxFreeDeliveryAddress";
	final static String	TERMS_AND_COMDITION_MAX_CHARS										= "termsAndConditionMax";
	final static String	OTHER_SUPPLIER_ADDRESS												= "otherSupplierAddress";
	final static String	MY_ADDRESS															= "myAddress";
	final static String	INACTIVE_PROJECT													= "inactiveProject";
	final static String	OTHER_COMPANY_CC_OTHER_COMPANY_PROJECT_OTHER_COMPANY_BUDGET			= "otherCompanyCC_otherCompanyProject_otherCompanyBudget";
	final static String	VALIDATION_MAP_CHECK_GL_ACCOUNT										= "validationCheckGLAccount";
	final static String	BUSINESS_UNIT_NAME													= "BusinessUnit_Name";
	final static String	LOCATION_NAME														= "Location_Name";
	final static String	DEPATMENT_NAME														= "department_Name";
	final static String	PCard_No_For_Creating_User_Pcard									= "PCard_No_For_Creating_User_Pcard";
	final static String	PCard_No_For_Creating_Supplier_Pcard								= "PCard_No_For_Creating_Supplier_Pcard";
	final static String	PCARD_ISSUING_BANK													= "PCard_Issuing_Bank";
	final static String	PCard_Type															= "PCard_Type";
	final static String	Punchout_Item_Name													= "Punchout Item Name";
	final static String	OTHER_SUPPLIER_DELIVERY_TERMS										= "OtherSupplierDeliveryTerms";
	final static String	OUTDATED_PROJECT													= "outdatedProject";
	final static String	MUlTILINGUAL_PROJECT												= "projectwithmultilingual";
	final static String	SPECIALCHARACTER_PROJECT											= "projectwithspecialcharacter";
	final static String	MAXLENGTHCHAR_PROJECT												= "projectwithmaxchar";
	final static String	ITEM_PRODUCT_CATAGORY												= "productcatagory";
	final static String	CHILD_GL_ACCOUNT													= "childGLAccount";
	final static String	PO_EMAIL_DETAILS_TEMPLATE											= "POEmailDetailsTemplate";
	final static String	SHIPPED_VIA															= "shippedVia";
	final static String	TEMP_GL_ACCOUNT														= "tempGLAccount";
	final static String	TEMP_GL_MAP_CATEGORY												= "tempGLMapCategory";
	final static String	TEMP_ITEM															= "tempItem";
	final static String	OTHER_GL_ACCOUNT_TYPE												= "otherGLAccountType";
	final static String	TEMP_PROJECT														= "tempProject";
	final static String	ASSIGNED_BUYER_USER_GROUP											= "AssignedBuyerUserGroup";
	final static String	DIFFERENT_USER														= "DifferentUser";
	final static String	OTHER_GL_ACCOUNT													= "OtherGLAccount";
	final static String	DIFFERENT_PRODUCT_CATEGORY											= "DifferentProductCategory";
	final static String	BUYER_WITH_PURCHASING_SCOPE_1										= "BuyerWithPurchasingScope1";
	final static String	BUYER_WITH_PURCHASING_SCOPE_2										= "BuyerWithPurchasingScope2";
	final static String	BUYER_WITH_HIGHER_APPROVAL_LIMIT									= "BuyerWithHigherApprovalLimit";
	final static String	ASSET_CODE															= "AssetCode";
	final static String	MULTILINGUAL_ASSET_CODE												= "MultilingualAssetCode";
	final static String	SPECIAL_CHAR_ASSET_CODE												= "SpecialCharAssetCode";
	final static String	MAX_CHAR_ASSET_CODE													= "MaxCharAssetCode";
	final static String	ZERO_PRICE_ITEM_IN_CATALOG											= "ZeroPriceItemInCatalog";
	final static String	MAX_CHAR_CC															= "MaxCharCC";
	final static String	MAX_CHAR_GL_ACCOUNT													= "MaxCharGlAccount";
	final static String	UOM_SUPPLIER_CODE													= "UomSupplierCode";
	final static String	CURRENCY_SUPPLIER_CODE												= "CurrencySupplierCode";
	final static String	CATEGORY_SUPPLIER_CODE												= "CategorySupplierCode";
	final static String	OTHER_UOM_SUPPLIER_CODE												= "OtherUomSupplierCode";
	final static String	OTHER_CURRENCY_SUPPLIER_CODE										= "OtherCurrencySupplierCode";
	final static String	OTHER_CATEGORY_SUPPLIER_CODE										= "OtherCategorySupplierCode";
	final static String	TEMP_PAYMENT_TERM													= "TempPaymentTerm";
	final static String	TENANT_ID															= "TENANT_ID";
	String				Item_Master_Type													= "Item Master Type";
	final static String	Item_Number															= "Item_Number";
	final static String	Item_Short_Description												= "Item_Short_Description";
	final static String	Item_Long_Description												= "Item_Long_Description";
	final static String	Item_Product_Category												= "Item_Product_Category";
	final static String	MIN_PRICE_FILTER													= "minPriceFilter";
	final static String	MAX_PRICE_FILTER													= "maxPriceFilter";
	final static String	PRODUCT_DESCRIPTION													= "productDescription";

	final static String	Item_Quantity														= "Item_Quantity";
	final static String	Item_Price0															= "Item_Price";
	final static String	Item_Currency														= "Item_Currency";
	final static String	Item_Supplier_Name													= "Item_Supplier_Name";
	final static String	Req_Name_for_Duplicate_Item											= "Req_Name_for_Duplicate_Item";
	final static String	Req_Name_for_Item													= "Req_Name_for_Item";
	final static String	Req_Number_for_Duplicate_Item										= "Req_Number_for_Duplicate_Item";
	final static String	Item_UOM															= "Item_UOM";
	final static String	Item_Sourcing_Status												= "Item_Sourcing_Status";
	final static String	Item_Manufacturer_Name												= "Item_Manufacturer_Name";
	final static String	Item_Manufacturer_Part_Id											= "Item_Manufacturer_Part_Id";
	final static String	Item_Specification_Name												= "Item_Specification_Name";
	final static String	Item_Specification_Key												= "Item_Specification_Key";
	final static String	Item_Specification_Value											= "Item_Specification_Value";
	final static String	Item_Specification_Count											= "Item_Specification_Count";
	final static String	Item_Image_URL0														= "Item_Image_URL0";
	final static String	Item_Product_URL													= "Item_Product_URL";
	final static String	Item_Manufacturer_URL												= "Item_Manufacturer_URL";
	final static String	Item_Address_Requirement_Tab										= "Item_Address_Requirement_Tab";
	final static String	Item_BPO_Number														= "Item_BPO_Number";
	final static String	Item_Contract_Number												= "Item_Contract_Number";
	final static String	Item_Req_Change_Comments											= "Item_Req_Change_Comments";
	final static String	Item_GL_Account														= "Item_GL_Account";
	final static String	Item_Cost_Center													= "Item_Cost_Center";
	final static String	Item_Project														= "Item_Project";
	final static String	Item_Budget															= "Item_Budget";

	// Buyers Desk Setting
	final static String	Item_AllowPR_Percent_Total_Amount									= "Item_AllowPR_Percent_Total_Amount";
	final static String	Item_AllowPR_CurrencyUnits											= "Item_AllowPR_CurrencyUnits";
	// GL-Category Map
	final static String	Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1	= "Category1,PurchaseType1,AnyCC,Amount,GLType1,GLAccount1,Company1";
	final static String	Category1_PurchaseType2_AnyCC_Amount_GLType2_GLAccount2_Company1	= "Category1,PurchaseType2,AnyCC,Amount,GLType2,GLAccount2,Company1";
	final static String	Category1_AnyPurchaseType_AnyCC_Amount_GLType3_GLAccount3_Company1	= "Category1,AnyPurchaseType,AnyCC,Amount,GLType3,GLAccount3,Company1";
	final static String	Category2_PurchaseType1_AnyCC_Amount_GLType2_GLAccount2_Company1	= "Category2,PurchaseType1,AnyCC,Amount,GLType2,GLAccount2,Company1";
	final static String	Category2_PurchaseType2_AnyCC_Amount_GLType1_GLAccount1_Company1	= "Category2,PurchaseType2,AnyCC,Amount,GLType1,GLAccount1,Company1";
	final static String	Category2_AnyPurchaseType_AnyCC_Amount_GLType3_GLAccount3_Company1	= "Category2,AnyPurchaseType,AnyCC,Amount,GLType3,GLAccount3,Company1";
	final static String	Category1_AnyPurchaseType_AnyCC_Amount_GLType1_GLAccount4_Company2	= "Category1,AnyPurchaseType,AnyCC,Amount,GLType1,GLAccount4,Company2";
	final static String	Category2_AnyPurchaseType_AnyCC_Amount_GLType2_GLAccount5_Company2	= "Category2,AnyPurchaseType,AnyCC,Amount,GLType2,GLAccount5,Company2";
	final static String	Category1_PurchaseType_CC_Amount_GLType1_GLAccount1_Company1		= "Category1,PurchaseType1,AnyCC,Amount,GLType1,GLAccount1,Company1";

	// different project names
	final static String	MAX_CHAR_PROJECT													= "maxCharProject";
	final static String	SPECIAL_CHAR_PROJECT												= "specialCharProject";
	final static String	MULTILINGUAL_CHAR_PROJECT											= "multilingualCharProject";

	// different types of user names
	final static String	MAX_CHAR_USER														= "MaxCharUser";
	final static String	MULTILINGUAL_CHAR_USER												= "MultilingualUser";
	final static String	SPECIAL_CHAR_USER													= "SpecialCharUser";

	final static String	ALL_CHARACTERS														= "All_Characters";

	String				PurchasingScope_WithOneLocation										= "PurchasingScope_WithOneLocation";
	String				PurchaseType_Used_In_Custom_Business_Rule							= "PurchaseType_Used_In_Custom_Business_Rule";
	String				List_Of_Cost_Center_For_BU											= "List Of Cost Center For Business Unit";
	String				List_Of_Projects_For_BU												= "List Of Projects For Business Unit";
	String				TenantName															= "TenantName";
	String				System_Tenant_Custom_Lang_Name										= "System Tenant Custom Lang Name";

	// category-manager map
	String				Category1_Buyer1_Purpose1											= "Category1,Buyer1,Purpose1,Child Category";
	String				Category2_Buyer2_Purpose1											= "Category2,Buyer2,Purpose1,Child Category";

	String				Purchase_Type_Used_In_Manager_Node_Workflow							= "Purchase_Type_Used_In_Manager_Node_Workflow";

	String				Region_Name															= "Region Name";

	String				Non_Inventory_Item_With_Asset_Tagging								= "Non_Inventory_Item_With_Asset_Tagging";

	// item details from property file
	final static String	Item_Name															= "Item_Name";
	final static String	Description															= "Description";
	final static String	Manufacturer														= "Manufacturer";
	final static String	Category															= "Category";
	final static String	SPSC_Code															= "SPSC_Code";
	final static String	Supplier															= "Supplier";
	final static String	Supplier_Contact													= "Supplier_Contact";
	final static String	Delivery_Lead_Time													= "Delivery_Lead_Time";
	final static String	Contract_No															= "Contract_No";
	final static String	Supplier_Part_Id													= "Supplier_Part_Id";
	final static String	Item_Price															= "Item_Price";
	final static String	Specification														= "Specification";
	final static String	Spec_Key															= "Spec_Key";
	final static String	Spec_Value															= "Spec_Value";
	final static String	NA																	= "N/A";
	final static String	Attachment															= "Attachment";

	// users delivery scope by value
	String				DELIVERY_SCOPE_SELF_BEHALF											= "SELF_BEHALF";
	String				DELIVERY_SCOPE_DEPT													= "DEPT";
	String				DELIVERY_SCOPE_PS													= "PS";
	String				DELIVERY_SCOPE_BU													= "BU";
	String				DELIVERY_SCOPE_COMPANY												= "COMPANY";
	String				DELIVERY_SCOPE_ANY_USER												= "ANY_USER";
	String				SCRIPT_INPUT														= "SCRIPT_INPUT";

	// cost center search in
	String				SearchCC_In_Code													= "Code";
	String				SearchCC_In_Name													= "Name";
	String				SearchCC_In_Cost_Center_Code										= "Cost Center Code";
	String				SearchCC_In_Cost_Center_Owner										= "Cost Center Owner";
	String				Company																= "Company";
	String				Company_TATA														= "TATA";
	String				Status																= "Status";
	String				SearchCC_In_Project_Code											= "Code";
	String				SearchCC_In_Project_Or_Task_No										= "Project/Task No.";
	String				SearchCC_In_Project_Or_Task_Name									= "Project/Task Name";
	String				SearchCC_In_Statistical_Project_Or_Task_Name						= "Statistical Project/Task Name";
	String				SearchCC_In_Project_Company											= "Company";
	String				SearchCC_In_Project_In_Use											= "In use";

	String				Default_System_Tenant_Custom_Lang_Name								= "Default";
	String				Default_CostCenter_Label_Name										= "Cost Center";
	String				Default_Project_Label_Name											= "Project";
	String				Default_GL_Account_Label_Name										= "GL Account";
	String				Default_Account_Type_Label_Name										= "Account type";

	String				COST_BOOKING_SINGLE_PROJECT											= "Automation_Project1";
	String				COST_BOOKING_SINGLE_BUDGET											= "Automation Budget";

	// TMS setting
	final static String	Radio_Always														= "Always";
	final static String	Radio_Never															= "Never";
	final static String	Radio_LetUserDecide													= "Let users decide";

	// BuyersDesk Actions
	final static String	Action_Click_Link_Cancel											= "Click_Link_Cancel";
	final static String	Action_Create_Guided_Item											= "Create_Item";
	final static String	Action_Click_Button_CancelAndGoBack									= "Click_Button_CancelAndGoBack";

	String				FREE_TEXT_ITEM_NAME													= "AlphaBetaGama";
	String				searchFor															= "searchFor";

	// Add item to (Cart,basket,Fav)
	public String		ADD_TO_CART															= "ADD_TO_CART";
	public String		ADD_TO_BASKET														= "ADD_TO_BASKET";
	public String		ADD_TO_FAV															= "ADD_TO_FAV";

	// category names
	public String		Freedom_of_speech_defense_associations								= "Freedom of speech defense associations";
	public String		Paper_Materials_and_Products										= "Paper_Materials_and_Products";
	public String		Cleaning_and_janitorial_services									= "Cleaning_and_janitorial_services";

	// supplier names
	public String		Supplier_ebay														= "Supplier_ebay";
	public String		Supplier_eproc														= "Supplier_eproc";

	// confirmation choices
	public String		CONFIRMATION_YES													= "CONFIRMATION_YES";
	public String		CONFIRMATION_NO														= "CONFIRMATION_NO";

	// recall/approve via
	public String		VIA_TOOL_TIP														= "VIA_TOOL_TIP";
	public String		VIA_VIEW_PAGE														= "VIA_VIEW_PAGE";
	public String		VIA_ACTION_DROPDOWN													= "VIA_ACTION_DROPDOWN";

	// admin Monitoring activities
	public String		CLEAR_CACHE															= "Clear Cache";
	public String		MONITOR_ACTIVEMQ													= "Monitor ActiveMQ";
	public String		CURRENT_SESSION														= "Current Session";
	public String		PHP_CONFIG_INFO														= "PHP config info";
	public String		APPROVALS															= "Approvals";
	public String		EVENTS																= "Events";
	public String		UNDER_MAINTAINANCE													= "Under Maintenance";
	public String		UTILITY																= "Utility";
	public String		PRODUCT_STATUS														= "Product Status";
	public String		IMPORT_EXPORT_DATA													= "Import - Export Data";
	public String		SEARCH_EVENT														= "Search";
	public String		RESET_EVENT															= "Reset";

	// iConsole automation specific
	public String		API_ACTION_SEARCH													= "Search";
	public String		API_ACTION_UPDATE													= "Update";
	public String		API_REQUISITION_APPROVAL											= "/rest/v1/eProc/requisitions/{requisitionId}/approval";
	public String		API_PURCHASE_ORDER_APPROVAL											= "/rest/v1/eProc/purchaseOrder/{purchaseOrderId}/approval";

	// COA tenant names
	public String		COA																	= "COA";
	public String		AMFAM																= "AmFam";
	public String		MAYER_BROWN															= "MayerBrown";
	public String		COA_SHEET_VALID														= "Valid";
	public String		COA_SHEET_INVALID													= "Invalid";

	// Client Specific for SaWater
	public String		External_Agent														= "External Agent";
	public String		DELIVERY_ADRESS_1													= "DeliveryAddress_1";
	public String		DELIVERY_ADRESS_2													= "DeliveryAddress_2";
	final static String	IMPORT_EFORM														= "IMPORT_EFORM";
	final static String	ITEM_NAME_FOR_SEARCHING_1											= "ITEM_NAME_FOR_SEARCHING_1";

	final static String	ITEM_CATEGORY_FOR_SEARCHING											= "ITEM_CATEGORY_FOR_SEARCHING";
	final static String	ITEM_CATEGORY_CODE_FOR_SEARCHING									= "ITEM_CATEGORY_CODE_FOR_SEARCHING";
	final static String	ITEM_NOT_TAGGED_WITH_ANY_CATEGORY									= "ITEM_NOT_TAGGED_WITH_ANY_CATEGORY";
	final static String	ITEM_SUPPLIER_FOR_SEARCHING											= "ITEM_SUPPLIER_FOR_SEARCHING";
	final static String	ITEM_SUPPLIER_FOR_SEARCHING_1										= "ITEM_SUPPLIER_FOR_SEARCHING_1";
	final static String	ITEM_SUPPLIER_FOR_SEARCHING_2										= "ITEM_SUPPLIER_FOR_SEARCHING_2";

	final static String	SHARE_POINT_URL_EFORM												= "SHARE_POINT_URL_EFORM";
	final static String	INTERNAL_DELIVERY_LOCATION_EFORM									= "INTERNAL_DELIVERY_LOCATION_EFORM";
	final static String	DELIVERY_INSTRUCTION_EFORM											= "DELIVERY_INSTRUCTION_EFORM";
	final static String	ESTIMATED_FREIGHT_EFORM												= "ESTIMATED_FREIGHT_EFORM";
	final static String	PURCHASING_INSTRUCTIONS_EFORM										= "PURCHASING_INSTRUCTIONS_EFORM";

	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK									= "ITEM_NAME_FOR_SEARCHING_NON_STOCK";

	final static String	WORKFLOW_EXTERNAL_AGENT_TEXT										= "WORKFLOW_EXTERNAL_AGENT_TEXT";
	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK_1									= "ITEM_NAME_FOR_SEARCHING_NON_STOCK_1";
	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK_SUPPLIER_1						= "ITEM_NAME_FOR_SEARCHING_NON_STOCK_SUPPLIER_1";
	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK_SUPPLIER_2						= "ITEM_NAME_FOR_SEARCHING_NON_STOCK_SUPPLIER_2";

	final static String	SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS						= "SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS";

	final static String	UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS						= "UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS";

	final static String	NA_RESPONSE_CMS														= "RESPONSE_CMS";
	final static String	YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION				= "YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION";

	final static String	NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS							= "NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS";
	final static String	OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS								= "OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS";
	final static String	OBTAINED_BUT_TC_QUOTE_FURTHER_DETAILS								= "OBTAINED_BUT_T&C_QUOTE_FURTHER_DETAILS";
	final static String	NA_QUOTE_FURTHER_DETAILS											= "NA_QUOTE_FURTHER_DETAILS";
	final static String	NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS						= "NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS";
	final static String	NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS					= "NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS";
	final static String	EMAIL_PO_MEDIUM_FURTHER_DETAILS										= "EMAIL_PO_MEDIUM_FURTHER_DETAILS";
	final static String	PRINT_PO_MEDIUM_FURTHER_DETAILS										= "PRINT_PO_MEDIUM_FURTHER_DETAILS";
	final static String	FAX_PO_MEDIUM_FURTHER_DETAILS										= "FAX_PO_MEDIUM_FURTHER_DETAILS";
	final static String	DROPDOWN_IS_PO_VALUE_PO_COMPLETED									= "DROPDOWN_IS_PO_VALUE_PO_COMPLETED";

	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK_WH_1								= "ITEM_NAME_FOR_SEARCHING_NON_STOCK_WH_1";
	final static String	ITEM_NAME_FOR_SEARCHING_NON_STOCK_WH_2								= "ITEM_NAME_FOR_SEARCHING_NON_STOCK_WH_2";
	final static String	ITEM_CATEGORY_FOR_SEARCHING_NOCAT_SAWATER							= "ITEM_CATEGORY_FOR_SEARCHING_NOCAT_SAWATER";
	final static String	SUPPLIER_NAME_1														= "supplierName1";
	final static String	ITEM_CATEGORY_FOR_SEARCHING_1										= "ITEM_CATEGORY_FOR_SEARCHING_1";
	final static String	ITEM_NAME_FOR_SEARCHING_SUPPLIER_1									= "ITEM_NAME_FOR_SEARCHING_SUPPLIER_1";
	final static String	ITEM_NAME_FOR_SEARCHING_SUPPLIER_2									= "ITEM_NAME_FOR_SEARCHING_SUPPLIER_2";

	// Client Specific for ICW
	final static String	COUNTRY_NAME														= "COUNTRY_NAME";

	// client specific QTS
	final static String	IS_PURCHASE_BUDGETED												= "IS_PURCHASE_BUDGETED";
	final static String	WHAT_IS_PURCHASED_AND_WHY											= "WHAT_IS_PURCHASED_AND_WHY";
	final static String	IS_PURCHASED_BEFORE													= "IS_PURCHASED_BEFORE";
	final static String	IS_PRICE_INCREASE													= "IS_PRICE_INCREASE";
	final static String	IS_ADDITIONAL_SAVINGS												= "IS_ADDITIONAL_SAVINGS";
	final static String	SAVINGS_ACHIEVED													= "SAVINGS_ACHIEVED";

	// eform file upload
	final static String	PEFORM_FILE_UPLOAD_PATH												= "PEFORM FILE UPLOAD PATH";
	final static String	CEFORM_FILE_UPLOAD_PATH												= "CEFORM FILE UPLOAD PATH";
	final static String	PEFORM_FILE_UPLOAD_NAME												= "PEFORM FILE UPLOAD NAME";
	final static String	CEFORM_FILE_UPLOAD_NAME												= "CEFORM FILE UPLOAD NAME";

	//
	final static String	OTHER																= "Other";
	final static String	REPLACEMENT															= "Replacement";
	final static String	FULLY_INVOICED														= "Fully Invoiced";

	// Pcard
	final static String	ERROR_PCARD_ALREADY_EXIST											= "card already exists";
	final static String	ERROR_PCARD_DAILY_TRANSACTION										= "daily transactions can not be more than transactions per cycle";
	final static String	ERROR_PCARD_DAILY_SPEND												= "spend per use can not be more than daily spend";
	final static String	ERROR_PCARD_DAILY_SPEND_MORE_THAN_SPEND_CYCLE						= "daily spend can not be less than spend per use or more than spend per cycle";
	final static String	ERROR_PCARD_NO_ALL_READY_USED										= "Card no is already used";

	final static String	ERROR_PCARD_ORDERS_MULTI_CURR										= "p-card orders cannot be of multiple currencies";
	final static String	ERROR_PCARD_ORDERS_MULTI_SUPPLIERS									= "p-card orders cannot be from multiple suppliers";
	final static String	ERROR_PCARD_TRANSACTION_LIMIT_EXCEEDED								= "number of transactions allowed have been exceeded";
	final static String	ERROR_PCARD_SPEND_LIMIT_EXCEEDED									= "spend limit on this user p-card has been exceeded";

	final static String	PCARD_TRANSACTION_COUNT												= "on 1 Orders";

	final static String	attachment_file_name												= "attachment_file_name";
	final static String	buyer_desk_item_category											= "buyer_desk_item_category";

	final static String	RETURN_NOTE															= "Return Note";
	final static String	RECEIPT																= "Receipt";

	final static String	RECEIVED															= "Received";
	final static String	ITEM_NAME_AND_SUPPLIER												= "Item Name and Supplier";
	final static String	RATE																= "Rate";
	final static String	UNIT_PRICE															= "Unit Price";
	final static String	VALUE_OF_ACCEPTED_GOODS												= "Value of Accepted Goods";
	final static String	REQUISITION_NO														= "Requisition No";
	final static String	RETURNED_QUANTITY_AMOUNT											= "Returned Quantity/Amount";
	final static String	VALUE_OF_RETURNED_GOODS_SERVICE										= "Value of Returned Goods/Services";
	final static String	REASON_FOR_RETURN													= "Reason for Return";
	final static String	RETURN_METHOD														= "Return Method";

	// search by conditions for item master

	public String		ERP_PART_NO															= "ERP_PART_NO";
	public String		MANUFACTURER_PART_ID												= "MANUFACTURER_PART_ID";
	public String		ITEM_NAME															= "ITEM_NAME";
	public String		CATEGORY															= "CATEGORY";

	// actions for item in item master

	public String		EDIT_ITEM															= "EDIT_ITEM";
	public String		DISCARD_ITEM														= "DISCARD_ITEM";

	// Warehouse
	final static String	WAREHOUSE															= "WAREHOUSE";
	final static String	ACTIVE																= "Active";
	final static String	INACTIVE															= "Inactive";

	final static String	TEXT_FIELD															= "Text Field";
	final static String	TEXT_AREA															= "Text Area";
	final static String	CHECK_BOX															= "Check Box";

	final static String	SPECIFICATIONS_NAME_LONG_DATA										= "SPECIFICATIONS_NAME_LONG_DATA";
	final static String	LONG_MARKET_PRICE													= "LONG_MARKET_PRICE";
	final static String	MARKET_PRICE_WITH_ALPHABETS_AND_SPECIAL_CHARACTERS					= "MARKET_PRICE_WITH_ALPHABETS_AND SPECIAL_CHARACTERS";
	final static String	NEGATIVE_MARKET_PRICE												= "NEGATIVE_MARKET_PRICE";

	// valid data for item master item
	final static String	ITEM_DESCRIPTION_VALID												= "sH6XQ08slZgUUwsUpYu5GHawiMjKPHtbTF3yCTEk4yxImji84UwddQLf5g6HihwAugPmeCXKihZOj2XO0eGPBnLG94Scxl4nNUIjtsz4cvFKnpWn5rACBw3Hw33zPC3pp9CJ5QH5tYlBUtV4ehdCI2kDs4MCBs8EbonlXNrSL48Tmz1XtMXjrAtTPgB9VIaAZesNLO51LxyqpOKM8zy3sIhkaMagKk2xVui5XE5HC6qP51OHfwuHBXyIFE466CdwbbRLAPoXQYU8F3xcXksU9xRvxILX2P4jzfSfRnFBoSiVBM6Q3LYnLgH5XhKYBWg2DBoAV99ST3OIkLZIEsQMs6W1OKNAvC2LSXBVxEpVyyQgyttyTs4Zil1ggGQHrW3ppKaFv7Njmn7FTEOYVeym2a5z4TratzFKzxkLIjvoNraau8Pd5DSH9WjEklSBQ71OWROUlqAuKTr2UnIeMdKwtDY4IjnL7abIFNbrWUbFRZF0dQUu4pK8TeHJDzYNNqkZmZVM7O0u9ahzFaRdq3vRbUDxsa9wUnYiKZ9FmIdtISljS22ljsOLHlH6638RMLqCrznsbtE6x1tbVomWsbRrUdAADTjDCZFmDlE2qPf67WmCVOhH9X3TOUKiP2qGdwzWhGp6GALuyfa5ALIpM9nuMxAyg4F2TjnnJ1l6yiVQPtE5asT7JYU9d2oEBcIiwphU8E7t4gXC4M6YZUl05aEWLbooWo9zEJRmARAw4QuTWcVg0Xl7PUpYwnvs8xLqRvdB3Fvxc4gtjERH5SNcROsGZqdYYoGWMfcHpe1oJUWtWGRYqw4B8cXwqUtEY2cWgGFRenXPrKDJ0LkWFlb1ApM2iRfpB5qdxNaDyLcgL62nAQsnhEyQVd5ai3WgVKmBXztDCC1M0iVOzKJ7geXmNYVlDeUBPYTnDgvQJkLjQwP0s3QDTeoQfPhsfR7V3bsACRhsuHFv70vk1EmNsgtbHIk0uNsl9VYNJaLBC6EdZcg4oBe5ybJG4JBs6B7ITRLZf7Y4Sl5255dgTBUfGPOMEc7mw1XB4XFPidJSmgAyYv8tSVG8KgoGPTYrCiHD5oIhmqzHecUu3nQqmOvddMPFT1BtpxIlgnP4yzCrjjEVBA1MSDRjvOVpK87BcQ9tw1IvATcf2pDzxTeLiblzQrroRrAMWtQqjpT62D5dNpsDI0ovcUaJ2m1ug7gyld3bi9Ms3uP5glhGZCQGg0cTVNcpd262BLVPqQYkU5rdrqvfa796gtWiMAEEKYsu10zefQrfrnwEQnkFRVKZwGxTJNDK7spyPpwNYjUOj9HHFSVXzuQMG22eUo5sfUkHi9LtNVISfBU0ck3ceiVhyZtLp5o40zsjcGRmWmDxmfhJgGK0ZlqQ9DXcKxPMiWuZhOOgnUOHLZD6evSR8HmMrwEuTVg1ZqNSYSRvuVQNSNX4DlSYWNqiDOxO5y7lsY4vfqfJd8wG1iXrGyUXSUaaaP9XUUQFmRgp6ZS7X9HuSRQjXDMBrV4CCzO3KLNt2uqnQNSGaLxUEKgCiOVwO5sAMa5wiK54jJA45Fe2dHpIf778iFraieG2gEDZ86vn67DRHxFcPHXoMlh0PrPvwGL3LUOAQMA6fUXlCIqQEpROSxflmZB8xt3Egtizwsj1DhdDI7iqwDSyQIIlQiGmLth6Iv2I8udfDx3Zxty68D4kG8qHNvMBUeBqELN0kcwSucHVpiEjy5CFwfIGE3a0WZOokSLLulaUeEQQLsDeZbJupi4q3rmouBGKLQaC52xSVHAEQwGqNsRXmulr36swktzWpArVgkD6vVETndfYTDn0z4GUApJu68X2M6fXLvLpu5fI7hIk32u3266n8YEEqcUJc2pw0qqVBuBDqhGjNgyYYIk2qfwrgWq5kRoxRxvVyTpvGXEqJxeQWq6SZQRUI2qXvhgUD32HyMbOlUxicpEIb58uhC8yi7clLbiDIp52bek3xIoDpgF4Tf9kYcW6oYd2eFuXiKsy";	// 2000
	// characters
	final static String	PRODUCT_DESCRIPTION_VALID											= "OyK5RBrcaEQhyqhy11OMpytfFCbon7CfcjVU8JYytgN9JbzY51Gf8KfbI6OFygbsyl4wSp3lvf148yIvXFTcKY8bF3YayOMTZwyPNbiePx0jophw67fWeXktM8YZxRI0uEuCOckM2kCIupATETkLPjzYEeymL6ld0cl2YcOmltpjaAKW9Qid46RruKiYyX4nLlTM6XHAvGjmhaBgGrNRdtAKm2VDOuK6T8fe6ZPeJ41UMy4UQBCEJgqBPi";																																																																																																																																																																																																																																																																																																																																																																																																																																																							// 250
	// characters
	final static String	MARKET_PRICE_VALID													= "123456789123456";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	// 15
	// characters
	final static String	CURRENCY_VALID														= "1234567891234567891234567891234567891234";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											// 40
	// characters
	final static String	SPECIFICATIONS_NAME_VALID											= "bSIIqqIqPIZfuPWGWnyQJNUthUvnTmP5WCNyGewqMAL5h8fGxwZNv48XIP5jTS71ud3tSFVeL7ZCfsenS50qBScKvPIs6C85FWNhsAN5TyLYIJqz4DQN4aLpk1kGS0mTK4i37ZLrV7acGZv1q4Xo2obq6bux3nY1ArpQ4rUVyxrbPKr6s6U8mmztO5qm2GzNFQ1xMKs6cI08PHo9h9gMee3i0G380SQlgeFmxk8DWdFGvDV6CIVYLMBGXQ";																																																																																																																																																																																																																																																																																																																																																																																																																																																							// 250
	// characters
	final static String	SPECIFICATIONS_VALID												= "bSIIqqIqPIZfuPWGWnyQJNUthUvnTmP5WCNyGewqMAL5h8fGxwZNv48XIP5jTS71ud3tSFVeL7ZCfsenS50qBScKvPIs6C85FWNhsAN5TyLYIJqz4DQN4aLpk1kGS0mTK4i37ZLrV7acGZv1q4Xo2obq6bux3nY1ArpQ4rUVyxrbPKr6s6U8mmztO5qm2GzNFQ1xMKs6cI08PHo9h9gMee3i0G380SQlgeFmxk8DWdFGvDV6CIVYLMBGXQ";																																																																																																																																																																																																																																																																																																																																																																																																																																																							// 250
	// characters
	final static String	MANUFACTURER_NAME_VALID												= "ugrANhOsId5KB4lJZaBfm4s0sblptSi2u8Ndcmb3rUuXogI58ArmoklTaEO48MtBRRUacZaOn1JWmvaFWeWdanh2x1syGfNKR2LR";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												// 100
	// characters
	final static String	MANUFACTURER_PART_ID_VALID											= "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												// 100
	// characters
	final static String	ERP_PART_NO_VALID													= "1234567891234567891234567891234567891234";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											// 40
	// characters
	final static String	ITEM_NO_VALID														= "1234567891234567891234567891234567891234";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											// 40
	// characters

	// invalid data for item master item
	final static String	ITEM_DESCRIPTION_INVALID											= "sH6XQ08slZgUUwsUpYu5GHawiMjKPHtbTF3yCTEk4yxImji84UwddQLf5g6HihwAugPmeCXKihZOj2XO0eGPBnLG94Scxl4nNUIjtsz4cvFKnpWn5rACBw3Hw33zPC3pp9CJ5QH5tYlBUtV4ehdCI2kDs4MCBs8EbonlXNrSL48Tmz1XtMXjrAtTPgB9VIaAZesNLO51LxyqpOKM8zy3sIhkaMagKk2xVui5XE5HC6qP51OHfwuHBXyIFE466CdwbbRLAPoXQYU8F3xcXksU9xRvxILX2P4jzfSfRnFBoSiVBM6Q3LYnLgH5XhKYBWg2DBoAV99ST3OIkLZIEsQMs6W1OKNAvC2LSXBVxEpVyyQgyttyTs4Zil1ggGQHrW3ppKaFv7Njmn7FTEOYVeym2a5z4TratzFKzxkLIjvoNraau8Pd5DSH9WjEklSBQ71OWROUlqAuKTr2UnIeMdKwtDY4IjnL7abIFNbrWUbFRZF0dQUu4pK8TeHJDzYNNqkZmZVM7O0u9ahzFaRdq3vRbUDxsa9wUnYiKZ9FmIdtISljS22ljsOLHlH6638RMLqCrznsbtE6x1tbVomWsbRrUdAADTjDCZFmDlE2qPf67WmCVOhH9X3TOUKiP2qGdwzWhGp6GALuyfa5ALIpM9nuMxAyg4F2TjnnJ1l6yiVQPtE5asT7JYU9d2oEBcIiwphU8E7t4gXC4M6YZUl05aEWLbooWo9zEJRmARAw4QuTWcVg0Xl7PUpYwnvs8xLqRvdB3Fvxc4gtjERH5SNcROsGZqdYYoGWMfcHpe1oJUWtWGRYqw4B8cXwqUtEY2cWgGFRenXPrKDJ0LkWFlb1ApM2iRfpB5qdxNaDyLcgL62nAQsnhEyQVd5ai3WgVKmBXztDCC1M0iVOzKJ7geXmNYVlDeUBPYTnDgvQJkLjQwP0s3QDTeoQfPhsfR7V3bsACRhsuHFv70vk1EmNsgtbHIk0uNsl9VYNJaLBC6EdZcg4oBe5ybJG4JBs6B7ITRLZf7Y4Sl5255dgTBUfGPOMEc7mw1XB4XFPidJSmgAyYv8tSVG8KgoGPTYrCiHD5oIhmqzHecUu3nQqmOvddMPFT1BtpxIlgnP4yzCrjjEVBA1MSDRjvOVpK87BcQ9tw1IvATcf2pDzxTeLiblzQrroRrAMWtQqjpT62D5dNpsDI0ovcUaJ2m1ug7gyld3bi9Ms3uP5glhGZCQGg0cTVNcpd262BLVPqQYkU5rdrqvfa796gtWiMAEEKYsu10zefQrfrnwEQnkFRVKZwGxTJNDK7spyPpwNYjUOj9HHFSVXzuQMG22eUo5sfUkHi9LtNVISfBU0ck3ceiVhyZtLp5o40zsjcGRmWmDxmfhJgGK0ZlqQ9DXcKxPMiWuZhOOgnUOHLZD6evSR8HmMrwEuTVg1ZqNSYSRvuVQNSNX4DlSYWNqiDOxO5y7lsY4vfqfJd8wG1iXrGyUXSUaaaP9XUUQFmRgp6ZS7X9HuSRQjXDMBrV4CCzO3KLNt2uqnQNSGaLxUEKgCiOVwO5sAMa5wiK54jJA45Fe2dHpIf778iFraieG2gEDZ86vn67DRHxFcPHXoMlh0PrPvwGL3LUOAQMA6fUXlCIqQEpROSxflmZB8xt3Egtizwsj1DhdDI7iqwDSyQIIlQiGmLth6Iv2I8udfDx3Zxty68D4kG8qHNvMBUeBqELN0kcwSucHVpiEjy5CFwfIGE3a0WZOokSLLulaUeEQQLsDeZbJupi4q3rmouBGKLQaC52xSVHAEQwGqNsRXmulr36swktzWpArVgkD6vVETndfYTDn0z4GUApJu68X2M6fXLvLpu5fI7hIk32u3266n8YEEqcUJc2pw0qqVBuBDqhGjNgyYYIk2qfwrgWq5kRoxRxvVyTpvGXEqJxeQWq6SZQRUI2qXvhgUD32HyMbOlUxicpEIb58uhC8yi7clLbiDIp52bek3xIoDpgF4Tf9kYcW6oYd2eFuXiKsy1";	// 2001
	// characters
	final static String	PRODUCT_DESCRIPTION_INVALID											= "OyK5RBrcaEQhyqhy11OMpytfFCbon7CfcjVU8JYytgN9JbzY51Gf8KfbI6OFygbsyl4wSp3lvf148yIvXFTcKY8bF3YayOMTZwyPNbiePx0jophw67fWeXktM8YZxRI0uEuCOckM2kCIupATETkLPjzYEeymL6ld0cl2YcOmltpjaAKW9Qid46RruKiYyX4nLlTM6XHAvGjmhaBgGrNRdtAKm2VDOuK6T8fe6ZPeJ41UMy4UQBCEJgqBPi1";																																																																																																																																																																																																																																																																																																																																																																																																																																																						// 251
	// characters
	final static String	MARKET_PRICE_INVALID												= "1234567891234567";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	// 16
	// characters
	final static String	CURRENCY_INVALID													= "12345678912345678912345678912345678912345";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											// 41
	// characters
	final static String	SPECIFICATIONS_NAME_INVALID											= "bSIIqqIqPIZfuPWGWnyQJNUthUvnTmP5WCNyGewqMAL5h8fGxwZNv48XIP5jTS71ud3tSFVeL7ZCfsenS50qBScKvPIs6C85FWNhsAN5TyLYIJqz4DQN4aLpk1kGS0mTK4i37ZLrV7acGZv1q4Xo2obq6bux3nY1ArpQ4rUVyxrbPKr6s6U8mmztO5qm2GzNFQ1xMKs6cI08PHo9h9gMee3i0G380SQlgeFmxk8DWdFGvDV6CIVYLMBGXQ1";																																																																																																																																																																																																																																																																																																																																																																																																																																																						// 251
	// characters
	final static String	SPECIFICATIONS_INVALID												= "bSIIqqIqPIZfuPWGWnyQJNUthUvnTmP5WCNyGewqMAL5h8fGxwZNv48XIP5jTS71ud3tSFVeL7ZCfsenS50qBScKvPIs6C85FWNhsAN5TyLYIJqz4DQN4aLpk1kGS0mTK4i37ZLrV7acGZv1q4Xo2obq6bux3nY1ArpQ4rUVyxrbPKr6s6U8mmztO5qm2GzNFQ1xMKs6cI08PHo9h9gMee3i0G380SQlgeFmxk8DWdFGvDV6CIVYLMBGXQ1";																																																																																																																																																																																																																																																																																																																																																																																																																																																						// 251
	// characters
	final static String	MANUFACTURER_NAME_INVALID											= "ugrANhOsId5KB4lJZaBfm4s0sblptSi2u8Ndcmb3rUuXogI58ArmoklTaEO48MtBRRUacZaOn1JWmvaFWeWdanh2x1syGfNKR2LR1";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												// 101
	// characters
	final static String	MANUFACTURER_PART_ID_INVALID										= "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												// 101
	// characters
	final static String	ERP_PART_NO_INVALID													= "12345678912345678912345678912345678912345";																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											// 41
	// characters
	final static String	ITEM_NO_INVALID														= "12345678912345678912345678912345678912345";
	final static String	LONG_CURRENCY														= "LONG_CURRENCY";
	final static String	Free_Text_Item_Alphanumeric_Item_Number								= "Free_Text_Item_Alphanumeric_Item_Number";
	final static String	Item_Requirement_Details											= "Item_Requirement_Details";

	// product login user name, password
	final static String	Product_Login_Username												= "Product_Login_Username";
	final static String	Product_Login_Password												= "Product_Login_Password";

	// buyers desk page
	final static String	Requisition_Status													= "Status";
	final static String	Requisition_No														= "Requisition No";
	final static String	Requisition_Name													= "Requisition Name";
	final static String	Requisition_Requester												= "Requester";
	final static String	Received_on															= "Received on";
	final static String	Assigned_buyer														= "Assigned buyer";
	final static String	Purchase_Amount														= "Purchase Amount";
	final static String	Actions																= "Actions";

	final static String	Reset_Warehouse_Fields												= "Reset_Warehouse_Fields";
	// warehouse details
	final static String	Warehouse_Name														= "Warehouse_Name";
	final static String	Warehouse_Address													= "Warehouse_Address";
	final static String	Warehouse_Location													= "Warehouse_Location";
	final static String	Add_Warehouse														= "Add_Warehouse";
	// TestData Added
	final static String	SUPPLIER_NAME_2														= "supplierName1";

	// Test Data for Warehouse Name
	final static String	Warehouse_Name_Special_Characters									= "Warehouse_Name_Special_Characters";

	final static String	item_supplier_scope_preprod											= ConfigProperty.getConfig("item_supplier_scope_preprod");
	final static String	item_master_upload_file												= ConfigProperty.getConfig("item_master_upload_file");
	final static String	item_master_without_scope											= ConfigProperty.getConfig("item_master_without_scope");

	final static String	URGENT_REQUEST_TITLE												= "This document contains urgent item";

	final static String	First_Company														= "First_Company";
	final static String	First_BU															= "First_BU";
	final static String	First_Location														= "First_Location";

	// Requisition Settings
	final static String	Requisition_Always													= "Always";
	final static String	Requisition_Never													= "Never";
	final static String	Requisition_Permission_Based										= "Permission Based";
	final static String	Requisition_Yes														= "Yes";
	final static String	Requisiiton_No														= "No";
	final static String	Requisition_Required												= "Required";
	final static String	Requisition_Optional												= "Optional";
	final static String	Requisition_Hidden													= "Hidden";
	final static String	Requisition_Buyer													= "Buyer";
	final static String	Requisition_BuyerGroup												= "BuyerGroup";

	// Buyers Desk Settings
	final static String	BuyersDesk_Yes														= "Yes";
	final static String	BuyersDesk_No														= "No";
	final static String	BuyersDesk_ExceedLimit_Smaller										= "smaller";
	final static String	BuyersDesk_ExceedLimit_Larger										= "larger";

	// Purchase Order Settings
	final static String	PurchaseOrder_Yes													= "Yes";
	final static String	PurchaseOrder_No													= "No";
	final static String	PurchaseOrder_ExceedLimit_Smaller									= "smaller";
	final static String	PurchaseOrder_ExceedLimit_Larger									= "larger";

	// Purchase Cost Booking Settings
	final static String	CostBooking_Yes														= "Yes";
	final static String	CostBooking_No														= "No";

	// Purchase MasterData_Cost Booking Settings
	final static String	MasterData_CostBooking_Yes											= "Yes";
	final static String	MasterData_CostBooking_No											= "No";
	final static String	MasterData_CostBooking_Never										= "Never";
	final static String	MasterData_CostBooking_Always										= "Always";
	final static String	MasterData_CostBooking_LetUsersDecide								= "Let users decide";

	// Purchase MasterData_Control Settings
	final static String	MasterData_Control_Yes												= "Yes";
	final static String	MasterData_Control_No												= "No";

	// Purchase Workflow Settings
	final static String	Workflow_Block														= "Block";
	final static String	Workflow_Warning													= "Display warning";

	// warehouse attributes
	final static String	Warehouse_Company													= "Warehouse_Company";
	final static String	Warehouse_BU														= "Warehouse_BU";
	// adhoc approver attributes
	final static String	Adhoc_Approver														= "adhoc_approver";
	final static String	Changed_Approver													= "changed_approver";

	final static String	Item_Sub_Total_Price												= "Item Sub-total Price";
	final static String	PCARD_SUPPLIER														= "pCardSupplier";

	// additional catalog status

	final static String	Not_Available														= "N/A";

	// files for upload in Ecatalog

	final static String	ECATALOG_1245														= ConfigProperty.getConfig("ECATALOG_1245");
	final static String	ECATALOG_1223														= ConfigProperty.getConfig("ECATALOG_1223");
	final static String	ECATALOG_1222														= ConfigProperty.getConfig("ECATALOG_1222");
	final static String	ECATALOG_1219														= ConfigProperty.getConfig("ECATALOG_1219");
	final static String	ECATALOG_1217														= ConfigProperty.getConfig("ECATALOG_1217");

	// Line number error
	final static String	Line_No_cannot_be_empty												= "Line No. cannot be empty";

	// Third approver
	final static String	Third_Approver														= "Third_Approver";
	final static String	Fourth_Approver														= "Fourth_Approver";

	String				disableMe															= "disableMe";
	// audit trail message
	String				Items_Ready_For_Approval											= PropertyReader.messageProperty.getProperty("Items_Ready_For_Approval");

	//item status
	final static String	In_Progress_Status													= "In Progress";

	// file upload in ECatalog
	final static String	multiple_items_without_supplier_in_item_master						= ConfigProperty.getConfig("multiple_items_without_supplier_in_item_master");
	final static String	supplier_scope														= ConfigProperty.getConfig("supplier_scope");
	final static String	item_supplier_scope_with_blank_item_details							= ConfigProperty.getConfig("item_supplier_scope_with_blank_item_details");
	final static String	duplicate_supplier_part_id											= ConfigProperty.getConfig("duplicate_supplier_part_id");
	final static String	missing_short_description											= ConfigProperty.getConfig("missing_short_description");
	final static String	short_description_length_exceeded									= ConfigProperty.getConfig("short_description_length_exceeded");
	final static String	manufacturer_name_valid												= ConfigProperty.getConfig("manufacturer_name_valid");
	final static String	manufacturer_name_invalid											= ConfigProperty.getConfig("manufacturer_name_invalid");
	final static String	unit_of_measure_invalid												= ConfigProperty.getConfig("unit_of_measure_invalid");
	final static String	item_description_length_exceeded									= ConfigProperty.getConfig("item_description_length_exceeded");
	final static String	item_description_valid												= ConfigProperty.getConfig("item_description_valid");
	final static String	currency_missing													= ConfigProperty.getConfig("currency_missing");
	final static String	short_description_valid												= ConfigProperty.getConfig("short_description_valid");
	final static String	missing_unit_of_measure												= ConfigProperty.getConfig("missing_unit_of_measure");
	final static String	currency_invalid_inactive											= ConfigProperty.getConfig("currency_invalid_inactive");
	final static String	manufacture_part_id_length_exceeded									= ConfigProperty.getConfig("manufacture_part_id_length_exceeded");
	final static String	manufacture_part_id_valid											= ConfigProperty.getConfig("manufacture_part_id_valid");
	final static String	product_category_length_exceeded									= ConfigProperty.getConfig("product_category_length_exceeded");
	final static String	inactive_currency													= ConfigProperty.getConfig("inactive_currency");
	final static String	missing_product_category											= ConfigProperty.getConfig("missing_product_category");
	final static String	unit_price_alphanumeric												= ConfigProperty.getConfig("unit_price_alphanumeric");
	final static String	missing_erp_part_no_supplier_details								= ConfigProperty.getConfig("missing_erp_part_no_supplier_details");
	final static String	invalid_supplier_id													= ConfigProperty.getConfig("invalid_supplier_id");
	final static String	missing_supplier_id													= ConfigProperty.getConfig("missing_supplier_id");
	final static String	internal_lead_time_alphanumeric										= ConfigProperty.getConfig("internal_lead_time_alphanumeric");

	// updated supplier price

	final static Double	Updated_Price_Supplier												= 100.20;

	// file error messages

	final static String	Mandatory_File_Missing												= ConfigProperty.getConfig("Please fix the errors in the items to continue");

	// testData for product URL

	final static String	PRODUCT_URL															= "www.google.com";

	final static String	USD																	= "USD";
	final static String	INR																	= "INR";
	// return note messages
	static String		SELECT_AN_ITEM_ALERT_MESSAGE										= PropertyReader.messageProperty.getProperty("SELECT_AN_ITEM_ALERT_MESSAGE");
	static String		RTURN_NOTE_FINALIZE_ALERT_MESSAGE									= PropertyReader.messageProperty.getProperty("RTURN_NOTE_FINALIZE_ALERT_MESSAGE");
	static String		RETURN_NOTE_NUMBER_ALREADY_IN_USE									= PropertyReader.messageProperty.getProperty("RETURN_NOTE_NUMBER_ALREADY_IN_USE");
	static String		RN_FINALIZE_WITH_NOTIFY_SUPPLIER									= PropertyReader.messageProperty.getProperty("RN_FINALIZE_WITH_NOTIFY_SUPPLIER");

	//Product Category
	final static String	PRODUCT_CATEGORY													= "PRODUCT_CATEGORY";

	final static String	EMPTY_STRING														= "";

	final static String	PO_Search_Item														= "PO_Search_Item";

	//audit trail messages
	final static String	ORDER_RELEASED														= "Order released";
	final static String	ORDER_APPROVED														= "Order approved";
	final static String	ORDER_SUBMITTED														= "Order submitted";

	//AUDIT TRAIL ROLES
	final static String	SYSTEM																= "System";
	final static String	BUYER																= "Buyer";

	//audit trail version
	final static String	VERSION_V1															= "v1";

	//Checkout page new address creation
	final static String	NEW_ADDRESS_STATE													= "NEW_ADDRESS_STATE";

	final static String	EACH																= "Each";

	//Requisition on behalf of another user

	final static String	USERNAME_FOR_LOGIN													= "USERNAME_FOR_LOGIN";
	final static String	USERNAME_FOR_ON_BEHALF												= "USERNAME_FOR_ON_BEHALF";

	//My address
	final static String	ADDRESS_STREET_NAME													= "Automation_Street";
	final static String	CITY_NAME															= "Automation_City";
	final static String	ADDRESS_ADDRESS_NAME												= "Automation_Address_Name";
	final static String	ZIPCODE																= "12345";

	// eForm messages
	static String		INVALID_EFORM_NAME													= PropertyReader.messageProperty.getProperty("Invalid_eForm_Name_Error");
	static String		INVALID_EFORM_DISPLAY_NAME											= PropertyReader.messageProperty.getProperty("Invalid_eForm_DisplayName_Error");
	static String		BLANK_SCOPE_ERROR													= PropertyReader.messageProperty.getProperty("Blank_eForm_Scope_Error");
	static String		BLANK_SECTIONNAME_ERROR												= PropertyReader.messageProperty.getProperty("Blank_eForm_SectionName_Error");
	static String		INVALID_FILE_TYPE_ERROR												= PropertyReader.messageProperty.getProperty("Invalid_File_Type");
}
