/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invoicelisting;

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
public class IPageInvoiceListingImpl implements IPageInvoiceListing
{
	static Logger logger = Logger.getLogger(IPageInvoiceListingImpl.class);

	@Override
	public void clickOnFromPurchaseOrderButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_INVOICE);
		ActionBot.click(driver, BUTTON_FROM_PURCHASE_ORDER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on From Purchase Order Button");
	}

	@Override
	public void clickOnCreateNonInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_INVOICE);
		ActionBot.click(driver, BUTTON_CREATE_NON_PO_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Non PO Button");
	}

	@Override
	public void clickOnFilterInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FILTER_INVOICE_NO);
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_FILTER_INVOICE_NO);
		element.clear();
		element.sendKeys(supplierName);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);

		String supplier_name = element.getAttribute("value").trim();
		logger.info("Entered Supplier Name : " + supplier_name);
		return supplier_name;
	}

	@Override
	public void clickOnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_INVOICE_ACTIONS);
	}

	@Override
	public String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_INVOICE_STATUS);
		logger.info("Status of Invoice : " + status);
		return status;
	}

	@Override
	public String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceNo = ActionBot.getTextWithInElement(driver, LINK_FIRST_INVOICE_NO);
		logger.info("First Invoice No : " + invoiceNo);
		ScreenShot.screenshot(driver, testCaseName, "Invoice No");
		return invoiceNo;
	}

	@Override
	public void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FIRST_INVOICE_NO);
		ActionBot.defaultMediumSleep();
	}

}
