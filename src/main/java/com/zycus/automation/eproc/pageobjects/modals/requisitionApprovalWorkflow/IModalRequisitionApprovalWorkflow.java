/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.requisitionApprovalWorkflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRequisitionApprovalWorkflow
{
	static UI_Elements	BUTTON_SAVE_REQ_APPROVAL_WORKFLOW						= UIFactory.getElements("BUTTON_SAVE_REQ_APPROVAL_WORKFLOW");

	static UI_Elements	BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW						= UIFactory.getElements("BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW");

	static UI_Elements	LABEL_REQUESTER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW	= UIFactory.getElements("LABEL_REQUESTER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW");

	static UI_Elements	LABEL_REQUESTER_NODE_STATUS_REQ_APPROVAL_WORKFLOW		= UIFactory.getElements("LABEL_REQUESTER_NODE_STATUS_REQ_APPROVAL_WORKFLOW");

	static UI_Elements	LABEL_BUYER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW		= UIFactory.getElements("LABEL_BUYER_NODE_DISPLAY_NAME_REQ_APPROVAL_WORKFLOW");

	public void clickOnSaveReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequesterNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequesterNodeStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBuyerNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
