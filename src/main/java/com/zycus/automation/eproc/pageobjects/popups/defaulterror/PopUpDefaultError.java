/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaulterror;

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
public class PopUpDefaultError
{
	static Logger				logger			= Logger.getLogger(PopUpDefaultError.class);
	static public UI_Elements	BUTTON_ERROR_OK	= UIFactory.getElements("BUTTON_ERROR_OK");
	static public UI_Elements	LABEL_ERROR_MSG	= UIFactory.getElements("LABEL_ERROR_MSG");

	public static String getErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Error Message");
		String errorMsg = ActionBot.getTextWithInElement(driver, LABEL_ERROR_MSG);
		logger.info("Error Message : " + errorMsg);
		return errorMsg;
	}

	public static void clickOnErrorOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ERROR_OK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Error Ok button");
	}
}
