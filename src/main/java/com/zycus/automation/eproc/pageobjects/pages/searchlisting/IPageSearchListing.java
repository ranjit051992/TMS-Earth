/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.searchlisting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author puneet.sharma
 */
public interface IPageSearchListing
{

	final static UI_Elements		EMPTY_DATA_TABLE										= UIFactory.getElements("EMPTY_DATA_TABLE");
	final static String				ITEM_NAME_PREFIX										= "item_list_row_";
	final static UI_Elements		ITEM_NAMES												= UIFactory.getElements("ITEM_NAMES");
	final static UI_Elements		BUTTON_CHECKOUT											= UIFactory.getElements("BUTTON_CHECKOUT");
	final static UI_Elements		GRID_VIEW												= UIFactory.getElements("GRID_VIEW");
	final static UI_Elements		LIST_VIEW												= UIFactory.getElements("LIST_VIEW");
	final static UI_Elements		ANCSESTOR_TR											= UIFactory.getElements("ANCSESTOR_TR");

	final static UI_Elements		LABEL_ITEM_IN_CART_VALUE								= IPageOnlineStore.LABEL_ITEM_IN_CART_VALUE;

	final static UI_Elements		TEXTBOX_ENTER_SEARCH_NAME								= IPageOnlineStore.TEXTBOX_ENTER_SEARCH_NAME;
	final static UI_Elements		BUTTON_SEARCH_BUTTON									= IPageOnlineStore.BUTTON_SEARCH_BUTTON;
	final static UI_Elements		BUTTON_CHECKOUT_BUTTON									= IPageOnlineStore.BUTTON_CHECKOUT_BUTTON;
	final static UI_Elements		LINK_COMPARE_MULTIPLE_ITEMS								= UIFactory.getElements("LINK_COMPARE_MULTIPLE_ITEMS");
	final static UI_Elements		LINK_ADD_MULTIPLE_TO_CART								= UIFactory.getElements("LINK_ADD_MULTIPLE_TO_CART");
	final static UI_Elements		LINK_ADD_MULTIPLE_TO_BASKET								= UIFactory.getElements("LINK_ADD_MULTIPLE_TO_BASKET");
	final static UI_Elements		LINK_ADD_MULTIPLE_TO_FAVORITE							= UIFactory.getElements("LINK_ADD_MULTIPLE_TO_FAVORITE");
	final static UI_Elements		ITEM_ADDED_TO_CART_SUCCESS_MESSAGE						= UIFactory.getElements("ITEM_ADDED_TO_CART_SUCCESS_MESSAGE");
	// By ANCESTOR_TR = By.xpath("ancestor::tr");
	By								INPUT													= By.tagName("input");
	final static UI_Elements		SEARCHED_SELECTED_CATEGORY								= UIFactory.getElements("SEARCHED_SELECTED_CATEGORY");
	final static UI_Elements		RELATED_CATEGORIES_SEARCH								= UIFactory.getElements("RELATED_CATEGORIES_SEARCH");
	final static UI_Elements		FIRST_RELATED_SEARCH_CATEGORY_LINK						= UIFactory.getElements("FIRST_RELATED_SEARCH_CATEGORY_LINK");
	final static UI_Elements		GUIDE_ME_EXPAND											= UIFactory.getElements("GUIDE_ME_EXPAND");
	final static UI_Elements		BUTTON_GUIDED_PROCUREMENT								= UIFactory.getElements("BUTTON_GUIDED_PROCUREMENT");
	final static UI_Elements		BUTTON_GUIDED_PROCUREMENT_FOR_NO_RECORDS				= UIFactory.getElements("BUTTON_GUIDED_PROCUREMENT_FOR_NO_RECORDS");
	static UI_Elements				ITEM_DESC												= UIFactory.getElements("ITEM_DESC");
	static UI_Elements				TEXTBOX_ITEM_DESC_FILTER								= UIFactory.getElements("TEXTBOX_ITEM_DESC_FILTER");
	static UI_Elements				SEARCH_ITEM_LIST_PROCESSING								= UIFactory.getElements("SEARCH_ITEM_LIST_PROCESSING");
	static UI_Elements				ITEM_PRICE_ON_SEARCH_LISTING							= UIFactory.getElements("ITEM_PRICE_ON_SEARCH_LISTING");
	static UI_Elements				PRICE_FILTER_MAX_VALUE									= UIFactory.getElements("PRICE_FILTER_MAX_VALUE");
	static UI_Elements				PRICE_FILTER_MIN_VALUE									= UIFactory.getElements("PRICE_FILTER_MIN_VALUE");
	static UI_Elements				CHECK_BOX_LIST_MANUFACTURERS							= UIFactory.getElements("CHECK_BOX_LIST_MANUFACTURERS");

