package com.zycus.automation.eproc.pageobjects.modals.poactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOActionsImpl implements IModalPOActions
{
	@Override
	public void clickOnCopyFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_ACTIONS);
		//ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCreateReceiptFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT_ACTIONS);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on create receipt");

	}

	@Override
	public void clickOnCreateInvoiceFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_INVOICE_ACTIONS);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on create invoice");

	}

	@Override
	public void clickOnClosePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_ACTIONS);

	}

	@Override
	public void clickOnDeleteFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete PO option");

	}

	@Override
	public void clickOnDownloadFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DOWNLOAD_ACTIONS);
		ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on download PO option");

	}

	@Override
	public void clickOnAmendPOFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMEND_PO_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amend PO aption");

	}

	@Override
	public boolean isCopyPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_COPY_ACTIONS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCreateReceiptFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_CREATE_RECEIPT_ACTIONS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnReleasePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RELEASE_PO_ACTIONS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on release PO");
	}

	@Override
	public void clickOnRecallApprovalRequestFromActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECALL_APPROVAL_REQUEST_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on recall approval request");

	}

	@Override
	public boolean isDownloadPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_DOWNLOAD_ACTIONS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
