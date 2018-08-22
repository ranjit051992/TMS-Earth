/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicenofilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.IPageInvoiceListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceNoFilterImpl implements IModalInvoiceNoFilter
{
	static Logger logger = Logger.getLogger(IModalInvoiceNoFilterImpl.class);

	@Override
	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_FILTER_INVOICE_NO, invoiceNo);
		String invoice_no = ActionBot.findElement(driver, TEXTBOX_FILTER_INVOICE_NO).getAttribute("value");
		logger.info("Entered Invoice No : " + invoice_no);
		return invoice_no;
	}

	@Override
	public void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_INVOICE_NO_FILTER);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.INVOICE_LISTING_PROCESSING);
		ActionBot.defaultSleep();
	}

}
