package com.zycus.automation.eproc.businessflow.businessUnitSettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.BusinessUnitSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.businessUnitMasterDataSettings.IPageBusinessUnitMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.businessUnitMasterDataSettings.PageBusinessUnitMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowBusinessUnitSettings
{
	public static BusinessUnitSettings changeStatusOfBusinessUnit(WebDriver driver, String testCaseName, String buName, BusinessUnitSettings businessUnitSettings)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnBusinessUnitLink(driver, testCaseName);
		PageBusinessUnitMasterDataSettings.fillBUSearchName(driver, testCaseName, buName);
		PageBusinessUnitMasterDataSettings.clickOnGO(driver, testCaseName);
		if (businessUnitSettings.getChangStatus().equalsIgnoreCase(IPageBusinessUnitMasterDataSettings.ACTIVE))
		{
			PageBusinessUnitMasterDataSettings.clickOnActiveLink(driver, testCaseName);
		}
		if (businessUnitSettings.getChangStatus().equalsIgnoreCase(IPageBusinessUnitMasterDataSettings.INACTIVE))
		{
			PageBusinessUnitMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return businessUnitSettings;
	}
}
