package com.zycus.automation.eproc.businessflow.TMS_paymentTermsSettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.TMS_paymentTermsSettings;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSPaymentTermsMasterDataSettings.PageTMSPaymentTermsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSmasterDataSettings.PageTMSMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.TMS_MainPageHeaderLevelTabs.PageTMSmainHeaderLevelTabs;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;

public class FlowTMSPaymentTermsSettingsFlow
{
	public static TMS_paymentTermsSettings changeStatusOfPaymentTerm(WebDriver driver, String testCaseName, TMS_paymentTermsSettings tms_paymentTermsSettings, int index)
		throws ActionBotException
	{
		PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
		PageTMSMasterDataSettings.clickOnPaymentTerms(driver, testCaseName);
		PageTMSPaymentTermsMasterDataSettings.enterInSearch(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermSearch());
		PageTMSPaymentTermsMasterDataSettings.selectPaymentTermsOption(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermOption());
		PageTMSPaymentTermsMasterDataSettings.clickonOnGO(driver, testCaseName);
		if (tms_paymentTermsSettings.getChangeStatus().equalsIgnoreCase(IConstantsData.ACTIVE_STATUS))
		{
			PageTMSPaymentTermsMasterDataSettings.clickOnActiveLink(driver, testCaseName, index);

		}
		if (tms_paymentTermsSettings.getChangeStatus().equalsIgnoreCase(IConstantsData.INACTIVE_STATUS))
		{
			PageTMSPaymentTermsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName, index);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		return tms_paymentTermsSettings;
	}

	public static TMS_paymentTermsSettings editPaymentTerm(WebDriver driver, String testCaseName, TMS_paymentTermsSettings tms_paymentTermsSettings, int index)
		throws ActionBotException
	{
		PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
		PageTMSMasterDataSettings.clickOnPaymentTerms(driver, testCaseName);
		PageTMSPaymentTermsMasterDataSettings.enterInSearch(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermSearch());
		PageTMSPaymentTermsMasterDataSettings.selectPaymentTermsOption(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermOption());
		PageTMSPaymentTermsMasterDataSettings.clickonOnGO(driver, testCaseName);
		PageTMSPaymentTermsMasterDataSettings.clickOnEditLink(driver, testCaseName, index);
		PageTMSPaymentTermsMasterDataSettings.fillPaymentTermName(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermName());
		PageTMSPaymentTermsMasterDataSettings.clickOnUpdatePaymentTerm(driver, testCaseName);
		return tms_paymentTermsSettings;
	}

	public static String getPaymentTerm(WebDriver driver, String testCaseName, TMS_paymentTermsSettings tms_paymentTermsSettings, int index) throws ActionBotException
	{
		PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
		PageTMSMasterDataSettings.clickOnPaymentTerms(driver, testCaseName);
		PageTMSPaymentTermsMasterDataSettings.enterInSearch(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermSearch());
		PageTMSPaymentTermsMasterDataSettings.selectPaymentTermsOption(driver, testCaseName, tms_paymentTermsSettings.getPaymentTermOption());
		PageTMSPaymentTermsMasterDataSettings.clickonOnGO(driver, testCaseName);
		return PageTMSPaymentTermsMasterDataSettings.getPaymentTermsOfFirstRow(driver, testCaseName, index);
	}
}
