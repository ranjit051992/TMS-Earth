package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryAttachmentsAndComments;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOFreeTextItemSummaryAttachmentsAndCommentsImpl implements IModalPOFreeTextItemSummaryAttachmentsAndComments
{

	@Override
	public void clickOnAttachmentsAndComments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ATTACHMENTS_AND_COMMENTS_FREE_TEXT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on attachments and comments");
		ActionBot.defaultSleep();
	}

	@Override
	public String enterInternalComments(WebDriver driver, String testCaseName, String inetrnalComments) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INTERNAL_COMMENTS, inetrnalComments);
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_INTERNAL_COMMENTS);
		return str;
	}

	@Override
	public String enterCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMMENTS_FOR_SUPPLIER, commentsForSupplier);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_COMMENTS_FOR_SUPPLIER);
		return str;
	}

}
