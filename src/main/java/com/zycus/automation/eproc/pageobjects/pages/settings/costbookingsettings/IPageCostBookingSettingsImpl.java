package com.zycus.automation.eproc.pageobjects.pages.settings.costbookingsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageCostBookingSettingsImpl implements IPageCostBookingSettings
{

	@Override
	public void clickOnProjects(WebDriver driver)
	{
		try
		{
			ActionBot.click(driver, BUTTON_PROJECTS);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnBudget(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_BUDGET);

	}

	@Override
	public void clickOnAccounting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ACCOUNTING);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on accounting section in costbooking settings");

	}

}
