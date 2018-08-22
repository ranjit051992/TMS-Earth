/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpeform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreatePEform
{
	static Logger logger = Logger.getLogger(PageCreatePEform.class);

	public static String fillPEformName(WebDriver driver, String testCaseName, String peformName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.fillPEformName(driver, testCaseName, peformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPEformName " + e, e);
		}
		return null;
	}

	public static String selectProcessForPEform(WebDriver driver, String testCaseName, String processName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.selectProcessForPEform(driver, testCaseName, processName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectProcessForPEform " + e, e);
		}
		return null;
	}

	public static void clickOnSelectOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnSelectOU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectOU " + e, e);
		}
	}

	public static String selectPurhcaseTypeForPEform(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.selectPurhcaseTypeForPEform(driver, testCaseName, purchaseType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPurhcaseTypeForPEform " + e, e);
		}
		return null;
	}

	public static void clickOnSavePEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnSavePEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSavePEformButton " + e, e);
		}
	}

	public static void clickOnCancelPEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnCancelPEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelPEformButton " + e, e);
		}
	}

	public static void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnSaveAsDraftButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveAsDraftButton " + e, e);
		}
	}

	public static void clickOnPreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnPreviewButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPreviewButton " + e, e);
		}
	}

	public static String getPEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getPEformName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPEformName " + e, e);
		}
		return null;
	}

	public static String getSelectedProcessFoePEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getSelectedProcessFoePEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedProcessFoePEform " + e, e);
		}
		return null;
	}

	public static String getSelectedPurchaseTypeForPEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getSelectedPurchaseTypeForPEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedPurchaseTypeForPEform " + e, e);
		}
		return null;
	}

	public static String getAddedSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getAddedSectionName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedSectionName " + e, e);
		}
		return null;
	}

	public static String getAddedFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getAddedFieldName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedFieldName " + e, e);
		}
		return null;
	}

	public static String getTagOFAddedFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getTagOFAddedFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagOFAddedFieldValue " + e, e);
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	//client specific- QTS
	public static String getFileUploadedPEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			return createPEform.getFileUploadedPEformName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFileUploadedPEformName " + e, e);
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	//client specific - QTS
	public static void selectFile(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.selectFile(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFile " + e, e);
		}
	}

	/*
	 * author: bhakti.sawant
	 */
	//client specific - QTS
	public static void clickOnImportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.clickOnImportButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFile " + e, e);
		}
	}

	/*
	 * author: bhakti.sawant
	 * method to attach specific file for upload process form
	 */
	public static void selectFile(WebDriver driver, String testCaseName,  String attachmentFileName) throws Exception
	{
		try
		{
			IPageCreatePEform createPEform = FactoryPage.getInstanceOf(IPageCreatePEformImpl.class);
			createPEform.selectFile(driver, testCaseName,attachmentFileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFile " + e, e);
		}
	}
}
