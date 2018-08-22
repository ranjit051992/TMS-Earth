/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoicesummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface ITabInvoiceSummary
{
	static UI_Elements	TAB_COST_BOOKING_INVOICE	= UIFactory.getElements("TAB_COST_BOOKING_INVOICE");
	static UI_Elements	TAB_BILLING_INVOICE			= UIFactory.getElements("TAB_BILLING_INVOICE");

	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBillingTab(WebDriver driver, String testCaseName) throws ActionBotException;

}
