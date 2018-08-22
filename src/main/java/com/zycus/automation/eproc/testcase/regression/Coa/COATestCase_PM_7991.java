package com.zycus.automation.eproc.testcase.regression.Coa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.COAMayerBrownDataBO;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.allrequisitionflow.FlowAllRequisition;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.coaflow.COAFlow;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.punchoutflow.FlowPunchout;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;

import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;

import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;

import com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode.PageApprovalDocumentViewMode;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;

import com.zycus.automation.exception.ActionBotException;

import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

public class COATestCase_PM_7991 extends TestDataProvider
{
	static Logger			logger			= Logger.getLogger(COATestCase_PM_7991.class);
	public static String	supplierName	= "Prashant Test";

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Item View On Req View Page for Punchout
	 * Item
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_12_Req_View_Punchout_Item(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		PunchoutItem punchoutItem = new PunchoutItem();
		Requisition requisition = new Requisition();
		Item item = new Item();
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostBookingAndAccountingItemSummaryCOA> coaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		List<PunchoutItem> punchoutItems = new ArrayList<PunchoutItem>();
		User user = new User();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			requisition = ObjectCreation.getRequisition(driver);

			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);

			// punchout item
			punchoutItem = ObjectCreation.getDefaultObjectOfPunchoutItem();
			punchoutItems.add(punchoutItem);
			item.setPunchoutItems(punchoutItems);
			requisition.setItems(item);
			LoginLogoutServices.login(driver, testCase, user);

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

			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			List<Boolean> flagList = FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());

			Assert.assertTrue(!(flagList.contains(false)));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Item View On Req View Page for guided Item
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_13_Req_View_Guided_Item(TestCase testCase) throws Exception
	{

		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
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

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// setting cost booking and accounting summart for COA
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.

			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters

			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req

			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			List<Boolean> flagList = FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());

			Assert.assertTrue(!(flagList.contains(false)));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Sample test case
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_14_Req_View_Catalogue_Item(TestCase testCase) throws Exception
	{
		// Done
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			List<Boolean> flagList = FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());
			Assert.assertTrue(flagList.contains(true));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Item view on Approval Page
	 */

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_17_Approval_View(TestCase testCase) throws Exception
	{
		// Done
		// Cases Covered-->17
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			FlowAllRequestsApproval.SearchAndClickRequisition(driver, testCaseName, requisition.getReqName());
			PageApprovalDocumentViewMode.clickOnViewItemSummaryButton(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			List<Boolean> flagList = COAFlow.verifyCoaFormOnViewPage(driver, testCaseName, itemSummaryCoa.getSplit());
			Assert.assertTrue(flagList.contains(true));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7991_15_Non_Stock_Item(TestCase testCase) throws Exception
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

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.ITEM_MASTER_ITEM);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// setting cost booking and accounting summart for COA
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_29_Pagination_flow(TestCase testCase) throws Exception
	{

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
			// WebDriver driver = DriverSelector.getDriver(testCase);
			WebDriver driver = null;
			driver = DriverSelector.getDriver(testCase);
			// driver.get("https://eproc.eprocdev.zycus.net:7010/eproc/");
			CommonServices.startTestCase(driver, testCase);

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
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.NONE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(13);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);

			//
			requisition.setVerifyWorkflow(false);
			requisition.setCoaAction(IConstantsData.SAVE);

			// requisition.setReqName("OU_1-001/PR/62");

			// login to application
			LoginLogoutServices.login(driver, testCase, user);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			MainPageHeaderLevelTab.clickOnAllRequisitionsSubTab(driver);
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			PageRequisitionView.clickOnViewCoaButton(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			UI_Elements gridSummary = IPageMyRequisition.GRID_ITEM_SUMMARY_MAYER;
			boolean flag = FlowRequisition.checkPaginationFlow(driver, testCaseName, 13, gridSummary);
			Assert.assertTrue(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_34_VersionCompareOnMyRequisition_AfterDeleteOnBuyersDesk(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// from req to buyers desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			requisition.getItemSummaryCoa().setInitialAction(IConstants.Action_Delete);

			List<COAMayerBrownDataBO> versionOneList = FlowRequisition.mayerBrownDataList;

			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			COAFlow.openItemSummaryPopUpOnBuyersDesk(driver, false, testCaseName);

			// requisition.getItemSummaryCoa().setNextAction(IConstants.Action_Save);//For
			// edit
			Thread.sleep(3000);

			FlowRequisition.coaFormActions(driver, testCaseName, requisition);
			requisition.setCoaAction(IConstantsData.SAVE);
			FlowRequisition.fillCOAForm(driver, testCaseName, requisition);
			List<COAMayerBrownDataBO> versionTwoList = FlowRequisition.mayerBrownDataList;

			// View on all requisition
			FlowAllRequisition.searchReqInAllRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			// compare two version on All requisition tab
			boolean flag = COAFlow.compareTwoVersionFromAuditTrail(driver, testCaseName, itemSummaryCoa.getSplit(), versionOneList, versionTwoList);
			Assert.assertTrue(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void TestCase_19_viewItemTableOnBuyersDesk(TestCase testCase)
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			boolean flag = COAFlow.viewCoaFormOnBuyersDesk(driver, testCaseName, false);
			Assert.assertEquals(true, flag);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Item View On Req View Page for Punchout
	 * Item
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_18_Req_View_AllRequisition(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SAVE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowAllRequisition.searchReqInAllRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			List<Boolean> flagList = FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());

			Assert.assertTrue(!(flagList.contains(false)));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7991_22_Req_View_AllRequisition_After_BuyersDesk_Modification1(TestCase testCase) throws Exception
	{
		// All Modification from buyers desk test cases will be done from here.
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		// Map<String, String> map = new HashMap<String, String>();
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// FlowMyRequisitions.viewRequisition(driver, testCaseName);
			List<COAMayerBrownDataBO> versionOneList = FlowRequisition.mayerBrownDataList;
			requisition.getItemSummaryCoa().setInitialAction(IConstants.Action_Delete);
			// requisition.getItemSummaryCoa().setNextAction(IConstants.Action_Save);//For
			// edit
			ActionBot.defaultMediumSleep();
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			COAFlow.openItemSummaryPopUpOnBuyersDesk(driver, false, testCaseName);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);
			requisition.setCoaAction(IConstantsData.SAVE);
			FlowRequisition.fillCOAForm(driver, testCaseName, requisition);

			List<COAMayerBrownDataBO> versionTwoList = FlowRequisition.mayerBrownDataList;

			/*
			 * WebElement okButtonOFItemPopUp = driver.findElement(By.xpath(
			 * "//input[@id='saveRequisitionItemSummary']"));
			 * okButtonOFItemPopUp.click();
			 */
			Thread.sleep(6000);
			WebElement saveButtonBuyersDesk = driver.findElement(By.xpath("//a[@id='saveRequisition']"));
			saveButtonBuyersDesk.click();

			ActionBot.defaultHighSleep();

			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			boolean flag = COAFlow.compareTwoVersionFromAuditTrail(driver, testCaseName, itemSummaryCoa.getSplit(), versionOneList, versionTwoList);
			Assert.assertTrue(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_19_verifyItemTableOnPOAfterReleasedState(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);
			requisition.setVerificationRequiredOnPO(true);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_19_verifyItemTableOnPOAfterAmendPO(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// Step-1-Edit Step at Buyers Desk.
			// Step-2-save the buyers desk form.
			// Step-3-Create Requisition From Buyers Desk.
			// Step-4-Save buyers desk form.
			// Step-5-Create a PO from buyers desk.
			// Step-5-View The req item at PO Page.
			FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA_7991_19_verifyItemTableOnStandardPOFlow(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);
			createRequisition(driver, requisition, testCaseName);
			CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// Step-1-Edit Step at Buyers Desk.
			// Step-2-save the buyers desk form.
			// Step-3-Create Requisition From Buyers Desk.
			// Step-4-Save buyers desk form.
			// Step-5-Create a PO from buyers desk.
			// Step-5-View The req item at PO Page.
			FlowRequisition.verifyCoaFormOnReqView(driver, testCaseName, itemSummaryCoa.getSplit());
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void createRequisition(WebDriver driver, Requisition req, String testCaseName) throws Exception
	{
		WebElement OnlineStoreSearch = driver.findElement(By.xpath("//input[@id='searchTerm']"));
		OnlineStoreSearch.click();
		OnlineStoreSearch.clear();
		OnlineStoreSearch.sendKeys("Table");

		WebElement searchButton = driver.findElement(By.xpath("//input[@id='btnBigSearch']"));
		searchButton.click();

		Thread.sleep(3000);

		WebElement checkBox = driver.findElement(By.xpath("(//input[@class='chk chkItemList'])[1]"));
		checkBox.click();

		WebElement addToCart = driver.findElement(By.xpath("html/body/div[1]/div[5]/div/a[2]/span"));
		addToCart.click();
		Thread.sleep(5000);
		WebElement checkOutButton = driver.findElement(By.xpath("html/body/div[1]/div[6]/div[1]/div[4]/div[1]/div[1]/a/span"));
		checkOutButton.click();

		WebElement reqName = driver.findElement(By.xpath("//input[@id='txtRequisitionName']"));
		reqName.click();
		reqName.clear();
		reqName.sendKeys(req.getReqName());

		Select purchaseType = new Select(driver.findElement(By.id("selPurchaseType")));
		purchaseType.selectByVisibleText("Journal");

		WebElement datePicker = driver.findElement(By.xpath("html/body/div[1]/div[14]/div[1]/form/div[11]/div[1]/table/tbody/tr/td[1]/div[2]/div/img"));
		datePicker.click();
		Thread.sleep(3000);
		WebElement dateSelect = driver.findElement(By.xpath("//a[@href='#'][contains(text(),'31')]"));
		dateSelect.click();

		WebElement expandAll = driver.findElement(By.xpath("//a[contains(text(),'Expand All')]"));
		expandAll.click();

		WebElement editElement = driver
			.findElement(By.xpath("//a[@class='icon scLnk splitItemToMultipleIconPos splitToMultiple itemCOAsplitchange itemsplitchange'][contains(text(),'Edit')]"));
		editElement.click();

		ModelItemSummaryCostBooking.getQuantityFromItemSummary(driver, testCaseName);

		// FlowRequisition.fillCOAForm(driver, testCaseName, req);
		// FlowRequisition.submitReq(driver, testCaseName, false);

	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void add1PunchoutItemAndSubmitRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		PunchoutItem punchoutItem = new PunchoutItem();
		Requisition requisition = new Requisition();
		Item item = new Item();
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostBookingAndAccountingItemSummaryCOA> coaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		List<PunchoutItem> punchoutItems = new ArrayList<PunchoutItem>();
		User user = new User();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			requisition = ObjectCreation.getRequisition(driver);

			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);

			// punchout item
			punchoutItem = ObjectCreation.getDefaultObjectOfPunchoutItem();
			punchoutItems.add(punchoutItem);
			item.setPunchoutItems(punchoutItems);
			requisition.setItems(item);
			LoginLogoutServices.login(driver, testCase, user);

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

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createFreeTextItemFromBuyersDesk(TestCase testCase)
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			List<COAMayerBrownDataBO> reqMayerDataList = FlowRequisition.mayerBrownDataList;

			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			BuyersDesk buyersDesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersDesk);

			COAFlow.openItemSummaryPopUpOnBuyersDesk(driver, true, testCaseName);
			FlowRequisition.fillCOAForm(driver, testCaseName, requisition);
			List<COAMayerBrownDataBO> buyersDeskDataList = FlowRequisition.mayerBrownDataList;
			COAFlow.clickOnOkButtonOfCoaForm(driver);
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			// Requisition View Page.

			MainPageHeaderLevelTab.clickOnAllRequisitionsSubTab(driver);
			FlowAllRequisition.searchReqInAllRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			COAFlow.viewMultipleItemsOnReqViewPage(driver, testCaseName, reqMayerDataList, buyersDeskDataList);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createPunchoutItemOnBuyersDesk(TestCase testCase)
	{
		boolean flag = false;
		String status = null;

		PunchoutItem punchoutItem = new PunchoutItem();
		List<PunchoutItem> punchoutItems = new ArrayList<PunchoutItem>();
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
			accountingItemSummary.setNextAction(IConstantsData.SAVE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(1);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.SAVE);

			requisition.setVerificationRequiredOnPO(true);
			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			List<COAMayerBrownDataBO> reqMayerDataList = FlowRequisition.mayerBrownDataList;

			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			punchoutItem = ObjectCreation.getDefaultObjectOfPunchoutItem();
			punchoutItems.add(punchoutItem);
			item.setPunchoutItems(punchoutItems);

			FlowBuyersDesk.createPunchoutItemFromBuyersDesk(driver, testCaseName, punchoutItem);

			COAFlow.openItemSummaryPopUpOnBuyersDesk(driver, true, testCaseName);
			FlowRequisition.fillCOAForm(driver, testCaseName, requisition);
			List<COAMayerBrownDataBO> buyersDeskDataList = FlowRequisition.mayerBrownDataList;
			COAFlow.clickOnOkButtonOfCoaForm(driver);

			// Return to requester flow
			FlowBuyersDesk.returnReqWithQuote(driver, testCaseName);
			// Requisition viewFlo Flow
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			FlowAllRequisition.searchReqInAllRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);
			WebElement submitButton = driver.findElement(By.xpath("//a[@class='fR b-button b-final submitGroup btnPrimaryAction'][contains(text(),'Submit')]"));
			submitButton.click();
			ActionBot.defaultHighSleep();
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
				IConstantsData.APPROVE);

			approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			requisition.setPurchaseOrdersList(purchaseOrders);

			for (PurchaseOrder purchaseOrder : purchaseOrders)
			{
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("PO was not created against requisition", flag);

				if (requisition.isVerificationRequiredOnPO() == true)
				{
					FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
					WebElement actionlink = driver.findElement(By.xpath("(//a[@class='icon actLnk'])[1]"));
					actionlink.click();

					WebElement releaseLink = driver.findElement(By.xpath("//a[@class='scLnk icon releasepo']"));
					releaseLink.click();

					WebElement releasePoButton = driver.findElement(By.xpath("//span[@class='ui-button-text'][contains(text(),'Release PO')]"));
					releasePoButton.click();

					FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

					PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
					List<COAMayerBrownDataBO> mayerDataList = COAFlow.viewCoaDataFromPOPage(driver);
					List<COAMayerBrownDataBO> enteredData = FlowRequisition.mayerBrownDataList;
					List<Boolean> flagList = COAFlow.compareTwoObject(enteredData, mayerDataList);

					for (COAMayerBrownDataBO mayerData : mayerDataList)
					{
						System.out.println(mayerData.getBookCostTo() + "--" + mayerData.getClient() + "---" + mayerData.getDepartment());
					}
				}
				else
				{
					assertTrue("Error while searching PO created against requisition", flag);
					// check status
					flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
					assertTrue("Status of PO was not Released", flag);
				}

			}

		}
		catch (

		Exception e)
		{
			e.printStackTrace();
		}
	}
}
