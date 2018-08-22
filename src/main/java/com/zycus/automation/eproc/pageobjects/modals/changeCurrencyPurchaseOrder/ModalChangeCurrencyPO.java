package com.zycus.automation.eproc.pageobjects.modals.changeCurrencyPurchaseOrder;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalChangeCurrencyPO
{
	public static void clickOnConvertAmountsToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalChangeCurrencyPO iModalChangeCurrencyPO = FactoryPage.getInstanceOf(IModalChangeCurrencyPOImpl.class);
		iModalChangeCurrencyPO.clickOnConvertAmountsToCurrencyType(driver, testCaseName);
	}

	public static void clickOnOnlyChangeCurrencyToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalChangeCurrencyPO iModalChangeCurrencyPO = FactoryPage.getInstanceOf(IModalChangeCurrencyPOImpl.class);
		iModalChangeCurrencyPO.clickOnOnlyChangeCurrencyToCurrencyType(driver, testCaseName);
	}

	public static void clickOnCancelChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalChangeCurrencyPO iModalChangeCurrencyPO = FactoryPage.getInstanceOf(IModalChangeCurrencyPOImpl.class);
		iModalChangeCurrencyPO.clickOnCancelChangeCurrency(driver, testCaseName);
	}
}
