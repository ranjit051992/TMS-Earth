package eProc.pages.checkout;

import eProc.productUtilities.constants.Constants;

public interface ICheckout
{
    String BASIC_DETAILS = "FlowOR/Requisition/Basic Details/link_Basic details";
    String REQUISITION_NAME = "//eproc-req-basic-detail//input[contains(@class,'serviceDefaultName')]";
    String ON_BEHALF_OF = "FlowOR/Requisition/Basic Details/input_on Behalf Of";
    String FIRST_ONBEHALF_VALUE = "FlowOR/Requisition/Basic Details/select First On Behalf User";

    //Buying Unit;
    String BUYING_UNIT = "FlowOR/Requisition/Basic Details/Buying Unit/header level_Edit";
    String COMPANY_NAME = "FlowOR/Requisition/Basic Details/Buying Unit/input_Company";
    String COMPANY_FIRST_OPTION = "FlowOR/Requisition/Basic Details/Buying Unit/selectFirstOption";
    String BUSINESS_UNIT = "FlowOR/Requisition/Basic Details/Buying Unit/input_Business Unit";
    String BUSINESS_FIRST_OPTION = "FlowOR/Requisition/Basic Details/Buying Unit/selectFirstOption";
    String LOCATION = "FlowOR/Requisition/Basic Details/Buying Unit/input_Location";
    String LOCATION_FIRST_OPTION = "FlowOR/Requisition/Basic Details/Buying Unit/selectFirstOption";
    String CURRENCY = "FlowOR/Requisition/Basic Details/Buying Unit/input_Currency";
    String CURRENCY_FIRST_OPTION = "FlowOR/Requisition/Basic Details/Buying Unit/selectFirstOption";
    String BUYING_UNIT_DONE_BUTTON = "FlowOR/Requisition/Basic Details/Buying Unit/button_Save Buying Unit Details";

    //Additional Details;
    String ADDITIONAL_DETAILS_LINK = "FlowOR/Requisition/Additional Details/link_ additional details";
    String PURCHASE_TYPE ="FlowOR/Requisition/Additional Details/select_ purchase type";
    String SELECT_SETTLEMENT_VIA = "FlowOR/Requisition/Additional Details/select_settlement Via";
    String SETTLEMENT_VIA_INVOICE = "FlowOR/Requisition/Additional Details/select_Settlement via _Invoice";
    String SETTLEMENT_VIA_DISBURSMENT = "FlowOR/Requisition/Additional Details/select_settlement_via_Disbursement";
    String SETTLEMENT_VIA_USER_PCARD = "FlowOR/Requisition/Additional Details/select via User P-card";
    String INPUT_USER_P_CARD = "FlowOR/Requisition/Additional Details/input_User P Card";
    String PCARD = "FlowOR/Requisition/Additional Details/div_P Card Dropdown";
    String PURCHASE_ORDER_TABLE = "FlowOR/Requisition/Additional Details/table_Purchase Order";
    String SELECT_PURCHASE_ORDER = "FlowOR/Requisition/Additional Details/select Purchase Order";
    String FIRST_PO_NUMBER = "FlowOR/Requisition/Additional Details/select_First Po No From PO Table";
    String PO_BUTTON_CONTINUE = "FlowOR/Requisition/Additional Details/button_Continue";
    String VIEW_LINK_PO = "FlowOR/Requisition/Additional Details/link_View Selected PO";
    String RADIO_PURCHASE_YES = "FlowOR/Requisition/Additional Details/radio_Respective Purchase Yes";
    String RADIO_SEND_PO_TO_SUPPLIE_NO_BUTTON = "FlowOR/Requisition/Additional Details/radio Button_send PO to Supplier No";
    String INPUT_ADD_ATTACHMENT_FILE = "FlowOR/Requisition/Add attachment/input_Add Attachment File";

