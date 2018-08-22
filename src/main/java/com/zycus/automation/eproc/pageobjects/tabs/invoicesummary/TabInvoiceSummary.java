/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.tabs.invoicesummary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class TabInvoiceSummary
{
	static Logger logger = Logger.getLogger(TabInvoiceSummary.class);

	public static void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceSummary invoiceSummary = FactoryPage.getInstanceOf(ITabInvoiceSummaryImpl.class);
			invoiceSummary.clickOnCostBookingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostBookingTab " + e, e);
		}
	}

	public static void clickOnBillingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ITabInvoiceSummary invoiceSummary = FactoryPage.getInstanceOf(ITabInvoiceSummaryImpl.class);
			invoiceSummary.clickOnBillingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBillingTab " + e, e);
		}
	}

}
