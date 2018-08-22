package com.zycus.automation.eproc.pageobjects.pages.settings.accountingCostBookingSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageAccountingCostBookingSettings
{
	static UI_Elements	RADIO_BUTTON_EPROC_USE_ASSET_CODE_YES	= UIFactory.getElements("RADIO_BUTTON_EPROC_USE_ASSET_CODE_YES");
	static UI_Elements	RADIO_BUTTON_EPROC_USE_ASSET_CODE_NO	= UIFactory.getElements("RADIO_BUTTON_EPROC_USE_ASSET_CODE_NO");

	public void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDisplayAssetCodeFieldForAssigningACodeToAnAssetItem_NO(WebDriver driver, String testCaseName) throws ActionBotException;
}
