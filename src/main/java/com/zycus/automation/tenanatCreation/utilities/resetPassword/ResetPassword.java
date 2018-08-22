package com.zycus.automation.tenanatCreation.utilities.resetPassword;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class ResetPassword
{

	public static UI_Elements	TEXTBOX_EMAILID_RESETPASSWORD	= UIFactory.getElements("TEXTBOX_EMAILID_RESETPASSWORD");
	public static UI_Elements	BUTTON_ENTER_RESETPASSWORD		= UIFactory.getElements("BUTTON_ENTER_RESETPASSWORD");
	public static UI_Elements	LABEL_PASSWORD_RESETPASSWORD	= UIFactory.getElements("LABEL_PASSWORD_RESETPASSWORD");
	public static UI_Elements	LINK_BACK_TO_TMS				= UIFactory.getElements("LINK_BACK_TO_TMS");

	public static String resetPassword(WebDriver driver, String testCaseName, String username) throws ActionBotException, InterruptedException
	{
		try
		{
//			driver.get(ConfigProperty.getConfig("RESET_PASSWORD_LINK"));
//			ActionBot.waitForElementToBeEnable(driver, TEXTBOX_EMAILID_RESETPASSWORD, ActionBot.timeOut);
			ActionBot.sendKeys(driver, TEXTBOX_EMAILID_RESETPASSWORD, username);
			ActionBot.click(driver, BUTTON_ENTER_RESETPASSWORD);
			ActionBot.defaultLowSleep();
//			ActionBot.waitForElementToBeEnable(driver, LABEL_PASSWORD_RESETPASSWORD, ActionBot.timeOut);
			String labelPassword = ActionBot.getTextWithInElement(driver, LABEL_PASSWORD_RESETPASSWORD);
			return (labelPassword.split(":")[2].trim()).split("Go")[0];

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

}
