package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.IModelRequisitionSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelBuyersdeskSummaryBilling
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException
	{
		String billBU = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billBU = reqSummary.fillBillingBU(driver, testCaseName, billingBU);
			if (billBU.equalsIgnoreCase(billingBU))
			{
				return billBU;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingBU " + e, e);
		}
		return null;
	}

	public static String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException
	{

		String billComp = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billComp = reqSummary.fillBillingCompany(driver, testCaseName, billingCompany);
			if (billComp.equalsIgnoreCase(billingCompany))
			{
				return billComp;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingCompany " + e, e);
		}
		return null;
	}

	public static String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException
	{

		String billCurr = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billCurr = reqSummary.fillBillingCurrency(driver, testCaseName, billingCurrency);
			if (billCurr.equalsIgnoreCase(billingCurrency))
			{
				return billCurr;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingCurrency " + e, e);
		}
		return null;
	}

	public static String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException
	{

		String billLoc = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billLoc = reqSummary.fillBillingLocation(driver, testCaseName, billingLocation);
			if (billLoc.equalsIgnoreCase(billingLocation))
			{
				return billLoc;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingLocation " + e, e);
		}
		return null;
	}

	public static String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billToAddress = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billToAddress = reqSummary.getBillToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillToAddress " + e, e);
		}
		return billToAddress;
	}

	public static String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String sendtoAddress = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			sendtoAddress = reqSummary.getSendToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSendToAddress " + e, e);
		}
		return sendtoAddress;
	}

	public static String getRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqCurrency = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			reqCurrency = reqSummary.getRequisitionCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionCurrency " + e, e);
		}
		return reqCurrency;
	}

	public static String getBillingCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingCompanyName = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billingCompanyName = reqSummary.getBillingCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillingCompany " + e, e);
		}
		return billingCompanyName;
	}

	public static String getBillingBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingBU = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billingBU = reqSummary.getBillingBU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillingBU " + e, e);
		}
		return billingBU;
	}

	public static String getBillingLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingLocation = null;
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			billingLocation = reqSummary.getBillingLocation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillingLocation " + e, e);
		}
		return billingLocation;
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			reqSummary.clickOnSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryBilling reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryBilling();
			reqSummary.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

}
