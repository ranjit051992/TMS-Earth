package com.zycus.automation.eproc.businessflow.locationSettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.LocationSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings.IPageLocationMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings.PageLocationMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowLocationSettings
{
	public static LocationSettings changeStatusOfLocation(WebDriver driver, String testCaseName, String location, LocationSettings locationSettings)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnLocationLink(driver, testCaseName);
		PageLocationMasterDataSettings.fillSearchBox(driver, testCaseName, location);
		PageLocationMasterDataSettings.clickOnGo(driver, testCaseName);
		if (locationSettings.getChangStatus().equalsIgnoreCase(IPageLocationMasterDataSettings.ACTIVE))
		{
			PageLocationMasterDataSettings.clickOnActiveLink(driver, testCaseName);
		}
		if (locationSettings.getChangStatus().equalsIgnoreCase(IPageLocationMasterDataSettings.INACTIVE))
		{
			PageLocationMasterDataSettings.clickOnInactiveLink(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return locationSettings;
	}
}
