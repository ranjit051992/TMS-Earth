/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode.PageApprovalDocumentViewMode;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAllRequestsApprovalDocumentRejectImpl implements IModalAllRequestsApprovalDocumentReject
{
	static Logger logger = Logger.getLogger(IModalAllRequestsApprovalDocumentRejectImpl.class);

	@Override
	public String fillRejectComment(WebDriver driver, String testCaseName, String rejectComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, REJECT_COMMENTS, rejectComment);
		ScreenShot.screenshot(driver, testCaseName, "After filling Reject Comment");
		String reject_comment = ActionBot.findElement(driver, REJECT_COMMENTS).getAttribute("value").trim();
		logger.info("Reject Comment : " + reject_comment);
		return reject_comment;
	}

	@Override
	public String getRejectComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Reject Comment");
		String reject_comment = ActionBot.findElement(driver, REJECT_COMMENTS).getAttribute("value").trim();
		logger.info("Reject Comment : " + reject_comment);
		return reject_comment;
	}

	@Override
	public void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECT_BUTTON);
		PageAllRequestsApproval.waitTillApprovalActionProcessingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Reject Button");
	}

	@Override
	public void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECT_CLOSE_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Reject Close Button");
	}

	@Override
	public boolean rejectMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, IPageAllRequestsApproval.AUTO_CHECK_ALL);
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[1]"));
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[2]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting multiple items");
		ActionBot.click(driver, LINK_REJECT_MULTIPLE_ITEMS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking reject link");
		fillRejectComment(driver, testCaseName, IConstantsData.REJECT_COMMENT);
		clickOnRejectButton(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After rejecting multiple items");
		return PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);

	}

}
