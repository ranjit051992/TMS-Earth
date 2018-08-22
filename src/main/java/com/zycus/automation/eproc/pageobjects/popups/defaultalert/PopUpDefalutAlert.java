/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaultalert;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class PopUpDefalutAlert
{
	static Logger		logger								= Logger.getLogger(PopUpDefalutAlert.class);
	static UI_Elements	LABEL_ALERT_MSG						= UIFactory.getElements("LABEL_ALERT_MSG");
	static UI_Elements	BUTTON_ALERT_OK						= UIFactory.getElements("BUTTON_ALERT_OK");
	static UI_Elements	ALERT_AND_ERROR_VALIDATION_CHECKOUT	= UIFactory.getElements("ALERT_AND_ERROR_VALIDATION_CHECKOUT");

	public static String getAlertMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String alertMsg = ActionBot.getTextWithInElement(driver, LABEL_ALERT_MSG);
		logger.info("Alert Message : " + alertMsg);
		return alertMsg;
	}

	public static void clickOnAlertOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Alert Ok button");
		ActionBot.click(driver, BUTTON_ALERT_OK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Alert Ok button");
	}

	public static boolean isAlertAndErrorPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before popup");
		if (ActionBot.isElementPresent(driver, ALERT_AND_ERROR_VALIDATION_CHECKOUT))
		{
			ScreenShot.screenshot(driver, testCaseName, "After popup appears");
			return true;
		}
		else
		{
			return false;
		}
	}
}
