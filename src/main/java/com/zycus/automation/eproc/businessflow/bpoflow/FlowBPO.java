/**
 * 
 */
package com.zycus.automation.eproc.businessflow.bpoflow;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.bpobuyingscope.ModalBPOBuyingScope;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling.ModalPurchaseOrderSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.ModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.bpo.PageBPO;
import com.zycus.automation.eproc.pageobjects.pages.po.PagePO;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class FlowBPO
{
	static Logger logger = Logger.getLogger(FlowBPO.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill BPO creation form <br>
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
	public static BPO fillBPOCreationForm(WebDriver driver, String testCaseName, BPO bpo) throws Exception
	{
		// PO No
		if (bpo.getPoNumber() != null)
		{
			bpo.setPoNumber(PageStandardPO.fillPONumber(driver, testCaseName, bpo.getPoNumber()));
		}
		else
		{
			bpo.setPoNumber(PageStandardPO.getPONo(driver, testCaseName));
		}
		// order description
		if (bpo.getOrderDescription() != null)
		{
			bpo.setOrderDescription(PageStandardPO.enterOrderDescription(driver, bpo.getOrderDescription()));
		}

		// supplier name
		if (bpo.getSupplierName() != null)
		{
			bpo.setSupplierName(PageStandardPO.enterSupplierName(driver, bpo.getSupplierName()));
		}

		bpo.setSupplierAddress(PageStandardPO.selectFirstSupplierAddress(driver, testCaseName));

		// currency type
		if (bpo.getCurrencyType() != null)
		{
			bpo.setCurrencyType(PageStandardPO.enterCurrencyType(driver, bpo.getCurrencyType()));
		}
		if (bpo.getDeliveryTerms() != null)
		{
			bpo.setDeliveryTerms(PageStandardPO.selectDeliveryTerms(driver, bpo.getDeliveryTerms()));
		}

		// purchase type
		if (bpo.getPurchaseType() != null)
		{
			bpo.setPurchaseType(PageStandardPO.enterPurchaseType(driver, bpo.getPurchaseType()));
		}
		// buyer
		if (bpo.getBuyer() != null)
		{
			bpo.setBuyer(PageStandardPO.enterBuyer(driver, bpo.getBuyer()));
		}

		// payment terms
		if (bpo.getPaymentTerms() != null)
		{
			bpo.setPaymentTerms(PageStandardPO.enterPaymentTerms(driver, bpo.getPaymentTerms()));
		}
		// contact no
		bpo.setPoContact(PageStandardPO.getSupplierContact(driver, testCaseName));

		// requester
		if (bpo.getRequester() != null)
		{
			bpo.setRequester(PageStandardPO.enterRequester(driver, testCaseName, bpo.getRequester()));
		}

		// order type
		if (bpo.getOrderType() != null)
		{
			if (bpo.getOrderType().equalsIgnoreCase(IConstantsData.BPO_AUTH_TYPE_RELEASE_ORDER))
			{
				PageBPO.clickOnOrderTypeRelease(driver, testCaseName);
			}
			else if (bpo.getOrderType().equalsIgnoreCase(IConstantsData.BPO_AUTH_TYPE_DIRECT_INVOINCING))
			{
				PageBPO.clickOnOrderTypeDirectInvoicing(driver, testCaseName);
			}
		}
		else
		{
			PageBPO.clickOnOrderTypeRelease(driver, testCaseName);
		}

		// click on edit
		if (bpo.getCostBookingRequisitionSummary() != null)
		{
			PageStandardPO.clickOnEdit(driver);
			// billing info
			{
				BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
				billingRequisitionSummary.setCompany(ModalPurchaseOrderSummaryBilling.getCompany(driver, testCaseName));
				billingRequisitionSummary.setBusinessUnit(ModalPurchaseOrderSummaryBilling.getBusinessUnit(driver, testCaseName));
				billingRequisitionSummary.setLocation(ModalPurchaseOrderSummaryBilling.getLocation(driver, testCaseName));
				billingRequisitionSummary.setDeliveryAddress(ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName));
				billingRequisitionSummary.setBillToAddress(ModalPurchaseOrderSummaryBilling.getLocationOfBillToAddress(driver, testCaseName));
				bpo.setBillingRequisitionSummary(billingRequisitionSummary);
			}
			// click oN costBooking res Summary
			if (bpo.getCostBookingRequisitionSummary() != null)
			{
				TabPOSummary.clickOnCostBookingPOSummary(driver);
				bpo.setCostBookingRequisitionSummary(FlowStandardPo.fillCostBookingPurchaseOrderSummary(driver, testCaseName, bpo.getCostBookingRequisitionSummary()));
			}
		}
		ActionBot.scroll(driver, "650");

		/*
		 * //attachment if (standardpo.getAttachmentFileName() != null) {
		 * PageStandardPO.clickOnPOAddAttachmentLink(driver, testCaseName);
		 * ModalPOAttachment.fillAttachmentFileName(driver, testCaseName,
		 * standardpo.getAttachmentFileName());
		 * 
		 * standardpo.setAttachmentFileName(ModalPOAttachment.getAttachmentName(
		 * driver, testCaseName));
		 * 
		 * String status = ModalPOAttachment.getAttachmentStatus(driver,
		 * testCaseName); String size =
		 * ModalPOAttachment.getAttachmentSize(driver, testCaseName);
		 * 
		 * ModalPOAttachment.clickOnDoneButton(driver, testCaseName);
		 * 
		 * if ((!status.equalsIgnoreCase(IConstantsData.Uploaded)) ||
		 * (size.equalsIgnoreCase("0 KB"))) { Assert.assertFalse(true,
		 * "File was not uploaded"); }
		 * 
		 * if (!PageStandardPO.getLabelValueOfPOAddAttachmentLink(driver,
		 * testCaseName).equalsIgnoreCase(
		 * IConstantsData.Label_Value_Of_Attachment)) { Assert.assertFalse(true,
		 * "File was not uploaded properly and not shown on checkout page"); } }
		 */

		// add item
		if (bpo.getItems() != null)
		{
			bpo.setItems(FlowStandardPo.addItem(driver, testCaseName, bpo.getItems()));
		}
		ActionBot.scroll(driver);

		// item level info
		// catalog item
		if (bpo.getItems() != null)
		{
			if (bpo.getItems().getCatelogItems() != null)
			{
				for (CatelogItem catelogItem : bpo.getItems().getCatelogItems())
				{
					String itemID = catelogItem.getItemID();
					PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
					if (bpo.getCostBookingItemSummary().getAccountingItemSummary() != null)
					{
						ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
						FlowStandardPo.fillAccountingDetails(driver, testCaseName, bpo.getCostBookingItemSummary().getAccountingItemSummary());
					}
				}
			}
		}

		// terms and condition
		bpo.setTermsAndConditions(PageStandardPO.getTermsAndConditions(driver, testCaseName));

		// notes
		if (bpo.getNotes() == null)
		{
			bpo.setNotes(PageStandardPO.enterNotes(driver, testCaseName, bpo.getNotes()));
		}

		// auto update
		if (!bpo.isAutoUpdate())
		{
			bpo.setAutoUpdate(PageBPO.clickOnAutoUpdate(driver, testCaseName));
		}

		// order value
		if (bpo.getOrderValue() != null)
		{
			bpo.setOrderValue(PageBPO.fillOrderValue(driver, testCaseName, bpo.getOrderValue()));
		}
		else
		{
			bpo.setOrderValue(PageBPO.getOrderValue(driver, testCaseName));
		}

		// define buying scope
		if (bpo.getBpoBuyingScope() != null)
		{
			PageStandardPO.clickOnDefineBuyingScopeLink(driver, testCaseName);
			ModalBPOBuyingScope.fillBU(driver, testCaseName, bpo.getBpoBuyingScope().getBusinessUnit());
			ModalBPOBuyingScope.fillLocation(driver, testCaseName, bpo.getBpoBuyingScope().getLocation());
			ModalBPOBuyingScope.fillCostCenter(driver, testCaseName, bpo.getBpoBuyingScope().getCostCenter());
			ModalBPOBuyingScope.clickOnOKButton(driver, testCaseName);
		}

		// from validity date
		if (bpo.getFromValidityDate() != null)
		{
			bpo.getFromValidityDate().setDate(PageBPO.selectFromValidityDate(driver, testCaseName, bpo.getFromValidityDate().getDay(), bpo.getFromValidityDate().getMonth(),
				bpo.getFromValidityDate().getYear()));
		}
		else
		{
			CustomDate customDate = new CustomDate();
			bpo.setFromValidityDate(customDate);
			bpo.getFromValidityDate().setDate(PageBPO.getFromValidityDate(driver, testCaseName));
		}

		// to validity date
		if (bpo.getToValidityDate() != null)
		{
			bpo.getToValidityDate().setDate(
				PageBPO.selectToValidityDate(driver, testCaseName, bpo.getToValidityDate().getDay(), bpo.getToValidityDate().getMonth(), bpo.getToValidityDate().getYear()));
		}
		else
		{
			CustomDate customDate = new CustomDate();
			bpo.setToValidityDate(customDate);
			bpo.getToValidityDate().setDate(PageBPO.getToValidityDate(driver, testCaseName));
		}

		// to until validity date
		if (bpo.getUntilValidityDate() != null)
		{
			bpo.getUntilValidityDate().setDate(PageBPO.selectUntilValidityDate(driver, testCaseName, bpo.getUntilValidityDate().getDay(), bpo.getUntilValidityDate().getMonth(),
				bpo.getUntilValidityDate().getYear()));
		}
		else
		{
			CustomDate customDate = new CustomDate();
			bpo.setUntilValidityDate(customDate);
			bpo.getUntilValidityDate().setDate(PageBPO.getUntilValidityDate(driver, testCaseName));
		}

		// prevent items of other categories
		if (bpo.isPreventOrderOfItemsOfOtherCategorie())
		{
			PageBPO.clickOnPreventItemsOfOtherCategoryToBeOdredred(driver, testCaseName);
		}

		// prevent changing part no & item description
		if (bpo.isPreventChangingPartNoAndItemDescription())
		{
			PageBPO.clickOnPreventChangingPartNoAndItemDescription(driver, testCaseName);
		}

		// prevent exceeding blanket order value
		if (bpo.isPreventExceedingBlanketValues())
		{
			PageBPO.clickOnPreventExceedingBPOValue(driver, testCaseName);
		}

		// require receipt
		if (bpo.isRequireReceipt())
		{
			PageBPO.clickOnRequireReceiptAgainstPO(driver, testCaseName);
		}

		// to remove taxes
		if (bpo.isRemoveAllTaxes())
		{
			PageStandardPO.clickOnRemoveAllTaxesOption(driver, testCaseName);
		}
		return bpo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create BPO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param bpo </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static BPO createBPO(WebDriver driver, String testCaseName, BPO bpo) throws Exception
	{
		MainPageHeaderLevelTab.clickOnPOTab(driver);

		PagePO.clickOnBPO(driver, testCaseName);

		bpo = fillBPOCreationForm(driver, testCaseName, bpo);
		bpo.setTotalPrice(PageBPO.getTotalAmount(driver, testCaseName));

		// next action
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_PO_FOR_PROCESSING))
		{
			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "After Submitting PO");
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_PO_AS_DRAFT))
		{
			bpo.setPoNumber(FlowStandardPo.savePOAsDraft(driver, testCaseName));
			ScreenShot.screenshot(driver, testCaseName, "Save PO as Draft");
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageStandardPO.clickOnCancelPo(driver);
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			// only fill the form and do nothing
		}
		return bpo;
	}

	public static BPO createRelease(WebDriver driver, String testCaseName, BPO bpo) throws ActionBotException, FactoryMethodException
	{
		// BPO Actions
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);

		if (bpo.getReleaseNo() != null)
		{
			bpo.setReleaseNo(PageStandardPO.fillReleaseNo(driver, testCaseName, bpo.getReleaseNo()));
		}

		// get release no
		bpo.setReleaseNo(PageStandardPO.getAutogeneratedPoNo(driver, testCaseName));

		logger.info("Release no : " + bpo.getReleaseNo());

		// set required by date
		PageStandardPO.fillRequiredByDate(driver, testCaseName, bpo.getRequiredByDate().getDay(), bpo.getRequiredByDate().getMonth(), bpo.getRequiredByDate().getYear());

		// click oN costBooking Summary
		if (bpo.getCostBookingRequisitionSummary() != null)
		{
			// click on edit
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			bpo.setCostBookingRequisitionSummary(FlowStandardPo.fillCostBookingPurchaseOrderSummary(driver, testCaseName, bpo.getCostBookingRequisitionSummary()));
		}

		ActionBot.scroll(driver, "500");

		// edit item level info
		/*
		 * if (bpo.getCostBookingItemSummary() != null) { for (WebElement
		 * element : PageStandardPO.getListOfItemLevelEditButtons(driver,
		 * testCaseName)) { if
		 * (bpo.getCostBookingItemSummary().getAccountingItemSummary() != null)
		 * { ActionBot.moveToElementAndClick(driver, element);
		 * ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver,
		 * testCaseName); FlowStandardPo.fillAccountingDetails(driver,
		 * testCaseName, bpo.getCostBookingItemSummary()
		 * .getAccountingItemSummary()); } } }
		 */

		// catalog item
		if (bpo.getItems() != null)
		{
			if (bpo.getItems().getCatelogItems() != null)
			{
				for (CatelogItem catelogItem : bpo.getItems().getCatelogItems())
				{
					String itemName = catelogItem.getItemName();
					if (PageStandardPO.isItemPresentUsingItemName(driver, testCaseName, itemName))
					{
						PageStandardPO.clickOnItemUsingItemName(driver, testCaseName, itemName);

						// market price
						if (catelogItem.getMarketPrice() != null)
						{
							catelogItem.setMarketPrice(
								Float.toString(ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, Float.parseFloat(catelogItem.getMarketPrice()))));
						}
						// quantity
						if (catelogItem.getQuantity() != 0)
						{
							catelogItem.setQuantity(Math.round(ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, catelogItem.getQuantity())));
						}

						// to fill accounting details
						if (bpo.getCostBookingItemSummary() != null)
						{
							ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
							FlowStandardPo.fillAccountingDetails(driver, testCaseName, bpo.getCostBookingItemSummary().getAccountingItemSummary());
						}
					}
				}
			}
			if (bpo.getItems().getGuidedItems() != null)
			{
				for (GuidedItem guidedItem : bpo.getItems().getGuidedItems())
				{
					String itemName = guidedItem.getShortDescription();
					if (PageStandardPO.isItemPresentUsingItemName(driver, testCaseName, itemName))
					{
						PageStandardPO.clickOnItemUsingItemName(driver, testCaseName, itemName);
						ActionBot.scroll(driver);

						// zero price item
						if (guidedItem.isZeroPriceItem())
						{
							ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
						}

						// market price
						if (guidedItem.getPrice() != 0)
						{
							guidedItem.setPrice(ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, guidedItem.getPrice()));
						}

						// quantity
						if (guidedItem.getQuantity() != 0)
						{
							guidedItem.setQuantity(ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, guidedItem.getQuantity()));
						}
						// to fill accounting details
						if (bpo.getCostBookingItemSummary() != null)
						{
							ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
							FlowStandardPo.fillAccountingDetails(driver, testCaseName, bpo.getCostBookingItemSummary().getAccountingItemSummary());
						}
					}
				}
			}
		}

		// next action
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_PO_FOR_PROCESSING))
		{
			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setReleaseNo(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_PO_AS_DRAFT))
		{
			FlowStandardPo.savePOAsDraft(driver, testCaseName);
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageStandardPO.clickOnCancelPo(driver);
		}
		if (bpo.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			// only fill the form and do nothing
		}
		return bpo;
	}

	public static BPO getInformationOfBPO(WebDriver driver, String testCaseName, Item item) throws ActionBotException, FactoryMethodException
	{
		logger.info("Information of copied BPO : ");
		BPO bpo = new BPO();
		bpo.setPoNumber(PageStandardPO.getPONo(driver, testCaseName));
		bpo.setOrderDescription(PageStandardPO.getOrderDescription(driver, testCaseName));
		bpo.setSupplierName(PageStandardPO.getSelectedSupplierName(driver, testCaseName));
		bpo.setPurchaseType(PageStandardPO.getSelectedPurchaseType(driver, testCaseName));
		bpo.setBuyer(PageStandardPO.getBuyer(driver));

		// header level info
		PageStandardPO.clickOnEdit(driver);
		// billing info
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
		billingRequisitionSummary.setCompany(ModalPurchaseOrderSummaryBilling.getCompany(driver, testCaseName));
		billingRequisitionSummary.setBusinessUnit(ModalPurchaseOrderSummaryBilling.getBusinessUnit(driver, testCaseName));
		billingRequisitionSummary.setLocation(ModalPurchaseOrderSummaryBilling.getLocation(driver, testCaseName));
		billingRequisitionSummary.setDeliveryAddress(ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName));
		billingRequisitionSummary.setBillToAddress(ModalPurchaseOrderSummaryBilling.getLocationOfBillToAddress(driver, testCaseName));
		bpo.setBillingRequisitionSummary(billingRequisitionSummary);

		// cost center info
		TabPOSummary.clickOnCostBookingPOSummary(driver);
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		costBookingRequisitionSummary.setCostCenter(ModalPOSummaryCostBooking.getCostCenterName(driver, testCaseName));
		costBookingRequisitionSummary.setBudget(ModalPOSummaryCostBooking.getBudgetName(driver, testCaseName));
		costBookingRequisitionSummary.setProject(ModalPOSummaryCostBooking.getProjectName(driver, testCaseName));
		bpo.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

		ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);

		ActionBot.scroll(driver);
		// items
		List<WebElement> itemsNames = PageStandardPO.getListOfItems(driver, testCaseName);
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		for (WebElement element : itemsNames)
		{
			CatelogItem catelogItem = new CatelogItem();
			catelogItem.setItemName(element.getText().trim());
			catelogItems.add(catelogItem);
		}
		Item items = new Item();
		items.setCatelogItems(catelogItems);
		bpo.setItems(items);

		/*
		 * //Cost Allocation info CostBookingItemSummary costBookingItemSummary
		 * = new CostBookingItemSummary(); AccountingItemSummary
		 * accountingItemSummary = new AccountingItemSummary(); //catalog item
		 * if (item.getCatelogItems() != null) { for (CatelogItem catelogItem :
		 * item.getCatelogItems()) { String itemID = catelogItem.getItemID();
		 * PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
		 * ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver,
		 * testCaseName);
		 * accountingItemSummary.setGlAccount(ModalPOItemSummaryCostAllocation.
		 * getGLAccount(driver, testCaseName));
		 * costBookingItemSummary.setAccountingItemSummary(accountingItemSummary
		 * ); ModalPOItemSummaryCostAllocation.clickOnCancel(driver); } }
		 * //guided items if (item.getGuidedItems() != null) { for (GuidedItem
		 * guidedItem : item.getGuidedItems()) { String itemID =
		 * guidedItem.getItemID(); PageStandardPO.clickOnItemSummaryEdit(driver,
		 * testCaseName, itemID);
		 * ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver,
		 * testCaseName);
		 * accountingItemSummary.setGlAccount(ModalPOItemSummaryCostAllocation.
		 * getGLAccount(driver, testCaseName));
		 * costBookingItemSummary.setAccountingItemSummary(accountingItemSummary
		 * ); ModalPOItemSummaryCostAllocation.clickOnCancel(driver); } }
		 * bpo.setCostBookingItemSummary(costBookingItemSummary);
		 */

		bpo.setOrderValue(PageBPO.getOrderValue(driver, testCaseName));

		return bpo;
	}

	public static boolean compareCopiedBPOInfo(WebDriver driver, String testCaseName, BPO original_bpo, BPO copied_bpo) throws ActionBotException
	{
		boolean flag = true, itemNameFlag = false;
		String error = "";

		// supplier name
		if (!original_bpo.getSupplierName().equalsIgnoreCase(copied_bpo.getSupplierName()))
		{
			flag = false;
			error += "Supplier name on copied po was wrong. \n";
		}

		// purchase tyep
		if (!original_bpo.getPurchaseType().equalsIgnoreCase(copied_bpo.getPurchaseType()))
		{
			flag = false;
			error += "Purchase type on copied po was wrong. \n";
		}

		// buyer
		if (copied_bpo.getBuyer().contains("|"))
		{
			copied_bpo.setBuyer(StringUtils.split(copied_bpo.getBuyer(), "|")[0].trim());
		}
		if (original_bpo.getBuyer().contains("|"))
		{
			original_bpo.setBuyer(StringUtils.split(original_bpo.getBuyer(), "|")[0].trim());
		}
		if (!copied_bpo.getBuyer().equalsIgnoreCase(original_bpo.getBuyer()))
		{
			System.out.println("@@@@@@@@@@@@@@@@@@@@ copied_bpo.getBuyer() : " + copied_bpo.getBuyer());
			System.out.println("@@@@@@@@@@@@@@@@@@@@ original_bpo.getBuyer() : " + original_bpo.getBuyer());
			flag = false;
			error += "Buyer name on copied po was wrong. \n";
		}

		// CBL
		if (!original_bpo.getBillingRequisitionSummary().getCompany().equalsIgnoreCase(copied_bpo.getBillingRequisitionSummary().getCompany())
			&& !original_bpo.getBillingRequisitionSummary().getBusinessUnit().equalsIgnoreCase(copied_bpo.getBillingRequisitionSummary().getBusinessUnit())
			&& !original_bpo.getBillingRequisitionSummary().getLocation().equalsIgnoreCase(copied_bpo.getBillingRequisitionSummary().getLocation()))
		{
			flag = false;
			error += "CBL of copied po was wrong. \n";
		}

		// delivery address and bill to address
		if (!original_bpo.getBillingRequisitionSummary().getDeliveryAddress().equalsIgnoreCase(copied_bpo.getBillingRequisitionSummary().getDeliveryAddress())
			&& !original_bpo.getBillingRequisitionSummary().getBillToAddress().equalsIgnoreCase(copied_bpo.getBillingRequisitionSummary().getBillToAddress()))
		{
			flag = false;
			error += "Delivery address and/or Bill to address of copied po was wrong. \n";
		}

		// cc,budget,project
		if (!copied_bpo.getCostBookingRequisitionSummary().getCostCenter().split(":")[0].trim()
			.equalsIgnoreCase(original_bpo.getCostBookingRequisitionSummary().getCostCenter().split(":")[0].trim()))
		{
			flag = false;
			error += "Cost Center of copied po was wrong. \n";
		}

		if (original_bpo.getCostBookingRequisitionSummary().getBudget() != null)
		{
			if (!copied_bpo.getCostBookingRequisitionSummary().getBudget().split(":")[0].trim()
				.equalsIgnoreCase(original_bpo.getCostBookingRequisitionSummary().getBudget().split(":")[0].trim()))
			{
				flag = false;
				error += "Budget of copied po was wrong. \n";
			}
		}

		if (original_bpo.getCostBookingRequisitionSummary().getProject() != null)
		{
			if (!copied_bpo.getCostBookingRequisitionSummary().getProject().split(":")[1].trim()
				.equalsIgnoreCase(original_bpo.getCostBookingRequisitionSummary().getProject().split(":")[1].trim()))
			{
				flag = false;
				error += "Project of copied po was wrong. \n";
			}
		}

		// to get item names
		List<String> itemNames = new ArrayList<String>();
		if (original_bpo.getItems().getCatelogItems() != null)
		{
			for (CatelogItem catelogItem : original_bpo.getItems().getCatelogItems())
			{
				itemNames.add(catelogItem.getItemName());
			}
		}

		if (original_bpo.getItems().getGuidedItems() != null)
		{
			for (GuidedItem guidedItem : original_bpo.getItems().getGuidedItems())
			{
				itemNames.add(guidedItem.getItemName());
			}
		}

		for (CatelogItem catelogItem : copied_bpo.getItems().getCatelogItems())
		{
			for (String itemName : itemNames)
			{
				if (catelogItem.getItemName().equalsIgnoreCase(itemName))
				{
					itemNameFlag = true;
					break;
				}
				else
				{
					itemNameFlag = false;
				}
			}
		}

		if (!itemNameFlag)
		{
			flag = false;
			error += "Items of copied po was wrong. \n";
		}

		logger.info(error);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To copy BPO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param item </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static BPO copyBPO(WebDriver driver, String testCaseName, Item item) throws ActionBotException, FactoryMethodException
	{
		BPO copied_bpo = new BPO();
		// BPO Actions
		PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
		ModalPOActions.clickOnCopyFromActions(driver, testCaseName);

		copied_bpo = getInformationOfBPO(driver, testCaseName, item);

		return copied_bpo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create bpo and release it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param bpo </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static BPO createAndReleaseBPO(WebDriver driver, String testCaseName, BPO bpo) throws Exception
	{
		// BPO creation
		bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

		String bpoNo = bpo.getPoNumber();

		driver.navigate().refresh();
		ActionBot.defaultSleep();
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		// search BPO
		logger.info("============== Searching BPO ==============");
		boolean flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
		assertTrue("Error while searching BPO", flag);

		String type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
		flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
		assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

		String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
		if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
		{
			// to approve the BPO
			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpoNo, IConstantsData.BPO, IConstantsData.APPROVE);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			driver.navigate().refresh();
			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of BPO was not Released", flag);
		}

		return bpo;
	}

}
