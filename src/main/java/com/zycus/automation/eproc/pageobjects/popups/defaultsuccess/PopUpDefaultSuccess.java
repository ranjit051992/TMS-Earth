/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaultsuccess;

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
public class PopUpDefaultSuccess
{
	static Logger				logger				= Logger.getLogger(PopUpDefaultSuccess.class);
	static public UI_Elements	BUTTON_SUCCESS_OK	= UIFactory.getElements("BUTTON_SUCCESS_OK");
	static public UI_Elements	LABEL_SUCCESS_MSG	= UIFactory.getElements("LABEL_SUCCESS_MSG");

	public static String getSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Success Message");
		String successMsg = ActionBot.getTextWithInElement(driver, LABEL_SUCCESS_MSG);
		logger.info("Success Message : " + successMsg);
		return successMsg;
	}

	public static void clickOnSuccessOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SUCCESS_OK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Success Ok button");
	}
}
