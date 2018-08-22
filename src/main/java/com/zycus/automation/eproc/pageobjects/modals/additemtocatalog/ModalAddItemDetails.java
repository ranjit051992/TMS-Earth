package com.zycus.automation.eproc.pageobjects.modals.additemtocatalog;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 * 
 */
public class ModalAddItemDetails
{
	static Logger	logger	= Logger.getLogger(ModalAddItemDetails.class);

	public static String fillSupplierPartId(WebDriver driver, String testCaseName, String supplierPartId) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSupplierPartId(driver, testCaseName, supplierPartId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierPartId " + e, e);
		}
		return null;
	}

	public static String fillShortDescription(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillShortDescription(driver, testCaseName, shortDescription);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillShortDescription " + e, e);
		}
		return null;
	}

	public static String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws Exception
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillProductCategory(driver, testCaseName, productCategory);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductCategory " + e, e);
		}
		return null;
	}

	public static double fillPrice(WebDriver driver, String testCaseName, double price) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillPrice(driver, testCaseName, price);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPrice " + e, e);
		}
		return 0;
	}

	public static void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnAddItemButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddItemButton " + e, e);
		}
	}

	public static void clickOnAddAndContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnAddAndContinueButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddAndContinueButton " + e, e);
		}
	}

	public static void clickOnCloseAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseAddItemButton " + e, e);
		}
	}

	public static String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierName " + e, e);
		}
		return null;
	}

	public static String fillItemCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillItemCurrency(driver, testCaseName, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemCurrency " + e, e);
		}
		return null;
	}

	public static void clickOnUpdateCatalogItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateCatalogItemButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateCatalogItemButton " + e, e);
		}
	}

	public static String fillItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillItemLongDescription(driver, testCaseName, itemLongDescription);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemLongDescription " + e, e);
		}
		return null;
	}

	public static String fillItemUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillItemUOM(driver, testCaseName, UOM);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemUOM " + e, e);
		}
		return null;
	}

	public static String getSupplierId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getSupplierId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemCurrency " + e, e);
		}
		return null;
	}

	public static String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getItemUOM(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUOM " + e, e);
		}
		return null;
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierName " + e, e);
		}
		return null;
	}

	public static String fillERPPartId(WebDriver driver, String testCaseName, String erpID) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillERPPartId(driver, testCaseName, erpID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillERPPartId " + e, e);
		}
		return null;
	}

	public static String fillMarketPrice(WebDriver driver, String testCaseName, String string) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillMarketPrice(driver, testCaseName, string);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMarketPrice " + e, e);
		}
		return null;
	}

	public static boolean isERPIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isERPIdEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isERPIdEditable " + e, e);
		}
		return false;
	}

	public static void clickButtonAddSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickButtonAddSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isERPIdEditable " + e, e);
		}
	}

	public static String fillProductURL(WebDriver driver, String testCaseName, String productURL) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillProductURL(driver, testCaseName, productURL);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductURL " + e, e);
		}
		return null;
	}

	public static String fillManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillManufacturerName(driver, testCaseName, manufacturerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerName " + e, e);
		}
		return null;
	}

	public static String fillManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillManufacturerPartId(driver, testCaseName, manufacturerPartId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerPartId " + e, e);
		}
		return null;
	}

	public static String fillManufacturerURL(WebDriver driver, String testCaseName, String manufacturerURL) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillManufacturerURL(driver, testCaseName, manufacturerURL);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerURL " + e, e);
		}
		return null;
	}

	public static int fillDeliveryLeadDays(WebDriver driver, String testCaseName, int i) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillDeliveryLeadDays(driver, testCaseName, i);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryLeadDays " + e, e);
		}
		return 0;
	}

	public static boolean checkIsGreen(WebDriver driver, String testCaseName, boolean isGreen) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.checkIsGreen(driver, testCaseName, isGreen);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryLeadDays " + e, e);
		}
		return isGreen;
	}

	public static boolean checkIsPreferred(WebDriver driver, String testCaseName, boolean isPreferred) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.checkIsPreferred(driver, testCaseName, isPreferred);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryLeadDays " + e, e);
		}
		return isPreferred;
	}

	public static String fillSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSpecificationName(driver, testCaseName, specificationName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationName " + e, e);
		}
		return null;
	}

	public static String fillSpecificationType(WebDriver driver, String testCaseName, String specificationType) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSpecificationType(driver, testCaseName, specificationType);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationType " + e, e);
		}
		return null;
	}

	public static String fillSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSpecificationValue(driver, testCaseName, specificationValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationValue " + e, e);
		}
		return null;
	}

	public static boolean uploadAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.uploadAttachments(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void fillAttachmentURL(WebDriver driver, String testCaseName, List<String> attachmentURL) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillAttachmentURL(driver, testCaseName, attachmentURL);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentURL " + e, e);
		}
	}

	public static String fillERPPartNo(WebDriver driver, String testCaseName, String ERPPartNo) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillERPPartNo(driver, testCaseName, ERPPartNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in method fillERPPartNo" + e, e);
		}
		return null;
	}

	public static String fillItemDescription(WebDriver driver, String testCaseName, String itemDescription) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillItemDescription(driver, testCaseName, itemDescription);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in method fillItemDescription" + e, e);
		}
		return null;
	}

	public static void clickItemCheckBoxItemMaster(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (index == 1)
				addItemDetails.clickItemCheckBoxItemMaster(driver, testCaseName);
			else if (index == 2)
				addItemDetails.clickSecondItemCheckBox(driver, testCaseName);
			else
				addItemDetails.clickThirdItemCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCheckboxFirstItemOfItemMaster " + e, e);
		}

	}

	public static void clickOnActionsLinkOfItemInItemMaster(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (index == 1)
				addItemDetails.clickOnActionsLinkOfItemInItemMaster(driver, testCaseName);
			else if (index == 2)
				addItemDetails.clickOnActionsLinkSecondItem(driver, testCaseName);
			else
				addItemDetails.clickOnActionsLinkThirdItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsLinkOfItemMaster " + e, e);
		}

	}

	public static void clickOnEditItem(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (index == 1)
				addItemDetails.clickOnEditItem(driver, testCaseName);
			else if (index == 2)
				addItemDetails.clickOnEditSecondItem(driver, testCaseName);
			else
				addItemDetails.clickOnEditThirdItem(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditItem" + e, e);
		}

	}

	public static void clickOnDiscardItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnDiscardItem(driver, testCaseName);
			;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDiscardItem" + e, e);
		}

	}

	public static void clickButtonAddSupplierWhileUpdatingItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickButtonAddSupplierWhileUpdatingItem(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickButtonAddSupplierWhileUpdatingItem" + e, e);
		}

	}

	public static boolean isERPIdPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isERPIdPresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickButtonAddSupplierWhileUpdatingItem" + e, e);
		}
		return false;
	}

	public static boolean selectItemImage(WebDriver driver, String testCaseName, String imageFile) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.selectItemImage(driver, testCaseName, imageFile))
				return true;
		}
		catch (FactoryMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isSelectItemImagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isSelectItemImagePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isAssetNumberingFieldEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isAssetNumberingFieldEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isAttachmentLinkEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isAttachmentLinkEnabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isManufacturePartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isManufacturePartIdEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isManufacturePartIdEditable " + e, e);
		}
		return false;
	}

	public static boolean isManufacturerNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isManufacturerNameEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isManufacturerNameEditable" + e, e);
		}
		return false;
	}

	public static boolean isSpecificationsNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSpecificationsNameEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSpecificationsNameEditable" + e, e);
		}
		return false;
	}

	public static boolean isSpecificationsTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSpecificationsTypeEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSpecificationsTypeEditable" + e, e);
		}
		return false;
	}

	public static boolean isSpecificationsValueEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSpecificationsValueEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSpecificationsValueEditable" + e, e);
		}
		return false;
	}

	public static boolean isCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isCurrencyEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyEditable" + e, e);
		}
		return false;
	}

	public static boolean isMarketPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isMarketPriceEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMarketPriceEditable" + e, e);
		}
		return false;
	}

	public static boolean isUOMEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isUOMEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isUOMEditable" + e, e);
		}
		return false;
	}

	public static boolean isReceiveByEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isReceiveByEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReceiveByEditable" + e, e);
		}
		return false;
	}

	public static boolean isItemTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isItemTypeEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemTypeEditable" + e, e);
		}
		return false;
	}

	public static boolean isProductCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isProductCategoryEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isProductCategoryEditable" + e, e);
		}
		return false;
	}

	public static boolean isItemDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isItemDescriptionEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemDescriptionEditable" + e, e);
		}
		return false;
	}

	public static boolean isShortDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isShortDescriptionEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isShortDescriptionEditable" + e, e);
		}
		return false;
	}

	public static boolean isERPPartNoEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isERPPartNoEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isERPPartNoEditable" + e, e);
		}
		return false;
	}

	public static boolean isShortDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isShortDescriptionMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isShortDescriptionMandatory" + e, e);
		}
		return false;
	}

	public static boolean isERPPartNoMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isERPPartNoMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isERPPartNoMandatory" + e, e);
		}
		return false;
	}

	public static boolean isItemTypeMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isItemTypeMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemTypeMandatory" + e, e);
		}
		return false;
	}

	public static boolean isUOMMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isUOMMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isUOMMandatory" + e, e);
		}
		return false;
	}

	public static boolean isProductCategoryMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isProductCategoryMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isProductCategoryMandatory" + e, e);
		}
		return false;
	}

	public static boolean isSelectFileButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSelectFileButtonPresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSelectFileButtonPresent" + e, e);
		}
		return false;
	}

	public static void clickOnUpdateSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateSupplierButton(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateSupplierButton" + e, e);
		}
	}

	public static String fillSearchBoxSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillSearchBoxSupplier(driver, testCaseName, supplierName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchBoxSupplier" + e, e);
		}
		return supplierName;
	}

	public static void clickOnGoButtonSupplierSearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnGoButtonSupplierSearch(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGoButtonSupplierSearch" + e, e);
		}
	}

	public static void clickOnClearSearchResults(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnClearSearchResults(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearSearchResults" + e, e);
		}
	}

	public static List<String> getListOfSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getListOfSuppliers(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfSuppliers" + e, e);
		}
		return null;
	}

	public static boolean isCancelAndCloseIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isCancelAndCloseIconPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCancelAndCloseIconPresent" + e, e);
		}
		return false;
	}

	public static List<String> getColumnNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getColumnNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getColumnNames" + e, e);
		}
		return null;
	}

	public static List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getItemNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemNames" + e, e);
		}
		return null;
	}

	public static String getAddedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getAddedOn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedOn" + e, e);
		}
		return null;
	}

	public static String getLastUpdatedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getLastUpdatedOn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLastUpdatedOn" + e, e);
		}
		return null;
	}

	public static String getSupplierStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getSupplierStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfSuppliers" + e, e);
		}
		return null;
	}

	public static void uploadAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.uploadAttachment(driver, testCaseName, fileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadAttachment" + e, e);
		}
	}

	public static void fillSingleAttachmentURL(WebDriver driver, String testCaseName, String URL) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillSingleAttachmentURL(driver, testCaseName, URL);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadAttachment" + e, e);
		}
	}

	public static String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getSpecificationName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadAttachment" + e, e);
		}
		return null;
	}

	public static String getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getMarketPrice(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method getMarketPrice" + e, e);
		}
		return null;
	}

	public static boolean isPreferredNoPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isPreferredNoPresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in methodisPreferredNoPresent" + e, e);
		}
		return false;
	}

	public static boolean isPreferredYesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isPreferredYesPresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPreferredYesPresent" + e, e);
		}
		return false;
	}

	public static boolean isSupplierNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierNameEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierNameEditable" + e, e);
		}
		return false;
	}

	public static boolean isSupplierPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierPriceEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierPriceEditable" + e, e);
		}
		return false;
	}

	public static boolean isItemCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isItemCurrencyEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemCurrencyEditable" + e, e);
		}
		return false;
	}

	public static boolean isDeliveryTimeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isDeliveryTimeEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryTimeEditable" + e, e);
		}
		return false;
	}

	public static boolean isProductURLEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isProductURLEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isProductURLEditable" + e, e);
		}
		return false;
	}

	public static boolean isSupplierPartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierPartIdEditable(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierPartIdEditable" + e, e);
		}
		return false;
	}

	public static boolean isProductURLPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isProductURLPresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isProductURLPresent" + e, e);
		}
		return false;
	}

	public static boolean isDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isDeliveryLeadTimePresent(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryLeadTimePresent" + e, e);
		}
		return false;
	}

	public static boolean isItemCurrencyMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isItemCurrencyMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemCurrencyMandatory" + e, e);
		}
		return false;
	}

	public static boolean isSupplierPriceMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierPriceMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierPriceMandatory" + e, e);
		}
		return false;
	}

	public static boolean isSupplierPartIdMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierPartIdMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierPartIdMandatory" + e, e);
		}
		return false;
	}

	public static boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			if (addItemDetails.isSupplierNameMandatory(driver, testCaseName))
				return true;

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierNameMandatory" + e, e);
		}
		return false;
	}

	public static void clickOnSupplierActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnSupplierActionsLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSupplierActionsLink" + e, e);
		}

	}

	public static void clickOnEditSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnEditSupplierLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditSupplierLink" + e, e);
		}

	}

	public static void clickOnDiscardSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnDiscardSupplierLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDiscardSupplierLink" + e, e);
		}

	}

	public static void clickOnItemScopeOfAddSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnItemScopeOfAddSupplier(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemScopeOfAddSupplier" + e, e);
		}

	}

	public static boolean isItemScopeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isItemScopeLabelPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateAllLinesPresentInSupplierPage(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static void clickOnUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateAllLinesPresentInSupplierPage(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static boolean isUpdateItemProductCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemProductCategoryPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemCurrencyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemCurrencyPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemUOMPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemUOMPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemManufacturerNamePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemManufacturerNamePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemManufacturerURLPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemManufacturerURLPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemDeliveryLeadTimePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static void fillUpdateItemProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemProductCategory(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void fillUpdateItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemCurrency(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void fillUpdateItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemUOM(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void fillUpdateItemManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemManufacturerName(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void fillUpdateItemManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemManufacturerURL(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void fillUpdateItemDeliveryLeadTime(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.fillUpdateItemDeliveryLeadTime(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static boolean isUpdateItemUpdateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemUpdateButtonPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemCloseLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemCloseLinkPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static boolean isUpdateItemCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isUpdateItemCloseButtonPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
		return false;

	}

	public static void clickOnUpdateItemUpdateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateItemUpdateButton(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}

	}

	public static void clickOnUpdateItemCloseLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateItemCloseLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemScopePresent" + e, e);
		}
	}

	public static void clickOnUpdateItemCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateItemCloseButton(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method getItemCurrency" + e, e);
		}
	}

	public static String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAddItemDetails addItemDetails;
		try
		{
			addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getItemCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCurrency" + e, e);
		}
		return null;
	}

	public static List<String> getListOfAddedAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getListOfAddedAttachments(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfAddedAttachments" + e, e);
		}
		return null;
	}

	public static void clickOnUpdateSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnUpdateSupplier(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateSupplier" + e, e);
		}

	}

	public static void clickOnAddExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.clickOnAddExistingSupplier(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddExistingSupplier" + e, e);
		}

	}

	public static boolean isCurrencyItemEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isCurrencyItemEditable(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyItemEditable" + e, e);
		}
		return false;

	}

	public static boolean isCurrencyItemPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isCurrencyItemPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyItemPresent" + e, e);
		}
		return false;

	}

	public static void setActiveSupplierYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.setActiveSupplierYes(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method setActiveSupplierYes" + e, e);
		}

	}

	public static void setActiveSupplierNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			addItemDetails.setActiveSupplierNo(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method setActiveSupplierNo" + e, e);
		}

	}

	public static boolean isDuplicateERPPartNoErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isDuplicateERPPartNoErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDuplicateERPPartNoErrorMessagePresent" + e, e);
		}
		return false;

	}

	public static boolean isSupplierNameMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isSupplierNameMandatoryErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierNameMandatoryErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isSupplierPartIdMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isSupplierPartIdMandatoryErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierPartIdMandatoryErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isSupplierItemPriceMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isSupplierItemPriceMandatoryErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierItemPriceMandatoryErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static String fillFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillFromValidityDate(driver, testCaseName, day, month, year);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFromValidityDate" + e, e);
		}
		return null;
	}

	public static String fillToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.fillToValidityDate(driver, testCaseName, day, month, year);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToValidityDate" + e, e);
		}
		return null;
	}

	public static boolean isFromValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isFromValidityDatePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method setActiveSupplierNo" + e, e);
		}
		return false;
	}

	public static boolean isToValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isToValidityDatePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method setActiveSupplierNo" + e, e);
		}
		return false;
	}

	public static boolean isErrorBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isErrorBoxPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isErrorBoxPresent" + e, e);
		}
		return false;
	}

	public static boolean isInvalidERPPartNoErrorMessageForFilePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isInvalidERPPartNoErrorMessageForFilePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvalidERPPartNoErrorMessageForFilePresent" + e, e);
		}
		return false;
	}

	public static boolean isDuplicateSupplierPartIDPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isDuplicateSupplierPartIDPresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDuplicateSupplierPartIDPresent" + e, e);
		}
		return false;
	}

	public static boolean isMissingShortDescriptionErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isMissingShortDescriptionErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMissingShortDescriptionErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static int getNumberOfCharactersShortDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getNumberOfCharactersShortDescription(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersShortDescription" + e, e);
		}
		return 0;
	}

	public static int getNumberOfCharactersManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getNumberOfCharactersManufacturerName(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersManufacturerName" + e, e);
		}
		return 0;
	}

	public static boolean isInvalidUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isInvalidUnitOfMeasureErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvalidUnitOfMeasureErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static int getNumberOfCharactersItemDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getNumberOfCharactersItemDescription(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersItemDescription" + e, e);
		}
		return 0;
	}

	public static boolean isMissingCurrencyErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isMissingCurrencyErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMissingCurrencyErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isMissingUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isMissingUnitOfMeasureErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMissingUnitOfMeasureErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isCurrencyInvalidOrInactiveErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isCurrencyInvalidOrInactiveErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyInvalidOrInactiveErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static int getNumberOfCharactersManufacturePartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getNumberOfCharactersManufacturePartId(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersManufacturePartId" + e, e);
		}
		return 0;
	}

	public static int getNumberOfCharactersProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.getNumberOfCharactersProductCategory(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersProductCategory" + e, e);
		}
		return 0;
	}

	public static boolean isMissingProductCategoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isMissingProductCategoryErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMissingProductCategoryErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isInvalidPriceErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isInvalidPriceErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvalidPriceErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isInvalidSupplierPartIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isInvalidSupplierPartIdErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfCharactersProductCategory" + e, e);
		}
		return false;
	}

	public static boolean isMissingSupplierIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isMissingSupplierIdErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMissingSupplierIdErrorMessagePresent" + e, e);
		}
		return false;
	}

	public static boolean isInvalidLeadTimeErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddItemDetails addItemDetails = FactoryPage.getInstanceOf(IModalAddItemDetailsImpl.class);
			return addItemDetails.isInvalidLeadTimeErrorMessagePresent(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvalidLeadTimeErrorMessagePresent" + e, e);
		}
		return false;
	}
}
