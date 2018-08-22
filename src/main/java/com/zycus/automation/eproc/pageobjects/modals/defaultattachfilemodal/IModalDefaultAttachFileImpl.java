/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class IModalDefaultAttachFileImpl implements IModalDefaultAttachFile
{
	static Logger logger = Logger.getLogger(IModalDefaultAttachFileImpl.class);

	/*
	 * method to fill attachment name
	 */
	@Override
	public void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName, UI_Elements ui_Elements) throws ActionBotException
	{
		// WebElement element = ActionBot.findElement(driver, ui_Elements);
		WebElement element = ActionBot.findElementByWaitingForPresenceOfElement(driver, ui_Elements);
		element.sendKeys(fileName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		logger.info("Uploading file : " + fileName);
		ScreenShot.screenshot(driver, testCaseName, "After uploading file");
	}

	@Override
	public String getAttachmentName(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		String attachmentName = ActionBot.getTextWithInElement(driver, ui_Elements);
		logger.info("Attached File Name : " + attachmentName);
		return attachmentName;
	}

	@Override
	public String getAttachmentStatus(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		String attachmentStatus = ActionBot.getTextWithInElement(driver, ui_Elements);
		logger.info("Attached File Status : " + attachmentStatus);
		return attachmentStatus;
	}

	@Override
	public String getAttachmentSize(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		String attachmentSize = ActionBot.getTextWithInElement(driver, ui_Elements);
		logger.info("Attached File Size : " + attachmentSize);
		return attachmentSize;
	}

	@Override
	public void clickOnDoneButton(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on done button");
		ActionBot.click(driver, ui_Elements);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on done button");
	}

	@Override
	public void clickOnDownloadAttachment(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		ActionBot.click(driver, ui_Elements);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on download attachment");

	}

	@Override
	public String selectItemVisibility(WebDriver driver, String testCaseName, UI_Elements ui_Elements, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ui_Elements);
		Select sel = new Select(ele);
		sel.selectByIndex(index);
		return testCaseName;
	}

	@Override
	public String selectItemVisibility(WebDriver driver, String testCaseName, UI_Elements ui_Elements, String visibleText) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ui_Elements);
		Select sel = new Select(ele);
		sel.selectByVisibleText(visibleText);
		String selectedValue = sel.getFirstSelectedOption().getText().trim();
		logger.info("Selected Visibility : " + selectedValue);
		return selectedValue;
	}

	/*
	 * Author : Omkar Jagdale
	 */
	@Override
	public void clickOnFirstFileCheckbox(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on File checkbox");
		if (ActionBot.isElementPresent(driver, ui_Elements))
		{
			ActionBot.click(driver, ui_Elements);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on File checkbox");

	}
}
