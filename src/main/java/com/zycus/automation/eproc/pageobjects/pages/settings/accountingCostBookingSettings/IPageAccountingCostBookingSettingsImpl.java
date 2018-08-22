package com.zycus.automation.eproc.pageobjects.pages.settings.accountingCostBookingSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageAccountingCostBookingSettingsImpl implements IPageAccountingCostBookingSettings
{

	@Override
	public void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_EPROC_USE_ASSET_CODE_YES);
		ScreenShot.screenshot(driver, testCaseName, "After clciking on use asset code_YES");

	}

	@Override
	public void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_EPROC_USE_ASSET_CODE_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clciking on use asset code_NO");

	}

}
