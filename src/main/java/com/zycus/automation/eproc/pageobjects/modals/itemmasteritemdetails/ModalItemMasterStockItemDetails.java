package com.zycus.automation.eproc.pageobjects.modals.itemmasteritemdetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class ModalItemMasterStockItemDetails
{
	static Logger				logger							= Logger.getLogger(ModalItemMasterStockItemDetails.class);
	public static UI_Elements	WAREHOUSE_LINK_ON_ITEM_DETAILS	= UIFactory.getElements("WAREHOUSE_LINK_ON_ITEM_DETAILS");
	public static UI_Elements	SPECIFICATION_TAB_LINK			= UIFactory.getElements("SPECIFICATION_TAB_LINK");
	public static UI_Elements	ATTACHMENT_TAB_LINK				= UIFactory.getElements("ATTACHMENT_TAB_LINK");

	public static boolean isWarehouseLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, WAREHOUSE_LINK_ON_ITEM_DETAILS);
	}

	public static void clickOnSpecificationTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking specification tab");
		ActionBot.click(driver, SPECIFICATION_TAB_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking specification tab");
	}

	public static void clickOnAttachmentTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking attachment tab");
		ActionBot.click(driver, ATTACHMENT_TAB_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking attachment tab");
	}

}
