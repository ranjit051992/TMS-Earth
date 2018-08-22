/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createcatalog;

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
public class PageCreateCatalog
{
	static Logger logger = Logger.getLogger(PageCreateCatalog.class);

	public static String fillCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.fillCatalogName(driver, testCaseName, catalogName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCatalogName " + e, e);
		}
		return null;
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.fillSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierName " + e, e);
		}
		return null;
	}

	public static String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.selectFirstSupplierAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFirstSupplierAddress " + e, e);
		}
		return null;
	}

	public static void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnNextButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNextButton " + e, e);
		}
	}

	public static void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnAddItemButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddItemButton " + e, e);
		}
	}

	public static void clickOnNextLinkScopeValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNextLinkScopeValidityButton " + e, e);
		}
	}

	public static void clickOnSelectOrganizationUnitLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnSelectOrganizationUnitLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectOrganizationUnitLink " + e, e);
		}
	}

	public static void clickOnSubmitCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitCatalogButton " + e, e);
		}
	}

	public static void clickOnDiscardCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnDiscardCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDiscardCatalogButton " + e, e);
		}
	}

	public static void clickOnCloseCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnCloseCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseCatalogButton " + e, e);
		}
	}

	public static void clickOnEditFirstCatalogItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditFirstCatalogItem " + e, e);
		}
	}

	public static List<WebElement> getListOfItemsInCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getListOfItemsInCatalog(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemsInCatalog " + e, e);
		}
		return null;
	}

	public static String getItemCatagory(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getItemCatagory(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCatagory " + e, e);
		}
		return null;
	}

	public static String getItemSupplier(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getItemSupplier(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplier " + e, e);
		}
		return null;
	}

	public static String getItemCurrency(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getItemCurrency(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCurrency " + e, e);
		}
		return null;
	}

	public static double getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getItemUnitPrice(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUnitPrice " + e, e);
		}
		return 0;
	}

	public static String getItemSupplierPartId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.getItemSupplierPartId(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplierPartId " + e, e);
		}
		return null;
	}

	public static void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnUploadItemsViaFileButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUploadItemsViaFileButton " + e, e);
		}
	}

	public static void clickOnSelectCatalogScopeLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			createCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectCatalogScopeLink " + e, e);
		}
	}

	public static boolean isSelectCatalogScopeLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isSelectCatalogScopeLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSelectCatalogScopeLinkPresent " + e, e);
		}
		return false;
	}

	public static String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.fillContractNumber(driver, testCaseName, contractNumber);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillContractNumber " + e, e);
		}
		return null;
	}

	public static String selectFromValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.selectFromValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFromValidityDate " + e, e);
		}
		return null;
	}

	public static String selectToValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.selectToValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectToValidityDate " + e, e);
		}
		return null;
	}

	public static boolean isScopeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isScopeEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isScopeEditable " + e, e);
		}
		return false;
	}

	public static boolean isFromValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isFromValidityDateEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFromValidityDateEditable " + e, e);
		}
		return false;
	}

	public static boolean isToValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isToValidityDateEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillContractNumber " + e, e);
		}
		return false;
	}

	public static boolean isScopePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isScopePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isScopePresent " + e, e);
		}
		return false;
	}

	public static boolean isScopeMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isScopeMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isScopeMandatory " + e, e);
		}
		return false;
	}

	public static boolean isFromValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isFromValidityPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFromValidityPresent " + e, e);
		}
		return false;
	}

	public static boolean isToValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isToValidityPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isToValidityPresent " + e, e);
		}
		return false;
	}

	public static boolean isCatalogPresentAfterSearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCatalog createCatalog = FactoryPage.getInstanceOf(IPageCreateCatalogImpl.class);
			return createCatalog.isCatalogPresentAfterSearch(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCatalogPresentAfterSearch " + e, e);
		}
		return false;
	}
}
