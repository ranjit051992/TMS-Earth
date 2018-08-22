/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesupplierlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageInviteSupplierListingImpl implements IPageInviteSupplierListing
{
	static Logger logger = Logger.getLogger(IPageInviteSupplierListingImpl.class);

	@Override
	public void clickOnSendInvitationsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_INVITATIONS);
	}

	@Override
	public String fillSearchSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_SUPPLIER_NAME_INVITE_SUPPLIER, supplierName);
		ActionBot.findElement(driver, TEXTBOX_SEARCH_SUPPLIER_NAME_INVITE_SUPPLIER).sendKeys(Keys.ARROW_DOWN);
		String enteredSupplierName = ActionBot.getAttributeOfElement(driver, TEXTBOX_SEARCH_SUPPLIER_NAME_INVITE_SUPPLIER, "value").trim();
		logger.info("Entered Supplier Name : " + enteredSupplierName);
		return enteredSupplierName;
	}

	@Override
	public void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on filter button");
		ActionBot.click(driver, BUTTON_FILTER_SUPPLIERS_INVITATIONS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on filter button");
	}

	@Override
	public void clickOnClearFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on clear filter button");
		ActionBot.click(driver, BUTTON_CLEAR_FILTER_INVITE_SUPPLIER_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on clear filter button");
	}

	@Override
	public void clickOnInvitedStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on invited supplier filter button");
		ActionBot.click(driver, LINK_INVITED_INVITATION_STATUS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on invited supplier filter button");
	}

	@Override
	public void clickOnCancelledStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancelled supplier filter button");
		ActionBot.click(driver, LINK_CANCELLED_INVITATION_STATUS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancelled supplier filter button");
	}

	@Override
	public String getSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_INVITED_SUPPLIER_NAME);
		logger.info("Searched Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getSearchedSupplierInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierInfo = ActionBot.getTextWithInElement(driver, LABEL_INVITED_SUPPLIER_INFO);
		logger.info("Searched Supplier Info : " + supplierInfo);
		return supplierInfo;
	}

	@Override
	public void clickOnRemindSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on remind supplier link");
		ActionBot.click(driver, LINK_REMIND_SUPPLIER_INVITE_SUPPLIER_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on remind supplier link");
		waitTillProgressingDivIsPresent(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCancelInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel supplier invitation link");
		ActionBot.click(driver, LINK_CANCEL_INVITATION_INVITE_SUPPLIER_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel supplier invitation link");
		waitTillProgressingDivIsPresent(driver, testCaseName);
	}

	@Override
	public String waitTillProgressingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String successMsg = null;
		if (ActionBot.isElementPresent(driver, PROGRESSING_DIV_INVITE_SUPPLIER_LISTING))
		{
			successMsg = ActionBot.getTextWithInElement(driver, PROGRESSING_DIV_INVITE_SUPPLIER_LISTING);
		}
		logger.info("Success Message : " + successMsg);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_INVITE_SUPPLIER_LISTING);
		return successMsg;
	}

	@Override
	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, DIV_DATA_TABLES_EMPTY);
	}

}
