/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.uploaditemsincatalog;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalUploadItemsInCatalog
{
	static Logger logger = Logger.getLogger(ModalUploadItemsInCatalog.class);

	public static void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemsInCatalog modalUploadItemsInCatalog = FactoryPage.getInstanceOf(IModalUploadItemsInCatalogImpl.class);
			modalUploadItemsInCatalog.clickOnUploadItemsViaFileButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("FactoryMethodException in clickOnUploadItemsViaFileButton method" + e, e);
		}
	}

	public static String fillFileName(WebDriver driver, String testCaseName, String fileName) throws Exception
	{
		try
		{
			IModalUploadItemsInCatalog modalUploadItemsInCatalog = FactoryPage.getInstanceOf(IModalUploadItemsInCatalogImpl.class);
			return modalUploadItemsInCatalog.fillFileName(driver, testCaseName, fileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("FactoryMethodException in fillFileName method" + e, e);
		}
		return null;
	}

	public static void clickOnUploadCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemsInCatalog modalUploadItemsInCatalog = FactoryPage.getInstanceOf(IModalUploadItemsInCatalogImpl.class);
			modalUploadItemsInCatalog.clickOnUploadCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("FactoryMethodException in clickOnUploadCatalogButton method" + e, e);
		}
	}

	public static void clickOnCancelCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemsInCatalog modalUploadItemsInCatalog = FactoryPage.getInstanceOf(IModalUploadItemsInCatalogImpl.class);
			modalUploadItemsInCatalog.clickOnCancelCatalogButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("FactoryMethodException in clickOnCancelCatalogButton method" + e, e);
		}
	}

}
