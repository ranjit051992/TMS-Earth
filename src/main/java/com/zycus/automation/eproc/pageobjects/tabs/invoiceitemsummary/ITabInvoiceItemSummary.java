/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoiceitemsummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface ITabInvoiceItemSummary
{
	static UI_Elements	TAB_ITEM_INVOICE				= UIFactory.getElements("TAB_ITEM_INVOICE");
	static UI_Elements	TAB_ITEM_COST_BOOKING_INVOICE	= UIFactory.getElements("TAB_ITEM_COST_BOOKING_INVOICE");
	static UI_Elements	TAB_ITEM_ACCOUNTING_INVOICE		= UIFactory.getElements("TAB_ITEM_ACCOUNTING_INVOICE");
	static UI_Elements	TAB_ITEM_ATTACHMENTS_INVOICE	= UIFactory.getElements("TAB_ITEM_ATTACHMENTS_INVOICE");
	static UI_Elements	TAB_ITEM_TAXES_INVOICE			= UIFactory.getElements("TAB_ITEM_TAXES_INVOICE");

	public void clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAccountingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAttachmentsTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException;

}
