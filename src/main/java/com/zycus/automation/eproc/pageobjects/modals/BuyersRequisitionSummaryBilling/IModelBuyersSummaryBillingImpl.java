package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.IModelRequisitionSummaryBilling;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelBuyersSummaryBillingImpl implements IModelRequisitionSummaryBilling
{

	static Logger logger = Logger.getLogger(IModelBuyersSummaryBillingImpl.class);

	@Override
	public String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, BILLING_BU);
		ele.clear();
		/*
		 * ele.sendKeys(billingBU); ActionBot.defaultSleep();
		 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
		 */

		ActionBot.fillAutoCompleteField(driver, BILLING_BU, billingBU);
		if (ele.getAttribute("value") != null)
		{
			logger.info("Business Unit Name : " + ele.getAttribute("value"));
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException
	{

		{

			WebElement ele = ActionBot.findElement(driver, BILLING_COMPANY);
			ele.clear();
			/*
			 * ele.sendKeys(billingCompany); ele.sendKeys(Keys.ARROW_DOWN);
			 * ele.sendKeys(Keys.ENTER);
			 */

			ActionBot.fillAutoCompleteField(driver, BILLING_COMPANY, billingCompany);
			if (ele.getAttribute("value") != null)
			{
				logger.info("Company Name : " + ele.getAttribute("value"));
				return ele.getAttribute("value");
			}
			else
			{
				return null;
			}
		}

	}

	@Override
	public String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, BILLING_CURRENCY);
		ele.clear();
		ele.sendKeys(billingCurrency);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			logger.info("Billing Currency Name : " + ele.getAttribute("value"));
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, BILLING_LOCATION);
		ele.clear();
		/*
		 * ele.sendKeys(billingLocation); ele.sendKeys(Keys.ARROW_DOWN);
		 * ele.sendKeys(Keys.ENTER);
		 */
		ActionBot.fillAutoCompleteField(driver, BILLING_LOCATION, billingLocation);
		if (ele.getAttribute("value") != null)
		{
			logger.info("Location Name : " + ele.getAttribute("value"));
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
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
		ScreenShot.screenshot(driver, testCaseName, "Billing Company Name");
		return billingCompany;
	}

	@Override
	public String getBillingBU(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billingBU = ActionBot.findElement(driver, BILLING_BU).getAttribute("value").trim();
		logger.info("Billing BU Name : " + billingBU);
		ScreenShot.screenshot(driver, testCaseName, "Billing BU Name");
		return billingBU;
	}

	@Override
	public String getBillingLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billingLocation = ActionBot.findElement(driver, BILLING_LOCATION).getAttribute("value").trim();
		logger.info("Billing Location Name : " + billingLocation);
		ScreenShot.screenshot(driver, testCaseName, "Billing Location Name");
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
		// TODO Auto-generated method stub

	}

}
