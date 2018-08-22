/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemmasteritemdetails;

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
public class ModalItemMasterItemDetails
{
	static Logger				logger														= Logger.getLogger(ModalItemMasterItemDetails.class);

	// all locators added in SearchListingPage.xls
	public static UI_Elements	ITEM_DETAILS_STANDARD_FIELDS								= UIFactory.getElements("ITEM_DETAILS_STANDARD_FIELDS");
	public static UI_Elements	RADIO_BUTTON_QUOTED_BY_SUPPLIER_ITEM_MASTER_ITEM_DETAILS	= UIFactory.getElements("RADIO_BUTTON_QUOTED_BY_SUPPLIER_ITEM_MASTER_ITEM_DETAILS");
	public static UI_Elements	RADIO_BUTTON_NEED_A_QUOTE_ITEM_MASTER_ITEM_DETAILS			= UIFactory.getElements("RADIO_BUTTON_NEED_A_QUOTE_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_SUPPLIER_NAME_ITEM_MASTER_ITEM_DETAILS				= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_SUPPLIER_PART_ID_ITEM_MASTER_ITEM_DETAILS			= UIFactory.getElements("TEXTBOX_SUPPLIER_PART_ID_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_SHORT_DESCRIPTION_ITEM_MASTER_ITEM_DETAILS			= UIFactory.getElements("TEXTBOX_SHORT_DESCRIPTION_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_ITEM_DESCRIPTION_ITEM_MASTER_ITEM_DETAILS			= UIFactory.getElements("TEXTBOX_ITEM_DESCRIPTION_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	LABEL_PRODUCT_CATEGORY_ITEM_MASTER_ITEM_DETAILS				= UIFactory.getElements("LABEL_PRODUCT_CATEGORY_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	LABEL_ITEM_TYPE_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("LABEL_ITEM_TYPE_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	LABEL_RECEIPT_TYPE_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("LABEL_RECEIPT_TYPE_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_PRICE_ITEM_MASTER_ITEM_DETAILS						= UIFactory.getElements("TEXTBOX_PRICE_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	CHECKBOX_ZERO_PRICE_ITEM_MASTER_ITEM_DETAILS				= UIFactory.getElements("CHECKBOX_ZERO_PRICE_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_CURRENCY_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("TEXTBOX_CURRENCY_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	TEXTBOX_QUANTITY_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("TEXTBOX_QUANTITY_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	LABEL_UOM_ITEM_MASTER_ITEM_DETAILS							= UIFactory.getElements("LABEL_UOM_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	LABEL_ASSET_NUMBERING_REQUIRED_ITEM_MASTER_ITEM_DETAILS		= UIFactory.getElements("LABEL_ASSET_NUMBERING_REQUIRED_ITEM_MASTER_ITEM_DETAILS");
	public static UI_Elements	LABEL_ERP_PART_ID_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("LABEL_ERP_PART_ID_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	BUTTON_ADD_TO_CART_ITEM_MASTER_ITEM_DETAILS					= UIFactory.getElements("BUTTON_ADD_TO_CART_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	BUTTON_ADD_TO_BASKET_ITEM_MASTER_ITEM_DETAILS				= UIFactory.getElements("BUTTON_ADD_TO_BASKET_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	BUTTON_CANCEL_ITEM_MASTER_ITEM_DETAILS						= UIFactory.getElements("BUTTON_CANCEL_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	ASTK_SUPPLIER_NAME_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS	= UIFactory.getElements("ASTK_SUPPLIER_NAME_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS");

	public static UI_Elements	ASTK_PRICE_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS			= UIFactory.getElements("ASTK_PRICE_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS");
	public static UI_Elements	LABEL_SOURCING_STATUS_VALUE_ITEM_MASTER_ITEM_DETAILS		= UIFactory.getElements("LABEL_SOURCING_STATUS_VALUE_ITEM_MASTER_ITEM_DETAILS");

	public static void clickOnQuotedBySupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_QUOTED_BY_SUPPLIER_ITEM_MASTER_ITEM_DETAILS);
	}

	public static void clickOnNeedAQuote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_NEED_A_QUOTE_ITEM_MASTER_ITEM_DETAILS);
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String supplier_Name = ActionBot.fillAutoCompleteField(driver, TEXTBOX_SUPPLIER_NAME_ITEM_MASTER_ITEM_DETAILS, supplierName);
		logger.info("Entered Supplier Name : " + supplier_Name);
		return supplier_Name;
	}

	public static boolean isQuotedBySupplierSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_QUOTED_BY_SUPPLIER_ITEM_MASTER_ITEM_DETAILS);
	}

	public static boolean isNeedAQuoteSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_NEED_A_QUOTE_ITEM_MASTER_ITEM_DETAILS);
	}

	public static boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ASTK_SUPPLIER_NAME_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS);
	}

	public static boolean isPriceMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ASTK_PRICE_MANDATORY_ICON_ITEM_MASTER_ITEM_DETAILS);
	}

	public static Double fillPrice(WebDriver driver, String testCaseName, Double price) throws ActionBotException
	{
		String enteredPrice = ActionBot.sendKeys(driver, TEXTBOX_PRICE_ITEM_MASTER_ITEM_DETAILS, Double.toString(price));
		logger.info("Entered Price : " + enteredPrice);
		return Double.parseDouble(enteredPrice);
	}

	public static Float fillQuantity(WebDriver driver, String testCaseName, Float quantity) throws ActionBotException
	{
		String enteredQuantity = ActionBot.sendKeys(driver, TEXTBOX_QUANTITY_ITEM_MASTER_ITEM_DETAILS, Float.toString(quantity));
		logger.info("Entered Quantity : " + enteredQuantity);
		return Float.parseFloat(enteredQuantity);
	}

	public static void clickOnAddToCartButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Add to cart button");
		ActionBot.click(driver, BUTTON_ADD_TO_CART_ITEM_MASTER_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add to cart button");
	}

	public static void clickOnAddToBasketButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Add to basket button");
		ActionBot.click(driver, BUTTON_ADD_TO_BASKET_ITEM_MASTER_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add to basket button");
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel button");
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_MASTER_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel button");
	}

	public static String getSourcingStatus(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String sourcingStatus = ActionBot.getTextWithInElement(driver, LABEL_SOURCING_STATUS_VALUE_ITEM_MASTER_ITEM_DETAILS);
		logger.info("Sourcing Status : " + sourcingStatus);
		return sourcingStatus;
	}

	public static void clearPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_PRICE_ITEM_MASTER_ITEM_DETAILS);
	}

	public static boolean isAddToCartButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_ADD_TO_CART_ITEM_MASTER_ITEM_DETAILS);
	}
}
