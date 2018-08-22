/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.myreqactionsrecallapprovalrequest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalRecallApprovalRequestImpl implements IModalRecallApprovalRequest
{
	static Logger logger = Logger.getLogger(IModalRecallApprovalRequestImpl.class);

	@Override
	public String fillRecallComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException
	{
		if (recallComment == null)
		{
			recallComment = IConstantsData.RECALL_COMMENT;
		}
		ActionBot.sendKeys(driver, TEXTBOX_RECALL_REQ_COMMENT, recallComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXTBOX_RECALL_REQ_COMMENT);
		logger.info("Recall Comment :" + comment);
		ScreenShot.screenshot(driver, testCaseName, "Recall Comment");

		return comment;
	}

	@Override
	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_RECALL);
		waitTillSaveCommentProcessingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After recalling requisition");

	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel recall requisition");
	}

	@Override
	public void waitTillSaveCommentProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, SAVING_COMMENT_PROCESSING_DIV);
	}

}
