package com.zycus.automation.eproc.pageobjects.modals.EFormAddAttachmentCheckout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class ModalEFormAddAttachmentCheckout
{

	static UI_Elements	TEXTBOX_EFORM_ADD_ATTACHMENT_CHECKOUT		= UIFactory.getElements("TEXTBOX_EFORM_ADD_ATTACHMENT_CHECKOUT");
	static UI_Elements	BUTTON_DONE_EFORM_ADD_ATTACHMENT_CHECKOUT	= UIFactory.getElements("BUTTON_DONE_EFORM_ADD_ATTACHMENT_CHECKOUT");

	public static String enterFileNameForEformAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before entering file name");
		String name = ActionBot.sendKeys(driver, TEXTBOX_EFORM_ADD_ATTACHMENT_CHECKOUT, fileName);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After entering file name");
		return name;
	}

	public static void clickOnDoneEformAttachment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Done ");
		ActionBot.click(driver, BUTTON_DONE_EFORM_ADD_ATTACHMENT_CHECKOUT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Done");
	}

}
