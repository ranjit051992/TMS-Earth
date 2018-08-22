/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.catalogview;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCatalogView
{
	static Logger logger = Logger.getLogger(PageCatalogView.class);

	public static String getCatalogValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.getCatalogValidity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCatalogValidity " + e, e);
		}
		return null;
	}

	public static String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.getSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierName " + e, e);
		}
		return null;
	}

	public static List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.getItemNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemNames " + e, e);
		}
		return null;
	}

	public static List<String> getOUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.getOUs(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getOUs " + e, e);
		}
		return null;
	}

	public static void clickOnItemActionsLink(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.clickOnItemActionsLink(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemActionsLink " + e, e);
		}
	}

	public static void clickOnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.clickOnHideItemLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHideItemLink " + e, e);
		}
	}

	public static void clickOnUnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.clickOnUnHideItemLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUnHideItemLink " + e, e);
		}
	}

	public static boolean isItemHiddenStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.isItemHiddenStatusIconPresent(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemHideStatusIconPresent " + e, e);
		}
		return false;
	}

	public static boolean isItemUnHideStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.isItemUnHideStatusIconPresent(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemUnHideStatusIconPresent " + e, e);
		}
		return false;
	}

	public static void waitTillSuccessMsgPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.waitTillSuccessMsgPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillSuccessMsgPresent " + e, e);
		}
	}

	public static void clickOnSubmitForApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.clickOnSubmitForApprovalButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitForApprovalButton " + e, e);
		}
	}

	public static boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.isSubmitForApprovalButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSubmitForApprovalButtonPresent " + e, e);
		}
		return false;
	}

	public static void clickOnAuditTrailTabLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			catalogView.clickOnAuditTrailTabLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAuditTrailTabLink " + e, e);
		}
	}

	public static boolean isAuditTrailTablePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageCatalogView catalogView = FactoryPage.getInstanceOf(IPageCatalogViewImpl.class);
			return catalogView.isAuditTrailTablePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAuditTrailTablePresent " + e, e);
		}
		return false;
	}
}
