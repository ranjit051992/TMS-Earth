package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryAttachmentsAndComments;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOFreeTextItemSummaryAttachmentsAndComments
{
	final UI_Elements	BUTTON_ATTACHMENTS_AND_COMMENTS_FREE_TEXT	= UIFactory.getElements("BUTTON_ATTACHMENTS_AND_COMMENTS_FREE_TEXT");
	final UI_Elements	TEXTBOX_INTERNAL_COMMENTS					= UIFactory.getElements("TEXTBOX_INTERNAL_COMMENTS");
	final UI_Elements	TEXTBOX_COMMENTS_FOR_SUPPLIER				= UIFactory.getElements("TEXTBOX_COMMENTS_FOR_SUPPLIER");

	static UI_Elements	INPUT_PO_ITEM_LEVEL_ATTACHMENT				= UIFactory.getElements("INPUT_PO_ITEM_LEVEL_ATTACHMENT");
	static UI_Elements	LABEL_PO_ITEM_LEVEL_ATTACHMENT_NAME			= UIFactory.getElements("LABEL_PO_ITEM_LEVEL_ATTACHMENT_NAME");
	static UI_Elements	LABEL_PO_ITEM_LEVEL_ATTACHMENT_STATUS		= UIFactory.getElements("LABEL_PO_ITEM_LEVEL_ATTACHMENT_STATUS");
	static UI_Elements	LABEL_PO_ITEM_LEVEL_ATTACHMENT_SIZE			= UIFactory.getElements("LABEL_PO_ITEM_LEVEL_ATTACHMENT_SIZE");
	UI_Elements			SELECT_PO_ITEM_LEVEL_ATTACHMENT_VISIBILITY	= UIFactory.getElements("SELECT_PO_ITEM_LEVEL_ATTACHMENT_VISIBILITY");
	
	public void clickOnAttachmentsAndComments(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterInternalComments(WebDriver driver, String testCaseName, String inetrnalComments) throws ActionBotException;

	public String enterCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException;

}
