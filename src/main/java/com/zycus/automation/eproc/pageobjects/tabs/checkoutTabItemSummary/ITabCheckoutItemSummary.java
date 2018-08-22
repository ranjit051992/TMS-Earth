package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface ITabCheckoutItemSummary
{

	final static UI_Elements	ITEM_SUMMARY_DELIVERY_TAB		= UIFactory.getElements("ITEM_SUMMARY_DELIVERY_TAB");
	final static UI_Elements	ITEM_SUMMARY_COSTBOOKING_TAB	= UIFactory.getElements("ITEM_SUMMARY_COSTBOOKING_TAB");
	final static UI_Elements	ITEM_SUMMARY_ACCOUNTING_TAB		= UIFactory.getElements("ITEM_SUMMARY_ACCOUNTING_TAB");
	final static UI_Elements	ITEM_SUMMARY_ATTACHMENTS_TAB	= UIFactory.getElements("ITEM_SUMMARY_ATTACHMENTS_TAB");
	final static UI_Elements	ITEM_SUMMARY_MISCELLANEOUS_TAB	= UIFactory.getElements("ITEM_SUMMARY_MISCELLANEOUS_TAB");
	final static UI_Elements	ITEM_SUMMARY_ASSIGNED_BUYER_TAB	= UIFactory.getElements("ITEM_SUMMARY_ASSIGNED_BUYER_TAB");

	void clickItemSummaryAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummaryAttachmentTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummaryCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummaryAssignedBuyerTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemSummaryMiscellaneousTab(WebDriver driver, String testCaseName) throws ActionBotException;

}
