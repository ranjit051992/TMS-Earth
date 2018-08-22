package com.zycus.automation.eproc.businessflow.supplierCodeMapMasterDataSettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.supplierCodeMapMasterDataSetting.PageSupplierCodeMapMasterDataSetting;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowSupplierCodeMapMasterDataSettings
{

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 14-Jan-2016 </b> <b>Method :
	 * searchSupplierCodeMap <b>Description : searchSupplierCodeMap </font>
	 * <b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param search </font><b><br>
	 * @param supplierCodeMapOption </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */

	public static void searchSupplierCodeMap(WebDriver driver, String testCaseName, String search, String supplierCodeMapOption) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
		PageMasterDataSettings.clickOnSupplierCodesMapLink(driver, testCaseName);
		PageSupplierCodeMapMasterDataSetting.selectSupplierCodeMapOptions(driver, testCaseName, supplierCodeMapOption);
		PageSupplierCodeMapMasterDataSetting.fillSearch(driver, testCaseName, search);
		PageSupplierCodeMapMasterDataSetting.clickOnGO(driver, testCaseName);
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 14-Jan-2016 </b> <b>Method :
	 * editSupplierCode <b>Description : editSupplierCode </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param search </font><b><br>
	 * @param supplierCodeMapOption </font><b><br>
	 * @param supplierCode </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */

	public static String editSupplierCode(WebDriver driver, String testCaseName, String search, String supplierCodeMapOption, String supplierCode)
		throws ActionBotException, FactoryMethodException
	{
		searchSupplierCodeMap(driver, testCaseName, search, supplierCodeMapOption);
		PageSupplierCodeMapMasterDataSetting.clickOnEdit(driver, testCaseName);
		PageSupplierCodeMapMasterDataSetting.fillSupplierSideCode(driver, testCaseName, supplierCode);
		PageSupplierCodeMapMasterDataSetting.clickOnButtonUpdateSupplierCodeMap(driver, testCaseName);
		// PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
		// testCaseName);
		return supplierCode;

	}
}
