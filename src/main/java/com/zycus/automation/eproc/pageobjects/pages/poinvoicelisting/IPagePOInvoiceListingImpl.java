/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPagePOInvoiceListingImpl implements IPagePOInvoiceListing
{
	static Logger logger = Logger.getLogger(IPagePOInvoiceListingImpl.class);

	@Override
	public String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceNo = ActionBot.getTextWithInElement(driver, LINK_FIRST_INVOICE_NUMBER);
		logger.info("Invoice No : " + invoiceNo);
		return invoiceNo;
	}

	@Override
	public String getFirstInvoiceDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceDate = ActionBot.getTextWithInElement(driver, LABEL_FIRST_INVOICE_DATE);
		logger.info("Invoice Date : " + invoiceDate);
		return invoiceDate;
	}

	@Override
	public String getFirstInvoiceDueDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceDate = ActionBot.getTextWithInElement(driver, LABEL_FIRST_INVOICE_DUE_DATE);
		logger.info("Invoice Due Date : " + invoiceDate);
		return invoiceDate;
	}

	@Override
	public String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceStatus = ActionBot.getTextWithInElement(driver, LABEL_FIRST_INVOICE_STATUS);
		logger.info("Invoice Status : " + invoiceStatus);
		return invoiceStatus;
	}

	@Override
	public void clickOnPOInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_INVOICE_ACTIONS);
	}

	@Override
	public void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FIRST_INVOICE_NUMBER);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCreateInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on create invoice");

	}

	@Override
	public void clickOnReturnInvoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RETURN_INVOICE_ACTIONS);
		ActionBot.defaultSleep();

	}

}
