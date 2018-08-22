package com.zycus.automation.eproc.pageobjects.modals.discountstandardpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalDiscountPO
{
	final static UI_Elements	TEXTBOX_DISCOUNT_AMOUNT											= UIFactory.getElements("TEXTBOX_DISCOUNT_AMOUNT");
	final static UI_Elements	TOTAL_PO_AMOUNT													= UIFactory.getElements("TOTAL_PO_AMOUNT");
	final static UI_Elements	LINK_CANCEL_MODAL_DISCOUNT										= UIFactory.getElements("LINK_CANCEL_MODAL_DISCOUNT");
	final static UI_Elements	TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG				= UIFactory.getElements("TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG");
	final static UI_Elements	TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG_ITEM_LEVEL	= UIFactory
		.getElements("TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG_ITEM_LEVEL");
	final static UI_Elements	BUTTON_SAVE_DISCOUNT											= UIFactory.getElements("BUTTON_SAVE_DISCOUNT");
	final static UI_Elements	DISCOUNTED_PRICE												= UIFactory.getElements("DISCOUNTED_PRICE");
	final static UI_Elements	BUTTON_ITEM_LEVEL_DISCOUNT										= UIFactory.getElements("BUTTON_ITEM_LEVEL_DISCOUNT");
	final static UI_Elements	SELECT_ITEM_LEVEL_DISCOUNT_TYPE									= UIFactory.getElements("SELECT_ITEM_LEVEL_DISCOUNT_TYPE");
	final static UI_Elements	TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE								= UIFactory.getElements("TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE");
	final static UI_Elements	TEXTBOX_ITEM_LEVEL_DISCOUNT_AMOUNT								= UIFactory.getElements("TEXTBOX_ITEM_LEVEL_DISCOUNT_AMOUNT");
	final static UI_Elements	ALERT_DISCOUNT_MODAL_PO											= UIFactory.getElements("ALERT_DISCOUNT_MODAL_PO");
	final static UI_Elements	ERROR_ICON_DISCOUNT_MORE_THEN_ITEM_PRICE_HEADER_LEVEL			= UIFactory.getElements("ERROR_ICON_DISCOUNT_MORE_THEN_ITEM_PRICE_HEADER_LEVEL");
	final static UI_Elements	ERROR_MESSAGE_DISCOUNT_MORE_THEN_ITEM_PRICE						= UIFactory.getElements("ERROR_MESSAGE_DISCOUNT_MORE_THEN_ITEM_PRICE");
	final static UI_Elements	ERROR_ICON_ITEM_LEVEL_DISCOUNT									= UIFactory.getElements("ERROR_ICON_ITEM_LEVEL_DISCOUNT");
	final static UI_Elements	ERROR_APPLY_TO_ALL_ITEM_LEVEL_DISCOUNT							= UIFactory.getElements("ERROR_APPLY_TO_ALL_ITEM_LEVEL_DISCOUNT");
	final static UI_Elements	TEXTBOX_APPLY_TO_ALL_DISCOUNT									= UIFactory.getElements("TEXTBOX_APPLY_TO_ALL_DISCOUNT");
	final static UI_Elements	LINK_APPLY_TO_ALL_DISCOUNT										= UIFactory.getElements("LINK_APPLY_TO_ALL_DISCOUNT");
	final static UI_Elements	RADIO_BUTTON_DISCOUNT_ON_ENTIRE_ORDER							= UIFactory.getElements("RADIO_BUTTON_DISCOUNT_ON_ENTIRE_ORDER");
	final static UI_Elements	ALERT_DISCOUNT_AT_HEADER_LEVEL_NOT_ALLOWED						= UIFactory.getElements("ALERT_DISCOUNT_AT_HEADER_LEVEL_NOT_ALLOWED");

	public Integer fillDiscountAmount(WebDriver driver, String testCaseName, int discount) throws ActionBotException;

	public void clickOnSaveDiscount(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getDiscountedPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDiscountedPriceEqualToDiscountedAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalPoAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemLevelTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectItemLevelDiscountType(WebDriver driver, String testCaseName, String type) throws ActionBotException;

	public Integer enterItemLevelDiscountValue(WebDriver driver, String testCaseName, int value) throws ActionBotException;

	public void clickOnItemLevelTotalDiscount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscountModalCancelLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public Double getItemLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public Double getHeaderLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertInDiscountPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isHeaderLevelDiscountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isHeaderLevelDiscountErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemLevelErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isApplyToAllErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillApplyToAllDiscount(WebDriver driver, String testCaseName, int discount) throws ActionBotException;

	public void clickOnApplyToAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscountOnEntireOrder(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertOfHeaderLevelDiscountNotAllowedPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectItemLevelDiscountIndexwise(WebDriver driver, String testCaseName, int index, String discountType) throws ActionBotException;

	public void fillItemLevelDiscountValueIndexwise(WebDriver driver, String testCaseName, int index, int discountValue) throws ActionBotException;
}
