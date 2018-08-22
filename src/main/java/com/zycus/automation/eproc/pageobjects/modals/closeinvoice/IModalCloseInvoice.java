/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closeinvoice;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalCloseInvoice
{
	static UI_Elements	TEXTBOX_CLOSE_INVOICE_COMMENT	= UIFactory.getElements("TEXTBOX_CLOSE_INVOICE_COMMENT");
	static UI_Elements	BUTTON_CLOSE_INVOICE			= UIFactory.getElements("BUTTON_CLOSE_INVOICE");
	static UI_Elements	BUTTON_CANCEL_CLOSE_INVOICE		= UIFactory.getElements("BUTTON_CANCEL_CLOSE_INVOICE");

	public String fillCloseComments(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException;

	public void clickOnCloseInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
