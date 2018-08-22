package com.zycus.automation.eproc.testcase.regression.BpoToPR;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.DeliveryItemSummary;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.convertedpurchaseorder.FlowConvertedPurchaseOrder;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple.ModelChangeMultiple;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.IModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.itemSummaryItem.ModalItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.itemdetails.ModalItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.bpo.IPageBPO;
import com.zycus.automation.eproc.pageobjects.pages.bpo.PageBPO;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.IPageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.requisitionparser.test.CommonUtil;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.zsn.automation.bo.CatalogItem;

// import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class PRToBORTestCases extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(PRToBORTestCases.class);
	static String	bpoNo	= null;
	//static String	bpoNo	= 	"104910ponumberrandomdigits";

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Create BPO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the type of BPO, it should be
	 * Blanket </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void createBPOS(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		Item item2 = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);

			int randomNo = CommonUtilities.getNonZeroRandomNumbers(6);
			bpo.setPoNumber(randomNo + "");

			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			bpo.getItems().getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			bpo.setAutoUpdate(false);
			bpo.setOrderValue(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(7)) + "" + Integer.toString(CommonUtilities.getNonZeroRandomNumbers(7)));

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			if (PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
				FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);

			}
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.RELEASED);
			bpoNo = bpo.getPoNumber();
			logger.info("bmpNo set :" + bpoNo);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>In Amend Req-BPR; Validation should be
	 * present for max total for categories defined on BPO. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 2)
	public void RTC_201134(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag = false;
		Requisition requisition = new Requisition();
		Item item = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				// RTC_201135 : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201135"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201136"));
			}

			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			item.getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			item.getGuidedItems().get(0).setEditCategory(true);
			item.getGuidedItems().get(0).setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			item.getGuidedItems().get(0).setBPONo(bpoNo);
			item.getGuidedItems().get(0).setPartNumber(null);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag);
			if (PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(0).getPoNo(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
				FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			}
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.RELEASED);
			Assert.assertTrue(flag, "Po is not released state");
			// amend po
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			// edit item price
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			String marketPrice = CommonUtilities.getNonZeroRandomNumber(3) + "";
			ModalPOFreeTextItemSummaryItem.clearAndfillMarketPrice(driver, testCaseName, Float.parseFloat(marketPrice));
			// click On CostBooking
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp = StringUtils.split(amount.substring(4), ",");
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			amount = CommonUtilities.getNonZeroRandomNumber(10) + "";
			ModalPOItemSummaryCostAllocation.clearAndfillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			// check error msg present/not
			flag = PageStandardPO.checkInvalidAmountError(driver, testCaseName);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>In Amend Req-BPR; Validation should be
	 * present if BPO is closed <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 3)
	public void RTC_201137(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag = false;
		Item item = null;
		Requisition requisition = new Requisition();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			{
				// RTC_201135 : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201138"));
			}

			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			item.getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			item.getGuidedItems().get(0).setEditCategory(true);
			item.getGuidedItems().get(0).setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			item.getGuidedItems().get(0).setPartNumber(null);
			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			item.getGuidedItems().get(0).setBPONo(bpoNo);
			requisition.setItems(item);

			// req to buyers desk

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			Assert.assertTrue(requisition != null);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// convert to PO and save as draft
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			ActionBot.defaultHighSleep();
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			String poNo = purchaseOrders.get(0).getPoNo();
			// amend po
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests2 = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, poNo, IConstantsData.PURCHASE_ORDER,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests2);
				ActionBot.defaultSleep();
			}
			flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);

			// amend po
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());

			PageStandardPO.enterOrderDescription(driver, "description" + new Random().nextInt(99999) + 1);

			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			ActionBot.scroll(driver, "500");
			PageStandardPO.clickOnRequireReceiptChkbox(driver);
			ActionBot.scroll(driver, "600");
			PageStandardPO.isEditableCommentsFields(driver, IConstantsData.PO_CHANGE_COMMENT);

			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			ActionBot.defaultMediumSleep();
			// close the bpo used
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnClosePOFromActions(driver, testCaseName);
			PagePurchaseOrderListing.fillCloseCommentBox(driver, testCaseName, IConstantsData.CLOSE_PO_COMMENT);
			PagePurchaseOrderListing.clickOnClosePOButton(driver, testCaseName);

			// Open po and check for validation
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			ActionBot.defaultSleep();
			ActionBot.scroll(driver, "1000");
			PageStandardPO.isEditableCommentsFields(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag, "Error msg is not displayed for amending a PO linked with closed BPO");
			mappedTestCases.get(0).setTestResult(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 214522 - Unable to submit PR
	 * which is returned with quote, submission goes infinite. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 4)
	public void RTC_219100(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		GuidedItem guidedItem = new GuidedItem();
		String requeComment = IConstantsData.REC_CHANGE_COMM;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			{
				// RTC_201135 : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201138"));
			}

			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);

			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			guidedItem.setCategory(guidedItemSelectCategory);
			guidedItem.setEditCategory(true);
			guidedItem.setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			guidedItem.setPartNumber(null);
			guidedItems.add(guidedItem);
			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);
			// req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// click on first poNo
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			// click On first buyer desk link
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "450");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			// fill comment and click on return
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, requeComment);
			PageBuyersDesk.clickOnReturn(driver, testCaseName);
			// click on default pop-up yes
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			flag = FlowRequisition.submitReq(driver, testCaseName, false);
			Assert.assertTrue(flag, "Requisition is not submited");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 214522 - Unable to submit PR
	 * which is returned with quote, submission goes infinite. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 5)
	public void RTC_251845(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_239312 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_239312"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_229782"));
		}
		User user = null;
		boolean flag = false;
		GuidedItem guidedItem = new GuidedItem();
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);

			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			guidedItem.setCategory(guidedItemSelectCategory);
			guidedItem.setEditCategory(true);
			guidedItem.setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			guidedItem.setPartNumber(null);
			guidedItems.add(guidedItem);
			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			String bName = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			requisition.setAssignedBuyer(bName);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);
			// req to buyers desk
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			flag = FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			Assert.assertTrue(flag, "PO is not created");
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			String status1 = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status1.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, poNo, IConstantsData.PURCHASE_ORDER,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				mappedTestCases.get(0).setTestResult(flag);
				assertTrue("Status of PO was not Released", flag);
			}
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String value = PageViewPurchaseOrder.getBuyerName(driver, testCaseName);
			flag = bName.equalsIgnoreCase(value);
			Assert.assertTrue(flag);
			mappedTestCases.get(1).setTestResult(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>If multiple free text items are linked to
	 * the same BO than the buyer of that BO should be the buyer of auto-BOR. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 6)
	public void RTC_229778(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		Requisition requisition = null;
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		User user = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				// RTC_229777 : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_229777"));
			}

			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			// add 1st item
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem1.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem1.setBPONo(bpoNo);
			guidedItem1.setCategory(guidedItemSelectCategory);
			guidedItem1.setEditCategory(true);
			guidedItem1.setPartNumber(null);
			guidedItem1.setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			guidedItems.add(guidedItem1);

			// add 2nd item
			GuidedItem guidedItem2 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem2.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem2.setBPONo(bpoNo);
			guidedItem2.setCategory(guidedItemSelectCategory);
			guidedItem2.setEditCategory(true);
			guidedItem2.setPartNumber(null);
			guidedItem2.setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			guidedItems.add(guidedItem2);

			// add 3rd item
			GuidedItem guidedItem3 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem3.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem3.setBPONo(bpoNo);
			guidedItem3.setCategory(guidedItemSelectCategory);
			guidedItem3.setEditCategory(true);
			guidedItem3.setPartNumber(null);
			guidedItem3.setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			guidedItems.add(guidedItem3);

			items.setGuidedItems(guidedItems);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			// change settings for touchless po
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowEditingAutoGeneratedPONumber_Yes(driver, testCaseName);
			String buyerName = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			PagePurchaseOrderSetting.fillDefaultBuyerForAutoPO(driver, testCaseName, buyerName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
				IConstantsData.APPROVE);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			driver.navigate().refresh();
			String status1 = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status1.equalsIgnoreCase(IConstantsData.RELEASED);
			Assert.assertTrue(flag, "PO is not in released state");
			mappedTestCases.get(0).setTestResult(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnAllowEditingAutoGeneratedPONumber_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Exception occurred while changing Purchase Order setting to default value" + e, e);

			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 214489 - Duplicate Release
	 * numbers used for multiple releases in case of Release conversion from PR. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219065(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		DeliveryItemSummary deliveryItemSummary = new DeliveryItemSummary();
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		String attachmentFileName = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.FREE_TEXT_ITEM_ATTACHMENT;
		String commentsForSupplier = CommonServices.getTestData(IConstantsData.COMMENT_FOR_SUPPLIER);
		String internalComments = CommonServices.getTestData(IConstantsData.INTERNAL_COMMENTS_PO);
		PurchaseOrder purchaseorder = new PurchaseOrder();
		User user = null;
		boolean flag = false;
		float quantity;
		String status;
		Requisition requisition = new Requisition();
		String bpoNo1 = null;
		try
		{

			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);

			{
				// RTC_201135 : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_219090"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_219089"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_219077"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_295880"));
			}

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			bpo.getItems().getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			bpo.getItems().getGuidedItems().get(0).setQuantity(CommonUtilities.getNonZeroRandomNumber(1));
			bpo.setNextAction(IConstantsData.NONE);

			String poNumber = CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME);
			int lenght = poNumber.length();

			int randomNo = CommonUtilities.getNonZeroRandomNumbers(6);
			String poNameRandomGenerated = randomNo + poNumber.substring(0, lenght - 6);
			bpo.setPoNumber(poNameRandomGenerated);
			bpo.setAutoUpdate(false);
			bpo.setOrderValue(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(7)) + "" + Integer.toString(CommonUtilities.getNonZeroRandomNumbers(7)));
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			ActionBot.scroll(driver, "500");
			// click on bpo settings
			if (ActionBot.isElementDisplayed(driver, IPageBPO.PREVENT_ITEMS_OF_THE_OTHER_CATAGORIES_SETTINGS))
			{
				PageBPO.clickOnPreventItemsOfOtherCatagories(driver, testCaseName);
			}
			if (ActionBot.isElementDisplayed(driver, IPageBPO.PREVENT_CHANGING_PART_NO_SETTINGS))
			{
				PageBPO.clickOnPreventChangingPartNoCheckBox(driver, testCaseName);
			}
			if (ActionBot.isElementDisplayed(driver, IPageBPO.PREVENT_EXCEEDING_BLANKET_ORDER_VALUE_SETTINGS))
			{
				PageBPO.clickOnPreventExceedingTheBlanketOrderCheckBox(driver, testCaseName);
			}
			bpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);

			bpoNo1 = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (bpoNo1 != null)
				bpo.setPoNumber(bpoNo1);

			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests2 = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests2);
				FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			}
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.RELEASED);
			Assert.assertTrue(flag, "BPO is not in released state");
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			quantity = CommonUtilities.getNonZeroRandomNumbers(2);

			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			quantity = CommonUtilities.getNonZeroRandomNumbers(1);
			item.getGuidedItems().get(0).setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			item.getGuidedItems().get(0).setQuantity(quantity);
			item.getGuidedItems().get(0).setPartNumber(null);
			item.getGuidedItems().get(0).setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			item.getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.getCostBookingItemSummary().setNextAction(IConstantsData.NONE);
			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			deliveryItemSummary.setSplitDeliveryToMultipleLocations(true);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo1);
			deliveryItemSummary.setDeliverySplitInfo(deliverySplitInfos);
			deliveryItemSummary.setNextAction(IConstantsData.NONE);

			requisition.setDeliveryItemSummary(deliveryItemSummary);
			// req to buyers desk
			AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary = new AttachmentsAndCommentsItemSummary();
			FileAttachment attachment = new FileAttachment();
			attachment.setFileName(attachmentFileName);
			attachment.setFileVisibility(IConstantsData.internal_file_visibility);
			List<FileAttachment> attachments = new ArrayList<>();
			attachments.add(attachment);
			attachmentsAndCommentsItemSummary.setAttachments(attachments);
			attachmentsAndCommentsItemSummary.setCommentsForSupplier(commentsForSupplier);
			attachmentsAndCommentsItemSummary.setInternalComments(internalComments);
			attachmentsAndCommentsItemSummary.setNextAction(IConstantsData.SAVE);
			requisition.setAttachmentsAndCommentsItemSummary(attachmentsAndCommentsItemSummary);
			String attactmentFile = CommonServices.getTestData(IConstantsData.attachment_file_name, 0);

			requisition.setAttactmentFile(attactmentFile);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			// click on Enclosure link
			ActionBot.scroll(driver);
			PageViewPurchaseOrder.clickOnLinkEnclosure(driver, testCaseName);
			// release and amend
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests2 = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(0).getPoNo(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests2);
				FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			}
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.RELEASED);
			Assert.assertTrue(flag, "PO is not in released state");

			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			ActionBot.defaultSleep();
			purchaseorder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillOrderDescription(driver, testCaseName, Integer.toString(CommonUtilities.getNonZeroRandomNumbers(6)));
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseorder.getCustomDate().getDay(), purchaseorder.getCustomDate().getMonth(),
				purchaseorder.getCustomDate().getYear());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag, "PO is not created");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 215904 - User is able to save
	 * a requisition as draft and convert to PO with BPO and non-BPO items <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 6)
	public void RTC_225898(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		boolean flag;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);
			// req object creation

			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			item.getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			item.getGuidedItems().get(0).setEditCategory(true);
			item.getGuidedItems().get(0).setPrice(CommonUtilities.getNonZeroRandomNumber(2));
			item.getGuidedItems().get(0).setPartNumber(null);
			requisition.setItems(item);
			// req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			// select first reqno link
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "450");

			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			// select supplier and click on Show bpo button
			String searchtext = CommonServices.getTestData(IConstantsData.SUPPLIER_NAME);

			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, searchtext);
			ModalGuidedItemDetails.clickOnShowAllContractsButton(driver, testCaseName);
			ModalGuidedItemDetails.fillBpoNo(driver, testCaseName, bpoNo);
			ModalGuidedItemDetails.clickOnHeaderBpoNo(driver, testCaseName);
			ModalGuidedItemDetails.selectBpoRadioButton(driver, testCaseName);
			ActionBot.click(driver, IModalGuidedItemDetails.BUTTON_OK_SHOW_ALL_CONTRACTS);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag, "PO is not created");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 214918 - BPO is not getting
	 * reset on supplier change via change multiple, causing Release generation
	 * against different supplier than BPO. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createBPOS" }, priority = 7)
	public void RTC_219946(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		boolean flag = false;
		Requisition requisition = new Requisition();
		Item item = null;
		ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);
			item.getGuidedItems().get(0).setCategory(guidedItemSelectCategory);
			item.getGuidedItems().get(0).setPartNumber(null);
			item.getGuidedItems().get(0).setPrice(CommonUtilities.getNonZeroRandomNumber(2));

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			String bName = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			requisition.setAssignedBuyer(bName);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);
			// req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// select first reqno link
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "450");

			GuidedItem editGuidedItem = new GuidedItem();
			editGuidedItem.setSourcingStatus(IConstantsData.BUYER_NEGOTIATED_PRICE);
			editGuidedItem.setNextAction(IConstantsData.SAVE);
			// view item details
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.waitTillPopUpIsPresent(driver, IPageBuyersDesk.LOADER_ITEM_NAME);

			// change item details
			editGuidedItem = FlowBuyersDesk.editGuidedItemDetailsatBuyersDesk(driver, testCaseName, editGuidedItem);
			// send for apporval
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);
			FlowBuyersDesk.sendReqForApproval(driver, testCaseName);

			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.searchRequisitionByReqNo(driver, testCaseName, requisition.getReqNo());
			String status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			if (status.contains(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			}
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "600");
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

			String status1 = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status1.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(0).getPoNo(), IConstantsData.PURCHASE_ORDER,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				Assert.assertTrue(flag, "Error while searching PO");
			}
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			Assert.assertTrue(flag, "Status of PO was not Released");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 216455 - Error 500 thrown on
	 * releasing a BPO . <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_228924(TestCase testCase) throws Exception
	{

		WebDriver driver = null;
		driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		CommonServices.startTestCase(driver, testCase);
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		BPO copied_bpo = new BPO();
		BPO bpo_release = new BPO();
		BPO new_bpo = new BPO();
		Item item = new Item();
		Item item2 = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		boolean flag = false;
		String type, status;
		try
		{

			user = LoginLogoutServices.login(driver, testCase);
			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo_release = ObjectCreation.getDefaultObjectOfBOR();

			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObjectForBPO());
			item2.setGuidedItems(guidedItems);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// search BPO
			logger.info("============== Searching PO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			// data for new BPO
			new_bpo.setPoNumber("Copy_OF_" + bpo.getPoNumber());
			// from validity date
			CustomDate fromDate = CommonUtilities.getTodaysDate();
			new_bpo.setFromValidityDate(fromDate);
			// to validity date
			CustomDate toDate = CommonUtilities.getTodaysDate();
			toDate.setYear(toDate.getYear() + CommonUtilities.getNonZeroRandomNumbers(1));
			new_bpo.setToValidityDate(toDate);

			// copy BPO
			logger.info("============== Copying BPO ==============");
			copied_bpo = FlowBPO.copyBPO(driver, testCaseName, bpo.getItems());
			flag = FlowBPO.compareCopiedBPOInfo(driver, testCaseName, bpo, copied_bpo);
			assertTrue("Information in copied BPO was wrong", flag);

			// to create new BPO from copied BPO
			logger.info("============== Creating new BPO from copied BPO ==============");
			new_bpo = FlowBPO.fillBPOCreationForm(driver, testCaseName, new_bpo);

			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				new_bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// search new BPO
			logger.info("============== Searching copied BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching copied BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of copied BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, new_bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching copied BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of copied BPO was not Released", flag);
			}

			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			// to amend the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			ActionBot.scroll(driver, "400");
			// amend BPO
			logger.info("============== Amending BPO by adding new Catalog Item ===============");
			item = FlowStandardPo.addItem(driver, testCaseName, item);

			// to submit BPO for processing
			//@@@@@@@@@@@@@@@@error in this line@@@@@@@@@@@@@@@@@@@@@@@@@@//
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			// search new BPO
			logger.info("============== Searching copied BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching copied BPO", flag);
			// view po
			// to view amended BPO
			FlowPoListing.viewPO(driver, testCaseName);

			List<WebElement> itemNames = PageViewPurchaseOrder.getListOfItems(driver, testCaseName);
			flag = false;
			for (WebElement element : itemNames)
			{
				String itemName = element.getText().trim();
				if (itemName.equalsIgnoreCase(bpo.getItems().getCatelogItems().get(0).getItemName()) || itemName.equalsIgnoreCase(item.getCatelogItems().get(0).getItemName()))
				{
					flag = true;
				}
			}
			assertTrue("BPO was not amended, added catalog item was not present", flag);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// search new BPO
			logger.info("============== Searching copied BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching copied BPO", flag);

			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);
			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching release", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}
}
