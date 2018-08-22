package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SuggestNewSupplier;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalSuggestNewSupplier
{

	static Logger logger = Logger.getLogger(ModalSuggestNewSupplier.class);

	public static String fillSupplierNameAtHeader(WebDriver driver, String testcaseName, String suppName) throws ActionBotException
	{
		String supplierName = null;

		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			supplierName = suggestNewSupp.fillSupplierNameAtHeader(driver, testcaseName, suppName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqNoFromMyReq " + e, e);
		}

		return supplierName;
	}

	public static String fillSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException
	{
		String suppName = null;

		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			suppName = suggestNewSupp.fillSupplierName(driver, testcaseName, supplierName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierName " + e, e);
		}

		return suppName;
	}

	public static String fillLocation(WebDriver driver, String testcaseName, String location) throws ActionBotException
	{

		String loc = null;

		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			loc = suggestNewSupp.fillLocation(driver, testcaseName, location);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillLocation " + e, e);
		}

		return loc;
	}

	public static String fillContactPerson(WebDriver driver, String testcaseName, String contactPerson) throws ActionBotException
	{

		String contPerson = null;

		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			contPerson = suggestNewSupp.fillContactPerson(driver, testcaseName, contactPerson);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillContactPerson " + e, e);
		}

		return contPerson;
	}

	public static String fillEmail(WebDriver driver, String testcaseName, String emailAddress) throws ActionBotException
	{

		String email = null;
		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			email = suggestNewSupp.fillEmail(driver, testcaseName, emailAddress);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillEmail " + e, e);
		}

		return email;
	}

	public static int fillPhoneNumber(WebDriver driver, String testcaseName, int phoneNumber) throws ActionBotException
	{
		int phnNo = 0;
		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			phnNo = suggestNewSupp.fillPhoneNumber(driver, testcaseName, phoneNumber);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPhoneNumber " + e, e);
		}

		return phnNo;
	}

	public static String fillOtherDetails(WebDriver driver, String testcaseName, String otherDetails) throws ActionBotException
	{
		String details = null;
		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			details = suggestNewSupp.fillOtherDetails(driver, testcaseName, otherDetails);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOtherDetails " + e, e);
		}

		return details;
	}

	public static void toClickSuggestBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			suggestNewSupp.toClickSuggestBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickSuggestBtn " + e, e);
		}

	}

	public static void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalSuggestNewSupplier suggestNewSupp = FactoryModal.getInstanceOfIModalSuggestNewSupplier();
			suggestNewSupp.toClickCancelBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelBtn " + e, e);
		}

	}

}
