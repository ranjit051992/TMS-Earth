/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closeinvoice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.IPageInvoiceListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalCloseInvoiceImpl implements IModalCloseInvoice
{
	static Logger logger = Logger.getLogger(IModalCloseInvoiceImpl.class);

	@Override
	public String fillCloseComments(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CLOSE_INVOICE_COMMENT, closeComment);
		String close_comment = ActionBot.getTextWithInElement(driver, TEXTBOX_CLOSE_INVOICE_COMMENT);
		logger.info("Entered Close Comment : " + close_comment);
		return close_comment;
	}

	@Override
	public void clickOnCloseInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close invoice button");
		ActionBot.click(driver, BUTTON_CLOSE_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.CLOSE_INVOICE_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close invoice button");
	}

	@Override
	public void clickOnCancelInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel close invoice button");
		ActionBot.click(driver, BUTTON_CANCEL_CLOSE_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel close invoice button");
	}

}
