package com.zycus.automation.tenanatCreation.pageObjects.masterData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class MasterDataImpl implements MasterData
{

	@Override
	public void selectAllCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CURRENCY);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}
	}

	@Override
	public void selectAllExchangeRates(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXCHANGE_RATES);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}

	}

	@Override
	public void selectAllUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UNIT_OF_MEASURE);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}

	}

	@Override
	public void selectAllCountries(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COUNTRIES);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}

	}

	@Override
	public void selectAllStates(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_STATE);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}

	}

	@Override
	public void selectAllDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELIVERY_TERMS);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_BACK_TO_SUMMARY_MASTER_DATA, ActionBot.timeOut);
		if (ActionBot.isElementEnabled(driver, CHECKBOX_ALL_MASTER_DATA))
		{
			ActionBot.click(driver, CHECKBOX_ALL_MASTER_DATA);
			ActionBot.click(driver, ACTIVATE_LINK_MASTER_DATA);

			if (ActionBot.isElementDisplayed(driver, BUTTON_POPUP_YES_MASTER_DATA))
			{
				ActionBot.click(driver, BUTTON_POPUP_YES_MASTER_DATA);
				ActionBot.defaultLowSleep();
				ActionBot.defaultLowSleep();
			}
		}
	}

	@Override
	public void uploadPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\payment_terms.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadCatagories(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{

		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\categories.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();
	}

	@Override
	public void createOrganizationUnits(WebDriver driver, String testCaseName, String organizationUnitName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_OU_NAME_LEVEL, organizationUnitName);
		ActionBot.click(driver, BUTTON_ADD_LEVEL);
		ActionBot.defaultSleep();
	}

	@Override
	public void createProcurementScopeConfiguration(WebDriver driver, String testCaseName, String procurementScopeConfigurationName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_BUSINESS_SCOPE);
		ActionBot.waitForElementToBeDisplayed(driver, DROPDOWN_SCOPE_NAME_BUSINESS_SCOPE, ActionBot.timeOut);
		
	}

	@Override
	public void uploadRegions(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\regions.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadAddresses(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\addresses.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadLocations(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\locations.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadDepartment(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\departments.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadCostCenters(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\cost_centers.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadWorkOrder(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\workorder.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();

	}

	@Override
	public void uploadDesignation(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		ActionBot.click(driver, BUTTON_BROWSE_CMD);
		Runtime.getRuntime().exec("D:\\AutoItFiles\\language_translation_designations.exe");
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPLOAD_CMD_FILE);
		ActionBot.defaultSleep();
		
	}

}
