/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.searchlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author puneet.sharma
 */
public class IPageSearchListingImpl extends GenerateByValuesForSearchListingPage implements IPageSearchListing
{
	static Logger logger = Logger.getLogger(IPageSearchListingImpl.class);

	@Override
	public void hoverToGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Actions action = new Actions(driver);
		action.moveToElement(ActionBot.findElement(driver, GRID_VIEW));
		action.build().perform();
	}

	@Override
	public String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Total Items In Cart");
		String itemInCart = ActionBot.getTextWithInElement(driver, LABEL_ITEM_IN_CART_VALUE).trim();
		return itemInCart;
	}

	@Override
	public List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, ITEM_NAMES);
		// ActionBot.defaultMediumSleep();
		return ActionBot.findElements(driver, ITEM_NAMES);
	}

	@Override
	public String getItemDescription(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By description = itemDescription(itemId);
		return ActionBot.getTextWithInElement(driver, description);

	}

	@Override
	public String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{

		By supplier = itemSupplier(itemId);
		return ActionBot.getTextWithInElement(driver, supplier);
	}

	@Override
	public String getItemDeliveryDays(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By deliveryDate = itemDelieveryDate(itemId);
		return ActionBot.getTextWithInElement(driver, deliveryDate);
	}

	@Override
	public String fillItemQuantity(WebDriver driver, String testCaseName, String itemId, String quantity) throws ActionBotException, TestCaseException
	{
		By itemQuantity = itemQuantity(itemId);
		// ActionBot.clear(driver, itemQuantity);
		String entered_quantity = ActionBot.sendKeys(driver, itemQuantity, quantity);
		return entered_quantity;
	}

	@Override
	public void addToCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		// logger.info("\n ## Adding Item " + getItem(driver, testCaseName,
		// itemId) + " to cart.");
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before adding items to cart");
		By cart = itemCart(itemId);
		ActionBot.click(driver, cart);
		ActionBot.waitTillPopUpIsPresent(driver, ITEM_ADDED_TO_CART_SUCCESS_MESSAGE);
		// ActionBot.defaultLowSleep();
	}

	@Override
	public String getItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By item = item(itemId);
		String itemName = ActionBot.getTextWithInElement(driver, item);
		logger.info("Item Name : " + itemName);
		return itemName;
	}

	@Override
	public String getItemUnitPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By itemUnitPrice = itemUnitPrice(itemId);
		return ActionBot.getTextWithInElement(driver, itemUnitPrice);
	}

	@Override
	public String getItemPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By itemPrice = itemPrice(itemId);
		return ActionBot.getTextWithInElement(driver, itemPrice);
	}

	@Override
	public void clickOnItemActions(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By actions = itemActions(itemId);
		ActionBot.click(driver, actions);
	}

	@Override
	public void makeItemAsFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		By itemAsFavorite = itemAsfavorite(itemId);
		ActionBot.click(driver, itemAsFavorite);
	}

	@Override
	public boolean isSearchResultDisplpayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, EMPTY_DATA_TABLE);
	}

	@Override
	public String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ENTER_SEARCH_NAME, searchText);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_ENTER_SEARCH_NAME);
	}

	@Override
	public void clickOnSearchButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH_BUTTON);
		waitTillSearchListLoaded(driver, testCaseName);
	}

	@Override
	public boolean isSearchListingPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemNames = ActionBot.findElements(driver, ITEM_NAMES);
		return itemNames.size() > 0 ? true : false;
	}

	@Override
	public void clickOnCheckOutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CHECKOUT_BUTTON, 20);
		// 20);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_CHECKOUT_BUTTON);
		// ActionBot.waitForPageLoad(driver);
		waitTillCheckoutPageLoaded(driver, testCaseName);
		ActionBot.waitForElementToBeVisible(driver, 6000, IPageRequisitionCheckOut.TEXTBOX_REQUISITION_NAME);
		ActionBot.findElement(driver, IPageRequisitionCheckOut.TEXTBOX_REQUISITION_NAME);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Checkout Button");
		// ActionBot.waitForPageLoad(driver);
	}

	@Override
	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, EMPTY_DATA_TABLE);
	}

	@Override
	public void clickOnCompareMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COMPARE_MULTIPLE_ITEMS);
	}

	@Override
	public void clickOnAddMultipleItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 60, LINK_ADD_MULTIPLE_TO_CART);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_ADD_MULTIPLE_TO_CART, 60);
		ActionBot.click(driver, LINK_ADD_MULTIPLE_TO_CART);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnAddMultipleItemsToBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_MULTIPLE_TO_BASKET);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnAddMultipleItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_MULTIPLE_TO_FAVORITE);
	}

	@Override
	public String getSearchedSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String searchedSelectedCategory = ActionBot.getTextWithInElement(driver, SEARCHED_SELECTED_CATEGORY);
		logger.info("Searched Selected Category : " + searchedSelectedCategory);
		ScreenShot.screenshot(driver, testCaseName, "Searched selected category");
		return searchedSelectedCategory;
	}

	@Override
	public void hoverOverRelatedCategorySearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, RELATED_CATEGORIES_SEARCH);
		ActionBot.defaultMediumSleep();
		// ScreenShot.screenshot(driver, testCaseName,
		// "Related Category Search");
	}

	@Override
	public void clickOnFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_RELATED_SEARCH_CATEGORY_LINK);
		ActionBot.defaultMediumSleep();
		ActionBot.waitTillPopUpIsPresent(driver, IPageOnlineStore.LOADER_SEARCH_ITEM_LIST);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on First Related Category Search");
	}

	@Override
	public String getFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String relatedSearchedCategory = ActionBot.getTextWithInElement(driver, FIRST_RELATED_SEARCH_CATEGORY_LINK);
		logger.info("Related Searched Category : " + relatedSearchedCategory);
		// ScreenShot.screenshot(driver, testCaseName,
		// "Related Searched category");
		return relatedSearchedCategory;
	}

	@Override
	public void clickOnGuideMeExpand(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, GUIDE_ME_EXPAND);
	}

	@Override
	public void clickOnButtonGuidedProcurement(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GUIDED_PROCUREMENT);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Guided Procurement Button");
	}

	@Override
	public void clickOnButtonGuidedProcurementForNoRecords(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GUIDED_PROCUREMENT_FOR_NO_RECORDS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Guided Procurement Button");
	}

	@Override
	public boolean isGuideMeExpandPresent(WebDriver driver) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, GUIDE_ME_EXPAND);
	}

	@Override
	public void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.id("favorite_list_" + itemId));
		if (!ele.getAttribute("class").equals("fav favorite active"))// remove
																		// item
																		// from
																		// favorites
																		// if it
																		// is
																		// already
																		// added
		{
			ActionBot.click(driver, By.id("favorite_list_" + itemId));
		}
	}

	@Override
	public void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.id("chk_item_list_" + itemId), 60);
		ActionBot.click(driver, By.id("chk_item_list_" + itemId));
	}

	@Override
	public List<WebElement> getItemDescriptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item description");
		return ActionBot.findElements(driver, ITEM_DESC);
	}

	@Override
	public void applyItemDescFilter(WebDriver driver, String testCaseName, String itemDesc) throws ActionBotException
	{
		logger.info("Applying item description filter with " + itemDesc);
		ActionBot.sendKeys(driver, TEXTBOX_ITEM_DESC_FILTER, itemDesc);
		ActionBot.findElement(driver, TEXTBOX_ITEM_DESC_FILTER).sendKeys(Keys.RETURN);
		waitTillSearchListLoaded(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After applying desc filter");

	}

	@Override
	public List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item Price");
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		return ActionBot.findElements(driver, ITEM_PRICE_ON_SEARCH_LISTING);
	}

	@Override
	public void applyMinItemPriceFilter(WebDriver driver, String testCaseName, String minPrice) throws ActionBotException
	{
		logger.info("Applying minimum item price filter with " + minPrice);
		ActionBot.sendKeys(driver, PRICE_FILTER_MIN_VALUE, minPrice);
		ActionBot.findElement(driver, PRICE_FILTER_MIN_VALUE).sendKeys(Keys.RETURN);
		waitTillSearchListLoaded(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After applying min price filter");
	}

	@Override
	public void applyMaxItemPriceFilter(WebDriver driver, String testCaseName, String maxPrice) throws ActionBotException
	{
		logger.info("Applying maximum item price filter with " + maxPrice);
		ActionBot.sendKeys(driver, PRICE_FILTER_MAX_VALUE, maxPrice);
		ActionBot.findElement(driver, PRICE_FILTER_MAX_VALUE).sendKeys(Keys.RETURN);
		waitTillSearchListLoaded(driver, testCaseName);

		ScreenShot.screenshot(driver, testCaseName, "After applying max price filter");
	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='item_list_row_" + itemId + "']//a[contains(@class,'itmName')]"));
		ScreenShot.screenshot(driver, testCaseName, "Item details");

	}

	@Override
	public List<WebElement> getItemManufacturersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item Manufacturers CheckBox List");
		return ActionBot.findElements(driver, CHECK_BOX_LIST_MANUFACTURERS);
	}

	@Override
	public List<WebElement> getItemSuppliersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item Suppliers CheckBox List");
		return ActionBot.findElements(driver, CHECK_BOX_LIST_SUPPLIERS);
	}

	@Override
	public List<WebElement> getItemSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item Suppliers");
		return ActionBot.findElements(driver, SUPPLIER_NAMES);
	}

	@Override
	public void waitTillSearchListLoaded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, SEARCH_ITEM_LIST_PROCESSING);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnExpandSupplierFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EXPAND_BUTTON_SUPPLIERS_FILTER);
	}

	@Override
	public boolean isAlertpopUpForTwoItemsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, MODAL_TWO_ITEM_SELECT_ALERT_BOX))
		{
			return true;
		}
		return false;

	}

	@Override
	public void clickOnCatalogItemCheckBoxOfItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECK_ITEM_LIST);

	}

	@Override
	public boolean isZeroPriceItemIconPresentInListView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ICON_ZERO_PRICE_ITEM_IN_LIST_VIEW))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSwitchToGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SWITCH_TO_GRID_VIEW);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After switching to grid view");

	}

	@Override
	public boolean isZeroPriceItemIconPresentInGridView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, ICON_ZERO_PRICE_ITEM_IN_GRID_VIEW);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, ICON_ZERO_PRICE_ITEM_IN_GRID_VIEW))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void waitTillCheckoutPageLoaded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV_PROCEEDING_TO_CHECKOUT);
	}

	public void selectFromExistingBasket(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		WebElement select_Baskets = ActionBot.findElement(driver, SELECT_EXISTING_BASKET);
		Select basket_options = new Select(select_Baskets);
		basket_options.selectByIndex(index);
	}

	public void clickOnAddToBasketbutton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, ADD_TO_BASKET_BUTTON);
		ActionBot.click(driver, ADD_TO_BASKET_BUTTON);
	}

	public void clickOnItemCheckBoxbutton(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'chk_item_list')])[" + index + "]"));
	}

	@Override
	public boolean isCompareLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Compare displayed");
		if (ActionBot.isElementDisplayed(driver, LINK_COMPARE_MULTIPLE_ITEMS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAddToCartLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "add to cart displayed");
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_MULTIPLE_TO_CART))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAddToFavouriteDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "add to favourite displayed");
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_MULTIPLE_TO_FAVORITE))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAddToBasketLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "add to basket displayed");
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_MULTIPLE_TO_BASKET))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickSortByRelevance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, LINK_SORT_BY);
		ActionBot.click(driver, SORT_BY_RELEVANCE);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Sort By Relevance");
	}

	@Override
	public void clickSortByPriceLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, LINK_SORT_BY);
		ActionBot.click(driver, SORT_BY_PRICE_LOW_TO_HIGH);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Sort By Price: Low to High");

	}

	@Override
	public void clickSortByPriceHighToLow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, LINK_SORT_BY);
		ActionBot.click(driver, SORT_BY_PRICE_HIGH_TO_LOW);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Sort By Price: High to Low");

	}

	@Override
	public void clickSortByLeadLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, LINK_SORT_BY);
		ActionBot.click(driver, SORT_BY_LEAD_LOW_TO_HIGH);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Sort By Lead: low to high");

	}

	@Override
	public void clickSortByLeadHighToLow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, LINK_SORT_BY);
		ActionBot.click(driver, SORT_BY_LEAD_HIGH_TO_LOW);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Sort By Lead: High to Low");

	}

	@Override
	public void seeOtherFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		try
		{
			ActionBot.waitForElementToBeDisplayed(driver, OTHER_FILTER_OPTIONS, 2);
			ActionBot.click(driver, OTHER_FILTER_OPTIONS);
		}
		catch (Exception e)
		{
			ActionBot.waitForElementToBePresent(driver, 3, OTHER_FILTER_BUTTON);
			ActionBot.waitForElementToBeDisplayed(driver, OTHER_FILTER_BUTTON, 3);
			ActionBot.click(driver, OTHER_FILTER_BUTTON);
		}
	}

	@Override
	public void selectGreenfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 10, CHECK_GREEN_FACET);
		ActionBot.waitForElementToBeDisplayed(driver, CHECK_GREEN_FACET, 10);
		ActionBot.click(driver, CHECK_GREEN_FACET);
	}

	@Override
	public void selectPrefferedfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 10, CHECK_PREFFERED_FACET);
		ActionBot.waitForElementToBeDisplayed(driver, CHECK_PREFFERED_FACET, 10);
		ActionBot.click(driver, CHECK_PREFFERED_FACET);
	}

	@Override
	public boolean isLoadingPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ActionBot.waitForElementToBePresent(driver, 5, SEARCH_ITEM_LIST_PROCESSING);
			ActionBot.waitForElementToBeDisplayed(driver, SEARCH_ITEM_LIST_PROCESSING, 5);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public void seePriceRangeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		try
		{
			ActionBot.waitForElementToBeDisplayed(driver, PRICE_RANGE_DIAGRAM, 2);
		}
		catch (Exception e)
		{
			ActionBot.waitForElementToBePresent(driver, 6, PRICE_RANGE_BUTTON);
			ActionBot.waitForElementToBeDisplayed(driver, PRICE_RANGE_BUTTON, 6);
			ActionBot.click(driver, PRICE_RANGE_BUTTON);
		}
	}

	@Override
	public void insertLowerRangePrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, PRICE_LOWER_RANGE);
		element.click();
		element.clear();
		element.sendKeys("200");
		element.sendKeys(Keys.ENTER);
	}

	@Override
	public void insertHigherRangePrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, PRICE_HIGHER_RANGE);
		element.click();
		element.clear();
		element.sendKeys("500");
		element.sendKeys(Keys.ENTER);
	}

	@Override
	public boolean isItemAlreadyInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//div[contains(@class,'itemInCart')])[" + index + "]"), 60);
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//div[contains(@class,'itemInCart')])[" + index + "]"), 60);
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//div[contains(@class,'itemInCart')])[" + index + "]"));
	}

	@Override
	public void seeMultipleCurrencyOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		try
		{
			ActionBot.waitForElementToBeDisplayed(driver, MULTIPLE_CURRENCY_OPTIONS, 60);
		}
		catch (Exception e)
		{
			ActionBot.waitForElementToBePresent(driver, 60, MULTIPLE_CURRENCY_OPTIONS_BUTTON);
			ActionBot.waitForElementToBeDisplayed(driver, MULTIPLE_CURRENCY_OPTIONS_BUTTON, 60);
			ActionBot.click(driver, MULTIPLE_CURRENCY_OPTIONS_BUTTON);
		}
	}

	@Override
	public void selectPriceOptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'chk_facet_currency_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'chk_facet_currency_')])[" + index + "]"), 60);
		ActionBot.waitForElementToBeEnable(driver, By.xpath("(.//*[contains(@id,'chk_facet_currency_')])[" + index + "]"), 60);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'chk_facet_currency_')])[" + index + "]"));
		ActionBot.defaultHighSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ActionBot.defaultSleep();
			if (ActionBot.isElementEnabled(driver, VIEW_CART))
			{
				ActionBot.click(driver, VIEW_CART);
			}
		}
		catch (Exception e)
		{
			ActionBot.defaultSleep();
			if (ActionBot.isElementEnabled(driver, VIEW_CART))
			{
				ActionBot.click(driver, VIEW_CART);
			}
		}
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getItemPriceCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String price = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//label[contains(@class,'itemPrice')])[" + index + "]"));
		String currency = null;
		int i = 0;
		while (price.charAt(i) != ' ')
		{
			currency = currency + price.charAt(i);
			i++;
		}
		return currency;
	}

	@Override
	public void clickItemDescriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//a[contains(@class,'highlightTerm')])[" + index + "]"), 60);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_list_row_')]//a[contains(@class,'highlightTerm')])[" + index + "]"));
	}

	@Override
	public String getItemContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ITEM_CONTRACT_NUMBER);
	}

	@Override
	public void clickOnCloseItemDescriptionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_ITEM_DESCRIPTION);
	}

	@Override
	public void clicktoAddItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'addToCart_list_')])[" + index + "]"));
	}

	@Override
	public void clicktoSortSearchListingChoiceWise(WebDriver driver, String testCaseName, UI_Elements sortElement) throws Exception
	{
		WebElement element = ActionBot.findElement(driver, sortElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	@Override
	public void toHoverOverTheSortingOptions(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.moveToElement(driver, SEARCH_SORT_LINK);
	}

	@Override
	public String getItemDeliveryLeadDaysIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_detail_popup_')]//span[contains(@class,'leadTime')])[" + index + "]"));
	}

	@Override
	public boolean isItemPresentInSearchListingPageIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'item_list_row_')])[" + index + "]"));
	}

	@Override
	public void clickOnSwitchToListView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.defaultSleep();
		ActionBot.click(driver, LIST_VIEW);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After switching to grid view");

	}

	@Override
	public void clickRadioButtonUsingIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@class='radioItemList'])[" + index + "]"));
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isLeadTimeVisibleIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathExpression = "(.//*[contains(@id,'item_detail_popup_')]//span[contains(@class,'leadTime')])[" + index + "]";
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpathExpression), 10);
		return ActionBot.isElementDisplayed(driver, By.xpath(xpathExpression));
	}

	@Override
	public String getLeadTimeIndexwise(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='txtLeadTime'])[3]"));
	}

	@Override
	public String getCategoryFromCategoryFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CATEGORIES_FILTER);
		String categoryName = ActionBot.findElement(driver, LABEL_CATEGORIES_FROM_FILTER).getAttribute("title");
		return categoryName;
	}

	@Override
	public void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLEAR_FILTER);
		ActionBot.waitTillPopUpIsPresent(driver, IPageOnlineStore.LOADER_SEARCH_ITEM_LIST);
		ScreenShot.screenshot(driver, testCaseName, "After clearing listing page filter");

	}

	@Override
	public double getTotalCartAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		double finalTotalPrice = 0.0D;
		if (ActionBot.isElementDisplayed(driver, TOTAL_CART_AMOUNT))
		{
			String itemPriceInStringWithCurrencyType = ActionBot.findElement(driver, TOTAL_CART_AMOUNT).getText();
			String filteredPrice = itemPriceInStringWithCurrencyType.split(" ")[1];
			filteredPrice = filteredPrice.replaceAll(",", "");
			finalTotalPrice = Double.parseDouble(filteredPrice);
			return finalTotalPrice;
		}
		return -1.0D;
	}

	@Override
	public int getSearchedItemCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count = 0;
		if (ActionBot.isElementDisplayed(driver, ITEMS_FOUND))
		{
			String itemCountInString = ActionBot.findElement(driver, ITEMS_FOUND).getText();
			count = Integer.parseInt(itemCountInString);
			return count;
		}
		return count;
	}

	@Override
	public boolean isNoCatalogItemsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, NO_CATALOG_ITEMS_FOUND_LABEL);
	}
}
