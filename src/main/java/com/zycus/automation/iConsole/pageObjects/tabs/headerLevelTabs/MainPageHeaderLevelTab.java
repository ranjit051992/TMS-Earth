package com.zycus.automation.iConsole.pageObjects.tabs.headerLevelTabs;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class MainPageHeaderLevelTab implements IMainPageHeaderLevelTab
{
	public static void clickOnApiConsoleTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_API_CONSOLE);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking API COnsole Tab");
	}
}
