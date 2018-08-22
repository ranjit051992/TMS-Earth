/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove;

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
public class IModalAllRequestsApprovalDocumentApproveImpl implements IModalAllRequestsApprovalDocumentApprove
{

	Logger logger = Logger.getLogger(IModalAllRequestsApprovalDocumentApproveImpl.class);

	@Override
	public String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, APPROVAL_COMMENTS, approvalComment);
		ScreenShot.screenshot(driver, testCaseName, "After filling Approval Comment");
		String approval_comment = ActionBot.findElement(driver, APPROVAL_COMMENTS).getAttribute("value");
		logger.info("Approval Comment : " + approval_comment);

		return approval_comment;
	}

	@Override
	public String getApprovalComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Approval Comment");
		String approval_comment = ActionBot.findElement(driver, APPROVAL_COMMENTS).getAttribute("value");
		logger.info("Approval Comment : " + approval_comment);

		return approval_comment;
	}

	@Override
	public boolean clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, APPROVE_BUTTON);
		PageAllRequestsApproval.waitTillApprovalActionProcessingDivPresent(driver, testCaseName);
		return PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);

		//		ScreenShot.screenshot(driver, testCaseName, "After clicking on Approve Button");
	}

	@Override
	public void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, APPROVE_CLOSE_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Button");
	}

	@Override
	public String getApprovedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approvedAmount = ActionBot.getAttributeOfElement(driver, TEXTBOX_APPROVED_AMOUNT, "value");
		logger.info("Approved Amount : " + approvedAmount);
		return approvedAmount;
	}

	@Override
	public String fillApprovedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		String approvedAmount = ActionBot.sendKeys(driver, TEXTBOX_APPROVED_AMOUNT, amount);
		logger.info("Entered Approved Amount : " + approvedAmount);
		return approvedAmount;
	}

	@Override
	public boolean approveMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, IPageAllRequestsApproval.AUTO_CHECK_ALL);
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[1]"));
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[2]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting multiple items");
		ActionBot.click(driver, LINK_APPROVE_MULTIPLE_ITEMS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking approve link");
		ModalAllRequestsApprovalDocumentApprove.fillApprovalComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);
		return ModalAllRequestsApprovalDocumentApprove.clickOnApproveButton(driver, testCaseName);
		// at the time point comes here, success msg is vanished
		//		return PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);
		//		ScreenShot.screenshot(driver, testCaseName, "After approving multiple items");
	}

}
