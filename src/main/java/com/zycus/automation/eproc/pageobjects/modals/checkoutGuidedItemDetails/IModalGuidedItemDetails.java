/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalGuidedItemDetails
{
	UI_Elements	TEXTBOX_ITEM_NUMBER_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("TEXTBOX_ITEM_NUMBER_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_SHORT_DESCRIPTION_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_SHORT_DESCRIPTION_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_LONG_DESCRIPTION_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_LONG_DESCRIPTION_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_ITEM_TYPE_GOODS_CHECKOUT_ITEM_DETAILS								= UIFactory.getElements("RADIO_BUTTON_ITEM_TYPE_GOODS_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_ITEM_TYPE_SERVICES_CHECKOUT_ITEM_DETAILS							= UIFactory.getElements("RADIO_BUTTON_ITEM_TYPE_SERVICES_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_RECEIVE_BY_QUANTITY_CHECKOUT_ITEM_DETAILS							= UIFactory.getElements("RADIO_BUTTON_RECEIVE_BY_QUANTITY_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_RECEIVE_BY_AMOUNT_CHECKOUT_ITEM_DETAILS							= UIFactory.getElements("RADIO_BUTTON_RECEIVE_BY_AMOUNT_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS					= UIFactory
		.getElements("RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_SOURCING_STATUS_BUDGETARY_CHECKOUT_ITEM_DETAILS					= UIFactory
		.getElements("RADIO_BUTTON_SOURCING_STATUS_BUDGETARY_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_SOURCING_STATUS_QUOTE_CHECKOUT_ITEM_DETAILS						= UIFactory.getElements("RADIO_BUTTON_SOURCING_STATUS_QUOTE_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_CURRENCY_CHECKOUT_ITEM_DETAILS											= UIFactory.getElements("TEXTBOX_CURRENCY_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_PRODUCT_CATEGORY_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_PRODUCT_CATEGORY_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_QUANTITY_CHECKOUT_ITEM_DETAILS											= UIFactory.getElements("TEXTBOX_QUANTITY_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_UOM_CHECKOUT_ITEM_DETAILS												= UIFactory.getElements("TEXTBOX_UOM_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS												= UIFactory.getElements("TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXT_PRICE_CHECKOUT_ITEM_DETAILS												= UIFactory.getElements("TEXT_PRICE_CHECKOUT_ITEM_DETAILS");

	UI_Elements	BUTTON_SAVE_GUIDED_ITEM															= UIFactory.getElements("BUTTON_SAVE_GUIDED_ITEM");
	UI_Elements	BUTTON_CANCEL_GUIDED_ITEM														= UIFactory.getElements("BUTTON_CANCEL_GUIDED_ITEM");
	UI_Elements	TAB_REQUIREMENT_DETAILS_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TAB_REQUIREMENT_DETAILS_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TAB_SUPPLIERS_DETAILS_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("TAB_SUPPLIERS_DETAILS_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_EFORM_FIELD_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("TEXTBOX_ITEM_NUMBER_CHECKOUT_ITEM_DETAILS");
	UI_Elements	TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_SUPPLIER_CONTACT_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_SUPPLIER_CONTACT_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_SUPPLIER_PHONE_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_SUPPLIER_PHONE_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_SUPPLIER_OTHER_DETAILS_CHECKOUT_ITEM_DETAILS							= UIFactory.getElements("TEXTBOX_SUPPLIER_OTHER_DETAILS_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_SUPPLIER_ADDRESS_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_SUPPLIER_ADDRESS_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_SUPPLIER_EMAIL_ID_CHECKOUT_ITEM_DETAILS									= UIFactory.getElements("TEXTBOX_SUPPLIER_EMAIL_ID_CHECKOUT_ITEM_DETAILS");

	UI_Elements	TEXTBOX_CONTRACT_NO_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("TEXTBOX_CONTRACT_NO_CHECKOUT_ITEM_DETAILS");

	UI_Elements	BUTTON_SHOW_ALL_BPO_CHECKOUT_ITEM_DETAILS										= UIFactory.getElements("BUTTON_SHOW_ALL_BPO_CHECKOUT_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_SUGGEST_SUPPLIER_CHECKOUT_ITEM_DETAILS								= UIFactory.getElements("RADIO_BUTTON_SUGGEST_SUPPLIER_CHECKOUT_ITEM_DETAILS");

	UI_Elements	MODAL_GUIDEDITEMDETAILS_SUPPLER_TAB												= UIFactory.getElements("MODAL_GUIDEDITEMDETAILS_SUPPLER_TAB");
	UI_Elements	MODAL_GUIDEDITEMDETAILS_CONTRACT_NO												= UIFactory.getElements("MODAL_GUIDEDITEMDETAILS_CONTRACT_NO");
	UI_Elements	MODAL_GUIDEDITEMDETAILS_SUPPLER_NAME											= UIFactory.getElements("MODAL_GUIDEDITEMDETAILS_SUPPLER_NAME");

	UI_Elements	LINK_SYSTEM_SUGGESTED_SUPPLIER_GUITEM_ITEM										= UIFactory.getElements("LINK_SYSTEM_SUGGESTED_SUPPLIER_GUITEM_ITEM");
	UI_Elements	RADIO_BUTTON_SOURCING_STATUS_BUYER_NEGOTIATED_PRICE_BUYERS_DESK_ITEM_DETAILS	= UIFactory
		.getElements("RADIO_BUTTON_SOURCING_STATUS_BUYER_NEGOTIATED_PRICE_BUYERS_DESK_ITEM_DETAILS");
	UI_Elements	RADIO_BUTTON_SOURCING_STATUS_NEED_A_QUOTE_BUYERS_DESK_ITEM_DETAILS				= UIFactory
		.getElements("RADIO_BUTTON_SOURCING_STATUS_NEED_A_QUOTE_BUYERS_DESK_ITEM_DETAILS");
	UI_Elements	LABEL_ERROR_PRODUCT_CATEGORY													= UIFactory.getElements("LABEL_ERROR_PRODUCT_CATEGORY");
	UI_Elements	MODAL_GUIDEDITEMSDETAILS_SUPPLIER_ADDRESS										= UIFactory.getElements("MODAL_GUIDEDITEMSDETAILS_SUPPLIER_ADDRESS");
	UI_Elements	TEXTBOX_BPO_NO																	= UIFactory.getElements("TEXTBOX_BPO_NO");
	UI_Elements	RADIO_BUTTON_SELECT_BPO															= UIFactory.getElements("RADIO_BUTTON_SELECT_BPO");
	UI_Elements	BUTTON_SELECT_BPO																= UIFactory.getElements("BUTTON_SELECT_BPO");
	UI_Elements	HEADER_BPO_TYPE_SHOW_ALL_BPOS													= UIFactory.getElements("HEADER_BPO_TYPE_SHOW_ALL_BPOS");
	UI_Elements	LABEL_ITEM_PRICE_GUIDED_MODEL													= UIFactory.getElements("LABEL_ITEM_PRICE_GUIDED_MODEL");
	UI_Elements	LINK_CLICK_HERE_TO_MODIFY_IN_ITEM_MODAL											= UIFactory.getElements("LINK_CLICK_HERE_TO_MODIFY_IN_ITEM_MODAL");
	UI_Elements	LABEL_SOURCING_STATUS_IN_ITEM_MODAL												= UIFactory.getElements("LABEL_SOURCING_STATUS_IN_ITEM_MODAL");
	UI_Elements	LINK_BPO_NUMBER_IN_ITEM_DETAILS													= UIFactory.getElements("LINK_BPO_NUMBER_IN_ITEM_DETAILS");
	UI_Elements	BUTTON_SELECT_EXISTING_SUPPLIER_ITEM_DETAIL_MODAL								= UIFactory.getElements("BUTTON_SELECT_EXISTING_SUPPLIER_ITEM_DETAIL_MODAL");

	UI_Elements	LABEL_SUGGESTED_SUPPLIER_BLOCK_EMPTY											= UIFactory.getElements("LABEL_SUGGESTED_SUPPLIER_BLOCK_EMPTY");

	UI_Elements	LINK_SYSTEM_SUGGESTED_SUPPLIER_EXPAND											= UIFactory.getElements("LINK_SYSTEM_SUGGESTED_SUPPLIER_EXPAND");

	UI_Elements	LABEL_SYSTEM_SUGGESTED_SUPPLIER_TYPE											= UIFactory.getElements("LABEL_SYSTEM_SUGGESTED_SUPPLIER_TYPE");

	UI_Elements	LABEL_SYSTEM_SUGGESTED_SUPPLIER_NAME											= UIFactory.getElements("LABEL_SYSTEM_SUGGESTED_SUPPLIER_NAME");

	UI_Elements	LABEL_SYSTEM_SUGGESTED_SUPPLIER_ADDRESS											= UIFactory.getElements("LABEL_SYSTEM_SUGGESTED_SUPPLIER_ADDRESS");

	UI_Elements	LABEL_SYSTEM_SUGGESTED_SUPPLIER_VIEW_CONTRACTS									= UIFactory.getElements("LABEL_SYSTEM_SUGGESTED_SUPPLIER_VIEW_CONTRACTS");
	UI_Elements	LABEL_SYSTEM_SUGGESTED_SUPPLIER_ACTIONS											= UIFactory.getElements("LABEL_SYSTEM_SUGGESTED_SUPPLIER_ACTIONS");
	String		xpath1_action_system_suggested_supplier											= ".//tr[.//*[contains(text(),'";
	String		xpath2_action_system_suggested_supplier											= "')]]//a[contains(@class,'editSupplier')]";
	String		xpath2_supplierName_system_suggested_supplier									= "')]]/td[contains(@class,'guidedSuggestedSuppName')]/span";
	String		xpath2_supplierAddress_system_suggested_supplier								= "')]]/td[contains(@class,'guidedSuggestedSuppAdd')]/span";
	String		xpath2_viewContractsLink_system_suggested_supplier								= "')]]//a[contains(@class,'viewContracts')]";
	String		xpath2_previouslyUsedIcon_system_suggested_supplier								= "')]]//span[contains(@class,'previouslyUsed')]";

	UI_Elements	LINK_ADD_NEW_SUGGEST_SUPPLIER_IN_ITEM_DETAILS_MODAL								= UIFactory.getElements("LINK_ADD_NEW_SUGGEST_SUPPLIER_IN_ITEM_DETAILS_MODAL");
	UI_Elements	ERROR_MSG_SUPPLIER_DETAILS_MANDATORY_ON_ITEM_DETAIL_MODAL						= UIFactory
		.getElements("ERROR_MSG_SUPPLIER_DETAILS_MANDATORY_ON_ITEM_DETAIL_MODAL");
	UI_Elements	ICON_MANDATORY_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL								= UIFactory.getElements("ICON_MANDATORY_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL");
	UI_Elements	ICON_MANDATORY_SUPPLIER_ADDRESS_ON_ITEM_DETAIL_MODAL							= UIFactory.getElements("ICON_MANDATORY_SUPPLIER_ADDRESS_ON_ITEM_DETAIL_MODAL");
	UI_Elements	TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTACT										= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTACT");
	UI_Elements	TEXTBOX_EXISTING_SUGGEST_SUPPLIER_EMAIL_ID										= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_SUPPLIER_EMAIL_ID");
	UI_Elements	TEXTBOX_EXISTING_SUGGEST_SUPPLIER_PHONE											= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_SUPPLIER_PHONE");
	UI_Elements	TEXTBOX_EXISTING_SUGGEST_OTHER_DETAILS											= UIFactory.getElements("TEXTBOX_EXISTING_SUGGEST_OTHER_DETAILS");
	UI_Elements	BUTTON_SHOW_ALL_BPO_ON_ITEM_DETAIL_MODAL										= UIFactory.getElements("BUTTON_SHOW_ALL_BPO_ON_ITEM_DETAIL_MODAL");
	UI_Elements	TEXTBOX_CONTRACT_NO_FOR_EXISTING_SUPPLIER_ON_CHECKOUT_ITEM_DETAILS				= UIFactory
		.getElements("TEXTBOX_CONTRACT_NO_FOR_EXISTING_SUPPLIER_ON_CHECKOUT_ITEM_DETAILS");
	UI_Elements	ICON_MANDATORY_SUGGEST_NEW_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL					= UIFactory
		.getElements("ICON_MANDATORY_SUGGEST_NEW_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL");
	UI_Elements	LABEL_FIRST_SUGGESTED_NEW_SUPPLIER												= UIFactory.getElements("LABEL_FIRST_SUGGESTED_NEW_SUPPLIER");
	UI_Elements	LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS										= UIFactory.getElements("LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS");

	UI_Elements	LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTACT										= UIFactory.getElements("LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTACT");

	UI_Elements	LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTRACT_NO									= UIFactory.getElements("LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTRACT_NO");
	UI_Elements	TAB_ITEM_DETAILS_IN_ITEM_DETAILS_MODAL_CHECKOUT_PAGE							= UIFactory.getElements("TAB_ITEM_DETAILS_IN_ITEM_DETAILS_MODAL_CHECKOUT_PAGE");

	UI_Elements	LABEL_QUOTED_BY_SUPPLIER_SOURCING_STATUS_ITEM_DETAILS_MODAL						= UIFactory
		.getElements("LABEL_QUOTED_BY_SUPPLIER_SOURCING_STATUS_ITEM_DETAILS_MODAL");

	UI_Elements	LABEL_ESTIMATED_PRICE_SOURCING_STATUS_ITEM_DETAILS_MODAL						= UIFactory.getElements("LABEL_ESTIMATED_PRICE_SOURCING_STATUS_ITEM_DETAILS_MODAL");

	UI_Elements	LABEL_NEED_A_QUOTE_SOURCING_STATUS_ITEM_DETAILS_MODAL							= UIFactory.getElements("LABEL_NEED_A_QUOTE_SOURCING_STATUS_ITEM_DETAILS_MODAL");
	UI_Elements	ERROR_INVALID_QUANTITY_GUIDED_ITEM_DETAILS										= UIFactory.getElements("ERROR_INVALID_QUANTITY_GUIDED_ITEM_DETAILS");
	UI_Elements	BUTTON_YES_CONFIRM_POPUP														= UIFactory.getElements("BUTTON_YES_CONFIRM_POPUP");
	UI_Elements	TEXTBOX_ITEM_SUMMARY_SUGGESTED_NEW_SUPPLIER_CONTRACT							= UIFactory.getElements("TEXTBOX_ITEM_SUMMARY_SUGGESTED_NEW_SUPPLIER_CONTRACT");

	UI_Elements	CLICK_ON_SELECT_ON_SUPPLIER_TAB													= UIFactory.getElements("CLICK_ON_SELECT_ON_SUPPLIER_TAB");

	UI_Elements	CLICK_ON_SUGGESTED_SUPPLIER_ON_SUPPLIER_TAB										= UIFactory.getElements("CLICK_ON_SUGGESTED_SUPPLIER_ON_SUPPLIER_TAB");

	UI_Elements	LINK_MODIFY_RECEIVE_BY_OPTION													= UIFactory.getElements("LINK_MODIFY_RECEIVE_BY_OPTION");

	UI_Elements	LABEL_SUPPLIER_EMAIL_ID_IN_REQUISITION_PAGE										= UIFactory.getElements("LABEL_SUPPLIER_EMAIL_ID_IN_REQUISITION_PAGE");
	UI_Elements	TEXT_RECEIVE_BY_IN_ITEM_MODAL													= UIFactory.getElements("TEXT_RECEIVE_BY_IN_ITEM_MODAL");
	UI_Elements	TEXT_PRODUCT_CATEGORY_IN_ITEM_MODAL												= UIFactory.getElements("TEXT_PRODUCT_CATEGORY_IN_ITEM_MODAL");
	UI_Elements	TEXT_SHORT_DESCRIPTION_IN_ITEM_MODAL											= UIFactory.getElements("TEXT_SHORT_DESCRIPTION_IN_ITEM_MODAL");
	UI_Elements	TEXT_LONG_DESCRIPTION_IN_ITEM_MODAL												= UIFactory.getElements("TEXT_LONG_DESCRIPTION_IN_ITEM_MODAL");
	UI_Elements	TEXT_ITEM_TYPE_IN_ITEM_MODAL													= UIFactory.getElements("TEXT_ITEM_TYPE_IN_ITEM_MODAL");
	UI_Elements	TEXT_ITEM_NUMBER_ITEM_MODAL														= UIFactory.getElements("TEXT_ITEM_NUMBER_ITEM_MODAL");
	UI_Elements	BUTTON_OK_SHOW_ALL_CONTRACTS													= UIFactory.getElements("BUTTON_OK_SHOW_ALL_CONTRACTS");
	
	UI_Elements	SHOW_ALL_BPO_NEW_SUPPLIER_BUTTON												= UIFactory.getElements("SHOW_ALL_BPO_NEW_SUPPLIER_BUTTON");
	
	UI_Elements	FIRST_EFORM_NAME_LINK															= UIFactory.getElements("FIRST_EFORM_NAME_LINK");
	
	public String fillProductCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	public String fillItemName(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	public String fillSuplierName(WebDriver driver, String testCaseName, String searchtext) throws ActionBotException;

	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierContract(WebDriver driver, String testCaseName, String contract) throws ActionBotException;

	public String fillSupplierContractForNewSupplier(WebDriver driver, String testCaseName, String contract) throws ActionBotException;

	public String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public float fillPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException;

	public void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectBpoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public float fillprice(WebDriver driver, String testCaseName, float price) throws ActionBotException;

	public void clickOnSourcingStatusEstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTabSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSuggestedSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnHeaderBpoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatusNeedAQuoteOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public String fillBpoNo(WebDriver driver, String testCaseName, String BpoNo) throws ActionBotException;

	public boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShowAllContractsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemPriceInGuidedModel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClickHereToModifyInItemDetail(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSourcingStatusFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBpoNumberLinkedPresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequesterSelectedSuppliersEmptyTablePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfRequesterSelectedSuppliersEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandSystemSuggestedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfTypeColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfNameColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfAddressColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfViewContractsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfActionsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean isSupplierPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String getSupplierAddressInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean isViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String getTextOfViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean isPreviouslyUsedIconPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void clickOnViewContractLink(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void clickOnActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean isSelectExistingSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddNewSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getMandatoryErrorMsgForSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierAddressTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierContactTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierEmailIdTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPhoneTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContractNoTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isOtherDetailsTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMandatoryIconPresentForSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMandatoryIconPresentForSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillExistingSuggestSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException;

	String selectExistingSuggestSupplierAddress(WebDriver driver, String testcaseName, String supplierAddress) throws ActionBotException;

	public String getAttributeOFExistingSupplierContactField(WebDriver driver, String testCaseName, String attributeName) throws ActionBotException;

	public boolean isShowAllBPOButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnShowAllBPOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillExistingSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException;

	public String getTagOfEmailId(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfContractNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierAddressTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierContactTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierEmailIdTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPhoneTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContractNoTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isOtherDetailsTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfSupplierNameForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddNewSuggestSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSuggestNewSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean isSuggestNewSupplierNameIsMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSuggestNewSupplierFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfSupplierAddressForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfSupplierContactForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfContractNoForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSuggestNewSupplierAddressFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSuggestNewSupplierContactFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSuggestNewContractNoFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatusQuotedBySupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatusNeedAQuoteRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierAddressTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierContactTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierEmailIdTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPhoneTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isContractNoTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isOtherDetailsTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillExistingSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String selectSupplierAddressForExistingSupplier(WebDriver driver, String testCaseName, String address) throws ActionBotException;

	public String fillSupplierContactForExistingSupplier(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException;

	public String fillSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName, String emailId) throws ActionBotException;

	public String fillSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName, String phone) throws ActionBotException;

	public String fillContractNoForExistingSupplier(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException;

	public String fillOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName, String otherDetails) throws ActionBotException;

	public String getSupplierContactForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getContractNoForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEstimatedPriceSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNeedAQuoteSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillQuantity(WebDriver driver, String testCaseName, String quantity, String itemId) throws ActionBotException;

	public boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillUOM(WebDriver driver, String testCaseName, String uom, String itemId) throws ActionBotException;

	public String getUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public float getQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonYesOnConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickEditForRequestedSuggestedSuppliers(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnSelectOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSystemSuggestedSupplierOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierEmailIdFromSupplierTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierContractNoTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException;

	String getReceiveOrBillByFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getProductCategoryFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getShortDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getLongDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getItemTypeFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getItemNumberItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public void clickOnShowAllBPOForSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnEditActionItemDetailsModal(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public boolean clickOnActionForRequesterSuggestedSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException;
}
