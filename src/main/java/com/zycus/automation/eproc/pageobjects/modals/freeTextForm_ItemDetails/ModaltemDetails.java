package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ItemDetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModaltemDetails
{

	static Logger logger = Logger.getLogger(ModaltemDetails.class);

	public String getItemNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String itemNumber = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			itemNumber = itemDetails.getItemNumber(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemNumber " + e, e);
		}
		return itemNumber;
	}

	public String getIShortDescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{

		String shortDesc = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			shortDesc = itemDetails.getIShortDescription(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getIShortDescription " + e, e);
		}
		return shortDesc;
	}

	public String getLongdescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String longDesc = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			longDesc = itemDetails.getLongdescription(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLongdescription " + e, e);
		}
		return longDesc;

	}

	public String getItemType(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String itemType = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			itemType = itemDetails.getItemType(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemType " + e, e);
		}
		return itemType;

	}

	public String getReceiveBy(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String receiveBy = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			receiveBy = itemDetails.getReceiveBy(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceiveBy " + e, e);
		}
		return receiveBy;
	}

	public String getProductCategory(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String prodCategory = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			prodCategory = itemDetails.getProductCategory(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceiveBy " + e, e);
		}
		return prodCategory;
	}

	public int getQuantity(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		int qty = 0;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			qty = itemDetails.getQuantity(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantity " + e, e);
		}
		return qty;
	}

	public String getUOM(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String getUOM = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			getUOM = itemDetails.getUOM(driver, testcaseName, itemID);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUOM " + e, e);
		}
		return getUOM;
	}

	public float getPrice(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		float price = 0;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			price = itemDetails.getPrice(driver, testcaseName, itemID);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPrice " + e, e);
		}
		return price;
	}

	public String getSourcingStatus(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String sourcingStatus = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			sourcingStatus = itemDetails.getSourcingStatus(driver, testcaseName, itemID);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSourcingStatus " + e, e);
		}
		return sourcingStatus;
	}

	public String getCurrency(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String curr = null;

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			curr = itemDetails.getCurrency(driver, testcaseName, itemID);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCurrency " + e, e);
		}
		return curr;
	}

	public void toClickShowExtraFields(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			itemDetails.toClickShowExtraFields(driver, testcaseName);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickShowExtraFields " + e, e);
		}

	}

	public String getAddressFrmRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{

		String addFrmRequirementDetails = null;
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			addFrmRequirementDetails = itemDetails.getAddressFrmRequirementDetailsTab(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddressFrmRequirementDetailsTab " + e, e);
		}
		return addFrmRequirementDetails;
	}

	public String getSupplierName(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String supplierName = null;
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			supplierName = itemDetails.getSupplierName(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierName " + e, e);
		}
		return supplierName;
	}

	public String getAddressFrmSuppliersTab(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String addFrmSuppliersTab = null;
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			addFrmSuppliersTab = itemDetails.getAddressFrmSuppliersTab(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddressFrmSuppliersTab " + e, e);
		}
		return addFrmSuppliersTab;
	}

	public String getContractNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String contractNo = null;
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			contractNo = itemDetails.getContractNumber(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getContractNumber " + e, e);
		}
		return contractNo;
	}

	public void toClickCopyBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			itemDetails.toClickCopyBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCopyBtn " + e, e);
		}

	}

	public void toClickCloseBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails itemDetails = FactoryModal.getInstanceOfIModalItemDetails();
			itemDetails.toClickCloseBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCloseBtn " + e, e);
		}

	}

}