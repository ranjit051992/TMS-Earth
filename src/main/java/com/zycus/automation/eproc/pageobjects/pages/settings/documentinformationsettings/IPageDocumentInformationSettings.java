package com.zycus.automation.eproc.pageobjects.pages.settings.documentinformationsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageDocumentInformationSettings
{
	final static UI_Elements	LINK_REQUISITION_INFO				= UIFactory.getElements("LINK_REQUISITION_INFO");
	final static UI_Elements	LINK_PO_INFO						= UIFactory.getElements("LINK_PO_INFO");
	final static UI_Elements	TEXTBOX_PO_DETAILS_TEMPLATE			= UIFactory.getElements("TEXTBOX_PO_DETAILS_TEMPLATE");
	final static UI_Elements	TEXTBOX_PO_ITEM_ROW_TEMPLATE		= UIFactory.getElements("TEXTBOX_PO_ITEM_ROW_TEMPLATE");
	final static UI_Elements	BUTTON_SAVE_DOCUMENT_INFORMATION	= UIFactory.getElements("BUTTON_SAVE_DOCUMENT_INFORMATION");

	public void clickOnRequisitionInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPOInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillPODetailsTemplate(WebDriver driver, String testCaseName, String detailsTemplate) throws ActionBotException;

	public String fillPOItemRowTemplate(WebDriver driver, String testCaseName, String itemRowTemplate) throws ActionBotException;

	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDetailsTemplate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemRowTemplate(WebDriver driver, String testCaseName) throws ActionBotException;
}
