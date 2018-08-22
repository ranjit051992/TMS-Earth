/**
 * 
 */
package com.zycus.automation.eproc.businessflow.invoicelisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.closeinvoice.ModalCloseInvoice;
import com.zycus.automation.eproc.pageobjects.modals.invoiceactions.ModalInvoiceActions;
import com.zycus.automation.eproc.pageobjects.modals.invoicenofilter.ModalInvoiceNoFilter;
import com.zycus.automation.eproc.pageobjects.modals.recallinvoice.ModalRecallApprovalInvoiceRequest;
import com.zycus.automation.eproc.pageobjects.modals.returninvoice.ModalReturnInvoice;
import com.zycus.automation.eproc.pageobjects.modals.voidinvoice.ModalVoidInvoice;
import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.PageInvoiceListing;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class FlowInvoiceListing
{
	static Logger logger = Logger.getLogger(FlowInvoiceListing.class);

	public static boolean searchInvoice(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		boolean flag = false;

		MainPageHeaderLevelTab.clickOnInvoiceSubTab(driver, testCaseName);
		PageInvoiceListing.clickOnFilterInvoiceNo(driver, testCaseName);
		ModalInvoiceNoFilter.fillInvoiceNo(driver, testCaseName, invoiceNo);
		ModalInvoiceNoFilter.clickOnInvoiceNoFilterButton(driver, testCaseName);

		flag = checkIfInvoiceIsSearched(driver, testCaseName, invoiceNo);
		return flag;
	}

	public static boolean checkIfInvoiceIsSearched(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		return invoiceNo.equalsIgnoreCase(PageInvoiceListing.getFirstInvoiceNo(driver, testCaseName));
	}

	public static void confirmAndMatchInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (PageInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.SUBMITTED_FILTER_LABEL))
		{
			PageInvoiceListing.clickOnInvoiceActions(driver, testCaseName);
			ModalInvoiceActions.clickOnConfirmAndMatchInVoiceAction(driver, testCaseName);
		}
	}

	public static void closeInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageInvoiceListing.clickOnInvoiceActions(driver, testCaseName);
		ModalInvoiceActions.clickOnCloseInVoiceAction(driver, testCaseName);
		ModalCloseInvoice.fillCloseComments(driver, testCaseName, IConstantsData.INVOICE_CLOSE_COMMENT);
		ModalCloseInvoice.clickOnCloseInvoiceButton(driver, testCaseName);
	}

	public static void voidInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageInvoiceListing.clickOnInvoiceActions(driver, testCaseName);
		ModalInvoiceActions.clickOnVoidInVoiceAction(driver, testCaseName);
		ModalVoidInvoice.fillVoidInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_VOID_COMMENT);
		ModalVoidInvoice.clickOnVoidInvoiceButton(driver, testCaseName);
	}

	public static void returnInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageInvoiceListing.clickOnInvoiceActions(driver, testCaseName);
		ModalInvoiceActions.clickOnReturnInVoiceAction(driver, testCaseName);
		ModalReturnInvoice.fillReturnInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RETURN_COMMENT);
		ModalReturnInvoice.clickOnReturnInvoiceButton(driver, testCaseName);
	}

	public static void recallInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageInvoiceListing.clickOnInvoiceActions(driver, testCaseName);
		ModalInvoiceActions.clickOnRecallApprovalRequest(driver, testCaseName);
		ModalRecallApprovalInvoiceRequest.fillRecallApprovalInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RECALL_APPROVAL_REQUEST_COMMENT);
		ModalRecallApprovalInvoiceRequest.clickOnRecallButton(driver, testCaseName);
	}
}
