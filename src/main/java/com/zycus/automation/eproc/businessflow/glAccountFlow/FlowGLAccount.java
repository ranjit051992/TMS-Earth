package com.zycus.automation.eproc.businessflow.glAccountFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GLAccount;
import com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings.IPageGLAccountsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings.PageGLAccountsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowGLAccount
{
	public static GLAccount createGLAccount(WebDriver driver, String testCaseName, GLAccount glAccount) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
		PageGLAccountsMasterDataSettings.clickOnAddGLAccount(driver, testCaseName);
		PageGLAccountsMasterDataSettings.enterGLAccountName(driver, testCaseName, glAccount.getGlAccountName());
		PageGLAccountsMasterDataSettings.selectCompany(driver, testCaseName, glAccount.getCompany());
		PageGLAccountsMasterDataSettings.selectGLAccountType(driver, testCaseName, glAccount.getGlAccountType());
		PageGLAccountsMasterDataSettings.enterGLAccountCode(driver, testCaseName, glAccount.getGlAccountCode());
		PageGLAccountsMasterDataSettings.clickOnApplyAddGLAccount(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return glAccount;
	}

	public static void deleteGLAccount(WebDriver driver, String testCaseName, String glAccountName) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
		PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, glAccountName);
		PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
		PageGLAccountsMasterDataSettings.clickOnDeleteGLAccount(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

	}

	public static GLAccount changeStatusOfGLAccount(WebDriver driver, String testCaseName, GLAccount glAccount, String glAccountName)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
		PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, glAccountName);
		PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);

		if (glAccount.getChangeStatus().equalsIgnoreCase(IPageGLAccountsMasterDataSettings.ACTIVE))
		{
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
		}
		if (glAccount.getChangeStatus().equalsIgnoreCase(IPageGLAccountsMasterDataSettings.INACTIVE))
		{
			PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
		}

		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return glAccount;

	}
}
