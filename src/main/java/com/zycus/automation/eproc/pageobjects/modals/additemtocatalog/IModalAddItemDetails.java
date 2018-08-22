/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.additemtocatalog;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public interface IModalAddItemDetails
{
	static UI_Elements	TEXTBOX_SUPPLIER_PART_ID									= UIFactory.getElements("TEXTBOX_SUPPLIER_PART_ID");
	static UI_Elements	TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM						= UIFactory.getElements("TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM");
	static UI_Elements	TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM						= UIFactory.getElements("TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM");
	static UI_Elements	TEXTBOX_PRICE_CATALOG_ITEM									= UIFactory.getElements("TEXTBOX_PRICE_CATALOG_ITEM");
	static UI_Elements	BUTTON_ADD_CATALOG_ITEM										= UIFactory.getElements("BUTTON_ADD_CATALOG_ITEM");
	static UI_Elements	BUTTON_ADD_AND_CONTINUE										= UIFactory.getElements("BUTTON_ADD_AND_CONTINUE");
	static UI_Elements	BUTTON_CLOSE_ADD_ITEM										= UIFactory.getElements("BUTTON_CLOSE_ADD_ITEM");
	static UI_Elements	LABEL_SELECTED_SUPPLIER_NAME								= UIFactory.getElements("LABEL_SELECTED_SUPPLIER_NAME");
	static UI_Elements	TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM							= UIFactory.getElements("TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM");
	static UI_Elements	BUTTON_UPDATE_CATALOG_ITEM									= UIFactory.getElements("BUTTON_UPDATE_CATALOG_ITEM");

	UI_Elements			TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION					= UIFactory.getElements("TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION");
	UI_Elements			TEXTBOX_ITEM_UOM_CATALOG_CREATION							= UIFactory.getElements("TEXTBOX_ITEM_UOM_CATALOG_CREATION");
	UI_Elements			LABEL_SUPPLIER_ID_CATALOG_CREATION							= UIFactory.getElements("LABEL_SUPPLIER_ID_CATALOG_CREATION");
	UI_Elements			TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION						= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION");

	UI_Elements			TEXTBOX_ERP_PART_ID											= UIFactory.getElements("TEXTBOX_ERP_PART_ID");
	UI_Elements			TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG					= UIFactory.getElements("TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG");
	static UI_Elements	BUTTON_ADD_SUPPLIER_ITEM_MASTER								= UIFactory.getElements("BUTTON_ADD_SUPPLIER_ITEM_MASTER");

	static UI_Elements	LABEL_ERP_PART_ID_FOR_CATALOG_ITEM							= UIFactory.getElements("LABEL_ERP_PART_ID_FOR_CATALOG_ITEM");

	static UI_Elements	CHECKBOX_FIRST_ITEM_FROM_ITEM_MASTER						= UIFactory.getElements("CHECKBOX_ITEM_FROM_ITEM_MASTER");
	static UI_Elements	LINK_ACTIONS_OF_ITEM_IN_ITEM_MASTER							= UIFactory.getElements("LINK_ACTIONS_OF_ITEM_IN_ITEM_MASTER");
	static UI_Elements	LINK_EDIT_ITEM_OF_ITEM_MASTER								= UIFactory.getElements("LINK_EDIT_ITEM_OF_ITEM_MASTER");
	static UI_Elements	LINK_DISCARD_ITEM_OF_ITEM_MASTER							= UIFactory.getElements("LINK_DISCARD_ITEM_OF_ITEM_MASTER");
	static UI_Elements	BUTTON_ADD_SUPPLIER_WHILE_UPDATING_ITEM						= UIFactory.getElements("BUTTON_ADD_SUPPLIER_WHILE_UPDATING_ITEM");

	static UI_Elements	TEXTBOX_PRODUCT_URL											= UIFactory.getElements("TEXTBOX_PRODUCT_URL");
	static UI_Elements	TEXTBOX_MANUFACTURER_NAME									= UIFactory.getElements("TEXTBOX_MANUFACTURER_NAME");
	static UI_Elements	TEXTBOX_MANUFACTURER_PART_ID								= UIFactory.getElements("TEXTBOX_MANUFACTURER_PART_ID");
	static UI_Elements	TEXTBOX_MANUFACTURER_URL									= UIFactory.getElements("TEXTBOX_MANUFACTURER_URL");
	static UI_Elements	TEXTBOX_LEAD_TIME											= UIFactory.getElements("TEXTBOX_LEAD_TIME");
	static UI_Elements	RADIO_BUTTON_IS_GREEN_YES									= UIFactory.getElements("RADIO_BUTTON_IS_GREEN_YES");
	static UI_Elements	RADIO_BUTTON_IS_GREEN_NO									= UIFactory.getElements("RADIO_BUTTON_IS_GREEN_NO");
	static UI_Elements	IS_PREFFERED_YES											= UIFactory.getElements("IS_PREFFERED_YES");
	static UI_Elements	IS_PREFFERED_NO												= UIFactory.getElements("IS_PREFFERED_NO");
	static UI_Elements	TEXTBOX_SPECIFICATION_NAME									= UIFactory.getElements("TEXTBOX_SPECIFICATION_NAME");
	static UI_Elements	SPECIFICATIONS_TYPE											= UIFactory.getElements("SPECIFICATIONS_TYPE");
	static UI_Elements	SPECIFICATIONS_VALUE										= UIFactory.getElements("SPECIFICATIONS_VALUE");
	static UI_Elements	BUTTON_ITEM_BROWSE											= UIFactory.getElements("BUTTON_ITEM_BROWSE");
	static UI_Elements	ATTACHMENT_URL												= UIFactory.getElements("ATTACHMENT_URL");
	static UI_Elements	ATTACHMENT_URL_ADD_BUTTON									= UIFactory.getElements("ATTACHMENT_URL_ADD_BUTTON");
	static UI_Elements	TEXTBOX_ERP_PART_NO											= UIFactory.getElements("TEXTBOX_ERP_PART_NO");
	static UI_Elements	TEXTBOX_ITEM_DESCRIPTION									= UIFactory.getElements("TEXTBOX_ITEM_DESCRIPTION");
	static UI_Elements	SELECT_ITEM_IMAGE											= UIFactory.getElements("SELECT_ITEM_IMAGE");
	static UI_Elements	SELECT_ITEM_IMAGE_ERROR_MESSAGE								= UIFactory.getElements("SELECT_ITEM_IMAGE_ERROR_MESSAGE");
	static UI_Elements	ASSET_NUMBERING_REQUIRED_YES								= UIFactory.getElements("ASSET_NUMBERING_REQUIRED_YES");
	static UI_Elements	ASSET_NUMBERING_REQUIRED_NO									= UIFactory.getElements("ASSET_NUMBERING_REQUIRED_NO");
	static UI_Elements	LABEL_RECEIVE_BY											= UIFactory.getElements("LABEL_RECEIVE_BY");
	static UI_Elements	LABEL_ITEM_TYPE_GOODS										= UIFactory.getElements("LABEL_ITEM_TYPE_GOODS");
	static UI_Elements	LABEL_RECEIVE_BY_QUANTITY									= UIFactory.getElements("LABEL_RECEIVE_BY_QUANTITY");
	static UI_Elements	LABEL_ITEM_TYPE												= UIFactory.getElements("LABEL_ITEM_TYPE");
	static UI_Elements	SHORT_DESCRIPTION_MANDATORY_TAG								= UIFactory.getElements("SHORT_DESCRIPTION_MANDATORY_TAG");
	static UI_Elements	LABEL_ERROR_MESSAGE_SHORT_DESCRIPTION						= UIFactory.getElements("LABEL_ERROR_MESSAGE_SHORT_DESCRIPTION");
	static UI_Elements	ERP_PART_NO_MANDATORY_TAG									= UIFactory.getElements("ERP_PART_NO_MANDATORY_TAG");
	static UI_Elements	LABEL_ERROR_MESSAGE_ERP_PART_NO								= UIFactory.getElements("LABEL_ERROR_MESSAGE_ERP_PART_NO");
	static UI_Elements	ITEM_TYPE_MANDATORY_TAG										= UIFactory.getElements("ITEM_TYPE_MANDATORY_TAG");

	static UI_Elements	PRODUCT_CATEGORY_MANDATORY_TAG								= UIFactory.getElements("PRODUCT_CATEGORY_MANDATORY_TAG");
	static UI_Elements	LABEL_ERROR_MESSGAE_PRODUCT_CATEGORY						= UIFactory.getElements("LABEL_ERROR_MESSGAE_PRODUCT_CATEGORY");
	static UI_Elements	UOM_MANDATORY_TAG											= UIFactory.getElements("UOM_MANDATORY_TAG");

	// static UI_Elements ITEM_SCOPE_MANDATORY_TAG =
	// UIFactory.getElements("ITEM_SCOPE_MANDATORY_TAG");
	// static UI_Elements LABEL_ERROR_MESSAGE_ITEM_SCOPE =
	// UIFactory.getElements("LABEL_ERROR_MESSAGE_ITEM_SCOPE");

	static UI_Elements	ADD_ITEM_MASTER_ITEM_UPLOAD_ATTACHMENT_SELECT_FILE_BUTTON	= UIFactory.getElements("ADD_ITEM_MASTER_ITEM_UPLOAD_ATTACHMENT_SELECT_FILE_BUTTON");
	static UI_Elements	UPDATE_SUPPLIER_BUTTON										= UIFactory.getElements("UPDATE_SUPPLIER_BUTTON");
	static UI_Elements	SEARCH_TEXTBOX_SUPPLIER										= UIFactory.getElements("SEARCH_TEXTBOX_SUPPLIER");
	static UI_Elements	SUPPLIER_SEARCH_GO_BUTTON									= UIFactory.getElements("SUPPLIER_SEARCH_GO_BUTTON");
	static UI_Elements	CLEAR_SEARCH_SUPPLIER										= UIFactory.getElements("CLEAR_SEARCH_SUPPLIER");
	static UI_Elements	LIST_OF_SUPPLIERS											= UIFactory.getElements("LIST_OF_SUPPLIERS");
	static UI_Elements	CLOSE_BUTTON_ADD_ITEM_DETAILS								= UIFactory.getElements("CLOSE_BUTTON_ADD_ITEM_DETAILS");
	static UI_Elements	SUPPLIER_COLUMN_NAMES										= UIFactory.getElements("SUPPLIER_COLUMN_NAMES");
	static UI_Elements	ITEM_NAME_LIST_OF_ITEMS										= UIFactory.getElements("ITEM_NAME_LIST_OF_ITEMS");
	static UI_Elements	SUPPLIER_ADDED_ON											= UIFactory.getElements("SUPPLIER_ADDED_ON");
	static UI_Elements	SUPPLIER_LAST_UPDATED_ON									= UIFactory.getElements("SUPPLIER_LAST_UPDATED_ON");
	static UI_Elements	SUPPLIER_STATUS												= UIFactory.getElements("SUPPLIER_STATUS");
	static UI_Elements	ITEM_SCOPE_MANDATORY_TAG									= UIFactory.getElements("ITEM_SCOPE_MANDATORY_TAG");
	static UI_Elements	ITEM_CURRENCY_MANDATORY_TAG									= UIFactory.getElements("ITEM_CURRENCY_MANDATORY_TAG");
	static UI_Elements	ITEM_PRICE_MANDATORY_TAG									= UIFactory.getElements("ITEM_PRICE_MANDATORY_TAG");
	static UI_Elements	SUPPLIER_PART_ID_MANDATORY_TAG								= UIFactory.getElements("SUPPLIER_PART_ID_MANDATORY_TAG");
	static UI_Elements	SUPPLIER_NAME_MANDATORY_TAG									= UIFactory.getElements("SUPPLIER_NAME_MANDATORY_TAG");

	static UI_Elements	BUTTON_SELECT_FILE_IN_ITEM_DETAILS							= UIFactory.getElements("BUTTON_SELECT_FILE_IN_ITEM_DETAILS");

	static UI_Elements	ACTIONS_LINK_SUPPLIER										= UIFactory.getElements("ACTIONS_LINK_SUPPLIER");
	static UI_Elements	EDIT_LINK_SUPPLIER											= UIFactory.getElements("EDIT_LINK_SUPPLIER");
	static UI_Elements	DISCARD_LINK_SUPPLIER										= UIFactory.getElements("DISCARD_LINK_SUPPLIER");
	static UI_Elements	ITEM_SCOPE													= UIFactory.getElements("ITEM_SCOPE");
	static UI_Elements	ITEM_SCOPE_LABEL_ADD_SUPPLIER_PAGE							= UIFactory.getElements("ITEM_SCOPE_LABEL_ADD_SUPPLIER_PAGE");
	static UI_Elements	LINK_UPDATE_ALL_LINES_ITEM_MASTER							= UIFactory.getElements("LINK_UPDATE_ALL_LINES_ITEM_MASTER");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_PRODUCT_CATEGORY						= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_PRODUCT_CATEGORY");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_CURRENCY								= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_CURRENCY");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_UOM										= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_UOM");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_MANUFACTURER_NAME						= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_MANUFACTURER_NAME");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_MANUFACTURER_URL						= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_MANUFACTURER_URL");
	static UI_Elements	TEXTBOX_UPDATE_ITEM_DELIVERY_LEAD_TIME						= UIFactory.getElements("TEXTBOX_UPDATE_ITEM_DELIVERY_LEAD_TIME");
	static UI_Elements	UPDATE_ITEM_CLOSE											= UIFactory.getElements("UPDATE_ITEM_CLOSE");
	static UI_Elements	UPDATE_ITEM_UPDATE_BUTTON									= UIFactory.getElements("UPDATE_ITEM_UPDATE_BUTTON");
	static UI_Elements	UPDATE_ITEM_CLOSE_LINK										= UIFactory.getElements("UPDATE_ITEM_CLOSE_LINK");
	static UI_Elements	ATTACHMENT_FILE_LIST_ATTACHMENT_NAME						= UIFactory.getElements("ATTACHMENT_FILE_LIST_ATTACHMENT_NAME");
	static UI_Elements	TEXTBOX_ITEM_CURRENCY										= UIFactory.getElements("TEXTBOX_ITEM_CURRENCY");

	static UI_Elements	BUTTON_UPDATE_SUPPLIER										= UIFactory.getElements("BUTTON_UPDATE_SUPPLIER");
	static UI_Elements	BUTTON_ADD_EXISTING_SUPPLIER								= UIFactory.getElements("BUTTON_ADD_EXISTING_SUPPLIER");
	static UI_Elements	TEXTBOX_CURRENCY_ITEM										= UIFactory.getElements("TEXTBOX_CURRENCY_ITEM");
	static UI_Elements	ACTIVE_SUPPLIER_YES											= UIFactory.getElements("ACTIVE_SUPPLIER_YES");
	static UI_Elements	ACTIVE_SUPPLIER_NO											= UIFactory.getElements("ACTIVE_SUPPLIER_NO");

	//file upload
	static UI_Elements	Duplicate_ERP_Part_Number_Link								= UIFactory.getElements("Duplicate_ERP_Part_Number_Link");

	//error messages
	static UI_Elements	Supplier_Name_Mandatory_Error_Message						= UIFactory.getElements("Supplier_Name_Mandatory_Error_Message");
	static UI_Elements	Supplier_Part_ID_Mandatory_Error_Message					= UIFactory.getElements("Supplier_Part_ID_Mandatory_Error_Message");
	static UI_Elements	Supplier_Item_Price_Mandatory_Error_Message					= UIFactory.getElements("Supplier_Item_Price_Mandatory_Error_Message");

	// item checkbox
	static UI_Elements	CHECKBOX_SECOND_ITEM_FROM_ITEM_MASTER						= UIFactory.getElements("CHECKBOX_SECOND_ITEM_FROM_ITEM_MASTER");
	static UI_Elements	CHECKBOX_THIRD_ITEM_FROM_ITEM_MASTER						= UIFactory.getElements("CHECKBOX_THIRD_ITEM_FROM_ITEM_MASTER");

	// edit item 
	static UI_Elements	EDIT_THIRD_ITEM												= UIFactory.getElements("EDIT_THIRD_ITEM");
	static UI_Elements	EDIT_SECOND_ITEM											= UIFactory.getElements("EDIT_SECOND_ITEM");

	//actions link
	static UI_Elements	ACTIONS_LINK_SECOND_ITEM									= UIFactory.getElements("ACTIONS_LINK_SECOND_ITEM");
	static UI_Elements	ACTIONS_LINK_THIRD_ITEM										= UIFactory.getElements("ACTIONS_LINK_THIRD_ITEM");

	//supplier validity dates

	static UI_Elements	TEXTBOX_FROM_SCOPE_VALIDITY_DATE							= UIFactory.getElements("TEXTBOX_FROM_SCOPE_VALIDITY_DATE");
	static UI_Elements	TEXTBOX_TO_SCOPE_VALIDITY_DATE								= UIFactory.getElements("TEXTBOX_TO_SCOPE_VALIDITY_DATE");
	static UI_Elements	DATE_PICKER_FROM											= UIFactory.getElements("DATE_PICKER_FROM");
	static UI_Elements	DATE_PICKER_TO												= UIFactory.getElements("DATE_PICKER_TO");

	//error box in file upload
	static UI_Elements	ERROR_BOX													= UIFactory.getElements("ERROR_BOX");

	//file upload error messages
	static UI_Elements	ERROR_INVALID_ERP_PART_NO_FILE								= UIFactory.getElements("ERROR_INVALID_ERP_PART_NO_FILE");
	static UI_Elements	ERROR_DUPLICATE_ERP_PART_NO_FILE							= UIFactory.getElements("ERROR_DUPLICATE_ERP_PART_NO_FILE");
	static UI_Elements	ERROR_MISSING_SHORT_DESCRIPTION								= UIFactory.getElements("ERROR_MISSING_SHORT_DESCRIPTION");
	static UI_Elements	ERROR_INVALID_UNIT_OF_MEASURE								= UIFactory.getElements("ERROR_INVALID_UNIT_OF_MEASURE");
	static UI_Elements	ERROR_MISSING_CURRENCY										= UIFactory.getElements("ERROR_MISSING_CURRENCY");
	static UI_Elements	ERROR_MISSING_UNIT_OF_MEASURE								= UIFactory.getElements("ERROR_MISSING_UNIT_OF_MEASURE");
	static UI_Elements	ERROR_INACTIVE_OR_INVALID_CURRENCY							= UIFactory.getElements("ERROR_INACTIVE_OR_INVALID_CURRENCY");

	static UI_Elements	ERROR_MISSING_PRODUCT_CATEGORY								= UIFactory.getElements("ERROR_MISSING_PRODUCT_CATEGORY");
	static UI_Elements	ERROR_INVALID_PRICE											= UIFactory.getElements("ERROR_INVALID_PRICE");

	static UI_Elements	ERROR_INVALID_SUPPLIER_ID									= UIFactory.getElements("ERROR_INVALID_SUPPLIER_ID");
	static UI_Elements	ERROR_MISSING_SUPPLIER_ID									= UIFactory.getElements("ERROR_MISSING_SUPPLIER_ID");
	static UI_Elements	ERROR_INVALID_LEAD_TIME										= UIFactory.getElements("ERROR_INVALID_LEAD_TIME");

	public String fillSupplierPartId(WebDriver driver, String testCaseName, String supplierPartId) throws ActionBotException;

	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException;

	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws Exception;

	public double fillPrice(WebDriver driver, String testCaseName, double price) throws ActionBotException;

	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddAndContinueButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillItemCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public void clickOnUpdateCatalogItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException;

	public String fillItemUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException;

	public String getSupplierId(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String fillERPPartId(WebDriver driver, String testCaseName, String erpPartId) throws ActionBotException;

	public String fillMarketPrice(WebDriver driver, String testCaseName, String string) throws ActionBotException;

	public boolean isERPIdEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonAddSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnActionsLinkOfItemInItemMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscardItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonAddSupplierWhileUpdatingItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isERPIdPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickItemCheckBoxItemMaster(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillProductURL(WebDriver driver, String testCaseName, String productURL) throws ActionBotException;

	public String fillERPPartNo(WebDriver driver, String testCaseName, String ERPPartNo) throws ActionBotException;

	public String fillManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException;

	public String fillManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException;

	public String fillManufacturerURL(WebDriver driver, String testCaseName, String manufacturerURL) throws ActionBotException;

	public int fillDeliveryLeadDays(WebDriver driver, String testCaseName, int i) throws ActionBotException;

	public boolean checkIsGreen(WebDriver driver, String testCaseName, boolean isGreen) throws ActionBotException;

	public boolean checkIsPreferred(WebDriver driver, String testCaseName, boolean isPreferred) throws ActionBotException;

	public String fillSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException;

	public String fillSpecificationType(WebDriver driver, String testCaseName, String specificationType) throws ActionBotException;

	public String fillSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException;

	public boolean uploadAttachments(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillAttachmentURL(WebDriver driver, String testCaseName, List<String> attachmentURL) throws ActionBotException;

	public String fillItemDescription(WebDriver driver, String testCaseName, String itemDescription) throws ActionBotException;

	public boolean selectItemImage(WebDriver driver, String testCaseName, String imageFile) throws ActionBotException;

	public boolean isSelectItemImagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssetNumberingFieldEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAttachmentLinkEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isManufacturePartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isManufacturerNameEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSpecificationsNameEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSpecificationsTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSpecificationsValueEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMarketPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUOMEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReceiveByEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isShortDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isERPPartNoEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isShortDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isERPPartNoMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemTypeMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductCategoryMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUOMMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectFileButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	// public boolean isItemScopeMandatory(WebDriver driver, String
	// testCaseName) throws ActionBotException;
	public void clickOnUpdateSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductURLEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryTimeEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPreferredYesPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPreferredNoPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductURLPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemCurrencyMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPriceMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPartIdMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscardSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchBoxSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void clickOnGoButtonSupplierSearch(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearSearchResults(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfSuppliers(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCancelAndCloseIconPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getColumnNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLastUpdatedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void uploadAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException;

	public void fillSingleAttachmentURL(WebDriver driver, String testCaseName, String URL) throws ActionBotException;

	public String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemScopeOfAddSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemScopeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemProductCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemCurrencyPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemUOMPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemManufacturerNamePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemManufacturerURLPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUpdateItemDeliveryLeadTime(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemUpdateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemCloseLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateItemCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateItemUpdateButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateItemCloseLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateItemCloseButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfAddedAttachments(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyItemEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyItemPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void setActiveSupplierYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void setActiveSupplierNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDuplicateERPPartNoErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//supplier page error messages

	public boolean isSupplierNameMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierPartIdMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierItemPriceMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//item checkbox

	public void clickSecondItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickThirdItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	//edit item link

	public void clickOnEditSecondItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditThirdItem(WebDriver driver, String testCaseName) throws ActionBotException;

	//actions link 

	public void clickOnActionsLinkSecondItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActionsLinkThirdItem(WebDriver driver, String testCaseName) throws ActionBotException;

	// supplier validity

	public boolean isFromValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isToValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	//error box

	public boolean isErrorBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//file error messages

	public boolean isInvalidERPPartNoErrorMessageForFilePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDuplicateSupplierPartIDPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMissingShortDescriptionErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMissingCurrencyErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMissingUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCurrencyInvalidOrInactiveErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMissingProductCategoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidPriceErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidSupplierPartIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMissingSupplierIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidLeadTimeErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//count characters

	public int getNumberOfCharactersShortDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNumberOfCharactersManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNumberOfCharactersItemDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNumberOfCharactersManufacturePartId(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNumberOfCharactersProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

}
