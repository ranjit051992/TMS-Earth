package com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOFreeTextItemSummaryItem
{
	final UI_Elements			TEXTBOX_LINE_NO								= UIFactory.getElements("TEXTBOX_LINE_NO");
	final UI_Elements			BUTTON_CANCEL_ITEM_SUMMARY					= UIFactory.getElements("BUTTON_CANCEL_ITEM_SUMMARY");
	final UI_Elements			FREETEXT_ITEM_NO							= UIFactory.getElements("FREETEXT_ITEM_NO");
	final UI_Elements			ENTER_VALID_URL_MSG							= UIFactory.getElements("ENTER_VALID_URL_MSG");
	final UI_Elements			TEXTBOX_IMAGE_URL							= UIFactory.getElements("TEXTBOX_IMAGE_URL");
	final UI_Elements			TEXTBOX_SHORT_DESCRIPTION					= UIFactory.getElements("TEXTBOX_SHORT_DESCRIPTION");
	final UI_Elements			TEXTBOX_PRODUCT_CATEGORY					= UIFactory.getElements("TEXTBOX_PRODUCT_CATEGORY");
	final UI_Elements			TEXTBOX_MARKET_PRICE						= UIFactory.getElements("TEXTBOX_MARKET_PRICE");
	final UI_Elements			TEXTBOX_QUANTITY							= UIFactory.getElements("TEXTBOX_QUANTITY");
	final UI_Elements			RADIO_BUTTON_GOODS							= UIFactory.getElements("RADIO_BUTTON_GOODS");
	final UI_Elements			RADIO_BUTTON_SERVICES						= UIFactory.getElements("RADIO_BUTTON_SERVICES");
	final UI_Elements			RADIO_BUTTON_QUANTITY						= UIFactory.getElements("RADIO_BUTTON_QUANTITY");
	final UI_Elements			RADIO_BUTTON_AMOUNT							= UIFactory.getElements("RADIO_BUTTON_AMOUNT");
	final UI_Elements			RADIO_BUTTON_NO_RECEIPT						= UIFactory.getElements("RADIO_BUTTON_NO_RECEIPT");
	final UI_Elements			TEXTBOX_UOM									= UIFactory.getElements("TEXTBOX_UOM");
	final UI_Elements			TEXTBOX_LONG_DESCRIPTION					= UIFactory.getElements("TEXTBOX_LONG_DESCRIPTION");
	final UI_Elements			TEXTBOX_ITEM_NO								= UIFactory.getElements("TEXTBOX_ITEM_NO");
	final UI_Elements			BUTTON_SAVE									= UIFactory.getElements("BUTTON_SAVE");

	final UI_Elements			ERROR_ITEM_SUMMARY							= UIFactory.getElements("ERROR_ITEM_SUMMARY");
	final UI_Elements			MODAL_ITEM_SUMMARY							= UIFactory.getElements("MODAL_ITEM_SUMMARY");
	final UI_Elements			IS_GREEN_RADIO_BUTTON						= UIFactory.getElements("IS_GREEN_RADIO_BUTTON");
	final UI_Elements			ERROR_ICON_SPECIFICATION					= UIFactory.getElements("ERROR_ICON_SPECIFICATION");
	final UI_Elements			TEXT_BOX_SPECIFICATIONS_DATA_VALUE			= UIFactory.getElements("TEXT_BOX_SPECIFICATIONS_DATA_VALUE");
	final UI_Elements			TEXT_BOX_SPECIFICATIONS_DATA_KEY			= UIFactory.getElements("TEXT_BOX_SPECIFICATIONS_DATA_KEY");
	final UI_Elements			TEXT_BOX_SPECIFICATIONS_NAME				= UIFactory.getElements("TEXT_BOX_SPECIFICATIONS_NAME");
	final UI_Elements			IS_PREFERRED_RADIO_BUTTON					= UIFactory.getElements("IS_PREFERRED_RADIO_BUTTON");
	static UI_Elements			LABEL_PRODUCT_CATEGORY_PO_FREE_TEXT_ITEM	= UIFactory.getElements("LABEL_PRODUCT_CATEGORY_PO_FREE_TEXT_ITEM");

	final static UI_Elements	BUTTON_ITEM_FREE_TEXT						= UIFactory.getElements("BUTTON_ITEM_FREE_TEXT");
	final static UI_Elements	ERROR_PRODUCT_CATEGORY						= UIFactory.getElements("ERROR_PRODUCT_CATEGORY");

	final static UI_Elements	ITEM_MODAL_CURRENCY_TYPE					= UIFactory.getElements("ITEM_MODAL_CURRENCY_TYPE");

	final static UI_Elements	TAB_ITEM_DETAILS_PO							= UIFactory.getElements("TAB_ITEM_DETAILS_PO");
	final static UI_Elements	TEXT_ITEM_NAME_LENGHT_VALIDATION_ERROR		= UIFactory.getElements("TEXT_ITEM_NAME_LENGHT_VALIDATION_ERROR");
	final static UI_Elements	ERROR_MARKET_PRICE_ITEM_SUMMARY				= UIFactory.getElements("ERROR_MARKET_PRICE_ITEM_SUMMARY");
	final static UI_Elements	ERROR_QUANTITY_ITEM_SUMMARY					= UIFactory.getElements("ERROR_QUANTITY_ITEM_SUMMARY");
	final static UI_Elements	ADD_NEW_SPECIFICATION_BUTTON				= UIFactory.getElements("ADD_NEW_SPECIFICATION_BUTTON");
	final static UI_Elements	CHECKBOX_ZERO_PRICE_ITEM					= UIFactory.getElements("CHECKBOX_ZERO_PRICE_ITEM");
	final static UI_Elements	TEXTBOX_MAX_TOTAL_PRICE						= UIFactory.getElements("TEXTBOX_MAX_TOTAL_PRICE");
	UI_Elements					TEXTBOX_MAX_UNIT_PRICE						= UIFactory.getElements("TEXTBOX_MAX_UNIT_PRICE");
	UI_Elements					LABEL_LINE_NO_FREE_TEXT_ITEM				= UIFactory.getElements("LABEL_LINE_NO_FREE_TEXT_ITEM");
	UI_Elements					LABEL_UNIT_PRICE_ITEM_DETAILS_PO			= UIFactory.getElements("LABEL_UNIT_PRICE_ITEM_DETAILS_PO");
	UI_Elements					LABEL_CURRENCY_ITEM_DETAILS_PO				= UIFactory.getElements("LABEL_CURRENCY_ITEM_DETAILS_PO");
	UI_Elements					LABEL_CURRENCY_GUIDED_ITEM_PO				= UIFactory.getElements("LABEL_CURRENCY_GUIDED_ITEM_PO");
	final UI_Elements			LINK_CANCEL_GUIDED_ITEM_PO					= UIFactory.getElements("LINK_CANCEL_GUIDED_ITEM_PO");
	final UI_Elements			LABEL_SPECIFICATION_NAME					= UIFactory.getElements("LABEL_SPECIFICATION_NAME");
	final UI_Elements			LINK_CANCEL									= UIFactory.getElements("LINK_CANCEL");
	final static UI_Elements	TEXT_PRODUCT_CATEGORY_PO					= UIFactory.getElements("TEXT_PRODUCT_CATEGORY_PO");
	final UI_Elements			TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM		= UIFactory.getElements("TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM");
	final UI_Elements			IS_ERROR_MESSAGE_DISPLAYED					= UIFactory.getElements("IS_ERROR_MESSAGE_DISPLAYED");
	UI_Elements					BUTTON_OK_CHANGE_CURRENCY					= UIFactory.getElements("BUTTON_OK_CHANGE_CURRENCY");

	public int getLineNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException;

	public String clearAndfillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException;

	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException;

	public String fillFreeTextItemNo(WebDriver driver, String testCaseName, String itemNo) throws ActionBotException;

	public float fillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException;

	public float clearAndfillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException;

	public float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException;

	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIsGreenRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIsPreferredRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceiveBillByQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceiveBillByAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceiveBillByNoReceipt(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddNewSpecificationBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getUOM(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer enterLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException;

	public String enterlongDescription(WebDriver driver, String testCaseName, String longDesc) throws ActionBotException;

	public String fillSpecificationsName(WebDriver driver, String testCaseName, String SpecificationName) throws ActionBotException;

	public String getSpecificationsName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSpecificationsDataKey(WebDriver driver, String testCaseName, String SpecificationsDataKey) throws ActionBotException;

	public String fillSpecificationsDataValue(WebDriver driver, String testCaseName, String SpecificationsDataValue) throws ActionBotException;

	public String fillModalItemImageUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException;

	public Integer enterItemNo(WebDriver driver, String testCaseName, int itemNo) throws ActionBotException;

	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterAndHoverOnProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException;

	public boolean isItemSummaryModalPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNullSpecificationKeyIcondisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isValidUrlMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTabErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isLineNoErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isLineNoErrorMessageCorrect(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnShortDescTextBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isLineNoFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isShortDescFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductCategoryFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMarketPriceFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isQuantityFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemDetail(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelBtnItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorPresentInProductCategoryValid(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemNameLenghtValidationErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMarketPriceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnZeroPriceItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearMaxTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public float fillMaxTotalPrice(WebDriver driver, String testCaseName, float maxTotalPrice) throws ActionBotException;

	public float fillMaxUnitPrice(WebDriver driver, String testCaseName, float maxUnitPrice) throws ActionBotException;

	public String getLabelValueOfCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public float getUnitPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public float getMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrencyOfMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException;

	int fillQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public boolean clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException;

	public String fillUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException, FactoryMethodException;

	public String fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException, FactoryMethodException;
}
