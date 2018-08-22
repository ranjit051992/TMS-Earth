/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemdetails;

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
public class ModalItemDetails
{

	static Logger logger = Logger.getLogger(ModalItemDetails.class);

	public static String getItemTitle(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemTitle(driver, testCaseName, itemId);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemTitle " + e, e);
		}
		return null;
	}

	public static String getItemDesc(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemDesc(driver, testCaseName, itemId);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDesc " + e, e);
		}
		return null;
	}

	public static String getItemManufacturer(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemManufacturer(driver, testCaseName, itemId);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemManufacturer " + e, e);
		}
		return null;
	}

	public static void clickOnCloseItemDetailsMdoal(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			iModalItemDetails.clickOnCloseItemDetailsMdoal(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseItemDetailsMdoal " + e, e);
		}
	}

	public static String getItemCategory(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemCategory(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCategory " + e, e);
		}
		return null;
	}

	public static String getItemSpscCode(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSpscCode(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSpscCode " + e, e);
		}
		return null;
	}

	public static String getItemSupplierName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSupplierName(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplierName " + e, e);
		}
		return null;
	}

	public static String getItemSupplierContact(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSupplierContact(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplierContact " + e, e);
		}
		return null;
	}

	public static String getItemDeliveryLeadTime(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemDeliveryLeadTime(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemDeliveryLeadTime " + e, e);
		}
		return null;
	}

	public static String getItemContractNo(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemContractNo(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemContractNo " + e, e);
		}
		return null;
	}

	public static String getItemSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSpecificationName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSpecificationName " + e, e);
		}
		return null;
	}

	public static String getItemSpecificationKey(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSpecificationKey(driver, testCaseName, divIndex);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSpecificationKey " + e, e);
		}
		return null;
	}

	public static String getItemSpecificationValue(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getItemSpecificationValue(driver, testCaseName, divIndex);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSpecificationValue " + e, e);
		}
		return null;
	}

	public static List<WebElement> getAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getAttachments(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachments " + e, e);
		}
		return null;
	}

	public static List<String> getAttachmentsNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getAttachmentsNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentsNames " + e, e);
		}
		return null;
	}

	public static boolean isItemDetailsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isItemDetailsTabPresent(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemDetailsTabPresent " + e, e);
		}
		return false;
	}

	public static boolean isItemSpecificationsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isItemSpecificationsTabPresent(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemSpecificationsTabPresent " + e, e);
		}
		return false;
	}

	public static boolean isItemAttachmentsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isItemAttachmentsTabPresent(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemAttachmentsTabPresent " + e, e);
		}
		return false;
	}

	public static void clickOnSpecificationTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			iModalItemDetails.clickOnSpecificationTab(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSpecificationTab " + e, e);
		}
	}

	public static void clickOnAttachmentTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			iModalItemDetails.clickOnAttachmentTab(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAttachmentTab " + e, e);
		}
	}

	public static int getSizeOfSpecifications(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.getSizeOfSpecifications(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSizeOfSpecifications " + e, e);
		}

		return 0;
	}
}
