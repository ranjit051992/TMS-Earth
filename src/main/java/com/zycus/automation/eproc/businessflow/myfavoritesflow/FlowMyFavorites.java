/**
 * 
 */
package com.zycus.automation.eproc.businessflow.myfavoritesflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.PageMyFavorites;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 */
public class FlowMyFavorites
{

	static Logger logger = Logger.getLogger(FlowMyFavorites.class);

	public static CatelogItem searchFavoriteItems(WebDriver driver, String testCaseName, CatelogItem catelogItem) throws ActionBotException
	{
		ActionBot.defaultSleep();
		MainPageHeaderLevelTab.clickOnMyFavoritesSubTab(driver);
		String favoriteItemToBeSearched = null, favoriteItemToBeSearchedBy = null;
		if (catelogItem.getItemName() != null)
		{
			favoriteItemToBeSearched = catelogItem.getItemName();
			favoriteItemToBeSearchedBy = IConstantsData.SEARCH_FAVORITE_BY_ITEM_NAME;
		}
		else if (catelogItem.getSupplier() != null)
		{
			favoriteItemToBeSearched = catelogItem.getSupplier();
			favoriteItemToBeSearchedBy = IConstantsData.SEARCH_FAVORITE_BY_SUPPLIER_NAME;
		}
		else if (catelogItem.getItemNo() != null)
		{
			favoriteItemToBeSearched = catelogItem.getItemNo();
			favoriteItemToBeSearchedBy = IConstantsData.SEARCH_FAVORITE_BY_ITEM_NO;
		}
		else
		{
			logger.info("Search option is not specified properly");
		}

		PageMyFavorites.fillSearchFavorite(driver, testCaseName, favoriteItemToBeSearched);
		PageMyFavorites.selectSearchFavoriteBy(driver, testCaseName, favoriteItemToBeSearchedBy);
		PageMyFavorites.clickOnSearchFavoriteGo(driver, testCaseName);

		catelogItem.setResult(checkIfFavoriteItemSearched(driver, testCaseName, favoriteItemToBeSearched, favoriteItemToBeSearchedBy));

		return catelogItem;

	}

	public static boolean checkIfFavoriteItemSearched(WebDriver driver, String testCaseName, String favoriteItemToBeSearched, String favoriteItemToBeSearchedBy)
		throws ActionBotException
	{
		boolean flag = false;
		// for item names
		if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_ITEM_NAME))
		{
			List<WebElement> searchedItems = PageMyFavorites.getListOfSearchedItems(driver, testCaseName);
			for (WebElement ele : searchedItems)
			{
				if (ele.getText().trim().equalsIgnoreCase(favoriteItemToBeSearched))
				{
					flag = true;
					break;
				}
			}
		}
		// for item no
		else if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_ITEM_NO))
		{
			String searchedItemNo = PageMyFavorites.getSearchedItemNo(driver, testCaseName);
			flag = searchedItemNo.equalsIgnoreCase(favoriteItemToBeSearched);

		}
		// for supplier names
		else if (favoriteItemToBeSearchedBy.equalsIgnoreCase(IConstantsData.SEARCH_FAVORITE_BY_SUPPLIER_NAME))
		{
			List<WebElement> searchedItems = PageMyFavorites.getListOfSearchedItemSupplierNames(driver, testCaseName);
			for (WebElement ele : searchedItems)
			{
				if (ele.getText().trim().equalsIgnoreCase(favoriteItemToBeSearched))
				{
					flag = true;
					break;
				}
			}
		}
		else
		{
			logger.info("Search option is not specified properly");
		}
		return flag;

	}

	public static CatelogItem removeItemFromFavorites(WebDriver driver, String testCaseName, CatelogItem catelogItem) throws ActionBotException
	{
		// to search item
		searchFavoriteItems(driver, testCaseName, catelogItem);

		// to remove item
		PageMyFavorites.selectFavoriteItem(driver, testCaseName, catelogItem.getItemID());
		PageMyFavorites.clickOnRemoveFromFavorite(driver, testCaseName);
		// PopUpDeleteConfirmation.clickOnYesButton(driver, testCaseName);
		PageMyFavorites.waitTillDeleteConfrimationMessageDisplayed(driver, testCaseName);

		catelogItem.setResult(checkIfFavoriteItemRemoved(driver, testCaseName, catelogItem.getItemID()));
		return catelogItem;

	}

	public static boolean checkIfFavoriteItemRemoved(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		boolean flag = true;
		List<WebElement> searchedItems = PageMyFavorites.getListOfSearchedItems(driver, testCaseName);
		for (WebElement ele : searchedItems)
		{
			if (ele.getAttribute("itemid").trim().equalsIgnoreCase(itemId))
			{
				flag = false;
				break;
			}
		}
		return flag;

	}

	public static boolean verifySortingOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnMyFavoritesSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		if (PageMyFavorites.isSortByDescOrderUnitPricePresent(driver, testCaseName))
		{
			PageMyFavorites.clickOnSortByDescOrderUnitPrice(driver, testCaseName);
		}
		else
		{
			return false;
		}
		return true;
	}

	public static boolean toPushToCartItems_With_and_withoutQuantity(WebDriver driver, String testCaseName) throws Exception
	{
		// to navigate to my favourite sub tab
		try
		{
			ActionBot.defaultMediumSleep();
			MainPageHeaderLevelTab.clickOnMyFavoritesSubTab(driver);

			// to select the item to push to cart
			String item_qty = CommonServices.getTestData(IConstantsData.Item_Quantity, 2);
			for (int i = 1; i <= 2; i++)
			{
				PageMyFavorites.clickToCheckItemCheckBoxFromCart(driver, testCaseName, i);
				if (i == 2)
					PageMyFavorites.fillItemTextBoxForAddingToCart(driver, testCaseName, i, item_qty);
			}
			PageMyFavorites.clickOnAddFavoriteItemToCart(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	//client specific - QTS - method to compare items in favorites tab
	public static boolean compareFavoriteItems(WebDriver driver, String testCaseName, CatelogItem catelogItem1, CatelogItem catelogItem2) throws ActionBotException
	{

		if (catelogItem1 == null || catelogItem2 == null)
			return false;
		PageMyFavorites.clickOnCompareFavouriteItems(driver, testCaseName);

		return false;

	}

	//client specific - QTS - method to compare items in favorites tab
	public static void addFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageMyFavorites.addFavoriteItemToCart(driver, testCaseName);

	}

	//client specific - QTS - to add favorite item to Basket
	public static void addFavoriteItemToBasket(WebDriver driver, String testCaseName, String ItemName) throws ActionBotException
	{
		PageMyFavorites.clickOnAddFavoriteItemToBasket(driver, testCaseName);

	}

	//client specific- QTS -to select checkbox
	public static void clickOnCheckBox(WebDriver driver, String testCaseName, int i) throws ActionBotException
	{
		PageMyFavorites.clickOnAddFavoriteItemToBasket(driver, testCaseName, i);

	}

}
