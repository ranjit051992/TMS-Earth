/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.requisitionApprovalWorkflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalRequisitionApprovalWorkflowImpl implements IModalRequisitionApprovalWorkflow
{
	static Logger logger = Logger.getLogger(IModalRequisitionApprovalWorkflowImpl.class);

	@Override
	public void clickOnSaveReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save req workflow");
		ActionBot.click(driver, BUTTON_SAVE_REQ_APPROVAL_WORKFLOW);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save req workflow");
	}

	@Override
	public void clickOnCancelReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel req workflow");
		ActionBot.click(driver, BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel req workflow");
	}

	@Override
	public String getRequesterNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String displayName = ActionBot.getTextWithInElement(driver, LABEL_REQUESTER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW);
		logger.info("Requester node display name : " + displayName);
		return displayName;
	}

	@Override
	public String getRequesterNodeStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_REQUESTER_NODE_STATUS_REQ_APPROVAL_WORKFLOW);
		logger.info("Requester node status : " + status);
		return status;
	}

	@Override
	public String getBuyerNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String displayName = ActionBot.getTextWithInElement(driver, LABEL_BUYER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW);
		logger.info("Buyer node display name : " + displayName);
		return displayName;
	}

	@Override
	public boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageRequisitionCheckOut.CHECKBOX_MODIFY_WORKFLOW_SETTING);
	}

}
