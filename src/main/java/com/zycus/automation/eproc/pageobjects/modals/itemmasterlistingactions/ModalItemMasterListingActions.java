/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemmasterlistingactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public class ModalItemMasterListingActions
{
	static Logger				logger								= Logger.getLogger(ModalItemMasterListingActions.class);

	public static UI_Elements	LINK_DEACTIVE_ITEM_MASTER_CATALOG	= UIFactory.getElements("LINK_DEACTIVE_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_UPDATE_ITEM_MASTER_CATALOG		= UIFactory.getElements("LINK_UPDATE_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_PUBLISH_ITEM_MASTER_CATALOG	= UIFactory.getElements("LINK_PUBLISH_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_DELETE_ITEM_MASTER_CATALOG		= UIFactory.getElements("LINK_DELETE_ITEM_MASTER_CATALOG");
	public static UI_Elements	LINK_CANCEL_SCHEDULE				= UIFactory.getElements("CANCEL_SCHEDULE");

	public static void clickOnDeactivateLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEACTIVE_ITEM_MASTER_CATALOG);
	}

	public static void clickOnUpdateItemMasterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_ITEM_MASTER_CATALOG);
	}

	public static void clickOnPublishItemMasterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PUBLISH_ITEM_MASTER_CATALOG);
	}

	public static void clickOnDeleteLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_ITEM_MASTER_CATALOG);
	}

	public static void clickOnCancelSchedule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_SCHEDULE);
	}

	public static boolean isDeactivateItemMasterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_DEACTIVE_ITEM_MASTER_CATALOG);
		return ActionBot.isElementPresent(driver, LINK_DEACTIVE_ITEM_MASTER_CATALOG);
	}

	public static boolean isUpdateItemMasterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_UPDATE_ITEM_MASTER_CATALOG);
		return ActionBot.isElementPresent(driver, LINK_UPDATE_ITEM_MASTER_CATALOG);
	}

	public static boolean isPublishItemMasterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_PUBLISH_ITEM_MASTER_CATALOG);
		return ActionBot.isElementPresent(driver, LINK_PUBLISH_ITEM_MASTER_CATALOG);
	}

	public static boolean isDeleteItemMasterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_DELETE_ITEM_MASTER_CATALOG);
		return ActionBot.isElementPresent(driver, LINK_DELETE_ITEM_MASTER_CATALOG);
	}

	public static boolean isCancelScheduleLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_CANCEL_SCHEDULE);
		return ActionBot.isElementPresent(driver, LINK_CANCEL_SCHEDULE);
	}

}
