/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.peformlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PagePEformListing
{
	static Logger logger = Logger.getLogger(PagePEformListing.class);

	public static List<WebElement> getListOfPEformNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			return pEformListing.getListOfPEformNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfPEformNames " + e, e);
		}
		return null;
	}

	public static void clickOnDeactivatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnDeactivatePEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeactivatePEformLink " + e, e);
		}
	}

	public static void clickOnDeletePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnDeletePEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeletePEformLink " + e, e);
		}
	}

	public static void clickOnModifyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnModifyPEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnModifyPEformLink " + e, e);
		}
	}

	public static void clickOnUpdatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnUpdatePEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdatePEformLink " + e, e);
		}
	}

	public static void clickOnCopyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnCopyPEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyPEformLink " + e, e);
		}
	}

	public static void clickOnExportPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			pEformListing.clickOnExportPEformLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExportPEformLink " + e, e);
		}
	}

	public static String fillSearchPEform(WebDriver driver, String testCaseName, String pEformName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			return pEformListing.fillSearchPEform(driver, testCaseName, pEformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchPEform " + e, e);
		}
		return null;
	}

	public static String getStatusOFFirstPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePEformListing pEformListing = FactoryPage.getInstanceOf(IPagePEformListingImpl.class);
			return pEformListing.getStatusOFFirstPEForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOFFirstPEForm " + e, e);
		}
		return null;
	}
}
