package com.zycus.automation.eproc.pageobjects.pages.itemmasterview;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * 
 * @author t.amarnath
 * 
 */
public class PageItemMasterView
{
	static Logger	logger	= Logger.getLogger(PageItemMasterView.class);

	public static List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageItemMasterView itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getItemNames(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemNames " + e, e);
		}
		return null;
	}

	public static void clickOnFirstItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnFirstItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstItem " + e, e);
		}
	}

	public static int getSupplierCountOFFirstItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getSupplierCountOfFirstItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierCountOFFirstItem " + e, e);
		}
		return 0;
	}

	public static void clickOnSupplierCountLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnSupplierCountLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSupplierCountLink " + e, e);
		}

	}

	public static void clickOnItemNameLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemNameLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemNameLink " + e, e);
		}

	}

	public static void clickOnViewScopeLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnViewScopeLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewScopeLink " + e, e);
		}

	}

	public static boolean isSupplierCountLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isSupplierCountLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierCountLinkPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemNameLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemNameLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemNameLinkPresent " + e, e);
		}
		return false;

	}

	public static boolean isViewScopeLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isViewScopeLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isViewScopeLinkPresent " + e, e);
		}
		return false;

	}

	public static String getViewScopePopUpHeaderName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getViewScopePopUpHeaderName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getViewScopePopUpHeaderName " + e, e);
		}
		return null;

	}

	public static void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnCloseButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseButton " + e, e);
		}

	}

	public static boolean isSupplierNameColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isSupplierNameColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierNameColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isAddedOnColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isAddedOnColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAddedOnColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isLastUpdatedOnColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isLastUpdatedOnColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isLastUpdatedOnColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isValidityColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isValidityColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isValidityColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isCurrencyColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isCurrencyColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isScopeColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isScopeColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isScopeColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isActiveColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isActiveColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isActiveColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isStatusColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isStatusColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isStatusColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isCloseButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCloseButtonPresent " + e, e);
		}
		return false;

	}

	public static String getValidityValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValidityValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValidityValue " + e, e);
		}
		return null;

	}

	public static boolean isItemActionsColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemActionsColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemActionsColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemStatusColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemStatusColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemStatusColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemERPPartNoColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemERPPartNoColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemERPPartNoColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemManufacturePartIdColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemManufacturePartIdColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemManufacturePartIdColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemNameColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemNameColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemNameColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemCategoryNameColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemCategoryNameColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemCategoryNameColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemSupplierCountColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemSupplierCountColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemSupplierCountColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemCurrencyColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemCurrencyColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemCurrencyColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemMarketPriceColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemMarketPriceColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemMarketPriceColumnPresent " + e, e);
		}
		return false;

	}

	public static boolean isItemUOMColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.isItemUOMColumnPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemUOMColumnPresent " + e, e);
		}
		return false;

	}

	public static void clickOnItemStatusColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemStatusColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemStatusColumn " + e, e);
		}

	}

	public static void clickOnItemERPPartNoColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemERPPartNoColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemERPPartNoColumn " + e, e);
		}

	}

	public static void clickOnItemManufacturePartIdColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemManufacturePartIdColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemManufacturePartIdColumn " + e, e);
		}

	}

	public static void clickOnItemNameColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemNameColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemNameColumn " + e, e);
		}

	}

	public static void clickOnItemCategoryNameColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemCategoryNameColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemCategoryNameColumn " + e, e);
		}

	}

	public static void clickOnItemSupplierCountColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemSupplierCountColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemSupplierCountColumn " + e, e);
		}

	}

	public static void clickOnItemCurrencyColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemCurrencyColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemCurrencyColumn " + e, e);
		}

	}

	public static void clickOnItemMarketPriceColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemMarketPriceColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemMarketPriceColumn " + e, e);
		}

	}

	public static void clickOnItemUOMColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemUOMColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemUOMColumn " + e, e);
		}

	}

	public static void clickOnItemActionsColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			itemMasterView.clickOnItemActionsColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemActionsColumn " + e, e);
		}

	}

	public static String getValueOfItemERPPartNoColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemERPPartNoColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemERPPartNoColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemManufacturePartIdColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemManufacturePartIdColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemManufacturePartIdColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemNameColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemNameColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemNameColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemCategoryNameColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemCategoryNameColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemCategoryNameColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemSupplierCountColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemSupplierCountColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemSupplierCountColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemCurrencyColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemCurrencyColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemCurrencyColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemMarketPriceColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemMarketPriceColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemMarketPriceColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemUOMColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemUOMColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemUOMColumn " + e, e);
		}
		return null;

	}

	public static String getValueOfItemActionsColumn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageItemMasterView itemMasterView;
		try
		{
			itemMasterView = FactoryPage.getInstanceOf(IPageItemMasterViewImpl.class);
			return itemMasterView.getValueOfItemActionsColumn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfItemActionsColumn " + e, e);
		}
		return null;

	}
}
