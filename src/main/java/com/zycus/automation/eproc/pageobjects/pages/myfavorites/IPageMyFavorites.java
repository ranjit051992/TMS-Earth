/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.myfavorites;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public interface IPageMyFavorites
{

	final static UI_Elements	TEXTBOX_SEARCH_FAVORITE				= UIFactory.getElements("TEXTBOX_SEARCH_FAVORITE");
	final static UI_Elements	SELECT_SEARCH_FAVORITE_BY			= UIFactory.getElements("SELECT_SEARCH_FAVORITE_BY");
	final static UI_Elements	BUTTON_SEARCH_FAVORITE_GO			= UIFactory.getElements("BUTTON_SEARCH_FAVORITE_GO");
	final static UI_Elements	FAVORITE_LIST_PROCESSING			= UIFactory.getElements("FAVORITE_LIST_PROCESSING");
	final static UI_Elements	FAVORITE_ITEM_NAMES					= UIFactory.getElements("FAVORITE_ITEM_NAMES");
	final static UI_Elements	BUTTON_REMOVE_FAVORITE_ITEM			= UIFactory.getElements("BUTTON_REMOVE_FAVORITE_ITEM");

	final static UI_Elements	BUTTON_REMOVE_FAVORITE_ITEM1		= UIFactory.getElements("BUTTON_REMOVE_FAVORITE_ITEM1");
	final static UI_Elements	BUTTON_ADD_FAVORITE_ITEM_TO_CART	= UIFactory.getElements("BUTTON_ADD_FAVORITE_ITEM_TO_CART");
	final static UI_Elements	BUTTON_ADD_FAVORITE_ITEM_TO_BASKET	= UIFactory.getElements("BUTTON_ADD_FAVORITE_ITEM_TO_BASKET");
	final static UI_Elements	FAVORITE_ITEM_SUPPLIER_NAMES		= UIFactory.getElements("FAVORITE_ITEM_SUPPLIER_NAMES");
	final static UI_Elements	FAVORITE_ITEM_NO					= UIFactory.getElements("FAVORITE_ITEM_NO");

	final static UI_Elements	DELETE_SUCCESS_MSG					= UIFactory.getElements("DELETE_SUCCESS_MSG");

	final static UI_Elements	SELECT_SORT_BY_FILTER_FAV_LISTING	= UIFactory.getElements("SELECT_SORT_BY_FILTER_FAV_LISTING");

	final static UI_Elements	UNIT_PRICE_DESC_SORT				= UIFactory.getElements("UNIT_PRICE_DESC_SORT");

	final static UI_Elements	UPDATE_FIRST_ITEM_IN_CART			= UIFactory.getElements("UPDATE_FIRST_ITEM_IN_CART");

	final static UI_Elements	UPDATE_FIRST_ITEM_IN_CART_TEXTFIELD	= UIFactory.getElements("UPDATE_FIRST_ITEM_IN_CART_TEXTFIELD");

	final static UI_Elements	CHECK_OUT							= UIFactory.getElements("CHECK_OUT");

	final static UI_Elements	FIRST_ITEM_IN_FAVOURITE_LIST		= UIFactory.getElements("FIRST_ITEM_IN_FAVOURITE_LIST");

	final static UI_Elements	TOTAL_FAVOURITE_ITEMS				= UIFactory.getElements("TOTAL_FAVOURITE_ITEMS");

	final static UI_Elements	VIEW_CART							= UIFactory.getElements("VIEW_CART");

	final static UI_Elements	YES_CONFIRMATION					= UIFactory.getElements("YES_CONFIRMATION");
	static final UI_Elements	NO_CONFIRMATION						= UIFactory.getElements("NO_CONFIRMATION");

	//client specific- QTS
	final static UI_Elements	COMPARE_FAVORITE_ITEMS_BUTTON		= UIFactory.getElements("COMPARE_FAVORITE_ITEMS_BUTTON");
	final static UI_Elements	CHECKBOX_ITEM_ONE_FOR_COMPARISON	= UIFactory.getElements("CHECKBOX_ITEM_ONE_FOR_COMPARISON");
	final static UI_Elements	CHECKBOX_ITEM_TWO_FOR_COMPARISON	= UIFactory.getElements("CHECKBOX_ITEM_TWO_FOR_COMPARISON");
	final static UI_Elements	FAVORITE_ADD_TO_CART				= UIFactory.getElements("FAVORITE_ADD_TO_CART");
	final static UI_Elements	BACK_FROM_COMPARE					= UIFactory.getElements("BACK_FROM_COMPARE");

	public String fillSearchFavorite(WebDriver driver, String testCaseName, String favoriteItemToBeSearched) throws ActionBotException;

	public String selectSearchFavoriteBy(WebDriver driver, String testCaseName, String favoriteItemToBeSearchedBy) throws ActionBotException;

	public void clickOnSearchFavoriteGo(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfSearchedItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfSearchedItemSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedItemNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveFromFavorite(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean selectFavoriteItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	void waitTillDeleteConfrimationMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFavoriteSortByFilter(WebDriver driver, String testCaseName, String sortBy) throws ActionBotException;

	public void clickOnSortByDescOrderUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSortByDescOrderUnitPricePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToUpdateFirstItemInCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToUpdateFirstItemInCartByTextField(WebDriver driver, String testCaseName, String string) throws ActionBotException;

	public void clickToCheckOutFromCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFirstFavoriteItemPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchTotalFavoriteItemPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToCheckItemCheckBoxFromCart(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void fillItemTextBoxForAddingToCart(WebDriver driver, String testCaseName, int index, String text) throws ActionBotException;

	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchItemNumberFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fetchSupplierNameForItemsFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean isItemPresentInFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToRemoveItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnConfirmation_YES_NO(WebDriver driver, String testCaseName, String choice) throws ActionBotException;

	//client specific- QTS
	public void clickOnCompareFavouriteItems(WebDriver driver, String testCaseName) throws ActionBotException;

	//client specific- QTS
	public void addFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName, int i) throws ActionBotException;
}
