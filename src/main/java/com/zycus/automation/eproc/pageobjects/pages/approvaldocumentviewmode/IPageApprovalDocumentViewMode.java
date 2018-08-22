/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageApprovalDocumentViewMode
{
	static UI_Elements			TEXTBOX_APPROVAL_COMMENT_ON_DOCUMENT_VIEW_PAGE	= UIFactory.getElements("TEXTBOX_APPROVAL_COMMENT_ON_DOCUMENT_VIEW_PAGE");
	static UI_Elements			BUTTON_APPROVE_ON_DOCUMENT_VIEW_PAGE			= UIFactory.getElements("BUTTON_APPROVE_ON_DOCUMENT_VIEW_PAGE");
	static UI_Elements			BUTTON_REJECT_ON_DOCUMENT_VIEW_PAGE				= UIFactory.getElements("BUTTON_REJECT_ON_DOCUMENT_VIEW_PAGE");
	static UI_Elements			BUTTON_DELEGATE_ON_DOCUMENT_VIEW_PAGE			= UIFactory.getElements("BUTTON_DELEGATE_ON_DOCUMENT_VIEW_PAGE");
	static UI_Elements			APPROVAL_PROCESSING_DIV_ON_DOCUMENT_VIEW_PAGE	= UIFactory.getElements("APPROVAL_PROCESSING_DIV_ON_DOCUMENT_VIEW_PAGE");
	static UI_Elements			ERROR_MANDATORY_COMMENTS						= UIFactory.getElements("ERROR_MANDATORY_COMMENTS");
	static UI_Elements			BUTTON_ADD_APPROVER_IN_ALL_APPROVAL_PAGE		= UIFactory.getElements("BUTTON_ADD_APPROVER_IN_ALL_APPROVAL_PAGE");
	public static UI_Elements	MY_APPROVAL_VIEW_ITEM_COMMENTS					= UIFactory.getElements("APPROVAL_VIEW_ITEM_COMMENTS");
	static UI_Elements			WORKFLOW_APPROVER_LIST							= UIFactory.getElements("WORKFLOW_APPROVER_LIST");
	static UI_Elements			DELEGATE_APPROVAL_TO							= UIFactory.getElements("DELEGATE_APPROVAL_TO");
	static UI_Elements			DELEGATE_BUTTON									= UIFactory.getElements("DELEGATE_BUTTON");

	public String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException;

	public void clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isMandatoryCommentsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean checkAddedApproverByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException;

	String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException;

	void clickDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnChangeApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException;

	void clickOnRemoveApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException;
}
