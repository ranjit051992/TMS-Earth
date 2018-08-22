/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cdwpunchout;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCDWPunchout
{

	public static String fillSearchPunchoutItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.fillSearchPunchoutItem(driver, testCaseName, itemName);
	}

	public static void clickOnSearchButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.clickOnSearchButton(driver, testCaseName);
	}

	public static List<WebElement> getListOfSearchedProducts(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.getListOfSearchedProducts(driver, testCaseName);
	}

	public static int fillItemQuantity(WebDriver driver, String testCaseName, int quantity, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.fillItemQuantity(driver, testCaseName, quantity, itemName);
	}

	public static void clickOnAddToCartButton(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.clickOnAddToCartButton(driver, testCaseName, itemName);
	}

	public static void waitTillProgressiveDivAddItemToCartPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.waitTillProgressiveDivAddItemToCartPresent(driver, testCaseName);
	}

	public static int getQuantityOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.getQuantityOfAddedItem(driver, testCaseName);
	}

	public static String getUnitPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.getUnitPriceOfAddedItem(driver, testCaseName);
	}

	public static String getTotalPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.getTotalPriceOfAddedItem(driver, testCaseName);
	}

	public static void clickOnCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.clickOnCheckoutButton(driver, testCaseName);
	}

	public static void clickOnTransferSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.clickOnTransferSubmitButton(driver, testCaseName);
	}

	public static void fillItemCategory(WebDriver driver, String testCaseName, String itemCategory) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		cdwPunchout.fillItemCategory(driver, testCaseName, itemCategory);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get added punchout item name
	 */
	public static String getAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCDWPunchout cdwPunchout = FactoryPage.getInstanceOf(IPageCDWPunchoutImpl.class);
		return cdwPunchout.getAddedItemName(driver, testCaseName);
	}

}
