/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cataloglistingactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 * 
 */
public class ModalCatalogListingActions
{
	static Logger logger = Logger.getLogger(ModalCatalogListingActions.class);

	public static void clickOnUpdateScopeAndValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnUpdateScopeAndValidity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateScopeAndValidity " + e, e);
		}
	}

	public static void clickOnUpdateCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnUpdateCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateCatalog " + e, e);
		}
	}

	public static void clickOnDeactivateCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnDeactivateCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeactivateCatalog " + e, e);
		}
	}

	public static void clickOnExportCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnExportCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExportCatalog " + e, e);
		}
	}

	public static void clickOnViewCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnViewCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewCatalog " + e, e);
		}
	}

	public static void clickOnDeletCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnDeletCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeletCatalog " + e, e);
		}
	}

	public static void clickOnRecallCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnRecallCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallCatalog " + e, e);
		}
	}

	public static void clickOnCancelCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			catalogListingActions.clickOnCancelCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelCatalog " + e, e);
		}
	}

	public static boolean isUpdateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			return catalogListingActions.isUpdateCatalogPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isUpdateCatalogPresent " + e, e);
		}
		return false;
	}

	public static boolean isViewCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			return catalogListingActions.isViewCatalogPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isViewCatalogPresent " + e, e);
		}
		return false;
	}

	public static boolean isDeactivateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCatalogListingActions catalogListingActions = FactoryPage.getInstanceOf(IModalCatalogListingActionsImpl.class);
			return catalogListingActions.isDeactivateCatalogPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeactivateCatalogPresent " + e, e);
		}
		return false;
	}
}
