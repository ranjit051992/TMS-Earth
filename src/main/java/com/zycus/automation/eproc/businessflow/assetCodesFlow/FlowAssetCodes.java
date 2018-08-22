package com.zycus.automation.eproc.businessflow.assetCodesFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.AssetCodeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.assetCodeMasterDataSettings.IPageAssetCodeMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.assetCodeMasterDataSettings.PageAssetCodeMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class FlowAssetCodes
{
	public static AssetCodeSettings changeStatusOfAssetCode(WebDriver driver, String testCaseName, String assetCode, String asset, AssetCodeSettings assetCodeSettings)
		throws ActionBotException, FactoryMethodException
	{

		// navigates to TMS
		driver.get(ConfigProperty.getConfig("TMS_URL"));
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
		//Master Data tab
		MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

		PageMasterDataSettings.clickOnAssetCodesLink(driver, testCaseName);
		PageAssetCodeMasterDataSettings.fillSearchAssetCodes(driver, testCaseName, assetCode);
		PageAssetCodeMasterDataSettings.selectAssetOptions(driver, testCaseName, asset);
		PageAssetCodeMasterDataSettings.clickOnGOAssetCodes(driver, testCaseName);
		if (assetCodeSettings.getChangeStatus().equalsIgnoreCase(IPageAssetCodeMasterDataSettings.ACTIVE))
		{
			PageAssetCodeMasterDataSettings.clickOnActiveLinkAssetCode(driver, testCaseName);
		}
		if (assetCodeSettings.getChangeStatus().equalsIgnoreCase(IPageAssetCodeMasterDataSettings.INACTIVE))
		{
			PageAssetCodeMasterDataSettings.clickOnDeactiveLinkAssetCode(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		// navigates to EPROC
		driver.get(ConfigProperty.getConfig("Product_URL"));
		ActionBot.waitForPageLoad(driver);

		ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
		ActionBot.defaultSleep();
		return assetCodeSettings;

	}
}
