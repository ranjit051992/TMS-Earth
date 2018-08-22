/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cataloglisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCatalogListing
{
	static Logger logger = Logger.getLogger(PageCatalogListing.class);

	public static void clickOnAddCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			catalogListing.clickOnAddCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddCatalogButton " + e, e);
		}
	}

	public static String fillSearchCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			return catalogListing.fillSearchCatalogName(driver, testCaseName, catalogName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchCatalogName " + e, e);
		}
		return null;
	}

	public static String getFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			return catalogListing.getFirstCatalogName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstCatalogName " + e, e);
		}
		return null;
	}

	public static void clickOnCatalogActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			catalogListing.clickOnCatalogActions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCatalogActions " + e, e);
		}
	}

	public static String getStatusOfFirstCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			return catalogListing.getStatusOfFirstCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfFirstCatalog " + e, e);
		}
		return null;
	}

	public static void clickOnFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			catalogListing.clickOnFirstCatalogName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstCatalogName " + e, e);
		}
	}

	public static void clickOnSearchCatalogClearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogListing catalogListing = FactoryPage.getInstanceOf(IPageCatalogListingImpl.class);
			catalogListing.clickOnSearchCatalogClearFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSearchCatalogClearFilter " + e, e);
		}
	}

}
