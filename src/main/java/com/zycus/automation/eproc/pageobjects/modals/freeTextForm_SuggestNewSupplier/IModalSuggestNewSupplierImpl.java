package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SuggestNewSupplier;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalSuggestNewSupplierImpl extends IModalSuggestNewSupplierUtil implements IModalSuggestNewSupplier
{

	static Logger logger = Logger.getLogger(IModalSuggestNewSupplierImpl.class);

	@Override
	public String fillSupplierNameAtHeader(WebDriver driver, String testcaseName, String suppName) throws ActionBotException
	{
		String supplierName = "";
		if (suppName != null)
		{
			WebElement element = ActionBot.findElement(driver, ENTER_SUPPLIER_NAME_FIELD);
			ActionBot.sendKeys(driver, ENTER_SUPPLIER_NAME_FIELD, suppName);
			ActionBot.defaultSleep();
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
			ActionBot.defaultSleep();
			supplierName = ActionBot.findElement(driver, ENTER_SUPPLIER_NAME_FIELD).getAttribute("value");
			return supplierName;

		}
		else
		{
			WebElement element = ActionBot.findElement(driver, ENTER_SUPPLIER_NAME_FIELD);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
			ActionBot.defaultSleep();
			supplierName = ActionBot.findElement(driver, ENTER_SUPPLIER_NAME_FIELD).getAttribute("value");
			return supplierName;
		}
	}

	@Override
	public String fillLocation(WebDriver driver, String testcaseName, String location) throws ActionBotException
	{
		ActionBot.sendKeys(driver, LOCATION, location);
		String suggestedSuppLocation = ActionBot.findElement(driver, LOCATION).getAttribute("value");
		logger.info("Location is : " + suggestedSuppLocation);
		return suggestedSuppLocation;
	}

	@Override
	public String fillContactPerson(WebDriver driver, String testcaseName, String contactPerson) throws ActionBotException
	{
		ActionBot.sendKeys(driver, CONTACT_PERSON, contactPerson);
		String enteredContactPerson = ActionBot.findElement(driver, CONTACT_PERSON).getAttribute("value");
		logger.info("Contact Person is : " + enteredContactPerson);
		return enteredContactPerson;
	}

	@Override
	public String fillEmail(WebDriver driver, String testcaseName, String emailAddress) throws ActionBotException
	{
		ActionBot.sendKeys(driver, EMAIL, emailAddress);
		String enteredEmail = ActionBot.findElement(driver, EMAIL).getAttribute("value");
		logger.info("Email Address is : " + enteredEmail);
		return enteredEmail;
	}

	@Override
	public int fillPhoneNumber(WebDriver driver, String testcaseName, int phoneNumber) throws ActionBotException
	{
		String phnNumber = String.valueOf(phoneNumber);
		ActionBot.sendKeys(driver, PHONE, phnNumber);
		String enteredPhoneNo = ActionBot.findElement(driver, PHONE).getAttribute("value");
		logger.info("Phone Number is : " + enteredPhoneNo);
		int phNumber = Integer.parseInt(enteredPhoneNo);
		return phNumber;
	}

	@Override
	public String fillOtherDetails(WebDriver driver, String testcaseName, String otherDetails) throws ActionBotException
	{
		ActionBot.sendKeys(driver, OTHER_DETAILS, otherDetails);
		String enteredDetails = ActionBot.findElement(driver, OTHER_DETAILS).getAttribute("value");
		logger.info("Other Details entered are : " + enteredDetails);
		return enteredDetails;
	}

	@Override
	public void toClickSuggestBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUGGEST_BTN);
		ScreenShot.screenshot(driver, testcaseName, "After filling suggest supplier data");
	}

	@Override
	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BTN);
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, SUPPLIER_NAME, supplierName);
		String suppName = ActionBot.findElement(driver, SUPPLIER_NAME).getAttribute("value");
		logger.info("Supplier Name entered is : " + suppName);
		return suppName;
	}

}
