/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.polistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPOListingActions
{

	static UI_Elements	LINK_RECALL_APPROVAL_REQUEST_ACTIONS	= UIFactory.getElements("LINK_RECALL_APPROVAL_REQUEST_ACTIONS");
	static UI_Elements	LINK_REMIND_APPROVER_ACTIONS			= UIFactory.getElements("LINK_REMIND_APPROVER_ACTIONS");
	static UI_Elements	LINK_COPY_ACTIONS						= UIFactory.getElements("LINK_COPY_ACTIONS");
	static UI_Elements	LINK_DOWNLOAD_ACTIONS					= UIFactory.getElements("LINK_DOWNLOAD_ACTIONS");
	static UI_Elements	LINK_CREATE_RECEIPT_ACTIONS				= UIFactory.getElements("LINK_CREATE_RECEIPT_ACTIONS");
	static UI_Elements	LINK_CREATE_INVOICE_ACTIONS				= UIFactory.getElements("LINK_CREATE_INVOICE_ACTIONS");
	static UI_Elements	LINK_CLOSE_ACTIONS						= UIFactory.getElements("LINK_CLOSE_ACTIONS");
	static UI_Elements	LINK_DELETE_ACTIONS						= UIFactory.getElements("LINK_DELETE_ACTIONS");
	static UI_Elements	LINK_AMEND_PO_LISTING_ACTIONS			= UIFactory.getElements("LINK_AMEND_PO_LISTING_ACTIONS");

	public void clickOnRecallApprovalRequestLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDownloadLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateInvoiceLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmendPOLink(WebDriver driver, String testCaseName) throws ActionBotException;

	/**
	 * @author sanjay.kundu
	 */
	public boolean isAmendPOEnable(WebDriver driver, String testCaseName) throws ActionBotException;

}
