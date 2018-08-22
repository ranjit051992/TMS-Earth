/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.bpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageBPO extends PageStandardPO
{
	Logger logger = Logger.getLogger(PageBPO.class);

	public static String fillOrderValue(WebDriver driver, String testCaseName, String orderValue) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.fillOrderValue(driver, testCaseName, orderValue);
	}

	public static boolean clickOnAutoUpdate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.clickOnAutoUpdate(driver, testCaseName);
	}

	public static boolean isFromValiditydateDisplayedAslabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.isFromValiditydateDisplayedAslabel(driver, testCaseName);
	}

	public static void clickOnDatePickerOfFromValidity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnDatePickerOfFromValidity(driver, testCaseName);
	}

	public static void clickOnDatePickerOfToValidity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnDatePickerOfToValidity(driver, testCaseName);
	}

	public static void clickOnDatePickerOfUntilValidity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnDatePickerOfUntilValidity(driver, testCaseName);
	}

	public static String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.getFromValidityDate(driver, testCaseName);
	}

	public static String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.getToValidityDate(driver, testCaseName);
	}

	public static String getUntilValidityDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.getUntilValidityDate(driver, testCaseName);
	}

	public static void clickOnPreventItemsOfOtherCategoryToBeOdredred(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventItemsOfOtherCategoryToBeOdredred(driver, testCaseName);
	}

	public static void clickOnPreventChangingPartNoAndItemDescription(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventChangingPartNoAndItemDescription(driver, testCaseName);
	}

	public static void clickOnPreventExceedingBPOValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventExceedingBPOValue(driver, testCaseName);
	}

	public static void clickOnRequireReceiptAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnRequireReceiptAgainstPO(driver, testCaseName);
	}

	public static void clickOnPreventExceedingTheBlanketOrderCheckBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventExceedingTheBlanketOrderCheckBox(driver, testCaseName);
	}

	public static void clickOnPreventChangingPartNoCheckBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventChangingPartNoCheckBox(driver, testCaseName);
	}

	public static void clickOnPreventItemsOfOtherCatagories(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnPreventItemsOfOtherCatagories(driver, testCaseName);
	}

	public static String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.getOrderValue(driver, testCaseName);
	}

	public static String selectFromValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.selectFromValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static String selectToValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.selectToValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static String selectUntilValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.selectUntilValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static void clickOnRollBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnRollBackButton(driver, testCaseName);
	}

	public static void clickOnEditItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnEditItem(driver, testCaseName, itemName);
	}

	public static void clickOnFirstItemCopyLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnFirstItemCopyLink(driver, testCaseName);
	}

	public static String getTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		return pageBPO.getTotalAmount(driver, testCaseName);
	}

	public static void clickOnOrderTypeRelease(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnOrderTypeRelease(driver, testCaseName);
	}

	public static void clickOnOrderTypeDirectInvoicing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnOrderTypeDirectInvoicing(driver, testCaseName);
	}

	public static void clickOnAlertPopUpTaxesIfDefinedOkButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBPO pageBPO = FactoryPage.getInstanceOf(IPageBPOImpl.class);
		pageBPO.clickOnAlertPopUpTaxesIfDefinedOkButton(driver, testCaseName);
	}
}
