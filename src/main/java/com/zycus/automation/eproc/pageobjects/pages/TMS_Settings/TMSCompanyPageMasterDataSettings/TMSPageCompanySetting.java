package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSCompanyPageMasterDataSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class TMSPageCompanySetting
{

	static UI_Elements	LINK_ADD_COMPANY			= UIFactory.getElements("LINK_ADD_COMPANY");
	static UI_Elements	TEXT_SEARCH_COMPANY			= UIFactory.getElements("TEXT_SEARCH_COMPANY");
	static UI_Elements	DROPDOWN_SEARCH_IN_COMPANY	= UIFactory.getElements("DROPDOWN_SEARCH_IN_COMPANY");
	static UI_Elements	BUTTON_GO_COMPANY_PAGE		= UIFactory.getElements("BUTTON_GO_COMPANY_PAGE");
	static UI_Elements	LINK_EDIT_COMPANY			= UIFactory.getElements("LINK_EDIT_COMPANY");
	static UI_Elements	POPUP_PROCESSING			= UIFactory.getElements("POPUP_PROCESSING");
	static UI_Elements	BUTTON_ADD_COMPANY			= UIFactory.getElements("BUTTON_ADD_COMPANY");
	static UI_Elements	NOTIFICATION_SUCCESSMESSAGE	= UIFactory.getElements("NOTIFICATION_SUCCESSMESSAGE");
	static UI_Elements	BUTTON_EDIT_COMPANY			= UIFactory.getElements("BUTTON_EDIT_COMPANY");

	public static boolean clickLinkAddCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_COMPANY))
		{
			ActionBot.click(driver, LINK_ADD_COMPANY);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Add Company");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static String fillSearchBox(WebDriver driver, String testCaseName, String projectName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SEARCH_COMPANY, projectName);
		return projectName;
	}

	public static String selectSearchInCompany(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DROPDOWN_SEARCH_IN_COMPANY);
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
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO_COMPANY_PAGE))
		{
			ActionBot.click(driver, BUTTON_GO_COMPANY_PAGE);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static boolean clickLinkEditCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_EDIT_COMPANY))
		{
			ActionBot.click(driver, LINK_EDIT_COMPANY);
			ActionBot.waitTillPopUpIsPresent(driver, POPUP_PROCESSING);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Edit Company");
			return true;
		}
		return false;
	}

	public static boolean clickButtonAddCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_ADD_COMPANY))
		{
			ActionBot.click(driver, BUTTON_ADD_COMPANY);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Add Company");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

	public static boolean clickButtonEditCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_EDIT_COMPANY))
		{
			ActionBot.click(driver, BUTTON_EDIT_COMPANY);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Edit Company");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}

}
