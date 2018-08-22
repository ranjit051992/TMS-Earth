/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.returnfrompunchout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageReturnFromPunchout
{

	public static String getAddedPunchoutItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		return returnFromPunchout.getAddedPunchoutItemName(driver, testCaseName);
	}

	public static String getAddedPunchoutItemCategory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		return returnFromPunchout.getAddedPunchoutItemCategory(driver, testCaseName);
	}

	public static String getAddedPunchoutItemUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		return returnFromPunchout.getAddedPunchoutItemUnitPrice(driver, testCaseName);
	}

	public static int getAddedPunchoutItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		return returnFromPunchout.getAddedPunchoutItemQuantity(driver, testCaseName);
	}

	public static String getAddedPunchoutItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		return returnFromPunchout.getAddedPunchoutItemTotalPrice(driver, testCaseName);
	}

	public static void clickOnAddToCardAndCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		returnFromPunchout.clickOnAddToCardAndCheckoutButton(driver, testCaseName);
	}

	public static void clickOnAddToCardAndContinueShoppingButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		returnFromPunchout.clickOnAddToCardAndContinueShoppingButton(driver, testCaseName);
	}

	public static void clickOnDiscardAllItems(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReturnFromPunchout returnFromPunchout = FactoryPage.getInstanceOf(IPageReturnFromPunchoutImpl.class);
		returnFromPunchout.clickOnDiscardAllItems(driver, testCaseName);
	}

}
