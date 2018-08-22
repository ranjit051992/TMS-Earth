package com.zycus.automation.eproc.pageobjects.modals.itemSummaryDelivery;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemSummaryDelivery
{
	final static UI_Elements	REQ_BY_DATE_ITEM_LEVEL								= UIFactory.getElements("REQ_BY_DATE_ITEM_LEVEL");
	final static UI_Elements	REQUIRED_BY_DATE_PICKER								= UIFactory.getElements("REQUIRED_BY_DATE_PICKER");
	final static UI_Elements	SELECT_MONTH										= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements	SELECT_YEAR											= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements	REQUIRED_BY_DATE									= UIFactory.getElements("REQUIRED_BY_DATE");
	final static UI_Elements	MODAL_ITEM_SUMMARY_DELIVERY_TAB						= UIFactory.getElements("MODAL_ITEM_SUMMARY_DELIVERY_TAB");
	UI_Elements					CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY");
	UI_Elements					LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY");
	UI_Elements					LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY				= UIFactory.getElements("LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY");
	UI_Elements					ICON_MANDATORY_ASSET_NO_DELIVERY_ITEM_SUMMARY		= UIFactory.getElements("ICON_MANDATORY_ASSET_NO_DELIVERY_ITEM_SUMMARY");
	UI_Elements					TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY				= UIFactory.getElements("TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY");

	UI_Elements					TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY	= UIFactory.getElements("TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY");

	UI_Elements					TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY					= UIFactory.getElements("TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY");
	UI_Elements					ERROR_ICON_ASSET_NO_REQUIRED						= UIFactory.getElements("ERROR_ICON_ASSET_NO_REQUIRED");
	UI_Elements					DELIVERY_MYADDRESS_RADIO_BUTTON						= UIFactory.getElements("DELIVERY_MYADDRESS_RADIO_BUTTON");
	UI_Elements					PO_OTHER_ADDRESS									= UIFactory.getElements("PO_OTHER_ADDRESS");

	public String fillRequiredByDateAtItemLevel(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public void clickOnItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCreateAssetTagForThisItemCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCreateAssetTagForThisItemCheckboxEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getValueOFCreateAssetTagForThisItemCheckboxLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFirstAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException;

	public String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manuSrNo) throws ActionBotException;

	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException;

	public String getAssetNoError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String changeDeliveryOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException;

}
