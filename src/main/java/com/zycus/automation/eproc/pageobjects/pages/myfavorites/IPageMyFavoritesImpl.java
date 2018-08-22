/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.myfavorites;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageMyFavoritesImpl implements IPageMyFavorites
{

	static Logger logger = Logger.getLogger(IPageMyFavoritesImpl.class);

	@Override
	public String fillSearchFavorite(WebDriver driver, String testCaseName, String favoriteItemToBeSearched) throws ActionBotException
	{
		String itemToBeSearched;
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_FAVORITE, favoriteItemToBeSearched);
		itemToBeSearched = ActionBot.findElement(driver, TEXTBOX_SEARCH_FAVORITE).getAttribute("value");
		logger.info("Favorite item to be searched : " + itemToBeSearched);
		ScreenShot.screenshot(driver, testCaseName, "After entering favorite item to be searched");
		return itemToBeSearched;
	}

	@Override
	public String selectSearchFavoriteBy(WebDriver driver, String testCaseName, String favoriteItemToBeSearchedBy) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_SEARCH_FAVORITE_BY));
		if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_ITEM_NO))
		{
			select.selectByIndex(0);
		}
		else if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_ITEM_NAME))
		{
			select.selectByIndex(1);
		}
		else if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_SUPPLIER_NAME))
		{
			select.selectByIndex(2);
		}
		else
		{
			logger.info("Invalid option");
		}
		String searchBy = select.getFirstSelectedOption().getText().trim();
		logger.info("Favorite Item search by : " + searchBy);
		ScreenShot.screenshot(driver, testCaseName, "Search favorite by");
		return searchBy;
	}

	@Override
	public void clickOnSearchFavoriteGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH_FAVORITE_GO);
		ActionBot.waitTillPopUpIsPresent(driver, FAVORITE_LIST_PROCESSING);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After searching favorite items");
	}

	@Override
	public List<WebElement> getListOfSearchedItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		List<WebElement> searchedItems = ActionBot.findElements(driver, FAVORITE_ITEM_NAMES);
		ScreenShot.screenshot(driver, testCaseName, "Searched Items");
		return searchedItems;
	}

	@Override
	public void clickOnRemoveFromFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 15, BUTTON_REMOVE_FAVORITE_ITEM);
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_REMOVE_FAVORITE_ITEM, 15);
		ActionBot.click(driver, BUTTON_REMOVE_FAVORITE_ITEM);
		ActionBot.waitForElementToBePresent(driver, 30, YES_CONFIRMATION);
		ActionBot.waitForElementToBeDisplayed(driver, YES_CONFIRMATION, 30);
		ActionBot.click(driver, YES_CONFIRMATION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on remove favorite items button");
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnAddFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_FAVORITE_ITEM_TO_CART);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add favorite items to cart");
	}

	@Override
	public void clickOnConfirmation_YES_NO(WebDriver driver, String testCaseName, String choice) throws ActionBotException
	{
		if (choice.equals(IConstantsData.CONFIRMATION_YES))
		{
			if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
				ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
		}
		else if (choice.equals(IConstantsData.CONFIRMATION_NO))
		{
			if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.NO_CONFIRMATION))
				ActionBot.click(driver, IPageMyFavorites.NO_CONFIRMATION);
		}
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_FAVORITE_ITEM_TO_BASKET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add favorite items to basket");
	}

	@Override
	public boolean selectFavoriteItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.id("chkItem_" + itemId));
		return ActionBot.findElement(driver, By.id("chkItem_" + itemId)).isSelected();
	}

	@Override
	public List<WebElement> getListOfSearchedItemSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> searchedItemsSupplierNames = ActionBot.findElements(driver, FAVORITE_ITEM_SUPPLIER_NAMES);
		ScreenShot.screenshot(driver, testCaseName, "Searched Items Supplier Names");
		return searchedItemsSupplierNames;
	}

	@Override
	public String getSearchedItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemNo = ActionBot.getTextWithInElement(driver, FAVORITE_ITEM_NO);
		ScreenShot.screenshot(driver, testCaseName, "Searched Item No");
		logger.info("Searched item no : " + itemNo);
		return itemNo;
	}

	@Override
	public void waitTillDeleteConfrimationMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, DELETE_SUCCESS_MSG);
		ActionBot.waitTillPopUpIsPresent(driver, FAVORITE_LIST_PROCESSING);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "Delete success message");
	}

	@Override
	public String selectFavoriteSortByFilter(WebDriver driver, String testCaseName, String sortByValue) throws ActionBotException
	{
		String selectedSortByValue = ActionBot.selectElement(driver, SELECT_SORT_BY_FILTER_FAV_LISTING, IConstantsData.SELECT_BY_VISIBLE_TEXT, sortByValue);
		logger.info("Selected Sort by Value : " + selectedSortByValue);
		return selectedSortByValue;
	}

	@Override
	public void clickOnSortByDescOrderUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UNIT_PRICE_DESC_SORT);
	}

	@Override
	public boolean isSortByDescOrderUnitPricePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, UNIT_PRICE_DESC_SORT);
	}

	@Override
	public void clickToUpdateFirstItemInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UPDATE_FIRST_ITEM_IN_CART);
	}

	@Override
	public void clickToUpdateFirstItemInCartByTextField(WebDriver driver, String testCaseName, String string) throws ActionBotException
	{
		ActionBot.sendKeys(driver, UPDATE_FIRST_ITEM_IN_CART_TEXTFIELD, string);
	}

	@Override
	public void clickToCheckOutFromCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 30, CHECK_OUT);
		ActionBot.waitForElementToBeDisplayed(driver, CHECK_OUT, 30);
		ActionBot.click(driver, CHECK_OUT);
	}

	@Override
	public boolean isFirstFavoriteItemPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, FIRST_ITEM_IN_FAVOURITE_LIST);
	}

	@Override
	public String fetchTotalFavoriteItemPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 30, TOTAL_FAVOURITE_ITEMS);
		ActionBot.waitForElementToBeDisplayed(driver, TOTAL_FAVOURITE_ITEMS, 30);
		return ActionBot.getTextWithInElement(driver, TOTAL_FAVOURITE_ITEMS);
	}

	@Override
	public void clickToCheckItemCheckBoxFromCart(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'chkItem')])[" + index + "]"));
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void fillItemTextBoxForAddingToCart(WebDriver driver, String testCaseName, int index, String text) throws ActionBotException
	{
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'txt')])[" + index + "]"), text);
	}

	@Override
	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW_CART);
	}

	@Override
	public String fetchItemNumberFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='favList']//td[contains(@class,'supplierPartId')])[" + index + "]"));
	}

	@Override
	public boolean isItemPresentInFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='favList']//td[contains(@class,'supplierPartId')])[" + index + "]"));
	}

	@Override
	public String fetchSupplierNameForItemsFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String raw_sup_name = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='favList']//div[@class='iSuppName'])[" + index + "]"));
		int position = raw_sup_name.indexOf(":");
		return raw_sup_name.substring(position + 2, raw_sup_name.length());
	}

	@Override
	public void clickToRemoveItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='fav_cell_item_name_null']/label)[" + index + "]"));
	}

	/*
	 * author: bahkti.sawant
	 */
	//client specific- QTS
	@Override
	public void clickOnCompareFavouriteItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, CHECKBOX_ITEM_ONE_FOR_COMPARISON);
		//ActionBot.click(driver, CHECKBOX_ITEM_TWO_FOR_COMPARISON);
		ActionBot.click(driver, COMPARE_FAVORITE_ITEMS_BUTTON);
		ActionBot.click(driver, BACK_FROM_COMPARE);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();

	}

	/*
	 * author: bahkti.sawant
	 */
	//client specific- QTS
	@Override
	public void addFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FAVORITE_ADD_TO_CART);

	}

	@Override
	public void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName, int i) throws ActionBotException
	{
		if (i == 1)
			ActionBot.click(driver, CHECKBOX_ITEM_ONE_FOR_COMPARISON);
		else if (i == 2)
			ActionBot.click(driver, CHECKBOX_ITEM_TWO_FOR_COMPARISON);

	}
}
