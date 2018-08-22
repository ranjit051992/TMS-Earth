/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceCostBookingSummaryCommonImpl implements IModalInvoiceCostBookingSummaryCommon
{
	@Override
	public void clickOnSaveInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_INVOICE_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save invoice summary");
	}

	@Override
	public void clickOnCloseInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_INVOICE_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close invoice summary");
	}

}
