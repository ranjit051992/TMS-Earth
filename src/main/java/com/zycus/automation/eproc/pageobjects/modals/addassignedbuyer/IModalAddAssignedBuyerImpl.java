/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addassignedbuyer;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAddAssignedBuyerImpl implements IModalAddAssignedBuyer
{
	static Logger logger = Logger.getLogger(IModalAddAssignedBuyerImpl.class);

	@Override
	public String fillAssignedBuyerName(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException
	{
		String assignedBuyer1 = null;
		WebElement assignedBuyer = ActionBot.findElement(driver, INPUT_ASSIGNED_BUYER_AT_BUYERS_DESK_LISTING);
		assignedBuyer.sendKeys(assignedBuyerName);
		// ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
		assignedBuyer.sendKeys(Keys.ARROW_DOWN);
		assignedBuyer.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, LABEL_ASSIGNED_BUYER_ON_CHANGED_BUYER_MODAL))
		{
			assignedBuyer1 = ActionBot.getTextWithInElement(driver, LABEL_ASSIGNED_BUYER_ON_CHANGED_BUYER_MODAL);
		}
		logger.info("Entered assigned Buyer Name : " + assignedBuyer);
		return assignedBuyer1;
	}

	@Override
	public String fillChangedBuyerComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTAREA_BUYER_COMMENTS, comments);
		String buyerCommnets = ActionBot.getTextWithInElement(driver, TEXTAREA_BUYER_COMMENTS);
		logger.info("Comments : " + buyerCommnets);
		return buyerCommnets;
	}

	@Override
	public void clickOnSaveAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save assgined buyer button");
		ActionBot.click(driver, BUTTON_SAVE_BUYER);
		ActionBot.waitTillPopUpIsPresent(driver, IPageBuyersDeskListing.PROCESSING_DIV_SAVING_BUYER);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCancelAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_BUYER_CANCEL);
	}

	@Override
	public void clickOnDropdownBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DROPDOWN_BUYER_ICON);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnSingleBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_SINGLE_BUYER_ICON);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnGroupBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_GROUP_BUYER_ICON);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAssignedBuyerTextbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, INPUT_ASSIGNED_BUYER_AT_BUYERS_DESK_LISTING);

	}

	@Override
	public boolean isAssignedBuyerNameLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_ASSIGNED_BUYER_ON_CHANGED_BUYER_MODAL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnRemoveBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REMOVE_ASSIGNED_BUYER);

	}

	@Override
	public boolean isAssignedBuyerIsMandatoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_ASSIGNED_BUYER_MANDATORY_READY_FOR_APPROVAL_PAGE);
	}

}
