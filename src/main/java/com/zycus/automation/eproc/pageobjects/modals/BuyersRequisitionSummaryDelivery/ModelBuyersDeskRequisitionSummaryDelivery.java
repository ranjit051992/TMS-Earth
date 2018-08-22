package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryDelivery;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.IModelRequisitionSummaryDelivery;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class ModelBuyersDeskRequisitionSummaryDelivery
{

	static Logger logger = Logger.getLogger(ModelBuyersDeskRequisitionSummaryDelivery.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean saveAdd = false;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			saveAdd = reqSummary.checkSaveAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkSaveAddress " + e, e);
		}
		return saveAdd;

	}

	public static void clearDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			reqSummary.clearDeliveryRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearDeliveryRequiredByDate " + e, e);
		}

	}

	public static void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			reqSummary.clickDeliveryCreateNewAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryCreateNewAddress " + e, e);
		}

	}

	public static String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			deliverTo = reqSummary.fillDeliveryDeliverTo(driver, testCaseName, deliveryDeliverTo);
			if (deliverTo.equalsIgnoreCase(deliveryDeliverTo))
			{
				return deliverTo;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryDeliverTo " + e, e);
		}
		return null;
	}

	public static String fillDeliveryMyAddress(WebDriver driver, String testCaseName, String deliveryMyAddress) throws ActionBotException
	{

		String deliverAdd = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			deliverAdd = reqSummary.fillDeliveryMyAddress(driver, testCaseName, deliveryMyAddress);
			ScreenShot.screenshot(driver, testCaseName, "After filling delivery My Address");
			if (deliverAdd.equalsIgnoreCase(deliveryMyAddress))
			{
				return deliverAdd;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryMyAddress " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressCity(WebDriver driver, String testCaseName, String newAddressCity) throws ActionBotException
	{

		String addCity = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			addCity = reqSummary.fillDeliveryNewAddressCity(driver, testCaseName, newAddressCity);
			if (addCity.equalsIgnoreCase(newAddressCity))
			{
				return addCity;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressCity " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressCountry(WebDriver driver, String testCaseName, String newAddressCountry) throws ActionBotException
	{

		String country = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			country = reqSummary.fillDeliveryNewAddressCountry(driver, testCaseName, newAddressCountry);
			if (country.equalsIgnoreCase(newAddressCountry))
			{
				return country;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressCountry " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressCounty(WebDriver driver, String testCaseName, String newAddressCounty) throws ActionBotException
	{

		String county = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			county = reqSummary.fillDeliveryNewAddressCounty(driver, testCaseName, newAddressCounty);
			if (county.equalsIgnoreCase(newAddressCounty))
			{
				return county;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressCounty " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressName(WebDriver driver, String testCaseName, String newAddressName) throws ActionBotException
	{

		String name = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			name = reqSummary.fillDeliveryNewAddressName(driver, testCaseName, newAddressName);
			if (name.equalsIgnoreCase(newAddressName))
			{
				return name;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressName " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressState(WebDriver driver, String testCaseName, String newAddressState) throws ActionBotException
	{

		String state = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			state = reqSummary.fillDeliveryNewAddressState(driver, testCaseName, newAddressState);
			if (state.equalsIgnoreCase(newAddressState))
			{
				return state;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressState " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressStreet1(WebDriver driver, String testCaseName, String newAddressStreet1) throws ActionBotException
	{

		String street1 = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			street1 = reqSummary.fillDeliveryNewAddressStreet1(driver, testCaseName, newAddressStreet1);
			if (street1.equalsIgnoreCase(newAddressStreet1))
			{
				return street1;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressStreet1 " + e, e);
		}
		return null;
	}

	public static String fillDeliveryNewAddressStreet2(WebDriver driver, String testCaseName, String newAddressStreet2) throws ActionBotException
	{

		String street2 = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			street2 = reqSummary.fillDeliveryNewAddressStreet2(driver, testCaseName, newAddressStreet2);
			if (street2.equalsIgnoreCase(newAddressStreet2))
			{
				return street2;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressStreet2 " + e, e);
		}
		return null;
	}

	public static int fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, int newAddressZip) throws ActionBotException
	{

		int zip = 0;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			zip = reqSummary.fillDeliveryNewAddressZip(driver, testCaseName, newAddressZip);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressZip " + e, e);
		}
		return zip;
	}

	public static String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException
	{

		String otherAddress = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			otherAddress = reqSummary.fillDeliveryOtherAddress(driver, testCaseName, deliveryOtherAddress);
			if (otherAddress.equalsIgnoreCase(deliveryOtherAddress))
			{
				return otherAddress;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryOtherAddress " + e, e);
		}
		return null;
	}

	public static String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			deliverTo = reqSummary.getdeliveryDeliverTo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getdeliveryDeliverTo " + e, e);
		}
		return deliverTo;
	}

	public static String getDeliveryOtherAddressesReflectedAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reflectedAddress = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			reflectedAddress = reqSummary.getDeliveryOtherAddressesReflectedAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryOtherAddressesReflectedAddress " + e, e);
		}
		return reflectedAddress;
	}

	public static String getDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ouAddress = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			ouAddress = reqSummary.getDeliveryOUAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryOUAddress " + e, e);
		}
		return ouAddress;
	}

	public static String getDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reqdate = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			reqdate = reqSummary.getDeliveryRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryRequiredByDate " + e, e);
		}
		return reqdate;
	}

	public static boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean deliveryMyAddress = false;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			deliveryMyAddress = reqSummary.selectDeliveryMyAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryMyAddress " + e, e);
		}
		return deliveryMyAddress;
	}

	public static boolean selectDeliveryOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean otherAddress = false;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			otherAddress = reqSummary.selectDeliveryOtherAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOtherAddress " + e, e);
		}
		return otherAddress;
	}

	public static boolean selectDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean ouAddress = false;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			ouAddress = reqSummary.selectDeliveryOUAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOUAddress " + e, e);
		}
		return ouAddress;
	}

	public static String selectRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String requiredByDate = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			requiredByDate = reqSummary.selectRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return requiredByDate;
	}

	public static String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requiredByDate = null;
		try
		{
			IModelRequisitionSummaryDelivery reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryDelivery();
			requiredByDate = reqSummary.getRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequiredByDate " + e, e);
		}
		return requiredByDate;
	}

}
