package com.zycus.automation.eproc.pageobjects.pages.po;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;

public class PagePO
{
	public static void clickOnAdd(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		iPagePO.clickOnAdd(driver, testCaseName);

	}

	public static void clickOnStandardPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		// clickOnAdd(driver, testCaseName);
		iPagePO.clickOnStandardPO(driver, testCaseName);

	}

	public static String enterPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		return iPagePO.enterPONumber(driver, testCaseName, poNumber);
	}

	public static void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		iPagePO.clickOnActions(driver, testCaseName);
	}

	public static void clickOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		iPagePO.clickOnPONumber(driver, testCaseName);
	}

	public static void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		iPagePO.clickOnViewAmmendedPO(driver, testCaseName);
	}

	public static boolean isViewAmmendedPOPrsent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		return iPagePO.isViewAmmendedPOPrsent(driver, testCaseName);
	}

	public static void clickOnBPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPagePO iPagePO = FactoryPage.getInstanceOfPagePO();
		iPagePO.clickOnBPO(driver, testCaseName);
	}

}
