/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycommon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceCostBookingSummaryCommon
{
	static Logger logger = Logger.getLogger(ModalInvoiceCostBookingSummaryCommon.class);

	public static void clickOnSaveInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummaryCommon bookingSummaryCommon = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryCommonImpl.class);
			bookingSummaryCommon.clickOnSaveInvoiceSummaryButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveInvoiceSummaryButton " + e, e);
		}

	}

	public static void clickOnCloseInvoiceSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummaryCommon bookingSummaryCommon = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryCommonImpl.class);
			bookingSummaryCommon.clickOnCloseInvoiceSummaryButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveInvoiceSummaryButton " + e, e);
		}
	}

}
