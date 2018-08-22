package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelItemSummaryAttachment
{
	final static UI_Elements	INTERNAL_COMMENT									= UIFactory.getElements("INTERNAL_COMMENT");
	final static UI_Elements	SUPPLIER_COMMENT									= UIFactory.getElements("SUPPLIER_COMMENT");
	static UI_Elements			INPUT_SELECT_ITEM_LEVEL_ATTACHMENT_ON_CHECKOUT_PAGE	= UIFactory.getElements("INPUT_SELECT_ITEM_LEVEL_ATTACHMENT_ON_CHECKOUT_PAGE");
	static UI_Elements			LABEL_ITEM_LEVEL_ATTACHMENT_NAME_ON_CHECKOUT_PAGE	= UIFactory.getElements("LABEL_ITEM_LEVEL_ATTACHMENT_NAME_ON_CHECKOUT_PAGE");
	static UI_Elements			LABEL_ITEM_LEVEL_ATTACHMENT_STATUS_ON_CHECKOUT_PAGE	= UIFactory.getElements("LABEL_ITEM_LEVEL_ATTACHMENT_STATUS_ON_CHECKOUT_PAGE");
	static UI_Elements			LABEL_ITEM_LEVEL_ATTACHMENT_SIZE_ON_CHECKOUT_PAGE	= UIFactory.getElements("LABEL_ITEM_LEVEL_ATTACHMENT_SIZE_ON_CHECKOUT_PAGE");

	// for fill

	String fillAttachmentInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException;

	String fillAttachmentSupplierlComment(WebDriver driver, String testCaseName, String supplierlComment) throws ActionBotException;

}
