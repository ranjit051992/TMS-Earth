package com.zycus.automation.eproc.pageobjects.modals.shoppingcart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalShoppingCart
{

	// UI ELEMENTS (STRING CONSTANST IN UI ELEMENTS)
	final static String			ITEM_ID								= ".//*[@id='grid_item_row_";
	final static String			ITEM_NAME							= ".//*[@id='grid_item_row_";
	final static String			ITEM_AVAILABILITY					= ".//*[@id='grid_item_row_";
	final static String			ITEM_QUANTITY						= ".//*[@id='cart_item_quantity_";
	final static String			ITEM_UPDATE							= ".//*[@id='cart_item_update_";
	final static String			ITEM_PRICE							= ".//*[@id='grid_item_row_subTotalPriceFormatted_";
	final static String			ITEM_DELETE							= ".//*[@id='cart_item_delete_";
	final static String			END_OF_XPATH						= "']";

	// UI ELEMENTS
	final static UI_Elements	ICON_EMPTY_CART						= UIFactory.getElements("ICON_EMPTY_CART");
	final static UI_Elements	LABEL_CART_TOTAL_PRICE				= UIFactory.getElements("LABEL_CART_TOTAL_PRICE");
	final static UI_Elements	BUTTON_CONTINUE_SHOPPING			= UIFactory.getElements("BUTTON_CONTINUE_SHOPPING");
	final static UI_Elements	ICON_SAVE_CART_AS_SHOPPING_BASKET	= UIFactory.getElements("ICON_SAVE_CART_AS_SHOPPING_BASKET");
	// MAPPED FROM ONLINE PAGE BUTTON
	final static UI_Elements	BUTTON_CHECKOUT_BUTTON				= IPageOnlineStore.BUTTON_CHECKOUT_BUTTON;
	final static UI_Elements	X_CLOSE_SHOPPING_CART				= UIFactory.getElements("CLOSE_SHOPPING_CART");
	final static UI_Elements	MODAL_SHOPPING_CART					= UIFactory.getElements("MODAL_SHOPPING_CART");

	// METHODS
	public void emptyCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void checkout(WebDriver driver, String testCaseName) throws ActionBotException;

	public void continueWithCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void deleteItemFromCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String fillItemQUantity(WebDriver driver, String testCaseName, String itemId, String quantity) throws ActionBotException;

	public void updateItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemAvailaibility(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getTotalPriceOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void saveCartAsShopppingBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void closeCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModalAppear(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemList(WebDriver driver, String testCaseName) throws ActionBotException;

	float getItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

}
