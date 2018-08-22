/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.IPagePurchaseOrderListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPORecallApprovalRequestImpl implements IModalPORecallApprovalRequest
{

	static Logger logger = Logger.getLogger(IModalPORecallApprovalRequestImpl.class);

	@Override
	public String fillRecallComments(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_RECALL_COMMENTS_PO, recallComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXTBOX_RECALL_COMMENTS_PO);
		logger.info("Entered Recall Comment : " + comment);
		ScreenShot.screenshot(driver, testCaseName, "After filling recall comment");
		return comment;
	}

	@Override
	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_RECALL_PO);
		ActionBot.waitTillPopUpIsPresent(driver, IPagePurchaseOrderListing.RECALLING_PROCESSING_DIV);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_PO);
		ActionBot.waitTillPopUpIsPresent(driver, IPagePurchaseOrderListing.RECALLING_PROCESSING_DIV);
	}

}
