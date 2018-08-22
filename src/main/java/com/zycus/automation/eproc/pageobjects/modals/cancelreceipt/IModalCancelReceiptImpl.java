/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cancelreceipt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.IPageReceiptListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalCancelReceiptImpl implements IModalCancelReceipt
{
	static Logger logger = Logger.getLogger(IModalCancelReceiptImpl.class);

	@Override
	public String fillCancelReceiptComment(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CANCEL_RECEIPT_COMMENT, receiptComment);
		String receipt_comment = ActionBot.getTextWithInElement(driver, TEXTBOX_CANCEL_RECEIPT_COMMENT);
		logger.info("Entered Receipt Comment : " + receipt_comment);
		return receipt_comment;
	}

	@Override
	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel receipt button");
		ActionBot.click(driver, BUTTON_CANCEL_RECEIPT);
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.CANCELLING_RECEIPT_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel receipt button");
	}

	@Override
	public void clickOnCloseCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on closec cancel receipt button");
		ActionBot.click(driver, BUTTON_CANCEL_RECEIPT_CLOSE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close cancel receipt button");
	}

}
