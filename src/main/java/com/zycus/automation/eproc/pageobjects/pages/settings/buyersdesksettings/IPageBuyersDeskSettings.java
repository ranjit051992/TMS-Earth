package com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageBuyersDeskSettings
{

	// NOTIFY_REQUESTER_ON_CHANGE
	final static UI_Elements	NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_YES								= UIFactory.getElements("NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_YES");
	final static UI_Elements	NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_NO								= UIFactory.getElements("NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_NO");

	// ALLOW_BUYER_TO_ADD_ITEM_IN_REQ
	final static UI_Elements	ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_YES									= UIFactory.getElements("ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_YES");
	final static UI_Elements	ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_NO									= UIFactory.getElements("ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_NO");

	// ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ
	final static UI_Elements	ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_YES								= UIFactory.getElements("ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_YES");
	final static UI_Elements	ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_NO								= UIFactory.getElements("ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_NO");

	// ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN
	// MINIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN_BY_VALUE		= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN_BY_VALUE");
	// MAXIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE		= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE");
	// ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT
	// MINIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MIN_BY_VALUE	= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MIN_BY_VALUE");
	// MAXIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MAX_BY_VALUE	= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MAX_BY_VALUE");
	// ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATELOG
	// MINIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MIN_BY_VALUE	= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MIN_BY_VALUE");
	// MAXIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MAX_BY_VALUE	= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MAX_BY_VALUE");
	// ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATELOG
	// MINIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MIN_BY_VALUE		= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MIN_BY_VALUE");
	// MAXIMUM
	final static UI_Elements	ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MAX_BY_VALUE		= UIFactory
		.getElements("ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MAX_BY_VALUE");

	final static UI_Elements	BUYERS_DESK_SETTINGS_SAVE_BUTTON									= UIFactory.getElements("BUYERS_DESK_SETTINGS_SAVE_BUTTON");
	final static UI_Elements	BUYERS_DESK_SETTINGS_CANCEL_BUTTON									= UIFactory.getElements("BUYERS_DESK_SETTINGS_CANCEL_BUTTON");

	final static UI_Elements	BUYERS_DESK_SETTING_SUCCESS_MSG										= UIFactory.getElements("BUYERS_DESK_SETTING_SUCCESS_MSG");
	final static UI_Elements	BUYERS_DESK_SETTING__ITEM_RECIEVED_BY_QUANTITY						= UIFactory.getElements("BUYERS_DESK_SETTING__ITEM_RECIEVED_BY_QUANTITY");

	// Allows Buyer to change PR's for newly added items
	final static UI_Elements	RADIO_BUTTON_ALLOW_PR_SMALLER										= UIFactory.getElements("RADIO_BUTTON_ALLOW_PR_SMALLER");
	final static UI_Elements	RADIO_BUTTON_ALLOW_PR_LARGER										= UIFactory.getElements("RADIO_BUTTON_ALLOW_PR_LARGER");
	final static UI_Elements	TEXT_ALLOW_PR_PERCENT_OF_TOTAL_AMOUNT								= UIFactory.getElements("TEXT_ALLOW_PR_PERCENT_OF_TOTAL_AMOUNT");
	final static UI_Elements	TEXT_ALLOW_PR_CURRENCY_UNITS										= UIFactory.getElements("TEXT_ALLOW_PR_CURRENCY_UNITS");
	final static UI_Elements	TEXT_ITEM_RECEIVED_BY_AMOUNT										= UIFactory.getElements("TEXT_ITEM_RECEIVED_BY_AMOUNT");
	final static UI_Elements	TEXT_PRICE_CONTROL_VIRTUAL_ITEM										= UIFactory.getElements("TEXT_PRICE_CONTROL_VIRTUAL_ITEM");

	final static UI_Elements	ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_YES		= UIFactory
		.getElements("ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_YES");

	final static UI_Elements	ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_NO		= UIFactory
		.getElements("ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_NO");

	// NOTIFY_REQUESTER_ON_CHANGE
	public boolean clickOnNotifyRequesterOnChangeToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnNotifyRequesterOnChangeToReq_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNotifyRequesterOnChangeToReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ
	public boolean clickOnAllowBuyerToReplaceItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToReplaceItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowBuyerToReplaceItemsInReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY
	public Integer fillReceivedByQuantity_Minimum(WebDriver driver, String testCaseName, int receivedByQuantityMin) throws ActionBotException;

	public Integer fillAllowBuyerItemRcvByQuantityTextBox(WebDriver driver, String testCaseName, int receivedByQuantity) throws ActionBotException;

	public Integer fillReceivedByQuantity_Maximum(WebDriver driver, String testCaseName, int receivedByQuantityMax) throws ActionBotException;

	public Integer getReceivedByQuantity_Minimum(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getReceivedByQuantity_Maximum(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT
	public Integer fillReceivedByAmount_Minimum(WebDriver driver, String testCaseName, int receivedByAmountMin) throws ActionBotException;

	public Integer fillReceivedByAmount_Maximum(WebDriver driver, String testCaseName, int receivedByAmountMax) throws ActionBotException;

	public Integer getReceivedByAmount_Minimum(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getReceivedByAmount_Maximum(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATELOG
	public Integer fillPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName, int minPriceSubTotalOfNonCatalogItems) throws ActionBotException;

	public Integer fillPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName, int maxPriceSubTotalOfNonCatalogItems) throws ActionBotException;

	public Integer getPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_ITEMS
	public Integer fillPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName, int PriceSubTotalOfCatalogItems) throws ActionBotException;

	public void clearPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearQuantitySubTotalReceivedByQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	// ALLOW_BUYER_TO_ADD_ITEM_IN_REQ
	public boolean clickOnAllowBuyerToAddItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToAddItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException;

	// Allows Buyer to change threshhold limit for newly added items.
	public boolean clickOnAllowPR_Smaller(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowPR_Larger(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterAllowPr_TotalAmount(WebDriver driver, String testCaseName, String prTotalAmount) throws ActionBotException;

	public String enterAllowPr_CurrencyUnits(WebDriver driver, String testCaseName, String prCurrencyUnits) throws ActionBotException;

	public void clearAllowPr_TotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearAllowPr_CurrencyUnits(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearItemReceivedByAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterItemReceivedByAmount(WebDriver driver, String testCaseName, String itemAmount) throws ActionBotException;

	public void clearPriceControlVirtualItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterPriceControlVirtualItem(WebDriver driver, String testCaseName, String priceControlValue) throws ActionBotException;

	public boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_No(WebDriver driver, String testCaseName) throws ActionBotException;

}
