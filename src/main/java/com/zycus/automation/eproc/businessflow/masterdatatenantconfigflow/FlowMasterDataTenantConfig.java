/**
 * 
 */
package com.zycus.automation.eproc.businessflow.masterdatatenantconfigflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.MasterDataTenantConfig;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig.PageMasterDataTenantLevelConfigSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowMasterDataTenantConfig
{
	public static MasterDataTenantConfig changeMasterDataTenantConfig(WebDriver driver, String testCaseName, MasterDataTenantConfig masterDataTenantConfig)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
		ActionBot.scroll(driver, "400");
		// set purchase type
		if (masterDataTenantConfig.getPurchaseType() != null)
		{
			masterDataTenantConfig.setPurchaseType(PageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, masterDataTenantConfig.getPurchaseType()));
		}

		// Use purchase type field to classify purchases
		if (masterDataTenantConfig.getUsePurchaseTypeFieldToClassifyPurchases() != null)
		{
			if (masterDataTenantConfig.getUsePurchaseTypeFieldToClassifyPurchases().equalsIgnoreCase(IConstants.YES))
			{
				PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(driver, testCaseName);
			}
			else if (masterDataTenantConfig.getUsePurchaseTypeFieldToClassifyPurchases().equalsIgnoreCase(IConstants.NO))
			{
				PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(driver, testCaseName);
			}
		}

		// Enforce purchase type-based validation of GL accounts
		if (PageMasterDataTenantLevelConfigSettings.isEnforcePTBasedValidationOfGLAccountYESEnabled(driver, testCaseName))
		{
			if (masterDataTenantConfig.isEnforcePurchaseTypeBasedValidationOfGLAccounts())
			{
				PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			}
			else
			{
				PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			}
		}

		PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
		return masterDataTenantConfig;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get master data settings <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static MasterDataTenantConfig getMasterDataTenantConfig(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		MasterDataTenantConfig masterDataTenantConfig = new MasterDataTenantConfig();
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
		ActionBot.scroll(driver, "400");

		// set purchase type
		masterDataTenantConfig.setPurchaseType(PageMasterDataTenantLevelConfigSettings.getPurchaseType(driver, testCaseName));

		return masterDataTenantConfig;

	}
}
