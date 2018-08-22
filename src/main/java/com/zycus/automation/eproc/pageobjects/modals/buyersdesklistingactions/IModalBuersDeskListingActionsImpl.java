/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalBuersDeskListingActionsImpl implements IModalBuersDeskListingActions
{

	@Override
	public void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYERS_DESK_LISTING_EDIT_ACTION);
	}

	@Override
	public void clickOnConvertToPOAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYERS_DESK_LISTING_CONVERT_TO_PO_ACTION);
	}

	@Override
	public void clickOnChangeBuyerAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION);
	}

	@Override
	public void clickOnRejectAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.hover(driver, IPageBuyersDesk.BUTTON_ACTIONS);
		ActionBot.click(driver, IPageBuyersDesk.LINK_RETURN);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Return Link");
	}

	@Override
	public boolean isRejectActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_LISTING_REJECT_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isEditActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_LISTING_EDIT_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isViewActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_LISTING_VIEW_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isConvertToPOActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_LISTING_CONVERT_TO_PO_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isChangeBuyerActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
