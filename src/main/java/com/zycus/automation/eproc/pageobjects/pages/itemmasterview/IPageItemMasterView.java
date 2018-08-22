package com.zycus.automation.eproc.pageobjects.pages.itemmasterview;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageItemMasterView
{
	static UI_Elements	LINK_ITEM_NAMES_VIEW_CATALOG		= UIFactory.getElements("LINK_ITEM_NAMES_VIEW_CATALOG");
	static UI_Elements	ITEM_MASTER_FIRST_ITEM_LINK			= UIFactory.getElements("ITEM_MASTER_FIRST_ITEM_LINK");
	static UI_Elements	WAREHOUSE_LINK_ON_ITEM_DETAILS		= UIFactory.getElements("WAREHOUSE_LINK_ON_ITEM_DETAILS");
	static UI_Elements	SUPPLIER_COUNT_OF_FIRST_ITEM		= UIFactory.getElements("SUPPLIER_COUNT_OF_FIRST_ITEM");
	static UI_Elements	SUPPLIER_COUNT_LINK					= UIFactory.getElements("SUPPLIER_COUNT_LINK");
	static UI_Elements	ITEM_NAME_LINK						= UIFactory.getElements("ITEM_NAME_LINK");
	static UI_Elements	VIEW_SCOPE_LINK						= UIFactory.getElements("VIEW_SCOPE_LINK");
	static UI_Elements	VIEW_SCOPE_POP_UP_HEADER			= UIFactory.getElements("VIEW_SCOPE_POP_UP_HEADER");
	static UI_Elements	VIEW_SCOPE_POP_UP_CLOSE_BUTTON		= UIFactory.getElements("VIEW_SCOPE_POP_UP_CLOSE_BUTTON");
	static UI_Elements	VIEW_DETAILS_SUPPLIER_NAME			= UIFactory.getElements("VIEW_DETAILS_SUPPLIER_NAME");
	static UI_Elements	VIEW_DETAILS_ADDED_ON				= UIFactory.getElements("VIEW_DETAILS_ADDED_ON");
	static UI_Elements	VIEW_DETAILS_LAST_UPDATED_ON		= UIFactory.getElements("VIEW_DETAILS_LAST_UPDATED_ON");
	static UI_Elements	VIEW_DETAILS_VALIDITY				= UIFactory.getElements("VIEW_DETAILS_VALIDITY");
	static UI_Elements	VIEW_DETAILS_PRICE_CURRENCY			= UIFactory.getElements("VIEW_DETAILS_PRICE_CURRENCY");
	static UI_Elements	VIEW_DETAILS_SCOPE					= UIFactory.getElements("VIEW_DETAILS_SCOPE");
	static UI_Elements	VIEW_DETAILS_ACTIVE					= UIFactory.getElements("VIEW_DETAILS_ACTIVE");
	static UI_Elements	VIEW_DETAILS_STATUS					= UIFactory.getElements("VIEW_DETAILS_STATUS");
	static UI_Elements	VALIDITY_VALUE						= UIFactory.getElements("VALIDITY_VALUE");
	//under item heading
	static UI_Elements	STATUS_COLUMN						= UIFactory.getElements("STATUS_COLUMN");
	static UI_Elements	ERP_PART_NO_COLUMN					= UIFactory.getElements("ERP_PART_NO_COLUMN");
	static UI_Elements	MANUFACTURE_PART_ID_COLUMN			= UIFactory.getElements("MANUFACTURE_PART_ID_COLUMN");
	static UI_Elements	ITEM_NAME_COLUMN					= UIFactory.getElements("ITEM_NAME_COLUMN");
	static UI_Elements	CATEGORY_COLUMN						= UIFactory.getElements("CATEGORY_COLUMN");
	static UI_Elements	SUPPLIER_COUNT_COLUMN				= UIFactory.getElements("SUPPLIER_COUNT_COLUMN");
	static UI_Elements	CURRENCY_COLUMN						= UIFactory.getElements("CURRENCY_COLUMN");
	static UI_Elements	MARKET_PRICE_COLUMN					= UIFactory.getElements("MARKET_PRICE_COLUMN");
	static UI_Elements	UOM_COLUMN							= UIFactory.getElements("UOM_COLUMN");
	static UI_Elements	ACTIONS_COLUMN						= UIFactory.getElements("ACTIONS_COLUMN");
	static UI_Elements	VALUE_STATUS_COLUMN					= UIFactory.getElements("VALUE_STATUS_COLUMN");
	static UI_Elements	VALUE_ERP_PART_NO_COLUMN			= UIFactory.getElements("VALUE_ERP_PART_NO_COLUMN");
	static UI_Elements	VALUE_MANUFACTURE_PART_ID_COLUMN	= UIFactory.getElements("VALUE_MANUFACTURE_PART_ID_COLUMN");
	static UI_Elements	VALUE_ITEM_NAME_COLUMN				= UIFactory.getElements("VALUE_ITEM_NAME_COLUMN");
	static UI_Elements	VALUE_CATEGORY_COLUMN				= UIFactory.getElements("VALUE_CATEGORY_COLUMN");
	static UI_Elements	VALUE_SUPPLIER_COUNT_COLUMN			= UIFactory.getElements("VALUE_SUPPLIER_COUNT_COLUMN");
	static UI_Elements	VALUE_CURRENCY_COLUMN				= UIFactory.getElements("VALUE_CURRENCY_COLUMN");
	static UI_Elements	VALUE_MARKET_PRICE_COLUMN			= UIFactory.getElements("VALUE_MARKET_PRICE_COLUMN");
	static UI_Elements	VALUE_UOM_COLUMN					= UIFactory.getElements("VALUE_UOM_COLUMN");
	static UI_Elements	VALUE_ACTIONS_COLUMN				= UIFactory.getElements("VALUE_ACTIONS_COLUMN");

	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstItem(WebDriver driver, String testCaseName);

	public int getSupplierCountOfFirstItem(WebDriver driver, String testCaseName);

	public void clickOnSupplierCountLink(WebDriver driver, String testCaseName);

	public void clickOnItemNameLink(WebDriver driver, String testCaseName);

	public void clickOnViewScopeLink(WebDriver driver, String testCaseName);

	public boolean isSupplierCountLinkPresent(WebDriver driver, String testCaseName);

	public boolean isItemNameLinkPresent(WebDriver driver, String testCaseName);

	public boolean isViewScopeLinkPresent(WebDriver driver, String testCaseName);

	public String getViewScopePopUpHeaderName(WebDriver driver, String testCaseName);

	public void clickOnCloseButton(WebDriver driver, String testCaseName);

	public boolean isCloseButtonPresent(WebDriver driver, String testCaseName);

	public boolean isSupplierNameColumnPresent(WebDriver driver, String testCaseName);

	public boolean isAddedOnColumnPresent(WebDriver driver, String testCaseName);

	public boolean isLastUpdatedOnColumnPresent(WebDriver driver, String testCaseName);

	public boolean isValidityColumnPresent(WebDriver driver, String testCaseName);

	public boolean isCurrencyColumnPresent(WebDriver driver, String testCaseName);

	public boolean isScopeColumnPresent(WebDriver driver, String testCaseName);

	public boolean isActiveColumnPresent(WebDriver driver, String testCaseName);

	public boolean isStatusColumnPresent(WebDriver driver, String testCaseName);

	public String getValidityValue(WebDriver driver, String testCaseName);

	//under item heading

	public boolean isItemStatusColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemERPPartNoColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemManufacturePartIdColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemNameColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemCategoryNameColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemSupplierCountColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemCurrencyColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemMarketPriceColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemUOMColumnPresent(WebDriver driver, String testCaseName);

	public boolean isItemActionsColumnPresent(WebDriver driver, String testCaseName);

	public void clickOnItemStatusColumn(WebDriver driver, String testCaseName);

	public void clickOnItemERPPartNoColumn(WebDriver driver, String testCaseName);

	public void clickOnItemManufacturePartIdColumn(WebDriver driver, String testCaseName);

	public void clickOnItemNameColumn(WebDriver driver, String testCaseName);

	public void clickOnItemCategoryNameColumn(WebDriver driver, String testCaseName);

	public void clickOnItemSupplierCountColumn(WebDriver driver, String testCaseName);

	public void clickOnItemCurrencyColumn(WebDriver driver, String testCaseName);

	public void clickOnItemMarketPriceColumn(WebDriver driver, String testCaseName);

	public void clickOnItemUOMColumn(WebDriver driver, String testCaseName);

	public void clickOnItemActionsColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemERPPartNoColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemManufacturePartIdColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemNameColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemCategoryNameColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemSupplierCountColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemCurrencyColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemMarketPriceColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemUOMColumn(WebDriver driver, String testCaseName);

	public String getValueOfItemActionsColumn(WebDriver driver, String testCaseName);

}
