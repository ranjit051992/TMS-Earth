/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.viewpoactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalViewPOActionsImpl implements IModalViewPOActions
{

	@Override
	public void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PREVIEW_PO);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on preview po link");
	}

	@Override
	public void clickOnPrintPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PRINT_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on print po link");
	}

	@Override
	public void clickOnPDFPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PDF_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on PDF po link");
	}

	@Override
	public void clickOnEmailPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EMAIL_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Email po link");
	}

	@Override
	public void clickOnCopyPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Copy po link");
	}

	@Override
	public void clickOnRemindPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REMIND_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Remind PO link");
	}

	@Override
	public void clickOnCreateReceiptPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Receipt link");
	}

	@Override
	public void clickOnCreateInvoicePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_INVOICE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Invoice link");
	}

	@Override
	public void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel PO link");
	}

	@Override
	public void clickOnClosePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close PO link");
	}

	@Override
	public void clickOnAmendPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMEND_PO);
		//ActionBot.defaultSleep();
		ActionBot.defaultMediumSleep();
		//ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amend PO link");
	}

	/*
	 * author : bhakti.sawant
	 */
	@Override
	public void clickOnCreateReceiptViewPoDrpodownLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT_DROPDOWN);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Receipt link");
	}

	@Override
	public void clickOnReleasePoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RELEASE_FIRST_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Release PO link");
	}

	@Override
	public void clickOnReleasePOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_RELEASE_PO))
		{
			ActionBot.click(driver, BUTTON_RELEASE_PO);
			ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Release PO Button");
	}
}
