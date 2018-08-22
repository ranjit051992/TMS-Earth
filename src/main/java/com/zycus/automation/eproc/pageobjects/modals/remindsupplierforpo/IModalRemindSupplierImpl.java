/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalRemindSupplierImpl implements IModalRemindSupplier
{
	static Logger logger = Logger.getLogger(IModalRemindSupplierImpl.class);

	@Override
	public String fillRemindSupplierTo(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, TEXTBOX_REMIND_SUPPLIER_TO, to);
		String selectedRemindSupplierTo = getSelectedRemindSupplierTo(driver, testCaseName);
		logger.info("Entered remind supplier to : " + selectedRemindSupplierTo);
		return selectedRemindSupplierTo;
	}

	@Override
	public String getSelectedRemindSupplierTo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedRemindSupplierTo = ActionBot.getTextWithInElement(driver, LABEL_SELECTED_REMIND_SUPPLIER_TO);
		logger.info("Selected remind supplier to : " + selectedRemindSupplierTo);
		return selectedRemindSupplierTo;
	}

	@Override
	public void clickOnSendCopyCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SEND_COPY_REMIND_SUPPLIER);
	}

	@Override
	public String fillMessageForRemindSupplier(WebDriver driver, String testCaseName, String message) throws ActionBotException
	{
		String reminderMessage = ActionBot.sendKeys(driver, TEXTBOX_REMIND_MESSAGE, message);
		logger.info("Entered reminder message : " + reminderMessage);
		return reminderMessage;
	}

	@Override
	public String getNameOfAttachment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String nameOfAttachment = ActionBot.getTextWithInElement(driver, LINK_REMIND_SUPPLIER_ATTACHMENT);
		logger.info("Name of Attachment : " + nameOfAttachment);
		return nameOfAttachment;
	}

	@Override
	public void clickOnSendButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Send Button");
		ActionBot.click(driver, BUTTON_SEND_REMIND_SUPPLIER);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Send Button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Button");
		ActionBot.click(driver, BUTTON_CANCEL_REMIND_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

	@Override
	public boolean isSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SUCCESS_MESSAGE_REMIND_SUPPLIER);
	}

}
