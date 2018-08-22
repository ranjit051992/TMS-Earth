package com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageLocationMasterDataSettingsImpl implements IPageLocationMasterDataSettings
{

	@Override
	public String fillSearchBox(WebDriver driver, String testCaseName, String location) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_SEARCH_LOCATION);
		ele.clear();
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_LOCATION, location);
		ScreenShot.screenshot(driver, testCaseName, "After entering the location name");
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_SEARCH_LOCATION);
		return str;

	}

	@Override
	public void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");

	}

	@Override
	public String getBillTOAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, BILL_TO_ADDRESS_OF_LOCATION);

	}

	@Override
	public String getDeliveryAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, DELIVERY_ADDRESS_OF_LOCATION);
	}

	@Override
	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVE_LOCATION);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnInactiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_INACTIVE_LOCATION);
		ActionBot.defaultSleep();

	}

}