    //Shipping Details;
    String DELIVER_TO = "FlowOR/Requisition/Shipping Details/select _ deliver to";
    String REQUIRED_BY_DATE = "FlowOR/Requisition/Shipping Details/select _required by";
    String SHIP_DEFAULT_ADDRESS = "FlowOR/Requisition/Shipping Details/radio button_ship to default address";
    String SHIP_ANOTHER_ADDRESS = "FlowOR/Requisition/Shipping Details/select Another Address";
    String FIRST_SELECTED_ADDRESS = "FlowOR/Requisition/Shipping Details/select_First Another Address";
    String DEFAULT_SHIPPING_LABEL = "FlowOR/Requisition/Shipping Details/text_Default Shipping Address";
    String SHIIPPING_DETAILS_TAB = "FlowOR/Requisition/Shipping Details/link_Shipping Details";

    //Buyer Info
    String BUYERS_TAB = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/Buyers tab";
    String BUYER_DROP_DOWN = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/BuyerDropDown";
    String BUYER_DROP_DOWN_OPTIONS = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/BuyerDropDownOptions";
    String INPUT_BUYER_TEXTBOX = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/BuyerTextbox";

    //Costbooking Tab
    String COST_BOOKING_TAB = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/Cost Booking tab";

    //Asset Tagging;
    String SHIPPING_AND_ASSET_TAGGING_PAGE = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ShippingAndAssetTaggingPage";
    String ADD_ASSET_TAG_LINK = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AddAssetTagLink";
    String ASSET_TAG_POPUP = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetTag_PopUp";
    String ADD_ASSET_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ButtonAdd";
    String ASSET_NUMBER = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetNumber";
    String MANUFACTURER_SERIAL_NUMBER = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ManufacturerSerialNumber";
    String NOTES = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Notes";
    String ASSET_NUMBER_MISSING_ERROR_MSG = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetNumberMissing_ErrorMsg";
    String DUPLICATE_ICON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Error_DuplicateIcon";
    String DUPLICATE_ERROR_MSG = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/DuplicateErrorMessage";
    String TOTAL_ASSET_TAG_ROWS = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/TotalAssetTagRows";
    String ASSET_TAG_COLOUMS_HEADING = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Header_AssetTag";
    String CLOSE_ASSET_TAG_POP_UP = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Close_Assettag_PopUp";
    String SAVE_LINE_ITEM_DETAILS_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/SaveButton";
    String CLEAR_ASSET_TAGS = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ClearAssetTag_Buttton";
    String CONFIRM_YES_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Confirm_YES_button";
    String CONFIRM_POPUP = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ClearTag_ConfirmPopUp";
    String CONFIRM_NO_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Confirm_NO_button";
    String CONFIRMATION_MESSAGE = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ClearAssetTag_ConfirmMessage";
    String BACK_ARROW = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/BackArrow";
    String ASSET_NUMBER_INFO = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetNumberMissing";
    String FETCH_ASSET_TAG_DETAILS = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetTagDetailsTable";
    String BUYERS_LINK = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/BuyersLink";
    String TAXES_LINK = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/TaxesLink";
    String ERROR_AT_SHIPPING_DETAILS_AND_ASSET_TAGGING_TAB = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ErrorAtShippingAssetDetailsTab";
    String ASSET_INFO_LOST_MSG = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Asset_Info_Lost_Msg";
    String CONFIRM_POPUP_CONTINUE_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Asset_Info_Lost_PopUp_ContinueBtn";
    String ADD_ASSET_TAG = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AddAssetTag_Button";
    String FETCH_ASSET_NUMBER = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Fetch_AssetNumber";
    String FETCH_MANUFACTURER_NO = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/FetchManufactureNo";
    String FETCH_NOTES = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/FetchNotes";
    String LINE_LEVEL_SHIPPING_DETAILS_LINK = "FlowOR/Requisition/Shipping Details/LineLevelShippingDetailslink";
    String COA_PURCHASE_TYPE = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/PurchaseType";
    //Line Items Tab;
    String LINE_ITEMS_LINK = "FlowOR/Requisition/Line Item Details/link_line item details";

