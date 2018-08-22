package com.zycus.automation.eproc.pageobjects.modals.discountstandardpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalDiscountPO
{
	public static Integer fillDiscountAmount(WebDriver driver, String testCaseName, int total) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.fillDiscountAmount(driver, testCaseName, total);
	}

	public static void clickOnSaveDiscount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
	}

	public static Integer getDiscountedPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.getDiscountedPrice(driver, testCaseName);
	}

	public static boolean isDiscountedPriceEqualToDiscountedAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isDiscountedPriceEqualToDiscountedAmount(driver, testCaseName);
	}

	public static boolean isTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(driver, testCaseName);
	}

	public static boolean isItemLevelTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isItemLevelTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(driver, testCaseName);
	}

	public static void clickOnItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
	}

	public static void clickOnDiscountModalCancelLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnDiscountModalCancelLink(driver, testCaseName);
	}

	public static String selectItemLevelDiscountType(WebDriver driver, String testCaseName, String type) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type);
	}

	public static Integer enterItemLevelDiscountValue(WebDriver driver, String testCaseName, int value) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value);
	}

	public static void clickOnItemLevelTotalDiscount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
	}

	public static Double getItemLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
	}

	public static Double getHeaderLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.getHeaderLevelTotalDiscountAmount(driver, testCaseName);
	}

	public static String getTotalPoAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.getTotalPoAmount(driver, testCaseName);
	}

	public static boolean isAlertInDiscountPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isAlertInDiscountPresent(driver, testCaseName);
	}

	public static boolean isHeaderLevelDiscountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isHeaderLevelDiscountErrorPresent(driver, testCaseName);
	}

	public static boolean isHeaderLevelDiscountErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isHeaderLevelDiscountErrorMessageDisplayed(driver, testCaseName);
	}

	public static boolean isItemLevelErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isItemLevelErrorPresent(driver, testCaseName);
	}

	public static boolean isApplyToAllErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isApplyToAllErrorPresent(driver, testCaseName);
	}

	public static Integer fillApplyToAllDiscount(WebDriver driver, String testCaseName, int discount) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.fillApplyToAllDiscount(driver, testCaseName, discount);
	}

	public static void clickOnApplyToAll(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnApplyToAll(driver, testCaseName);
	}

	public static void clickOnDiscountOnEntireOrder(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.clickOnDiscountOnEntireOrder(driver, testCaseName);
	}

	public static boolean isAlertOfHeaderLevelDiscountNotAllowedPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.isAlertOfHeaderLevelDiscountNotAllowedPresent(driver, testCaseName);
	}

	public static String selectItemLevelDiscountIndexwise(WebDriver driver, String testCaseName, int index, String discountType) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		return iModalDiscountPO.selectItemLevelDiscountIndexwise(driver, testCaseName, index, discountType);
	}

	public static void fillItemLevelDiscountValueIndexwise(WebDriver driver, String testCaseName, int index, int discountValue) throws ActionBotException, FactoryMethodException
	{
		IModalDiscountPO iModalDiscountPO = FactoryPage.getInstanceOf(IModalDiscountPOImpl.class);
		iModalDiscountPO.fillItemLevelDiscountValueIndexwise(driver, testCaseName, index, discountValue);
	}
}
