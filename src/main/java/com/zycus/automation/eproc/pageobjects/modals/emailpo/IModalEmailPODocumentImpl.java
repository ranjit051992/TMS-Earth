/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.emailpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalEmailPODocumentImpl implements IModalEmailPODocument
{
	static Logger logger = Logger.getLogger(IModalEmailPODocumentImpl.class);

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_VIEW_PO);
	}

	@Override
	public String clickOnEmailMessageFieldAndGet(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_EMAIL_TO);
		ActionBot.defaultSleep();
		String selectedTo = ActionBot.findElement(driver, EMAIL_LIST).getText();
		ScreenShot.screenshot(driver, testCaseName, "After geting text of Email To Field");
		return selectedTo;
	}

	@Override
	public void clickOnSendCopyCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SEND_COPY);
	}

	@Override
	public void clickOnSendEmailButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_EMAIL);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		// ActionBot.waitTillPopUpIsPresent(driver, SEND_EMAIL_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Send Email Button");
	}

	@Override
	public String fillEmailMessageField(WebDriver driver, String testCaseName, String message) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_EMAIL_MESSAGE, message);
		String addedMessage = ActionBot.getTextWithInElement(driver, TEXTBOX_EMAIL_MESSAGE);
		logger.info("Message : " + addedMessage);
		ScreenShot.screenshot(driver, testCaseName, "After adding message");
		return addedMessage;
	}

	@Override
	public String fillEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_EMAIL_TO);
		element.clear();
		element.sendKeys(to);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.RETURN);
		if (ActionBot.isElementDisplayed(driver, LINK_CLICK_TO_ADD_EMAIL_ADDRESS))
		{
			ActionBot.click(driver, LINK_CLICK_TO_ADD_EMAIL_ADDRESS);
		}
		String selectedTo = ActionBot.getTextWithInElement(driver, LABEL_ADDED_TO_VALUE);
		logger.info("Selected To Value : " + selectedTo);
		ScreenShot.screenshot(driver, testCaseName, "After selecting To field");
		return selectedTo;
	}

	@Override
	public String getAddedMailid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String addedMialId = ActionBot.getTextWithInElement(driver, LABEL_ADDED_TO_VALUE);
		logger.info("Added MailId  : " + addedMialId);
		return addedMialId;
	}

	@Override
	public String getAttachmentLinkText(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String attachmentLinkText = ActionBot.findElement(driver, LINK_ATTACHMENT_PO).getText();
		logger.info("Attachment Link Text  : " + attachmentLinkText);
		ScreenShot.screenshot(driver, testCaseName, "After getting link text");
		return attachmentLinkText;
	}

	@Override
	public String getModalWindowTitle(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String windowTitle = ActionBot.findElement(driver, WINDOW_TITLE_EMAIL_PO_DOC).getText();

		logger.info("Window title  : " + windowTitle);
		ScreenShot.screenshot(driver, testCaseName, "PO view modal");
		return windowTitle;
	}

	@Override
	public boolean isAbleToclickOnAttachmentPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_ATTACHMENT_PO))
		{
			return ActionBot.findElement(driver, LINK_ATTACHMENT_PO).isEnabled();
			//ActionBot.click(driver, LINK_ATTACHMENT_PO);
			//return true;
		}
		return false;
	}

	@Override
	public boolean isCancelRecipientPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_RECIPIENT);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, LABEL_ADDED_TO_VALUE))
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean isCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SEND_COPY);
		if (ActionBot.isElementSelected(driver, CHECKBOX_SEND_COPY))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSendEmailSuccessDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SEND_EMAIL_PROCESSING_DIV);
	}

	@Override
	public boolean isErrorMsgForMailIdOfOutSideUserdisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ERROR_MSG_ADD_EXTERNAL_MAIL))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isErrorMsgAddMsgToSendMailPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_MSG_PLEASE_ADD_MSG_TO_SEND_MAIL))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnAddExternalEmailLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_EXTERNAL_MAIL_LINK);

	}

	@Override
	public String fillOtherEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_EMAIL_TO);
		element.clear();
		element.sendKeys(to);
		ActionBot.defaultSleep();
		return to;

	}
}
