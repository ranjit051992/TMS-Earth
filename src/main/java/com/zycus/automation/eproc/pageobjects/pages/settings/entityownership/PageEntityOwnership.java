/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.entityownership;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageEntityOwnership
{

	public static String fillCurrentOwnerName(WebDriver driver, String testCaseName, String currentOwnerName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		return entityOwnership.fillCurrentOwnerName(driver, testCaseName, currentOwnerName);
	}

	public static String fillNewOwnerName(WebDriver driver, String testCaseName, String newOwnerName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		return entityOwnership.fillNewOwnerName(driver, testCaseName, newOwnerName);
	}

	public static void clickOnRequisitionCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		entityOwnership.clickOnRequisitionCheckbox(driver, testCaseName);
	}

	public static void clickOnStartChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		entityOwnership.clickOnStartChangeOwnerButton(driver, testCaseName);
	}

	public static void clickOnResetChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		entityOwnership.clickOnResetChangeOwnerButton(driver, testCaseName);
	}

	public static String fillSearchOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		return entityOwnership.fillSearchOwnerName(driver, testCaseName, ownerName);
	}

	public static String selectSearchOwnerIn(WebDriver driver, String testCaseName, String searchOwnerIn) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		return entityOwnership.selectSearchOwnerIn(driver, testCaseName, searchOwnerIn);
	}

	public static void clickOnSearchGo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		entityOwnership.clickOnSearchGo(driver, testCaseName);
	}

	public static void clickOnChangeOwner(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IPageEntityOwnershipImpl.class);
		entityOwnership.clickOnChangeOwner(driver, testCaseName);
	}

}
