package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelItemSummaryDelivery
{

	final static UI_Elements	DELIVERY_OPTION_SINGLE_SPLIT						= UIFactory.getElements("DELIVERY_OPTION_SINGLE_SPLIT");
	final static UI_Elements	DELIVERY_OPTION_MULTI_SPLIT							= UIFactory.getElements("DELIVERY_OPTION_MULTI_SPLIT");
	final static UI_Elements	DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS				= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS");
	final static UI_Elements	DELIVERY_SINGLE_SPLIT_DELIVER_TO					= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_DELIVER_TO");
	final static UI_Elements	DELIVERY_SINGLE_SPLIT_REQUIRED_DATE					= UIFactory.getElements("DELIVERY_SINGLE_SPLIT_REQUIRED_DATE");
	final static UI_Elements	ITEMSUMMARY_ITEM_QUANTITY							= UIFactory.getElements("ITEMSUMMARY_ITEM_QUANTITY");
	UI_Elements					ERROR_INVALID_QUANTITY_ITEM_LEVEL_DELIVERY_DETAILS	= UIFactory.getElements("ERROR_INVALID_QUANTITY_ITEM_LEVEL_DELIVERY_DETAILS");
	UI_Elements					CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY");
	UI_Elements					LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY");

	UI_Elements					LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY				= UIFactory.getElements("LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY");

	UI_Elements					ICON_MANDATORY_ASSET_NO_DELIVERY_ITEM_SUMMARY		= UIFactory.getElements("ICON_MANDATORY_ASSET_NO_DELIVERY_ITEM_SUMMARY");
	UI_Elements					TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY				= UIFactory.getElements("TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY");
	UI_Elements					TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY");
	UI_Elements					TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY					= UIFactory.getElements("TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY");

	// for click

	void clickDeliveryAddMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	void clickDeliveryDeleteMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	// for fill
	String fillDeliveryMultiSplitAddress(WebDriver driver, String testCaseName, String multiSplitAddress, String itemID, int index) throws ActionBotException;

	String fillDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String multiSplitDeliverTo, String itemID, int index) throws ActionBotException;

	int fillDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, int multiSplitQuantity, String itemID, int index) throws ActionBotException;

	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemID, int index) throws ActionBotException;

	public String selectDeliveryUptoDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemID, int index) throws ActionBotException;

	// for get

	String getDeliveryMultiSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	String getDeliverySingleSplitDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliverySingleSplitDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliverySingleSplitRequiredDate(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliveryMultiSplitUptoDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	// for option selection

	boolean selectDeliveryOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException;

	int fillQuantityOrAmountOfDelivery(WebDriver driver, String testCaseName, int amount) throws ActionBotException;

	public boolean isDeliveryOnDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public boolean isDeliveryUptoDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public boolean isFromDateRequiredErrorPresent(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public String getFromDateRequiredError(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public String fillQuantityAtHeaderLevel(WebDriver driver, String testCaseName, String quantity) throws ActionBotException;

	public String getInvalidQuantityError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvalidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEnableAssetTaggingCheckboxEnabledOrNot(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEnableAssetTaggingCheckboxSelectedOrNot(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfEnableAssetTaggingCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException;

	public String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manufacturerSrNo) throws ActionBotException;

	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException;

	void clickCreateAssetTagsForThisItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

}
