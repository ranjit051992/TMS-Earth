/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummarycommon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceItemSummaryCommon
{
	static Logger logger = Logger.getLogger(ModalInvoiceItemSummaryCommon.class);

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryCommon itemSummaryCommon = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryCommonImpl.class);
			itemSummaryCommon.clickOnSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceItemSummaryCommon itemSummaryCommon = FactoryPage.getInstanceOf(IModalInvoiceItemSummaryCommonImpl.class);
			itemSummaryCommon.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

}
