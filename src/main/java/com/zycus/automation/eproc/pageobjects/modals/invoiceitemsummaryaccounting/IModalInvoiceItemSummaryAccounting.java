/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummaryaccounting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceItemSummaryAccounting
{
	static UI_Elements	SELECT_GL_TYPE_INVOICE		= UIFactory.getElements("SELECT_GL_TYPE_INVOICE");
	static UI_Elements	TEXTBOX_GL_ACCOUNT_INVOICE	= UIFactory.getElements("TEXTBOX_GL_ACCOUNT_INVOICE");

	public String fillAccountingGLType(WebDriver driver, String testCaseName, String accountingGLType) throws ActionBotException;

	public String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode) throws ActionBotException;

	public String getGlAccountType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException;
}
