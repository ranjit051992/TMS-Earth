/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.myfavorites;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 */
public class PageMyFavorites
{

	static Logger logger = Logger.getLogger(PageMyFavorites.class);

	public static String fillSearchFavorite(WebDriver driver, String testCaseName, String favoriteItemToBeSearched) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.fillSearchFavorite(driver, testCaseName, favoriteItemToBeSearched);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchFavorite " + e, e);
		}
		return null;
	}

	public static String selectSearchFavoriteBy(WebDriver driver, String testCaseName, String favoriteItemToBeSearchedBy) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.selectSearchFavoriteBy(driver, testCaseName, favoriteItemToBeSearchedBy);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSearchFavoriteBy " + e, e);
		}
		return null;
	}

	public static void clickOnSearchFavoriteGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnSearchFavoriteGo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSearchFavoriteGo " + e, e);
		}
	}

	public static List<WebElement> getListOfSearchedItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.getListOfSearchedItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfSearchedItems " + e, e);
		}

		return null;
	}

	public static void clickOnRemoveFromFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnRemoveFromFavorite(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemoveFromFavorite " + e, e);
		}
	}

	public static void clickOnAddFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnAddFavoriteItemToCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddFavoriteItemToCart " + e, e);
		}
	}

	public static void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnAddFavoriteItemToBasket(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddFavoriteItemToBasket " + e, e);
		}
	}

	public static boolean selectFavoriteItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.selectFavoriteItem(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFavoriteItem " + e, e);
		}
		return false;
	}

	public static List<WebElement> getListOfSearchedItemSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.getListOfSearchedItemSupplierNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfSearchedItemSupplierNames " + e, e);
		}
		return null;
	}

	public static String getSearchedItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.getSearchedItemNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSearchedItemNo " + e, e);
		}
		return null;
	}

	public static void waitTillDeleteConfrimationMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.waitTillDeleteConfrimationMessageDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillDeleteConfrimationMessageDisplayed " + e, e);
		}
	}

	public static String selectFavoriteSortByFilter(WebDriver driver, String testCaseName, String sortByValue) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.selectFavoriteSortByFilter(driver, testCaseName, sortByValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFavoriteSortByFilter " + e, e);
		}
		return null;
	}

	public static void clickOnSortByDescOrderUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnSortByDescOrderUnitPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSortByDescOrderUnitPrice " + e, e);
		}
	}

	public static boolean isSortByDescOrderUnitPricePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.isSortByDescOrderUnitPricePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method sisSortByDescOrderUnitPricePresent " + e, e);
		}
		return false;
	}

	public static void clickToUpdateFirstItemInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToUpdateFirstItemInCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToUpdateFirstItemInCart " + e, e);
		}
	}

	public static void clickToUpdateFirstItemInCartByTextField(WebDriver driver, String testCaseName, String string) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToUpdateFirstItemInCartByTextField(driver, testCaseName, string);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToUpdateFirstItemInCart " + e, e);
		}
	}

	public static void clickToCheckOutFromCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToCheckOutFromCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToUpdateFirstItemInCart " + e, e);
		}
	}

	public static void clickToCheckItemCheckBoxFromCart(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToCheckItemCheckBoxFromCart(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToCheckItemCheckBoxFromCart " + e, e);
		}
	}

	public static void fillItemTextBoxForAddingToCart(WebDriver driver, String testCaseName, int index, String text) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.fillItemTextBoxForAddingToCart(driver, testCaseName, index, text);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemTextBoxForAddingToCart " + e, e);
		}
	}

	public static void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToViewCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToViewCart " + e, e);
		}
	}

	public static String fetchItemNumberFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.fetchItemNumberFromFavouriteList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchItemNumberFromFavouriteList " + e, e);
		}
		return null;
	}

	public static boolean isItemPresentInFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.isItemPresentInFavouriteList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemPresentInFavouriteList " + e, e);
		}
		return false;
	}

	public static String fetchTotalFavoriteItemPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.fetchTotalFavoriteItemPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchTotalFavoriteItemPresent " + e, e);
		}
		return null;
	}

	public static String fetchSupplierNameForItemsFromFavouriteList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			return myFavorites.fetchSupplierNameForItemsFromFavouriteList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchSupplierNameForItemsFromFavouriteList " + e, e);
		}
		return null;
	}

	public static void clickToRemoveItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickToRemoveItemIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToRemoveItemIndexwise " + e, e);
		}
	}

	public static void clickOnConfirmation_YES_NO(WebDriver driver, String testCaseName, String choice) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnConfirmation_YES_NO(driver, testCaseName, choice);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmation_YES_NO " + e, e);
		}
	}

	//client specific- QTS- to compare favorite items under MyFavorites tab
	public static void clickOnCompareFavouriteItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnCompareFavouriteItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompareFavouriteItems " + e, e);
		}
	}

	//client specific- QTS- to add favorite item to cart
	public static void addFavoriteItemToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.addFavoriteItemToCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addFavoriteItemToCart " + e, e);
		}

	}

	public static void clickOnAddFavoriteItemToBasket(WebDriver driver, String testCaseName, int i) throws ActionBotException
	{
		try
		{
			IPageMyFavorites myFavorites = FactoryPage.getInstanceOf(IPageMyFavoritesImpl.class);
			myFavorites.clickOnAddFavoriteItemToBasket(driver, testCaseName, i);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addFavoriteItemToCart " + e, e);
		}

	}
}
