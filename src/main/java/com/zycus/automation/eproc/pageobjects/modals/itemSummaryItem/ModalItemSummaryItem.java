package com.zycus.automation.eproc.pageobjects.modals.itemSummaryItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemSummaryItem
{
	public static Integer clearAndEnterQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.clearAndEnterQuantity(driver, testCaseName, quantity);
	}

	public static String getModalItemContractNo(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.getModalItemContractNo(driver);
	}

	public static void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		iModalItemSummaryItem.clickOnItemDetailsTab(driver, testCaseName);
	}

	public static String fillModalItemContractNo(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.fillModalItemContractNo(driver, testCaseName, contractNo);
	}

	public static String getModalItemCurrencylabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.getModalItemCurrencylabel(driver);
	}

	public static int getQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.getQuantity(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to enter the market price
	 */
	public static float clearAndEnterMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.clearAndEnterMarketPrice(driver, testCaseName, marketPrice);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get market price
	 */
	public static float getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryItem iModalItemSummaryItem = FactoryPage.getInstanceOf(IModalItemSummaryItemImpl.class);
		return iModalItemSummaryItem.getMarketPrice(driver, testCaseName);
	}
}
