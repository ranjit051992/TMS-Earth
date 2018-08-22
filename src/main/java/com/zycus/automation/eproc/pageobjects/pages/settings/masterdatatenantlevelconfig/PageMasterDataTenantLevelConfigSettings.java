package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageMasterDataTenantLevelConfigSettings
{
	public static void removePurchaseType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		iPageMasterDataTenantLevelConfigSettings.removePurchaseType(driver, testCaseName);
	}

	public static String addPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, purchaseType);
	}

	public static boolean clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
	}

	public static boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(driver, testCaseName);
	}

	public static boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(driver, testCaseName);
	}

	public static boolean clickOnEnforcePTBasedValidationOfGLAccountsYES(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
	}

	public static boolean clickOnEnforcePTBasedValidationOfGLAccountsNO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
	}

	public static boolean isEnforcePTBasedValidationOfGLAccountsYESNOSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.isEnforcePTBasedValidationOfGLAccountsYESNOSettingPresent(driver, testCaseName);
	}

	public static boolean isAllowsplittingcosttomultiplecostcentersYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.isAllowsplittingcosttomultiplecostcentersYes(driver, testCaseName);
	}

	public static String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.getPurchaseType(driver, testCaseName);
	}

	public static boolean isEnforcePTBasedValidationOfGLAccountYESEnabled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.isEnforcePTBasedValidationOfGLAccountYESEnabled(driver, testCaseName);
	}

	public static boolean isManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.isManageStockAtWarehouseLevel(driver, testCaseName);
	}

	public static boolean clickOnManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnManageStockAtWarehouseLevel(driver, testCaseName);
	}

	public static boolean clickOnAllowEditingPurchaseTypeLineLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowEditingPurchaseTypeLineLevel_Yes(driver, testCaseName);
	}

	public static boolean clickOnAllowEditingPurchaseTypeLineLevel_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowEditingPurchaseTypeLineLevel_No(driver, testCaseName);
	}

	public static boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowCostCenterOwnerWithOverlappingLimit_Yes(driver, testCaseName);
	}

	public static boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowCostCenterOwnerWithOverlappingLimit_No(driver, testCaseName);
	}

	public static boolean clickOnAllowProjectOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowProjectOwnerWithOverlappingLimit_Yes(driver, testCaseName);
	}

	public static boolean clickOnAllowProjectOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowProjectOwnerWithOverlappingLimit_No(driver, testCaseName);
	}

	public static boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowGLAccountOwnerWithOverlappingLimit_Yes(driver, testCaseName);
	}

	public static boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowGLAccountOwnerWithOverlappingLimit_No(driver, testCaseName);
	}

	public static boolean clickOnAllowMultipleCatagoryOwners_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowMultipleCatagoryOwners_Yes(driver, testCaseName);
	}

	public static boolean clickOnAllowMultipleCatagoryOwners_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnAllowMultipleCatagoryOwners_No(driver, testCaseName);
	}

	public static boolean clickOnPreventSupplierNotEntendedToOrderingLocation_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnPreventSupplierNotEntendedToOrderingLocation_Yes(driver, testCaseName);
	}

	public static boolean clickOnPreventSupplierNotEntendedToOrderingLocation_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataTenantLevelConfigSettings iPageMasterDataTenantLevelConfigSettings = FactoryPage.getInstanceOf(IPageMasterDataTenantLevelConfigSettingsImpl.class);
		return iPageMasterDataTenantLevelConfigSettings.clickOnPreventSupplierNotEntendedToOrderingLocation_No(driver, testCaseName);
	}

}
