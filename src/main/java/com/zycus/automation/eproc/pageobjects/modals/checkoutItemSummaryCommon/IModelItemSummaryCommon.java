package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelItemSummaryCommon
{

	final static UI_Elements	ITEMSUMMARY_SAVE			= UIFactory.getElements("ITEMSUMMARY_SAVE");
	final static UI_Elements	ITEMSUMMARY_CANCLE			= UIFactory.getElements("ITEMSUMMARY_CANCLE");
	final static UI_Elements	ITEMSUMMARY_ITEM_TOTALPRICE	= UIFactory.getElements("ITEMSUMMARY_ITEM_TOTALPRICE");
	final static UI_Elements	ITEMSUMMARY_ITEM_QUANTITY	= UIFactory.getElements("ITEMSUMMARY_ITEM_QUANTITY");
	final static UI_Elements	ITEMSUMMARY_ITEM_NAME		= UIFactory.getElements("ITEMSUMMARY_ITEM_NAME");
	final static UI_Elements	ITEMSUMMARY_ITEM_SUPPLIER	= UIFactory.getElements("ITEMSUMMARY_ITEM_SUPPLIER");

	// for click

	void clickItemSummaryCancle(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummarySave(WebDriver driver, String testCaseName) throws ActionBotException;

	// for get

	String getItemSummaryItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemSummaryItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemSummaryItemSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemSummaryItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

}
