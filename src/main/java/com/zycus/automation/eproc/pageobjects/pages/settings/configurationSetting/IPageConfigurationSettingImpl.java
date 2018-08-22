package com.zycus.automation.eproc.pageobjects.pages.settings.configurationSetting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageConfigurationSettingImpl implements IPageConfigurationSetting
{

	@Override
	public void clickOnCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COMPANY);

	}

	@Override
	public String selectCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_COMPANY_NAME));
		select.selectByVisibleText(companyName);
		ScreenShot.screenshot(driver, testCaseName, "After selecting company name");

		String company = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return company;
	}

	@Override
	public String enterDefaultBuyerForCompany(WebDriver driver, String testCaseName, String defaultBuyer) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DEFAULT_BUYER_FOR_AUTO_COMPANY);
		ele.clear();
		ele.sendKeys(defaultBuyer);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String buyer = ele.getAttribute("value").trim();
		return buyer;
	}

	@Override
	public void clickOnUpdateCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPDATE_COMPANY);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BUSSINESS_UNIT);

	}

	@Override
	public String selectCompanyForBU(WebDriver driver, String testCaseName, String companyForBU) throws ActionBotException
	{

		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_SELECT_COMPANY_BU));
		select.selectByVisibleText(companyForBU);
		ScreenShot.screenshot(driver, testCaseName, "After selecting company name for BU");

		String company = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return company;
	}

	@Override
	public String selectBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException
	{
		ActionBot.defaultSleep();
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_SELECT_BUSINESS_UNIT));
		select.selectByVisibleText(BU);
		ScreenShot.screenshot(driver, testCaseName, "After selecting BU");

		String business_unit = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return business_unit;
	}

	@Override
	public String enterDefaultBuyerForBU(WebDriver driver, String testCaseName, String BUBuyer) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DEFAULT_BUYER_FOR_AUTO_BU);
		ele.clear();
		ele.sendKeys(BUBuyer);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String buyer = ele.getAttribute("value").trim();
		return buyer;
	}

	@Override
	public void clickOnUpdateBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPDATE_BU);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_LOCATION);

	}

	@Override
	public String selectCompanyForLocation(WebDriver driver, String testCaseName, String companyForLocation) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_LOCATION_COMPANY));
		select.selectByVisibleText(companyForLocation);
		ScreenShot.screenshot(driver, testCaseName, "After selecting company name for location");

		String company = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return company;
	}

	@Override
	public String selectBUForLocation(WebDriver driver, String testCaseName, String BUForLocation) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_LOCATION_BU));
		select.selectByVisibleText(BUForLocation);
		ScreenShot.screenshot(driver, testCaseName, "After selecting BU for location");

		String business_unit = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return business_unit;
	}

	@Override
	public String selectLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_LOCATION));
		select.selectByVisibleText(location);
		ScreenShot.screenshot(driver, testCaseName, "After selecting location");

		String location_name = select.getFirstSelectedOption().getText().trim();
		ActionBot.defaultSleep();

		return location_name;
	}

	@Override
	public String enterDefaultBuyerForLocation(WebDriver driver, String testCaseName, String LocationBuyer) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DEFAULT_BUYER_FOR_AUTO_LOCATION);
		ele.clear();
		ele.sendKeys(LocationBuyer);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String buyer = ele.getAttribute("value").trim();
		return buyer;
	}

	@Override
	public void clickOnUpdateLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPDATE_LOCATION);
		ActionBot.defaultSleep();

	}

	@Override
	public String enterMaxTermsAndConditions(WebDriver driver, String testCaseName, String termsAndConditions) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_EPROC_COMPANY_PO_TERMS_AND_CONDITIONS);
		ActionBot.sendKeys(driver, TEXTBOX_EPROC_COMPANY_PO_TERMS_AND_CONDITIONS, termsAndConditions);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_EPROC_COMPANY_PO_TERMS_AND_CONDITIONS);

	}

}
