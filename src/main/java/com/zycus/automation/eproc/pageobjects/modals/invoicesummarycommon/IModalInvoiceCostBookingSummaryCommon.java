/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceCostBookingSummaryCommon
{
	static UI_Elements	BUTTON_SAVE_INVOICE_SUMMARY		= UIFactory.getElements("BUTTON_SAVE_INVOICE_SUMMARY");
	static UI_Elements	BUTTON_CLOSE_INVOICE_SUMMARY	= UIFactory.getElements("BUTTON_CLOSE_INVOICE_SUMMARY");

	public void clickOnSaveInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
