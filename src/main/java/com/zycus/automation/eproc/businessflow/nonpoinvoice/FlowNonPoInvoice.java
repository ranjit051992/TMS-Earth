/**
 * 
 */
package com.zycus.automation.eproc.businessflow.nonpoinvoice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.pageobjects.modals.invoiceitemdetails.ModalInvoiceItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummaryaccounting.ModalInvoiceItemSummaryAccounting;
import com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummarycommon.ModalInvoiceItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.invoicesummarycommon.ModalInvoiceCostBookingSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.invoicesummarycostbooking.ModalInvoiceCostBookingSummary;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.IPageCreateNonPOInvoice;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.IPageCreateNonPOInvoiceImpl;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.PageCreateNonPOInvoice;
import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.PageInvoiceListing;
import com.zycus.automation.eproc.pageobjects.popups.invoiceerror.PopUpInvoicingError;
import com.zycus.automation.eproc.pageobjects.popups.invoicesubmitforapproval.PopUpInvoiceSubmitForApproval;
import com.zycus.automation.eproc.pageobjects.tabs.invoiceitemsummary.TabInvoiceItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.invoicesummary.TabInvoiceSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 *
 */
public class FlowNonPoInvoice
{
	static Logger logger = Logger.getLogger(FlowNonPoInvoice.class);

