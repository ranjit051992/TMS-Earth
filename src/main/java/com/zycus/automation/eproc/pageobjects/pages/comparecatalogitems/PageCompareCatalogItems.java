/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.comparecatalogitems;

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
public class PageCompareCatalogItems
{
	static Logger logger = Logger.getLogger(PageCompareCatalogItems.class);

	public static List<WebElement> getListOfItemsCompared(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getListOfItemsCompared(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemsCompared " + e, e);
		}
		return null;
	}

	public static String getComparedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemName " + e, e);
		}
		return null;
	}

	public static String getComparedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemUnitPrice " + e, e);
		}
		return null;
	}

	public static String getComparedItemAvailability(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemAvailability(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemAvailability " + e, e);
		}
		return null;
	}

	public static String getComparedItemSupplierName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemSupplierName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemSupplierName " + e, e);
		}
		return null;
	}

	public static String getComparedItemSupplierPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemSupplierPartId(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemSupplierPartId " + e, e);
		}
		return null;
	}

	public static String getComparedItemMarketPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemMarketPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemMarketPrice " + e, e);
		}
		return null;
	}

	public static String getComparedItemManufacturerName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemManufacturerName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemManufacturerName " + e, e);
		}
		return null;
	}

	public static String getComparedItemManufacturerPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemManufacturerPartId(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemManufacturerPartId " + e, e);
		}
		return null;
	}

	public static String getComparedItemDescription(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemDescription(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemDescription " + e, e);
		}
		return null;
	}

	public static String getComparedItemSpecKey(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemSpecKey(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemSpecKey " + e, e);
		}
		return null;
	}

	public static String getComparedItemSpecValue(WebDriver driver, String testCaseName, int columnIndex, int valueIndex) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemSpecValue(driver, testCaseName, columnIndex, valueIndex);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemSpecValue " + e, e);
		}
		return null;
	}

	public static String getComparedItemAttachment(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemAttachment(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemAttachment " + e, e);
		}
		return null;
	}

	public static List<String> getComparedItemAttachments(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getComparedItemAttachments(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getComparedItemAttachments " + e, e);
		}
		return null;
	}

	public static int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.fillQuantity(driver, testCaseName, itemId, quantity, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
		return 0;
	}

	public static int getQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			return compareCatalogItems.getQuantity(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantity " + e, e);
		}
		return 0;
	}

	public static void clickOnAddToCartButton(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCompareCatalogItems compareCatalogItems = FactoryPage.getInstanceOf(IPageCompareCatalogItemsImpl.class);
			compareCatalogItems.clickOnAddToCartButton(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToCartButton " + e, e);
		}
	}
}
