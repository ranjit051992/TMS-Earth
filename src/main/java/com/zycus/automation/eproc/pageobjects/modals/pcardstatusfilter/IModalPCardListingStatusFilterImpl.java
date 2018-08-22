package com.zycus.automation.eproc.pageobjects.modals.pcardstatusfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author Sanjay.kundu
 * 
 */

public class IModalPCardListingStatusFilterImpl implements IModalPCardListingStatusFilter
{

	@Override
	public void clickOnDraftCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_FILTER_DRAFT);
	}

	@Override
	public void clickOnInUseCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_FILTER_INUSE);
	}

	@Override
	public void clickOnDeactivatedCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_FILTER_DEACTIVATED);
	}

	@Override
	public void clickOnArchivedCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_FILTER_ARCHIVED);
	}

	@Override
	public void clickOnFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FILTER_STATUS);
	}

	@Override
	public void clickOnFilterCancelLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_FILTER_STATUS);
	}

}
