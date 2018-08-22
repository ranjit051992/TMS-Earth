/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.pcardactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPCardListingActionsImpl implements IModalPCardListingActions
{

	@Override
	public void clickOnActivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVATE_PCARD_ACTIONS);
	}

	@Override
	public void clickOnEditPCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_PCARD_ACTIONS);
	}

	@Override
	public void clickOnArchivePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ARCHIVE_PCARD_ACTIONS);
	}

	@Override
	public void clickOnDeactivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEACTIVATE_PCARD_ACTIONS);
	}

}
