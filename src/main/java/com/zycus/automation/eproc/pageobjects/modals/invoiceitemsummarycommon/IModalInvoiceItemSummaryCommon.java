/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummarycommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceItemSummaryCommon
{
	static UI_Elements	BUTTON_SAVE_INVOICE_ITEM_SUMMARY	= UIFactory.getElements("BUTTON_SAVE_INVOICE_ITEM_SUMMARY");
	static UI_Elements	BUTTON_CANCEL_INVOICE_ITEM_SUMMARY	= UIFactory.getElements("BUTTON_CANCEL_INVOICE_ITEM_SUMMARY");

	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
