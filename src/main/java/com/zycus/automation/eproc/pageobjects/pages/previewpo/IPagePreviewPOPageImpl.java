/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.previewpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPagePreviewPOPageImpl implements IPagePreviewPOPage
{
	static Logger logger = Logger.getLogger(IPagePreviewPOPageImpl.class);

	@Override
	public String getPreviewGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String privewPageGrossTotal = ActionBot.findElement(driver, LABEL_GROSS_TOTAL_PREVIEW_PO).getText();

		return privewPageGrossTotal;
	}

	@Override
	public String getPreviewPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNo = ActionBot.getTextWithInElement(driver, LABEL_PREVIEW_PO_NO);
		logger.info("PO No on Preview PO Page : " + poNo);
		ScreenShot.screenshot(driver, testCaseName, "PO No on Preview PO Page");
		return poNo;
	}

	@Override
	public String getPreviewPoSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_NAME_PREVIEW_PO);
		logger.info("Supplier Name on Preview PO Page : " + supplierName);
		ScreenShot.screenshot(driver, testCaseName, "Supplier Name on Preview PO Page");
		return supplierName;
	}

	@Override
	public String getPreviewPoBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billToAddress = ActionBot.getTextWithInElement(driver, LABEL_BILL_TO_ADDRESS_PREVIEW_PO);
		logger.info("Bill To Address on Preview PO Page : " + billToAddress);
		ScreenShot.screenshot(driver, testCaseName, "Bill To Address on Preview PO Page");
		return billToAddress;
	}

	@Override
	public String getPreviewPoShipToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String shipToAddress = ActionBot.getTextWithInElement(driver, LABEL_SHIP_TO_ADDRESS_PREVIEW_PO);
		logger.info("Ship To Address on Preview PO Page : " + shipToAddress);
		ScreenShot.screenshot(driver, testCaseName, "Ship To Address on Preview PO Page");
		return shipToAddress;
	}

	@Override
	public String getPreviewPoBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String buyerName = ActionBot.getTextWithInElement(driver, LABEL_BUYER_PREVIEW_PO);
		logger.info("Buyer Name on Preview PO Page : " + buyerName);
		ScreenShot.screenshot(driver, testCaseName, "Buyer Name on Preview PO Page");
		return buyerName;
	}

	@Override
	public String getPreviewPoCBLDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String cbl_details = ActionBot.getTextWithInElement(driver, LABEL_CBL_DETAILS_PREVIEW_PO);
		logger.info("CBL Details on Preview PO Page : " + cbl_details);
		ScreenShot.screenshot(driver, testCaseName, "CBL Details on Preview PO Page");
		return cbl_details;
	}

	@Override
	public String getPreviewPoItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String ItemName = ActionBot.getTextWithInElement(driver, LABEL_ITEM_NAME_PREVIEW_PO);
		logger.info("Item Name on Preview PO Page : " + ItemName);
		ScreenShot.screenshot(driver, testCaseName, "Item Name on Preview PO Page");
		return ItemName;
	}

	@Override
	public String getPreviewPoQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = ActionBot.getTextWithInElement(driver, LABEL_QUANTITY_PREVIEW_PO);
		logger.info("Quantity on Preview PO Page : " + quantity);
		ScreenShot.screenshot(driver, testCaseName, "Quantity on Preview PO Page");
		return quantity;
	}

	@Override
	public String getPreviewPoUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_UNIT_PRICE_PREVIEW_PO);
		logger.info("Unit Price on Preview PO Page : " + unitPrice);
		ScreenShot.screenshot(driver, testCaseName, "Unit Price on Preview PO Page");
		return unitPrice;
	}

	@Override
	public String getPreviewPoTaxesTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxTotal = ActionBot.getTextWithInElement(driver, LABEL_TAXES_TOTAL_PREVIEW_PO);
		logger.info("Tax Total on Preview PO Page : " + taxTotal);
		ScreenShot.screenshot(driver, testCaseName, "Tax Total on Preview PO Page");
		return taxTotal;
	}

}
