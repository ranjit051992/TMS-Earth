package com.zycus.automation.eproc.pageobjects.pages.onlinestore;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public interface IPageOnlineStore
{
	// UI ELEMENTS

	final static UI_Elements		BUTTON_LOGOUT						= UIFactory.getElements("BUTTON_LOGOUT");
	final static UI_Elements		TEXTBOX_ENTER_SEARCH_NAME			= UIFactory.getElements("TEXTBOX_ENTER_SEARCH_NAME");
	final static UI_Elements		BUTTON_SEARCH_BUTTON				= UIFactory.getElements("BUTTON_SEARCH_BUTTON");
	final static UI_Elements		STATUS_LOADER						= UIFactory.getElements("STATUS_LOADER");
	final static UI_Elements		LABEL_ITEM_IN_CART					= UIFactory.getElements("LABEL_ITEM_IN_CART");
	final static UI_Elements		LABEL_ITEM_IN_CART_VALUE			= UIFactory.getElements("LABEL_ITEM_IN_CART_VALUE");
	final static UI_Elements		BUTTON_CHECKOUT_BUTTON				= UIFactory.getElements("BUTTON_CHECKOUT_BUTTON");
	final static UI_Elements		LABEL_CART_TOTAL_AMOUNT				= UIFactory.getElements("LABEL_CART_TOTAL_AMOUNT");
	final static UI_Elements		LOADER_SEARCH_ITEM_LIST				= UIFactory.getElements("LOADER_SEARCH_ITEM_LIST");
	final static UI_Elements		LABEL_COMPARED_ITEM_NAMES			= UIFactory.getElements("LABEL_COMPARED_ITEM_NAMES");
	final static UI_Elements		LINK_FIRST_CATEGORY					= UIFactory.getElements("LINK_FIRST_CATEGORY");
	final static UI_Elements		LINK_FIRST_SUB_CATEGORY				= UIFactory.getElements("LINK_FIRST_SUB_CATEGORY");
	final static UI_Elements		LINK_CDW_PUNCHOUT					= UIFactory.getElements("LINK_CDW_PUNCHOUT");
	UI_Elements						LINK_NEW_MAIN_NAVIGATION			= UIFactory.getElements("LINK_NEW_MAIN_NAVIGATION");
	UI_Elements						LINK_CONFIGURATION_IN_NEW_MAIN_NAV	= UIFactory.getElements("LINK_CONFIGURATION_IN_NEW_MAIN_NAV");
	UI_Elements						LOADER_ITEMS_IN_CART				= UIFactory.getElements("LOADER_ITEMS_IN_CART");
	UI_Elements						BUTTON_GOT_IT						= UIFactory.getElements("BUTTON_GOT_IT");
	final static UI_Elements		TEXT_DISPLAYED_CATEGORY				= UIFactory.getElements("TEXT_DISPLAYED_CATEGORY");
	final static UI_Elements		TOTAL_ITEMS_IN_CART					= UIFactory.getElements("TOTAL_ITEMS_IN_CART");
	final static UI_Elements		EMPTY_THE_CART						= UIFactory.getElements("EMPTY_THE_CART");
	final static UI_Elements		NO_CART_CONTINUE_BUTTON				= UIFactory.getElements("NO_CART_CONTINUE_BUTTON");
	final static UI_Elements		CART_CONTINUE_BUTTON				= UIFactory.getElements("CART_CONTINUE_BUTTON");
	public final static UI_Elements	Yes_DELETE							= UIFactory.getElements("Yes_DELETE");
	public final static UI_Elements	GUIDED_PROCUREMENT					= UIFactory.getElements("GUIDED_PROCUREMENT");

	public static UI_Elements		BUTTON_OK_BANDWIDTH_CHECK			= UIFactory.getElements("BUTTON_OK_BANDWIDTH_CHECK");
	public static UI_Elements		BUTTON_CANCEL_CNS_NOTIFICATION		= UIFactory.getElements("BUTTON_CANCEL_CNS_NOTIFICATION");

	public static UI_Elements		LINK_SWITCH_TO_CLASSIC_VIEW			= UIFactory.getElements("LINK_SWITCH_TO_CLASSIC_VIEW");
	public static UI_Elements		BUTTON_CONTINUE_TO_CLASSIC_VIEW		= UIFactory.getElements("BUTTON_CONTINUE_TO_CLASSIC_VIEW");
	public static UI_Elements		BUTTON_LOGOUT_FROM_RAINBOW			= UIFactory.getElements("BUTTON_LOGOUT_FROM_RAINBOW");
	public static UI_Elements		LOGO_ZYCUS_RAINBOW					= UIFactory.getElements("LOGO_ZYCUS_RAINBOW");
	public final static UI_Elements	LINK_RELATED_CATEGORIES				= UIFactory.getElements("LINK_RELATED_CATEGORIES");
	public final static UI_Elements	LIST_RELATED_CATEGORIES				= UIFactory.getElements("LIST_RELATED_CATEGORIES");
	public final static UI_Elements	LABEL_ALL_ITEM_NAME					= UIFactory.getElements("LABEL_ALL_ITEM_NAME");
	public final static UI_Elements	LABEL_ALL_ITEM_LONG_DESCRIPTION		= UIFactory.getElements("LABEL_ALL_ITEM_LONG_DESCRIPTION");
	public final static UI_Elements	LABEL_ALL_ITEM_SUPPLIER_NAME		= UIFactory.getElements("LABEL_ALL_ITEM_SUPPLIER_NAME");
	public final static UI_Elements	LINK_PUCHOUTS_ITEM_LISTING			= UIFactory.getElements("LINK_PUCHOUTS_ITEM_LISTING");
	public final static UI_Elements	LINK_ALL_PUCHOUTS_LIST_ITEM_LISTING	= UIFactory.getElements("LINK_ALL_PUCHOUTS_LIST_ITEM_LISTING");
	public final static UI_Elements	LINK_NEED_HELP						= UIFactory.getElements("LINK_NEED_HELP");
	public final static UI_Elements	LINK_KNOWLEDGE_HUB					= UIFactory.getElements("LINK_KNOWLEDGE_HUB");
	public final static UI_Elements	BUTTON_GUIDED_PROCUREMENT_VIEW_ALL	= UIFactory.getElements("BUTTON_GUIDED_PROCUREMENT_VIEW_ALL");
	public final static UI_Elements	ALL_EFORMS_POPUP					= UIFactory.getElements("ALL_EFORMS_POPUP");
	public final static UI_Elements	LINK_ALL_EFORMS						= UIFactory.getElements("LINK_ALL_EFORMS");
	public final static UI_Elements	SEARCH_KEYWORDS						= UIFactory.getElements("SEARCH_KEYWORDS");
	public final static UI_Elements	FIRST_SEARCH_KEYWORD				= UIFactory.getElements("FIRST_SEARCH_KEYWORD");

	// METHODS

	String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException;

	void clickSearchButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCheckOut(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCheckOutPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnLogOutButton(WebDriver driver, String testCaseName) throws ActionBotException;

	String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOverFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTextOfFistSubCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstSubCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCDWPunchoutLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfigurationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGotItButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEmptyCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNoCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException;

	public void updateItemQtyInCart(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException;

	public void clickUpdateItemQtyInCart(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnYesdeleteCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnGuidedProcurementLink(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isGuidedProcurementLinkVisible(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickItemInCartindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickRequirementDetailsTabInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean verifyEformFieldInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public void clickOnOkButtonForBandwidthCheck(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCNSNotification(WebDriver driver, String testCaseName) throws ActionBotException;

	public void switchToClassicView(WebDriver driver, TestCase testCase, User user) throws ActionBotException;

	public boolean isRelatedCategoryDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnGuidedProcurementViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnFirstEformUnderGuidedProcurementPopupViaViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
