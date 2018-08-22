package com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageFreeTextForm
{

	final static UI_Elements	SHORT_DESCRIPTION												= UIFactory.getElements("SHORT_DESCRIPTION");
	final static UI_Elements	PART_NUMBER														= UIFactory.getElements("PART_NUMBER");
	final static UI_Elements	QUANTITY														= UIFactory.getElements("QUANTITY");
	final static UI_Elements	LONG_DESCRIPTION												= UIFactory.getElements("LONG_DESCRIPTION");
	final static UI_Elements	UOM																= UIFactory.getElements("UOM");
	final static UI_Elements	PRICE															= UIFactory.getElements("PRICE");
	final static UI_Elements	SOURCING_STATUS_QUOTEDBYSUPPLIER								= UIFactory.getElements("SOURCING_STATUS_QUOTEDBYSUPPLIER");
	final static UI_Elements	SOURCING_STATUS_ESTIMATEDPRICE									= UIFactory.getElements("SOURCING_STATUS_ESTIMATEDPRICE");
	final static UI_Elements	SOURCING_STATUS_NEEDQUOTE										= UIFactory.getElements("SOURCING_STATUS_NEEDQUOTE");
	final static UI_Elements	ITEM_TYPE_GOODS													= UIFactory.getElements("ITEM_TYPE_GOODS");
	final static UI_Elements	ITEM_TYPE_SERVICES												= UIFactory.getElements("ITEM_TYPE_SERVICES");
	final static UI_Elements	RECEIVE_QUANTIY													= UIFactory.getElements("RECEIVE_QUANTIY");
	final static UI_Elements	RECEIVE_AMOUNT													= UIFactory.getElements("RECEIVE_AMOUNT");
	final static UI_Elements	RECEIVE_NORECEIPT												= UIFactory.getElements("RECEIVE_NORECEIPT");
	final static UI_Elements	CURRENCY														= UIFactory.getElements("CURRENCY");
	final static UI_Elements	ANOTHER_NEW_SUPPLIER_LINK										= UIFactory.getElements("ANOTHER_NEW_SUPPLIER_LINK");
	final static UI_Elements	PLACE_ORDER_WITH_EXISTING_SUPPLIER								= UIFactory.getElements("PLACE_ORDER_WITH_EXISTING_SUPPLIER");
	final static UI_Elements	RECENTLY_ORDERED_FREETEXT_LINK									= UIFactory.getElements("RECENTLY_ORDERED_FREETEXT_LINK");
	final static UI_Elements	ADD_TO_CART_BUTTON												= UIFactory.getElements("ADD_TO_CART_BUTTON");
	final static UI_Elements	CANCEL_BUTTON													= UIFactory.getElements("CANCEL_BUTTON");
	final static UI_Elements	SELECT_CATEGORY													= UIFactory.getElements("SELECT_CATEGORY");
	final static UI_Elements	CANCEL_BUTTON_FREE_TEXT_FORM									= UIFactory.getElements("CANCEL_BUTTON_FREE_TEXT_FORM");

	final static UI_Elements	SELECT_CATEGORY_LINK											= UIFactory.getElements("SELECT_CATEGORY_LINK_TEXT");

	final static UI_Elements	SELECT_CATEGORY_AT_HEADER										= UIFactory.getElements("SELECT_CATEGORY_AT_HEADER");
	final static UI_Elements	RECENTLY_ORDERED_FREE_TEXT_ITEMS								= UIFactory.getElements("RECENTLY_ORDERED_FREE_TEXT_ITEMS");
	final static UI_Elements	ITEM_RECENTLY_ORDERED_FREE_TEXT_ITEMS							= UIFactory.getElements("ITEM_RECENTLY_ORDERED_FREE_TEXT_ITEMS");
	final static UI_Elements	ACTIONS_BTN														= UIFactory.getElements("ACTIONS_BTN");
	final static UI_Elements	SUPPLIER_NAME_IN_SUPPLIER_INFO									= UIFactory.getElements("SUPPLIER_NAME_IN_SUPPLIER_INFO");
	final static UI_Elements	ADDRESS_IN_SUPPLIER_INFO										= UIFactory.getElements("ADDRESS_IN_SUPPLIER_INFO");
	final static UI_Elements	CONTRACT_NO_IN_SUPPLIER_INFO									= UIFactory.getElements("CONTRACT_NO_IN_SUPPLIER_INFO");
	final static UI_Elements	FIRST_SUPPLIER__ADDRESS											= UIFactory.getElements("FIRST_SUPPLIER__ADDRESS");
	final static UI_Elements	LABEL_PRODUCT_CATEGORY											= UIFactory.getElements("LABEL_PRODUCT_CATEGORY");
	static UI_Elements			RADIO_BUTTON_SUGGEST_SUPPLIER									= UIFactory.getElements("RADIO_BUTTON_SUGGEST_SUPPLIER");
	static UI_Elements			LINK_ADD_NEW_OR_EXISTING_SUPPLIER								= UIFactory.getElements("LINK_ADD_NEW_OR_EXISTING_SUPPLIER");
	static UI_Elements			LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_NAME							= UIFactory.getElements("LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_NAME");
	static UI_Elements			LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_TYPE							= UIFactory.getElements("LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_TYPE");
	static UI_Elements			LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_ACTIONS						= UIFactory.getElements("LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_ACTIONS");
	static UI_Elements			BUTTON_SHOW_ALL_CONTRACT_OR_BPO_FOR_GUIDED_ITEM					= UIFactory.getElements("BUTTON_SHOW_ALL_CONTRACT_OR_BPO_FOR_GUIDED_ITEM");
	static UI_Elements			LABEL_SELECTED_CONTARCT_OR_BPO_FOR_GUIDED_ITEM					= UIFactory.getElements("LABEL_SELECTED_CONTARCT_OR_BPO_FOR_GUIDED_ITEM");
	static UI_Elements			LINK_ADD_EXISTING_SUPPLIER										= UIFactory.getElements("LINK_ADD_EXISTING_SUPPLIER");
	static UI_Elements			LINK_ADD_NEW_SUPPLIER											= UIFactory.getElements("LINK_ADD_NEW_SUPPLIER");
	static UI_Elements			TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME							= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME");
	static UI_Elements			SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS						= UIFactory.getElements("SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS");
	static UI_Elements			TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO					= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO");
	static UI_Elements			BUTTON_ADD_EXISTING_SUGGEST_SUPPLIER							= UIFactory.getElements("BUTTON_ADD_EXISTING_SUGGEST_SUPPLIER");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME								= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME");
	static UI_Elements			SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS								= UIFactory.getElements("SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO						= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT							= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT_EMAIL_ID					= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT_EMAIL_ID");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_PHONE								= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_PHONE");
	static UI_Elements			TEXTBOX_SUGGEST_NEW_SUPPLIER_OTHER_DETAILS						= UIFactory.getElements("TEXTBOX_SUGGEST_NEW_SUPPLIER_OTHER_DETAILS");
	static UI_Elements			BUTTON_RESET_EXISTING_SUGGEST_SUPPLIER							= UIFactory.getElements("BUTTON_RESET_EXISTING_SUGGEST_SUPPLIER");
	static UI_Elements			BUTTON_ADD_NEW_SUGGEST_SUPPLIER									= UIFactory.getElements("BUTTON_ADD_NEW_SUGGEST_SUPPLIER");
	static UI_Elements			BUTTON_RESET_NEW_SUGGEST_SUPPLIER								= UIFactory.getElements("BUTTON_RESET_NEW_SUGGEST_SUPPLIER");
	static UI_Elements			AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_NAME			= UIFactory.getElements("AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_NAME");
	static UI_Elements			AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_ADDRESS		= UIFactory
		.getElements("AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_ADDRESS");

	static UI_Elements			AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_NAME					= UIFactory.getElements("AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_NAME");

	static UI_Elements			AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_ADDRESS				= UIFactory.getElements("AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_ADDRESS");

	static UI_Elements			AUTO_POPULATED_LIST_FOR_FREE_TEXT_CURRENCY						= UIFactory.getElements("AUTO_POPULATED_LIST_FOR_FREE_TEXT_CURRENCY");
	static UI_Elements			LABEL_CREATE_FREE_TEXT_ITEM										= UIFactory.getElements("LABEL_CREATE_FREE_TEXT_ITEM");
	static UI_Elements			CHECKBOX_ZERO_PRICE_ITEM_GUIDED_ITEM_PAGE						= UIFactory.getElements("CHECKBOX_ZERO_PRICE_ITEM_GUIDED_ITEM_PAGE");
	static UI_Elements			LINK_ADD_ATTACHMENTS_GUIDED_ITEM								= UIFactory.getElements("LINK_ADD_ATTACHMENTS_GUIDED_ITEM");
	static UI_Elements			BUTTON_DONE_ATTACHMENT_GUIDED_ITEM								= UIFactory.getElements("BUTTON_DONE_ATTACHMENT_GUIDED_ITEM");

	static UI_Elements			CHECKOUT_BUTTON													= UIFactory.getElements("CHECKOUT_BUTTON");

	static UI_Elements			SAVE_REQ_ITEM													= UIFactory.getElements("SAVE_REQ_ITEM");

	static UI_Elements			SEARCH_TEXT_BOX_CATEGRORY_SELECTION								= UIFactory.getElements("SEARCH_TEXT_BOX_CATEGRORY_SELECTION");

	static UI_Elements			SELECT_EFORM_LINK												= UIFactory.getElements("SELECT_E-FORM_LINK");

	static UI_Elements			SUPPLIER_NAME_TEXTBOX											= UIFactory.getElements("SUPPLIER_NAME_TEXTBOX");

	static UI_Elements			CONTINUE_WITHOUT_CATEGORY										= UIFactory.getElements("CONTINUE_WITHOUT_CATEGORY");

	static UI_Elements			CLOSE_CATEGORY_DAILOGUE_BUTTON									= UIFactory.getElements("CLOSE_CATEGORY_DAILOGUE_BUTTON");

	static UI_Elements			YELLOW_BAND_CONTAINER											= UIFactory.getElements("YELLOW_BAND_CONTAINER");

	static UI_Elements			YELLOW_BAND_CATALOG_ITEM_LINK									= UIFactory.getElements("YELLOW_BAND_CATALOG_ITEM_LINK");

	static UI_Elements			YELLOW_BAND_PUNCHOUTS_LINK										= UIFactory.getElements("YELLOW_BAND_PUNCHOUTS_LINK");

	static UI_Elements			SEARCH_TEXT_BOX_EFORM_SELECTION									= UIFactory.getElements("SEARCH_TEXT_BOX_EFORM_SELECTION");

	static UI_Elements			RECENTLY_ORDERED_ITEMS											= UIFactory.getElements("RECENTLY_ORDERED_ITEMS");

	static UI_Elements			SUPPLIER_SUB_TAB												= UIFactory.getElements("SUPPLIER_SUB_TAB");

	static UI_Elements			CONTRACT_NO_IN_ITEM_DETAIL_POPUP								= UIFactory.getElements("CONTRACT_NO_IN_ITEM_DETAIL_POPUP");

	static UI_Elements			COPY_ITEM_BUTTON												= UIFactory.getElements("COPY_ITEM_BUTTON");

	static UI_Elements			CATEGORY_MODAL_POPUP_EFORM_COUNT_LABEL							= UIFactory.getElements("CATEGORY_MODAL_POPUP_EFORM_COUNT_LABEL");

	static UI_Elements			ITEM_TAB_RECENTLY_ORDERED_ITEM_POPUP							= UIFactory.getElements("ITEM_TAB_RECENTLY_ORDERED_ITEM_POPUP");

	static UI_Elements			REQUIREMENT_TAB_RECENTLY_ORDERED_ITEM_POPUP						= UIFactory.getElements("REQUIREMENT_TAB_RECENTLY_ORDERED_ITEM_POPUP");

	static UI_Elements			SUPPLIER_TAB_RECENTLY_ORDERED_ITEM_POPUP						= UIFactory.getElements("SUPPLIER_TAB_RECENTLY_ORDERED_ITEM_POPUP");

	static UI_Elements			CANCEL_ITEM_MODAL_POPUP											= UIFactory.getElements("CANCEL_ITEM_MODAL_POPUP");

	static UI_Elements			SHOW_EXTRA_FIELDS_LINK											= UIFactory.getElements("SHOW_EXTRA_FIELDS_LINK");

	static UI_Elements			MANUFACTURER_NAME												= UIFactory.getElements("MANUFACTURER_NAME");

	static UI_Elements			IMAGE_URL														= UIFactory.getElements("IMAGE_URL");

	static UI_Elements			SUPP_URL														= UIFactory.getElements("SUPP_URL");

	static UI_Elements			MANUFACTURER_URL												= UIFactory.getElements("MANUFACTURER_URL");

	static UI_Elements			MANUFACTURER_ID													= UIFactory.getElements("MANUFACTURER_ID");

	static UI_Elements			IS_GREEN_YES													= UIFactory.getElements("IS_GREEN_YES");

	static UI_Elements			IS_GREEN_NO														= UIFactory.getElements("IS_GREEN_NO");

	static UI_Elements			IS_PREFFERED_YES												= UIFactory.getElements("IS_PREFFERED_YES");

	static UI_Elements			IS_PREFFERED_NO													= UIFactory.getElements("IS_PREFFERED_NO");

	static UI_Elements			SPECIFICATION_NAME												= UIFactory.getElements("SPECIFICATION_NAME");

	static UI_Elements			SPECIFICATION_KEY												= UIFactory.getElements("SPECIFICATION_KEY");

	static UI_Elements			SPECIFICATION_VALUE												= UIFactory.getElements("SPECIFICATION_VALUE");

	static UI_Elements			BUTTON_ADDRESS_DROPDOWN											= UIFactory.getElements("BUTTON_ADDRESS_DROPDOWN");

	static UI_Elements			PRODUCT_CATEGORY_LOADER											= UIFactory.getElements("PRODUCT_CATEGORY_LOADER");

	static UI_Elements			REQUIREMENT_DETAILS_SECTION										= UIFactory.getElements("REQUIREMENT_DETAILS_SECTION");

	//SA Water Requirement Details

	static UI_Elements			RADIO_SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS			= UIFactory.getElements("RADIO_SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS");
	static UI_Elements			RADIO_UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS			= UIFactory.getElements("RADIO_UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS");
	static UI_Elements			RADIO_YES_RESPONSE_CMS											= UIFactory.getElements("RADIO_YES_RESPONSE_CMS");
	static UI_Elements			RADIO_NO_RESPONSE_CMS											= UIFactory.getElements("RADIO_NO_RESPONSE_CMS");
	static UI_Elements			RADIO_NA_RESPONSE_CMS											= UIFactory.getElements("RADIO_NA_RESPONSE_CMS");

	static UI_Elements			RADIO_YES_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS	= UIFactory
		.getElements("RADIO_YES_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS");
	static UI_Elements			RADIO_NO_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS		= UIFactory
		.getElements("RADIO_NO_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS");
	static UI_Elements			RADIO_YES_QUOTE_OBTAINED_QUOTE_RECOMMENDATION					= UIFactory.getElements("RADIO_YES_QUOTE_OBTAINED_QUOTE_RECOMMENDATION");
	static UI_Elements			RADIO_YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION		= UIFactory
		.getElements("RADIO_YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION");
	static UI_Elements			RADIO_NO_QUOTE_OBTAINED_QUOTE_RECOMMENDATION					= UIFactory.getElements("RADIO_NO_QUOTE_OBTAINED_QUOTE_RECOMMENDATION");
	static UI_Elements			LINK_CANCEL_GUIDE_ME											= UIFactory.getElements("LINK_CANCEL_GUIDE_ME");

	static UI_Elements			QUANTITY_FREE_TEXT_ITEM											= UIFactory.getElements("QUANTITY_FREE_TEXT_ITEM");
	static UI_Elements			SEE_ALL_EFORMS													= UIFactory.getElements("SEE_ALL_EFORMS");
	static UI_Elements			EFORMS_FOUND_COUNT												= UIFactory.getElements("EFORMS_FOUND_COUNT");
	static UI_Elements			VIEW_ITEMS_IN_CART_LINK											= UIFactory.getElements("VIEW_ITEMS_IN_CART_LINK");

	static UI_Elements			CLOSE_ITEM_MODAL												= UIFactory.getElements("CLOSE_ITEM_MODAL");

	// Free Text Form Functions
	String fillShortDescription(WebDriver driver, String testcaseName, String shortDescription) throws ActionBotException;

	String fillPartNumber(WebDriver driver, String testcaseName, String partNumber) throws ActionBotException;

	void clickOnSelectCategory(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnSelectCategoryAtHeader(WebDriver driver, String testcaseName) throws ActionBotException;

	float fillQuantity(WebDriver driver, String testcaseName, float quantity) throws ActionBotException;

	String fillLongDescription(WebDriver driver, String testcaseName, String longDescription) throws ActionBotException;

	String fillUOM(WebDriver driver, String testcaseName, String UOM) throws ActionBotException;

	float fillPrice(WebDriver driver, String testcaseName, float price) throws ActionBotException;

	boolean clickItemType(WebDriver driver, String testcaseName, String itemType) throws ActionBotException;

	boolean clickSourcingStatus(WebDriver driver, String testcaseName, String sourcingStatus) throws ActionBotException;

	boolean clickReceive_BillBy(WebDriver driver, String testcaseName, String receiveBy) throws ActionBotException;

	String fillCurrency(WebDriver driver, String testcaseName, String currency) throws ActionBotException;

	void fillNew_ExistingSupplierInfo(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean clickPlaceOrderWithExistingSupplier(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnAddToCartButton(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCancelButton(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnItemLinkOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnActionsBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillsupplierNameInSuppInfo(WebDriver driver, String testcaseName, String suppName) throws ActionBotException;

	String filladdressInSuppInfo(WebDriver driver, String testcaseName, String address) throws ActionBotException;

	String fillcontractNoInSuppInfo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException;

	boolean isSelectCategoryLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isCreateFreeTextItemLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	int countSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	int countEForms(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	int getSizeOfSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnAddNewOrExistingSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSuggestedSupplierNameOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSuggestedSupplierTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSuggestedSupplierActionOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShowAllContractOrBPOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedContractOrBPOName(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSelectExistingSupplierLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnAddNewSupplierLink(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillExistingSuggestSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException;

	String selectExistingSuggestSupplierAddress(WebDriver driver, String testcaseName) throws ActionBotException;

	String fillExistingSuggestSupplierContractNo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException;

	public void clickOnAddExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnResetExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillSuggestNewSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException;

	String fillSuggestNewSupplierAddress(WebDriver driver, String testcaseName, String supplierAddress) throws ActionBotException;

	String fillSuggestNewSupplierContractNo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException;

	String fillSuggestNewSupplierContact(WebDriver driver, String testcaseName, String contact) throws ActionBotException;

	String fillSuggestNewSupplierEmailId(WebDriver driver, String testcaseName, String emailId) throws ActionBotException;

	int fillSuggestNewSupplierPhone(WebDriver driver, String testcaseName, int phone) throws ActionBotException;

	String fillSuggestNewSupplierOtherDetails(WebDriver driver, String testcaseName, String otherDetails) throws ActionBotException;

	public void clickOnAddSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnResetSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnZeroPriceItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddAttachmentLinkAndEscape(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewExistingSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierEmailID(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierPhone(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestNewSupplierOtherDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	int fillQuantity(WebDriver driver, String testcaseName, int quantity) throws ActionBotException;

	public String fillSourcingStatus(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickToCheckout(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickToAddFreeTextItemIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickSelectCategoryLink(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean selectCategoryFromTheSearchBox(WebDriver driver, String testcaseName, String Category) throws ActionBotException;

	void selectEFormForCategory(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickSelectEFormLink(WebDriver driver, String testcaseName, String eformName) throws ActionBotException;

	void clickEFormNamewise(WebDriver driver, String testcaseName, String name) throws ActionBotException;

	void continueWithoutCategory(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isContinueWithoutCategoryPresent(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickCloseCategoryDailogueButton(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isCategoryListPresentInsideEForm(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isYellowBandPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isCatalogItemPunchoutsHyperlinkPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickCatalogItemLink(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isContractNoFieldPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickSuggestedSupplierRadioLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void veiwRecentlyOrderedItems(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickRecentlyOrderedItemsIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickSupplierSubTab(WebDriver driver, String testcaseName) throws ActionBotException;

	public String getContractNumberFromItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getExistingSupplierContractNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCloseItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException;

	String getItemCurrencyFromItemDetailPopup(WebDriver driver, String testcaseName, String currency) throws ActionBotException;

	String getItemQuantityFromItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException;

	String getItemPriceFromItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException;

	String getPrice(WebDriver driver, String testcaseName) throws ActionBotException;

	String getQuantity(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickCopyItem(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickCloseItemModalPopup(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickEFormInCategoryNameWise(WebDriver driver, String testcaseName, String eFormNAme) throws ActionBotException;

	public void clickCategoryUnderEFormIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	public void clickShowMoreExtraFields(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isErrorMessageVisible(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isEFormFieldsVisible(WebDriver driver, String testcaseName, String fieldName) throws ActionBotException;

	public boolean isCatalogItemCountVisible(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isPunchoutCountLinkVisible(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isEFormVisible(WebDriver driver, String testcaseName, String displayName) throws ActionBotException;

	public boolean isFreeTextItemVisible(WebDriver driver, String testcaseName, String searchName) throws ActionBotException;

	public String getShortDescription(WebDriver driver, String testcaseName) throws ActionBotException;

	void searchForSupplierName(WebDriver driver, String testcaseName, String suppName) throws ActionBotException;

	boolean isEformFieldVisible(WebDriver driver, String testcaseName, String eFormFieldName) throws ActionBotException;

	void clickOnAddAnotherItemOnAddToCartPopup(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean checkEditingSupplierAddress(WebDriver driver, String testcaseName, int editCount) throws ActionBotException;

	boolean isRequirementDetailsSectionVisible(WebDriver driver, String testcaseName) throws ActionBotException;

	//Free Text SA Water Requirement Details
	public void clickOnRequisitionAppliesTo_RequirementDetail(WebDriver driver, String testcaseName, String requisitionAppliesTo_RequirementDetail) throws ActionBotException;

	public void clickOnResponse_RequirementDetail(WebDriver driver, String testcaseName, String response_RequirementDetail) throws ActionBotException;

	public void clickOnPOSentToSupplier_RequirementDetail(WebDriver driver, String testcaseName, String poSentToSupplier_RequirementDetail) throws ActionBotException;

	public void clickOnQuoteObtain_RequirementDetail(WebDriver driver, String testcaseName, String quoteObtained_RequirementDetail) throws ActionBotException;

	void clickCancelGuideMePopup(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnLinkViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnshortDescriptionLinkInRecentlyOrderedFreeTextItemsNameWise(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException;

}