	static UI_Elements				CHECK_BOX_LIST_SUPPLIERS								= UIFactory.getElements("CHECK_BOX_LIST_SUPPLIERS");
	static UI_Elements				SUPPLIER_NAMES											= UIFactory.getElements("SUPPLIER_NAMES");
	static UI_Elements				MODAL_TWO_ITEM_SELECT_ALERT_BOX							= UIFactory.getElements("MODAL_TWO_ITEM_SELECT_ALERT_BOX");
	static UI_Elements				EXPAND_BUTTON_SUPPLIERS_FILTER							= UIFactory.getElements("EXPAND_BUTTON_SUPPLIERS_FILTER");
	static UI_Elements				CHECK_ITEM_LIST											= UIFactory.getElements("CHECK_ITEM_LIST");
	static UI_Elements				ICON_ZERO_PRICE_ITEM_IN_LIST_VIEW						= UIFactory.getElements("ICON_ZERO_PRICE_ITEM_IN_LIST_VIEW");
	static UI_Elements				BUTTON_SWITCH_TO_GRID_VIEW								= UIFactory.getElements("BUTTON_SWITCH_TO_GRID_VIEW");
	static UI_Elements				ICON_ZERO_PRICE_ITEM_IN_GRID_VIEW						= UIFactory.getElements("ICON_ZERO_PRICE_ITEM_IN_GRID_VIEW");
	UI_Elements						LOADING_DIV_PROCEEDING_TO_CHECKOUT						= UIFactory.getElements("LOADING_DIV_PROCEEDING_TO_CHECKOUT");

	String							xpath1_item_title_on_item_details_popup					= ".//*[@id='item_detail_popup_";
	String							xpath2_item_title_on_item_details_popup					= "']//span[contains(@class,'itemTitle')]";

	final static UI_Elements		LINK_SORT_BY											= UIFactory.getElements("LINK_SORT_BY");
	final static UI_Elements		SORT_BY_RELEVANCE										= UIFactory.getElements("SORT_BY_RELEVANCE");
	final static UI_Elements		SORT_BY_PRICE_LOW_TO_HIGH								= UIFactory.getElements("SORT_BY_PRICE_LOW_TO_HIGH");
	final static UI_Elements		SORT_BY_PRICE_HIGH_TO_LOW								= UIFactory.getElements("SORT_BY_PRICE_HIGH_TO_LOW");
	final static UI_Elements		SORT_BY_LEAD_LOW_TO_HIGH								= UIFactory.getElements("SORT_BY_LEAD_LOW_TO_HIGH");
	final static UI_Elements		SORT_BY_LEAD_HIGH_TO_LOW								= UIFactory.getElements("SORT_BY_LEAD_HIGH_TO_LOW");

	final static UI_Elements		SELECT_EXISTING_BASKET									= UIFactory.getElements("SELECT_EXISTING_BASKET");

	final static UI_Elements		ADD_TO_BASKET_BUTTON									= UIFactory.getElements("ADD_TO_BASKET_BUTTON");

	final static UI_Elements		CONFIRMATION_DIALOGUE_FOR_SUCCESSFUL_CHECKOUT_SUBMITION	= UIFactory.getElements("CONFIRMATION_DIALOGUE_FOR_SUCCESSFUL_CHECKOUT_SUBMITION");	// PageSearchListing.xls

	final static UI_Elements		NO_CATLOGUE_FOUND										= UIFactory.getElements("NO_CATLOGUE_FOUND");										// OnlineStorePage.xls

	public final static UI_Elements	OTHER_FILTER_OPTIONS									= UIFactory.getElements("OTHER_FILTER_OPTIONS");

	public final static UI_Elements	OTHER_FILTER_BUTTON										= UIFactory.getElements("OTHER_FILTER_BUTTON");

	public final static UI_Elements	CHECK_PREFFERED_FACET									= UIFactory.getElements("CHECK_PREFFERED_FACET");

	public final static UI_Elements	CHECK_GREEN_FACET										= UIFactory.getElements("CHECK_GREEN_FACET");

