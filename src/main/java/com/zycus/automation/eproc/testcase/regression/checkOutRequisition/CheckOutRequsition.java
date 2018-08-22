package com.zycus.automation.eproc.testcase.regression.checkOutRequisition;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.MasterDataTenantConfig;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.bo.ModalGuidedItemSelectSupplierContract;
import com.zycus.automation.bo.MyRequisitionFilter;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.convertedpurchaseorder.FlowConvertedPurchaseOrder;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.FlowFillGuidedItem;
import com.zycus.automation.eproc.businessflow.glMapFlow.FlowGLMap;
import com.zycus.automation.eproc.businessflow.masterdatatenantconfigflow.FlowMasterDataTenantConfig;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.requisitionsettingsflow.FlowRequisitionSettings;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.businessflow.viewpoflow.FlowViewPO;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling.ModelBuyersdeskSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.EFormAddAttachmentCheckout.ModalEFormAddAttachmentCheckout;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple.ModelChangeMultiple;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.ModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery.ModelItemSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.ModelRequisitionSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon.ModelRequisitionSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.ModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.ModelRequisitionSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.discountstandardpo.ModalDiscountPO;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.IModalSelectCategory;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.IModalSelectCategoryImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.ModalSelectCategory;
import com.zycus.automation.eproc.pageobjects.modals.myreqactionsrecallapprovalrequest.ModalRecallApprovalRequest;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.ModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.showallpos.ModalShowAllPos;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder.PageConvertedPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOutImpl;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings.PageBudgetSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.costbookingsettings.PageCostBookingSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig.PageMasterDataTenantLevelConfigSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings.PageProjectsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.PageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.PageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.IPageRequisitionView;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.defaultalert.PopUpDefalutAlert;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.IPopUpDefaultConfirmationImpl;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary.TabCheckoutReqSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.validation.VerifyShoppingItemsWithShoppingCarts;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class CheckOutRequsition extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(CommonServices.class);
	String			PONo	= null;

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always; the setting should be displayed in Requisition and it
	 * should be disabled with yes option selected. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275707(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275708"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275709"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275710"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_274801"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_30998"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on always
			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
			ActionBot.defaultSleep();

			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isAssingToPurchasOrderRedioBtnYesSelected(driver, testCaseName);
			Assert.assertTrue(flag, "Yes not selected");
			flag = ModelRequisitionSummaryCostBooking.isAssingToPurchasOrderRedioDisabled(driver, testCaseName);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			Assert.assertFalse(!flag, "AssignToPurchaseOrder Yes Btn Eabled");
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on Never

			PageProjectsSettings.clickOnNever(driver);

			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
			ActionBot.defaultMediumSleep();

			requisition.setReqNo(requisition.getReqNo());
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.defaultSleep();
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isAssingToPurchasOrderRedioBtnYesSelected(driver, testCaseName);
			Assert.assertFalse(flag, "yes Selected");

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes;If user selects spit ' Split cost to
	 * multiple cost centers' in header,the project field should be displayed
	 * besides budget field and on save the project should be displayed in the
	 * billing and delivery section. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275715(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on always
			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			// to create req
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);

			List<CostCenterSplitInfo> centerSplitInfo1 = new ArrayList<CostCenterSplitInfo>();
			CostCenterSplitInfo costCenterSplitInfoObject = new CostCenterSplitInfo();
			costCenterSplitInfoObject.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costCenterSplitInfoObject.setBudget(cc_budget_project.get(IConstantsData.budget));
			costCenterSplitInfoObject.setProject(cc_budget_project.get(IConstantsData.project));
			costCenterSplitInfoObject.setPercentage(100);

			centerSplitInfo1.add(costCenterSplitInfoObject);
			costBookingRequisitionSummary.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costBookingRequisitionSummary.setBudget(cc_budget_project.get(IConstantsData.budget));
			costBookingRequisitionSummary.setProject(cc_budget_project.get(IConstantsData.project));
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);
			requisition.getCostBookingRequisitionSummary().setSplitCostToMultipleCostCenter(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			costBookingRequisitionSummary.setListOfSplitedCostCenters(centerSplitInfo1);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			//			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, true);
			// search reqNo
			FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			// copy req
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isCostbookingSingleCCRadioBtnSelected(driver, testCaseName);

			Assert.assertTrue(flag);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on never
			PageProjectsSettings.clickOnNever(driver);
			PageProjectsSettings.clickOnSave(driver);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes, When the project lines are copied
	 * from PR to Buyer's desk project information should also be carried
	 * similar to cost center information. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275726(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on Always
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// to create req
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostToMultipleCostCenter(true);

			CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
			centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
			centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
			costBookingRequisitionSummary.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costBookingRequisitionSummary.setProject(cc_budget_project.get(IConstantsData.project));
			costBookingRequisitionSummary.setBudget(cc_budget_project.get(IConstantsData.budget));
			costBookingRequisitionSummary.setBookCostToSingleCostCenter(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelBuyersdeskSummaryBilling.clickOnCancelButton(driver, testCaseName);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Change Multiple on checkout >> Change multiple option
	 * should be present on checkout page at the top of the Item grid. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_201868(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201869"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64074"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64076"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64085"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64222"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64226"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64227"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31026"));

		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on never decide
			PageProjectsSettings.clickOnNever(driver);
			//Save Action
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			PageRequisitionCheckOut.clickChangeMultiple(driver, testCaseName);
			ModelChangeMultiple.clickChangeMultipleClose(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on always decide
			PageProjectsSettings.clickOnAlways(driver);
			//Save Action
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "200");
			IPageRequisitionCheckOutImpl object = new IPageRequisitionCheckOutImpl();
			boolean flag = ActionBot.isElementPresent(driver, object.CHANGE_MULTIPLE);

			//On Req View update all link should not be present so flag should be false
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);
			mappedTestCases.get(2).setTestResult(!flag);
			mappedTestCases.get(3).setTestResult(!flag);
			mappedTestCases.get(4).setTestResult(!flag);
			mappedTestCases.get(5).setTestResult(!flag);
			mappedTestCases.get(6).setTestResult(!flag);
			mappedTestCases.get(7).setTestResult(!flag);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">verify that On item details POPUP on click on Add
	 * another item,user should get redirect to free text item page with all
	 * information reset. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_64228(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();

		Map<String, String> map = new HashMap<String, String>();

		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64230"));

		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			//Get object for guided item
			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.SUGGEST_NEW_SUPPLIER);

			//Set activity to add another item
			guidedItem.setActivity(IConstantsData.AddAnotherItem);

			OnlineStore onlinestore = ObjectCreation.searchItem();
			FlowOnlineStore.searchItem(driver, testCaseName, onlinestore);

			//Add guided item
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			FlowFillGuidedItem.fillGuidedItemNAddToCart(driver, testCaseName, guidedItem);

			//Check for result 
			String shrtDes = PageFreeTextForm.getShortDescription(driver, testCaseName);

			boolean flag = false;
			if (shrtDes == null)
			{
				flag = true;
			}
			Assert.assertNull(shrtDes);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Create PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void createPo(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String status;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");

			CommonUtilities.getNonZeroRandomNumbers(2);

			requisition.setItems(item);

			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// click on first ReqNo link
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// Fill Req Change Comment
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);

			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);

			PurchaseOrder purchaseOrder1 = FlowConvertedPurchaseOrder.getPurchaseOrderinfo(driver, testCaseName, 1);

			FlowPoListing.searchPo(driver, testCaseName, purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
				approvalAllRequests.setDocumentNo(purchaseOrder1.getPoNo());
				approvalAllRequests.setActions(IConstantsData.APPROVE);
				approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
				approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
				ActionBot.defaultSleep();
			}
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ActionBot.defaultSleep();
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);

			PONo = purchaseOrder1.getPoNo();
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue(flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,The setting should not impact the Add
	 * items to existing PO display logic. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createPo" }, priority = 2)
	public void RTC_275729(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();
			Requisition requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on Let User Decide
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// select ShowAllpo
			FlowRequisition.SelctShowAllPos(driver, testCaseName, PONo);

			FlowRequisition.submitReq(driver, testCaseName, false);
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on never
			PageProjectsSettings.clickOnNever(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			// cearch in my req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			CustomDate customDate = CommonUtilities.getRequiredBy();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			// select ShowAllpo
			FlowRequisition.SelctShowAllPos(driver, testCaseName, PONo);

			FlowRequisition.submitReq(driver, testCaseName, false);
			ActionBot.defaultSleep();
			flag = PageRequisitionCheckOut.isReqCanNotBeLinkedErrorMsgDisplayed(driver, testCaseName);
			Assert.assertTrue(!flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,The setting should not impact the Add
	 * items to existing PO display logic. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", dependsOnMethods = { "createPo" }, priority = 3)
	public void RTC_272107(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();
			Requisition requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			// click on cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// click on cost Projects Link
			PageCostBookingSettings.clickOnProjects(driver);
			// Click on Let User Decide
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// select ShowAllpo
			FlowRequisition.SelctShowAllPos(driver, testCaseName, PONo);
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
			// click On Submit
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PurchaseOrder purchaseOrder1 = FlowConvertedPurchaseOrder.getPurchaseOrderinfo(driver, testCaseName, 1);
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			String shortDesc = CommonServices.getTestData(IConstantsData.SHORT_DESC_FOR_GUIDED_ITEM);
			String marketPrice = CommonServices.getTestData(IConstantsData.MARKET_PRICE);
			ActionBot.defaultSleep();
			ModalPOFreeTextItemSummaryItem.clearAndfillShortDescription(driver, testCaseName, shortDesc);
			ModalPOFreeTextItemSummaryItem.clearAndfillMarketPrice(driver, testCaseName, Integer.parseInt(marketPrice));
			// click On CostBooking
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp = StringUtils.split(amount.substring(4), ",");
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.clearAndfillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			// Draft PO &gt;&gt; Buyer should be able to change Payment Term
			// details while editing Draft PO (req to PO.)
			flag = PageStandardPO.isEditableSupplierPaymentTerms(driver);
			Assert.assertTrue(flag);
			// Draft PO &gt;&gt; Buyer should be able to change Delivery Term
			// details while editing Draft PO (req to PO.)
			ActionBot.defaultLowSleep();
			String deliveryTerms = CommonServices.getTestData(IConstantsData.DELIVERY_TERMS);
			String dTerms = PageStandardPO.selectDeliveryTerms(driver, deliveryTerms);
			flag = deliveryTerms.equalsIgnoreCase(dTerms);
			// Draft PO &gt;&gt; Buyer should be able to change PO Contact
			// details while editing Draft PO (req to PO.)
			ActionBot.defaultSleep();
			String contact = CommonServices.getTestData(IConstantsData.PO_SUPPLIER_CONTACT);
			flag = PageStandardPO.isEditableSupplierContact(driver, contact);
			Assert.assertTrue(flag);
			// Draft PO &gt;&gt; Buyer should be able to change Currency
			// exchange rate while editing Draft PO (req to PO.)
			flag = PageStandardPO.isSupplierCurrencydisplayedAslabel(driver);
			Assert.assertFalse(flag);
			// Draft PO &gt;&gt; Buyer should be able to change Buyer while
			// editing Draft PO (req to PO.)
			String buyer = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			flag = buyer.equalsIgnoreCase(PageStandardPO.enterBuyer(driver, buyer));
			// Draft PO &gt;&gt; Buyer should be able to change Delivery Address
			// while editing Draft PO (req to PO.)
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ActionBot.defaultLowSleep();
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			// Draft PO >> If Buyer change PO total by editing free text item
			// price then it should get backupdated in Order tab of req.
			String dprice = ModalDiscountPO.getTotalPoAmount(driver, testCaseName);
			// Draft PO &amp;gt;&amp;gt; Buyer should be able to change (only
			// future dates allowed) Required By Date while editing Draft PO
			// dates (req to PO.)
			PurchaseOrder purchaseorder = new PurchaseOrder();
			purchaseorder.setCustomDate(CommonUtilities.getRequiredBy());

			String dateValue = PageStandardPO.fillPreviousdate(driver, testCaseName, purchaseorder.getCustomDate().getDay(), purchaseorder.getCustomDate().getMonth(),
				purchaseorder.getCustomDate().getYear());

			// approve and released po
			StandardPO standardPO = new StandardPO();
			standardPO.setPoNumber(PageStandardPO.getPONo(driver, testCaseName));
			ActionBot.defaultSleep();
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			// Draft PO &gt;&gt; If Buyer change details of free text item (Name
			// and Description); then it should get backupdated in req in Req
			// tab on PO confirmation.
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ActionBot.defaultSleep();
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			// For first Item
			PurchaseOrder purchaseOrder3 = FlowConvertedPurchaseOrder.getReqViewPurchaseOrderinfo(driver, testCaseName, 1);
			/*
			 * boolean reqpageDetails =
			 * shortDesc.equalsIgnoreCase(purchaseOrder3.getItemName());
			 * mappedTestCases.get(12).setTestResult(reqpageDetails);
			 * Assert.assertTrue("Item Details not updated", reqpageDetails);
			 */
			System.out.println(purchaseOrder3.getDeliveryDate());
			boolean dateDetails = dateValue.equalsIgnoreCase(purchaseOrder3.getDeliveryDate());
			Assert.assertTrue(dateDetails, "Unable to update date details");
			// mappedTestCases.get(13).setTestResult(dateDetails);
			boolean Tprice = dprice.equals(purchaseOrder3.getTotalPrice());
			// mappedTestCases.get(13).setTestResult(dateDetails);
			Assert.assertTrue(Tprice, "Unable to update ");
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 235356 - User is not able to
	 * submit a requisition if a BPO is attached to a free text item . <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275719(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			//Get requisition object
			Requisition requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on let user decide
			PageProjectsSettings.clickOnLetUsersDecide(driver);
			//Save Action
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
			ActionBot.defaultSleep();

			//Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			ActionBot.scroll(driver, "-500");
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isReqSummaryProjectToolTipContainsProjectDetails(driver, testCaseName);
			Assert.assertTrue(flag, "project tooltip details not present");
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);

			//Revert setting
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			//click on never
			PageProjectsSettings.clickOnNever(driver);
			PageProjectsSettings.clickOnSave(driver);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 233500 - On adding a contract
	 * supplier contact and email id vanishes for free text item. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_325113(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80478"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80484"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80487"));

		}
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		User user = null;
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			String itemID = item.getGuidedItems().get(0).getItemID();

			// click On Item Details
			ActionBot.defaultMediumSleep();
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemID);
			ActionBot.defaultSleep();
			ModalGuidedItemSelectSupplierContract guidedItemSelectSupplierContract = new ModalGuidedItemSelectSupplierContract();

			String contract = "7374663";

			guidedItemSelectSupplierContract.setcontract(contract);
			guidedItem.setSuppliercontract(guidedItemSelectSupplierContract);
			guidedItem.setNextAction("SAVE");

			FlowRequisition.changeGuidedItemDetailsOnCheckoutPage(driver, testCaseName, guidedItem);

			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemID);
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Verify that in Section 1 Iten Details, If
	 * user change the category from category POPUP then respective changed
	 * category should be displayed in Product category field.. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_80525(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80478"));

		}
		CommonServices.startTestCase(driver, testCase);
		new Requisition();
		User user = null;
		new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes; If project selected in requisition is
	 * deactivated after it is saved in draft,on submit proper error should be
	 * displayed, <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275712(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275755"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on always
			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			//PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			String SearchItem = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			IPopUpDefaultConfirmationImpl popUp = new IPopUpDefaultConfirmationImpl();
			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			ActionBot.defaultSleep();
			//PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			requisition.setReqNo(requisition.getReqNo());
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			if (requisition != null)
			{
				flag = true;
				mappedTestCases.get(0).setTestResult(flag);
			}
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// revert setting
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			String SearchItem1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			//PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
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
		try
		{
			String SearchItem1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Unable to Active project" + e, e);
		}
		finally
		{

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 223232 - On selecting Let user's decide in customize>projects, default option in requisition is set to No. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_276283(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_276283 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276239"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			// Navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");

			// Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			// Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			// Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click Let user decide
			PageProjectsSettings.clickOnLetUsersDecide(driver);

			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// Navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// To create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isAssingToPurchasOrderRedioBtnYesSelected(driver, testCaseName);

			Assert.assertTrue(flag);
			// Change the setting
			ModelRequisitionSummaryCostBooking.clickYesAssignToPurchaseCost(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			// Click OnEdit
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			// Change setting to No
			ModelRequisitionSummaryCostBooking.clickNoAssignToPurchaseCost(driver, testCaseName);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			ModelRequisitionSummaryBilling.fillBillingCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModelRequisitionSummaryBilling.fillBillingBU(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModelRequisitionSummaryBilling.fillBillingLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isAssingToPurchasOrderRedioBtnYesSelected(driver, testCaseName);

			mappedTestCases.get(0).setTestResult(!flag);
			Assert.assertFalse(flag);
			ActionBot.defaultSleep();

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 223807 - Error 500 is
	 * displayed on viewing audit trail of a requisition in ready for approval
	 * state <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_281854(TestCase testCase) throws Exception
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

			//Get requisition object
			requisition = ObjectCreation.getRequisition(driver);

			//Get Item object
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			//Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Search requisition
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			//View requisition
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);

			ActionBot.scroll(driver, "900");

			//Check audit trail visibility
			boolean isAuditTrialVisible = ActionBot.isElementDisplayed(driver, By.xpath(IPageRequisitionView.xpath_audit_trail_header));

			Assert.assertTrue(isAuditTrialVisible, "Audit trail not visible");

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,user should be able to split the
	 * project using percentage at item level in requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275795(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_276283 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275794"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Map<String, String> cc_budget_project;
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Item item = ObjectCreation.getItem("catalogItem");
			Requisition requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			cc_budget_project = ObjectCreation.getOtherCostCenterProjectAndBudget();
			//			ObjectCreation.getItem("guidedItem");
			CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
			// to set CC split at item level
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
			costBookingItemSummary.setSplitCostCenterAtItemLevel(true);
			costBookingItemSummary.setSplitCostCenterAtItemLevel_percentage(true);
			CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
			centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
			centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
			centerSplitInfo1.setPercentage(100);
			AccountingItemSummary accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 223206 - Delivery split for
	 * an item leads to script error in a particular scenario. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275814(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53398"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53399"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53400"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_53401"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			/*
			 * DeliveryItemSummary deliveryitemsummary = new
			 * DeliveryItemSummary();
			 * deliveryitemsummary.setSplitDeliveryToMultipleLocations(true);
			 */
			CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
			centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
			centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
			costBookingRequisitionSummary.setBudget(cc_budget_project.get(IConstantsData.budget));
			costBookingRequisitionSummary.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costBookingRequisitionSummary.setProject(cc_budget_project.get(IConstantsData.project));
			costBookingRequisitionSummary.setBookCostToSingleCostCenter(true);
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnDeliveryItemEdit(driver, testCaseName);
			ModelItemSummaryDelivery.selectDeliveryOptionMultiSplit(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCostBooking.clickOnBookCostTOSingleCostCenter(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			//When Delivery option is selected for multiple location and under Booking tab we apply book cost to single cost center then the radio button for costbooking single item in not selected
			flag = ModelRequisitionSummaryCostBooking.isCostbookingSingleCCRadioBtnSelected(driver, testCaseName);
			Assert.assertTrue(!flag);
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);
			mappedTestCases.get(2).setTestResult(!flag);
			mappedTestCases.get(3).setTestResult(!flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 223562 - Number of errors on
	 * page multiplies each time on submit. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_281230(TestCase testCase) throws Exception
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

			//Get req object
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			//requisition.setEditHeaderLevelInfo(false);

			//Create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Submit req
			FlowRequisition.submitReq(driver, testCaseName, false);
			ActionBot.defaultSleep();

			//Verify error 
			boolean flag = PageRequisitionCheckOut.verifyErrorMessageOnHeader(driver, testCaseName);
			assertTrue("Error Msg present", !flag);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,If project selected in requisition is
	 * deleted after it is in ready for approval state,on submit proper error
	 * should be displayed. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275756(TestCase testCase) throws Exception
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
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			// create a project
			// PageMasterDataSettings.
			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowRequisition.submitReq(driver, testCaseName, false);
			ActionBot.defaultSleep();
			// code yet to wrt
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 227360 -
	 * Requisition>>Oracle>>Server 500 when cost center is blank and user clicks
	 * on save as draft <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_295553(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			// create a project
			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);

			CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
			centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
			centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);
			ActionBot.defaultSleep();
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			// copy req
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);

			//Set requiired by date
			CustomDate customDate = CommonUtilities.getRequiredBy();
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			ModelRequisitionSummaryBilling.fillBillingCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModelRequisitionSummaryBilling.fillBillingBU(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModelRequisitionSummaryBilling.fillBillingLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Check Cost splitting functionality in case
	 * of Draft requisition. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_53415(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		new CostBookingRequisitionSummary();
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//Get req object
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			//Save as draft
			requisition.setNextAction(IConstantsData.SAVE_AS_DRAFT_REQ);

			// create a Requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Search in My Req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);

			requisition = ObjectCreation.getRequisition(driver);

			Item item1 = ObjectCreation.getItem("guidedItem");
			//	item1.getGuidedItems().get(0).setItemID("12345-67890");
			requisition.setItems(item1);

			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);
			requisition.getCostBookingRequisitionSummary().setSplitCostAtLineItemLevel(true);
			// costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();

			// to set CostBookingItemSummary in guided items - with quantity
			costBookingItemSummary = ObjectCreation.getDefaultObjectOfCCSplitAtItemLevel(false, requisition.getItems().getGuidedItems().get(0).getQuantity());

			AccountingItemSummary accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);
			costBookingItemSummary.setNextAction(IConstantsData.SAVE);

			// requisition.getItems().getGuidedItems().get(0).setCostBookingItemSummary(costBookingItemSummary);
			requisition.setCostBookingItemSummary(costBookingItemSummary);

			ActionBot.defaultSleep();
			requisition.setOnBehalfOf(null);
			requisition.setReqName(null);
			requisition.setReasonForOrdering(null);
			requisition.setCommentForSupplier(null);
			requisition.setAssignedBuyer(null);
			requisition.setPurchaseType(null);
			FlowRequisition.fillcheckoutForm(driver, testCaseName, requisition, item);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Check Cost splitting functionality in case
	 * of Draft requisition. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_24247(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_286975: testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24248"));

		}
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			String assb = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			requisition.setAssignedBuyer(assb);
			requisition.setNextAction("NONE");
			// create a project
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			ActionBot.scroll(driver, "-200");
			FlowRequisition.submitReq(driver, testCaseName, false);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
			// get Assign buyer
			String valueOfAssignedBuyer = PageRequisitionView.getLabelValueOfAssignBuyer(driver, testCaseName);

			if (valueOfAssignedBuyer != null)
			{
				flag = true;
			}
			mappedTestCases.get(0).setTestResult(flag);
			Assert.assertTrue(flag, "Assign buyer field displayed");
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Verify that On requisition view page, User
	 * should have Delivery (It should be hidden). <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_24249(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_286975: testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24250"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24251"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24253"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24252"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22533"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22536"));
		}
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//Verify that there should be keywords below search box.
			boolean isKeywordsPresent = ActionBot.isElementPresent(driver, IPageOnlineStore.SEARCH_KEYWORDS);
			Assert.assertTrue(isKeywordsPresent, "No search keywords below search box");
			mappedTestCases.get(4).setTestResult(isKeywordsPresent);

			//Verify that there should be hyperlink on examples to fire the search on click.
			String keyword = ActionBot.findElement(driver, IPageOnlineStore.FIRST_SEARCH_KEYWORD).getText();
			ActionBot.findElement(driver, IPageOnlineStore.FIRST_SEARCH_KEYWORD).click();
			String searchText = ActionBot.getTextWithInElement(driver, IPageOnlineStore.TEXTBOX_ENTER_SEARCH_NAME);

			boolean isLinktoFireSearch = searchText.equalsIgnoreCase(keyword);
			mappedTestCases.get(5).setTestResult(isLinktoFireSearch);

			//Get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			//Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Search requisition
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			//View requisition
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "400");

			//Check whether audit trail is present or not
			boolean isAuditTrailPresent = ActionBot.isElementPresent(driver, IPageRequisitionView.AUDIT_TRAIL_LINK);
			mappedTestCases.get(2).setTestResult(isAuditTrailPresent);

			//Check whether delivery,accounting and cost booking details are hidden or not
			flag = ActionBot.isElementPresent(driver, IPageRequisitionView.ITEM_SUMMARY_BLOCK);
			Assert.assertTrue(!flag, "Delivery deatails are not hidden");
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);

			ActionBot.defaultSleep();

			//Check for workflow trail

			boolean isWorkflowinOpenState = ActionBot.isElementPresent(driver, IPageRequisitionView.WORKFLOW_OPEN_BLOCK);
			mappedTestCases.get(3).setTestResult(isWorkflowinOpenState);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Check Cost splitting functionality in case
	 * of Draft requisition. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	/*
	 * @Test(dataProvider = "dataProvider") public void RTC_24249(TestCase
	 * testCase) throws Exception { WebDriver driver =
	 * DriverSelector.getDriver(testCase); String testCaseName =
	 * testCase.getTestMethodName(); Map<String, String> map = new HashMap<String,
	 * String>(); List<MappedTestCase> mappedTestCases = new
	 * ArrayList<MappedTestCase>(); { //RTC_286975: testcase to be mapped
	 * mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24250"));
	 * } CommonServices.startTestCase(driver, testCase, mappedTestCases);
	 * Requisition requisition = new Requisition(); User user = null; boolean
	 * flag = false; try { user = LoginLogoutServices.login(driver, testCase);
	 * requisition = ObjectCreation.getRequisition(driver); Item item =
	 * ObjectCreation.getItem("catalogItem"); requisition.setItems(item);
	 * //create a project requisition =
	 * FlowRequisition.createRequisition(driver, testCaseName, requisition);
	 * FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName,
	 * requisition); PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
	 * String assb = CommonServices.getTestData(IConstantsData.BUYER_NAME);
	 * String assignBuyer = PageRequisitionView.getAssignBuyerField(driver,
	 * testCaseName); flag = assb.equalsIgnoreCase(assignBuyer);
	 * Assert.assertTrue(!flag); mappedTestCases.get(0).setTestResult(!flag);
	 * PageRequisitionView.clickOnItemDetailsLink(driver, testCaseName);
	 * CommonServices.successfulExecutionOfTestCase(driver, testCase); } catch
	 * (AssertionError e) { CommonServices.assertionMethod(driver, testCase,
	 * user, e); } catch (Exception e) { CommonServices.exceptionMethod(driver,
	 * testCase, user, e); } finally {
	 * CommonServices.afterExecutionOfTestcase(driver, testCase, map, user,
	 * mappedTestCases); } }
	 */

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Check whether system allows to compare with only one
	 * item selected or not. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_23418(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// search an item
			String searchText = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageOnlineStore.fillSearchText(driver, testCaseName, searchText);
			PageOnlineStore.clickSearchButton(driver, testCaseName);
			ObjectCreation.getItem("catalogItem");
			// String itemId = item.getCatelogItems().get(0).getItemID();
			PageSearchListing.clickOnCatalogItemCheckBoxOfItem(driver, testCaseName);
			PageSearchListing.clickOnCompareMultipleItems(driver, testCaseName);
			flag = PageSearchListing.isAlertpopUpForTwoItemsDisplayed(driver, testCaseName);
			Assert.assertFalse(flag, "Atleast compare two item msg not displayed");
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">System should ask for confirmation when ented large
	 * quantities while adding to cart. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_23134(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// search an item
			Requisition requisition = new Requisition();

			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");

			requisition.setItems(item);

			requisition.setItems(item);
			int quantity = CommonUtilities.getNonZeroRandomNumbers(9);
			requisition.getItems().getCatelogItems().get(0).setQuantity(quantity);
			String itemName = FlowSearchListing.searchItem(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemName());
			String itemId = PageSearchListing.getItemId(driver, testCaseName, requisition.getItems().getCatelogItems().get(0).getItemName());

			PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, quantity);

			PageSearchListing.addToCart(driver, testCaseName, itemId);
			boolean flagForConfirmationPopup = PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName);
			assertTrue("System should ask for confirmation when ented large quantities while adding to cart", flagForConfirmationPopup);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize&gt;Cost booking: Assign cost to
	 * project&gt;Always/Let user decide:Yes,In case of outdated projects when
	 * requisition is converted to PO at suggsted po screen proper error should
	 * be thrown displayed. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275734(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		String SearchItem = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on Always Decide
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// Fill Req Change Comment
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);

			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			// Purchase Order Object Creation
			// For first Item
			PurchaseOrder purchaseOrder1 = FlowConvertedPurchaseOrder.getPurchaseOrderinfo(driver, testCaseName, 1);
			// search po

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// deActivate Project Link
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);

			IPopUpDefaultConfirmationImpl popUp = new IPopUpDefaultConfirmationImpl();
			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			ActionBot.defaultSleep();
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			FlowPoListing.searchPo(driver, testCaseName, purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// deActivate PrejectLink
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);

			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			ActionBot.defaultSleep();
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
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
		try
		{
			/*
			 * String SearchItem1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			 * PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			 * PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			 * PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			 * PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			 */
		}
		catch (Exception e)
		{
			logger.error("Unable to Active project" + e, e);
		}
		finally
		{

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>>Cost booking: Assign cost
	 * to project&amp>>Always/Let user decide:Yes; Outdated projects should
	 * not be loaded in projects field. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275711(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275713"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on always
			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			String costBookingSingleProject = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject);
			ModelRequisitionSummaryCommon.clickCancleReqSummary(driver, testCaseName);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			if (requisition != null)
			{
				flag = true;
				mappedTestCases.get(0).setTestResult(flag);
			}
			{
				CommonServices.successfulExecutionOfTestCase(driver, testCase);
			}
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		try
		{
			String SearchItem1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Unable to Active project" + e, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Item listing page should have a Field to
	 * input quantity, and a button to add to cart <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_12757(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_13375 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13375"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_12996"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_12999"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13005"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13006"));
			// need to update in xls
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13739"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64221"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64220"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			Item items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
			requisition.setItems(items);
			flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
			assertTrue("Item added to cart are wrong", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			// click on check out
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>verify that On free text item page,
	 * "change category" option should be present. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_64212(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_13375 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64213"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64217"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64218"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_64219"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80525"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80527"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80529"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// add item with 0 quantity
			GuidedItem guidedItem = new GuidedItem();
			guidedItems.add(guidedItem);
			guidedItem.setItemName(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			FlowSearchListing.searchItem(driver, testCaseName, guidedItems.get(0).getItemName());
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			flag = PageFreeTextForm.isSelectCategoryLinkPresent(driver, testCaseName);
			Assert.assertTrue(flag);

			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);

			boolean flag1 = PageFreeTextForm.isCreateFreeTextItemLabelPresent(driver, testCaseName);
			mappedTestCases.get(1).setTestResult(flag1);

			String shortDescription = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageFreeTextForm.fillShortDescription(driver, testCaseName, shortDescription);

			String selectCategory = CommonServices.getTestData(IConstantsData.Item_Product_Category);
			ActionBot.defaultSleep();
			PageFreeTextForm.fillLongDescription(driver, testCaseName, "test");

			PageFreeTextForm.clickOnSelectCategory(driver, testCaseName);

			if (ActionBot.isElementDisplayed(driver, IPageFreeTextForm.SELECT_CATEGORY))
			{
				//ActionBot.click(driver, IPageFreeTextForm.SELECT_CATEGORY);
				//ActionBot.defaultSleep();
			}
			ModalSelectCategory.fillSelectCategory(driver, testCaseName, selectCategory);
			ModalSelectCategory.clickOnSelectEform(driver, testCaseName);
			ActionBot.defaultSleep();
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			// clear search result
			ActionBot.click(driver, IModalSelectCategory.CHANGE_CATEGORY);
			ActionBot.defaultMediumSleep();
			if (ActionBot.isElementDisplayed(driver, IModalSelectCategoryImpl.CLEAR_SEARCH_RESULTS))
			{
				ModalSelectCategory.toClickClearSearchResults(driver, testCaseName);
			}

			ModalSelectCategory.fillSelectCategory(driver, testCaseName, selectCategory);
			ModalSelectCategory.clickOnSelectEform(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// enter Alpha numeric char
			String shortDescription1 = CommonServices.getTestData(IConstantsData.SPECIAL_CHARACTER_ITEMNAME);
			PageFreeTextForm.fillShortDescription(driver, testCaseName, shortDescription1);
			String longDescription = CommonServices.getTestData(IConstantsData.SPECIAL_CHARACTER_ITEMNAME);
			PageFreeTextForm.fillLongDescription(driver, testCaseName, longDescription);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>verify that On free text item page,
	 * "change category" option should be present. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_145054(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_13375 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_145053"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_145055"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80531"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80532"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80533"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80534"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_80537"));
		}
		CommonServices.startTestCase(driver, testCase);
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item items = new Item();
		Requisition requisition = new Requisition();
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// add item with 0 quantity
			// to get guided item
			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.SUGGEST_NEW_SUPPLIER);
			// guidedItem.getGuidedItemSuggestSupplier().s

			guidedItems.add(guidedItem);

			items.setGuidedItems(guidedItems);

			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);
			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, item.getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			String contract = CommonServices.getTestData(IConstantsData.CONTRACT_NO);
			ModalGuidedItemDetails.clickEditForRequestedSuggestedSuppliers(driver, testCaseName, 1);
			//	String cNo = ModalGuidedItemDetails.fillSupplierContract(driver, testCaseName, contract);
			String cNo = ModalGuidedItemDetails.fillContractNoForNewSupplier(driver, testCaseName, contract);
			boolean cno = cNo.equalsIgnoreCase(contract);
			Assert.assertTrue(cno);
			mappedTestCases.get(0).setTestResult(cno);
			mappedTestCases.get(1).setTestResult(cno);
			mappedTestCases.get(2).setTestResult(cno);
			mappedTestCases.get(3).setTestResult(cno);
			mappedTestCases.get(4).setTestResult(cno);
			mappedTestCases.get(5).setTestResult(cno);
			mappedTestCases.get(6).setTestResult(cno);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);
			//	PageRequisitionView.clickOnItemDetailsLink(driver, testCaseName);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 224593 - Price mentioned for
	 * need a quote item vanishes on saving the item modal. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_286040(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItems.add(guidedItem);
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			String itemID = item.getGuidedItems().get(0).getItemID();
			items.setGuidedItems(guidedItems);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.NONE);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, item.getGuidedItems().get(0).getItemID());
			String price = CommonServices.getTestData(IConstantsData.MARKET_PRICE);
			ModalGuidedItemDetails.fillPrice(driver, testCaseName, Float.parseFloat(price));
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			// click on item details
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemID);

			String pricedetails = ModalGuidedItemDetails.getItemPrice(driver, testCaseName);

			Assert.assertEquals(pricedetails, price);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 223102 - Budget not seen in
	 * cost booking section in requisition view page on ordering a need a quote
	 * item. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275803(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItems.add(guidedItem);
			items.setGuidedItems(guidedItems);
			ObjectCreation.getItem("guidedItem");
			// to get requisition object
			/* requisition = ObjectCreation.getRequisition(driver); */
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			// click on cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// click on cost Projects Link
			//	PageCostBookingSettings.clickOnBudget(driver);
			// Click on Let User Decide
			PageBudgetSettings.clickOnAllowBudgetUtilizationYES(driver, testCaseName);

			// Click On Save
			PageProjectsSettings.clickOnSave(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// chceck budget
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "200");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionView.clickOnExpandCostBooking(driver, testCaseName);
			ActionBot.defaultSleep();
			boolean flag = PageRequisitionView.isBudgetDisplayedInsideCostBooking(driver, testCaseName);
			Assert.assertTrue(flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 222318 - Script error is
	 * displayed on clicking on assign buyer modal for ready for approval
	 * requisitions <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_268795(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_269140"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_269318"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = new Requisition();
		boolean flag = false;
		Item items = new Item();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//Clear cart
			FlowOnlineStore.clearCart(driver, testCaseName);
			items = ObjectCreation.getItem("guidedItem");
			//	 to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setNextAction(IConstantsData.NONE);
			requisition.setAssignedBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setItems(items);

			//Create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickOnModifyWorkFlowSettings(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, false);
			ActionBot.defaultMediumSleep();

			//View req
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);

			PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
			PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
			// get Assign buyer
			String valueOfAssignedBuyer = PageRequisitionView.getLabelValueOfAssignBuyer(driver, testCaseName);

			if (valueOfAssignedBuyer != null)
			{
				flag = true;
			}
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			Assert.assertTrue(flag, "Assign buyer field displayed");
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to select one or more
	 * items, specify quantity and add them to a basket. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_13760(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13771"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13734"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13735"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13001"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13737"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_12760"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13752"));

		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//Get requisition object
			Requisition requisition = ObjectCreation.getRequisition(driver);

			//Get item
			Item item = ObjectCreation.getItem("catalogItem");

			int quantity = CommonUtilities.getNonZeroRandomNumbers(2);

			CatelogItem catelogItem2 = new CatelogItem();
			catelogItem2.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			catelogItem2.setQuantity(quantity);

			item.getCatelogItems().add(catelogItem2);

			requisition.setNextAction(IConstantsData.NONE);
			requisition.setItems(item);

			//Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Save req as draft
			FlowRequisition.saveReqAsDraft(driver, testCaseName);

			// Check 
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			boolean flag = requisition.equals(requisition);
			Assert.assertTrue(flag, "Requisition not found");

			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Verify that Draft status REQ should open
	 * in EDIT mode on click. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_58109(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58111"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58112"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31063"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_31064"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_259356"));

		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");

			requisition.setNextAction(IConstantsData.NONE);
			requisition.setItems(item);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);

			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			//code to press enter

			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.defaultSleep();

			FlowRequisition.submitReq(driver, testCaseName, false);
			ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.REQ_LIST_PROCESSING);
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ActionBot.defaultMediumSleep();
			MyRequisitionFilter myRequisitionFilter = new MyRequisitionFilter();
			myRequisitionFilter.setInApprovalFilter(true);
			ActionBot.defaultSleep();
			FlowMyRequisitions.applyMyRequisitionStatusFilter(driver, testCaseName, myRequisitionFilter);
			ActionBot.defaultMediumSleep();
			//	ModalMyRequisitionStatusFilters.clickOnFilterBtn(driver, testCaseName);
			String status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			//ask kunal
			boolean flag = status.trim().contains((IConstantsData.IN_APPROVAL_FILTER_LABEL).trim());
			//	boolean flag = status.equalsIgnoreCase(IConstantsData.APPROVED_FILTER_STATUS);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			PageMyRequisition.clickOnReqNoLink(driver, testCaseName);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Checkout Requisition>> GL accounts in the
	 * document should be defaulted taking into consideration cost center and
	 * line item cost <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_286973(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_286975: testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286975"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Requisition requisition = new Requisition();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			// create gl map
			GLMap glMap = ObjectCreation.getDefaultObjectOfGLMap();
			glMap = FlowGLMap.createGLMap(driver, testCaseName, glMap);

			// go to req-chkout
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			requisition.getCostBookingItemSummary().getAccountingItemSummary().setGlAccount(glMap.getGlAccount());
			requisition.setNextAction(IConstantsData.NONE);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// FlowRequisition
			String itemID = requisition.getItems().getCatelogItems().get(0).getItemID();
			// click on item expandAll
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			boolean isglmap = FlowRequisition.isGLAccountSameAsGLMap(driver, testCaseName, glMap, itemID);
			mappedTestCases.get(0).setTestResult(isglmap);
			Assert.assertTrue(isglmap, "is Default glMap Present");
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Checkout Requisition >> Redefaulting of GL
	 * based on Purchase type selection will remain as is. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_286978(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_286974: testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286974"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286979"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_307436"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("" + ""));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289276"));

		}
		User user = null;
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		GLMap glMapC1P2GLAcc2Company1 = new GLMap();
		GLMap glMapC1AnyPurchaseTypeGLAcc3Company1 = new GLMap();
		GLMap glMapC2P2GLAcc1Company1 = new GLMap();
		GLMap glMapC2P1GLAcc2Company1 = new GLMap();
		GLMap glMapC2AnyPurchaseTypeGLAcc3Company1 = new GLMap();
		GLMap glMapC2AnyPurchaseTypeGLAcc5Company2 = new GLMap();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		String purchaseTypeName, defaultedGLAccount, itemId;
		boolean flag = false, flag1 = false, flag2 = false;
		new Requisition();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.YES);

			// to change req settings
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// GL Maps
			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);
			glMapC1P2GLAcc2Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType2_AnyCC_Amount_GLType2_GLAccount2_Company1);
			glMapC1AnyPurchaseTypeGLAcc3Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_AnyPurchaseType_AnyCC_Amount_GLType3_GLAccount3_Company1);
			glMapC2P2GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category2_PurchaseType2_AnyCC_Amount_GLType1_GLAccount1_Company1);
			glMapC2P1GLAcc2Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category2_PurchaseType1_AnyCC_Amount_GLType2_GLAccount2_Company1);
			glMapC2AnyPurchaseTypeGLAcc3Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category2_AnyPurchaseType_AnyCC_Amount_GLType3_GLAccount3_Company1);
			glMapC2AnyPurchaseTypeGLAcc5Company2 = ObjectCreation.getGLMapObject(IConstantsData.Category2_AnyPurchaseType_AnyCC_Amount_GLType2_GLAccount5_Company2);

			item = ObjectCreation.getItem("guidedItem");
			// guided item with specified category
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			ModalGuidedItemSelectCategory categoryModal = new ModalGuidedItemSelectCategory();
			categoryModal.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			//			guidedItem.setCategory(categoryModal);

			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);

			item.getGuidedItems().get(0).setCategory(categoryModal);
			//			guidedItems.add(guidedItem);
			//			item.setGuidedItems(guidedItems);

			// Online store tab
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// to add item and checkout
			item = FlowRequisition.addItemAndCheckout(driver, testCaseName, item);

			ActionBot.scroll(driver, "500");
			itemId = item.getGuidedItems().get(0).getItemID();
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, item.getGuidedItems().get(0).getItemID());
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			Requisition requisition = ObjectCreation.getRequisition(driver);
			ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, requisition.getCostBookingItemSummary().getAccountingItemSummary().getGlAccount(), itemId, 0);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			purchaseTypeName = PageRequisitionCheckOut.getSelectedPurchaseType(driver, testCaseName);

			flag = purchaseTypeName.equalsIgnoreCase(IConstantsData.SELECT_OPTION_DEFAULT_VALUE);

			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag1 = defaultedGLAccount.equalsIgnoreCase(glMapC1AnyPurchaseTypeGLAcc3Company1.getGlAccount());
			// select purchase type
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, glMapC1P1GLAcc1Company1.getPurchaseType());
			// override gl account
			FlowRequisition.overrideGLAccount(driver, testCaseName, true);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag2 = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			flag = flag1 && flag2;

			// change purchase type
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, glMapC1P2GLAcc2Company1.getPurchaseType());
			// dont override gl account
			FlowRequisition.overrideGLAccount(driver, testCaseName, false);
			ActionBot.scroll(driver, "400");

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount()) && !defaultedGLAccount.equalsIgnoreCase(glMapC1P2GLAcc2Company1.getGlAccount());

			// view item details
			FlowRequisition.viewItemDetails(driver, testCaseName, itemId);
			// change category
			GuidedItem guidedItem2 = new GuidedItem();
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(glMapC2P2GLAcc1Company1.getCategory());
			guidedItem2.setCategory(guidedItemSelectCategory);
			guidedItem2.setNextAction(IConstantsData.SAVE);

			guidedItem2 = FlowRequisition.changeGuidedItemDetailsOnCheckoutPage(driver, testCaseName, guidedItem2);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag = defaultedGLAccount.equalsIgnoreCase(glMapC2P2GLAcc1Company1.getGlAccount());

			// change purchase type
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, glMapC2P1GLAcc2Company1.getPurchaseType());
			// dont override gl account
			FlowRequisition.overrideGLAccount(driver, testCaseName, true);
			ActionBot.scroll(driver, "400");

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag = defaultedGLAccount.equalsIgnoreCase(glMapC2P1GLAcc2Company1.getGlAccount());

			// check available gl accounts
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCostBooking.clearGLAccounts(driver, testCaseName, itemId, 0);

			List<String> availableGlAccounts = ModelItemSummaryCostBooking.getListOfNamesAvailableGLAccounts(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

			flag = false;
			for (String glAccount : availableGlAccounts)
			{
				if (glAccount.equalsIgnoreCase(glMapC2P1GLAcc2Company1.getGlAccount()) || glAccount.equalsIgnoreCase(glMapC2P2GLAcc1Company1.getGlAccount())
					|| glAccount.equalsIgnoreCase(glMapC2AnyPurchaseTypeGLAcc3Company1.getGlAccount()))
				{
					flag = true;
				}
			}

			CustomDate customDate = CommonUtilities.getTodaysDate();
			// required by date
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());

			BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
			billingRequisitionSummary.setCompany(glMapC2AnyPurchaseTypeGLAcc5Company2.getCompany());
			billingRequisitionSummary.setNextAction(IConstantsData.NONE);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			billingRequisitionSummary = FlowRequisition.fillBillingRequisitionSummary(driver, testCaseName, billingRequisitionSummary);

			CostBookingRequisitionSummary costBookingRequisitionSummary = ObjectCreation.getDefaultObjectOfCostBookingOfOtherCompany();
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			FlowRequisition.fillCostBookingRequisitionSummary(driver, testCaseName, costBookingRequisitionSummary);

			ActionBot.scroll(driver, "400");

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag = defaultedGLAccount.equalsIgnoreCase(glMapC2AnyPurchaseTypeGLAcc5Company2.getGlAccount());
			assertTrue("Accounting details was not reset as per new Company selected", flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 225698 - When single purchase
	 * type is defaulted, GL accounting is not defaulted <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_291884(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		String purchaseTypeName, defaultedGLAccount, itemId;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to change req settings

			//requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.YES);
			//requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// GL Maps
			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);

			// guided item with specified category
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			ModalGuidedItemSelectCategory categoryModal = new ModalGuidedItemSelectCategory();
			categoryModal.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			guidedItem.setCategory(categoryModal);

			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);

			// Online store tab
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// to add item and checkout
			item = FlowRequisition.addItemAndCheckout(driver, testCaseName, item);

			purchaseTypeName = PageRequisitionCheckOut.getSelectedPurchaseType(driver, testCaseName);
			flag = purchaseTypeName.equalsIgnoreCase(IConstantsData.SELECT_OPTION_DEFAULT_VALUE);

			itemId = item.getGuidedItems().get(0).getItemID();

			// select purchase type
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, glMapC1P1GLAcc1Company1.getPurchaseType());

			// override gl account
			FlowRequisition.overrideGLAccount(driver, testCaseName, true);

			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);

			boolean result = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			assertTrue("Accounting details was not reset as per new Company selected", result);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Checkout Requisition >>Changing CC from
	 * Header due company change or by change multiple option will redefault GL
	 * type/account. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_286980(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286981"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286982"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286983"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286984"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286985"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286986"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_286987"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289278"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289349"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289326"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289325"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_289445"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Item item = new Item();
		String purchaseTypeName, defaultedGLAccount, itemId;
		boolean flag = false, flag2 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.YES);
			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// GL Maps

			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			ModalGuidedItemSelectCategory categoryModal = new ModalGuidedItemSelectCategory();
			categoryModal.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			guidedItem.setCategory(categoryModal);

			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);

			// Online store tab
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// to add item and checkout
			item = FlowRequisition.addItemAndCheckout(driver, testCaseName, item);

			purchaseTypeName = PageRequisitionCheckOut.getSelectedPurchaseType(driver, testCaseName);

			flag = purchaseTypeName.equalsIgnoreCase(IConstantsData.SELECT_OPTION_DEFAULT_VALUE);

			itemId = item.getGuidedItems().get(0).getItemID();

			// select purchase type
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, glMapC1P1GLAcc1Company1.getPurchaseType());
			// override gl account
			FlowRequisition.overrideGLAccount(driver, testCaseName, true);

			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag2 = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			// check cc at header level
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);

			String cc_project_budget = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);
			StringTokenizer st = new StringTokenizer(cc_project_budget);
			String costBookingSingleCC = st.nextToken(",");
			String project = st.nextToken(",");
			String budget = st.nextToken(",");
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, costBookingSingleCC);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, project);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, budget);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			// check ccat
			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag2 = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			assertTrue("Accounting details was not reset as per new Company selected", flag2);
			// check update all line
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ActionBot.defaultSleep();
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, costBookingSingleCC);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, budget);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, project);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);

			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
			// check ccat
			PageRequisitionCheckOut.clickChangeMultiple(driver, testCaseName);
			ModelChangeMultiple.fillChangeMultipleCostCenter(driver, testCaseName, costBookingSingleCC);
			ModelChangeMultiple.clickChangeMultipleApply(driver, testCaseName);

			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag2 = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			assertTrue("Accounting details was not reset as per new Company selected", flag2);
			mappedTestCases.get(9).setTestResult(flag2);
			mappedTestCases.get(8).setTestResult(flag2);

			mappedTestCases.get(0).setTestResult(flag2);
			mappedTestCases.get(1).setTestResult(flag2);
			mappedTestCases.get(2).setTestResult(flag2);
			mappedTestCases.get(3).setTestResult(flag2);
			mappedTestCases.get(4).setTestResult(flag2);
			mappedTestCases.get(5).setTestResult(flag2);
			mappedTestCases.get(6).setTestResult(flag2);
			mappedTestCases.get(7).setTestResult(flag2);
			// change qty
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			defaultedGLAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemId);
			int itemQty = 1;
			PageRequisitionCheckOut.fillItemQuantity(driver, testCaseName, itemQty, itemId);
			PageRequisitionCheckOut.clickChangeMultiple(driver, testCaseName);
			defaultedGLAccount = CommonUtilities.getProperGLAccount(defaultedGLAccount);
			flag2 = defaultedGLAccount.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			assertTrue("Accounting details was not reset as per new Company selected", flag2);
			mappedTestCases.get(10).setTestResult(flag2);
			mappedTestCases.get(11).setTestResult(flag2);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize&gt;Cost booking: Assign cost to
	 * project&gt;Always/Let user decide:Yes,In case of outdated projects when
	 * requisition is converted to PO from buyer desk's listing and is in
	 * suggested po screen <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275736(TestCase testCase) throws Exception
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
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			/*
			 * //go to setup->customize
			 * MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver,
			 * testCaseName); // click on cost booking link
			 * PageCustomizeSettings.clickOnCostBookingLink(driver,
			 * testCaseName); // click on cost Projects Link
			 * PageCostBookingSettings.clickOnProjects(driver); // Click on Let
			 * User Decide PageProjectsSettings.clickOnAlways(driver); // Click
			 * On Save PageProjectsSettings.clickOnSave(driver);
			 */
			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			String costBookingSingleProject = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject);
			String costBookingSingleBudget = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget);
			//ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName,
			//	costBookingSingleBudget);
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
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			// Purchase Order Object Creation
			// For first Item
			PurchaseOrder purchaseOrder1 = FlowConvertedPurchaseOrder.getPurchaseOrderinfo(driver, testCaseName, 1);

			// search po
			/*
			 * //deActivate PrejectLink >>>>>>> .r4613
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			 * // fill searchBox String SearchItem =
			 * CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			 * PageProjectsMasterDataSettings.fillProjectSearchBox(driver,
			 * testCaseName, SearchItem);
			 * PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			 * PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
			 */
			// change Date

			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getPreviousDayDate());
			PageProjectsMasterDataSettings.fillProjectEndDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			// submit po
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			// revert setting
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			String SearchItem1 = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
			// change Date
			PurchaseOrder purchaseOrder2 = new PurchaseOrder();
			purchaseOrder2.setCustomDate(CommonUtilities.getRequiredBy());
			PageProjectsMasterDataSettings.fillProjectEndDate(driver, testCaseName, purchaseOrder2.getCustomDate().getDay(), purchaseOrder2.getCustomDate().getMonth(),
				purchaseOrder2.getCustomDate().getYear());
			PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);

			/*
			 * PurchaseOrder purchaseOrder = new PurchaseOrder();
			 * purchaseOrder.setCustomDate(CommonUtilities.getPreviousDayDate())
			 * ; PageProjectsMasterDataSettings.fillProjectEndDate(driver,
			 * testCaseName, purchaseOrder.getCustomDate() .getDay(),
			 * purchaseOrder.getCustomDate().getMonth(),
			 * purchaseOrder.getCustomDate().getYear());
			 * PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver,
			 * testCaseName);
			 * PageMasterDataSettings.clickOnReturnToSetUpModule(driver,
			 * testCaseName); FlowPoListing.searchPo(driver, testCaseName,
			 * purchaseOrder1.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			 * PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			 * //submit po FlowStandardPo.submitPoForProcessing(driver,
			 * testCaseName); //revert setting
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			 * //fill searchBox String SearchItem1 =
			 * CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			 * PageProjectsMasterDataSettings.fillProjectSearchBox(driver,
			 * testCaseName, SearchItem1);
			 * PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			 * PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
			 * //change Date PurchaseOrder purchaseOrder2 = new PurchaseOrder();
			 * purchaseOrder2.setCustomDate(CommonUtilities.getRequiredBy());
			 * PageProjectsMasterDataSettings.fillProjectEndDate(driver,
			 * testCaseName, purchaseOrder2.getCustomDate() .getDay(),
			 * purchaseOrder2.getCustomDate().getMonth(),
			 * purchaseOrder2.getCustomDate().getYear());
			 * PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver,
			 * testCaseName);
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
		/*
		 * try { MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		 * PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName); //
		 * fill searchBox String SearchItem1 =
		 * CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
		 * PageProjectsMasterDataSettings.fillProjectSearchBox(driver,
		 * testCaseName, SearchItem1);
		 * PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		 * PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName); //
		 * change Date PurchaseOrder purchaseOrder2 = new PurchaseOrder();
		 * purchaseOrder2.setCustomDate(CommonUtilities.getRequiredBy());
		 * PageProjectsMasterDataSettings.fillProjectEndDate(driver,
		 * testCaseName, purchaseOrder2.getCustomDate().getDay(),
		 * purchaseOrder2.getCustomDate().getMonth(),
		 * purchaseOrder2.getCustomDate() .getYear());
		 * PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver,
		 * testCaseName); } catch ( Exception e ) { logger.error(
		 * "Unable to revert project date" + e, e); }
		 */
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize&gt;Cost booking: Assign cost to
	 * project&gt;Always/Let user decide:Yes,In case of outdated projects when
	 * requisition is converted to PO from buyer desk's listing and is in
	 * suggested po screen <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275737(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275739"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275751"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275754"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287223"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_30999"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			// go to setup->customize
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			// click on cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// click on cost Projects Link
			PageCostBookingSettings.clickOnProjects(driver);
			// Click on Let User Decide
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);
			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			String costBookingSingleProject = CommonServices.getTestData(IConstantsData.MUlTILINGUAL_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject);
			String costBookingSingleBudget = CommonServices.getTestData(IConstantsData.budget);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			boolean hproject = PageRequisitionCheckOut.isHeaderLevelProjectDisplayed(driver, testCaseName);
			Assert.assertTrue(hproject);
			mappedTestCases.get(0).setTestResult(hproject);
			mappedTestCases.get(1).setTestResult(hproject);
			mappedTestCases.get(2).setTestResult(hproject);
			mappedTestCases.get(3).setTestResult(hproject);
			mappedTestCases.get(4).setTestResult(hproject);
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			// special character
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			String costBookingSingleProject1 = CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject1);
			String costBookingSingleBudget1 = CommonServices.getTestData(IConstantsData.budget);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget1);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			boolean hproject1 = PageRequisitionCheckOut.isHeaderLevelProjectDisplayed(driver, testCaseName);
			Assert.assertTrue(hproject1);
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			// Max character
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			String costBookingSingleProject2 = CommonServices.getTestData(IConstantsData.MAXLENGTHCHAR_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject2);
			String costBookingSingleBudget2 = CommonServices.getTestData(IConstantsData.budget);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget2);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			boolean hproject2 = PageRequisitionCheckOut.isHeaderLevelProjectDisplayed(driver, testCaseName);
			Assert.assertTrue(hproject2);
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			FlowRequisition.saveReqAsDraft(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			String SearchItem1 = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			String costBookingSingleProject3 = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingSingleProject3);
			String costBookingSingleBudget3 = CommonServices.getTestData(IConstantsData.budget);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingSingleBudget3);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
			// revert Setting
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
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
		try
		{
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			String SearchItem1 = CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Unable to revert project date" + e, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Setup > Customize > Master data >
	 * Accounting: Enforce amount based general ledger rules on PO & Invoice: ()
	 * Yes (o) No setting should be present <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_286988(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_293759"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_294043"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnCustomize(driver, testCaseName);

			// click on control
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);
			ActionBot.defaultSleep();
			flag = PageMasterDataTenantLevelConfigSettings.isEnforcePTBasedValidationOfGLAccountsYESNOSettingPresent(driver, testCaseName);
			Assert.assertTrue(flag);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			String deliveryDeliverTo = IConstantsData.DELIVER_TO_FIELD;
			String dTO = ModelRequisitionSummaryDelivery.fillDeliveryDeliverTo(driver, testCaseName, deliveryDeliverTo);
			flag = dTO.equalsIgnoreCase(deliveryDeliverTo);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
			//			PageRequisitionCheckOut.clickCurrencyWiseTotal(driver, testCaseName);
			//			PageRequisitionCheckOut.clickOnCloseCurrencyWiseTotalLink(driver, testCaseName);

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 200854 - Draft REQ not
	 * getting deleted from REQ listing. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_134409(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_134381"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		Item item = null;
		Item item2 = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);
			item.setGuidedItems(null);
			//	System.out.println(item.getGuidedItems().size());

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// save req as draft
			FlowRequisition.saveReqAsDraft(driver, testCaseName);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			// delete the req
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnDeleteLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			//FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ActionBot.defaultSleep();
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			boolean flag1 = PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, 1);
			Assert.assertFalse(flag1, "Delete under action is not present for drafted requisition");
			// go to checkout screen and and check whether check out screen is
			// displayed/not
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			item2 = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item2);
			System.out.println(item2.getGuidedItems().size());
			item2.setCatelogItems(null);
			// to add items
			if (requisition.getItems() != null)
			{
				//item2.setGuidedItems(null);
				item2 = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
			}
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.clickOnCheckOut(driver, testCaseName);
			flag = PageRequisitionCheckOut.isHeaderCheckoutIconDisplayed(driver, testCaseName);
			Assert.assertTrue(flag);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Test for bug 201411 - Status of the requisition is displayed as 'Awaiting Approval' even though
	 * the approval request have been recalled <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_134431(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		User user = null;
		try
		{
			//Login
			user = LoginLogoutServices.login(driver, testCase);

			String recallcomment = IConstantsData.COMPLETE_RELEASED_FILTER_LABEL;

			//Get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			//Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// click On Myreq
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);

			//Search req in Myreq 
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			//Recall req
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			PageMyRequisition.clickOnRecallApprocalRequestLink(driver, testCaseName);
			PageMyRequisition.fillRecallApprovalComment(driver, testCaseName, recallcomment);

			//Check status of recalled req
			ActionBot.defaultMediumSleep();
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			String status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean flag = status.contains("Draft");

			Assert.assertTrue(flag, "Status of the requisition is displayed as Awaiting Approval even though the approval request have been recalled");

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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Customize>Cost booking: Assign cost to
	 * project>Always/Let user decide:Yes,In case of inactive projects when
	 * requisition is converted to PO at suggsted po screen proper error should
	 * be thrown displayed. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275758(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Requisition requisition = new Requisition();
		String SearchItem = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnCustomize(driver, testCaseName);

			// click on cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on Let User Decide
			PageProjectsSettings.clickOnAlways(driver);
			// Click On Save
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// to create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// deactivate the project

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// deActivate PrejectLink
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);

			IPopUpDefaultConfirmationImpl popUp = new IPopUpDefaultConfirmationImpl();
			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			ActionBot.defaultSleep();
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			// check whether error is displayed or not
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);

			PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

			// Fill Req Change Comment
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);

			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			// Purchase Order Object Creation
			// For first Item
			PurchaseOrder purchaseOrder1 = FlowConvertedPurchaseOrder.getPurchaseOrderinfo(driver, testCaseName, 1);
			// search po
			// revert setting
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// deActivate PrejectLink
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			// fill searchBox
			PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, SearchItem);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);

			popUp.clickOnConfirmYesButtonSpanType(driver, testCaseName);
			ActionBot.defaultSleep();
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

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
		/*
		 * finally { try { MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		 * PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		 * String SearchItem1 =
		 * CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT);
		 * PageProjectsMasterDataSettings.fillProjectSearchBox(driver,
		 * testCaseName, SearchItem1);
		 * PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		 * PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
		 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
		 * testCaseName);
		 * PageMasterDataSettings.clickOnReturnToSetUpModule(driver,
		 * testCaseName); } catch ( Exception e ) { logger.error(
		 * "Exception occurred while changing data of Project" + e, e); }
		 */
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Verify that Allow splitting cost to
	 * multiple cost centers setting has Yes option selected by default. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_287120(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// RTC_22610 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287121"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);

			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();

			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);

			List<CostCenterSplitInfo> centerSplitInfo1 = new ArrayList<CostCenterSplitInfo>();
			CostCenterSplitInfo costCenterSplitInfoObject = new CostCenterSplitInfo();
			costCenterSplitInfoObject.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costCenterSplitInfoObject.setBudget(cc_budget_project.get(IConstantsData.budget));
			costCenterSplitInfoObject.setProject(cc_budget_project.get(IConstantsData.project));
			costCenterSplitInfoObject.setPercentage(100);

			centerSplitInfo1.add(costCenterSplitInfoObject);
			costBookingRequisitionSummary.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costBookingRequisitionSummary.setBudget(cc_budget_project.get(IConstantsData.budget));
			costBookingRequisitionSummary.setProject(cc_budget_project.get(IConstantsData.project));
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);
			requisition.getCostBookingRequisitionSummary().setSplitCostToMultipleCostCenter(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			costBookingRequisitionSummary.setListOfSplitedCostCenters(centerSplitInfo1);

			requisition.setNextAction(IConstantsData.NONE);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isselectCostBookingOptionMultipleCCDisplayed(driver, testCaseName);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
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
	 * <b>Author: Amit Dash </b> <b><br>
	 * <font color="blue">Method :</b>Allow splitting cost to multiple cost
	 * centers setting > No- Split cost to multiple cost centers at header level
	 * will not be available in requisition. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_287122(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		Map<String, String> cc_budget_project;
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287123"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287124"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287125"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287126"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287127"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287130"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;
		boolean flag = false;
		try
		{
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Global_Role");
			LoginLogoutServices.login(driver, testCase, user);
			// change the setting in customize masterdata
			Assert.assertFalse(flag);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");

			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);

			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			// Click on always
			PageProjectsSettings.clickOnLetUsersDecide(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("catalogItem");
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.NONE);

			cc_budget_project = ObjectCreation.getCostCenterProjectAndBudget();

			requisition.getCostBookingRequisitionSummary().setBookCostToSingleCostCenter(false);

			List<CostCenterSplitInfo> centerSplitInfo1 = new ArrayList<CostCenterSplitInfo>();
			CostCenterSplitInfo costCenterSplitInfoObject = new CostCenterSplitInfo();
			costCenterSplitInfoObject.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costCenterSplitInfoObject.setBudget(cc_budget_project.get(IConstantsData.budget));
			costCenterSplitInfoObject.setProject(cc_budget_project.get(IConstantsData.project));
			costCenterSplitInfoObject.setPercentage(100);

			centerSplitInfo1.add(costCenterSplitInfoObject);
			costBookingRequisitionSummary.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
			costBookingRequisitionSummary.setBudget(cc_budget_project.get(IConstantsData.budget));
			costBookingRequisitionSummary.setProject(cc_budget_project.get(IConstantsData.project));
			requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);
			requisition.getCostBookingRequisitionSummary().setSplitCostToMultipleCostCenter(true);
			costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);
			costBookingRequisitionSummary.setListOfSplitedCostCenters(centerSplitInfo1);
			requisition.setNextAction(IConstantsData.NONE);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			flag = ModelRequisitionSummaryCostBooking.isselectCostBookingOptionMultipleCCDisplayed(driver, testCaseName);
			Assert.assertTrue(flag);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
			String itemId = item.getCatelogItems().get(0).getItemID();
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
			// click on header level edit and select item level
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnCancelButton(driver, testCaseName);
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
			// click on header level edit and select item level
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionSingleCC(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			// click on edit item summary
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
			// click on header level edit and select item level
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelRequisitionSummaryBilling.clickOnSaveButton(driver, testCaseName);
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
			ActionBot.defaultSleep();
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
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

	/*********************************************
	 * Payal's TestCases
	 *****************************************************/

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 16-Nov-2015 </b> <b>Method :
	 * RTC_344549 <b>Description : Test for bug 224468 -
	 * [Oracle]Requisition:Clicking on project under cost booking generates
	 * "error 500". </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_344549(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_348373"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352669"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352742"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		/*
		 * GuidedItem guidedItem = new GuidedItem(); Item item = new Item();
		 * List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		 */
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// add guided item and checkout
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			// requisition.getCostBookingItemSummary().getAccountingItemSummary().setGlAccount(null);
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			/*
			 * //open project
			 * PageRequisitionCheckOut.clickEditHeaderInfo(driver,
			 * testCaseName); TabCheckoutReqSummary.clickCostBookingTab(driver,
			 * testCaseName);
			 * ModelRequisitionSummaryCostBooking.clickOnSinglePoject(driver,
			 * testCaseName);
			 * ModelRequisitionSummaryCommon.clickCancleReqSummary(driver,
			 * testCaseName);
			 */
			// enter max characters in gl account
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);

			ActionBot.defaultSleep();
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			/*
			 * String itemId = PageRequisitionCheckOut.getItemId(driver,
			 * testCaseName, item.getGuidedItems().get(0) .getItemName());
			 */
			ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT, 0),
				requisition.getItems().getGuidedItems().get(0).getItemID(), 0);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			String glAccount = PageRequisitionCheckOut.getGLAccountInfoInExpandAll(driver, testCaseName);
			boolean flag = glAccount == null ? true : false;
			assertTrue("Error 500 is displayed after entering max characters in gl account", !flag);
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);

			// edit item and check details link if gl account is not present
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean details = ModelItemSummaryCostBooking.isGeneralLedgerDetailsPresent(driver, testCaseName);
			assertTrue("Details link is still present even when gl account is not selected", details);
			mappedTestCases.get(2).setTestResult(details);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Nov-2015 </b> <b>Method :
	 * RTC_344550 <b>Description : Test for bug 237146 - Status of item is
	 * getting changed even on cancelling changes in item in following scenario
	 * . </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_344550(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352668"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_365854"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_341951"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);
			logger.info("The item id is" + requisition.getItems().getGuidedItems().get(0).getItemID());

			//create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "requisition not searched");

			// change sourcing status at buyers desk and send for approval
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "requisition not searched at buyers desk");

			//MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "400");

			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			GuidedItem editGuidedItem = new GuidedItem();
			editGuidedItem.setSourcingStatus(IConstantsData.BUYER_NEGOTIATED_PRICE);
			editGuidedItem.setNextAction(IConstantsData.SAVE);
			editGuidedItem.setSupplierType(IConstantsData.EXISTING_SUPPLIER);
			editGuidedItem.setSupplierNameInSuppInfo(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			//editGuidedItem.setsupplier
			FlowBuyersDesk.editGuidedItemDetailsatBuyersDesk(driver, testCaseName, editGuidedItem);
			//		ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			//		ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			//		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);
			logger.info("The req no is" + requisition.getReqNo());
			// copy req
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			//	MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			//	PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
			ActionBot.defaultSleep();
			ActionBot.scroll(driver, "400");

			// view item details and check sourcing status when changes are not
			// saved
			String itemId = PageStandardPO.getItemId(driver, requisition.getItems().getGuidedItems().get(0).getShortDescription());
			System.out.println("the item id is@@@@@@@@@@@@@" + itemId);
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemId);
			String status1 = ModalGuidedItemDetails.getSourcingStatusFromItemModal(driver, testCaseName);
			ModalGuidedItemDetails.clickOnClickHereToModifyInItemDetail(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemId);
			String status2 = ModalGuidedItemDetails.getSourcingStatusFromItemModal(driver, testCaseName);
			boolean flag = status2.equalsIgnoreCase(status1) ? true : false;
			assertTrue("Sourcing status has changed even if changes in item is not saved", flag);
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
			// check gl account details icon
			//PageRequisitionCheckOut.clickEditItemRequisitionindexwise(driver, testCaseName, 1);
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			//ActionBot.defaultSleep();
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean account = ModelItemSummaryCostBooking.isGeneralLedgerDetailsPresent(driver, testCaseName);
			assertTrue("Details in gl account is not present", account);
			mappedTestCases.get(0).setTestResult(account);
			mappedTestCases.get(1).setTestResult(account);
			mappedTestCases.get(2).setTestResult(account);

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Nov-2015 </b> <b>Method :
	 * RTC_344553 <b>Description : Test for bug 237149 - Error is not shown on
	 * requisition header if sourcing status of item is not available . </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_344553(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352718"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352702"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352698"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352696"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352692"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_353018"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352948"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setSourcingStatus(IConstantsData.Quoted_by_supplier);
			requisition.setNextAction(IConstantsData.SAVE_AS_DRAFT_REQ);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// uncheck quoted by supplier sourcing status in setting
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
			PageRequisitionSettings.clickOnSourcingStatus_QuotedBySupplier(driver, testCaseName);
			PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);

			// open req and submit and check error
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, true);
			boolean status = PageRequisitionCheckOut.isSourcingStatusErrorIconPresent(driver, testCaseName);
			assertTrue("Sourcing status not available error is not displayed", status);
			mappedTestCases.get(0).setTestResult(status);
			mappedTestCases.get(1).setTestResult(status);
			mappedTestCases.get(2).setTestResult(status);
			mappedTestCases.get(3).setTestResult(status);
			mappedTestCases.get(4).setTestResult(status);
			mappedTestCases.get(5).setTestResult(status);
			mappedTestCases.get(6).setTestResult(status);

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
				// tick quoted by supplier sourcing status in setting
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
				PageRequisitionSettings.clickOnSourcingStatus_QuotedBySupplier(driver, testCaseName);
				PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing sorcing status setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 17-Nov-2015 </b> <b>Method :
	 * RTC_351757 <b>Description : PT Hide>>Checkout>>
	 * "Enforce PT based validation of GL account": YES >>Validation GL rules
	 * map should be considered to validate Accounting details on clicking
	 * "I'm done" </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_351757(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_351758"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Requisition requisition = new Requisition();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// keep validation setting and PT settings as YES in customize
			// master data settings
			MasterDataTenantConfig masterDataTenantConfig = new MasterDataTenantConfig();
			masterDataTenantConfig.setUsePurchaseTypeFieldToClassifyPurchases(IConstants.YES);
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(true);

			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.getCostBookingItemSummary().getAccountingItemSummary().setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			requisition.setNextAction(IConstantsData.NONE);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickContinueRequisition(driver, testCaseName);

			// check validation error
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Validation error popup is not present even when validation setting is kept YES", flag);
			PageRequisitionCheckOut.clickOnOKForAlertPopup(driver, testCaseName);
			PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);

			// change validation setting to NO
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);

			FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			// open req and submit again and check if validation error is
			// present
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			FlowRequisition.submitReq(driver, testCaseName, true);
			boolean flag1 = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue(!flag1);
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
			try
			{
				// change validation setting to NO
				MasterDataTenantConfig masterDataTenantConfig1 = new MasterDataTenantConfig();
				masterDataTenantConfig1.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);
				FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig1);
			}
			catch (Exception e)
			{
				logger.error("Error while changing gl account validation setting to NO" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 18-Nov-2015 </b> <b>Method :
	 * RTC_352029 <b>Description : Test for bug 239023 - Checkout>>Server
	 * 500 when users clicks on "I'm done" for a requisition containing a free
	 * text item such that supplier for this item has only one address. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352029(TestCase testCase) throws Exception
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

			// create req with single address supplier
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setSupplierNameInSuppInfo(CommonServices.getTestData(IConstantsData.SUPPLIER_WITH_DIFF_CURRENCY));

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Nov-2015 </b> <b>Method :
	 * RTC_351752 <b>Description : PT Hide>>Checkout>>PT should be hidden on
	 * checkout screen when setting
	 * "Use the Purchase Type field to classify purchases?" is set to
	 * NO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_351752(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_351756"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352913"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			MasterDataTenantConfig masterDataTenantConfig = new MasterDataTenantConfig();
			masterDataTenantConfig.setUsePurchaseTypeFieldToClassifyPurchases(IConstants.NO);

			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check if purchase type is present or not
			boolean flag = PageRequisitionCheckOut.isPurchaseTypePresent(driver, testCaseName);
			assertTrue("Purchase type is stil present even after keeping PT setting as NO", !flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);

			ActionBot.scroll(driver, "400");

			// check accounting details
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

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
				MasterDataTenantConfig masterDataTenantConfig1 = new MasterDataTenantConfig();
				masterDataTenantConfig1.setUsePurchaseTypeFieldToClassifyPurchases(IConstants.YES);

				masterDataTenantConfig1 = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig1);
			}
			catch (Exception e)
			{
				logger.error("Error while changing PT setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 23-Nov-2015 </b> <b>Method :
	 * RTC_351754 <b>Description : PT Hide>>Checkout>>
	 * "Use the Purchase Type field to classify purchases?" : YES>>PT should be
	 * visible </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_351754(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_351755"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352684"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352685"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(driver, testCaseName);
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
			ActionBot.defaultSleep();

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check if purchase type is present or not
			boolean flag = PageRequisitionCheckOut.isPurchaseTypePresent(driver, testCaseName);
			assertTrue("Purchase type is stil present even after keeping PT setting as NO", !flag);
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);
			mappedTestCases.get(2).setTestResult(!flag);

			ActionBot.scroll(driver, "400");

			// check accounting details
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(driver, testCaseName);
			PageProjectsSettings.clickOnSave(driver);
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
	 * <b>Author: payal.alag </b> <b>Created On : 24-Nov-2015 </b> <b>Method :
	 * RTC_352662 <b>Description : Requisition>>Checkout>>Display accounting
	 * details to requester is set to NO>>GL accounts field should not be
	 * visible within cost allocation tab. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352662(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352738"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// set display accounting info to requester to NO
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.NO);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check is glAccount present or not
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean flag = ModelItemSummaryCostBooking.isGLAccountPresent(driver, testCaseName, itemId, 0);
			assertTrue("GL Account is present even when display gl account setting is set to NO", !flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

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
				// set display accounting info to requester to YES
				RequisitionSettings requisitionSettings1 = new RequisitionSettings();
				requisitionSettings1.setDisplayAccountingInfoToRequesterOption(IConstants.YES);

				requisitionSettings1 = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings1);
			}
			catch (Exception e)
			{
				logger.error("Error while changing display accounting info" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 24-Nov-2015 </b> <b>Method :
	 * RTC_352709 <b>Description : Requisition>>Checkout>>Requester is required
	 * to provide accounting information:YES>>GL accounts field should be
	 * mandatory within cost allocation tab of Item. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352709(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// set Requester is required to provide accounting info to YES
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.YES);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check is glAccount present or not
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean flag = ModelItemSummaryCostBooking.isGlAccountMandatorySignPresent(driver, testCaseName);
			assertTrue("GL Account is not mandatory even after setting to YES", flag);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

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
				// set Requester is required to provide accounting info to NO
				RequisitionSettings requisitionSettings1 = new RequisitionSettings();
				requisitionSettings1.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.NO);

				requisitionSettings1 = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings1);
			}
			catch (Exception e)
			{
				logger.error("Error while changing requester is required to provide accounting info" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}

	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 24-Nov-2015 </b> <b>Method :
	 * RTC_352723 <b>Description : Requisition>>Checkout>>Requester is required
	 * to provide accounting information:NO>>GL accounts field should not be
	 * mandatory within cost allocation tab of Item. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352723(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// set Requester is required to provide accounting info to NO
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.NO);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check is glAccount present or not
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean flag = ModelItemSummaryCostBooking.isGlAccountMandatorySignPresent(driver, testCaseName);
			assertTrue("GL Account is not mandatory even after setting to YES", !flag);
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 24-Nov-2015 </b> <b>Method :
	 * RTC_352803 <b>Description : Multiple Buyers>>Checkout screen>>User should
	 * be able to add buyer/ buyer group which has special characters in their
	 * name. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352803(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352812"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352834"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352856"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352866"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352890"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352904"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_352926"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnDeliveryItemEdit(driver, testCaseName);

			TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
			PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
			PageRequisitionCheckOut.clickOnSingleAssignedBuyer(driver, testCaseName);

			// add special char buyer
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER));

			// remove special char buyer
			PageRequisitionCheckOut.clickOnRemoveAssignedBuyer(driver, testCaseName);

			// add multilingual buyer
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR_USER));

			// add max char buyer
			PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHAR_USER));

			// add group buyer
			PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
			PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
			PageRequisitionCheckOut.fillAssignedBuyerGroup(driver, testCaseName, CommonServices.getTestData(IConstantsData.ASSIGNED_BUYER_USER_GROUP));

			boolean buyer = PageRequisitionCheckOut.isAssignedBuyerLabelPresent(driver, testCaseName);
			assertTrue("Assigned buyer is not present", buyer);
			mappedTestCases.get(0).setTestResult(buyer);
			mappedTestCases.get(1).setTestResult(buyer);
			mappedTestCases.get(2).setTestResult(buyer);
			mappedTestCases.get(3).setTestResult(buyer);
			mappedTestCases.get(4).setTestResult(buyer);
			mappedTestCases.get(5).setTestResult(buyer);
			mappedTestCases.get(6).setTestResult(buyer);

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Nov-2015 </b> <b>Method :
	 * RTC_353213 <b>Description : PS in BPO&gt;&gt;BPO should be delinked from
	 * item when user submits a requisition which has both BPO and PO attached
	 * to it. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_353213(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			String bpoNo = bpo.getPoNumber();

			flag = FlowPoListing.searchBPO(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setBPONo(bpoNo);
			requisition.setNextAction(IConstantsData.NONE);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// check bpo number should be present
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			flag = ModalGuidedItemDetails.isBpoNumberLinkedPresentInItemDetails(driver, testCaseName);
			assertTrue("linked bpo number is not present, it should be present", flag);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);

			// link po to req
			PageRequisitionCheckOut.clickOnShowAllPosBtn(driver, testCaseName);
			ModalShowAllPos.clickOnFirstPoNoRadioButton(driver, testCaseName);
			ModalShowAllPos.clickOnSelectPoBtn(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// check bpo number should be delinked now
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			boolean flag1 = ModalGuidedItemDetails.isBpoNumberLinkedPresentInItemDetails(driver, testCaseName);
			assertTrue("linked bpo number is present, which is wrong", !flag1);
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Nov-2015 </b> <b>Method :
	 * RTC_363346 <b>Description : Test for bug 240828 - Checkout screen>>User
	 * is not able to increment price of Guided item on checkout screen. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_363346(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setPrice(100);
			requisition.getItems().getGuidedItems().get(0).setQuantity(10f);
			requisition.getItems().getGuidedItems().get(0).setCurrency("USD");
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// increase item price
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.fillPrice(driver, testCaseName, 101);
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);

			FlowRequisition.submitReq(driver, testCaseName, true);

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Nov-2015 </b> <b>Method :
	 * RTC_376831 <b>Description : Test for bug 236286 - Unable to submit a
	 * particular requisition on keeping settlement via Invoice. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_376831(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_378949"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.USERNAME, CommonServices.getTestData(IConstantsData.USERNAME_FOR_LOGIN));
			LoginLogoutServices.login(driver, testCase, user);

			// create req with settlement via invoice
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			mappedTestCases.get(0).setTestResult(true);

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Nov-2015 </b> <b>Method :
	 * RTC_377031 <b>Description : Test for bug 237251 - Multiple confirm modals
	 * displayed on clicking add item multiple times. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377031(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377033"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// click on add new item
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName);
			assertTrue("Save modal is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// add new item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// again click on add new item
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Nov-2015 </b> <b>Method :
	 * RTC_377034 <b>Description : Accounting display setting mismatch in
	 * customize should display the confirm modal on add item in
	 * requisition. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377034(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		RequisitionSettings requisitionSettings = new RequisitionSettings();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// set display accounting info to requester to YES
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// set display accounting info to requester to NO
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.NO);

			requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// return req from buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnRejectAction(driver, testCaseName);
			ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
			ModalBuyersDeskReturnRequisition.clickOnReturnReqButton(driver, testCaseName);

			// open req on my requisition and check for confirm modal
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);

			boolean confirm = PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName);
			assertTrue("Confirm modal is not present even after accounting mismatch", confirm);

			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);

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
				// set display accounting info to requester to YES
				requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);

				requisitionSettings = FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
			}
			catch (Exception e)
			{
				logger.error("Error while changing display accounting info to requester to YES" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 30-Nov-2015 </b> <b>Method :
	 * RTC_377035 <b>Description : User should not be prompted to save the
	 * requisition on adding an item after copying a requisition and saving it
	 * as draft. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377035(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377052"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377054"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377063"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_378938"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// copy req
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// save req as draft
			String reqname = PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, CommonUtilities.getReqName());
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);

			// open req and check is confirm modal present
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, reqname);
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm popup is still present, which is wrong", !flag);
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);
			mappedTestCases.get(2).setTestResult(!flag);
			mappedTestCases.get(3).setTestResult(!flag);
			ActionBot.defaultSleep();

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377058 <b>Description : Awaiting quote from buyer >> User should not
	 * be prompted to save the document, unless any changes are made on the
	 * checkout page. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377058(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req with need a quote item
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.getItems().getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "req not searched at my requisitions");

			// return req from buyers desk
			//			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());

			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "req not searched at buyersdesk");

			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			ActionBot.scroll(driver, "500");
			PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
			PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			//ModalBuyersDeskReturnRequisition.clickOnReturnReqFromBuyersDesk(driver, testCaseName);

			//FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);

			// open req at my req and check confim modal
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);

			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "req not searched at my requisitions");

			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377059 <b>Description : User should not be prompted to save the
	 * document, if any setting is changed is from customize tab. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377059(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Keep cost booking customize project and budget setting as YES
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageBudgetSettings.clickOnAllowBudgetUtilizationYES(driver, testCaseName);
			PageProjectsSettings.clickOnSave(driver);
			PageCostBookingSettings.clickOnProjects(driver);
			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// change req settings to YES
			RequisitionSettings requisitionSettings = new RequisitionSettings();
			requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);
			requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.NO);
			requisitionSettings.setEnableReqForking(true);
			requisitionSettings.setForReqByCategory(true);
			FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings);

			// create req and save as draft
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// change cost booking settings to NO
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageBudgetSettings.clickOnAllowBudgetUtilizationNO(driver, testCaseName);
			PageProjectsSettings.clickOnSave(driver);
			PageCostBookingSettings.clickOnProjects(driver);
			PageProjectsSettings.clickOnNever(driver);
			PageProjectsSettings.clickOnSave(driver);

			// change req settings to NO
			RequisitionSettings requisitionSettings1 = new RequisitionSettings();
			requisitionSettings1.setDisplayAccountingInfoToRequesterOption(IConstants.NO);
			requisitionSettings1.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.YES);
			requisitionSettings1.setEnableReqForking(false);
			FlowRequisitionSettings.changeRequisitionSettings(driver, testCaseName, requisitionSettings1);

			// open req and check confirm modal is present or not
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377060 <b>Description : PO cancel - Return from buyers desk >> User
	 * should not be prompted to save the document, unless any changes are made
	 * on the checkout page. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377060(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		String poNo = null, poStatus = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			//req to Po
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			flag = FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			Assert.assertTrue(flag, "Po not searched at PO");
			poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);

			// cancel PO
			FlowPoListing.viewPO(driver, testCaseName);
			FlowViewPO.cancelPo(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			ActionBot.refreshPage(driver, testCaseName);

			//search Po and check status
			flag = FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			Assert.assertTrue(flag, "Po not searched at PO");
			poStatus = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			Assert.assertTrue(poStatus.equalsIgnoreCase(IConstantsData.CANCELLED), "PO not cancelled");

			// return req from buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.isResult(), "req not searched at buyers desk");
			FlowBuyersDeskListing.getReqStatusIndexwise(driver, testCaseName, 1);
			// to return req from buyers desk
			flag = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			assertTrue("Pending Requisition was not returned", flag);

			// open req at my req and check confirm modal
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377061 <b>Description : Return >> User should not be prompted to save
	 * the document, unless any changes are made on the checkout page. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377061(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// return req from buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnRejectAction(driver, testCaseName);
			ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
			ModalBuyersDeskReturnRequisition.clickOnReturnReqButton(driver, testCaseName);

			// open req at my req and check confirm modal is present or not
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377062 <b>Description : Recall >> User should not be prompted to save
	 * the document, unless any changes are made on the checkout page. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377062(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// recall req
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnRecallApproveRequestLink(driver, testCaseName);
			ModalRecallApprovalRequest.fillRecallComment(driver, testCaseName, IConstantsData.RECALL_APPROVAL_REQUEST_COMMENT);
			ModalRecallApprovalRequest.clickOnRecallButton(driver, testCaseName);
			ActionBot.defaultSleep();

			// open req at my req and check confirm modal is present or not
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_377064 <b>Description : Checkout >> User should not be prompted to
	 * save the document, unless any changes are made on the checkout
	 * page. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377064(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setNextAction(IConstantsData.SAVE_AS_DRAFT_REQ);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// open req at my req and check confirm modal is present or not
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Dec-2015 </b> <b>Method :
	 * RTC_378950 <b>Description : Test for bug 229243 -
	 * JQuery>>Requisition>>User cannot create requisition on behalf of another
	 * user. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_378950(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.USERNAME, CommonServices.getTestData(IConstantsData.USERNAME_FOR_LOGIN));
			LoginLogoutServices.login(driver, testCase, user);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.USERNAME_FOR_ON_BEHALF));

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
	 * <b>Author: payal.alag </b> <b>Created On : 02-Dec-2015 </b> <b>Method :
	 * RTC_377083 <b>Description : Test for bug 238556 - Max length characters
	 * displayed wrongly in cost center field. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377083(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377084"));//0
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377085"));//1
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377087"));//2
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377088"));//3
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377090"));//4
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377091"));//5
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377092"));//6
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377093"));//7
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377094"));//8
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377095"));//9
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377096"));//10
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377097"));//11
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377098"));//12
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377099"));//13
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377100"));//14
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377101"));//15
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377102"));//16
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377089"));//17
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_358654"));//18
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_358641"));//19

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// set date
			Requisition requisition = new Requisition();
			requisition.setCustomDate(CommonUtilities.getRequiredBy());
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(), requisition.getCustomDate().getMonth(),
				requisition.getCustomDate().getYear());

			// check cost center with single letter
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, "T");

			// check max char in cost center
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHAR_CC));

			// check project with single letter
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, "P");

			// check project with max char
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHAR_PROJECT));

			// fill budget
			ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_BOOKING_SINGLE_BUDGET));
			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);

			String cc = PageRequisitionCheckOut.getCostCenterHeader(driver, testCaseName);

			//Get proper CC
			String properCC = CommonUtilities.getProperCostCenter(cc);

			boolean flag = properCC.equals(CommonServices.getTestData(IConstantsData.MAX_CHAR_CC)) ? true : false;
			assertTrue("Max char CC is not displayed properly", flag);

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

			ActionBot.scroll(driver, "300");

			// fill gl account with single letter
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, "R", itemId, 0);

			// fill gl account
			ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT), itemId, 0);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);

			// expand and check gl account is proper or not
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			String gl = PageRequisitionCheckOut.getGLAccountInfoInExpandAll(driver, testCaseName);
			//Get proper GL
			String properGL = CommonUtilities.getProperGLAccount(gl);

			boolean account = properGL.equals(CommonServices.getTestData(IConstantsData.GL_ACCOUNT)) ? true : false;
			assertTrue("Gl account is not displayed properly", account);

			mappedTestCases.get(10).setTestResult(account);
			mappedTestCases.get(11).setTestResult(account);
			mappedTestCases.get(12).setTestResult(account);
			mappedTestCases.get(13).setTestResult(account);
			mappedTestCases.get(14).setTestResult(account);
			mappedTestCases.get(15).setTestResult(account);
			mappedTestCases.get(16).setTestResult(account);
			mappedTestCases.get(17).setTestResult(account);
			mappedTestCases.get(18).setTestResult(account);
			mappedTestCases.get(19).setTestResult(account);

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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Dec-2015 </b> <b>Method :
	 * RTC_377051 <b>Description : Rejected Requisition >> The confirm
	 * modal should not be displayed to user on add item if the requisition in
	 * rejected from approval and edited again. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377051(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// reject req from approvers tab
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.REJECT_COMMENT);
			approvalAllRequests.setActions(IConstantsData.REJECT);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// open req and check is confirm modal present
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnEditLink(driver, testCaseName);
			// PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			PageRequisitionCheckOut.clickAddItemOnCheckout(driver, testCaseName);
			boolean flag = PageRequisitionCheckOut.isValidationAlertPopupPresent(driver, testCaseName);
			assertTrue("Confirm modal is present, which is wrong", !flag);
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Dec-2015 </b> <b>Method :
	 * RTC_377029 <b>Description : Test for bug 237079 - Add attachment modal
	 * doesn't close on clicking escape. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377029(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// search item
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			PageSearchListing.getItemId(driver, testCaseName, name);
			PageOnlineStore.clickSearchButton(driver, testCaseName);
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickOnAddAttachmentLinkAndEscape(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Dec-2015 </b> <b>Method :
	 * RTC_365735 <b>Description : Test for bug 241319 - Checkout screen>>Script
	 * error is thrown when user clicks on "Apply" button present within
	 * "Update all lines" pop-up. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_365735(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// set date
			Requisition requisition = new Requisition();
			requisition.setCustomDate(CommonUtilities.getRequiredBy());
			PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(), requisition.getCustomDate().getMonth(),
				requisition.getCustomDate().getYear());

			// select item level split
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);

			// update all lines
			ActionBot.scroll(driver, "400");
			PageRequisitionCheckOut.selectItemIDwise(driver, testCaseName, itemId);
			PageRequisitionCheckOut.clickChangeMultiple(driver, testCaseName);
			ModelChangeMultiple.fillChangeMultipleCostCenter(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_CENTER));
			ModelChangeMultiple.clickChangeMultipleApply(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 07-Dec-2015 </b> <b>Method :
	 * RTC_352675 <b>Description : Requisition>>Checkout>>Max length accounting
	 * data>>Max length accounting details should be properly displayed in
	 * accounting details link present in cost allocation tab present in
	 * requisition item. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_352675(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.getCostBookingItemSummary().getAccountingItemSummary().setGlAccount(CommonServices.getTestData(IConstantsData.MAX_CHAR_GL_ACCOUNT));
			requisition.setNextAction(IConstantsData.NONE);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// check details
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			boolean flag = ModelItemSummaryCostBooking.isGeneralLedgerDetailsPresent(driver, testCaseName);
			assertTrue("GL account details is not present properly", flag);
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);

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
	 * <b>Author: payal.alag </b> <b>Created On : 14-Dec-2015 </b> <b>Method :
	 * RTC_366237 <b>Description : Eform reset on PT>>Checkout screen>>Eform
	 * should be retained along with its value when user changes PT and same
	 * eform is re-evaluated </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_366237(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_366238"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		Item item = new Item();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// empty the cart
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			if (item.isEmptyCart())
			{
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			}

			// search item
			FlowSearchListing.searchItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			List<WebElement> itemName = PageSearchListing.getItemName(driver, testCaseName);
			String name = itemName.get(0).getText();
			String itemId = PageSearchListing.getItemId(driver, testCaseName, name);

			// Add item
			ActionBot.defaultSleep();
			PageSearchListing.addToCart(driver, testCaseName, itemId);
			ActionBot.defaultSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// check eForm
			ActionBot.scroll(driver, "200");
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			String eForm1 = PageRequisitionCheckOut.getEformTitleSectionLabel(driver, testCaseName);

			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_PURCHASE_TYPE));
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			String eForm2 = PageRequisitionCheckOut.getEformTitleSectionLabel(driver, testCaseName);
			boolean flag = eForm2 != eForm1 ? true : false;
			assertTrue("eForm has not changed with change in purchase type", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Dec-2015 </b> <b>Method :
	 * RTC_366239 <b>Description : Test for bug 241400 - Checkout screen>>Eform
	 * loader goes infinite when user copies requisition (or opens a draft req)
	 * and changes PT (or Company/BU)such that new eform is to be
	 * loaded. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_366239(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req and save as draft
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setPurchaseType(CommonServices.getTestData(IConstantsData.OTHER_PURCHASE_TYPE));
			requisition.setNextAction(IConstantsData.SAVE_AS_DRAFT_REQ);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// open req draft and change PT and check eForm
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
			String eForm1 = PageRequisitionCheckOut.getEformTitleSectionLabel(driver, testCaseName);
			PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			String eForm2 = PageRequisitionCheckOut.getEformTitleSectionLabel(driver, testCaseName);
			boolean flag = eForm2 != eForm1 ? true : false;
			assertTrue("eForm has not changed with change in purchase type", flag);

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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Dec-2015 </b> <b>Method :
	 * RTC_374806 <b>Description : Test for bug 242054 - Settlement via
	 * validation is incorrectly displayed when requisition is attached to PO in
	 * following scenario. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_374806(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// keep send PO to supplier as YES
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSendPOToSupplierForRetrospectivePurchase_YES(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// check YES for retrospective purchase
			PageRequisitionCheckOut.checkRetrospectivePurchase(driver, testCaseName);

			// submit req and approve it
			FlowRequisition.submitReq(driver, testCaseName, true);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// convert req to PO
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			List<WebElement> po = PageConvertedPurchaseOrder.getListOfPurchaseOrderGenerated(driver, testCaseName);
			String poNo = po.get(0).getText();

			// approve PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			ApprovalAllRequests approvalAllRequests1 = new ApprovalAllRequests();
			approvalAllRequests1.setDocumentNo(poNo);
			approvalAllRequests1.setActions(IConstantsData.APPROVE);
			approvalAllRequests1.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests1.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests1);
			ActionBot.defaultSleep();

			// change send PO to supplier to NO
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSendPOToSupplierForRetrospectivePurchase_NO(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition1 = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition1.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition1);

			// check YES for retrospective purchase
			PageRequisitionCheckOut.checkRetrospectivePurchase(driver, testCaseName);

			// attach earlier created PO to this req
			PageRequisitionCheckOut.clickOnShowAllPosBtn(driver, testCaseName);
			ModalShowAllPos.fillPonoShowAllpo(driver, testCaseName, poNo);
			ModalShowAllPos.clickOnFirstPoNoRadioButton(driver, testCaseName);
			ModalShowAllPos.clickOnSelectPoBtn(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// submit req and check errors
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
			boolean error = PageRequisitionCheckOut.isPONoErrorOnAttachmentPresent(driver, testCaseName);
			assertTrue("Send PO to supplier mismatch error is not present", error);

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
				// change send PO to supplier to YES
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSendPOToSupplierForRetrospectivePurchase_YES(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error while changing retrospective purchase to YES" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: payal.alag </b> <b>Created On : 15-Dec-2015 </b> <b>Method :
	 * RTC_377465 <b>Description : User should be able to upload a file by
	 * clicking on 'Add Attachments' link in requisition </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377465(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377464"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377453"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377539"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377540"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377538"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377456"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377457"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setPurchaseType("ABC");
			requisition.setNextAction(IConstantsData.NONE);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// attach 1st file
			boolean flag1 = PageRequisitionCheckOut.isEformAddAttachmentLinkPresent(driver, testCaseName);
			assertTrue("Eform attachment link is not present", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			mappedTestCases.get(2).setTestResult(flag1);
			PageRequisitionCheckOut.clickOnEformAddAttachmentLink(driver, testCaseName);
			String fileName1 = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_WITH_DATA_VALIDATION;
			ModalEFormAddAttachmentCheckout.enterFileNameForEformAttachment(driver, testCaseName, fileName1);
			ModalEFormAddAttachmentCheckout.clickOnDoneEformAttachment(driver, testCaseName);

			// attach 2nd file
			boolean flag2 = PageRequisitionCheckOut.isEformAddAttachmentLinkPresent(driver, testCaseName);
			assertTrue(flag2);
			mappedTestCases.get(3).setTestResult(flag2);
			mappedTestCases.get(4).setTestResult(flag2);
			PageRequisitionCheckOut.clickOnEformAddAttachmentLink(driver, testCaseName);
			String fileName2 = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FILE_WITH_DISTURBED_STRUCTURE;
			ModalEFormAddAttachmentCheckout.enterFileNameForEformAttachment(driver, testCaseName, fileName2);
			ModalEFormAddAttachmentCheckout.clickOnDoneEformAttachment(driver, testCaseName);

			// attach 3rd file
			boolean flag3 = PageRequisitionCheckOut.isEformAddAttachmentLinkPresent(driver, testCaseName);
			assertTrue(flag3);
			mappedTestCases.get(5).setTestResult(flag3);
			mappedTestCases.get(6).setTestResult(flag3);
			PageRequisitionCheckOut.clickOnEformAddAttachmentLink(driver, testCaseName);
			String fileName3 = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FILE_WITH_MAXCHAR;
			ModalEFormAddAttachmentCheckout.enterFileNameForEformAttachment(driver, testCaseName, fileName3);
			ModalEFormAddAttachmentCheckout.clickOnDoneEformAttachment(driver, testCaseName);

			FlowRequisition.submitReq(driver, testCaseName, true);

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

	/*********************************************
	 * End of Payal's TestCases
	 *****************************************************/

	/*********************************************
	 * Start of Kunal's TestCases
	 *****************************************************/
	/**
	 * <b>Author: kunal.ashar </b> <b>Created On : 29-Mar-2017 </b> <b>Method :
	 * MultipleReq <b>Description : creating multiple requisition </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void MultipleReq(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		String reqNumber = null;
		try
		{
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			for (int i = 1; i <= 10; i++)
			{

				OnlineStore onlinestore = ObjectCreation.searchItem();
				onlinestore.setSearchItem("Laptop");

				MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
				FlowShoppingCart.emptyShoppingCart(driver, testCaseName);

				onlinestore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlinestore);

				// filling req details and getting newly created reqNumber
				reqNumber = FlowRequisition.fillReqDetailsForBuyerDeskTC(driver, testCaseName, reqNumber);
				logger.info("Req created: " + reqNumber);
				ActionBot.defaultMediumSleep();

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
	/*********************************************
	 * End of Kunal's TestCases
	 *****************************************************/

}