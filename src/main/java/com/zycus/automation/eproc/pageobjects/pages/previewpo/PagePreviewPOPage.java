/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.previewpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PagePreviewPOPage
{
	static Logger logger = Logger.getLogger(PagePreviewPOPage.class);

	public static String getPreviewGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewGrossTotal(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewGrossTotal" + e, e);
		}
		return null;
	}

	public static String getPreviewPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoNo" + e, e);
		}
		return null;
	}

	public static String getPreviewPoSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoSupplierName" + e, e);
		}
		return null;
	}

	public static String getPreviewPoBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoBillToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoBillToAddress" + e, e);
		}
		return null;
	}

	public static String getPreviewPoShipToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoShipToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoShipToAddress" + e, e);
		}
		return null;
	}

	public static String getPreviewPoBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoBuyerName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoBuyerName" + e, e);
		}
		return null;
	}

	public static String getPreviewPoCBLDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoCBLDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoCBLDetails" + e, e);
		}
		return null;
	}

	public static String getPreviewPoItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoItemName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoItemName" + e, e);
		}
		return null;
	}

	public static String getPreviewPoQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoQuantity" + e, e);
		}
		return null;
	}

	public static String getPreviewPoUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoUnitPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoUnitPrice" + e, e);
		}
		return null;
	}

	public static String getPreviewPoTaxesTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePreviewPOPage previewPOPage = FactoryPage.getInstanceOf(IPagePreviewPOPageImpl.class);
			return previewPOPage.getPreviewPoTaxesTotal(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory Method Exception in method getPreviewPoTaxesTotal" + e, e);
		}
		return null;
	}

}
