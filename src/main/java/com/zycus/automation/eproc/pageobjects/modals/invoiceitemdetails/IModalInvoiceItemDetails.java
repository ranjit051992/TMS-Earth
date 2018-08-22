/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemdetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceItemDetails
{
	static UI_Elements	TEXTBOX_INVOICE_LINE_NO					= UIFactory.getElements("TEXTBOX_INVOICE_LINE_NO");
	static UI_Elements	TEXTBOX_INVOICE_ITEM_SHORT_DESCRIPTION	= UIFactory.getElements("TEXTBOX_INVOICE_ITEM_SHORT_DESCRIPTION");
	static UI_Elements	TEXTBOX_INVOICE_ITEM_PRODUCT_CATEGORY	= UIFactory.getElements("TEXTBOX_INVOICE_ITEM_PRODUCT_CATEGORY");
	static UI_Elements	SELECT_ITEM_TYPE_GOODS_INVOICE			= UIFactory.getElements("SELECT_ITEM_TYPE_GOODS_INVOICE");
	static UI_Elements	SELECT_ITEM_TYPE_SERVICES_INVOICE		= UIFactory.getElements("SELECT_ITEM_TYPE_SERVICES_INVOICE");
	static UI_Elements	TEXTBOX_INVOICE_MARKET_PRICE			= UIFactory.getElements("TEXTBOX_INVOICE_MARKET_PRICE");
	static UI_Elements	TEXTBOX_INVOICE_QUANTITY				= UIFactory.getElements("TEXTBOX_INVOICE_QUANTITY");

	public int fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException;

	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException;

	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException;

	public boolean clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException;

	public float fillMarketPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException;

	public float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException;

}
