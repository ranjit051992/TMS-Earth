package com.zycus.automation.eproc.pageobjects.pages.settings.companyMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageCompanyMasterDataSettingsImpl implements IPageCompanyMasterDataSettings
{

	@Override
	public String fillSearchCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_COMPANY, companyName);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After entering company name");
		return str;
	}

	@Override
	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_IN_COMPANY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");

	}

	@Override
	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVE_COMPANY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on active link");

	}

	@Override
	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_INACTIVE_COMPANY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactive link");

	}

}
