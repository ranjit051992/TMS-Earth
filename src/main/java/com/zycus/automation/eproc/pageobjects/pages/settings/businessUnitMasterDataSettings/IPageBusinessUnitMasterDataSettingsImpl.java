package com.zycus.automation.eproc.pageobjects.pages.settings.businessUnitMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageBusinessUnitMasterDataSettingsImpl implements IPageBusinessUnitMasterDataSettings
{

	@Override
	public String fillBUSearchName(WebDriver driver, String testCaseName, String buName) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_BU, buName);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After entering bU name");
		return str;
	}

	@Override
	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_IN_BU);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");
	}

	@Override
	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVE_BU);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on active link");
	}

	@Override
	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_INACTIVE_BU);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactive link");
	}

}
