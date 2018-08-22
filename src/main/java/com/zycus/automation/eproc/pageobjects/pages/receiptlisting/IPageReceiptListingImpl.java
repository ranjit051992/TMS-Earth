/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.receiptlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.createreceipt.IPageCreateReceipt;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageReceiptListingImpl implements IPageReceiptListing
{
	static Logger logger = Logger.getLogger(IPageReceiptListingImpl.class);

	@Override
	public boolean checkSuccessfulCreationOfReturnNote(WebDriver driver, String testCaseName, String returnNoteNo) throws ActionBotException
	{
		clickOnClearFilterStatusButton(driver, testCaseName);
		selectReturnNoteStatusFilter(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		List<WebElement> returnNoteNameList = ActionBot.findElements(driver, RETURN_NOTE_NAME_LIST);
		for (WebElement returnNoteName : returnNoteNameList)
		{
			String returnNote = ActionBot.getTextWithInElement(driver, returnNoteName);
			if (returnNote.equals(returnNoteNo))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void clickOnCreateReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_RECEIPT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on create receipt button");
	}

	@Override
	public void clickOnFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECEIPT_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first receipt no");
	}

	@Override
	public String getFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnClearFilterStatusButton(driver, testCaseName);
		selectReceiptInStatusFilter(driver, testCaseName);
		ActionBot.defaultSleep();
		List<WebElement> receiptNumber = ActionBot.findElements(driver, LINK_RECEIPT_NO);
		String receiptNo = ActionBot.getTextWithInElement(driver, receiptNumber.get(0));
		logger.info("Receipt No : " + receiptNo);
		return receiptNo;
	}

	@Override
	public String getFirstReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receiptDate = ActionBot.getTextWithInElement(driver, LABEL_RECEIPT_DATE);
		logger.info("Receipt Date : " + receiptDate);
		return receiptDate;
	}

	@Override
	public String getFirstReceiptStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receiptStatus = ActionBot.getTextWithInElement(driver, LABEL_RECEIPT_STATUS);
		logger.info("Receipt Status : " + receiptStatus);
		return receiptStatus;
	}

	@Override
	public void clickOnViewReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on view receipt button");
		ActionBot.click(driver, LINK_VIEW_RECEIPT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view receipt button");
	}

	@Override
	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel receipt button");
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_CANCEL_RECEIPT);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel receipt button");
	}

	@Override
	public void clickOnEditReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_RECEIPT);
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, IPageCreateReceipt.TEXTBOX_RECEIPT_DATE);
	}

	@Override
	public void clickOnDeleteReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		ActionBot.click(driver, element);
		ActionBot.defaultSleep();
	}

	@Override
	public List<WebElement> getWebElementOfDeleteReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, DELETE_DRAFTED_RETURN_NOTE);
	}

	@Override
	public void clickOnYesButtonReturnNotePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Alert Ok button");
		ActionBot.click(driver, DELETE_DRAFTED_RETURN_NOTE_POPUP);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Alert Ok button");
	}

	@Override
	public void selectReceiptInStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLICK_FILTER_RECEIPT_LISTING_STATUS);
		ActionBot.click(driver, CLICK_ON_SELECT_RECEIPT_FILTER_STATUS);
		ActionBot.click(driver, CLICK_ON_FILTER_BUTTON_RECEIPT_LISTING_STATUS);
	}

	@Override
	public void selectReturnNoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLICK_FILTER_RECEIPT_LISTING_STATUS);
		ActionBot.click(driver, CLICK_ON_SELECT_RETURN_NOTE_FILTER_STATUS);
		ActionBot.click(driver, CLICK_ON_FILTER_BUTTON_RECEIPT_LISTING_STATUS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnClearFilterStatusButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, CLICK_FILTER_RECEIPT_LISTING_STATUS, 15);
		WebElement elementFliterOption = ActionBot.findElement(driver, CLICK_FILTER_RECEIPT_LISTING_STATUS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elementFliterOption);
		WebElement elementClearFilter = ActionBot.findElement(driver, CLICK_ON_CLEAR_FILTER_BUTTON_RECEIPT_LISTING_STATUS);
		executor.executeScript("arguments[0].click();", elementClearFilter);
		ActionBot.defaultMediumSleep();
	}

	@Override
	public String getStatusOfFirstReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> statusReturnNote = ActionBot.findElements(driver, STATUS_OF_RETURN_NOTE);
		String statusRN = ActionBot.getTextWithInElement(driver, statusReturnNote.get(0));
		return statusRN;
	}

	@Override
	public String getFirstReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnClearFilterStatusButton(driver, testCaseName);
		selectReturnNoteStatusFilter(driver, testCaseName);
		ActionBot.defaultLowSleep();
		List<WebElement> returnNotenumber = ActionBot.findElements(driver, RETURN_NOTE_NAME_LIST);
		return ActionBot.getTextWithInElement(driver, returnNotenumber.get(0));
	}

}
