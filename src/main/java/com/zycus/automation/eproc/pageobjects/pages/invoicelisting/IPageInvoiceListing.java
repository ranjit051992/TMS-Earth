/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invoicelisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageInvoiceListing
{
	static UI_Elements	FILTER_INVOICE_NO				= UIFactory.getElements("FILTER_INVOICE_NO");
	static UI_Elements	TEXTBOX_FILTER_INVOICE_NO		= UIFactory.getElements("TEXTBOX_FILTER_INVOICE_NO");
	static UI_Elements	LINK_INVOICE_ACTIONS			= UIFactory.getElements("LINK_INVOICE_ACTIONS");
	static UI_Elements	LABEL_INVOICE_STATUS			= UIFactory.getElements("LABEL_INVOICE_STATUS");
	static UI_Elements	BUTTON_ADD_INVOICE				= UIFactory.getElements("BUTTON_ADD_INVOICE");
	static UI_Elements	BUTTON_FROM_PURCHASE_ORDER		= UIFactory.getElements("BUTTON_FROM_PURCHASE_ORDER");
	static UI_Elements	BUTTON_CREATE_NON_PO_INVOICE	= UIFactory.getElements("BUTTON_CREATE_NON_PO_INVOICE");
	static UI_Elements	INVOICE_LISTING_PROCESSING		= UIFactory.getElements("INVOICE_LISTING_PROCESSING");
	static UI_Elements	LINK_FIRST_INVOICE_NO			= UIFactory.getElements("LINK_FIRST_INVOICE_NO");
	static UI_Elements	CONFIRM_INVOICE_PROCESSING_DIV	= UIFactory.getElements("CONFIRM_INVOICE_PROCESSING_DIV");
	static UI_Elements	CLOSE_INVOICE_PROCESSING_DIV	= UIFactory.getElements("CLOSE_INVOICE_PROCESSING_DIV");
	static UI_Elements	RETURN_INVOICE_PROCESSING_DIV	= UIFactory.getElements("RETURN_INVOICE_PROCESSING_DIV");
	static UI_Elements	VOID_INVOICE_PROCESSING_DIV		= UIFactory.getElements("VOID_INVOICE_PROCESSING_DIV");
	static UI_Elements	RECALL_INVOICE_PROCESSING_DIV	= UIFactory.getElements("RECALL_INVOICE_PROCESSING_DIV");

	public void clickOnFromPurchaseOrderButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateNonInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void clickOnInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException;

}
