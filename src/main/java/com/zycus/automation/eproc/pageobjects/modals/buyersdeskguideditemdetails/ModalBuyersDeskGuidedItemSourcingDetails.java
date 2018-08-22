/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdeskguideditemdetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalBuyersDeskGuidedItemSourcingDetails
{
	static Logger				logger												= Logger.getLogger(ModalBuyersDeskGuidedItemSourcingDetails.class);

	public static UI_Elements	TAB_SOURCING_GUIDED_ITEM							= UIFactory.getElements("TAB_SOURCING_GUIDED_ITEM");
	public static UI_Elements	LABEL_SUPPLIER_NAME_IN_SOURCING_GUIDED_ITEM_TABLE	= UIFactory.getElements("LABEL_SUPPLIER_NAME_IN_SOURCING_GUIDED_ITEM_TABLE");
	public static UI_Elements	LABEL_BID_QUANTITY_IN_SOURCING_GUIDED_ITEM_TABLE	= UIFactory.getElements("LABEL_BID_QUANTITY_IN_SOURCING_GUIDED_ITEM_TABLE");
	public static UI_Elements	LABEL_BID_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE		= UIFactory.getElements("LABEL_BID_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE");
	public static UI_Elements	LABEL_BULK_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE		= UIFactory.getElements("LABEL_BULK_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE");
	public static UI_Elements	LABEL_TOTAL_SAVINGS_IN_SOURCING_GUIDED_ITEM_TABLE	= UIFactory.getElements("LABEL_TOTAL_SAVINGS_IN_SOURCING_GUIDED_ITEM_TABLE");
	public static UI_Elements	LINK_UNLINK_ITEM_SOURCING							= UIFactory.getElements("LINK_UNLINK_ITEM_SOURCING");
	public static UI_Elements	LINK_COPY_UNIT_PRICE								= UIFactory.getElements("LINK_COPY_UNIT_PRICE");

	public static String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_NAME_IN_SOURCING_GUIDED_ITEM_TABLE);
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	public static String getBidQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bidQuantity = ActionBot.getTextWithInElement(driver, LABEL_BID_QUANTITY_IN_SOURCING_GUIDED_ITEM_TABLE);
		logger.info("Bid Quantity : " + bidQuantity);
		return bidQuantity;
	}

	public static String getBidPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bidPrice = ActionBot.getTextWithInElement(driver, LABEL_BID_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE);
		logger.info("Bid Price : " + bidPrice);
		return bidPrice;
	}

	public static String getBulkPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bulkPrice = ActionBot.getTextWithInElement(driver, LABEL_BULK_PRICE_IN_SOURCING_GUIDED_ITEM_TABLE);
		logger.info("Bulk Price : " + bulkPrice);
		return bulkPrice;
	}

	public static String getTotalSavings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String toalSavings = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_SAVINGS_IN_SOURCING_GUIDED_ITEM_TABLE);
		logger.info("Total Savings : " + toalSavings);
		return toalSavings;
	}

	public static void clickOnUnlinkItemSourcingLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UNLINK_ITEM_SOURCING);
	}

	public static void clickOnCopyUnitPriceLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_UNIT_PRICE);
	}

	public static void clickOnSourcingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_SOURCING_GUIDED_ITEM);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on sourcing tab");
	}

	public static boolean isSourcingTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TAB_SOURCING_GUIDED_ITEM);
	}

}
