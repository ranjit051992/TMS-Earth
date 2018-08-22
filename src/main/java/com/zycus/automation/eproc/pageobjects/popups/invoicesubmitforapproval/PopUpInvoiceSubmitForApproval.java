/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoicesubmitforapproval;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummarycommon.ModalInvoiceItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpInvoiceSubmitForApproval
{
	static Logger logger = Logger.getLogger(ModalInvoiceItemSummaryCommon.class);

	public static void clickOnSendForComfirmation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoiceSubmitForApproval submitForApproval = FactoryPage.getInstanceOf(IPopUpInvoiceSubmitForApprovalImpl.class);
			submitForApproval.clickOnSendForComfirmation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSendForComfirmation " + e, e);
		}
	}

	public static void clickOnCancelAndEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpInvoiceSubmitForApproval submitForApproval = FactoryPage.getInstanceOf(IPopUpInvoiceSubmitForApprovalImpl.class);
			submitForApproval.clickOnCancelAndEdit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelAndEdit " + e, e);
		}
	}

}
