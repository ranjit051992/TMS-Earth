/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.recallinvoice;

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
public class IModalRecallApprovalInvoiceRequestImpl implements IModalRecallApprovalInvoiceRequest
{
	static Logger logger = Logger.getLogger(IModalRecallApprovalInvoiceRequestImpl.class);

	@Override
	public String fillRecallApprovalInvoiceComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_RECALL_APPROVAL_INVOICE_COMMENT, recallComment);
		String recall_comment = ActionBot.getTextWithInElement(driver, TEXTBOX_RECALL_APPROVAL_INVOICE_COMMENT);
		logger.info("Entered Recall Comment : " + recall_comment);
		return recall_comment;
	}

	@Override
	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on recall button");
		ActionBot.click(driver, BUTTON_RECALL_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.RECALL_INVOICE_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on recall button");
	}

	@Override
	public void clickOnCancelRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_RECALL_INVOICE);
	}

}
