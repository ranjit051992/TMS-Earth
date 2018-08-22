/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closereq;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalCloseReqImpl implements IModalCloseReq
{

	static Logger logger = Logger.getLogger(IModalCloseReqImpl.class);

	@Override
	public String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CLOSE_COMMENT, closeComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXTBOX_CLOSE_COMMENT);
		logger.info("Close Comment : " + comment);
		return comment;
	}

	@Override
	public void clickOnCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close button");
		ActionBot.click(driver, BUTTON_CLOSE_REQUISITION);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_CLOSING_REQ);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close button");
	}

	@Override
	public void clickOnCancelCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel close button");
		ActionBot.click(driver, BUTTON_CANCEL_CLOSE_BOX);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel close button");
	}

}
