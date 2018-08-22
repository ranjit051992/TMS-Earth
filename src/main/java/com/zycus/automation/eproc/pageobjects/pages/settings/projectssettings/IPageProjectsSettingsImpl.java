package com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.IPageBuyersDeskSettingsImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPageProjectsSettingsImpl implements IPageProjectsSettings
{

	@Override
	public boolean clickOnAlways(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_ALWAYS_PROJECT_SETTINGS);
		if (ActionBot.isElementSelected(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_ALWAYS_PROJECT_SETTINGS))
		{
			return true;
		}
		else
		{
			return false;

		}
	}

	@Override
	public boolean clickOnNever(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_NEVER_PROJECT_SETTINGS);
		ActionBot.defaultSleep();
		if (ActionBot.isElementSelected(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_NEVER_PROJECT_SETTINGS))
		{
			return true;
		}
		else
		{
			return false;

		}
	}

	@Override
	public boolean clickOnLetUsersDecide(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_LET_USERS_DECIDE_PROJECT_SETTINGS);

		if (ActionBot.isElementSelected(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_LET_USERS_DECIDE_PROJECT_SETTINGS))
		{
			return true;
		}
		else
		{
			return false;

		}

	}

	@Override
	public String getAssignProjectToPurchaseCost(WebDriver driver) throws ActionBotException
	{
		String assignProjectToPurchaseCost;
		if (ActionBot.isElementSelected(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_ALWAYS_PROJECT_SETTINGS))
		{
			assignProjectToPurchaseCost = ALWAYS;
		}
		else if (ActionBot.isElementSelected(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_NEVER_PROJECT_SETTINGS))
		{
			assignProjectToPurchaseCost = NEVER;
		}
		else
		{
			assignProjectToPurchaseCost = LET_USERS_DECIDE;
		}

		return assignProjectToPurchaseCost;
	}

	@Override
	public boolean clickOnSave(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, SAVE_PROJECT_SETTINGS);
		if (ActionBot.isElementPresent(driver, IPageBuyersDeskSettingsImpl.BUYERS_DESK_SETTING_SUCCESS_MSG))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String checked = ActionBot.findElement(driver, PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_NO_LINK).getAttribute("checked");
		if (checked != null && "checked".equals(checked))
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean isYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String checked = ActionBot.findElement(driver, PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_YES_LINK).getAttribute("checked");
		if (checked != null && "checked".equals(checked))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isNoSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String checked = ActionBot.findElement(driver, PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_NO_LINK).getAttribute("checked");
		if (checked != null && "checked".equals(checked))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean assignProjectSettingEnabledOrDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String className = ActionBot.findElement(driver, PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_LETS_USER_DECIDE_LINK).getAttribute("class");
		if (className.contains("disableMe"))
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean clickOnDisplayAssetCodeForAssigningCodeToItem_Yes(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_YES);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_YES);

	}

	@Override
	public boolean clickOnDisplayAssetCodeForAssigningCodeToItem_No(WebDriver driver) throws ActionBotException
	{

		ActionBot.click(driver, RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_NO);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_NO);

	}

}
