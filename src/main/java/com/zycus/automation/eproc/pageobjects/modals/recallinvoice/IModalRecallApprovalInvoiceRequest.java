/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.recallinvoice;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRecallApprovalInvoiceRequest
{
	static UI_Elements	TEXTBOX_RECALL_APPROVAL_INVOICE_COMMENT	= UIFactory.getElements("TEXTBOX_RECALL_APPROVAL_INVOICE_COMMENT");
	static UI_Elements	BUTTON_RECALL_INVOICE					= UIFactory.getElements("BUTTON_RECALL_INVOICE");
	static UI_Elements	BUTTON_CANCEL_RECALL_INVOICE			= UIFactory.getElements("BUTTON_CANCEL_RECALL_INVOICE");

	public String fillRecallApprovalInvoiceComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException;

	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelRecallButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
