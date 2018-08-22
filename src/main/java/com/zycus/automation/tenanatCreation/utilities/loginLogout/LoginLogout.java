package com.zycus.automation.tenanatCreation.utilities.loginLogout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class LoginLogout
{

	public static UI_Elements	TEXTBOX_LOGIN_EMAIL_TEMP	= UIFactory.getElements("TEXTBOX_LOGIN_EMAIL_TEMP");
	public static UI_Elements	TEXTBOX_LOGIN_EMAIL			= UIFactory.getElements("TEXTBOX_LOGIN_EMAIL");
	public static UI_Elements	TEXTBOX_LOGIN_PASSWORD_TEMP	= UIFactory.getElements("TEXTBOX_LOGIN_PASSWORD_TEMP");
	public static UI_Elements	TEXTBOX_LOGIN_PASSWORD		= UIFactory.getElements("TEXTBOX_LOGIN_PASSWORD");
	public static UI_Elements	BUTTON_LOGIN				= UIFactory.getElements("BUTTON_LOGIN");
	public static UI_Elements	BUTTON_LOGOUT				= UIFactory.getElements("BUTTON_LOGOUT");

	public static void login(WebDriver driver, TestCase testCase, String username, String password) throws ActionBotException, InterruptedException
	{
		try
		{
			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.waitForPageLoad(driver);
			//driver.wait(3000);
			Thread.sleep(5000);
//			JavascriptExecutor
			((JavascriptExecutor) driver).executeScript("window.focus();");
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Before login");
			ActionBot.clickOnCertificateError(driver, "Login");

			//to handle secure connection failed error.
			System.out.println("Value is ::::\n"+TEXTBOX_LOGIN_EMAIL_TEMP.getValue());
			if (!(ActionBot.isElementDisplayed(driver, TEXTBOX_LOGIN_EMAIL_TEMP)))
			{
				driver.get(ConfigProperty.getConfig("URL"));
				ActionBot.waitForPageLoad(driver);
			}
			ActionBot.waitForElementToBeEnable(driver, TEXTBOX_LOGIN_EMAIL_TEMP, ActionBot.timeOut);
			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL_TEMP).click();
			// ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL_TEMP).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).sendKeys(username);
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD_TEMP).click();
			// ActionBot.findElement(driver,
			// TEXTBOX_LOGIN_PASSWORD_TEMP).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).sendKeys(password);
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "After filling login info");

			if (ActionBot.isElementDisplayed(driver, BUTTON_LOGIN))
			{
				ActionBot.findElement(driver, BUTTON_LOGIN).click();
			}
			ActionBot.defaultSleep();

			ActionBot.clickOnCertificateError(driver, "Login");
			//		errorInLogin(driver, username, password);

			PageOnlineStore.clickOnGotItButton(driver, "TenantCreation");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void logout(WebDriver driver, TestCase testCase) throws ActionBotException, InterruptedException
	{
		try
		{
			System.out.println(ActionBot.isElementDisplayed(driver, BUTTON_LOGOUT));
			ActionBot.click(driver, BUTTON_LOGOUT);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
