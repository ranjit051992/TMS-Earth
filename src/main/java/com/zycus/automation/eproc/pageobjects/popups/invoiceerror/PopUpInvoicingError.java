/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoiceerror;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpInvoicingError
{
	static Logger logger = Logger.getLogger(PopUpInvoicingError.class);

	public static boolean isIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoicingError invoicingError = FactoryPage.getInstanceOf(IPopUpInvoicingErrorImpl.class);
			return invoicingError.isIgnoreAndSubmitInvoiceButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isIgnoreAndSubmitInvoiceButtonPresent " + e, e);
		}
		return false;
	}

	public static boolean isReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoicingError invoicingError = FactoryPage.getInstanceOf(IPopUpInvoicingErrorImpl.class);
			return invoicingError.isReviewInvoiceButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReviewInvoiceButtonPresent " + e, e);
		}
		return false;
	}

	public static void clickOnIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoicingError invoicingError = FactoryPage.getInstanceOf(IPopUpInvoicingErrorImpl.class);
			invoicingError.clickOnIgnoreAndSubmitInvoiceButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnIgnoreAndSubmitInvoiceButtonPresent " + e, e);
		}
	}

	public static void clickOnReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoicingError invoicingError = FactoryPage.getInstanceOf(IPopUpInvoicingErrorImpl.class);
			invoicingError.clickOnReviewInvoiceButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReviewInvoiceButtonPresent " + e, e);
		}
	}

}
