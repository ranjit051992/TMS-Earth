/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicenofilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceNoFilter
{
	static UI_Elements	TEXTBOX_FILTER_INVOICE_NO	= UIFactory.getElements("TEXTBOX_FILTER_INVOICE_NO");
	static UI_Elements	BUTTON_INVOICE_NO_FILTER	= UIFactory.getElements("BUTTON_INVOICE_NO_FILTER");

	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException;

	public void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
