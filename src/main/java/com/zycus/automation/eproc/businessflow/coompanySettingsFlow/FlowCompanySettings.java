package com.zycus.automation.eproc.businessflow.coompanySettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CompanySettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.companyMasterDataSettings.IPageCompanyMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.companyMasterDataSettings.PageCompanyMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowCompanySettings
{
	public static CompanySettings changeStatusOfCompany(WebDriver driver, String testCaseName, String companyName, CompanySettings companySettings)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnCompaniesLink(driver, testCaseName);
		PageCompanyMasterDataSettings.fillSearchCompanyName(driver, testCaseName, companyName);
		PageCompanyMasterDataSettings.clickOnGO(driver, testCaseName);
		if (companySettings.getChangStatus().equalsIgnoreCase(IPageCompanyMasterDataSettings.ACTIVE))
		{
			PageCompanyMasterDataSettings.clickOnActiveLink(driver, testCaseName);
		}
		if (companySettings.getChangStatus().equalsIgnoreCase(IPageCompanyMasterDataSettings.INACTIVE))
		{
			PageCompanyMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return companySettings;
	}
}
