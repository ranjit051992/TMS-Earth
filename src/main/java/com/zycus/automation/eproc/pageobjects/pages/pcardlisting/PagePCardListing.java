/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.pcardlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PagePCardListing
{
	static Logger logger = Logger.getLogger(PagePCardListing.class);

	public static void clickOnAddPCardButtton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		pCardListing.clickOnAddPCardButtton(driver, testCaseName);
	}

	public static void clickOnStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		pCardListing.clickOnStatusFilterLink(driver, testCaseName);
	}

	public static void clickOnClearStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		pCardListing.clickOnClearStatusFilterLink(driver, testCaseName);
	}

	public static void clickOnPCardActionsOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		pCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
	}

	public static String fillPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.fillPCardType(driver, testCaseName, pCardType);
	}

	public static String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.fillPCardNo(driver, testCaseName, pCardNo);
	}

	public static String getStatusOfPCard(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.getStatusOfPCard(driver, testCaseName);
	}

	public static String getPCardTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.getPCardTypeOfFirstRow(driver, testCaseName);
	}

	public static String getPCardNoOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.getPCardNoOfFirstRow(driver, testCaseName);
	}

	public static boolean isActionLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.isActionLinkEnable(driver, testCaseName);
	}

	public static boolean isEditLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.isEditLinkEnable(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to check action button present or not
	 */
	public static boolean isActionButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.isActionButtonDisplayed(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to check action button present or not
	 */
	public static String getIssueToOfPCard(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePCardListing pCardListing = FactoryPage.getInstanceOf(IPagePCardListingImpl.class);
		return pCardListing.getIssueToOfPCard(driver, testCaseName);
	}
}
