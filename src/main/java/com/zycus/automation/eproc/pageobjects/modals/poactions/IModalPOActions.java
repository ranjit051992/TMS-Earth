package com.zycus.automation.eproc.pageobjects.modals.poactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOActions
{
	final UI_Elements	LINK_COPY_ACTIONS						= UIFactory.getElements("LINK_COPY_ACTIONS");
	final UI_Elements	LINK_CREATE_RECEIPT_ACTIONS				= UIFactory.getElements("LINK_CREATE_RECEIPT_ACTIONS");
	final UI_Elements	LINK_CREATE_INVOICE_ACTIONS				= UIFactory.getElements("LINK_CREATE_INVOICE_ACTIONS");
	final UI_Elements	LINK_DELETE_ACTIONS						= UIFactory.getElements("LINK_DELETE_ACTIONS");
	final UI_Elements	LINK_CLOSE_ACTIONS						= UIFactory.getElements("LINK_CLOSE_ACTIONS");
	final UI_Elements	LINK_DOWNLOAD_ACTIONS					= UIFactory.getElements("LINK_DOWNLOAD_ACTIONS");
	final UI_Elements	LINK_AMEND_PO_ACTIONS					= UIFactory.getElements("LINK_AMEND_PO_ACTIONS");
	final UI_Elements	LINK_RELEASE_PO_ACTIONS					= UIFactory.getElements("LINK_RELEASE_PO_ACTIONS");
	final UI_Elements	LINK_RECALL_APPROVAL_REQUEST_ACTIONS	= UIFactory.getElements("LINK_RECALL_APPROVAL_REQUEST_ACTIONS");

	public void clickOnCopyFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateReceiptFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateInvoiceFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDownloadFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmendPOFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCopyPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCreateReceiptFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReleasePOFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecallApprovalRequestFromActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDownloadPOFromActionsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
