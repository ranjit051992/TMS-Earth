/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.ceformlisting;

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
public class PageCEformListing
{
	static Logger logger = Logger.getLogger(PageCEformListing.class);

	public static void clickOnOnlineEditor(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnOnlineEditor(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOnlineEditor " + e, e);
		}
	}

	public static void clickOnFileUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnFileUpload(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFileUpload " + e, e);
		}
	}

	public static List<WebElement> getAllCEforms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			return eformListing.getAllCEforms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllCEforms " + e, e);
		}
		return null;
	}

	public static void clickOnDeactivateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnDeactivateCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeactivateCEform " + e, e);
		}
	}

	public static void clickOnDeleteCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnDeleteCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteCEform " + e, e);
		}
	}

	public static void clickOnCopyCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnCopyCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyCEform " + e, e);
		}
	}

	public static void clickOnModifyCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnModifyCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnModifyCEform " + e, e);
		}
	}

	public static void fillSearchCEform(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.fillSearchCEform(driver, testCaseName, cEformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchCEform " + e, e);
		}
	}

	public static void selectSearchInOptionForCEform(WebDriver driver, String testCaseName, int searchInOptionIndex) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.selectSearchInOptionForCEform(driver, testCaseName, searchInOptionIndex);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSearchInOptionForCEform " + e, e);
		}
	}

	public static String getStatusOfFirstCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			return eformListing.getStatusOfFirstCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfFirstCEform " + e, e);
		}
		return null;
	}

	/**
	 * @author Rohini Shinge
	 */
	public static boolean isFillSearchCEformPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			return eformListing.isFillSearchCEformPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfFirstCEform " + e, e);
		}
		return false;
	}

	/**
	 * @author Rohini Shinge
	 */
	public static void clickOnActivateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnActivateCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActivateCEform " + e, e);
		}
	}

	/**
	 * @author Rohini Shinge
	 */
	public static void clickOnUpdateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnUpdateCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateCEform " + e, e);
		}
	}

	/**
	 * @author Rohini Shinge
	 */

	public static void clickOnExportCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCEformListing eformListing = FactoryPage.getInstanceOf(IPageCEformListingImpl.class);
			eformListing.clickOnExportCEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExportCEform " + e, e);
		}
	}

}
