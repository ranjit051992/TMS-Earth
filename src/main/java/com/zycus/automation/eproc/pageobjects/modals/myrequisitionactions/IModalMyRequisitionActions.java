package com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalMyRequisitionActions
{
	final static UI_Elements	EDIT_LINK						= UIFactory.getElements("EDIT_LINK");
	final static UI_Elements	DELETE_LINK						= UIFactory.getElements("DELETE_LINK");
	final static UI_Elements	RECALL_APPROVE_REQUEST_LINK		= UIFactory.getElements("RECALL_APPROVE_REQUEST_LINK");
	final static UI_Elements	REMIND_APPROVER_LINK			= UIFactory.getElements("REMIND_APPROVER_LINK");
	final static UI_Elements	COPY_LINK						= UIFactory.getElements("COPY_LINK");
	final static UI_Elements	CANCEL_LINK						= UIFactory.getElements("CANCEL_LINK");
	final static UI_Elements	CREATE_RECEIPT_LINK				= UIFactory.getElements("CREATE_RECEIPT_LINK");
	final static UI_Elements	ACTIONS_BTN_LINK_LIST			= UIFactory.getElements("ACTIONS_BTN_LINK_LIST");
	UI_Elements					LINK_CLOSE_REQ					= UIFactory.getElements("LINK_CLOSE_REQ");
	final static UI_Elements	BUTTON_ACTIONS_VIEW_REQUISITION	= UIFactory.getElements("BUTTON_ACTIONS_VIEW_REQUISITION");
	final static UI_Elements	TEXTBOX_RECALL_COMMENTS_MY_REQ	= UIFactory.getElements("TEXTBOX_RECALL_COMMENTS_MY_REQ");
	final static UI_Elements	BUTTON_RECALL_MY_REQUISITION	= UIFactory.getElements("BUTTON_RECALL_MY_REQUISITION");
	final static UI_Elements	LINK_CANCEL_RECALL				= UIFactory.getElements("LINK_CANCEL_RECALL");
	final static UI_Elements	POPUP_RECALLING					= UIFactory.getElements("POPUP_RECALLING");

	void clickOnEditLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnDeleteLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnRecallApproveRequestLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnRemindApproverLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCopyLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCreateReceiptLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnCloseLink(WebDriver driver, String testcaseName) throws ActionBotException;

	boolean isCloseLinkPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	void performRecallActions(WebDriver driver, String testcaseName, String recallActions) throws ActionBotException;
}
