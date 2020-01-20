package eProc.productUtilities.constants;

import framework.utilities.GlobalVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static List<String>			passedCases															= new ArrayList<String>();
    public static List<String>			failedCases															= new ArrayList<String>();
    public static List<String>			totalCases															= new ArrayList<String>();
    public static List<String> skippedCases														            = new ArrayList<String>();
    public static Map<String, String>	testCaseMapping														= new HashMap<String, String>();
    public static Map<String, String>	testCaseStatus														= new HashMap<String, String>();
    public static Map<String, String> profileConfig														    = new HashMap<String, String>();

    public static String				BUYER																= "Buyer";
    public static String				CURRENCY_USD														= "USD";
    public static String				CatalogItem															= "CatalogItem";
    public static String				GuidedItem															= "Guideditem";

    // purchaseOrder Actions;
    public static String				SUBMIT_PO_FOR_PROCESSING											= "SUBMIT_PO_FOR_PROCESSING";
    public static String				SAVE_PO_AS_DRAFT													= "SAVE_PO_AS_DRAFT";

    // Guided Item constants;
    public static String				GUIDED_ITEM_GOODS													= "Goods";
    public static String				GUIDED_ITEM_SERVICES												= "Service";
    public static String				GUIDED_ITEM_RECEIVE_BY_QUANTITY										= "Quantity";
    public static String				GUIDED_ITEM_RECEIVE_BY_AMOUNT										= "Amount";
    public static String				SOURCING_STATUS_QUOTED_BY_SUPPLIER									= "Quoted by supplier";
    public static String				SOURCING_STATUS_ESTIMATED_PRICE										= "Estimated Price";
    public static String				SOURCING_STATUS_NEED_A_QUOTE										= "Need a Quote";
    public static String				nonStockItem														= "Non Stock1";

    // image upload path;
    public static String				commonPath															= "\\\\192.168.3.239/AutomationSharing/Katalon_File_Attachment/";
    public static String				AttachmentFilePath													= commonPath + GlobalVariable.SETUP + "/Catalog_Item_File_Upload_xlsx.xlsx";
    public static String				imagePath															= commonPath + GlobalVariable.SETUP + "/Camera.jpg";
    public static String				imagePath2															= commonPath + GlobalVariable.SETUP + "/Speaker.jpg";
    // Non stock item Attachments;
    public static String				NONSTOCK_ATTACHMENT_PATH											= commonPath + GlobalVariable.SETUP + "\\TextFile.txt";
    public static String				ATTACHMENT_PATH														= commonPath + GlobalVariable.SETUP + "\\validation.jpg";
    public static String				URL																	= "https://www.google.com/search?biw=1920&bih=925&tbm=isch&sa=1&ei=2D_MXJ_JFaKSvQSMx7OIBw&q=power+bank&oq=power+bank&gs_l=img.3..0j0i67j0l8.9954.12736..13183...0.0..0.181.1585.9j6......0....1..gws-wiz-img.....0..0i10.ySS2j9dm4Ww#imgrc=iQQ9mcb4nyPsRM:";
    public static String				FILE_DOWNLOAD_DIR													= "D:/Downloads";

    public static String				ATTACHMENT_FOLDER													= "//192.168.3.239//AutomationSharing//Automation_File_Attachment//Production";
    public static String				FILE_SIZE_ZERO														= commonPath + GlobalVariable.SETUP + "All_log_file.xml";
    public static String				FILE_NAME_WTIH_SPCL_CHAR											= commonPath + GlobalVariable.SETUP + "/Phone#.jpg";
    public static String				FILE_NAME_WTIH_MORE_THAN_FIFTY_CHAR									= commonPath + GlobalVariable.SETUP + "/Phone#.jpg";

    public static String				COAfilePath															= commonPath + GlobalVariable.SETUP + "/COAData.xlsx";
    public static String				BPO_ATTCHMENT_FILE_PNG												= commonPath + GlobalVariable.SETUP + "\\additem_issue2.png";
    public static String				BPO_ATTCHMENT_FILE_XLS												= commonPath + GlobalVariable.SETUP + "\\BPOFileUpload.xls";
    public static String				BPO_ATTCHMENT_FILE_PDF												= commonPath + GlobalVariable.SETUP + "\\java_tutorial.pdf";
    public static String				TEXT_FILE_PATH														= commonPath + GlobalVariable.SETUP + "\\TextFile.txt";
    public static String				PNG_FILE_PATH														= commonPath + GlobalVariable.SETUP + "\\PNGFile.png";

    // Req Status;
    public static String				REQ_STATUS_IN_PENDING												= "PENDING";
    public static String				REQ_STATUS_IN_PROCESS_IN_APPROVAL									= "In Process (In Approval)";
    public static String				REQ_STATUS_IN_PROCESS_WITH_BUYER									= "In Process (With Buyer)";
    public static String				REQ_STATUS_IN_PROCESS_ORDERING										= "PR_LIST_STATUS_ORDERING_1";
    public static String				REQ_STATUS_RELEASED_FULLY_RECEIVED									= "PR_LIST_STATUS_FULLY_RECEIVED_1";
    public static String				REQ_STATUS_RELEASED_PARTIALLY_RECEIVED								= "Released (Partially Received)";
    public static String				REQ_STATUS_RELEASED_PARTIALLY_ORDERED								= "Released (Partially Ordered)";
    public static String				REQ_STATUS_RELEASED_NOT_RECEIVED									= "Released (Not received)";
    public static String				REQ_STATUS_READY_FOR_APPROVAL										= "In Process";
    public static String				REQ_STATUS_DRAFT													= "Draft";
    public static String				REQ_STATUS_IN_PROCESS_SENT_FOR_QUOTE								= "In Process (Sent for quote)";

    public static String				REQ_STATUS_IN_PROCESS_RFA											= "In Process (Ready for Approval)";

    public static String				REQ_STATUS_IN_PROCESS												= "In Process";

    public static String				REQ_STATUS_REJECTED													= "Rejected";

    public static String				REQ_STATUS_RELEASED													= "Released";

    // Purchase Order Status;
    public static String				PO_STATUS_DELIVERY_FULLY_RECEIVED									= "Delivery (Fully received)";
    public static String				PO_STATUS_DRAFT														= "Draft";

    // Request Additional Details Fields;
    public static String				MARKET_PRICE														= "Market Price";
    public static String				PRODUCT_URL															= "Product Url";
    public static String				DELIVERY_LEAD_TIME													= "Delivery Lead Time";
    public static String				DAYS																= "Days";
    public static String				SPECIFICATIONS_NAME													= "Specifications Name";
    public static String				SPECIFICATIONS														= "Specifications";
    public static String				SPECIFICATION														= "Specification";
    public static String				SPECIFICATION_DETAIL												= "Specification details";
    public static String				ADD_ATTACHMENTS														= "Add Attachments";

    // Dropdown selection methods;
    public static String				SELECT_BY_VALUE														= "SELECT_BY_VALUE";
    public static String				SELECT_BY_INDEX														= "SELECT_BY_INDEX";
    public static String				SELECT_BY_VISIBLE_TEXT												= "SELECT_BY_VISIBLE_TEXT";
    public static String				SELECT_BY_PARTIAL_VISIBLE_TEXT										= "SELECT_BY_PARTIAL_VISIBLE_TEXT";

    public static String				SCREENSHOT_PATH														= "Screenshots/";
    public static String				TEMP_SCREENSHOT														= "tempScreenshot/";
    public static String				PASSED_SCREENSHOT													= "";

    // item;
    public static String				ITEM_TYPE_NONSTOCK													= "Non Stock";
    public static String				ITEM_TYPE_STOCK														= "Stock";

    public static String				ITEM_TYPE_VIRTUAL													= "Virtual";
    public static String				ITEM_TYPE_GUIDED_ITEM												= "Guided Item";
    public static String				ITEM_TYPE_CATALOG_ITEM												= "Catalog Item";

    // Image Upload Add Item;
    public static String				ITEM_IMAGE_LABEL													= "FlowOR/Requisition/GuidedItem/Add Non Stock Item Details/Item Image Label";
    public static String				IMAGE_UPLOAD_BUTTON													= "FlowOR/Requisition/GuidedItem/Add Non Stock Item Details/Image Upload button";
    public static String				IMAGE_DELETE_BUTTON													= "FlowOR/Requisition/GuidedItem/Add Non Stock Item Details/Image Delete button";

    // add item to cart / basket;
    public static String				ADD_TO_CART															= "Add_to_cart";
    public static String				ADD_TO_BASKET														= "Add_to_basket";

    public static String				VIRTUAL_ITEM														= "VirtualItem";
    public static String				NON_STOCK_ITEM														= "NonStockItem";
    public static String				CLICK_ON_ADD														= "AddButton";

    public static String				SUBMIT_RETURN_NOTE													= "Submit_Return_Note";
    public static String				SUBMIT_RECEIPT														= "Submit_Receipt";
    public static String				NONE																= "None";
    public static String				SUBMIT																= "Submit";
    public static String				SAVE_AS_DRAFT														= "Save_As_Draft";
    public static String				CANCEL																= "Cancel";
    public static String				REVIEW_PO															= "Review PO";
    public static String				NEXT																= "Next";

    public static String				PO_STATUS_RELEASED													= "Released";
    public static String				PO_STATUS_CLOSED													= "Closed";
    public static String				PO_STATUS_RFA														= "Ready for approval";
    public static String				PO_STATUS_IN_APPROVAL												= "In Approval";


    // public static String REQUEST_ADDITIONAL_ITEMS_MESSAGE = "You will now be
    // taken to the checkout screen where you can add new items to your
    // requisition. To add new items without deleting existing items in your
    // shopping cart click Keep items as it is or click Delete items in cart to
    // delete existing items or click Create a draft requisition to create a
    // draft requisition for existing items in the cart.";
    public static String				REQUEST_ADDITIONAL_ITEMS_MESSAGE									= "Proceeding to checkout screen where you can add new items to your requisition.";

    public static String				REQUISITION_STATUS_REJECTED											= "Rejected";

    public static String				WORKFLOW_ALERT_MESSAGE												= "Workflows/Approvers have not been selected for some nodes in the workflow. Please select and then submit the requisition.";
    public static String				MODIFY_REQ_CONFIRMATION_MSG											= "Are you sure you want to modify this group?";
    public static String				SELCTED_WORKFLOW_ALERT												= "Workflows/Approvers can be selected in the next step after clicking the Next button.";
    public static String				RFA_INFO_ALERT_MSG													= "Your requisition (/S+) is ready for processing. Select the approvers and submit the requisition. Taking you there";
    public static String				APPROVER_SELECTOR_NODE												= "Approver selector";
    public static String				CHANGE_APPROVER														= "Change Approver";
    public static String				SELECT_APPROVER														= "Select Approver";
    public static String				ADHOC_APPROVER_NODE													= "Ad-hoc Approver";

    public static String				SHIP_TO_DEFAULT_ADDRESS												= "Ship to default address";
    public static String				SHIP_TO_ANOTHER_ADDRESS												= "Ship to another address";

    public static String				REQ_NEED_A_QUOTE_CONFIRMATION_MSG									= "Need a quote' Items, will go for buyer updates and then requisition will be returned to requester.";

    public static String				REQUISITION_STATUS_RETURNED											= "Returned for amendment";

    public static String				GUIDED_ITEM_DETAILS_MODAL_DONE										= "Done";

    public static String				SETTLEMENT_VIA_INVOICE												= "Invoice";
    public static String				SETTLEMENT_VIA_DISBURSMENT											= "Disbursment";
    public static String				SETTLEMENT_VIA_USER_PCard											= "PCard";

    public static String				DEFAULT_ROLE														= "Trina role";
    // public static String ADHOC_APPROVER_ROLE ="Automation_AdhocApproverRole";
    public static String				ADHOC_APPROVER_ROLE													= "AutoX_Missing_AdhocApproverRole";
    public static String				PRODUCT																= "eProc";
    public static String				CREATE_RECEIPT_ROLE													= "";
    public static String				CREATE_NEW_ADDRESS_ROLE												= "";
    public static String				VIEW_ALL_REQ_IN_SCOPE												= "";
    public static String				VIEW_ORDERS_IN_SCOPE												= "";
    public static String				VIEW_MY_ORDERS														= "";
    public static String				COMPARE_ITEM_ROLE													= "";
    public static String				CREATE_VIEW_RETURN_NOTE												= "";
    public static String				CHANGE_APPROVER_ROLE												= "";
    public static String				ACCESS_REQUISITON_ROLE												= "";
    public static String				DATA_ACCESS_ROLE													= "";
    public static String				ITEM_ROLE															= "guided access";

    public static String				FILE_NAME_MORE_THAN_FIFTY_CHAR_ERROR								= "File name cannot be of more than 50 characters";
    public static String				ITEM_DETAILS_MODAL_DONE												= "Done";
    public static String				CREATE_NEW_ADDRESS													= "CreateNewAddress";
    public static String				BOTH																= "Both";
    public static String				APPROVED_STATUS														= "Approved";
    public static String				REJECTED_STATUS														= "Rejected";
    public static String				DELEGATED_STATUS													= "Delegated";

    public static String				EMPTY_CART_MSG														= "Your cart is empty";

    public static String				YES_SEND_FOR_APPROVAL												= "Yes Send For Approval";
    public static String				NO_RETURN_TO_ME														= "No Return To Me";

    public static String				COPY_PO_INACTIVE_CBL_MSG											= "OU/CC/Budget, etc. is no longer part of your purchasing scope.Click Here to view the errors. Please modify the purchase order and re-submit with new values.";
    public static String				COPY_PO_INACTIVE_CBL_ALERT_MSG										= "Some master data or default values in your profile have been changed/removed. Please see the errors below:";
    public static String				COPY_PO_UNAUTHORIZED_LOCATION_ADDRESS								= "";

    public static String				COPY_PO_INACTIVE_CBL_ADMIN_MSG										= "Please select another value or contact your administrator.";

    public static String				USE_PURCHASE_TYPE_TO_CLASSIFY_PURCHASES_YES							= "Yes";
    public static String				USE_PURCHASE_TYPE_TO_CLASSIFY_PURCHASES_NO							= "No";

    public static String				COA_PLANT															= "Plant";
    public static String				COA_STORAGE_LOCATION												= "Storage Location";
    public static String				COA_ACCOUNT_ASSIGNMENT												= "Account Assignment";

    public static String				PO_Release_Date														= "Release Date";
    public static String				PO_Delivery_Date													= "Delivery Date";
    public static String				PAIR																= "Pair";
    public static String				EXCHANGE_RATE_VALUE													= "1.2879";
    public static String				INVALID_EXCHANGE_RATE_MSG											= "Invalid base exchange rate";
    public static String				ITEM_WARNING_MESSAGE												= "This item category is not assigned to your profile";
    public static String				USER																= "User";
    public static String				PRODUCT_CATEGORY													= "Corporate Gifts - Opex";

    public static String				SPO_BREADCRUMB														= "Home -> PO -> Create PO";
    public static String				CREATE_SPO_HEADING													= "Purchase Order";

    public static String				BUYER_REVIEW_WARNING_MESSAGE										= "Request in progress";

    // BPO page constants;
    public static String				ACCEPT_INVOICE_UNTIL_ERROR_MSG										= "Invoice until date must be greater than current date";
    public static String				ERROR_MESSAGE_VALIDITY_TO											= "Validity to date must be greater than current date";
    public static String				ERROR_MESSAGE_VALIDITY_FROM											= "Validity from date must be greater than current date";

    public static String				FORMAT_DATE_BY_MM_DD_YYYY											= "MM/dd/yyyy";
    public static String				ERROR_MESSAGE_PO_NUMBER												= "Please Enter Purchase Order Number";

    // public static String
    public static String				ALL_SPECIAL_CHARACTER												= "`~@#$%^&*()_-=+[]{}|.,<>/?;:\"'{}";

    public static String				BPO_ERROR_MESSAGE													= "Please Enter Supplier!Please Enter Address!Please Enter Payment terms!Please Enter Delivery terms!Please Enter Currency!Please select buyer";

    public static String				BPO_UPLOADED_FILE_NAME												= "java_tutorial.pdf!BPOFileUpload.xls!additem_issue2.png";

    public static String				FILTER_BY_STATUS													= "Status";
    public static String				FILTER_TYPE_BLANKET													= "Blanket";
    public static String				FILTER_TYPE_RELEASE													= "Release";
    public static String				FILTER_STATUS_RELEASED												= "Released";
    public static String				FILTER_STATUS_CLOSED												= "Closed";
    public static String				ORDER_VALUE_ERROR_MESSAGE											= "Order value cannot be less than order total";

    public static String				AMEND_PO_PURCHASE_ORDER_CHANGE_COMMENT_ERROR_MSG					= "Please Enter Purchase Order Change Comments";
    public static String				ORDER_DESCRIPTION_ERROR_MESSAGE										= "Please Enter Order Description";

    public static String				ACTION_AMEND_PO														= "Amend PO";
    public static String				BUYER_ERROR_MESSAGE													= "Please select buyer";
    public static String				BPO_ATTCHMENT_FILE_PNG_NAME											= "additem_issue2.png";

    // public static String AUTO_RELEASE_CONFIRMATION_MESSAGE="For an Auto
    // Release PO, Catalog Item will be converted to Free Text Items when adding
    // them to cart. Do you wish to proceed?";
    public static String				AUTO_RELEASE_CONFIRMATION_MESSAGE									= "For Auto Release PO, Catalog Item will be converted to Free Text Items in cart. Are you sure you want to continue?";
    public static String				AUTO_RELEASE_SCHEDULE_TOOLTIP										= "You can create Release Schedules under the section 'Release PO Details'";
    public static String				AUTO_RELEASE_SCHEDULE_ITEMlEVEL_MESSAGE								= "Auto release schedule for BPO will remove all information provided in the 'Items' section. Are you sure you want to continue?";
    public static String				VALIDITY_DATE_ERROR_MSG												= "Define the validity of the BPO";

    public static String				PO_INACTIVE_PURCHASE_TYPE_ERROR										= "Invalid Purchase Type";

    public static String				DISPLAY_ASSET_CODE_YES												= "Yes";
    public static String				DISPLAY_ASSET_CODE_NO												= "No";

    public static String				SPO_LINE_ITEM_COLUMN_NAMES											= "Line Number,Item Number,Item Name,Reference Contract,Category,Market Price,Ordered Qty/Amt,Taxes,Total Price";

    public static String				BASKET_NAME															= "Automation_Basket_" + System.currentTimeMillis();

    public static String				PREVENT_SELECTING_SUPPLIERS_NOT_EXTENDED_TO_ORDERING_LOCATION_YES	= "Yes";
    public static String				PREVENT_SELECTING_SUPPLIERS_NOT_EXTENDED_TO_ORDERING_LOCATION_NO	= "NO";
    public static String				AUTOMATION_CATEGORY_ITEM											= "Speaker";
    public static String				STATUS_PENDING														= "Pending";
    public static String				STATUS_DELEGATED													= "Delegated";
    public static String				DELEGATE_PO_INFO_TEXT												= "Delegate";																																																												// "Since
    // requests
    // cannot
    // be
    // delegated
    // back
    // to
    // the
    // initiator/creator,
    // initiators/creators
    // of
    // the
    // selected
    // requests
    // will
    // not
    // be
    // displayed
    // below.";

    public static String				STANDARD_PO															= "Standard PO";
    public static String				BLANKET_PO															= "Blanket PO";

    public static String				ORDER_VALUE_ERROR_MSG												= "Please enter an order value";
    public static String				FORMAT_DATE_BY_DD_MM_YYYY											= "dd/MM/yyyy";

    public static String				ACTIVE_STATUS														= "Active";
    public static String				INACTIVE_STATUS														= "Inactive";

    public static String				PO_INACTIVE_BUYER_MSG												= "User(s) (\\S+) have been disabled";
    public static String				EXCEED_AMOUNT_ERROR_MESAGE											= "Sum of all Release Total amounts cannot exceed the BPO Order Value'";
    public static String				PREVIEW_AND_EDIT_SCHEDULED_RELEASE									= "Preview and Edit scheduled releases";
    public static String				RELEASE_PO_DETAILS_ERROR_MSG										= "Please define atleast one release schedule definition";

    public static String				DUPLICATE_PO_NUMBER_MSG												= "PO Number Already in use.";

    public static String				RFA_STATUS															= "Ready for approval";
    public static String				BLANK_PO_NUMBER_ERROR												= "Please Enter Purchase Order Number";
    public static String				BLANK_PO_DECRIPTION_ERROR											= "Please Enter Order Description";
    public static String				BLANK_PO_CURRENCY_ERROR												= "Please Enter Currency";

    public static String				PO_ALREADY_SUBMITTED_MSG											= "PO - Already Submitted";

    public static String				COA_FORM_COLUMN_NAMES												= "Plant,Storage Location,Account Assignment,GL Account,Cost Center,WBS/ Projects,Internal Order/Recoverable Account,Profit Center,Budget ID,Percentage,public Amount,Action";
    public static String				ASSET_NUMBER														= "Asset Number *";
    public static String				MANUFACTURER_SERIAL_NUMBER											= "Manufacturer serial number";
    public static String				NOTES																= "Notes";

    // public static String COA_FORM_COLUMN_NAMES = "Plant,Storage
    // Location,Account Assignment,GL Account,Cost Center,WBS/ Projects,Internal
    // Order/Recoverable Account,Profit Center,Budget ID,Percentage,public
    // Amount,Action";
    public static String				DELEGATE_ERROR_MESSAGE												= "An action has already been taken by another user on the document which was being viewed by you";
    public static String				RECALLED_PO_DELEGATION_ERROR_MESSAGE								= "Error while taking action on Purchase Order/s Automation_spo_541557261. Request is already recalled by initiator";
    public static String				DELEGATE															= "Delegate";

    public static String				BPO_ORDER_VALUE_EXCEEDING_ERROR_MESSAGE								= "Value of all releases exceeds BPO order value";
    public static String				BPO_DIFFERENT_CATEGORY_ERROR_MESSAGE								= "Item does not belong to actual blanket order item Category or Receive/Bill by.";
    public static String				BPO_ITEM_TOTAL_ACROSS_RELEASE_EXCEEDED_ERROR_MESSAGE				= "Item line no. {lineNo} has exceeded its allowed price.";
    public static String				RECEIPT_CREATION_RULE_HEADER										= "header level";
    public static String				RECEIPT_CREATION_RULE_DEFAULT										= "default";
    public static String				BPO_TYPE															= "Blanket PO";

    public static String				FAVORITES_AND_PREVIOUSLY_USED_TAB									= "Favorites &amp; Previously Used";
    public static String				CATALOGS_TAB														= "Catalogs";
    public static String				CATEGORIES_TAB														= "Categories";
    public static String				CREATE_PO_ROLE														= "Autox_PO_Test";

    public static String				APPROVER_WORKFLOW_NODE												= "Reporting Manager";

    public static String				BUYER_WORKFLOW_NODE													= "Buyer";

    public static String				PO_STATUS_CANCELLED													= "Cancelled";

    public static String				REQ_STATUS_IN_PROCESS_PENDING										= "In Process (Pending Order)";

    public static String				ITEM_STATUS_PENDING													= "Pending Order";

    public static String				REQ_APPROVED														= "Approved";

    public static String				ADHOC_APPROVER														= "Adhoc approver";

    public static String				CANCELLED_STATUS													= "Cancelled";
    public static String				AUTO_GENERATED_COMMENT												= "This is an auto generated comment";
    public static String				CLOSE_PO_LINK														= "Close";
    public static String				COST_BOOKING_DETAILS_LINK											= "Cost Booking Details";

    public static String				BILLING_INFORMATION_TAB												= "Billing Information";
    public static String				SUPPLIER_INFORMATION_TAB											= "Supplier Details";
    public static String				BUYER_AND_OTHER_INFORMATION_TAB										= "Buyer And Other Information";
    public static String				ADD_ATTACHMENTS_TAB_BPO												= "Add Attachments";
    public static String				SHIPPING_DETAILS_TAB												= "Shipping Details";
    public static String				CONTROL_SETTINGS_TAB												= "Control Settings";
    public static String				LINE_ITEMS_TAB														= "Line Items";
    public static String				TAXES_TAB															= "Taxes";
    public static String				AGREEMENT_DETAILS_TAB												= "Agreement Details";
    public static String				VALIDITY_TAB														= "Validity";
    public static String				SETTINGS_TAB														= "Settings";
    public static String				WORKFLOW_TAB														= "Workflow";
    public static String				BASIC_DETAILS_TAB_VIEW_BPO											= "Basic Details";
    public static String				BILLING_AND_ORGANIZATION_UNITS_INFORMATION_TAB						= "Billing and Organization Units Information";
    public static String				SUPPLIER_INFORMATION_TAB_VIEW_BPO									= "Supplier Details";
    public static String				BUYER_AND_OTHER_INFORMATION_TAB_VIEW_BPO							= "Buyer And Other Information";
    public static String				ADD_ATTACHMENTS_TAB_VIEW_BPO										= "Attachments";
    public static String				SHIPPING_DETAILS_TAB_VIEW_BPO										= "Shipping Details";
    public static String				CONTROL_SETTINGS_TAB_VIEW_BPO										= "Control Settings";
    public static String				LINE_ITEMS_TAB_VIEW_BPO												= "Line Items";
    public static String				TAX_DETAILS_TAB														= "Tax Details";
    public static String				PAYMENT_AND_CREDITS_TAB												= "Payments & Credits";
    public static String				AGREEMENT_DETAILS_TAB_VIEW_BPO										= "Agreement Details";
    public static String				SETTINGS_TAB_VIEW_BPO												= "Settings";
    public static String				TERMS_AND_NOTES_TAB													= "Terms & Notes";
    public static String				WORKFLOW_TAB_VIEW_BPO												= "Workflow";
    public static String				COST_BOOKING_DETAILS_TAB_COA										= "Cost Booking Details";

    public static String				COA_FORM_HEADING_QUANTITY_LABEL										= "Quantity / Amount";
    public static String				BASIC_DETAILS_TAB													= "Basic Details";
    public static String				ADDITIONAL_DETAILS_TAB												= "Additional Details";
    public static String				CONTRACT_NO															= "Contract No";
    public static String				ITEM_TYPE															= "Item Type";
    public static String				UNIT_PRICE															= "Unit Price";
    public static String				SOURCING_STATUS														= "Sourcing Status";
    public static String				RECEIVE_BY															= "MST_Receive By";
    public static String				REQUISITION															= "Requisition";
    public static String				MY_ORDERS_TAB														= "My Orders";
    public static String				LINE_ITEMS_DETAILS_TAB												= "Item Details";

    public static int					SPLIT_PERCENTAGE													= 100;
    public static String				MY_REQUISITIONS_TAB													= "My Requisitions";
    public static String				MY_PURCHASE_ORDERS													= "My Purchase Orders";
    public static String				FAVORITES_TAB														= "Favorites";
    public static String				PREVIOUSLY_USED_TAB													= "Previously Used";
    public static String				ACTIVITY_TAB														= "Activity";
    public static String				DISCUSSION_MESSAGE													= "Automation_Message";
    public static String				DETAILS_TAB															= "DETAILS";
    public static String				COLLABORATOR_NAME													= "Automation.Admin";
    public static String				COST_ALLOCATION														= "Cost allocation";
    public static String				ITEMS_TAB_VIEW_RETURN_NOTE_PAGE										= "Items";
    public static String				RETURN_NOTE_DETAILS_TAB_VIEW_RETURN_NOTE_PAGE						= "Return Note Details";
    public static String				ORDERED_ITEMS_TAB													= "Ordered Items";
    public static String				RETURN_NOTE															= "Return Note";
    public static String				DELIVERY_DETAILS													= "Delivery Details";

    public static String				YES																	= "Yes";
    public static String				NO																	= "No";
    public static String				ASSET_CODE															= "Asset Code";
    public static String				NA																	= "NA";

    public static String				NO_TAXES_ADDED_MESSAGE												= "Please select Taxes";
    public static String				BASKETS_TAB															= "Basket";
    public static String				DELIVERY_LEAD_TIME_LABEL											= "Delivery Lead time - Days";
    public static String				PRODUCT_URL_LABEL													= "Product URL";
    public static String				MANUFACTURER_URL_LABEL												= "Manufacturer URL";
    public static String				PART_NUMBER_LABEL													= "Part Number";
    public static String				RECEIVE_BY_LABEL													= "MST_Receive By";

    public static String				BUSINESS_UNIT														= "Business Unit";
    public static String				SRNO_COLUMN															= "Sr No.";
    public static String				ITEM_NUMBER_COLUMN													= "Item Number";
    public static String				ITEM_NAME_COLUMN													= "Item Name";
    public static String				REFERENCE_CONTRACT_COLUMN											= "Reference Contract";
    public static String				DESCRIPTION_COLUMN													= "Description";
    public static String				MARKET_PRICE_COLUMN													= "Market Price";
    public static String				QUANTITY_AMOUNT_COLUMN												= ""
            + " / Amount";
    public static String				ITEM_SUBTOTAL_PRICE_COLUMN											= "Item Sub-total Price";

    public static String				COPY_ACTION															= "Copy";

    public static String				BUYER_REVIEW_REQUIRED_INFO											= "If set to \"Yes\", you can suggest multiple suppliers to the buyer and requisition will wait on buyer's desk. If set to \"No\", you can only select a single supplier.";

    public static String				ITEM_LEVEL_COLUMNS_CHECKOUT_PAGE									= "Sr.No,Deliver to *,Address (Location),Delivery date/duration,Qty/Amt *,Total Price";
    public static String				COMPANY_SCOPE_ERROR_MESSSAGE_TEXT									= "Company";
    public static String				BUSINESS_SCOPE_UNIT_ERROR_MESSSAGE_TEXT								= "Business unit";
    public static String				LOCATION_SCOPE_ERROR_MESSSAGE_TEXT									= "Location";
    public static String				ADDRESS_SCOPE_ERROR_MESSSAGE_TEXT									= "Addresses";
    public static String				PURCHASE_TYPE_SCOPE_ERROR_MESSSAGE_TEXT								= "Purchase Type";
    public static String				COST_CENTER_SCOPE_ERROR_MESSSAGE_TEXT								= "Cost center";
    public static String				GL_ACCOUNT_SCOPE_ERROR_MESSSAGE_TEXT								= "GL Account";
    public static String				SUBPROCESS_NODE														= "Sub Process";

    public static String				SUPPLIER_POPUP_SUPPLIER_NAME_LABEL									= "Supplier name";
    public static String				SUPPLIER_POPUP_ADDRESS_LABEL										= "Address";
    public static String				SUPPLIER_POPUP_SUPPLIER_CONTACT_NAME_LABEL							= "Supplier contact name";
    public static String				SUPPLIER_POPUP_SUPPLIER_CONTACT_EMAIL_ID_LABEL						= "Supplier contact Email ID";
    public static String				SUPPLIER_POPUP_SUPPLIER_CONTACT_PHONE_LABEL							= "Supplier contact phone";
    public static String				SUPPLIER_POPUP_OTHER_DETAILS_LABEL									= "More";
    public static String				UNCONFIRMED															= "Unconfirmed";

    public static String				AMEND_PO_COMMENTS_SECTION											= "Comments";

    public static String				DELEGATE_SUCCESS_MESSGAE											= "Action Successful";

    public static String				WEB_LINK															= "Web Link";
    public static String				RELEASE_ORDER_TAB													= "";
    public static String				REMINDE_SUCCESS_MESSAGE												= "";

    public static String DOC_TYPE_PO = "Purchase Order";
}
