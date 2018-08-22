package com.zycus.automation.eproc.testcase.regression.BpoToPR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.FlowFillGuidedItem;
import com.zycus.automation.eproc.businessflow.flipinvoice.FlowFlipInvoice;
import com.zycus.automation.eproc.businessflow.invoicelisting.FlowInvoiceListing;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem.ModalBlanketOrdersForFreeTextItem;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.invoiceactions.ModalInvoiceActions;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.recallinvoice.ModalRecallApprovalInvoiceRequest;
import com.zycus.automation.eproc.pageobjects.modals.returninvoice.ModalReturnInvoice;
import com.zycus.automation.eproc.pageobjects.modals.voidinvoice.ModalVoidInvoice;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.bpo.PageBPO;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting.PagePOInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class BpoToPRTestCases extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(BpoToPRTestCases.class);
	static String	bpoNo	= null;

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 14-Sep-2015 </b> <b>Method :
	 * RTC_00 <b>Description : CreateBPO </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	//done
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_00(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 11-Sep-2015 </b> <b>Method :
	 * RTC_201126 <b>Description : In Draft Req-BPR; Validation should be
	 * present for max total for categories defined on BPO. </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201126(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201127"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201128"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		String bpoNo = null;
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

			// to get requisition object
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// convert to PO and save as draft
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);

			// Open PO and change price of item

			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageBPO.clickOnCopedItemSummaryEdit(driver, 1);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 500);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp = StringUtils.split(amount.substring(4), ",");
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, temp[0]);

			// check price validation
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);
			mappedTestCases.get(1).setTestResult(price);

			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			// edit item and change quantity and submit
			PageBPO.clickOnCopedItemSummaryEdit(driver, 1);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 20);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 100);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String amount1 = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp1 = StringUtils.split(amount1.substring(4), ",");
			amount1 = "";
			for (String str : temp1)
			{
				amount1 += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount1);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check quantity error
			boolean quantity = PageStandardPO.isQuantityExceedingMaxValue(driver, testCaseName);
			Assert.assertTrue("Quantity exceeding max value error is not present", quantity);
			mappedTestCases.get(0).setTestResult(quantity);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 11-Sep-2015 </b> <b>Method :
	 * RTC_201129 <b>Description : In Draft Req-BPR; Validation should be
	 * present if BPO is closed </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201129(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201130"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		String bpoNo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

			// to get requisition object
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpo.getPoNumber());

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// convert to PO and save as draft
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			ActionBot.defaultSleep();
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);

			// close the bpo used
			ActionBot.defaultSleep();
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnClosePOFromActions(driver, testCaseName);
			PagePurchaseOrderListing.fillCloseCommentBox(driver, testCaseName, IConstantsData.CLOSE_PO_COMMENT);
			PagePurchaseOrderListing.clickOnClosePOButton(driver, testCaseName);
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// PagePurchaseOrderListing.clickOnClearFilter(driver, testCaseName,
			// 3);
			ActionBot.defaultSleep();

			// Open po and check for validation
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			boolean closeError = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("Error for closed BPO is not present", closeError);
			mappedTestCases.get(0).setTestResult(closeError);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Sep-2015 </b> <b>Method :
	 * RTC_201101 <b>Description : User should be able to create receipt against
	 * BOR created from PR as usual. </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201101(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201102"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201103"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201104"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201105"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_208745"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		String bpoNo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// convert to PO and submit the PO
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);

			// create receipt against that PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			Receipt receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setNextAction(IConstantsData.SUBMIT_INVOICE);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);
			boolean status = receipt.getStatus().equalsIgnoreCase("Confirmed") ? true : false;
			Assert.assertTrue("Receipt is not created against BOR", status);
			mappedTestCases.get(0).setTestResult(status);
			mappedTestCases.get(1).setTestResult(status);
			mappedTestCases.get(2).setTestResult(status);

			// create invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			Invoice invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);

			// check released status at req view
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionView.clickOnOrderTab(driver, testCaseName);
			String poStatus = PageRequisitionView.getPOStatusOnOrderTab(driver, testCaseName);
			boolean flag = poStatus.equalsIgnoreCase("Released") ? true : false;
			Assert.assertTrue("Released status of PO is not shown on req view of PR", flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 16-Sep-2015 </b> <b>Method :
	 * RTC_201114 <b>Description : PR to BOR>>Select BPO modal>>User should be
	 * able to paginate properly in case records are across pages. </font>
	 * <b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201114(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_206754"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201107"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// empty the cart
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// go to guided item screen
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// check Balance Amount column
			boolean column = ModalBlanketOrdersForFreeTextItem.isBalanceAmountColumnPresent(driver, testCaseName);
			Assert.assertTrue("Balance amount column is not present in show all BPO modal", column);
			mappedTestCases.get(1).setTestResult(column);

			// check pagination and records on BPO modal
			Integer no1 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);

			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 3);
			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			Integer no2 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 4);
			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			Integer no3 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 6);
			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			Integer no4 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);

			boolean flag = no4.equals(no1) ? true : false;
			Assert.assertTrue("Incorrect count of records is shown", flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 16-Sep-2015 </b> <b>Method :
	 * RTC_206966 <b>Description : Test for bug 214202 - Error
	 * 500[NumberFormatException] is displayed on clicking on preview PO for BPO
	 * items in Buyers desk </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_206966(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_206971"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_207023"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201108"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_244446"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		String bpoNo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);

			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

			// to get requisition object
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// check buyer name of PR and BPO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = requisition.getPurchaseOrdersList().get(0).getPoNo();
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String poBuyer = PageViewPurchaseOrder.getBuyerName(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String bpoBuyer = PageViewPurchaseOrder.getBuyerName(driver, testCaseName);
			String str = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getConsumedOrderValueOfBPO(driver, testCaseName));

			boolean buyer = bpoBuyer.equalsIgnoreCase(poBuyer) ? true : false;
			Assert.assertTrue("Buyer has changed in PR even though it was manually converted to PO", buyer);
			mappedTestCases.get(0).setTestResult(buyer);
			mappedTestCases.get(1).setTestResult(buyer);

			// after rollback action(cancel po), check consumed value
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelPoLink(driver, testCaseName);
			PageViewPurchaseOrder.fillCancelPoCommentField(driver, testCaseName, IConstantsData.CANCEL_PO_COMMENT);
			PageViewPurchaseOrder.clickOnCancelPoSubmitButtom(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String str1 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getConsumedOrderValueOfBPO(driver, testCaseName));

			boolean value = str != str1 ? true : false;
			Assert.assertTrue("After roll back action, the consumed order value of bpo has not rollbacked, which is wrong", value);
			mappedTestCases.get(2).setTestResult(value);
			mappedTestCases.get(3).setTestResult(value);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 21-Sep-2015 </b> <b>Method :
	 * RTC_219043 <b>Description : Test for bug 214466 - BPO related error
	 * thrown with no description on entering supplier part ID of max
	 * length. </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219043(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		String bpoNo = null;
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

			// to get requisition object
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req

			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// set part number as maximum and check for errors
			requisition.getItems().getGuidedItems().get(0).setPartNumber("5465758767898998867987608998896587953689786978695789687968978697865987965879687986987968796879896879");

			// submit req
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 21-Sep-2015 </b> <b>Method :
	 * RTC_201113 <b>Description : PR to BOR>>Select BPO modal>>Created by user
	 * should be the one who created BPO and not the one who amended. </font>
	 * <b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201113(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item item = new Item();
		User user = null;
		String bpoNo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String name1 = user.getDisplayName();
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// login with other user
			User user2 = UserUtilHelper.getAvailableUserFromList();
			UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.USERNAME, "amit.dash@zycus.com");
			LoginLogoutServices.logout(driver, testCase, user);
			ActionBot.defaultMediumSleep();
			LoginLogoutServices.login(driver, testCase, user2);
			String name2 = user2.getDisplayName();

			// amend bpo by user2
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1150)", "");
			PageBPO.fillFreightCharges(driver, testCaseName, "500");
			PageBPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// go to guided item screen
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpoNo);
			String name = ModalBlanketOrdersForFreeTextItem.getFirstBPOCreatedBy(driver, testCaseName);
			boolean flag = name.equals(name1) ? true : false;
			Assert.assertTrue("Created by user is not the one who created the bpo", !flag);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 21-Sep-2015 </b> <b>Method :
	 * RTC_201111 <b>Description : PR to BOR>>Rollback cases: Invoiced amount in
	 * a BPO should be rollbacked on : Invoice return </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "RTC_00" }, priority = 2)
	public void RTC_201111(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// create invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = requisition.getPurchaseOrdersList().get(0).getPoNo();
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			Invoice invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);

			// check and get invoiced amount of bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price1 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			// return invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
			PagePOInvoiceListing.clickOnReturnInvoiceAction(driver, testCaseName);
			ModalReturnInvoice.fillReturnInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RETURN_COMMENT);
			ModalReturnInvoice.clickOnReturnInvoiceButton(driver, testCaseName);

			// check invoice amount of bpo again after returning invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price2 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			boolean flag = price2 != price1 ? true : false;
			Assert.assertTrue("Invoiced amount has not changed even after returning the invoice", flag);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 22-Sep-2015 </b> <b>Method :
	 * RTC_201110 <b>Description : PR to BOR&gt;&gt;Rollback cases: Invoiced
	 * amount in a BPO should be rollbacked on : Invoice recall </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider", dependsOnMethods = { "RTC_00" }, priority = 2)
	public void RTC_201110(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_244443"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk and Convert PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// create invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = requisition.getPurchaseOrdersList().get(0).getPoNo();
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			Invoice invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);

			// check and get invoiced amount of bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price1 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			// recall invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			FlowInvoiceListing.confirmAndMatchInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
			ModalInvoiceActions.clickOnRecallApprovalRequest(driver, testCaseName);
			ModalRecallApprovalInvoiceRequest.fillRecallApprovalInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_RECALL_APPROVAL_REQUEST_COMMENT);
			ModalRecallApprovalInvoiceRequest.clickOnRecallButton(driver, testCaseName);

			// check invoice amount of bpo again after returning invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price2 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			boolean flag = price2 != price1 ? true : false;
			Assert.assertTrue("Invoiced amount has not changed even after recalling approval request of invoice", flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 22-Sep-2015 </b> <b>Method :
	 * RTC_201112 <b>Description : PR to BOR>>Rollback cases: Invoiced amount in
	 * a BPO should be rollbacked on : Invoice cancel </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider", dependsOnMethods = { "RTC_00" }, priority = 2)
	public void RTC_201112(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// convert to PO and submit the PO
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);

			// create invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			Invoice invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);

			// check and get invoiced amount of bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price1 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			// cancel invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnPOInvoiceActions(driver, testCaseName);
			ModalInvoiceActions.clickOnVoidInVoiceAction(driver, testCaseName);
			ModalVoidInvoice.fillVoidInvoiceComment(driver, testCaseName, IConstantsData.INVOICE_VOID_COMMENT);
			ModalVoidInvoice.clickOnVoidInvoiceButton(driver, testCaseName);

			// check invoice amount of bpo again after returning invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.applyTypeFilter(driver, testCaseName, IConstantsData.BLANKET_PO_TYPE);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnPoLink(driver, testCaseName, 1);
			String price2 = CommonUtilities.getDecimalPrice(PageViewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName));

			boolean flag = price2 != price1 ? true : false;
			Assert.assertTrue("Invoiced amount has not changed even after returning the invoice", flag);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 22-Sep-2015 </b> <b>Method :
	 * RTC_208858 <b>Description : Test for bug 214358 - Long description check
	 * is happening in case sensitive way instead of case insensitive. </font>
	 * <b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_208858(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		String bpoNo = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.getItems().getGuidedItems().get(0).setLongDescription("LongDescription");
			bpo.setPreventChangingPartNoAndItemDescription(true);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// create PR
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);
			requisition.getItems().getGuidedItems().get(0).setLongDescription("loNgdesCripTion");

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 22-Sep-2015 </b> <b>Method :
	 * RTC_201121 <b>Description : BPO to PR&gt;&gt;User should be able to link
	 * a item with all price types with an BPO </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider", dependsOnMethods = { "RTC_00" }, priority = 2)
	public void RTC_201121(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// add 1st item
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem1.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem1.setBPONo(bpoNo);
			guidedItem1.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem1);

			// add 2nd item
			GuidedItem guidedItem2 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem2.setSourcingStatus(IConstantsData.Estimated_price);
			guidedItem2.setBPONo(bpoNo);
			guidedItem2.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem2);

			// add 3rd item
			GuidedItem guidedItem3 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem3.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItem3.setBPONo(bpoNo);
			guidedItem3.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem3);

			items.setGuidedItems(guidedItems);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 24-Sep-2015 </b> <b>Method :
	 * RTC_201116 <b>Description : PR to BOR>>Validation on I'm Done : All
	 * validations should be present as of fresh PR submit in case of recalled
	 * PR </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider", dependsOnMethods = { "RTC_00" }, priority = 2)
	public void RTC_201116(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201117"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// Recall req
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnRecallApproveRequestLink(driver, testCaseName);

			// Open and submit req again as fresh req
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
			String status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean flag = status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			Assert.assertTrue("Requisition is not submitted successfully after recalling it before", flag);

			// Approve req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// return req from buyers desk listing and submit again
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnRejectAction(driver, testCaseName);
			ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
			ModalBuyersDeskReturnRequisition.clickOnReturnReqButton(driver, testCaseName);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);

			String status1 = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean flag1 = status1.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			Assert.assertTrue("Requisition is not submitted successfully after returning it before", flag1);
			mappedTestCases.get(0).setTestResult(flag1);

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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 24-Sep-2015 </b> <b>Method :
	 * RTC_201120 <b>Description : Buyer desk return for Need a quote item>>All
	 * Validations as of PR submit should be present on Submit for approval
	 * event from buyer desk. </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201120(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// submit for approval at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1050)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);

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
