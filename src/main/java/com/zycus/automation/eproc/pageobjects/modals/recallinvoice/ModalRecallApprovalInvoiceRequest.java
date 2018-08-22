/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.recallinvoice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRecallApprovalInvoiceRequest
{
	static Logger logger = Logger.getLogger(ModalRecallApprovalInvoiceRequest.class);

	public static String fillRecallApprovalInvoiceComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException
	{
		try
		{
			IModalRecallApprovalInvoiceRequest approvalInvoiceRequest = FactoryPage.getInstanceOf(IModalRecallApprovalInvoiceRequestImpl.class);
			return approvalInvoiceRequest.fillRecallApprovalInvoiceComment(driver, testCaseName, recallComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRecallApprovalInvoiceComment " + e, e);
		}
		return null;
	}

	public static void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalRecallApprovalInvoiceRequest approvalInvoiceRequest = FactoryPage.getInstanceOf(IModalRecallApprovalInvoiceRequestImpl.class);
			approvalInvoiceRequest.clickOnRecallButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallButton " + e, e);
		}
	}

	public static void clickOnCancelRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalRecallApprovalInvoiceRequest approvalInvoiceRequest = FactoryPage.getInstanceOf(IModalRecallApprovalInvoiceRequestImpl.class);
			approvalInvoiceRequest.clickOnCancelRecallButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelRecallButton " + e, e);
		}
	}

}
