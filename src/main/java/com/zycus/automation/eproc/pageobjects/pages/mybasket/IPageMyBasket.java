/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mybasket;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public interface IPageMyBasket
{

	final static UI_Elements	TEXT_BASKET_SEARCH						= UIFactory.getElements("TEXT_BASKET_SEARCH");
	final static UI_Elements	SELECT_BASKET_SEARCH_BY					= UIFactory.getElements("SELECT_BASKET_SEARCH_BY");
	final static UI_Elements	BUTTON_BASKET_SEARCH_GO					= UIFactory.getElements("BUTTON_BASKET_SEARCH_GO");
	final static UI_Elements	VIEW_BASKET								= UIFactory.getElements("VIEW_BASKET");
	final static UI_Elements	BUTTON_DELETE_FROM_BASKET				= UIFactory.getElements("BUTTON_DELETE_FROM_BASKET");
	final static UI_Elements	BUTTON_ADD_ITEMS_TO_FAVORITE			= UIFactory.getElements("BUTTON_ADD_ITEMS_TO_FAVORITE");
	final static UI_Elements	BUTTON_ADD_TO_CART						= UIFactory.getElements("BUTTON_ADD_TO_CART");
	final static UI_Elements	ADD_TO_CART_LINK						= UIFactory.getElements("ADD_TO_CART_LINK");
	final static UI_Elements	ADD_TO_BASKET_SUCCESS_MSG				= UIFactory.getElements("ADD_TO_BASKET_SUCCESS_MSG");
	static UI_Elements			BASKET_LIST_PROCESSING					= UIFactory.getElements("BASKET_LIST_PROCESSING");
	static UI_Elements			SUCCESS_MSG_ADD_ITEMS_TO_FAVORITE		= UIFactory.getElements("SUCCESS_MSG_ADD_ITEMS_TO_FAVORITE");
	static UI_Elements			SUCCESS_MSG_ADD_ITEMS_TO_CART			= UIFactory.getElements("SUCCESS_MSG_ADD_ITEMS_TO_CART");
	static UI_Elements			SUCCESS_MSG_DELETE_ITEMS_FROM_BASKET	= UIFactory.getElements("SUCCESS_MSG_DELETE_ITEMS_FROM_BASKET");
	static UI_Elements			ITEMS_IN_BASKET							= UIFactory.getElements("ITEMS_IN_BASKET");

	final static UI_Elements	BUTTON_ACTION_MY_BASKET					= UIFactory.getElements("BUTTON_ACTION_MY_BASKET");

	final static UI_Elements	DELETE_BASKET							= UIFactory.getElements("DELETE_BASKET");

	final static UI_Elements	FIRST_BASKET_IN_LIST					= UIFactory.getElements("FIRST_BASKET_IN_LIST");

	final static UI_Elements	FIRST_ITEM_CHECK_BOX_IN_BASKET			= UIFactory.getElements("FIRST_ITEM_CHECK_BOX_IN_BASKET");

	final static UI_Elements	FIRST_ITEM_IN_BASKET					= UIFactory.getElements("FIRST_ITEM_IN_BASKET");

	final static UI_Elements	VIEW_CART								= UIFactory.getElements("VIEW_CART");

	final static UI_Elements	CLICK_TO_CONTINUE_SHOPPING				= UIFactory.getElements("CLICK_TO_CONTINUE_SHOPPING");

	final static UI_Elements	LABLE_ITEM_NO							= UIFactory.getElements("LABLE_ITEM_NO");

	final static UI_Elements	LABLE_ITEM_NO_SUPPLIER_NAME				= UIFactory.getElements("LABLE_ITEM_NO_SUPPLIER_NAME");

	final static UI_Elements	LABLE_ITEM_PRICE						= UIFactory.getElements("LABLE_ITEM_PRICE");

	final static UI_Elements	LABLE_ITEM_QTY							= UIFactory.getElements("LABLE_ITEM_QTY");

	final static UI_Elements	ADD_BASKET_TO_CART						= UIFactory.getElements("ADD_BASKET_TO_CART");

	final static UI_Elements	FIRST_ITEM_QTY							= UIFactory.getElements("FIRST_ITEM_QTY");

	final static UI_Elements	SORT_BASKET_PRICE						= UIFactory.getElements("SORT_BASKET_PRICE");

	final static UI_Elements	BASKET_ITEM_CAPACITY					= UIFactory.getElements("BASKET_ITEM_CAPACITY");

	final static UI_Elements	BUTTON_CANCEL_ADD_TO_BASKET				= UIFactory.getElements("BUTTON_CANCEL_ADD_TO_BASKET");

	final static UI_Elements	SELECT_BASKET_SHARING_SCOPE				= UIFactory.getElements("SELECT_BASKET_SHARING_SCOPE");

	final static UI_Elements	SAVE_SELECTED_Ous						= UIFactory.getElements("SAVE_SELECTED_Ous");

	final static UI_Elements	SHARE_BASKET_BUTTON						= UIFactory.getElements("SHARE_BASKET_BUTTON");

	final static UI_Elements	ACTION_SHARE_BASKET						= UIFactory.getElements("ACTION_SHARE_BASKET");

	final static UI_Elements	ACTION_UNSHARE_BASKET					= UIFactory.getElements("ACTION_UNSHARE_BASKET");

	final static UI_Elements	DEPARTMENT_SEARCH_BOX					= UIFactory.getElements("SEARCH_BOX_DEPARTMENT_BASKET_SHARING_DEPARTMENT_SCOPE");

	final static UI_Elements	SEARCH_GO								= UIFactory.getElements("BUTTON_SEARCH_GO");

	final static UI_Elements	CHECKBOX_BASKET_SHARING					= UIFactory.getElements("CHECKBOX_BASKET_SHARING");

	final static UI_Elements	COMPANY_SEARCH_BOX						= UIFactory.getElements("SEARCH_BOX_COMPANY_BASKET_ORGANIZATION_UNITS_SCOPE");

	final static UI_Elements	LINK_SELECT_ALL_BUSINESS_UNITS			= UIFactory.getElements("LINK_SELECT_ALL_BUSINESS_UNITS");

	final static UI_Elements	LINK_SELECT_ALL_LOCATIONS				= UIFactory.getElements("LINK_SELECT_ALL_LOCATIONS");
	final static UI_Elements	ADD_MULTIPLE_ITEMS_TO_CART				= UIFactory.getElements("ADD_MULTIPLE_ITEMS_TO_CART");

	public String fillBasketSearchTextBox(WebDriver driver, String testCaseName, String basketName) throws ActionBotException;

	public String selectBasketSearchBy(WebDriver driver, String testCaseName, String basketName) throws ActionBotException;

	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewBasketLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteFromBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddToCartLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillAddToBasketSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckBoxForItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void waitTillItemDeletedSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfItemsInBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedBasketName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickActionButon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickDeleteBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickFirstBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickFirstItemCheckBoxInBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkMentionedItemNumberDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkMentionedItemNameSupplierNameDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkMentionedItemPriceDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkMentionedItemQtyDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickFirstItemInBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToAddBasketToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public String toFetchQtyOfFirstItemInCurrentBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToSortBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBasketcapacityAvailable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchBasketcapacity(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isFirstItemInBasketPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeletBasketButtonPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void addItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public int addAllBasketItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickToCancelCreationBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickBasketActionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickBasketShareAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectBasketSharingScope(WebDriver driver, String testCaseName, String sharingScope) throws ActionBotException;

	public void searchAndSelectCompanyInOrganizationUnitsSharingScope(WebDriver driver, String testCaseName, String companyCode) throws ActionBotException;

	public void clickBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectOUUnderBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName, int chioce) throws ActionBotException;

	public void clickLocationsInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectOUUnderLocationsInBasketShareScope(WebDriver driver, String testCaseName, int chioce) throws ActionBotException;

	public void clickToShareBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isShareBasketActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isUnShareBasketActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddBasketToCartActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean isBasketVisible(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void searchAndSelectDepartmentInDepartmentSharingScope(WebDriver driver, String testCaseName, String departmentCode) throws ActionBotException;

	public void selectAllBusinessUnits(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllLocations(WebDriver driver, String testCaseName) throws ActionBotException;
}
