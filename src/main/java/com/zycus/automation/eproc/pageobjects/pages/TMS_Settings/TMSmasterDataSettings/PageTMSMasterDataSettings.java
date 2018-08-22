package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSmasterDataSettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageTMSMasterDataSettings
{
	static UI_Elements	LINK_PAYMENT_TERMS_TMS	= UIFactory.getElements("LINK_PAYMENT_TERMS_TMS");
	static UI_Elements	LINK_PROJECTS_TMS		= UIFactory.getElements("LINK_PROJECTS_TMS");
	static UI_Elements	LINK_COMPANY_TMS		= UIFactory.getElements("LINK_COMPANY_TMS");
	static UI_Elements	LINK_BUSINESS_UNIT		= UIFactory.getElements("LINK_BUSINESS_UNIT");
	static UI_Elements	LINK_LOCATIONS			= UIFactory.getElements("LINK_LOCATIONS");
	static UI_Elements	LINK_COSTCENTERS		= UIFactory.getElements("LINK_COSTCENTERS");
	static UI_Elements	WAREHOUSE_LINK			= UIFactory.getElements("WAREHOUSE_LINK");
	static UI_Elements	UNITS_OF_MEASURE_LINK	= UIFactory.getElements("UNITS_OF_MEASURE_LINK");

	public static void clickOnPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on payment terms");
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_PAYMENT_TERMS_TMS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on payment terms");
	}

	public static void clickOnLinkProjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PROJECTS_TMS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link projects");
	}

	public static void clickOnLinkCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COMPANY_TMS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link company");
	}

	public static void clickOnLinkBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BUSINESS_UNIT);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link business unit");
	}

	public static void clickOnLinkLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_LOCATIONS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link locations");
	}

	public static void clickOnLinkCostCenters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COSTCENTERS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link cost centers");
	}

	public static void clickOnLinkWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, WAREHOUSE_LINK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link warehouses");
	}

	public static void clickOnUom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UNITS_OF_MEASURE_LINK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on units of measure link");
	}
}
