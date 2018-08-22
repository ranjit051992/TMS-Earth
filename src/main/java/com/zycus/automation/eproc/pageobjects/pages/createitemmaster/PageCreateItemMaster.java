package com.zycus.automation.eproc.pageobjects.pages.createitemmaster;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public class PageCreateItemMaster
{
	static Logger				logger																			= Logger.getLogger(PageCreateItemMaster.class);

	public static UI_Elements	TEXTBOX_ITEM_MASTER_NAME														= UIFactory.getElements("TEXTBOX_ITEM_MASTER_NAME");
	public static UI_Elements	TEXTBOX_WAREHOUSE_FIELD_IN_ITEM_MASTER											= UIFactory.getElements("TEXTBOX_WAREHOUSE_FIELD_IN_ITEM_MASTER");
	public static UI_Elements	RADIO_BUTTON_ITEM_MASTER_TYPE_INVENTORY											= UIFactory.getElements("RADIO_BUTTON_ITEM_MASTER_TYPE_INVENTORY");
	public static UI_Elements	RADIO_BUTTON_ITEM_MASTER_TYPE_NON_INVENTORY										= UIFactory
																													.getElements("RADIO_BUTTON_ITEM_MASTER_TYPE_NON_INVENTORY");
	public static UI_Elements	TEXTBOX_ITEM_MASTER_DESCRIPTION													= UIFactory.getElements("TEXTBOX_ITEM_MASTER_DESCRIPTION");
	public static UI_Elements	BUTTON_NEXT_ITEM_MASTER															= UIFactory.getElements("BUTTON_NEXT_ITEM_MASTER");
	public static UI_Elements	BUTTON_CANCEL_ITEM_MASTER														= UIFactory.getElements("BUTTON_CANCEL_ITEM_MASTER");
	public static UI_Elements	LINK_DISCARD_ITEM_MASTER_CATALOG												= UIFactory.getElements("LINK_DISCARD_ITEM_MASTER_CATALOG");
	public static UI_Elements	SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER											= UIFactory.getElements("SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER");
	public static UI_Elements	TEXTBOX_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE								= UIFactory
																													.getElements("TEXTBOX_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE");
	public static UI_Elements	BUTTON_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE								= UIFactory
																													.getElements("BUTTON_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE");
	public static UI_Elements	LABEL_ERP_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING							= UIFactory
																													.getElements("LABEL_ERP_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LABEL_MANUFACTURER_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING				= UIFactory
																													.getElements("LABEL_MANUFACTURER_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING							= UIFactory
																													.getElements("LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LABEL_CATEGORY_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING						= UIFactory
																													.getElements("LABEL_CATEGORY_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LABEL_SUPPLIER_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING						= UIFactory
																													.getElements("LABEL_SUPPLIER_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LABEL_CURRENCY_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING							= UIFactory
																													.getElements("LABEL_CURRENCY_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	LABEL_UNIT_PRICE_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING							= UIFactory
																													.getElements("LABEL_UNIT_PRICE_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");

	public static UI_Elements	LABEL_UOM_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING									= UIFactory
																													.getElements("LABEL_UOM_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");

	public static UI_Elements	LINK_ACTIONS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING								= UIFactory
																													.getElements("LINK_ACTIONS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING");
	public static UI_Elements	SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER_AT_ITEM_DETAILS_PAGE						= UIFactory
																													.getElements("SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER_AT_ITEM_DETAILS_PAGE");

	public static UI_Elements	LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING_AT_ITEM_DETAILS_PAGE	= UIFactory
																													.getElements("LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING_AT_ITEM_DETAILS_PAGE");

	public static UI_Elements	LINK_ADD_ITEM_ITEM_MASTER														= UIFactory.getElements("LINK_ADD_ITEM_ITEM_MASTER");

	public static UI_Elements	LINK_UPLOAD_VIA_FILE_ITEM_MASTER												= UIFactory.getElements("LINK_UPLOAD_VIA_FILE_ITEM_MASTER");

	public static UI_Elements	TEXTBOX_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE										= UIFactory
																													.getElements("TEXTBOX_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE");

	public static UI_Elements	BUTTON_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE										= UIFactory
																													.getElements("BUTTON_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE");
	public static UI_Elements	WAREHOUSE_ICON																	= UIFactory.getElements("WAREHOUSE_ICON");
	public static UI_Elements	TEXTBOX_DESCRIPTION																= UIFactory.getElements("TEXTBOX_DESCRIPTION");

	//error messages

	public static UI_Elements	ERROR_ITEM_MASTER_SCOPE_MANDATORY												= UIFactory.getElements("ERROR_ITEM_MASTER_SCOPE_MANDATORY");

	public static String fillItemMasterName(WebDriver driver, String testCaseName, String itemMasterName) throws ActionBotException
	{
		String itemMaster_Name = ActionBot.sendKeys(driver, TEXTBOX_ITEM_MASTER_NAME, itemMasterName);
		logger.info("Entered Item Master Name : " + itemMaster_Name);
		return itemMaster_Name;
	}

	public static void clickOnInventoryType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ITEM_MASTER_TYPE_INVENTORY);
	}

	public static void clickOnNonInventoryType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ITEM_MASTER_TYPE_NON_INVENTORY);
	}

	public static String fillItemMasterDescription(WebDriver driver, String testCaseName, String itemMasterDesc) throws ActionBotException
	{
		String desc = ActionBot.sendKeys(driver, TEXTBOX_DESCRIPTION, itemMasterDesc);
		logger.info("Entered Item Master Description : " + desc);
		return desc;
	}

	public static void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Next Button");
		ActionBot.click(driver, BUTTON_NEXT_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "after clicking on Next Button");
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Button");
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "after clicking on Cancel Button");
	}

	public static void clickOnDiscardItemMasterCatalogLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Discard Item Master Catalog Link");
		ActionBot.click(driver, LINK_DISCARD_ITEM_MASTER_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "after clicking on Discard Item Master Catalog Link");
	}

	public static String selectSearchItemIn(WebDriver driver, String testCaseName, String searchItemIn) throws ActionBotException
	{
		String selectedSearchItemIn = null;
		if (ActionBot.isElementPresent(driver, SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER))
		{
			selectedSearchItemIn = ActionBot.selectElement(driver, SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER, IConstantsData.SELECT_BY_VISIBLE_TEXT, searchItemIn);
		}
		else if (ActionBot.isElementPresent(driver, SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER_AT_ITEM_DETAILS_PAGE))
		{
			selectedSearchItemIn = ActionBot.selectElement(driver, SELECT_SEARCH_FOR_ITEM_IN_ITEM_MASTER_AT_ITEM_DETAILS_PAGE, IConstantsData.SELECT_BY_VISIBLE_TEXT, searchItemIn);
		}
		ActionBot.defaultSleep();
		return selectedSearchItemIn;
	}

	public static String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		String enteredSearchText = null;

		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE))
		{
			enteredSearchText = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE, searchText);
		}
		else if (ActionBot.isElementDisplayed(driver, TEXTBOX_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE))
		{
			enteredSearchText = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE, searchText);
		}
		return enteredSearchText;
	}

	public static String getERPPartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String erpId = ActionBot.getTextWithInElement(driver, LABEL_ERP_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("ERP Id : " + erpId);
		return erpId;
	}

	public static String getManufacturerartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String manuId = ActionBot.getTextWithInElement(driver, LABEL_MANUFACTURER_PART_ID_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("Manufacturer Part Id : " + manuId);
		return manuId;
	}

	public static String getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemName = null;
		if (ActionBot.isElementPresent(driver, LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING))
		{
			itemName = ActionBot.getTextWithInElement(driver, LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		}
		else if (ActionBot.isElementPresent(driver, LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING_AT_ITEM_DETAILS_PAGE))
		{
			itemName = ActionBot.getTextWithInElement(driver, LINK_ITEM_DETAILS_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING_AT_ITEM_DETAILS_PAGE);
		}
		logger.info("Item Name : " + itemName);
		return itemName;
	}

	public static String getCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String category = ActionBot.getTextWithInElement(driver, LABEL_CATEGORY_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("Category : " + category);
		return category;
	}

	public static String getSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplier = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_NAME_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("Supplier : " + supplier);
		return supplier;
	}

	public static String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = ActionBot.getTextWithInElement(driver, LABEL_CURRENCY_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("Currency : " + currency);
		return currency;
	}

	public static String getUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_UNIT_PRICE_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("Unit Price : " + unitPrice);
		return unitPrice;
	}

	public static String getUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String uom = ActionBot.getTextWithInElement(driver, LABEL_UOM_FOR_ITEM_MASTER_ITEM_IN_SEACH_LISTING);
		logger.info("UOM : " + uom);
		return uom;
	}

	public static void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Search Go Button");

		if (ActionBot.isElementDisplayed(driver, BUTTON_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE))
		{
			ActionBot.click(driver, BUTTON_SEARCH_FOR_ITEM_IN_ITEM_MASTER_SCOPE_PAGE);
		}
		else if (ActionBot.isElementDisplayed(driver, BUTTON_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE))
		{
			ActionBot.click(driver, BUTTON_SEARCH_FOR_ITEM_IN_BROWSE_ITEM_PAGE);
		}
		ScreenShot.screenshot(driver, testCaseName, "after clicking on Search Go Button");
	}

	public static boolean clickOnAddItemMasterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, LINK_ADD_ITEM_ITEM_MASTER, 60);
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_ITEM_ITEM_MASTER))
		{
			ActionBot.click(driver, LINK_ADD_ITEM_ITEM_MASTER);
			ScreenShot.screenshot(driver, testCaseName, "after clicking on link Add Item");
			return true;
		}
		return false;
	}

	public static boolean clickOnUploadViaFileMasterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_UPLOAD_VIA_FILE_ITEM_MASTER))
		{
			ActionBot.click(driver, LINK_UPLOAD_VIA_FILE_ITEM_MASTER);
			ScreenShot.screenshot(driver, testCaseName, "after clicking on link Upload via File");
			return true;
		}
		return false;
	}

	public static String fillWarehouseName(WebDriver driver, String testCaseName, String warehouseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_WAREHOUSE_FIELD_IN_ITEM_MASTER))
		{
			String warehouse_name = ActionBot.fillAutoCompleteField(driver, TEXTBOX_WAREHOUSE_FIELD_IN_ITEM_MASTER, warehouseName);
			logger.info("Entered Warehouse Name : " + warehouse_name);
			return warehouse_name;
		}
		return null;
	}

	public static boolean isWarehouseIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, WAREHOUSE_ICON);
	}

	public static String getWarehouseAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String address = null;
		try
		{
			WebElement element = ActionBot.getElement(driver, WAREHOUSE_ICON);
			address = element.getAttribute("data-qtipmsg");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return address;
	}

	public static boolean isWarehouseFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementPresent(driver, TEXTBOX_WAREHOUSE_FIELD_IN_ITEM_MASTER))
			return true;
		return false;
	}

	public static boolean isStockTypeInventoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RADIO_BUTTON_ITEM_MASTER_TYPE_INVENTORY))
			return true;
		return false;
	}

	public static boolean isStockTypeNonInventoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RADIO_BUTTON_ITEM_MASTER_TYPE_NON_INVENTORY))
			return true;
		return false;
	}

	public static boolean isErrorMessafeForItemMasterScopePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ITEM_MASTER_SCOPE_MANDATORY))
			return true;
		return false;
	}

}
