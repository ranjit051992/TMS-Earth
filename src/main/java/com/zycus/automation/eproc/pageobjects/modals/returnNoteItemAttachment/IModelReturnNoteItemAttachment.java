package com.zycus.automation.eproc.pageobjects.modals.returnNoteItemAttachment;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelReturnNoteItemAttachment
{
	static UI_Elements	COMMENTS_AND_ATTACHMENT_ITEM								= UIFactory.getElements("COMMENTS_AND_ATTACHMENT_ITEM");
	static UI_Elements	TEXT_ITEM_INTERNAL_COMMENT									= UIFactory.getElements("TEXT_ITEM_INTERNAL_COMMENT");
	static UI_Elements	TEXT_ITEM_SUPPLIER_COMMENT									= UIFactory.getElements("TEXT_ITEM_SUPPLIER_COMMENT");
	static UI_Elements	ATTACHMENT_RETURN_NOTE_ITEM_ATTACHMENTS						= UIFactory.getElements("ATTACHMENT_RETURN_NOTE_ITEM_ATTACHMENTS");
	static UI_Elements	ATTACHMENT_VISIBILITY_SUPPLIER								= UIFactory.getElements("ATTACHMENT_VISIBILITY_SUPPLIER");
	static UI_Elements	ATTACHMENT_VISIBILITY_ITEM									= UIFactory.getElements("ATTACHMENT_VISIBILITY_ITEM");
	static UI_Elements	SAVE_ATTACHMENT_DIALOG_BUTTON								= UIFactory.getElements("SAVE_ATTACHMENT_DIALOG_BUTTON");
	static UI_Elements	CLOSE_ATTACHMENT_DIALOG_BUTTON								= UIFactory.getElements("CLOSE_ATTACHMENT_DIALOG_BUTTON");
	static UI_Elements	ATTACHMENT_VISIBILITY_RETURN_NOTE							= UIFactory.getElements("ATTACHMENT_VISIBILITY_RETURN_NOTE");
	static UI_Elements	ATTACHMENT_RN_HEADER_LEVEL_ATTACHMENTS						= UIFactory.getElements("ATTACHMENT_RN_HEADER_LEVEL_ATTACHMENTS");
	static UI_Elements	ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK			= UIFactory.getElements("ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK");
	static UI_Elements	ATTACHMENT_VISIBILITY_AT_ITEM_LEVEL							= UIFactory.getElements("ATTACHMENT_VISIBILITY_AT_ITEM_LEVEL");
	static UI_Elements	SAVE_ATTACHMENT_OK_BUTTON_ITEM_LEVEL						= UIFactory.getElements("SAVE_ATTACHMENT_OK_BUTTON_ITEM_LEVEL");
	static UI_Elements	ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK_ITEM_LEVEL	= UIFactory.getElements("ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK_ITEM_LEVEL");

	public String getAttachmentVisibilityWhenNotifySupplierUncheck(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementCommentsAndAttachment(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCommentAndAttachment(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

	public boolean selectFileForAttachmentHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTextItemInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException;

	public String fillTextItemSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException;

	public boolean selectFileForAttachmentInItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSupplierInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSupplierInAttachmentVisibilityAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAttachmentButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAttachmentOkButtonItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseAttachmentbutton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getValueOfAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierCommentTextFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierFieldInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierFieldInAttachmentVisibilityItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

}
