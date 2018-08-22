package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelRequisitionSummaryBilling
{
	final static UI_Elements	BILLING_CURRENCY		= UIFactory.getElements("BILLING_CURRENCY");
	final static UI_Elements	BILLING_COMPANY			= UIFactory.getElements("BILLING_COMPANY");
	final static UI_Elements	BILLING_BU				= UIFactory.getElements("BILLING_BU");
	final static UI_Elements	BILLING_LOCATION		= UIFactory.getElements("BILLING_LOCATION");
	final static UI_Elements	BILLING_BILL_TO_ADDRESS	= UIFactory.getElements("BILLING_BILL_TO_ADDRESS");
	final static UI_Elements	BILLING_SEND_TO_ADDRESS	= UIFactory.getElements("BILLING_SEND_TO_ADDRESS");
	final static UI_Elements	SAVEREQSUMMARY			= UIFactory.getElements("SAVEREQSUMMARY");
	final static UI_Elements	CANCLEREQSUMMARY		= UIFactory.getElements("CANCLEREQSUMMARY");

	String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException;

	String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException;

	String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException;

	String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException;

	String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBillingCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBillingBU(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBillingLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearBU(WebDriver driver, String testCaseName) throws ActionBotException;

}
