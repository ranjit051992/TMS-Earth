package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelRequisitionSummary
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean saveAdd = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			saveAdd = reqSummary.checkSaveAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkSaveAddress " + e, e);
		}
		return saveAdd;

	}

	public void clearDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clearDeliveryRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearDeliveryRequiredByDate " + e, e);
		}

	}

	public void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clickCancleReqSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleReqSummary " + e, e);
		}
	}

	public void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clickDeliveryCreateNewAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryCreateNewAddress " + e, e);
		}

	}

	public void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clickMultiAddCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickMultiAddCostCenter " + e, e);
		}
	}

	public void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clickMultiDeleteCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickMultiDeleteCostCenter " + e, e);
		}
	}

	public void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqSummary.clickSaveReqSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveReqSummary " + e, e);
		}

	}

	public String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException
	{
		String billBU = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException
	{

		String billComp = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException
	{

		String billCurr = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException
	{

		String billLoc = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException
	{

		String budget = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			budget = reqSummary.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget);
			if (budget.equalsIgnoreCase(costBookingSingleBudget))
			{
				return budget;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleBudget " + e, e);
		}
		return null;
	}

	public String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException
	{

		String cc = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			cc = reqSummary.fillCostBookingSingleCC(driver, testCaseName, costBookingSingleCC);
			if (cc.equalsIgnoreCase(costBookingSingleCC))
			{
				return cc;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostBookingSingleCC " + e, e);
		}
		return null;
	}

	public String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryMyAddress(WebDriver driver, String testCaseName, String deliveryMyAddress) throws ActionBotException
	{

		String deliverAdd = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			deliverAdd = reqSummary.fillDeliveryMyAddress(driver, testCaseName, deliveryMyAddress);
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

	public String fillDeliveryNewAddressCity(WebDriver driver, String testCaseName, String newAddressCity) throws ActionBotException
	{

		String addCity = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressCountry(WebDriver driver, String testCaseName, String newAddressCountry) throws ActionBotException
	{

		String country = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressCounty(WebDriver driver, String testCaseName, String newAddressCounty) throws ActionBotException
	{

		String county = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressName(WebDriver driver, String testCaseName, String newAddressName) throws ActionBotException
	{

		String name = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressState(WebDriver driver, String testCaseName, String newAddressState) throws ActionBotException
	{

		String state = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressStreet1(WebDriver driver, String testCaseName, String newAddressStreet1) throws ActionBotException
	{

		String street1 = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressStreet2(WebDriver driver, String testCaseName, String newAddressStreet2) throws ActionBotException
	{

		String street2 = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, String newAddressZip) throws ActionBotException
	{

		String zip = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			zip = reqSummary.fillDeliveryNewAddressZip(driver, testCaseName, newAddressZip);
			if (zip.equalsIgnoreCase(newAddressZip))
			{
				return zip;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryNewAddressZip " + e, e);
		}
		return null;
	}

	public String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException
	{

		String otherAddress = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
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

	public String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException
	{

		String ccBudget = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccBudget = reqSummary.fillMultiCostCenterBudget(driver, testCaseName, multiCostCenterBudget, index);
			if (ccBudget.equalsIgnoreCase(multiCostCenterBudget))
			{
				return ccBudget;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterBudget " + e, e);
		}
		return null;
	}

	public String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException
	{

		String ccName = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccName = reqSummary.fillMultiCostCenterName(driver, testCaseName, multiCostCenterName, index);
			if (ccName.equalsIgnoreCase(multiCostCenterName))
			{
				return ccName;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterName " + e, e);
		}
		return null;
	}

	public String fillMultiCostCenterPercent(WebDriver driver, String testCaseName, String multiCostCenterPercent, int index) throws ActionBotException
	{

		String ccPercent = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccPercent = reqSummary.fillMultiCostCenterPercent(driver, testCaseName, multiCostCenterPercent, index);
			if (ccPercent.equalsIgnoreCase(multiCostCenterPercent))
			{
				return ccPercent;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiCostCenterPercent " + e, e);
		}
		return null;
	}

	public String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billToAddress = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			billToAddress = reqSummary.getBillToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillToAddress " + e, e);
		}
		return billToAddress;
	}

	public String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccAmount = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccAmount = reqSummary.getCostBookingItemLevelCCAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCAmount " + e, e);
		}
		return ccAmount;
	}

	public String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccBudget = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccBudget = reqSummary.getCostBookingItemLevelCCBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCBudget " + e, e);
		}
		return ccBudget;
	}

	public String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccName = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccName = reqSummary.getCostBookingItemLevelCCName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingItemLevelCCName " + e, e);
		}
		return ccName;
	}

	public String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, String multiCostCenterAmount, int index) throws ActionBotException
	{

		String ccAmount = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ccAmount = reqSummary.getCostBookingMultiCostCenterAmount(driver, testCaseName, multiCostCenterAmount, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiCostCenterAmount " + e, e);
		}
		return ccAmount;
	}

	public String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String totalAmount = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			totalAmount = reqSummary.getCostBookingTotalAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingTotalAmount " + e, e);
		}
		return totalAmount;
	}

	public String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverTo = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			deliverTo = reqSummary.getdeliveryDeliverTo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getdeliveryDeliverTo " + e, e);
		}
		return deliverTo;
	}

	public String getDeliveryOtherAddressesReflectedAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reflectedAddress = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reflectedAddress = reqSummary.getDeliveryOtherAddressesReflectedAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryOtherAddressesReflectedAddress " + e, e);
		}
		return reflectedAddress;
	}

	public String getDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ouAddress = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ouAddress = reqSummary.getDeliveryOUAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryOUAddress " + e, e);
		}
		return ouAddress;
	}

	public String getDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reqdate = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			reqdate = reqSummary.getDeliveryRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryRequiredByDate " + e, e);
		}
		return reqdate;
	}

	public String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String sendtoAddress = null;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			sendtoAddress = reqSummary.getSendToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSendToAddress " + e, e);
		}
		return sendtoAddress;
	}

	public boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean sendtoAddress = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			sendtoAddress = reqSummary.selectCostBookingOptionLineItemCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionLineItemCC " + e, e);
		}
		return sendtoAddress;
	}

	public boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionMultipleCC = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			optionMultipleCC = reqSummary.selectCostBookingOptionMultipleCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionMultipleCC " + e, e);
		}
		return optionMultipleCC;
	}

	public boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean optionSingleCC = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			optionSingleCC = reqSummary.selectCostBookingOptionSingleCC(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostBookingOptionSingleCC " + e, e);
		}
		return optionSingleCC;
	}

	public boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean deliveryMyAddress = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			deliveryMyAddress = reqSummary.selectDeliveryMyAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryMyAddress " + e, e);
		}
		return deliveryMyAddress;
	}

	public boolean selectDeliveryOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean otherAddress = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			otherAddress = reqSummary.selectDeliveryOtherAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOtherAddress " + e, e);
		}
		return otherAddress;
	}

	public boolean selectDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean ouAddress = false;
		try
		{
			IModelRequisitionSummary reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummary();
			ouAddress = reqSummary.selectDeliveryOUAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryOUAddress " + e, e);
		}
		return ouAddress;
	}

}