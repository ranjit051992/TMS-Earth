/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.voidinvoice;

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
public class IModalVoidInvoiceImpl implements IModalVoidInvoice
{

	static Logger logger = Logger.getLogger(IModalVoidInvoiceImpl.class);

	@Override
	public String fillVoidInvoiceComment(WebDriver driver, String testCaseName, String voidComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_VOID_INVOICE_COMMENT, voidComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXTBOX_VOID_INVOICE_COMMENT);
		logger.info("Entered void invoice comment : " + comment);
		return comment;
	}

	@Override
	public void clickOnVoidInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Void Invoice Button");
		ActionBot.click(driver, BUTTON_VOID_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.VOID_INVOICE_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Void Invoice Button");
	}

	@Override
	public void clickOnCancelVoidButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Void Invoice Button");
		ActionBot.click(driver, BUTTON_CANCEL_VOID_INVOICE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Void Invoice Button");

	}

}
