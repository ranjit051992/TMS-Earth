/**
 * 
 */
package com.zycus.automation.eproc.businessflow.systemtenantconfigurationflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.SystemTenantConfiguration;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.systemtenantconfiguration.PageSystemTenantConfiguration;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowSystemTenantConfiguration
{

	public static SystemTenantConfiguration changeSytemTenantConfiguration(WebDriver driver, String testCaseName, SystemTenantConfiguration configuration) throws ActionBotException
	{
		PageOnlineStore.clickOnConfigurationLink(driver, testCaseName);
		PageSystemTenantConfiguration.clickOnSystemTenantConfigurationLink(driver, testCaseName);
		// select tenant name
		PageSystemTenantConfiguration.selectTenantNames(driver, testCaseName, configuration.getTenantName());

		ActionBot.scroll(driver);
		// select custom lang / Display name of pre-defined fields
		PageSystemTenantConfiguration.selectCustomLang(driver, testCaseName, configuration.getCustomLang());
		if (!configuration.getCustomLang().equalsIgnoreCase(IConstantsData.Default_System_Tenant_Custom_Lang_Name))
		{
			// preview
			PageSystemTenantConfiguration.clickOnPreviewCustomLang(driver, testCaseName);
			configuration.setStandardNames(PageSystemTenantConfiguration.getListOfStandardNames(driver, testCaseName));
			configuration.setCustomizedNames(PageSystemTenantConfiguration.getListOfCustomizedNames(driver, testCaseName));
			// close modal
			PageSystemTenantConfiguration.clickOnCloseCustomLangButton(driver, testCaseName);
		}

		// update
		PageSystemTenantConfiguration.clickOnUpdateConfigTenantButton(driver, testCaseName);

		return configuration;
	}
}
