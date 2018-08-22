package com.zycus.automation.tenanatCreation.utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.AdminConfiguration;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class ChangePassword {

	public static UI_Elements BUTTON_GOT_IT = UIFactory.getElements("BUTTON_GOT_IT");
	public static UI_Elements DROPDOWN_MANAGE_PROFILE = UIFactory.getElements("DROPDOWN_MANAGE_PROFILE");
	public static UI_Elements BUTTON_CHANGE_PASSWORD = UIFactory.getElements("BUTTON_CHANGE_PASSWORD");
	public static UI_Elements TEXTBOX_CURRENT_PASSWORD_POPUP = UIFactory.getElements("TEXTBOX_CURRENT_PASSWORD_POPUP");
	public static UI_Elements TEXTBOX_NEW_PASSWORD_POPUP = UIFactory.getElements("TEXTBOX_NEW_PASSWORD_POPUP");
	public static UI_Elements TEXTBOX_CONFIRM_PASSWORD_POPUP = UIFactory.getElements("TEXTBOX_CONFIRM_PASSWORD_POPUP");
	public static UI_Elements BUTTON_CHANGE_PASSWORD_POPUP = UIFactory.getElements("BUTTON_CHANGE_PASSWORD_POPUP");
	public static UI_Elements BUTTON_CLOSE_POPUP = UIFactory.getElements("BUTTON_CLOSE_POPUP");

	public static boolean changePassword(WebDriver driver, String testCaseName, String username, String oldPassword,
			String newPassword) throws ActionBotException, InterruptedException {
		try {
			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.waitForPageLoad(driver);
			if (ActionBot.isElementDisplayed(driver, BUTTON_GOT_IT)) {
				ActionBot.click(driver, BUTTON_GOT_IT);
				ActionBot.defaultLowSleep();
			}
			ActionBot.waitForElementToBeEnable(driver, AdminConfiguration.HEADER_TAB_SETTING, ActionBot.timeOut);
			ActionBot.click(driver, AdminConfiguration.HEADER_TAB_SETTING);
			ActionBot.waitForElementToBeDisplayed(driver, DROPDOWN_MANAGE_PROFILE,
					Integer.parseInt(ActionBot.defaultSleep));
			String parentWindowHandle = driver.getWindowHandle();
			ActionBot.click(driver, DROPDOWN_MANAGE_PROFILE);

			Set<String> allWindowHandles = driver.getWindowHandles();
			String lastWindowHandle = "";
			for (String handle : allWindowHandles) {
				driver.switchTo().window(handle);
				lastWindowHandle = handle;
			}

			ActionBot.waitForElementToBeEnable(driver, BUTTON_CHANGE_PASSWORD, ActionBot.timeOut);

			ActionBot.click(driver, BUTTON_CHANGE_PASSWORD);
			ActionBot.sendKeys(driver, TEXTBOX_CURRENT_PASSWORD_POPUP, oldPassword);

			// ActionBot.click(driver,TEXTBOX_NEW_PASSWORD_POPUP);
			ActionBot.findElement(driver, TEXTBOX_NEW_PASSWORD_POPUP).sendKeys(newPassword);
			// ActionBot.click(driver,TEXTBOX_CONFIRM_PASSWORD_POPUP);
			ActionBot.findElement(driver, TEXTBOX_CONFIRM_PASSWORD_POPUP).sendKeys(newPassword);

			ActionBot.click(driver, BUTTON_CHANGE_PASSWORD_POPUP);
			ActionBot.defaultSleep();
			ActionBot.click(driver, BUTTON_CLOSE_POPUP);
			driver.close();
			driver.switchTo().window(parentWindowHandle);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
