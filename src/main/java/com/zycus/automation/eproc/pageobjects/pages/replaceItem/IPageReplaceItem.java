package com.zycus.automation.eproc.pageobjects.pages.replaceItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageReplaceItem
{

	final static UI_Elements	BUTTON_REPLACE_ITEM												= UIFactory.getElements("BUTTON_REPLACE_ITEM");
	final static UI_Elements	BUTTON_CANCEL_AND_GO_BACK										= UIFactory.getElements("BUTTON_CANCEL_AND_GO_BACK");
	final static UI_Elements	TEXTBOX_CHANGE_COMMENTS											= UIFactory.getElements("TEXTBOX_CHANGE_COMMENTS");
	final static UI_Elements	BUTTON_CONFIRM_REPLACE_BUYER_ITEM								= UIFactory.getElements("BUTTON_CONFIRM_REPLACE_BUYER_ITEM");
	final static UI_Elements	BUTTON_CANCEL_REPLACE_BUYER_ITEM								= UIFactory.getElements("BUTTON_CANCEL_REPLACE_BUYER_ITEM");
	final static UI_Elements	RADIO_BUTTON_ITEM_LIST											= UIFactory.getElements("RADIO_BUTTON_ITEM_LIST");

	final static UI_Elements	TEXT_PAGE_HEADER												= UIFactory.getElements("TEXT_PAGE_HEADER");
	final static UI_Elements	TEXT_DESCRIPTION												= UIFactory.getElements("TEXT_DESCRIPTION");

	// items on Replace Item Page
	final static UI_Elements	ITEM_IMAGE														= UIFactory.getElements("ITEM_IMAGE");
	final static UI_Elements	ITEM_NAME_REPLACE_ITEM											= UIFactory.getElements("ITEM_NAME_REPLACE_ITEM");
	final static UI_Elements	ITEM_DESCRIPTION												= UIFactory.getElements("ITEM_DESCRIPTION");
	final static UI_Elements	ITEM_SUPPLIER_NAME												= UIFactory.getElements("ITEM_SUPPLIER_NAME");
	final static UI_Elements	ITEM_LEAD_TIME													= UIFactory.getElements("ITEM_LEAD_TIME");
	final static UI_Elements	ICON_IS_GREEN													= UIFactory.getElements("ICON_IS_GREEN");
	final static UI_Elements	ICON_IS_PREFERRED												= UIFactory.getElements("ICON_IS_PREFERRED");
	final static UI_Elements	ITEM_PRICE_REPLACE_ITEM_PAGE									= UIFactory.getElements("ITEM_PRICE_REPLACE_ITEM_PAGE");

	// item under replace item 'item details' popup window
	final static UI_Elements	POPUP_ITEM_DETAILS												= UIFactory.getElements("POPUP_ITEM_DETAILS");
	final static UI_Elements	ITEM_NAME_POPUP_ITEM_DETAILS									= UIFactory.getElements("ITEM_NAME_POPUP_ITEM_DETAILS");
	final static UI_Elements	ITEM_PART_ID_POPUP_ITEM_DETAILS									= UIFactory.getElements("ITEM_PART_ID_POPUP_ITEM_DETAILS");
	final static UI_Elements	ITEM_PRICE_POPUP_ITEM_DETAILS									= UIFactory.getElements("ITEM_PRICE_POPUP_ITEM_DETAILS");
	final static UI_Elements	ICON_IS_GREEN_POPUP_ITEM_DETAILS								= UIFactory.getElements("ICON_IS_GREEN_POPUP_ITEM_DETAILS");
	final static UI_Elements	ICON_IS_PREFERRED_POPUP_ITEM_DETAILS							= UIFactory.getElements("ICON_IS_PREFERRED_POPUP_ITEM_DETAILS");
	final static UI_Elements	TAB_DETAILS_POPUP_ITEM_DETAILS									= UIFactory.getElements("TAB_DETAILS_POPUP_ITEM_DETAILS");
	final static UI_Elements	TAB_SPECIFICATION_POPUP_ITEM_DETAILS							= UIFactory.getElements("TAB_SPECIFICATION_POPUP_ITEM_DETAILS");
	final static UI_Elements	TAB_ATTACHMENT_POPUP_ITEM_DETAILS								= UIFactory.getElements("TAB_ATTACHMENT_POPUP_ITEM_DETAILS");
	final static UI_Elements	BUTTON_CLOSE_ITEM_POPUP_REPLACE_ITEM							= UIFactory.getElements("BUTTON_CLOSE_ITEM_POPUP_REPLACE_ITEM");

	// items under details tab on popup window
	final static UI_Elements	LABEL_DESCRIPTION_TAB_DETAILS_POPUP_REPLACE_ITEM				= UIFactory.getElements("LABEL_DESCRIPTION_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_MANUFACTURER_TAB_DETAILS_POPUP_REPLACE_ITEM				= UIFactory.getElements("LABEL_MANUFACTURER_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_CATEGORY_TAB_DETAILS_POPUP_REPLACE_ITEM					= UIFactory.getElements("LABEL_CATEGORY_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_SPSC_TAB_DETAILS_POPUP_REPLACE_ITEM						= UIFactory.getElements("LABEL_SPSC_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_SUPPLIER_TAB_DETAILS_POPUP_REPLACE_ITEM					= UIFactory.getElements("LABEL_SUPPLIER_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_DELIVERY_TAB_DETAILS_POPUP_REPLACE_ITEM					= UIFactory.getElements("LABEL_DELIVERY_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_CONTRACT_TAB_DETAILS_POPUP_REPLACE_ITEM					= UIFactory.getElements("LABEL_CONTRACT_TAB_DETAILS_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_SPECIFICATION_NAME_TAB_SPECIFICATION_POPUP_REPLACE_ITEM	= UIFactory
		.getElements("LABEL_SPECIFICATION_NAME_TAB_SPECIFICATION_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_SPECIFICATION_KEY_TAB_SPECIFICATION_POPUP_REPLACE_ITEM	= UIFactory
		.getElements("LABEL_SPECIFICATION_KEY_TAB_SPECIFICATION_POPUP_REPLACE_ITEM");
	final static UI_Elements	LABEL_SPECIFICATION_VALUE_TAB_SPECIFICATION_POPUP_REPLACE_ITEM	= UIFactory
		.getElements("LABEL_SPECIFICATION_VALUE_TAB_SPECIFICATION_POPUP_REPLACE_ITEM");
	final static UI_Elements	LINK_TAB_ATTACHMENT_POPUP_REPLACE_ITEM							= UIFactory.getElements("LINK_TAB_ATTACHMENT_POPUP_REPLACE_ITEM");
	final static UI_Elements	RADIO_BUTTON_ITEM_GRID											= UIFactory.getElements("RADIO_BUTTON_ITEM_GRID");
	final static UI_Elements	BUTTON_ALERT_OK_REPLACE_ITEM									= UIFactory.getElements("BUTTON_ALERT_OK_REPLACE_ITEM");
	final static UI_Elements	LABEL_GET_ITEM_QUANTITY											= UIFactory.getElements("LABEL_GET_ITEM_QUANTITY");
	final static UI_Elements	TEXT_REPLACE_ITEM_QUANTITY										= UIFactory.getElements("TEXT_REPLACE_ITEM_QUANTITY");
	final static UI_Elements	LINK_CANCEL_REPLACE_BUYER_ITEM									= UIFactory.getElements("LINK_CANCEL_REPLACE_BUYER_ITEM");
	final static UI_Elements	BUTTON_REPLACE_ITEMS_POPUP										= UIFactory.getElements("BUTTON_REPLACE_ITEMS_POPUP");

	public void clickOnRadioItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRadioItemGrid(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReplaceItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillChangeComment(WebDriver driver, String testCaseName, String changeComment) throws ActionBotException;

	public void clickOnConfirm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReplaceItemPageHeaderText(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyReplaceButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyCancelAndGoBackButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCancelAndGoBackButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterproductDescription(WebDriver driver, String testCaseName, String productDescription) throws ActionBotException;

	public void clearProductDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSearchResultDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemImageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemDescriptionDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemLeadTimeDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isIconIsGreenDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isIconIsPreferredDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemPriceDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNameInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemPartIdInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemPriceInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isIconIsGreenInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isIconIsPreferredInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTabDetailsInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTabSpecificationInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTabAttachmentInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickCloseOnItemPopUpByXpath(WebDriver driver, String testCaseName, String xpath) throws ActionBotException;

	public boolean verifyFieldsOnDetailsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickDetailsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSpecificationTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickAttachmentsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyFieldsOnSpecificationTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyFieldsOnAttachmentsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickButtonAlertOk(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillReplaceItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyButtonConfirmDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyLinkCancelDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickReplaceFreeTextItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
