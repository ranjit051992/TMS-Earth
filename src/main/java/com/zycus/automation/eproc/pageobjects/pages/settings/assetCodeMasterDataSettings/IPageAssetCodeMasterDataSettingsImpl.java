package com.zycus.automation.eproc.pageobjects.pages.settings.assetCodeMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPageAssetCodeMasterDataSettingsImpl implements IPageAssetCodeMasterDataSettings
{

	@Override
	public String fillSearchAssetCodes(WebDriver driver, String testCaseName, String assetCode) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_ASSET_CODES, assetCode);
		ActionBot.defaultSleep();
		return ActionBot.getTextWithInElement(driver, TEXTBOX_SEARCH_ASSET_CODES);
	}

	@Override
	public void clickOnGOAssetCodes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_ASSET_CODES);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnActiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVE_ASSET_CODES);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnDeactiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEACTIVE_ASSET_CODES);
		ActionBot.defaultSleep();

	}

	@Override
	public String selectAssetOptions(WebDriver driver, String testCaseName, String asset) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_ASSET_OPTIONS, IConstantsData.SELECT_BY_VISIBLE_TEXT, asset);
	}

}
