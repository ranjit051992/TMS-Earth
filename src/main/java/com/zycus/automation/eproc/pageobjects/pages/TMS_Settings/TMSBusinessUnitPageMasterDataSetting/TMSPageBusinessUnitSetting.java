package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSBusinessUnitPageMasterDataSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class TMSPageBusinessUnitSetting
{

	static UI_Elements	LINK_ADD_BUSINESS_UNIT				= UIFactory.getElements("LINK_ADD_BUSINESS_UNIT");
	static UI_Elements	TEXT_SEARCH_BUSINESS_UNIT			= UIFactory.getElements("TEXT_SEARCH_BUSINESS_UNIT");
	static UI_Elements	DROPDOWN_SEARCH_IN_BUSINESS_UNIT	= UIFactory.getElements("DROPDOWN_SEARCH_IN_BUSINESS_UNIT");
	static UI_Elements	BUTTON_GO_BUSINESS_UNIT				= UIFactory.getElements("BUTTON_GO_BUSINESS_UNIT");
	static UI_Elements	LINK_EDIT_BUSINESS_UNIT				= UIFactory.getElements("LINK_EDIT_BUSINESS_UNIT");
	static UI_Elements	POPUP_PROCESSING_BUSINESS_UNIT		= UIFactory.getElements("POPUP_PROCESSING_BUSINESS_UNIT");
	static UI_Elements	BUTTON_ADD_BUSINESS_UNIT			= UIFactory.getElements("BUTTON_ADD_BUSINESS_UNIT");
	static UI_Elements	NOTIFICATION_SUCCESSMESSAGE			= UIFactory.getElements("NOTIFICATION_SUCCESSMESSAGE");
	static UI_Elements	BUTTON_EDIT_BUSINESS_UNIT			= UIFactory.getElements("BUTTON_EDIT_BUSINESS_UNIT");

	public static boolean clickLinkAddBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_BUSINESS_UNIT))
		{
			ActionBot.click(driver, LINK_ADD_BUSINESS_UNIT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Add Business Unit");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static String fillSearchBox(WebDriver driver, String testCaseName, String buName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SEARCH_BUSINESS_UNIT, buName);
		return buName;
	}

	public static String selectSearchInBusinessUnit(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DROPDOWN_SEARCH_IN_BUSINESS_UNIT);
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
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO_BUSINESS_UNIT))
		{
			ActionBot.click(driver, BUTTON_GO_BUSINESS_UNIT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static boolean clickLinkEditBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_EDIT_BUSINESS_UNIT))
		{
			ActionBot.click(driver, LINK_EDIT_BUSINESS_UNIT);
			ActionBot.waitTillPopUpIsPresent(driver, POPUP_PROCESSING_BUSINESS_UNIT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Edit Business Unit");
			return true;
		}
		return false;
	}

	public static boolean clickButtonAddBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_ADD_BUSINESS_UNIT))
		{
			ActionBot.click(driver, BUTTON_ADD_BUSINESS_UNIT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Add Business Unit");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

	public static boolean clickButtonEditBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_EDIT_BUSINESS_UNIT))
		{
			ActionBot.click(driver, BUTTON_EDIT_BUSINESS_UNIT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Edit Business Unit");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

}