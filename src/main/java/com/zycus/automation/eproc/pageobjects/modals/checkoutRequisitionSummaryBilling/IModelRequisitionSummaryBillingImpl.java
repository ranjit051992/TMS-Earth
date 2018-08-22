package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelRequisitionSummaryBillingImpl implements IModelRequisitionSummaryBilling
{

	static Logger logger = Logger.getLogger(IModelRequisitionSummaryBillingImpl.class);

	@Override
	public String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException
	{
		String selectedBU = ActionBot.fillAutoCompleteField(driver, BILLING_BU, billingBU);
		logger.info("Business Unit Name : " + selectedBU);
		return selectedBU;

	}

	@Override
	public String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException
	{
		String selectedCompany = ActionBot.fillAutoCompleteField(driver, BILLING_COMPANY, billingCompany);
		logger.info("Company Name : " + selectedCompany);
		return selectedCompany;
	}

	@Override
	public String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException
	{
		String selectedCurrency = ActionBot.fillAutoCompleteField(driver, BILLING_CURRENCY, billingCurrency);
		logger.info("Billing Currency Name : " + selectedCurrency);
		return selectedCurrency;
	}

	@Override
	public String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException
	{
		String selectedLocation = ActionBot.fillAutoCompleteField(driver, BILLING_LOCATION, billingLocation);
		logger.info("Location Name : " + selectedLocation);
		return selectedLocation;
	}

	@Override
	public String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billToAddress = ActionBot.findElement(driver, BILLING_BILL_TO_ADDRESS).getText();
		logger.info("Bill To Address : " + billToAddress);
		if (billToAddress != null)
		{
			return billToAddress;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sendToAddress = ActionBot.findElement(driver, BILLING_SEND_TO_ADDRESS).getText();
		logger.info("Send To Address : " + sendToAddress);
		if (sendToAddress != null)
		{
			return sendToAddress;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqCurrency = ActionBot.findElement(driver, BILLING_CURRENCY).getAttribute("value").trim();
		logger.info("Requisition Currency : " + reqCurrency);
		ScreenShot.screenshot(driver, testCaseName, "Requisition Currency");
		return reqCurrency;
	}

	@Override
	public String getBillingCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingCompany = ActionBot.findElement(driver, BILLING_COMPANY).getAttribute("value").trim();
		logger.info("Billing Company Name : " + billingCompany);
		// ScreenShot.screenshot(driver, testCaseName, "Billing Company Name");
		return billingCompany;
	}

	@Override
	public String getBillingBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingBU = ActionBot.findElement(driver, BILLING_BU).getAttribute("value").trim();
		logger.info("Billing BU Name : " + billingBU);
		// ScreenShot.screenshot(driver, testCaseName, "Billing BU Name");
		return billingBU;
	}

	@Override
	public String getBillingLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billingLocation = ActionBot.findElement(driver, BILLING_LOCATION).getAttribute("value").trim();
		logger.info("Billing Location Name : " + billingLocation);
		// ScreenShot.screenshot(driver, testCaseName, "Billing Location Name");
		return billingLocation;
	}

	@Override
	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SAVEREQSUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on SAVE Button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCLEREQSUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on CANCEL Button");
	}

	@Override
	public void clearBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, BILLING_BU);
	}

}
