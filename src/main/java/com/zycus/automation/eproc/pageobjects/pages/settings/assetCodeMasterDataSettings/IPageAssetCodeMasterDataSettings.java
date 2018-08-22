package com.zycus.automation.eproc.pageobjects.pages.settings.assetCodeMasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageAssetCodeMasterDataSettings
{
	final static String	ACTIVE						= "active";
	final static String	INACTIVE					= "inactive";

	UI_Elements			TEXTBOX_SEARCH_ASSET_CODES	= UIFactory.getElements("TEXTBOX_SEARCH_ASSET_CODES");
	UI_Elements			BUTTON_GO_ASSET_CODES		= UIFactory.getElements("BUTTON_GO_ASSET_CODES");
	UI_Elements			LINK_ACTIVE_ASSET_CODES		= UIFactory.getElements("LINK_ACTIVE_ASSET_CODES");
	UI_Elements			LINK_DEACTIVE_ASSET_CODES	= UIFactory.getElements("LINK_DEACTIVE_ASSET_CODES");
	UI_Elements			SELECT_ASSET_OPTIONS		= UIFactory.getElements("SELECT_ASSET_OPTIONS");

	public String fillSearchAssetCodes(WebDriver driver, String testCaseName, String assetCode) throws ActionBotException;

	public void clickOnGOAssetCodes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactiveLinkAssetCode(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectAssetOptions(WebDriver driver, String testCaseName, String asset) throws ActionBotException;
}
