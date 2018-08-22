/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poinvoicelistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPOInvoiceListingActionsImpl implements IModalPOInvoiceListingActions
{
	@Override
	public void clickOnViewInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view invoice action");
	}

	@Override
	public void clickOnConfirmAndMatchInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CONFIRM_AND_MATCH_INVOICE_ACTIONS);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_CONFIRM_INVOICE);
		ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on confirm and match action");
	}

	@Override
	public void clickOnReturnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RETURN_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on return invoice action");
	}

	@Override
	public void clickOnVoidInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VOID_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on void invoice action");
	}

	@Override
	public void clickOnRecallInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECALL_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on recall invoice action");
	}

	@Override
	public void clickOnEditInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit invoice action");
	}

	@Override
	public void clickOnCloseInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_INVOICE_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close invoice action");
	}
}
