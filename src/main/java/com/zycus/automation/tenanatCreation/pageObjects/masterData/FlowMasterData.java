package com.zycus.automation.tenanatCreation.pageObjects.masterData;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.FlowAdminConfiguration;

public class FlowMasterData
{
	static Logger logger = Logger.getLogger(FlowAdminConfiguration.class);

	public static void selectAllCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllCurrency " + e, e);
		}
	}

	public static void selectAllExchangeRates(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllExchangeRates(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllExchangeRates" + e, e);
		}
	}

	public static void selectAllUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllUOM(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllUOM" + e, e);
		}
	}

	public static void selectAllCountries(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllCountries(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllCountries" + e, e);
		}
	}

	public static void selectAllStates(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllStates(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllStates" + e, e);
		}
	}

	public static void selectAllDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.selectAllDeliveryTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllDeliveryTerms" + e, e);
		}
	}

	public static void uploadPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadPaymentTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadPaymentTerms" + e, e);
		}
	}

	public static void uploadCatagories(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadCatagories(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadCatagories" + e, e);
		}
	}

	public static void createOrganizationUnits(WebDriver driver, String testCaseName, String organizationUnitName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.createOrganizationUnits(driver, testCaseName, organizationUnitName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method createOrganizationUnits" + e, e);
		}
	}

	public static void createProcurementScopeConfiguration(WebDriver driver, String testCaseName, String procurementScopeConfigurationName) throws ActionBotException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.createProcurementScopeConfiguration(driver, testCaseName, procurementScopeConfigurationName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method createProcurementScopeConfiguration" + e, e);
		}
	}

	public static void uploadRegions(WebDriver driver, String testCaseName ) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadRegions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadRegions" + e, e);
		}
	}

	public static void uploadAddresses(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadAddresses(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadAddresses" + e, e);
		}
	}

	public static void uploadLocations(WebDriver driver, String testCaseName ) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadLocations(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadLocations" + e, e);
		}
	}

	public static void uploadDepartment(WebDriver driver, String testCaseName ) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadDepartment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadDepartment" + e, e);
		}
	}

	public static void uploadCostCenters(WebDriver driver, String testCaseName ) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadCostCenters(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadCostCenters" + e, e);
		}
	}

	public static void uploadWorkOrder(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		try
		{
			MasterDataImpl masterDataObj = FactoryPage.getInstanceOf(MasterDataImpl.class);
			masterDataObj.uploadWorkOrder(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method uploadWorkOrder" + e, e);
		}
	}

}
