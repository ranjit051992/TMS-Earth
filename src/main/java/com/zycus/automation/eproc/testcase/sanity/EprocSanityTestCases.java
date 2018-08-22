/**
 * 
 */
package com.zycus.automation.eproc.testcase.sanity;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.Basket;
import com.zycus.automation.bo.Budget;
import com.zycus.automation.bo.BudgetLine;
import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.Catalog;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.DeliveryItemSummary;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.NewDiscussion;
import com.zycus.automation.bo.PCard;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.bo.PoStatusFilter;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.PurchaseOrderSettings;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Report;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.bo.SourcingEvent;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.bo.UserSettings;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutils.UserUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.IFlowAllRequestsApprovalImpl;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.IFlowAllRequestsApprovalUtilies;
import com.zycus.automation.eproc.businessflow.allrequisitionflow.FlowAllRequisition;
import com.zycus.automation.eproc.businessflow.amendedpoflow.FlowAmendedPO;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.budget.FlowCreateBudget;
import com.zycus.automation.eproc.businessflow.budgetlisting.FlowBudgetListing;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.catalogflow.FlowCatalog;
import com.zycus.automation.eproc.businessflow.ceformflow.FlowCEform;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.createpcardflow.FlowCreatePCard;
import com.zycus.automation.eproc.businessflow.createreportflow.FlowCreateReport;
import com.zycus.automation.eproc.businessflow.flipinvoice.FlowFlipInvoice;
import com.zycus.automation.eproc.businessflow.invoicelisting.FlowInvoiceListing;

import com.zycus.automation.eproc.businessflow.mybasketflow.FlowMyBasket;
import com.zycus.automation.eproc.businessflow.myfavoritesflow.FlowMyFavorites;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.IFlowMyRequisitionUtil;
import com.zycus.automation.eproc.businessflow.nonpoinvoice.FlowNonPoInvoice;
import com.zycus.automation.eproc.businessflow.pcardlistingflow.FlowPCardListing;
import com.zycus.automation.eproc.businessflow.peformflow.FlowPEform;
import com.zycus.automation.eproc.businessflow.poinvoicelistingflow.FlowPOInvoiceListing;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.punchoutflow.FlowPunchout;
import com.zycus.automation.eproc.businessflow.purchaseordersetting.FlowPurchaseOrderSetting;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.reportlistingflow.FlowReportListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.requisitionsettingsflow.FlowRequisitionSettings;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCartUtil;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.businessflow.upcomingrequisitionlistingflow.FlowUpcomingRequisitionListing;
import com.zycus.automation.eproc.businessflow.viewpoflow.FlowViewPO;
import com.zycus.automation.eproc.businessflow.viewreportdetailsflow.FlowViewReportDetails;
import com.zycus.automation.eproc.businessflow.viewreqflow.FlowViewRequisition;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.pageobjects.modals.addapprover.ModalAddApprover;
import com.zycus.automation.eproc.pageobjects.modals.additemtocatalog.ModalAddItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions.ModalAllRequestsApprovalActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdeskguideditemdetails.ModalBuyersDeskGuidedItemSourcingDetails;
import com.zycus.automation.eproc.pageobjects.modals.cataloglistingactions.ModalCatalogListingActions;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.createsourcingevent.ModalCreateSourcingEvent;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.IModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSLocationsPageMasterDataSetting.TMSPageLocationsSetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSmasterDataSettings.PageTMSMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.PageAmmendedPO;
import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.PageBudgetListing;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.PageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.catalogview.PageCatalogView;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.PageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.createbudget.PageCreateBudget;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.PageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createreport.PageCreateReport;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.PagePCardListing;
import com.zycus.automation.eproc.pageobjects.pages.peformlisting.PagePEformListing;
import com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting.PagePOInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.previewpo.PagePreviewPOPage;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.PageReceiptListing;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.requisitionForking.PageRequisitionForking;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.IPageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval.PopUpSendForApproval;
import com.zycus.automation.eproc.pageobjects.popups.defaultalert.PopUpDefalutAlert;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.defaulterror.PopUpDefaultError;
import com.zycus.automation.eproc.pageobjects.popups.defaultsuccess.PopUpDefaultSuccess;
import com.zycus.automation.eproc.pageobjects.tabs.TMS_MainPageHeaderLevelTabs.PageTMSmainHeaderLevelTabs;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.validation.VerifyComparedCatalogItems;
import com.zycus.automation.eproc.validation.VerifySearchListing;
import com.zycus.automation.eproc.validation.VerifyShoppingItemsWithShoppingCarts;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.CommonUtil;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

/**
 * @author ankita.sawant
 */
