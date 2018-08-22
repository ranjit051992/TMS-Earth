/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.receiptlisting;

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
public class PageReceiptListing
{
	static Logger logger = Logger.getLogger(PageReceiptListing.class);

	public static boolean checkSuccessfulCreationOfReturnNote(WebDriver driver, String testCaseName, String returnNoteNo) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNoteNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method Exception in method checkSuccessfulCreationOfReturnNote");
		}
		return false;
	}

	public static void clickOnCreateReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnCreateReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReceiptButton " + e, e);
		}
	}

	public static void clickOnFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnFirstReceiptNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstReceiptNo " + e, e);
		}
	}

	public static String getFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getFirstReceiptNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReceiptNo " + e, e);
		}
		return null;
	}

	public static String getFirstReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getFirstReceiptDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReceiptDate " + e, e);
		}
		return null;
	}

	public static String getFirstReceiptStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getFirstReceiptStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReceiptStatus " + e, e);
		}
		return null;
	}

	public static void clickOnViewReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnViewReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewReceiptButton " + e, e);
		}
	}

	public static void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnCancelReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelReceiptButton " + e, e);
		}
	}

	public static void clickOnEditReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnEditReceiptLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditReceiptLink " + e, e);
		}

	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static List<WebElement> getWebElementOfDeleteReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getWebElementOfDeleteReturnNote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteReturnNote" + e, e);
		}
		return null;
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void clickOnDeleteReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnDeleteReturnNote(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteReturnNote" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void clickOnYesButtonReturnNotePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnYesButtonReturnNotePopUp(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnYesButtonReturnNotePopUp" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void selectReceiptInStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.selectReceiptInStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReceiptInStatusFilter" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void selectReturnNoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.selectReturnNoteStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReturnNoteStatusFilter" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void clickOnClearFilterStatusButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			receiptListing.clickOnClearFilterStatusButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearFilterStatusButton" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static String getStatusOfFirstReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getStatusOfFirstReturnNote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfFirstReturnNote" + e, e);
		}
		return null;
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static String getFirstReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageReceiptListing receiptListing = FactoryPage.getInstanceOf(IPageReceiptListingImpl.class);
			return receiptListing.getFirstReturnNoteNumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReturnNoteNumber" + e, e);
		}
		return null;
	}

}
