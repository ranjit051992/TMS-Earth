package com.zycus.automation.eproc.pageobjects.modals.changeCurrencyPurchaseOrder;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalChangeCurrencyPOImpl implements IModalChangeCurrencyPO
{

	@Override
	public void clickOnConvertAmountsToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONVERT_AMOUNTS_TO_CURRENCY_TYPE))
		{
			ActionBot.click(driver, BUTTON_CONVERT_AMOUNTS_TO_CURRENCY_TYPE);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on convert amount to currency type");
		}

	}

	@Override
	public void clickOnOnlyChangeCurrencyToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ONLY_CHANGE_CURRENCY_TO_CURRENCY_TYPE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on only change currency to currency type");

	}

	@Override
	public void clickOnCancelChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CHANGE_CURRENCY);
		ScreenShot.screenshot(driver, testCaseName, "Afetr clicking on cancel currency change");

	}

}
