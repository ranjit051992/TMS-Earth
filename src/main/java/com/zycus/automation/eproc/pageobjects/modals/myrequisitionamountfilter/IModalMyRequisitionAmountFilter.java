package com.zycus.automation.eproc.pageobjects.modals.myrequisitionamountfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalMyRequisitionAmountFilter
{

	final static UI_Elements	FROM_AMOUNT					= UIFactory.getElements("FROM_AMOUNT");
	final static UI_Elements	TO_AMOUNT					= UIFactory.getElements("TO_AMOUNT");
	final static UI_Elements	CURRENCY_INR				= UIFactory.getElements("CURRENCY_INR");
	final static UI_Elements	CURRENCY_USD				= UIFactory.getElements("CURRENCY_USD");
	final static UI_Elements	CLEAR_FILTER				= UIFactory.getElements("CLEAR_FILTER");
	final static UI_Elements	FILTER_BTN_AMOUNT_FILTER	= UIFactory.getElements("FILTER_BTN_AMOUNT_FILTER");
	final static UI_Elements	CANCEL_BTN_AMOUNT_FILTER	= UIFactory.getElements("CANCEL_BTN_AMOUNT_FILTER");

	int fillFromAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException;

	int fillToAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException;

	boolean checkINRCurrency(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean checkUSDCurrency(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickClearFilter(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

}
