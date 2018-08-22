package com.zycus.automation.eproc.testcase.regression.requistionForking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.requisitionsettingsflow.FlowRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.ModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.requisitionForking.PageRequisitionForking;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class RequisitionForkingTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(RequisitionForkingTestCases.class);

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 07-Sep-2015 </b> <b>Method :
	 * RTC_239441 <b>Description : Test for bug 217806 - Incorrect requisition
	 * numbering displayed for forked requisitions </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_239441(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251744"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251745"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251947"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251948"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289820"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289821"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289823"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289824"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289825"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		defaultRequisitionSettings.setEnableReqForking(false);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object and change forking setting i.e. to
			// enable forking
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(false);
			requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.REQUIRED);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create req with multiple items
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.BOTH);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			String str = PageRequisitionCheckOut.getTextOfSubmitButton(driver, testCaseName);
			boolean submit = str.equalsIgnoreCase("Continue");
			Assert.assertTrue("I AM DONE button of submit is not changed to Continue", submit);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);

			// check PR's on forking screen
			/*
			 * List<String> pr =
			 * PageRequisitionForking.getListOfPRNumbersOnForkingScreen(driver,
			 * testCaseName); boolean flag =
			 * pr.get(0).equalsIgnoreCase(requisition.getReqNo() + "-1") &&
			 * pr.get(1).equals(requisition.getReqNo() + "-2");
			 * Assert.assertTrue("PR numbers generated are wrong", flag);
			 */

			// check alert message for submitting reqs
			String str1 = PageRequisitionForking.getAlertMessageForSubmittingForkedReqs(driver, testCaseName);
			boolean message = str1.equalsIgnoreCase(IConstantsData.SUBMITTING_REQS_ON_FORKING_SCREEN_ALERT_MESSAGE);
			Assert.assertTrue("Alert message info is wrong", message);

			// check workflow settings for 1st req
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 0);
			boolean workflow1 = PageRequisitionForking.isModifyWorkflowSettingsPresent(driver, testCaseName);
			Assert.assertTrue("Modify workflow setting is not present for req1", !workflow1);
			mappedTestCases.get(4).setTestResult(workflow1);
			mappedTestCases.get(8).setTestResult(workflow1);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 0);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnCancelApprovalWorkflow(driver, testCaseName);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 0);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);

			// check workflow settings for 2nd req
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 1);
			boolean workflow2 = PageRequisitionForking.isModifyWorkflowSettingsPresent(driver, testCaseName);
			Assert.assertTrue("Modify workflow setting is not present for req2", !workflow2);
			mappedTestCases.get(5).setTestResult(workflow2);
			mappedTestCases.get(6).setTestResult(workflow2);
			mappedTestCases.get(7).setTestResult(workflow2);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 1);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);

			// get req nos
			String req1 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 0);
			String req2 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 1);

			// save reqs in draft
			PageRequisitionForking.clickDraft(driver, testCaseName, 0);
			PageRequisitionForking.clickDraft(driver, testCaseName, 1);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

			// edit req1 and change assigned buyer
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, req1);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickOnRemoveAssignedBuyer(driver, testCaseName);
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, "Payal");
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

			// edit req2 and change assigned buyer
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, req2);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickOnRemoveAssignedBuyer(driver, testCaseName);
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, "Payal");
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

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
				RequisitionSettings req = new RequisitionSettings();
				req.setEnableReqForking(false);
				req.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
				req = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, req);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting spilt req changes" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 08-Sep-2015 </b> <b>Method :
	 * RTC_251748 <b>Description : Requisition>Assigned Buyer: In case 'Assigned
	 * Buyer' field is empty and requisition is in ready for approval state;
	 * workflow prediction should display the 'Buyer' icon with 'Assign buyer'
	 * link below it </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_251748(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251749"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251752"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268978"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251747"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251841"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251750"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		defaultRequisitionSettings.setEnableReqForking(false);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object and change forking setting i.e. to
			// enable forking
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(false);
			requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.REQUIRED);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create req with multiple items
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.BOTH);
			requisition.setItems(item);
			requisition.setAssignedBuyer(null);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);

			// check PR's on forking screen
			/*
			 * List<String> pr =
			 * PageRequisitionForking.getListOfPRNumbersOnForkingScreen(driver,
			 * testCaseName); boolean flag =
			 * pr.get(0).equalsIgnoreCase(requisition.getReqNo() + "-1") &&
			 * pr.get(1).equals(requisition.getReqNo() + "-2");
			 * Assert.assertTrue("PR numbers generated are wrong", flag);
			 */

			// submit reqs
			String req1 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 0);
			String req2 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 1);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 0);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 1);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

			// edit req1 and add assigned buyer
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, req1);

			// check status of req
			String str = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean status = str.equalsIgnoreCase("Ready For Approval");
			Assert.assertTrue("Status of req is not as expected i.e. Ready for approval", status);

			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionView.getAssignBuyerField(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");

			/*
			 * //add assigned buyer without buyer role and check error
			 * PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
			 * PageRequisitionView.fillAssignBuyerField(driver, testCaseName,
			 * "payal10@zycus.com");
			 * PageRequisitionView.clickOnSaveAssignBuyer(driver, testCaseName);
			 * PageRequisitionView.clickOnSubmitForApproval(driver,
			 * testCaseName); boolean buyerAlert =
			 * PageRequisitionCheckOut.isValidationAlertPopupPresent(driver,
			 * testCaseName); Assert.assertTrue(
			 * "Error for assigned buyer who does not have buyer role is not present"
			 * , buyerAlert); mappedTestCases.get(3).setTestResult(status);
			 * mappedTestCases.get(5).setTestResult(buyerAlert);
			 */

			// add assigned buyer
			PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
			// PageRequisitionView.clickOnRemoveAssignBuyerbtn(driver,
			// testCaseName);
			PageRequisitionView.fillAssignBuyerField(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			PageRequisitionView.clickOnSaveAssignBuyer(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,950)", "");
			String newBuyer = PageRequisitionView.getAssignBuyerField(driver, testCaseName);

			// check whether assigned buyer has changed or not
			boolean buyer = newBuyer.equals(CommonServices.getTestData(IConstantsData.BUYER_NAME)) ? true : false;
			Assert.assertTrue("Buyer name has changed after changng buyer from assigned buyer link", !buyer);
			mappedTestCases.get(0).setTestResult(!buyer);
			mappedTestCases.get(1).setTestResult(!buyer);
			jsx.executeScript("window.scrollBy(0,950)", "");

			// change assign buyer
			PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
			PageRequisitionView.fillAssignBuyerField(driver, testCaseName, "Amit");
			PageRequisitionView.clickOnSaveAssignBuyer(driver, testCaseName);
			String buyers = PageRequisitionView.getAssignBuyerField(driver, testCaseName);

			// check whether buyer has changed to MULTIPLE after selecting many
			// buyers
			boolean multipleBuyers = buyers.equalsIgnoreCase("Multiple") ? true : false;
			Assert.assertTrue("After adding multiple buyers, Assigned buyer has not changed to multiple", multipleBuyers);
			mappedTestCases.get(2).setTestResult(multipleBuyers);
			mappedTestCases.get(4).setTestResult(multipleBuyers);
			PageRequisitionView.clickOnSubmitForApproval(driver, testCaseName);

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

				RequisitionSettings req = new RequisitionSettings();
				req.setEnableReqForking(false);
				req.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
				req = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, req);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting spilt req changes" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}

		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 08-Sep-2015 </b> <b>Method :
	 * RTC_251963 <b>Description : Test for bug 219544 - Confirmation for need a
	 * quote item is displayed in forking screen for requisition which is saved
	 * as draft </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_251963(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		defaultRequisitionSettings.setEnableReqForking(false);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object and change forking setting i.e. to
			// enable forking
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(false);
			requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create req with multiple items
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.BOTH);
			requisition.getItems().getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);

			// save reqs in draft
			PageRequisitionForking.clickDraft(driver, testCaseName, 0);
			PageRequisitionForking.clickDraft(driver, testCaseName, 1);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

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

				RequisitionSettings req = new RequisitionSettings();
				req.setEnableReqForking(false);
				req.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
				req = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, req);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting spilt req changes" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}

		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 08-Sep-2015 </b> <b>Method :
	 * RTC_251753 <b>Description : Requisition>Assigned Buyer: If 'Requester is
	 * required to assign a buyer when submitting requisitions for quote'
	 * setting is YES and forking is enabled; Assigned Buyer field should be
	 * mandatory on submitting the requisition from ready from approval
	 * state </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_251753(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		defaultRequisitionSettings.setEnableReqForking(false);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object and change forking setting i.e. to
			// enable forking
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(false);
			requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.REQUIRED);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create req with multiple items
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.BOTH);
			requisition.setItems(item);
			requisition.setAssignedBuyer(null);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			// submit reqs
			String req1 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 0);
			String req2 = PageRequisitionForking.getForkedReqNumber(driver, testCaseName, 1);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 0);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickViewWorkflow(driver, testCaseName, 1);
			PageRequisitionForking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
			PageRequisitionForking.clickOnSaveApprovalWorflow(driver, testCaseName);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

			// edit req1 and add assigned buyer
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, req1);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionView.clickOnSubmitForApproval(driver, testCaseName);

			// check error while submitting without buyer
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			Assert.assertTrue("Assign buyer field empty error is not present", flag);
			PageRequisitionCheckOut.clickOnOKForAlertPopup(driver, testCaseName);

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

				RequisitionSettings req = new RequisitionSettings();
				req.setEnableReqForking(false);
				req.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
				req = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, req);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting spilt req changes" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}

		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 08-Sep-2015 </b> <b>Method :
	 * RTC_251949 <b>Description : When user is assigned 'Show & reassign all
	 * requests in scope' activity, 'Change buyer' action should be displayed
	 * for all requisitions on buyers desk </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_251949(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			// login with SRARS role user
			UserUtilHelper.getAvailableUserFromList();
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Buyer_SRARS_Activity");
			LoginLogoutServices.login(driver, testCase, user);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);

			// check change buyer action for reqs
			boolean action = ModalBuersDeskListingActions.isChangeBuyerActionPresent(driver, testCaseName);
			Assert.assertTrue("Change buyer action is not present when logged in with SRARS activity role user", action);

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
	 * <b>Author: payal.alag </b> <b>Created On : 08-Sep-2015 </b> <b>Method :
	 * RTC_249133 <b>Description : Test for bug 219327 - [Demo]: Audit trail is
	 * not displayed properly for resubmitted requisitions in the following
	 * scenario </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_249133(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		RequisitionSettings defaultRequisitionSettings = new RequisitionSettings();
		defaultRequisitionSettings.setEnableReqForking(false);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to set reqSettings object and change forking setting i.e. to
			// enable forking
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			requisitionSettings.setForReqBySourcingStatus(false);
			requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create req with item1
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			// submit reqs
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());

			// approve req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			// return req from buyers desk listing
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnRejectAction(driver, testCaseName);
			ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
			ModalBuyersDeskReturnRequisition.clickOnReturnReqButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);

			// add 2nd item
			PageOnlineStore.fillSearchText(driver, testCaseName, "epens");
			PageOnlineStore.clickSearchButton(driver, testCaseName);
			List<WebElement> name = PageSearchListing.getItemName(driver, testCaseName);
			String itemname = name.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, itemname);
			PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, 20);
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT), itemId, 0);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionForking.clickConfirmReq(driver, testCaseName);

			/*
			 * Item item2 = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			 * requisition.setItems(item2);
			 * requisition.setNextAction(IConstantsData.NONE); requisition =
			 * FlowRequisition.createRequisition(driver, testCaseName,
			 * requisition); PageRequisitionCheckOut.clickIAmDone(driver,
			 * testCaseName); PageRequisitionForking.clickConfirmReq(driver,
			 * testCaseName);
			 */

			// check audit trail for req1
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo() + "-1");
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionView.clickOnParentRequisitionLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Requisition view page is opened successfully");
			jsx.executeScript("window.scrollBy(0,1050)", "");
			PageRequisitionView.clickOnAuditTrail(driver, testCaseName);
			driver.switchTo().window(winHandlerBefore);

			// check audit trail for req2
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo() + "-2");
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionView.clickOnParentRequisitionLink(driver, testCaseName);
			String winHandlerBefore1 = driver.getWindowHandle();
			Set<String> winHandler1 = driver.getWindowHandles();
			for (String handler : winHandler1)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Requisition view page is opened successfully");
			jsx.executeScript("window.scrollBy(0,1050)", "");
			PageRequisitionView.clickOnAuditTrail(driver, testCaseName);
			driver.switchTo().window(winHandlerBefore1);
			jsx.executeScript("window.scrollBy(0,950)", "");

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

				RequisitionSettings req = new RequisitionSettings();
				req.setEnableReqForking(false);
				req.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
				req = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, req);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting spilt req changes" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}

		}
	}

}
