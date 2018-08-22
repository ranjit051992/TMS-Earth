/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.voidinvoice;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalVoidInvoice
{
	static UI_Elements	TEXTBOX_VOID_INVOICE_COMMENT	= UIFactory.getElements("TEXTBOX_VOID_INVOICE_COMMENT");
	static UI_Elements	BUTTON_VOID_INVOICE				= UIFactory.getElements("BUTTON_VOID_INVOICE");
	static UI_Elements	BUTTON_CANCEL_VOID_INVOICE		= UIFactory.getElements("BUTTON_CANCEL_VOID_INVOICE");

	public String fillVoidInvoiceComment(WebDriver driver, String testCaseName, String voidComment) throws ActionBotException;

	public void clickOnVoidInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelVoidButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
