package com.zycus.automation.tenanatCreation.businessFlows;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.MasterDataCmd;
import com.zycus.automation.tenanatCreation.pageObjects.masterData.FlowMasterData;
import com.zycus.automation.tenanatCreation.pageObjects.masterData.MasterDataImpl;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.objectCreation.DefaultObjectCreation;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class MasterDataFlow
{
	public static MasterDataCmd fillMasterDataCMD(WebDriver driver, String testCaseName) throws Exception
	{
		MasterDataCmd masterData = DefaultObjectCreation.getMasterdataForCMD();
		ActionBot.click(driver, MasterDataImpl.TAB_MASTER_DATA);
		ActionBot.waitForElementToBeDisplayed(driver, MasterDataImpl.LINK_CURRENCY, ActionBot.timeOut);

		if (masterData.getCurrency() != null)
		{
			if (masterData.getCurrency().equalsIgnoreCase("Yes"))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_CURRENCY);
				ActionBot.defaultSleep();
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA);
					if (ActionBot.isElementEnabled(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA);
					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA);
						ActionBot.defaultSleep();

					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
						ActionBot.defaultLowSleep();

					}
				}
			}
		}
		if (masterData.getExchangeRates() != null)
		{
			if (masterData.getExchangeRates().equalsIgnoreCase("Yes"))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_EXCHANGE_RATES);
				ActionBot.defaultSleep();
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA);
					if (ActionBot.isElementEnabled(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA);
					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA);
						ActionBot.defaultLowSleep();
					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
						ActionBot.defaultLowSleep();
					}
				}
			}
		}
		if (masterData.getCountries() != null)
		{
			if (masterData.getCountries().equalsIgnoreCase("Yes"))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_COUNTRIES);
				ActionBot.defaultSleep();
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA);
					if (ActionBot.isElementEnabled(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA);
					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA);
						ActionBot.defaultLowSleep();

					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
						ActionBot.defaultLowSleep();

					}
				}
			}
		}
		if (masterData.getDeliveryTerms() != null)
		{
			if (masterData.getDeliveryTerms().equalsIgnoreCase("Yes"))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_DELIVERY_TERMS);
				ActionBot.defaultSleep();
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.CHECKBOX_ALL_MASTER_DATA);
					if (ActionBot.isElementEnabled(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.ACTIVATE_LINK_MASTER_DATA);
					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.BUTTON_POPUP_YES_MASTER_DATA);
						ActionBot.defaultLowSleep();

					}
					if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
					{
						ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
						ActionBot.defaultLowSleep();

					}
				}
			}

		}
		if (masterData.getOrganizationUnits() != null)
		{
			if (masterData.getOrganizationUnits().equalsIgnoreCase("Yes"))
			{

				ActionBot.click(driver, MasterDataImpl.LINK_ORGANIZATION_UNITS);
				ActionBot.click(driver, MasterDataImpl.LINK_ADD_OU_LEVEL);
				Map<String, String> oulevels = ExcelReader.getTestDataComboFromFileXlsx("masterDataCmdFile", "OULevel");
				Set<String> keys = oulevels.keySet();
				for (String currentKey : keys)
				{
					ActionBot.sendKeys(driver, MasterDataImpl.TEXTBOX_OU_NAME_LEVEL, oulevels.get(currentKey));
					ActionBot.click(driver, MasterDataImpl.BUTTON_ADD_LEVEL);
				}
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
					ActionBot.defaultLowSleep();

				}
			}

		}
		if (masterData.getProcurementScopeConfig() != null)
		{
			if (masterData.getProcurementScopeConfig().equalsIgnoreCase("Yes"))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_PROCUREMENT_SCOPE_CONFIGURATION);
				Map<String, String> procurementScope = ExcelReader.getTestDataComboFromFileXlsx("masterDataCmdFile", "procurementScopeLevel");
				Set<String> keys = procurementScope.keySet();
				for (String currentKey : keys)
				{
					ActionBot.click(driver, MasterDataImpl.LINK_ADD_NEW_SCOPE);
					ActionBot.defaultSleep();
					if (currentKey.toLowerCase().trim().contains("admin"))
					{
						Select sel = new Select(driver.findElement(By.xpath(MasterDataImpl.DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE.getValue())));
						sel.selectByValue("ADMIN_SCOPE");
					}
					if (currentKey.toLowerCase().trim().contains("receiving"))
					{
						Select sel = new Select(driver.findElement(By.xpath(MasterDataImpl.DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE.getValue())));
						sel.selectByValue("RECEIVING_SCOPE");
					}
					if (currentKey.toLowerCase().trim().contains("requesting"))
					{
						Select sel = new Select(driver.findElement(By.xpath(MasterDataImpl.DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE.getValue())));
						sel.selectByValue("REQUESTING_SCOPE");
					}
					if (currentKey.toLowerCase().trim().contains("reporting"))
					{
						Select sel = new Select(driver.findElement(By.xpath(MasterDataImpl.DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE.getValue())));
						sel.selectByValue("REPORTING_SCOPE");
					}
					String orgEntity = procurementScope.get(currentKey);
					if (orgEntity.toLowerCase().trim().contains("region"))
					{
						ActionBot.click(driver, MasterDataImpl.CHECKBOX_REGION_SCOPE_BUSINESS_SCOPE);
					}
					if (orgEntity.toLowerCase().trim().contains("organization"))
					{
						ActionBot.click(driver, MasterDataImpl.CHECKBOX_ORGANIZATION_STRUCTURE_BUSINESS_SCOPE);
					}
					if (orgEntity.toLowerCase().trim().contains("location"))
					{
						ActionBot.click(driver, MasterDataImpl.CHECKBOX_LOCATION_STRUCTURE_BUSINESS_SCOPE);
					}
					if (orgEntity.toLowerCase().trim().contains("cost"))
					{
						ActionBot.click(driver, MasterDataImpl.CHECKBOX_COST_CENTER_STRUCTURE_BUSINESS_SCOPE);
					}
					ActionBot.click(driver, MasterDataImpl.BUTTON_ADD_BUSINESS_SCOPE);
					ActionBot.defaultSleep();
				}
				if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
				{
					ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
					ActionBot.defaultLowSleep();
				}
			}
		}

		if (masterData.getPaymentTerms() != null)
		{
			if (masterData.getPaymentTerms().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.PaymentTerms);
			}
		}
		if (masterData.getCatagories() != null)
		{
			if (masterData.getCatagories().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.Catagories);
			}
		}
		if (masterData.getRegions() != null)
		{
			if (masterData.getRegions().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.Regions);
			}
		}
		if (masterData.getAddress() != null)
		{
			if (masterData.getAddress().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.Address);
			}
		}
		if (masterData.getLocations() != null)
		{
			if (masterData.getLocations().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.Locations);
			}
		}
		if (masterData.getDepartments() != null)
		{
			if (masterData.getDepartments().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.Departments);
			}
		}
		if (masterData.getCostCenters() != null)
		{
			if (masterData.getCostCenters().equalsIgnoreCase("yes"))
			{
				uploadMasterDataFiles(driver, testCaseName, IConstantData.CostCenters);
			}
		}
		return masterData;
	}

	public static void uploadMasterDataFiles(WebDriver driver, String testCaseName, String master) throws ActionBotException, IOException
	{
		if (master.equalsIgnoreCase(IConstantData.PaymentTerms))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_PAYMENT_TERMS);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadPaymentTerms(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();
			}
		}
		if (master.equalsIgnoreCase(IConstantData.Catagories))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_CATEGORIES);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadCatagories(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();
			}
		}
		if (master.equalsIgnoreCase(IConstantData.Regions))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_REGIONS);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadRegions(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();
			}
		}
		if (master.equalsIgnoreCase(IConstantData.Address))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_ADDRESSES);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadAddresses(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();

			}
		}
		if (master.equalsIgnoreCase(IConstantData.Locations))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_LOCATIONS);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadLocations(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();

			}
		}
		if (master.equalsIgnoreCase(IConstantData.Departments))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_DEPARTMENTS);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadDepartment(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();

			}
		}
		if (master.equalsIgnoreCase(IConstantData.CostCenters))
		{
			ActionBot.click(driver, MasterDataImpl.LINK_COST_CENTERS);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, MasterDataImpl.BUTTON_FILE_UPLOAD);
			FlowMasterData.uploadCostCenters(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA))
			{
				ActionBot.click(driver, MasterDataImpl.LINK_BACK_TO_SUMMARY_MASTER_DATA);
				ActionBot.defaultLowSleep();
			}
		}
	}

	public void fillCMDMasterData(WebDriver driver, String testCaseName, MasterDataCmd masterDataCmd) throws Exception
	{
		MasterDataCmd dataCmd = fillMasterDataCMD(driver, testCaseName);
		if (dataCmd.getPaymentTerms().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.PaymentTerms);
		}
		if (dataCmd.getCatagories().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.Catagories);
		}
		if (dataCmd.getRegions().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.Regions);
		}
		if (dataCmd.getAddress().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.Address);
		}
		if (dataCmd.getLocations().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.Locations);
		}
		if (dataCmd.getDepartments().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.Departments);
		}
		if (dataCmd.getCostCenters().equalsIgnoreCase("yes"))
		{
			uploadMasterDataFiles(driver, testCaseName, IConstantData.CostCenters);
		}

	}

}
