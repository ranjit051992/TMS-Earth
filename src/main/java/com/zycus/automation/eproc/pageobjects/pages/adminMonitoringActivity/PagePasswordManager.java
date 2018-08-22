package com.zycus.automation.eproc.pageobjects.pages.adminMonitoringActivity;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.AdminMonitoring;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PagePasswordManager
{

	static Logger					logger							= Logger.getLogger(PagePasswordManager.class);

	final static UI_Elements		TEXT_USERNAME_PASSWORD_MANAGER	= UIFactory.getElements("TEXT_USERNAME_PASSWORD_MANAGER");
	final static UI_Elements		TEXT_PASSWORD_PASSWORD_MANAGER	= UIFactory.getElements("TEXT_PASSWORD_PASSWORD_MANAGER");
	final static UI_Elements		BUTTON_LOGIN_PASSWORD_MANAGER	= UIFactory.getElements("BUTTON_LOGIN_PASSWORD_MANAGER");
	final static UI_Elements		TEXT_SEARCH_PASSWORD_MANAGER	= UIFactory.getElements("TEXT_SEARCH_PASSWORD_MANAGER");
	final static UI_Elements		LINK_RESOURCE_NAME				= UIFactory.getElements("LINK_RESOURCE_NAME");
	final static UI_Elements		POPUP_RESOURCE_DETAILS			= UIFactory.getElements("POPUP_RESOURCE_DETAILS");
	public final static UI_Elements	LINK_RESOURCE_URL				= UIFactory.getElements("LINK_RESOURCE_URL");

	public static AdminMonitoring loginPasswordManager(WebDriver driver, String testCaseName, AdminMonitoring adminMonitoring) throws ActionBotException
	{
		driver.get("https://dummy2142.zycus.net:7272/PassTrixMain.cc");
		ActionBot.sendKeys(driver, TEXT_USERNAME_PASSWORD_MANAGER, adminMonitoring.getUsername());
		ActionBot.sendKeys(driver, TEXT_PASSWORD_PASSWORD_MANAGER, adminMonitoring.getPassword());
		ActionBot.click(driver, BUTTON_LOGIN_PASSWORD_MANAGER);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After loggin to passowrd manager page");
		return adminMonitoring;
	}

	public static AdminMonitoring searchUserAccount(WebDriver driver, String testCaseName, AdminMonitoring adminMonitoring) throws ActionBotException
	{
		// search for specific user
		WebElement ele = ActionBot.findElement(driver, TEXT_SEARCH_PASSWORD_MANAGER);
		ele.sendKeys(adminMonitoring.getUserAccount());
		ele.sendKeys(Keys.ENTER);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After searching User Account");
		return adminMonitoring;
	}

	public static void navigateToResourcePage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// to click on Resource Name and click on resoure url
		ActionBot.click(driver, LINK_RESOURCE_NAME);
		ActionBot.waitTillPopUpIsPresent(driver, POPUP_RESOURCE_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking resoure name");
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_RESOURCE_URL);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking resource url");
	}

}
