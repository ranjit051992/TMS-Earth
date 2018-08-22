/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cataloglisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCatalogListingImpl implements IPageCatalogListing
{
	static Logger logger = Logger.getLogger(IPageCatalogListingImpl.class);

	@Override
	public void clickOnAddCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add catalog button");
	}

	@Override
	public String fillSearchCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_CATALOG_NAME, catalogName);
		String catalog_name = ActionBot.findElement(driver, TEXTBOX_SEARCH_CATALOG_NAME).getAttribute("value");
		logger.info("Catalog Name : " + catalog_name);
		ActionBot.findElement(driver, TEXTBOX_SEARCH_CATALOG_NAME).sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After entering catalog name");
		return catalog_name;
	}

	@Override
	public String getFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String catalogName = ActionBot.findElements(driver, FIRST_CATALOG_NAME).get(0).getText();
		logger.info("First Catalog Name : " + catalogName);
		return catalogName;
	}

	@Override
	public void clickOnCatalogActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CATALOG_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on catalog actions");
	}

	@Override
	public String getStatusOfFirstCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_FIRST_CATALOG);
		logger.info("Status of first catalog : " + status);
		return status;
	}

	@Override
	public void clickOnFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_CATALOG_NAME);
		ActionBot.waitForPageLoad(driver);
	}

	/*
	 * t.amarnath
	 */
	@Override
	public void clickOnSearchCatalogClearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_SEARCH_FILTER);
	}

}
