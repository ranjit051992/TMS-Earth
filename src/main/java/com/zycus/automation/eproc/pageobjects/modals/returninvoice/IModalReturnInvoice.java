/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.returninvoice;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalReturnInvoice
{
	static UI_Elements	TEXTBOX_RETURN_INVOICE_COMMENT	= UIFactory.getElements("TEXTBOX_RETURN_INVOICE_COMMENT");
	static UI_Elements	BUTTON_RETURN_INVOICE			= UIFactory.getElements("BUTTON_RETURN_INVOICE");
	static UI_Elements	BUTTON_CANCEL_RETURN_INVOICE	= UIFactory.getElements("BUTTON_CANCEL_RETURN_INVOICE");

	public String fillReturnInvoiceComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException;

	public void clickOnReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReturnInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