    //Footer Buttons
    String I_AM_DONE_BUTTON = "FlowOR/Requisition/Footer/button_ I am done";
    String CONTINUE_BUTTON = "FlowOR/Requisition/button_continue";
   // String DDS_CONTINUE_BTN = "FlowOR/Requisition/DewDrops_Continue_Btn";
    String SAVE_AS_DRAFT = "FlowOR/Requisition/Footer/SaveAsDraftButton";
    String CANCEL_BUTTON = "FlowOR/Requisition/Footer/CancelButton";
    String SUBMIT_REQ_POPUP = "FlowOR/Requisition/Footer/SubmitReq_Popup/SubmitReqPopup";
    String SUBMIT_REQUISITION_MESSAGE = "FlowOR/Requisition/Footer/SubmitReq_Popup/SubmitReqMessage";
    String SUBMIT_REQUISITION_POPUP_CANCEL_BUTTON = "FlowOR/Requisition/Footer/SubmitReq_Popup/CancelButton";
    String SUBMIT_REQUISITION_POPUP_CONTINUE_BUTTON = "FlowOR/Requisition/Footer/SubmitReq_Popup/ContinueButton";

    //Urgent Requiremnet Status;
    String RADIO_URGENT_YES_BUTTON  = "FlowOR/Requisition/Basic Details/radio_Urgent Requirement Yes";
    String RADIO_URGENT_NO_BUTTON = "FlowOR/Requisition/Basic Details/radio_Urgent Requirement No";

    String VALIDATION_MESSAGE = "FlowOR/Checkout Page/Validation_Error_Msg_for_Deactivate_masterData";
    String SHIP_TO_ANOTHER_ADDRESS_RADIO_BUTTON = "Check_Out_Page/Shipping Details Tab/Radio Button Ship to another Address";
    String SHIP_TO_ANOTHER_ADDRESS_RADIO_BUTTON_INPUT_TAG = "Check_Out_Page/Shipping Details Tab/ShipToAnotherAddressRadioButtonInputTag";
    String SHIP_TO_ANOTHER_ADDRESS_TEXTAREA = "FlowOR/Requisition/Shipping Details/ShipToAnotherAddressTextarea";
    String SHIPPING_DETAILS_AND_ASSET_TAGGING = "FlowOR/Requisition/Line Item Details/cost booking details/ShippingDetailsAndAssetTaggingTab";
    String SHIPPING_DETAILS_INFO_RADIO_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShippingDetailsInfoRadioButton";
    String SHIP_ITEMS_TO_MULTIPLE_LOCATIONS_RADIO_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShipItemsToMultipleLocationsRadioButton";
    String DELIVER_TO_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/DeliverToField";
    String ADDRESS_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/AddressTextbox";
    String DELIVERY_DATE_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/DeliverDateTextbox";
    String SHIP_TO_MULTIPLE_LOCATIONS_TABLE = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShipToMultipleLocationsTable";
    String SHIP_TO_MULTIPLE_LOCATIONS_DELIVER_TO_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShipToMultipleLocationsDeliverToTextbox";
    String SHIP_TO_MULTIPLE_LOCATIONS_ADDRESS_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShipToMulipleLocationsAddressTextbox";
    String SHIP_TO_MULTIPLE_LOCATIONS_DELIVERY_DATE_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/ShipToMultipleLocationsDeliveryDateTextbox";
    String SHIPPING_AND_ASSET_TAGGING_QTY_AMT_TEXTBOX = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/QtyAmtTextbox";
    String SHIP_TO_MULTIPLE_LOCATIONS_TOTAL_PRICE = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/TotalPrice";
    String DEFAULT_SHIPPING_ADDRESS = "FlowOR/Requisition/Shipping Details/DefaultShippingAddress";
    String CREATE_NEW_ADDRESS_DROPDOWN_VALUE = "Check_Out_Page/Shipping Details Tab/CreateNewAddressDropdownValue";
    String ADDRESS_NAME_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/AddressNameTextbox";
    String STREET1_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/Street1Textbox";
    String STREET2_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/Street2Textbox";
    String COUNTRY_DROPDOWN = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/CountryDropdown";
    String CITY_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/CityTextbox";
    String CREATE_BUTTON_SHIP_TO_ANOTHER_ADDRESS_MODAL = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/CreateButton";
    String COUNTY_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/CountyTextbox";
    String POSTAL_CODE_TEXTBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/PostalCodeTextbox";
    String SAVE_FOR_NEXT_TIME_CHECKBOX = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/SaveForNextTimeCheckbox";
    String STATE_DROPDOWN = "FlowOR/Requisition/Shipping Details/CreateNewAddressModal/StateDropdown";

