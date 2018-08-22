/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.IPageInvoiceListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceActionsImpl implements IModalInvoiceActions
{

	@Override
	public void clickOnVoidInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VOID_INVOICE);
	}

	@Override
	public void clickOnCloseInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_INVOICE);
	}

	@Override
	public void clickOnReturnInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RETURN_INVOICE);
	}

	@Override
	public void clickOnViewInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_INVOICE);
	}

	@Override
	public void clickOnConfirmAndMatchInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CONFIRM_AND_MATCH_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.CONFIRM_INVOICE_PROCESSING_DIV);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Confirm and Match Invoice");
	}

	@Override
	public void clickOnRecallApprovalRequest(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECALL_APPROVAL_REQUEST_INVOICE);
	}

}