	public final static UI_Elements	PRICE_RANGE_DIAGRAM										= UIFactory.getElements("PRICE_RANGE_DIAGRAM");

	public final static UI_Elements	PRICE_RANGE_BUTTON										= UIFactory.getElements("PRICE_RANGE_BUTTON");

	public final static UI_Elements	PRICE_LOWER_RANGE										= UIFactory.getElements("PRICE_LOWER_RANGE");

	public final static UI_Elements	PRICE_HIGHER_RANGE										= UIFactory.getElements("PRICE_HIGHER_RANGE");

	public final static UI_Elements	MULTIPLE_CURRENCY_OPTIONS								= UIFactory.getElements("MULTIPLE_CURRENCY_OPTIONS");

	public final static UI_Elements	MULTIPLE_CURRENCY_OPTIONS_BUTTON						= UIFactory.getElements("MULTIPLE_CURRENCY_OPTIONS_BUTTON");

	public final static UI_Elements	VIEW_CART												= UIFactory.getElements("VIEW_CART");

	public final static UI_Elements	SEARCH_ITEM_LIST										= UIFactory.getElements("SEARCH_ITEM_LIST");

	public final static UI_Elements	ITEM_CONTRACT_NUMBER									= UIFactory.getElements("ITEM_CONTRACT_NUMBER");

	public final static UI_Elements	CLOSE_ITEM_DESCRIPTION									= UIFactory.getElements("CLOSE_ITEM_DESCRIPTION");

	public final static UI_Elements	DESCENDING_ORDER_LEAD_TIME_SORT							= UIFactory.getElements("DESCENDING_ORDER_LEAD_TIME_SORT");

	public final static UI_Elements	ASCENDING_ORDER_LEAD_TIME_SORT							= UIFactory.getElements("ASCENDING_ORDER_LEAD_TIME_SORT");

	public final static UI_Elements	SEARCH_SORT_LINK										= UIFactory.getElements("SEARCH_SORT_LINK");

	public final static UI_Elements	FETCH_LEAD_TIME											= UIFactory.getElements("FETCH_LEAD_TIME");

	public final static UI_Elements	LINK_CATEGORIES_FILTER									= UIFactory.getElements("LINK_CATEGORIES_FILTER");

	public final static UI_Elements	LABEL_CATEGORIES_FROM_FILTER							= UIFactory.getElements("LABEL_CATEGORIES_FROM_FILTER");

	public final static UI_Elements	LABEL_RELATED_CATEGORY									= UIFactory.getElements("LABEL_RELATED_CATEGORY");

	public final static UI_Elements	LINK_CLEAR_FILTER										= UIFactory.getElements("LINK_CLEAR_FILTER");

	public final static UI_Elements	LINK_CLOSE												= UIFactory.getElements("LINK_CLOSE");

	public static final UI_Elements	TOTAL_CART_AMOUNT										= UIFactory.getElements("TOTAL_CART_AMOUNT");

	public static final UI_Elements	ITEMS_FOUND												= UIFactory.getElements("ITEMS_FOUND");

	public static final UI_Elements	CHECKBOX_FIRST_CURRENCY_FILTER							= UIFactory.getElements("CHECKBOX_FIRST_CURRENCY_FILTER");

	public static final UI_Elements	CHECKBOX_FIRST_MANUFACTURER_FILTER						= UIFactory.getElements("CHECKBOX_FIRST_MANUFACTURER_FILTER");

	public static final UI_Elements	CHECKBOX_FIRST_SUPPLIERS_FILTER							= UIFactory.getElements("CHECKBOX_FIRST_SUPPLIERS_FILTER");

	public static final UI_Elements	LINK_WAREHOUSE_FILTER_EXPAND							= UIFactory.getElements("LINK_WAREHOUSE_FILTER_EXPAND");

	public static final UI_Elements	LINK_WAREHOUSE_SELECT_ALL								= UIFactory.getElements("LINK_WAREHOUSE_SELECT_ALL");

	public static final UI_Elements	CHECKBOX_FIRST_CATEGORIES_FILTER						= UIFactory.getElements("CHECKBOX_FIRST_CATEGORIES_FILTER");

	public static final UI_Elements	CHECKBOX_FIRST_OTHERS_FILTER							= UIFactory.getElements("CHECKBOX_FIRST_OTHERS_FILTER");

	public static final UI_Elements	LABEL_FIRST_CURRENCY_FILTER								= UIFactory.getElements("LABEL_FIRST_CURRENCY_FILTER");

