package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsamountfilter;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalAllRequestsAmountFilter
{

	UI_Elements	FROM_AMOUNT_RANGE		= UIFactory.getElements("FROM_AMOUNT_RANGE");
	UI_Elements	TO_AMOUNT_RANGE			= UIFactory.getElements("TO_AMOUNT_RANGE");
	UI_Elements	AMOUNT_FILTER_BUTTON	= UIFactory.getElements("AMOUNT_FILTER_BUTTON");
	UI_Elements	AMOUNT_CANCEL_BUTTON	= UIFactory.getElements("AMOUNT_CANCEL_BUTTON");
	UI_Elements	AMOUNT_CLEAR_BUTTON		= UIFactory.getElements("AMOUNT_CLEAR_BUTTON");
	UI_Elements	SELECT_ALL_CURRENCIES	= UIFactory.getElements("SELECT_ALL_CURRENCIES");

	public double fillFromAmountRange(WebDriver driver, String testCaseName, double fromAmountRange) throws ActionBotException;

	public double fillToAmountRange(WebDriver driver, String testCaseName, double toAmountRange) throws ActionBotException;

	public double getFromAmountRange(WebDriver driver, String testCaseName) throws ActionBotException;

	public double getToAmountRange(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> selectAllCurrencies(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
