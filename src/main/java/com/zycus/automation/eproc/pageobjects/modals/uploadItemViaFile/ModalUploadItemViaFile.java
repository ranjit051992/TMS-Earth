package com.zycus.automation.eproc.pageobjects.modals.uploadItemViaFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalUploadItemViaFile
{
	static Logger logger = Logger.getLogger(ModalUploadItemViaFile.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static String enterFilePath(WebDriver driver, String testCaseName, String filePath)
	{
		try
		{
			IModalUploadItemViaFile iModalUploadItemViaFile = FactoryPage.getInstanceOf(IModalUploadItemViaFileImpl.class);
			return iModalUploadItemViaFile.enterFilePath(driver, testCaseName, filePath);
		}
		catch (Exception e)
		{
			logger.error("Exception in enterFilePath " + e, e);
		}
		return null;
	}

	public static void clickOnUploadFile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemViaFile iModalUploadItemViaFile = FactoryPage.getInstanceOf(IModalUploadItemViaFileImpl.class);
			iModalUploadItemViaFile.clickOnUploadFile(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnUploadFile " + e, e);
		}
	}

	public static boolean isErrorDetailsOfValidationOfDataPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemViaFile iModalUploadItemViaFile = FactoryPage.getInstanceOf(IModalUploadItemViaFileImpl.class);
			return iModalUploadItemViaFile.isErrorDetailsOfValidationOfDataPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isErrorDetailsOfValidationOfDataPresent " + e, e);
		}
		return false;
	}

	public static void clickOnCloseErrorDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemViaFile iModalUploadItemViaFile = FactoryPage.getInstanceOf(IModalUploadItemViaFileImpl.class);
			iModalUploadItemViaFile.clickOnCloseErrorDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnCloseErrorDetails " + e, e);
		}
	}

	public static boolean isBlankLineNumberErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUploadItemViaFile iModalUploadItemViaFile = FactoryPage.getInstanceOf(IModalUploadItemViaFileImpl.class);
			return iModalUploadItemViaFile.isBlankLineNumberErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isBlankLineNumberErrorPresent " + e, e);
		}
		return false;
	}
}
