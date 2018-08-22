/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.searchlisting;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.Price;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.ItemException;
import com.zycus.automation.utilities.SupportingFunctions;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author puneet.sharma
 */
public class PageSearchListing extends PageSearchListingUtil
{
	static Logger logger = Logger.getLogger(PageSearchListing.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void hoverToGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.hoverToGridView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method hoverToGridView " + e, e);
		}

	}

	public static String getItemId(WebDriver driver, String testCaseName, String searchText) throws ActionBotException, ItemException
	{
		try
		{
			int cnt = 0;
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			List<WebElement> itemNameElement = iPageSearchListing.getItemName(driver, testCaseName);
			String itemId = null;

			for (WebElement item : itemNameElement)
			{
				try
				{
					WebElement parentElement = item.findElement(IPageSearchListing.ANCSESTOR_TR.getBy());
					String itemName = item.getText().trim();
					if (itemName.equalsIgnoreCase(searchText.trim()))
					{
						itemId = parentElement.getAttribute("id").substring(14);
						break;
					}
				}
				catch (StaleElementReferenceException e)
				{
					logger.error("StaleElementReferenceException occurred ... ");
					List<WebElement> itemNameElement1 = iPageSearchListing.getItemName(driver, testCaseName);
					WebElement parentElement = itemNameElement1.get(cnt).findElement(IPageSearchListing.ANCSESTOR_TR.getBy());
					String itemName = itemNameElement1.get(cnt).getText().trim();
					if (itemName.equalsIgnoreCase(searchText.trim()))
					{
						itemId = parentElement.getAttribute("id").substring(14);
						break;
					}
				}
				cnt++;
			}
			logger.info("Item Id : " + itemId);
			if (itemId == null)
			{
				throw new ItemException("ITEM NOT FOUND");
			}
			else
			{
				return itemId;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemName " + e, e);
		}
		return null;
	}

	public static String getItemDescription(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemDescription(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDescription " + e, e);
		}
		return null;
	}

	public static String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemSupplier(driver, testCaseName, itemId).trim();
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplier " + e, e);
		}
		return null;
	}

	public static int getItemDeliveryDays(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			String days = "day(s)";
			String del = "Delivery in";
			String avail = "Availability:";
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			String delievery = iPageSearchListing.getItemDeliveryDays(driver, testCaseName, itemId);

			if (delievery.contains(avail))
			{
				return 0;
			}
			else
			{
				return Integer.parseInt(delievery.substring(del.length(), delievery.length() - days.length()).toString().trim());
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDeliveryDays " + e, e);
		}

		return 0;
	}

	public static int fillItemQuantity(WebDriver driver, String testCaseName, String itemId, int quantity) throws ActionBotException, TestCaseException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			String itemNo = iPageSearchListing.fillItemQuantity(driver, testCaseName, itemId, "" + quantity);
			return itemNo != null ? Integer.parseInt(itemNo) : 0;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemQuantity " + e, e);
		}
		return 0;
	}

	public static void addToCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.addToCart(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addToCart " + e, e);
		}
	}

	public static String getItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.getItem(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItem " + e, e);
		}
		return null;
	}

	public static Price getItemUnitPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			Price price = new Price();
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			String unitPrice = iPageSearchListing.getItemUnitPrice(driver, testCaseName, itemId);
			String space = " ";
			String[] itemPriceObj = StringUtils.split(unitPrice, space);
			price.setPrice(unitPrice);
			price.setPriceType(itemPriceObj[0].toString().trim());
			price.setPriceValue(Double.parseDouble(SupportingFunctions.removeUnderScore(itemPriceObj[1].toString().trim())));
			return price;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUnitPrice " + e, e);
		}

		return getDefaultPrice();
	}

	public static Price getItemPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();

			if (ActionBot.isElementDisplayed(driver, itemPrice(itemId)))
			{
				Price price = new Price();
				String itemPrice = iPageSearchListing.getItemPrice(driver, testCaseName, itemId);
				logger.info("Item Price: " + itemPrice);
				String unwanted = "~";
				String space = " ";
				if (itemPrice.contains(unwanted))
				{
					itemPrice = itemPrice.substring(unwanted.length());
				}
				String[] itemPriceObj = StringUtils.split(itemPrice, space);
				price.setPriceType(itemPriceObj[0].toString().trim());
				price.setPriceValue(Double.parseDouble(SupportingFunctions.removeUnderScore(itemPriceObj[1].toString().trim())));
				price.setPrice(itemPrice);
				return price;
			}
			else
			{
				return getDefaultPrice();
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPrice " + e, e);
		}
		return getDefaultPrice();
	}

	public static void clickOnItemActions(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnItemActions(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemActions " + e, e);
		}
	}

	public static void makeItemAsFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.makeItemAsFavorite(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method makeItemAsFavorite " + e, e);
		}
	}

	public static boolean isSearchResultDisplpayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.isSearchResultDisplpayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSearchResultDisplpayed " + e, e);
		}
		return false;
	}

	public static String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.fillSearchText(driver, testCaseName, searchText);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchText " + e, e);
		}
		return null;
	}

	public static boolean clickSearchButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnSearchButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSearchButton " + e, e);
		}
		return false;
	}

	public static void clickOnCheckOutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnCheckOutButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckOutButton " + e, e);
		}
	}

	public static boolean isSearchListingPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isSearchListingPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSearchListingPage " + e, e);
		}
		return false;
	}

	public static boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			flag = iPageSearchListing.isDataTableEmptyPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDataTableEmptyPresent " + e, e);
		}
		return flag;
	}

	public static String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			result = iPageSearchListing.getTotalItemsInCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalItemsInCart " + e, e);
		}
		return result;
	}

	public static List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemNames = null;
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			itemNames = iPageSearchListing.getItemName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemName " + e, e);
		}
		return itemNames;
	}

	public static void clickOnCompareMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnCompareMultipleItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompareMultipleItems " + e, e);
		}
	}

	public static boolean isAlertpopUpForTwoItemsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.isAlertpopUpForTwoItemsDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAlertpopUpForTwoItemsDisplayed " + e, e);
		}
		return false;
	}

	public static void clickOnAddMultipleItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnAddMultipleItemsToCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddMultipleItemsToCart " + e, e);
		}
	}

	public static void clickOnAddMultipleItemsToBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnAddMultipleItemsToBasket(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddMultipleItemsToBasket " + e, e);
		}
	}

	public static void clickOnAddMultipleItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnAddMultipleItemsToFavorite(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddMultipleItemsToFavorite " + e, e);
		}
	}

	public static String getSearchedSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getSearchedSelectedCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSearchedSelectedCategory " + e, e);
		}
		return null;
	}

	public static void hoverOverRelatedCategorySearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.hoverOverRelatedCategorySearch(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRelatedCategorySearch " + e, e);
		}
	}

	public static void clickOnFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnFirstRelatedSearchCategoryLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstRelatedSearchCategoryLink " + e, e);
		}
	}

	public static String getFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getFirstRelatedSearchCategoryLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRelatedSearchCategoryLink " + e, e);
		}
		return null;
	}

	public static void clickOnGuideMeExpand(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGuideMeExpand " + e, e);
		}
	}

	public static void clickOnButtonGuidedProcurement(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonGuidedProcurement " + e, e);
		}
	}

	public static void clickOnButtonGuidedProcurementForNoRecords(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnButtonGuidedProcurementForNoRecords(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonGuidedProcurementForNoRecords " + e, e);
		}
	}

	public static boolean isGuideMeExpandPresent(WebDriver driver) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isGuideMeExpandPresent(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGuideMeExpandPresent " + e, e);
		}
		return false;
	}

	public static void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnAddItemsToFavorite(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddItemsToFavorite " + e, e);
		}
	}

	public static void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckBoxOfItem " + e, e);
		}
	}

	public static void clickOnCatalogItemCheckBoxOfItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnCatalogItemCheckBoxOfItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckBoxOfItem " + e, e);
		}
	}

	public static List<WebElement> getItemDescriptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemDescriptions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDescriptions " + e, e);
		}
		return null;
	}

	public static void applyItemDescFilter(WebDriver driver, String testCaseName, String itemDesc) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.applyItemDescFilter(driver, testCaseName, itemDesc);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method applyItemDescFilter " + e, e);
		}
	}

	public static List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPrice " + e, e);
		}
		return null;
	}

	public static void applyMinItemPriceFilter(WebDriver driver, String testCaseName, String minPrice) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.applyMinItemPriceFilter(driver, testCaseName, minPrice);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method applyMinItemPriceFilter " + e, e);
		}
	}

	public static void applyMaxItemPriceFilter(WebDriver driver, String testCaseName, String maxPrice) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.applyMaxItemPriceFilter(driver, testCaseName, maxPrice);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method applyMaxItemPriceFilter " + e, e);
		}
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnItemName(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemName " + e, e);
		}
	}

	public static List<WebElement> getItemManufacturersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemManufacturersCheckBoxList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemManufacturersCheckBoxList " + e, e);
		}
		return null;
	}

	public static List<WebElement> getItemSuppliersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemSuppliersCheckBoxList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSuppliersCheckBoxList " + e, e);
		}
		return null;
	}

	public static List<WebElement> getItemSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemSuppliers(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSuppliers " + e, e);
		}
		return null;
	}

	public static void waitTillSearchListLoaded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.waitTillSearchListLoaded(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillSearchListLoaded " + e, e);
		}
	}

	public static void clickOnExpandSupplierFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnExpandSupplierFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandSupplierFilterButton " + e, e);
		}
	}

	public static boolean isZeroPriceItemIconPresentInListView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isZeroPriceItemIconPresentInListView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isZeroPriceItemIconPresentInListView " + e, e);
		}
		return false;
	}

	public static void clickOnSwitchToGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnSwitchToGridView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSwitchToGridView " + e, e);
		}

	}

	public static void clickOnSwitchToListView(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickOnSwitchToListView(driver, testCaseName);
	}

	public static boolean isZeroPriceItemIconPresentInGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isZeroPriceItemIconPresentInGridView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isZeroPriceItemIconPresentInGridView " + e, e);
		}
		return false;
	}

	public static void waitTillCheckoutPageLoaded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.waitTillCheckoutPageLoaded(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillCheckoutPageLoaded " + e, e);
		}
	}

	public static boolean isCompareLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		return iPageSearchListing.isCompareLinkDisplayed(driver, testCaseName);
	}

	public static boolean isAddToCartLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		return iPageSearchListing.isAddToCartLinkDisplayed(driver, testCaseName);
	}

	public static boolean isAddToFavouriteDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		return iPageSearchListing.isAddToFavouriteDisplayed(driver, testCaseName);
	}

	public static boolean isAddToBasketLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		return iPageSearchListing.isAddToBasketLinkDisplayed(driver, testCaseName);
	}

	public static void clickSortByRelevance(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickSortByRelevance(driver, testCaseName);
	}

	public static void clickSortByPriceLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickSortByPriceLowToHigh(driver, testCaseName);
	}

	public static void clickSortByPriceHighToLow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickSortByPriceHighToLow(driver, testCaseName);
	}

	public static void clickSortByLeadLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickSortByLeadLowToHigh(driver, testCaseName);
	}

	public static void clickSortByLeadHighToLow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickSortByLeadHighToLow(driver, testCaseName);
	}

	public static void clickRadioButtonUsingIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
		iPageSearchListing.clickRadioButtonUsingIndex(driver, testCaseName, index);
	}

	public static void selectFromExistingBasket(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.selectFromExistingBasket(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFromExistingBasket " + e, e);
		}
	}

	public static void clickOnAddToBasketbutton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnAddToBasketbutton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToBasketbutton " + e, e);
		}
	}

	public static void seeOtherFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.seeOtherFilterOptions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method seeOtherFilterOptions " + e, e);
		}
	}

	public static void selectPrefferedfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.selectPrefferedfacetFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPrefferedfacetFilter " + e, e);
		}
	}

	public static void selectGreenfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.selectGreenfacetFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectGreenfacetFilter " + e, e);
		}
	}

	public static boolean isLoadingPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isLoadingPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isLoadingPage " + e, e);
			return false;
		}
	}

	public static void seePriceRangeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.seePriceRangeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method seePriceRangeFilter " + e, e);
		}
	}

	public static void insertHigherRangePrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.insertHigherRangePrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method insertHigherRangePrice " + e, e);
		}
	}

	public static void insertLowerRangePrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.insertLowerRangePrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method insertLowerRangePrice " + e, e);
		}
	}

	public static boolean isItemAlreadyInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isItemAlreadyInCartIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemAlreadyInCartIndexwise " + e, e);
			return false;
		}
	}

	public static void seeMultipleCurrencyOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.seeMultipleCurrencyOptions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method seeMultipleCurrencyOptions " + e, e);
		}
	}

	public static void selectPriceOptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.selectPriceOptionIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPriceOptionIndexwise " + e, e);
		}
	}

	public static void deselectPriceOptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.selectPriceOptionIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPriceOptionIndexwise " + e, e);
		}
	}

	public static void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickToViewCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToViewCart " + e, e);
		}
	}

	public static String getItemPriceCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemPriceCurrencyIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPriceCurrencyIndexwise " + e, e);
		}
		return null;
	}

	public static void clickItemDescriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickItemDescriptionIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemDescriptionIndexwise " + e, e);
		}
	}

	public static String getItemContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemContractNumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemContractNumber " + e, e);
		}
		return null;
	}

	public static void clickOnCloseItemDescriptionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clickOnCloseItemDescriptionButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseItemDescriptionButton " + e, e);
		}
	}

	public static void clicktoAddItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clicktoAddItemToCartIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clicktoAddItemToCartIndexwise " + e, e);
		}
	}

	public static void toHoverOverTheSortingOptions(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.toHoverOverTheSortingOptions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toHoverOverTheSortingOptions " + e, e);
		}
	}

	public static void clicktoSortSearchListingChoiceWise(WebDriver driver, String testCaseName, UI_Elements sortElement) throws Exception
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clicktoSortSearchListingChoiceWise(driver, testCaseName, sortElement);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clicktoSortSearchListingChoiceWise " + e, e);
		}
	}

	public static String getItemDeliveryLeadDaysIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getItemDeliveryLeadDaysIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDeliveryLeadDaysIndexwise " + e, e);
		}
		return null;
	}

	public static boolean isItemPresentInSearchListingPageIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isItemPresentInSearchListingPageIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemPresentInSearchListingPageIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isLeadTimeVisibleIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isLeadTimeVisibleIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isLeadTimeVisibleIndexwise " + e, e);
		}
		return false;
	}

	public static String getLeadTimeIndexwise(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getLeadTimeIndexwise(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLeadTimeIndexwise " + e, e);
		}
		return null;
	}

	public static String getCategoryFromCategoryFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getCategoryFromCategoryFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCategoryFromCategoryFilter " + e, e);
		}
		return null;
	}

	public static void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = FactoryPage.getInstanceOfIPageSearchListing();
			iPageSearchListing.clearFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearFilter " + e, e);
		}
	}

	public static void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws Exception
	{
		List<WebElement> closeLinks = new ArrayList<WebElement>();
		WebElement currentElement;
		closeLinks = ActionBot.findElements(driver, IPageSearchListing.LINK_CLOSE);
		int size = closeLinks.size();
		for (int index = 1; index <= size; index++)
		{
			currentElement = closeLinks.get(index - 1);

			try
			{
				if (currentElement.isDisplayed())
				{
					ActionBot.click(driver, currentElement);
					break;
				}

			}
			catch (Exception e)
			{
				logger.info("close button was not found at index=" + index);
			}

		}
	}

	public static int getSearchedItemCount(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageSearchListing iPageSearchListing = (IPageSearchListing) FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getSearchedItemCount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSearchedItemCount " + e, e);
		}
		return 0;
	}

	public static double getTotalCartAmount(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageSearchListing iPageSearchListing = (IPageSearchListing) FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.getTotalCartAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalCartAmount " + e, e);
		}
		return -1.0D;
	}

	public static boolean isNoCatalogItemsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageSearchListing iPageSearchListing = (IPageSearchListing) FactoryPage.getInstanceOfIPageSearchListing();
			return iPageSearchListing.isNoCatalogItemsLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalCartAmount " + e, e);
		}
		return false;
	}
}
