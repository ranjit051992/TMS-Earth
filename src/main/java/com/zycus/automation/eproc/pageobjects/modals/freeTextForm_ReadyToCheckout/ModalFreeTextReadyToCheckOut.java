package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ReadyToCheckout;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalFreeTextReadyToCheckOut
{

	static Logger logger = Logger.getLogger(ModalFreeTextReadyToCheckOut.class);

	public static void toClickCheckoutBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			readyToCheckOut.toClickCheckoutBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCheckoutBtn " + e, e);
		}

	}

	public static void toClickAddAnotherItemBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			readyToCheckOut.toClickAddAnotherItemBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickAddAnotherItemBtn " + e, e);
		}

	}

	public static void toClickViewItemsInCartLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			readyToCheckOut.toClickViewItemsInCartLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickViewItemsInCartLink " + e, e);
		}

	}

	public static String getItemName(WebDriver driver, String testcaseName) throws ActionBotException
	{

		String guidedItemName = null;
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			guidedItemName = readyToCheckOut.getItemName(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickViewItemsInCartLink " + e, e);
		}

		return guidedItemName;
	}

	public static String getItemAmountAndCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String guidedItemAmount = null;
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			guidedItemAmount = readyToCheckOut.getItemAmountAndCurrency(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemAmountAndCurrency " + e, e);
		}

		return guidedItemAmount;
	}

	public static String getCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String guidedCategory = null;
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			guidedCategory = readyToCheckOut.getCategory(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCategory " + e, e);
		}

		return guidedCategory;
	}

	public static String getSPSCCode(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String guidedSPSCCode = null;
		try
		{
			IModalFreeTextReadyToCheckOut readyToCheckOut = FactoryModal.getInstanceOfIModalFreeTextReadyToCheckOut();
			guidedSPSCCode = readyToCheckOut.getSPSCCode(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSPSCCode " + e, e);
		}

		return guidedSPSCCode;
	}

}