	public static final UI_Elements	LABEL_FIRST_MANUFACTURER_FILTER							= UIFactory.getElements("LABEL_FIRST_MANUFACTURER_FILTER");

	public static final UI_Elements	ITEM_DEATILS_MANUFACTURER_NAME							= UIFactory.getElements("ITEM_DEATILS_MANUFACTURER_NAME");

	public static final UI_Elements	ITEM_LEADTIME											= UIFactory.getElements("ITEM_LEADTIME");

	public static final UI_Elements	LABEL_FIRST_SUPPLIER_FILTER								= UIFactory.getElements("LABEL_FIRST_SUPPLIER_FILTER");

	public static final UI_Elements	ITEM_DEATILS_SUPPLIER_NAME								= UIFactory.getElements("ITEM_DEATILS_SUPPLIER_NAME");
	public static final String		CLOSE_ITEM_DESCRIPTION_GENERIC							= "(//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick'])";
	public static final UI_Elements	ITEM_DEATILS_CATEGORY_NAME								= UIFactory.getElements("ITEM_DEATILS_CATEGORY_NAME");
	public static final UI_Elements	LABEL_SUCCESS_MSG_AFTER_ITEM_ADDED_TO_CART				= UIFactory.getElements("LABEL_SUCCESS_MSG_AFTER_ITEM_ADDED_TO_CART");
	public static final UI_Elements	NO_CATALOG_ITEMS_FOUND_LABEL							= UIFactory.getElements("NO_CATALOG_ITEMS_FOUND_LABEL");

	void hoverToGridView(WebDriver driver, String testCaseName) throws ActionBotException;

	List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getItemDescription(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getItemDeliveryDays(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String fillItemQuantity(WebDriver driver, String testCaseName, String itemId, String quantity) throws ActionBotException, TestCaseException;

	void addToCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getItemUnitPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	String getItemPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	void clickOnItemActions(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	void makeItemAsFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	boolean isSearchResultDisplpayed(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException;

	void clickOnSearchButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCheckOutButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCompareMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddMultipleItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddMultipleItemsToBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddMultipleItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOverRelatedCategorySearch(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstRelatedSearchCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGuideMeExpand(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnButtonGuidedProcurement(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnButtonGuidedProcurementForNoRecords(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGuideMeExpandPresent(WebDriver driver) throws ActionBotException;

	void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnCatalogItemCheckBoxOfItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemDescriptions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void applyItemDescFilter(WebDriver driver, String testCaseName, String itemDesc) throws ActionBotException;

	public List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void applyMinItemPriceFilter(WebDriver driver, String testCaseName, String minPrice) throws ActionBotException;

	public void applyMaxItemPriceFilter(WebDriver driver, String testCaseName, String maxPrice) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public List<WebElement> getItemManufacturersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemSuppliersCheckBoxList(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemSuppliers(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillSearchListLoaded(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandSupplierFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAlertpopUpForTwoItemsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isZeroPriceItemIconPresentInListView(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSwitchToGridView(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSwitchToListView(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isZeroPriceItemIconPresentInGridView(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillCheckoutPageLoaded(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCompareLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToCartLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToFavouriteDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToBasketLinkDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSortByRelevance(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSortByPriceLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSortByPriceHighToLow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSortByLeadLowToHigh(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSortByLeadHighToLow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickRadioButtonUsingIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void selectFromExistingBasket(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnAddToBasketbutton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemCheckBoxbutton(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void seeOtherFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectGreenfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectPrefferedfacetFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isLoadingPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void seePriceRangeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void insertLowerRangePrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void insertHigherRangePrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemAlreadyInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void seeMultipleCurrencyOptions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectPriceOptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSearchListingPage(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemPriceCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickItemDescriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemContractNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseItemDescriptionButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clicktoAddItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	public void clicktoSortSearchListingChoiceWise(WebDriver driver, String testCaseName, UI_Elements sortElement) throws Exception;

	public void toHoverOverTheSortingOptions(WebDriver driver, String testCaseName) throws Exception;

	public String getItemDeliveryLeadDaysIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isItemPresentInSearchListingPageIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean isLeadTimeVisibleIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getLeadTimeIndexwise(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCategoryFromCategoryFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public double getTotalCartAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getSearchedItemCount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoCatalogItemsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
