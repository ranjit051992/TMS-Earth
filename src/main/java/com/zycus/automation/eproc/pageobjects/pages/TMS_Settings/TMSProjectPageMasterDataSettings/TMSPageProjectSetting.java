package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSProjectPageMasterDataSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class TMSPageProjectSetting
{
	static UI_Elements	LINK_ADD_PROJECTS			= UIFactory.getElements("LINK_ADD_PROJECTS");
	static UI_Elements	TEXT_SEARCH					= UIFactory.getElements("TEXT_SEARCH");
	static UI_Elements	DROPDOWN_SEARCH_IN			= UIFactory.getElements("DROPDOWN_SEARCH_IN");
	static UI_Elements	BUTTON_GO					= UIFactory.getElements("BUTTON_GO");
	static UI_Elements	LINK_EDIT_PROJECT			= UIFactory.getElements("LINK_EDIT_PROJECT");
	static UI_Elements	POPUP_PROCESSING			= UIFactory.getElements("POPUP_PROCESSING");
	static UI_Elements	BUTTON_ADD_PROJECT			= UIFactory.getElements("BUTTON_ADD_PROJECT");
	static UI_Elements	NOTIFICATION_SUCCESSMESSAGE	= UIFactory.getElements("NOTIFICATION_SUCCESSMESSAGE");

	public static boolean clickLinkAddProjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ADD_PROJECTS))
		{
			ActionBot.click(driver, LINK_ADD_PROJECTS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Add Projects");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static String fillSearchBox(WebDriver driver, String testCaseName, String projectName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SEARCH, projectName);
		return projectName;
	}

	public static String selectSearchIn(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DROPDOWN_SEARCH_IN);
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
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO))
		{
			ActionBot.click(driver, BUTTON_GO);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	public static boolean clickLinkEditProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_EDIT_PROJECT))
		{
			ActionBot.click(driver, LINK_EDIT_PROJECT);
			ActionBot.waitTillPopUpIsPresent(driver, POPUP_PROCESSING);
			ScreenShot.screenshot(driver, testCaseName, "After clicking link Edit Project");
			return true;
		}
		return false;
	}

	public static boolean clickButtonAddProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_ADD_PROJECT))
		{
			ActionBot.click(driver, BUTTON_ADD_PROJECT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Add Project");
			ActionBot.waitTillPopUpIsPresent(driver, NOTIFICATION_SUCCESSMESSAGE);
			return true;
		}
		return false;
	}
}
