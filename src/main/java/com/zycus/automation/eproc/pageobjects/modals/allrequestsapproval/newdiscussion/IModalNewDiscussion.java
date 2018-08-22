/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.newdiscussion;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalNewDiscussion
{
	static UI_Elements	INPUT_TO_FIELD_FOR_NEW_DISCUSSION			= UIFactory.getElements("INPUT_TO_FIELD_FOR_NEW_DISCUSSION");
	static UI_Elements	TEXTAREA_MESSAGE_FOR_NEW_DISCUSSION			= UIFactory.getElements("TEXTAREA_MESSAGE_FOR_NEW_DISCUSSION");
	static UI_Elements	CHECKBOX_SELECT_ALL_FOR_SHARED_WITH			= UIFactory.getElements("CHECKBOX_SELECT_ALL_FOR_SHARED_WITH");
	static UI_Elements	CHECKBOX_SELECT_REQUESTER_FOR_SHARED_WITH	= UIFactory.getElements("CHECKBOX_SELECT_REQUESTER_FOR_SHARED_WITH");
	static UI_Elements	CHECKBOX_SELECT_APPROVAL_FOR_SHARED_WITH	= UIFactory.getElements("CHECKBOX_SELECT_APPROVAL_FOR_SHARED_WITH");
	static UI_Elements	CHECKBOX_SELECT_BUYER_FOR_SHARED_WITH		= UIFactory.getElements("CHECKBOX_SELECT_BUYER_FOR_SHARED_WITH");

	static UI_Elements	INPUT_ADD_ATTACHMENT_FOR_NEW_DISCUSSION		= UIFactory.getElements("INPUT_ADD_ATTACHMENT_FOR_NEW_DISCUSSION");
	static UI_Elements	BUTTON_SUBMIT_ON_NEW_DISCUSSION_FORM		= UIFactory.getElements("BUTTON_SUBMIT_ON_NEW_DISCUSSION_FORM");
	static UI_Elements	BUTTON_CANCEL_ON_NEW_DISCUSSION_FORM		= UIFactory.getElements("BUTTON_CANCEL_ON_NEW_DISCUSSION_FORM");
	static UI_Elements	LABEL_ADDED_TO_NAME							= UIFactory.getElements("LABEL_ADDED_TO_NAME");

	public String fillToFieldForNewDiscussion(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public String fillMessageForNewDiscussion(WebDriver driver, String testCaseName, String message) throws ActionBotException;

	public void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException;

	public void selectAllOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectRequesterOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectApproverOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectBuyerOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
