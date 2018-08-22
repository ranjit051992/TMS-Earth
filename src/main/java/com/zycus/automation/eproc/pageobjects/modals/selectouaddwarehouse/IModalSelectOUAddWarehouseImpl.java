package com.zycus.automation.eproc.pageobjects.modals.selectouaddwarehouse;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * 
 * @author t.amarnath
 *
 */
public class IModalSelectOUAddWarehouseImpl implements IModalSelectOUAddWarehouse
{

	@Override
	public void clickOnCompanyTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, COMPANY_TAB_SELECT_OU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUSINESS_UNITS_SELECT_OU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnFirstCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_OU_1ST_COMPANY_SELECT_OU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSecondCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_OU_2ND_COMPANY_SELECT_OU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnSelectOUInBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_OU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnFirstBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_1ST_BU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnSecondBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_2ND_BU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnThirdBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_3RD_BU_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSaveSelectedUnitsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_UNITS_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_SCOPE_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_CANCEL_SELECTED_SCOPE_ADD_WAREHOUSE);
		ActionBot.defaultSleep();
	}

}
