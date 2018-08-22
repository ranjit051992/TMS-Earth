/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemdetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceItemDetailsImpl implements IModalInvoiceItemDetails
{
	static Logger logger = Logger.getLogger(IModalInvoiceItemDetails.class);

	@Override
	public int fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INVOICE_LINE_NO, Integer.toString(lineNo));
		String line_no = ActionBot.findElement(driver, TEXTBOX_INVOICE_LINE_NO).getAttribute("value").trim();
		logger.info("Entered Line No : " + line_no);
		return Integer.parseInt(line_no);
	}

	@Override
	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INVOICE_ITEM_SHORT_DESCRIPTION, shortDesc);
		String short_desc = ActionBot.findElement(driver, TEXTBOX_INVOICE_ITEM_SHORT_DESCRIPTION).getAttribute("value");
		logger.info("Entered Short Description : " + short_desc);
		return short_desc;
	}

	@Override
	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_INVOICE_ITEM_PRODUCT_CATEGORY);
		if (productCategory != null)
		{
			element.clear();
			element.sendKeys(productCategory);
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
		}
		else
		{
			element.clear();
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
		}
		String product_category = ActionBot.findElement(driver, TEXTBOX_INVOICE_ITEM_PRODUCT_CATEGORY).getAttribute("value");
		logger.info("Selected product category : " + product_category);
		return product_category;
	}

	@Override
	public boolean clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_ITEM_TYPE_GOODS_INVOICE);
		ScreenShot.screenshot(driver, testCaseName, "After selecting Item Type");
		return ActionBot.isElementSelected(driver, SELECT_ITEM_TYPE_GOODS_INVOICE);
	}

	@Override
	public boolean clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_ITEM_TYPE_SERVICES_INVOICE);
		ScreenShot.screenshot(driver, testCaseName, "After selecting Item Type");
		return ActionBot.isElementSelected(driver, SELECT_ITEM_TYPE_SERVICES_INVOICE);
	}

	@Override
	public float fillMarketPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INVOICE_MARKET_PRICE, Float.toString(price));
		String marketPrice = ActionBot.findElement(driver, TEXTBOX_INVOICE_MARKET_PRICE).getAttribute("value");
		logger.info("Market Price : " + marketPrice);
		return Float.parseFloat(marketPrice);
	}

	@Override
	public float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INVOICE_QUANTITY, Float.toString(quantity));
		String quant = ActionBot.findElement(driver, TEXTBOX_INVOICE_QUANTITY).getAttribute("value");
		logger.info("Entered Quantity : " + quant);
		return Float.parseFloat(quant);
	}

}
