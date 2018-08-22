/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalClosePOImpl implements IModalClosePO
{

	static Logger logger = Logger.getLogger(IModalClosePOImpl.class);

	@Override
	public String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BOX_CLOSE_COMMENT, closeComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXT_BOX_CLOSE_COMMENT);
		logger.info("Close Comment : " + comment);
		return comment;
	}

	@Override
	public void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close button");
		ActionBot.click(driver, BUTTON_CLOSE_PO);
		ActionBot.waitTillPopUpIsPresent(driver, CLOSE_PO_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close button");
	}

	@Override
	public void clickOnCancelClosePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel close button");
		ActionBot.click(driver, BUTTON_CANCEL_CLOSE_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel close button");
	}

	@Override
	public void clickOnCheckBoxAllowCreatingInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CHECKBOX_ALLOW_CREATING_INVOICE))
		{
			ActionBot.click(driver, CHECKBOX_ALLOW_CREATING_INVOICE);
			ScreenShot.screenshot(driver, testCaseName, "After selecting checkbox Allow creating invoice");
		}
	}

}
