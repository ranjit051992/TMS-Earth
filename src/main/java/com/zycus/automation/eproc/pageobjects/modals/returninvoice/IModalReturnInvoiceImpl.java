/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.returninvoice;

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
public class IModalReturnInvoiceImpl implements IModalReturnInvoice
{
	static Logger logger = Logger.getLogger(IModalReturnInvoiceImpl.class);

	@Override
	public String fillReturnInvoiceComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_RETURN_INVOICE_COMMENT, returnComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXTBOX_RETURN_INVOICE_COMMENT);
		logger.info("Entered Return Comment : " + comment);
		return comment;
	}

	@Override
	public void clickOnReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on return invoice button");
		ActionBot.click(driver, BUTTON_RETURN_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.RETURN_INVOICE_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on return invoice button");
	}

	@Override
	public void clickOnCancelReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel return invoice button");
		ActionBot.click(driver, BUTTON_CANCEL_RETURN_INVOICE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel return invoice button");
	}

}
