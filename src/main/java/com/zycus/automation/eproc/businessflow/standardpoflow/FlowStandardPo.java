package com.zycus.automation.eproc.businessflow.standardpoflow;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.Tax;
import com.zycus.automation.bo.UpdateAllLinesApplyTax;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryAttachmentsAndComments.ModalPOFreeTextItemSummaryAttachmentsAndComments;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.UpdateAllLinesPO.ModalUpdateAllLinesPO;
import com.zycus.automation.eproc.pageobjects.modals.additemfromreq.ModalAddItemFromRequisition;
import com.zycus.automation.eproc.pageobjects.modals.poattachment.ModalPOAttachment;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling.ModalPurchaseOrderSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.ModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.po.PagePO;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.popups.alertSubmitPO.PopUpAlertSubmitPO;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.Helper;

/**
 * @author amitkumar.dash
 * 
 */
public class FlowStandardPo
{
	static Logger logger = Logger.getLogger(FlowStandardPo.class);

	public static Item addItem(WebDriver driver, String testCaseName, Item item) throws Exception
	{

		List<CatelogItem> catelogItems = item.getCatelogItems();
		List<GuidedItem> guidedItems = item.getGuidedItems();

		Item addedItems = new Item();
		List<CatelogItem> addedCatalogItem = new ArrayList<CatelogItem>();
		List<GuidedItem> addedGuidedItems = new ArrayList<GuidedItem>();

		ActionBot.scroll(driver, "400");
		if (catelogItems != null)
		{
			logger.info("=================== Adding Catalog Item ===================");
			PageStandardPO.clickOnSearchItem(driver);
			for (int index = 0; index < catelogItems.size(); index++)
			{
				CatelogItem catelogItem = catelogItems.get(index);

				catelogItem = searchItem(driver, testCaseName, catelogItem);
				addCatalogItemToCart(driver, testCaseName, catelogItem);

				ActionBot.scroll(driver, "350");
				catelogItem.setItemID(PageStandardPO.getItemId(driver, testCaseName, catelogItem.getItemName()));
				PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, catelogItem.getItemID());
				// to fill cost booking
				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBooking();
				costBookingRequisitionSummary = FlowStandardPo.fillItemSummaryCostBooking(driver, testCaseName, costBookingRequisitionSummary);
				//catelogItem.setUnit_Price(PageStandardPO.getItemUnitPrice(driver, testCaseName, catelogItem.getItemName()));
				//catelogItem.setUom(PageStandardPO.getItemUOM(driver, testCaseName, catelogItem.getItemName()));
				addedCatalogItem.add(catelogItem);
			}
			logger.info("=========================================================");
		}
		if (guidedItems != null)
		{
			logger.info("=================== Adding Guided Item ===================");
			for (int index = 0; index < guidedItems.size(); index++)
			{
				PageStandardPO.clickOnFreeTextItem(driver);
				GuidedItem guidedItem = guidedItems.get(index);
				guidedItem = fillGuidedItemForm(driver, testCaseName, guidedItem);
				ActionBot.scroll(driver, "350");
				ActionBot.defaultSleep();
				guidedItem.setItemID(PageStandardPO.getItemId(driver, testCaseName, guidedItem.getShortDescription()));
				guidedItem.setCurrency(PageStandardPO.getCurrencyOfItem(driver, testCaseName, guidedItem.getItemID()));
				addedGuidedItems.add(guidedItem);
			}
			logger.info("=========================================================");
		}
		addedItems.setCatelogItems(addedCatalogItem);
		addedItems.setGuidedItems(guidedItems);
		return addedItems;
	}

	public static String savePOAsDraft(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String poNo = null;
		poNo = PageStandardPO.getPONo(driver, testCaseName);
		// if PO change field is present
		if (PageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName))
		{
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
		}
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save po as draft");
		poNo = PageStandardPO.getPONo(driver, testCaseName);
		PageStandardPO.clickOnSaveAsDraftPo(driver);
		ActionBot.defaultSleep();
		// if duplicate po no
		if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
		{
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.scrollUp(driver, "300");
			poNo = PageStandardPO.getPONo(driver, testCaseName);
			PageStandardPO.clickOnSaveAsDraftPo(driver);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save po as draft");
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		return poNo;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit PO for processing <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static String submitPoForProcessing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String poNo = null;
		ActionBot.defaultSleep();
		// if PO change field is present
		if (PageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName))
		{
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
		}

		PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
		ActionBot.defaultSleep();
		/*
		 * //if duplicate po no poNo = duplicatePONoValidation(driver,
		 * testCaseName);
		 */

		// verify zero price item popup displayed
		if (PopUpAlertSubmitPO.isAlertPopUpPresent(driver, testCaseName))
		{
			PopUpAlertSubmitPO.clickOnYes(driver, testCaseName);
		}

		PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);

		// if duplicate po no
		poNo = duplicatePONoValidation(driver, testCaseName, false);

		int counter = 0;
		// if PO is edited by other user
		while (PopUpAlertSubmitPO.isAlertOKPresent(driver, testCaseName))
		{
			if (PopUpAlertSubmitPO.isAlertOKPresent(driver, testCaseName))
			{
				PopUpAlertSubmitPO.clickOnOK(driver, testCaseName);
				ActionBot.scrollUp(driver, "300");
				poNo = PageStandardPO.getPONo(driver, testCaseName);
				PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
				/*
				 * //if duplicate po no poNo = duplicatePONoValidation(driver,
				 * testCaseName);
				 */
				PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
				// if duplicate po no
				poNo = duplicatePONoValidation(driver, testCaseName, false);

				counter++;
			}
			if (counter > 4)
			{
				break;
			}
		}
		logger.info("PO No : " + poNo);
		return poNo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To submit PO for processing with Mark for
	 * adding approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param markForAddingApprovers </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static String submitPoForProcessing(WebDriver driver, String testCaseName, boolean markForAddingApprovers) throws ActionBotException, FactoryMethodException
	{
		String poNo = null;
		ActionBot.defaultSleep();
		// if PO change field is present
		if (PageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName))
		{
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
		}

		PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
		ActionBot.defaultLowSleep();
		/*
		 * //if duplicate po no poNo = duplicatePONoValidation(driver,
		 * testCaseName);
		 */
		if (markForAddingApprovers)
		{
			PageStandardPO.clickOnMarkForAddingApprovers(driver, testCaseName);
		}
		PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
		// if duplicate po no
		poNo = duplicatePONoValidation(driver, testCaseName, markForAddingApprovers);

		int counter = 0;
		// if PO is edited by other user
		while (PopUpAlertSubmitPO.isAlertOKPresent(driver, testCaseName))
		{
			if (PopUpAlertSubmitPO.isAlertOKPresent(driver, testCaseName))
			{
				PopUpAlertSubmitPO.clickOnOK(driver, testCaseName);
				ActionBot.scrollUp(driver, "300");
				poNo = PageStandardPO.getPONo(driver, testCaseName);
				PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
				/*
				 * //if duplicate po no poNo = duplicatePONoValidation(driver,
				 * testCaseName);
				 */if (markForAddingApprovers)
				{
					PageStandardPO.clickOnMarkForAddingApprovers(driver, testCaseName);
				}
				PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
				// if duplicate po no
				poNo = duplicatePONoValidation(driver, testCaseName, markForAddingApprovers);
				counter++;
			}
			if (counter > 4)
			{
				break;
			}
		}
		logger.info("PO No : " + poNo);
		return poNo;
	}

	/**
	 * <b>Author: amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>To create standard PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param standardpo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </font><b><br>
	 * @throws ItemException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static StandardPO createStandardPo(WebDriver driver, String testCaseName, StandardPO standardpo) throws Exception
	{
		MainPageHeaderLevelTab.clickOnPOTab(driver);

		PagePO.clickOnStandardPO(driver, testCaseName);

		// fill standard PO creation form
		standardpo = fillStandardPoCreationForm(driver, testCaseName, standardpo);

		// next action
		if (standardpo.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_PO_FOR_PROCESSING))
		{
			String poNo = null;
			if (standardpo.isMarkForAddingApprovers())
			{
				poNo = submitPoForProcessing(driver, testCaseName, standardpo.isMarkForAddingApprovers());
				if (poNo != null)
				{
					standardpo.setPoNumber(poNo);
				}
			}
			else
			{
				poNo = submitPoForProcessing(driver, testCaseName);
				if (poNo != null)
				{
					standardpo.setPoNumber(poNo);
				}
			}
		}
		if (standardpo.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_PO_AS_DRAFT))
		{
			String poNO = null;
			poNO = savePOAsDraft(driver, testCaseName);
			if (poNO != null)
				standardpo.setPoNumber(poNO);
		}
		if (standardpo.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageStandardPO.clickOnCancelPo(driver);
		}
		if (standardpo.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			// only fill the form and do nothing
		}
		return standardpo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill standard PO creation form <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param standardpo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </font><b><br>
	 * @throws ItemException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static StandardPO fillStandardPoCreationForm(WebDriver driver, String testCaseName, StandardPO standardpo) throws Exception
	{
		// PO No
		standardpo.setPoNumber(PageStandardPO.getPONo(driver, testCaseName));

		// order description
		if (standardpo.getOrderDescription() != null)
		{
			standardpo.setOrderDescription(PageStandardPO.enterOrderDescription(driver, standardpo.getOrderDescription()));
		}

		// supplier name
		if (standardpo.getSupplierName() != null)
		{
			standardpo.setSupplierName(PageStandardPO.enterSupplierName(driver, standardpo.getSupplierName()));
		}

		standardpo.setSupplierAddress(PageStandardPO.selectFirstSupplierAddress(driver, testCaseName));

		// currency type
		if (standardpo.getCurrencyType() != null)
		{
			standardpo.setCurrencyType(PageStandardPO.enterCurrencyType(driver, standardpo.getCurrencyType()));
		}
		else if (PageStandardPO.isSupplierCurrencyEditable(driver, testCaseName))
		{
			if (PageStandardPO.getCurrencyType(driver, testCaseName).length() == 0 || PageStandardPO.getCurrencyType(driver, testCaseName) == null)
			{
				standardpo.setCurrencyType(PageStandardPO.enterCurrencyType(driver, "USD"));
			}
		}
		else
		{
			standardpo.setCurrencyType(PageStandardPO.getSupplierCurrency(driver, testCaseName));
		}

		// delivery terms
		if (PageStandardPO.isSelectSupplierDeliveryTermPresent(driver, testCaseName))
		{
			if (standardpo.getDeliveryTerms() != null)
			{
				PageStandardPO.selectDeliveryTerms(driver, standardpo.getDeliveryTerms());
			}
			else if (PageStandardPO.getSelectedDeliveryTerm(driver, testCaseName).equalsIgnoreCase(IConstantsData.SELECT_OPTION_DEFAULT_VALUE))
			{
				PageStandardPO.selectDeliveryTerms(driver, null);
			}
		}
		else if (PageStandardPO.isSupplierDeliveryTermsdisplayedAslabel(driver))
		{
			standardpo.setDeliveryTerms(PageStandardPO.getSupplierDeliveryTermFromLabel(driver, testCaseName));
		}

		// purchase type
		if (PageStandardPO.isPurchaseTypePresent(driver, testCaseName))
		{
			standardpo.setPurchaseType(PageStandardPO.enterPurchaseType(driver, standardpo.getPurchaseType()));
		}

		// buyer
		if (standardpo.getBuyer() != null)
		{
			standardpo.setBuyer(PageStandardPO.enterBuyer(driver, standardpo.getBuyer()));
		}

		// payment terms
		if (standardpo.getPaymentTerms() != null)
		{
			standardpo.setPaymentTerms(PageStandardPO.enterPaymentTerms(driver, standardpo.getPaymentTerms()));
		}
		else
			standardpo.setPaymentTerms(PageStandardPO.getSupplierPaymentTerms(driver, testCaseName));
		// contact no
		standardpo.setPoContact(PageStandardPO.getSupplierContact(driver, testCaseName));

		// custom date
		if (standardpo.getCustomDate() != null)
		{
			standardpo.getCustomDate().setDate(PageStandardPO.fillRequiredByDate(driver, testCaseName, standardpo.getCustomDate().getDay(), standardpo.getCustomDate().getMonth(),
				standardpo.getCustomDate().getYear()));
		}

		// requester
		if (standardpo.getRequester() != null)
		{
			standardpo.setRequester(PageStandardPO.enterRequester(driver, testCaseName, standardpo.getRequester()));
		}

		// click on edit
		if (standardpo.isEditHeaderLevelInfo())
		{
			PageStandardPO.clickOnEdit(driver);
			if (standardpo.getBillingRequisitionSummary() != null)
			{
				standardpo.setBillingRequisitionSummary(fillBillingSummary(driver, testCaseName, standardpo.getBillingRequisitionSummary()));
			}
			else
			{
				standardpo.setBillingRequisitionSummary(getBillingSummary(driver, testCaseName));
			}
			// click oN costBooking res Summary
			if (standardpo.getCostBookingRequisitionSummary() != null)
			{
				TabPOSummary.clickOnCostBookingPOSummary(driver);
				fillCostBookingPurchaseOrderSummary(driver, testCaseName, standardpo.getCostBookingRequisitionSummary());
			}
		}

		ActionBot.scroll(driver, "650");

		// attachment
		if (standardpo.getAttachments() != null)
		{
			if (standardpo.getAttachments().size() != 0)
			{
				List<FileAttachment> attachedFiles = new ArrayList<FileAttachment>();
				PageStandardPO.clickOnPOAddAttachmentLink(driver, testCaseName);
				for (FileAttachment attachment : standardpo.getAttachments())
				{
					FileAttachment attachedFile = new FileAttachment();
					ModalPOAttachment.fillAttachmentFileName(driver, testCaseName, attachment.getFileName());

					attachedFile.setFileName(ModalPOAttachment.getAttachmentName(driver, testCaseName));

					String status = ModalPOAttachment.getAttachmentStatus(driver, testCaseName);
					String size = ModalPOAttachment.getAttachmentSize(driver, testCaseName);

					attachedFile.setFileStatus(status);
					attachedFile.setFileSize(size);

					if (attachment.getFileVisibility() != null)
					{
						attachment.setFileVisibility(ModalPOAttachment.selectVisibility(driver, testCaseName, attachment.getFileVisibility(), attachedFile.getFileName()));
					}
					if (!status.equalsIgnoreCase(IConstantsData.Uploaded) || size.equalsIgnoreCase("0 KB"))
					{
						Assert.assertFalse(true, "File was not uploaded");
					}

					if (!PageStandardPO.getLabelValueOfPOAddAttachmentLink(driver, testCaseName).equalsIgnoreCase(IConstantsData.Label_Value_Of_Attachment))
					{
						Assert.assertFalse(true, "File was not uploaded properly and not shown on checkout page");
					}
					attachedFiles.add(attachedFile);
				}

				standardpo.setAttachments(attachedFiles);
				ModalPOAttachment.clickOnDoneButton(driver, testCaseName);
			}
		}

		// add item
		standardpo.setItems(addItem(driver, testCaseName, standardpo.getItems()));
		ActionBot.defaultSleep();
		ActionBot.scroll(driver);
		ScreenShot.screenshot(driver, testCaseName, "After adding items to PO");

		// item level info
		// catalog item
		for (CatelogItem catelogItem : standardpo.getItems().getCatelogItems())
		{
			String itemID = catelogItem.getItemID();
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			// attachment and comments
			if (catelogItem.getAttachmentsAndCommentsItemSummary() != null)
			{
				ModalPOFreeTextItemSummaryAttachmentsAndComments.clickOnAttachmentsAndComments(driver, testCaseName);
				catelogItem.setAttachmentsAndCommentsItemSummary(fillAttachmentsAndComments(driver, testCaseName, catelogItem.getAttachmentsAndCommentsItemSummary()));
			}
			if (standardpo.getAccountingItemSummary() != null)
			{
				// ModalPOItemSummaryAccounting.clickOnAccounting(driver);
				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				fillAccountingDetails(driver, testCaseName, standardpo.getAccountingItemSummary());
			}
		}

		// terms and condition
		standardpo.setTermsAndConditions(PageStandardPO.fillTermsAndConditions(driver, testCaseName, standardpo.getTermsAndConditions()));

		// notes
		if (standardpo.getNotes() != null)
		{
			standardpo.setNotes(PageStandardPO.enterNotes(driver, testCaseName, standardpo.getNotes()));
		}
		else
		{
			standardpo.setNotes(PageStandardPO.enterNotes(driver, testCaseName, null));
		}
		// PO change comment
		// standardpo.setPoChange(PageStandardPO.fillPOChangeField(driver,
		// standardpo.getPoChange()));

		if (standardpo.isRemoveAllTaxes())
		{
			PageStandardPO.clickOnRemoveAllTaxesOption(driver, testCaseName);
		}
		// po total
		standardpo.setPoTotal(PageStandardPO.getPOTotalPrice(driver, testCaseName));

		return standardpo;
	}

	public static AccountingItemSummary fillAccountingDetails(WebDriver driver, String testCaseName, AccountingItemSummary accountingItemSummary)
		throws ActionBotException, FactoryMethodException
	{
		AccountingItemSummary accountingItemSummary2 = new AccountingItemSummary();
		if (accountingItemSummary.getGlAccount() != null)
		{
			accountingItemSummary2.setGlAccount(ModalPOItemSummaryCostAllocation.fillGLAccount(driver, accountingItemSummary.getGlAccount()));
		}

		if (accountingItemSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
		}
		if (accountingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
		}
		return accountingItemSummary2;
	}

	public static CostBookingRequisitionSummary fillCostBookingPurchaseOrderSummary(WebDriver driver, String testCaseName,
		CostBookingRequisitionSummary costBookingRequisitionSummary) throws ActionBotException
	{

		if (costBookingRequisitionSummary.isBookCostToSingleCostCenter())
		{
			// ModelRequisitionSummaryCostBooking.selectCostBookingOptionSingleCC(driver,
			// testCaseName);

			costBookingRequisitionSummary.setCostCenter(ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, costBookingRequisitionSummary.getCostCenter()));

			costBookingRequisitionSummary.setProject(ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, costBookingRequisitionSummary.getProject()));

			costBookingRequisitionSummary.setBudget(ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, costBookingRequisitionSummary.getBudget()));

			if (costBookingRequisitionSummary.getNextAction().equals(IConstantsData.SAVE))
			{
				ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			}
			if (costBookingRequisitionSummary.getNextAction().equals(IConstantsData.CANCEL))
			{
				ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			}
		}

		return costBookingRequisitionSummary;
	}

	public static GuidedItem fillGuidedItemForm(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws Exception
	{
		if (guidedItem.getLineNo() > 0)
			ModalPOFreeTextItemSummaryItem.fillLineNo(driver, testCaseName, guidedItem.getLineNo());
		// line no
		ModalPOFreeTextItemSummaryItem.getLineNo(driver, testCaseName);
		// short desc
		if (guidedItem.getShortDescription() != null)
		{
			guidedItem.setShortDescription(ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, guidedItem.getShortDescription()));
		}
		// long desc
		guidedItem.setLongDescription(ModalPOFreeTextItemSummaryItem.enterlongDescription(driver, testCaseName, guidedItem.getLongDescription()));

		ScreenShot.screenshot(driver, testCaseName, "After filling item description");
		if (guidedItem.getItemType() != null)
		{
			if (guidedItem.getItemType().equals(IConstantsData.Goods))
			{
				ModalPOFreeTextItemSummaryItem.clickOnItemTypeGoods(driver, testCaseName);
			}
			else if (guidedItem.getItemType().equals(IConstantsData.Services))
			{
				ModalPOFreeTextItemSummaryItem.clickOnItemTypeServices(driver, testCaseName);
			}
		}

		if (ModalPOFreeTextItemSummaryItem.isCategoryEditable(driver, testCaseName))
		{
			if (guidedItem.getCategory() == null)
			{
				ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
				category.setCategory(ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, null));
				guidedItem.setCategory(category);
			}
			else
			{
				guidedItem.getCategory().setCategory(ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, guidedItem.getCategory().getCategory()));
			}
		}
		else
		{
			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory(ModalPOFreeTextItemSummaryItem.getLabelValueOfCategory(driver, testCaseName));
			guidedItem.setCategory(category);
		}

		if (guidedItem.getReceiveBy() != null)
		{
			if (guidedItem.getReceiveBy().equals(IConstantsData.Quantity))
			{
				ModalPOFreeTextItemSummaryItem.clickOnReceiveBillByQuantity(driver, testCaseName);
			}
			else if (guidedItem.getReceiveBy().equals(IConstantsData.Amount))
			{
				ModalPOFreeTextItemSummaryItem.clickOnReceiveBillByAmount(driver, testCaseName);
			}
			else if (guidedItem.getReceiveBy().equals(IConstantsData.No_Receipt))
			{
				ModalPOFreeTextItemSummaryItem.clickOnReceiveBillByNoReceipt(driver, testCaseName);
			}
		}
		if (guidedItem.getPrice() != 0.0)
		{
			// market price
			guidedItem.setPrice(ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, guidedItem.getPrice()));
		}
		// guidedItem.setCurrency(ModalPOFreeTextItemSummaryItem.getCurrencyOfMarketPriceOfItem(driver,
		// testCaseName));
		// for zero price item
		if (guidedItem.isZeroPriceItem())
		{
			ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
		}

		// uom
		if (guidedItem.getUom() != null)
			guidedItem.setUom(ModalPOFreeTextItemSummaryItem.fillUOM(driver, testCaseName, guidedItem.getUom()));
		else
			guidedItem.setUom(ModalPOFreeTextItemSummaryItem.getUOM(driver, testCaseName));

		// quantity
		if (guidedItem.getQuantity() != 0)
		{
			float qty = 0;
			if (!guidedItem.getUom().equalsIgnoreCase("EA") || !guidedItem.getUom().equalsIgnoreCase("EACH"))
			{
				qty = ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, guidedItem.getQuantity());
			}
			else
			{
				qty = ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, guidedItem.getQuantity().intValue());
			}
			guidedItem.setQuantity(qty);
		}

		ActionBot.scroll(driver);
		// ModalPOFreeTextItemSummaryItem.clickOnIsPreferredRadioButton(driver,
		// testCaseName);

		/*
		 * guidedItem.setSpecification(ModalPOFreeTextItemSummaryItem.
		 * fillSpecificationsName(driver, testCaseName,
		 * guidedItem.getSpecification()));
		 */

		// max unit price
		if (guidedItem.getMaxUnitPrice() != 0)
		{
			guidedItem.setMaxUnitPrice(ModalPOFreeTextItemSummaryItem.fillMaxUnitPrice(driver, testCaseName, guidedItem.getMaxUnitPrice()));
		}
		// max total price
		if (guidedItem.getMaxTotalPrice() != 0)
		{
			guidedItem.setMaxTotalPrice(ModalPOFreeTextItemSummaryItem.fillMaxTotalPrice(driver, testCaseName, guidedItem.getMaxTotalPrice()));
		}
		if (guidedItem.getContractNo() != null)
		{
			guidedItem.setContractNo(ModalPOFreeTextItemSummaryItem.fillContractNumber(driver, testCaseName, guidedItem.getContractNo()));
		}
		ScreenShot.screenshot(driver, testCaseName, "After filling guided item details");
		if (guidedItem.getNextAction().equals(IConstantsData.SAVE))
		{
			// for attachments and comments
			if (guidedItem.getAttachmentsAndCommentsItemSummary() != null)
			{
				ModalPOFreeTextItemSummaryAttachmentsAndComments.clickOnAttachmentsAndComments(driver, testCaseName);
				guidedItem.setAttachmentsAndCommentsItemSummary(fillAttachmentsAndComments(driver, testCaseName, guidedItem.getAttachmentsAndCommentsItemSummary()));
			}

			// for accounting item summary
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			/*
			 * if (ModalPOItemSummaryAccounting.getGLAccountType(driver,
			 * testCaseName).equalsIgnoreCase(
			 * IConstantsData.SELECT_OPTION_DEFAULT_VALUE)) {
			 */
			AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			fillAccountingDetails(driver, testCaseName, accountingItemSummary);
			// }
		}
		if (guidedItem.getNextAction().equals(IConstantsData.CANCEL))
		{
			// since CANCEL is same for complete item summary modal
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
		}
		logger.info("Added Guided Item Details : ");
		logger.info("Item Name : " + guidedItem.getShortDescription());
		logger.info("Quantity : " + guidedItem.getQuantity());
		return guidedItem;

	}

	/*
	 * public static boolean isGLTypeSameAsGLMap(WebDriver driver, String
	 * testCaseName, GLMap glMap) throws ActionBotException,
	 * FactoryMethodException { String glType =
	 * ModalPOFreeTextItemSummaryCostAllocation.getGLAccountType(driver,
	 * testCaseName); String temp[] = StringUtils.split(glType, ":"); String
	 * gl_Type = temp[1].trim();
	 * 
	 * if (gl_Type.equalsIgnoreCase(glMap.getGlAccountType())) { return true; }
	 * else { return false; } }
	 */

	public static boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName, GLMap glMap) throws ActionBotException, FactoryMethodException
	{
		String glAccount = ModalPOFreeTextItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
		String temp[] = StringUtils.split(glAccount, ":");
		String gl_Account = temp[1].trim();
		if (gl_Account.equalsIgnoreCase(glMap.getGlAccount()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill item summary cost booking <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param costBookingRequisitionSummary </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static CostBookingRequisitionSummary fillItemSummaryCostBooking(WebDriver driver, String testCaseName, CostBookingRequisitionSummary costBookingRequisitionSummary)
		throws ActionBotException, FactoryMethodException
	{
		// to fill glAccount
		if (costBookingRequisitionSummary.getGlAccount() != null)
		{
			costBookingRequisitionSummary.setGlAccount(ModalPOItemSummaryCostAllocation.fillGLAccount(driver, costBookingRequisitionSummary.getGlAccount()));
		}

		if (costBookingRequisitionSummary.getCostCenter() != null)
		{
			costBookingRequisitionSummary.setCostCenter(ModalPOItemSummaryCostAllocation.fillCostCenter(driver, testCaseName, costBookingRequisitionSummary.getCostCenter()));
		}
		if (costBookingRequisitionSummary.getProject() != null)
		{
			costBookingRequisitionSummary.setProject(ModalPOItemSummaryCostAllocation.fillProject(driver, testCaseName, costBookingRequisitionSummary.getProject()));
		}
		if (costBookingRequisitionSummary.getBudget() != null)
		{
			costBookingRequisitionSummary.setBudget(ModalPOItemSummaryCostAllocation.fillBudget(driver, testCaseName, costBookingRequisitionSummary.getBudget()));
		}
		// to fill amount
		// to remove the ,
		String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
		String[] temp = StringUtils.split(amount.substring(4), ",");
		amount = "";
		for (String str : temp)
		{
			amount += str;
		}
		ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);

		if (costBookingRequisitionSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
		}
		if (costBookingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
		}
		return costBookingRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search catalog item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param catelogItem </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static CatelogItem searchItem(WebDriver driver, String testCaseName, CatelogItem catelogItem) throws ActionBotException
	{
		catelogItem.setItemName(PageStandardPO.fillAddItemsToPOField(driver, catelogItem.getItemName()));
		PageStandardPO.clickOnSearch(driver);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultHighSleep();
		return catelogItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add catalog item to cart <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param catelogItem </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static void addCatalogItemToCart(WebDriver driver, String testCaseName, CatelogItem catelogItem) throws Exception
	{
		// ActionBot.scroll(driver, "500");
		int index = 0;
		boolean flag = false;
		do
		{
			List<WebElement> searchTexts = PageStandardPO.getListOFSearchedItemNames(driver, testCaseName);

			List<WebElement> quantityInputs = PageStandardPO.fillQuantity(driver, testCaseName);

			List<WebElement> addButtons = PageStandardPO.Additem(driver, testCaseName);

			int itemIndex = 0;
			// int cnt = 1;
			for (WebElement searchText : searchTexts)
			{
				if (catelogItem.getItemName().equalsIgnoreCase(searchText.getText()))
				{
					WebElement quantityElement = quantityInputs.get(itemIndex);
					ActionBot.scroll(driver, quantityElement);
					quantityElement.clear();
					quantityElement.sendKeys(Integer.toString(catelogItem.getQuantity()));
					logger.info("Entered Quantity : " + quantityElement.getAttribute("value").trim());
					ScreenShot.screenshot(driver, testCaseName, "After adding Quantity");
					ActionBot.defaultSleep();
					WebElement addBtnElement = addButtons.get(itemIndex);
					Actions actions = new Actions(driver);
					actions.moveToElement(addBtnElement).click().build().perform();
					// addBtnElement.click();
					ActionBot.defaultSleep();
					/*
					 * ActionBot.waitTillPopUpIsPresent(driver, By.xpath(
					 * ".//*[@id='wrapper']//em[contains(@class,'icon tickActive')]"
					 * ));
					 */
					flag = true;
					break;
				}
				// cnt++;
				++itemIndex;
			}
			if (flag)
			{
				break;
			}
			index++;
			if (PageStandardPO.isNextPaginationPresent(driver, testCaseName))
			{
				PageStandardPO.clickOnNextPagination(driver, testCaseName);
			}
		} while (index < 3);

		ScreenShot.screenshot(driver, testCaseName, "After adding catalog item");
		// to handle other supplier/currency items
		if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
		{
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultSleep();

			// line no
			ModalPOFreeTextItemSummaryItem.getLineNo(driver, testCaseName);

			// to fill cost booking
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBooking();
			costBookingRequisitionSummary = FlowStandardPo.fillItemSummaryCostBooking(driver, testCaseName, costBookingRequisitionSummary);
		}
		logger.info("Added Catalog Item Details : ");
		logger.info("Item Name : " + catelogItem.getItemName());
		logger.info("Quantity : " + catelogItem.getQuantity());
	}

	public static StandardPO createAndReleasedPo(WebDriver driver, String testCaseName, StandardPO standardPO) throws Exception
	{
		// create standard PO
		standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

		driver.navigate().refresh();
		ActionBot.defaultSleep();
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		// search po
		boolean flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);

		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
		{
			assertTrue("Error while searching PO", flag);
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			ActionBot.defaultSleep();
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of PO was not Released", flag);
		}
		return standardPO;
	}

	public static boolean checkIfItemSearched(WebDriver driver, String testCaseName, String searchText, String searchBy) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;

		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_ITEM_NAME))
		{
			flag = searchText.equalsIgnoreCase(PageStandardPO.getFirstItemName(driver));
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_SUPPLIER))
		{
			flag = searchText.equalsIgnoreCase(PageStandardPO.getSupplierContact(driver, testCaseName));
		}
		else
		{
			logger.info("Invalid Search Option");
		}
		return flag;
	}

	public static boolean searchItem(WebDriver driver, String testCaseName, String searchText, String searchBy) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_ITEM_NAME))
		{
			PageStandardPO.fillItemName(driver, testCaseName, searchText);
			ActionBot.defaultSleep();
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BY_SUPPLIER))
		{
			PageStandardPO.fillSupplierName(driver, testCaseName, searchText);
		}
		else
		{
			logger.info("Invalid Search Option");
		}
		ActionBot.waitForPageLoad(driver);
		logger.info("Searching Item with ItemNAme");
		flag = checkIfItemSearched(driver, testCaseName, searchText, searchBy);

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill attachments and comments <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param attachmentsAndCommentsItemSummary </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static AttachmentsAndCommentsItemSummary fillAttachmentsAndComments(WebDriver driver, String testCaseName,
		AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary) throws ActionBotException, FactoryMethodException
	{
		if (attachmentsAndCommentsItemSummary.getInternalComments() != null)
		{
			attachmentsAndCommentsItemSummary.setInternalComments(
				ModalPOFreeTextItemSummaryAttachmentsAndComments.enterInternalComments(driver, testCaseName, attachmentsAndCommentsItemSummary.getInternalComments()));
		}
		if (attachmentsAndCommentsItemSummary.getCommentsForSupplier() != null)
		{
			attachmentsAndCommentsItemSummary.setCommentsForSupplier(
				ModalPOFreeTextItemSummaryAttachmentsAndComments.enterCommentsForSupplier(driver, testCaseName, attachmentsAndCommentsItemSummary.getCommentsForSupplier()));
		}
		if (attachmentsAndCommentsItemSummary.getAttachments().size() > 0)
		{
			int index = 2;
			for (FileAttachment attachment : attachmentsAndCommentsItemSummary.getAttachments())
			{
				ModalPOFreeTextItemSummaryAttachmentsAndComments.fillAttachmentFileName(driver, testCaseName, attachment.getFileName());

				attachment.setFileName(ModalPOFreeTextItemSummaryAttachmentsAndComments.getAttachmentName(driver, testCaseName, index));

				if (attachment.getFileVisibility() != null)
				{
					attachment.setFileVisibility(
						ModalPOFreeTextItemSummaryAttachmentsAndComments.selectVisibility(driver, testCaseName, attachment.getFileVisibility(), attachment.getFileName()));
				}

				String status = ModalPOFreeTextItemSummaryAttachmentsAndComments.getAttachmentStatus(driver, testCaseName, attachment.getFileName());
				String size = ModalPOFreeTextItemSummaryAttachmentsAndComments.getAttachmentSize(driver, testCaseName, attachment.getFileName());
				attachment.setFileStatus(status);
				attachment.setFileSize(size);

				if (!status.equalsIgnoreCase(IConstantsData.Uploaded) || size.equalsIgnoreCase("0 KB"))
				{
					Assert.assertFalse(true, "File was not uploaded");
				}
				index++;
			}
		}
		// to perform next action
		if (attachmentsAndCommentsItemSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
		}
		if (attachmentsAndCommentsItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
		}

		return attachmentsAndCommentsItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if items added <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param items </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean checkIfItemAdded(WebDriver driver, String testCaseName, Item items) throws ActionBotException
	{
		List<WebElement> listOfItemsAdded = PageStandardPO.getListOfItems(driver, testCaseName);
		List<CatelogItem> listOfCatalogItems = null;
		List<GuidedItem> listOfguidedItems = null;
		List<String> addedItemNames = new ArrayList<String>();
		int counter = 0;
		boolean flag = false;
		if (items.getCatelogItems() != null)
		{
			listOfCatalogItems = items.getCatelogItems();
			for (CatelogItem catelogItem : listOfCatalogItems)
			{
				addedItemNames.add(catelogItem.getItemName());
			}
		}
		if (items.getGuidedItems() != null)
		{
			listOfguidedItems = items.getGuidedItems();
			for (GuidedItem guidedItem : listOfguidedItems)
			{
				addedItemNames.add(guidedItem.getShortDescription());
			}
		}

		for (String str : addedItemNames)
		{
			for (WebElement element : listOfItemsAdded)
			{
				if (element.getText().trim().equalsIgnoreCase(str))
				{
					flag = true;
					counter++;
					break;
				}
			}
		}

		flag = counter == addedItemNames.size();
		return flag;
	}

	public static boolean removeItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		PageStandardPO.clickOnCheckBoxOfItem(driver, testCaseName, itemId);
		PageStandardPO.clickOnDeleteButton(driver, testCaseName, itemId);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		return checkIfItemRemoved(driver, testCaseName, itemId);
	}

	public static boolean checkIfItemRemoved(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		boolean flag = true;
		List<WebElement> items = PageStandardPO.getListOfItems(driver, testCaseName);
		for (WebElement element : items)
		{
			String id = element.getAttribute("id").trim();
			String[] temp = StringUtils.split(id, "_");
			if (id.contains("temp"))
			{
				id = "";
				id = temp[2].trim();
			}
			else
			{
				id = "";
				id = temp[1].trim();
			}

			if (id.equalsIgnoreCase(itemId))
			{
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To copy the items <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param item </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean copyItem(WebDriver driver, String testCaseName, Item item) throws ActionBotException, FactoryMethodException
	{
		List<WebElement> listOfItemsAdded = null;
		boolean flag = false;
		int counter = 0;
		if (item.getCatelogItems() != null)
		{
			for (CatelogItem catelogItem : item.getCatelogItems())
			{
				if (catelogItem.getItemID() != null)
				{
					PageStandardPO.clickOnCopyButton(driver, testCaseName, catelogItem.getItemID());
				}
				else if (catelogItem.getItemName() != null)
				{
					PageStandardPO.clickOnCopyButtonUsingItemName(driver, testCaseName, catelogItem.getItemName());
				}
			}
			listOfItemsAdded = PageStandardPO.getListOfItems(driver, testCaseName);

			for (CatelogItem catelogItem : item.getCatelogItems())
			{
				for (WebElement element : listOfItemsAdded)
				{
					if (element.getText().trim().equalsIgnoreCase(catelogItem.getItemName()))
					{
						counter++;
					}
				}
				flag = counter == 2;
			}
		}
		if (item.getGuidedItems() != null)
		{
			for (GuidedItem guidedItem : item.getGuidedItems())
			{
				if (guidedItem.getItemID() != null)
				{
					PageStandardPO.clickOnCopyButton(driver, testCaseName, guidedItem.getItemID());
				}
				else if (guidedItem.getShortDescription() != null)
				{
					PageStandardPO.clickOnCopyButtonUsingItemName(driver, testCaseName, guidedItem.getShortDescription());
				}
			}

			listOfItemsAdded = PageStandardPO.getListOfItems(driver, testCaseName);

			for (GuidedItem guidedItem : item.getGuidedItems())
			{
				for (WebElement element : listOfItemsAdded)
				{
					if (element.getText().trim().equalsIgnoreCase(guidedItem.getShortDescription()))
					{
						counter++;
					}
				}
				flag = counter == 2;
			}
		}
		ScreenShot.screenshot(driver, testCaseName, "After coping item");
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to add items to req to PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param item </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static Item addItemToReqToPO(WebDriver driver, String testCaseName, Item item) throws Exception
	{
		List<CatelogItem> catelogItems = item.getCatelogItems();
		List<GuidedItem> guidedItems = item.getGuidedItems();

		Item addedItems = new Item();
		List<CatelogItem> addedCatalogItem = new ArrayList<CatelogItem>();
		List<GuidedItem> addedGuidedItems = new ArrayList<GuidedItem>();

		CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBooking();

		if (catelogItems != null)
		{
			PageStandardPO.clickOnSearchItem(driver);
			for (int index = 0; index < catelogItems.size(); index++)
			{
				CatelogItem catelogItem = catelogItems.get(index);

				catelogItem = searchItem(driver, testCaseName, catelogItem);
				addCatalogItemToCart(driver, testCaseName, catelogItem);

				ActionBot.scroll(driver, "350");
				catelogItem.setItemID(PageStandardPO.getItemId(driver, testCaseName, catelogItem.getItemName()));
				addedCatalogItem.add(catelogItem);
			}

			addedItems.setCatelogItems(addedCatalogItem);
			// catalog item
			for (CatelogItem catelogItem : addedItems.getCatelogItems())
			{
				String itemID = catelogItem.getItemID();
				PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
				// to fill cost booking
				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				/*
				 * if (ModalPOItemSummaryCostAllocation.getCostCenter(driver,
				 * testCaseName) == null ||
				 * ModalPOItemSummaryCostAllocation.getCostCenter(driver,
				 * testCaseName).length() == 0) {
				 */
				FlowStandardPo.fillItemSummaryCostBooking(driver, testCaseName, costBookingRequisitionSummary);
				// }

			}
		}
		if (guidedItems != null)
		{
			PageStandardPO.clickOnFreeTextItem(driver);
			for (int index = 0; index < guidedItems.size(); index++)
			{
				GuidedItem guidedItem = guidedItems.get(index);
				guidedItem.setNextAction(IConstantsData.NONE);
				guidedItem = fillGuidedItemForm(driver, testCaseName, guidedItem);

				// to fill cost booking
				costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBooking();

				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				/*
				 * if (ModalPOItemSummaryCostAllocation.getCostCenter(driver,
				 * testCaseName) == null ||
				 * ModalPOItemSummaryCostAllocation.getCostCenter(driver,
				 * testCaseName).length() == 0) {
				 */FlowStandardPo.fillItemSummaryCostBooking(driver, testCaseName, costBookingRequisitionSummary);
				// }

				ActionBot.scroll(driver, "350");
				guidedItem.setItemID(PageStandardPO.getItemId(driver, testCaseName, guidedItem.getShortDescription()));
				addedGuidedItems.add(guidedItem);
			}
			addedItems.setGuidedItems(guidedItems);
		}

		return addedItems;
	}

	public static boolean changeThePriceOfItem(WebDriver driver, String testCaseName, String itemId, float amount) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PageStandardPO.clickOnItemName(driver, testCaseName, itemId);
		// ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver,
		// testCaseName);
		ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, amount);

		// to fill amount
		ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
		String updatedAmount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
		String[] temp = StringUtils.split(updatedAmount.substring(4), ",");
		updatedAmount = "";
		for (String str : temp)
		{
			updatedAmount += str;
		}
		ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, updatedAmount);

		ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

		ActionBot.scrollUp(driver, "200");

		// commented section
		/*
		 * String updatedMarketPrice =
		 * PageStandardPO.getMarketPriceOfAddedItem(driver, testCaseName,
		 * itemId); float marketPrice =
		 * Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(
		 * updatedMarketPrice)); flag = marketPrice ==
		 * Float.parseFloat(CommonUtilities.getDecimalPrice(Float.toString(
		 * amount)));
		 */

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add item from requisition in po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @param searchBy </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void addItemFromRequisition(WebDriver driver, String testCaseName, Requisition requisition, String searchBy) throws ActionBotException, FactoryMethodException
	{
		PageStandardPO.clickOnAddItemFromRequisition(driver, testCaseName);
		ModalAddItemFromRequisition.clickOnPendingRequisitionTab(driver, testCaseName);
		if (searchBy.equalsIgnoreCase(IConstantsData.Search_By_Req_No))
		{
			ModalAddItemFromRequisition.fillReqNo(driver, testCaseName, requisition.getReqNo());
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.Search_By_Item_Name))
		{

		}
		else
		{
			logger.info("Incorrect Option");
		}

		ModalAddItemFromRequisition.clickOnFirstRadioButton(driver, testCaseName);
		ModalAddItemFromRequisition.clickOnSelectReqItemButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Update all lines <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param updateAllLinesApplyTax </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static UpdateAllLinesApplyTax updateAllLines(WebDriver driver, String testCaseName, UpdateAllLinesApplyTax updateAllLinesApplyTax)
		throws ActionBotException, FactoryMethodException
	{
		PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);

		int i = 1, size = updateAllLinesApplyTax.getTaxes().size();
		List<Tax> taxes = new ArrayList<Tax>();
		for (Tax tax : updateAllLinesApplyTax.getTaxes())
		{
			if (tax.getTaxType() != null)
			{
				tax.setTaxType(ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, tax.getTaxType(), i + 1));
			}
			if (tax.getTaxName() != null)
			{
				tax.setTaxName(ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, tax.getTaxName(), i + 1));
			}
			if (tax.getTaxRate() != 0)
			{
				tax.setTaxRate(ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, tax.getTaxRate()));
			}

			if (i < size)
			{
				ModalUpdateAllLinesPO.clickOnAddTax(driver, testCaseName);
			}
			taxes.add(tax);
			i++;
		}
		updateAllLinesApplyTax.setTaxes(taxes);
		if (updateAllLinesApplyTax.isApplyWhereApplicableAndNotDefined())
		{
			ModalUpdateAllLinesPO.clickOnApplyWhereApplicableAndNotDefined(driver, testCaseName);
		}
		if (updateAllLinesApplyTax.isApplyWhereNotApplicable())
		{
			ModalUpdateAllLinesPO.clickOnRadioButtonTaxNotApplicable(driver, testCaseName);
		}
		if (updateAllLinesApplyTax.isOverrideWhereDefined())
		{
			ModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);
		}
		if (updateAllLinesApplyTax.isTaxesInclusiveOrNotApplicable())
		{

		}

		if (updateAllLinesApplyTax.getNextAction().equalsIgnoreCase(IConstantsData.applyTax_UpdateAllLines))
		{
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
		}
		else if (updateAllLinesApplyTax.getNextAction().equalsIgnoreCase(IConstantsData.removeAllTaxes_UpdateAllLines))
		{
			ModalUpdateAllLinesPO.clickOnRemoveAllMultipleTaxes(driver, testCaseName);
		}
		else if (updateAllLinesApplyTax.getNextAction().equalsIgnoreCase(IConstantsData.close_UpdateAllLines))
		{
			ModalUpdateAllLinesPO.clickOnCloseUpdateAllLines(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid Option");
		}
		return updateAllLinesApplyTax;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Fill billing summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param billingRequisitionSummary </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static BillingRequisitionSummary fillBillingSummary(WebDriver driver, String testCaseName, BillingRequisitionSummary billingRequisitionSummary) throws Exception
	{
		if (billingRequisitionSummary.getCompany() != null)
		{
			billingRequisitionSummary.setCompany(ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, billingRequisitionSummary.getCompany()));
		}
		if (billingRequisitionSummary.getBusinessUnit() != null)
		{
			billingRequisitionSummary.setBusinessUnit(ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, billingRequisitionSummary.getBusinessUnit()));
		}
		if (billingRequisitionSummary.getLocation() != null)
		{
			billingRequisitionSummary.setLocation(ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
		}

		if (billingRequisitionSummary.getNextAction().equals(IConstantsData.SAVE))
		{
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
		}
		if (billingRequisitionSummary.getNextAction().equals(IConstantsData.CANCEL))
		{
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
		}

		return billingRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Get billing summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param billingRequisitionSummary </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static BillingRequisitionSummary getBillingSummary(WebDriver driver, String testCaseName) throws Exception
	{
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();

		billingRequisitionSummary.setCompany(ModalPurchaseOrderSummaryBilling.getCompany(driver, testCaseName));
		billingRequisitionSummary.setBusinessUnit(ModalPurchaseOrderSummaryBilling.getBusinessUnit(driver, testCaseName));
		billingRequisitionSummary.setLocation(ModalPurchaseOrderSummaryBilling.getLocation(driver, testCaseName));

		return billingRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To perform action on duplicate PO
	 * validation <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static String duplicatePONoValidation(WebDriver driver, String testCaseName, boolean markForAddingApprovers) throws ActionBotException, FactoryMethodException
	{
		String poNo = null;
		int counter = 0;
		// if duplicate po no
		while (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
		{
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				ActionBot.scrollUp(driver, "300");
				ScreenShot.screenshot(driver, testCaseName, "After clicking on create new po no confirmation pop up");
				poNo = PageStandardPO.getPONo(driver, testCaseName);
				PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
				// verify zero price item popup displayed
				if (PopUpAlertSubmitPO.isAlertPopUpPresent(driver, testCaseName))
				{
					PopUpAlertSubmitPO.clickOnYes(driver, testCaseName);
				}
				if (markForAddingApprovers)
				{
					PageStandardPO.clickOnMarkForAddingApprovers(driver, testCaseName);
				}
				PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
				counter++;
			}
			if (counter > 4)
			{
				break;
			}
		}
		return poNo;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>naviagtes to Po and clicks on Amend PO
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean amendPO(WebDriver driver, String testCaseName, StandardPO stdpo) throws ActionBotException, FactoryMethodException
	{
		// Navigate to PO Page
		MainPageHeaderLevelTab.clickOnPOTab(driver);

		// Search PO
		PagePurchaseOrderListing.fillPoNo(driver, testCaseName, stdpo.getPoNumber());

		String poStatus = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

		//po gets stuck in parked state for sometime. hence added medium sleep.
		if (poStatus.equalsIgnoreCase(IConstantsData.PARKED_FILTER))
		{
			ActionBot.defaultSleep();
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			driver.navigate().refresh();
			ActionBot.waitForPageLoad(driver);
		}

		// Click on Amend PO
		PagePurchaseOrderListing.clickOnAmmendPOLinkFromTooltip(driver, testCaseName);

		// clicks on Continue or OK(in case of Approval) Button if Alert
		// displayed on Page
		return PagePurchaseOrderListing.clickOnAlertContinueButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>create/ change address on PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean changeAddressDeliveryTab(WebDriver driver, String testCaseName, String addressType) throws ActionBotException, FactoryMethodException
	{
		// naviagte to delivery tab and click on create new address
		PageStandardPO.clickOnEdit(driver);
		TabPOSummary.clickOnDeliveryPOSummary(driver);
		PageStandardPO.clickOnMyDeliveryAddressRadioBtm(driver);
		if (addressType.equalsIgnoreCase(IConstantsData.DeliveryAddress_MyAddress))
		{
			PageStandardPO.clickLinkCreateNewAddress(driver, testCaseName);
			// fill address details
			PageStandardPO.fillCustomAddressName(driver, testCaseName, Helper.getRandomString(5));
			PageStandardPO.fillCustomAddressStreet1(driver, testCaseName, Helper.getRandomString(5));
			PageStandardPO.fillCustomAddressCountry(driver, testCaseName, "1");
			PageStandardPO.fillCustomAddressCity(driver, testCaseName, Helper.getRandomString(5));
		}
		if (addressType.equalsIgnoreCase(IConstantsData.DeliveryAddress_OtherAddress))
		{
			PageStandardPO.selectOtherAddress(driver, testCaseName);
		}

		ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
		return PageStandardPO.clickAddressChangeButtonYes(driver, testCaseName);
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method :</b>fill Further details for PO page <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 */

	public static PurchaseOrder fillFurtherDetails(WebDriver driver, String testCaseName, PurchaseOrder purchaseOrder) throws ActionBotException, FactoryMethodException
	{

		if (purchaseOrder.getRecommendationMemoProvided() != null)
		{
			purchaseOrder.setRecommendationMemoProvided(
				PagePurchaseOrderToBeGenerated.clickOnRecomendationMemoProvided(driver, testCaseName, purchaseOrder.getRecommendationMemoProvided()));
		}

		if (purchaseOrder.getCmsRegistered() != null)
		{
			purchaseOrder.setCmsRegistered(PagePurchaseOrderToBeGenerated.clickOncmsRegistered(driver, testCaseName, purchaseOrder.getCmsRegistered()));
		}

		if (purchaseOrder.getProccurementInvolvement() != null)
		{
			purchaseOrder.setProccurementInvolvement(PagePurchaseOrderToBeGenerated.clickOnPurchaseProcurement(driver, testCaseName, purchaseOrder.getProccurementInvolvement()));
		}

		if (purchaseOrder.getIsPOValue() != null)
		{
			purchaseOrder.setIsPOValue(PagePurchaseOrderToBeGenerated.setIsPOValue(driver, testCaseName, purchaseOrder.getIsPOValue()));
		}

		if (purchaseOrder.getPoMedium() != null)
		{
			purchaseOrder.setPoMedium(PagePurchaseOrderToBeGenerated.clickOnpoMedium(driver, testCaseName, purchaseOrder.getPoMedium()));
		}

		if (purchaseOrder.getQuote() != null)
		{
			purchaseOrder.setQuote(PagePurchaseOrderToBeGenerated.clickOnquote(driver, testCaseName, purchaseOrder.getQuote()));
		}
		if (purchaseOrder.getPanelApply() != null)
		{
			purchaseOrder.setPanelApply(PagePurchaseOrderToBeGenerated.clickOnpanelApply(driver, testCaseName, purchaseOrder.getPanelApply()));
		}
		return purchaseOrder;
	}

}
