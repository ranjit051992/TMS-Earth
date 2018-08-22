package com.zycus.automation.eproc.testcase.regression.buyersDesk;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.BuyersDeskSetting;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.GLAccount;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.Project;
import com.zycus.automation.bo.ProjectsSettings;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.ReplaceItem;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdeskSettingFlow.FlowBuyersDeskSetting;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.glAccountFlow.FlowGLAccount;
import com.zycus.automation.eproc.businessflow.glMapFlow.FlowGLMap;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.projectFlow.FlowProject;
import com.zycus.automation.eproc.businessflow.projectssettingsflow.FlowProjectsSettings;
import com.zycus.automation.eproc.businessflow.punchoutflow.FlowPunchout;
import com.zycus.automation.eproc.businessflow.replaceItemFlow.FlowReplaceItem;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCostBooking.ModelItemBuyersdeskSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryDelivery.ModelItemBuyersSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling.ModelBuyersdeskSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryCostBooking.ModelBuyersdeskSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryDelivery.ModelBuyersDeskRequisitionSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.addassignedbuyer.ModalAddAssignedBuyer;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple.ModelChangeMultiple;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.ModelRequisitionSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.IModelRequisitionSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.poattachment.ModalPOAttachment;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder.PageConvertedPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.manageProfile.PageManageProfile;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.purchaseOrderDetails.PagePurchaseOrderDetails;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.replaceItem.PageReplaceItem;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.PageBuyersDeskSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings.IPageGLAccountsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig.PageMasterDataTenantLevelConfigSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings.IPageProjectsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.PageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions.PageUpcomingRequisitions;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval.PopUpSendForApproval;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary.TabCheckoutReqSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class BuyersDeskTestCases extends TestDataProvider
{

	static Logger	logger			= Logger.getLogger(BuyersDeskTestCases.class);
	String			reqNumber_11835	= null;
	String			reqNumber_11906	= null;
	String			reqNumber_12119	= null;
	String			reqNumber_12142	= null;

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 06-Jul-2015 </b> <b>Method :
	 * RTC_271483 <b>Description : Category-PT-GL Map >> Buyers Desk >>
	 * Defaulting Map Deleted: Accounting details should be as it was in the
	 * requisition. Q-Tip should not display deleted map </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_271483(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_271488"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_228637"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183973"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		CatelogItem catalogItem = new CatelogItem();
		Item item = new Item();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		GLAccount defaultStatus = new GLAccount();
		defaultStatus.setChangeStatus(IPageGLAccountsMasterDataSettings.INACTIVE);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create gl map
			GLMap glMap = ObjectCreation.getDefaultObjectOfGLMap();

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");

			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			//			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			// click on cost booking link
			PageCustomizeSettings.clickOnGLRulesMap(driver, testCaseName);
			glMap = FlowGLMap.createGLMap(driver, testCaseName, glMap);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			catalogItem = ObjectCreation.getDefaultCatalogItemObject();
			catalogItem.setItemName(CommonServices.getTestData(IConstantsData.TEMP_ITEM));
			catelogItems.add(catalogItem);
			item.setCatelogItems(catelogItems);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// delete gl map
			FlowGLMap.deleteGLMap(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_GL_MAP_CATEGORY));
			// check req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			/*
			 * PageBuyersDesk.clickEditItemSummary(driver, testCaseName,
			 * requisition.getItems().getCatelogItems().get(0) .getItemID());
			 * TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
			 * testCaseName); boolean flag =
			 * ModelItemBuyersdeskSummaryCostBooking.isGLAccountPresent(driver,
			 * testCaseName, requisition
			 * .getItems().getCatelogItems().get(0).getItemID(), 0);
			 * Assert.assertTrue("GL Account is not present", !flag);
			 */
			boolean flag = PageBuyersDesk.isExpandAllLinkPresent(driver, testCaseName);
			Assert.assertTrue("Expand all link is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			// ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver,
			// testCaseName);
			// inactive the used gl account
			GLAccount account = new GLAccount();
			account.setChangeStatus("ACTIVE");
			FlowGLAccount.changeStatusOfGLAccount(driver, testCaseName, account, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			// check req again
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemBuyersdeskSummaryCostBooking.clickOnCancelItemSummary(driver, testCaseName);
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
				// activate the gl account
				FlowGLAccount.changeStatusOfGLAccount(driver, testCaseName, defaultStatus, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 09-Jul-2015 </b> <b>Method :
	 * RTC_271485 <b>Description : Category-PT-GL Map >> Buyers Desk >>
	 * Validation Map deleted: If lone validation map is deleted all values
	 * should be accepted on submit; else should be blocked as per another
	 * map. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271485(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_271490"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_271496"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GLAccount defaultStatus = new GLAccount();
		defaultStatus.setChangeStatus(IPageGLAccountsMasterDataSettings.INACTIVE);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create gl map
			GLMap glMap = ObjectCreation.getDefaultObjectOfGLMap();
			glMap = FlowGLMap.createGLMap(driver, testCaseName, glMap);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// change validation setting to YES
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// delete gl account
			FlowGLMap.deleteGLMap(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_GL_MAP_CATEGORY));
			// check req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			/*
			 * PageBuyersDesk.clickEditItemSummary(driver, testCaseName,
			 * requisition.getItems().getGuidedItems().get(0) .getItemID());
			 * TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
			 * testCaseName);
			 * ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(
			 * driver, testCaseName);
			 */
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.COMMENT_FOR_CHANGE_IN_REQUISITION);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			// check validation
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Alert for validation is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				// change validation setting to NO
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
				PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
				PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing customize validation settings" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}

		}

	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jul-2015 </b> <b>Method :
	 * RTC_271493 <b>Description : Category-PT-GL Map >> Buyers Desk >> Change
	 * Company: Accounting details should be reset as per new Company
	 * selected </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271493(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287000"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			// change company
			ModelBuyersdeskSummaryBilling.fillBillingCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			Map<String, String> cpb = ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			String cc = cpb.get("costCenter");
			String project = cpb.get("project");
			String budget = cpb.get("budget");
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, cc);
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, project);
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, budget);
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String account = ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			boolean flag = account == null ? true : false;
			Assert.assertTrue("GL account has not changed", flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModelItemBuyersdeskSummaryCostBooking.clickOnCancelItemSummary(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jul-2015 </b> <b>Method :
	 * RTC_271498 <b>Description : Category-PT-GL Map >> Buyers Desk >> Enforce
	 * Setting Change: Validation Rules should be applied on Submit of the copy
	 * document [Yes To No] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271498(TestCase testCase) throws Exception
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
			// change validation setting to NO
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.COMMENT_FOR_CHANGE_IN_REQUISITION);
			FlowRequisition.submitReq(driver, testCaseName, false);
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jul-2015 </b> <b>Method :
	 * RTC_272096 <b>Description : Test for bug 220751 - Buyers Desk: Return
	 * action is available for partially ordered requisitions </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272096(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_304010"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31875"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31876"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31878"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31885"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23895"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23517"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22632"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_198241"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53464"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130520"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31877"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31883"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53434"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251817"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31882"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// filter on pending order status
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnPendingOrderStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean filter = status.contains(IConstantsData.PENDING_FILTER_STATUS) ? true : false;
			Assert.assertTrue("After applying pending order filter, status of req is not showing pending order", filter);
			mappedTestCases.get(8).setTestResult(filter);
			// check edit action is present
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			boolean editAction = ModalBuersDeskListingActions.isEditActionPresent(driver, testCaseName);
			Assert.assertTrue("Edit action is not prsent for pending order status req", editAction);
			mappedTestCases.get(1).setTestResult(editAction);
			// check return action is present
			boolean returnAction = ModalBuersDeskListingActions.isRejectActionPresent(driver, testCaseName);
			Assert.assertTrue("Return action is present", returnAction);
			mappedTestCases.get(2).setTestResult(returnAction);
			// filter on returned with quote status
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnExpandProcessedFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnReturnedWithQuoteFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			// check view action is present
			boolean quote = ModalBuersDeskListingActions.isViewActionPresent(driver, testCaseName);
			Assert.assertTrue("View action is not present for req with returned with quote status", quote);
			mappedTestCases.get(3).setTestResult(quote);
			mappedTestCases.get(11).setTestResult(quote);
			// filter on returned for modification
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			// PageBuyersDeskListing.clickOnExpandProcessedFilter(driver,
			// testCaseName);
			PageBuyersDeskListing.clickOnReturnedForModificationFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			// check view action is present
			boolean modification = ModalBuersDeskListingActions.isViewActionPresent(driver, testCaseName);
			Assert.assertTrue("View action is not present for req with returned for modification status", modification);
			// filter on partially order status
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnExpandPendingOrderFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnPartiallyOrderedFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			// check reject action is present
			boolean flag = ModalBuersDeskListingActions.isRejectActionPresent(driver, testCaseName);
			Assert.assertTrue("Return action is present", !flag);
			mappedTestCases.get(0).setTestResult(flag);
			boolean edit = ModalBuersDeskListingActions.isEditActionPresent(driver, testCaseName);
			Assert.assertTrue("Edit action is not present for partially ordered req status", edit);
			mappedTestCases.get(4).setTestResult(edit);
			mappedTestCases.get(5).setTestResult(edit);
			mappedTestCases.get(6).setTestResult(edit);
			mappedTestCases.get(7).setTestResult(edit);
			mappedTestCases.get(9).setTestResult(edit);
			mappedTestCases.get(10).setTestResult(edit);
			boolean po = ModalBuersDeskListingActions.isConvertToPOActionPresent(driver, testCaseName);
			Assert.assertTrue("Convert to PO action is not present for partially ordered req status", po);
			mappedTestCases.get(12).setTestResult(po);
			mappedTestCases.get(13).setTestResult(po);
			mappedTestCases.get(14).setTestResult(po);
			mappedTestCases.get(15).setTestResult(po);
			// filter on awaiting queue
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnAwaitingQueueFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnNextPageIcon(driver, testCaseName);
			PageBuyersDeskListing.clickOnNextPageIcon(driver, testCaseName);
			PageBuyersDeskListing.clickOnNextPageIcon(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jul-2015 </b> <b>Method :
	 * RTC_275727 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,The setting for project booking should
	 * not editable at the buyer's desk. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275727(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275728"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		boolean flag = false;

		try
		{
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
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);
			System.out.println("@@@ Flag : " + flag);
			// assertTrue("Total amount was not splitted as per cost center
			// split", flag);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			Assert.assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean project = ModelItemBuyersdeskSummaryCostBooking.isProjectNonEditable(driver, testCaseName);
			Assert.assertTrue("Project split at header level is editable at cost booking section", !project);
			mappedTestCases.get(0).setTestResult(project);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jul-2015 </b> <b>Method :
	 * RTC_275749 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,if the project is deleted after
	 * requisition is edited at buyer's desk proper error should be
	 * thrown </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275749(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275750"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275760"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183965"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create project
			Project project = ObjectCreation.getDefaultObjectsOfProject();
			project = FlowProject.createProject(driver, testCaseName, project, 1);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// delete created project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), project);
			// check for error on buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			boolean error = PageBuyersDeskListing.isValidationGlobalErrorMessagePresent(driver, testCaseName);
			// Assert.assertTrue("Error is not shown for req whose project is
			// deleted", !error);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Deleted project error is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275753 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,project with max length name should be
	 * displayed properly in the cost booking section(header and item) of
	 * buyer's desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275753(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.MAX_CHAR_PROJECT));
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275757 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of inactive projects when
	 * requisition is edited at buyer's desk, proper error should be
	 * shown. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275757(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275759"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275761"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Project defaultStatus = new Project();
		defaultStatus.setChangStatus(IPageProjectsMasterDataSettings.INACTIVE);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			/*
			 * PageBuyersDeskListing.clickOnFirstActionButton(driver,
			 * testCaseName);
			 * ModalBuersDeskListingActions.clickOnConvertToPOAction(driver,
			 * testCaseName);
			 */
			// deactivate project
			Project proj = new Project();
			proj.setChangStatus(IPageProjectsMasterDataSettings.ACTIVE);
			proj = FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), proj);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			// check for global validation error
			ActionBot.defaultSleep();
			boolean error = PageBuyersDeskListing.isValidationGlobalErrorMessagePresent(driver, testCaseName);
			Assert.assertTrue("Error is not shown for req whose project is deactivated", error);
			mappedTestCases.get(0).setTestResult(error);
			mappedTestCases.get(1).setTestResult(error);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			// check for validation error
			ActionBot.defaultSleep();
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Inavtive project error is not present", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				// activate the deactivated project
				FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), defaultStatus);
			}
			catch (Exception e)
			{
				logger.error("Error while activating deactivated project" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275764 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of split projects in copy
	 * requisition, if one or all of the project(s) assigned to CC is deleted
	 * proper error should be thrown </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275764(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		boolean flag = false;
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings proj = new ProjectsSettings();
			proj.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, proj, testCaseName);
			// create project
			Project project = ObjectCreation.getDefaultObjectsOfProject();
			project = FlowProject.createProject(driver, testCaseName, project, 1);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
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
			centerSplitInfo1.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
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
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);
			System.out.println("@@@ Flag : " + flag);
			// assertTrue("Total amount was not splitted as per cost center
			// split", flag);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			Assert.assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, true);
			// delete project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), project);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PageRequisitionCheckOut.clickOnClickHereLinkToShowErrors(driver, testCaseName);
			// check project validation
			ActionBot.defaultSleep();
			boolean error = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error of deleted project is not shown", error);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275763 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of split projects in copy
	 * requisition, if one or all of the project(s) assigned to CC is inactive
	 * proper error should be thrown </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275763(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		boolean flag = false;
		Project defaultStatus = new Project();
		defaultStatus.setChangStatus(IPageProjectsMasterDataSettings.INACTIVE);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
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
			centerSplitInfo1.setProject(CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
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
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);
			System.out.println("@@@ Flag : " + flag);
			// assertTrue("Total amount was not splitted as per cost center
			// split", flag);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			Assert.assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, true);
			// deactivate the project
			Project proj = new Project();
			proj.setChangStatus(IPageProjectsMasterDataSettings.ACTIVE);
			proj = FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), proj);
			// check created req
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PageRequisitionCheckOut.clickOnClickHereLinkToShowErrors(driver, testCaseName);
			// check project error validation
			ActionBot.defaultSleep();
			boolean error = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error for deactivated project is not shown", error);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				// activating deactivated project
				FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), defaultStatus);
			}
			catch (Exception e)
			{
				logger.error("Error while activating deactivated project" + e, e);
			}
			finally
			{

				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275766 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of split projects in copy
	 * requisition, all the details should be retained properly. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275766(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275767"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		User user = null;
		boolean flag = false;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

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
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);
			System.out.println("@@@ Flag : " + flag);
			// assertTrue("Total amount was not splitted as per cost center
			// split", flag);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			Assert.assertTrue("Cost Center Split information on checkout page was wrong", flag);
			mappedTestCases.get(0).setTestResult(flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);
			// check req in my requisition
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			// check project and cc
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jul-2015 </b> <b>Method :
	 * RTC_275772 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,in case of auto po if the project
	 * selected in requisition is deleted the requisition should be blocked at
	 * buyer's desk. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275772(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			PageCustomizeSettings.clickOnBackLink(driver, testCaseName);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			// create project
			Project proj = ObjectCreation.getDefaultObjectsOfProject();
			proj = FlowProject.createProject(driver, testCaseName, proj, 1);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// delete project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), proj);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean flag = status.equals("Scheduled") ? true : false;
			Assert.assertTrue("Requisition is not blocked at buyers desk", flag);
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
				// change po setting
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing the setting of purchse order" + e, e);
			}
			finally
			{

				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jul-2015 </b> <b>Method :
	 * RTC_275784 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, Buyer should be able to change the
	 * project from header level cost booking section. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275784(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			/*
			 * PageCustomizeSettings.clickOnBackLink(driver, testCaseName);
			 * PageCustomizeSettings.clickOnPurchaseOrderLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(
			 * driver, testCaseName);
			 * PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			 */
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			// change project at header level
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.FILLPROJECTFIELD_WITHOUTMANAGERFIELD));
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, "Test");
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jul-2015 </b> <b>Method :
	 * RTC_275787 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, if the project selected in buyer's
	 * desk is deleted error should be thrown at submit </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275787(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53438"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create project
			Project proj = ObjectCreation.getDefaultObjectsOfProject();
			proj = FlowProject.createProject(driver, testCaseName, proj, 1);
			// go at buyers desk and edit one req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, "Test");
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.REC_CHANGE_COMM));
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			// delete project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), proj);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error message for deleted project is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jul-2015 </b> <b>Method :
	 * RTC_275788 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, if the project selected in buyer's
	 * desk is deactivated error should be thrown at submit </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275788(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Project defaultStatus = new Project();
		defaultStatus.setChangStatus(IPageProjectsMasterDataSettings.INACTIVE);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			PageCustomizeSettings.clickOnBackLink(driver, testCaseName);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			// go at buyers desk and edit one req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, "Test");
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.REC_CHANGE_COMM));
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			// deactivate project
			Project proj = new Project();
			proj.setChangStatus(IPageProjectsMasterDataSettings.ACTIVE);
			proj = FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), proj);
			// check project at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error message for deleted project is not present", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				// activating deactivated project
				FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), defaultStatus);
			}
			catch (Exception e)
			{
				logger.error("Error while activating deactivated project" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 23-Jul-2015 </b> <b>Method :
	 * RTC_268143 <b>Description : Test for bug 222224 - On changing assigned
	 * buyer from blank to any buyer/buyer group in buyers desk, error 500 is
	 * displayed </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_268143(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_269456"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251768"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251769"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251831"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_252141"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251766"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251767"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251953"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnBuyerInAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnClearIconOfAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnUnassignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnChangeBuyerAction(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalAddAssignedBuyer.clickOnDropdownBuyerIcon(driver, testCaseName);
			ModalAddAssignedBuyer.clickOnGroupBuyerIcon(driver, testCaseName);
			ModalAddAssignedBuyer.clickOnDropdownBuyerIcon(driver, testCaseName);
			ModalAddAssignedBuyer.clickOnSingleBuyerIcon(driver, testCaseName);
			ModalAddAssignedBuyer.fillAssignedBuyerName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			boolean flag = ModalAddAssignedBuyer.isAssignedBuyerNameLabelPresent(driver, testCaseName);
			Assert.assertTrue("Buyer is not assigned", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			ModalAddAssignedBuyer.fillChangedBuyerComments(driver, testCaseName, IConstantsData.COMMENT_FOR_CHANGE_ASSIGNED_BUYER);
			ModalAddAssignedBuyer.clickOnSaveAssignedBuyerButton(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Jul-2015 </b> <b>Method :
	 * RTC_271475 <b>Description : Category-PT-GL Map >> Buyers Desk >>
	 * Accounting details should be redefaulted on Category change </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271475(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_271477"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286995"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286993"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286997"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22635"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_193498"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53462"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_131037"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_131040"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201809"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201810"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String oldGlAccount = IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT;
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.DIFFERENT_PRODUCT_CATEGORY));
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String newGlAccount = ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			boolean flag = !(newGlAccount.equals(oldGlAccount)) ? true : false;
			Assert.assertTrue("Gl account hasnt changed after changing the product category", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			mappedTestCases.get(8).setTestResult(flag);
			mappedTestCases.get(9).setTestResult(flag);
			mappedTestCases.get(10).setTestResult(flag);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemBuyersdeskSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_GL_ACCOUNT),
				requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemBuyersdeskSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.CHILD_GL_ACCOUNT),
				requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Jul-2015 </b> <b>Method :
	 * RTC_271479 <b>Description : Category-PT-GL Map >> Buyers Desk >>
	 * Validation rules should be applied on Convert To PO. [Validation Maps are
	 * those where Category is equal to *] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271479(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_271481"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22633"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_65031"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22638"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// chnage validation setting to YES
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);

			// check for validation error for gl account
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			String supplier = PageBuyersDesk.getItemSupplier(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			boolean flag3 = supplier.equalsIgnoreCase(requisition.getItems().getGuidedItems().get(0).getSupplierNameInSuppInfo()) ? true : false;
			Assert.assertTrue("Item supplier name is not correctly present at buyers desk", flag3);
			mappedTestCases.get(3).setTestResult(flag3);
			String no = PageBuyersDesk.getItemNo(driver, testCaseName);
			boolean flag1 = !no.equalsIgnoreCase("Null") ? true : false;
			Assert.assertTrue("Item no is displayed as Null which is wrong", flag1);
			mappedTestCases.get(2).setTestResult(flag1);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "Cost Allocation");
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			jsx.executeScript("window.scrollBy(650,0)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Validation error for gl account is not present", !flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
			// change validation setting to NO
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag2 = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Validation error for gl account is not present", !flag2);
			mappedTestCases.get(0).setTestResult(flag2);
			mappedTestCases.get(1).setTestResult(flag2);
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
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
				PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
				PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing setting of validation of gl accounts", e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jul-2015 </b> <b>Method :
	 * RTC_289844 <b>Description : Verify On editing 'Awaiting Quote'
	 * requisitions in Buyers desk; 'Modify workflow to add approvers' setting
	 * should be displayed in workflow section if buyer can send the requisition
	 * for approval </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_289844(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289846"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289847"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289848"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289849"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289850"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289851"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			// check modify workflow setting
			boolean workflow = PageBuyersDesk.isModifyWorkflowSettingPresent(driver, testCaseName);
			Assert.assertTrue("Modify workflow setting is not present at buyers desk page", workflow);
			mappedTestCases.get(0).setTestResult(workflow);
			mappedTestCases.get(1).setTestResult(workflow);
			PageBuyersDesk.isModifyWorkflowSettingQtipPresent(driver, testCaseName);
			PageBuyersDesk.clickOnModifyWorkflowSetting(driver, testCaseName);
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);
			// check workflow alert
			boolean alert = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Alert for workflow setting is not present", alert);
			mappedTestCases.get(2).setTestResult(alert);
			mappedTestCases.get(4).setTestResult(alert);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
			// check req status at my requisition
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			String str = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean status = str.equals("Ready for approval") ? true : false;
			Assert.assertTrue("At My Requisition, req is not in Ready for approval state", status);
			mappedTestCases.get(3).setTestResult(status);
			mappedTestCases.get(5).setTestResult(status);
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
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jul-2015 </b> <b>Method :
	 * RTC_289845 <b>Description : Verify On editing 'Awaiting Quote'
	 * requisitions in Buyers desk; 'Modify workflow to add approvers' setting
	 * should NOT be displayed in workflow section if buyer cannot send the
	 * requisition for approval </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_289845(TestCase testCase) throws Exception
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
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// return req to requester
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmReqButton(driver, testCaseName);
			ActionBot.defaultSleep();
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PopUpSendForApproval.clickOnSendForApprovalNoButton(driver, testCaseName);
			// check at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			// check modify workflow setting
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			boolean workflow = PageBuyersDesk.isModifyWorkflowSettingPresent(driver, testCaseName);
			Assert.assertTrue("Modify workflow setting is present at buyers desk which is wrong", workflow);
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
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jul-2015 </b> <b>Method :
	 * RTC_289852 <b>Description : Verify On returning an 'awaiting for quote'
	 * requisition back to the requester in buyers desk; if 'Modify workflow to
	 * add approvers' setting is checked; the setting should be retained on
	 * editing the requisition from My requisition listing </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_289852(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251830"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_223967"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnModifyWorkflowSetting(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			boolean flag = ModalBuyersDeskReturnRequisition.isReturnReqComentPresent(driver, testCaseName);
			Assert.assertTrue("Return req confirmation is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModalBuyersDeskReturnRequisition.clickOnReturnReqFromBuyersDesk(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			String str = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean status = str.equalsIgnoreCase("Returned For Amendment") ? true : false;
			Assert.assertTrue("Status of returned req is showing wrong", status);
			mappedTestCases.get(1).setTestResult(status);
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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jul-2015 </b> <b>Method :
	 * RTC_296101 <b>Description : Test for bug 227935 - Quantity is not
	 * editable from item grid and while editing delivery information of item
	 * from buyers desk in case of item received by amount . </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_296101(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_296667"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_161698"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// select receive by to amount
			guidedItem.setReceiveBy(IConstantsData.Amount);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// change amount
			ModelItemBuyersSummaryDelivery.fillQuantityOrAmountOfDelivery(driver, testCaseName, 1000);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String account = ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// check gl account
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String account1 = ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			boolean flag = account1.equalsIgnoreCase(account) ? true : false;
			Assert.assertTrue("GL account is going blank which is wrong", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 31-Jul-2015 </b> <b>Method :
	 * RTC_303307 <b>Description : Test for bug 229811 - Error 500 is occurred
	 * on submit PO when header level attachment is attached at Convert to PO
	 * Screen. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_303307(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_319861"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_323173"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23552"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23518"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23897"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase(""));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.BOTH);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert to PO
			PageBuyersDeskListing.clickOnCheckboxOfReqToBeSelected(driver, testCaseName, 1);
			PageBuyersDeskListing.clickOnConvertToPoButton(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.clickOnCollapseAndExpandIcon(driver, testCaseName);
			boolean po = PagePurchaseOrderToBeGenerated.isPONOFormatConfigPresentCorrectly(driver, testCaseName);
			Assert.assertTrue("PO NO Format will be configured accordingly label is not present on PO to be converted page", po);
			mappedTestCases.get(2).setTestResult(po);
			PagePurchaseOrderToBeGenerated.clickOnCollapseAndExpandIcon(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			// attach file
			PagePurchaseOrderToBeGenerated.clickOnAddAttachments(driver, testCaseName);
			String fileName = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FILE_WITH_DISTURBED_STRUCTURE;
			ModalPOAttachment.fillAttachmentFileName(driver, testCaseName, fileName);
			String size = ModalPOAttachment.getAttachmentSize(driver, testCaseName);
			boolean flag = !size.equalsIgnoreCase("0 KB") ? true : false;
			Assert.assertTrue("Attached file size is equal to zero", flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			ModalPOAttachment.clickOnDoneButton(driver, testCaseName);
			// submit PO
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			String reqNo = PageConvertedPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName, 2);
			boolean req = reqNo.equalsIgnoreCase(requisition.getReqNo()) ? true : false;
			Assert.assertTrue("Req no is not same after converting req to PO", req);
			mappedTestCases.get(0).setTestResult(req);
			mappedTestCases.get(1).setTestResult(req);
			mappedTestCases.get(3).setTestResult(req);
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
	 * <b>Author: payal.alag </b> <b>Created On : 31-Jul-2015 </b> <b>Method :
	 * RTC_307745 <b>Description : Test for bug 222230 - User is able to select
	 * individual users in buyer group option in assigned buyer field </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_307745(TestCase testCase) throws Exception
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
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,-550)", "");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
			// select assigned group buyer
			PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
			PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
			PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			// check assigned buyer
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, IConstantsData.BUYER_NAME);
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
	 * <b>Author: payal.alag </b> <b>Created On : 04-Aug-2015 </b> <b>Method :
	 * RTC_333443 <b>Description : Test for bug 234202 - Error 500 on keeping
	 * buyer field empty and returning a requisition after replacing
	 * items. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_333443(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_334547"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clearAssignedBuyer(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,650)", "");
			// replace item
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			PageReplaceItem.clickOnRadioItem(driver, testCaseName);
			PageReplaceItem.clickOnReplaceItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, IConstantsData.COMMENT_FOR_REPLACE_ITEM);
			PageReplaceItem.clickOnConfirm(driver, testCaseName);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// resubmit req
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			// reapprove req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			// check and open req at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			boolean flag = reqNo.equalsIgnoreCase(requisition.getReqNo()) ? true : false;
			Assert.assertTrue("Req is not present at buyers desk after reapproval", flag);
			mappedTestCases.get(0).setTestResult(false);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 04-Aug-2015 </b> <b>Method :
	 * RTC_335216 <b>Description : Test for bug 234741 - User is not directed to
	 * punchout site on clicking on a punchout </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_335216(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		PunchoutItem punchoutItem = new PunchoutItem();
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<PunchoutItem> punchoutItems = new ArrayList<PunchoutItem>();
		User user = new User();
		try
		{
			driver = DriverSelector.getDriver(testCase);
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
	 * <b>Author: payal.alag </b> <b>Created On : 04-Aug-2015 </b> <b>Method :
	 * RTC_275778 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of need a quote item, in Send
	 * for approval screen proper validation for deleted project in the req
	 * should be done </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275778(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275782"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251959"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.hoverOnFirstReqNoToGetReqInfo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// add quote
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			// delete used project
			Project project = ObjectCreation.getDefaultObjectsOfProject();
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), project);
			// open req at my requisition
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickContinueRequisition(driver, testCaseName);
			// check error
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			Assert.assertTrue("Project deleted error is not present at req", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 04-Aug-2015 </b> <b>Method :
	 * RTC_275779 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of need a quote item, in Send
	 * for approval screen proper validation for deactivate project in the req
	 * should be done </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275779(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275783"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22722"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		Project defaultStatus = new Project();
		defaultStatus.setChangStatus(IPageProjectsMasterDataSettings.INACTIVE);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// add quote
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			// deactivate used project
			Project proj = new Project();
			proj.setChangStatus(IPageProjectsMasterDataSettings.ACTIVE);
			proj = FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), proj);
			// open req at my requisition
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickContinueRequisition(driver, testCaseName);
			// check error
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			Assert.assertTrue("Project deleted error is not present at req", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
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
				// activate the deactivated project
				FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), defaultStatus);
			}
			catch (Exception e)
			{
				logger.error("Error while activating deactivated project" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 05-Aug-2015 </b> <b>Method :
	 * RTC_275785 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, Buyer should be able to change the
	 * project from item level cost booking section. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275785(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		new ArrayList<CostCenterSplitInfo>();
		Item item = new Item();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ObjectCreation.getCostCenterProjectAndBudget();

			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			// to set CC split at item level
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			// to set CostBookingItemSummary in catalog items- with %
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(false, 0);
			requisition.getItems().getCatelogItems().get(0).setCostBookingItemSummary(costBookingItemSummary);

			// to set non mandatory fields
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			// requisition.setNextAction(IConstantsData.NONE);
			requisition.setCostBookingItemSummary(null);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			// fill project and budget
			ModelItemSummaryCostBooking.fillCostBookingItemSplitProject(driver, testCaseName, IConstantsData.INACTIVE_PROJECT,
				requisition.getItems().getCatelogItems().get(0).getItemID(), 1);
			ModelItemSummaryCostBooking.fillCostBookingItemSplitBudget(driver, testCaseName, "Test", requisition.getItems().getCatelogItems().get(0).getItemID(), 1);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_275800 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of need a quote item, in
	 * Return to requestor screen proper validation for deleted project in the
	 * req should be done </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275800(TestCase testCase) throws Exception
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
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			// create project
			Project project = ObjectCreation.getDefaultObjectsOfProject();
			project = FlowProject.createProject(driver, testCaseName, project, 1);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
			PageRequisitionCheckOut.clickOnSendItBackToMe(driver, testCaseName);
			// delete created project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), project);
			// check for error on buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// add quote
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Deleted project validation error is not shown", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_53458 <b>Description : Verify working of a setting
	 * "Allow buyer to change price of catalog items requested" at
	 * Customize>>Buyers desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_53458(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53459"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_296098"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_226512"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_224851"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change unit price tolerance setting-->buyers desk
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnBuyersDeskLink(driver, testCaseName);
			PageBuyersDeskSettings.fillReceivedByQuantity_Maximum(driver, testCaseName, 50);
			PageBuyersDeskSettings.fillPriceSubTotalOfCatalogItems(driver, testCaseName, 50);
			PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);

			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.fillItemPrice(driver, testCaseName, 10000, requisition.getItems().getCatelogItems().get(0).getItemID());
			PageBuyersDesk.fillQuantity(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(), 500);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean price = PageBuyersDesk.isUnitPriceExceedingToleranceLevelErrorPresent(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			Assert.assertTrue("Exceeding Unit price tolerance level error is not present for catalog item", price);
			mappedTestCases.get(3).setTestResult(price);
			boolean qty = PageBuyersDesk.isQuantityExceedingToleranceLevelErrorPresent(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			Assert.assertTrue("Exceeding Quantity tolerance level error is not present for catalog item", qty);
			mappedTestCases.get(0).setTestResult(qty);
			mappedTestCases.get(1).setTestResult(qty);
			mappedTestCases.get(2).setTestResult(qty);
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
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnBuyersDeskLink(driver, testCaseName);
				PageBuyersDeskSettings.fillReceivedByQuantity_Maximum(driver, testCaseName, 0);
				PageBuyersDeskSettings.fillPriceSubTotalOfCatalogItems(driver, testCaseName, 0);
				PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing tolerance level of unit price of catalog item at buyers desk setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_270866 <b>Description : At Buyer desk &gt;&gt; The date format
	 * displayed in a PO preview/PO print template should be displayed as per
	 * the format set in the user's profile. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_270866(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_145451"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_151940"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_151955"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnPreviewPoLink(driver, testCaseName, 0);
			boolean flag = PagePurchaseOrderToBeGenerated.isPOInfoAtPreviewPOPresent(driver, testCaseName);
			Assert.assertTrue("PO info is not shown properly on preview PO", !flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_53461 <b>Description : Verify working of a setting at
	 * Customize>>Buyers desk {Blank value should ignore the setting} </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_53461(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53460"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23529"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change unit price tolerance setting-->buyers desk
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnBuyersDeskLink(driver, testCaseName);
			PageBuyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
			PageBuyersDeskSettings.fillReceivedByQuantity_Maximum(driver, testCaseName, 50);
			PageBuyersDeskSettings.fillPriceSubTotalOfCatalogItems(driver, testCaseName, 50);
			PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);

			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBuyersDesk.fillItemPrice(driver, testCaseName, 10000, requisition.getItems().getCatelogItems().get(0).getItemID());
			PageBuyersDesk.fillQuantity(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(), 500);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			String reqNo = PagePurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedReqNo(driver, testCaseName, 1);
			boolean flag = reqNo.equalsIgnoreCase(requisition.getReqNo()) ? true : false;
			Assert.assertTrue("Tolerance level for price and quantity is checked even though setting is blank which is wrong", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_275801 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of need a quote item, in
	 * Return to requestor screen proper validation for deactivated project in
	 * the req should be done </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275801(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		Project defaultStatus = new Project();
		defaultStatus.setChangStatus(IPageProjectsMasterDataSettings.INACTIVE);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
			PageRequisitionCheckOut.clickOnSendItBackToMe(driver, testCaseName);
			// deactivate project
			Project proj = new Project();
			proj.setChangStatus(IPageProjectsMasterDataSettings.ACTIVE);
			proj = FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), proj);
			// check for error on buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// add quote
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Deactivated project validation error is not shown", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				// activate the deactivated project
				FlowProject.changeStatusOfProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT), defaultStatus);
			}
			catch (Exception e)
			{
				logger.error("Error while activating deactivated project" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 10-Aug-2015 </b> <b>Method :
	 * RTC_275762 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of deleted projects when
	 * requisition is converted to PO from buyer desk's listing and is in
	 * suggested po screen </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275762(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create project
			Project project1 = ObjectCreation.getDefaultObjectsOfProject();
			project1 = FlowProject.createProject(driver, testCaseName, project1, 1);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.TEMP_PROJECT));
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			// delete created project
			FlowProject.deleteProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_PROJECT), project1);
			// check error at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			// check for global validation error
			boolean error = PageBuyersDeskListing.isValidationGlobalErrorMessagePresent(driver, testCaseName);
			Assert.assertTrue("Error is not shown for req whose project is deleted", error);
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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Aug-2015 </b> <b>Method :
	 * RTC_275780 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of need a quote item, in Send
	 * for approval screen proper validation for outdated project in the req
	 * should be done </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275780(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275781"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275802"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings projectsetting = new ProjectsSettings();
			projectsetting.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, projectsetting, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
			PageRequisitionCheckOut.clickOnSendItBackToMe(driver, testCaseName);
			// outdate the project
			Project project = ObjectCreation.getDefaultObjectsOfProject();
			project.setCustomDate(CommonUtilities.getFutureDayDate());
			FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), project, project.getCustomDate().getDay(),
				project.getCustomDate().getMonth(), project.getCustomDate().getYear(), true);
			// check for error on buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			// add quote
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// return req to requester
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Outdated project validation error is not shown", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				Project pro = new Project();
				FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), pro, pro.getCustomDate().getDay(),
					pro.getCustomDate().getMonth(), pro.getCustomDate().getYear(), false);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting the outdated project setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 12-Aug-2015 </b> <b>Method :
	 * RTC_275786 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, if the project selected in buyer's
	 * desk is out dated, error should be thrown at submit </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275786(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23410"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// go at buyers desk and edit one req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, "Test");
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.REC_CHANGE_COMM));
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			// outdate the project
			Project project1 = ObjectCreation.getDefaultObjectsOfProject();
			project1.setCustomDate(CommonUtilities.getFutureDayDate());
			FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), project1, project1.getCustomDate().getDay(),
				project1.getCustomDate().getMonth(), project1.getCustomDate().getYear(), true);
			// check error at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean flag1 = status.equalsIgnoreCase("Pending Order") ? true : false;
			Assert.assertTrue("Status of req after it is saved is not in pending order which is wrong", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error message for outdated project is not present", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				Project pro = new Project();
				FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), pro, pro.getCustomDate().getDay(),
					pro.getCustomDate().getMonth(), pro.getCustomDate().getYear(), false);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting the outdated project setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}

	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 12-Aug-2015 </b> <b>Method :
	 * RTC_275733 <b>Description : Customize&gt;Cost booking: Assign cost to
	 * project&gt;Always/Let user decide:Yes,In case of outdated projects when
	 * requisition is edited at buyer's desk, proper error should be
	 * shown. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275733(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// outdate the project
			Project project1 = ObjectCreation.getDefaultObjectsOfProject();
			project1.setCustomDate(CommonUtilities.getFutureDayDate());
			FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), project1, project1.getCustomDate().getDay(),
				project1.getCustomDate().getMonth(), project1.getCustomDate().getYear(), true);
			// check for error on buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("outdated project error is not present", flag);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				Project pro = new Project();
				FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), pro, pro.getCustomDate().getDay(),
					pro.getCustomDate().getMonth(), pro.getCustomDate().getYear(), false);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting the outdated project setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 12-Aug-2015 </b> <b>Method :
	 * RTC_275765 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of split projects in copy
	 * requisition, if one or all of the project(s) assigned to CC is outdated
	 * proper error should be thrown </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275765(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		List<CostCenterSplitInfo> centerSplitInfosOnCheckoutPage = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		boolean flag = false;
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings proj = new ProjectsSettings();
			proj.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, proj, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
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
			centerSplitInfo1.setProject(CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
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
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to check cost center split amount
			flag = FlowRequisition.checkCostCenterSplitAmount(requisition);
			System.out.println("@@@ Flag : " + flag);
			// assertTrue("Total amount was not splitted as per cost center
			// split", flag);

			// to get cc split data on checkout page
			centerSplitInfosOnCheckoutPage = FlowRequisition.getCostCenterSplitInfoOnCheckoutPage(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(),
				2);

			// to verify CC split data
			flag = FlowRequisition.checkIfCostCenterSplit(centerSplitInfos, centerSplitInfosOnCheckoutPage);
			Assert.assertTrue("Cost Center Split information on checkout page was wrong", flag);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, true);
			// outdate the project
			Project project1 = ObjectCreation.getDefaultObjectsOfProject();
			project1.setCustomDate(CommonUtilities.getFutureDayDate());
			FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), project1, project1.getCustomDate().getDay(),
				project1.getCustomDate().getMonth(), project1.getCustomDate().getYear(), true);
			// check for errors in my requisition
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PageRequisitionCheckOut.clickOnClickHereLinkToShowErrors(driver, testCaseName);
			// check project validation
			boolean error = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("Error of outdated project is not shown", error);
			PageBuyersDesk.clickOnOKForAlert(driver, testCaseName);
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
				Project pro = new Project();
				FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), pro, pro.getCustomDate().getDay(),
					pro.getCustomDate().getMonth(), pro.getCustomDate().getYear(), false);
			}
			catch (Exception e)
			{
				logger.error("Error while reverting the outdated project setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}

		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 12-Aug-2015 </b> <b>Method :
	 * RTC_275774 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,in case of auto po if the project
	 * selected in requisition is outdated the requisition should be blocked at
	 * buyer's desk. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275774(TestCase testCase) throws Exception
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
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			PageCustomizeSettings.clickOnBackLink(driver, testCaseName);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			CostBookingRequisitionSummary costBookingRequisitionSummary = requisition.getCostBookingRequisitionSummary();
			costBookingRequisitionSummary.setProject(CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// outdate the project
			Project project1 = ObjectCreation.getDefaultObjectsOfProject();
			project1.setCustomDate(CommonUtilities.getFutureDayDate());
			FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), project1, project1.getCustomDate().getDay(),
				project1.getCustomDate().getMonth(), project1.getCustomDate().getYear(), true);
			// check status of req at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean flag = status.contains(IConstantsData.PENDING_ORDER) ? true : false;
			Assert.assertTrue("Requisition is not blocked at buyers desk", flag);
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
				// change po setting
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
				// revert outdated project setting
				Project pro = new Project();
				FlowProject.outdateProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT), pro, pro.getCustomDate().getDay(),
					pro.getCustomDate().getMonth(), pro.getCustomDate().getYear(), false);
			}
			catch (Exception e)
			{
				logger.error("Error while changing the setting of purchse order" + e, e);
			}
			finally
			{

				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 13-Aug-2015 </b> <b>Method :
	 * RTC_268153 <b>Description : Upcoming requisitions>>Requisitions should be
	 * displayed as per buyer desk activities to users in upcoming requisition
	 * tab </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_268153(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268154"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			ActionBot.defaultSleep();
			TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
			PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
			PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
			ActionBot.defaultSleep();
			PageRequisitionCheckOut.fillAssignedBuyerGroup(driver, testCaseName, CommonServices.getTestData(IConstantsData.ASSIGNED_BUYER_USER_GROUP));
			ActionBot.defaultSleep();
			FlowRequisition.submitReq(driver, testCaseName, true);
			MainPageHeaderLevelTab.clickOnUpcomingRequisitionTab(driver, testCaseName);
			ActionBot.defaultSleep();
			PageUpcomingRequisitions.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			ActionBot.defaultSleep();
			String str = PageUpcomingRequisitions.getFirstReqNo(driver, testCaseName);
			ActionBot.defaultSleep();
			boolean flag = str.equalsIgnoreCase(requisition.getReqNo()) ? true : false;
			Assert.assertTrue("Req is not present in upcoming requisitions which is wrong", !flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 13-Aug-2015 </b> <b>Method :
	 * RTC_268185 <b>Description : [Assign request to user group]Buyers
	 * desk&gt;&gt;Buyer should be allowed to change buyer for all requisitions
	 * incase he only has activity A(Access buyers desk) assigned </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_268185(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268186"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268187"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268188"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			// login with "ABD buyer activity"
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Buyer_ABD_Activity");
			LoginLogoutServices.login(driver, testCase, user);
			// change buyer at buyers desk listing
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnChangeBuyerAction(driver, testCaseName);
			ModalAddAssignedBuyer.clickOnRemoveBuyer(driver, testCaseName);
			ModalAddAssignedBuyer.fillAssignedBuyerName(driver, testCaseName, IConstantsData.BUYER_NAME);
			ModalAddAssignedBuyer.clickOnSaveAssignedBuyerButton(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			PageBuyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);
			String req = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			boolean flag = !req.equalsIgnoreCase(reqNo) ? true : false;
			Assert.assertTrue("Req no is available in list even though buyer is changed and out of scope", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			// change buyer from buyers desk and convert to po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ModalAddAssignedBuyer.clickOnRemoveBuyer(driver, testCaseName);
			PageBuyersDesk.fillAssignedBuyer(driver, testCaseName, IConstantsData.BUYER_NAME);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedDeliverTo(driver, testCaseName, 1);
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
	 * <b>Author: payal.alag </b> <b>Created On : 14-Aug-2015 </b> <b>Method :
	 * RTC_268142 <b>Description : Test for bug 222213 - Default filter in
	 * assigned buyer is not working for buyer having show all requests in scope
	 * buyer activity </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_268142(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_268152"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_269301"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251773"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251775"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251776"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251779"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23548"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251774"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change req settings and make assigned buyer field mandatory
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
			PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Required(driver, testCaseName);
			PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			ActionBot.scrollUp(driver, "300");
			PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
			PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
			ActionBot.defaultSleep();
			PageRequisitionCheckOut.fillAssignedBuyerGroup(driver, testCaseName, CommonServices.getTestData(IConstantsData.ASSIGNED_BUYER_USER_GROUP));
			ActionBot.defaultSleep();
			FlowRequisition.submitReq(driver, testCaseName, true);
			// approve req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			// logout
			User user2 = UserUtilHelper.getAvailableUserFromList();
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.USERNAME, "amit.dash@zycus.com");
			LoginLogoutServices.logout(driver, testCase, user);
			ActionBot.defaultMediumSleep();

			// login with other user
			LoginLogoutServices.login(driver, testCase, user2);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			// apply me filter at buyers desk
			PageBuyersDeskListing.clickOnLinkAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnMeAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyAssignedBuyerFilter(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			// convert req to po
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			PageConvertedPurchaseOrder.clickOnPOLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Buyer name is present");
			String buyer = PageViewPurchaseOrder.getBuyerName(driver, testCaseName);
			boolean flag = buyer.equalsIgnoreCase("Amit") ? true : false;
			Assert.assertTrue("PO is not reassigned to the buyer who converted req to PO", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			driver.switchTo().window(winHandlerBefore);
			boolean date = PageViewPurchaseOrder.isPOCreatedOnDatePresent(driver, testCaseName);
			Assert.assertTrue("PO created on date is not present on viewing PO", !date);
			mappedTestCases.get(6).setTestResult(flag);
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
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
				PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Optional(driver, testCaseName);
				PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing assigned buyer setting of req" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 17-Aug-2015 </b> <b>Method :
	 * RTC_53452 <b>Description : User should be able to edit Comments for
	 * suppliers, Org Unit, delivery details at header level. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_53452(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140292"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			ModelBuyersdeskSummaryBilling.fillBillingCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryDeliverTo(driver, testCaseName, "Ankita");

			BillingRequisitionSummary billingReqSummary = new BillingRequisitionSummary();
			billingReqSummary.setCompany(CommonServices.getTestData(IConstantsData.Other_Company_Name));
			billingReqSummary.setBusinessUnit(CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			billingReqSummary.setLocation(CommonServices.getTestData(IConstantsData.Other_Location));
			billingReqSummary.setNextAction(IConstantsData.NONE);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			ActionBot.defaultSleep();
			FlowRequisition.fillBillingRequisitionSummary(driver, testCaseName, billingReqSummary);
			/*
			 * ModelBuyersdeskSummaryBilling.fillBillingCompany(driver,
			 * testCaseName,
			 * CommonServices.getTestData(IConstantsData.Other_Company_Name));
			 * ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			 * ModelBuyersdeskSummaryBilling.fillBillingLocation(driver,
			 * testCaseName,
			 * CommonServices.getTestData(IConstantsData.Other_Location));
			 */
			/*
			 * TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			 * ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryDeliverTo(
			 * driver, testCaseName, "Ankita");
			 */
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBookingOfOtherCompany();
			FlowRequisition.fillCostBookingRequisitionSummary(driver, testCaseName, costBookingRequisitionSummary);

			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);

			/*
			 * TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			 * Map<String, String> cpb =
			 * ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			 * ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleCC(driver,
			 * testCaseName, cpb.get("costCenter"));
			 * ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(
			 * driver, testCaseName, cpb.get("project"));
			 * ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(
			 * driver, testCaseName, cpb.get("budget"));
			 * ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver,
			 * testCaseName);
			 */

			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String oldgl = ModelItemBuyersdeskSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT),
				requisition.getItems().getCatelogItems().get(0).getItemID(), 1);
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());

			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			String newgl = ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID(), 0);
			boolean flag = newgl.equals(oldgl) ? true : false;
			Assert.assertTrue("Gl account has gone blank after opening saved req", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
			newgl = ActionBot.findElement(driver, By.xpath("(.//*[@class='accounting qtipCss hasQtip'])[2]")).getText();
			flag = newgl.isEmpty();
			Assert.assertTrue("Gl account has gone blank after opening saved req", !flag);
			mappedTestCases.get(0).setTestResult(!flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Aug-2015 </b> <b>Method :
	 * RTC_80542 <b>Description : Verify If auto req to PO settings is OFF - all
	 * requisition should always move to Buyer's Desk pending Filter. (even if
	 * all info is present in req). </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_80542(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80543"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80553"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change req settings and make assigned buyer field mandatory
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// approve req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean flag = status.contains(IConstantsData.PENDING_FILTER_STATUS) ? true : false;
			Assert.assertTrue("At buyers desk status of req is not in pending state which is wrong", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Aug-2015 </b> <b>Method :
	 * RTC_201813 <b>Description : Autocomplete for GL account >>
	 * Delete/Deactivate GL account check should be present at Buyers desk when
	 * Buyer edit REQ. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201813(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201814"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53422"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		CatelogItem catalogItem = new CatelogItem();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create gl map
			GLAccount glAccount = ObjectCreation.getDefaultObjectsOfGLAccount();
			glAccount = FlowGLAccount.createGLAccount(driver, testCaseName, glAccount);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.TEMP_GL_ACCOUNT));
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			catalogItem = ObjectCreation.getDefaultCatalogItemObject();
			catalogItem.setItemName(CommonServices.getTestData(IConstantsData.TEMP_ITEM));
			catelogItems.add(catalogItem);
			item.setCatelogItems(catelogItems);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			// delete gl account
			FlowGLAccount.deleteGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.TEMP_GL_ACCOUNT));
			// check req at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			boolean po = PageBuyersDesk.isConvertToPOOptionPresent(driver, testCaseName);
			Assert.assertTrue("Convert to PO option is not present", po);
			mappedTestCases.get(1).setTestResult(po);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			boolean flag = PageBuyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
			Assert.assertTrue("GL account deleted error is not shown on converting req to PO", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Aug-2015 </b> <b>Method :
	 * RTC_251816 <b>Description : Verify user should be able to view
	 * requisitions in Buyers desk which are in 'Returned with Quote'
	 * status </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_251816(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_227528"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251815"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_251854"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// open req at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			/*
			 * PageBuyersDesk.getNeedAQuoteHelpText(driver, testCaseName,
			 * requisition.getItems().getGuidedItems().get(0) .getItemID());
			 */
			ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			ModalGuidedItemDetails.clickOnTabSupplierDetails(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			ActionBot.defaultSleep();
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			String status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			boolean flag = status.contains(IConstantsData.AWAITING_QUOTE) ? true : false;
			Assert.assertTrue("Status of returned req at buyers desk is not matching the scenario", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Aug-2015 </b> <b>Method :
	 * RTC_134512 <b>Description : Test for bug 200307 - Fatal error message is
	 * displayed when Converting to PO by adding custom delivery address in
	 * Requisition </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134512(TestCase testCase) throws Exception
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
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			// change to customize address
			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			ModelBuyersDeskRequisitionSummaryDelivery.selectDeliveryMyAddress(driver, testCaseName);
			ActionBot.defaultSleep();

			ModelBuyersDeskRequisitionSummaryDelivery.clickDeliveryCreateNewAddress(driver, testCaseName);

			String newAddress = CommonUtilities.getRandomStringWithSize(10);

			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressName(driver, testCaseName, newAddress);

			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressStreet1(driver, testCaseName, "Street1");

			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressCountry(driver, testCaseName, CommonServices.getTestData(IConstantsData.COUNTRY_NAME));

			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressCity(driver, testCaseName, "City");

			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);

			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);

			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);

			ModelBuyersDeskRequisitionSummaryDelivery.selectDeliveryMyAddress(driver, testCaseName);

			WebElement myAddressCheckbox = ActionBot.findElement(driver, IModelRequisitionSummaryDelivery.DELIVERY_MY_ADDRESS);

			myAddressCheckbox.click();

			myAddressCheckbox.clear();

			ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryMyAddress(driver, testCaseName, newAddress);

			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 18-Aug-2015 </b> <b>Method :
	 * RTC_236685 <b>Description : Test for bug 217509 - Account type and GL
	 * account are getting overrided by using change multiple on buyers desk
	 * . </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_236685(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_233211"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_131039"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			// PageBuyersDesk.clickOnFirstItemEdit(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			// TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
			// testCaseName);
			/*
			 * String glaccount =
			 * ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver,
			 * testCaseName, requisition
			 * .getItems().getCatelogItems().get(0).getItemID(), 0);
			 */
			// ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver,
			// testCaseName);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnUpdateAllLink(driver, testCaseName);
			ModelChangeMultiple.clickSupplierTab(driver, testCaseName);
			ModelChangeMultiple.fillChangeMultipleGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			ModelChangeMultiple.clickChangeMultipleApply(driver, testCaseName);
			// PageBuyersDesk.clickOnFirstItemEdit(driver, testCaseName);
			// TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
			// testCaseName);
			/*
			 * String updatedaccount =
			 * ModelItemBuyersdeskSummaryCostBooking.getGLAccount(driver,
			 * testCaseName,
			 * requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			 */
			// ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver,
			// testCaseName);
			/*
			 * boolean flag = !updatedaccount.equals(glaccount) ? true : false;
			 * Assert.assertTrue(
			 * "After changing gl account from update all lines, gl account of item has not got updated"
			 * , flag);
			 */
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnTabSupplierDetails(driver, testCaseName);
			String suppliername = ModalGuidedItemDetails.getSupplierName(driver, testCaseName);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 900);
			boolean suggested = ModalGuidedItemDetails.isSuggestedSupplierLinkPresent(driver, testCaseName);
			Assert.assertTrue("Suggested supplier link is not present", suggested);
			mappedTestCases.get(1).setTestResult(suggested);
			ModalGuidedItemDetails.clickOnSuggestedSupplierLink(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			PageBuyersDesk.clickOnUpdateAllLink(driver, testCaseName);
			ModelChangeMultiple.fillSupplierName(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			ModelChangeMultiple.clickChangeMultipleApply(driver, testCaseName);
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnTabSupplierDetails(driver, testCaseName);
			String updatedsuppliername = ModalGuidedItemDetails.getSupplierName(driver, testCaseName);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			boolean supplier = !updatedsuppliername.equalsIgnoreCase(suppliername) ? true : false;
			Assert.assertTrue("Supplier name is not getting updared even after changing it from update all lines", supplier);
			mappedTestCases.get(0).setTestResult(supplier);
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
	 * <b>Author: payal.alag </b> <b>Created On : 18-Aug-2015 </b> <b>Method :
	 * RTC_22646 <b>Description : Verify that I should have the option on
	 * Buyer's desk listing page to filter records by Search {Req #, Req
	 * Name} </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_22646(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22647"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22648"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22642"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22652"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22641"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			// search req by req no
			String reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			PageBuyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);
			// search req by req name
			String reqName = PageBuyersDeskListing.getFirstRowReqName(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, reqName);
			PageBuyersDeskListing.clickOnClearIconOfRequisitionNameFilter(driver, testCaseName);
			ActionBot.defaultSleep();
			// search req by requester
			/*
			 * PageBuyersDeskListing.fillRequester(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.BUYER_NAME));
			 * PageBuyersDeskListing.clickOnClearIconOfRequesterFilter(driver,
			 * testCaseName);
			 */
			// search req by amount
			PageBuyersDeskListing.clickOnLinkAmountFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnCheckboxOfAmountFilter(driver, testCaseName, 1);
			PageBuyersDeskListing.clickOnApplyAmountFilter(driver, testCaseName);
			// open req by clicking on req no
			String no = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			// check cancel button ans check for changes saved
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnCancel(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, no);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			String comments = PageBuyersDesk.getReqChangeComments(driver, testCaseName);
			boolean flag = comments == null ? true : false;
			Assert.assertTrue("Even after canceling the edit req, changes made on req are saved", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 19-Aug-2015 </b> <b>Method :
	 * RTC_275790 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,buyer should be able to split the
	 * project according to cc and budget at header level </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275790(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130543"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130541"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130548"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130554"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130562"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130545"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130549"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130544"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130546"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130547"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130550"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130553"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130555"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130556"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130557"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130558"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130560"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130561"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130563"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130564"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_130565"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		Item item = new Item();
		int percentage1 = 0, percentage2 = 0;
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change project settings to YES--ALWAYS
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// open req at buyers desk
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			// get header total price
			String price = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			if (price.contains(" "))
			{
				String[] str = StringUtils.split(price, " ");
				price = "";
				price = str[0].trim();

			}

			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			// get item subtotal price
			String itemPrice = PageBuyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			if (itemPrice.contains(" "))
			{
				String[] str1 = StringUtils.split(itemPrice, " ");
				itemPrice = "";
				itemPrice = str1[0].trim();
			}
			PageBuyersDesk.clickOnCollapseAllItemsLink(driver, testCaseName);
			// change currency before split
			FlowBuyersDesk.changeCurrencyOfRequisition(driver, testCaseName);
			// check impact of it before split
			/*
			 * FlowBuyersDesk.checkImpactAfterCurrencyChangeAtBuyersDesk(driver,
			 * testCaseName, price, itemPrice,
			 * requisition.getItems().getCatelogItems().get(0).getItemID());
			 */

			// get header level price after changing currency
			String price1 = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			if (price1.contains(" "))
			{
				String[] str = StringUtils.split(price, " ");
				price1 = "";
				price1 = str[0].trim();

			}
			// check the changed currency at header level
			boolean flag1 = !price1.equalsIgnoreCase(price) ? true : false;
			Assert.assertTrue("Price has not changed at header level after changing currency", !flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			mappedTestCases.get(2).setTestResult(flag1);
			mappedTestCases.get(3).setTestResult(flag1);
			mappedTestCases.get(4).setTestResult(flag1);

			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);

			// get item level price after changing currency
			String itemPrice1 = PageBuyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			if (itemPrice1.contains(" "))
			{
				String[] str1 = StringUtils.split(itemPrice, " ");
				itemPrice1 = "";
				itemPrice1 = str1[0].trim();
			}

			// check the changed currency at item level
			boolean flag2 = !itemPrice1.equalsIgnoreCase(itemPrice) ? true : false;
			Assert.assertTrue("Price has not changed at item level after changing currency", !flag2);
			mappedTestCases.get(5).setTestResult(flag2);
			mappedTestCases.get(6).setTestResult(flag2);
			mappedTestCases.get(7).setTestResult(flag2);
			mappedTestCases.get(8).setTestResult(flag2);
			mappedTestCases.get(9).setTestResult(flag2);

			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			ObjectCreation.getOtherCostCenterProjectAndBudget();
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

			// get header total price after split
			String price2 = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			if (price.contains(" "))
			{
				String[] str = StringUtils.split(price, " ");
				price = "";
				price = str[0].trim();

			}

			// check cc split after expanding item info
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			boolean flag = PageBuyersDesk.isCostingSplitPresentAtItemLevel(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			Assert.assertTrue("Costing split at header level is shown properly at item level info", !flag);
			mappedTestCases.get(10).setTestResult(flag);
			mappedTestCases.get(11).setTestResult(flag);
			mappedTestCases.get(12).setTestResult(flag);
			mappedTestCases.get(13).setTestResult(flag);
			mappedTestCases.get(14).setTestResult(flag);

			// get item subtotal price after split
			String itemPrice2 = PageBuyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			if (itemPrice.contains(" "))
			{
				String[] str1 = StringUtils.split(itemPrice, " ");
				itemPrice = "";
				itemPrice = str1[0].trim();
			}

			PageBuyersDesk.clickOnCollapseAllItemsLink(driver, testCaseName);
			// change currency after
			FlowBuyersDesk.changeCurrencyOfRequisition(driver, testCaseName);

			/*
			 * FlowBuyersDesk.checkImpactAfterCurrencyChangeAtBuyersDesk(driver,
			 * testCaseName, price2, itemPrice2,
			 * requisition.getItems().getCatelogItems().get(0).getItemID());
			 */

			// get header level price after changing currency
			String price3 = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			if (price3.contains(" "))
			{
				String[] str = StringUtils.split(price, " ");
				price3 = "";
				price3 = str[0].trim();

			}
			// check the changed currency at header level
			boolean flag3 = !price3.equalsIgnoreCase(price2) ? true : false;
			Assert.assertTrue("Price has not changed at header level after changing currency", flag3);
			mappedTestCases.get(15).setTestResult(flag3);
			mappedTestCases.get(16).setTestResult(flag3);
			mappedTestCases.get(17).setTestResult(flag3);

			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);

			// get item level price after changing currency
			String itemPrice3 = PageBuyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			if (itemPrice3.contains(" "))
			{
				String[] str1 = StringUtils.split(itemPrice, " ");
				itemPrice3 = "";
				itemPrice3 = str1[0].trim();
			}

			// check the changed currency at item level
			boolean flag4 = !itemPrice3.equalsIgnoreCase(itemPrice2) ? true : false;
			Assert.assertTrue("Price has not changed at item level after changing currency", flag4);
			mappedTestCases.get(18).setTestResult(flag4);
			mappedTestCases.get(19).setTestResult(flag4);
			mappedTestCases.get(20).setTestResult(flag4);

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
	 * <b>Author: payal.alag </b> <b>Created On : 19-Aug-2015 </b> <b>Method :
	 * RTC_275791 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,buyer should be able to split the
	 * project according to cc and budget at item level </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275791(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275792"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project;
		int percentage1 = 0, percentage2 = 0;
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change project settings to YES--ALWAYS
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// project shown at header level is "-" when split for item level is
			// selected
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			// to set CC split at item level
			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			ObjectCreation.getOtherCostCenterProjectAndBudget();

			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			// to set CostBookingItemSummary in catalog items- with %
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(false, 0);
			requisition.getItems().getCatelogItems().get(0).setCostBookingItemSummary(costBookingItemSummary);

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
			// check split at header level
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			boolean flag = ModelBuyersdeskSummaryCostBooking.isCCSplitAtItemLevelContentPresentAtHeader(driver, testCaseName);
			Assert.assertTrue("CC Split at item level content is not shown properly at header", flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
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
	 * <b>Author: payal.alag </b> <b>Created On : 19-Aug-2015 </b> <b>Method :
	 * RTC_275793 <b>Description : Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,buyer should be able to split the
	 * project using quantity at item level </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275793(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// change project settings to YES--ALWAYS
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			// create req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// project shown at header level is "-" when split for item level is
			// selected
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
			PageBuyersDesk.clickEditItemSummary(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			// to set CostBookingItemSummary in guided items - with quantity
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(true, requisition.getItems().getGuidedItems().get(0).getQuantity());
			requisition.getItems().getGuidedItems().get(0).setCostBookingItemSummary(costBookingItemSummary);
			// check split at header level
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			boolean flag = ModelBuyersdeskSummaryCostBooking.isCCSplitAtItemLevelContentPresentAtHeader(driver, testCaseName);
			Assert.assertTrue("CC Split at item level content is not shown properly at header", flag);
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
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

	/*************************************
	 * KunalAshar's TestCases - Start
	 **********************************************/

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11835 <b>Description : Add Free text items: Verify Buyer should be
	 * able to add Free text items on a requisition on buyer s desk if 'Allow
	 * buyer to add new items to a requisition' setting is Yes </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11835(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_product_category_default_value = false;
		boolean flag_supplier_name_error = false;
		boolean flag_req_approval = false;
		boolean flag_workflow_approval_sequence = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11855"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11895"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Select 'Allow buyer to add new items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			//clear pr currency units
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			//clear pr total amount
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber_11835 = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber_11835);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber_11835);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// fetching workflow approval list from Buyers Desk Page before
			// creating free-text item
			String workflowBuyer_0[] = PageRequisitionCheckOut.getApprovalWorkFlow(driver, testCaseName);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			/** TC: Buyer_Desk_012 **/
			// to check default value present under product category field in
			// Item pop-up
			flag_product_category_default_value = PageBuyersDesk.verifyProductCategoryFieldDefaultValue(driver, testCaseName);
			Assert.assertTrue("Default value is set to BLANK for product category field", flag_product_category_default_value);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			flag_supplier_name_error = PageBuyersDesk.checkForSupplierNameError(driver, testCaseName);
			Assert.assertTrue("Error message displayed as supplier name is Blank", flag_supplier_name_error);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			String workflowBuyer_1[] = PageRequisitionCheckOut.getApprovalWorkFlow(driver, testCaseName);
			flag_workflow_approval_sequence = Arrays.equals(workflowBuyer_0, workflowBuyer_1);
			Assert.assertTrue("Workflow Approval list Matched", flag_workflow_approval_sequence);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_workflow_approval_sequence);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11836 <b>Description : Add Free text items: Verify Buyer should not
	 * be able to add Free text items on a requisition on buyer s desk if 'Allow
	 * buyer to add new items to a requisition' setting is No </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11836(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		Map<String, String> map = new HashMap<String, String>();

		User user = null;
		boolean flag_add_button = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as No
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			if (flag_add_button == false)
			{
				Assert.assertTrue("Add Item button not displayed on Page", true);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11837 <b>Description : Add Free text items: Verify Buyer should be
	 * able to add Free text items only on a pending requisition on Buyers
	 * desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11837(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button_pendingQrder = false;
		boolean flag_add_button_awaitingQuote = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button_pendingQrder = PageBuyersDesk.verifyButtonAddItems(driver, testCaseName);

			// verifying add button for Awaiting Quote status
			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.setStatusAsAwaitingQuote(driver, testCaseName);
			PageBuyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);
			FlowBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			flag_add_button_awaitingQuote = PageBuyersDesk.verifyButtonAddItems(driver, testCaseName);

			if (flag_add_button_pendingQrder == true && flag_add_button_awaitingQuote == false)
			{
				Assert.assertTrue("Add Item button displayed on Page only for Requisition with status as Pending Order", true);
			}
			else
			{
				Assert.assertTrue(
					"Add Item button not displayed on Page,Flag for Status Pending Order:" + flag_add_button_pendingQrder + " , Awaiting Quote:" + flag_add_button_awaitingQuote,
					false);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);

		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11841 <b>Description : Add Free text items: Verify On clicking on
	 * Cancel & Go back in free text item modal in add item screen; the free
	 * text item should NOT get added to the requisition and buyer should be
	 * redirected to requisition edit screen </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11841(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_link_cancel = false;
		boolean flag_item_added = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// Naviagtes to Free Text Item Pop-up and clicks on Cancel Link.
			/** TC: EPROC_11839 **/
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			flag_link_cancel = PageBuyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName);
			PageBuyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);

			// Fill all details under Create Item pop-up and click on Cancel and
			// Go back Button
			/** TC: EPROC_11841 **/
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			String itemNumber = buyersdesk.getItemNumber();
			FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);
			// Verify if item gets created when click on Go Back Button
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			if (flag_item_added == false)
			{
				Assert.assertTrue("Item not created", true);
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
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}

		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 25-Oct-2016 </b> <b>Method :
	 * EPROC_11842 <b>Description : Add Free text items: Verify Buyer should not
	 * be able to add Free text items on a requisition on buyer s desk if 'Allow
	 * buyer to add new items to a requisition' setting is No </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11842(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		Map<String, String> map = new HashMap<String, String>();

		User user = null;
		boolean flag_add_button = false;
		boolean flag_duplicate_item_created = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as No
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12675");

			// Creating buyers desk object to fetch values from Excel
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			/*
			 * //enters Gl Account field value for created item before creating
			 * another item PageBuyersDesk.clickOnCreateFreeTextItem(driver,
			 * testCaseName); PageBuyersDesk.clickConfimSave_Save(driver,
			 * testCaseName); //does not exist on dev instance, directly
			 * navigates to free text modal
			 */

			// adding gl account for default item
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickOnFirstItemEdit(driver, testCaseName);
			PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
			PageBuyersDesk.selectGLAccount(driver, testCaseName, buyersdesk.getGLAccount());

			// enter GL Account values for free text item
			PageBuyersDesk.clickAccountingEditLinkForFreeTextItem(driver, testCaseName);
			PageBuyersDesk.selectGLAccount(driver, testCaseName, buyersdesk.getGLAccount());

			// saves req and creates duplicate item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);
			// to create duplicate item
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_duplicate_item_created = PageBuyersDesk.isDuplicateItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Duplicate Item Created", flag_duplicate_item_created);

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
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11848 <b>Description : Add Free text items: Verify On entering
	 * product category in add free text item modal; if multiple category eforms
	 * are present for the item then eforms modal should be displayed with
	 * category; count of eforms and eforms </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11848(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		int eformCount = 0;
		int eformListCount = 0;

		boolean flag_default_eform_displayed = false;
		boolean flag_selected_eform_displayed = false;
		boolean flag_eform_dialog_displayed = false;
		boolean flag_is_category_displayed = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11847"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// creating default object of buyers desk to fetch values in below
			// steps
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			String productCategory_0 = buyersdesk.getProductCategory();

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM002/PR/10744");

			// Naviagtes to Free Text Item Pop-up and and enters Product
			// category field value to verify default eform under Requirement
			// Tab.
			/** TC: EPROC_11847 **/
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			PageBuyersDesk.enterProductCategory(driver, testCaseName, productCategory_0);
			flag_default_eform_displayed = FlowBuyersDesk.verifyEformPresentInRequirementTab(driver, testCaseName);
			Assert.assertTrue("Default eform displayed under Requirement Tab", flag_default_eform_displayed);

			// fills product category and checks if eform dialog is displayed
			// with product category, eforms count and eforms list
			/** TC: EPROC_11848 **/
			buyersdesk.setProductCategory(CommonServices.getTestData(IConstantsData.Item_Product_Category, 0));
			String productCategory_1 = buyersdesk.getProductCategory();
			PageBuyersDesk.clickItemTab(driver, testCaseName);
			PageBuyersDesk.enterProductCategory(driver, testCaseName, productCategory_1);

			// to check is eform dialog is displayed
			flag_eform_dialog_displayed = PageBuyersDesk.isEformDialogPresent(driver, testCaseName);
			Assert.assertTrue("Eform dialog displayed on page", flag_eform_dialog_displayed);

			// to check if category is displayed on eform
			flag_is_category_displayed = PageBuyersDesk.isCategoryOnEformDisplayed(driver, testCaseName, productCategory_1);
			Assert.assertTrue("Category displayed on eform dialog", flag_is_category_displayed);

			// to verify form count and form displayed count
			eformCount = PageBuyersDesk.getEformCount(driver, testCaseName, eformCount);
			eformListCount = PageBuyersDesk.getEformListCount(driver, testCaseName, eformListCount);

			if (eformCount == eformListCount)
			{
				Assert.assertTrue("Eform dialog displayed with matching form count and list count", true);
			}
			else
			{
				Assert.assertTrue("Eform dialog displayed with matching form count and list count", false);
			}

			// Select eform from dialog and check if displayed under Requirement
			// tab
			/** TC: EPROC_11849 **/
			PageBuyersDesk.clickEformFromList(driver, testCaseName);
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			flag_selected_eform_displayed = FlowBuyersDesk.verifyEformPresentInRequirementTab(driver, testCaseName);

			// PageBuyersDesk.clickOnCancelLinkEformDialog(driver,
			// testCaseName);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_default_eform_displayed);
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
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11850 <b>Description : Add Free text items: Verify Buyer should be
	 * able to add Free text items on a requisition on buyer s desk if 'Allow
	 * buyer to add new items to a requisition' setting is Yes </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11850(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;
		boolean flag_quantity_error_received = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11851"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11852"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11853"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11854"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			// overriding default values to very kg with decimal quantity
			buyersdesk.setUOM(CommonServices.getTestData(IConstantsData.Item_UOM, 0));
			buyersdesk.setQuantity(CommonServices.getTestData(IConstantsData.Item_Quantity, 1));

			String initial_quantity = buyersdesk.getQuantity();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			/** TC: EPROC_11853 **/
			String final_quantity = buyersdesk.getQuantity();
			// to check if quantity is changed from 0 to other number.
			if (initial_quantity.equalsIgnoreCase(final_quantity))
			{
				flag_quantity_error_received = false;
			}
			else
			{
				flag_quantity_error_received = true;
			}

			/** TC: EPROC_11854 **/
			// gets verified under FlowBuyersDesk.fillItemDetails(driver,
			// testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);
			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
			mappedTestCases.get(2).setTestResult(flag_quantity_error_received);
			mappedTestCases.get(3).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11857 <b>Description : Add Free text items: Verify manufacturer
	 * name field in add free text item modal should accept alphanumeric
	 * values </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11857(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11858"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11859"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11860"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11861"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11862"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11863"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11864"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);

			// creates new Item: Fill Extra item details like Manufacturer Name,
			// ID, etc.
			buyersdesk = FlowBuyersDesk.fillExtraItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// fills supplier details and adds item
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);

			Assert.assertTrue("Item Added", flag_item_added);
			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
			mappedTestCases.get(2).setTestResult(flag_item_added);
			mappedTestCases.get(3).setTestResult(flag_item_added);
			mappedTestCases.get(4).setTestResult(flag_item_added);
			mappedTestCases.get(5).setTestResult(flag_item_added);
			mappedTestCases.get(6).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11875 <b>Description : Add Free text items: Verify Length
	 * validation in requirement details section </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11875(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_error_in_requirement_tab = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11876"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11877"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());

			/** TC: EPROC_11874 **/
			// to check item is not added when mandatory fields are kept Blank
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			PageBuyersDesk.clearAddressRequirementTab(driver, testCaseName);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			flag_error_in_requirement_tab = PageBuyersDesk.verifyErrorInRequirementTab(driver, testCaseName);
			Assert.assertTrue("Error message received when mandatory fields is kept Blank", flag_error_in_requirement_tab);

			// validating length, special char and Multilingual char support
			String addressRequirementTab = buyersdesk.getAddressInRequirementTab();
			PageBuyersDesk.enterAddressRequirementTab(driver, testCaseName, addressRequirementTab);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);
			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);

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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11870 <b>Description : Verify adding free text item to a
	 * requisition with maximum characters in the following fields in mentioned
	 * fields in steps: </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11870(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11871"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11872"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			// setting item value to validate Max Length, Special Char and
			// Multilingual char
			buyersdesk.setItemNumber(CommonServices.getTestData(IConstantsData.Item_Number, 0));
			buyersdesk.setItemShortDescription(CommonServices.getTestData(IConstantsData.Item_Short_Description, 0));
			buyersdesk.setItemLongDescription(CommonServices.getTestData(IConstantsData.Item_Long_Description, 0));
			buyersdesk.setQuantity(CommonServices.getTestData(IConstantsData.Item_Quantity, 3));
			buyersdesk.setPrice(CommonServices.getTestData(IConstantsData.Item_Price0, 0));
			buyersdesk.setManufacturerName(CommonServices.getTestData(IConstantsData.Item_Manufacturer_Name, 0));
			buyersdesk.setManufacturerPartId(CommonServices.getTestData(IConstantsData.Item_Manufacturer_Part_Id, 0));
			buyersdesk.setSpecificationName(CommonServices.getTestData(IConstantsData.Item_Specification_Name, 0));
			buyersdesk.setSpecificationKey(CommonServices.getTestData(IConstantsData.Item_Specification_Key, 0));
			buyersdesk.setSpecificationValue(CommonServices.getTestData(IConstantsData.Item_Specification_Value, 0));

			// entering values for all fields
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			buyersdesk = FlowBuyersDesk.fillExtraItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);
			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);

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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11866 <b>Description : Add Free text items: Verify Buyer should be
	 * able to link free text items to Blanket Purchase Orders in add free text
	 * item modal </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11866(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqNumber = null;
		String bpoNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_show_all_button_enabled = false;
		boolean flag_is_bpo_selected = false;
		boolean flag_req_returned_to_requestor = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11869"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			// entering values for all fields
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			flag_show_all_button_enabled = PageBuyersDesk.clickShowAllButton(driver, testCaseName);
			Assert.assertTrue("Show All button is enabled", flag_show_all_button_enabled);

			// getting BPO number
			bpoNumber = PageBuyersDesk.selectBPONumber(driver, testCaseName, bpoNumber);
			flag_is_bpo_selected = PageBuyersDesk.verifyBPOSelected(driver, testCaseName, bpoNumber);
			Assert.assertTrue("BPO successfully selected", flag_is_bpo_selected);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			/** TC: EPROC_11869 **/
			// Returning Req to Requestor
			String reqChangeComments = buyersdesk.getReqChangeComments();
			PageBuyersDesk.enterReqChangeComments(driver, testCaseName, reqChangeComments);
			PageBuyersDesk.clickReturnToRequestorButton(driver, testCaseName);
			PageBuyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);

			// to verify req has been removed from Buyers Desk
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
			reqNumber = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			String reqStatus = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			if (reqStatus.equalsIgnoreCase("Returned"))
			{
				flag_req_returned_to_requestor = true;
			}
			Assert.assertTrue("Requisition returned to requestor", flag_req_returned_to_requestor);
			mappedTestCases.get(0).setTestResult(flag_req_returned_to_requestor);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11868 <b>Description : Add Free text items: Verify Buyer should be
	 * able to mention alphanumeric characters in contracts field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11868(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String contractNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			contractNumber = buyersdesk.getContractNumber();
			// entering values for all fields
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.enterContractNumber(driver, testCaseName, contractNumber);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11879 <b>Description : Add Free text items: Verify Buyer should be
	 * able to close the add free text item modal and add catalog/punchout
	 * items </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11879(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_link_cancel = false;
		boolean flag_item_added = false;
		int index = 0; // index of item to be operated. 0 will select first item
						// from list.
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// Naviagtes to Free Text Item Pop-up
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// clicks on Cancel Link.
			flag_link_cancel = PageBuyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName);
			Assert.assertTrue("Clicked on link Cancel and closed modal", flag_link_cancel);

			// Searching for item
			OnlineStore onlinestore = ObjectCreation.searchItem();
			onlinestore = FlowOnlineStore.searchItem(driver, testCaseName, onlinestore);
			onlinestore = FlowOnlineStore.getItemId(driver, testCaseName, index, onlinestore);

			String itemId = onlinestore.getItemId();
			int itemQuantity = onlinestore.getQuantity();
			String searchItemName = onlinestore.getItemName();

			// filling item quantity and adding item to req
			onlinestore = FlowOnlineStore.fillItemQuantity(driver, testCaseName, itemId, itemQuantity, onlinestore);
			onlinestore = FlowOnlineStore.clickOnCheckBoxOfItem(driver, testCaseName, itemId, onlinestore);
			PageBuyersDesk.clickAddItemsButtonToReq(driver, testCaseName);

			// to check selected item is added to Requisition
			flag_item_added = PageBuyersDesk.isCatalogItemAdded(driver, testCaseName, searchItemName);
			Assert.assertTrue("Catalog Item Added", flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11880 <b>Description : Add Free text items: Verify Buyer should be
	 * able to close the add free text item modal and add catalog/punchout
	 * items </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11880(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_save_cc_project_budget_changes = false;
		boolean flag_dont_save_cc_project_budget_changes = false;
		boolean flag_is_free_text_model_displayed = false;
		boolean flag_changed_value = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11881"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11882"));
			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes

			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12755");

			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 0));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 0));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 0));

			// changes cost center, project and budget details of req
			FlowBuyersDesk.changeCostcenterProjectBudget(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			/** TC: EPROC_11881 **/
			// verify Create Free Text Item model is displayed after clicking on
			// Save
			flag_is_free_text_model_displayed = PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
			Assert.assertTrue("Create Free Text item modal displayed", flag_is_free_text_model_displayed);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			flag_changed_value = PageBuyersDesk.verifyCostcenterProjectBudgetUpdatedValues(driver, testCaseName, buyersdesk.getCostCenter(), buyersdesk.getProject(),
				buyersdesk.getBudget());
			Assert.assertTrue("Updated values reflected on Req", flag_changed_value);

			/** TC: EPROC_11882 **/
			// updating values to check if changes getting saved when No button
			// is clicked
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 1));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 1));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 1));

			// changes cost center, project and budget details of req
			FlowBuyersDesk.changeCostcenterProjectBudget(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			flag_dont_save_cc_project_budget_changes = PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);
			Assert.assertTrue("Changes saved for cost center/project/budget ", flag_dont_save_cc_project_budget_changes);

			flag_is_free_text_model_displayed = PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
			Assert.assertTrue("Create Free Text item modal displayed", flag_is_free_text_model_displayed);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			flag_changed_value = PageBuyersDesk.verifyCostcenterProjectBudgetUpdatedValues(driver, testCaseName, buyersdesk.getCostCenter(), buyersdesk.getProject(),
				buyersdesk.getBudget());
			if (flag_changed_value == false)
			{
				Assert.assertTrue("Values not updated on Req", true);
			}
			mappedTestCases.get(0).setTestResult(flag_is_free_text_model_displayed);
			mappedTestCases.get(1).setTestResult(flag_is_free_text_model_displayed);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11883 <b>Description : Add Free text items: Verify Replace icon
	 * should not be displayed for newly added free text items </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11835" })
	public void EPROC_11883(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_icon_replace_disabled = false;
		boolean flag_delivery_address_matched = false;
		boolean flag_cost_center_matched = false;
		String itemDeliveryAddress = null;
		String reqDeliveryAddress = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11887"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11886"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11835);

			// click/verifies if Add Item button displayed on page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// verifies if Replace icon is enabled
			flag_icon_replace_disabled = PageBuyersDesk.verifyReplaceIconEnabledForFreeTextItem(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace icon is disabled for newly created item", flag_icon_replace_disabled);

			// to check delivery address displayed under item is matching with
			// Req delivery address displayed at header level
			/** TC: EPROC_11884 **/
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqDeliveryAddress = PageBuyersDesk.getReqDeliveryAddressHeaderlevel(driver, testCaseName);
			itemDeliveryAddress = PageBuyersDesk.getFreeTextItemDeliveryAddress(driver, testCaseName);
			if (reqDeliveryAddress.equalsIgnoreCase(itemDeliveryAddress))
			{
				flag_delivery_address_matched = true;
			}
			Assert.assertTrue("Free text delivery address matched with req delivery address", flag_delivery_address_matched);

			// to check cost center displayed under item is matching with Req
			// cost center at header level
			/** TC: EPROC_11885, EPROC_11886, , EPROC_11887 **/
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center matched with req cost center", flag_cost_center_matched);

			mappedTestCases.get(0).setTestResult(flag_cost_center_matched);
			mappedTestCases.get(1).setTestResult(flag_cost_center_matched);
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
				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11888 <b>Description : Add free text items: Verify On adding free
	 * text items to the requisition; cost booking information of the item
	 * should be set to requester s default cost center in case 'Book cost at
	 * line item level' is selected and requisition s OU is requester s default
	 * OU </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11888(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String company_Req = null, ouCompany = null;
		String bUnit_Req = null, ouBusinessUnit = null;
		String location_Req = null, ouLocation = null;
		String reqNumber = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		String onBehalfOf = null;
		boolean flag_req_approval = false;
		boolean flag_ou_matched = false;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_cost_center_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11889"));

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// get Req OU i.e. Company/BusinessUnit/Location
			company_Req = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			bUnit_Req = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			location_Req = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			// filling req details and getting newly created reqNumber
			onBehalfOf = MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);
			PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, onBehalfOf);
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get OU i.e. Company/BusinessUnit/Location from Buyers Desk and
			// compares with Create Req Page
			ouCompany = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			ouBusinessUnit = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			ouLocation = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			if (company_Req.equalsIgnoreCase(ouCompany) && bUnit_Req.equalsIgnoreCase(ouBusinessUnit) && location_Req.equalsIgnoreCase(ouLocation))
			{
				flag_ou_matched = true;
			}
			Assert.assertTrue("Buyer's desk OU matched with Req OU", flag_ou_matched);

			// Changing Cost Allocation to Line Item Level and Save details
			FlowBuyersDesk.changeToCostAtLineLevel(driver, testCaseName);
			// PageBuyersDesk.clickOnSave(driver, testCaseName);

			// entering cost booking and accounting details and Save
			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.enterProjectForCostBookingItemLevel(driver, testCaseName, buyersdesk.getProject());
			PageBuyersDesk.enterBudgetForCostBookingItemLevel(driver, testCaseName, buyersdesk.getBudget());
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);

			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			// creating new free text item
			buyersdesk = ObjectCreation.createItem();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifying if free text item is created
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// checking cost center of free text item matches with Req cost
			// center.
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center matched with req cost center", flag_cost_center_matched);

			mappedTestCases.get(0).setTestResult(flag_cost_center_matched);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11890 <b>Description : Add free text items: Verify On adding free
	 * text items to the requisition; cost booking information of the item
	 * should be empty/blank in case 'Book cost at line item level' is selected
	 * and requisition s OU is NOT requester s default OU </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11890(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String company_Req = null, ouCompany = null;
		String bUnit_Req = null, ouBusinessUnit = null;
		String location_Req = null, ouLocation = null;
		String reqNumber = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		String onBehalfOf = null;
		String purchaseType = null;
		boolean flag_req_approval = false;
		boolean flag_ou_matched = false;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_cost_center_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			onBehalfOf = MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);
			PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, onBehalfOf);
			PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, CommonUtilities.getReqName());
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, purchaseType);
			String settlementVia = "SETTLEMENT_VIA_OPTION_INVOICE";
			PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, settlementVia);
			PageBuyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);

			// changing Req CBL i.e. Company/BusinessUnit/Location
			FlowRequisition.changeCompanyBULocationOfUser(driver, testCaseName);

			// Navigate to Cost Allocation and select Book at line item level
			PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
			PageBuyersDesk.clickCostAtLineLevelRadioButton(driver, testCaseName);
			PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);

			// get Req OU i.e. Company/BusinessUnit/Location
			company_Req = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			bUnit_Req = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			location_Req = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			// fetching data for updating CC/Project/Budget
			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 2));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 2));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 2));

			// entering cost booking and accounting details
			FlowBuyersDesk.changeCostcenterProjectBudgetLineLevel(driver, testCaseName, buyersdesk);

			// Submitting Requisiiton
			FlowRequisition.submitRequisiiton(driver, testCaseName);

			// getting created req number
			reqNumber = PageBuyersDesk.getCreatedReqNumber(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get OU i.e. Company/BusinessUnit/Location from Buyers Desk and
			// compares with Create Req Page
			ouCompany = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			ouBusinessUnit = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			ouLocation = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			if (company_Req.equalsIgnoreCase(ouCompany) && bUnit_Req.equalsIgnoreCase(ouBusinessUnit) && location_Req.equalsIgnoreCase(ouLocation))
			{
				flag_ou_matched = true;
			}
			Assert.assertTrue("Buyer's desk OU matched with Req OU", flag_ou_matched);

			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			// creating new free text item
			buyersdesk = ObjectCreation.createItem();
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifying if free text item is created
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// checking cost center of free text item matches with Req cost
			// center.
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = false;
			}
			else if (itemCostCenter == null)
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center value displayed as Empty/Blank", flag_cost_center_matched);

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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11891 <b>Description : Add free text items: Verify On adding free
	 * text items to the requisition; cost booking information of the item
	 * should be displayed according to requester + buyer scope </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	// new attribute is being added for value on create free text item modal for
	// USer currency field
	public void EPROC_11891(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String userName = null;
		String costCenter = null;
		String userDefaultCurrency = null;
		boolean flag_add_button = false;
		boolean user_default_currency_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			CommonServices.startTestCase(driver, testCase);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			/** TC: EPROC_11856 **/
			// gets user default currency from manage profile page
			userDefaultCurrency = FlowBuyersDesk.getUserDefaultCurrency(driver, testCaseName);

			// Navigates to Buyer Desk and selects created Req
			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.setStatusAsPendingQrder(driver, testCaseName);
			// PageBuyersDeskListing.searchRequisitionNumberInFilter(driver,
			// testCaseName, reqNumber);
			FlowBuyersDeskListing.clickOnEditAction(driver, testCaseName);

			// navigates to create free text item page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// get currency displayed under Create free text item
			WebElement ele = ActionBot.findElement(driver, By.xpath("(//input[@name='currency'])[1]"));
			// ele.click();
			String currency = ele.getAttribute("value");

			System.out.println("Currency: " + currency);

			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			if (userDefaultCurrency.equalsIgnoreCase(currency))
			{
				user_default_currency_matched = true;
				Assert.assertTrue("Default value in Currency field in add free text item modal is requester user currency", user_default_currency_matched);
			}
			else
			{
				Assert.assertTrue("Default value in Currency field in add free text item modal is not as per requester user currency", user_default_currency_matched);
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
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11898 <b>Description : Add Free text items: Verify working of
	 * 'Allow PRs (containing newly added item(s)) total amount to exceed the
	 * approved PRs total amount up to the (radio button) smaller or (radio
	 * button) larger of _ % of approved PRs total amount or _ currency units'
	 * setting </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11898(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqTotalPrice = null;
		String prTotalAmount = null;
		String prCurrencyUnits = null;
		String reqNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_allowPr_smaller = false;
		boolean flag_tolerance_error = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11896"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11897"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11901"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11902"));
			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Select smaller button from AllowPr and set total amount and
			// currency units;
			BuyersDeskSetting buyersdesksetting = ObjectCreation.enterAllowPrValues();
			flag_allowPr_smaller = FlowBuyersDeskSetting.clickOnAllowPR_Smaller(driver, testCaseName);
			prTotalAmount = FlowBuyersDeskSetting.enterAllowPr_TotalAmount(driver, testCaseName, buyersdesksetting.getAllowPrPercentTotalAmount());
			prCurrencyUnits = FlowBuyersDeskSetting.enterAllowPr_CurrencyUnits(driver, testCaseName, buyersdesksetting.getallowPrCurrenctUnits());

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get Req total price and convert it to threshold %limit
			reqTotalPrice = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			float reqPercentPrice = (Float.parseFloat(reqTotalPrice) * Float.parseFloat(prTotalAmount)) / 100;
			String reqPercentPrice_String = reqPercentPrice + "";

			// navigates to create free text item page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// create new free text item
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// to enter GL account info of req item
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// enter Gl account info for free text item
			FlowBuyersDesk.enterGLAccoutnForReqFreeTextItem(driver, testCaseName, itemNumber);

			// select required by date
			CustomDate customDate = CommonUtilities.getTodaysDate();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			// increasing item price by comparing smallest of AllowPR's amount
			// to get Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// adding 100 to get threshold error
					currencyUnits = currencyUnits + 100;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// adding 100 to get threshold error
					reqPercentPrice = reqPercentPrice + 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			/** TC: EPROC_11896 **/
			// changing item price
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			/** TC: EPROC_11897 **/
			// changing item quantity
			buyersdesk.setQuantity("1");
			PageBuyersDesk.updateFreeTextItemQuantity(driver, testCaseName, buyersdesk.getQuantity(), itemNumber);

			// save quanity and price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			flag_tolerance_error = PageBuyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
			Assert.assertTrue("Tolerance error displayed", flag_tolerance_error);

			// subtracting values to remove Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// subtracting 105 to remove threshold error
					currencyUnits = currencyUnits - 105;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// subtracting 100 to remove threshold error
					reqPercentPrice = reqPercentPrice - 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			// updating price to new value
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			// save price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_tolerance_error);
			mappedTestCases.get(1).setTestResult(flag_tolerance_error);
			mappedTestCases.get(2).setTestResult(flag_tolerance_error);
			mappedTestCases.get(3).setTestResult(flag_tolerance_error);
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
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11899 <b>Description : Add Free text items: Verify working of
	 * 'Allow PRs (containing newly added item(s)) total amount to exceed the
	 * approved PRs total amount up to the (radio button) smaller or (radio
	 * button) larger of _ % of approved PRs total amount or _ currency units'
	 * setting [Check in case either field is empty] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11899(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqTotalPrice = null;
		String prTotalAmount = null;
		String prCurrencyUnits = null;
		String reqNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_allowPr_smaller = false;
		boolean flag_tolerance_error = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Select smaller button from AllowPr and set total amount and
			// currency units;
			BuyersDeskSetting buyersdesksetting = ObjectCreation.enterAllowPrValues();
			flag_allowPr_smaller = FlowBuyersDeskSetting.clickOnAllowPR_Smaller(driver, testCaseName);
			prTotalAmount = FlowBuyersDeskSetting.enterAllowPr_TotalAmount(driver, testCaseName, buyersdesksetting.getAllowPrPercentTotalAmount());
			prCurrencyUnits = "1";

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get Req total price and convert it to threshold %limit
			reqTotalPrice = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			float reqPercentPrice = (Float.parseFloat(reqTotalPrice) * Float.parseFloat(prTotalAmount)) / 100;
			String reqPercentPrice_String = reqPercentPrice + "";

			// navigates to create free text item page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// create new free text item
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// to enter GL account info of req item
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// enter Gl account info for free text item
			FlowBuyersDesk.enterGLAccoutnForReqFreeTextItem(driver, testCaseName, itemNumber);

			// select required by date
			CustomDate customDate = CommonUtilities.getTodaysDate();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			// increasing item price by comparing smallest of AllowPR's amount
			// to get Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// adding 100 to get threshold error
					currencyUnits = currencyUnits + 100;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// adding 100 to get threshold error
					reqPercentPrice = reqPercentPrice + 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			/** TC: EPROC_11896 **/
			// changing item price
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			/** TC: EPROC_11897 **/
			// changing item quantity
			buyersdesk.setQuantity("1");
			PageBuyersDesk.updateFreeTextItemQuantity(driver, testCaseName, buyersdesk.getQuantity(), itemNumber);

			// save quanity and price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			flag_tolerance_error = PageBuyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
			Assert.assertFalse("Tolerance error displayed", flag_tolerance_error);

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
				FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11900 <b>Description : Add Free text items: Verify working of
	 * 'Allow PRs (containing newly added item(s)) total amount to exceed the
	 * approved PRs total amount up to the (radio button) smaller or (radio
	 * button) larger of _ % of approved PRs total amount or _ currency units'
	 * setting [Check in case of 0 value] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11900(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqTotalPrice = null;
		String prTotalAmount = null;
		String prCurrencyUnits = null;
		String reqNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_allowPr_smaller = false;
		boolean flag_tolerance_error = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			// Select smaller button from AllowPr and set total amount and
			// currency units;
			BuyersDeskSetting buyersdesksetting = ObjectCreation.enterAllowPrValues();
			buyersdesksetting.setAllowPrCurrenctUnits("0");
			buyersdesksetting.setAllowPrPercentTotalAmount("0");
			flag_allowPr_smaller = FlowBuyersDeskSetting.clickOnAllowPR_Smaller(driver, testCaseName);
			prTotalAmount = FlowBuyersDeskSetting.enterAllowPr_TotalAmount(driver, testCaseName, buyersdesksetting.getAllowPrPercentTotalAmount());
			prCurrencyUnits = FlowBuyersDeskSetting.enterAllowPr_CurrencyUnits(driver, testCaseName, buyersdesksetting.getallowPrCurrenctUnits());

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get Req total price and convert it to threshold %limit
			reqTotalPrice = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			float reqPercentPrice = (Float.parseFloat(reqTotalPrice) * Float.parseFloat(prTotalAmount)) / 100;
			String reqPercentPrice_String = reqPercentPrice + "";

			// navigates to create free text item page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// create new free text item
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// to enter GL account info of req item
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// enter Gl account info for free text item
			FlowBuyersDesk.enterGLAccoutnForReqFreeTextItem(driver, testCaseName, itemNumber);

			// select required by date
			CustomDate customDate = CommonUtilities.getTodaysDate();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			// increasing item price by comparing smallest of AllowPR's amount
			// to get Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// adding 100 to get threshold error
					currencyUnits = currencyUnits + 100;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// adding 100 to get threshold error
					reqPercentPrice = reqPercentPrice + 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			/** TC: EPROC_11896 **/
			// changing item price
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			/** TC: EPROC_11897 **/
			// changing item quantity
			buyersdesk.setQuantity("1");
			PageBuyersDesk.updateFreeTextItemQuantity(driver, testCaseName, buyersdesk.getQuantity(), itemNumber);

			// save quanity and price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			flag_tolerance_error = PageBuyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
			Assert.assertTrue("Tolerance error displayed", flag_tolerance_error);

			// subtracting values to remove Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// subtracting 105 to remove threshold error
					currencyUnits = currencyUnits - 105;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// subtracting 100 to remove threshold error
					reqPercentPrice = reqPercentPrice - 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			// updating price to new value
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			// save price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

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
				FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11903 <b>Description : Add Free text items: Verify working of
	 * 'Allow PRs (containing newly added item(s)) total amount to exceed the
	 * approved PRs total amount up to the (radio button) smaller or (radio
	 * button) larger of _ % of approved PRs total amount or _ currency units'
	 * setting in the following scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11903(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqTotalPrice = null;
		String prTotalAmount = null;
		String prCurrencyUnits = null;
		String reqNumber = null;
		boolean flag_add_button = false;
		boolean flag_item_added = false;
		boolean flag_allowPr_smaller = false;
		boolean flag_tolerance_error = false;
		boolean flag_req_approval = false;
		int index = 0;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
			PageBuyersDeskSettings.clearItemReceivedByAmount(driver, testCaseName);

			// Select smaller button from AllowPr and set total amount and
			// currency units;
			BuyersDeskSetting buyersdesksetting = ObjectCreation.enterAllowPrValues();
			flag_allowPr_smaller = FlowBuyersDeskSetting.clickOnAllowPR_Smaller(driver, testCaseName);
			prTotalAmount = FlowBuyersDeskSetting.enterAllowPr_TotalAmount(driver, testCaseName, buyersdesksetting.getAllowPrPercentTotalAmount());
			prCurrencyUnits = FlowBuyersDeskSetting.enterAllowPr_CurrencyUnits(driver, testCaseName, buyersdesksetting.getallowPrCurrenctUnits());
			PageBuyersDeskSettings.enterItemReceivedByAmount(driver, testCaseName, "500");

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get Req total price and convert it to threshold %limit
			reqTotalPrice = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
			float reqPercentPrice = (Float.parseFloat(reqTotalPrice) * Float.parseFloat(prTotalAmount)) / 100;
			String reqPercentPrice_String = reqPercentPrice + "";

			// navigates to create free text item page
			flag_add_button = PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			Assert.assertTrue("Add Item button displayed on Page", flag_add_button);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// create new free text item
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// to enter GL account info of req item
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// enter Gl account info for free text item
			FlowBuyersDesk.enterGLAccoutnForReqFreeTextItem(driver, testCaseName, itemNumber);

			// select required by date
			CustomDate customDate = CommonUtilities.getTodaysDate();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			// increasing item price by comparing smallest of AllowPR's amount
			// to get Tolerance Error
			if (flag_allowPr_smaller == true)
			{
				float currencyUnits = Float.parseFloat(prCurrencyUnits);
				if (reqPercentPrice > currencyUnits)
				{
					// adding 100 to get threshold error
					currencyUnits = currencyUnits + 100;
					// converting to String to set Item price
					prCurrencyUnits = currencyUnits + "";
					buyersdesk.setPrice(prCurrencyUnits);
				}
				else
				{
					// adding 100 to get threshold error
					reqPercentPrice = reqPercentPrice + 100;
					// converting to String to set Item price
					reqPercentPrice_String = reqPercentPrice + "";
					buyersdesk.setPrice(reqPercentPrice_String);
				}
			}

			/** TC: EPROC_11896 **/
			// changing item price
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), itemNumber);

			/** TC: EPROC_11897 **/
			// changing item quantity
			buyersdesk.setQuantity("1");
			PageBuyersDesk.updateFreeTextItemQuantity(driver, testCaseName, buyersdesk.getQuantity(), itemNumber);

			// save quanity and price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			flag_tolerance_error = PageBuyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
			Assert.assertTrue("Tolerance error displayed", flag_tolerance_error);

			// deleting free text item
			PageBuyersDesk.clickDeleteItemIcon(driver, testCaseName, itemNumber);
			PageBuyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);

			int quantity = onlinestore.getQuantity() * 2;

			// changing item quantity to verify tolerance error
			PageBuyersDesk.fillQuantity(driver, testCaseName, onlinestore.getItemId(), quantity);
			// save price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			flag_tolerance_error = PageBuyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
			Assert.assertFalse("Tolerance error displayed", flag_tolerance_error);

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
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
				PageBuyersDeskSettings.clearItemReceivedByAmount(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11904 <b>Description : Replace-Catalog item: Verify Buyer should be
	 * able to replace items on a requisition on buyers desk </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11904(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String itemNumber = null;
		String itemName = null;
		String reqNumber = null;
		String replacedItemNumber = null;
		String replaceItemPageHeader = null;
		String getReplaceItemPageHeader = null;
		String getDisplayedCategory = null;
		String userDefaultCurrency = null;
		String reqCurrency = null;
		boolean flag_req_approval = false;
		boolean flag_replace_icon_enabled = false;
		boolean flag_item_replaced = false;
		boolean flag_req_saved = false;
		boolean flag_replace_item_page_header = false;
		boolean flag_replace_button_displayed = false;
		boolean flag_cancel_and_go_back_button_displayed = false;
		boolean flag_displayed_category = false;
		boolean flag_currency_matched = false;
		boolean flag_convertToPoButton_displayed = true;
		boolean flag_convertToPoLink_displayed = true;
		boolean flag_confirm_button_displayed = false;
		boolean flag_link_cancel_displayed = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11905"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11908"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11909"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11910"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11912"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11913"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11940"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11941"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11942"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11943"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11944"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11957"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11958"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11960"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12203"));
			}

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			ReplaceItem replaceitem = new ReplaceItem();

			// gets user default currency from manage profile page
			userDefaultCurrency = FlowBuyersDesk.getUserDefaultCurrency(driver, testCaseName);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			itemName = PageBuyersDesk.getReqDefaultItemName(driver, testCaseName);

			// creating string to compare against header
			replaceItemPageHeader = "Replacing \"" + itemName + "\" on " + reqNumber;

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			/** TC: EPROC_11910, EPROC_11958, EPROC_12203 **/
			// click on replace icon button and replace Req Item
			FlowReplaceItem.replaceReqItem(driver, testCaseName, itemNumber, replaceitem);

			getReplaceItemPageHeader = replaceitem.getPageHeader();
			// verify replace item page header
			if (replaceItemPageHeader.equalsIgnoreCase(getReplaceItemPageHeader))
			{
				flag_replace_item_page_header = true;
			}
			Assert.assertTrue("Page Header verification Passed", flag_replace_item_page_header);

			/** TC: EPROC_11913 **/
			// verify product category
			getDisplayedCategory = replaceitem.getDisplayedCategory();
			if (getDisplayedCategory != null)
			{
				flag_displayed_category = true;
			}
			Assert.assertTrue("Category Displayed on Replace Item Page", flag_displayed_category);

			// verify button visibility on Replace item page
			flag_replace_button_displayed = replaceitem.getButtonReplaceDisplayed();
			flag_cancel_and_go_back_button_displayed = replaceitem.getButtonCancelAndGoBack();

			if (flag_replace_button_displayed == true && flag_cancel_and_go_back_button_displayed == true)
			{
				Assert.assertTrue("Replace button and Cancel & Go back button Displayed", true);
			}
			else
			{
				Assert.assertTrue("Replace button and Cancel & Go back button Displayed", false);
			}

			/** TC: EPROC-11957 **/
			// verify if button confirm and link cancel displayed on clicking
			// Replace item button
			flag_confirm_button_displayed = replaceitem.getButtonConfirmDisplayed();
			flag_link_cancel_displayed = replaceitem.getLinkCancelDisplayed();
			if (flag_confirm_button_displayed == true && flag_link_cancel_displayed == true)
			{
				Assert.assertTrue("Button confirm and link cancel displayed on clicking replace button", true);
			}
			else
			{
				Assert.assertTrue("Button confirm and link cancel displayed on clicking replace button", false);
			}

			// verify if item gets replaced
			replacedItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			if (!itemNumber.equalsIgnoreCase(replacedItemNumber))
			{
				flag_item_replaced = true;
			}
			Assert.assertTrue("Item replaced successfully", flag_item_replaced);

			/** TC: EPROC-11943 **/
			// verify button convert to po is displayed after replacing item
			flag_convertToPoButton_displayed = PageBuyersDesk.verifyButtonConvertToPo(driver, testCaseName);
			Assert.assertFalse("Button Convert to PO not diplsyed after replacing item", flag_convertToPoButton_displayed);

			/** TC: EPROC-11942 **/
			// verify replace item currency gets converted to user currency
			reqCurrency = PageBuyersDesk.getReqPurchaseCurrencyType(driver, testCaseName);
			if (reqCurrency.equalsIgnoreCase(userDefaultCurrency))
			{
				flag_currency_matched = true;
			}
			Assert.assertTrue("Replace item currency gets converted to user currency", flag_currency_matched);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// enter GL account details for replaced item
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// save replaced item to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			/** TC: EPROC-11944 **/
			// verify if convert to po link is displayed under actions
			flag_convertToPoLink_displayed = PageBuyersDeskListing.verifyLinkConvertToPoDisplayed(driver, testCaseName);
			if (flag_convertToPoLink_displayed == false)
			{
				Assert.assertFalse("Link Convert to PO not displayed after item is replaced", flag_convertToPoLink_displayed);
				flag_convertToPoLink_displayed = true;
			}

			mappedTestCases.get(0).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(1).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(2).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(3).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(4).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(5).setTestResult(flag_displayed_category);
			mappedTestCases.get(6).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(7).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(8).setTestResult(flag_currency_matched);
			mappedTestCases.get(9).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(10).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(11).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(12).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(13).setTestResult(flag_convertToPoLink_displayed);
			mappedTestCases.get(14).setTestResult(flag_replace_item_page_header);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11906 <b>Description : Replace-Catalog item: Verify Buyer should
	 * NOT be able to replace items on a requisition on buyers desk if 'Allow
	 * buyer to replace existing items on a requisition' setting is NO </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11906(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String itemNumber = null;
		String replacedItemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_item_not_replaced = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11911"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11959"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as No
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			// filling req details and getting newly created reqNumber
			reqNumber_11906 = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber_11906);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber_11906);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11906);

			// to verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			if (flag_replace_icon_enabled == false)
			{
				flag_replace_icon_enabled = true;
			}
			Assert.assertTrue("Replace Icon not Displayed", flag_replace_icon_enabled);

			/** EPROC_11911 **/
			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11906);

			// fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			/** TC: EPROC_11959 **/
			// select item and click on cancel and go back button
			PageReplaceItem.clickOnRadioItem(driver, testCaseName);
			PageReplaceItem.clickCancelAndGoBackButton(driver, testCaseName);

			// verify if item gets replaced or not
			replacedItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			if (itemNumber.equalsIgnoreCase(replacedItemNumber))
			{
				flag_item_not_replaced = true;
			}
			Assert.assertTrue("Item not replaced", flag_item_not_replaced);

			mappedTestCases.get(0).setTestResult(flag_item_not_replaced);
			mappedTestCases.get(1).setTestResult(flag_item_not_replaced);
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
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11915 <b>Description : Replace-Catalog item: Verify On replace item
	 * screen; buyer should be able to search for items by product
	 * description </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11906" })
	public void EPROC_11915(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String itemNumber = null;
		String productDescription = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_replace_item_result_displayed = false;
		boolean flag_supplier_name_search_result_displayed = false;
		boolean flag_part_number_search_result_displayed = false;
		boolean flag_page_items_on_replace_item_page = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11916"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11917"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11918"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11919"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11923"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11906);

			// fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// gets item description
			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);
			productDescription = PageBuyersDesk.getItemDescription(driver, testCaseName);
			PageBuyersDesk.clickCloseOnItemPopUp(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			/**
			 * TC: // Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			 * // items to a requisition' as Yes
			 * FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
			 * 
			 * // Navigates to Buyer Desk and selects created Req
			 * FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11906);
			 * 
			 * // fetching item values for verification
			 * itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			 * 
			 * // gets item description
			 * PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);
			 * productDescription = PageBuyersDesk.getItemDescription(driver, testCaseName);
			 * PageBuyersDesk.clickCloseOnItemPopUp(driver, testCaseName);
			 * 
			 * // selects item displayed on Page
			 * PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			 * 
			 * // to verify replace item button is enabled or not
			 * flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			 * Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);
			 * 
			 * // Navigate to replace item page
			 * PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);
			 **/
			// to verify below items displayed on page:
			// itemImage,itemName,itemDescription,itemSupplierName,itemLeadTime,iconIsGreen,iconIsPreferred,itemPrice
			ReplaceItem replaceitem = new ReplaceItem();
			FlowReplaceItem.verifyReplaceItemPageDetails(driver, testCaseName, replaceitem);
			// verifies if all below items are displayed on Replace item page
			if (replaceitem.getItemImage() == true && replaceitem.getItemName() == true && replaceitem.getItemDescription() == true && replaceitem.getItemSupplierName() == true
				&& replaceitem.getItemLeadTime() && replaceitem.getIconIsGreen() == true && replaceitem.getIconIsPreferred() == true && replaceitem.getItemPrice() == true)
			{

				flag_page_items_on_replace_item_page = true;
			}
			Assert.assertTrue("All items displayed on Replace item page", flag_page_items_on_replace_item_page);

			// enters text for Product Description box and verify result
			PageReplaceItem.enterproductDescription(driver, testCaseName, productDescription);
			flag_replace_item_result_displayed = PageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
			if (flag_replace_item_result_displayed == true)
			{
				Assert.assertTrue("Search Result displayed when product description provided", flag_replace_item_result_displayed);
			}
			else
			{
				Assert.assertTrue("NO Result displayed when product description provided", false);
			}

			/** TC: EPROC_11916 **/
			// Clears Product description from search fields
			PageReplaceItem.clearProductDescription(driver, testCaseName);

			// Searching for item using Supplier Name
			BuyersDesk buyersDesk = ObjectCreation.createItem();
			String supplierName = buyersDesk.getSupplierName();
			PageOnlineStore.fillSearchText(driver, testCaseName, supplierName);
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Verify is result is displayed when searched with supplier name
			flag_supplier_name_search_result_displayed = PageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
			if (flag_replace_item_result_displayed == true)
			{
				Assert.assertTrue("Search Result displayed when supplier name provided", flag_replace_item_result_displayed);
			}
			else
			{
				Assert.assertTrue("NO Result displayed when supplier name provided", false);
			}

			/** TC: EPROC_11917 **/
			// Searching for item using Part Number
			PageOnlineStore.fillSearchText(driver, testCaseName, itemNumber);
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Verify is result is displayed when searched with part number
			flag_part_number_search_result_displayed = PageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
			if (flag_part_number_search_result_displayed == true)
			{
				Assert.assertTrue("Search Result displayed when part number provided", flag_part_number_search_result_displayed);
			}
			else
			{
				Assert.assertTrue("NO Result displayed when part number provided", false);
			}

			PageReplaceItem.clickCancelAndGoBackButton(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_supplier_name_search_result_displayed);
			mappedTestCases.get(1).setTestResult(flag_part_number_search_result_displayed);
			mappedTestCases.get(2).setTestResult(flag_replace_item_result_displayed);
			mappedTestCases.get(3).setTestResult(flag_replace_item_result_displayed);
			mappedTestCases.get(4).setTestResult(flag_page_items_on_replace_item_page);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11924 <b>Description : Replace-Catalog item: Verify On clicking on
	 * item name in replace item screen; item modal should open with the
	 * following fields: Item name; Part id; price; details tab; specification
	 * tab; attachments tab; Is green; is preferred icon </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_11906" })
	public void EPROC_11924(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String itemNumber = null;
		String itemName = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_item_details_popup_fields = false;
		boolean flag_field_on_details_tab = false;
		boolean flag_field_on_specification_tab = false;
		boolean flag_field_on_attachment_tab = false;
		boolean flag_compare = false;
		boolean flag_addToCart = false;
		boolean flag_addToBasket = false;
		boolean flag_addToFavourite = false;
		boolean flag_replaceIcon_disabled = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11925"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11926"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11927"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11928"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11929"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11930"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11931"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11932"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11933"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11934"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11935"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11936"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11937"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11938"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11939"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11945"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11946"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11947"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11948"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11949"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11950"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11951"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11952"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11953"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11954"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11955"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11956"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11966"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11961"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11962"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11963"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11964"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11965"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects created Req
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12723");
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11906);

			// fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			itemName = PageBuyersDesk.getReqDefaultItemName(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// Searching for item using Part Number
			// PageOnlineStore.fillSearchText(driver, testCaseName,
			// "AutomationItem");
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 2));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// verify items displayed under Item Pop-up
			PageReplaceItem.clickItemName(driver, testCaseName);
			ReplaceItem replaceitem = new ReplaceItem();
			FlowReplaceItem.verifyItemDetailsPopupFileds(driver, testCaseName, replaceitem);
			Assert.assertTrue("Item Details Popup Displayed", replaceitem.getItemDetailsPopupDisplayed());

			if (replaceitem.getItemNamePopupItemDetails() == true && replaceitem.getItemPartIdPopupItemDetails() == true && replaceitem.getItemPricePopupItemDetails() == true
				&& replaceitem.getIconIsGreenPopupItemDetails() == true && replaceitem.getIconIsPreferredPopupItemDetails() == true
				&& replaceitem.getTabDetailsPopupItemDetails() == true && replaceitem.getTabAttachmentPopupItemDetails() == true
				&& replaceitem.getTabSpecificationPopupItemDetails() == true)
			{
				flag_item_details_popup_fields = true;
			}
			Assert.assertTrue("Fields in Item Details Popup displayed properly", flag_item_details_popup_fields);

			/** TC: EPROC_11925 **/
			// verify fields present under Details Tab on Item Popup
			flag_field_on_details_tab = PageReplaceItem.verifyFieldsOnDetailsTabItemPopup(driver, testCaseName);
			Assert.assertTrue("Fields dispayed properly on Details Tab", flag_field_on_details_tab);

			/** TC: EPROC_11926 **/
			// verify specificaiton name and key-value on page
			flag_field_on_specification_tab = PageReplaceItem.verifyFieldsOnSpecificationTabItemPopup(driver, testCaseName);
			Assert.assertTrue("Fields dispayed properly on Specification Tab", flag_field_on_specification_tab);

			/** TC: EPROC_11927 **/
			// verify web links on page
			flag_field_on_attachment_tab = PageReplaceItem.verifyFieldsOnAttachmentsTabItemPopup(driver, testCaseName);
			Assert.assertTrue("Fields dispayed properly on Attachment Tab", flag_field_on_attachment_tab);
			// closes item Details popup window
			PageReplaceItem.clickCloseOnItemPopUp(driver, testCaseName);

			/** TC: EPROC_11928 **/
			// verify Compare/AddtoCart/AddtoFavourites/AddtoBasket not to be
			// displayed in LIST view
			PageReplaceItem.clickOnRadioItem(driver, testCaseName);
			flag_compare = PageSearchListing.isCompareLinkDisplayed(driver, testCaseName);
			flag_addToBasket = PageSearchListing.isAddToBasketLinkDisplayed(driver, testCaseName);
			flag_addToCart = PageSearchListing.isAddToCartLinkDisplayed(driver, testCaseName);
			flag_addToFavourite = PageSearchListing.isAddToFavouriteDisplayed(driver, testCaseName);

			if (flag_compare == false && flag_addToBasket == false && flag_addToCart == false && flag_addToFavourite == false)
			{
				Assert.assertTrue("Actions not displayed on Replace Item Page for List View", true);
			}
			else
			{
				Assert.assertTrue("Actions displayed on Replace Item Page for List View", false);
			}

			/** TC: EPROC-11929 **/
			// verifying Compare/AddtoCart/AddtoFavourites/AddtoBasket not to be
			// displayed in GRID view
			PageSearchListing.clickOnSwitchToGridView(driver, testCaseName);
			PageReplaceItem.clickOnRadioItemGrid(driver, testCaseName);
			flag_compare = PageSearchListing.isCompareLinkDisplayed(driver, testCaseName);
			flag_addToBasket = PageSearchListing.isAddToBasketLinkDisplayed(driver, testCaseName);
			flag_addToCart = PageSearchListing.isAddToCartLinkDisplayed(driver, testCaseName);
			flag_addToFavourite = PageSearchListing.isAddToFavouriteDisplayed(driver, testCaseName);

			if (flag_compare == false && flag_addToBasket == false && flag_addToCart == false && flag_addToFavourite == false)
			{
				Assert.assertTrue("Actions not displayed on Replace Item Page for Grid View", true);
			}
			else
			{
				Assert.assertTrue("Actions displayed on Replace Item Page for Grid View", false);
			}

			PageSearchListing.clickOnSwitchToListView(driver, testCaseName);

			/** TC: EPROC-11931 **/
			// sort by Price: Low to High
			PageSearchListing.clickSortByPriceLowToHigh(driver, testCaseName);

			/** TC: EPROC-11932 **/
			// sort by Price: High to Low
			PageSearchListing.clickSortByPriceHighToLow(driver, testCaseName);

			/** TC: EPROC-11933 **/
			// sort by Lead: Low to High
			PageSearchListing.clickSortByLeadLowToHigh(driver, testCaseName);

			/** TC: EPROC-11934 **/
			// sort by Lead: High to Low
			PageSearchListing.clickSortByLeadHighToLow(driver, testCaseName);

			/** TC: EPROC-11930 **/
			// sort by Relevance
			PageSearchListing.clickSortByRelevance(driver, testCaseName);

			/** TC: EPROC-11935, EPROC-11953, EPROC-11945 **/
			// click on item with max char
			FlowReplaceItem.searchItemAndVerifyPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME, 0),
				"(.//*[contains(@class,'ui-dialog-titlebar')]//*[@title='Close']//*[text()='Close'])");

			/** TC: EPROC-11936, EPROC-11954, EPROC-11946 **/
			// click on item with Special char
			FlowReplaceItem.searchItemAndVerifyPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHARACTER_ITEMNAME, 0),
				"(.//*[contains(@class,'ui-dialog-titlebar')]//*[@title='Close']//*[text()='Close'])");

			/** TC: EPROC-11937, EPROC-11955, EPROC-11947 **/
			// click on item with Multi lingual char
			FlowReplaceItem.searchItemAndVerifyPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHARACTER_ITEMNAME, 0),
				"(.//*[contains(@class,'ui-dialog-titlebar')]//*[@title='Close']//*[text()='Close'])");

			/** TC: EPROC-11938, EPROC-11956, EPROC-11948 **/
			// click on item with Script char
			FlowReplaceItem.searchItemAndVerifyPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Script_char_item_name, 0),
				"(.//*[contains(@class,'ui-dialog-titlebar')]//*[@title='Close']//*[text()='Close'])");

			/** TC: EPROC-11939 **/
			// verifies if pop-up is displayed on clicking replace item button
			// w/o selecting item
			PageReplaceItem.clickOnReplaceItemButton(driver, testCaseName);
			PageReplaceItem.clickButtonAlertOk(driver, testCaseName);

			// navigate back to Edit Req Page
			PageReplaceItem.clickCancelAndGoBackButton(driver, testCaseName);

			/** TC: EPROC_11966 **/
			// Replace item icon shall be disabled if item is not selected
			flag_replaceIcon_disabled = PageBuyersDesk.verifyReplaceIconEnabledForFreeTextItem(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace icon disabled when item not selected on Page", flag_replaceIcon_disabled);

			/**
			 * TC: EPROC-11961,EPROC-11962,EPROC-11963,EPROC-11964,EPROC-11965
			 **/
			// comment to be entered while replacing item
			String changeComment = CommonServices.getTestData(IConstantsData.ALL_CHARACTERS);

			// index of item to be selected
			int index = 1;
			String auditMessage = FlowBuyersDesk.replaceItemAndVerifyAuditTrailComment(driver, testCaseName, itemNumber, changeComment, reqNumber_11906, index);
			// String auditMessage =
			// FlowBuyersDesk.replaceItemAndVerifyAuditTrailComment(driver,
			// testCaseName, itemNumber, changeComment,"COM001/PR/12723",
			// index);

			// replaces encoded value of & i.e. &amp; top &
			StrBuilder sb = new StrBuilder(auditMessage);
			sb.replaceAll("amp;", "");

			if (sb.contains(changeComment))
			{
				Assert.assertTrue("Change comment displayed correctly", true);
			}
			else
			{
				Assert.assertTrue("Change comment not displayed correctly", false);
			}

			mappedTestCases.get(0).setTestResult(flag_field_on_details_tab);
			mappedTestCases.get(1).setTestResult(flag_field_on_specification_tab);
			mappedTestCases.get(2).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(3).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(4).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(5).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(6).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(7).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(8).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(9).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(10).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(11).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(12).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(13).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(14).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(15).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(16).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(17).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(18).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(19).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(20).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(21).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(22).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(23).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(24).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(25).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(26).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(27).setTestResult(flag_replaceIcon_disabled);
			mappedTestCases.get(28).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(29).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(30).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(31).setTestResult(flag_field_on_attachment_tab);
			mappedTestCases.get(32).setTestResult(flag_field_on_attachment_tab);
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
				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_11873 <b>Description : Verify adding free text item to a
	 * requisition with script characters in the following fields in mentioned
	 * fields in steps: </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11873(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqNumber = null;
		boolean flag_req_approval = false;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11878"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
			FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// click/verifies if Add Item button displayed on page
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// creates new Item: Fill item details and click on Add Button
			BuyersDesk buyersdesk = ObjectCreation.createItem();

			// updating item values to check XSS Handling
			String xss = CommonServices.getTestData(IConstantsData.Script_char_item_name);
			buyersdesk.setItemNumber(xss);
			buyersdesk.setItemShortDescription(xss);
			buyersdesk.setItemLongDescription(xss);
			buyersdesk.setManufacturerName(xss);
			buyersdesk.setManufacturerPartId(xss);
			buyersdesk.setSpecificationName(xss);
			buyersdesk.setSpecificationKey(xss);
			buyersdesk.setSpecificationValue(xss);
			buyersdesk.setAddressInRequirementTab(xss);
			buyersdesk.setContractNumber(xss);

			// fill item and extra item details
			buyersdesk = FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			buyersdesk = FlowBuyersDesk.fillExtraItemDetails(driver, testCaseName, buyersdesk);

			// fills requirement details
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			PageBuyersDesk.enterAddressRequirementTab(driver, testCaseName, buyersdesk.getAddressInRequirementTab());

			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.enterContractNumber(driver, testCaseName, buyersdesk.getContractNumber());
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);

			// verifies if created item is displayed under Req Items
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			mappedTestCases.get(0).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to add new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12119 <b>Description : Replace-Free text item: Verify Buyer should
	 * be able to replace item with free text item on a requisition on buyer s
	 * desk if 'Allow buyer to replace new items to a requisition' setting is
	 * Yes </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12119(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_req_approval = false;
		boolean flag_item_added = false;
		boolean flag_workflow_approval_sequence = false;
		boolean flag_convertToPoButton_displayed = true;
		boolean flag_audit_version = false;
		boolean flag_audit_comment = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12121"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12122"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12124"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12126"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12127"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12129"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12130"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12131"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12135"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12136"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12139"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12141"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12144"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12145"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12149"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12150"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12151"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12152"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12153"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12154"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12155"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12156"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12157"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12158"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12161"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11907"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12188"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12210"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12189"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12190"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12204"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12206"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12209"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber_12119 = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber_12119);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber_12119);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/13059");

			// fetching workflow approval list from Buyers Desk Page before
			// creating free-text item
			String workflowBuyer_0[] = PageRequisitionCheckOut.getApprovalWorkFlow(driver, testCaseName);

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			String workflowBuyer_1[] = PageRequisitionCheckOut.getApprovalWorkFlow(driver, testCaseName);
			flag_workflow_approval_sequence = Arrays.equals(workflowBuyer_0, workflowBuyer_1);
			Assert.assertTrue("Workflow Approval list Matched", flag_workflow_approval_sequence);

			/** TC: EPROC_12210 **/
			// verify button convert to po is displayed after replacing item
			flag_convertToPoButton_displayed = PageBuyersDesk.verifyButtonConvertToPo(driver, testCaseName);
			if (flag_convertToPoButton_displayed == false)
			{
				Assert.assertFalse("Button Convert to PO not diplsyed after replacing item", flag_convertToPoButton_displayed);
				flag_convertToPoButton_displayed = true;
			}

			/** TC: EPROC_12204, EPROC_12206 **/
			// save requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			// search req and edit
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);

			// click on audit trail link and get change comment
			PageBuyersDesk.clickAuditTrailLink(driver, testCaseName);
			String auditMessage = PageBuyersDesk.getAuditTrailMessage(driver, testCaseName);

			int auditVersion = PageBuyersDesk.getAuditTrailVersion(driver, testCaseName);

			// replaces encoded value of & i.e. &amp; top &
			StrBuilder sb = new StrBuilder(auditMessage);
			sb.replaceAll("amp;", "");

			String changeComment = CommonServices.getTestData(IConstantsData.ALL_CHARACTERS);

			if (sb.contains(changeComment))
			{
				flag_audit_comment = true;
				Assert.assertTrue("Change comment displayed correctly", flag_audit_comment);
			}
			else
			{
				Assert.assertTrue("Change comment not displayed correctly", flag_audit_comment);
			}

			// to get audit version
			if (auditVersion > 1)
			{
				flag_audit_version = true;
				Assert.assertTrue("Audit version updated correctly", flag_audit_version);
			}
			else
			{
				Assert.assertTrue("Audit version not updated correctly", flag_audit_version);
			}

			/** TC: EPROC_12189 **/
			// changing item price
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.updateFreeTextItemPrice(driver, testCaseName, buyersdesk.getPrice(), buyersdesk.getItemNumber());

			/** TC: EPROC_12190 **/
			// changing item quantity
			PageBuyersDesk.updateFreeTextItemQuantity(driver, testCaseName, buyersdesk.getQuantity(), buyersdesk.getItemNumber());

			// save quanity and price changes to req.
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
			mappedTestCases.get(2).setTestResult(flag_item_added);
			mappedTestCases.get(3).setTestResult(flag_item_added);
			mappedTestCases.get(4).setTestResult(flag_item_added);
			mappedTestCases.get(5).setTestResult(flag_item_added);
			mappedTestCases.get(6).setTestResult(flag_item_added);
			mappedTestCases.get(7).setTestResult(flag_item_added);
			mappedTestCases.get(8).setTestResult(flag_item_added);
			mappedTestCases.get(9).setTestResult(flag_item_added);
			mappedTestCases.get(10).setTestResult(flag_item_added);
			mappedTestCases.get(11).setTestResult(flag_item_added);
			mappedTestCases.get(12).setTestResult(flag_item_added);
			mappedTestCases.get(13).setTestResult(flag_item_added);
			mappedTestCases.get(14).setTestResult(flag_item_added);
			mappedTestCases.get(15).setTestResult(flag_item_added);
			mappedTestCases.get(16).setTestResult(flag_item_added);
			mappedTestCases.get(17).setTestResult(flag_item_added);
			mappedTestCases.get(18).setTestResult(flag_item_added);
			mappedTestCases.get(19).setTestResult(flag_item_added);
			mappedTestCases.get(20).setTestResult(flag_item_added);
			mappedTestCases.get(21).setTestResult(flag_item_added);
			mappedTestCases.get(22).setTestResult(flag_item_added);
			mappedTestCases.get(23).setTestResult(flag_item_added);
			mappedTestCases.get(24).setTestResult(flag_item_added);
			mappedTestCases.get(25).setTestResult(flag_item_added);
			mappedTestCases.get(26).setTestResult(flag_workflow_approval_sequence);
			mappedTestCases.get(27).setTestResult(flag_convertToPoButton_displayed);
			mappedTestCases.get(28).setTestResult(flag_item_added);
			mappedTestCases.get(29).setTestResult(flag_item_added);
			mappedTestCases.get(30).setTestResult(flag_audit_comment);
			mappedTestCases.get(31).setTestResult(flag_audit_version);
			mappedTestCases.get(32).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12120 <b>Description : Replace-Free text item: Verify Buyer should
	 * not be able to replace item with free text item on a requisition on buyer
	 * s desk if 'Allow buyer to replace new items to a requisition' setting is
	 * No </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12120(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, reqNumber_12119);
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, "COM001/PR/10952");

			// fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			if (flag_replace_icon_enabled == false)
			{
				flag_replace_icon_enabled = true;
			}
			Assert.assertTrue("Replace Icon not Displayed", flag_replace_icon_enabled);

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
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12123 <b>Description : Replace-Free text item: Verify Buyer should
	 * be able to close the free text item modal by clicking on cancel or
	 * [x]close option </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12123(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;

		boolean flag_link_cancel = false;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12125"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/10952");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Click_Link_Cancel);
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_link_cancel = buyersdesk.getActionStatus();
			Assert.assertTrue("Unable to click on link cancel", flag_link_cancel);

			/** TC: EPROC_12125 **/
			String itemNumber = buyersdesk.getItemNumber();
			buyersdesk.setActionToPerform(IConstantsData.Action_Click_Button_CancelAndGoBack);

			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			if (flag_item_added == false)
			{
				flag_item_added = true;
				Assert.assertTrue("Item not created", true);
			}

			mappedTestCases.get(0).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12128 <b>Description : Replace-Free text item: Verify Buyer should
	 * be able to replace a free text item to the requisition with duplicate
	 * value in item number field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12128(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				// mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12121"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12715");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			// adding gl account for default item
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnFirstItemEdit(driver, testCaseName);
			PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
			PageBuyersDesk.selectGLAccount(driver, testCaseName, buyersdesk.getGLAccount());

			// creating another item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies if created item is displayed under Req Items
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			// mappedTestCases.get(0).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12132 <b>Description : Replace-Free text item: Verify item type
	 * field in replace free text item modal should display the following
	 * values: Goods (default); service </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12132(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12133"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12148"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12715");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			// verifies default radio value selected for Item Type and Receive
			// By
			if (buyersdesk.getSelectedItemType().equalsIgnoreCase("Goods") && buyersdesk.getSelectedReceivedBy().equalsIgnoreCase("Quantity"))
			{
				Assert.assertTrue("Default item type selectd as Goods and Received By set as Quantity", true);
			}
			else
			{
				Assert.assertTrue("Default item type not selectd as Goods or Received By not set as Quantity", false);
			}

			/** TC: EPROC_12148 **/
			// to verify selected isGreen and isPreferred Radio button
			if (buyersdesk.getSelectedIsGreen().equalsIgnoreCase("No") && buyersdesk.getSelectedIsPreferred().equalsIgnoreCase("No"))
			{
				Assert.assertTrue("Default is Green selectd as No and is Preferred selected as No", true);
			}
			else
			{
				Assert.assertTrue("Default is Green not selectd as No or is Preferred selected as No", false);
			}

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12137 <b>Description : Replace-Free text item: Verify On entering
	 * product category in replace free text item modal; if multiple category
	 * eforms are present for the item then eforms modal should be displayed
	 * with category; count of eforms and eforms </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12137(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		int eformCount = 0;
		int eformListCount = 0;
		String reqItemNumber = null;
		boolean flag_default_eform_displayed = false;
		boolean flag_selected_eform_displayed = false;
		boolean flag_eform_dialog_displayed = false;
		boolean flag_is_category_displayed = false;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12138"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12715");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			String productCategory_0 = buyersdesk.getProductCategory();

			// fetching item values for verification
			reqItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

			// expands box on replace item page and clicks on Guided Procurement
			// button
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);

			/** TC: EPROC_12138 **/
			// fills product category to verify if default e-form in displayed.
			PageBuyersDesk.enterProductCategory(driver, testCaseName, productCategory_0);
			flag_default_eform_displayed = FlowBuyersDesk.verifyEformPresentInRequirementTab(driver, testCaseName);
			Assert.assertTrue("Default eform displayed under Requirement Tab", flag_default_eform_displayed);

			// fills product category and checks if eform dialog is displayed
			// with product category, eforms count and eforms list
			buyersdesk.setProductCategory(CommonServices.getTestData(IConstantsData.Item_Product_Category, 0));
			String productCategory_1 = buyersdesk.getProductCategory();
			PageBuyersDesk.clickItemTab(driver, testCaseName);
			PageBuyersDesk.enterProductCategory(driver, testCaseName, productCategory_1);

			// to check is eform dialog is displayed
			flag_eform_dialog_displayed = PageBuyersDesk.isEformDialogPresent(driver, testCaseName);
			Assert.assertTrue("Eform dialog not displayed on page", flag_eform_dialog_displayed);

			// to check if category is displayed on eform
			flag_is_category_displayed = PageBuyersDesk.isCategoryOnEformDisplayed(driver, testCaseName, productCategory_1);
			Assert.assertTrue("Category not displayed on eform dialog", flag_is_category_displayed);

			// to verify form count and form displayed count
			eformCount = PageBuyersDesk.getEformCount(driver, testCaseName, eformCount);
			eformListCount = PageBuyersDesk.getEformListCount(driver, testCaseName, eformListCount);

			if (eformCount == eformListCount)
			{
				Assert.assertTrue("Eform dialog displayed with matching form count and list count", true);
			}
			else
			{
				Assert.assertTrue("Eform dialog displayed with matching form count and list count", false);
			}

			// Select eform from dialog and check if displayed under Requirement
			// tab
			PageBuyersDesk.clickEformFromList(driver, testCaseName);
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			flag_selected_eform_displayed = FlowBuyersDesk.verifyEformPresentInRequirementTab(driver, testCaseName);

			// PageBuyersDesk.clickOnCancelLinkEformDialog(driver,
			// testCaseName);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_is_category_displayed);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12140 <b>Description : Replace-Free text item: Verify quantity
	 * field in replace free text item modal should accept numeric and decimal
	 * (according to UOM) values </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12140(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12142"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12143"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12715");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// overriding default values to very kg with decimal quantity
			buyersdesk.setUOM(CommonServices.getTestData(IConstantsData.Item_UOM, 0));
			buyersdesk.setQuantity(CommonServices.getTestData(IConstantsData.Item_Quantity, 1));

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12146 <b>Description : Replace-Free text item: Verify default value
	 * in Currency field in replace free text item modal should be buyers user
	 * currency </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12146(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String userDefaultCurrency = null;
		boolean user_default_currency_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// gets user default currency
			userDefaultCurrency = FlowBuyersDesk.getUserDefaultCurrency(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12715");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.NONE);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			// get currency displayed under Create free text item
			PageBuyersDesk.clickItemTab(driver, testCaseName);
			WebElement ele = ActionBot.findElement(driver, By.xpath("(//input[@name='currency'])[1]"));
			String currency = ele.getAttribute("value");
			System.out.println("Currency: " + currency);

			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);
			if (userDefaultCurrency.equalsIgnoreCase(currency))
			{
				user_default_currency_matched = true;
				Assert.assertTrue("Default value in Currency field in add free text item modal is requester user currency", user_default_currency_matched);
			}
			else
			{
				Assert.assertTrue("Default value in Currency field in add free text item modal is not as per requester user currency", user_default_currency_matched);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12159 <b>Description : Replace-Free text item: Verify Buyer should
	 * be able to replace item with free text item on a requisition on buyer s
	 * desk if 'Allow buyer to replace new items to a requisition' setting is
	 * Yes </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12159(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqNumber = null;
		String bpoNumber = null;
		boolean flag_req_approval = false;
		boolean flag_item_added = false;
		boolean flag_show_all_button_enabled = false;
		boolean flag_is_bpo_selected = false;
		boolean flag_req_returned_to_requestor = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12162"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12734");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.NONE);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			// verifying show all button enabled on Free text modal- Supplier
			// Tab
			flag_show_all_button_enabled = PageBuyersDesk.clickShowAllButton(driver, testCaseName);
			Assert.assertTrue("Show All button is enabled", flag_show_all_button_enabled);

			// getting BPO number
			bpoNumber = PageBuyersDesk.selectBPONumber(driver, testCaseName, bpoNumber);
			flag_is_bpo_selected = PageBuyersDesk.verifyBPOSelected(driver, testCaseName, bpoNumber);
			Assert.assertTrue("BPO successfully selected", flag_is_bpo_selected);
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			PageReplaceItem.clickOnConfirm(driver, testCaseName);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			/** TC: EPROC_12162 **/
			// Returning Req to Requestor
			String reqChangeComments = buyersdesk.getReqChangeComments();
			PageBuyersDesk.enterReqChangeComments(driver, testCaseName, reqChangeComments);
			PageBuyersDesk.clickReturnToRequestorButton(driver, testCaseName);
			PageBuyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);

			// to verify req has been removed from Buyers Desk
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
			String reqStatus = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			if (reqStatus.equalsIgnoreCase("Returned"))
			{
				flag_req_returned_to_requestor = true;
			}
			Assert.assertTrue("Requisition returned to requestor", flag_req_returned_to_requestor);

			mappedTestCases.get(0).setTestResult(flag_req_returned_to_requestor);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12164 <b>Description : Replace-Free text item: Verify replacing
	 * free text item to a requisition with maximum characters in the mentioned
	 * fields </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12164(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12165"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12166"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12167"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12721");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// setting item value to validate Max Length, Special Char and
			// Multilingual char
			buyersdesk.setItemNumber(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setItemShortDescription(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setItemLongDescription(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setManufacturerName(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setManufacturerPartId(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setSpecificationName(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setSpecificationKey(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setSpecificationValue(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			buyersdesk.setContractNumber(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
			mappedTestCases.get(2).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12168 <b>Description : Replace-Free text item: Verify Buyer should
	 * NOT be able to replace free text item if value is missing for any
	 * mandatory field in requirement details field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12168(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_item_added = false;
		boolean flag_error_in_requirement_tab = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12169"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12170"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12171"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12172"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12173"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12721");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.NONE);
			buyersdesk.setAddressInRequirementTab(CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			PageBuyersDesk.clearAddressRequirementTab(driver, testCaseName);
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			flag_error_in_requirement_tab = PageBuyersDesk.verifyErrorInRequirementTab(driver, testCaseName);
			Assert.assertTrue("Error message received when mandatory fields is kept Blank", flag_error_in_requirement_tab);

			// validating length, special char and Multilingual char support,
			// XSS handling
			PageBuyersDesk.enterAddressRequirementTab(driver, testCaseName, buyersdesk.getAddressInRequirementTab());
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			PageReplaceItem.clickOnConfirm(driver, testCaseName);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			mappedTestCases.get(0).setTestResult(flag_item_added);
			mappedTestCases.get(1).setTestResult(flag_item_added);
			mappedTestCases.get(2).setTestResult(flag_item_added);
			mappedTestCases.get(3).setTestResult(flag_item_added);
			mappedTestCases.get(4).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12174 <b>Description : Replace-Free text item: Verify On clicking
	 * on create free text item in a requisition; if the requisition is
	 * modified; the mentioned message should be displayed </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "EPROC_12119" })
	public void EPROC_12174(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_is_free_text_model_displayed = false;
		boolean flag_changed_value = false;
		boolean flag_dont_save_cc_project_budget_changes = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12175"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12176"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12980");

			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 0));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 0));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 0));

			// changes cost center, project and budget details of req
			FlowBuyersDesk.changeCostcenterProjectBudget(driver, testCaseName, buyersdesk);
			String reqItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickAccountingEditLinkForFreeTextItem(driver, testCaseName);
			PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			// expands box on replace item page and clicks on Guided Procurement
			// button
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);

			/** TC: EPROC_12175 **/
			// verify Create Free Text Item model is displayed after clicking on
			// Save
			flag_is_free_text_model_displayed = PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
			Assert.assertTrue("Create Free Text item modal displayed", flag_is_free_text_model_displayed);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			flag_changed_value = PageBuyersDesk.verifyCostcenterProjectBudgetUpdatedValues(driver, testCaseName, buyersdesk.getCostCenter(), buyersdesk.getProject(),
				buyersdesk.getBudget());
			Assert.assertTrue("Updated values reflected on Req", flag_changed_value);

			/** TC: EPROC_12176 **/
			// updating values to check if changes getting saved when No button
			// is clicked
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 1));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 1));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 1));

			// changes cost center, project and budget details of req
			FlowBuyersDesk.changeCostcenterProjectBudget(driver, testCaseName, buyersdesk);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);
			flag_dont_save_cc_project_budget_changes = PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);
			Assert.assertTrue("Changes saved for cost center/project/budget ", flag_dont_save_cc_project_budget_changes);

			// expands box on replace item page and clicks on Guided Procurement
			// button
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);

			flag_is_free_text_model_displayed = PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
			Assert.assertTrue("Create Free Text item modal displayed", flag_is_free_text_model_displayed);
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);

			flag_changed_value = PageBuyersDesk.verifyCostcenterProjectBudgetUpdatedValues(driver, testCaseName, buyersdesk.getCostCenter(), buyersdesk.getProject(),
				buyersdesk.getBudget());
			if (flag_changed_value == false)
			{
				Assert.assertTrue("Values not updated on Req", true);
			}

			mappedTestCases.get(0).setTestResult(flag_is_free_text_model_displayed);
			mappedTestCases.get(1).setTestResult(flag_is_free_text_model_displayed);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12177 <b>Description : Replace-Free text item: Verify On replacing
	 * free text items to the requisition; delivery information on the item
	 * should be copied from requisition header </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12177(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqDeliveryAddress = null;
		String itemDeliveryAddress = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		boolean flag_item_added = false;
		boolean flag_delivery_address_matched = false;
		boolean flag_cost_center_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12178"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12179"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12180"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_12119);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/12755");

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// replace req item with free text item
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			// to verify delievry address is copied properly from header level
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqDeliveryAddress = PageBuyersDesk.getReqDeliveryAddressHeaderlevel(driver, testCaseName);
			itemDeliveryAddress = PageBuyersDesk.getFreeTextItemDeliveryAddress(driver, testCaseName);
			if (reqDeliveryAddress.equalsIgnoreCase(itemDeliveryAddress))
			{
				flag_delivery_address_matched = true;
			}
			Assert.assertTrue("Free text delivery address matched with req delivery address", flag_delivery_address_matched);

			// to check cost center displayed under item is matching with Req
			// cost center at header level
			/** TC: EPROC_12178, EPROC_12179, EPROC_12180 **/
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center matched with req cost center", flag_cost_center_matched);

			mappedTestCases.get(0).setTestResult(flag_cost_center_matched);
			mappedTestCases.get(1).setTestResult(flag_cost_center_matched);
			mappedTestCases.get(2).setTestResult(flag_cost_center_matched);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12181 <b>Description : Verify On replacing free text items to the
	 * requisition; cost booking information of the item should be set to
	 * requester s default cost center in case 'Book cost at line item level' is
	 * selected and requisition s OU is requester s default OU </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12181(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String company_Req = null, ouCompany = null;
		String bUnit_Req = null, ouBusinessUnit = null;
		String location_Req = null, ouLocation = null;
		String reqNumber = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		String onBehalfOf = null;
		boolean flag_req_approval = false;
		boolean flag_item_added = false;
		boolean flag_ou_matched = false;
		boolean flag_cost_center_matched = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12182"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// get Req OU i.e. Company/BusinessUnit/Location
			company_Req = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			bUnit_Req = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			location_Req = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			// filling req details and getting newly created reqNumber
			onBehalfOf = MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);
			PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, onBehalfOf);
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get OU i.e. Company/BusinessUnit/Location from Buyers Desk and
			// compares with Create Req Page
			ouCompany = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			ouBusinessUnit = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			ouLocation = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			if (company_Req.equalsIgnoreCase(ouCompany) && bUnit_Req.equalsIgnoreCase(ouBusinessUnit) && location_Req.equalsIgnoreCase(ouLocation))
			{
				flag_ou_matched = true;
			}
			Assert.assertTrue("Buyer's desk OU matched with Req OU", flag_ou_matched);

			// Changing Cost Allocation to Line Item Level and Save details
			FlowBuyersDesk.changeToCostAtLineLevel(driver, testCaseName);
			// PageBuyersDesk.clickOnSave(driver, testCaseName);

			// entering cost booking and accounting details and Save
			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageBuyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
			PageBuyersDesk.enterProjectForCostBookingItemLevel(driver, testCaseName, buyersdesk.getProject());
			PageBuyersDesk.enterBudgetForCostBookingItemLevel(driver, testCaseName, buyersdesk.getBudget());
			ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);

			buyersdesk = ObjectCreation.createItem();

			String reqItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			// creating new guided item
			// expands box on replace item page and clicks on Guided Procurement
			// button
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);

			// fill free text item details
			FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			FlowBuyersDesk.fillExtraItemDetails(driver, testCaseName, buyersdesk);
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.selectSupplierAddress(driver, testCaseName);
			PageBuyersDesk.enterContractNumber(driver, testCaseName, buyersdesk.getContractNumber());

			// replace item
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			PageReplaceItem.clickOnConfirm(driver, testCaseName);

			// verifying if free text item is created
			String itemNumber = buyersdesk.getItemNumber();
			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
			Assert.assertTrue("Item Added", flag_item_added);

			// checking cost center of free text item matches with Req cost
			// center.
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center matched with req cost center", flag_cost_center_matched);

			mappedTestCases.get(0).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12183 <b>Description : Replace-Free text item: Verify On replacing
	 * free text items to the requisition; cost booking information of the item
	 * should be empty/blank in case 'Book cost at line item level' is selected
	 * and requisition s OU is NOT requester s default OU </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12183(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String company_Req = null, ouCompany = null;
		String bUnit_Req = null, ouBusinessUnit = null;
		String location_Req = null, ouLocation = null;
		String reqNumber = null;
		String reqCostCenter = null;
		String itemCostCenter = null;
		String onBehalfOf = null;
		String purchaseType = null;
		boolean flag_req_approval = false;
		boolean flag_ou_matched = false;
		boolean flag_item_added = false;
		boolean flag_cost_center_matched = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				// mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_12121"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			onBehalfOf = MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);
			PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, onBehalfOf);
			PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, CommonUtilities.getReqName());
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, purchaseType);
			String settlementVia = "SETTLEMENT_VIA_OPTION_INVOICE";
			PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, settlementVia);
			PageBuyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);

			// changing Req CBL i.e. Company/BusinessUnit/Location
			FlowRequisition.changeCompanyBULocationOfUser(driver, testCaseName);

			// Navigate to Cost Allocation and select Book at line item level
			PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
			PageBuyersDesk.clickCostAtLineLevelRadioButton(driver, testCaseName);
			PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);

			// get Req OU i.e. Company/BusinessUnit/Location
			company_Req = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			bUnit_Req = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			location_Req = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			// fetching data for updating CC/Project/Budget
			BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
			buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 2));
			buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 2));
			buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 2));

			// entering cost booking and accounting details
			FlowBuyersDesk.changeCostcenterProjectBudgetLineLevel(driver, testCaseName, buyersdesk);

			// Submitting Requisiiton
			FlowRequisition.submitRequisiiton(driver, testCaseName);

			// getting created req number
			reqNumber = PageBuyersDesk.getCreatedReqNumber(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// get OU i.e. Company/BusinessUnit/Location from Buyers Desk and
			// compares with Create Req Page
			ouCompany = PageBuyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
			ouBusinessUnit = PageBuyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
			ouLocation = PageBuyersDesk.getReqOULocation(driver, testCaseName, ouLocation);

			if (company_Req.equalsIgnoreCase(ouCompany) && bUnit_Req.equalsIgnoreCase(ouBusinessUnit) && location_Req.equalsIgnoreCase(ouLocation))
			{
				flag_ou_matched = true;
			}
			Assert.assertTrue("Buyer's desk OU matched with Req OU", flag_ou_matched);

			// replace req item with free text item
			buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			// checking cost center of free text item matches with Req cost
			// center.
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			reqCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			itemCostCenter = PageBuyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
			if (reqCostCenter.equalsIgnoreCase(itemCostCenter))
			{
				flag_cost_center_matched = false;
			}
			else if (itemCostCenter == null)
			{
				flag_cost_center_matched = true;
			}
			Assert.assertTrue("Free text cost center value displayed as Empty/Blank", flag_cost_center_matched);

			// mappedTestCases.get(0).setTestResult(flag_item_added);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12191 <b>Description : Replace-Free text item: Verify working of
	 * mentioned setting </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12191(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqTotalPrice = null;
		String prTotalAmount = null;
		String prCurrencyUnits = null;
		String reqNumber = null;
		String priceControlValue = "10";
		boolean flag_item_added = false;
		boolean flag_allowPr_smaller = false;
		boolean flag_tolerance_error = false;
		boolean flag_req_approval = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{
				/*
				 * mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase(
				 * "EPROC_12121"));
				 * mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase(
				 * "EPROC_12122"));
				 */
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
			PageBuyersDeskSettings.enterPriceControlVirtualItem(driver, testCaseName, priceControlValue);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowReplaceItem.replaceWithFreeTextItem(driver, testCaseName, buyersdesk);

			/*
			 * mappedTestCases.get(0).setTestResult(flag_item_added);
			 * mappedTestCases.get(1).setTestResult(flag_item_added);
			 */
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_CurrencyUnits(driver, testCaseName);
				FlowBuyersDeskSetting.clearAllowPr_TotalAmount(driver, testCaseName);
				FlowBuyersDeskSetting.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 21-Oct-2016 </b> <b>Method :
	 * EPROC_12163 <b>Description : Replace-Free text item: Verify On replacing
	 * a free text item and saving the requisition; the requisition items should
	 * not be displayed on PO amendment screen </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_12163(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String poNumber = null;
		String reqNumber = null;
		boolean flag_req_approval = false;
		boolean flag_item_added = false;
		boolean flag_is_req_item_displayed_on_po = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			{

			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
			/*
			 * StandardPO standardPO =
			 * ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM)
			 * ; standardPO.setCurrencyType("INR");
			 * standardPO.setPurchaseType("PQR"); // create standard PO
			 * standardPO = FlowStandardPo.createStandardPo(driver,
			 * testCaseName, standardPO); poNumber = standardPO.getPoNumber();
			 * //approve created po ApprovalAllRequests approvalAllRequests =
			 * new ApprovalAllRequests();
			 * approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER
			 * ); approvalAllRequests.setDocumentNo(poNumber);
			 * approvalAllRequests.setActions(IConstantsData.APPROVE);
			 * MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			 * FlowAllRequestsApproval.searchAndPerformActions(driver,
			 * testCaseName, approvalAllRequests);
			 */
			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			// filling req details and getting newly created reqNumber
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);
			/** Req creation ends **/

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);
			// FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver,
			// testCaseName, "COM001/PR/13483");

			// to enter GL Account info for replaced item.
			FlowBuyersDesk.enterGLAccoutnForReqDefaultItem(driver, testCaseName);

			// link PO with Req
			FlowBuyersDesk.linkReqWithPO(driver, testCaseName, poNumber);

			BuyersDesk buyersdesk = ObjectCreation.createItem();
			buyersdesk.setActionToPerform(IConstantsData.Action_Create_Guided_Item);

			// fetching item values for verification
			String reqItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);

			// If save changes pop-up is displayed on page.
			PageBuyersDesk.clickConfimSave_Save(driver, testCaseName);

			if (PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName) == false)
			{
				// expands box on replace item page and clicks on Guided
				// Procurement button
				PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
				PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);
			}

			// fill free text item details
			FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			PageBuyersDesk.selectSupplierAddress(driver, testCaseName);
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			PageReplaceItem.clickOnConfirm(driver, testCaseName);

			flag_item_added = PageBuyersDesk.isFreeTextItemCreated(driver, testCaseName, buyersdesk.getItemNumber());
			Assert.assertTrue("Item Added", flag_item_added);

			// to enter GL Account info for replaced item.
			FlowBuyersDesk.enterGLAccoutnForReqFreeTextItem(driver, testCaseName, buyersdesk.getItemNumber());

			// Returns req to requestor
			PageBuyersDesk.clickReturnToRequestorButton(driver, testCaseName);
			PageBuyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);

			// navigate to myreq tab and save req
			FlowMyRequisitions.saveReturnedReqFromBuyerDesk(driver, testCaseName, reqNumber);

			// Approving updated Req
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects Req with status as Pending
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Convert req to po
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);

			// search PO on POListing Page
			FlowPoListing.searchPO(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
			FlowPoListing.amendPO(driver, testCaseName);

			flag_is_req_item_displayed_on_po = PageBuyersDesk.isReqItemDisplayedOnPOPage(driver, testCaseName, buyersdesk.getItemNumber());
			if (flag_is_req_item_displayed_on_po == false)
			{
				flag_is_req_item_displayed_on_po = true;
				Assert.assertTrue("req item not displayed on PO page", flag_is_req_item_displayed_on_po);
			}
			else
			{
				Assert.assertTrue("req items displayed on po page", flag_is_req_item_displayed_on_po);
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

				FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing Allow buyer to replace new items to a requisition validation settings to No" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/*************************************
	 * KunalAshar's TestCases - End
	 ************************************************/
	/*************************************
	 * Start of Raj Singh's TestCases
	 **********************************************/

	/**
	 * <b>Author: Raj.Singh </b> <b>Created On : 4-April-2016 </b> <b>Method :
	 * RTC_31875 <b>Description : Verify that in buyers desk tab requisition
	 * should be available in pending filter having the action of Edit. Reviewed
	 * By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_31875(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		boolean flag = false;
		boolean flag_RTC_31876 = false;
		boolean flag_RTC_31878 = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31876"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31878"));
			}

			// log in
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to create req
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to perform verification for the above given scenario
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			flag = PageBuyersDeskListing.verifyAvailablityOfEditAction(driver, testCaseName);
			Assert.assertTrue("the EDIT action was not present in the ACTION dropdown of the requisition Listing in Buyer's desk", flag);

			/** RTC_31876 **/
			flag_RTC_31876 = PageBuyersDeskListing.verifyReturnActionOnReqInBuyerList(driver, testCaseName, 1);
			Assert.assertTrue("the RETURN action was not present in the ACTION dropdown of the requisition Listing in Buyer's desk", flag_RTC_31876);
			mappedTestCases.get(0).setTestResult(flag_RTC_31876);

			/** RTC_31878 **/
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			//			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);

			FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, false);
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			flag_RTC_31878 = ModalBuersDeskListingActions.isViewActionPresent(driver, testCaseName);
			Assert.assertTrue("the VIEW action was not present in the ACTION dropdown of the returned requisition Listing in Buyer's desk", flag_RTC_31878);

			mappedTestCases.get(1).setTestResult(flag_RTC_31878);
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
	 * <b>Author: Raj.Singh </b> <b>Created On : 4-April-2016 </b> <b>Method :
	 * RTC_31885 <b>Description : Verify that In buyers desk tab, requisition
	 * should be available in Partially Ordered filter having the action of edit
	 * . Reviewed By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_31885(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag = false;
		boolean flag_RTC_23895 = false;
		boolean flag_RTC_23536 = false;
		int filterCount = 0;
		int perPageTotalItem = 0;
		int remainder = 0, pages = 0;
		Requisition requisition = new Requisition();
		Item item = new Item();

		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23895"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23536"));
			}

			// log in
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.BOTH);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to create req
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			PageBuyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);

			/** RTC_23895 **/
			// to verify pagination
			filterCount = Integer.parseInt(PageBuyersDeskListing.getFilterCount(driver, testCaseName));
			perPageTotalItem = Integer.parseInt(PageBuyersDeskListing.getPageItemCount(driver, testCaseName));
			pages = filterCount / perPageTotalItem;
			remainder = filterCount % perPageTotalItem;
			if (remainder > 0)
			{
				pages++;
			}
			PageBuyersDeskListing.naviagteToLastPage(driver, testCaseName);
			if (Integer.parseInt(PageBuyersDeskListing.getShowingPageNumber(driver, testCaseName)) == pages)
			{
				if (PageBuyersDeskListing.getNumberOfReqOnPage(driver, testCaseName) == remainder)
				{
					flag_RTC_23895 = true;
				}
			}
			PageBuyersDeskListing.naviagteToFirstPage(driver, testCaseName);
			Assert.assertTrue("pagination is not working fine", flag_RTC_23895);
			mappedTestCases.get(0).setTestResult(flag_RTC_23895);

			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, requisition.getReqNo());

			/** RTC_31885 **/
			// to create a partially ordered req		

			//to view req at buyers desk
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickItemCheckboxIndexwise(driver, testCaseName, 1);

			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.CONVERT_TO_PO_COMMENT);

			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PageBuyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);
			if (!PagePurchaseOrderToBeGenerated.isSubmitPOForProcessingPresent(driver, testCaseName))
			{
				ActionBot.defaultSleep();
			}
			ScreenShot.screenshot(driver, testCaseName, "After converting to po");

			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at Buyers Desk", requisition.isResult());

			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			flag_RTC_23536 = ModalBuersDeskListingActions.isEditActionPresent(driver, testCaseName);
			Assert.assertTrue("Edit option was not found for a partially ordered Requisition", flag);
			mappedTestCases.get(1).setTestResult(flag_RTC_23536);

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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_31353 <b>Description : Verify that In buyers desk tab, requisition
	 * should be available in Partially Ordered filter having the action of edit
	 * . Reviewed By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_31353(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_RTC_31353 = false;
		boolean flag_RTC_23895 = false;
		boolean flag_RTC_22633 = false;
		Requisition requisition = new Requisition();
		Item item = new Item();
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23895"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22633"));
			}

			// log in
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to create req
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			/** RTC_23895 **/
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			flag_RTC_23895 = PageBuyersDeskListing.verifyAvailablityOfEditAction(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(flag_RTC_23895);

			/** RTC_22633 **/
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			flag_RTC_22633 = PageBuyersDeskListing.isDeliverByDateEditable(driver, testCaseName);
			mappedTestCases.get(1).setTestResult(flag_RTC_22633);

			//search req at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at Buyers Desk", requisition.isResult());

			//to return req from buyers desk
			FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);

			// to navigate to my requisition and verify the scenario			
			MainPageHeaderLevelTab.clickOnAllRequisitionsSubTab(driver);
			PageMyRequisition.searchRequisitionByReqNo(driver, testCaseName, requisition.getReqNo());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);

			ActionBot.scroll(driver, "1000");
			ActionBot.defaultSleep();

			flag_RTC_31353 = PageRequisitionView.isBuyerReturnCommentPresent(driver, testCaseName);
			Assert.assertTrue("buyer's return comment was not found on the requisition view page", flag_RTC_31353);

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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_23517 <b>Description : On the buyer's desk page, User should be able
	 * to filter requisitions by specified statuses. Reviewed By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_23517(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase);

			// to navigate to the buyer's desk page
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

			// to perform verification for the filter

			// Pending status filter			
			FlowBuyersDeskListing.toFilterPendingReqStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.PENDING_ORDER);
			Assert.assertTrue("Failed to filter out Pending Filter Requisition", flag);

			// Sourcing status Filter
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.toFilterSourcingStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.SOURCING_STATUS);
			Assert.assertTrue("Failed to filter out sourcing status Filter Requisition", flag);

			// cancelled status Filter
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.toFilterCancelledStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.CANCELLED);
			Assert.assertTrue("Failed to filter out cancelled status Filter Requisition", flag);

			// closed status Filter
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.toFilterClosedStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.CLOSED);
			Assert.assertTrue("Failed to filter out closed status Filter Requisition", flag);

			// Awaiting Quote status Filter
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.toFilterAwaitingQuoteStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.AWAITING_QUOTE);
			Assert.assertTrue("Failed to filter out awaiting quote status Filter Requisition", flag);

			// Awaiting Review status Filter
			FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
			FlowBuyersDeskListing.toFilterAwaitingReviewStatusFilter(driver, testCaseName);
			flag = FlowBuyersDeskListing.toVerifyFilterStatusPerformance(driver, testCaseName, IConstantsData.AWAITING_REVIEW);
			Assert.assertTrue("Failed to filter out awaiting review status Filter Requisition", flag);

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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_23547 <b>Description : The purchase orders generated should include:
	 * all items accompanied with comments for suppliers & attachments Reviewed
	 * By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_23547(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_comment = false, flag_items = false;
		Requisition requisition = new Requisition();
		Item item = new Item();
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_23544"));
			}

			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setCommentForSupplier(IConstantsData.SupplierComment);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to create req
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			mappedTestCases.get(0).setTestResult(requisition.isResult());

			FlowPoListing.viewPO(driver, testCaseName);

			// verify the scenario
			flag_comment = PagePurchaseOrderDetails.isCommentForSupplierAvailable(driver);
			flag_items = PagePurchaseOrderDetails.isAllItemsAvailable(driver, 1);
			Assert.assertTrue("the PO generated was not containing all the items and comments for suppliers inside it", flag_comment && flag_items);

			// log out
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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_53438 <b>Description : User should be able to save an edited
	 * requisition. Reviewed By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_53438(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqNo = null, commentForSupplier = null;
		boolean flag_edit_save = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase);

			// to navigate to the buyer's desk and filter out Pending
			// requisitions			
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			FlowBuyersDeskListing.toFilterPendingReqStatusFilter(driver, testCaseName);
			reqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);

			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			commentForSupplier = Helper.getRandomString(10);
			PageBuyersDesk.fillCommentsForSupplier(driver, testCaseName, commentForSupplier);
			PageBuyersDesk.clickOnSave(driver, testCaseName);

			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			if (PageBuyersDesk.getCommentsForSupplier(driver, testCaseName).equals(commentForSupplier))
				flag_edit_save = true;
			Assert.assertTrue("The requisition was not successfully edited and saved", flag_edit_save);

			// log out
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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_23896 <b>Description : Verify convert to PO should work on pagenation
	 * across multiple pages on buyers desk listing. Reviewed By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_23896(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		boolean flag_ConvertToPO_Across_Pagenation = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase);

			// to navigate to the buyer's desk and filter out Pending
			// requisitions
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

			PageBuyersDeskListing.clickOnCheckboxOfReqToBeSelected(driver, testCaseName, 5);
			PageBuyersDeskListing.clickOnNextPageIcon(driver, testCaseName);

			PageBuyersDeskListing.clickConvertToPo(driver, testCaseName);
			if (PagePurchaseOrderToBeGenerated.isSubmitPOForProcessingPresent(driver, testCaseName))
				;
			flag_ConvertToPO_Across_Pagenation = true;
			Assert.assertTrue("the convert to PO across pagenation is not working", flag_ConvertToPO_Across_Pagenation);

			// log out
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
	 * <b>Author: Raj.Singh </b> <b>Created On : 6 -April-2016 </b> <b>Method :
	 * RTC_38703 <b>Description : Verify On Buyer's desk, user should be
	 * provided a "Change Multiple" button that allows user to change Delivery
	 * Date and/or GL Account for all items OR items where it is empty. Reviewed
	 * By: kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_38703(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		String testCaseName = testCase.getTestMethodName();
		User user = null;
		String reqNo = null, GL_Account = null;
		boolean flag = false;
		boolean flag_RTC_53425 = false;
		int countMatches = 0;
		Requisition requisition = new Requisition();
		Item item = new Item();
		try
		{

			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53425"));
			}

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setCommentForSupplier(IConstantsData.SupplierComment);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to create req
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			//to view requisition
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// to verify the scenario
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageBuyersDesk.clickOnUpdateAllLink(driver, testCaseName);
			GL_Account = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			PageBuyersDesk.fillGLAccount(driver, testCaseName, GL_Account);
			PageBuyersDesk.clickDeliveryTabInUpdateAllLines(driver, testCaseName);
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			PageBuyersDesk.fillMultiDeliveryOnUpdateAllLines(driver, testCaseName, Integer.toString(calendar.get(Calendar.DATE)), Integer.toString(calendar.get(Calendar.MONTH)),
				Integer.toString(calendar.get(Calendar.YEAR)));
			PageBuyersDesk.clickOnApplyallLink(driver, testCaseName);
			for (int i = 1; i < item.getCatelogItems().get(0).getQuantity(); i++)
			{
				PageBuyersDesk.clickEditItemSummary(driver, testCaseName, item.getCatelogItems().get(0).getItemID());
				PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
				if (PageBuyersDesk.fetchGLAccount(driver, testCaseName).equals(GL_Account))
				{
					countMatches++;
				}
				PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
			}
			if (countMatches == item.getCatelogItems().get(0).getQuantity())
				flag = true;
			Assert.assertTrue("Change Multiple button that allows user to change Delivery Date and/or GL Account for all items ", flag);

			/** RTC_53425 **/
			PageBuyersDesk.clickButtonShowAllPo(driver, testCaseName);
			flag_RTC_53425 = PageBuyersDesk.isPurchaseOrderListingTab(driver, testCaseName);
			Assert.assertTrue("User did not get list of all possible POs that can be generated", flag_RTC_53425);

			// log out
			mappedTestCases.get(0).setTestResult(flag_RTC_53425);
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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Free text item: Verify price field in replace free text item modal
	 * should accept numeric and decimal values
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_12142(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_item_added = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Navigate to Setup tab and selects 'Allow buyer to add new items
			// to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			/** Creating new Req **/
			// Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify the following actions should not be displayed in
	 * Item modal in replace item screen: Compare; Add to cart; Add to favorites; Add to basket
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11928(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber_11928 = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber_11928 = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber_11928);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber_11928);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11928);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			PageReplaceItem.clickOnRadioItem(driver, testCaseName);
			// verify Compare/AddtoCart/AddtoFavourites/AddtoBasket not to be
			// displayed in LIST view
			boolean flag_compare = PageSearchListing.isCompareLinkDisplayed(driver, testCaseName);
			boolean flag_addToBasket = PageSearchListing.isAddToBasketLinkDisplayed(driver, testCaseName);
			boolean flag_addToCart = PageSearchListing.isAddToCartLinkDisplayed(driver, testCaseName);
			boolean flag_addToFavourite = PageSearchListing.isAddToFavouriteDisplayed(driver, testCaseName);

			if (flag_compare == false && flag_addToBasket == false && flag_addToCart == false && flag_addToFavourite == false)
			{
				Assert.assertTrue("Actions not displayed on Replace Item Page for List View", true);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: (Grid View)Verify the following actions should not be displayed in
	 * Item modal in replace item screen: Compare; Add to cart; Add to favorites; Add to basket
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11929(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber_11929 = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber_11929 = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber_11929);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber_11929);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber_11929);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// verifying Compare/AddtoCart/AddtoFavourites/AddtoBasket not to be
			// displayed in GRID view
			PageSearchListing.clickOnSwitchToGridView(driver, testCaseName);
			PageReplaceItem.clickOnRadioItemGrid(driver, testCaseName);
			boolean flag_compare = PageSearchListing.isCompareLinkDisplayed(driver, testCaseName);
			boolean flag_addToBasket = PageSearchListing.isAddToBasketLinkDisplayed(driver, testCaseName);
			boolean flag_addToCart = PageSearchListing.isAddToCartLinkDisplayed(driver, testCaseName);
			boolean flag_addToFavourite = PageSearchListing.isAddToFavouriteDisplayed(driver, testCaseName);

			if (flag_compare == false && flag_addToBasket == false && flag_addToCart == false && flag_addToFavourite == false)
			{
				Assert.assertTrue("Actions not displayed on Replace Item Page for Grid View", true);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify Buyer should be able to sort item in replace item screen by: Relevance (default)
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11930(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition

			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			PageSearchListing.clickSortByRelevance(driver, testCaseName);

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify Buyer should be able to sort item in replace item screen by: Price (Low to high)
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11931(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			//sorting
			PageSearchListing.clickSortByPriceLowToHigh(driver, testCaseName);

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Buyer's Desk Listing>Verify that by default, requisitions in following statuses should be loaded in the list:
	 * 1. Awaiting Quote
	 * 2. Awaiting Review
	 * 3. Pending Order
	 * Under Pending Order:
	 * a. Unordered
	 * b. Partially Ordered
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_20900(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		List<String> status = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			//Go to buyer desk listing page
			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

			//Get statuses of all requisitions
			status = PageBuyersDeskListing.getStatusOfAllReq(driver, testCaseName);

			//Check statuses
			for (int i = 0; i < status.size(); i++)
			{

				Assert.assertTrue("By default, requisitions statuses loaded in the list", status.get(i) == "In Process\r\n" + "(Awaiting Quote)"
					|| status.get(i) == "In Process\r\n" + "(Awaiting Review)" || status.get(i) == "In Process\r\n" + "(Pending Order)");

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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify On clicking on item name in replace item screen;
	 * item modal should open with the following fields in details tab:
	 * Description; Manufacturer; Category; SPSC Code; Supplier; Delivery Lead Time (days); Contract No
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11925(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			boolean flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, "COM001/PR/18589");
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
			ActionBot.defaultMediumSleep();
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);

			// fetching item values for verification
			String itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			boolean flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			PageReplaceItem.verifyFieldsOnDetailsTabItemPopup(driver, testCaseName);

			//Checking fields
			PageReplaceItem.clickItemName(driver, testCaseName);
			boolean isAllElementsPresent = PageReplaceItem.verifyFieldsOnDetailsTabItemPopup(driver, testCaseName);
			org.testng.Assert.assertTrue(isAllElementsPresent, "All fields are present properly");

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify On clicking on item name in replace item screen;
	 * item modal should open with the following fields in Specifications tab:
	 * Specification name; specification key - value
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11926(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			boolean flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, "COM001/PR/18589");
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
			ActionBot.defaultMediumSleep();
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);

			// fetching item values for verification
			String itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			boolean flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			//Checking fields
			PageReplaceItem.clickItemName(driver, testCaseName);
			boolean isFieldsPresentOnSpecificationTab = PageReplaceItem.verifyFieldsOnSpecificationTabItemPopup(driver, testCaseName);

			org.testng.Assert.assertTrue(isFieldsPresentOnSpecificationTab, "All fields are present properly on specification tab");

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify On clicking on item name in replace item screen;
	 * item modal should open with the following fields in Attachments tab: Web links; attachments
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11927(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);

			// Navigate to Setup tab and selects 'Allow buyer to REPLACE new
			// items to a requisition' as Yes
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			boolean flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created Req
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, "COM001/PR/18589");
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
			ActionBot.defaultMediumSleep();
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);

			// fetching item values for verification
			String itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// to verify replace item button is enabled or not
			boolean flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			//Checking fields
			PageReplaceItem.clickItemName(driver, testCaseName);
			boolean isFieldsPresentOnAttachmentTab = PageReplaceItem.verifyFieldsOnAttachmentsTabItemPopup(driver, testCaseName);

			org.testng.Assert.assertTrue(isFieldsPresentOnAttachmentTab, "All fields are present properly on attachment tab");

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify Buyer should be able to sort item in replace item screen by: Price (High to Low)
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11932(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			//sorting
			PageSearchListing.clickSortByPriceHighToLow(driver, testCaseName);

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify Buyer should be able to sort item in replace item screen by: Lead time (Low to high)
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11933(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			//sorting
			PageSearchListing.clickSortByLeadHighToLow(driver, testCaseName);

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
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify On replace item screen;
	 * buyer should be able to search for items by supplier name
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11916(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;
		boolean flag_supplier_result_displayed = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// Searching for item using Supplier Name
			BuyersDesk buyersDesk = ObjectCreation.createItem();
			String supplierName = buyersDesk.getSupplierName();
			PageOnlineStore.fillSearchText(driver, testCaseName, supplierName);
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Verify is result is displayed when searched with supplier name
			flag_supplier_result_displayed = PageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
			if (flag_supplier_result_displayed == true)
			{
				Assert.assertTrue("Search Result displayed when supplier name provided", flag_supplier_result_displayed);
			}
			else
			{
				Assert.assertTrue("No Result displayed when supplier name provided", false);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Replace-Catalog item: Verify On searching for an item in replace item screen;
	 * item search results should be displayed properly
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11919(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String itemNumber = null;
		String itemName = null;
		boolean flag_replace_icon_enabled = false;
		boolean flag_req_approval = false;
		String reqNumber = null;
		boolean flag_itemName_result_displayed = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to customize>>Buyers desk: Keep 'Allow buyer to replace existing items on a requisition' setting YES
			FlowBuyersDeskSetting.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);

			//Adding Item and checking out
			OnlineStore onlinestore = ObjectCreation.searchItem();
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

			//Fetching user name from home page
			MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);

			//Filling requisition details and get requisition number
			reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);

			// Approving created requisition
			flag_req_approval = FlowAllRequestsApproval.approveSingleRequisition(driver, testCaseName, reqNumber);
			Assert.assertTrue("Requisition Approved", flag_req_approval);

			// Navigates to Buyer Desk and selects created requisition
			FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

			// Fetching item values for verification
			itemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);
			itemName = PageBuyersDesk.getReqDefaultItemName(driver, testCaseName);

			// Selects item displayed on Page
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// To verify replace item button is enabled or not
			flag_replace_icon_enabled = PageBuyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
			Assert.assertTrue("Replace Icon Enabled", flag_replace_icon_enabled);

			// Navigate to replace item page
			PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);

			// Searching for item using Supplier Name

			PageOnlineStore.fillSearchText(driver, testCaseName, itemName);
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Verify is result is displayed when searched with item name
			flag_itemName_result_displayed = PageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
			if (flag_itemName_result_displayed == true)
			{
				Assert.assertTrue("Search Result displayed when item name provided", flag_itemName_result_displayed);
			}
			else
			{
				Assert.assertTrue("No Result displayed when item name provided", false);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: t.amarnath </b> <b>Created On : 28-Dec-2017 </b> <b>Method :
	 * EPROC_11838 <b>Description : Add Free text items: Verify On clicking on create free
	 * text item in a requisition on buyers desk; buyer should be directed to 'Add item' screen with free
	 * text item modal opened by default
	 * </font><b><br>
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11838(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11839"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11838 = false;
		try
		{
			//get default requisition objects
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//search the requisition
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//check whether free text item modal opens up
			EPROC_11838 = PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
			Assert.assertTrue(EPROC_11838);
			//check if the modal closes after clicking Cancel link
			EPROC_11838 = PageBuyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName);
			Assert.assertTrue(EPROC_11838);
			PageBuyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//check if the modal closes after clicking the close icon
			EPROC_11838 = PageBuyersDesk.clickOnCloseIconModalAddFreeTextItem(driver, testCaseName);
			Assert.assertTrue(EPROC_11838);
			mappedTestCases.get(0).setTestResult(EPROC_11838);
			PageBuyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 29-Dec-2017 </b> <b>Method :
	 * EPROC_11840 <b>Description :Add Free text items: Verify On clicking on Add item
	 * in free text item modal in add item screen; the free text item should get added
	 * to the requisition and buyer should be directed to requisition edit screen.
	 * 
	 * 
	 * </font><b><br>
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11840(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11840 = false;
		try
		{
			//get default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);
			List<String> requisitionItems = PageBuyersDesk.getListOfRequisitionItems(driver, testCaseName);
			//check if free text item added to the requisition
			EPROC_11840 = requisitionItems.contains(buyersdesk.getItemNumber());
			Assert.assertTrue(EPROC_11840);
			//save the requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);
			buyersdesk = ObjectCreation.createItem();
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//fill the item details
			FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			//click on cancel in modal free text item
			PageBuyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName);
			//click on cancel and go back
			PageBuyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);
			requisitionItems = PageBuyersDesk.getListOfRequisitionItems(driver, testCaseName);
			//check whether free text item added
			EPROC_11840 = requisitionItems.contains(buyersdesk.getItemNumber());
			Assert.assertTrue(!EPROC_11840);
			PageBuyersDesk.clickOnSave(driver, testCaseName);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 29-Dec-2017 </b> <b>Method :
	 * EPROC_11843 <b>Description :Add Free text items: Verify Item number field in add free
	 * text item modal should accept alphanumeric characters
	 * 
	 * 
	 * </font><b><br>
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11843(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11844"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11845"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11843 = false;
		try
		{
			//get default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			//create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the created requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//get a default item object
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			//set item number with alphanumeric data
			buyersdesk.setItemNumber(CommonServices.getTestData(IConstantsData.Free_Text_Item_Alphanumeric_Item_Number));
			//set item short description with alphanumeric data
			buyersdesk.setItemShortDescription(CommonServices.getTestData(IConstantsData.Free_Text_Item_Alphanumeric_Item_Number));
			//set item long description with alphanumeric data
			buyersdesk.setItemLongDescription(CommonServices.getTestData(IConstantsData.Free_Text_Item_Alphanumeric_Item_Number));
			//create the free text item
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);
			List<String> requisitionItems = PageBuyersDesk.getListOfRequisitionItems(driver, testCaseName);
			//check if the free text item got added to the requisition
			EPROC_11843 = requisitionItems.contains(buyersdesk.getItemNumber());
			Assert.assertTrue(EPROC_11843);
			mappedTestCases.get(0).setTestResult(EPROC_11843);
			mappedTestCases.get(1).setTestResult(EPROC_11843);
			//save the requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 29-Dec-2017 </b> <b>Method :
	 * EPROC_11846 <b>Description :Add Free text items: Add Free text items: Verify On
	 * clicking on create free text item in a requisition on buyers desk; Product category field in Add free text item modal should be empty/blank
	 * </font><b><br>
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11846(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11849"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11846 = false;
		int eFormListCount = 0;
		try
		{
			//get default requisition item
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//get the value filled in product category
			EPROC_11846 = (PageBuyersDesk.getProductCategory(driver, testCaseName) == null);
			Assert.assertTrue(EPROC_11846);
			//fill the product category with value
			ActionBot.fillAutoCompleteField(driver, IPageBuyersDesk.TEXT_PRODUCT_CATEGORY, buyersdesk.getProductCategory());
			//check if eforms are displayed
			if (EPROC_11846 = PageBuyersDesk.isEformDialogPresent(driver, testCaseName))
			{
				//get the number of eforms displayed
				eFormListCount = PageBuyersDesk.getEformListCount(driver, testCaseName, eFormListCount);
				//click on the first eform
				PageBuyersDesk.clickEformFromList(driver, testCaseName);
			}
			Assert.assertTrue(EPROC_11846);
			EPROC_11846 = (eFormListCount > 1);
			Assert.assertTrue(EPROC_11846);
			//go to requirement details tab
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			//verify if eform is populated in requirement details tab
			EPROC_11846 = PageBuyersDesk.isEformPresentInRequirementTab(driver, testCaseName);
			Assert.assertTrue(EPROC_11846);
			mappedTestCases.get(0).setTestResult(EPROC_11846);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 03-Jan-2018 </b> <b>Method :
	 * EPROC_11856 <b>Description :Add Free text items: Verify default value in Currency
	 * field in add free text item modal should be requester s user currency
	 * </font><b><br>
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11856(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11856 = false;
		String defaultUserCurrency = null;
		String defaultCurrencyEntered = null;
		try
		{
			//get default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			//get user's default currency
			defaultUserCurrency = PageManageProfile.getDefaultCurrency(driver, testCaseName);
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//get the default item currency entered
			defaultCurrencyEntered = PageBuyersDesk.getItemCurrency(driver, testCaseName);
			//enter the user's default currency
			PageBuyersDesk.enterItemCurrency(driver, testCaseName, defaultUserCurrency);
			//verify if both are same
			EPROC_11856 = PageBuyersDesk.getItemCurrency(driver, testCaseName).equalsIgnoreCase(defaultCurrencyEntered);
			Assert.assertTrue(EPROC_11856);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 04-Jan-2018 </b> <b>Method :
	 * EPROC_11865 <b>Description :Add Free text items: Verify Buyer should not be
	 * able to add free text item with Supplier Name/Supplier Address as empty
	 * </font><b><br>
	 * *@param testCase
	 * {@link String}*</font><b><br>
	 * *@throws Exception @
	 * {@link Exception}*</b><br>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11865(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11867"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11865 = false;
		String contractNumber = null;
		try
		{
			contractNumber = CommonServices.getTestData(IConstantsData.CONTRACT_NO, 1);
			//get default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//fill item details
			FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
			//click on supplier tab
			PageBuyersDesk.clickOnSupplierTabInFreeText(driver, testCaseName);
			//check if supplier name is mandatory
			EPROC_11865 = PageBuyersDesk.isSupplierNameMandatory(driver, testCaseName);
			Assert.assertTrue(EPROC_11865);
			//check if supplier address is mandatory
			EPROC_11865 = PageBuyersDesk.isSupplierAddressMandatory(driver, testCaseName);
			Assert.assertTrue(EPROC_11865);
			//enter the supplier name
			PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
			//verify if the contract number field is editable
			EPROC_11865 = PageBuyersDesk.isContractNumberEditable(driver, testCaseName);
			Assert.assertTrue(EPROC_11865);
			mappedTestCases.get(0).setTestResult(EPROC_11865);
			//enter the alphanumeric contract number
			PageBuyersDesk.enterContractNumber(driver, testCaseName, contractNumber);
			//click on add items button
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			//verify if the item got added to the requisition
			EPROC_11865 = PageBuyersDesk.getListOfRequisitionItems(driver, testCaseName).contains(buyersdesk.getItemNumber());
			Assert.assertTrue(EPROC_11865);
			//save the requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 04-Jan-2018 </b> <b>Method :
	 * EPROC_11874 <b>Description :Add Free text items: Verify Buyer should NOT
	 * be able to add free text item if value is missing for any mandatory field in
	 * requirement details field
	 * </font><b><br>
	 * *@param testCase
	 * {@link String}*</font><b><br>
	 * *@throws Exception @
	 * {@link Exception}*</b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11874(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11874 = false;
		try
		{
			//get a default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//click on create free text item
			PageBuyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
			//click on add items button
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			//check for item name error
			EPROC_11874 = PageBuyersDesk.checkForItemNameError(driver, testCaseName);
			Assert.assertTrue(EPROC_11874);
			//enter item short description
			PageBuyersDesk.enterItemShortDescription(driver, testCaseName, buyersdesk.getItemShortDescription());
			//click on add items button
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			//check for product category error
			EPROC_11874 = PageBuyersDesk.checkForProductCategoryError(driver, testCaseName);
			Assert.assertTrue(EPROC_11874);
			//enter the product category
			PageBuyersDesk.enterProductCategory(driver, testCaseName, buyersdesk.getProductCategory());
			//click on add items button
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			//check for quantity error
			EPROC_11874 = PageBuyersDesk.checkForQuantityError(driver, testCaseName);
			Assert.assertTrue(EPROC_11874);
			//enter item quantity
			PageBuyersDesk.enterItemQuantity(driver, testCaseName, buyersdesk.getQuantity());
			//click on add items button
			PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
			//check for item price error
			EPROC_11874 = PageBuyersDesk.checkForPriceError(driver, testCaseName);
			Assert.assertTrue(EPROC_11874);
			//click on supplier's tab
			PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
			//check for supplier's name error
			EPROC_11874 = PageBuyersDesk.checkForSupplierNameError(driver, testCaseName);
			Assert.assertTrue(EPROC_11874);
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
	 * <b>Author: t.amarnath </b> <b>Created On : 05-Jan-2018 </b> <b>Method :
	 * EPROC_11884 <b>Description :Add free text items: Verify On adding free text
	 * items to the requisition; delivery information on the item should be copied from requisition header
	 * </font><b><br>
	 * *@param testCase
	 * {@link String}*</font><b><br>
	 * *@throws Exception @
	 * {@link Exception}*</b><br>
	 */
	/**
	 * @param testCase
	 * @throws Exception
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11884(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11885"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = null;
		boolean EPROC_11884 = false;
		String requisitionDeliveryAddress = null;
		String requisitionItemDeliveryAddress = null;
		String requisitionCostCenter = null;
		String requisitionItemCostCenter = null;
		try
		{
			//get default requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//login to eproc
			user = LoginLogoutServices.login(driver, testCase);
			BuyersDesk buyersdesk = ObjectCreation.createItem();
			//create a requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			//edit the requisition
			PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
			//create simple free text item
			FlowBuyersDesk.createSimpleFreeTextItem(driver, testCaseName, buyersdesk);
			//get the requisition delivery address
			requisitionDeliveryAddress = PageBuyersDesk.getDeliveryAddress(driver, testCaseName);
			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			//get the delivery address of the created free text item
			requisitionItemDeliveryAddress = PageBuyersDesk.getRequisitionItemDeliveryAddress(driver, testCaseName, 1);
			//verify if both are same
			EPROC_11884 = requisitionItemDeliveryAddress.contains(requisitionDeliveryAddress);
			Assert.assertTrue(EPROC_11884);
			//get the cost center from requisition header
			requisitionCostCenter = PageBuyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
			requisitionItemCostCenter = PageBuyersDesk.getRequisitionItemCostCenter(driver, testCaseName, 1);
			EPROC_11884 = requisitionCostCenter.equalsIgnoreCase(requisitionItemCostCenter);
			Assert.assertTrue(EPROC_11884);
			mappedTestCases.get(0).setTestResult(EPROC_11884);
			//save the requisition
			PageBuyersDesk.clickOnSave(driver, testCaseName);
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
