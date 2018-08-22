/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.itemmastercataloglisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * 
 * 
 * @author ankita.sawant
 * 
 */
public class PageItemMasterCatalogListing
{
	static Logger				logger											= Logger.getLogger(PageItemMasterCatalogListing.class);

	public static UI_Elements	BUTTON_ADD_ITEM_MASTER_CATALOG					= UIFactory.getElements("BUTTON_ADD_ITEM_MASTER_CATALOG");
	public static UI_Elements	TEXTBOX_FILTER_ITEM_MASTER_NAME					= UIFactory.getElements("TEXTBOX_FILTER_ITEM_MASTER_NAME");
	public static UI_Elements	LINK_VIEW_ITEM_MASTER_CATALOG					= UIFactory.getElements("LINK_VIEW_ITEM_MASTER_CATALOG");
	public static UI_Elements	LABEL_VERSION_OF_ITEM_MASTER_CATALOG			= UIFactory.getElements("LABEL_VERSION_OF_ITEM_MASTER_CATALOG");
	public static UI_Elements	LABEL_ITEMS_OF_ITEM_MASTER_CATALOG				= UIFactory.getElements("LABEL_ITEMS_OF_ITEM_MASTER_CATALOG");
	public static UI_Elements	LABEL_LAST_UPDATED_ON_OF_ITEM_MASTER_CATALOG	= UIFactory.getElements("LABEL_LAST_UPDATED_ON_OF_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_ACTIONS_OF_ITEM_MASTER_CATALOG				= UIFactory.getElements("LINK_ACTIONS_OF_ITEM_MASTER_CATALOG");
	public static UI_Elements	LABEL_STATUS_OF_ITEM_MASTER_CATALOG				= UIFactory.getElements("LABEL_STATUS_OF_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_EDIT_ITEM_MASTER							= UIFactory.getElements("LINK_EDIT_ITEM_MASTER");
	public static UI_Elements	LINK_VIEW_ITEM_MASTER_ACTIONS_LINK				= UIFactory.getElements("LINK_VIEW_ITEM_MASTER_ACTIONS_LINK");

	public static void clickOnAddItemMasterCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_ITEM_MASTER_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add item master catalog button");
	}

	public static String fillItemMasterName(WebDriver driver, String testCaseName, String itemMasterName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_FILTER_ITEM_MASTER_NAME);
		element.sendKeys(itemMasterName);
		element.sendKeys(Keys.ENTER);
		logger.info("Entered Item Master Name : " + element.getAttribute("value"));
		ActionBot.defaultSleep();
		return itemMasterName;
	}

	public static void clickOnViewFirstItemMasterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_ITEM_MASTER_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view item master catalog link");
	}

	public static String getStatusOfFirstItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_ITEM_MASTER_CATALOG);
		logger.info("Status of Item Master : " + status);
		return status;
	}

	public static void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIONS_OF_ITEM_MASTER_CATALOG);
	}

	public static String getVersionOfItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String version = ActionBot.getTextWithInElement(driver, LABEL_VERSION_OF_ITEM_MASTER_CATALOG);
		logger.info("Version of Item Master : " + version);
		return version;
	}

	public static String getFirstItemMasterName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemMasterName = ActionBot.getTextWithInElement(driver, LINK_VIEW_ITEM_MASTER_CATALOG);
		logger.info("First Item Master Name : " + itemMasterName);
		return itemMasterName;
	}

	public static void clickEditItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit item master catalog button");
	}

	public static void clickViewItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_ITEM_MASTER_ACTIONS_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view item master catalog button");
	}

}
