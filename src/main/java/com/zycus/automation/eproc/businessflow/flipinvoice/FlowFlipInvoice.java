/**
 * 
 */
package com.zycus.automation.eproc.businessflow.flipinvoice;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.eproc.businessflow.nonpoinvoice.FlowNonPoInvoice;
import com.zycus.automation.eproc.businessflow.poinvoicelistingflow.FlowPOInvoiceListing;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.PageCreateNonPOInvoice;
import com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting.PagePOInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowFlipInvoice
{
	static Logger logger = Logger.getLogger(FlowFlipInvoice.class);

	public static Invoice fillFlipInvoiceForm(WebDriver driver, String testCaseName, Invoice invoice) throws ActionBotException
	{
		Invoice createdInvoice = new Invoice();

		//add attachment to invoice
		if (invoice.isAddAttachment())
		{
			PageCreateNonPOInvoice.addAttachment(driver, testCaseName, invoice.getFileName());
		}

		if (invoice.getInvoiceNo() != null)
		{
			createdInvoice.setInvoiceNo(PageCreateNonPOInvoice.fillInvoiceNo(driver, testCaseName, invoice.getInvoiceNo()));
		}

		if (invoice.getInvoiceDueDate() != null)
		{

			invoice.getInvoiceDueDate().setDate(PageCreateNonPOInvoice.selectInvoiceDueDate(driver, testCaseName, invoice.getInvoiceDueDate().getDay(),
				invoice.getInvoiceDueDate().getMonth(), invoice.getInvoiceDueDate().getYear()));
			createdInvoice.setInvoiceDueDate(invoice.getInvoiceDueDate());
		}

		if (invoice.getInvoiceDate() != null)
		{
			invoice.getInvoiceDate().setDate(PageCreateNonPOInvoice.selectInvoiceDate(driver, testCaseName, invoice.getInvoiceDate().getDay(), invoice.getInvoiceDate().getMonth(),
				invoice.getInvoiceDate().getYear()));
			createdInvoice.setInvoiceDate(invoice.getInvoiceDate());
		}

		if (invoice.getBuyer() != null)
		{
			createdInvoice.setBuyer(PageCreateNonPOInvoice.fillBuyer(driver, testCaseName, invoice.getBuyer()));
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,750);");

		PageCreateNonPOInvoice.clickOnSelectAllItems(driver, testCaseName);
		return createdInvoice;
	}

	public static Invoice createFlipInvoice(WebDriver driver, String testCaseName, Invoice invoice) throws ActionBotException
	{
		Invoice createdInvoice = new Invoice();
		createdInvoice = fillFlipInvoiceForm(driver, testCaseName, invoice);

		if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_INVOICE))
		{
			FlowNonPoInvoice.submitInvoice(driver, testCaseName);
		}
		else if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_INVOICE))
		{
			FlowNonPoInvoice.saveAsDraftInvoice(driver, testCaseName);
		}
		else if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_EDITING_INVOICE))
		{
			FlowNonPoInvoice.cancelInvoice(driver, testCaseName);
		}
		else if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			// only fill the form and do nothing
		}
		else
		{
			logger.info("Invalid next action");
		}
		return createdInvoice;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create Flip Invoice and confirm and Submit
	 * it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param standardPO </font><b><br>
	 * @param invoice </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static Invoice createFlipInvoiceAndConfirmAndSubmitIt(WebDriver driver, String testCaseName, StandardPO standardPO, Invoice invoice)
		throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		// search po
		logger.info("=============== Search PO ===============");
		flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);
		flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
		assertTrue("Status of PO was not released", flag);

		logger.info("================= Create FlipInvoice ===============");
		// to create flip invoice
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOListingActions.clickOnCreateInvoiceLink(driver, testCaseName);

		invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
		invoice.setStandardPO(standardPO);

		logger.info("================= Search PO ===============");
		// search po
		flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		logger.info("================= View PO ===============");
		// view po
		FlowPoListing.viewPO(driver, testCaseName);
		// view invoice
		PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);

		logger.info("================= View Invoice ===============");
		// to get invoice no
		flag = FlowPOInvoiceListing.checkIfInvoiceCreated(driver, testCaseName, invoice.getInvoiceNo());
		assertTrue("Invoice was not created for released po or status of invoice was wrong", flag);

		logger.info("================= Confirm and match invoice ===============");
		// confirm and match invoice
		FlowPOInvoiceListing.confirmAndMatchInvoice(driver, testCaseName);
		flag = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
		assertTrue("Status of invoice after confirm and match was wrong, it should be In Approval", flag);
		return invoice;
	}
}
