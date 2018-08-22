/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.emailpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalEmailPODocument
{
	static UI_Elements	TEXTBOX_EMAIL_TO						= UIFactory.getElements("TEXTBOX_EMAIL_TO");
	static UI_Elements	ADD_EXTERNAL_MAIL_LINK					= UIFactory.getElements("ADD_EXTERNAL_MAIL_LINK");
	static UI_Elements	TEXTBOX_EMAIL_MESSAGE					= UIFactory.getElements("TEXTBOX_EMAIL_MESSAGE");
	static UI_Elements	BUTTON_SEND_EMAIL						= UIFactory.getElements("BUTTON_SEND_EMAIL");
	static UI_Elements	BUTTON_CANCEL_VIEW_PO					= UIFactory.getElements("BUTTON_CANCEL_VIEW_PO");
	static UI_Elements	CHECKBOX_SEND_COPY						= UIFactory.getElements("CHECKBOX_SEND_COPY");
	static UI_Elements	LABEL_ADDED_TO_VALUE					= UIFactory.getElements("LABEL_ADDED_TO_VALUE");
	static UI_Elements	SEND_EMAIL_PROCESSING_DIV				= UIFactory.getElements("SEND_EMAIL_PROCESSING_DIV");
	static UI_Elements	WINDOW_TITLE_EMAIL_PO_DOC				= UIFactory.getElements("WINDOW_TITLE_EMAIL_PO_DOC");
	static UI_Elements	EMAIL_LIST								= UIFactory.getElements("EMAIL_LIST");
	static UI_Elements	CANCEL_RECIPIENT						= UIFactory.getElements("CANCEL_RECIPIENT");
	static UI_Elements	LINK_ATTACHMENT_PO						= UIFactory.getElements("LINK_ATTACHMENT_PO");
	static UI_Elements	ERROR_MSG_ADD_EXTERNAL_MAIL				= UIFactory.getElements("ERROR_MSG_ADD_EXTERNAL_MAIL");
	static UI_Elements	ERROR_MSG_PLEASE_ADD_MSG_TO_SEND_MAIL	= UIFactory.getElements("ERROR_MSG_PLEASE_ADD_MSG_TO_SEND_MAIL");
	UI_Elements			LINK_CLICK_TO_ADD_EMAIL_ADDRESS			= UIFactory.getElements("LINK_CLICK_TO_ADD_EMAIL_ADDRESS");

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String clickOnEmailMessageFieldAndGet(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public void clickOnSendCopyCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendEmailButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddExternalEmailLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillEmailMessageField(WebDriver driver, String testCaseName, String message) throws ActionBotException;

	public String fillEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public String fillOtherEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public String getAddedMailid(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAttachmentLinkText(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getModalWindowTitle(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAbleToclickOnAttachmentPo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCancelRecipientPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSendEmailSuccessDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorMsgAddMsgToSendMailPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorMsgForMailIdOfOutSideUserdisplayed(WebDriver driver, String testCaseName) throws ActionBotException;
}
