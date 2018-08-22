/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.onlinestore;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.User;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

/**
 * @author puneet.sharma
 */
public class PageOnlineStore
{

	static Logger logger = Logger.getLogger(PageOnlineStore.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{

		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOf(IPageOnlineStoreImpl.class);
			return iPageOnlineStore.fillSearchText(driver, testCaseName, searchText);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchText " + e, e);
		}

		return null;
	}

	public static void clickSearchButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickSearchButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSearchButton " + e, e);
		}

	}

	public static void clickOnViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnViewCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewCart " + e, e);
		}

	}

	public static void clickOnCheckOut(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnCheckOut(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckOut " + e, e);
		}

	}

	public static String getCheckOutPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.getCheckOutPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCheckOutPrice " + e, e);
		}
		return null;
	}

	public static void clickOnLogOutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnLogOutButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLogOutButton " + e, e);
		}
	}

	public static String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.getTotalItemsInCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalItemsInCart " + e, e);
		}
		return null;
	}

	public static void hoverOverFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.hoverOverFirstCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method hoverOverFirstCategory " + e, e);
		}
	}

	public static String getTextOfFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.getTextOfFirstCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTextOfFirstCategory " + e, e);
		}
		return null;
	}

	public static String getTextOfFistSubCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.getTextOfFistSubCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTextOfFistSubCategory " + e, e);
		}
		return null;
	}

	public static void clickOnFirstSubCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnFirstSubCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstSubCategory " + e, e);
		}
	}

	public static void clickOnCDWPunchoutLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnCDWPunchoutLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCDWPunchoutLink " + e, e);
		}
	}

	public static void clickOnConfigurationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnConfigurationLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfigurationLink " + e, e);
		}
	}

	public static void clickOnGotItButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnGotItButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGotItButton " + e, e);
		}
	}

	public static String getSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
		return iPageOnlineStore.getSelectedCategory(driver, testCaseName);
	}

	public static String fetchTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.fetchTotalItemsInCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchTotalItemsInCart " + e, e);
		}
		return null;
	}

	public static void clickOnEmptyCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnEmptyCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEmptyCart " + e, e);
		}
	}

	public static void clickOnContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnContinueShopping(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnContinueShopping " + e, e);
		}
	}

	public static void clickOnNoCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnNoCartContinueShopping(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNoCartContinueShopping " + e, e);
		}
	}

	public static void clickOnYesdeleteCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnYesdeleteCartContinueShopping(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNoCartContinueShopping " + e, e);
		}
	}

	public static void clickOnGuidedProcurementLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGuidedProcurementLink " + e, e);
		}
	}

	public static boolean isGuidedProcurementLinkVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.isGuidedProcurementLinkVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGuidedProcurementLink " + e, e);
			return false;
		}
	}

	public static void updateItemQtyInCart(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.updateItemQtyInCart(driver, testCaseName, index, qty);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method updateItemQtyInCart " + e, e);
		}
	}

	public static void clickUpdateItemQtyInCart(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickUpdateItemQtyInCart(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickUpdateItemQtyInCart " + e, e);
		}
	}

	public static void fillAutoCompleteSearchField(WebDriver driver, UI_Elements uiElements, String value) throws ActionBotException
	{
		WebElement element = null;
		try
		{
			element = ActionBot.findElement(driver, uiElements);
			element.clear();
			element.sendKeys(value);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();
			ActionBot.waitForElementToBePresent1(driver,
				By.xpath(".//*[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'][contains(@style,'display: block')]/li"));
			// waitForElementToBePresent(driver,
			// By.xpath(".//li[contains(@class,'ui-menu-item')]"));
			// waitForPageLoad(driver);
			// ActionBot.defaultSleep();
			// ActionBot.defaultMediumSleep();
			// ActionBot.defaultHighSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ARROW_DOWN);
			// ActionBot.defaultSleep();

			// ActionBot.defaultSleep();
			element.sendKeys(Keys.ENTER);

			// Thread.sleep(1000);

			/*
			 * List<WebElement> elements = ActionBot.findElements(driver,
			 * By.xpath(".//li[contains(@class,'ui-menu-item')]")); for
			 * (WebElement element2 : elements) { if
			 * (element2.getText().contains(value)) { element2.click(); break; }
			 * }
			 */
		}
		catch (Exception e)
		{
		}
	}

	public static void clickItemInCartindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickItemInCartindexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemInCartindexwise " + e, e);
		}
	}

	public static void clickRequirementDetailsTabInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickRequirementDetailsTabInItemDetailsPopupInViewCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickRequirementDetailsTabInItemDetailsPopupInViewCart " + e, e);
		}
	}

	public static boolean verifyEformFieldInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.verifyEformFieldInItemDetailsPopupInViewCart(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyEformFieldInItemDetailsPopupInViewCart " + e, e);
			return false;
		}
	}

	public static void clickOnOkButtonForBandwidthCheck(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageOnlineStore iPageOnlineStore;
		try
		{
			iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnOkButtonForBandwidthCheck(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOkButtonForBandwidthCheck " + e, e);
		}
	}

	public static void clickOnCancelCNSNotification(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageOnlineStore iPageOnlineStore;
		try
		{
			iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			iPageOnlineStore.clickOnCancelCNSNotification(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelCNSNotification " + e, e);
		}

	}

	public static void switchToClassicView(WebDriver driver, TestCase testCase, User user) throws ActionBotException
	{
		{
			IPageOnlineStore iPageOnlineStore;
			try
			{
				iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
				iPageOnlineStore.switchToClassicView(driver, testCase, user);
			}
			catch (FactoryMethodException e)
			{
				logger.error("Factory Method Exception in method switchToClassicView " + e, e);
			}
		}
	}

	public static boolean isRelatedCategoryDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		{
			IPageOnlineStore iPageOnlineStore;
			try
			{
				iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
				return iPageOnlineStore.isRelatedCategoryDisplayed(driver, testCaseName);
			}
			catch (FactoryMethodException e)
			{
				logger.error("Factory Method Exception in method isRelatedCategoryDisplayed " + e, e);
			}
		}
		return false;
	}

	public static boolean clickOnGuidedProcurementViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.clickOnGuidedProcurementViewAllButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyEformFieldInItemDetailsPopupInViewCart " + e, e);
			return false;
		}
	}

	public static boolean clickOnFirstEformUnderGuidedProcurementPopupViaViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageOnlineStore iPageOnlineStore = FactoryPage.getInstanceOfIPageOnlineStore();
			return iPageOnlineStore.clickOnFirstEformUnderGuidedProcurementPopupViaViewAllButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstEformUnderGuidedProcurementPopupViaViewAllButton " + e, e);
			return false;
		}
	}

}
