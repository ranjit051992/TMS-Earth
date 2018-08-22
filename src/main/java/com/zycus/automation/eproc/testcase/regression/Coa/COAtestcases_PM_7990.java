package com.zycus.automation.eproc.testcase.regression.Coa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverException;

import org.testng.Assert;

import org.testng.annotations.Test;

// import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;

import com.zycus.automation.constants.IConstants;

import com.zycus.automation.boutils.MappedTestCaseUtil;

import com.zycus.automation.datacreation.ObjectCreation;

import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.IFlowMyRequisitionUtil;

import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;

import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.ModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

/**
 * <b>Author: kunal.ashar </b>
 */
public class COAtestcases_PM_7990 extends TestDataProvider
{
	static Logger		logger				= Logger.getLogger(COAtestcases_PM_7990.class);
	final static String	guidedItemSupplier	= "AMAZON";										// setup specific Supplier.

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Sample test case to verify created flows.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void testCOA(TestCase testCase) throws Exception
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
			accountingItemSummary.setNextAction(IConstantsData.NONE);
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

			// adding parameters for req creation
			requisition.setCostBookingItemSummary(null);
			requisition.setEditHeaderLevelInfo(false);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);
			//requisition.setPurchaseType("Mixed");
			requisition.setAssignedBuyer(user.getUsername());

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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
	 * <font color="blue">Description :</b>[Split by Percentage] Amount should
	 * be automatically calculated in the Final Amount field based on the added
	 * split.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_9(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_9 = false;
		boolean PM_7990_10 = false;
		boolean PM_7990_11 = false;
		boolean PM_7990_19 = false;
		boolean PM_7990_20 = false;
		boolean PM_7990_21 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_10"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_11"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_19"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_25"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_20"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_21"));
			}
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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			//requisition.setPurchaseType("Mixed");
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PM_7990_9 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_9, "Final amount not calculated properly based on " + itemSummaryCoa.getSplitBy());

			/** TC: PM_7990_10 **/
			// to verify Item Total amount vs Total Final amount of all splits
			double totalAmountCalculated = itemSummaryCoa.getFinalUIAmount();
			double totalItemAmount = ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver, testCaseName);

			PM_7990_10 = totalAmountCalculated == totalItemAmount;
			Assert.assertTrue(PM_7990_10, "Final amount calculated did not match with Item Total Amount");

			//to save item summary split
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);

			/** TC: PM_7990_11 **/
			// update quantity and verify updated price calculation
			int updatedQuantity = CommonUtilities.getNonZeroRandomNumbers(4);
			PageRequisitionCheckOut.fillItemQuantity(driver, testCaseName, updatedQuantity, item.getCatelogItems().get(0).getItemID());

			//to open itemsummary popup
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);

			PM_7990_11 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_11, "Final amount not calculated properly after quantity is updated");

			// to save item summary and to submit req
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// Navigate to Buyers Desk and return requisition
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// to return req from buyers desk
			PM_7990_19 = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			Assert.assertTrue(PM_7990_19, "Requisition was not returned");

			/** TC: PM_7990_20 **/
			// Navigate to My Req Page and open Req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// verifying COA form
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);

			int updatedQuantity2 = CommonUtilities.getNonZeroRandomNumbers(4);
			ModelItemSummaryCostBooking.updateQuantityFromItemSummary(driver, testCaseName, updatedQuantity2);
			PM_7990_20 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_20, "Final amount not calculated properly after quantity is updated on My Req page");

			/** TC: PM_7990_21 **/
			// to verify error msg after deleting split
			itemSummaryCoa.setCoaEdit(true);
			itemSummaryCoa.setSplit(1);// to delete only first entry
			itemSummaryCoa.setInitialAction(IConstants.Action_Delete);
			requisition.setCoaAction(IConstantsData.SAVE);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);

			ActionBot.waitForPageLoad(driver);
			String errorMessage = ModelItemSummaryCostBooking.getErrorMessage_CoaForm(driver, testCaseName);

			if (!(errorMessage == null))
			{
				PM_7990_21 = errorMessage.equalsIgnoreCase(PropertyReader.messageProperty.getProperty("ErrorMsg_TotalPercentage"));
			}
			Assert.assertTrue(PM_7990_21, "Expected error message not displayed. Message: " + errorMessage);

			mappedTestCases.get(0).setTestResult(PM_7990_10);
			mappedTestCases.get(1).setTestResult(PM_7990_11);
			mappedTestCases.get(2).setTestResult(PM_7990_19);
			mappedTestCases.get(3).setTestResult(PM_7990_9);
			mappedTestCases.get(4).setTestResult(PM_7990_20);
			mappedTestCases.get(5).setTestResult(PM_7990_21);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage] Amount should
	 * be automatically calculated in the Final Amount field based on the added
	 * split.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_23(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_23 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);
			item.getGuidedItems().get(0).setZeroPriceItem(true);

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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(5);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			requisition.getItemSummaryCoa().setQuantity(requisition.getItems().getGuidedItems().get(0).getQuantity() + "");
			PM_7990_23 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_23, "Final amount not calculated properly for Zero Price Item based on " + itemSummaryCoa.getSplitBy());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]Final amount
	 * should be shown zero when user add zero price item with Receive/Bill by =
	 * Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_24(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_24 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Amount);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);
			item.getGuidedItems().get(0).setZeroPriceItem(true);

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
			requisition.setNextAction(IConstantsData.SUBMIT);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(5);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PM_7990_24 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_24, "Final amount not calculated properly for Zero Price Item based on " + itemSummaryCoa.getSplitBy());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully with non stock item splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_28(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_28 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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
			accountingItemSummary.setNextAction(IConstantsData.NONE);
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
			itemSummaryCoa.setSplit(5);
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

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_28 = requisition.isResult();
			Assert.assertTrue(PM_7990_28, "Requisition not submitted with Non Stock Item");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully for guided item with sourcing status Need A Quote
	 * splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_29(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_29 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.NEED_A_QUOTE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_29 = requisition.isResult();
			Assert.assertTrue(PM_7990_29, "Requisition not submitted for guided item with sourcing status Need A Quote");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully for guided item with sourcing status Estimated
	 * Price splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_30(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_30 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.ESTIMATED_PRICE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_30 = requisition.isResult();
			Assert.assertTrue(PM_7990_30, "Requisition not submitted for guided item with sourcing status  Estimated Price");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully for guided item with sourcing status Quoted By
	 * Supplier splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_31(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_31 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.QUOTED_BY_SUPPLIER);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_31 = requisition.isResult();
			Assert.assertTrue(PM_7990_31, "Requisition not submitted for guided item with sourcing status Quoted By Supplier");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully for guided item with sourcing status Quoted By
	 * Supplier splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_33(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_33 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to search created req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			// to copy req
			FlowMyRequisitions.copyReq(driver, testCaseName, false);

			// to change req name
			requisition.setReqName(CommonUtilities.getReqName());
			requisition.setReqNo(null);
			PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());

			// to submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_33 = requisition.isResult();
			Assert.assertTrue(PM_7990_33, "Error while Searching copied Requisition");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]Verify Final Amount
	 * of all split should be matched with the Total Price of the item
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_46(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_46 = false;
		boolean PM_7990_47 = false;
		boolean PM_7990_49 = false;
		boolean PM_7990_54 = false;
		boolean PM_7990_55 = false;
		boolean PM_7990_56 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_47"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_49"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_54"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_55"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_56"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_60"));
			}
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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(2);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PM_7990_46 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_46, "Final amount not calculated properly based on " + itemSummaryCoa.getSplitBy());

			/** TC: PM_7990_47 **/
			// to verify Item Total amount vs Total Final amount of all splits
			double totalAmountCalculated = itemSummaryCoa.getFinalUIAmount();
			double totalItemAmount = ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver, testCaseName);

			PM_7990_47 = totalAmountCalculated == totalItemAmount;
			Assert.assertTrue(PM_7990_47, "Final amount calculated did not match with Item Total Amount");

			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// Navigate to Buyers Desk and return requisition
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// to return req from buyers desk
			PM_7990_54 = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			Assert.assertTrue(PM_7990_54, "Requisition was not returned");

			/** TC: PM_7990_20 **/
			// Navigate to My Req Page and open Req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// verifying COA form
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);
			//
			//			int updatedQuantity2 = CommonUtilities.getNonZeroRandomNumbers(4);
			//			ModelItemSummaryCostBooking.updateQuantityFromItemSummary(driver, testCaseName, updatedQuantity2);
			//			PM_7990_55 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			//			Assert.assertTrue(PM_7990_55, "Final amount not calculated properly after quantity is updated on My Req page");

			/** TC: PM_7990_21 **/
			// to verify error msg after deleting split
			itemSummaryCoa.setCoaEdit(true);
			itemSummaryCoa.setSplit(1);// to delete only first entry
			itemSummaryCoa.setInitialAction(IConstants.Action_Delete);
			requisition.setCoaAction(IConstantsData.SAVE);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);

			String errorMessage = ModelItemSummaryCostBooking.getErrorMessage_CoaForm(driver, testCaseName);

			if (!(errorMessage == null))
			{
				PM_7990_56 = errorMessage.equalsIgnoreCase(PropertyReader.messageProperty.getProperty("ErrorMsg_TotalAmount"));
			}
			Assert.assertTrue(PM_7990_56, "Expected error message not displayed. Message: " + errorMessage);

			mappedTestCases.get(0).setTestResult(PM_7990_47);
			mappedTestCases.get(1).setTestResult(PM_7990_56);
			mappedTestCases.get(2).setTestResult(PM_7990_54);
			mappedTestCases.get(3).setTestResult(PM_7990_56);
			mappedTestCases.get(4).setTestResult(PM_7990_56);
			mappedTestCases.get(5).setTestResult(PM_7990_46);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage] Amount should
	 * be automatically calculated in the Final Amount field based on the added
	 * split.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_59(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_59 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Amount);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);
			item.getGuidedItems().get(0).setZeroPriceItem(true);

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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(5);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);

			if (itemSummaryCoa.getFinalUIAmount() == 0)
			{
				PM_7990_59 = true;
			}
			Assert.assertTrue(PM_7990_59, "Final amount not calculated properly for Zero Price Item based on " + itemSummaryCoa.getSplitBy());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]User should to submit req successfully with Catalog item splatted by Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_60(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_60 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(2);
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

			//search created req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_60 = requisition.isResult();
			Assert.assertTrue(PM_7990_60, "Error while searching requisiton " + requisition.getReqNo());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]User should to
	 * submit req successfully with non stock item splatted by percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_63(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_63 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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
			accountingItemSummary.setNextAction(IConstantsData.NONE);
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
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_63 = requisition.isResult();
			Assert.assertTrue(PM_7990_63, "Requisition not submitted with Non Stock Item");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]User should to submit req successfully for guided item with sourcing status Need A Quote splatted by Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_64(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_64 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.NEED_A_QUOTE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_64 = requisition.isResult();
			Assert.assertTrue(PM_7990_64, "Requisition not submitted for guided item with sourcing status Need A Quote");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]User should to submit req successfully for guided item with sourcing status Estimated Price splatted by Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_65(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_65 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.ESTIMATED_PRICE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(5);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_65 = requisition.isResult();
			Assert.assertTrue(PM_7990_65, "Requisition not submitted for guided item with sourcing status Estimated Price");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]User should to submit req successfully for guided item with sourcing status Quoted By Supplier splatted by Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_66(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_66 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.QUOTED_BY_SUPPLIER);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_66 = requisition.isResult();
			Assert.assertTrue(PM_7990_66, "Requisition not submitted for guided item with sourcing status Quoted By Supplier");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]All added split by Amount should be copied successfully and saved when user copy any req having cost split by Amount.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_68(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_68 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.AMOUNT);
			itemSummaryCoa.setSplit(2);
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

			// to search created req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			// to copy req
			FlowMyRequisitions.copyReq(driver, testCaseName, false);

			// to change req name
			requisition.setReqName(CommonUtilities.getReqName());
			requisition.setReqNo(null);
			PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());

			// to submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_68 = requisition.isResult();
			Assert.assertTrue(PM_7990_68, "Error while Searching copied Requisition");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]Verify Final Amount of all split should be matched with the Total Price of the item
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_81(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_81 = false;
		boolean PM_7990_83 = false;
		boolean PM_7990_82 = false;
		boolean PM_7990_89 = false;
		boolean PM_7990_90 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_83"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_82"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_89"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_90"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("PM_7990_94"));
			}
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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(2);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PM_7990_81 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_81, "Final amount not calculated properly based on " + itemSummaryCoa.getSplitBy());

			/** TC: PM_7990_83 **/
			// to verify Item Total amount vs Total Final amount of all splits
			double totalAmountCalculated = itemSummaryCoa.getFinalUIAmount();
			double totalItemAmount = ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver, testCaseName);

			PM_7990_83 = totalAmountCalculated == totalItemAmount;
			Assert.assertTrue(PM_7990_83, "Final amount calculated did not match with Item Total Amount");

			//to save item summary split
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);

			/** TC: PM_7990_82 **/
			// update quantity and verify updated price calculation
			int updatedQuantity = CommonUtilities.getNonZeroRandomNumbers(4);
			PageRequisitionCheckOut.fillItemQuantity(driver, testCaseName, updatedQuantity, item.getCatelogItems().get(0).getItemID());

			//to open itemsummary popup
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);

			//to delete all entry
			itemSummaryCoa.setInitialAction(IConstants.Action_Delete);
			requisition.setCoaAction(IConstantsData.NONE);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);

			//add new values with updated quantity
			FlowRequisition.fillCOAForm(driver, testCaseName, requisition);

			//verify final amount as per updated quantity
			PM_7990_82 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_82, "Final amount not calculated properly after quantity is updated");

			// to save item summary and to submit req
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

			// to approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// Navigate to Buyers Desk and return requisition
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// to return req from buyers desk
			PM_7990_89 = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			Assert.assertTrue(PM_7990_89, "Requisition was not returned");

			/** TC: PM_7990_89 **/
			// Navigate to My Req Page and open Req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			// verifying COA form
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);

			int updatedQuantity2 = CommonUtilities.getNonZeroRandomNumbers(4);
			ModelItemSummaryCostBooking.updateQuantityFromItemSummary(driver, testCaseName, updatedQuantity2);
			PM_7990_89 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_89, "Final amount not calculated properly after quantity is updated on My Req page");

			/** TC: PM_7990_21 **/
			// to verify error msg after deleting split
			itemSummaryCoa.setCoaEdit(true);
			itemSummaryCoa.setSplit(1);// to delete only first entry
			itemSummaryCoa.setInitialAction(IConstants.Action_Delete);
			requisition.setCoaAction(IConstantsData.SAVE);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);

			String errorMessage = ModelItemSummaryCostBooking.getErrorMessage_CoaForm(driver, testCaseName);

			if (!(errorMessage == null))
			{
				PM_7990_90 = errorMessage.equalsIgnoreCase(PropertyReader.messageProperty.getProperty("ErrorMsg_TotalQuantity"));
			}
			Assert.assertTrue(PM_7990_90, "Expected error message not displayed. Message: " + errorMessage);

			mappedTestCases.get(0).setTestResult(PM_7990_83);
			mappedTestCases.get(1).setTestResult(PM_7990_82);
			mappedTestCases.get(2).setTestResult(PM_7990_89);
			mappedTestCases.get(3).setTestResult(PM_7990_90);
			mappedTestCases.get(4).setTestResult(PM_7990_81);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]Validation message should be shown if user delete any filled splitting details from the req when Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_84(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_84 = false;
		int initialSplit = 2;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(initialSplit);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//to delete one row to verify error message
			itemSummaryCoa.setSplit(1);// to delete only first entry
			itemSummaryCoa.setInitialAction(IConstants.Action_Delete);
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setCoaAction(IConstantsData.SAVE);
			FlowRequisition.coaFormActions(driver, testCaseName, requisition);

			String errorMessage = ModelItemSummaryCostBooking.getErrorMessage_CoaForm(driver, testCaseName);

			if (!(errorMessage == null))
			{
				PM_7990_84 = errorMessage.equalsIgnoreCase(PropertyReader.messageProperty.getProperty("ErrorMsg_TotalQuantity"));
			}
			Assert.assertTrue(PM_7990_84, "Expected error message not displayed. Message: " + errorMessage);

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]Final amount should be shown zero when user add zero price item with Receive/Bill by = Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_92(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_92 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);
			item.getGuidedItems().get(0).setZeroPriceItem(true);

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
			requisition.setNextAction(IConstantsData.NONE);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(2);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount			
			PM_7990_92 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_92, "Final amount not calculated properly for Zero Price Item based on " + itemSummaryCoa.getSplitBy());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]Final amount should be shown zero when user add zero price item with Receive/Bill by = Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_93(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_93 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Amount);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);
			item.getGuidedItems().get(0).setZeroPriceItem(true);

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
			requisition.setNextAction(IConstantsData.SUBMIT);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
			requisition.setEditCOAInfo(true);
			requisition.setCoaDataList(coaBO);
			itemSummaryCoa.setTotalRows(coaBO.size());
			requisition.setItemSummaryCoa(itemSummaryCoa);
			requisition.setAssignedBuyer(user.getUsername());
			requisition.setCoaAction(IConstantsData.NONE);

			// login to application
			LoginLogoutServices.login(driver, testCase, user);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to verify calculated final amount
			PM_7990_93 = PageRequisitionCheckOut.verifyFinalAmountGenerated_COA(driver, testCaseName, itemSummaryCoa);
			Assert.assertTrue(PM_7990_93, "Final amount not calculated properly for Zero Price Item based on " + itemSummaryCoa.getSplitBy());

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]User should to submit req successfully with non stock item when Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_97(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_97 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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
			accountingItemSummary.setNextAction(IConstantsData.NONE);
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
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(5);
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

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_97 = requisition.isResult();
			Assert.assertTrue(PM_7990_97, "Requisition not submitted with Non Stock Item");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]User should to submit req successfully for guided item with sourcing status Need A Quote when Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_98(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_98 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.NEED_A_QUOTE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_98 = requisition.isResult();
			Assert.assertTrue(PM_7990_98, "Requisition not submitted for guided item with sourcing status Need A Quote");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]User should to submit req successfully for guided item with sourcing status Estimated Price when Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_99(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_99 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.ESTIMATED_PRICE);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_99 = requisition.isResult();
			Assert.assertTrue(PM_7990_99, "Requisition not submitted for guided item with sourcing status  Estimated Price");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]User should to submit req successfully for guided item with sourcing status Quoted By Supplier when Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_100(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_100 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setReceiveBy(IConstantsData.Quantity);
			item.getGuidedItems().get(0).setSourcingStatus(IConstantsData.QUOTED_BY_SUPPLIER);
			item.getGuidedItems().get(0).setSupplierNameInSuppInfo(guidedItemSupplier);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(2);
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

			// to verify calculated final amount
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_100 = requisition.isResult();
			Assert.assertTrue(PM_7990_100, "Requisition not submitted for guided item with sourcing status Quoted By Supplier");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]All added split by Quantity should be copied successfully and saved when user copy any req having Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_102(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		boolean PM_7990_102 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(2);
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

			// to search created req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			// to copy req
			FlowMyRequisitions.copyReq(driver, testCaseName, false);

			// to change req name
			requisition.setReqName(CommonUtilities.getReqName());
			requisition.setReqNo(null);
			PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());

			// to submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			// search req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PM_7990_102 = requisition.isRequired();
			Assert.assertTrue(PM_7990_102, "Error while copying req.");

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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Quantity]Req should be saved successfully having splits more than 150 with Split by Quantity
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_112(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			logger.info("\nTestcase >>" + testCaseName + " started for COA");
			// to read coa data and to store it in BO
			coaBO = ExcelReader.readCoaExcelData(IConstantsData.COA_SHEET_VALID);

			// to login with custom COA user
			user.setUsername(ConfigProperty.getConfig("coaUsername"));
			user.setPassword(ConfigProperty.getConfig("coaPassword"));

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			item.getCatelogItems().get(0).setQuantity(200);

			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setReqName("QuantitySplit-150");

			// setting cost booking and accounting summart for COA
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			accountingItemSummary.setNextAction(IConstantsData.NONE);
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
			itemSummaryCoa.setSplitBy(IConstantsData.Quantity);
			itemSummaryCoa.setSplit(150);
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

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Amount]Req should be saved successfully having splits more than 150 with Split by Amount
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_113(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.Amount);
			itemSummaryCoa.setSplit(150);
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

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Description :</b>[Split by Percentage]Req should be saved successfully having splits more than 150 with Split by Percentage
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void PM_7990_114(TestCase testCase) throws Exception
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
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
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

			// to ignore workflow setting.
			requisition.setVerifyWorkflow(false);
			requisition.setModifyWorkflowSettings(false);

			// adding COA related parameters
			CostBookingAndAccountingItemSummaryCOA itemSummaryCoa = new CostBookingAndAccountingItemSummaryCOA();
			itemSummaryCoa.setSplitBy(IConstantsData.PERCENTAGE);
			itemSummaryCoa.setPercentage("100");
			itemSummaryCoa.setSplit(100);
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

			// to search req in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());
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
}
