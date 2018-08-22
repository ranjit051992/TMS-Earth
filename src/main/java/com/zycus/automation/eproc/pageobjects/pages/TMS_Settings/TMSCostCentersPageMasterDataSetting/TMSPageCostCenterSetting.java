package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSCostCentersPageMasterDataSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class TMSPageCostCenterSetting
{

	static UI_Elements	LINK_ADD_COST_CENTERS			= UIFactory.getElements("LINK_ADD_COST_CENTERS");
	static UI_Elements	TEXT_SEARCH_COST_CENTERS		= UIFactory.getElements("TEXT_SEARCH_COST_CENTERS");
	static UI_Elements	DROPDOWN_SEARCH_IN_COST_CENTERS	= UIFactory.getElements("DROPDOWN_SEARCH_IN_COST_CENTERS");
	static UI_Elements	BUTTON_GO_COST_CENTERS			= UIFactory.getElements("BUTTON_GO_COST_CENTERS");
	static UI_Elements	LINK_EDIT_COST_CENTERS			= UIFactory.getElements("LINK_EDIT_COST_CENTERS");
	static UI_Elements	POPUP_PROCESSING_COST_CENTERS	= UIFactory.getElements("POPUP_PROCESSING_COST_CENTERS");
	static UI_Elements	BUTTON_ADD_COST_CENTERS			= UIFactory.getElements("BUTTON_ADD_COST_CENTERS");
	static UI_Elements	NOTIFICATION_SUCCESSMESSAGE		= UIFactory.getElements("NOTIFICATION_SUCCESSMESSAGE");
	static UI_Elements	BUTTON_UPDATE_COST_CENTERS		= UIFactory.getElements("BUTTON_UPDATE_COST_CENTERS");

	public static boolean clickLinkAddCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_COST_CENTERS))
		{
			ActionBot.click(driver, LINK_ADD_COST_CENTERS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Add cost center");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static String fillSearchBox(WebDriver driver, String testCaseName, String ccName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SEARCH_COST_CENTERS, ccName);
		return ccName;
	}

	public static String selectSearchInCostCenter(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DROPDOWN_SEARCH_IN_COST_CENTERS);
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
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO_COST_CENTERS))
		{
			ActionBot.click(driver, BUTTON_GO_COST_CENTERS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static boolean clickLinkEditCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_EDIT_COST_CENTERS))
		{
			ActionBot.click(driver, LINK_EDIT_COST_CENTERS);
			ActionBot.waitTillPopUpIsPresent(driver, POPUP_PROCESSING_COST_CENTERS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Edit CostCenter");
			return true;
		}
		return false;
	}

	public static boolean clickButtonAddCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_ADD_COST_CENTERS))
		{
			ActionBot.click(driver, BUTTON_ADD_COST_CENTERS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Add CostCenter");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

	public static boolean clickButtonEditCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_UPDATE_COST_CENTERS))
		{
			ActionBot.click(driver, BUTTON_UPDATE_COST_CENTERS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Edit CostCenter");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}
}
