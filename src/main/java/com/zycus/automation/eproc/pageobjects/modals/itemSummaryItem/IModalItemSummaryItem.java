package com.zycus.automation.eproc.pageobjects.modals.itemSummaryItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemSummaryItem
{
	final static UI_Elements	TEXTBOX_QUANTITY_ITEM_SUMMARY		= UIFactory.getElements("TEXTBOX_QUANTITY_ITEM_SUMMARY");

	final static UI_Elements	MODAL_ITEM_CONTRACT_NO				= UIFactory.getElements("MODAL_ITEM_CONTRACT_NO");
	final static UI_Elements	MODAL_ITEM_SUMMARY_ITEM_DETAILS_TAB	= UIFactory.getElements("MODAL_ITEM_SUMMARY_ITEM_DETAILS_TAB");
	final static UI_Elements	MODAL_ITEM_PRICE_CURRENCY_LABEL		= UIFactory.getElements("MODAL_ITEM_PRICE_CURRENCY_LABEL");
	final static UI_Elements	TEXTBOX_CONTRACT_NO					= UIFactory.getElements("TEXTBOX_CONTRACT_NO");

	public Integer clearAndEnterQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public int getQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getModalItemContractNo(WebDriver driver) throws ActionBotException;

	public String getModalItemCurrencylabel(WebDriver driver) throws ActionBotException;

	public String fillModalItemContractNo(WebDriver driver, String testCSaseNmae, String contractNo) throws ActionBotException;

	public float clearAndEnterMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException;

	public float getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException;
}
