/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.requestadditionalitems;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IPopupRequestAdditiondalItemsImpl implements IPopupRequestAdditiondalItems
{
	@Override
	public void clickOnKeepItemAsItIsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_KEEP_ITEM_AS_IT_IS);
	}

	@Override
	public void clickOnDeleteItemInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DELETE_ITEM_IN_CART);
	}

	@Override
	public void clickOnCreateDraftReauisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_DRAFT_REQUISITION);
	}

}