	public static Invoice createNonPOInvoice(WebDriver driver, String testCaseName, Invoice invoice) throws Exception
	{
		Invoice createdInvoice = new Invoice();

		MainPageHeaderLevelTab.clickOnInvoiceSubTab(driver, testCaseName);
		PageInvoiceListing.clickOnCreateNonInvoiceButton(driver, testCaseName);

		createdInvoice = fillNonPOInvoiceForm(driver, testCaseName, invoice);

		if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_INVOICE))
		{
			submitInvoice(driver, testCaseName);
		}
		else if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_INVOICE))
		{
			saveAsDraftInvoice(driver, testCaseName);
		}
		else if (invoice.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_EDITING_INVOICE))
		{
			cancelInvoice(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}
		return createdInvoice;

	}

	public static Invoice fillNonPOInvoiceForm(WebDriver driver, String testCaseName, Invoice invoice) throws Exception
	{
		Invoice createdInvoice = new Invoice();
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
		if (invoice.getPurchaseType() != null)
		{
			createdInvoice.setPurchaseType(PageCreateNonPOInvoice.selectPurchaseType(driver, testCaseName, invoice.getPurchaseType()));
		}
		ActionBot.defaultSleep();

		// supplier name
		if (invoice.getStandardPO().getSupplierName() != null)
		{
			invoice.getStandardPO().setSupplierName(PageCreateNonPOInvoice.fillSupplierName(driver, testCaseName, invoice.getStandardPO().getSupplierName()));
		}

		ActionBot.defaultSleep();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
		if (invoice.getStandardPO().getSupplierAddress() != null)
		{
			invoice.getStandardPO().setSupplierAddress(PageCreateNonPOInvoice.selectFirstSupplierAddress(driver, testCaseName));
		}
		else
		{
			invoice.getStandardPO().setSupplierAddress(PageCreateNonPOInvoice.selectFirstSupplierAddress(driver, testCaseName));
		}

		if (invoice.getStandardPO().getPaymentTerms() != null)
		{
			invoice.getStandardPO().setPaymentTerms((PageCreateNonPOInvoice.selectPaymentTerms(driver, testCaseName, invoice.getStandardPO().getPaymentTerms())));
		}

		// click on edit
		PageCreateNonPOInvoice.clickOnEditBillingAndDeliveryInfo(driver, testCaseName);
		// click oN costBooking res Summary
		if (invoice.getStandardPO().getCostBookingRequisitionSummary() != null)
		{
			TabInvoiceSummary.clickOnCostBookingTab(driver, testCaseName);
			fillCostBookingPurchaseOrderSummary(driver, testCaseName, invoice.getStandardPO().getCostBookingRequisitionSummary());
		}

		// add item
		invoice.getStandardPO().setItems(addItem(driver, testCaseName, invoice.getStandardPO().getItems()));

		createdInvoice.setStandardPO(invoice.getStandardPO());
		return createdInvoice;

	}

	public static CostBookingRequisitionSummary fillCostBookingPurchaseOrderSummary(WebDriver driver, String testCaseName,
		CostBookingRequisitionSummary costBookingRequisitionSummary) throws ActionBotException
	{

		costBookingRequisitionSummary.setCostCenter(ModalInvoiceCostBookingSummary.fillInCostCenterField(driver, testCaseName, costBookingRequisitionSummary.getCostCenter()));

		costBookingRequisitionSummary.setProject(ModalInvoiceCostBookingSummary.fillInProjectField(driver, testCaseName, costBookingRequisitionSummary.getProject()));

		costBookingRequisitionSummary.setBudget(ModalInvoiceCostBookingSummary.fillInBudgetField(driver, testCaseName, costBookingRequisitionSummary.getBudget()));

		if (costBookingRequisitionSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalInvoiceCostBookingSummaryCommon.clickOnSaveInvoiceSummaryButton(driver, testCaseName);
		}
		if (costBookingRequisitionSummary.getNextAction().equals(IConstantsData.CANCEL))
		{
			ModalInvoiceCostBookingSummaryCommon.clickOnCloseInvoiceSummaryButton(driver, testCaseName);
		}

		return costBookingRequisitionSummary;
	}

	public static Item addItem(WebDriver driver, String testCaseName, Item item) throws Exception
	{
		item.getCatelogItems();
		List<GuidedItem> guidedItems = item.getGuidedItems();

		Item addedItems = new Item();
		List<CatelogItem> addedCatalogItem = new ArrayList<CatelogItem>();
		List<GuidedItem> addedGuidedItems = new ArrayList<GuidedItem>();

		if (guidedItems != null)
		{

			for (int index = 0; index < guidedItems.size(); index++)
			{
				PageCreateNonPOInvoice.clickOnAddItemButton(driver, testCaseName);
				GuidedItem guidedItem = guidedItems.get(index);
				guidedItem = fillGuidedItemForm(driver, testCaseName, guidedItem);
				// guidedItem.setItemID(PageStandardPO.getItemId(driver,
				// testCaseName, guidedItem.getShortDescription()));
				addedGuidedItems.add(guidedItem);
			}

		}
		addedItems.setCatelogItems(addedCatalogItem);
		addedItems.setGuidedItems(guidedItems);
		return addedItems;
	}

	public static GuidedItem fillGuidedItemForm(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws Exception
	{
		int lineNo = 0;
		if (guidedItem.getLineNo() != 0)
		{
			lineNo = guidedItem.getLineNo();
		}
		else
		{
			lineNo = CommonUtilities.getNonZeroRandomNumbers(2);
		}
		guidedItem.setLineNo(ModalInvoiceItemDetails.fillLineNo(driver, testCaseName, lineNo));
		guidedItem.setShortDescription(ModalInvoiceItemDetails.fillShortDescription(driver, testCaseName, guidedItem.getShortDescription()));

		if (guidedItem.getItemType().equals(IConstantsData.Goods))
		{
			ModalInvoiceItemDetails.clickOnItemTypeGoods(driver, testCaseName);
		}
		else if (guidedItem.getItemType().equals(IConstantsData.Services))
		{
			ModalInvoiceItemDetails.clickOnItemTypeServices(driver, testCaseName);
		}

		if (guidedItem.getCategory() != null)
		{
			guidedItem.getCategory().setCategory(ModalInvoiceItemDetails.fillProductCategory(driver, testCaseName, guidedItem.getCategory().getCategory()));
		}

		guidedItem.setPrice(ModalInvoiceItemDetails.fillMarketPrice(driver, testCaseName, guidedItem.getPrice()));
		guidedItem.setQuantity(ModalInvoiceItemDetails.fillQuantity(driver, testCaseName, guidedItem.getQuantity()));

		if (guidedItem.getNextAction().equals(IConstantsData.SAVE))
		{
			TabInvoiceItemSummary.clickOnAccountingTab(driver, testCaseName);

			AccountingItemSummary accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			fillAccountingDetails(driver, testCaseName, accountingItemSummary);
		}
		if (guidedItem.getNextAction().equals(IConstantsData.CANCEL))
		{
			// since CANCEL is same for complete item summary modal
			ModalInvoiceItemSummaryCommon.clickOnCancelButton(driver, testCaseName);
		}

		return guidedItem;

	}

	public static AccountingItemSummary fillAccountingDetails(WebDriver driver, String testCaseName, AccountingItemSummary accountingItemSummary)
		throws ActionBotException, FactoryMethodException
	{
		if (accountingItemSummary.getGlAccountType() != null)
		{
			accountingItemSummary.setGlAccountType(ModalInvoiceItemSummaryAccounting.fillAccountingGLType(driver, testCaseName, accountingItemSummary.getGlAccountType()));
		}
		accountingItemSummary.setGlAccount(ModalInvoiceItemSummaryAccounting.fillAccountingGLAccount(driver, testCaseName, accountingItemSummary.getGlAccount()));

		if (accountingItemSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalInvoiceItemSummaryCommon.clickOnSaveButton(driver, testCaseName);
		}
		if (accountingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalInvoiceItemSummaryCommon.clickOnCancelButton(driver, testCaseName);
		}
		return accountingItemSummary;
	}

	public static void submitInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageCreateNonPOInvoice.clickOnSubmitInvoiceButton(driver, testCaseName);
		// to ignore & submit the invoice
		PopUpInvoicingError.clickOnIgnoreAndSubmitInvoiceButtonPresent(driver, testCaseName);
		PopUpInvoiceSubmitForApproval.clickOnSendForComfirmation(driver, testCaseName);
		//to handle the loader after submitting invoice
		if (ActionBot.isElementDisplayed(driver, IPageCreateNonPOInvoiceImpl.LOADER_CHECKING_INVOICE_DETAILS))
		{
			new WebDriverWait(driver, 8).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(IPageCreateNonPOInvoiceImpl.LOADER_CHECKING_INVOICE_DETAILS.getValue())));
		}
	}

	public static void saveAsDraftInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageCreateNonPOInvoice.clickOnSavAsDraftButton(driver, testCaseName);
	}

	public static void cancelInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageCreateNonPOInvoice.clickOnCancelEditingButton(driver, testCaseName);
	}
}