    String LINE_LEVEL_DETAILS_SAVE_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssetTagging/LineLevelDetailsSaveButton";
    String REASON_FOR_ORDERING_TEXTBOX = "FlowOR/Requisition/Basic Details/textarea_Reason For ordering";
    String COMMENT_FOR_SUPPLIER_TEXTBOX = "FlowOR/Requisition/Basic Details/textarea_Comment For Supplier";
    String REQUISITION_NAME_ERROR_MESSAGE = "FlowOR/Requisition/Basic Details/RequisitionNameErrorMessage";
    String PURCHASE_TYPE_ERROR_MESSAGE = "FlowOR/Requisition/Additional Details/PurchaseTypeErrorMessage";
    String PCARD_ERROR_MESSAGE = "FlowOR/Requisition/Additional Details/P-cardErrorMessage";
    String ERROR_HEADING_ON_CHECKOUT_PAGE = "FlowOR/Requisition/ErrorBlockHeading";
    String REQUIRED_BY_ERROR_MESSAGE = "FlowOR/Requisition/Shipping Details/RequiredByErrorMessage";
    String COMMENTS_TEXTAREA = "FlowOR/Requisition/Line Item Details/Comments/CommentsTextarea";
    String SHIP_TO_ANOTHER_ADDRESS_CLOSE_BUTTON = "Check_Out_Page/Shipping Details Tab/Create_new_address_popup/ShipToAnotherAddressCloseButton";
    String ERROR_POPUP_TEXT = "Check_Out_Page/ErrorPopUpText";
    String ERROR_POPUP_DISMISS_BUTTON = "Check_Out_Page/ErrorPopUpDismissButton";


    String LINE_LEVEL_ITEM_ROW = "FlowOR/Requisition/Line Item Details/ItemRowsLineItemLevel";
    String ITEM_LEVEL_ADD_ITEM_MODAL_CLOSE_BUTTON = "FlowOR/Requisition/Line Item Details/Add Line Item/AddItemDetailsModalCloseButton";
    String DELETE_CONFIRM_POPUP_YES_BUTTON = "FlowOR/Requisition/Line Item Details/DeletePopUpConfirmYesButton";
    String DELETE_CONFIRM_POPUP = "FlowOR/Requisition/Line Item Details/DeleteConfirmPopUp";

    String BUYER_DROPDOWN = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/BuyerDropDown";
    String BUYER_DROPDOWN_OPTION = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/BuyerDropDownOptions";
    String GROUP_DROPDOWN_OPTION = "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Buyers Tab/GroupOption";
    String CHECKOUT_PAGE_TAB_LIST = "FlowOR/Requisition/CheckoutPageTabs";
    //String BASIC_DETAILS_TAB = Constants.BASIC_DETAILS_TAB;
   // String ADDITIONAL_DETAILS_TAB = Constants.ADDITIONAL_DETAILS_TAB;
    String TAB_LIST = "Check_Out_Page/TabList";
    String ASSET_TAG_DELETE_BUTTON = "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetDeleteButton";
    String SUPPLIER_DETAILS_MODAL_DONE_BUTTON = "Check_Out_Page/Line Item Details Tab/SupplierDetailsModalDoneButton";
    String BASIC_DETAILS_TAB = Constants.BASIC_DETAILS_TAB;
    String ADDITIONAL_DETAILS_TAB = Constants.ADDITIONAL_DETAILS_TAB;
    String LOADING_SPINNER = "FlowOR/Requisition/LoadingSpinner";


    //Line Item Details
    String ITEM_TOTAL_AMOUNT = "FlowOR/Requisition/Line Item Details/ItemTotalAmount";

    String SEND_TO_BUYER_CONFIRM_POPUP = "FlowOR/Requisition/Confirm_PopUp_Send_To_Buyer";
    String RECEIPT_CONFIRM_BUTTON= "Receipt_Page/ConfirmButton";



}
