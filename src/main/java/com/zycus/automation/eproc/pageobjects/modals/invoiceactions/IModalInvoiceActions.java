/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceActions
{
	static UI_Elements	LINK_VOID_INVOICE						= UIFactory.getElements("LINK_VOID_INVOICE");
	static UI_Elements	LINK_CLOSE_INVOICE						= UIFactory.getElements("LINK_CLOSE_INVOICE");
	static UI_Elements	LINK_RETURN_INVOICE						= UIFactory.getElements("LINK_RETURN_INVOICE");
	static UI_Elements	LINK_VIEW_INVOICE						= UIFactory.getElements("LINK_VIEW_INVOICE");
	static UI_Elements	LINK_CONFIRM_AND_MATCH_INVOICE			= UIFactory.getElements("LINK_CONFIRM_AND_MATCH_INVOICE");
	static UI_Elements	LINK_RECALL_APPROVAL_REQUEST_INVOICE	= UIFactory.getElements("LINK_RECALL_APPROVAL_REQUEST_INVOICE");

	public void clickOnVoidInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfirmAndMatchInVoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecallApprovalRequest(WebDriver driver, String testCaseName) throws ActionBotException;
}
