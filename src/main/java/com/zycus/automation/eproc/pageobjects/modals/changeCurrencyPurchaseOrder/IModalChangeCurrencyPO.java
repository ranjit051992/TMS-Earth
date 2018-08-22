package com.zycus.automation.eproc.pageobjects.modals.changeCurrencyPurchaseOrder;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalChangeCurrencyPO
{
	final static UI_Elements	BUTTON_CONVERT_AMOUNTS_TO_CURRENCY_TYPE			= UIFactory.getElements("BUTTON_CONVERT_AMOUNTS_TO_CURRENCY_TYPE");
	final static UI_Elements	BUTTON_ONLY_CHANGE_CURRENCY_TO_CURRENCY_TYPE	= UIFactory.getElements("BUTTON_ONLY_CHANGE_CURRENCY_TO_CURRENCY_TYPE");
	final static UI_Elements	BUTTON_CANCEL_CHANGE_CURRENCY					= UIFactory.getElements("BUTTON_CANCEL_CHANGE_CURRENCY");

	public void clickOnConvertAmountsToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOnlyChangeCurrencyToCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

}
