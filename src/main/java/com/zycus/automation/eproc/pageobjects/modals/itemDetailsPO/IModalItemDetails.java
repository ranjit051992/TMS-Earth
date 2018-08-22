package com.zycus.automation.eproc.pageobjects.modals.itemDetailsPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemDetails
{
	public static final UI_Elements	CATALOG_ITEM_LABEL_ITEM_DETAILS	= UIFactory.getElements("CATALOG_ITEM_LABEL_ITEM_DETAILS");
	final UI_Elements	BUTTON_ADD_TO_CART_PO			= UIFactory.getElements("BUTTON_ADD_TO_CART_PO");
	final UI_Elements	BUTTON_ADD_TO_FAVORITES			= UIFactory.getElements("BUTTON_ADD_TO_FAVORITES");
	final UI_Elements	BUTTON_ADD_TO_BASKET			= UIFactory.getElements("BUTTON_ADD_TO_BASKET");
	final UI_Elements	TEXTBOX_ADD_ITEMS_TO_PO			= UIFactory.getElements("TEXTBOX_ADD_ITEMS_TO_PO");
	final UI_Elements	BUTTON_CLOSE_MODAL_ITEM_DETAILS	= UIFactory.getElements("BUTTON_CLOSE_MODAL_ITEM_DETAILS");

	public boolean checkIsCatalogItemSameAsSelected(WebDriver driver, int index) throws ActionBotException;

	public boolean isAddPresentInItemDetail(WebDriver driver, int index) throws ActionBotException;

	public boolean isMaxCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException;

	public boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException;

	public boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException;

	public boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException;

	public boolean isAddToCartPresentInItemDetail(WebDriver driver) throws ActionBotException;

	public boolean isAddToFavoritesPresentInItemDetail(WebDriver driver) throws ActionBotException;

	public boolean isAddToBasketPresentInItemDetail(WebDriver driver) throws ActionBotException;

	public boolean isItemNamePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	//click on close button
	public void clickOnCloseButton(WebDriver driver) throws ActionBotException;
}
