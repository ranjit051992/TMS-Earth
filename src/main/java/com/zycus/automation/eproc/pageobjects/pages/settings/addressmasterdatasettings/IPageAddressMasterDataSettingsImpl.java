package com.zycus.automation.eproc.pageobjects.pages.settings.addressmasterdatasettings;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageAddressMasterDataSettingsImpl implements IPageAddressMasterDataSettings
{

	@Override
	public void clickOnAddAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_ADDRESS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add adress link");

	}

	@Override
	public String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_CITY_ADDRESS);
		ele.sendKeys(city);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String city_name = ele.getAttribute("value").trim();
		return city_name;
	}

	@Override
	public String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_COUNTY_ADDRESS);
		ele.clear();
		ele.sendKeys(county);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String county_name = ele.getAttribute("value").trim();
		return county_name;
	}

	@Override
	public String enterFreeTextCounty(WebDriver driver, String testCaseName, String freeTextCounty) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_COUNTY_ADDRESS);
		ele.clear();
		ele.sendKeys(freeTextCounty);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String county_freeText_name = ele.getAttribute("value").trim();
		return county_freeText_name;
	}

}
