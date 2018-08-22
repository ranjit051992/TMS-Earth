package com.zycus.automation.eproc.pageobjects.pages.settings.taxratesmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageTaxRatesMasterDataSettings
{
	public static void clickOnAddTaxRate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnAddTaxRate(driver, testCaseName);
	}

	public static void clickOnDeleteTaxLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnDeleteTaxLink(driver, testCaseName);
	}

	public static void clickOnApplyThisTaxManuallyBtn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnApplyThisTaxManuallyBtn(driver, testCaseName);
	}

	public static void clickOnApplyThisAutomaticallyBtn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnApplyThisAutomaticallyBtn(driver, testCaseName);
	}

	public static void clickOnTaxEditLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnTaxEditLink(driver, testCaseName);
	}

	public static void clickOnDeleteTaxYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnDeleteTaxYes(driver, testCaseName);
	}

	public static void clickOnAddTaxRateBtn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnAddTaxRateBtn(driver, testCaseName);
	}

	public static void fillUniqueCode(WebDriver driver, String testCaseName, int Code) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.fillUniqueCode(driver, testCaseName, Code);
	}

	public static void fillTaxRate(WebDriver driver, String testCaseName, int Rate) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.fillTaxRate(driver, testCaseName, Rate);
	}

	public static String fillNameTaxRate(WebDriver driver, String testCaseName, String zycustax) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.fillNameTaxRate(driver, testCaseName, zycustax);

	}

	public static String SearchTax(WebDriver driver, String testCaseName, String searchTax) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.SearchTax(driver, testCaseName, searchTax);

	}

	public static String fillTaxType(WebDriver driver, String testCaseName, String zycustax) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.fillTaxType(driver, testCaseName);

	}

	public static String fillCountry(WebDriver driver, String testCaseName, String zycustax) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.fillCountry(driver, testCaseName);

	}

	public static int SelectCountry(WebDriver driver, String testCaseName, String zycustax, int index) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.SelectCountry(driver, testCaseName, index);

	}

	public static String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.getTaxName(driver, testCaseName);

	}

	public static String getTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException

	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.getTaxRate(driver, testCaseName, index);

	}

	public static boolean isCityFieldPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.isCityFieldPresent(driver, testCaseName);
	}

	public static boolean isCountyFieldPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.isCountyFieldPresent(driver, testCaseName);
	}

	public static boolean allowToEnterFreeTextCity(WebDriver driver, String testCaseName, String city) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.allowToEnterFreeTextCity(driver, testCaseName, city);
	}

	public static String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.selectOption(driver, testCaseName, option);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		iPageTaxRatesMasterDataSetings.clickOnGO(driver, testCaseName);
	}

	public static String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.enterCity(driver, testCaseName, city);
	}

	public static String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException, FactoryMethodException
	{
		IPageTaxRatesMasterDataSetings iPageTaxRatesMasterDataSetings = FactoryPage.getInstanceOf(IPageTaxRatesMasterDataSettingsImpl.class);
		return iPageTaxRatesMasterDataSetings.enterCounty(driver, testCaseName, county);
	}
}
