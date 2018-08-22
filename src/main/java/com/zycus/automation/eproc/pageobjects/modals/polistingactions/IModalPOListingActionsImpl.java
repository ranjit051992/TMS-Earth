/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.polistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPOListingActionsImpl implements IModalPOListingActions
{

	@Override
	public void clickOnRecallApprovalRequestLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECALL_APPROVAL_REQUEST_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Recall Approval Request");
	}

	@Override
	public void clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REMIND_APPROVER_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Remind Approver");
	}

	@Override
	public void clickOnCopyLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Copy Link");
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnDownloadLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DOWNLOAD_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Download Link");
	}

	@Override
	public void clickOnCreateReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT_ACTIONS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Receipt Link");
	}

	@Override
	public void clickOnCreateInvoiceLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, LINK_CREATE_INVOICE_ACTIONS, 100);
		ActionBot.click(driver, LINK_CREATE_INVOICE_ACTIONS);
		ActionBot.defaultHighSleep();
		ActionBot.clickOnCertificateError(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Invoice Link");
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCloseLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Link");
	}

	@Override
	public void clickOnDeleteLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delete Link");
	}

	@Override
	public void clickOnAmendPOLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMEND_PO_LISTING_ACTIONS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amend PO Link");
	}

	@Override
	public boolean isAmendPOEnable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, LINK_AMEND_PO_LISTING_ACTIONS);
	}
}
