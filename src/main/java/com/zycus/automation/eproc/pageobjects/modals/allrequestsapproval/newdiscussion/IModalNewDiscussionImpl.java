/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.newdiscussion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalNewDiscussionImpl implements IModalNewDiscussion
{
	static Logger logger = Logger.getLogger(IModalNewDiscussionImpl.class);

	@Override
	public String fillToFieldForNewDiscussion(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, INPUT_TO_FIELD_FOR_NEW_DISCUSSION, to);
		String toName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_TO_NAME);
		logger.info("Added To : " + toName);
		return toName;
	}

	@Override
	public String fillMessageForNewDiscussion(WebDriver driver, String testCaseName, String message) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTAREA_MESSAGE_FOR_NEW_DISCUSSION, message);
		String msg = ActionBot.getTextWithInElement(driver, TEXTAREA_MESSAGE_FOR_NEW_DISCUSSION);
		logger.info("Message : " + msg);
		return msg;
	}

	@Override
	public void selectAllOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementSelected(driver, CHECKBOX_SELECT_ALL_FOR_SHARED_WITH))
		{
			ActionBot.click(driver, CHECKBOX_SELECT_ALL_FOR_SHARED_WITH);
		}
	}

	@Override
	public void selectRequesterOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_REQUESTER_FOR_SHARED_WITH);
	}

	@Override
	public void selectApproverOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_APPROVAL_FOR_SHARED_WITH);
	}

	@Override
	public void selectBuyerOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_BUYER_FOR_SHARED_WITH);
	}

	@Override
	public void clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit button");
		ActionBot.click(driver, BUTTON_SUBMIT_ON_NEW_DISCUSSION_FORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel button");
		ActionBot.click(driver, BUTTON_CANCEL_ON_NEW_DISCUSSION_FORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel button");
	}

	@Override
	public void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, INPUT_ADD_ATTACHMENT_FOR_NEW_DISCUSSION, fileName);
	}

}
