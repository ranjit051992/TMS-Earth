/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poinvoicelistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPOInvoiceListingActions
{
	static UI_Elements	LINK_VIEW_INVOICE_ACTIONS				= UIFactory.getElements("LINK_VIEW_INVOICE_ACTIONS");
	static UI_Elements	LINK_CONFIRM_AND_MATCH_INVOICE_ACTIONS	= UIFactory.getElements("LINK_CONFIRM_AND_MATCH_INVOICE_ACTIONS");
	static UI_Elements	LINK_RETURN_INVOICE_ACTIONS				= UIFactory.getElements("LINK_RETURN_INVOICE_ACTIONS");
	static UI_Elements	LINK_VOID_INVOICE_ACTIONS				= UIFactory.getElements("LINK_VOID_INVOICE_ACTIONS");
	static UI_Elements	LINK_RECALL_INVOICE_ACTIONS				= UIFactory.getElements("LINK_RECALL_INVOICE_ACTIONS");
	static UI_Elements	PROGRESSING_DIV_CONFIRM_INVOICE			= UIFactory.getElements("PROGRESSING_DIV_CONFIRM_INVOICE");
	static UI_Elements	LINK_EDIT_INVOICE_ACTIONS				= UIFactory.getElements("LINK_EDIT_INVOICE_ACTIONS");
	static UI_Elements	LINK_CLOSE_INVOICE_ACTIONS				= UIFactory.getElements("LINK_CLOSE_INVOICE_ACTIONS");

	public void clickOnViewInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConfirmAndMatchInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnVoidInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecallInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

}
