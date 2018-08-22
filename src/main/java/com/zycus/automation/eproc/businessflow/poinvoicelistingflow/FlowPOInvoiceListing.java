/**
 * 
 */
package com.zycus.automation.eproc.businessflow.poinvoicelistingflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.closeinvoice.ModalCloseInvoice;
import com.zycus.automation.eproc.pageobjects.modals.poinvoicelistingactions.ModalPOInvoiceListingActions;
import com.zycus.automation.eproc.pageobjects.modals.recallinvoice.ModalRecallApprovalInvoiceRequest;
import com.zycus.automation.eproc.pageobjects.modals.returninvoice.ModalReturnInvoice;
import com.zycus.automation.eproc.pageobjects.modals.voidinvoice.ModalVoidInvoice;
import com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting.PagePOInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowPOInvoiceListing
{
	static Logger logger = Logger.getLogger(FlowPOInvoiceListing.class);

	public static boolean checkIfInvoiceCreated(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException, FactoryMethodException
	{
		return PagePOInvoiceListing.getFirstInvoiceNo(driver, testCaseName).equalsIgnoreCase(invoiceNo);
	}

	public static void confirmAndMatchInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		if (PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.SUBMITTED_FILTER_LABEL))
		{
			PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
			ModalPOInvoiceListingActions.clickOnConfirmAndMatchInvoiceActions(driver, testCaseName);
		}
	}

	public static void closeInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
		ModalPOInvoiceListingActions.clickOnCloseInvoiceActions(driver, testCaseName);
		ModalCloseInvoice.fillCloseComments(driver, testCaseName, IConstantsData.INVOICE_CLOSE_COMMENT);
		ModalCloseInvoice.clickOnCloseInvoiceButton(driver, testCaseName);
	}

	public static void voidInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
		ModalPOInvoiceListingActions.clickOnVoidInvoiceActions(driver, testCaseName);
		ModalVoidInvoice.fillVoidInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_VOID_COMMENT);
		ModalVoidInvoice.clickOnVoidInvoiceButton(driver, testCaseName);
	}

	public static void returnInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
		ModalPOInvoiceListingActions.clickOnReturnInvoiceActions(driver, testCaseName);
		ModalReturnInvoice.fillReturnInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RETURN_COMMENT);
		ModalReturnInvoice.clickOnReturnInvoiceButton(driver, testCaseName);
	}

	public static void recallInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
		ModalPOInvoiceListingActions.clickOnRecallInvoiceActions(driver, testCaseName);
		ModalRecallApprovalInvoiceRequest.fillRecallApprovalInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RECALL_APPROVAL_REQUEST_COMMENT);
		ModalRecallApprovalInvoiceRequest.clickOnRecallButton(driver, testCaseName);
	}

	public static void viewInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePOInvoiceListing.clickOnFirstInvoiceNo(driver, testCaseName);
	}

	/*
	 * author: bhakti sawant : to check invoice closed or not
	 */
	public static boolean checkIfInvoiceClosed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
		return PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.CLOSED);
	}
}
