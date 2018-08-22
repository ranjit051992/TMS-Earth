package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ReadyToCheckout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalFreeTextReadyToCheckOut
{

	final static UI_Elements	CATEGORY					= UIFactory.getElements("CATEGORY");
	final static UI_Elements	SPSC_CODE					= UIFactory.getElements("SPSC_CODE");
	final static UI_Elements	ITEM_NAME_FREE_TEXT_PAGE	= UIFactory.getElements("ITEM_NAME_FREE_TEXT_PAGE");
	final static UI_Elements	ITEM_AMOUNT_N_CURR			= UIFactory.getElements("ITEM_AMOUNT_N_CURR");
	final static UI_Elements	CHECKOUT_BTN				= UIFactory.getElements("CHECKOUT_BTN");
	final static UI_Elements	ADD_ANOTHER_ITEM			= UIFactory.getElements("ADD_ANOTHER_ITEM");
	final static UI_Elements	VIEW_ITEMS_IN_CART			= UIFactory.getElements("VIEW_ITEMS_IN_CART");

	void toClickCheckoutBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickAddAnotherItemBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickViewItemsInCartLink(WebDriver driver, String testcaseName) throws ActionBotException;

	String getItemName(WebDriver driver, String testcaseName) throws ActionBotException;

	String getItemAmountAndCurrency(WebDriver driver, String testcaseName) throws ActionBotException;

	String getCategory(WebDriver driver, String testcaseName) throws ActionBotException;

	String getSPSCCode(WebDriver driver, String testcaseName) throws ActionBotException;

}
