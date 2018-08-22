/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummarycommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceItemSummaryCommonImpl implements IModalInvoiceItemSummaryCommon
{

	@Override
	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_INVOICE_ITEM_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save item summary");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_INVOICE_ITEM_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel item summary");
	}

}
