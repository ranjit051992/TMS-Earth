package com.zycus.automation.requisitionparser.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.Parser;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework.WaitUtil;

public class Utility
{

	public static void loginPage(WebDriver driver, Parser parser, Map<String, By> loginMap, String configUsername, String configPassword) throws Exception
	{

		try
		{
			WaitUtil.getElementUsingFluentWait(driver, parser.getBy(loginMap, "login_email_temp"));
			WaitUtil.waitForElementVisible(driver, parser.getBy(loginMap, "login_email_temp"), 30);
			WaitUtil.getElementUsingFluentWait(driver, parser.getBy(loginMap, "login_email"));
			WaitUtil.getElementUsingFluentWait(driver, parser.getBy(loginMap, "login_password_temp"));
			WaitUtil.getElementUsingFluentWait(driver, parser.getBy(loginMap, "login_password"));

			driver.findElement(parser.getBy(loginMap, "login_email_temp")).clear();
			driver.findElement(parser.getBy(loginMap, "login_email")).clear();
			driver.findElement(parser.getBy(loginMap, "login_email")).sendKeys(new CharSequence[] { configUsername });
			driver.findElement(parser.getBy(loginMap, "login_password_temp")).clear();
			driver.findElement(parser.getBy(loginMap, "login_password")).clear();
			driver.findElement(parser.getBy(loginMap, "login_password")).sendKeys(new CharSequence[] { configPassword });

			WaitUtil.waitForElementClickable(driver, parser.getBy(loginMap, "login_button"), 30);
			WaitUtil.waitForElementClickable(driver, parser.getBy(loginMap, "login_button"), 30).click();
		}
		catch (Exception e)
		{
			throw e;
		}

	}

	public static void clickOnSetupTab(String fileName, WebDriver driver, Parser parser, Map<String, By> searchCatalogMap) throws Exception
	{
		CommonUtil.parseHTMLContent(fileName, driver, parser);
		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "SETUP"), 30).click();
	}

	public static void openCustomizedSettingsPage(String fileName, WebDriver driver, Parser parser, Map<String, By> setupPageMap) throws Exception
	{
		CommonUtil.parseHTMLContent(fileName, driver, parser);
		WaitUtil.waitForElementClickable(driver, parser.getBy(setupPageMap, "CUSTOMIZE"), 30).click();
	}

	public static void openReqSettingLink(String fileName, WebDriver driver, Parser parser, Map<String, By> customizedSettingsMap) throws Exception
	{
		CommonUtil.parseHTMLContent(fileName, driver, parser);
		WaitUtil.waitForElementClickable(driver, parser.getBy(customizedSettingsMap, "REQUISITION_LINK"), 30).click();
	}

	public static void searchCatalogPage(String fileName, WebDriver driver, Parser parser, Map<String, By> searchCatalogMap) throws Exception
	{
		CommonUtil.parseHTMLContent(fileName, driver, parser);
		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "LABEL_ITEM_IN_CART"), 30).click();

		CommonUtil.parseElementsNotFoundOnPage(fileName, driver, parser);

		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "X_CLOSE_SHOPPING_CART"), 30).click();
		ActionBot.defaultSleep();

		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "TEXTBOX_ENTER_SEARCH_NAME"), 30).click();
		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "TEXTBOX_ENTER_SEARCH_NAME"), 30).sendKeys("cleaning");
		WaitUtil.waitForElementClickable(driver, parser.getBy(searchCatalogMap, "BUTTON_SEARCH_BUTTON"), 30).click();
	}

	public static void searchListingPage(String fileName, WebDriver driver, Parser parser, Map<String, By> searchListingMap) throws Exception
	{
		CommonUtil.parseHTMLContent(fileName, driver, parser);
		/*
		 * WaitUtil.waitForElementClickable(driver,
		 * parser.getBy(searchListingMap, "addToCartButton"), 30).click();
		 * 
		 * WaitUtil.waitForElementClickable(driver,
		 * parser.getBy(searchListingMap, "clickOnCart"), 30).click();
		 * 
		 * CommonUtil.parseElementsNotFoundOnPage(fileName, driver, parser);
		 * 
		 * WaitUtil.waitForElementClickable(driver,
		 * parser.getBy(searchListingMap, "closeViewCart"), 30).click();
		 * ActionBot.defaultSleep();
		 * 
		 * WaitUtil.waitForElementClickable(driver,
		 * parser.getBy(searchListingMap, "gridView"), 30).click();
		 */

		CommonUtil.parseElementsNotFoundOnPage(fileName, driver, parser);

		WaitUtil.waitForElementClickable(driver, parser.getBy(searchListingMap, "GUIDE_ME_EXPAND"), 30).click();

		WaitUtil.waitForElementClickable(driver, parser.getBy(searchListingMap, "BUTTON_GUIDED_PROCUREMENT"), 30).click();

	}

	public static void addGuidedItem(String fileName, WebDriver driver, Parser parser, Map<String, By> guidedItemMap) throws Exception
	{
		WebElement element;

		CommonUtil.parseHTMLContent(fileName, driver, parser);

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "SHORT_DESCRIPTION"), 30).sendKeys(Helper.getRandomAlphaNumeric(5));

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "QUANTITY"), 30).sendKeys(Helper.getRandomNumber(2));

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "SOURCING_STATUS_QUOTEDBYSUPPLIER"), 30).click();

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "PRICE"), 30).sendKeys(Helper.getRandomNumber(3));

		// change category
		if (driver.findElements(parser.getBy(guidedItemMap, "SELECT_CATEGORY")).size() != 0)
		{
			ActionBot.click(driver, parser.getBy(guidedItemMap, "SELECT_CATEGORY"));

			// ActionBot.click(driver, searchCategory);
			WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "SELECT_CATEGORY_FIELD"), 30);
			element = WaitUtil.getElementUsingFluentWait(driver, parser.getBy(guidedItemMap, "SELECT_CATEGORY_FIELD"));
			element.click();
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);

			ActionBot.defaultSleep();

			// select from the loaded suggestions
			// WaitUtil.waitForElementClickable(driver,
			// parser.getBy(guidedItemMap, "categorySuggestions"), 30);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);

			// for waiting in firefox

			ActionBot.defaultSleep();

			element = driver.findElement(By.xpath(".//*"));
			String htmlContent = element.getAttribute("outerHTML");
			parser.parseHtmlContent(fileName, htmlContent);

			Thread.sleep(2000);

			if (driver.findElement(parser.getBy(guidedItemMap, "SELECT_EFORM")) != null)
			{
				ActionBot.click(driver, parser.getBy(guidedItemMap, "CANCEL_BTN"));
			}
			else
			{
				ActionBot.click(driver, parser.getBy(guidedItemMap, "CANCEL_BTN"));
				// ActionBot.click(driver, parser.getBy(guidedItemMap,
				// "changeCategoryYes"));
			}
		}

		Thread.sleep(2000);
		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "SUPPLIER_NAME_IN_SUPPLIER_INFO"), 30).sendKeys("Ebay Office");

		Thread.sleep(1000);
		// WaitUtil.waitForElementClickable(driver,
		// By.partialLinkText("QUALITY"), 30).click();

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "ADD_TO_CART_BUTTON"), 30).click();

		WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "CHECKOUT_BTN"), 30).click();

	}

}
