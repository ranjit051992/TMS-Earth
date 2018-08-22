/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author amitkumar.dash
 *
 */
public class IModalPurchaseOrderSummaryBillingImpl implements IModalPurchaseOrderSummaryBilling
{

	static Logger logger = Logger.getLogger(IModalPurchaseOrderSummaryBillingImpl.class);

	@Override
	public String getLocationOfDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliverylocation = ActionBot.getTextWithInElement(driver, DELIVERY_ADDRESS_PO_SUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "location of delivery address");
		return deliverylocation;
	}

	@Override
	public String getLocationOfBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String billLocation = ActionBot.getTextWithInElement(driver, BILL_TO_ADDRESS_PO_SUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "location of bill to address");
		return billLocation;
	}

	@Override
	public String getCurrentLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currentLocation = ActionBot.getTextWithInElement(driver, CURRENT_LOCATION);
		ScreenShot.screenshot(driver, testCaseName, "current location");
		return currentLocation;
	}

	@Override
	public String getOtherLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String otherLocation = ActionBot.getTextWithInElement(driver, OTHER_LOCATION);
		ScreenShot.screenshot(driver, testCaseName, "other location");
		return otherLocation;
	}

	@Override
	public void clickOnButtonOfOtherLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_OF_OTHER_LOCATION);

	}

	@Override
	public boolean isCompanyInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, LABEL_COMPANY_PO_SUMMARY_OU);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("Label") ? true : false;
		return bl;
	}

	@Override
	public boolean isBusinessUnitInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, LABEL_BUSINESS_UNIT_PO_SUMMARY_OU);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("Label") ? true : false;
		return bl;
	}

	@Override
	public boolean isLocationInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, LABEL_LOCATION_PO_SUMMARY_OU);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("Label") ? true : false;
		return bl;
	}

	@Override
	public String fillCompany(WebDriver driver, String testCaseName, String company) throws Exception
	{
		WebElement ele = ActionBot.findElement(driver, OU_COMPANY_PO_SUMMARY);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(company);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String fillBusinessUnit(WebDriver driver, String testCaseName, String bu) throws Exception
	{
		WebElement ele = ActionBot.findElement(driver, OU_BUSINESS_UNIT_PO_SUMMARY);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(bu);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String fillLocation(WebDriver driver, String testCaseName, String location) throws Exception
	{
		WebElement ele = ActionBot.findElement(driver, OU_LOCATION_PO_SUMMARY);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(location);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String getCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Modal Company PO summary");
		String companyName = ActionBot.getAttributeOfElement(driver, OU_COMPANY_PO_SUMMARY, "value");
		logger.info("Company Name : " + companyName);
		return companyName;
	}

	@Override
	public String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String businessUnitName = ActionBot.getAttributeOfElement(driver, OU_BUSINESS_UNIT_PO_SUMMARY, "value");
		logger.info("Business Unit Name : " + businessUnitName);
		return businessUnitName;
	}

	@Override
	public String getLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String locationName = ActionBot.getAttributeOfElement(driver, OU_LOCATION_PO_SUMMARY, "value");
		logger.info("Location Name : " + locationName);
		return locationName;
	}

}
