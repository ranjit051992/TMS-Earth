/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPagePOInvoiceListing
{
	static UI_Elements	LINK_FIRST_INVOICE_NUMBER		= UIFactory.getElements("LINK_FIRST_INVOICE_NUMBER");
	static UI_Elements	LABEL_FIRST_INVOICE_DATE		= UIFactory.getElements("LABEL_FIRST_INVOICE_DATE");
	static UI_Elements	LABEL_FIRST_INVOICE_DUE_DATE	= UIFactory.getElements("LABEL_FIRST_INVOICE_DUE_DATE");
	static UI_Elements	LABEL_FIRST_INVOICE_STATUS		= UIFactory.getElements("LABEL_FIRST_INVOICE_STATUS");
	static UI_Elements	LINK_PO_INVOICE_ACTIONS			= UIFactory.getElements("LINK_PO_INVOICE_ACTIONS");
	static UI_Elements	BUTTON_CREATE_INVOICE			= UIFactory.getElements("BUTTON_CREATE_INVOICE");
	static UI_Elements	LINK_RETURN_INVOICE_ACTIONS		= UIFactory.getElements("LINK_RETURN_INVOICE_ACTIONS");

	public String getFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstInvoiceDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstInvoiceDueDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstInvoiceStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPOInvoiceActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstInvoiceNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateInvoice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnInvoiceAction(WebDriver driver, String testCaseName) throws ActionBotException;

}
