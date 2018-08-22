package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsreceivedonfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalAllRequestsApprovalReceivedOnFilter
{

	UI_Elements	FROM_DATE_TEXT_FIELD		= UIFactory.getElements("FROM_DATE_TEXT_FIELD");
	UI_Elements	TO_DATE_TEXT_FIELD			= UIFactory.getElements("TO_DATE_TEXT_FIELD");
	UI_Elements	FROM_DATE_PICKER			= UIFactory.getElements("FROM_DATE_PICKER");
	UI_Elements	TO_DATE_PICKER				= UIFactory.getElements("TO_DATE_PICKER");
	UI_Elements	SELECT_DATE_MONTH			= UIFactory.getElements("SELECT_DATE_MONTH");
	UI_Elements	SELECT_DATE_YEAR			= UIFactory.getElements("SELECT_DATE_YEAR");
	UI_Elements	RECEIVED_ON_FILTER_BUTTON	= UIFactory.getElements("RECEIVED_ON_FILTER_BUTTON");
	UI_Elements	RECEIVED_ON_CANCEL_BUTTON	= UIFactory.getElements("RECEIVED_ON_CANCEL_BUTTON");
	UI_Elements	RECEIVED_ON_CLEAR_BUTTON	= UIFactory.getElements("RECEIVED_ON_CLEAR_BUTTON");

	public void clickOnFromDatePicker(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnToDatePicker(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFromDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectToDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getToDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceivedOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceivedOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceivedOnClearButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
