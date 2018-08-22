/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoicesubmitforapproval;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.IPageCreateNonPOInvoice;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPopUpInvoiceSubmitForApprovalImpl implements IPopUpInvoiceSubmitForApproval
{

	@Override
	public void clickOnSendForComfirmation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_SEND_FOR_CONFIRMATION))
		{
			ActionBot.click(driver, BUTTON_SEND_FOR_CONFIRMATION);
			ActionBot.waitTillPopUpIsPresent(driver, IPageCreateNonPOInvoice.UPDATE_INVOICE_PROGRESSING_DIV);
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCaseName, "Send for confirmation");
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Send for confirmation");
		// ActionBot.findElement(driver,
		// IPageInvoiceListing.BUTTON_ADD_INVOICE);
	}

	@Override
	public void clickOnCancelAndEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_AND_EDIT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel and Edit");
	}

}
