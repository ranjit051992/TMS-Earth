/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAllRequestsApprovalDocumentApprove
{

	final static UI_Elements	APPROVAL_COMMENTS			= UIFactory.getElements("APPROVAL_COMMENTS");
	final static UI_Elements	APPROVE_BUTTON				= UIFactory.getElements("APPROVE_BUTTON");
	final static UI_Elements	APPROVE_CLOSE_BUTTON		= UIFactory.getElements("APPROVE_CLOSE_BUTTON");
	final static UI_Elements	TEXTBOX_APPROVED_AMOUNT		= UIFactory.getElements("TEXTBOX_APPROVED_AMOUNT");
	final static UI_Elements	LINK_APPROVE_MULTIPLE_ITEMS	= UIFactory.getElements("LINK_APPROVE_MULTIPLE_ITEMS");

	public String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException;

	public String getApprovalComment(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getApprovedAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillApprovedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public boolean clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean approveMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException;

}