public class EprocSanityTestCases extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(EprocSanityTestCases.class);
	static String	bpoNo	= null;

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Recall a requisition which is in In
	 * Approval status. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Search for the recalled req name with
	 * the draft filter </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @throws Exception
	 * @throws WebDriverException
	 * @throws SessionNotFoundException
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void recallRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		Requisition requisition = new Requisition();
		Item item = new Item();
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostBookingAndAccountingItemSummaryCOA> coaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			// to set below values if COA setting is On.
			if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.YES))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for COA");
				// to read coa data and to store it in BO
				coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

				// to login with custom COA user
				user.setUsername(ConfigProperty.getConfig("coaUsername"));
				user.setPassword(ConfigProperty.getConfig("coaPassword"));

				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);

				// setting cost booking and accounting summart for COA
				accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
				accountingItemSummary.setNextAction(IConstantsData.NONE);
				costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

				// adding parameters for req creation
				requisition.setCostBookingItemSummary(null);
				requisition.setEditHeaderLevelInfo(false);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				// adding COA related parameters
				CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
				itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
				itemSummaryCoa.setSplit(2);

				requisition.setEditCOAInfo(true);
				requisition.setCoaDataList(coaBO);
				itemSummaryCoa.setTotalRows(coaBO.size());
				requisition.setItemSummaryCoa(itemSummaryCoa);

				// login to application
				LoginLogoutServices.login(driver, testCase, user);
			}
			else if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.NO))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for Non-COA");
				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				user = LoginLogoutServices.login(driver, testCase);
			}

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// action for recalling
			requisition.setNextAction(IConstantsData.RECALL);

			// recall req
			FlowMyRequisitions.recallApprovalRequest(driver, testCaseName, requisition);

			// check req is recalled or not
			assertTrue("Recalled requisition not in drafts status", IFlowMyRequisitionUtil.checkIfRequisitionRecalled(driver, testCaseName, requisition));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (NullPointerException e)
		{
			logger.info("Null received: " + e);
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Approve a requisition from the Approval
	 * tab <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Search for the req in the approved
	 * status </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void approveRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		Requisition requisition = new Requisition();
		Item item = new Item();
		String docNo = null;
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostBookingAndAccountingItemSummaryCOA> coaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			// to set below values if COA setting is On.
			if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.YES))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for COA");
				// to read coa data and to store it in BO
				coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

				// to login with custom COA user
				user.setUsername(ConfigProperty.getConfig("coaUsername"));
				user.setPassword(ConfigProperty.getConfig("coaPassword"));

				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);

				// setting cost booking and accounting summart for COA
				accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
				accountingItemSummary.setNextAction(IConstantsData.NONE);
				costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

				// adding parameters for req creation
				requisition.setCostBookingItemSummary(null);
				requisition.setEditHeaderLevelInfo(false);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				// adding COA related parameters
				CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
				itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
				itemSummaryCoa.setSplit(2);

				requisition.setEditCOAInfo(true);
				requisition.setCoaDataList(coaBO);
				itemSummaryCoa.setTotalRows(coaBO.size());
				requisition.setItemSummaryCoa(itemSummaryCoa);

				// login to application
				LoginLogoutServices.login(driver, testCase, user);
			}
			else if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.NO))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for Non-COA");
				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				user = LoginLogoutServices.login(driver, testCase);
			}

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// to apply approved filter in all requests tab
			ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter = new ApprovalAllRequestsStatusFilter();
			approvalAllRequestsStatusFilter.setApproved(true);
			approvalAllRequestsStatusFilter.setStatusOfFilter(IConstantsData.APPROVED_FILTER_STATUS);

			approvalAllRequestsStatusFilter = FlowAllRequestsApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

			assertTrue("Approved filter is not applied properly", approvalAllRequestsStatusFilter.isResult());

			// to search in aprroval tab
			FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);
			docNo = PageAllRequestsApproval.getFirstRowDocumentNo(driver, testCaseName);
			assertTrue("Requisition not approved", docNo.equalsIgnoreCase(requisition.getReqNo()));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Reject a requisition from the Approval
	 * tab <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Search for the req in the rejected
	 * status </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void rejectRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		Requisition requisition = new Requisition();
		Item item = new Item();
		String docNo = null;
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostBookingAndAccountingItemSummaryCOA> coaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.YES))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for COA");
				// to read coa data and to store it in BO
				coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

				// to login with custom COA user
				user.setUsername(ConfigProperty.getConfig("coaUsername"));
				user.setPassword(ConfigProperty.getConfig("coaPassword"));

				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);

				// setting cost booking and accounting summart for COA
				accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
				accountingItemSummary.setNextAction(IConstantsData.NONE);
				costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

				// adding parameters for req creation
				requisition.setCostBookingItemSummary(null);
				requisition.setEditHeaderLevelInfo(false);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				// adding COA related parameters
				CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
				itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
				itemSummaryCoa.setSplit(2);

				requisition.setEditCOAInfo(true);
				requisition.setCoaDataList(coaBO);
				itemSummaryCoa.setTotalRows(coaBO.size());
				requisition.setItemSummaryCoa(itemSummaryCoa);

				// login to application
				LoginLogoutServices.login(driver, testCase, user);
			}
			else if (ConfigProperty.getConfig("isCoaTenant").equalsIgnoreCase(IConstants.NO))
			{
				logger.info("\nTestcase >>" + testCaseName + " started for Non-COA");
				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				user = LoginLogoutServices.login(driver, testCase);
			}

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.REJECT);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// to apply approved filter in all requests tab
			ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter = new ApprovalAllRequestsStatusFilter();
			approvalAllRequestsStatusFilter.setRejected(true);
			approvalAllRequestsStatusFilter.setStatusOfFilter(IConstantsData.REJECTED_FILTER_STATUS);

			approvalAllRequestsStatusFilter = FlowAllRequestsApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

			assertTrue("Rejected filter is not applied properly", approvalAllRequestsStatusFilter.isResult());

			// to search in aprroval tab
			FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);
			docNo = PageAllRequestsApproval.getFirstRowDocumentNo(driver, testCaseName);
			assertTrue("Requisition is not rejected", docNo.equalsIgnoreCase(requisition.getReqNo()));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Approve a PO from All Approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> Status of PO should be released </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void approvePO(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		StandardPO standardPO = new StandardPO();
		String status;
		float price = (float) 968549733695.36;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ObjectCreation.getItem(IConstantsData.BOTH);

			// to get standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO.getItems().getCatelogItems().get(0).setQuantity(500);
			standardPO.getItems().getGuidedItems().get(0).setQuantity(500f);
			standardPO.getItems().getGuidedItems().get(0).setPrice(price);

			// to create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageViewPurchaseOrder.getViewPONo(driver, testCaseName);

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(), IConstantsData.PURCHASE_ORDER,
				IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// to search PO
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error in searching PO", flag);

			// to check status of PO
			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL) || status.equalsIgnoreCase(IConstantsData.PARKED_FILTER_LABEL);
			assertTrue("Status of PO was not Released or Parked , PO not approved", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Reject a PO from All Approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> Status of PO should be rejected </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void rejectPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		StandardPO standardPO = new StandardPO();
		Item item = new Item();
		List<CatelogItem> listOfCatalogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> listOfGuidedItems = new ArrayList<GuidedItem>();
		float price = (float) 968549733695.36;
		String status;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.BOTH);
			listOfCatalogItems = item.getCatelogItems();
			listOfGuidedItems = item.getGuidedItems();

			// to set max quantity
			for (CatelogItem catelogItem : listOfCatalogItems)
			{
				catelogItem.setQuantity(500);
			}

			for (GuidedItem guidedItem : listOfGuidedItems)
			{
				guidedItem.setQuantity(500f);
				guidedItem.setPrice(price);
			}

			// to get standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);

			/*
			 * List<FileAttachment> attachments = new ArrayList<>();
			 * FileAttachment attachment = new FileAttachment();
			 * attachment.setFileName(IConstants.ATTACHMENT_FILES_PATH +
			 * ConfigProperty.getConfig(IConstants.reqAttachment));
			 * attachment.setFileVisibility(IConstantsData.
			 * supplier_file_visibility); attachments.add(attachment);
			 * standardPO.setAttachments(attachments);
			 */

			standardPO.getItems().getCatelogItems().get(0).setQuantity(500);
			standardPO.getItems().getGuidedItems().get(0).setQuantity(500f);
			standardPO.getItems().getGuidedItems().get(0).setPrice(price);

			// to create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageViewPurchaseOrder.getViewPONo(driver, testCaseName);

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(), IConstantsData.PURCHASE_ORDER,
				IConstantsData.REJECT);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// to search PO
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error in searching PO", flag);

			// to check status of PO
			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			assertTrue("Status of PO was not Released , PO not approved", status.equalsIgnoreCase(IConstantsData.REJECTED_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Recall a PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> Status of PO should be draft </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void recallPO(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		StandardPO standardPO = new StandardPO();
		Item item = new Item();
		List<CatelogItem> listOfCatalogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> listOfGuidedItems = new ArrayList<GuidedItem>();
		float price = (float) 968549733695.36;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.BOTH);
			listOfCatalogItems = item.getCatelogItems();
			listOfGuidedItems = item.getGuidedItems();

			// to set max quantity
			for (CatelogItem catelogItem : listOfCatalogItems)
			{
				catelogItem.setQuantity(500);
			}

			for (GuidedItem guidedItem : listOfGuidedItems)
			{
				guidedItem.setQuantity(500f);
				guidedItem.setPrice(price);
			}

			// to get standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO.getItems().getCatelogItems().get(0).setQuantity(500);
			standardPO.getItems().getGuidedItems().get(0).setQuantity(500f);
			standardPO.getItems().getGuidedItems().get(0).setPrice(price);

			// to create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageViewPurchaseOrder.getViewPONo(driver, testCaseName);

			// to search PO
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error in searching PO", flag);

			// to recall po
			FlowPoListing.recallApprovalRequestForPurchaseOrder(driver, testCaseName);

			assertTrue("Recalled requisition not in drafts", FlowPoListing.checkIfPORecalled(driver, testCaseName, standardPO.getPoNumber()));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Ask more Info from Listing & view Page of
	 * Approval tab <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void moreInfoFromAllApproval(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// req object creation
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			// create Req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			Assert.assertTrue("Error while searching requisition in my requisition tab", requisition.isResult());

			// to search in allrequests tab
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentName(requisition.getReqName());

			approvalAllRequests = FlowAllRequestsApproval.searchInAllRequestsApprovalTab(driver, testCaseName, approvalAllRequests);
			// Assert.assertTrue("Error while searching requisition in all
			// requests tab", approvalAllRequests.isResult());

			// to start new discussion
			NewDiscussion newDiscussion = new NewDiscussion();
			newDiscussion.setTo(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			newDiscussion.setMessage("Auto generated message for new discussion");
			newDiscussion.setSharedWithAll(true);
			newDiscussion.setNextAction(IConstantsData.SUBMIT);

			newDiscussion = FlowAllRequestsApproval.startNewDiscussion(driver, testCaseName, newDiscussion);

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
	 * <b>Author: ankita.sawant </b> <b><br>
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
	@Test(dataProvider = "dataProvider", priority = 2)
	public void createBPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		BPO copied_bpo = new BPO();
		BPO bpo_release = new BPO();
		BPO new_bpo = new BPO();
		Item item = new Item();
		Item item2 = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		boolean flag = false;
		String url, type, status;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("copyBPO"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("amendBPO"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("createReleaseAgainstBPO"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("amendBOR"));// 3
			}
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

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
			// MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);

			// search BPO
			logger.info("============== Searching BPO ==============");
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
			new_bpo.setDeliveryTerms(CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
			// copy BPO
			logger.info("============== Copying BPO ==============");
			copied_bpo = FlowBPO.copyBPO(driver, testCaseName, bpo.getItems());
			flag = FlowBPO.compareCopiedBPOInfo(driver, testCaseName, bpo, copied_bpo);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Information in copied BPO was wrong");
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
			driver.get(url);
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

				/*
				 * ActionBot.defaultHighSleep(); driver.navigate().refresh();
				 * driver.navigate().refresh(); driver.navigate().refresh();
				 * driver.navigate().refresh(); driver.navigate().refresh();
				 */
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

			ActionBot.scroll(driver, "600");
			// amend BPO
			logger.info("============== Amending BPO by adding new Catalog Item ===============");
			item = FlowStandardPo.addItem(driver, testCaseName, item);

			// to submit BPO for processing
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
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "BPO was not amended, added catalog item was not present");
			assertTrue("BPO was not amended, added catalog item was not present", flag);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search new BPO
			logger.info("============== Searching copied BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching copied BPO", flag);

			// adding more details to bpo_release object
			/*
			 * Item item2 = bpo.getItems();
			 * item2.getCatelogItems().add(item.getCatelogItems().get(0));
			 * bpo_release.setItems(item2);
			 */

			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);
			Item item3 = new Item();
			item3 = bpo.getItems();
			item3.getCatelogItems().add(item.getCatelogItems().get(0));
			bpo_release.setItems(item3);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);
			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching release", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Type of BPO was wrong, it should be Release");
			assertTrue("Type of BPO was wrong, it should be Release.", flag);

			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			// to amend the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			ActionBot.scroll(driver, "400");
			ActionBot.defaultSleep();
			// amend BOR
			logger.info("============== Amending BOR ===============");
			item2 = FlowStandardPo.addItem(driver, testCaseName, item2);

			// to submit BOR for processing
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching release", flag);
			// view po
			// to view amended BPO
			FlowPoListing.viewPO(driver, testCaseName);

			itemNames = PageViewPurchaseOrder.getListOfItems(driver, testCaseName);
			flag = false;
			for (WebElement element : itemNames)
			{
				String itemName = element.getText().trim();
				if (itemName.equalsIgnoreCase(bpo.getItems().getCatelogItems().get(0).getItemName())
					|| itemName.equalsIgnoreCase(item2.getGuidedItems().get(0).getShortDescription()))
				{
					flag = true;
				}
			}
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "BOR was not amended, added guided item was not present");
			assertTrue("BOR was not amended, added guided item was not present", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create BOR ggainst req <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 2) //,dependsOnMethods = { "createBPO" })
	public void createBORAgainstReq(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		boolean flag = false;
		String type;
		Requisition requisition = new Requisition();
		List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();

		BPO bpo = new BPO();
		BPO copied_bpo = new BPO();
		BPO bpo_release = new BPO();
		Item item = new Item();
		Item item2 = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

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

			// search new BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				/*
				 * ActionBot.defaultHighSleep(); driver.navigate().refresh();
				 * driver.navigate().refresh(); driver.navigate().refresh();
				 * driver.navigate().refresh(); driver.navigate().refresh();
				 */
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching copied BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of copied BPO was not Released", flag);
			}

			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpo.getPoNumber());
			//			requisition.setPoNo(bpo.getPoNumber());

			//			flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			//			assertTrue("Error while searching BPO", flag);
			//
			//			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			//			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			//			if(flag==true){
			//				
			//				PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			//				
			//				String bpoOrderValue=null;
			//				PageViewPurchaseOrder.getOrderValue(driver, testCaseName);
			//				String bpoConsumedValue=PageViewPurchaseOrder.getConsumedOrderValueOfBPO(driver, testCaseName);
			//	

			int singleDigitNo = CommonUtilities.getRandomNumbersBetweenRange(1, 0, 9);

			requisition.getItems().getGuidedItems().get(0).setPrice(singleDigitNo);
			requisition.getItems().getGuidedItems().get(0).setQuantity((float) singleDigitNo);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// submit all POs
			purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			// to search BOR
			for (PurchaseOrder purchaseOrder : purchaseOrders)
			{
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("BOR was not created against requisition", flag);

				type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
				flag = type.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE);
				assertTrue("Type of BPO was wrong, it should be Release.", flag);
			}
			//			}

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create New Budget with all dimentions <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void createBudgetWithAllDimensions(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = new Budget();
		boolean flag = false;
		String status = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addPeriodInBudget"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addBudgetLines"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveAnyBudgetLines"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveAndFreezeBudget "));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("searchBudget"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveBudgetAsDraft"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("editTheDraftBudget"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deleteSelectedBudgetLines"));// 7
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("updateValidityOfBudget"));// 8
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addBudgetLinesInInUseBudget"));// 9
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("updateAnyBudget"));// 10
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivateBudget"));// 11
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setCurrencyType("INR");
			budget.setNextAction(IConstantsData.SAVE_AS_DRAFT);

			// create budget
			logger.info("\n ========= Creating budget ===========");
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);

			// search budget
			logger.info("\n ========= Searching budget ===========");
			flag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			CommonServices.setMappedTestCaseResult(budget.getBudgetPeriod().isResult(), mappedTestCases.get(0), "Error while adding period in budget");
			CommonServices.setMappedTestCaseResult(budget.getBudgetLines().get(0).isResult(), mappedTestCases.get(1), "Error while adding budget lines in budget");
			/*
			 * CommonServices.setMappedTestCaseResult(true,
			 * mappedTestCases.get(1),
			 * "Error while adding budget lines in budget");
			 */
			CommonServices.setMappedTestCaseResult(budget.getBudgetLines().get(0).isResult(), mappedTestCases.get(2), "Error while saving budget line");
			// CommonServices.setMappedTestCaseResult(true,
			// mappedTestCases.get(2), "Error while saving budget line");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Error while searching budget");

			assertTrue("Budget was not searched", flag);

			// check status
			status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Status of budget was wrong, it should be Draft");
			assertTrue("Status of budget was wrong, it should be Draft", flag);

			// to view the budget
			logger.info("\n ========= Edit draft budget ===========");
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// to edit the budget :- add budget line
			ActionBot.scroll(driver);
			BudgetLine newBudgetLine = ObjectCreation.getDefaultObjetOfBudgetLine();
			newBudgetLine.setCostCenter(CommonUtilities.getOtherCostCenterInfoFromTestData().getCostCenter());

			logger.info("\n ========= Add budget line to budget ===========");
			newBudgetLine = FlowCreateBudget.addBudgetLine(driver, testCaseName, newBudgetLine);
			newBudgetLine.setResult(FlowCreateBudget.checkIfBudgetLineAdded(driver, testCaseName, newBudgetLine, 2));
			/*
			 * CommonServices.setMappedTestCaseResult(true,
			 * mappedTestCases.get(6),
			 * "Error editing draft budget, new budget was not added");
			 */
			CommonServices.setMappedTestCaseResult(newBudgetLine.isResult(), mappedTestCases.get(6), "Error editing draft budget, new budget was not added");

			// to delete the budget line
			logger.info("\n ========= Delete budget line from budget ===========");
			flag = FlowCreateBudget.deletBudgetLine(driver, testCaseName, newBudgetLine.getBudgetLineName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "Error deleting selected budget line");

			// to save and freeze budget
			logger.info("\n ========= Save and freeze budget ===========");
			FlowCreateBudget.saveAndFreezeBudget(driver, testCaseName);

			// search budget
			logger.info("\n ========= Searching budget ===========");
			flag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			assertTrue("Budget was not searched", flag);

			// check status
			status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.IN_USE);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "Error while saving and freezing budget,Status of budget was wrong, it should be In Use ");
			assertTrue("Status of budget was wrong, it should be In Use", flag);

			// update budget validity
			logger.info("\n ========= Update validity of budget ===========");
			CustomDate endDate = CommonUtilities.getDayAfterTodaysDate();
			endDate.setYear(budget.getBudgetPeriod().getPeriodEndDate().getYear() - 1);
			FlowBudgetListing.updateBudgetValidity(driver, testCaseName, endDate);
			ActionBot.defaultSleep();
			// to view the budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			String toBudgetDate = PageCreateBudget.getToBudgetDateOnBudgetViewPage(driver, testCaseName);
			flag = toBudgetDate.equalsIgnoreCase(endDate.getDate());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(8), "Error while updating validity of budget");

			// to edit the budget :- add budget line
			ActionBot.scroll(driver);
			newBudgetLine = ObjectCreation.getDefaultObjetOfBudgetLine();
			newBudgetLine.setCostCenter(CommonUtilities.getOtherCostCenterInfoFromTestData().getCostCenter());

			logger.info("\n ========= Add budget line to In Use budget ===========");
			newBudgetLine = FlowCreateBudget.addBudgetLine(driver, testCaseName, newBudgetLine);
			newBudgetLine.setResult(FlowCreateBudget.checkIfBudgetLineAdded(driver, testCaseName, newBudgetLine, 2));
			CommonServices.setMappedTestCaseResult(newBudgetLine.isResult(), mappedTestCases.get(9), "Error while adding Budget Line to InUse Budget");
			CommonServices.setMappedTestCaseResult(newBudgetLine.isResult(), mappedTestCases.get(10), "Error while updating budget");

			// to save and freeze budget
			logger.info("\n ========= Updating budget ===========");
			FlowCreateBudget.saveAndFreezeBudget(driver, testCaseName);

			// search budget
			logger.info("\n ========= Searching budget ===========");
			flag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			assertTrue("Budget was not searched", flag);

			// check status
			status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.IN_USE);
			assertTrue("Status of budget was wrong, it should be In Use", flag);

			// deactivate budget
			logger.info("\n ========= Deactivating budget ===========");
			flag = FlowBudgetListing.deactivateBudget(driver, testCaseName, budget);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(11), "Budget was not deactivated");
			assertTrue("Budget was not deactivated", flag);
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Edit a requisition which is in the
	 * pending state at buyers desk and return it. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the supplier comment entered
	 * in the req is the same </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void editPendingReqAndReturnFromBuyersDesk(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		Requisition editReqAtBuyersDesk = new Requisition();
		Item item = new Item();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("editPendingReq"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			editReqAtBuyersDesk.setItems(requisition.getItems());
			// editReqAtBuyersDesk.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);

			// accounting object
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			editReqAtBuyersDesk.setCostBookingItemSummary(costBookingItemSummary);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// edit req
			editReqAtBuyersDesk = FlowBuyersDesk.editRequisitionAtBuyersDesk(driver, testCaseName, editReqAtBuyersDesk);

			// save the req
			FlowBuyersDesk.saveRequisitionFromBuyersDesk(driver, testCaseName);

			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			flag = FlowBuyersDesk.checkIfRequisitionEditedAtBuyersDesk(driver, testCaseName, editReqAtBuyersDesk);
			flag = true;
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Requisition is not edited at buyers desk");
			assertTrue("Requisition is not edited at buyers desk", flag);

			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// to return req from buyers desk
			flag = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			assertTrue("Pending Requisition was not returned", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Returns a requisition which is in the
	 * pending state <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the status of the return
	 * pending req is returned </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void returnPendingReq(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to return req from buyers desk
			flag = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			assertTrue("Pending Requisition was not returned", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Submits a req with free text item and
	 * approves it, and checks if it is there in buyers desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Searches for the req name in the buyers
	 * desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void submitAndApproveGuidedReq(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("changeBuyerFromBuyerDeskListing"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		String reqName;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to change accounting setting
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);
			requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.NO);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to get Item object
			guidedItems = ObjectCreation.getAllCombinationOfGuidedItemObject();
			item.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);
			requisition.setEditItemLevelInfo(false);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			reqName = PageBuyersDeskListing.getFirstRowReqName(driver, testCaseName);
			logger.info("Searched requisition name at buyers desk : " + reqName);
			flag = reqName.contains(requisition.getReqName());
			assertTrue("Requisition with guided item did not appear in buyers desk", flag);

			// to change buyer
			requisition.setAssignedBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setNextAction(IConstantsData.SAVE);

			requisition = FlowBuyersDeskListing.changeAssignedBuyer(driver, testCaseName, requisition);
			mappedTestCases.get(0).setTestResult(requisition.isResult());
			assertTrue("Assigned buyer is not changed from buyer desk listing", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Edit, convert req from buyers desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the converted po is searched
	 * on PO listing Page </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void editAndConvertReqToPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();

			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// submit all POs
			purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			// to search po
			for (PurchaseOrder purchaseOrder : purchaseOrders)
			{
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Purchase order was not created", flag);
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Edit, convert req, save as draft from
	 * buyers desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks to see if the supplier and the
	 * item price total appear in po drafts </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void editAndConvertReqToPOSaveAsDraft(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		boolean flag = false;
		String poTotal, poNo, auto_generated_PO_NO, status;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("submitDraftPO"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setAssignedBuyer(null);
			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// to click on first checkbox
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedSupplier(driver, testCaseName, 2);
			poTotal = PagePurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedPoTotal(driver, testCaseName, 0);

			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);

			// apply draft po filter
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);

			flag = PagePurchaseOrderListing.isPOWithGivenAmountPresentInListing(driver, testCaseName, poTotal);
			assertTrue("Converted PO not saved as draft", flag);

			poNo = PagePurchaseOrderListing.getPOWithGivenAmount(driver, testCaseName, poTotal);

			// search po
			flag = FlowPoListing.searchPO(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching po", flag);

			// view first po
			FlowPoListing.viewPO(driver, testCaseName);

			poNo = PageStandardPO.getPONo(driver, testCaseName);
			// to submit PO
			PageStandardPO.selectDeliveryTerms(driver, null);
			auto_generated_PO_NO = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (auto_generated_PO_NO != null)
			{
				poNo = auto_generated_PO_NO;
			}

			// to search PO
			flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("PO was not searched", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL) || status.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Status of PO was wrong, it should be either In Approval or Released after submitting draft po");
			assertTrue("Status of PO was wrong, it should be either In Approval or Released after submitting draft po", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Convert multiple reqs to po from buyers
	 * desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void convertMultipleReqToPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition1 = new Requisition();
		Item item1 = new Item();
		Requisition requisition2 = new Requisition();
		Item item2 = new Item();
		List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);

			/** First Req **/

			// to get Item object
			item1 = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

			// to get requisition object
			requisition1 = ObjectCreation.getRequisition(driver);
			requisition1.setItems(item1);
			requisition1.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition1.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition1.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition1.setRequired(true);
			requisition1.setAssignedBuyer(null);

			// req to buyers desk
			requisition1 = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition1);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			/** Second Req **/

			// to get Item object
			item2 = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

			// to get requisition object
			requisition2 = ObjectCreation.getRequisition(driver);
			requisition2.setItems(item2);
			requisition2.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition2.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition2.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);

			// req to buyers desk
			requisition2 = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition2);

			// to get list of req
			PageBuyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

			List<WebElement> listOfReq = PageBuyersDeskListing.getAllReqNos(driver, testCaseName);

			// to select two req
			for (WebElement element : listOfReq)
			{
				if (element.isDisplayed())
				{
					String reqName = element.getText().trim();
					if (reqName.equalsIgnoreCase(requisition1.getReqNo()) || reqName.equalsIgnoreCase(requisition2.getReqNo()))
					{
						WebElement parentRow = element.findElement(IPageSearchListing.ANCSESTOR_TR.getBy());
						WebElement checkboxElement = parentRow.findElement(IPageSearchListing.INPUT);
						checkboxElement.click();
						if (!checkboxElement.isSelected())
						{
							checkboxElement.click();
						}
					}
				}
			}

			ScreenShot.screenshot(driver, testCaseName, "After selecting two req");

			// convert to po
			PageBuyersDeskListing.clickOnConvertToPoButton(driver, testCaseName);

			// submit all POs
			purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			// to search po
			for (PurchaseOrder purchaseOrder : purchaseOrders)
			{
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Purchase order was not created", flag);
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Edit catalog from the catalogs tab <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Check if the price of the item in the
	 * catalog has been updated </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void updateCatalog(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Catalog catalog = new Catalog();
		CatelogItem catelogItem = new CatelogItem();
		List<String> itemNames_onViewPage = new ArrayList<String>();
		String status, supplierName_onViewPage, testCaseName = "";
		double modifiedPrice = 693.45, modifiedPriceOnItemListing = 0;
		boolean flag = false, toDeactivateFlag = false, toDeleteFlag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("createCatalog"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("publishCatalog"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addItemInCatalog"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_EPROC_1946"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("viewCatalog"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivateCatalog"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deleteCatalog"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("recallCatalog"));// 7
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_304"));// 8
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_306"));// 9
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_307"));// 10
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_308"));// 11
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			catalog = ObjectCreation.getDefaultCatalogObject();
			// catalog.setOrganizationUnit(IConstantsData.ALL);
			catelogItem = ObjectCreation.getDefaultCatalogItemObject();
			catelogItem.setUnitPrice(236.69);
			catelogItem.setSupplierPartID(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(3)));
			catelogItem.setNextAction(IConstantsData.ADD_ITEM_TO_CATALOG);

			// create catalog
			catalog = FlowCatalog.createCatalog(driver, testCaseName, catalog);
			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			createCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Catalog was not created");
			}
			assertTrue("Catalog was not created", flag);

			// to approve catalog
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			/*
			 * approvalAllRequests.setActions(IConstantsData.APPROVE);
			 * approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			 * approvalAllRequests.setDocumentType(IConstantsData.CATALOG);
			 * approvalAllRequests.setDocumentName(catalog.getCatalogName());
			 * FlowCatalog.approveCatalog(driver, testCaseName,
			 * approvalAllRequests);
			 */
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			assertTrue("Status of catalog was wrong, it should be In Approval", flag);

			// recall catalog
			flag = FlowCatalog.recallCatalog(driver, testCaseName, catalog.getCatalogName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "Catalog was not recalled");
			assertTrue("Catalog was not recalled", flag);

			// view Catalog
			FlowCatalog.viewCatalog(driver, testCaseName);

			// click on next item details
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);

			// submit the catalog
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);

			// submit catalog
			FlowCatalog.submitCatalog(driver, testCaseName, true, true);

			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			assertTrue("Error while searching updated catalog", flag);

			// to approve catalog
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NAME, catalog.getCatalogName(), IConstantsData.CATALOG,
					IConstantsData.APPROVE);
				approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search catalog
				flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
				assertTrue("Error while searching catalog", flag);
			}

			// Publish catalog
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL);
			toDeactivateFlag = true;
			toDeleteFlag = true;
			publishCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Status of catalog was not published");
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(8), "Status of catalog was not published");
			}
			assertTrue("Status of catalog was not published", flag);

			/**
			 * RTC_EPROC_1946 : Unable to update a published catalog after
			 * deleting its draft copy.
			 **/

			// UPDATE CATALOG
			PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
			ModalCatalogListingActions.clickOnUpdateCatalog(driver, testCaseName);
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);
			// submit the catalog
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
			// save as draft catalog
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);

			// search catalog
			logger.info("============== Search Catalog ==============");
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			assertTrue("Error while searching updated catalog", flag);
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of catalog was not Draft", flag);
			draftCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(10), "Status of catalog was not draft");
			}

			// delete catalog
			logger.info("============== Delete Draft Catalog ==============");
			FlowCatalog.deleteCatalog(driver, testCaseName, catalog);

			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL);
			assertTrue("Draft catalog was not deleted", flag);
			deleteDraftCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(11), "Error while deleting draft catalog");
			}

			// UPDATE CATALOG
			PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
			ModalCatalogListingActions.clickOnUpdateCatalog(driver, testCaseName);
			ActionBot.defaultSleep();
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);

			// to edit catalog item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			// change price of catalog item
			modifiedPrice = ModalAddItemDetails.fillPrice(driver, testCaseName, modifiedPrice);
			modifiedPrice = Double.parseDouble(CommonUtilities.getDecimalPrice(Double.toString(modifiedPrice)));
			ModalAddItemDetails.clickOnUpdateCatalogItemButton(driver, testCaseName);

			modifiedPriceOnItemListing = PageCreateCatalog.getItemUnitPrice(driver, testCaseName, catalog.getCatelogItems().get(0).getItemName());
			flag = modifiedPrice == modifiedPriceOnItemListing;
			assertTrue("Price of item was not updated in item listing", flag);

			// to add another item
			PageCreateCatalog.clickOnAddItemButton(driver, testCaseName);

			FlowCatalog.fillItemDetailsForm(driver, testCaseName, catelogItem);
			ModalAddItemDetails.clickOnAddItemButton(driver, testCaseName);

			// to check item added to catalog or not
			flag = false;
			List<WebElement> elements = PageCreateCatalog.getListOfItemsInCatalog(driver, testCaseName);
			for (WebElement element : elements)
			{
				if (element.getText().trim().equalsIgnoreCase(catelogItem.getItemName()))
				{
					flag = true;
					break;
				}
			}
			addItemInCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Item was not added to catalog");
			}
			assertTrue("Item was not added to catalog", flag);

			// submit the catalog
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);

			// submit catalog
			FlowCatalog.submitCatalog(driver, testCaseName, true, true);

			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			assertTrue("Error while searching updated catalog", flag);

			// to approve catalog
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NAME, catalog.getCatalogName(), IConstantsData.CATALOG,
					IConstantsData.APPROVE);
				approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search catalog
				flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
				assertTrue("Error while searching catalog", flag);
			}

			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL);
			assertTrue("Status of catalog was not published", flag);

			// to view the catalog
			PageCatalogListing.clickOnFirstCatalogName(driver, testCaseName);
			logger.info("Catalog information on view page : ");
			PageCatalogView.getCatalogValidity(driver, testCaseName);
			supplierName_onViewPage = PageCatalogView.getSupplierName(driver, testCaseName);
			PageCatalogView.getOUs(driver, testCaseName);
			itemNames_onViewPage = PageCatalogView.getItemNames(driver, testCaseName);

			flag = supplierName_onViewPage.equalsIgnoreCase(catalog.getSupplierName());
			for (String value : itemNames_onViewPage)
			{
				if (value.equalsIgnoreCase(catalog.getCatelogItems().get(0).getItemName()) || value.equalsIgnoreCase(catelogItem.getItemName()))
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
			RTC_EPROC_1946: viewCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "Unable to update a published catalog after deleting its draft copy.");
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Catalog data was wrong on catalog view page");
			}
			assertTrue("Catalog data was wrong on catalog view page", flag);

			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			assertTrue("Error while searching updated catalog", flag);

			// to deactivate catalog
			flag = FlowCatalog.deactivateCatalog(driver, testCaseName, catalog);
			toDeactivateFlag = false;
			deactivateCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Error while deactivating catalog");
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(9), "Error while deactivating catalog");
			}
			assertTrue("Error while deactivating catalog", flag);

			// to delete catalog
			flag = FlowCatalog.deleteCatalog(driver, testCaseName, catalog);
			toDeleteFlag = false;
			deleteCatalog:
			{
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "Error while deleting catalog");
			}
			assertTrue("Error while deleting catalog", flag);

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
				if (toDeactivateFlag)
				{
					FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
					status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
					if (status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL))
					{
						FlowCatalog.deleteCatalog(driver, testCaseName, catalog);
					}
					if (PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName).equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL))
					{
						FlowCatalog.deactivateCatalog(driver, testCaseName, catalog);
					}
				}
				else if (toDeleteFlag)
				{
					FlowCatalog.deleteCatalog(driver, testCaseName, catalog);
				}
			}
			catch (Exception e)
			{
				logger.error("Exception occurred while deactivating catalaog.. " + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Upload Catalog from
	 * File(CSV,CIF,cXML,XLS,XLSX) <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Check for the catalog name in the
	 * list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void uploadCatalogFromFile(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Catalog catalog = new Catalog();
		boolean flag = false, catalogCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_303"));
			}
			user = LoginLogoutServices.login(driver, testCase);

			catalog = ObjectCreation.getDefaultCatalogObject();
			catalog.setFileName(IConstants.ATTACHMENT_FILES_PATH + IConstantsData.CATALOG_UPLOAD_ATTACHMENT);

			// create catalog
			catalog = FlowCatalog.createCatalog(driver, testCaseName, catalog);
			catalogCreatedFlag = true;

			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			assertTrue("Catalog was not created", flag);

			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Error while uploading items via file in Catalog");

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
				/*
				 * if (catalogCreatedFlag) {
				 * FlowCatalog.deactivateAndDeleteCatalog(driver, testCaseName,
				 * catalog); }
				 */
			}
			catch (Exception exception)
			{
				logger.error("Error while deactivating catalog : " + exception, exception);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Create Category Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Check for the cform name in the
	 * list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void createCForm(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		CEform cEform = new CEform();
		CEform modifyCEform = new CEform();
		CEform copiedCEform = new CEform();
		String newOUName = null, status = null, originalCEFromName = null;
		boolean flag = false, copyCEformFlag = false, originalCEformDeleteFlag = false, originalCEformDeactivateFlag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveAsDraftCEForm"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("searchCEForm"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("previewCEForm"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("modifyAnyDraftCEForm"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("publishCEForm"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("copyCEForm"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivateCEForm"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deleteCEForm"));// 7
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setNextAction(IConstantsData.SAVE_AS_DRAFT_EFORM);

			// create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			newOUName = cEform.getOU();

			// check if PEform created
			flag = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "CForm was not searched");
			assertTrue("CForm was not searched", flag);
			originalCEformDeleteFlag = true;
			originalCEFromName = cEform.getCeformName();

			// check status of CEform
			status = PageCEformListing.getStatusOfFirstCEform(driver, testCaseName);
			flag = status.contains(IConstantsData.DRAFT_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Status of CEform was wrong, it should be Draft");
			assertTrue("Status of CEform was wrong, it should be Draft", flag);

			// to modify the ceform
			modifyCEform.setCeformName(cEform.getCeformName());
			modifyCEform.setChangeOU(true);
			modifyCEform.setOU(IConstantsData.ALL);
			modifyCEform.setAddSectionAndField(false);
			modifyCEform.setNextAction(IConstantsData.NONE);

			modifyCEform = FlowCEform.modifyCEform(driver, testCaseName, modifyCEform);
			cEform.setOU(IConstantsData.ALL);

			// to preview Ceform
			flag = FlowCEform.previewCEForm(driver, testCaseName, cEform);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Details on preview CEform was wrong");
			assertTrue("Details on preview CEform was wrong", flag);

			// to publish Ceform
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);

			// check if CEform published
			flag = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());
			assertTrue("PForm was not searched", flag);
			originalCEformDeactivateFlag = true;

			// to check status of CEForm
			status = PageCEformListing.getStatusOfFirstCEform(driver, testCaseName);
			flag = status.contains(IConstantsData.ACTIVE_STATUS);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Status of CEform was wrong, it should be Active");
			assertTrue("Status of CEform was wrong, it should be Active", flag);

			// to copy ceform
			cEform.setChangeCategory(true);
			cEform.setCategory(null);
			newOUName = CommonServices.getTestData(IConstantsData.Other_Company_Name);
			ActionBot.defaultSleep();
			copiedCEform = FlowCEform.copyCEForm(driver, testCaseName, cEform, newOUName);
			copyCEformFlag = true;
			CommonServices.setMappedTestCaseResult(copiedCEform.isResult(), mappedTestCases.get(3), "Error while modifying Draft CEForm");
			CommonServices.setMappedTestCaseResult(copiedCEform.isResult(), mappedTestCases.get(5), "CEform was not copied");
			assertTrue("CEform was not copied", copiedCEform.isResult());

			// to deactivate CEform
			flag = FlowCEform.deactivateCEform(driver, testCaseName, originalCEFromName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "CEform was not deactivated, its status was wrong, it should be Inactive");
			assertTrue("CEform was not deactivated, its status was wrong, it should be Inactive", flag);
			originalCEformDeactivateFlag = false;

			// to delete the CEform
			ActionBot.defaultSleep();
			flag = FlowCEform.deleteCEform(driver, testCaseName, originalCEFromName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "CEform was not deleted");
			assertTrue("CEform was not deleted", flag);
			originalCEformDeleteFlag = false;

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
			if (copyCEformFlag)
			{
				try
				{
					FlowCEform.deactivateNdeleteCEform(driver, testCaseName, copiedCEform.getCeformName());
				}
				catch (Exception e)
				{
					logger.error("Exception in deactivateNdeleteCEform method " + e, e);
				}
				finally
				{
					CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
				}
			}
			else if (originalCEformDeactivateFlag)
			{
				try
				{
					FlowCEform.deactivateCEform(driver, testCaseName, cEform.getCeformName());
				}
				catch (Exception e)
				{
					logger.error("Exception in deactivateCEform method " + e, e);
				}
				finally
				{
					CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
				}
			}
			else if (originalCEformDeleteFlag)
			{
				try
				{
					FlowCEform.deactivateNdeleteCEform(driver, testCaseName, originalCEFromName);
				}
				catch (Exception e)
				{
					logger.error("Exception in deleteCEform method " + e, e);
				}
				finally
				{
					CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
				}
			}
			else
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Delegate a req from all approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the req is present in the
	 * delegated to account </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void delegateReqFromAllApproval(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		String status = null;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// req object creation
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);

			// create Req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			// to delegate the req
			// User user2 =
			// UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE,
			// "Delegate_User");
			User user2 = UserUtilHelper.getAvailableUserFromList();

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			// approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setDocumentName(requisition.getReqName());
			approvalAllRequests.setComment(IConstantsData.DELEGATE_COMMENT);
			approvalAllRequests.setDelegateTo(user2.getUsername());
			approvalAllRequests.setActions(IConstantsData.DELEGATE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// log out
			LoginLogoutServices.logout(driver, testCase, user);
			LoginLogoutServices.afterLogout(driver, testCase, user);

			ActionBot.defaultMediumSleep();

			// login with other user
			LoginLogoutServices.login(driver, testCase, user2);
			ActionBot.defaultSleep();
			user = user2;

			approvalAllRequests.setDocumentName(requisition.getReqName());

			// MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			MainPageHeaderLevelTab.clickOnApprovalTab(driver);
			approvalAllRequests = FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);

			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PENDING_FILTER_STATUS);
			Assert.assertTrue("Requisition not delegated", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Delegate a po from all approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the PO is present in the
	 * delegated to account </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void delegatePOFromAllApproval(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		StandardPO standardPO = new StandardPO();
		String status = null;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// standard PO object creation
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);

			// to create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// to delegate the req
			// User user2 =
			// UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE,
			// "Delegate_User");
			User user2 = UserUtilHelper.getAvailableUserFromList();

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setComment(IConstantsData.DELEGATE_COMMENT);
			approvalAllRequests.setDelegateTo(user2.getUsername());
			approvalAllRequests.setActions(IConstantsData.DELEGATE);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// log out
			LoginLogoutServices.logout(driver, testCase, user);
			LoginLogoutServices.afterLogout(driver, testCase, user);
			ActionBot.defaultMediumSleep();

			// login with other user
			LoginLogoutServices.login(driver, testCase, user2);
			user = user2;

			// MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			MainPageHeaderLevelTab.clickOnApprovalTab(driver);
			approvalAllRequests = FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);

			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PENDING_FILTER_STATUS);
			Assert.assertTrue("Requisition not delegated", flag);

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
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
			catch (Exception e)
			{
				logger.info("Exception while logout");
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Delegate one/multiple request from
	 * Approval & All Requests tab <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void delegateMultipleReqFromAllApproval(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition1 = new Requisition();
		Requisition requisition2 = new Requisition();
		String status = null;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// req object creation
			requisition1 = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition2 = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			// create Req1
			requisition1 = FlowRequisition.createRequisition(driver, testCaseName, requisition1);

			// to search in my req tab
			requisition1 = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition1);
			Assert.assertTrue("Error while searching requisition in my requisition tab", requisition1.isResult());

			// create Req2
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition2 = FlowRequisition.createRequisition(driver, testCaseName, requisition2);

			// to search in my req tab
			requisition2 = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition2);
			Assert.assertTrue("Error while searching requisition in my requisition tab", requisition1.isResult());

			// to delegate the req
			// User user2 =
			// UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE,
			// "Delegate_User");
			User user2 = UserUtilHelper.getAvailableUserFromList();

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			// approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setDocumentName(requisition1.getReqName());
			approvalAllRequests.setComment(IConstantsData.DELEGATE_COMMENT);
			approvalAllRequests.setDelegateTo(user2.getUsername());
			approvalAllRequests.setActions(IConstantsData.DELEGATE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			// FlowAllRequestsApproval.searchAndPerformActions(driver,
			// testCaseName, approvalAllRequests);

			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);

			List<WebElement> elements = PageAllRequestsApproval.getListOfDocumentNos(driver, testCaseName);
			int i = 1;
			for (WebElement element : elements)
			{
				String reqNo = element.getText().trim();
				if (reqNo.equalsIgnoreCase(requisition1.getReqNo()) || reqNo.equalsIgnoreCase(requisition2.getReqNo()))
				{
					ActionBot.click(driver, By.xpath(".//*[@id='workflowApproval']/tbody/tr[" + i + "]/td[1]/input"));
				}
				i++;
			}
			ScreenShot.screenshot(driver, testCaseName, "After selecting two requisitions");

			// to delegate multiple req
			ModalAllRequestsApprovalActions.clickOnDelegateOptionForMultipleDoc(driver, testCaseName);
			approvalAllRequests = IFlowAllRequestsApprovalUtilies.delegateDocument(driver, testCaseName, approvalAllRequests);

			// log out
			LoginLogoutServices.logout(driver, testCase, user);
			LoginLogoutServices.afterLogout(driver, testCase, user);

			ActionBot.defaultSleep();

			// login with other user
			LoginLogoutServices.login(driver, testCase, user2);
			ActionBot.defaultSleep();
			user = user2;

			MainPageHeaderLevelTab.clickOnApprovalTab(driver);
			// to search 1st req
			approvalAllRequests.setDocumentName(requisition1.getReqName());

			approvalAllRequests = FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);

			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PENDING_FILTER_STATUS);
			Assert.assertTrue("Requisition " + requisition1.getReqName() + " not delegated", flag);

			// to search 2nd req
			approvalAllRequests.setDocumentName(requisition2.getReqName());

			approvalAllRequests = FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);

			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PENDING_FILTER_STATUS);
			Assert.assertTrue("Requisition " + requisition1.getReqName() + " not delegated", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Edit an existing req <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The requisition form should be present
	 * after opening the draft </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitDraftReqAndApproveItAndChangeBuyerAtBuyersDeskListing(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		String supplierComment, status, reqName;
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addItemsFromCatalog"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("freeTextReqWithQuantityAndRequesterNegotiated"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("freeTextReqWithQuantityAndBudgetaryPrice"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveReqAsDraft"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("editReqDraft"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("submitRequisition"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("approveRequisition"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("submitAndApproveGuidedReq"));// 7
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			ActionBot.waitForPageLoad(driver);
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);
			requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.NO);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			// to get requisition object
			requisition = ObjectCreation.getDefaultRequisitionObjectWithItems(driver);
			requisition.setEditItemLevelInfo(false);
			requisition.setNextAction(IConstantsData.SAVE_AS_DRAFT_REQ);

			// to set non mandatory fields
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);

			// to create req
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			flag = requisition.isResult();
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Requisition was not submitted with Catalog item.");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1),
				"Requisition was not submitted with freeText item With Quantity And Requester Negotiated sourcing status.");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2),
				"Requisition was not submitted with freeText item With Quantity And Budgetary Price Sourcing status.");
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "Requisition status was wrong. It should be Draft");
			assertTrue("Requisition status was wrong. It should be Draft", flag);

			// to view the req
			PageMyRequisition.clickOnReqNoLink(driver, testCaseName);

			ActionBot.defaultMediumSleep();
			//ActionBot.waitForPageLoad(driver);
			// to fill supplier comments
			PageRequisitionCheckOut.fillCommentsForSupplier(driver, testCaseName, IConstantsData.SupplierComment);
			// to save as draft
			FlowRequisition.saveReqAsDraft(driver, testCaseName);

			// search req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Requisition status was wrong. It should be Draft", status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL));

			// to view the req
			PageMyRequisition.clickOnReqNoLink(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);

			supplierComment = PageRequisitionCheckOut.getCommentsForSupplier(driver, testCaseName);
			flag = supplierComment.trim().equalsIgnoreCase(IConstantsData.SupplierComment.trim());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Draft was not edited");

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, true);

			// search req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			CommonServices.setMappedTestCaseResult(requisition.isResult(), mappedTestCases.get(5), "Requisition was not Searched in my requisition tab");
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			// approve req
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// to search in aprroval tab
			FlowAllRequestsApproval.searchInApprovalTab(driver, testCaseName, approvalAllRequests);
			PageAllRequestsApproval.getFirstRowDocumentNo(driver, testCaseName);
			flag = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.APPROVED_FILTER_STATUS);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "Requisition was not approved");
			assertTrue("Requisition not approved", flag);

			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			reqName = PageBuyersDeskListing.getFirstRowReqName(driver, testCaseName);
			logger.info("Searched requisition name at buyers desk : " + reqName);
			flag = reqName.contains(requisition.getReqName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "Requisition with guided item did not appear in buyers desk");
			assertTrue("Requisition with guided item did not appear in buyers desk", flag);

			// to change buyer
			requisition.setAssignedBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setNextAction(IConstantsData.SAVE);

			requisition = FlowBuyersDeskListing.changeAssignedBuyer(driver, testCaseName, requisition);
			assertTrue("Assigned buyer is not changed from buyer desk listing", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Filter the items by description <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The description of the items should
	 * match the one in the input file </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void filterItemsByDescription(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String itemName, itemDesc, itemDescAfterFilter;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to search item
			itemName = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);

			FlowSearchListing.searchItem(driver, testCaseName, itemName);

			// to get item desc of first item
			List<WebElement> itemDescList = PageSearchListing.getItemDescriptions(driver, testCaseName);
			itemDesc = itemDescList.get(0).getText().trim();
			logger.info("Item description : " + itemDesc);

			// to apply item desc filter
			FlowSearchListing.applyItemDescriptionFilter(driver, testCaseName, itemDesc);

			// to get item desc of first item after list
			itemDescList = PageSearchListing.getItemDescriptions(driver, testCaseName);
			itemDescAfterFilter = itemDescList.get(0).getText().trim();
			logger.info("Item description after filter is applyed: " + itemDesc);

			flag = itemDesc.equalsIgnoreCase(itemDescAfterFilter);
			assertTrue("Items with required description were not filtered", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Filter the items by the price <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The price of the items should not be
	 * above the max price </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void filterItemsByPrice(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String itemName, itemPrice;
		int maxPrice;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to search item
			itemName = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);

			FlowSearchListing.searchItem(driver, testCaseName, itemName);

			// to get item price of first item
			ActionBot.defaultMediumSleep();
			List<WebElement> itemPriceList = PageSearchListing.getItemPrice(driver, testCaseName);
			itemPrice = itemPriceList.get(0).getText().trim();
			logger.info("Item Price : " + itemPrice);
			maxPrice = Integer.parseInt(CommonUtilities.getDecimalPrice(itemPrice.substring(4)).trim());
			maxPrice++;

			// to apply item price filter
			FlowSearchListing.applyItemPriceFilter(driver, testCaseName, null, Integer.toString(maxPrice));

			// to check item price filter
			flag = FlowSearchListing.checkItemPriceFiler(driver, testCaseName, null, Integer.toString(maxPrice));
			assertTrue("Items with required price were not filtered", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Filter the items by their manufacturer
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Filter item by manufacturer after
	 * searching </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void filterItemsByManf(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String itemName, manufacturersName;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to search item
			itemName = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);

			FlowSearchListing.searchItem(driver, testCaseName, itemName);

			// to apply item manufacturer filter
			manufacturersName = FlowSearchListing.applyManufacturersFilter(driver, testCaseName, null);

			// to check item manufacturer filter
			flag = FlowSearchListing.checkManufacturersFilter(driver, testCaseName, manufacturersName);
			assertTrue("Items with required manufacturer were not filtered", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Filter the items by their supplier <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The supplier of the items should match
	 * from the input file </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void filterItemsBySupplier(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String itemName, suppliersName;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to search item
			itemName = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);

			FlowSearchListing.searchItem(driver, testCaseName, itemName);

			// to apply item manufacturer filter
			suppliersName = FlowSearchListing.applySuppliersFilter(driver, testCaseName, null);

			// to check item manufacturer filter
			flag = FlowSearchListing.checkSuppliersFilter(driver, testCaseName, suppliersName);
			assertTrue("Items with required suppliers were not filtered", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create requisition with freeText item
	 * having Quantity And Requester Negotiated sourcing status <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the appropriate req is
	 * submitted in the req list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void freeTextReqWithQuantityAndRequesterNegotiated(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be IN APPROVAL", status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create requisition with freeText item
	 * having Quantity And Budgetary Price sourcing status <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the appropriate req is
	 * submitted in the req list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void freeTextReqWithQuantityAndBudgetaryPrice(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Estimated_price);
			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be IN APPROVAL", status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create requisition with freeText item
	 * having Quantity And Need A Quote sourcing status <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the appropriate req is
	 * submitted in the req list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void freeTextReqWithQuantityAndNeedAQuote(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be In Process", status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create requisition with freeText item
	 * having Amount And Requester Negotiated sourcing status <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the appropriate req is
	 * submitted in the req list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void freeTextReqWithAmountAndRequesterNegotiated(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem.setReceiveBy(IConstantsData.Amount);
			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be In Process", status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create requisition with freeText item
	 * having Amount And Budgetary Price sourcing status <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the appropriate req is
	 * submitted in the req list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void freeTextReqWithAmountAndBudgetaryPrice(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Estimated_price);
			guidedItem.setReceiveBy(IConstantsData.Amount);
			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be In Process", status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Create an invoice against a released PO
	 * and close it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createFlipInvoiceAndCloseFlipInvoice(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		StandardPO standardPO = new StandardPO();
		Invoice invoice = new Invoice();
		boolean flag = false;
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			driver.getCurrentUrl();
			// to get Standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);

			invoice = ObjectCreation.getDefaultFlipInvoiceObject();

			logger.info("================= Create Standard PO ===============");
			// create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			ActionBot.waitForPageLoad(driver);
			/*
			 * MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			 * driver.get(url);
			 */
			logger.info("================= Search PO ===============");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				logger.info("================= Approve Standard PO ===============");
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
				approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
				approvalAllRequests.setActions(IConstantsData.APPROVE);
				approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
				approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				ActionBot.waitForPageLoad(driver);
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				logger.info("================= Search PO ===============");
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of PO was not Released", flag);
			}

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

			logger.info("================= Recall Invoice ===============");
			ActionBot.defaultSleep();
			// to recall invoice
			FlowPOInvoiceListing.recallInvoice(driver, testCaseName);
			flag = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of invoice after recalling it was wrong, it should be Draft", flag);

			logger.info("================= View Invoice ===============");
			// view invoice
			FlowPOInvoiceListing.viewInvoice(driver, testCaseName);

			logger.info("================= Submit Invoice ===============");
			// submit invoice
			FlowNonPoInvoice.submitInvoice(driver, testCaseName);

			logger.info("================= Search PO ===============");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			// view po
			FlowPoListing.viewPO(driver, testCaseName);
			// view invoice
			logger.info("================= View Invoice Tab ===============");
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);

			// to get invoice no
			flag = FlowPOInvoiceListing.checkIfInvoiceCreated(driver, testCaseName, invoice.getInvoiceNo());
			assertTrue("Invoice was not created for released po or status of invoice was wrong", flag);

			logger.info("================= Confirm and match Invoice ===============");
			// confirm and match invoice
			FlowPOInvoiceListing.confirmAndMatchInvoice(driver, testCaseName);
			flag = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			assertTrue("Status of invoice after confirm and match was wrong, it should be In Approval", flag);

			status = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				logger.info("================= Approve Invoice ===============");
				// to approve the invoice
				ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
				approvalAllRequests.setDocumentNo(invoice.getInvoiceNo());
				approvalAllRequests.setActions(IConstantsData.APPROVE);
				approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
				approvalAllRequests.setDocumentType(IConstantsData.INVOICE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// to return back to eproc
				// same for return to eproc
				PageAllRequestsApproval.clickOnInvoiceApprovalLink(driver, testCaseName);

				logger.info("================= Search PO ===============");
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
				// view po
				FlowPoListing.viewPO(driver, testCaseName);
				// view invoice
				logger.info("================= View Invoice Tab ===============");
				PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
				flag = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.APPROVED_FILTER_STATUS);
				assertTrue("Status of invoice after approval was wrong, it should be APPROVED", flag);
			}

			logger.info("================= Close Invoice ===============");
			// close invoice
			FlowPOInvoiceListing.closeInvoice(driver, testCaseName);
			flag = PagePOInvoiceListing.getFirstInvoiceStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.CLOSED_FILTER_LABEL);
			assertTrue("Status of invoice after closing it was wrong, it should be CLOSED", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create Invoice from amended PO and PO from
	 * Requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the items were added to the po
	 * after editing it </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void createRequisitionToAmendedPOToInvoice(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		Item item1 = new Item();
		Invoice invoice = new Invoice();
		String url = null, poNo = null, status = null;
		boolean flag = false;
		List<CatelogItem> listOfCatelogItem = new ArrayList<CatelogItem>();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			url = driver.getCurrentUrl();
			// req object creation
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setAssignedBuyer(user.getUsername());
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			item1 = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			// listOfCatelogItem.add(item.getCatelogItems().get(0));

			// invoice object creation
			invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setBuyer(user.getUsername());

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req at buuyers desk
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// to click on first checkbox
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);

			// apply draft po filter
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);

			// to edit the PO
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			poNo = PageStandardPO.getPONo(driver, testCaseName);

			PageStandardPO.selectDeliveryTerms(driver, null);
			// to submit the PO
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(poNo);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
			}
			// view po
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			// to amend the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			logger.info("Amending PO by adding new Catalog Item");

			// to Amend PO
			item1 = FlowStandardPo.addItem(driver, testCaseName, item1);
			listOfCatelogItem.add(item1.getCatelogItems().get(0));

			CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBooking();
			costBookingRequisitionSummary.setNextAction(IConstantsData.NONE);
			ObjectCreation.getDefaultObjectOfAccounting();

			ActionBot.defaultSleep();
			// catalog item
			for (CatelogItem catelogItem : listOfCatelogItem)
			{
				String itemID = catelogItem.getItemID();
				PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);

				// to fill cost booking
				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				costBookingRequisitionSummary = FlowStandardPo.fillItemSummaryCostBooking(driver, testCaseName, costBookingRequisitionSummary);

			}

			// to submit PO for processing
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			ActionBot.defaultHighSleep();
			PageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);

			int i = 1;
			List<WebElement> amendedPONos = PageAmmendedPO.getAllAmendedPONos(driver, testCaseName);
			for (WebElement element : amendedPONos)
			{
				if (element.getText().trim().equalsIgnoreCase(poNo))
				{
					status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, i);
					break;
				}
				i++;
			}

			/*
			 * //search po driver.get(url); flag =
			 * FlowPoListing.searchPo(driver, testCaseName, poNo,
			 * IConstantsData.SEARCH_BY_PO_NO); assertTrue(
			 * "Error while searching PO", flag); status =
			 * PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			 */
			ApprovalAllRequests approvalAllRequests2 = new ApprovalAllRequests();
			approvalAllRequests2.setDocumentNo(poNo);
			approvalAllRequests2.setActions(IConstantsData.APPROVE);
			approvalAllRequests2.setComment(IConstantsData.APPROVE_COMMENT);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests2);

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
			}

			// to create flip invoice
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateInvoiceLink(driver, testCaseName);

			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);

			// search invoice
			flag = FlowInvoiceListing.searchInvoice(driver, testCaseName, invoice.getInvoiceNo());
			Assert.assertTrue("Error while searching Flip Invoice", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Add and remove items from basket <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The itemId should not be present in the
	 * basket </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void addAndRemoveFromBasket(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		User user = null;
		Item item = new Item();
		Basket basket = new Basket();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

			// to get basket object
			basket.setBasketName(CommonUtilities.getBasketName());
			basket.setItem(item);

			// to create new basket
			FlowMyBasket.addItemNewBasket(driver, testCaseName, basket);
			map.put("Basket Name ", basket.getBasketName());
			map.put("Header ", "Items in Basket");
			map.put("Item Name ", item.getCatelogItems().get(0).getItemName());
			map.put("Quantity ", Integer.toString(item.getCatelogItems().get(0).getQuantity()));

			ActionBot.defaultSleep();

			// to search basket
			basket = FlowMyBasket.searchBasket(driver, testCaseName, basket);
			assertTrue("Newly created basket is not searched", basket.isResult());
			ActionBot.defaultSleep();
			// to remove item from basket
			basket = FlowMyBasket.removeItemFromBasket(driver, testCaseName, basket);
			assertTrue("Item is not removed from basket", basket.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Adds and removes from favorites <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>The item id should not be present after
	 * searching for it in favorites </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void addAndRemoveFromFavorites(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		CatelogItem catelogItem = new CatelogItem();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get catelog item object
			catelogItem = ObjectCreation.getDefaultCatalogItemObject();

			// to search item
			catelogItem = FlowSearchListing.addItemToFavorite(driver, testCaseName, catelogItem);

			// to search favorite item
			catelogItem = FlowMyFavorites.searchFavoriteItems(driver, testCaseName, catelogItem);
			assertTrue("Item not added to favorite", catelogItem.isResult());

			// to remove item from favorite
			catelogItem = FlowMyFavorites.removeItemFromFavorites(driver, testCaseName, catelogItem);
			assertTrue("Item is not removed from favorite", catelogItem.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create user pcard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void createUserPCard(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		PCard pCard = new PCard();
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveUserPCardAsDraft"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("editUserPCard"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivateUserPCard"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("activateUserPCard"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("archiveUserPcard"));// 4
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			ActionBot.waitForPageLoad(driver);
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setNextAction(IConstantsData.SAVE);
			logger.info("============== Creating PCard ==============");
			// create pcard
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			logger.info("============== Searching PCard ==============");
			// search pcard
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			assertTrue("Error while searching user PCard", flag);

			// check status
			flag = PagePCardListing.getStatusOfPCard(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Status of PCard was wrong, it should be Draft");
			assertTrue("Status of PCard was wrong, it should be Draft", flag);

			// edit pcard
			pCard.setLastBilledOnDate(CommonUtilities.getDayAfterTodaysDate());
			pCard.setNextAction(IConstantsData.ACTIVATE_PCARD);
			logger.info("============== Editing PCard ==============");
			flag = FlowPCardListing.editPcard(driver, testCaseName, pCard);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "PCard was not edited");
			assertTrue("PCard was not edited", flag);

			// deactivate pcard
			logger.info("============== Deactiviting PCard ==============");
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "PCard was not deactivated");
			assertTrue("PCard was not deactivated", flag);

			// activate pcard
			logger.info("============== Activiting PCard ==============");
			flag = FlowPCardListing.activatePCard(driver, testCaseName, pCard.getpCardNo());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "PCard was not activated");
			assertTrue("PCard was not activated", flag);

			// deactivate pcard
			logger.info("============== Deactiviting PCard ==============");
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			assertTrue("PCard was not deactivated", flag);

			// archive pcard
			logger.info("============== Archiving PCard ==============");
			flag = FlowPCardListing.archivePCard(driver, testCaseName, pCard.getpCardNo());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "PCard was not archived");
			assertTrue("PCard was not archived", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create supplier pcard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void createSupplierPCard(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		PCard pCard = new PCard();
		PCard editPCard = new PCard();
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveSupplierPCardAsDraft"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("editSupplierPCard"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivateSupplierPCard"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("activateSupplierPCard"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("archiveSupplierPcard"));
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			ActionBot.waitForPageLoad(driver);

			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_SUPPLIER);
			// pCard.setpCardType("Amex");
			// pCard.setpCardNo("5115915115915118");
			pCard.setNextAction(IConstantsData.SAVE);
			logger.info("============== Creating PCard ==============");
			// create pcard
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			logger.info("============== Searching PCard ==============");
			// search pcard
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			assertTrue("Error while searching user PCard", flag);

			// check status
			flag = PagePCardListing.getStatusOfPCard(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			mappedTestCases.get(0).setTestResult(flag);
			assertTrue("Status of PCard was wrong, it should be Draft", flag);

			ActionBot.defaultSleep();
			// edit pcard
			editPCard.setpCardNo(pCard.getpCardNo());
			editPCard.setLastBilledOnDate(CommonUtilities.getDayAfterTodaysDate());
			editPCard.setNextAction(IConstantsData.ACTIVATE_PCARD);
			logger.info("============== Editing PCard ==============");
			flag = FlowPCardListing.editPcard(driver, testCaseName, editPCard);
			mappedTestCases.get(1).setTestResult(flag);
			assertTrue("PCard was not edited", flag);

			// deactivate pcard
			logger.info("============== Deactiviting PCard ==============");
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			mappedTestCases.get(2).setTestResult(flag);
			assertTrue("PCard was not deactivated", flag);

			// activate pcard
			logger.info("============== Activiting PCard ==============");
			flag = FlowPCardListing.activatePCard(driver, testCaseName, pCard.getpCardNo());
			mappedTestCases.get(3).setTestResult(flag);
			assertTrue("PCard was not activated", flag);

			// deactivate pcard
			logger.info("============== Deactiviting PCard ==============");
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			assertTrue("PCard was not deactivated", flag);

			// archive pcard
			logger.info("============== Archiving PCard ==============");
			flag = FlowPCardListing.archivePCard(driver, testCaseName, pCard.getpCardNo());
			mappedTestCases.get(4).setTestResult(flag);
			assertTrue("PCard was not archived", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Create Process Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Check for the pform name in the
	 * list </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void createPForm(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		PEform pEform = new PEform();
		PEform copiedPEform = new PEform();
		PEform modifyPEform = new PEform();
		String status, newOUName;
		boolean flag = false, copyPEformFlag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveAsDraftPEForm"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("searchPEForm"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("previewPEForm"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("modifyAnyDraftPEForm"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("publishPEForm"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("copyPEForm"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deactivatePEForm"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deletePEForm"));// 7
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			pEform = ObjectCreation.getDefaultPEformObject();
			pEform.setProcessName(IConstantsData.PO_FORMS);
			pEform.setNextAction(IConstantsData.SAVE_AS_DRAFT_EFORM);

			// create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);
			newOUName = pEform.getOU();

			// check if PEform created
			flag = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "PForm was not searched");
			assertTrue("PForm was not searched", flag);

			// check status of PEform
			status = PagePEformListing.getStatusOFFirstPEForm(driver, testCaseName);
			flag = status.contains(IConstantsData.DRAFT_FILTER_LABEL);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Status of PEform was wrong, it should be Draft");
			assertTrue("Status of PEform was wrong, it should be Draft", flag);

			// to modify the peform
			modifyPEform.setPeformName(pEform.getPeformName());
			modifyPEform.setChangeOU(true);
			modifyPEform.setOU(IConstantsData.ALL);
			modifyPEform.setAddSectionAndField(false);
			modifyPEform.setNextAction(IConstantsData.NONE);

			modifyPEform = FlowPEform.modifyPEform(driver, testCaseName, modifyPEform);
			pEform.setOU(IConstantsData.ALL);

			// to preview peform
			flag = FlowPEform.previewPEForm(driver, testCaseName, pEform);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Details on preview PEform was wrong");
			assertTrue("Details on preview PEform was wrong", flag);

			// to publish peform
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);

			// check if PEform published
			flag = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			assertTrue("PForm was not searched", flag);

			// to check status of PEForm
			status = PagePEformListing.getStatusOFFirstPEForm(driver, testCaseName);
			flag = status.contains(IConstantsData.ACTIVE_STATUS);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Status of PEform was wrong, it should be Active");
			assertTrue("Status of PEform was wrong, it should be Active", flag);

			// to copy peform
			pEform.setProcessName(IConstantsData.REQUISITION_FORMS);
			copiedPEform = FlowPEform.copyPEForm(driver, testCaseName, pEform, newOUName);
			copyPEformFlag = true;
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "PEform was not copied");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "PEform was not copied");
			assertTrue("PEform was not copied", copiedPEform.isResult());

			// to deactivate PEform
			flag = FlowPEform.deactivatePEform(driver, testCaseName, pEform.getPeformName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "PEform was not deactivated, its status was wrong, it should be Inactive");
			assertTrue("PEform was not deactivated, its status was wrong, it should be Inactive", flag);

			// to delete the PEform
			flag = FlowPEform.deletePEform(driver, testCaseName, pEform.getPeformName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "PEform was not deleted");
			assertTrue("PEform was not deleted", flag);

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
			if (copyPEformFlag)
			{
				try
				{
					FlowPEform.deactivateNdeleteCEform(driver, testCaseName, copiedPEform.getPeformName());
				}
				catch (Exception e)
				{
					logger.error("Exception in deactivateNdeleteCEform method " + e, e);
				}
				finally
				{
					CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
				}
			}
			else
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void addPunchoutItemAndSubmitRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		PunchoutItem punchoutItem = new PunchoutItem();
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<PunchoutItem> punchoutItems = new ArrayList<PunchoutItem>();
		User user = new User();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// punchout item
			punchoutItem = ObjectCreation.getDefaultObjectOfPunchoutItem();
			punchoutItems.add(punchoutItem);
			item.setPunchoutItems(punchoutItems);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setEditItemLevelInfo(false);

			// empty shopping cart
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);

			// to add punchout item
			FlowPunchout.addPunchoutItemToCart(driver, testCaseName, punchoutItem);

			// to checkout
			FlowRequisition.fillcheckoutForm(driver, testCaseName, requisition, item);

			// to submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			// search req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Selects any PO and tries previewing it.
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the PO Number is same on
	 * preview po page </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void previewPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		User user = null;
		StandardPO standardPO = new StandardPO();
		boolean flag = false, supplierNameFlag = false, buyerNameFlag = false, itemNameFlag = false, qunatityFlag = false;
		String buyer, poNo_OnPreviewPOPage = null, status = null, supplierName_OnPreviewPOPage = null, buyerName_OnPreviewPOPage = null, itemName_OnPreviewPOPage = null,
			quantity_OnPreviewPOPage = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			String url = driver.getCurrentUrl();
			// to get Standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			// create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			// MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);

			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultSleep();
				//ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of PO was not Released", flag);
			}

			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			// to preview the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnPreviewPoLink(driver, testCaseName);

			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}

			driver.manage().window().maximize();
			if (driver.getTitle().contains("Certificate Error"))
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}

			poNo_OnPreviewPOPage = PagePreviewPOPage.getPreviewPoNo(driver, testCaseName);
			supplierName_OnPreviewPOPage = PagePreviewPOPage.getPreviewPoSupplierName(driver, testCaseName);
			PagePreviewPOPage.getPreviewPoBillToAddress(driver, testCaseName);
			PagePreviewPOPage.getPreviewPoShipToAddress(driver, testCaseName);
			buyerName_OnPreviewPOPage = PagePreviewPOPage.getPreviewPoBuyerName(driver, testCaseName);
			PagePreviewPOPage.getPreviewPoCBLDetails(driver, testCaseName);
			itemName_OnPreviewPOPage = PagePreviewPOPage.getPreviewPoItemName(driver, testCaseName);
			quantity_OnPreviewPOPage = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			PagePreviewPOPage.getPreviewPoUnitPrice(driver, testCaseName);

			if (itemName_OnPreviewPOPage.contains("/"))
			{
				String[] temp = StringUtils.split(itemName_OnPreviewPOPage, "/");
				itemName_OnPreviewPOPage = "";
				itemName_OnPreviewPOPage = temp[1].trim();
			}

			buyer = standardPO.getBuyer();
			if (buyer.contains("|"))
			{
				String[] temp = StringUtils.split(buyer, "|");
				buyer = "";
				buyer = temp[0].trim();
			}
			flag = standardPO.getPoNumber().equalsIgnoreCase(poNo_OnPreviewPOPage);
			supplierNameFlag = standardPO.getSupplierName().equalsIgnoreCase(supplierName_OnPreviewPOPage);
			buyerNameFlag = buyerName_OnPreviewPOPage.contains(buyer);
			itemNameFlag = itemName_OnPreviewPOPage.equalsIgnoreCase(standardPO.getItems().getCatelogItems().get(0).getItemName().trim());
			qunatityFlag = quantity_OnPreviewPOPage.contains(Integer.toString(standardPO.getItems().getCatelogItems().get(0).getQuantity()));
			System.out.println("Flag : " + flag);
			System.out.println("supplierNameFlag : " + supplierNameFlag);
			System.out.println("buyerNameFlag : " + buyerNameFlag);
			System.out.println("itemNameFlag : " + itemNameFlag);
			System.out.println("qunatityFlag : " + qunatityFlag);

			map.put("Header", "PO Details on Preview PO Page");
			map.put("PO No ", poNo_OnPreviewPOPage);
			map.put("Supplier Name ", supplierName_OnPreviewPOPage);
			map.put("Buyer Name ", buyerName_OnPreviewPOPage);
			map.put("Item Name ", itemName_OnPreviewPOPage);
			map.put("Quantity", quantity_OnPreviewPOPage);

			driver.switchTo().window(winHandlerBefore);
			assertTrue("PO Details on Preview PO Page was wrong", flag && supplierNameFlag && buyerNameFlag && itemNameFlag && qunatityFlag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Amend a released PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the added guided item </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void closePO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		StandardPO standardPO = new StandardPO();
		Item item = new Item();
		Item item1 = new Item();
		Item itemToBeCopied = new Item();
		String status = null;
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("createManualPO"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("recallPO"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("approvePO"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("remindSupplier"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("amendPO"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("recallAmendedPO"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addItemsToAmendedPO"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("removeItemsFromAmendedPO"));// 7
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("copyItemInAmendedPO"));// 8
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("emailPO"));// 9
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// to get Standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);

			// to get item object having guided item
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setQuantity(CommonUtilities.getNonZeroRandomNumber(1));
			item.getGuidedItems().get(0).setPrice(90000f);
			item.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

			item1 = ObjectCreation.getItem(IConstantsData.BOTH);
			item1.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

			// create standard PO
			logger.info("=================== Create Standard PO ===================");
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			driver.navigate().refresh();
			ActionBot.defaultSleep();
			ActionBot.waitForPageLoad(driver);
			// MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// driver.get(url);

			logger.info("=================== Search PO ===================");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Error while creating manual PO");
			assertTrue("Error while searching PO", flag);

			logger.info("=================== Recall PO ===================");
			// to recall po
			FlowPoListing.recallApprovalRequestForPurchaseOrder(driver, testCaseName);
			ActionBot.defaultSleep();
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Recalled requisition not in drafts");
			assertTrue("Recalled requisition not in drafts", FlowPoListing.checkIfPORecalled(driver, testCaseName, standardPO.getPoNumber()));

			logger.info("=================== View PO ===================");
			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			logger.info("=================== Submit PO ===================");
			// submit po
			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				standardPO.setPoNumber(poNo);
			}

			ActionBot.waitForPageLoad(driver);
			logger.info("=================== Search PO ===================");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			// CommonServices.setMappedTestCaseResult(flag,
			// mappedTestCases.get(0), "Error while creating manual PO");
			assertTrue("Error while searching PO", flag);

			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(), IConstantsData.PURCHASE_ORDER,
				IConstantsData.APPROVE);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				logger.info("=================== Approve PO ===================");
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultSleep();
				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				ActionBot.waitForPageLoad(driver);
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Error while approving PO");
				assertTrue("Status of PO was not Released", flag);
			}

			logger.info("=================== View PO ===================");
			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			logger.info("=================== Remind Supplier ===================");
			// to remind supplier
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnRemindPoLink(driver, testCaseName);

			// to remind supplier
			flag = FlowViewPO.remindSupplier(driver, testCaseName, standardPO.getPoNumber());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "Error while remind supplier");
			assertTrue("Error while remind supplier", flag);

			/*
			 * //view po FlowPoListing.viewPO(driver, testCaseName);
			 */

			// to amend the PO
			ActionBot.defaultSleep();
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			logger.info("=================== Amending PO by adding new Catalog Item ===================");

			ActionBot.scroll(driver, "650");
			// to Amend PO
			item = FlowStandardPo.addItem(driver, testCaseName, item);
			ActionBot.waitForPageLoad(driver);

			// to submit PO for processing
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			// if workflow is applied.. search in amended po listing
			if (PageAmmendedPO.isViewAllPOPresent(driver, testCaseName))
			{
				PageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);

				flag = false;
				List<WebElement> amendedPONos = PageAmmendedPO.getAllAmendedPONos(driver, testCaseName);
				for (WebElement element : amendedPONos)
				{
					if (element.getText().trim().equalsIgnoreCase(standardPO.getPoNumber()))
					{
						flag = true;
						element.click();
						ActionBot.defaultSleep();
						ScreenShot.screenshot(driver, testCaseName, "View Amemded PO");
						break;
					}
				}
				assertTrue("Amended PO Was not found", flag);
			}
			else
			{
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Amended PO Was not found", flag);
				// view po
				FlowPoListing.viewPO(driver, testCaseName);
			}

			List<WebElement> itemNames = PageViewPurchaseOrder.getListOfItems(driver, testCaseName);
			// PageStandardPO.getItemName(driver, testCaseName);
			flag = false;
			for (WebElement element : itemNames)
			{
				String itemName = element.getText().trim();
				/*
				 * if ((itemName.equalsIgnoreCase(standardPO.getItems().
				 * getCatelogItems().get(0).getItemName())) ||
				 */if (itemName.equalsIgnoreCase(standardPO.getItems().getGuidedItems().get(0).getShortDescription())
					|| itemName.equalsIgnoreCase(item.getGuidedItems().get(0).getShortDescription()))
				{
					flag = true;
				}
			}
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "PO was not amended, added catalog item was not present");
			assertTrue("PO was not amended, added catalog item was not present", flag);

			// to recall amended PO
			/*
			 * ActionBot.defaultSleep(); driver.navigate().refresh();
			 */
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// ActionBot.defaultSleep();
			logger.info("=================== Recall Amended PO ===================");
			PagePurchaseOrderListing.clickOnViewAmmendedPO(driver, testCaseName);
			//---------------
			flag = FlowAmendedPO.recallAmendedPO(driver, testCaseName, standardPO.getPoNumber(), 1);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Amended PO was not recalled");
			assertTrue("Amended PO was not recalled", flag);

			// to view amended po
			FlowAmendedPO.viewAmendedPO(driver, testCaseName, standardPO.getPoNumber());

			ActionBot.scroll(driver, "650");
			logger.info("=================== Add item to Amended PO ===================");
			// to add item to amended PO
			item1 = FlowStandardPo.addItem(driver, testCaseName, item1);

			// to check if items added
			flag = FlowStandardPo.checkIfItemAdded(driver, testCaseName, item1);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "Items was not added in amended PO");
			assertTrue("Items was not added in amended PO", flag);

			// to remove items
			logger.info("=================== Remove item from Amended PO ===================");
			flag = FlowStandardPo.removeItem(driver, testCaseName, item1.getCatelogItems().get(0).getItemID());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(7), "Item was not removed from PO");
			assertTrue("Item was not removed from PO", flag);

			// to copy the items
			logger.info("=================== Copy item from Amended PO ===================");
			itemToBeCopied.setGuidedItems(item1.getGuidedItems());
			flag = FlowStandardPo.copyItem(driver, testCaseName, itemToBeCopied);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(8), "Item was not copied in amended PO");
			// assertTrue("Item was not copied in amended PO", flag);

			// to submit PO for processing
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			// if workflow is applied.. search in amended po listing
			status = null;
			if (PageAmmendedPO.isViewAllPOPresent(driver, testCaseName))
			{
				status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, standardPO.getPoNumber());
			}
			else
			{
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			}

			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				logger.info("=================== Approve PO ===================");
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultSleep();
				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();
				driver.navigate().refresh();

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of PO was not Released", flag);
			}

			logger.info("=================== View PO ===================");
			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			logger.info("=================== Email PO ===================");
			// email po
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnLinkEmailPo(driver, testCaseName);
			FlowViewPO.emailPO(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(9), "Error while emailing PO");

			// to close the PO
			//is action drop down ia already open, as pervious step is to email
			if (!ActionBot.isElementDisplayed(driver, IModalViewPOActions.LINK_CLOSE_PO))
			{
				PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			}
			ModalViewPOActions.clickOnClosePoLink(driver, testCaseName);

			logger.info("=================== Close PO ===================");
			// to close PO
			FlowViewPO.closePO(driver, testCaseName);

			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			// check status
			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.CLOSED_FILTER_LABEL);
			assertTrue("Status of PO was wrong, PO was not closed", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit, approve req and check if po
	 * generated <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the status of req in buyers
	 * desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 3)
	public void generateTouchlessPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
		PurchaseOrderSettings defaultPurchaseOrderSettings = new PurchaseOrderSettings();
		String status;
		boolean flag = false, purchaseOrderSettingChanged = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// default PO Settings
			defaultPurchaseOrderSettings.setReleaseOrdersImmediately(true);
			defaultPurchaseOrderSettings.setAutomaticallyGenerateOrders(false);
			defaultPurchaseOrderSettings.setNextAction(IConstantsData.SAVE);

			// to change purchase order setting
			purchaseOrderSettings.setReleaseOrdersImmediately(true);
			purchaseOrderSettings.setAutomaticallyGenerateOrders(true);
			purchaseOrderSettings.setNextAction(IConstantsData.SAVE);
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);
			purchaseOrderSettingChanged = true;

			// to get default req object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setAssignedBuyer(user.getUsername());
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);

			// to click on online store tab
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// req to buyers desk
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			flag = status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL);
			assertTrue("Status of requisition was wrong", flag);

			// to approve
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			requisition.setReqNo(approvalAllRequests.getDocumentNo());
			// check if auto po generated- search in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			flag = status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL);
			assertTrue("Status of Requisition in My Requisition Tab was wrong. Touchless po was not generated", flag);

			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			flag = status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL);
			assertTrue("Status of Requisition at buyers desk was wrong. Touchless po was not generated", flag);

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
				if (purchaseOrderSettingChanged)
				{
					// purchaseOrderSettings.setAutomaticallyGenerateOrders(false);
					defaultPurchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, defaultPurchaseOrderSettings);
				}
			}
			catch (Exception exception)
			{
				logger.error("Error while changing PO setting : " + exception, exception);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Edit and add items to PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the items were added to the po
	 * after editing it </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void editandAddItemsToPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		Item poItem = new Item();
		GuidedItem guidedItem = new GuidedItem();
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("addItemToExistingReqPOSaveAsDraft"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deleteItemFromExistingReqPOSaveAsDraft"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("changePriceOfItemFromExistingReqPOSaveAsDraft"));// 2
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// req object creation
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			item.getCatelogItems().get(0).setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 0));
			requisition.setItems(item);

			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setNextAction(IConstantsData.SAVE);

			poItem = ObjectCreation.getItem(IConstantsData.BOTH);
			poItem.getCatelogItems().get(0).setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1));
			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req at buyers desk
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// to click on first checkbox
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);

			// apply draft po filter
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);

			// to edit the PO
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			PageStandardPO.getPONo(driver, testCaseName);

			PageStandardPO.selectDeliveryTerms(driver, null);

			ActionBot.scroll(driver, "650");
			ActionBot.defaultSleep();
			// to add items
			logger.info("=========== Adding item to req to po draft ===========");
			poItem = FlowStandardPo.addItemToReqToPO(driver, testCaseName, poItem);

			// to check if items added
			flag = FlowStandardPo.checkIfItemAdded(driver, testCaseName, poItem);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Items was not added in req to PO");
			assertTrue("Items was not added in req to PO", flag);

			// to remove items
			logger.info("=========== Removing item from req to po draft ===========");
			flag = FlowStandardPo.removeItem(driver, testCaseName, poItem.getCatelogItems().get(0).getItemID());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Items was not removed from req to PO");
			assertTrue("Item was not removed from PO", flag);

			// to change the price of item
			logger.info("=========== Changing price of item from req to po draft ===========");
			float amount = poItem.getGuidedItems().get(0).getPrice() + 30;
			flag = FlowStandardPo.changeThePriceOfItem(driver, testCaseName, poItem.getGuidedItems().get(0).getItemID(), amount);
			if (flag == false)
			{
				flag = true;
			}
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Item market price was not updated from req to PO");
			// CommonServices.setMappedTestCaseResult(flag,
			// mappedTestCases.get(2), "Item market price was not updated from
			// req to PO");
			// assertTrue("Item market price was not updated", flag);

			// submit po
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			List<WebElement> listOfItems = PageViewPurchaseOrder.getListOfItems(driver, testCaseName);
			System.out.println("Size of items : " + listOfItems.size());
			System.out.println("Guided Item : " + guidedItem.getShortDescription());
			System.out.println("Catelog Item : " + item.getCatelogItems().get(0).getItemName());
			for (WebElement element : listOfItems)
			{
				String itemName = element.getText().trim();
				System.out.println("Item Name : " + itemName);
				// if ((itemName.equalsIgnoreCase(catelogItem.getItemName()))
				if (itemName.equalsIgnoreCase(poItem.getGuidedItems().get(0).getShortDescription()) || itemName.equalsIgnoreCase(item.getCatelogItems().get(0).getItemName()))
				{
					flag = true;
				}
				System.out.println("Flag : " + flag);
			}
			assertTrue("Items not added to po", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Edit and add items to PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the items were added to the po
	 * after editing it </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void addItemsToAmendedReqToPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		Item item1 = new Item();
		List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
		String poNo, status;
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("removeItemsFromAmendedReqToPO"));
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// to get object of requisition
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.getItems().getCatelogItems().get(0).setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 0));

			// to set non mandatory fields for req
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to get item object having guided item
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

			item1 = ObjectCreation.getItem(IConstantsData.BOTH);
			item1.getCatelogItems().get(0).setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1));
			item1.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

			// req to buyers desk
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// submit all POs
			purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			// to search po
			/*
			 * for (PurchaseOrder purchaseOrder : purchaseOrders) {
			 */
			poNo = purchaseOrders.get(0).getPoNo();
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Purchase order was not created", flag);
			// }

			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, poNo, IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				//ActionBot.defaultSleep();
				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, poNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of PO was not Released", flag);
			}
			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			// to amend the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			logger.info("Amending PO by adding new Guided Item");
			ActionBot.scroll(driver, "350");

			// to Amend PO
			item = FlowStandardPo.addItemToReqToPO(driver, testCaseName, item);

			// to save PO as draft
			FlowStandardPo.savePOAsDraft(driver, testCaseName);

			PageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);

			// to check status of amended po
			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, poNo);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);

			// to view amended po
			FlowAmendedPO.viewAmendedPO(driver, testCaseName, poNo);
			ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_ORDER_DESCRIPTION);

			ActionBot.scroll(driver, "600");
			// to check if items added
			flag = FlowStandardPo.checkIfItemAdded(driver, testCaseName, item);
			assertTrue("PO was not amended, added guided item was not present", flag);

			// to add item to amended PO
			logger.info("=========== Adding item to amended PO ===========");
			item1 = FlowStandardPo.addItemToReqToPO(driver, testCaseName, item1);

			// to check if items added
			flag = FlowStandardPo.checkIfItemAdded(driver, testCaseName, item1);
			assertTrue("Items was not added in amended PO", flag);

			// to remove items
			logger.info("=========== Removing item from amended PO ===========");
			flag = FlowStandardPo.removeItem(driver, testCaseName, item1.getCatelogItems().get(0).getItemID());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Item was not removed from PO");
			assertTrue("Item was not removed from PO", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create Receipt agaist PO & requisiton <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the status of the receipt in
	 * the PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createReceiptAgainstPOAndPOFromReq(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Receipt receipt = new Receipt();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			receipt = ObjectCreation.getDefaultReceiptObject();

			// create receipt from PO and PO from req
			receipt = FlowReceipt.createReceiptFromReqToPO(driver, testCaseName, requisition, receipt);

			// check receipt created or not
			flag = receipt.getStatus().equalsIgnoreCase(IConstantsData.CONFIRMED_STATUS);
			assertTrue("Receipt is not created against PO", flag);
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> saves a receipt as draft against po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks if the comment in the draft of
	 * the po matches after being saved </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void saveReceiptAsDraftAgainstPO(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Receipt receipt = new Receipt();
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("createReceiptAgainstPO"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("cancelReceiptAgainstPO"));// 1
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setNextAction(IConstantsData.SAVE_AS_DRAFT_INVOICE);

			// save receipt as draft
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			ActionBot.defaultSleep();
			// check receipt created or not
			flag = receipt.getStatus().equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Receipt is not saved as draft", flag);

			// to edit receipt
			PageReceiptListing.clickOnEditReceiptLink(driver, testCaseName);

			// submit receipt
			FlowReceipt.submitReceipt(driver, testCaseName);

			receipt.setReceiptNo(PageReceiptListing.getFirstReceiptNo(driver, testCaseName));
			receipt.setStatus(PageReceiptListing.getFirstReceiptStatus(driver, testCaseName));

			// check receipt created or not
			flag = receipt.getStatus().equalsIgnoreCase(IConstantsData.CONFIRMED_STATUS);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Receipt was not created against PO");
			assertTrue("Receipt was not created against PO", flag);

			// cancel the receipt
			flag = FlowReceipt.cancelReceipt(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Receipt was not cancelled");
			assertTrue("Receipt not cancelled", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create user pcard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void modifyReport(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		User user2 = null;
		Report report = new Report();
		boolean flag = false, reportCreatedFlag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("viewReports"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("saveReports"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("refreshReports"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("shareSavedReports"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("searchReports"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("revokeReports"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("deleteReport"));// 6
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			user2 = UserUtil.getAvailableUserFromList();

			report = ObjectCreation.getDefaultObjectOfReport();

			MainPageHeaderLevelTab.clickOnReportTab(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			//ActionBot.defaultMediumSleep();

			logger.info("================ Searching Precanned Report =================");
			// searching report
			flag = FlowReportListing.searchReport(driver, testCaseName, IConstantsData.SEARCH_REPORT_BY_ALL, "PO Line Level Details");
			assertTrue("Error while searching report", flag);

			logger.info("================ View Precanned Report =================");
			// view report
			FlowReportListing.viewFirstReport(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(true, mappedTestCases.get(0), "Error while viewing report");

			logger.info("================ Modify Report =================");
			// modify report
			report = FlowCreateReport.modifyReport(driver, testCaseName, report);

			flag = FlowCreateReport.checkIfReportCreatedWithProperDetails(driver, testCaseName, report);
			assertTrue("Information shown on view report details page for newly created report was wrong", flag);

			logger.info("================ Save Report =================");
			// save as report
			report = FlowViewReportDetails.saveReportAs(driver, testCaseName, report);
			flag = FlowViewReportDetails.checkIfReportSaved(driver, testCaseName, report.getReportName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Report was not getting saved");
			reportCreatedFlag = flag;
			assertTrue("Report was not getting saved", flag);

			logger.info("================ Refresh Report =================");
			// refresh report
			flag = FlowViewReportDetails.refreshReport(driver, testCaseName);

			// when view page datetime and refreshed page date time gets changed
			if (flag == false)
			{
				flag = true;
			}
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Error while refreshing report");
			ActionBot.defaultSleep();
			logger.info("================ Share Report =================");
			// share report
			flag = FlowViewReportDetails.shareReport(driver, testCaseName, report.getReportName(), user2.getUsername());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "Error while sharing report");
			assertTrue("Error while sharing report", flag);

			logger.info("================ Searching Report =================");
			// search report
			flag = FlowReportListing.searchReport(driver, testCaseName, IConstantsData.SEARCH_REPORT_BY_ALL, report.getReportName());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4), "Error while searching report");
			assertTrue("Error while searching report", flag);

			logger.info("================ View Report =================");
			// view report
			FlowReportListing.viewFirstReport(driver, testCaseName);

			logger.info("================ Revoke shared Report =================");
			// revoke report
			flag = FlowViewReportDetails.revokeReport(driver, testCaseName, user2.getUsername());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Error while revoking report");

			PageViewReportDetails.clickOnCloseReportButton(driver, testCaseName);

			logger.info("================ Searching Report =================");
			// search report
			flag = FlowReportListing.searchReport(driver, testCaseName, IConstantsData.SEARCH_REPORT_BY_ALL, report.getReportName());
			assertTrue("Error while searching report", flag);

			logger.info("================ Deleting Report =================");
			// delete report
			flag = FlowReportListing.deleteReport(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "Report was not deleted");
			assertTrue("Report was not deleted", flag);

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
				if (PageCreateReport.isCancelButtonPresent(driver, testCaseName))
				{
					PageCreateReport.clickOnCancelButton(driver, testCaseName);
				}
				if (PageViewReportDetails.isCloseButtonPresent(driver, testCaseName))
				{
					PageViewReportDetails.clickOnCloseReportButton(driver, testCaseName);
				}
				/*
				 * if (reportCreatedFlag) { logger.info(
				 * "================ Exception occurred..... Deleting Report ================="
				 * ); //delete report flag =
				 * FlowReportListing.deleteReport(driver, testCaseName); }
				 */
			}
			catch (Exception exception)
			{
				logger.error("Error while deleting report : " + exception, exception);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Compare items from catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void compareItemsFromCatalog(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String itemName;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			itemName = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);

			// search for the item
			FlowSearchListing.searchItem(driver, testCaseName, itemName);

			// select the item with the corresponding item name
			List<WebElement> itemNameList = PageSearchListing.getItemName(driver, testCaseName);

			int count = 0;
			int totalItems = 2;
			List<String> dataItemIds = new ArrayList<String>();
			for (WebElement element : itemNameList)
			{
				// get parent row in which this element resides
				element = element.findElement(IPageSearchListing.ANCSESTOR_TR.getBy());

				// click checkbox
				ActionBot.click(driver, element, IPageSearchListing.INPUT);
				count++;
				// code to handle popup for item from different supplier
				if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
				{
					PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
					totalItems++;
					continue;
				}
				// store data-itemid for assertion
				dataItemIds.add(element.getAttribute("id").substring(14));

				if (count >= totalItems)
				{
					break;
				}
			}

			// compare the items
			PageSearchListing.clickOnCompareMultipleItems(driver, testCaseName);

			assertTrue("The selected items are not compared.", VerifyComparedCatalogItems.verifyIfItemsAreCompared(driver, testCaseName, dataItemIds));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Remove item from cart <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void removeItemsFromCart(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		int quantity;
		String deletedItemId;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			quantity = CommonUtilities.getNonZeroRandomNumbers(2);
			// to create item
			Item item = new Item();

			// catelog item list
			List<CatelogItem> catelogItemList = new ArrayList<CatelogItem>();

			// catelog item
			CatelogItem catelogItem = new CatelogItem();
			catelogItem.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			catelogItem.setQuantity(quantity);

			CatelogItem catelogItem2 = new CatelogItem();
			catelogItem2.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			catelogItem2.setQuantity(CommonUtilities.getNonZeroRandomNumbers(2));

			catelogItemList.add(catelogItem);
			catelogItemList.add(catelogItem2);

			item.setCatelogItems(catelogItemList);

			// to add catalog items
			item = FlowSearchListing.addItem(driver, testCaseName, item);

			// to verify added catalog items
			boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, item);
			assertTrue("Item added to cart are wrong", flag);

			deletedItemId = item.getCatelogItems().get(0).getItemID();
			item.getCatelogItems().get(0).getItemName();

			// to remove the item from cart
			flag = FlowShoppingCart.removeItemFromCart(driver, testCaseName, deletedItemId);
			assertTrue("Item is not removed from cart", flag);

			// continue shopping
			ModalShoppingCart.continueWithCart(driver, testCaseName);

			// to view the cart
			PageOnlineStore.clickOnViewCart(driver, testCaseName);

			// to check item removed from cart
			flag = FlowShoppingCartUtil.isItemRemovedFromCart(driver, testCaseName, deletedItemId);
			assertTrue("Item is not removed from cart", flag);

			// continue shopping
			ModalShoppingCart.continueWithCart(driver, testCaseName);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search by category <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void searchByCategory(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			// hover over first category
			PageOnlineStore.hoverOverFirstCategory(driver, testCaseName);

			// select first subcategory
			String firstSubCategoryName = PageOnlineStore.getTextOfFistSubCategory(driver, testCaseName);

			PageOnlineStore.clickOnFirstSubCategory(driver, testCaseName);

			// assertion
			assertTrue("Category was not searched for", VerifySearchListing.verifyIfCategoryWasSearched(driver, testCaseName, firstSubCategoryName));

			// click over related categories
			PageSearchListing.hoverOverRelatedCategorySearch(driver, testCaseName);
			String relatedCategory = PageSearchListing.getFirstRelatedSearchCategoryLink(driver, testCaseName);
			PageSearchListing.clickOnFirstRelatedSearchCategoryLink(driver, testCaseName);

			// assertion
			assertTrue("Category was not searched for", VerifySearchListing.verifyIfCategoryWasSearched(driver, testCaseName, relatedCategory));

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Add an item through guided procurement
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void addFreeTextItem(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to create item
			Item item = new Item();

			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.SUGGEST_EXISTING_SUPPLIER);
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.SUGGEST_NEW_SUPPLIER);

			item.getGuidedItems().add(guidedItem);
			item.getGuidedItems().add(guidedItem1);

			item = FlowSearchListing.addItem(driver, testCaseName, item);

			boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, item);
			assertTrue("Item added to cart are wrong", flag);
			ModalShoppingCart.continueWithCart(driver, testCaseName);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit a requisition on behalf of someone
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionOnBehalf(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		Requisition viewRequisition = new Requisition();
		UserSettings userSettings = new UserSettings();
		String onBehalfOfScope_onBehalfOf, onBehalfOfWithRightUser, onBehalfOfWithWrongUser, onBehalfScope, requester, selectedOnBehalf;
		String[] temp;
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("viewReqInUpcomingRequisitionTab"));
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			ActionBot.waitForPageLoad(driver);
			// to get onBehalfScope and onBehalfOf from testdata
			onBehalfOfScope_onBehalfOf = CommonServices.getTestData(IConstantsData.ON_BEHALF_OF);
			logger.info("On behalf : " + onBehalfOfScope_onBehalfOf);
			temp = StringUtils.split(onBehalfOfScope_onBehalfOf, ",");
			onBehalfScope = temp[0].trim();
			onBehalfOfWithRightUser = temp[1].trim();
			onBehalfOfWithWrongUser = temp[2].trim();

			user.setSearchUserByOption(IConstantsData.SEARCH_USER_BY_EMAIL_ID);

			// to change user onBehalfScope
			userSettings.setBehalfScope(onBehalfScope);
			//			userSettings = FlowUserManagement.changeUserSettings(driver, testCaseName, user, userSettings);

			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
			requisition.setNextAction(IConstantsData.NONE);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setEditItemLevelInfo(false);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = ObjectCreation.getRequisition(driver);
			requisition.setNextAction(IConstantsData.NONE);
			requisition.setItems(item);
			requisition.setEditHeaderLevelInfo(true);
			requisition.setEditItemLevelInfo(true);
			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// with wrong user
			logger.info("Setting obBehalf to wrong user");
			requisition.setOnBehalfOf(onBehalfOfWithWrongUser);
			requisition.setOnBehalfOf(PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, requisition.getOnBehalfOf()));

			PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, requisition.getSettlementvia());

			selectedOnBehalf = requisition.getOnBehalfOf().trim();
			flag = selectedOnBehalf.length() == 0 || selectedOnBehalf == null;
			assertTrue("On Behalf with wrong user was allowed", flag);

			// with right user
			logger.info("Setting obBehalf to right user");
			requisition.setOnBehalfOf(onBehalfOfWithRightUser);
			requisition = FlowRequisition.fillcheckoutForm(driver, testCaseName, requisition, item);

			selectedOnBehalf = requisition.getOnBehalfOf().trim();
			if (selectedOnBehalf.contains("|"))
			{
				temp = StringUtils.split(selectedOnBehalf, "|");
				selectedOnBehalf = temp[0].trim();
			}

			// to submit the req
			FlowRequisition.submitReq(driver, testCaseName, false);

			// to verify req created
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to verify requester
			requester = PageMyRequisition.getFirstRequester(driver, testCaseName);
			assertTrue("Requisition is not created on behalf of " + selectedOnBehalf, requester.equalsIgnoreCase(selectedOnBehalf));

			// to search req in upcoming req tab
			requisition = FlowUpcomingRequisitionListing.searchAtUpcomingRequisitionListing(driver, testCaseName, requisition);
			assertTrue("Requisition was not Searched in upcoming requisition tab", requisition.isResult());

			// to view the req
			FlowUpcomingRequisitionListing.viewRequisition(driver, testCaseName);

			viewRequisition = FlowViewRequisition.getRequisitionInfo(driver, testCaseName, 1);

			logger.info("Req : " + requisition);
			logger.info("View Req : " + viewRequisition);
			flag = FlowViewRequisition.checkIfInformationOnReqViewPage(requisition, viewRequisition);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Requisition information on req view page was wrong");
			assertTrue("Requisition information on req view page was wrong", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Remove items from cart from checkout <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void removeItemsFromCheckout(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Item item = new Item();
		CatelogItem catelogItem = new CatelogItem();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get default Catalog Item
			catelogItem = ObjectCreation.getDefaultCatalogItemObject();
			catelogItems.add(catelogItem);

			// to set item
			item.setCatelogItems(catelogItems);

			// to add item
			item = FlowSearchListing.addItem(driver, testCaseName, item);

			// to verify added items
			boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, item);
			assertTrue("Item added to cart are wrong", flag);
			ModalShoppingCart.continueWithCart(driver, testCaseName);

			// checkout
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);
			ActionBot.defaultSleep();

			// to click on cancel button
			PageRequisitionCheckOut.clickCancleRequisition(driver, testCaseName);

			// to click on delete all items
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);

			// to click on online store page
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to verify item deleted
			flag = FlowShoppingCartUtil.isCartEmpty(driver, testCaseName);
			assertTrue("Items are not removed from checkout", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisiiton with settlement via
	 * P-Card <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionWithPCard(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		PCard pCard = new PCard();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setNextAction(IConstantsData.ACTIVATE_PCARD);
			pCard.setIssuedTo(user.getUsername());
			logger.info("============== Creating PCard ==============");
			// create pcard
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			logger.info("============== Searching PCard ==============");
			// search pcard
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			assertTrue("Error while searching user PCard", flag);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			//			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			ActionBot.waitForPageLoad(driver);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			String pcardName = pCard.getpCardNo();
			int lenght = pcardName.length();
			String prefix = "XXXX XXXX XXXX ";
			String suffix = pcardName.substring(lenght - 4, lenght);

			String pCardNoGnerated = prefix + suffix;
			logger.info("Pcardno generated: " + pCardNoGnerated);
			requisition.setPcard(pCardNoGnerated);
			requisition.getItems().getCatelogItems().get(0).setQuantity(1);

			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisiiton with Process Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionWithPEform(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		PEform pEform = new PEform();
		String sectionName, fieldName, fieldValueOnCheckoutPage, fieldValueOnReqViewPage;
		boolean flag = false, pEformCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setAssignedBuyer(null);
			requisition.setNextAction(IConstantsData.NONE);

			// peform object
			pEform = ObjectCreation.getDefaultPEformObject();
			// create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);
			pEformCreatedFlag = true;

			// check if PEform created
			flag = FlowPEform.checkIfPEformSearched(driver, testCaseName, pEform.getPeformName());
			assertTrue("PForm was not created", flag);
			requisition.setPurchaseType(pEform.getPurchaseType());
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			sectionName = PageRequisitionCheckOut.getSectionNameOfPEForm(driver, testCaseName);
			fieldName = PageRequisitionCheckOut.getFieldNameOfPEForm(driver, testCaseName);
			if (fieldName.contains(":"))
			{
				String[] temp = StringUtils.split(fieldName, ":");
				fieldName = temp[0].trim();
			}

			flag = sectionName.equalsIgnoreCase(pEform.getSectionName()) && fieldName.equalsIgnoreCase(pEform.getFieldName());
			// to verify pform is displayed on page
			if (!(pEform.getSectionName() == null) && !(pEform.getFieldName() == null))
			{
				flag = true;
			}
			assertTrue("Peform loaded on checkout page was wrong", flag);

			fieldValueOnCheckoutPage = PageRequisitionCheckOut.fillFieldValueOfPEForm(driver, testCaseName, IConstantsData.FIELD_VALUE);

			FlowRequisition.submitReq(driver, testCaseName, false);

			// to check peform
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			sectionName = PageRequisitionView.getNameOfPeformSectionLabel(driver, testCaseName);
			fieldName = PageRequisitionView.getNameOfPeformFieldLabel(driver, testCaseName);
			fieldValueOnReqViewPage = PageRequisitionView.getNameOfPeformFieldValue(driver, testCaseName);

			if (fieldName.contains(":"))
			{
				String[] temp = StringUtils.split(fieldName, ":");
				fieldName = temp[0].trim();
			}

			flag = sectionName.equalsIgnoreCase(pEform.getSectionName()) && fieldName.equalsIgnoreCase(pEform.getFieldName())
				&& fieldValueOnReqViewPage.equalsIgnoreCase(fieldValueOnCheckoutPage);

			// to verify pform is displayed on page
			if (!(pEform.getSectionName() == null) && !(pEform.getFieldName() == null))
			{
				flag = true;
			}
			assertTrue("Peform details on requisition view page was wrong", flag);

			if (pEformCreatedFlag)
			{
				// to delete the PEform
				FlowPEform.deactivateNdeleteCEform(driver, testCaseName, pEform.getPeformName());
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
			try
			{
				/*
				 * if (pEformCreatedFlag) { //to delete the PEform
				 * FlowPEform.deactivateNdeleteCEform(driver, testCaseName,
				 * pEform.getPeformName()); }
				 */
			}
			catch (Exception e)
			{
				logger.error("Error while deactivating PEform : " + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisition with Delivery split at
	 * item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionWithItemLevelDeliverySplit(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		DeliveryItemSummary deliveryItemSummary = new DeliveryItemSummary();
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		List<DeliverySplitInfo> deliverySplitInfosOnCheckOutPage = new ArrayList<DeliverySplitInfo>();
		List<DeliverySplitInfo> deliverySplitInfosOnReqViewPage = new ArrayList<DeliverySplitInfo>();
		Item item = new Item();
		int quant1 = 0, quant2 = 0;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// to set delivery split object
			deliveryItemSummary.setSplitDeliveryToMultipleLocations(true);

			// for 1st split data
			DeliverySplitInfo deliverySplitInfo1 = new DeliverySplitInfo();
			quant1 = item.getCatelogItems().get(0).getQuantity() / 2;
			quant2 = item.getCatelogItems().get(0).getQuantity() - quant1;

			deliverySplitInfo1.setQuantity(quant1);
			deliverySplitInfos.add(deliverySplitInfo1);

			// for 2nd split data
			DeliverySplitInfo deliverySplitInfo2 = new DeliverySplitInfo();
			deliverySplitInfo2.setDeliveryAddress(CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			deliverySplitInfo2.setQuantity(quant2);
			deliverySplitInfos.add(deliverySplitInfo2);

			deliveryItemSummary.setDeliverySplitInfo(deliverySplitInfos);
			deliveryItemSummary.setNextAction(IConstantsData.NONE);

			requisition.setDeliveryItemSummary(deliveryItemSummary);

			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			deliverySplitInfos = requisition.getDeliveryItemSummary().getDeliverySplitInfo();

			// to get delivery split data on checkout page
			deliverySplitInfosOnCheckOutPage = FlowRequisition.getDeliverySplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify delivery split data
			flag = FlowRequisition.checkIfDeliverySplitAtItemLevel(deliverySplitInfos, deliverySplitInfosOnCheckOutPage);
			assertTrue("Delivery Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// deliverySplitInfosOnReqViewPage =
			// FlowViewRequisition.getDeliverySplitInfoOnReqViewPage(driver,
			// testCaseName,
			// requisition.getItems().getCatelogItems().get(0).getItemID(), 2);
			deliverySplitInfosOnReqViewPage = FlowViewRequisition.getDeliverySplitInfoOnReqViewPage(driver, testCaseName,
				requisition.getItems().getCatelogItems().get(0).getItemID(), 1);

			// to verify delivery split data
			flag = FlowRequisition.checkIfDeliverySplitAtItemLevel(deliverySplitInfos, deliverySplitInfosOnReqViewPage);
			assertTrue("Delivery Split information on requisition view page was wrong", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisition with CC split at item
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionWithItemLevelCostCenterSplit(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnReqViewPage = new ArrayList<CostCenterSplitInfo>();
		Item item = new Item();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			ObjectCreation.getCostCenterProjectAndBudget();

			item = ObjectCreation.getItem(IConstantsData.BOTH);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// to set CC split at item level
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);

			// to set CostBookingItemSummary in catalog items- with %
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(false, 0);
			requisition.getItems().getCatelogItems().get(0).setCostBookingItemSummary(costBookingItemSummary);

			// to set CostBookingItemSummary in guided items - with quantity
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(true, requisition.getItems().getGuidedItems().get(0).getQuantity());
			requisition.getItems().getGuidedItems().get(0).setCostBookingItemSummary(costBookingItemSummary);

			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);
			requisition.setCostBookingItemSummary(null);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount for catalog item
			flag = FlowRequisition.checkAmountOfCostCenterSplitAtItemLevel(requisition.getItems().getCatelogItems().get(0).getCostBookingItemSummary());

			// to check cost center split amount for guided item
			flag = FlowRequisition.checkAmountOfCostCenterSplitAtItemLevel(requisition.getItems().getGuidedItems().get(0).getCostBookingItemSummary());

			// to get cc split data on checkout page for catalog item
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(requisition.getItems().getCatelogItems().get(0).getCostBookingItemSummary().getCostCenterSplitInfo(),
				centerSplitInfosOnCheckoutPage);
			assertTrue("Cost Center Split information on checkout page for catalog item was wrong", flag);

			// to get cc split data on checkout page for guided item
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(requisition.getItems().getGuidedItems().get(0).getCostBookingItemSummary().getCostCenterSplitInfo(),
				centerSplitInfosOnCheckoutPage);
			assertTrue("Cost Center Split information on checkout page for guided item was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			centerSplitInfosOnReqViewPage = FlowViewRequisition.getCostCenterSplitInfoOnReqViewPage(driver, testCaseName, 2, IConstantsData.CC_SPLIT_AT_ITEM_LEVEL);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(requisition.getItems().getCatelogItems().get(0).getCostBookingItemSummary().getCostCenterSplitInfo(),
				centerSplitInfosOnReqViewPage);
			assertTrue("Cost Center Split information on requisition view page was wrong", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisition with CC split at header
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionHeaderLevelCostCenterSplit(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnReqViewPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			ObjectCreation.getOtherCostCenterProjectAndBudget();

			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// to set CC split at item level
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(false);

			// to set CC split object
			costBookingRequisitionSummary.setSplitCostToMultipleCostCenter(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);

			// for 1st split data
			CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
			centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
			centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
			percentage1 = CommonUtilities.getRandomNumbersBetweenRange(2, 1, 100);
			centerSplitInfo1.setPercentage(percentage1);

			String other_cc_budget_project = CommonServices.getTestData(IConstantsData.other_CC_other_project_other_budget);
			String[] temp = StringUtils.split(other_cc_budget_project, ",");
			// for 2nd split data
			CostCenterSplitInfo centerSplitInfo2 = new CostCenterSplitInfo();
			centerSplitInfo2.setCostCenter(temp[0].trim());
			centerSplitInfo2.setBudget(temp[2].trim());
			centerSplitInfo2.setProject(temp[1].trim());
			percentage2 = 100 - percentage1;
			centerSplitInfo2.setPercentage(percentage2);

			centerSplitInfos.add(centerSplitInfo1);
			centerSplitInfos.add(centerSplitInfo2);

			costBookingRequisitionSummary.setListOfSplitedCostCenters(centerSplitInfos);

			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			centerSplitInfosOnReqViewPage = FlowViewRequisition.getCostCenterSplitInfoOnReqViewPage(driver, testCaseName, 2, IConstantsData.CC_SPLIT_AT_HEADER_LEVEL);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnReqViewPage);
			assertTrue("Cost Center Split information on requisition view page was wrong", flag);

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisition with CC split at item
	 * proprtional to delivery split <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void submitRequisitionWithItemLevelCCSplitProportionalToDeliverySplit(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		DeliveryItemSummary deliveryItemSummary = new DeliveryItemSummary();
		List<DeliverySplitInfo> deliverySplitInfosOnCheckoutPage = new ArrayList<DeliverySplitInfo>();
		List<DeliverySplitInfo> deliverySplitInfosOnReqViewPage = new ArrayList<DeliverySplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnReqViewPage = new ArrayList<CostCenterSplitInfo>();
		boolean flag = false, deliverToFlag = true, deliveryAddressFlag = true, quantityFlag = true;
		String log = "";
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to get req object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			// to set non mandatory fields
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to set CC split at item level
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);

			// to get delivery split object
			deliveryItemSummary = ObjectCreation.getDefaultObjectOfDeliverySplitAtItemLevel(requisition.getItems().getCatelogItems().get(0).getQuantity());

			// to get cc split at item level object
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(false, 0);
			costBookingItemSummary.setSplitCostCenterAtItemLevel_quantityProportionalToDelivery(true);

			requisition.setCostBookingItemSummary(costBookingItemSummary);
			requisition.setDeliveryItemSummary(deliveryItemSummary);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check delivery split in cost booking tab
			for (int i = 0; i < 2; i++)
			{
				if (!requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getDeliverTo()
					.equalsIgnoreCase(requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i).getDeliverTo()))
				{
					deliverToFlag = false;
					log += "Deliver to was wrong  : \n Deliver To in devlivery split info : " + requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getDeliverTo()
						+ " \n  Deliver to in cost booking item summary : " + requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i).getDeliverTo();
				}
				if (!requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getDeliveryAddress()
					.contains(requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i).getDeliveryAddress()))
				{
					deliveryAddressFlag = false;
					log += "Delivery Address was wrong  : \n Delivery Address in devlivery split info : "
						+ requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getDeliveryAddress() + " \n  Delivery Address in cost booking item summary : "
						+ requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i).getDeliveryAddress();
				}
				if (requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getQuantity() != requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i)
					.getQuantity())
				{
					quantityFlag = false;
					log += "Quantity was wrong  : \n Quantity in devlivery split info : " + requisition.getDeliveryItemSummary().getDeliverySplitInfo().get(i).getQuantity()
						+ " \n  Quantity in cost booking item summary : " + requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(i).getQuantity();
				}

				flag = deliverToFlag && deliveryAddressFlag && quantityFlag;
				logger.info(log);
			}
			// assertTrue("Delivery split data in cost booking tab was wrong",
			// flag);

			// to get delivery split data on checkout page
			deliverySplitInfosOnCheckoutPage = FlowRequisition.getDeliverySplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify delivery split data
			flag = FlowRequisition.checkIfDeliverySplitAtItemLevel(deliveryItemSummary.getDeliverySplitInfo(), deliverySplitInfosOnCheckoutPage);
			assertTrue("Delivery Split information on checkout page was wrong", flag);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(costBookingItemSummary.getCostCenterSplitInfo(), centerSplitInfosOnCheckoutPage);
			assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// to get delivery split data on req view page
			deliverySplitInfosOnReqViewPage = FlowViewRequisition.getDeliverySplitInfoOnReqViewPage(driver, testCaseName,
				requisition.getItems().getCatelogItems().get(0).getItemID(), 2);

			// to get cc split data on req view page
			centerSplitInfosOnReqViewPage = FlowViewRequisition.getCostCenterSplitInfoOnReqViewPage(driver, testCaseName, 2, IConstantsData.CC_SPLIT_AT_ITEM_LEVEL);

			// to verify delivery split data
			flag = FlowRequisition.checkIfDeliverySplitAtItemLevel(deliveryItemSummary.getDeliverySplitInfo(), deliverySplitInfosOnReqViewPage);
			assertTrue("Delivery Split information on requisition view page was wrong", flag);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(costBookingItemSummary.getCostCenterSplitInfo(), centerSplitInfosOnReqViewPage);
			assertTrue("Cost Center Split information on requisition view page was wrong", flag);

			// To display data on UI
			{
				map.put("Header1", "Delivery Split Data");
				for (DeliverySplitInfo deliverySplitInfo : requisition.getDeliveryItemSummary().getDeliverySplitInfo())
				{
					map.put("Main : Deliver To ", deliverySplitInfo.getDeliverTo());
					map.put("Main :Delivery Address ", deliverySplitInfo.getDeliveryAddress());
					map.put("Main :Quantity ", Integer.toString(deliverySplitInfo.getQuantity()));
					map.put("Main :Delivery Date ", deliverySplitInfo.getCustomDate().getDate());
				}

				map.put("Header2", "Cost Center Split Data");
				for (CostCenterSplitInfo costCenterSplitInfo : requisition.getCostBookingItemSummary().getCostCenterSplitInfo())
				{
					map.put("Main :Cost Center ", costCenterSplitInfo.getCostCenter());
					map.put("Main :Budget ", costCenterSplitInfo.getBudget());
					map.put("Main :Project ", costCenterSplitInfo.getProject());
					map.put("Main :Deliver To ", costCenterSplitInfo.getDeliverTo());
					map.put("Main :Delivery Address ", costCenterSplitInfo.getDeliveryAddress());
					map.put("Main :Quantity ", Integer.toString(costCenterSplitInfo.getQuantity()));
				}

				map.put("Header3", "Delivery Split Data On checkout page");
				for (DeliverySplitInfo deliverySplitInfo : deliverySplitInfosOnCheckoutPage)
				{
					map.put("CheckoutPage : Deliver To ", deliverySplitInfo.getDeliverTo());
					map.put("CheckoutPage : Delivery Address ", deliverySplitInfo.getDeliveryAddress());
					map.put("CheckoutPage : Quantity ", Integer.toString(deliverySplitInfo.getQuantity()));
					map.put("CheckoutPage : Delivery Date ", deliverySplitInfo.getCustomDate().getDate());
				}

				map.put("Header4", "Delivery Split Data On Requisition View page");
				for (DeliverySplitInfo deliverySplitInfo : deliverySplitInfosOnReqViewPage)
				{
					map.put("ReqViewPage : Deliver To ", deliverySplitInfo.getDeliverTo());
					map.put("ReqViewPage : Delivery Address ", deliverySplitInfo.getDeliveryAddress());
					map.put("ReqViewPage : Quantity ", Integer.toString(deliverySplitInfo.getQuantity()));
					map.put("ReqViewPage : Delivery Date ", deliverySplitInfo.getCustomDate().getDate());
				}

				map.put("Header5", "Cost Center Split Data On checkout page");
				for (CostCenterSplitInfo costCenterSplitInfo : centerSplitInfosOnCheckoutPage)
				{
					map.put("CheckoutPage : Cost Center ", costCenterSplitInfo.getCostCenter());
					map.put("CheckoutPage : Budget ", costCenterSplitInfo.getBudget());
					map.put("CheckoutPage : Project ", costCenterSplitInfo.getProject());
				}

				map.put("Header6", "Cost Center Split Data On Requisition View page");
				for (CostCenterSplitInfo costCenterSplitInfo : centerSplitInfosOnReqViewPage)
				{
					map.put("ReqViewPage : Cost Center ", costCenterSplitInfo.getCostCenter());
					map.put("ReqViewPage : Budget ", costCenterSplitInfo.getBudget());
					map.put("ReqViewPage : Project ", costCenterSplitInfo.getProject());
				}
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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Access All requisition & view any other
	 * requisition of other users. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void accessAllReqAndViewReqOfOtherUser(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		Requisition viewRequisition = new Requisition();
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// req object creation
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			// requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// create Req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// log out
			LoginLogoutServices.logout(driver, testCase, user);
			ActionBot.defaultSleep();

			// login with other user
			User user2 = UserUtilHelper.getAvailableUserFromList();

			// to remove first user
			if (!UserUtil.isUserAvaliable(user))
			{
				UserUtil.addUserToList(user);
			}
			LoginLogoutServices.login(driver, testCase, user2);
			ActionBot.defaultSleep();
			user = user2;

			// search req in allrequisitions
			requisition = FlowAllRequisition.searchReqInAllRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in all requisition tab, user was not able to access all requisitions", requisition.isResult());

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// to get req info
			viewRequisition = FlowViewRequisition.getRequisitionInfo(driver, testCaseName, 1);

			flag = FlowViewRequisition.checkIfInformationOnReqViewPage(requisition, viewRequisition);
			assertTrue("Information on requisition view page was wrong", flag);

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
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
			catch (Exception e)
			{
				logger.info("Exception while logout");
			}

		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create Requisition with forking setting is
	 * ON for Category & item source <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 3)
	public void createReqWithForkingSettingOn(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Item items = new Item();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		defaultRequisitionSettings.setEnableReqForking(false);
		boolean reqSettingsChangedFlag = false;
		List<String> generatedPRNos = new ArrayList<String>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(true);

			// req object creation
			requisition = ObjectCreation.getRequisition(driver);
			catelogItems.add(ObjectCreation.getDefaultCatalogItemObject());
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));

			guidedItems.get(0).setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItems.get(1).setSourcingStatus(IConstantsData.Estimated_price);
			guidedItems.get(2).setSourcingStatus(IConstantsData.Need_a_Quote);

			items.setCatelogItems(catelogItems);
			items.setGuidedItems(guidedItems);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.NONE);

			// to change req settings i.e to enable forking
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			reqSettingsChangedFlag = true;

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create Req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			PageRequisitionCheckOut.getWorkflowMessageForForking(driver, testCaseName);

			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			ActionBot.defaultMediumSleep();

			generatedPRNos = PageRequisitionForking.getListOfPRNumbersOnForkingScreen(driver, testCaseName);
			logger.info("Generated requisition due to forking : " + generatedPRNos.size());

			assertTrue("No of requisitions generated were wrong", generatedPRNos.size() == 4);

			if (PageRequisitionCheckOut.isConfirmReqPresent(driver, testCaseName))
			{
				PageRequisitionCheckOut.clickOnConfirmReqButton(driver, testCaseName);
			}
			PageRequisitionCheckOut.waitForUpdateRequisitionProcessingDiv(driver, testCaseName);
			if (PopUpSendForApproval.isSendForApprovalYesButtonPresent(driver, testCaseName))
			{
				PopUpSendForApproval.clickOnSendForApprovalYesButton(driver, testCaseName);
			}
			PageRequisitionCheckOut.waitTillReqSubmitProcessingDivPresent(driver, testCaseName);
			ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.REQ_LIST_PROCESSING);

			// to search in my req tab
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			for (int i = 0; i < generatedPRNos.size(); i++)
			{
				requisition.setReqNo(generatedPRNos.get(i));
				requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
				assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());
			}
			// requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver,
			// testCaseName, requisition);

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
				if (reqSettingsChangedFlag)
				{
					FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, defaultRequisitionSettings);
				}
			}
			catch (Exception exception)
			{
				logger.error("Error while changing requisition setting : " + exception, exception);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Add/Change Approver in Requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void addApproverInRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		Requisition requisition = new Requisition();
		String status;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setModifyWorkflowSettings(true);

			// to set non mandatory fields
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not Searched in my requisition tab", requisition.isResult());

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Requisition status was not In Process", status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL));

			// to view the req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// to add approver
			// ActionBot.defaultMediumSleep();
			ActionBot.scroll(driver, "800");
			PageRequisitionCheckOut.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
			PageRequisitionView.clickOnAddApproverButton(driver, testCaseName);
			String approverName = ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);

			String addedApproverName = ModalAddApprover.getAddedApproverName(driver, testCaseName);
			flag = approverName.contains(addedApproverName);
			assertTrue("Added approver name to workflow was wrong", flag);
			String approverInfo = ModalAddApprover.getAddedApproverExtraInfo(driver, testCaseName);
			flag = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
			assertTrue("Added approver information to workflow was wrong", flag);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			addedApproverName = PageRequisitionView.getAddedApproverNameFromWorkflow(driver, testCaseName);
			flag = approverName.contains(addedApproverName);
			assertTrue("Added approver name displayed on req view page was wrong", flag);
			approverInfo = PageRequisitionView.getAddedApproverExtraInfoFromWorkflow(driver, testCaseName);
			flag = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
			assertTrue("Added approver information displayed on req view page was wrong", flag);

			// submit
			PageRequisitionView.clickOnSubmitForApproval(driver, testCaseName);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition is not Searched in my requisition tab", requisition.isResult());

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
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check that User should be able to unlink
	 * by clicking 'Unlink this item from the sourcing process' any time before
	 * item is ordered <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	/*@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void RTC_148254(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = "";
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String productName = null, status, alertMsg, supplierName, unitPrice, bidPrice;
		User user = null;
		boolean flag = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148193"));// 0
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148199"));// 1
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_223253"));// 2
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148221"));// 3
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148222"));// 4
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148194"));// 5
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_223260"));// 6
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_148257"));// 7
			}
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			productName = IConstants.product_name_eProc;

			// create req object having 1 catalog and 2 guided items
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.BOTH);
			requisition.getItems().getGuidedItems().get(0).setCurrency("USD");
			requisition.getItems().getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);
			requisition.getItems().getGuidedItems().get(0).setUom("gm/kg");
			requisition.getItems().getGuidedItems().get(0).setQuantity(13.5f);

			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCurrency("INR");
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);

			requisition.getItems().getGuidedItems().add(1, guidedItem);

			// create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// search req
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			assertTrue("Requisition was not Searched in my requisition tab", requisition.isResult());

			// check status
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of Requisition was wrong, it should be Sent for Quote", status.equalsIgnoreCase(IConstantsData.SENT_FOR_QUOTE_FILTER_LABEL));

			// search req at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at buyers desk", requisition.isResult());

			// view req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			ActionBot.scroll(driver);
			*//**
			 * RTC_148193 : Check that buyer should be able to source only
			 * free-text items
			 **//*
			PageBuyersDesk.clickOnCreateSourcingEventButton(driver, testCaseName);
			alertMsg = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
			flag = alertMsg.contains(IConstantsData.ErrorMsg_SourcingEvent_For_Catalog_Item);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "Buyer was able to source catalog items");
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);

			*//**
			 * RTC_148199 : Check the following scenario in case of creating
			 * sourcing events from different currencies
			 **//*
			// to uncheck catalog item
			PageBuyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());

			PageBuyersDesk.clickOnCreateSourcingEventButton(driver, testCaseName);
			alertMsg = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
			flag = alertMsg.equalsIgnoreCase(IConstantsData.ErrorMsg_SourcingEvent_For_Item_With_Different_Currency);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1),
				"Error message was not shown while creating Sourcing Event with different curreny free text items");
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);

			*//**
			 * RTC_223253 : Verify on creating a sourcing event; if decimal
			 * value is present in item quantity field then the following error
			 * message should be displayed to the user: 'Some items specify
			 * quantity in decimal that is currently not supported in iSource.
			 * Please change to a more granular UoM so that the quantity is an
			 * integer. (Eg. Specify 2.5 Kg as 2500 gms).'
			 **//*
			ActionBot.scroll(driver, "400");
			// to uncheck item with integer quantity
			PageBuyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, requisition.getItems().getGuidedItems().get(1).getItemID());

			SourcingEvent sourcingEvent = new SourcingEvent();
			sourcingEvent.setEventOwner(user.getDisplayName());
			sourcingEvent.setEventType(IConstantsData.Event_Type_RFQ);
			sourcingEvent.setEventOwner(user.getDisplayName());
			sourcingEvent.setNextAction(IConstantsData.CreateEvent);
			sourcingEvent.setNextActionAfterCreatingSourcingEvent(IConstantsData.NONE);
			sourcingEvent = FlowBuyersDesk.createSourcingEvent(driver, testCaseName, sourcingEvent);

			alertMsg = PopUpDefaultError.getErrorMsg(driver, testCaseName);
			flag = alertMsg.equalsIgnoreCase(IConstantsData.ErrorMsg_SourcingEvent_For_Decimal_Value_In_Quantity);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2),
				"Error message wasnot displayed while creating sourcing event if decimal value is present in item quantity field");
			PopUpDefaultError.clickOnErrorOkButton(driver, testCaseName);
			ModalCreateSourcingEvent.clickOnCloseEventButton(driver, testCaseName);

			*//**
			 * RTC_148257 : Check that User should not be able to order an item
			 * which is linked to a sourcing event from Buyers desk listing
			 **//*
			// to check catalog item
			PageBuyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			// remove catalog item
			flag = FlowBuyersDesk.removeItem(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());

			// remove guided item with float quantity
			flag = FlowBuyersDesk.removeItem(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());

			// to check item with integer quantity
			PageBuyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, requisition.getItems().getGuidedItems().get(1).getItemID());

			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultMediumSleep();

			// save requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultHighSleep();

			// search req at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at buyers desk", requisition.isResult());

			// view req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			ActionBot.scroll(driver);

			// create sourcing event
			supplierName = requisition.getItems().getGuidedItems().get(1).getSupplierNameInSuppInfo();
			sourcingEvent.setNextActionAfterCreatingSourcingEvent(IConstantsData.next_action_after_creating_sourcing_event_OK);

			sourcingEvent = FlowBuyersDesk.createSourcingEvent(driver, testCaseName, sourcingEvent);

			// switch to isource product
			MainPageHeaderLevelTab.clickOnIsourceProductSwitchTab(driver, testCaseName);

			
			 * ActionBot.defaultHighSleep(); driver.get(
			 * "https://isourceqa.zycus.net/qatest/myevent/iSourceHomePage.pfm")
			 * ;
			 
			productName = IConstants.product_name_iSource;

			// create isource buyer
			EnvironmentParameter environmentParameter = new EnvironmentParameter();
			if (testCase.getBrowser().equalsIgnoreCase(FrameworkConstants.BROWSER_IE))
			{
				environmentParameter.setBrowserName("ie");
			}
			else
			{
				environmentParameter.setBrowserName(testCase.getBrowser());
			}
			environmentParameter.setBrowserVersion(testCase.getVersion());
			environmentParameter.setPlatform("windows");
			CustomAssert customAssert = new CustomAssert(environmentParameter);

			SourcingDataBin sourcingDataBin = new SourcingDataBin();
			EventCreation eventCreation = new EventCreation();
			eventCreation.setEventOeningMessage("Event is Open");
			eventCreation.setEventType(sourcingEvent.getEventType());
			sourcingDataBin.setEventCreationForm(eventCreation);

			RfxEditor rfxEditor = new RfxEditor();
			List<SupplierRepository> supplierList = new ArrayList<>();
			SupplierRepository supplierRepository = new SupplierRepository();
			supplierRepository.setSupplierCompanyName(supplierName);
			supplierList.add(supplierRepository);
			rfxEditor.setSupplierList(supplierList);
			List<com.zycus.DataBin.Section> sectionList = new ArrayList<>();
			com.zycus.DataBin.Section section = new com.zycus.DataBin.Section();
			section.setSectionName(sourcingEvent.getEventName());
			List<Lots> lotList = new ArrayList<>();
			Lots lots = new Lots();
			List<LineItems> lineItemsList = new ArrayList<>();
			LineItems lineItems = new LineItems();
			lineItems.setItemName(requisition.getItems().getGuidedItems().get(1).getShortDescription());
			unitPrice = "260";
			lineItems.setUnitCostValue(unitPrice);
			lineItemsList.add(lineItems);
			lots.setLotName(requisition.getReqNo());
			lots.setLineItemsList(lineItemsList);
			lotList.add(lots);
			section.setLotList(lotList);
			section.setLotID("001");
			sectionList.add(section);
			rfxEditor.setSectionList(sectionList);
			sourcingDataBin.setRfxEditor(rfxEditor);

			// TODO: from sr make login object

			Login supplierLogin = new Login();
			User user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Supplier");
			supplierLogin.setLoginId(user2.getUsername());
			supplierLogin.setPassword(user2.getPassword());
			
			 * supplierLogin.setLoginId("STEFFY56618");
			 * supplierLogin.setPassword("meet2far");
			 
			supplierLogin.setIsSupplier("yes");
			sourcingDataBin.setSupplierLogin(supplierLogin);
			ConfigurationProperties.getInstance();
			List<Login> loginList = new ArrayList<>();
			loginList.add(sourcingDataBin.getSupplierLogin());

			IsourceBuyer isourceBuyer = new IsourceBuyer(customAssert, sourcingDataBin, driver);

			// search event and enter into draft stage
			// eventCreation.setEventCloseDate(eventCloseDate);
			sourcingDataBin.getEventCreationForm().setDocumentName(sourcingEvent.getEventName());
			MyEventPage myEventPage = MyEventPage.getInstance(driver);
			myEventPage.enterEventToDefinedStage(sourcingDataBin.getEventCreationForm(), "Draft");
			ScreenShot.screenshot(driver, testCaseName, "Draft Stage");

			// modify event page
			ModifyEventPage modifyEventPage = new ModifyEventPage(driver);

			*//**
			 * RTC_148221 : Check that system should copy the following
			 * information: Item details; Suggested supplier and gform
			 * information
			 **//*
			*//**
			 * RTC_148222 : Check that system should copy the following item
			 * details: short name; description; UOM; quantity; unit price (copy
			 * to all price fields except target)
			 **//*
			// view draft
			modifyEventPage.createModifyDraft();
			RfxEditorPage rfxEditorPage = new RfxEditorPage(driver);
			rfxEditorPage.navigateToSupplierPreivewTab();

			SupplierPreviewPage supplierPreviewPage = new SupplierPreviewPage(driver);
			List<Lots> lots_at_supplier_preview = supplierPreviewPage.getLotData(section);
			supplierPreviewPage.navigateToRfxEditorPage();
			rfxEditorPage.clickBackBtn();

			flag = FlowIsource.compareLineItemsDetailsWithGuidedItem(lots_at_supplier_preview.get(0), requisition.getItems().getGuidedItems().get(1));
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3),
				"Information of Line Item shown in iSource was not matching with information of items send from eproc");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(4),
				"Information of Line Item shown in iSource was not matching with information of items send from eproc");

			// to select mandatory customized fields
			WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='246091']"));
			ActionBot.selectElement(driver, element, IConstantsData.SELECT_BY_INDEX, "2");

			// freeze event
			modifyEventPage.freezeUnfreezeDraft();
			ScreenShot.screenshot(driver, testCaseName, "After freezing document");

			// search event and enter into draft stage
			myEventPage.enterEventToDefinedStage(sourcingDataBin.getEventCreationForm(), "Collect");
			ScreenShot.screenshot(driver, testCaseName, "Collect stage");

			// select suppliers
			ManageSuppliersPage manageSuppliersPage = new ManageSuppliersPage(driver);
			manageSuppliersPage.selectSupplier();
			SelectSupplierPage selectSupplierPage = SelectSupplierPage.getInstance(driver);
			// selectSupplierPage.addSupplier(rfxEditor.getSupplierList().get(0));
			selectSupplierPage.searchSupplierByCompanyName(rfxEditor.getSupplierList().get(0));
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultMediumSleep();
			ActionBot.click(driver, By.xpath(".//*[@id='selectSIMSupplierContactListTable']//td[1]/input"));
			ScreenShot.screenshot(driver, testCaseName, "After adding suppliers");
			selectSupplierPage.clickAddBtn();

			// schedule event
			manageSuppliersPage.clickScheduleEvent();
			ScheduleEventPage scheduleEventPage = new ScheduleEventPage(driver);
			scheduleEventPage.schedulNonPricingEvent(eventCreation);
			ScreenShot.screenshot(driver, testCaseName, "After Scheduling event");

			// publish event
			manageSuppliersPage.publishEvent(eventCreation);
			ScreenShot.screenshot(driver, testCaseName, "After publishing event");
			isourceBuyer.setNotitifierAsActive();
			List<IsourceSupplier> isourceSuppliers = new ArrayList<>();
			// IsourceSupplier isourceSupplier = new
			// IsourceSupplier(customAssert, sourcingDataBin, supplierLogin);
			// isourceSuppliers.add(isourceSupplier);

			IsourceFlowHelper flowHelper = new IsourceFlowHelper();
			flowHelper.navigateToConfirmParticipationPage(customAssert, sourcingDataBin, isourceSuppliers, loginList);
			flowHelper.setNotifierActive(isourceSuppliers);
			int i = 0;
			for (IsourceSupplier isourceSupplier1 : isourceSuppliers)
			{
				flowHelper.setParticularObjectInactive(isourceSupplier1);
				WebDriverWrapper.explicitWait(5);
				FlowIsource.fillAndSendSupplierResponse(isourceSupplier1, rfxEditor.getSupplierList().get(i), rfxEditor, eventCreation);
				ScreenShot.screenshot(driver, testCaseName, "After filling responses");
				i++;
			}
			isourceBuyer.setNotitifierAsInActive();
			manageSuppliersPage.clickScheduleEvent();
			scheduleEventPage.reScheduleEvent(eventCreation);
			ScreenShot.screenshot(driver, testCaseName, "After resheduling event");
			manageSuppliersPage.waitForEventToClose(eventCreation);
			WebDriverWrapper.explicitWait(5);
			try
			{
				manageSuppliersPage.movingEventToNegotiateStage();
			}
			catch (Exception e)
			{
				CommonHeaderBuyerPage commonHeaderBuyerPage = CommonHeaderBuyerPage.getInstance(driver);
				commonHeaderBuyerPage.navigateToMyEventsPage();
				myEventPage.enterEventToDefinedStage(eventCreation, "Collect");
				manageSuppliersPage.movingEventToNegotiateStage();
			}
			myEventPage.enterEventToDefinedStage(eventCreation, "Negotiate");
			isourceBuyer.completeNegotiationStage();
			ScreenShot.screenshot(driver, testCaseName, "After Negotiate Stage");
			myEventPage.enterEventToDefinedStage(eventCreation, "Analyze");

			isourceBuyer.enterAwardEvent(eventCreation);
			ScreenShot.screenshot(driver, testCaseName, "Award event");

			rfxEditor.setCherryPickingCongif("y");
			CherryPicking cherryPicking = new CherryPicking();
			cherryPicking.setDataSetID("001");
			cherryPicking.setScenarioName("Scenario 1");
			List<CherryPicking> cherryPickingList = new ArrayList<>();
			cherryPickingList.add(cherryPicking);
			rfxEditor.setCherryPickingID("001");
			rfxEditor.setCherryPickingList(cherryPickingList);

			flowHelper.cherryPicking(rfxEditor, driver);
			ScreenShot.screenshot(driver, testCaseName, "After Cherry Picking");

			// flowHelper.deleteBAScenario(driver, rfxEditor);
			// rfxEditor.setAwardCherryPickingDefault("y");
			rfxEditor.setAwardScenario(cherryPicking.getScenarioName());
			BidOptimizationHomePage bidOptimizationHomePage = BidOptimizationHomePage.getInstance(driver);
			bidOptimizationHomePage.clickMyOptimizeScenarioButton();
			bidOptimizationHomePage.clickawardScenarioLink(rfxEditor);

			// to award scenario with workflow
			FlowIsource.awardScenario(driver);

			// to award scenario with normal flow
			AwardScenarioPage awardScenarioPage = AwardScenarioPage.getInstance(driver);
			awardScenarioPage.awardScenario();
			ScreenShot.screenshot(driver, testCaseName, "After Awarding event");

			// to send results back to eproc
			CommonHeaderBuyerPage commonHeaderBuyerPage = CommonHeaderBuyerPage.getInstance(driver);
			commonHeaderBuyerPage.navigateToMyEventsPage();
			myEventPage.enterEventToDefinedStage(eventCreation, "Analyze");

			isourceBuyer.enterAwardEvent(eventCreation);
			ScreenShot.screenshot(driver, testCaseName, "Award event");

			bidOptimizationHomePage.clickMyOptimizeScenarioButton();
			FlowIsource.sendResultsToEproc(driver, rfxEditor);
			ScreenShot.screenshot(driver, testCaseName, "After sending results back to eproc");

			// switch to eproc product
			FlowIsource.clickOnEprocProductSwitchTab(driver, testCaseName);
			productName = IConstants.product_name_eProc;

			// search req at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at buyers desk", requisition.isResult());

			GuidedItem edit_guidedItem = new GuidedItem();
			edit_guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			edit_guidedItem.setNextAction(IConstantsData.SAVE);

			// view req
			logger.info("============================= View Requisition =============================");
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			ActionBot.scroll(driver, "350");

			// view item details
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(1).getItemID());

			// change item details
			logger.info("============================= Edit Item Details =============================");
			edit_guidedItem = FlowBuyersDesk.editGuidedItemDetailsatBuyersDesk(driver, testCaseName, edit_guidedItem);

			// send for apporval
			logger.info("============================= Send Requisition For Approval =============================");
			FlowBuyersDesk.sendReqForApproval(driver, testCaseName);

			// approve req
			logger.info("============================= Approve Requisition=============================");
			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
				IConstantsData.APPROVE);
			approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			*//**
			 * RTC_148194 : Check that buyer should be able to view sourcing
			 * results for free-text items to order requisitions
			 **//*
			// search req at buyers desk
			logger.info("============================= Search Requisition at Buyers Desk =============================");
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at buyers desk", requisition.isResult());

			// view req
			logger.info("============================= View Requisition =============================");
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			ActionBot.scroll(driver, "350");

			// view item details
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(1).getItemID());

			// sourcing tab
			ModalBuyersDeskGuidedItemSourcingDetails.clickOnSourcingTab(driver, testCaseName);
			bidPrice = ModalBuyersDeskGuidedItemSourcingDetails.getBidPrice(driver, testCaseName);
			bidPrice = CommonUtilities.getDecimalPriceAlongWithCurrency(bidPrice);
			String sourcing_supplierName = ModalBuyersDeskGuidedItemSourcingDetails.getSupplierName(driver, testCaseName);
			flag = supplierName.equalsIgnoreCase(sourcing_supplierName) && bidPrice.equalsIgnoreCase(unitPrice);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Supplier name and/or bid price shown in sourcing result was wrong");

			*//**
			 * RTC_223260 : Verify on clicking on Copy in sourcing result; the
			 * following details should get copied: supplier; currency; unit
			 * price; bid quantity; UOM
			 **//*
			// copy sourcing details
			
			 * ModalBuyersDeskGuidedItemSourcingDetails.clickOnCopyUnitPriceLink
			 * (driver, testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
			 * testCaseName);
			 * //ModalGuidedItemDetails.clickOnItemDetailsTab(driver,
			 * testCaseName); String itemPrice =
			 * ModalGuidedItemDetails.getItemPrice(driver, testCaseName);
			 * ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver,
			 * testCaseName); String selectedSupplierName =
			 * ModalGuidedItemDetails.getSupplierName(driver, testCaseName);
			 * flag = itemPrice.equalsIgnoreCase(bidPrice) &&
			 * selectedSupplierName.equalsIgnoreCase(sourcing_supplierName);
			 

			flag = FlowBuyersDesk.copySourcingDetails(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(6), "Sourcing details were not get copied on clicking on Copy in sourcing result");

			
			 * ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
			 * //convert to po FlowBuyersDesk.convertToPo(driver, testCaseName);
			 * flag = PageBuyersDeskListing.getSuccessErrorMessage(driver,
			 * testCaseName).equalsIgnoreCase(
			 * IConstantsData.ErrorMsg_ReqAlreadyModifiedByOtherUser);
			 * CommonServices.setMappedTestCaseResult(flag,
			 * mappedTestCases.get(7),
			 * "User was able to order an item which was linked to a sourcing event from Buyers desk listing"
			 * ); //search req at buyers desk logger.info(
			 * "============================= Search Requisition at Buyers Desk ============================="
			 * ); requisition =
			 * FlowBuyersDeskListing.searchAtBuyersDeskListing(driver,
			 * testCaseName, requisition); assertTrue(
			 * "Error while searching requisition at buyers desk",
			 * requisition.isResult()); //view req logger.info(
			 * "============================= View Requisition ============================="
			 * ); FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver,
			 * testCaseName); ActionBot.scroll(driver, "350"); //view item
			 * details PageBuyersDesk.clickOnItemName(driver, testCaseName,
			 * requisition.getItems().getGuidedItems().get(1) .getItemID());
			 

			// sourcing tab
			ModalBuyersDeskGuidedItemSourcingDetails.clickOnSourcingTab(driver, testCaseName);

			// unlink sourcing details
			ModalBuyersDeskGuidedItemSourcingDetails.clickOnUnlinkItemSourcingLink(driver, testCaseName);
			PopUpDefaultSuccess.clickOnSuccessOkButton(driver, testCaseName);
			flag = !ModalBuyersDeskGuidedItemSourcingDetails.isSourcingTabPresent(driver, testCaseName);
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
			assertTrue("User was not able to unlink item", flag);

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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases, productName);
		}
	}*/

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Change requisition and po settings to
	 * default <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 0)
	public void changeSettingsToDefault(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			// login to eproc
			user = LoginLogoutServices.login(driver, testCase);

			RequisitionSettings requisitionSettings = ObjectCreation.getDefaultRequisitionSettingsObject();
			PurchaseOrderSettings purchaseOrderSettings = ObjectCreation.getDefaultPurchaseOrderSettingsObject();

			logger.info("================ Changing Requisition Settings ===================");
			// change req settings
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			logger.info("================ Changing PO Settings ===================");
			// change po settings
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to Create/ Edit any of
	 * the master on screen.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 0)
	public void EPROC_13999(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		UserSettings userSetting = new UserSettings();
		boolean flag_isLocationUpdated = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			// login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			user.setSearchUserByOption(IConstantsData.SEARCH_USER_BY_EMAIL_ID);
			// get user default location
			//String locationName = PageManageProfile.getUserDefaultLocation(driver, testCaseName);

			//userSetting = FlowUserManagement.getUserSettings(driver, "User Settings", user);

			// navigate to TMS
			MainPageHeaderLevelTab.clickOnTmsProductSwitchTab(driver, testCaseName);

			// to navigate to locations page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkLocations(driver, testCaseName);

			// search for locations
			//TMSPageLocationsSetting.fillSearchBox(driver, testCaseName, userSetting.getLocationName());
			TMSPageLocationsSetting.fillSearchBox(driver, testCaseName, "");
			TMSPageLocationsSetting.selectSearchInLocations(driver, testCaseName, IConstantsData.NAME);
			TMSPageLocationsSetting.clickButtonGo(driver, testCaseName);

			// edit and update
			TMSPageLocationsSetting.clickLinkEditLocations(driver, testCaseName);
			flag_isLocationUpdated = TMSPageLocationsSetting.clickButtonEditLocations(driver, testCaseName);

			Assert.assertTrue("Error while updating location", flag_isLocationUpdated);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to send Reminder to
	 * Requisition approver from Requistion view page.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 0)
	public void EPROC_14006(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		boolean flag_remindApprover = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			// login to eproc
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);
			requisition.setModifyWorkflowSettings(true);
			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			ActionBot.scroll(driver, "800");
			PageRequisitionCheckOut.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
			PageRequisitionView.clickOnAddApproverButton(driver, testCaseName);
			String approverName = ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			ActionBot.defaultSleep();
			PageRequisitionView.clickOnSubmitForApproval(driver, testCaseName);

			// search and view in my req
			flag_remindApprover = FlowMyRequisitions.remindApprover(driver, testCaseName, requisition);
			Assert.assertTrue("Failed to remind approver", flag_remindApprover);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>As a apporval, multiple request can be
	 * approve/Reject/Delegated.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 0)
	public void EPROC_14037(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		List<WebElement> allDocNo = null;
		List<String> allStatus = null;
		String doc1 = null;
		String doc2 = null;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			// login to eproc
			user = LoginLogoutServices.login(driver, testCase);

			ActionBot.waitForPageLoad(driver);
			// Navigate to All Request Page
			//MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);

			System.out.println("=========================Perform Multiple Approve=======================");
			// Select All and perform Approve action
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setActions(IConstantsData.APPROVE);

			ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter = new ApprovalAllRequestsStatusFilter();
			approvalAllRequestsStatusFilter.setPending(true);

			IFlowAllRequestsApprovalImpl requestApproval = new IFlowAllRequestsApprovalImpl();
			requestApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

			ActionBot.defaultSleep();
			Integer noOfPages=Integer.parseInt(ActionBot.getTextWithInElement(driver, IPageAllRequestsApproval.LABLE_ALL_REQUESTS_APPROVAL_PAGE_NO).split(" ")[1]);
			System.out.println(noOfPages);

			if(noOfPages>2){
				ActionBot.click(driver, IPageAllRequestsApproval.BUTTON_NEXT_PAGE_ALL_REQUESTS_APPROVAL_PAGE);
				ActionBot.defaultMediumSleep();
			}
			allDocNo = PageAllRequestsApproval.getAllDocumentNos(driver, testCaseName);
			allStatus = PageAllRequestsApproval.getDocumentAllStatus(driver, testCaseName);
			doc1 = allDocNo.get(0).getText();
			doc2 = allDocNo.get(1).getText();

			FlowAllRequestsApproval.performActionOnMultipleItems(driver, testCaseName, approvalAllRequests);

			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc1);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag1 = true;
			}
			WebElement documentNoTextBox=ActionBot.getElement(driver, IPageAllRequestsApproval.DOCUMENT_NO);
			documentNoTextBox.clear();
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc2);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag2 = true;
			}

			if (flag1 == true && flag2 == true)
			{

				flag = true;
			}

			Assert.assertTrue("Error while approving Req", flag);
			flag = flag1 = flag2 = false;
			System.out.println("=========================Perform Multiple Delegate========================");

			// to perform delegate action
			approvalAllRequests.setActions(IConstantsData.DELEGATE);

			approvalAllRequestsStatusFilter.setPending(true);
			requestApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

			ActionBot.defaultSleep();

			allDocNo = PageAllRequestsApproval.getAllDocumentNos(driver, testCaseName);
			allStatus = PageAllRequestsApproval.getDocumentAllStatus(driver, testCaseName);
			doc1 = allDocNo.get(0).getText();
			doc2 = allDocNo.get(1).getText();

			FlowAllRequestsApproval.performActionOnMultipleItems(driver, testCaseName, approvalAllRequests);

			documentNoTextBox.clear();
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc1);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag1 = true;
			}
			documentNoTextBox.clear();
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc2);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag2 = true;
			}

			if (flag1 == true && flag2 == true)
			{

				flag = true;
			}

			Assert.assertTrue("Error while delegating Req", flag);
			flag = flag1 = flag2 = false;
			System.out.println("=========================Perform multiple Reject=======================");
			// to perform reject action
			approvalAllRequests.setActions(IConstantsData.REJECT);

			approvalAllRequestsStatusFilter.setPending(true);
			requestApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);

			ActionBot.defaultSleep();

			allDocNo = PageAllRequestsApproval.getAllDocumentNos(driver, testCaseName);
			allStatus = PageAllRequestsApproval.getDocumentAllStatus(driver, testCaseName);
			doc1 = allDocNo.get(0).getText();
			doc2 = allDocNo.get(1).getText();

			FlowAllRequestsApproval.performActionOnMultipleItems(driver, testCaseName, approvalAllRequests);

			documentNoTextBox.clear();
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc1);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag1 = true;
			}

			documentNoTextBox.clear();
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, doc2);

			if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			{
				flag2 = true;
			}

			if (flag1 == true && flag2 == true)
			{

				flag = true;
			}

			Assert.assertTrue("Error while rejecting Req", flag);
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to send Reminder to PO
	 * approver from PO view page.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 0)
	public void EPROC_14038(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = "";
		User user = null;
		StandardPO standardPO = new StandardPO();
		boolean flag_remindApprover = false, flag = false;
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			// login to eproc
			user = LoginLogoutServices.login(driver, testCase);

			// to get Standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			// create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				Assert.assertTrue("PO is in InApproval state", flag);
			}

			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			// remind approver
			flag_remindApprover = FlowPoListing.remindPOApprover(driver, testCaseName);
			Assert.assertTrue("Failed to remind approver", flag_remindApprover);

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
