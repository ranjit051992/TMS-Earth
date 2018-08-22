package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSLocationsPageMasterDataSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class TMSPageLocationsSetting
{

	static UI_Elements	LINK_ADD_LOCATIONS				= UIFactory.getElements("LINK_ADD_LOCATIONS");
	static UI_Elements	TEXT_SEARCH_LOCATIONS			= UIFactory.getElements("TEXT_SEARCH_LOCATIONS");
	static UI_Elements	DROPDOWN_SEARCH_IN_LOCATIONS	= UIFactory.getElements("DROPDOWN_SEARCH_IN_LOCATIONS");
	static UI_Elements	BUTTON_GO_LOCATIONS				= UIFactory.getElements("BUTTON_GO_LOCATIONS");
	static UI_Elements	LINK_EDIT_LOCATIONS				= UIFactory.getElements("LINK_EDIT_LOCATIONS");
	static UI_Elements	POPUP_PROCESSING_LOCATIONS		= UIFactory.getElements("POPUP_PROCESSING_LOCATIONS");
	static UI_Elements	BUTTON_ADD_LOCATIONS			= UIFactory.getElements("BUTTON_ADD_LOCATIONS");
	static UI_Elements	NOTIFICATION_SUCCESSMESSAGE		= UIFactory.getElements("NOTIFICATION_SUCCESSMESSAGE");
	static UI_Elements	BUTTON_UPDATE_LOCATIONS			= UIFactory.getElements("BUTTON_UPDATE_LOCATIONS");

	public static boolean clickLinkAddLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_LOCATIONS))
		{
			ActionBot.click(driver, LINK_ADD_LOCATIONS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Add Locations");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static String fillSearchBox(WebDriver driver, String testCaseName, String locationName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SEARCH_LOCATIONS, locationName);
		return locationName;
	}

	public static String selectSearchInLocations(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DROPDOWN_SEARCH_IN_LOCATIONS);
		Select select = new Select(ele);
		if (!(searchIn == null))
		{
			select.selectByVisibleText(searchIn);
		}
		else
		{
			select.selectByIndex(1);
		}
		return searchIn;
	}

	public static boolean clickButtonGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking button Go");
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO_LOCATIONS))
		{
			ActionBot.click(driver, BUTTON_GO_LOCATIONS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static boolean clickLinkEditLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_EDIT_LOCATIONS))
		{
			ActionBot.click(driver, LINK_EDIT_LOCATIONS);
			ActionBot.defaultSleep();
			//ActionBot.waitTillPopUpIsPresent(driver, POPUP_PROCESSING_LOCATIONS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Edit Locations");
			return true;
		}
		return false;
	}

	public static boolean clickButtonAddLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_ADD_LOCATIONS))
		{
			ActionBot.click(driver, BUTTON_ADD_LOCATIONS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Add Locations");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

	public static boolean clickButtonEditLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_UPDATE_LOCATIONS))
		{
			ActionBot.click(driver, BUTTON_UPDATE_LOCATIONS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Edit Locations");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}
}
