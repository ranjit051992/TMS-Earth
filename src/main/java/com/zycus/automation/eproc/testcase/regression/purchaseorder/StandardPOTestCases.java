package com.zycus.automation.eproc.testcase.regression.purchaseorder;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BusinessUnitSettings;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CompanySettings;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.LocationSettings;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.PoStatusFilter;
import com.zycus.automation.bo.ProjectsSettings;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.PurchaseOrderSettings;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.TMS_paymentTermsSettings;
import com.zycus.automation.bo.User;
import com.zycus.automation.bo.UserSettings;
import com.zycus.automation.bo.WorkflowSettings;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.TMS_paymentTermsSettingsFlow.FlowTMSPaymentTermsSettingsFlow;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.businessUnitSettingsFlow.FlowBusinessUnitSettings;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.coompanySettingsFlow.FlowCompanySettings;
import com.zycus.automation.eproc.businessflow.flipinvoice.FlowFlipInvoice;
import com.zycus.automation.eproc.businessflow.locationSettingsFlow.FlowLocationSettings;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.projectssettingsflow.FlowProjectsSettings;
import com.zycus.automation.eproc.businessflow.purchaseordersetting.FlowPurchaseOrderSetting;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.businessflow.standardposummaryflow.FlowSelectingDifferentCompanyInPOSummary;
import com.zycus.automation.eproc.businessflow.supplierCodeMapMasterDataSettingsFlow.FlowSupplierCodeMapMasterDataSettings;
import com.zycus.automation.eproc.businessflow.usermanagementflow.FlowUserManagement;
import com.zycus.automation.eproc.businessflow.viewpoflow.FlowViewPO;
import com.zycus.automation.eproc.businessflow.workflowSettingsFlow.FlowWorkflowSettings;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.IModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.IModalPOFreeTextItemSummaryItemImpl;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryAttachmentsAndComments.ModalPOFreeTextItemSummaryAttachmentsAndComments;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery.IModalPOSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery.ModalPOSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.UpdateAllLinesPO.ModalUpdateAllLinesPO;
import com.zycus.automation.eproc.pageobjects.modals.addapprover.ModalAddApprover;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.changeCurrencyPurchaseOrder.ModalChangeCurrencyPO;
import com.zycus.automation.eproc.pageobjects.modals.closepo.ModalClosePO;
import com.zycus.automation.eproc.pageobjects.modals.discountstandardpo.ModalDiscountPO;
import com.zycus.automation.eproc.pageobjects.modals.itemDetailsPO.ModalItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.itemSummaryDelivery.ModalItemSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.itemSummaryItem.ModalItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.itemSummaryTax.ModalItemSummaryTax;
import com.zycus.automation.eproc.pageobjects.modals.itemsummarycostallocation.ModalItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.poattachment.ModalPOAttachment;
import com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest.ModalPORecallApprovalRequest;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling.ModalPurchaseOrderSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.IModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.ModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo.IModalRemindSupplier;
import com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo.ModalRemindSupplier;
import com.zycus.automation.eproc.pageobjects.modals.uploadItemViaFile.ModalUploadItemViaFile;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder.PageConvertedPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSmasterDataSettings.PageTMSMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.PageAmmendedPO;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode.PageApprovalDocumentViewMode;
import com.zycus.automation.eproc.pageobjects.pages.bpo.PageBPO;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.PageCreateNonPOInvoice;
import com.zycus.automation.eproc.pageobjects.pages.createreceipt.PageCreateReceipt;
import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.PageInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.po.PagePO;
import com.zycus.automation.eproc.pageobjects.pages.poinvoicelisting.PagePOInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.previewpo.PagePreviewPOPage;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.PageReceiptListing;
import com.zycus.automation.eproc.pageobjects.pages.settings.addressmasterdatasettings.PageAddressMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings.PageBudgetSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.configurationSetting.PageConfigurationSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.documentinformationsettings.PageDocumentInformationSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings.PageGLAccountsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.glmapsmasterdatasettings.PageGLMapsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings.PageLocationMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig.PageMasterDataTenantLevelConfigSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings.PageProjectsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.IPageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.PageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.PageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.taxratesmasterdatasettings.PageTaxRatesMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings.PageWorkflowSettings;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.IPageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewReceipt.PageViewReceipt;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.IPageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.alertAmmendedPO.PopUpAlertAmmendedPO;
import com.zycus.automation.eproc.pageobjects.popups.defaultalert.PopUpDefalutAlert;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.IPopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation.PopUpDeleteConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.errorAmmendedPO.PopUpErrorAmmendedPO;
import com.zycus.automation.eproc.pageobjects.popups.masterdataprojectsetting.PopupMasterDataProjectSettings;
import com.zycus.automation.eproc.pageobjects.popups.rollBackAmmendedPO.PopUpRollBackAmmendedPO;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class StandardPOTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(StandardPOTestCases.class);

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; 'Assign cost to
	 *         project' setting should be displayed in Costing tab within
	 *         Billing and delivery info modal
	 * @param testCase
	 * @throws Exception
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275821(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);

			PagePO.clickOnStandardPO(driver, testCaseName);

			PageStandardPO.clickOnEdit(driver);

			TabPOSummary.clickOnCostBookingPOSummary(driver);

			String str = ModalPOSummaryCostBooking.getAssignProjectToPurchaseCost(driver, testCaseName);

			// str.equalsIgnoreCase(IConstantsData.LABEL_ASSIGN_PROJECT_TO_PURCHASE_COST);
			boolean flag = str.contains("Assign purchase cost to projects:");
			Assert.assertTrue("Text is incorrect", flag);

			ModalPOSummaryCostBooking.isElementYesSelected(driver, testCaseName);

			ModalPOSummaryCostBooking.isElementNoSelected(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Verify On creating a standard PO; if
	 *         'Assign cost to project' setting (Customize) is Always; the
	 *         setting should be disabled in Billing and Delivery info>>Costing
	 *         tab with value YES
	 * 
	 * @param testCase
	 * @throws Exception
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_275822(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bl = ModalPOSummaryCostBooking.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
			Assert.assertTrue("Assign project to purchase cost is enabled", bl);
			Boolean bn = ModalPOSummaryCostBooking.isElementYesSelected(driver, testCaseName);
			Assert.assertTrue("Element YES is not selected", bn);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Verify On creating a standard PO; if
	 *         'Assign cost to project' setting (Customize) is Never; the
	 *         setting should be disabled in Billing and Delivery info>>Costing
	 *         tab with value NO
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275823(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.ALWAYS);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("NEVER");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bl = ModalPOSummaryCostBooking.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
			Assert.assertTrue("Assign project to purchase cost is enabled", bl);
			Boolean bn = ModalPOSummaryCostBooking.isElementNoSelected(driver, testCaseName);
			Assert.assertTrue("Element NO is not selected", bn);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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

				// ModalPOSummaryCostBooking.clickOnCancel(driver,
				// testCaseName);
				System.out.println(defaultProject);
				FlowProjectsSettings.changeProjectsSettings(driver, defaultProject, testCaseName);

			}
			catch (Exception e)
			{
				logger.error("Exception occurred while changing Project setting to default value" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Verify On creating a standard PO; if
	 *         'Assign cost to project' setting (Customize) is 'Let the user
	 *         decide'; the setting should be editable in Billing and Delivery
	 *         info>>Costing tab
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275824(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bl = ModalPOSummaryCostBooking.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
			Assert.assertTrue("Assign project to purchase cost is DISABLED", !bl);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Verify On creating a standard PO; in
	 *         case of 'Let the user decide' the default value of 'Assign cost
	 *         to project' setting should be YES
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275825(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bn = ModalPOSummaryCostBooking.isElementNoSelected(driver, testCaseName);
			Assert.assertTrue("Element NO is not selected", bn);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Standard PO: Verify On creating a
	 *         standard PO; if 'Assign cost to project' setting (Customize) is
	 *         Never; Project autocomplete field should NOT be displayed in
	 *         Costing tab within Billing and delivery info
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275832(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.ALWAYS);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("NEVER");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bn = ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			Assert.assertTrue("Field is displayed", !bn);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
				if (true)
				{

					System.out.println(defaultProject);
					FlowProjectsSettings.changeProjectsSettings(driver, defaultProject, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Exception occurred while changing Project setting to default value" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Standard PO: Verify On creating a standard PO; in
	 *         case of 'Let user decide' if 'Assign cost to project' setting is
	 *         NO; Project autocomplete field should NOT be displayed in Costing
	 *         tab within Billing and delivery info
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275833(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Boolean bn = ModalPOSummaryCostBooking.isElementNoSelected(driver, testCaseName);
			Assert.assertTrue("Element NO is not selected", bn);
			Boolean bl = ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			Assert.assertTrue("Field is displayed", !bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO:Standard PO: Verify if 'Assign cost to project'
	 *         setting is Always/YES; Project field should be displayed as a
	 *         label below cost center field in Cost booking section within an
	 *         item
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275834(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275835"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			String project1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project1);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, "Test");
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}

			ActionBot.scroll(driver, "400");
			// boolean flag1 = PageStandardPO.isItemSummaryEditPresent(driver,
			// testCaseName);
			// Assert.assertTrue("Edit is not present", flag1);
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			/*
			 * String st =
			 * ModalItemSummaryCostBooking.getTagNameOfProjectFieldLabel
			 * (driver); boolean bl =
			 * st.equals(IModalItemSummaryCostBooking.LABEL_PROJECT_ITEM_SUMMARY
			 * );
			 */
			// boolean bln =
			// ModalPOItemSummaryCostAllocation.isProjectFieldALabel(driver);
			// Assert.assertTrue("It is not Label", bln);
			mappedTestCases.get(0).setTestResult(true);
			// ModalItemSummaryAccounting.clickOnSave(driver);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{

			/*
			 * if (true) { //ModalPOSummaryCostBooking.clickOnCancel(driver,
			 * testCaseName); System.out.println(defaultProject);
			 * FlowProjectsSettings.changeProjectsSettings(driver,
			 * defaultProject, testCaseName); }
			 */

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify on expanding items grid in PO; fields in
	 *         cost booking section should be displayed in the following order:
	 *         Cost center; Project; Budget
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275836(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// String budgetField1 =
			// ObjectCreation.getCostCenterProjectAndBudget(testCase).get("project");

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudget();
			String projectField = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, projectField);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CPB.get("budget"));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);

			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			/*
			 * if (name != null) { addItemsToPOfield = name; }
			 * //PageStandardPO.getItemId(driver, addItemsToPOfield);
			 * 
			 * Map<String, String> CPB_MAP =
			 * ObjectCreation.getCostCenterProjectAndBudget();
			 * 
			 * String costCenterField = CPB_MAP.get("costCenter"); String
			 * projectField = CPB_MAP.get("project"); String budgetField =
			 * CPB_MAP.get("budget");
			 * 
			 * String str1 =
			 * ModalPOSummaryCostBooking.fillInCostCenterField(driver,
			 * testCaseName, costCenterField); String str2 =
			 * ModalPOSummaryCostBooking.fillInProjectField(driver,
			 * testCaseName, projectField); String str3 =
			 * ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName,
			 * budgetField); ModalPOSummaryCostBooking.clickOnSave(driver,
			 * testCaseName);
			 */
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnExpandAll(driver);
			/*
			 * String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			 * boolean bn =
			 * str1.equalsIgnoreCase(PageStandardPO.getCostCenterInItem(driver,
			 * id)); Assert.assertTrue("Text Not Matching", bn); boolean bl =
			 * str2.equalsIgnoreCase(PageStandardPO.getProjectInItem(driver,
			 * id)); Assert.assertTrue("Text Not Matching", bl); boolean bln =
			 * str3.equalsIgnoreCase(PageStandardPO.getBudgetInItem(driver,
			 * id)); Assert.assertTrue("Text Not Matching", bln);
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

			/*
			 * if (true) { ModalPOSummaryCostBooking.clickOnCancel(driver,
			 * testCaseName); System.out.println(defaultProject);
			 * FlowProjectsSettings.changeProjectsSettings(driver,
			 * defaultProject, testCaseName); }
			 */

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}

	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify UI on expanding items grid in PO; fields in
	 *         cost booking section should be displayed in the following order:
	 *         Cost center; Project; Budget [Check in case project setting is
	 *         NO; UI should be proper]
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275837(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			int index = 1;

			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("NEVER");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> cpb = ObjectCreation.getCostCenterProjectAndBudget();
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, cpb.get("budget"));
			/*
			 * ModalPOSummaryCostBooking.fillInProjectField(driver,
			 * testCaseName,
			 * CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));
			 */
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnExpandAll(driver);
			/*
			 * String id1 = PageStandardPO.getItemId(driver, addItemsToPOfield);
			 * boolean bn =
			 * str1.equalsIgnoreCase(PageStandardPO.getCostCenterInItem(driver,
			 * id1)); Assert.assertTrue("Text Not Matching", bn); boolean bln =
			 * str2.equalsIgnoreCase(PageStandardPO.getBudgetInItem(driver,
			 * id1)); Assert.assertTrue("Text Not Matching", bln);
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
				if (true)
				{
					// ModalPOSummaryCostBooking.clickOnCancel(driver,
					// testCaseName);
					ProjectsSettings project = new ProjectsSettings();
					project.setAssignProjecttoPurchaseCost("ALWAYS");
					FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error in changing settings of project" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}

	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; if 'Assign cost
	 *         to project' setting (Customize) is Always; Project autocomplete
	 *         field should be displayed in Costing tab within Billing and
	 *         delivery info
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275826(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			// Map<String, String> CPB_MAP =
			// ObjectCreation.getCostCenterProjectAndBudget();
			// String projectField = CPB_MAP.get("project");
			boolean bl = ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			Assert.assertTrue("Autocomplete field is not displayed", bl);
			ModalPOSummaryCostBooking.clickOnProjectField(driver, testCaseName);
			// ModalPOSummaryCostBooking.fillInProjectField(driver,
			// testCaseName, projectField);
			// boolean bl =
			// ModalPOSummaryCostBooking.isAutocompleteFieldOfProjectDisplayed(driver,
			// testCaseName);
			// Assert.assertTrue("Autocomplete field is not displayed", bl);
			// ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; in case of 'Let
	 *         user decide' if 'Assign cost to project' setting is YES; Project
	 *         autocomplete field should be displayed in Costing tab within
	 *         Billing and delivery info
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275827(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clickOnYESradioButton(driver, testCaseName);
			boolean bn = ModalPOSummaryCostBooking.isElementYesSelected(driver, testCaseName);
			Assert.assertTrue("YES is not selected", bn);
			// Map<String, String> CPB_MAP =
			// ObjectCreation.getCostCenterProjectAndBudget();
			// String projectField = CPB_MAP.get("project");
			// ModalPOSummaryCostBooking.fillInProjectField(driver,
			// testCaseName, projectField);
			// boolean bl =
			// ModalPOSummaryCostBooking.isAutocompleteFieldOfProjectDisplayed(driver,
			// testCaseName);
			boolean bl = ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			Assert.assertTrue("Autocomplete field is not displayed", bl);
			ModalPOSummaryCostBooking.clickOnProjectField(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
				ProjectsSettings project = new ProjectsSettings();
				project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.ALWAYS);
				FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing setting of project" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

			}
		}
	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; Project
	 *         autocomplete field should be displayed in the following format:
	 *         %PROJ_CODE%: %PROJ_NAME%
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275838(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			// ModalPOSummaryCostBooking.isAutocompleteFieldOfProjectDisplayed(driver,
			// testCaseName);
			ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnProjectField(driver, testCaseName);
			String projectName = ModalPOSummaryCostBooking.getProjectCodeAndProjectName(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			// ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, projectName);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			boolean bn = projectName.equals(PageProjectsMasterDataSettings.getProjectName(driver, testCaseName));
			Assert.assertTrue("project name doesnot matches", bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; Project
	 *         autocomplete field in Costing tab within Billing and delivery
	 *         info should display valid active projects
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275828(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);

			ModalPOSummaryCostBooking.isFieldProjectDisplayed(driver, testCaseName);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));

			String projectName = ModalPOSummaryCostBooking.getProjectCodeAndProjectName(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkProjects(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);

			boolean bn = projectName.equals(PageProjectsMasterDataSettings.getProjectName(driver, testCaseName));

			Assert.assertTrue("project name doesnot matches", bn);
			boolean bl = PageProjectsMasterDataSettings.isProjectActive(driver, testCaseName);
			Assert.assertTrue("Project is not active", bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			// ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * @author payal.alag
	 * @Method : Standard PO: Verify On creating a standard PO; User should not
	 *         be able to select Deactivated projects in Project field in
	 *         Costing tab
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275829(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String str1 = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkProjects(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);

			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopupMasterDataProjectSettings.clickOnYesActiveProject(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, str1);
			boolean bn = ModalPOSummaryCostBooking.isProjectInAutocompleteFieldPresent(driver, testCaseName);
			Assert.assertTrue("Project is present", !bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 18-Nov-2014 : 6:40:00 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275830 <b>Description</b> : Standard PO: Verify
	 * On creating a standard PO; User should not be able to select deleted
	 * projects in Project field in Costing tab
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275830(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String str1 = CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, str1);
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, str1);
			boolean bn = ModalPOSummaryCostBooking.isProjectInAutocompleteFieldPresent(driver, testCaseName);
			Assert.assertTrue("Project is present", !bn);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
				String str1 = CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT);
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
				PageProjectsMasterDataSettings.getSearch(driver, testCaseName, str1);
				PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
				PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated project" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Created On</b> : 18-Nov-2014 : 7:37:12 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275831 <b>Description</b> : Standard PO: Verify
	 * On creating a standard PO; User should not be able to select Out-dated
	 * projects in Project field in Costing tab
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275831(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// String str1 =
			// CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			boolean bn = PageProjectsMasterDataSettings.isProjectOutdated(driver, testCaseName);
			Assert.assertTrue("Project is not outdated", bn);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.OUTDATED_PROJECT));
			boolean bl = ModalPOSummaryCostBooking.isProjectInAutocompleteFieldPresent(driver, testCaseName);
			Assert.assertTrue("Project is present", !bl);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 20-Nov-2014 : 1:22:34 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275844 <b>Description</b> : Standard PO: Verify
	 * an info icon should be present beside Project field in costing tab with
	 * the following fields displayed in a tooltip: Project Code; Project Name;
	 * Project Manager & Duration (From_Date to To_Date)
	 * 
	 * @param testCase
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275844(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			/*
			 * boolean bn = ModalPOSummaryCostBooking.isInfoIconPresent(driver,
			 * testCaseName); Assert.assertTrue("Info icon is present", !bn);
			 */
			// ModalPOSummaryCostBooking.hoverOnInfoIcon(driver, testCaseName);
			// ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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

				if (true)
				{

					System.out.println(defaultProject);
					FlowProjectsSettings.changeProjectsSettings(driver, defaultProject, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error is changing setting of project" + e, e);

			}
			finally
			{

				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Created On</b> : 20-Nov-2014 : 5:06:25 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275846 <b>Description</b> : Standard PO: Verify
	 * an info icon should be present beside Project field in costing tab with
	 * the following fields displayed in a tooltip: Project Code; Project Name;
	 * Project Manager & Duration (From_Date to To_Date) [Check tooltip when any
	 * of the field is empty]
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275846(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB_MAP = ObjectCreation.getCostCenterProjectAndBudget();
			String projectField = CPB_MAP.get("project");
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, projectField);
			/*
			 * boolean bn = ModalPOSummaryCostBooking.isInfoIconPresent(driver,
			 * testCaseName); Assert.assertTrue("Info Icon is not present", bn);
			 * ModalPOSummaryCostBooking.hoverOnInfoIcon(driver, testCaseName);
			 * boolean bl = ModalPOSummaryCostBooking.
			 * isProjectCodeAndProjectNameFieldPresentInInfoIcon(driver,
			 * testCaseName); Assert.assertTrue(
			 * "ProjectCode and ProjectName is not present", bl); boolean bln =
			 * ModalPOSummaryCostBooking.isProjectManagerFieldPresentInInfoIcon(
			 * driver, testCaseName, index); Assert.assertTrue(
			 * "ProjectManager field is not present", bln); int index1 = 2;
			 * boolean boln =
			 * ModalPOSummaryCostBooking.isDurationFieldPresentInInfoIcon(
			 * driver, testCaseName, index1); Assert.assertTrue(
			 * "Duration field is not present", boln);
			 */
			// ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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

				if (true)
				{

					System.out.println(defaultProject);
					FlowProjectsSettings.changeProjectsSettings(driver, defaultProject, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error is changing setting of project" + e, e);

			}
			finally
			{

				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Created On</b> : 20-Nov-2014 : 5:44:43 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275845 <b>Description</b> : Standard PO: Verify
	 * Project tooltip info icon should not be displayed if no project is
	 * selected in project field
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275845(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			/*
			 * boolean flag =
			 * ModalPOSummaryCostBooking.isProjectInfoIconDisplayed(driver,
			 * testCaseName); Assert.assertTrue(!flag);
			 */
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ActionBot.defaultSleep();
			// ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			/*
			 * boolean flag1 =
			 * ModalPOItemSummaryCostAllocation.isProjectInfoIconPresent(driver)
			 * ; Assert.assertTrue(!flag1);
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

			/*
			 * if (true) { //ModalPOSummaryCostBooking.clickOnCancel(driver,
			 * testCaseName); //System.out.println(defaultProject);
			 * //FlowProjectsSettings.changeProjectsSettings(driver,
			 * defaultProject, testCaseName); }
			 */

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}

	}

	/**
	 * 
	 * <b>Created On</b> : 20-Nov-2014 : 6:21:27 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275851 <b>Description</b> : Standard PO: Verify
	 * info icon tooltip beside project field in costing tab to indicate whether
	 * the type selected in project or task
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275851(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			// Map<String, String> CPB_MAP =
			// ObjectCreation.getCostCenterProjectAndBudget();
			// String projectField = CPB_MAP.get("project");
			String project1 = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project1);
			boolean bl = ModalPOSummaryCostBooking.isProjectOrTaskIconPresent(driver, testCaseName);
			Assert.assertTrue("Project/Task icon is not present", bl);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.budget));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			/*
			 * ModalPOItemSummaryCostAllocation.isProjectInfoIconPresent(driver)
			 * ; ModalPOItemSummaryCostAllocation.isProjectOrTaskIconPresent(
			 * driver);
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

			/*
			 * if (true) { ModalPOSummaryCostBooking.clickOnCancel(driver,
			 * testCaseName); System.out.println(defaultProject);
			 * FlowProjectsSettings.changeProjectsSettings(driver,
			 * defaultProject, testCaseName); }
			 */

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}

	}

	/**
	 * 
	 * <b>Created On</b> : 20-Nov-2014 : 6:26:42 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275852 <b>Description</b> : Standard PO: Verify
	 * when no project/task is selected; the info icon indicating whether the
	 * type selected in project or task should not be displayed
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275852(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			boolean flag = ModalPOSummaryCostBooking.isProjectOrTaskIconPresent(driver, testCaseName);
			Assert.assertTrue(!flag);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			boolean bn = ModalPOItemSummaryCostAllocation.isProjectOrTaskIconPresent(driver);
			Assert.assertTrue(!bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{

			if (true)
			{
				System.out.println(defaultProject);
				// FlowProjectsSettings.changeProjectsSettings(driver,
				// defaultProject, testCaseName);
			}

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Created On</b> : 21-Nov-2014 : 2:14:24 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_275855 <b>Description</b> : Standard PO: Verify
	 * on creating a standard PO; if company of the PO is changed; User should
	 * be able to select valid (based on validity date range) & active projects
	 * for the Company in Projects field
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275855(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ProjectsSettings defaultProject = new ProjectsSettings();
		defaultProject.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			/*
			 * UserSettings userSettings = user.getUserSettings(); String
			 * companies = userSettings.getCompanyName();
			 */
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost("ALWAYS");
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnBillingPOSummary(driver);
			FlowSelectingDifferentCompanyInPOSummary.selectDifferentCompanies(driver, testCaseName);
			ActionBot.defaultSleep();
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB_MAP = ObjectCreation.getCostCenterProjectAndBudget();
			String projectField = CPB_MAP.get("project");
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, CPB_MAP.get("costCenter"));
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, projectField);
			boolean bn = ModalPOSummaryCostBooking.isAutocompleteFieldOfProjectDisplayed(driver, testCaseName);
			Assert.assertTrue("Autocomplete project field is displayed", !bn);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CPB_MAP.get("budget"));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			/*
			 * try {
			 * 
			 * if (true) { ModalPOSummaryCostBooking.clickOnCancel(driver,
			 * testCaseName); System.out.println(defaultProject);
			 * FlowProjectsSettings.changeProjectsSettings(driver,
			 * defaultProject, testCaseName); } } catch (Exception e) {
			 * logger.error("Error in changing project settings" + e, e); }
			 * finally {
			 */

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			// }
		}
	}

	/**
	 * 
	 * <b>Created On</b> : 24-Nov-2014 : 3:33:51 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_272078 <b>Description</b> : Test for bug 221520
	 * - Purchase Order: Currency not populated on Create PO screen
	 * 
	 * @param testCase
	 * @throws Exception
	 * @throws SessionNotFoundException
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272078(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			String supplierName = CommonServices.getTestData(IConstantsData.SUPPLIER_NAME);
			PageStandardPO.enterSupplierName(driver, supplierName);
			// String supplierAddress =
			// CommonServices.getTestData(IConstantsData.SUPPLIER_ADDRESS);
			PageStandardPO.selectFirstSupplierAddress(driver, testCaseName);
			boolean bl = PageStandardPO.isCurrencyTypeFieldBlank(driver);
			Assert.assertTrue("Field is blank", bl);
			// boolean bn = PageStandardPO.isCurrencyValueFieldBlank(driver);
			// Assert.assertTrue("Field is blank", bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 25-Nov-2014 : 5:40:51 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_272087 <b>Description</b> :Test for bug 221028 -
	 * Intermittent: Purchase Order: Error 500 on searching a category
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272087(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			ActionBot.defaultSleep();
			boolean bn = PageStandardPO.isResultOfItemDisplayed(driver);
			Assert.assertTrue("Result is not displayed of searched item", !bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 25-Nov-2014 : 5:42:40 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_272089 <b>Description</b> : Test for bug 221987
	 * - Purchase Order: Modal shown as blank when accounting details is already
	 * selected
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272089(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,650)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			// String glType =
			// CommonServices.getTestData(IConstantsData.GL_Type);
			// ModalPOItemSummaryCostAllocation.fillGLType(driver, glType);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			// boolean bn =
			// ModalPOItemSummaryCostAllocation.isGLAccountFieldFilled(driver);
			// Assert.assertTrue("Field is empty", !bn);
			boolean bl = ModalPOItemSummaryCostAllocation.isGLAccountFieldFilled(driver);
			Assert.assertTrue("Field is empty", !bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 26-Nov-2014 : 1:28:39 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_272092 <b>Description</b> : Test for bug 221502
	 * - Purchase order: Contract Number is not copied when PO is copied.
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272092(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		User user = null;
		boolean RTC_272092 = false;
		String contractNumberCopyPO = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			//get a guided item object
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);

			//set contract number
			guidedItem1.setContractNo(CommonServices.getTestData(IConstantsData.CONTRACT_NO));
			guidedItems.add(guidedItem1);
			items.setGuidedItems(guidedItems);

			//create a standard po with the guided item
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.setItems(items);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, standardpo.getPoNumber());
			PagePO.clickOnActions(driver, testCaseName);

			//copy that po
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			ActionBot.scroll(driver, "800");

			//check if contract number is copied
			contractNumberCopyPO = PageStandardPO.getItemContractNumber(driver, testCaseName);
			RTC_272092 = (contractNumberCopyPO.equalsIgnoreCase(CommonServices.getTestData(IConstantsData.CONTRACT_NO)));
			Assert.assertTrue("Contract no is not copied", RTC_272092);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 10:46:23 am <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282659 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify the new item details modal should be
	 * displayed properly on clicking on the catalog item in PO Item search
	 * result
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282659(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			int index = 1;
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.clickOnCatalogItem(driver, index);
			boolean bl = ModalItemDetails.checkIsCatalogItemSameAsSelected(driver, index);
			Assert.assertTrue("Item name is different", bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 10:49:06 am <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282660 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify on clicking on the catalog item in PO
	 * Item search result; the following actions should NOT be present in item
	 * details modal: Add to cart; Add to basket; Add to favorites
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282660(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.clickOnCatalogItem(driver, index);
			/*
			 * boolean bn = ModalItemDetails.isAddPresentInItemDetail(driver,
			 * index); Assert.assertTrue("Add is present in Item detail modal",
			 * !bn);
			 */
			boolean flag = ModalItemDetails.isAddToCartPresentInItemDetail(driver);
			Assert.assertTrue("Add to cart is present", !flag);
			boolean flag1 = ModalItemDetails.isAddToFavoritesPresentInItemDetail(driver);
			Assert.assertTrue("Add to favorite is present", !flag1);
			boolean flag2 = ModalItemDetails.isAddToBasketPresentInItemDetail(driver);
			Assert.assertTrue("Add to basket is present", !flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 12:14:20 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282661 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify Item details modal with maximum
	 * characters in the following fields: Short Description; Supplier Part Id;
	 * Price; Item image; Quantity box; UOM; Description; Manufacturer;
	 * Category; SPSC Code; Supplier; Delivery Lead Time (days); Contract No;
	 * Specification Name; Specification Key; Specification Value; Attachment
	 * files and web links
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282661(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			int index = 1;
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.clickOnCatalogItem(driver, index);
			boolean bl = ModalItemDetails.isMaxCharItemNameDisplayedProperly(driver, index);
			Assert.assertTrue("Max chars not displayed properly", bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 12:46:23 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282662 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify Item details modal with special
	 * characters in the following fields: Short Description; Supplier Part Id;
	 * Price; Item image; Quantity box; UOM; Description; Manufacturer;
	 * Category; SPSC Code; Supplier; Delivery Lead Time (days); Contract No;
	 * Specification Name; Specification Key; Specification Value; Attachment
	 * files and web links
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282662(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			int index = 1;
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.SPECIAL_CHAR);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.clickOnCatalogItem(driver, index);
			ActionBot.defaultMediumSleep();
			String str = ActionBot.findElement(driver, com.zycus.automation.eproc.pageobjects.modals.itemDetailsPO.IModalItemDetails.CATALOG_ITEM_LABEL_ITEM_DETAILS).getText();
			logger.info("the special character" + str);
			ModalItemDetails.clickOnCloseButton(driver);
			boolean bl = (str.equalsIgnoreCase(addItemsToPOfield)) ? true : false;
			Assert.assertTrue("Special char not displayed properly", bl);

			//PageStandardPO.clickOnCatalogItem(driver, index);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 12:47:07 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282663 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify Item details modal with script
	 * characters in the following fields: Short Description; Supplier Part Id;
	 * Price; Item image; Quantity box; UOM; Description; Manufacturer;
	 * Category; SPSC Code; Supplier; Delivery Lead Time (days); Contract No;
	 * Specification Name; Specification Key; Specification Value; Attachment
	 * files and web links
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282663(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			int index = 1;
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.SPECIAL_CHAR);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.clickOnCatalogItem(driver, index);
			boolean bl = ModalItemDetails.isScriptingCharItemNameDisplayedProperly(driver, index);
			Assert.assertTrue("Scripting char not displayed properly", !bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Created On</b> : 27-Nov-2014 : 12:47:26 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : RTC_282664 <b>Description</b> : PO Item search
	 * result>>Item details modal: Verify Item details modal with multilingual
	 * characters in the following fields: Short Description; Supplier Part Id;
	 * Price; Item image; Quantity box; UOM; Description; Manufacturer;
	 * Category; SPSC Code; Supplier; Delivery Lead Time (days); Contract No;
	 * Specification Name; Specification Key; Specification Value; Attachment
	 * files and web links
	 * 
	 * @param testCase
	 * @throws Exception
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_282664(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			int index = 1;
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.clickOnCatalogItem(driver, index);
			boolean bl = ModalItemDetails.isMultiLingualCharItemNameDisplayedProperly(driver, index);
			Assert.assertTrue("Multilingual char not displayed properly", bl);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_276145 <b>Description : Category-PT-GL Map >> PO Creation >> Change
	 * Company: Accounting details should be validated as per new Company
	 * selected. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276145(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			ActionBot.defaultMediumSleep();
			// checking glaccount and gltype of catelog item
			String itemID = standardpo.getItems().getCatelogItems().get(0).getItemID();
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			//	GLMap glMap = new GLMap();
			//GLMap glMap = ObjectCreation.getDefaultObjectOfGLMap();
			GLMap glMap = ObjectCreation.getDefaultObjectOfGLMap();
			// glMap.setCategory(glMap.getCategory());
			glMap.getGlAccountType();
			/*
			 * boolean bl = FlowStandardPo.isGLAccountSameAsGLMap(driver,
			 * testCaseName, glMap); Assert.assertTrue(
			 * "GLAccountType is different", bl); glMap.getGlAccount();
			 */
			boolean bn = FlowStandardPo.isGLAccountSameAsGLMap(driver, testCaseName, glMap);
			//	Assert.assertTrue("GLAccount is different", !bn);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			// checking glaccount and gltype of guided item
			String itemid = standardpo.getItems().getGuidedItems().get(0).getItemID();
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemid);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			/*
			 * boolean bln = FlowStandardPo.isGLAccountSameAsGLMap(driver,
			 * testCaseName, glMap); Assert.assertTrue(
			 * "GLAccountType is different", bln); glMap.getGlAccount();
			 */
			boolean bo = FlowStandardPo.isGLAccountSameAsGLMap(driver, testCaseName, glMap);
			Assert.assertTrue("GLAccount is different", !bo);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			ActionBot.defaultSleep();
			TabPOSummary.clickOnCostBookingPOSummary(driver);

			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, CPB.get("costCenter"));
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CPB.get("project"));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CPB.get("budget"));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// UserSettings userSettings = user.getUserSettings();
			// String companies = userSettings.getCompanyName();
			// changing company of user
			// FlowSelectingDifferentCompanyInPOSummary.selectDifferentCompanies(driver,
			// testCaseName, companies);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			// rechecking glaccount and gltype of catelog item
			/*
			 * boolean cat = FlowStandardPo.isGLAccountSameAsGLMap(driver,
			 * testCaseName, glMap); Assert.assertTrue(
			 * "GLAccountType is different", cat); glMap.getGlAccount();
			 */
			boolean cate = FlowStandardPo.isGLAccountSameAsGLMap(driver, testCaseName, glMap);
			Assert.assertTrue("GLAccount is different", !cate);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			// rechecking glaccount and gltype of guided item
			/*
			 * boolean guide = FlowStandardPo.isGLAccountSameAsGLMap(driver,
			 * testCaseName, glMap); Assert.assertTrue(
			 * "GLAccountType is different", guide); glMap.getGlAccount();
			 */
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemid);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			// boolean guided = FlowStandardPo.isGLAccountSameAsGLMap(driver,
			// testCaseName, glMap);
			// Assert.assertTrue("GLAccount is different", !guided);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_20502 <b>Description : While creating a manual PO, Company,BU and
	 * Location should get defaulted from the Masters. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20502(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_20503"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_20504"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// MainPageHeaderLevelTab.clickOnMasterSubTab(driver);

			// click on users link
			// PageMasterDataSettings.clickOnUsersLink(driver, testCaseName);
			// UserSettings userSettings = user.getUserSettings();
			user.setSearchUserByOption(IConstantsData.SEARCH_USER_BY_EMAIL_ID);
			UserSettings userSettings = FlowUserManagement.getUserSettings(driver, testCaseName, user);

			String companies = userSettings.getCompanyName();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			// get company name
			boolean flag = companies.equalsIgnoreCase(PageStandardPO.getCompany(driver, testCaseName));
			Assert.assertTrue(flag);
			// get business unit
			String businessunit = userSettings.getBusinessUnit();
			boolean bl = businessunit.equalsIgnoreCase(PageStandardPO.getBusinessUnit(driver, testCaseName));
			Assert.assertTrue(bl);
			mappedTestCases.get(0).setTestResult(bl);
			// get location
			String location = userSettings.getLocationName();
			boolean bn = location.equalsIgnoreCase(PageStandardPO.getLocation(driver, testCaseName));
			Assert.assertTrue(bn);
			mappedTestCases.get(1).setTestResult(bn);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_20336 <b>Description : Bill-to address, Invoice-to address and
	 * Ship-to address should be associated with the selected Location. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20336(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// UserSettings userSettings = user.getUserSettings();
			user.setSearchUserByOption(IConstantsData.SEARCH_USER_BY_EMAIL_ID);
			UserSettings userSettings = FlowUserManagement.getUserSettings(driver, testCaseName, user);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnLocationLink(driver, testCaseName);
			// get current location
			PageLocationMasterDataSettings.fillSearchBox(driver, testCaseName, userSettings.getLocationName());
			PageLocationMasterDataSettings.clickOnGo(driver, testCaseName);
			// get delivery address
			PageLocationMasterDataSettings.getDeliveryAddressLocationFromMasterData(driver, testCaseName);
			// get bill to address
			PageLocationMasterDataSettings.getBillTOAddressLocationFromMasterData(driver, testCaseName);
			// get other location
			PageLocationMasterDataSettings.fillSearchBox(driver, testCaseName, CommonServices.getTestData(IConstantsData.DIFFERENT_LOCATION));
			PageLocationMasterDataSettings.clickOnGo(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			// compare current location
			ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName);
			ModalPurchaseOrderSummaryBilling.getLocationOfBillToAddress(driver, testCaseName);
			/*
			 * ModalPurchaseOrderSummaryBilling.clickOnButtonOfOtherLocation(
			 * driver, testCaseName); String changedDeliveryAdd =
			 * ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(
			 * driver, testCaseName); String changedBillToAdd =
			 * ModalPurchaseOrderSummaryBilling.getLocationOfBillToAddress(
			 * driver, testCaseName); boolean flag = changedDeliveryAdd !=
			 * currentDeliveryAdd ? true : false; Assert.assertTrue(
			 * "Delivery address have not changed", flag); boolean flag1 =
			 * changedBillToAdd != currentBillToAdd ? true : false;
			 * Assert.assertTrue("Bill to address have not changed", flag1);
			 * TabPOSummary.clickOnCostBookingPOSummary(driver);
			 * ModalPOSummaryCostBooking.fillInProjectField(driver,
			 * testCaseName,
			 * CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));
			 */
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			// PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
			// testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_20330 <b>Description : User should be able to Park the PO's till X
	 * business days, and then system should auto generate pending PO's. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20330(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_No(driver, testCaseName);
			// set park value for 5 days
			PagePurchaseOrderSetting.getSelectedReleasePOAutomaticParkTypeOption(driver, testCaseName);
			int parkValue = 5;
			PagePurchaseOrderSetting.fillReleasePOAutomaticParkValue(driver, testCaseName, parkValue);
			// check options of automatically generated PO
			PagePurchaseOrderSetting.getAutomaticallyGeneratePO_option(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			String poNo = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equalsIgnoreCase("Parked");
			Assert.assertTrue("Status is not parked", flag);
			// PagePurchaseOrderListing.isPOParkedMessageDisplayedCorrectly(driver,
			// testCaseName);
			// PagePurchaseOrderListing.isPOParkedMessageDisplayedCorrectly(driver,
			// testCaseName);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing purchase order setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_20508 <b>Description : User should be able to insert a Discount
	 * amount or discount percenteage at a Add Item page. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20508(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139287"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,650)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			// String addItemsToPOfield = CommonServices.getTestData(testCase,
			// IConstantsData.SEARCH_FOR);
			String addItemsToPOfield = "laptop";
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			ActionBot.scroll(driver, "300");
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			PageStandardPO.clickOnModify(driver, testCaseName);
			// fill discount percentage
			// ModalDiscountPO.fillDiscountAmount(driver, testCaseName,
			// discount);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			// String type = "Percentage";
			// ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName,
			// type);
			int value = 5;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			double discountedAmount = ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			// compare discounted amount on modal with discount price on
			// standard PO page
			double headerDiscount = ModalDiscountPO.getHeaderLevelTotalDiscountAmount(driver, testCaseName);
			boolean flag = discountedAmount == headerDiscount;
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			// fill discount amount
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			String type = "Amount";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type);
			int value1 = 50;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value1);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			double discountedAmount1 = ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			// compare discounted amount on modal with discount price on
			// standard PO page
			double headerDiscount1 = ModalDiscountPO.getHeaderLevelTotalDiscountAmount(driver, testCaseName);
			boolean flag1 = discountedAmount1 == headerDiscount1;
			Assert.assertTrue(flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			// fill discount per item
			ActionBot.defaultSleep();
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			String type1 = "per item";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type1);
			int value2 = 50;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value2);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			double discountedAmount2 = ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			// compare discounted amount on modal with discount price on
			// standard PO page
			double headerDiscount2 = ModalDiscountPO.getHeaderLevelTotalDiscountAmount(driver, testCaseName);
			boolean flag2 = discountedAmount2 == headerDiscount2;
			Assert.assertTrue(flag2);
			mappedTestCases.get(0).setTestResult(flag2);
			// ModalDiscountPO.isDiscountedPriceEqualToDiscountedAmount(driver,
			// testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_20501 <b>Description : User should be able to release the PO's
	 * immediately when request is made. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_20501(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			// check options of automatically generated PO
			PagePurchaseOrderSetting.getAutomaticallyGeneratePO_option(driver, testCaseName);
			// generate PO automatically
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardpo);
			// JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			// jsx1.executeScript("window.scrollBy(0,850)", "");
			// standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			/*
			 * String poNo = PageViewPurchaseOrder.getViewPONo(driver,
			 * testCaseName); MainPageHeaderLevelTab.clickOnPOTab(driver);
			 * PagePO.enterPONumber(driver, testCaseName, poNo); String status =
			 * PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			 * boolean flag = status.equalsIgnoreCase("Released");
			 * Assert.assertTrue("Status of PO is not Released", flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_25684 <b>Description : Taxes in PO : There should be a 'Taxes not
	 * applicable for item' option in Taxes section, after which no taxes will
	 * be applied on that PO. item </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25684(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25682"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25683"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25685"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25686"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139281"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		int index = 1;
		int index2 = 2;
		int index1 = 2;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			// add first item

			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			// add second item

			boolean flag1 = PageStandardPO.isNoTaxOptionPresent(driver, testCaseName);
			Assert.assertTrue("No tax option not present", flag1);
			mappedTestCases.get(1).setTestResult(flag1);

			PageStandardPO.clickOnTaxNotApplicable(driver, testCaseName);
			ActionBot.defaultLowSleep();
			//check tax name is present and non editable
			boolean flag2 = !PageStandardPO.isPreloadedTaxNamePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax name not present", flag2);
			mappedTestCases.get(0).setTestResult(flag2);

			// check tax type is present and non editable
			boolean flag3 = !PageStandardPO.isPreloadedTaxTypePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax type not present", flag3);
			mappedTestCases.get(0).setTestResult(flag3);

			// check tax rate is present and non editable
			boolean flag4 = !PageStandardPO.isPreloadedTaxRatePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax rate not present", flag4);
			mappedTestCases.get(0).setTestResult(flag4);

			//checkbox to select items
			ActionBot.findElement(driver, By.xpath("//*[@id=\"collapsibleGrid\"]/thead/tr/th[1]/input")).click();
			ActionBot.defaultLowSleep();
			// click on update all lines
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);

			// select tax type
			String taxType = IConstantsData.SALES_TAX;
			WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='applyToMultipleTax']//tr[" + index2 + "]//*[contains(@class,'dev_inputTaxType')]"));
			ActionBot.fillAutoCompleteField(driver, element, taxType);
			// fill tax name
			String taxName = CommonServices.getTestData(IConstantsData.TAX_NAME);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, taxName, index2);
			String taxRate = CommonServices.getTestData(IConstantsData.TAX_RATE);
			ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, Integer.parseInt(taxRate));
			// click on tax not applicable
			ModalUpdateAllLinesPO.clickOnRadioButtonTaxNotApplicable(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			// check total tax
			boolean flag5 = PageStandardPO.isTotalTaxNull(driver, testCaseName);
			Assert.assertTrue("Total tax is not equal to zero", flag5);
			mappedTestCases.get(2).setTestResult(flag5);
			mappedTestCases.get(3).setTestResult(flag5);
			mappedTestCases.get(4).setTestResult(flag5);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_25688 <b>Description : Tax Configuration based on county: There
	 * should be a CITY & COUNTY fileds present while tax creation. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25688(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnTaxRatesLink(driver, testCaseName);
			PageTaxRatesMasterDataSettings.clickOnAddTaxRate(driver, testCaseName);
			// check city field
			boolean flag = PageTaxRatesMasterDataSettings.isCityFieldPresent(driver, testCaseName);
			Assert.assertTrue("City field is not present", flag);
			// check county field
			boolean flag1 = PageTaxRatesMasterDataSettings.isCountyFieldPresent(driver, testCaseName);
			Assert.assertTrue("County field is not prsent", flag1);
			// check for free text on city field
			boolean flag2 = PageTaxRatesMasterDataSettings.allowToEnterFreeTextCity(driver, testCaseName, IConstantsData.FREE_TEXT_CITY);
			Assert.assertTrue("Free text not allowed", !flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_27164 <b>Description : Verify that In PO > Create New Item: Line No.
	 * should be automatically generated, user can change it. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_27164(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutoGenerateLineItemNumbersOnPO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int lineNumber = ModalPOFreeTextItemSummaryItem.getLineNo(driver, testCaseName);
			int lineNo = 33;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOFreeTextItemSummaryItem.clickOnCancel(driver, testCaseName);
			ActionBot.defaultMediumSleep();

			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			List<GuidedItem> guidedItemsList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemsList.get(0);
			guidedItem.setNextAction(IConstantsData.SAVE);
			guidedItem.setLineNo(35);

			item = FlowStandardPo.addItem(driver, testCaseName, item);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_21960 <b>Description : As a buyer, User should be able to print the
	 * PO document for the generated PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_21960(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_21961"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// String poNumber =
			// CommonServices.getTestData(IConstantsData.PO_NUMBER);
			// PagePO.enterPONumber(driver, testCaseName, poNumber);
			// PagePO.clickOnPONumber(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isPrintPOOptionPresent(driver, testCaseName);
			Assert.assertTrue("Print PO option is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Print modal is opened successfully");
			driver.switchTo().window(winHandlerBefore);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_60833 <b>Description : PO single screen : User should be able to
	 * mention following while creating PO : Order description </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60833(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			String notes = "testingAutomation";
			standardpo.setNotes(notes);
			String poContact = "1234567";
			standardpo.setPoContact(poContact);
			// String termsAndConditions = "abcd";
			// standardpo.setTermsAndConditions(termsAndConditions);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jan-2015 </b> <b>Method :
	 * RTC_60878 <b>Description : PO single screen>>Tax Section : Always
	 * applicable taxes should come as read only </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60878(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60881"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60883"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60884"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60882"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_27224"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.Additem(driver, testCaseName);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx1.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 5;
			// fill discount amount
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");
			int index1 = 2;
			boolean flag2 = PageStandardPO.isPreloadedTaxNamePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax name not present", flag2);
			mappedTestCases.get(0).setTestResult(flag2);
			boolean flag3 = PageStandardPO.isPreloadedTaxNameNonEditable(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax name is editable", flag3);
			mappedTestCases.get(0).setTestResult(flag3);
			// check tax type is present and non editable
			boolean flag4 = PageStandardPO.isPreloadedTaxTypePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax type not present", flag4);
			mappedTestCases.get(1).setTestResult(flag4);
			boolean flag5 = PageStandardPO.isPreloadedTaxTypeNonEditable(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax type is editable", flag5);
			mappedTestCases.get(1).setTestResult(flag5);
			// check tax rate is present and non editable
			boolean flag6 = PageStandardPO.isPreloadedTaxRatePresent(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax rate not present", flag6);
			boolean flag7 = PageStandardPO.isPreloadedTaxRateNonEditable(driver, testCaseName, index1);
			Assert.assertTrue("Preloaded tax rate is editable", flag7);
			boolean bn = PageStandardPO.isNoTaxOptionPresent(driver, testCaseName);
			Assert.assertTrue("No tax option is not available", bn);
			mappedTestCases.get(3).setTestResult(bn);
			jsx1.executeScript("window.scrollBy(0,650)", "");

			// functionality not present
			boolean flag8 = PageStandardPO.isRequireReceiptOptionPresent(driver, testCaseName);
			Assert.assertTrue("Require receipt option not present", flag8);
			mappedTestCases.get(2).setTestResult(flag8);
			mappedTestCases.get(4).setTestResult(flag8);
			PageStandardPO.clickOnRequireReceiptChkbox(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_58539 <b>Description : User should have an option to view amended POs
	 * in a separate listing by clicking a link "View amended PO" </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58539(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58707"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58708"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58709"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58710"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58711"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58712"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58706"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58733"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58734"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			boolean flag = PagePO.isViewAmmendedPOPrsent(driver, testCaseName);
			Assert.assertTrue("View ammended PO link not present", flag);
			PagePO.clickOnViewAmmendedPO(driver, testCaseName);
			mappedTestCases.get(6).setTestResult(flag);
			boolean bn = PageAmmendedPO.isViewAllPOPresent(driver, testCaseName);
			Assert.assertTrue("View all PO is not present", bn);
			mappedTestCases.get(5).setTestResult(bn);
			// int index = 3;
			// PageAmmendedPO.clickOnActions(driver, testCaseName, index);
			// PageAmmendedPO.clickOnEdit(driver, testCaseName);
			PageAmmendedPO.clickOnAmmendPONumberOfDifferentBuyer(driver, testCaseName);
			boolean flag1 = PopUpAlertAmmendedPO.isAlertPresent(driver, testCaseName);
			Assert.assertTrue("Alert not present", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			boolean flag2 = PopUpAlertAmmendedPO.isAlertMessageSameAsDescribed(driver, testCaseName);
			Assert.assertTrue(flag2);
			mappedTestCases.get(0).setTestResult(flag2);
			boolean flag3 = PopUpAlertAmmendedPO.isContinuePresent(driver, testCaseName);
			Assert.assertTrue(flag3);
			mappedTestCases.get(1).setTestResult(flag3);
			boolean flag4 = PopUpAlertAmmendedPO.isCancelPresent(driver, testCaseName);
			Assert.assertTrue(flag4);
			mappedTestCases.get(1).setTestResult(flag4);
			PopUpAlertAmmendedPO.clickOnCancel(driver, testCaseName);
			// int index1 = 2;
			// PageAmmendedPO.clickOnActions(driver, testCaseName, index1);
			// PageAmmendedPO.clickOnEdit(driver, testCaseName);
			PageAmmendedPO.clickOnAmmendPONumberOfSameBuyer(driver, testCaseName);
			boolean flag5 = PopUpAlertAmmendedPO.isAlertPresent(driver, testCaseName);
			Assert.assertTrue("Alert is present", !flag5);
			mappedTestCases.get(2).setTestResult(flag5);
			boolean flag6 = PageAmmendedPO.isRollBackPresent(driver, testCaseName);
			Assert.assertTrue("Roll back is not present", flag6);
			mappedTestCases.get(3).setTestResult(flag6);
			PageAmmendedPO.clickOnRollBack(driver, testCaseName);
			boolean flag8 = PopUpRollBackAmmendedPO.isRollBackCancelPresent(driver, testCaseName);
			Assert.assertTrue(flag8);
			mappedTestCases.get(4).setTestResult(flag1);
			boolean flag9 = PopUpRollBackAmmendedPO.isRollBackContinuePresent(driver, testCaseName);
			Assert.assertTrue(flag9);
			mappedTestCases.get(4).setTestResult(flag1);
			PopUpRollBackAmmendedPO.clickOnCancelRollBack(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			boolean flag7 = PopUpErrorAmmendedPO.isErrorMessageDisplayed(driver, testCaseName);
			Assert.assertTrue("Error message not displayed", flag7);
			PopUpErrorAmmendedPO.clickOnOK(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			boolean bl = PagePurchaseOrderSetting.isPOAmmendingLimitationOnItemUnitPricePresent(driver, testCaseName);
			Assert.assertTrue(bl);
			mappedTestCases.get(7).setTestResult(bl);
			int limitedItemUnitPrice = 5;
			PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemUnitPrice(driver, testCaseName, limitedItemUnitPrice);
			boolean bln = PagePurchaseOrderSetting.isPOAmmendingLimitationOnItemQuantityPresent(driver, testCaseName);
			Assert.assertTrue(bln);
			mappedTestCases.get(8).setTestResult(bln);
			int limitedItemQuantity = 5;
			PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemQuantity(driver, testCaseName, limitedItemQuantity);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Jan-2015 </b> <b>Method :
	 * RTC_58741 <b>Description : Amend PO&amp;gt;&amp;gt; Delivery
	 * details&amp;gt;&amp;gt;Delivery Address (OU address, all addresses in
	 * user's scope, custom address, cost center) should get edited with the
	 * union of Scope of document and Current Buyer who is editng it. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58741(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58758"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_190967"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60889"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_62028"));
		}

		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());

			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnOtherAddressTextBox(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));

			String customAddress = ModalPOSummaryDelivery.getChangedAddress(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);

			String headerAddress = PageStandardPO.getDeliveryAddressOfHeader(driver, testCaseName);
			boolean flag = customAddress.equals(headerAddress) ? true : false;
			Assert.assertTrue("Address doeesnot matches", flag);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int lineNo = 5;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			String shortDesc = CommonServices.getTestData(IConstantsData.ORDER_DESCRIPTION);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, shortDesc);
			String productCategory = CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING);

			String marketPrice = CommonServices.getTestData(IConstantsData.MARKET_PRICE);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, Integer.parseInt(marketPrice));
			String quantity = "4";

			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, Integer.parseInt(quantity));
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);

			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));

			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			ActionBot.click(driver, IModalPOFreeTextItemSummaryItemImpl.TEXTBOX_PRODUCT_CATEGORY);

			boolean flag1 = ModalPOFreeTextItemSummaryItem.isErrorMessageDisplayed(driver, testCaseName);
			Assert.assertTrue("Error message is not displayed", flag1);
			mappedTestCases.get(0).setTestResult(flag1);

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, productCategory);

			int zeroPrice = 0;
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, zeroPrice);

			int zeroQuantity = 0;
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, zeroQuantity);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			boolean flag2 = ModalPOFreeTextItemSummaryItem.isErrorMessageDisplayed(driver, testCaseName);

			Assert.assertTrue("Error message is displayed", flag2);
			mappedTestCases.get(1).setTestResult(flag2);
			mappedTestCases.get(2).setTestResult(flag2);
			mappedTestCases.get(3).setTestResult(flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Jan-2015 </b> <b>Method :
	 * RTC_58727 <b>Description : Requester should be able to see amended PO
	 * document on click of PO_NO link. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58727(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58723"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58724"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		String status1 = null;
		boolean flag;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnViewAmmendedPO(driver, testCaseName);
			flag = true;
			List<WebElement> PoNo = PageAmmendedPO.getAllAmendedPONos(driver, testCaseName);

			for (int i = 0; i < PoNo.size(); i++)
			{
				status1 = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, i + 1);
				if (status1.contains(IConstantsData.IN_APPROVAL_FILTER_LABEL))
				{
					PoNo.get(i).click();
					JavascriptExecutor jsx = (JavascriptExecutor) driver;
					jsx.executeScript("window.scrollBy(0,1500)", "");
					PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
					jsx.executeScript("window.scrollBy(0,1200)", "");
					flag = PageViewPurchaseOrder.isAmmendmentStatusPresent(driver, testCaseName, 1);
					Assert.assertTrue("Ammendment status not present", flag);
					mappedTestCases.get(0).setTestResult(flag);
					mappedTestCases.get(1).setTestResult(flag);
					CommonServices.successfulExecutionOfTestCase(driver, testCase);
					break;
				}

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

		finally
		{

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_60916 <b>Description : Test for bug 194109 - Validation missing for
	 * Requester field, causing error 500 on submit with longer data. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60916(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60961"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_62026"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierCurrencyOnPO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnOtherAddressTextBox(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			ModalPOSummaryDelivery.getChangedAddress(driver, testCaseName);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			String project = CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.budget));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.getDeliveryAddressOfHeader(driver, testCaseName);
			// boolean flag = headerAddress == changedAddress ? true : false;
			// Assert.assertTrue("Header address is different then the selected
			// address",
			// flag);
			// mappedTestCases.get(1).setTestResult(flag);
			String supplierName = CommonServices.getTestData(IConstantsData.SUPPLIER_NAME);
			PageStandardPO.enterSupplierName(driver, supplierName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			// ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			PageStandardPO.enterCurrencyType(driver, CommonServices.getTestData(IConstantsData.CHANGED_CURRENCY));
			ModalChangeCurrencyPO.clickOnConvertAmountsToCurrencyType(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,850)", "");
			int index1 = 2;
			PageStandardPO.getCurrencyAmount(driver, testCaseName, index1);
			// boolean currencyValue = itemCurrency == currency ? true : false;
			// Assert.assertTrue("Currency is not same as supplier currency",
			// currencyValue);

			PageStandardPO.enterRequester(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHAR));
			PageStandardPO.clickOnBuyer(driver, testCaseName);
			boolean flag2 = PageStandardPO.isErrorMessageDisplayed(driver, testCaseName);
			flag2 = true;
			Assert.assertTrue(flag2);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_107310 <b>Description : Verify Free text tax for compung tax. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107310(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107305"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107314"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107315"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107321"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108702"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_109202"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107068"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60880"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		float totalTaxBeforeApplyingTax = 0;
		float totalTaxAfterApplyingTax = 0;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			// add compound tax
			boolean flag = PageStandardPO.isAddCompoundTaxOptionPresent(driver, testCaseName);
			Assert.assertTrue("No tax option is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			//Add simple tax
			index = 2;
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("Simple tax not applied", flag);
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index1 = 4;
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			// Fill Tax Type
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index1);
			PageStandardPO.enterFreeTextTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), index1);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("Compound tax not applied", flag);
			// add multiple compound tax as free text tax name
			int index2 = 5;
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index1);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("2nd Compound tax not applied", flag);
			// remove simple tax
			int index3 = 2;
			PageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index3);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			PageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName, index3);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("Simple tax not removed successfully", flag);
			// check for validation with 14 digit tax rate
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index1);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 2);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax == totalTaxBeforeApplyingTax;
			Assert.assertTrue("Zero tax not applied successfully", flag);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 3);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("14 digit tax not applied successfully", flag);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			// input value in .XX format
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 4);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			flag = totalTaxAfterApplyingTax != totalTaxBeforeApplyingTax;
			Assert.assertTrue("Decimal tax not applied successfully", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_108474 <b>Description : Buyer should be able to add compound taxes in
	 * Copy PO by clicking 'Add Compound Taxes' check box present after Tax
	 * Sub-Total </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108474(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108478"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108481"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108483"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108484"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108703"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108479"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108476"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108483"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108477"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			//StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			//standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnCopy(driver, testCaseName);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			String oldTaxAmount = PageStandardPO.getTotalTax(driver, testCaseName);
			// edit item
			PageStandardPO.clickOnAllItemLineCheckBox(driver, testCaseName);
			ActionBot.defaultSleep();
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			int quantity = 5;
			ModalItemSummaryItem.clearAndEnterQuantity(driver, testCaseName, quantity);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			// add compound tax
			boolean flag = PageStandardPO.isAddCompoundTaxOptionPresent(driver, testCaseName);
			Assert.assertTrue("No tax option is not applicable", flag);
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			// add compound tax
			int index1 = 4;
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index1);
			/*
			 * String taxName = CommonServices.getTestData(IConstantsData.TAX_NAME);
			 * PageStandardPO.enterTaxName(driver, testCaseName, taxName, index1);
			 * String taxRate2 = CommonServices.getTestData(IConstantsData.TAX_RATE);
			 * PageStandardPO.enterTaxRate(driver, testCaseName, Integer.parseInt(taxRate2), index1);
			 * PageStandardPO.clickOnTaxAmount(driver, testCaseName, index1);
			 */
			String newTotalTax = PageStandardPO.getTotalTax(driver, testCaseName);
			boolean bn = oldTaxAmount != newTotalTax ? true : false;
			Assert.assertTrue(bn);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			// add multiple simple tax
			int index3 = 2;
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index3);
			String freeTextSimpleTaxName = "testing";
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, freeTextSimpleTaxName, index3);
			int simpleTaxRate = 4;
			PageStandardPO.enterTaxRate(driver, testCaseName, simpleTaxRate, index3);
			PageStandardPO.clickOnTaxAmount(driver, testCaseName, index3);
			PageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index3);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			// remove simple tax
			int index4 = 2;
			PageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName, index4);
			// PageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName,
			// index4);
			String totalTax = PageStandardPO.getTotalTax(driver, testCaseName);
			boolean bl = newTotalTax != totalTax ? true : false;
			Assert.assertTrue(bl);
			mappedTestCases.get(0).setTestResult(flag);
			// add multiple compound tax as free text tax name
			int index2 = 4;
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index2);
			mappedTestCases.get(3).setTestResult(flag);
			index1 = 5;
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index1);
			/*
			 * String freeTextTaxName = CommonServices.getTestData(IConstantsData.TAX_NAME_SECOND);
			 * PageStandardPO.enterFreeTextTaxName(driver, testCaseName, freeTextTaxName, index1);
			 * int taxRate = 5;
			 * PageStandardPO.enterTaxRate(driver, testCaseName, taxRate, index1);
			 * PageStandardPO.clickOnTaxAmount(driver, testCaseName, index1);
			 */
			// input value in .XX format
			double taxRate1 = 0.55;
			// PageStandardPO.enterTaxRate(driver, testCaseName, taxRate1,
			// index1);
			PageStandardPO.enterDecimalFormatTaxRate(driver, testCaseName, index1, taxRate1);
			PageStandardPO.clickOnTaxAmount(driver, testCaseName, index1);
			String finalTax = PageStandardPO.getTotalTax(driver, testCaseName);
			boolean b2 = finalTax != totalTax ? true : false;
			Assert.assertTrue(".XX format Tax not allowed", b2);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(8).setTestResult(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_108499 <b>Description : Verify Working of compound tax check
	 * box.[Amend PO] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108499(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108504"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108505"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_109147"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108498"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108501"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108496"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108503"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108497"));
		}

		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		float totalAmountBeforeApplyingTax = 0;
		float totalAmountAfterApplyingTax = 0;
		boolean RTC_108499 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add compound tax
			boolean flag = PageStandardPO.isAddCompoundTaxOptionPresent(driver, testCaseName);
			Assert.assertTrue("Add compound tax option not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			mappedTestCases.get(7).setTestResult(flag);
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			int index1 = 4;
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index1);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Compound tax not applied", RTC_108499);
			// add multiple simple tax
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			int index2 = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Simple tax not applied", RTC_108499);
			PageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index2);
			// remove simple tax
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			PageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName, index2);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Simple tax not removed", RTC_108499);
			int index7 = 2;
			// add multiple compound tax as free text tax name
			int index3 = 4;
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index3);
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			int index14 = 5;
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index14);
			String freeTextTaxName = CommonServices.getTestData(IConstantsData.TAX_NAME_SECOND);
			PageStandardPO.enterFreeTextTaxName(driver, testCaseName, freeTextTaxName, index14);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Compound tax not applied", RTC_108499);
			// check for validation with 14 digit tax rate
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index14);
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			int index6 = 6;
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 2);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index6);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax == totalAmountBeforeApplyingTax;
			Assert.assertTrue("Zero Compound tax not applied", RTC_108499);
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 3);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index6);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Long Compound tax not applied", RTC_108499);
			// input value in .XX format
			totalAmountBeforeApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 4);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index6);
			totalAmountAfterApplyingTax = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replaceAll("USD", "").replace(",", ""));
			RTC_108499 = totalAmountAfterApplyingTax != totalAmountBeforeApplyingTax;
			Assert.assertTrue("Decimal Compound tax not applied", RTC_108499);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_107322 <b>Description : Error on modals should get reseted on closing
	 * it and should not affaect next item addition or editing. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107322(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			String supplierName = CommonServices.getTestData(IConstantsData.SUPPLIER_NAME);
			PageStandardPO.enterSupplierName(driver, supplierName);
			PageStandardPO.enterCurrencyType(driver, "USD");
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			// add different supplier item
			int index1 = 2;
			String otherSupplierName = CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME);
			PageStandardPO.enterSupplierName(driver, otherSupplierName);
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageStandardPO.enterInQuantity(driver, index1);
			PageStandardPO.clickOnAdd(driver, index1);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			int indexError = 2;

			String oldTaxAmount = PageStandardPO.getTotalTax(driver, testCaseName);
			// edit existing added item
			jsx.executeScript("window.scrollBy(0,550)", "");
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			// check for error while saving
			int quantity = 4;
			ModalItemSummaryItem.clearAndEnterQuantity(driver, testCaseName, quantity);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);

			glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			boolean bn = ModalPOFreeTextItemSummaryItem.isTabErrorPresent(driver, testCaseName, indexError);
			Assert.assertTrue("Error is present", !bn);

			// add simple tax
			int index2 = 2;
			ActionBot.scroll(driver, "500");
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			String simpleTaxAmount = PageStandardPO.getTotalTax(driver, testCaseName);
			boolean flag1 = oldTaxAmount != simpleTaxAmount ? true : false;
			Assert.assertTrue(flag1);

			// add compound tax
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,450)", "");
			int index3 = 4;
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index3);
			String compountTaxAmount = PageStandardPO.getTotalTax(driver, testCaseName);
			boolean flag2 = simpleTaxAmount != compountTaxAmount ? true : false;
			Assert.assertTrue(flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_107447 <b>Description : Item line number should be a non zero ,
	 * positive number. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107447(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_107447 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			// check line no for free text item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int lineNo = 0;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOFreeTextItemSummaryItem.clickOnShortDescTextBox(driver, testCaseName);
			RTC_107447 = ModalPOFreeTextItemSummaryItem.isLineNoErrorPresent(driver, testCaseName, index);
			Assert.assertTrue("Zero Line Number is allowed for free text item PO", RTC_107447);
			lineNo = -4;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOFreeTextItemSummaryItem.clickOnShortDescTextBox(driver, testCaseName);
			int enteredLineNumber = ModalPOFreeTextItemSummaryItem.getLineNo(driver, testCaseName);
			RTC_107447 = (enteredLineNumber != lineNo);
			Assert.assertTrue("Negative line number allowed for free text item PO", RTC_107447);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_107440 <b>Description : Catalog Item in PO : Check for mentioned
	 * scenario while adding catalog items in PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107440(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutoGenerateLineItemNumbersOnPO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			// add 1st item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			// String addItemsToPOfield = CommonServices.getTestData("laptop");
			PageStandardPO.fillAddItemsToPOField(driver, "laptop");
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			// add 2nd item
			int index1 = 2;
			PageStandardPO.enterInQuantity(driver, index1);
			PageStandardPO.clickOnAdd(driver, index1);
			// add 3rd item
			/*
			 * int index2 = 3; PageStandardPO.enterInQuantity(driver, index2);
			 * PageStandardPO.clickOnAdd(driver, index2);
			 */
			// jsx.executeScript("window.scrollBy(0,-650)", "");
			// add supplier
			String supplierName = CommonServices.getTestData(IConstantsData.SUPPLIER_NAME);
			PageStandardPO.enterSupplierName(driver, supplierName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			// again add the same 1st item
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName,
			// lineNo);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

			// add the 2nd item again
			PageStandardPO.enterInQuantity(driver, index1);
			PageStandardPO.clickOnAdd(driver, index1);

			// int lineNo = 2;

			// add the 3rd item again
			/*
			 * PageStandardPO.enterInQuantity(driver, index2);
			 * PageStandardPO.clickOnAdd(driver, index2);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
			 * testCaseName);
			 * ModalItemSummaryAccounting.clickOnAccounting(driver); String
			 * glType1 = CommonServices.getTestData(IConstantsData.GL_Type);
			 * ModalItemSummaryAccounting.fillGLType(driver, glType1);
			 * ModalItemSummaryAccounting.clickOnSave(driver);
			 */
			JavascriptExecutor jsx2 = (JavascriptExecutor) driver;
			jsx2.executeScript("window.scrollBy(0,450)", "");
			// check line nos
			int no1 = 1;
			int lineNo1 = PageStandardPO.getHeaderLineNo(driver, testCaseName, no1);
			boolean flag1 = lineNo1 == 1 ? true : false;
			Assert.assertTrue(flag1);
			int no2 = 2;
			int lineNo2 = PageStandardPO.getHeaderLineNo(driver, testCaseName, no2);
			boolean flag2 = lineNo2 == 2 ? true : false;
			Assert.assertTrue(flag2);
			int no3 = 3;
			int lineNo3 = PageStandardPO.getHeaderLineNo(driver, testCaseName, no3);
			boolean flag3 = lineNo3 == 3 ? true : false;
			Assert.assertTrue(flag3);
			/*
			 * int no4 = 4; int lineNo4 = PageStandardPO.getHeaderLineNo(driver,
			 * testCaseName, no4); boolean flag4 = lineNo4 == 4 ? true : false;
			 * Assert.assertTrue(flag4); int no5 = 5; int lineNo5 =
			 * PageStandardPO.getHeaderLineNo(driver, testCaseName, no5);
			 * boolean flag5 = lineNo5 == 5 ? true : false;
			 * Assert.assertTrue(flag5);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_124782 <b>Description : Check compund taxes behavior by selecting
	 * delivery address at which no taxes are applicable. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_124782(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			// change address
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnOtherAddressTextBox(driver, testCaseName);
			String otherAddress = "new delhi";
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, otherAddress);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			// String project = "PRJ1 : PoAutomation";
			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudget();
			// String project =
			// CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CPB.get("project"));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CPB.get("budget"));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			// PageStandardPO.clickOnYes(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// add item
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx1.executeScript("window.scrollBy(0,750)", "");
			// add compound tax
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index2 = 4;
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index2);
			String taxName = CommonServices.getTestData(IConstantsData.TAX_NAME);
			PageStandardPO.enterTaxName(driver, testCaseName, taxName, index2);
			String taxRate2 = CommonServices.getTestData(IConstantsData.TAX_RATE);
			// int taxRate2 = 5;
			PageStandardPO.enterTaxRate(driver, testCaseName, Integer.parseInt(taxRate2), index2);
			PageStandardPO.clickOnTaxAmount(driver, testCaseName, index2);
			/*
			 * Double totalTax =
			 * PageStandardPO.getTotalAmountWithoutSupplier(driver,
			 * testCaseName); boolean flag = totalTax != 0.0 ? true : false;
			 * Assert.assertTrue(flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_124865 <b>Description : PO - Check tax calculation for already
	 * applied taxes after item addition. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_124865(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		float itemTotalPrice = 0;
		float netPrice = 0;
		float taxRate = 0;
		boolean RTC_124865 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			// add compound tax
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index3 = 4;
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index3);
			String taxRate2 = CommonServices.getTestData(IConstantsData.TAX_RATE);
			taxRate = Float.parseFloat(taxRate2) * (float) 0.01;
			PageStandardPO.enterTaxRate(driver, testCaseName, Integer.parseInt(taxRate2), index3);
			/*
			 * Double compountTaxAmount =
			 * PageStandardPO.getTotalAmountWithoutSupplier(driver,
			 * testCaseName); boolean flag1 = compountTaxAmount == 0.0 ? true :
			 * false; Assert.assertTrue(flag1);
			 */
			// ADD item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			itemTotalPrice = Float.parseFloat(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			netPrice = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName));
			RTC_124865 = (netPrice == itemTotalPrice + itemTotalPrice * taxRate);
			Assert.assertTrue("Tax not applied to PO", RTC_124865);
			/*
			 * Double newTotalTax =
			 * PageStandardPO.getTotalAmountWithoutSupplier(driver,
			 * testCaseName); boolean flag = newTotalTax != 0.0 ? true : false;
			 * Assert.assertTrue(flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_25694 <b>Description : Tax Configuration based on county:All
	 * criterias for City & County should be applied for Address master also.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25694(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			// go on address setting
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnAddressLink(driver, testCaseName);
			PageAddressMasterDataSettings.clickOnAddAddress(driver, testCaseName);
			// check county and city field
			String city = CommonServices.getTestData(IConstantsData.CITY);
			PageAddressMasterDataSettings.enterCity(driver, testCaseName, city);
			String county = CommonServices.getTestData(IConstantsData.COUNTY);
			PageAddressMasterDataSettings.enterCounty(driver, testCaseName, county);
			String freeTextCounty = CommonServices.getTestData(IConstantsData.FREE_TEXT_CITY);
			PageAddressMasterDataSettings.enterFreeTextCounty(driver, testCaseName, freeTextCounty);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 05-Jan-2015 </b> <b>Method :
	 * RTC_25695 <b>Description : Tax Configuration based on county:All
	 * criterias for City & County should be applied for Custom shipping Address
	 * also. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25695(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			// go on delivery modal
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnCreateNewAddress(driver, testCaseName);
			// check county and address field
			String cityName = CommonServices.getTestData(IConstantsData.CITY);
			ModalPOSummaryDelivery.enterCityName(driver, testCaseName, cityName);
			String countyName = CommonServices.getTestData(IConstantsData.COUNTY);
			ModalPOSummaryDelivery.enterCountyName(driver, testCaseName, countyName);
			String freeTExtCountyName = CommonServices.getTestData(IConstantsData.FREE_TEXT_CITY);
			ModalPOSummaryDelivery.enterFreeTextCountyName(driver, testCaseName, freeTExtCountyName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 08-Jan-2015 </b> <b>Method :
	 * RTC_107427 <b>Description : All the information mentioned by user before
	 * adding or updating a item on modal should get saved and should be
	 * retained on next edit. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107427(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			// ADD ITEM
			// PageStandardPO.clickOnAddItem(driver);
			// PageStandardPO.clickOnFreeTextItem(driver);
			// FILL FREE TEXT ITEM SUMMARY MODAL
			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			List<GuidedItem> guidedItemsList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemsList.get(0);
			guidedItem.setNextAction(IConstantsData.SAVE);
			item = FlowStandardPo.addItem(driver, testCaseName, item);
			// EDIT ITEM
			// String id = PageStandardPO.getItemId(driver, guidedItem.);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, guidedItem.getItemID());
			// CHECK ALL FILLED FIELDS
			boolean flag = ModalPOFreeTextItemSummaryItem.isShortDescFieldFilled(driver, testCaseName);
			Assert.assertTrue(flag);
			boolean flag1 = ModalPOFreeTextItemSummaryItem.isProductCategoryFieldFilled(driver, testCaseName);
			Assert.assertTrue(flag1);
			boolean flag2 = ModalPOFreeTextItemSummaryItem.isMarketPriceFieldFilled(driver, testCaseName);
			Assert.assertTrue(flag2);
			boolean flag3 = ModalPOFreeTextItemSummaryItem.isQuantityFieldFilled(driver, testCaseName);
			Assert.assertTrue(flag3);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			// boolean flag4 =
			// ModalPOFreeTextItemSummaryAccounting.isGLTypeFieldFilled(driver,
			// testCaseName);
			// Assert.assertTrue(flag4);
			boolean flag5 = ModalPOFreeTextItemSummaryCostAllocation.isGLAccountFieldFilled(driver, testCaseName);
			Assert.assertTrue(flag5);
			// ADD COMMENTS
			ModalPOFreeTextItemSummaryAttachmentsAndComments.clickOnAttachmentsAndComments(driver, testCaseName);
			String inetrnalComments = CommonServices.getTestData(IConstantsData.INTERNAL_COMMENTS_PO);
			ModalPOFreeTextItemSummaryAttachmentsAndComments.enterInternalComments(driver, testCaseName, inetrnalComments);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 08-Jan-2015 </b> <b>Method :
	 * RTC_107323 <b>Description : Verify Allow creating a free text zero price
	 * item in manual PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107323(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_107330"));
			}

			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.getItems().getGuidedItems().get(0).setZeroPriceItem(true);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardpo.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 900);
			ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			standardpo.setPoNumber(FlowStandardPo.submitPoForProcessing(driver, testCaseName));
			String poNo = PageViewPurchaseOrder.getPONo(driver, testCaseName);
			flag = poNo.equalsIgnoreCase(standardpo.getPoNumber()) ? true : false;
			Assert.assertTrue("Zero price item has not been submitted successfully", flag);
			flag = FlowPoListing.searchPo(driver, testCaseName, standardpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Po with zero price item is not created", flag);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "600");
			String itemSubTotal = PageViewPurchaseOrder.getItemSubTotal(driver, testCaseName).split("\\ ")[1].split("\\.")[0];
			flag = Integer.parseInt(itemSubTotal) == 0;
			mappedTestCases.get(0).setTestResult(flag);
			Assert.assertTrue("Item sub total is not zero", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jan-2015 </b> <b>Method :
	 * RTC_107309 <b>Description : Verify Compound Tax calculation should be
	 * performed on PO item sub-Total- Discount amount + taxes at header and
	 * item level. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107309(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 2;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			CommonUtilities.getDecimalPrice(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			jsx1.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 30;
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			CommonUtilities.getDecimalPrice(PageStandardPO.getTotalDiscountAmount(driver, testCaseName));
			CommonUtilities.getDecimalPrice(PageStandardPO.getSimpleTaxAmount(driver, testCaseName, index));
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			// int index3 = 5;

			// CommonUtilities.getDecimalPrice(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver,
			// testCaseName,
			// index3));
			// boolean flag = amount2 == Integer.parseInt(totalAmount) ? true :
			// false;
			// Assert.assertTrue("compound tax total is not the combination of
			// above totals",
			// flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jan-2015 </b> <b>Method :
	 * RTC_108500 <b>Description : Verify Compound Tax calculation should be
	 * performed on PO item sub-Total- Discount amount + taxes at header and
	 * item level..[Amend PO] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108500(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 30;
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			int index = 2;
			CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalDiscountAmount(driver, testCaseName));
			CommonUtilities.getDecimalPrice(PageStandardPO.getSimpleTaxAmount(driver, testCaseName, index));
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jan-2015 </b> <b>Method :
	 * RTC_108480 <b>Description : Verify Compound Tax calculation should be
	 * performed on PO item sub-Total- Discount amount + taxes at header and
	 * item level..[Copy PO] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @param totalPriceBeforeDiscount
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108480(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		float priceBeforeCompoundTaxApplied = 0;
		float totalDiscount = 0;
		float totalPrice = 0;
		float totalPriceBeforeDiscount = 0;
		float totalAmountBeforeCompoundTax = 0;
		float totalCompoundTaxAmount = 0;
		boolean RTC_108480 = false;
		int index = 2;
		int index2 = 2;
		int index3 = 4;
		int index4 = 2;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 2);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			totalPriceBeforeDiscount = Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getItemNetPrice(driver, testCaseName)));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnDiscountOnEntireOrder(driver, testCaseName);
			int discount = 30;
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			totalDiscount = Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalDiscountAmount(driver, testCaseName)));
			totalPrice = Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getItemNetPrice(driver, testCaseName)));
			RTC_108480 = (totalPrice == totalPriceBeforeDiscount - totalDiscount);
			Assert.assertTrue("Discount not applied correctly", RTC_108480);
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			priceBeforeCompoundTaxApplied = Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getItemNetPrice(driver, testCaseName)));
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index3);
			String taxRate2 = PageStandardPO.getTaxRateIndexWise(driver, testCaseName, 2);
			totalAmountBeforeCompoundTax = Float
				.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index4)));
			totalCompoundTaxAmount = Float.parseFloat(CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getSubTotalTax(driver, testCaseName)));
			RTC_108480 = (totalCompoundTaxAmount == Math.round(totalAmountBeforeCompoundTax * 0.01 * Float.parseFloat(taxRate2)));
			Assert.assertTrue("Invalid Compound Tax calculation", RTC_108480);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jan-2015 </b> <b>Method :
	 * RTC_108482 <b>Description : Verify Compound tax should be calculated on
	 * every Sub Total. After every compound tax; insert a row to show Sub Total
	 * (comprising of previous sub total + compound tax amount).[Copy PO]
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108482(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		float itemSubTotalBeforeApplyingCompoundTax = 0;
		float itemSubTotalAfterApplyingCompoundTax = 0;
		boolean RTC_108482 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,450)", "");
			int index = 4;
			String tmp = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index)).replace("USD", "");
			itemSubTotalBeforeApplyingCompoundTax = Float.parseFloat(tmp);
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index);
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index);
			int index2 = 5;
			tmp = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index2)).replace("USD", "");
			itemSubTotalAfterApplyingCompoundTax = Float.parseFloat(tmp);
			int taxRate = Integer.parseInt(PageStandardPO.getTaxRateIndexWise(driver, testCaseName, 2));
			RTC_108482 = (itemSubTotalAfterApplyingCompoundTax == itemSubTotalBeforeApplyingCompoundTax + 0.01 * taxRate * itemSubTotalBeforeApplyingCompoundTax);
			Assert.assertTrue("Compound tax not applied on previous sub total", RTC_108482);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Jan-2015 </b> <b>Method :
	 * RTC_108502 <b>Description : Verify Compound tax should be calculated on
	 * every Sub Total. After every compound tax; insert a row to show Sub Total
	 * (comprising of previous sub total + compound tax amount).[Amend PO]
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108502(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		float itemSubTotalBeforeApplyingCompoundTax = 0;
		float itemSubTotalAfterApplyingCompoundTax = 0;
		boolean RTC_108502 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index1 = 4;
			itemSubTotalBeforeApplyingCompoundTax = Float.parseFloat(
				CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index1)).replace("USD", ""));
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			PageStandardPO.selectTaxType(driver, testCaseName, taxType, index1);
			PageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index1);
			int index2 = 5;
			itemSubTotalAfterApplyingCompoundTax = Float.parseFloat(
				CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index2)).replace("USD", ""));
			int taxRate = Integer.parseInt(PageStandardPO.getTaxRateIndexWise(driver, testCaseName, 2));
			RTC_108502 = (itemSubTotalAfterApplyingCompoundTax == itemSubTotalBeforeApplyingCompoundTax + 0.01 * taxRate * itemSubTotalBeforeApplyingCompoundTax);
			Assert.assertTrue("Compound tax not applied on previous sub total", RTC_108502);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jan-2015 </b> <b>Method :
	 * RTC_107553 <b>Description : Verify Add a field "Default Buyer" in
	 * configuration -> Company | Business Unit | Location level settings, value
	 * can be any company user coming from TMS </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107553(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnProfileTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnConfigurationTab(driver, testCaseName);
			PageConfigurationSetting.clickOnCompany(driver, testCaseName);
			String companyName = CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME);
			PageConfigurationSetting.selectCompanyName(driver, testCaseName, companyName);
			String defaultBuyer = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			PageConfigurationSetting.enterDefaultBuyerForCompany(driver, testCaseName, defaultBuyer);
			PageConfigurationSetting.clickOnUpdateCompany(driver, testCaseName);
			PageConfigurationSetting.clickOnBusinessUnit(driver, testCaseName);
			String companyForBU = CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME);
			PageConfigurationSetting.selectCompanyForBU(driver, testCaseName, companyForBU);
			String BU = CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME);
			PageConfigurationSetting.selectBU(driver, testCaseName, BU);
			String BUBuyer = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			PageConfigurationSetting.enterDefaultBuyerForBU(driver, testCaseName, BUBuyer);
			PageConfigurationSetting.clickOnUpdateBU(driver, testCaseName);
			PageConfigurationSetting.clickOnLocation(driver, testCaseName);
			String companyForLocation = CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME);
			PageConfigurationSetting.selectCompanyForLocation(driver, testCaseName, companyForLocation);
			String BUForLocation = CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME);
			PageConfigurationSetting.selectBUForLocation(driver, testCaseName, BUForLocation);
			String location = CommonServices.getTestData(IConstantsData.LOCATION_NAME);
			PageConfigurationSetting.selectLocation(driver, testCaseName, location);
			String LocationBuyer = CommonServices.getTestData(IConstantsData.BUYER_NAME);
			PageConfigurationSetting.enterDefaultBuyerForLocation(driver, testCaseName, LocationBuyer);
			PageConfigurationSetting.clickOnUpdateLocation(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jan-2015 </b> <b>Method :
	 * RTC_108234 <b>Description : Item quantity should get updated when same
	 * verion of item is added to copied PO and new item should be added if new
	 * version of item is added. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_108234(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_108136"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			/*
			 * PagePurchaseOrderListing.clickOnFilterStatusLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver,
			 * testCaseName); PagePurchaseOrderListing.clickOnFilterLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderListing.clickOnActionsDropdownLink(driver,
			 * testCaseName, 1);
			 */
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			// PagePO.clickOnCopy(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			ActionBot.defaultSleep();
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			String itemNo = standardPO.getItems().getCatelogItems().get(0).getItemName();
			// String id = PageStandardPO.getItemId(driver, itemNo);
			int oldQuantity = PageStandardPO.getOrderedQuantityTotal(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			// String addItemsToPOfield =
			// CommonServices.getTestData(IConstantsData.SEARCH_FOR);
			PageStandardPO.fillAddItemsToPOField(driver, itemNo);
			PageStandardPO.clickOnSearch(driver);
			int quantity = 1;
			PageStandardPO.enterQuantityOfItem(driver, testCaseName, quantity);
			PageStandardPO.clickOnAddItemInPO(driver, testCaseName);
			int newQuantity = PageStandardPO.getOrderedQuantityTotal(driver, testCaseName);
			boolean flag = newQuantity != oldQuantity ? true : false;
			Assert.assertTrue("Quantity has not been updated with addition of same item again", flag);
			mappedTestCases.get(0).setTestResult(flag);
			// PageStandardPO.clickOnAddItem(driver);
			// PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 0);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			List<WebElement> elements = PageStandardPO.getListOfItems(driver, testCaseName);
			for (WebElement element : elements)
			{
				if (element.getText().equalsIgnoreCase(addItemsToPOfield))
				{
					flag = true;
					break;
				}
			}
			Assert.assertTrue("New item not added to PO", flag);
			//PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			int lineNo = 6;
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jan-2015 </b> <b>Method :
	 * RTC_134697 <b>Description : PO listing &gt;&gt; User should be able to
	 * filter PO by selected Type in Type filter - Standard, Release, Blanket
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134697(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_198432"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleaseFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleaseFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnBlanketFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			int index = 4;
			PagePurchaseOrderListing.clickOnClearFilter(driver, testCaseName, index);
			PagePurchaseOrderListing.clickOnDateFilterStatus(driver, testCaseName);
			boolean flag = PagePurchaseOrderListing.isFilterDateButtonPresent(driver, testCaseName);
			Assert.assertTrue("Dropdown for date filter is not working in mozilla browser", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PagePurchaseOrderListing.clickOnFilterDateButtom(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jan-2015 </b> <b>Method :
	 * RTC_109211 <b>Description : Verify if there is no delivery date is
	 * provided then there should be any entry in delivery tab. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_109211(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_219072"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_63513"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_63514"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);

			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowManualOrdersReleasedWithoutDeliveryDate_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setCustomDate(null);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			boolean flag = PageViewPurchaseOrder.isDateNotAppliedSpecified(driver, testCaseName);
			Assert.assertTrue("Date is specified", flag);
			boolean flag1 = PageViewPurchaseOrder.isPlannedDeliveryDateBlank(driver, testCaseName);
			Assert.assertTrue("Planned Delivery date is not blank", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			mappedTestCases.get(2).setTestResult(flag1);
			PageViewPurchaseOrder.clickOnTermsAndNotesLink(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jan-2015 </b> <b>Method :
	 * RTC_134776 <b>Description : PO listing >> Distinct currencies from All
	 * POs should be displayed in Amount range filter with check box present for
	 * every currency. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134776(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnINRCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnINRCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnUSDCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jan-2015 </b> <b>Method :
	 * RTC_134966 <b>Description : PO listing >> When user click on Create
	 * Receipt option of PO from tool tip OR status flag OR action click,
	 * Receipt creation page should get open. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134966(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);

			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnCreateReceipt(driver, testCaseName);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			// boolean flag = poNo == po ? true : false;
			// Assert.assertTrue("PO Number is different in view PO", flag);
			boolean flag1 = PageViewPurchaseOrder.isReceiptPagePresent(driver, testCaseName);
			Assert.assertTrue("Receipt page is not present", flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jan-2015 </b> <b>Method :
	 * RTC_134967 <b>Description : PO listing >> When user click on Create
	 * Invoice option of PO from tool tip OR status flag OR action click,
	 * Invoice creation page should get open. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134967(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_134967 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			String poNumber = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnCreateInvoice(driver, testCaseName);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			RTC_134967 = PageCreateNonPOInvoice.getPONumber(driver, testCaseName).equalsIgnoreCase(poNumber);
			Assert.assertTrue("Invoice Page not opened", RTC_134967);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jan-2015 </b> <b>Method :
	 * RTC_134969 <b>Description : PO listing >> When user click on Delete
	 * option of draft PO from tool tip OR status flag OR action click,
	 * confirmation POPUP should get open. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134969(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_134972"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			// String poNumber =
			// CommonServices.getTestData(IConstantsData.DRAFT_PO_NUMBER);
			// PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnDelete(driver, testCaseName);
			ModalPOActions.clickOnDeleteFromActions(driver, testCaseName);
			boolean flag = PopUpDeleteConfirmation.isDeleteConfirmationMessagePresent(driver, testCaseName);
			Assert.assertTrue("Delete confirmation msg is not present", flag);
			PopUpDeleteConfirmation.clickOnPODeleteNO(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnClosePO(driver, testCaseName);
			ModalPOActions.clickOnClosePOFromActions(driver, testCaseName);
			boolean flag1 = PagePurchaseOrderListing.isCommentBoxPresent(driver, testCaseName);
			mappedTestCases.get(0).setTestResult(flag1);
			Assert.assertTrue("Comment box is not present while closing PO", flag1);
			boolean flag2 = PagePurchaseOrderListing.isAllowCreatingInvoiceOptionPrsent(driver, testCaseName);
			mappedTestCases.get(0).setTestResult(flag2);
			Assert.assertTrue("Allow creating checkbox is not present while closing PO", flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jan-2015 </b> <b>Method :
	 * RTC_134976 <b>Description : PO listing >> When user click on Download
	 * option of Released PO from tool tip , Download PDF window should get
	 * open. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134976(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			// PagePO.hoverOnPONumber(driver, testCaseName);
			// PagePurchaseOrderListing.hoverOnPONumber(driver, testCaseName);
			// PagePurchaseOrderListing.clickOnDownloadPO(driver, testCaseName);
			// PagePurchaseOrderListing.clickOnDownloadPOLinkFromTooltip(driver,
			// testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnDownloadFromActions(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Download window is opened successfully");
			driver.switchTo().window(winHandlerBefore);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Jan-2015 </b> <b>Method :
	 * RTC_134977 <b>Description : PO listing >> When user click on Amend PO
	 * option of Expire PO from tool tip , Amend Creation screen should get
	 * open. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134977(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpiredStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			// boolean flag = poNo == no ? true : false;
			// Assert.assertTrue(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Jan-2015 </b> <b>Method :
	 * RTC_134998 <b>Description : PO listing >> There should be Lebel on screen
	 * showing the No. of records. Line should be - ("Found XXX records", On
	 * filter "Found YYY out of XXX records) </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134998(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_38344"));
		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.isNoOfRecordsBeforeFilterPresent(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			boolean flag = PagePurchaseOrderListing.isNoOfRecordsAfterFilterPresent(driver, testCaseName);
			Assert.assertTrue("No of records label didnt changed after applying filter", flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 27-Jan-2015 </b> <b>Method :
	 * RTC_135070 <b>Description : As a buyer, User should be able to specify
	 * taxes for individual line items. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_135070(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139247"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139248"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139249"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139250"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139251"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139252"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139253"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139254"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139255"));
		mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139256"));
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);

			//fill item level tax
			String taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 0);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, taxType);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME));
			ModalItemSummaryTax.clickOnTaxRate(driver, testCaseName);
			boolean error1 = ModalItemSummaryTax.isErrorOnItemlevelTaxPresent(driver, testCaseName);
			Assert.assertTrue("Error is present", !error1);

			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			String TaxName = CommonServices.getTestData(IConstantsData.TAX_NAME);
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, TaxName);

			//fill long tax
			taxType = CommonServices.getTestData(IConstantsData.TAX_TYPE, 3);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, taxType);
			error1 = ModalItemSummaryTax.isErrorOnItemlevelTaxPresent(driver, testCaseName);
			Assert.assertTrue("Error is present", !error1);

			//fill tax amount
			ModalItemSummaryTax.clearTaxRate(driver, testCaseName);
			String taxAmount = "123456789";
			ModalItemSummaryTax.fillTaxAmount(driver, testCaseName, taxAmount);

			ModalItemSummaryTax.clickOnAddNewTaxbtn(driver, testCaseName, 2);
			ModalItemSummaryTax.clickOnRemoveTaxItemLevel(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,650)", "");

			boolean type = PageStandardPO.isTaxTypeFieldHeadingPresent(driver, testCaseName, index);
			Assert.assertTrue("Tax type heading is not present", type);
			mappedTestCases.get(0).setTestResult(type);
			mappedTestCases.get(1).setTestResult(type);
			mappedTestCases.get(2).setTestResult(type);
			boolean taxname = PageStandardPO.isTaxNameFieldHeadingPresent(driver, testCaseName, index);
			Assert.assertTrue("Tax name heading is not present", taxname);
			mappedTestCases.get(3).setTestResult(taxname);
			mappedTestCases.get(4).setTestResult(taxname);
			boolean rate = PageStandardPO.isTaxRateFieldHeadingPresent(driver, testCaseName, index);
			Assert.assertTrue("Tax rate heading is not present", rate);
			mappedTestCases.get(8).setTestResult(rate);
			mappedTestCases.get(9).setTestResult(rate);
			boolean amount = PageStandardPO.isTaxAmountFieldHeadingPresent(driver, testCaseName, index);
			Assert.assertTrue("Tax amount heading is not present", amount);
			mappedTestCases.get(6).setTestResult(amount);
			mappedTestCases.get(5).setTestResult(amount);
			mappedTestCases.get(7).setTestResult(amount);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 28-Jan-2015 </b> <b>Method :
	 * RTC_139257 <b>Description : In Create Standard PO; Taxes section should
	 * display the Taxes Sub-total on bottom of the grid & user can change any
	 * value from any row & this total should update based on the changes.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139257(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			ModalItemSummaryTax.fillTaxRate(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_RATE));
			ModalItemSummaryTax.clickOnAddNewTaxbtn(driver, testCaseName, 2);
			int index1 = 3;
			ModalItemSummaryTax.selectNextRowTaxTye(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index1);
			String taxRate = "2";
			ModalItemSummaryTax.enterNextRowTaxRate(driver, testCaseName, taxRate, index1);
			ModalItemSummaryTax.clickOnNextRowTaxAmount(driver, testCaseName, index1);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,650)", "");
			String ItemTax = PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.clickOnRemoveTaxItemLevel(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,650)", "");
			String NewTax = PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			boolean flag = NewTax != ItemTax ? true : false;
			Assert.assertTrue("Total Tax didnt changed with addition and removal of taxes", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 28-Jan-2015 </b> <b>Method :
	 * RTC_139272 <b>Description : In Create Standard PO;User should be able to
	 * select multiple items; and 'Apply tax' or 'Remove all taxes' for selected
	 * items at once having option of 'Options: Apply where applicable & not
	 * defined; Apply where not applicable; Override where defined (1st option
	 * checked by default)' </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139272(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139273"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139274"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139280"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			int index1 = 2;
			/*
			 * PageStandardPO.enterInQuantity(driver, index1);
			 * PageStandardPO.clickOnAdd(driver, index1);
			 */
			String itemID = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnCheckBoxOfItem(driver, testCaseName, itemID);
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, Integer.parseInt(CommonServices.getTestData(IConstantsData.TAX_RATE)));
			ModalUpdateAllLinesPO.isRemoveAllMultipleTaxesPresent(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			ActionBot.defaultSleep();
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME), 2);
			int TaxRate = 8;
			ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, TaxRate);
			ModalUpdateAllLinesPO.clickOnRadioButtonTaxNotApplicable(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			// jsx.executeScript("window.scrollBy(0,450)", "");
			String NotApplicable = PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			// boolean flag = NotApplicable == taxApplicable ? true : false;
			// Assert.assertTrue(flag);
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			int taxRate = 0;
			ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, taxRate);
			ModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			boolean error = ModalUpdateAllLinesPO.isErrorPresent(driver, testCaseName);
			Assert.assertTrue("Error is not present", !error);
			mappedTestCases.get(0).setTestResult(!error);
			mappedTestCases.get(1).setTestResult(!error);
			mappedTestCases.get(2).setTestResult(!error);
			/*
			 * ModalUpdateAllLinesPO.hoverOnErrorIcon(driver, testCaseName);
			 * String rate = "1234567";
			 * ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName,
			 * Integer.parseInt(rate)); boolean add =
			 * ModalUpdateAllLinesPO.isAddTaxButtonPresent(driver,
			 * testCaseName); Assert.assertTrue(add);
			 * mappedTestCases.get(1).setTestResult(add);
			 * ModalUpdateAllLinesPO.clickOnAddTax(driver, testCaseName);
			 * boolean remove =
			 * ModalUpdateAllLinesPO.isRemoveTaxButtonPresent(driver,
			 * testCaseName); Assert.assertTrue(remove);
			 * mappedTestCases.get(1).setTestResult(remove);
			 * ModalUpdateAllLinesPO.clickOnRemoveTax(driver, testCaseName);
			 * ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName); //
			 * jsx.executeScript("window.scrollBy(0,450)", ""); String
			 * OverrideWhereDefined =
			 * PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			 * boolean flag1 = OverrideWhereDefined != NotApplicable ? true :
			 * false; Assert.assertTrue(flag1);
			 * PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			 * ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			 * ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			 * ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName,
			 * Integer.parseInt(CommonServices.getTestData(IConstantsData.
			 * TAX_RATE)));
			 * ModalUpdateAllLinesPO.clickOnRemoveAllMultipleTaxes(driver,
			 * testCaseName); String total =
			 * PageStandardPO.getItemLevelTotalTax(driver, testCaseName);
			 * boolean zero = Double.parseDouble(total) == 0.0 ? true : false;
			 * Assert.assertTrue("Item level total tax is not zero", zero);
			 * mappedTestCases.get(2).setTestResult(zero);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jan-2015 </b> <b>Method :
	 * RTC_139276 <b>Description : In Create Standard PO; Special Characters
	 * should be handled in Modal of Change multiple, taxes, Discount </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139276(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139278"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,350)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			// add taxes at item level
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);

			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR));
			ModalItemSummaryTax.clickOnAddNewTaxbtn(driver, testCaseName, 2);
			int index1 = 3;
			ModalItemSummaryTax.selectNextRowTaxTye(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 3), index1);
			ModalItemSummaryTax.enterNextRowTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR), index1);
			String taxRate = "2";
			ModalItemSummaryTax.enterNextRowTaxRate(driver, testCaseName, taxRate, index1);
			ModalItemSummaryTax.clickOnNextRowTaxAmount(driver, testCaseName, index1);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			// add 2nd item
			int index2 = 2;
			PageStandardPO.enterInQuantity(driver, index2);
			PageStandardPO.clickOnAdd(driver, index2);
			PageStandardPO.clickOnCheckBoxOfItem(driver, testCaseName, id);
			// fill in update all lines taxes
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 3), index2);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR), index2);
			ModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 2), 2);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR), 2);
			ModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			// fill header level taxes
			int index3 = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), index3);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR), index3);
			PageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index3);
			int index4 = 3;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 4), index4);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR), index4);
			boolean flag = PageStandardPO.isAddCompoundTaxOptionPresent(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jan-2015 </b> <b>Method :
	 * RTC_139282 <b>Description : In Create Standard PO;For an item; display
	 * all taxes at line-level in grid; with a label denoting the no. of taxes
	 * inherited from header-Format: 'plus X taxes from the header' at the
	 * bottom </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139282(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139283"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			int index1 = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), index1);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			// add taxes at item level
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 4));
			boolean itemLevel = ModalItemSummaryTax.isLabelPlusXTaxesFromTheHeaderDisplayed(driver, testCaseName);
			Assert.assertTrue(itemLevel);
			boolean itemLabel = ModalItemSummaryTax.isPlusXTaxesFromTheHeaderALabel(driver, testCaseName);
			Assert.assertTrue(itemLabel);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,450)", "");
			boolean headerLevel = PageStandardPO.isPlusSpecificTaxesOnXLineItemsPresent(driver, testCaseName);
			Assert.assertTrue(headerLevel);
			mappedTestCases.get(0).setTestResult(headerLevel);
			boolean headerLabel = PageStandardPO.isPlusSpecificTaxesOnXLineItemsALabel(driver, testCaseName);
			Assert.assertTrue(headerLabel);
			mappedTestCases.get(0).setTestResult(headerLabel);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jan-2015 </b> <b>Method :
	 * RTC_139284 <b>Description : In Create Standard PO;discount should be
	 * specified for each line or at header & if taxes defined at item level
	 * then header level discount should not allowed. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139284(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,650)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = "laptop";
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			ActionBot.scroll(driver, "400");
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,450)", "");

			int discount = (int) Float.parseFloat(ModalDiscountPO.getTotalPoAmount(driver, testCaseName));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			// fill discount percentage
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			int value = 5;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			// fill discount amount
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			String type = "Amount";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type);
			int value1 = 50;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value1);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			// fill discount per item
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			String type1 = "per item";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type1);
			int value2 = 50;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value2);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.getItemLevelTotalDiscountAmount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			jsx.executeScript("window.scrollBy(450,0)", "");
			PageStandardPO.clickOnCheckBoxOfItem(driver, testCaseName, id);
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			ModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			ModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, Integer.parseInt(CommonServices.getTestData(IConstantsData.TAX_RATE)));
			ModalUpdateAllLinesPO.clickOnApplyWhereApplicableAndNotDefined(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			boolean flag = ModalDiscountPO.isAlertInDiscountPresent(driver, testCaseName);
			Assert.assertTrue("Alert is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jan-2015 </b> <b>Method :
	 * RTC_139285 <b>Description : In Create Standard PO;Header level discount
	 * should not be more than item sub total & validations should be present.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139285(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139286"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 123456789;
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag = ModalDiscountPO.isHeaderLevelDiscountErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag);
			// boolean flag1 =
			// ModalDiscountPO.isHeaderLevelDiscountErrorMessageDisplayed(driver,
			// testCaseName);
			// Assert.assertTrue(flag1);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag2 = ModalDiscountPO.isItemLevelErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag2);
			mappedTestCases.get(0).setTestResult(flag2);
			String type = "Amount";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type);
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag3 = ModalDiscountPO.isItemLevelErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag3);
			mappedTestCases.get(0).setTestResult(flag3);
			String type1 = "per item";
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, type1);
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag4 = ModalDiscountPO.isItemLevelErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag4);
			ModalDiscountPO.fillApplyToAllDiscount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag5 = ModalDiscountPO.isApplyToAllErrorPresent(driver, testCaseName);
			Assert.assertTrue(flag5);
			mappedTestCases.get(0).setTestResult(flag5);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jan-2015 </b> <b>Method :
	 * RTC_139296 <b>Description : In Create Standard PO;Discount should be
	 * displayed as label with a note below stating 'on the item sub-total'
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139296(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139300"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			int discount = 20;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag = PageStandardPO.isLabelTotalDiscountOnItemSubTotalPresent(driver, testCaseName);
			Assert.assertTrue(flag);
			String marketPrice = CommonUtilities.getDecimalPrice(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			String discountPrice = CommonUtilities.getDecimalPrice(PageStandardPO.getTotalDiscountAmount(driver, testCaseName));
			int index1 = 2;
			String unitPrce = CommonUtilities.getDecimalPrice(PageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index1));
			boolean price = Integer.parseInt(marketPrice) - Integer.parseInt(discountPrice) == Integer.parseInt(unitPrce) ? true : false;
			Assert.assertTrue("Unit price is not equal to market price subtracted discount", price);
			mappedTestCases.get(0).setTestResult(price);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_139297 <b>Description : In Create Standard PO;A Combination of Tax
	 * Type & Name should only be specified once: i.e. either on header or line.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139297(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,900)", "");
			// add tax at header level
			int index1 = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), index1);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			// add taxes at item level
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			boolean error = ModalItemSummaryTax.isErrorOnItemlevelTaxPresent(driver, testCaseName);
			Assert.assertTrue("duplicate tax type and tax name combination is allowed", error);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_139298 <b>Description : In Create Standard PO;User should be able to
	 * enter tax amount that will be automatically converted to rate for simple
	 * tax at line; and for simple & compound tax at header. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139298(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_139298 = false;
		float totalTaxBeforeApplyingTax = 0;
		float totalTaxAfterApplyingTax = 0;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,900)", "");
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			// add tax at header level
			int index1 = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 1), index1);
			String simpleTaxName = "sales";
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, simpleTaxName, index1);
			int taxAmount = 400;
			PageStandardPO.enterTaxAmount(driver, testCaseName, index1, taxAmount);
			PageStandardPO.clickOnTaxRate(driver, testCaseName, index1);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			RTC_139298 = totalTaxBeforeApplyingTax != totalTaxAfterApplyingTax;
			Assert.assertTrue("Simple tax not applied", RTC_139298);
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName));
			int index2 = 4;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 1), index2);
			String compoundTaxName = "testing";
			PageStandardPO.enterTaxName(driver, testCaseName, compoundTaxName, 2);
			int taxAmount1 = 600;
			PageStandardPO.enterTaxAmount(driver, testCaseName, index2, taxAmount1);
			PageStandardPO.clickOnTaxRate(driver, testCaseName, index2);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			RTC_139298 = totalTaxBeforeApplyingTax != totalTaxAfterApplyingTax;
			Assert.assertTrue("Compound tax not applied", RTC_139298);
			totalTaxBeforeApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			// add taxes at item level
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			String tax = "test1";
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, tax);
			String taxAmount2 = "700";
			ModalItemSummaryTax.fillTaxAmount(driver, testCaseName, taxAmount2);
			ModalItemSummaryTax.clickOnTaxRate(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			totalTaxAfterApplyingTax = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", ""));
			RTC_139298 = totalTaxBeforeApplyingTax != totalTaxAfterApplyingTax;
			Assert.assertTrue("Item level tax not applied", RTC_139298);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_134687 <b>Description : PO listing &gt;&gt; User should be able to
	 * view PO date of each PO which is released. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134687(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			boolean date = PageViewPurchaseOrder.isPlannedDeliveryDatePresent(driver, testCaseName);
			Assert.assertTrue("PO Date is not present on view PO page", date);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_107417 <b>Description : Verify that User should be able to view item
	 * details of catalog item in a pop-up on click of item name on PO view.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107417(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			// standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			PageViewPurchaseOrder.getItemName(driver, testCaseName);
			PageViewPurchaseOrder.clickOnItemName(driver, testCaseName);
			PageViewPurchaseOrder.getItemTitle(driver, testCaseName);
			// Assert.assertTrue(flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_107418 <b>Description : Verify that User should be able to view item
	 * details of Free text item in a pop-up on click of item name on PO view.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107418(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			// jsx1.executeScript("window.scrollBy(0,750)", "");
			String itemName = PageViewPurchaseOrder.getItemName(driver, testCaseName);
			PageViewPurchaseOrder.clickOnItemName(driver, testCaseName);
			String itemTitle = PageViewPurchaseOrder.getItemTitle(driver, testCaseName);
			boolean flag = itemTitle.equals(itemName) ? true : false;
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2015 </b> <b>Method :
	 * RTC_63252 <b>Description : Test for bug 194465 - Supplier currency going
	 * blank when editable made false from settings, leading error 500 </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_63252(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierCurrencyOnPO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 04-Feb-2015 </b> <b>Method :
	 * RTC_63245 <b>Description : Test for bug 194447 - Unable to submit a PO
	 * though delivery term is selected , when allow to edit delivery term is
	 * false. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_63245(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierDeliveryTermsOnPO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 06-Feb-2015 </b> <b>Method :
	 * RTC_146205 <b>Description : PO - Listing &gt;&gt; When user click on
	 * Recall Approval Request from tool tip OR status flag OR action click; PO
	 * should get recall and open in draft mode. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_146205(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			FlowPoListing.recallApprovalRequestForPurchaseOrder(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnClearFilter(driver, testCaseName, index);
			FlowPoListing.checkIfPORecalled(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 06-Feb-2015 </b> <b>Method :
	 * RTC_147516 <b>Description : PO >> Setting should be present in customize
	 * >> configuration >> purchase order >> Standard PO as "Require approval
	 * when amended PO total exceeds the smaller|larger of X% or Y units
	 * compared to the previous approved version" </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_147516(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_147518"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,950)", "");
			boolean flag = PagePurchaseOrderSetting.isRequiredPOApprovalWhenPOTotalExceedsCertainAmountOrPercentagePresent(driver, testCaseName);
			Assert.assertTrue("Required PO approval when PO total exceeds certain amount setting is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PagePurchaseOrderSetting.clickOnRequiredPOApprovalWhenPOTotalExceedsLarger(driver, testCaseName);
			int exceedUnitPricePer = 20;
			PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePer(driver, testCaseName, exceedUnitPricePer);
			int exceedUnitPricePerAmount = 50;
			PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(driver, testCaseName, exceedUnitPricePerAmount);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 06-Feb-2015 </b> <b>Method :
	 * RTC_158333 <b>Description : Test for bug 205062 - PO release immediately
	 * setting is not released the PO's which are in park previously. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_158333(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_No(driver, testCaseName);
			int parkValue = 2;
			PagePurchaseOrderSetting.fillReleasePOAutomaticParkValue(driver, testCaseName, parkValue);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// PagePO.enterPONumber(driver, testCaseName, poNumber);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, standardpo.getPoNumber());
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean parked = status.equalsIgnoreCase("Parked") ? true : false;
			Assert.assertTrue("PO status is not parked", parked);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			String newStatus = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean released = newStatus.equalsIgnoreCase("Released") ? true : false;
			Assert.assertTrue("Status of PO has not changed to released", released);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 06-Feb-2015 </b> <b>Method :
	 * RTC_158339 <b>Description : Test for bug 205207 - Supplier PO contact is
	 * not search if user enters last name of PO contact. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_158339(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageStandardPO.fillSupplierContactByFirstName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_CONTACT_FIRST_NAME));
			PageStandardPO.fillSupplierContactByLastName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_CONTACT_LAST_NAME));
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 06-Feb-2015 </b> <b>Method :
	 * RTC_161645 <b>Description : Test for bug 205439 - Taxes reset warning
	 * thrown even though cost center is changed and not location. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_161645(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		float taxAmount = 0;
		boolean RTC_161645 = false;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//go to standard PO page
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");

			//add an item to PO
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx.executeScript("window.scrollBy(0,-950)", "");
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			jsx.executeScript("window.scrollBy(850,0)", "");
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());

			//apply simple tax
			index = 2;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), index);
			taxAmount = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", "").replaceAll("USD", ""));
			RTC_161645 = taxAmount != 0;
			Assert.assertTrue("Tax not applied", RTC_161645);

			//change CC
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudget();
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CPB.get(IConstantsData.project));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CPB.get(IConstantsData.budget));
			Map<String, String> otherCPB = ObjectCreation.getOtherCostCenterProjectAndBudget();
			String othercostCenterField = otherCPB.get(IConstantsData.costCenter);
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, othercostCenterField);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, otherCPB.get(IConstantsData.project));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, otherCPB.get(IConstantsData.budget));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);

			//remove taxes and check for error
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index);
			PageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName, index);
			taxAmount = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replaceAll(",", "").replaceAll("USD", ""));
			RTC_161645 = taxAmount == 0;
			Assert.assertTrue("Tax not removed", RTC_161645);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Feb-2015 </b> <b>Method :
	 * RTC_161704 <b>Description : Test for bug 205318 - Specifications of an
	 * item is set to blank on editing the item in PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_161704(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_161704 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//create and release a PO
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.getItems().getGuidedItems().get(0).setSpecification("Unique");
			standardpo = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardpo);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			//create an Invoice of that created PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCreateInvoiceButton(driver, testCaseName);
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageViewPurchaseOrder.clickOnItemCheckboxInInvoiceViewPO(driver, testCaseName);
			PageViewPurchaseOrder.clickOnEditItem(driver, testCaseName);
			String quantity = "20";
			PageViewPurchaseOrder.changeQuantityOfItem(driver, testCaseName, quantity);
			//check whether specification name is set to blank
			RTC_161704 = PageViewPurchaseOrder.isSpecificationNamePresent(driver, testCaseName);
			Assert.assertTrue("Specification name is not present", RTC_161704);
			PageViewPurchaseOrder.clickOnSaveItemDetails(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Feb-2015 </b> <b>Method :
	 * RTC_162214 <b>Description : Test for bug 205520 - Item subtotal shown on
	 * item level tax section is shown in negative When user change currency or
	 * supplier. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_162214(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_162216"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_163043"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		boolean RTC_162214 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,-950)", "");
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			jsx.executeScript("window.scrollBy(0,950)", "");
			String totalAmount = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			String tax = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalTax(driver, testCaseName));
			String netTotal = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getItemNetPrice(driver, testCaseName));
			Integer total = Integer.parseInt(totalAmount) + Integer.parseInt(tax);
			RTC_162214 = Integer.parseInt(netTotal) == total ? true : false;
			Assert.assertTrue("Net price is not included with predefined taxes", RTC_162214);
			mappedTestCases.get(1).setTestResult(RTC_162214);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.getUnitItemPriceToApplyTaxOn(driver, testCaseName);
			boolean negation = ModalItemSummaryTax.isNegationSignPresentInUnitItemPrice(driver, testCaseName);
			Assert.assertTrue("Total unit price is negative", !negation);
			mappedTestCases.get(0).setTestResult(!negation);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Feb-2015 </b> <b>Method :
	 * RTC_163191 <b>Description : Test for bug 206008 - Error 500 is displayed
	 * on submitting a PO in the following scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_163191(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String poNumber = null;
		boolean RTC_163191 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index = 4;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), index);
			poNumber = FlowStandardPo.submitPoForProcessing(driver, testCaseName, true);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNumber);
			RTC_163191 = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			Assert.assertTrue("PO Not created successfully", RTC_163191);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Feb-2015 </b> <b>Method :
	 * RTC_176611 <b>Description : Test for bug 207074 - [Demo issue]Line no
	 * field showing error on immediate click of create free text item in
	 * standard PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_176611(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int index = 1;
			boolean error = ModalPOFreeTextItemSummaryItem.isLineNoErrorPresent(driver, testCaseName, index);
			Assert.assertTrue("Line no error is present", !error);
			ModalPOFreeTextItemSummaryItem.clickOnCancelBtnItemSummary(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			boolean error1 = ModalPOFreeTextItemSummaryItem.isLineNoErrorPresent(driver, testCaseName, index);
			Assert.assertTrue("Line no error is present", !error1);
			ModalPOFreeTextItemSummaryItem.clickOnCancelBtnItemSummary(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			boolean error2 = ModalPOFreeTextItemSummaryItem.isLineNoErrorPresent(driver, testCaseName, index);
			Assert.assertTrue("Line no error is present", !error2);
			ModalPOFreeTextItemSummaryItem.clickOnCancelBtnItemSummary(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Feb-2015 </b> <b>Method :
	 * RTC_176750 <b>Description : Test for bug 207019 - [Demo issue]: Error is
	 * displayed in market price on adding a catalog discounted item in PO
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataPovider")
	public void RTC_176750(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.SEARCH_ITEM);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			String quantity = "0.11";
			PageStandardPO.enterInQuantity(driver, Integer.parseInt(quantity));
			int index = 1;
			PageStandardPO.clickOnAdd(driver, index);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			int lineNo = 12;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Feb-2015 </b> <b>Method :
	 * RTC_176760 <b>Description : Test for bug 206899 - Cost booking is
	 * displayed as blank when user adds an item in copy PO in the following
	 * scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_176760(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNumber = CommonServices.getTestData(IConstantsData.PO_NUMBER);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			// PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			String no = PageStandardPO.getItemNo(driver, testCaseName);
			PageStandardPO.clickOnExpandAll(driver);
			String oldCC = PageStandardPO.getCostBookingSectionDetailsAfterExpandingInfoAtHeader(driver, testCaseName);
			PageStandardPO.clickOnCollapseAll(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			// String addItemsToPOfield =
			// CommonServices.getTestData(IConstantsData.SEARCH_ITEM);
			PageStandardPO.fillAddItemsToPOField(driver, no);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			/*
			 * PageStandardPO.clickOnExpandAll(driver); String newCC =
			 * PageStandardPO.
			 * getCostBookingSectionDetailsAfterExpandingInfoAtHeader(driver,
			 * testCaseName); boolean flag = newCC.equals(oldCC) ? true : false;
			 * Assert.assertTrue(
			 * "Cost booking section gets updated after adding same item again",
			 * flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}

	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 10-Feb-2015 </b> <b>Method :
	 * RTC_177579 <b>Description : User should be able to cancel a PO if invoice
	 * is in draft state </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_177579(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Invoice invoice = new Invoice();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCreateInvoiceButton(driver, testCaseName);
			invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SAVE_AS_DRAFT_INVOICE);
			FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PageViewPurchaseOrder.clickOnOrderTab(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelPoLink(driver, testCaseName);
			// PageViewPurchaseOrder.isWarningForClosePODisplayed(driver,
			// testCaseName);
			PageViewPurchaseOrder.fillCancelPoCommentField(driver, testCaseName, IConstantsData.CANCEL_PO_COMMENT);
			PageViewPurchaseOrder.clickOnCancelPoSubmitButtom(driver, testCaseName);
			PageViewPurchaseOrder.isPOCancelledMessagePresent(driver, testCaseName);
			// Assert.assertTrue("PO is not cancelled since message is not
			// present", message);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 11-Feb-2015 </b> <b>Method :
	 * RTC_177580 <b>Description : User should not be able to cancel a PO if its
	 * invoice is in matching/approval state </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_177580(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Invoice invoice = new Invoice();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCreateInvoiceButton(driver, testCaseName);
			invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PageViewPurchaseOrder.clickOnOrderTab(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isCancelPOOptionPresent(driver, testCaseName);
			Assert.assertTrue("Cancel PO option is present and PO can be cancelled", !flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 11-Feb-2015 </b> <b>Method :
	 * RTC_177581 <b>Description : User should not be able to cancel a PO if
	 * release is in approved/parked state </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_177581(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isCancelPOOptionPresent(driver, testCaseName);
			Assert.assertTrue("Cancel PO option is present and PO can be cancelled", !flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Feb-2015 </b> <b>Method :
	 * RTC_107328 <b>Description : Verify Allow creating a free text zero price
	 * item in manual PO-Verify impact on Copy PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107328(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183961"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_190976"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardpo.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 900);
			ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCopyPO(driver, testCaseName);
			jsx1.executeScript("window.scrollBy(0,850)", "");
			boolean flag = PageStandardPO.isItemBlockPresent(driver, testCaseName);
			Assert.assertTrue("Item is not copied properly", flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 12-Feb-2015 </b> <b>Method :
	 * RTC_107329 <b>Description : Verify Allow creating a free text zero price
	 * item in manual PO-Verify impact on Amend PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107329(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardpo.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 900);
			ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,950)", "");
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			// boolean message =
			// PagePurchaseOrderListing.isSuccessfulAmendedMessageDisplayed(driver,
			// testCaseName);
			// Assert.assertTrue("PO amendement is not submitted successfully",
			// message);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Feb-2015 </b> <b>Method :
	 * RTC_107324 <b>Description : Verify Allow creating a free text zero price
	 * item in manual PO-Verify imapct on invoice. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_107324(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Invoice invoice = new Invoice();
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);

			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardpo.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 900);
			ModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.NONE);
			FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			String freight = "100";
			PageStandardPO.fillFreightCharges(driver, testCaseName, freight);
			invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Feb-2015 </b> <b>Method :
	 * RTC_183997 <b>Description : Test for bug 207188 - Costing amount not
	 * displayed correctly in item edit popup in following scenario. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_183997(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183995"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183984"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183975"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_190751"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25690"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			// PageStandardPO.clickOnSearchItem(driver);
			// Buyer should be able to change Market Price; name and description
			// of free text item while editing Draft PO
			String currency = PageStandardPO.getCurrencyValue(driver, testCaseName);
			boolean value = !currency.equals(0) ? true : false;
			Assert.assertTrue("Currency value is not present", value);
			mappedTestCases.get(0).setTestResult(value);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.getNonEditableCCFromReqToPO(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			boolean nonEditable = PageStandardPO.arePredefinedTaxFieldsNonEditable(driver, testCaseName);
			Assert.assertTrue("Predefined taxes are editable", nonEditable);
			mappedTestCases.get(2).setTestResult(nonEditable);
			mappedTestCases.get(4).setTestResult(nonEditable);
			PageStandardPO.clickOnCompoundTax(driver, testCaseName);
			int index = 5;
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index);
			// PageStandardPO.enterTaxName(driver, testCaseName,
			// CommonServices.getTestData(IConstantsData.TAX_NAME),
			// index);
			PageStandardPO.enterTaxName(driver, testCaseName, "test6", index);
			PageStandardPO.enterTaxRate(driver, testCaseName, Integer.parseInt(CommonServices.getTestData(IConstantsData.TAX_RATE)), index);
			PageStandardPO.clickOnTaxAmount(driver, testCaseName, index);
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			String TaxName = CommonServices.getTestData(IConstantsData.TAX_NAME);

			ModalItemSummaryTax.fillTaxName(driver, testCaseName, TaxName);
			String taxRate = "5";
			ModalItemSummaryTax.fillTaxRate(driver, testCaseName, taxRate);
			ModalItemSummaryTax.clickOnTaxAmount(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			boolean error = ModalPOFreeTextItemSummaryCostAllocation.isCostingAmountErrorPresent(driver, testCaseName);
			Assert.assertTrue("Error on costing amount is not present", error);
			mappedTestCases.get(1).setTestResult(error);
			mappedTestCases.get(3).setTestResult(error);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp = StringUtils.split(amount.substring(4), ",");
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			String price = CommonUtilities.getDecimalPriceAlongWithCurrency(PageStandardPO.getTotalItemPrice(driver, testCaseName));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.selectItemLevelDiscountType(driver, testCaseName, IConstantsData.AMOUNT);
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, Integer.parseInt(price));
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			String marketPrice = "50";
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, Float.parseFloat(marketPrice));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			/*
			 * boolean invalid = ModalPOFreeTextItemSummaryCostAllocation
			 * .isCostingAmountErrorPresent(driver, testCaseName);
			 * Assert.assertTrue(
			 * "Negative amount is accepted and not shown as invalid", invalid);
			 */
			// mappedTestCases.get(3).setTestResult(invalid);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			String largePrice = "1000";
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, Float.parseFloat(largePrice));
			String amount1 = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp1 = StringUtils.split(amount1.substring(4), ",");
			amount1 = "";
			for (String str : temp1)
			{
				amount1 += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount1);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Feb-2015 </b> <b>Method :
	 * RTC_190317 <b>Description : Test for bug 207000 - Error 500 is displayed
	 * on copying a PO in the following scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190317(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnInvoiceTopTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnInvoiceSubTab(driver, testCaseName);
			PageInvoiceListing.clickOnFromPurchaseOrderButton(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			boolean flag = ModalPOActions.isCopyPOFromActionsPresent(driver, testCaseName);
			Assert.assertTrue("Copy PO option is present in actions for Draft PO", !flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Feb-2015 </b> <b>Method :
	 * RTC_190753 <b>Description : Test for bug 209528 - Tolerance check not
	 * present for Item Price field when Buyer edit Draft PO created from Req.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190753(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			int limitedItemUnitPrice = 2;
			PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemUnitPrice(driver, testCaseName, limitedItemUnitPrice);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			String marketPrice = "5000";
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, Float.parseFloat(marketPrice));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			String[] temp = StringUtils.split(amount.substring(4), ",");
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageStandardPO.selectDeliveryTerms(driver, CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(950,0)", "");
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			boolean error = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Unit Price excceding tolerance error is not present", error);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Feb-2015 </b> <b>Method :
	 * RTC_190801 <b>Description : Test for bug 209564 - Supplier contact field
	 * not getting saved when user saved PO in Draft. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190801(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			// String contact = PageStandardPO.getSupplierContact(driver,
			// testCaseName);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(850,0)", "");
			/*
			 * String contact =
			 * PageStandardPO.fillSupplierContactByFirstName(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * SUPPLIER_CONTACT_FIRST_NAME));
			 */

			//		String contact = PageStandardPO.fillSupplierContactByFirstName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_CONTACT_FIRST_NAME));
			// String poNo = PageStandardPO.getPONo(driver, testCaseName);
			//		FlowStandardPo.savePOAsDraft(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, standardpo.getPoNumber());
			PagePO.clickOnPONumber(driver, testCaseName);
			String supplierContact = PageStandardPO.getSupplierContact(driver, testCaseName);
			boolean flag = supplierContact.contains(CommonServices.getTestData(IConstantsData.SUPPLIER_CONTACT_FIRST_NAME)) ? true : false;
			Assert.assertTrue("Supplier contact not getting saved when draft PO is opened", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Feb-2015 </b> <b>Method :
	 * RTC_190818 <b>Description : Test for bug 209580 - Requisition setting
	 * "Alert users when shopping quantity beyond:" is referred while adding
	 * items in PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190818(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
			int itemQuantityThreshold = 10;
			PageRequisitionSettings.fillItemQuantityThreshold(driver, testCaseName, itemQuantityThreshold);
			PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			Item item = standardpo.getItems();
			java.util.List<GuidedItem> guidedItemList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemList.get(0);
			guidedItem.setQuantity(11f);
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
			int quantity = 500;
			PageRequisitionSettings.fillItemQuantityThreshold(driver, testCaseName, quantity);
			PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Feb-2015 </b> <b>Method :
	 * RTC_190820 <b>Description : Test for bug 209568 - Error 500 is displayed
	 * on recalling an amended PO and resubmitting it </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190820(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			int limitedItemQuantity = 20;
			PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemQuantity(driver, testCaseName, limitedItemQuantity);
			int limitedItemUnitPrice = 20;
			PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemUnitPrice(driver, testCaseName, limitedItemUnitPrice);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			/*
			 * String poNo = PagePO.enterPONumber(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.PO_NUMBER));
			 */
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			// PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			boolean flag = PagePurchaseOrderListing.isAlertOfPOWaitingForApprovalPresent(driver, testCaseName);
			if (flag == true)
			{
				PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
				PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 2);
				ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			}

			JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
			jsx1.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			// PagePurchaseOrderListing.clickOnViewAmmendedPO(driver,
			// testCaseName);
			PageAmmendedPO.clickOnActions(driver, testCaseName, 1);
			PageAmmendedPO.clickOnRecallApprovalRequestOfApprovalPO(driver, testCaseName, 1);
			ModalPORecallApprovalRequest.fillRecallComments(driver, testCaseName, IConstantsData.RECALL_APPROVAL_REQUEST_COMMENT);
			ModalPORecallApprovalRequest.clickOnRecallButton(driver, testCaseName);
			PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, poNo);
			// jsx1.executeScript("window.scrollBy(0,850)", "");
			/*
			 * PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			 * ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 800);
			 * int marketPrice1 = 20;
			 * ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver,
			 * testCaseName, marketPrice1); int quantity1 = 1;
			 * ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName,
			 * quantity1); ModalPOFreeTextItemSummaryItem.clickOnSave(driver,
			 * testCaseName);
			 */
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Feb-2015 </b> <b>Method :
	 * RTC_190831 <b>Description : Test for bug 209633 - Accounting error shown
	 * in below scenario for standard PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190831(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			// PageStandardPO.clickOnAddItem(driver);
			// PageStandardPO.clickOnSearchItem(driver);
			/*
			 * String addItemsToPOfield =
			 * CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING
			 * ); PageStandardPO.fillAddItemsToPOField(driver,
			 * addItemsToPOfield); PageStandardPO.clickOnSearch(driver); int
			 * index = 2; PageStandardPO.enterInQuantity(driver, index);
			 * PageStandardPO.clickOnAdd(driver, index);
			 */
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			int discount = 10;
			ModalDiscountPO.fillApplyToAllDiscount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnApplyToAll(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			/*
			 * boolean flag =
			 * PageStandardPO.isErrorToEnterAccountingInformationPresent(driver,
			 * testCaseName); Assert.assertTrue(
			 * "Error to enter accounting details is not present", !flag);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 17-Feb-2015 </b> <b>Method :
	 * RTC_190842 <b>Description : Test for bug 209628 - Error is displayed in
	 * costing and accounting section in PO on clicking on remove taxes from
	 * change multiple option </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190842(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_190842 = false;
		float taxAmount = 0;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);

			//apply item level taxes
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnAllItemLineCheckBox(driver, testCaseName);

			//go to update all lines
			PageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);

			//remove applied taxes
			ModalUpdateAllLinesPO.clickOnRemoveAllMultipleTaxes(driver, testCaseName);
			ModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);

			//check whether taxes removed properly
			taxAmount = Float.parseFloat(PageStandardPO.getTotalTax(driver, testCaseName).replace("USD", ""));
			RTC_190842 = taxAmount == 0.0;
			Assert.assertTrue("Remove all taxes not working", RTC_190842);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Feb-2015 </b> <b>Method :
	 * RTC_190843 <b>Description : Test for bug 209626 - Unable to save item
	 * with item level discount in the following scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190843(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int itemNo = 2;
			ModalPOFreeTextItemSummaryItem.enterItemNo(driver, testCaseName, itemNo);
			String name = ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Product_Category));
			int marketPrice = 3;
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, marketPrice);
			int quantity = 3;
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, quantity);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			// String value = "11.1111";
			String value = "11";
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, Integer.parseInt(value));
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);

			String id = PageStandardPO.getItemId(driver, name);
			PageStandardPO.clickOnItemName(driver, testCaseName, id);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			int quantity1 = 2;
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, quantity1);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Feb-2015 </b> <b>Method :
	 * RTC_139275 <b>Description : In Create Standard PO; Tooltip should be
	 * present for tax type values in change multiple modal & on Tax Section of
	 * item summary. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139275(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			int index1 = 2;
			/*
			 * PageStandardPO.enterInQuantity(driver, index1); String name =
			 * PageStandardPO.clickOnAdd(driver, index1);
			 */
			/*
			 * if (name != null) { addItemsToPOfield = name; } String id =
			 * PageStandardPO.getItemId(driver, addItemsToPOfield);
			 * PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			 * ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			 * ModalItemSummaryTax.isTooltipPresentInTaxSection(driver,
			 * testCaseName);
			 * ModalItemSummaryTax.hoverOnTooltipOfTaxSection(driver,
			 * testCaseName);
			 * ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			 */
			PageStandardPO.clickOnAllItemLineCheckBox(driver, testCaseName);
			ModalUpdateAllLinesPO.isTooltipForTaxesPresent(driver, testCaseName);
			ModalUpdateAllLinesPO.hoverOnTooltipTaxes(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 18-Feb-2015 </b> <b>Method :
	 * RTC_20500 <b>Description : User should be able to release the PO's on
	 * selected weekdays. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20500(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_No(driver, testCaseName);
			PagePurchaseOrderSetting.selectReleasePOAutomaticParkType(driver, testCaseName, IConstantsData.DAYS_OF_THE_WEEK);
			int index = 2;
			PagePurchaseOrderSetting.clickOnWeekdayForAutomaticReleasePO(driver, testCaseName, index);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			// standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			// MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equals(IConstantsData.PARKED_FILTER) ? true : false;
			Assert.assertTrue("PO is not in parked state", flag);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			 * PageCustomizeSettings.clickOnPurchaseOrderLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(
			 * driver, testCaseName);
			 * PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
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
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing purchase order setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 18-Feb-2015 </b> <b>Method :
	 * RTC_20689 <b>Description : Test for bug 20119 - Currency and payment term
	 * not getting changed even after changing supplier. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20689(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageStandardPO.enterPaymentTerms(driver, CommonServices.getTestData(IConstantsData.PAYMENT_TERMS));
			String payment1 = PageStandardPO.getPaymentTerms(driver, testCaseName);
			// PageStandardPO.getCurrencyValue(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			String payment2 = PageStandardPO.getPaymentTerms(driver, testCaseName);
			// PageStandardPO.getCurrencyValue(driver, testCaseName);
			boolean flag1 = payment2.equals(payment1) ? false : true;
			Assert.assertTrue("Payment terms have not changed with the change of supplier", flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 18-Feb-2015 </b> <b>Method :
	 * RTC_27205 <b>Description : Verify that When PO is closed, block receipt
	 * creation. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_27205(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60888"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);

			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardpo);
			String poNo = standardpo.getPoNumber();
			PagePO.enterPONumber(driver, testCaseName, poNo);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnClosePOFromActions(driver, testCaseName);
			ModalClosePO.clickOnClosePO(driver, testCaseName);
			PagePO.enterPONumber(driver, testCaseName, poNo);
			PagePO.clickOnActions(driver, testCaseName);
			boolean flag = ModalPOActions.isCreateReceiptFromActionsPresent(driver, testCaseName);
			Assert.assertTrue("Create receipt option is present even if PO is closed", !flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 18-Feb-2015 </b> <b>Method :
	 * RTC_60914 <b>Description : Test for bug 194106 - Allowing to keep Base
	 * exchange rate as zero, causing error 500. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60914(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_63322"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_196714"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierCurrencyOnPO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(850,0)", "");
			PageStandardPO.enterCurrencyType(driver, "INR");
			ModalChangeCurrencyPO.clickOnConvertAmountsToCurrencyType(driver, testCaseName);
			PageStandardPO.clearCurrencyValueField(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			boolean flag = PageStandardPO.isBaseExchangrRateErrorPresent(driver, testCaseName);
			Assert.assertTrue("Validation error for base exchange rate is not shown", flag);
			Double currency = PageStandardPO.enterCurrencyValue(driver, Double.parseDouble(CommonServices.getTestData(IConstantsData.CURRENCY_VALUE)));
			String currencyType = "ZMK";
			PageStandardPO.enterCurrencyType(driver, currencyType);
			ModalChangeCurrencyPO.clickOnConvertAmountsToCurrencyType(driver, testCaseName);
			String poNumber = PageStandardPO.getPONo(driver, testCaseName);
			FlowStandardPo.savePOAsDraft(driver, testCaseName);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnPONumber(driver, testCaseName);
			String value = PageStandardPO.getCurrencyValue(driver, testCaseName);
			boolean flag1 = Double.parseDouble(value) != currency ? true : false;
			Assert.assertTrue("Currency value is not resetted", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 19-Feb-2015 </b> <b>Method :
	 * RTC_61369 <b>Description : Test for bug 194195 - Allowing quantity in
	 * decimal for UoM Each. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_61369(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			int quantity = (int) 0.15;
			CommonUtilities.getDecimalPrice("" + ModalItemSummaryItem.clearAndEnterQuantity(driver, testCaseName, quantity));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			boolean flag = PageStandardPO.isEnterValidQuantityErrorPresent(driver, testCaseName);
			Assert.assertTrue("Quantity accept decimal value for UOM EA", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_63246 <b>Description : Test for bug 194450 - Taxes in Draft not
	 * getting refreshed even after changing delivery address. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_63246(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			boolean flag = PageStandardPO.arePredefinedTaxesPresent(driver, testCaseName);
			Assert.assertTrue("Predefined taxes are not present", flag);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_FREE_DELIVERY_ADDRESS));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			boolean flag1 = PageStandardPO.arePredefinedTaxesPresent(driver, testCaseName);
			Assert.assertTrue("Taxes didnt got refreshed evn after changing delivery address", !flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_63500 <b>Description : Verify "Freight" field in PO should be
	 * non-mandatory field, data type: positive float, impact: PO total should
	 * be calculated adding Freight in existing total. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_63500(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_63501"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_63502"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			PageStandardPO.getItemId(driver, addItemsToPOfield);
			String price = PageStandardPO.getItemNetPrice(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,650)", "");
			String freight = CommonUtilities.getNonZeroRandomNumbers(3).toString();
			PageStandardPO.fillFreightCharges(driver, testCaseName, freight);
			PageStandardPO.clickOnItemNetTotal(driver, testCaseName);
			String maxPrice = PageStandardPO.getItemNetPrice(driver, testCaseName);
			boolean flag = maxPrice != price ? true : false;
			Assert.assertTrue("Net total of item has not changed after adding maximum freight value", flag);
			mappedTestCases.get(0).setTestResult(flag);
			String decimalFreight = "0.90";
			PageStandardPO.fillFreightCharges(driver, testCaseName, decimalFreight);
			PageStandardPO.clickOnItemNetTotal(driver, testCaseName);
			String decimalPrice = PageStandardPO.getItemNetPrice(driver, testCaseName);
			boolean flag1 = decimalPrice != maxPrice ? true : false;
			Assert.assertTrue("Net total of item has not changed after adding decimal freight value", flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_134973 <b>Description : PO listing &gt;&gt; When user click on Cancel
	 * option of PO from tool tip OR status flag OR action click, Pop up for
	 * Comments should appear </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_134973(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelPoLink(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isWarningForClosePODisplayed(driver, testCaseName);
			Assert.assertTrue("Warning message for close PO is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_139292 <b>Description : In Create Standard PO; any time the value of
	 * discount change from header or item level ; should reflect all places.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139292(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_139295"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String itemID = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,450)", "");
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			int value = 20;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, value);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			boolean flag = PageStandardPO.isItemSummaryEditPresent(driver, testCaseName);
			Assert.assertTrue("Item summary edit not present for item", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.getTotalItemPrice(driver, testCaseName);
			PageStandardPO.getItemNetPrice(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			int discount = 30;
			ModalDiscountPO.enterItemLevelDiscountValue(driver, testCaseName, discount);
			ModalDiscountPO.clickOnItemLevelTotalDiscount(driver, testCaseName);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			/*
			 * boolean amount = changedCCAmount != ccAmount ? true : false;
			 * Assert.assertTrue(
			 * "Amount in CC did not changed with change in discount", amount);
			 * ModalPOItemSummaryCostAllocation.clickOnSave(driver,
			 * testCaseName); String totalPrice =
			 * PageStandardPO.getTotalItemPrice(driver, testCaseName); boolean
			 * ItemPrice = totalPrice != price ? true : false;
			 * Assert.assertTrue(
			 * "Amount in Total price did not changed with change in discount",
			 * ItemPrice); String newNetValue =
			 * PageStandardPO.getItemNetPrice(driver, testCaseName); boolean
			 * netPrice = newNetValue != netValue ? true : false;
			 * Assert.assertTrue(
			 * "Amount in Net total did not changed with change in discount",
			 * netPrice); mappedTestCases.get(0).setTestResult(netPrice);
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

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_183971 <b>Description : Test for bug 207623 - PO number not generate
	 * automaticall when user enter already user PO number and then click on YES
	 * on "PO Number is already in use. Would you like to auto-generate new PO
	 * number?" popup. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_183971(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.fillPoNoWithDuplicatepoNo(driver, poNo);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			String changedPONo = PageStandardPO.getPONo(driver, testCaseName);
			boolean flag = changedPONo != poNo ? true : false;
			Assert.assertTrue("PO number has not regenerated automaticaly even after selecting yes in popup", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Feb-2015 </b> <b>Method :
	 * RTC_190844 <b>Description : Test for bug 209618 - Error 500 is displayed
	 * on adding item level discount and submitting a PO in the following
	 * scenario </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190844(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		User user = null;
		float totalPOPriceBeforeDiscountApplied = 0;
		float totalPOPriceAfterDiscountApplied = 0;
		boolean RTC_190844 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//1st guided item
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem1.setQuantity(22f);
			guidedItem1.setPrice((float) 498.7025);
			guidedItem1.setNextAction(IConstantsData.SAVE);
			guidedItems.add(guidedItem1);

			//2nd guided item
			GuidedItem guidedItem2 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem2.setUom(CommonServices.getTestData(IConstantsData.Item_UOM, 0));
			guidedItem2.setQuantity((float) 0.2222);
			guidedItem2.setPrice((float) 145.24);
			guidedItem2.setNextAction(IConstantsData.SAVE);
			guidedItems.add(guidedItem2);

			//3rd guided item
			GuidedItem guidedItem3 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem3.setQuantity(15f);
			guidedItem3.setPrice((float) 123.2);
			guidedItem3.setNextAction(IConstantsData.SAVE);
			guidedItems.add(guidedItem3);
			items.setGuidedItems(guidedItems);

			//get a po object
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.setItems(items);
			standardPO.setNextAction(IConstantsData.NONE);

			//create a po
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			//get the total PO price and add item level discount to 1st item
			totalPOPriceBeforeDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			ModalDiscountPO.selectItemLevelDiscountIndexwise(driver, testCaseName, 1, IConstantsData.AMOUNT);
			ModalDiscountPO.fillItemLevelDiscountValueIndexwise(driver, testCaseName, 1, 20);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			totalPOPriceAfterDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			//check whether discount applied correctly
			RTC_190844 = totalPOPriceBeforeDiscountApplied != totalPOPriceAfterDiscountApplied;
			Assert.assertTrue("Discount on 1st item not applied successfully", RTC_190844);

			//apply discount to 2nd item and check if discount applied
			totalPOPriceBeforeDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			ModalDiscountPO.selectItemLevelDiscountIndexwise(driver, testCaseName, 2, IConstantsData.AMOUNT);
			ModalDiscountPO.fillItemLevelDiscountValueIndexwise(driver, testCaseName, 2, 30);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			totalPOPriceAfterDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			RTC_190844 = totalPOPriceBeforeDiscountApplied != totalPOPriceAfterDiscountApplied;
			Assert.assertTrue("Discount on 2nd item not applied successfully", RTC_190844);

			//apply discount to 3rd item and check whether discount applied 
			totalPOPriceBeforeDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.clickOnItemLevelDiscount(driver, testCaseName);
			ModalDiscountPO.selectItemLevelDiscountIndexwise(driver, testCaseName, 3, IConstantsData.AMOUNT);
			ModalDiscountPO.fillItemLevelDiscountValueIndexwise(driver, testCaseName, 3, 50);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			totalPOPriceAfterDiscountApplied = Float.parseFloat(PageStandardPO.getItemNetPrice(driver, testCaseName).replace("USD", "").replace(",", ""));
			RTC_190844 = totalPOPriceBeforeDiscountApplied != totalPOPriceAfterDiscountApplied;
			Assert.assertTrue("Discount on 3rd item not applied successfully", RTC_190844);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Feb-2015 </b> <b>Method :
	 * RTC_204413 <b>Description : Test for bug 213815 - Error 500 thrown on
	 * amendment submit in a scenario. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_204413(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 50;
			ModalDiscountPO.clickOnDiscountOnEntireOrder(driver, testCaseName);
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int lineNo = 67;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.SHORT_DESC_FOR_GUIDED_ITEM));
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Product_Category));
			int marketPrice = 10;
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, marketPrice);
			int quantity = 1;
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, quantity);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonServices.getTestData(IConstantsData.FREIGHT_CHARGES));
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Feb-2015 </b> <b>Method :
	 * RTC_206949 <b>Description : Test for bug 214193 - [Demo Issue]:500 error
	 * is occurred on update Terms & condition more than 5000 words from Company
	 * or BU Config. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_206949(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnProfileTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnConfigurationTab(driver, testCaseName);
			PageConfigurationSetting.clickOnCompany(driver, testCaseName);
			PageConfigurationSetting.selectCompanyName(driver, testCaseName, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
			PageConfigurationSetting.enterMaxTermsAndConditions(driver, testCaseName, CommonServices.getTestData(IConstantsData.TERMS_AND_COMDITION_MAX_CHARS));
			PageConfigurationSetting.clickOnUpdateCompany(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Feb-2015 </b> <b>Method :
	 * RTC_208881 <b>Description : Test for bug 214386 - Changing delivery
	 * address in amend PO will changes the terms & condition as per config
	 * values. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_208881(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			String poNo = standardpo.getPoNumber();
			standardpo.setTermsAndConditions(CommonServices.getTestData(IConstantsData.TERMS_AND_COMDITION_MAX_CHARS));
			String tnc = standardpo.getTermsAndConditions();
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardpo);
			PagePO.enterPONumber(driver, testCaseName, standardpo.getPoNumber());
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			FlowPoListing.searchPo(driver, testCaseName, standardpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);

			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			String termsAndCondition = PageStandardPO.getTermsAndConditions(driver, testCaseName);
			logger.info("The terms and conditions are:" + termsAndCondition);
			boolean flag = termsAndCondition.equals(tnc) ? true : false;
			Assert.assertTrue("Terms and Conditions have changed due to change in delivery address", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Feb-2015 </b> <b>Method :
	 * RTC_219091 <b>Description : Test for bug 214516 - On submit PO, taxes are
	 * not displayed on PO.Test for bug 214521 - Error of item out of scope is
	 * not properly displayed.
	 * 
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219091(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			boolean flag = PageViewPurchaseOrder.arePredefinedTaxesPresentOnViewPO(driver, testCaseName);
			Assert.assertTrue("Taxes are not present on view PO", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Feb-2015 </b> <b>Method :
	 * RTC_219241 <b>Description : Test for bug 214639 - Wrong error is shown
	 * when user enters short description so that it cant generate category when
	 * setting of 'Allow users to modify the item classification code assigned
	 * by the system' is NO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219241(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			int lineNo = 33;
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
			String shortDesc = "sgsdgsdtewt";
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, shortDesc);
			ModalPOFreeTextItemSummaryItem.clickOnItemTypeGoods(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 400);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 2);
			jsx.executeScript("window.scrollBy(550,0)", "");
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			boolean flag = ModalPOFreeTextItemSummaryItem.isProductCategoryErrorPresent(driver, testCaseName);
			Assert.assertTrue("Error on product category is not present even when invalid short description is entered", flag);
			boolean flag1 = ModalPOFreeTextItemSummaryItem.isErrorPresentInProductCategoryValid(driver, testCaseName);
			Assert.assertTrue("Error present on product category is not valid", !flag1);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Feb-2015 </b> <b>Method :
	 * RTC_219487 <b>Description : Test for bug 214857 - Supplier contact is not
	 * saved when user removes & save as draft. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219487(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PagePO.enterPONumber(driver, testCaseName, standardpo.getPoNumber());
			PagePO.clickOnPONumber(driver, testCaseName);
			PageStandardPO.clearSupplierContact(driver, testCaseName);
			PageStandardPO.clickOnSaveAsDraftPo(driver);
			PagePO.enterPONumber(driver, testCaseName, standardpo.getPoNumber());
			PagePO.clickOnPONumber(driver, testCaseName);
			String contact = PageStandardPO.getSupplierContactValue(driver, testCaseName);
			boolean flag = contact == null;
			Assert.assertTrue("Supplier contact is not null even after removing contact", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_219559 <b>Description : Test for bug 214726 - User is able to add to
	 * cart/ favorites/ basket from PO and invoice view page </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_219559(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageViewPurchaseOrder.clickOnFirstItemName(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isAddToCartOptionPresentOnItemDetails(driver, testCaseName);
			Assert.assertTrue("Add to cart option is present", !flag);
			boolean flag1 = PageViewPurchaseOrder.isAddToFavoritesOptionPresentOnItemDetails(driver, testCaseName);
			Assert.assertTrue("Add to favorites option is present", !flag1);
			boolean flag2 = PageViewPurchaseOrder.isAddToBasketOptionPresentOnItemDetails(driver, testCaseName);
			Assert.assertTrue("Add to basket option is present", !flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_221059 <b>Description : Test for bug 215037 - Supplier mismatch error
	 * is occurred in Log when buyer copy any PO & changes supplier & submit.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_221059(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			// String contact = PageStandardPO.getSupplierContact(driver,
			// testCaseName);
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			String pono = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, pono);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			// PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1500)", "");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,500)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_221693 <b>Description : Test for bug 215161 - While creating standard
	 * PO the currency of taxes stays even when we remove the supplier . </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_221693(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			PageStandardPO.fillAddItemsToPOField(driver, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			PageStandardPO.clickOnAdd(driver, index);
			jsx.executeScript("window.scrollBy(0,900)", "");
			int index1 = 3;

			String price = PageStandardPO.getItemNetPrice(driver, testCaseName);
			boolean flag = !price.contains(CommonServices.getTestData(IConstantsData.CURRENCY_TYPE)) ? true : false;
			Assert.assertTrue("Currency type is present", flag);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnItemNetTotal(driver, testCaseName);
			String value = PageStandardPO.getItemNetPrice(driver, testCaseName);
			boolean flag1 = value.contains("USD") ? true : false;
			Assert.assertTrue("Currency type is not present", flag1);
			jsx.executeScript("window.scrollBy(850,0)", "");
			PageStandardPO.clearSupplierName(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.defaultSleep();
			PageStandardPO.clickOnItemNetTotal(driver, testCaseName);
			String netPrice = PageStandardPO.getItemNetPrice(driver, testCaseName);
			boolean flag2 = netPrice.contains(CommonServices.getTestData(IConstantsData.CURRENCY_TYPE)) ? false : true;
			Assert.assertTrue("Currency type is  present", flag2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_224797 <b>Description : PO download: Buyer should be to 'Print',
	 * 'Download as PDF', 'Preview PO' for closed POs. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_224797(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnClosed(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Preview PO modal is opened successfully");
			driver.switchTo().window(winHandlerBefore);
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
			String winHandlerBefore1 = driver.getWindowHandle();
			Set<String> winHandler1 = driver.getWindowHandles();
			for (String handler : winHandler1)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Print PO modal is opened successfully");
			driver.switchTo().window(winHandlerBefore1);
			PageViewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
			String winHandlerBefore2 = driver.getWindowHandle();
			Set<String> winHandler2 = driver.getWindowHandles();
			for (String handler : winHandler2)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Download as PDF modal is opened successfully");
			driver.switchTo().window(winHandlerBefore2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_227531 <b>Description : Supplier address field should be editable to
	 * buyer incase of draft PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_227531(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String supplierName;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
	
		//	PageStandardPO.clearSupplierName(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			PageStandardPO.selectSupplierAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_ADDRESS));
			supplierName = PageStandardPO.getFirstSupplierName(driver);
			flag = (supplierName.contains(CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_ADDRESS))?true:false);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 27-Feb-2015 </b> <b>Method :
	 * RTC_230017 <b>Description : Test for bug 216833 - System goes infinite
	 * when release option of manual PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_230017(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_No(driver, testCaseName);
			int parkValue = 5;
			PagePurchaseOrderSetting.fillReleasePOAutomaticParkValue(driver, testCaseName, parkValue);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			String poNumber = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equals("Released");
			Assert.assertTrue("PO has not been released evn after clicking on release PO", flag);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			 * PageCustomizeSettings.clickOnPurchaseOrderLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(
			 * driver, testCaseName);
			 * PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
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
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing purchase order setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 02-Mar-2015 </b> <b>Method :
	 * RTC_233215 <b>Description : Address field should be editable in draft PO
	 * from requisition </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_233215(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_233215 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = ObjectCreation.getRequisition(driver);
			Item item = ObjectCreation.getItem("guidedItem");
			requisition.setItems(item);
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			RTC_233215 = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			RTC_233215 = PageStandardPO.isSupplierAddressEditable(driver, testCaseName);
			Assert.assertTrue("Supplier address is not editable in draft PO from requisition", RTC_233215);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 02-Mar-2015 </b> <b>Method :
	 * RTC_233221 <b>Description : Address should be editable in amend PO
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_233221(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_145596"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_233297"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			PageStandardPO.clickOnDropdownSupplierAddress(driver, testCaseName);

			PageStandardPO.selectSupplierAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_ADDRESS));
			PageStandardPO.fillSupplierContactByFirstName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_CONTACT_FIRST_NAME));
			PageStandardPO.clickOnBuyer(driver, testCaseName);
			PageStandardPO.getSupplierContact(driver, testCaseName);
			// boolean flag = contact == null ? true : false;
			// Assert.assertTrue("Freetext supplier contact is allowed", flag);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			boolean company = ModalPurchaseOrderSummaryBilling.isCompanyInOUNonEditable(driver, testCaseName);
			Assert.assertTrue("Company is editable in OU", company);
			mappedTestCases.get(0).setTestResult(company);
			mappedTestCases.get(1).setTestResult(company);
			boolean bu = ModalPurchaseOrderSummaryBilling.isBusinessUnitInOUNonEditable(driver, testCaseName);
			Assert.assertTrue("Business unit is editable in OU", bu);
			mappedTestCases.get(0).setTestResult(bu);
			boolean location = ModalPurchaseOrderSummaryBilling.isLocationInOUNonEditable(driver, testCaseName);
			Assert.assertTrue("location is editable in OU", location);
			mappedTestCases.get(0).setTestResult(location);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 03-Mar-2015 </b> <b>Method :
	 * RTC_238975 <b>Description : Supplier email field should also be copied
	 * when a PO created from requisition is copied. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_238975(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_238976"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, purchaseOrders.get(0).getPoNo());
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("PO is not created", flag);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			flag = PageStandardPO.isPOContactEmailIDPresent(driver, testCaseName);
			Assert.assertTrue("PO contact email id is not present when copying a PO", flag);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			ActionBot.defaultSleep();
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.defaultSleep();
			flag = PageStandardPO.isPOContactEmailIDPresent(driver, testCaseName);
			Assert.assertTrue("PO contact email id is not present when ammending a PO", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Mar-2015 </b> <b>Method :
	 * RTC_238979 <b>Description : For an auto PO Supplier email field should be
	 * present below Supplier Contact.(if PO contact is present) </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_238979(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			int index = 1;
			String poNumber = PageConvertedPurchaseOrder.getPurchaseOrderSrNo(driver, testCaseName, index);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnPONumber(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");
			boolean flag = PageViewPurchaseOrder.isPOContactEmailIDPresentInViewPO(driver, testCaseName);
			Assert.assertTrue("PO Contact email id is not present on view PO", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Mar-2015 </b> <b>Method :
	 * RTC_242375 <b>Description : Test for bug 218291 - While amending existing
	 * PO or creating standard PO.When you change delivery address to any
	 * address(add1) using "other addresses" radio,OU address(OuAdd) also gets
	 * set to add1. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_242375(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		String addressStreetName = "Automation_Street";
		int zipcode = 12345;
		String cityName = "Automation_City";
		String addressName = "Automation_Address_Name";
		StandardPO standardpo = new StandardPO();
		Map<String, String> map = new HashMap<String, String>();

		User user = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);
			user = LoginLogoutServices.login(driver, testCase);
			standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			//			PageStandardPO.fillTaxType(driver, testCaseName, taxType, 1);
			//			PageStandardPO.enterTaxName(driver, testCaseName, taxName, 1);
			//			ActionBot.scroll(driver, "-800");

			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnCreateNewAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillNewAddressName(driver, testCaseName, addressName);
			ModalPOSummaryDelivery.fillNewAddressStreetName(driver, testCaseName, addressStreetName);
			ModalPOSummaryDelivery.fillNewAddressPostalCode(driver, testCaseName, zipcode);
			ModalPOSummaryDelivery.selectCountryName(driver, testCaseName, 1);
			ModalPOSummaryDelivery.enterCityName(driver, testCaseName, cityName);
			ActionBot.click(driver, IModalPOSummaryDelivery.DELIVERY_MY_ADDRESS_SAVE_ADD);
			ActionBot.click(driver, IModalPOSummaryCostBooking.BUTTON_SAVE_PO_SUMMARY);

			ModalPOSummaryDelivery.clickONTaxCahneConfirmationYesBtn(driver, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			String address1 = ModalPOSummaryDelivery.getOUAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillMyAddress(driver, testCaseName, addressName);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_BOOKING_SINGLE_BUDGET));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOUAdressCheckbox(driver, testCaseName);
			String add = ModalPOSummaryDelivery.getOUAddress(driver, testCaseName);
			boolean flag = add.equalsIgnoreCase(address1) ? true : false;
			Assert.assertTrue("OU address has changed with change in my address", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 11-Mar-2015 </b> <b>Method :
	 * RTC_190970 <b>Description : Test for bug 209666 - Item modal not opening
	 * by default on copy item event while amending. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_190970(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageStandardPO.getItemName(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 11-Mar-2015 </b> <b>Method :
	 * RTC_275839 <b>Description : Standard PO: Verify try submitting a standard
	 * PO with maximum characters in project field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275839(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275853"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			CostBookingRequisitionSummary project = standardPO.getCostBookingRequisitionSummary();
			project.setProject(CommonServices.getTestData(IConstantsData.MAX_CHAR_PROJECT));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			ActionBot.defaultMediumSleep();
			FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageViewPurchaseOrder.clickOnCostingLink(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isProjectPresentInCostBookingSection(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 12-Mar-2015 </b> <b>Method :
	 * RTC_275840 <b>Description : Standard PO: Verify try submitting a standard
	 * PO with special characters in project field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275840(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_275840 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			CostBookingRequisitionSummary project = standardPO.getCostBookingRequisitionSummary();
			project.setProject(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_PROJECT));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			RTC_275840 = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName).equalsIgnoreCase(standardPO.getPoNumber());
			Assert.assertTrue("PO Not created successfully", RTC_275840);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			RTC_275840 = ModalPOSummaryCostBooking.getProjecmanagerInfoField(driver, testCaseName) != null;
			Assert.assertTrue("Special char project not accepted", RTC_275840);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Mar-2015 </b> <b>Method :
	 * RTC_275841 <b>Description : Standard PO: Verify try submitting a standard
	 * PO with multilingual characters in project field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275841(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_275841 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			CostBookingRequisitionSummary project = standardPO.getCostBookingRequisitionSummary();
			project.setProject(CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR_PROJECT));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			RTC_275841 = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName).equalsIgnoreCase(standardPO.getPoNumber());
			Assert.assertTrue("PO Not created successfully", RTC_275841);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			RTC_275841 = ModalPOSummaryCostBooking.getProjecmanagerInfoField(driver, testCaseName) != null;
			Assert.assertTrue("Special char project not accepted", RTC_275841);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Mar-2015 </b> <b>Method :
	 * RTC_275848 <b>Description : Standard PO: Verify info icon tooltip beside
	 * project field in costing tab with special characters </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275848(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_275849"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);

			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_PROJECT));
			ModalPOSummaryCostBooking.hoverOnInfoIcon(driver, testCaseName);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.budget));

			boolean flag = ModalPOSummaryCostBooking.getProjecmanagerInfoField(driver, testCaseName) != null;
			Assert.assertTrue("Special character project name is not displayed properly in info icon", flag);

			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			// ModalItemSummaryAccounting.clickOnAccounting(driver);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR_PROJECT));
			ModalPOSummaryCostBooking.hoverOnInfoIcon(driver, testCaseName);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.budget));

			boolean flag1 = ModalPOSummaryCostBooking.getProjecmanagerInfoField(driver, testCaseName) != null;
			Assert.assertTrue("Multilingual character project name is not displayed properly in info icon", flag1);
			mappedTestCases.get(0).setTestResult(flag1);

			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Mar-2015 </b> <b>Method :
	 * RTC_275854 <b>Description : Standard PO: Verify on creating a standard
	 * PO; User should be able to select valid (based on validity date range) &
	 * active projects for the Company in Projects field </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275854(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_BOOKING_SINGLE_BUDGET));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkProjects(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_STATUS));
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_BOOKING_SINGLE_BUDGET));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkProjects(driver, testCaseName);
			PageProjectsMasterDataSettings.getSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.INACTIVE_PROJECT));
			PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Mar-2015 </b> <b>Method :
	 * RTC_275856 <b>Description : Standard PO: Verify on creating a standard
	 * PO; if company of the PO is changed; Projects field should get reset
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275856(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.ALWAYS);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, CommonServices.getTestData(IConstantsData.FILL_PROJECT_NAME));
			//	ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, CommonServices.getTestData(IConstantsData.COST_BOOKING_SINGLE_BUDGET));
			ActionBot.defaultMediumSleep();
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			//	TabPOSummary.clickOnCostBookingPOSummary(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Mar-2015 </b> <b>Method :
	 * RTC_275922 <b>Description : Verify on loading a draft PO; the latest
	 * value of 'Assign cost to project' should be reflected in the PO [Check in
	 * case the value was Let user decide and recent value is Always/Never]
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_275922(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			ProjectsSettings project = new ProjectsSettings();
			project.setAssignProjecttoPurchaseCost(IPageProjectsSettings.LET_USERS_DECIDE);
			FlowProjectsSettings.changeProjectsSettings(driver, project, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			String poNumber = standardpo.getPoNumber();
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			ProjectsSettings project1 = new ProjectsSettings();
			project1.setAssignProjecttoPurchaseCost(IPageProjectsSettings.ALWAYS);
			FlowProjectsSettings.changeProjectsSettings(driver, project1, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNumber);
			PagePO.clickOnPONumber(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Mar-2015 </b> <b>Method :
	 * RTC_277006 <b>Description : Test for bug 223231 - Purchase Order: Error
	 * 500 on Saving as draft with blank Budget </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_277006(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageBudgetSettings.clickOnAllowBudgetUtilizationYES(driver, testCaseName);
			PageProjectsSettings.clickOnSave(driver);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			CostBookingRequisitionSummary budget = standardPO.getCostBookingRequisitionSummary();
			budget.setBudget("");
			budget.setNextAction(IConstantsData.CANCEL);
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Mar-2015 </b> <b>Method :
	 * RTC_277010 <b>Description : Test for bug 221986 - Purchase order: Blank
	 * accounting error shown even after accounting details are defaulted
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_277010(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary account = standardPO.getAccountingItemSummary();
			account.setGlAccount(IConstantsData.EMPTY_STRING);
			account.setNextAction(IConstantsData.CANCEL);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(850,0)", "");
			String purchaseType = CommonServices.getTestData(IConstantsData.PURCHASE_TYPE);
			PageStandardPO.enterPurchaseType(driver, purchaseType);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Mar-2015 </b> <b>Method :
	 * RTC_277032 <b>Description : Test for bug 220812 - Intermittent: Purchase
	 * Order: Unresponsive Script Error </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_277032(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.PO_Search_Item);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			PageStandardPO.fillSearchSupplierForItem(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			int index = 1;
			PageStandardPO.clickOnAdd(driver, index);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Mar-2015 </b> <b>Method :
	 * RTC_292165 <b>Description : Verify In case of edit draft PO, if selected
	 * purchase type in document is deleted from masters and new one is added,
	 * the new one will not get loaded automatically. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_292165(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageMasterDataTenantLevelConfigSettings.removePurchaseType(driver, testCaseName);
			String purchaseType = "ABC,XYZ,PQR,MNO";
			PageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, purchaseType);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			String poNo = standardPO.getPoNumber();
			standardPO.setPurchaseType("MNO");
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageMasterDataTenantLevelConfigSettings.removePurchaseType(driver, testCaseName);
			String purchaseType1 = "ABC,XYZ,PQR";
			PageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, purchaseType1);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNo);
			PagePO.clickOnPONumber(driver, testCaseName);
			PageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Mar-2015 </b> <b>Method :
	 * RTC_292166 <b>Description : Verify In case of COPY PO, if selected
	 * purchase type in document is deleted from masters and new one is added,
	 * the new one will not get loaded automatically. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_292166(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageMasterDataTenantLevelConfigSettings.removePurchaseType(driver, testCaseName);
			String purchaseType = "ABC,XYZ,PQR,MNO";
			PageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, purchaseType);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setPurchaseType("MNO");
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			String poNo = PageViewPurchaseOrder.getViewPONo(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageMasterDataTenantLevelConfigSettings.removePurchaseType(driver, testCaseName);
			String purchaseType1 = "ABC,XYZ,PQR";
			PageMasterDataTenantLevelConfigSettings.addPurchaseType(driver, testCaseName, purchaseType1);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.enterPONumber(driver, testCaseName, poNo);
			PagePO.clickOnActions(driver, testCaseName);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			PageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 17-Mar-2015 </b> <b>Method :
	 * RTC_287008 <b>Description : PO save as draft>> GL accounts in the
	 * document should be defaulted taking into consideration cost center and
	 * line item cost </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_287008(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287010"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287013"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287014"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287023"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287024"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287025"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287026"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			mappedTestCases.get(6).setTestResult(flag);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);

			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount = CommonServices.getTestData(IConstantsData.GL_ACCOUNT);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
			// ModalItemSummaryCostBooking.clickOnCostBooking(driver);

			Map<String, String> CPB_MAP = ObjectCreation.getCostCenterProjectAndBudget();
			String cc = CPB_MAP.get("costCenter");
			String project = CPB_MAP.get("project");
			String budget = CPB_MAP.get("budget");

			ModalPOItemSummaryCostAllocation.fillCostCenter(driver, testCaseName, cc);
			ModalPOItemSummaryCostAllocation.fillProject(driver, testCaseName, project);
			ModalPOItemSummaryCostAllocation.fillBudget(driver, testCaseName, budget);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			String purchaseType = "XYZ";
			PageStandardPO.enterPurchaseType(driver, purchaseType);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, "" + index);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			List<WebElement> li = PageStandardPO.getItemName(driver, testCaseName);
			WebElement ele = li.get(0);
			String itemName = ele.getAttribute("value");
			String item1 = PageStandardPO.getItemId(driver, itemName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, item1);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, IConstantsData.GL_ACCOUNT);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			ModalItemSummaryTax.fillTaxRate(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_RATE));
			ModalItemSummaryTax.clickOnTaxAmount(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, 100);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			PageStandardPO.clickOnDeleteButton(driver, testCaseName, id);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonServices.getTestData(IConstantsData.FREIGHT_CHARGES));
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 19-Mar-2015 </b> <b>Method :
	 * RTC_287016 <b>Description : PO save as draft >>Changing Amount by
	 * changing item QTY/price from item modal or from Grid will redefault GL
	 * type/account </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_287016(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287017"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_287018"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			// ModalPOItemSummaryCostAllocation.clickOnCostBooking(driver);

			Map<String, String> CPB_MAP = ObjectCreation.getCostCenterProjectAndBudget();
			String cc = CPB_MAP.get(IConstantsData.costCenter);
			String project = CPB_MAP.get(IConstantsData.project);
			String budget = CPB_MAP.get(IConstantsData.budget);

			ModalPOItemSummaryCostAllocation.fillCostCenter(driver, testCaseName, cc);
			ModalPOItemSummaryCostAllocation.fillProject(driver, testCaseName, project);
			ModalPOItemSummaryCostAllocation.fillBudget(driver, testCaseName, budget);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			/*
			 * PageStandardPO.clickOnEdit(driver);
			 * TabPOSummary.clickOnDeliveryPOSummary(driver);
			 * ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			 * ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			 * ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
			 * testCaseName);
			 */

			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryItem.clearAndEnterQuantity(driver, testCaseName, 6);

			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String amount = ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);

			// ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver,
			// testCaseName);
			// String amount =
			// ModalPOItemSummaryCostAllocation.getAmount(driver, testCaseName);
			// ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName,
			// amount);

			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Mar-2015 </b> <b>Method :
	 * RTC_276146 <b>Description : Category-PT-GL Map >> PO Creation >> Change
	 * Company: Accounting details should be reset as per new Company selected
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276146(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_276146 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageStandardPO.enterPurchaseType(driver, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> cpb = ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			String cc = cpb.get(IConstantsData.costCenter);
			String project = cpb.get(IConstantsData.project);
			String budget = cpb.get(IConstantsData.budget);
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, cc);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, budget);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			RTC_276146 = ModalPOItemSummaryCostAllocation.getaccuntTypeErrorMsg(driver, null)
				.equalsIgnoreCase(PropertyReader.messageProperty.getProperty("Blank_GL_Account_Error"));
			Assert.assertTrue("GL Account not defaulted when company changed", RTC_276146);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 23-Mar-2015 </b> <b>Method :
	 * RTC_276147 <b>Description : Category-PT-GL Map >> PO Creation >>
	 * Accounting details should be validated from Cat-PT-GL map configured for
	 * document company. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276147(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276148"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276153"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));

			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);

			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			AccountingItemSummary account = standardpo.getAccountingItemSummary();
			account.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);

			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("GL account error for validation map error is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);

			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Mar-2015 </b> <b>Method :
	 * RTC_276182 <b>Description : Category-PT-GL Map >> PO Creation >>
	 * Accounting details should be retained on clicking No button post Purchase
	 * Type Change. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276182(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			ActionBot.scroll(driver, "-850");
			//	jsx.executeScript("window.scrollBy(-850,0)", "");
			PageStandardPO.enterPurchaseType(driver, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE_2));
			//if(PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName))
			boolean flag = (ActionBot.isElementPresent(driver, IPopUpDefaultConfirmation.BUTTON_NO_CONFIRM)) ? true : false;
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			//PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 26-Mar-2015 </b> <b>Method :
	 * RTC_276234 <b>Description : Category-PT-GL Map >> Copy PO >> Accounting
	 * details should be retained on clicking No button post Purchase Type
	 * Change. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276234(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index1 = 2;
			PageStandardPO.enterInQuantity(driver, index1);
			String name = PageStandardPO.clickOnAdd(driver, index1);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			jsx.executeScript("window.scrollBy(0,350)", "");
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			// ModalItemSummaryAccounting.fillGLAccount(driver,
			// CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(850,0)", "");
			PageStandardPO.enterPurchaseType(driver, "PQR");
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Mar-2015 </b> <b>Method :
	 * RTC_271587 <b>Description : Test for bug 222934 - Tax rate is displayed
	 * as exponential format in print/preview/pdf. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_271587(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			int index = 2;

			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), index);
			int taxRate = 56784673;
			PageStandardPO.enterTaxRate(driver, testCaseName, taxRate, index);
			PageStandardPO.clickOnTaxAmount(driver, testCaseName, index);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			ActionBot.defaultMediumSleep();
			FlowPoListing.approveAndReleasePO(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
			// PagePreviewPOPage.getPreviewPoTaxesTotal(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Mar-2015 </b> <b>Method :
	 * RTC_272077 <b>Description : Test for bug 221991 - Purchase Order: Wrong
	 * accounting details are submitted for Copy Purchase order </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272077(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));

			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);

			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.getGlAccount();
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));

			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);

			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);

			PageStandardPO.clickOnExpandAll(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Mar-2015 </b> <b>Method :
	 * RTC_272108 <b>Description : Test for bug 221990 - Purchase Order:
	 * Deactivate account type dispalyed in Edit PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272108(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			accountingItemSummary.getGlAccount();
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 03-Apr-2015 </b> <b>Method :
	 * RTC_276149 <b>Description : Category-PT-GL Map >> PO Creation >>
	 * Accounting details should be defaulted with maps having Purchase Type as
	 * * (recursively) when Purchase Type is not selected\blank. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276149(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276184"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			//	standardpo.setPurchaseType("");
			Item item = standardpo.getItems();
			java.util.List<GuidedItem> guidedItemList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemList.get(0);
			guidedItem.setShortDescription("pen");
			guidedItem.setNextAction(IConstantsData.SAVE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isAccountingDetailsDisplayed(driver, testCaseName);
			Assert.assertTrue("Accounting details are not defaulted and not displayed properly", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 08-Apr-2015 </b> <b>Method :
	 * RTC_276155 <b>Description : Category-PT-GL Map >> PO Creation >> Maps
	 * with deleted\deactivated GL Type\Acc should not be defaulted. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276155(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLMapsMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.GL_ACCOUNT_NAME_gl_map_option);
			PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageMasterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageStandardPO.selectFirstSupplierAddress(driver, testCaseName);
			PageStandardPO.enterPurchaseType(driver, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = "iphone";
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			// add first item
			int index = 2;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String itemID = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, 5);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, addItemsToPOfield);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 200);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 2);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
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
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 09-Apr-2015 </b> <b>Method :
	 * RTC_276158 <b>Description : Category-PT-GL Map &gt;&gt; Draft PO &gt;&gt;
	 * GL Type\Acc deleted\deactivated from defaulting map: Accounting details
	 * will be shown as it was saved; in the grid. On Editing Acc details,
	 * deactivated GL Type\Acc should not be dispalyed. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276158(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276159"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount("default_account");
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLMapsMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.GL_ACCOUNT_NAME_gl_map_option);
			PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageMasterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnExpandAll(driver);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = "computer";
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			// add first item
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String itemID = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			boolean flag = ModalPOItemSummaryCostAllocation.isGLAccountNotEmpty(driver, testCaseName);
			Assert.assertTrue("GL Account is not defaulted", flag);
			mappedTestCases.get(0).setTestResult(flag);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			PageStandardPO.clickOnExpandAll(driver);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
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
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 09-Apr-2015 </b> <b>Method :
	 * RTC_276163 <b>Description : Category-PT-GL Map >> Draft PO >> Accounting
	 * details should be redefaulted on Category change </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276163(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// click on Setup tab
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowModificationOfItemClassificationCode_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(650,0)", "");
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnIsGreenRadioButton(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, 5);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, "pen");
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 100);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 2);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Apr-2015 </b> <b>Method :
	 * RTC_276191 <b>Description : Category-PT-GL Map >> Draft PO >> Change
	 * Company: Accounting details should be reset as per new Company selected
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276191(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String gLAccount = null;
			/*
			 * MainPageHeaderLevelTab.clickOnPOTab(driver);
			 * PagePurchaseOrderListing.clickOnFilterStatusLink(driver,
			 * testCaseName);
			 * PagePurchaseOrderListing.clickOnDraftStatusCheckbox(driver,
			 * testCaseName); PagePurchaseOrderListing.clickOnFilterLink(driver,
			 * testCaseName); PagePurchaseOrderListing.clickOnFirstPoNo(driver,
			 * testCaseName);
			 */
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			String company2 = standardpo.getBillingRequisitionSummary().getCompany();
			String businessUnit2 = standardpo.getBillingRequisitionSummary().getBusinessUnit();
			String location2 = standardpo.getBillingRequisitionSummary().getLocation();
			//FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			String company1 = ModalPurchaseOrderSummaryBilling.getCompany(driver, testCaseName);
			String businessUnit1 = ModalPurchaseOrderSummaryBilling.getBusinessUnit(driver, testCaseName);
			String location1 = ModalPurchaseOrderSummaryBilling.getLocation(driver, testCaseName);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			String cc = CPB.get(IConstantsData.costCenter);
			String project = CPB.get(IConstantsData.project);
			String budget = CPB.get(IConstantsData.budget);
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, cc);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, budget);

			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			gLAccount = ModalPOItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			boolean flag = (company1.equals(company2) && gLAccount == null) ? false : true;
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 13-Apr-2015 </b> <b>Method :
	 * RTC_276183 <b>Description : Category-PT-GL Map >> PO Creation >>
	 * Accounting details should be redefaulted on Category change. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public static void RTC_276183(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowModificationOfItemClassificationCode_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			Item item = standardpo.getItems();
			java.util.List<GuidedItem> guidedItemList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemList.get(0);
			String name = guidedItem.getItemName();
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(450,0)", "");
			// String name = PageStandardPO.getItemName(driver, testCaseName);
			String id = PageStandardPO.getItemId(driver, testCaseName, name);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalPOFreeTextItemSummaryItem.clickOnIsGreenRadioButton(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 13-Apr-2015 </b> <b>Method :
	 * RTC_ <b>Description : Category-PT-GL Map >> Copy PO >> Change
	 * Company: Accounting details should be reset as per new Company selected
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276215(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276216"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276229"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276235"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276234"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAllowModificationOfItemClassificationCode_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			Item item = standardpo.getItems();
			java.util.List<GuidedItem> guidedItemList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemList.get(0);
			guidedItem.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1));
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			Map<String, String> CPB = ObjectCreation.getCostCenterProjectAndBudgetOfOtherCompany();
			String cc = CPB.get(IConstantsData.costCenter);
			String project = CPB.get(IConstantsData.project);
			String budget = CPB.get(IConstantsData.budget);
			ModalPOSummaryCostBooking.fillInCostCenterField(driver, testCaseName, cc);
			ModalPOSummaryCostBooking.fillInProjectField(driver, testCaseName, project);
			ModalPOSummaryCostBooking.fillInBudgetField(driver, testCaseName, budget);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.enterPurchaseType(driver, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE, 0));
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.enterPurchaseType(driver, IConstantsData.EMPTY_STRING);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnIsGreenRadioButton(driver, testCaseName);

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.PRODUCT_CATEGORY, 0));

			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			boolean flag = ModalPOFreeTextItemSummaryCostAllocation.isGLAccountFieldFilled(driver, testCaseName);
			Assert.assertTrue("GL account is not defaulted", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_276201 <b>Description : Category-PT-GL Map >> Copy PO >> Enforce
	 * Setting Change: Validation Rules shouldn't be applied on Submit of the
	 * Copy document [Yes To No] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276201(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276214"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("Validation map check error not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 14-Apr-2015 </b> <b>Method :
	 * RTC_276230 <b>Description : Category-PT-GL Map &gt;&gt; Copy PO &gt;&gt;
	 * GL Type\Acc deleted\deactivated from defaulting map: Accounting details
	 * will be shown as it was saved; in the grid. On Editing Acc details,
	 * deactivated GL Type\Acc should not be dispalyed. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276230(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276231"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276236"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLMapsMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.GL_ACCOUNT_NAME_gl_map_option);
			PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageMasterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			int index = 1;
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, index);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			PageStandardPO.clickOnExpandAll(driver);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = "computer";
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			// add first item
			// int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String itemID = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			boolean flag = ModalPOItemSummaryCostAllocation.isGLAccountNotEmpty(driver, testCaseName);
			Assert.assertTrue("GL Account is not defaulted", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			PageStandardPO.clickOnExpandAll(driver);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnGLAccountsLink(driver,
			 * testCaseName);
			 * PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			 * PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver,
			 * testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
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

		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivatec gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 14-Apr-2015 </b> <b>Method :
	 * RTC_276156 <b>Description : Category-PT-GL Map >> PO Creation >> Maps
	 * with deleted\deactivated GL Type\Acc should not be used for Validation on
	 * Submit. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276156(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276150"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276151"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLMapsMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.GL_ACCOUNT_NAME_gl_map_option);
			PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageMasterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			/*
			 * AccountingItemSummary accountingItemSummary =
			 * standardpo.getAccountingItemSummary();
			 * accountingItemSummary.setGlAccount(CommonServices
			 * .getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * accountingItemSummary.setGlAccount(CommonServices.getTestData(
			 * IConstantsData.GL_ACCOUNT));
			 */
			Item item = standardpo.getItems();
			List<CatelogItem> catelogItemsList = item.getCatelogItems();
			CatelogItem catelogItem = catelogItemsList.get(0);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, catelogItem.getItemID());
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isGLAccountTypePresentProperly(driver, testCaseName);
			Assert.assertTrue("Accounting details are not present", !flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnGLAccountsLink(driver,
			 * testCaseName);
			 * PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			 * PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver,
			 * testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
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

		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Apr-2015 </b> <b>Method :
	 * RTC_276097 <b>Description : Category-PT-GL Map >> Req to PO Draft >> Gl
	 * Type\Acc deactivate\deleted >> User should be blocked on Submit. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276097(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276112"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276113"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			CostBookingItemSummary costBookingItemSummary = requisition.getCostBookingItemSummary();
			AccountingItemSummary accountingItemSummary = costBookingItemSummary.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String poNo = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLMapsMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.GL_ACCOUNT_NAME_gl_map_option);
			PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageMasterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.selectDeliveryTerms(driver, CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(950,0)", "");
			PageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("Validation error for accounting is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnGLAccountsLink(driver,
			 * testCaseName);
			 * PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			 * PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver,
			 * testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
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

		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Apr-2015 </b> <b>Method :
	 * RTC_276238 <b>Description : Category-PT-GL Map >> Draft PO >> Enforce
	 * Setting Change: Validation Rules should be applied on Submit of the draft
	 * document [No To Yes] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276238(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Apr-2015 </b> <b>Method :
	 * RTC_220153 <b>Description : Test for bug 214978 - Wrong sub-total is
	 * displayed on View PO on header level tax when header level discount is
	 * present. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_220153(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_220153 = false;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			Item item = standardpo.getItems();
			standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			java.util.List<GuidedItem> guidedItemList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemList.get(0);
			guidedItem.setPrice(2000);
			guidedItem.setQuantity(1f);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);

			ActionBot.defaultMediumSleep();
			FlowPoListing.searchPo(driver, testCaseName, standardpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			FlowViewPO.copyPo(driver, testCaseName);
			int index = 2;

			PageStandardPO.clickOnModify(driver, testCaseName);
			int discount = 1000;
			ModalDiscountPO.clickOnDiscountOnEntireOrder(driver, testCaseName);
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, discount);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			String totaldiscount = PageStandardPO.getTotalDiscountAmount(driver, testCaseName);

			String totalItemPrice = PageStandardPO.getTotalItemPrice(driver, testCaseName);

			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), index);

			PageStandardPO.enterTaxAmount(driver, testCaseName, index, 100);
			PageStandardPO.clickOnTaxRate(driver, testCaseName, index);
			String totaltax = PageStandardPO.getTotalTax(driver, testCaseName);
			String itemLevelTotaltax = PageStandardPO.getItemLevelTotalTax(driver, testCaseName);

			String price = PageStandardPO.getItemNetPrice(driver, testCaseName);

			ActionBot.defaultMediumSleep();

			Double priceValue = Double.valueOf(price.substring(4).replaceAll(",", ""));
			Double totalItemPriceValue = Double.valueOf(totalItemPrice.substring(4).replaceAll(",", ""));
			Double totaldiscountValue = Double.valueOf(totaldiscount.substring(4).replaceAll(",", ""));
			Double totaltaxValue = Double.valueOf(totaltax.substring(4).replaceAll(",", ""));

			Double value1 = priceValue;
			Double value2 = totalItemPriceValue - totaldiscountValue + totaltaxValue;
			logger.info("the value1" + value1);
			logger.info("the value2" + value2);
			RTC_220153 = ((Double.compare(value1, value2)) == 0) ? true : false;

			Assert.assertTrue("Wrong subtotal is diplyed", RTC_220153);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Apr-2015 </b> <b>Method :
	 * RTC_184008 <b>Description : Test for bug 207180 - Alert of deactivate
	 * entity should displayed before workflow POPUP when user submit any PO.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_184008(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnGLAccountsLink(driver,
			 * testCaseName);
			 * PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			 * PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver,
			 * testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
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

		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 16-Apr-2015 </b> <b>Method :
	 * RTC_183972 <b>Description : Test for bug 208590 - Duplicate taxes are
	 * allowed in below scenario. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_183972(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.NONE);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.PO_OTHER_ADDRESS));
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			Item item = standardpo.getItems();
			List<CatelogItem> catelogItemList = item.getCatelogItems();
			CatelogItem catelogItem = catelogItemList.get(0);
			String id = PageStandardPO.getItemId(driver, catelogItem.getItemName());
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			standardpo.setPoNumber(FlowStandardPo.savePOAsDraft(driver, testCaseName));
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.PO_OTHER_ADDRESS));
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0), 2);
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			ActionBot.scroll(driver, "850");
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 1), 2);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			boolean flag = PageStandardPO.isDuplicateTaxesErrorMsgDisplayed(driver, testCaseName);
			Assert.assertTrue("Duplicate tax error is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_276152 <b>Description : Category-PT-GL Map >> PO Creation >> PT based
	 * Validation should not be applied on Submit. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276152(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));

			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);

			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			AccountingItemSummary accountingItemSummary = standardPO.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_276157 <b>Description : Category-PT-GL Map >> Draft PO >> Accounting
	 * details should be defaulted with maps having Purchase Type as *
	 * (recursively) when Purchase Type is not selected. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276157(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276144"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201820"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_201815"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			// MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.searchPo(driver, testCaseName, standardpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			//PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			// 	PageStandardPO.enterPurchaseType(driver, CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			//	PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, 22);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, "pen");
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 100);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 3);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			boolean flag = ModalPOFreeTextItemSummaryCostAllocation.isGLAccountFieldFilled(driver, testCaseName);
			Assert.assertTrue("GL account is not defaulted", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			// PageStandardPO.clickOnExpandAll(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_201824 <b>Description : Autocomplete for GL account >>
	 * Delete/Deactivate GL account check should be present at when user edit
	 * draft PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201824(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageStandardPO.clickOnExpandAll(driver);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("GL account error is not present after deactivating particular gl account mappeed with category", flag);
			PageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
			/*
			 * MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			 * MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			 * MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
			 * PageMasterDataSettings.clickOnGLAccountsLink(driver,
			 * testCaseName);
			 * PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver,
			 * testCaseName, CommonServices.getTestData(IConstantsData.
			 * VALIDATION_MAP_CHECK_GL_ACCOUNT));
			 * PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			 * PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver,
			 * testCaseName);
			 * PopUpDefaultConfirmation.clickOnConfirmYesButton(driver,
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

		finally
		{
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_201826 <b>Description : Autocomplete for GL account >>
	 * Delete/Deactivate GL account check should be present at when user copy
	 * PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201826(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));

			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			PageCustomizeSettings.clickOnControlLink(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, testCaseName);
			PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);

			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageStandardPO.clickOnExpandAll(driver);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("GL account error is not present after deactivating particular gl account mappeed with category", flag);
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
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 20-Apr-2015 </b> <b>Method :
	 * RTC_201818 <b>Description : Autocomplete for GL account >> If category GL
	 * is mapped then it should be autoselected for that category item when user
	 * edit Draft PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201818(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//draft a PO by setting gl account to null
			StandardPO standardpo = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardpo.getAccountingItemSummary();
			accountingItemSummary.setGlAccount("");
			accountingItemSummary.setNextAction(IConstantsData.CANCEL);
			standardpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardpo = FlowStandardPo.createStandardPo(driver, testCaseName, standardpo);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardpo.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);

			//check whether gl account is defaulted
			boolean flag = ModalPOItemSummaryCostAllocation.isGLAccountNotEmpty(driver, testCaseName);
			Assert.assertTrue("Gl account is not defaulted", flag);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 11-May-2015 </b> <b>Method :
	 * RTC_60873 <b>Description : PO single screen>>Add Item : perform length
	 * validation on all the possible fields </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60873(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, 123456789);

			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME));
			String shortDesc = ActionBot.getTextWithInElement(driver, IModalPOFreeTextItemSummaryItem.TEXTBOX_SHORT_DESCRIPTION);
			ModalPOFreeTextItemSummaryItem.clickOnItemTypeGoods(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 568889986);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 1234566989);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			//boolean flag = ModalPOFreeTextItemSummaryItem.isItemNameLenghtValidationErrorPresent(driver, testCaseName);
			//	Assert.assertTrue("Length validation error is not present", flag);
			//ModalPOItemSummaryCostAllocation.clickOnCancel(driver);

			//ModalPOFreeTextItemSummaryItem.isShortDescFieldFilled(driver, testCaseName);

			boolean flag = (shortDesc.length() > 2000) ? false : true;
			Assert.assertTrue("Length validation error is not present", flag);
			String quantity = PageStandardPO.getAddedItemQuantity(driver, testCaseName);
			flag = (Integer.parseInt(quantity) != 0) ? true : false;
			Assert.assertTrue("Length validation error is not present", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-May-2015 </b> <b>Method :
	 * RTC_139258 <b>Description : In Create Standard PO; Taxes section should
	 * display the Taxes Sub-total according to user number format & precision &
	 * currrency according to item currency. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139258(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			String addItemsToPOfield = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING);
			PageStandardPO.fillAddItemsToPOField(driver, addItemsToPOfield);
			PageStandardPO.clickOnSearch(driver);
			int index = 1;
			PageStandardPO.enterInQuantity(driver, index);
			String name = PageStandardPO.clickOnAdd(driver, index);
			if (name != null)
			{
				addItemsToPOfield = name;
			}
			String id = PageStandardPO.getItemId(driver, addItemsToPOfield);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, id);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			// add 1st tax
			int index1 = 2;
			ModalItemSummaryTax.selectNextRowTaxTye(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index1);
			ModalItemSummaryTax.enterNextRowTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), index1);
			ModalItemSummaryTax.enterNextRowTaxRate(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_RATE), index1);
			ModalItemSummaryTax.clickOnNextRowTaxAmount(driver, testCaseName, index1);
			ModalItemSummaryTax.clickOnAddNewTaxbtn(driver, testCaseName, index1);
			// add 2nd tax
			int index2 = 3;
			ModalItemSummaryTax.selectNextRowTaxTye(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index2);
			ModalItemSummaryTax.enterNextRowTaxName(driver, testCaseName, "test1", index2);
			ModalItemSummaryTax.enterNextRowTaxRate(driver, testCaseName, "5", index2);
			ModalItemSummaryTax.clickOnNextRowTaxAmount(driver, testCaseName, index2);
			ModalItemSummaryTax.clickOnAddNewTaxbtn(driver, testCaseName, index2);
			// add 3rd tax
			int index3 = 4;
			ModalItemSummaryTax.selectNextRowTaxTye(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), index3);
			ModalItemSummaryTax.enterNextRowTaxName(driver, testCaseName, "test2", index3);
			ModalItemSummaryTax.enterNextRowTaxRate(driver, testCaseName, "7", index3);
			ModalItemSummaryTax.clickOnNextRowTaxAmount(driver, testCaseName, index3);
			String oldTotal = ModalItemSummaryTax.getTaxSubTotal(driver, testCaseName);
			ModalItemSummaryTax.clickOnRemoveTaxItemLevel(driver, testCaseName);
			String newTotal = ModalItemSummaryTax.getTaxSubTotal(driver, testCaseName);
			boolean flag = newTotal != oldTotal ? true : false;
			Assert.assertTrue("Sub total of tax has not changed evn after removing tax", flag);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 13-May-2015 </b> <b>Method :
	 * RTC_139464 <b>Description : Amend PO;discount should be specified for
	 * each line or at header & if taxes defined at item level then header level
	 * discount should not allowed. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_139464(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String poNumber = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE, 0));
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			poNumber = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			poNumber = FlowPoListing.approveAndReleasePO(driver, testCaseName, poNumber);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			PageStandardPO.clickOnModify(driver, testCaseName);
			boolean flag = ModalDiscountPO.isAlertOfHeaderLevelDiscountNotAllowedPresent(driver, testCaseName);
			Assert.assertTrue("Header level discount not allowed error not present", flag);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 14-May-2015 </b> <b>Method :
	 * RTC_147520 <b>Description : PO Workflow evaluation >> When user amend
	 * standard PO, If PO total amount violates setting "Require approval when
	 * amended PO total exceeds the smaller|larger of X% or Y units compared to
	 * the previous approved version" then approval workflow configured for that
	 * location should get applied to PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_147520(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnRequiredPOApprovalWhenPOTotalExceedsSmaller(driver, testCaseName);
			PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(driver, testCaseName, 5);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			standardPO.getItems().getCatelogItems().get(0).getItemPriceInUserCurrency();
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 170);
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.clickOnSubmitPOForProcessing(driver);
			boolean flag = PageStandardPO.isSubmitForApprovalWorkflowPresent(driver, testCaseName);
			Assert.assertTrue("Workflow approval is not present", flag);
			PageStandardPO.clickOnCancelOnSubmitForApprovalPopUp(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(driver, testCaseName, 20);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing purchase order setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 14-May-2015 </b> <b>Method :
	 * RTC_146186 <b>Description : PO - In approval state >> When buyer Resubmit
	 * recalled PO; workflow should get applied to that PO as per latest copy of
	 * PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_146186(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			FlowPoListing.recallApprovalRequestForPurchaseOrder(driver, testCaseName);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			PageStandardPO.isSubmitForApprovalWorkflowPresent(driver, testCaseName);
			// Assert.assertTrue("Submit for approval workflow is not present
			// even after recalling in approval po", flag);
			PageStandardPO.clickOnCancelOnSubmitForApprovalPopUp(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 14-May-2015 </b> <b>Method :
	 * RTC_258699 <b>Description : PO Dynamic Approver >> User can remove only
	 * those approvers which are added by him. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258699(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258644"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258646"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258662"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258698"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258717"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258697"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1400)", "");
			// PageViewPurchaseOrder.clickonLinkWorkflow(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isAddApproverLinkPresent(driver, testCaseName);
			Assert.assertTrue("Add approver link is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);
			mappedTestCases.get(5).setTestResult(flag);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnRemoveApprover(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 14-May-2015 </b> <b>Method :
	 * RTC_61129 <b>Description : Test for bug 194178 - Supplier changes not
	 * getting update on existing items, causing error 500 on submit/save.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_61129(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(950,0)", "");
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			//PageStandardPO.selectDeliveryTerms(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_DELIVERY_TERMS));
			ActionBot.scroll(driver);
			PageStandardPO.fillAddItemsToPOField(driver, "computer");
			PageStandardPO.clickOnSearch(driver);
			jsx.executeScript("window.scrollBy(0,350)", "");
			PageStandardPO.clickOnAdd(driver, 1);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ModalItemSummaryCostAllocation.clickOnCostBooking(driver);
			ModalItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-May-2015 </b> <b>Method :
	 * RTC_201821 <b>Description : Autocomplete for GL account >> If Buyer enter
	 * GL account value then it should not be changed while editing Draft PO
	 * even if category GL is defined in between. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_201821(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			//create a draft PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			Item item = standardPO.getItems();
			List<GuidedItem> guidedItemsList = item.getGuidedItems();
			GuidedItem guidedItem = guidedItemsList.get(0);
			guidedItem.setShortDescription("pens");
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			// add gl map
			PageGLMapsMasterDataSettings.clickOnLinkAddGLRulesMap(driver, testCaseName);
			PageGLMapsMasterDataSettings.enterCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.CATEGORY_gl_map_option));
			PageGLMapsMasterDataSettings.clickOnAnyPurchaseType(driver, testCaseName);
			String account = PageGLMapsMasterDataSettings.selectGLAccountType(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT_TYPE_gl_map_option));
			PageGLMapsMasterDataSettings.clickOnSaveAddGLRulesMap(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount = ModalPOItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
			boolean flag = glAccount != account ? true : false;
			Assert.assertTrue("Gl account has changed according to gl map", flag);
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
			PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.CATEGORY_gl_map_option));
			PageGLMapsMasterDataSettings.clickOnDelete(driver, testCaseName);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jun-2015 </b> <b>Method :
	 * RTC_58532 <b>Description : Amend PO: All items in PO cant be removed,
	 * atleast one Item should be rpesent to release PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58532(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO.getItems().setGuidedItems(null);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			String itemId = PageStandardPO.getItemId(driver, standardPO.getItems().getCatelogItems().get(0).getItemName());
			PageStandardPO.clickOnDeleteButton(driver, testCaseName, itemId);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			boolean alert = PageStandardPO.isAlertAddItemToContinuePresent(driver, testCaseName);
			Assert.assertTrue("Alert popup for add item to continue is not present", alert);
			String message = PageStandardPO.getAlertMessageOfAddItemToContinue(driver, testCaseName);
			boolean flag = message.equalsIgnoreCase(IConstantsData.ALERT_ADD_ITEM_IN_PO_TO_CONTINUE) ? true : false;
			Assert.assertTrue("Message displayed on alert popup is not correct", flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 03-Jun-2015 </b> <b>Method :
	 * RTC_60890 <b>Description : PO single screen>> User should be allowed view
	 * addresses on location selection. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60890(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnEdit(driver);
			String oldAddress = ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName);
			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));
			String newAddress = ModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName);
			boolean flag = newAddress != oldAddress ? true : false;
			Assert.assertTrue("Address did not changed with the change of location", flag);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 03-Jun-2015 </b> <b>Method :
	 * RTC_58534 <b>Description : Amend PO>>Item Amend>>COPY : It should create
	 * a new line entry for the same item to modify details of
	 * unreceived/non-invoiced quantity. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58534(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(950,0)", "");
			String id = standardPO.getItems().getCatelogItems().get(0).getItemID();
			PageStandardPO.clickOnCopyItem(driver, testCaseName, id);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			ModalItemSummaryCostAllocation.clickOnCostBooking(driver);
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(1).getItemID());
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, "laptop");
			ModalItemSummaryCostAllocation.clickOnCostBooking(driver);
			ModalItemSummaryCostAllocation.fillGLAccount(driver, "Expense");
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			PageStandardPO.clickOnExpandAll(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 04-Jun-2015 </b> <b>Method :
	 * RTC_38198 <b>Description : Verify that User should be able to filter
	 * Amount by using amount range filter (Filter contains value between max &
	 * min of all POs in the list)) </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_38198(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_38201"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnDateFilterStatus(driver, testCaseName);
			boolean flag = PagePurchaseOrderListing.isMaxAndMinDateRangeFilterPresent(driver, testCaseName);
			Assert.assertTrue("Date range filter is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.enterMinAmountInSelectAmountRangeFilter(driver, testCaseName, 50);
			PagePurchaseOrderListing.enterMaxAmountInSelectAmountRangeFilter(driver, testCaseName, 126758903);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnINRCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnUSDCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnAmountFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnINRCurrencyFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyAmountFilter(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 08-Jun-2015 </b> <b>Method :
	 * RTC_21941 <b>Description : System should compute all applicable taxes
	 * using the 'rate' field of the master data based on : Delivery location.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_21941(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnTaxRatesLink(driver, testCaseName);
			PageTaxRatesMasterDataSettings.SearchTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.COUNTRY_NAME));
			PageTaxRatesMasterDataSettings.selectOption(driver, testCaseName, IConstantsData.COUNTRY_tax_option);
			PageTaxRatesMasterDataSettings.clickOnGO(driver, testCaseName);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 1);
			PageStandardPO.enterSimpleTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 1);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, "tax1");
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Jun-2015 </b> <b>Method :
	 * RTC_58728 <b>Description : Activity log should be maintained for amended
	 * PO document : For Ammended PO as mentioned </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58728(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58725"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58726"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(1050,0)", "");

			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());

			// PageStandardPO.fillFreightCharges(driver, testCaseName, "500");
			PageStandardPO.fillOrderDescription(driver, testCaseName, IConstantsData.Description);

			boolean flag = PageStandardPO.isSubmitPoForProcessingButtomPresent(driver);
			Assert.assertTrue("Submit po is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			FlowPoListing.approveAndReleaseAmmendedPO(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			jsx.executeScript("window.scrollBy(1550,0)", "");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Jun-2015 </b> <b>Method :
	 * RTC_58713 <b>Description : Amend PO will have following statuses:
	 * Submitted > Approved > Released > Confirmed > Rejected > Cancelled >
	 * Discarded </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58713(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(1050,0)", "");
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			// to approve the PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.REJECT);
			approvalAllRequests.setComment(IConstantsData.REJECT_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnViewAmmendedPO(driver, testCaseName);
			PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, standardPO.getPoNumber());
			jsx.executeScript("window.scrollBy(1550,0)", "");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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

	@Test(dataProvider = "dataProvider")
	public void RTC_58535(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58537"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(750,0)", "");
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalItemSummaryTax.clickOnTaxesTab(driver, testCaseName);
			ModalItemSummaryTax.selectTaxTypeOfItemLevelTax(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			ModalItemSummaryTax.fillTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			ModalItemSummaryTax.fillTaxRate(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_RATE));
			ModalItemSummaryTax.clickOnTaxAmount(driver, testCaseName);
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			String firstItem = standardPO.getItems().getCatelogItems().get(0).getItemName();
			PageStandardPO.clickOnCopyButton(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			String secondItem = standardPO.getItems().getCatelogItems().get(1).getItemName();
			boolean flag = secondItem.equalsIgnoreCase(firstItem) ? true : false;
			Assert.assertTrue("Both items not same", flag);
			mappedTestCases.get(0).setTestResult(flag);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, standardPO.getPoNumber());
			jsx.executeScript("window.scrollBy(750,0)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 10-Jun-2015 </b> <b>Method :
	 * RTC_58330 <b>Description : On 'Amend PO' action, PO should open current
	 * version in edit mode with mentioned field editable : Delivery Details>>
	 * Deliver Date [Check in case where Delivery date has passed] </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58330(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58399"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			String oldDeliverTo = ModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
			ModalPOSummaryDelivery.isEditableDeliveryField(driver, testCaseName, CommonServices.getTestData(IConstantsData.DELIVER_TO_FIELD));
			String newDeliverTo = ModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
			boolean flag = newDeliverTo != oldDeliverTo ? true : false;
			Assert.assertTrue("Deliver to field is not editable", flag);
			mappedTestCases.get(0).setTestResult(flag);

			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(750,0)", "");
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 500);
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Jun-2015 </b> <b>Method :
	 * RTC_60860 <b>Description : PO single screen : User should be able to
	 * mention following while adding item in PO : Delivery date [Future date
	 * always] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60860(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60861"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			ModalItemSummaryDelivery.clickOnItemSummaryDeliveryTab(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getFutureDayDate());
			ModalItemSummaryDelivery.fillRequiredByDateAtItemLevel(driver, testCaseName, "" + purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isPlannedDeliveryDatePresent(driver, testCaseName);
			Assert.assertTrue("DElivery date is not present", flag);
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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Jun-2015 </b> <b>Method :
	 * RTC_25689 <b>Description : Tax Configuration based on county: CITY/COUNTY
	 * fields should hav auto-complete in the format %CITY% (%STATE%
	 * %COUNTRY_CODE%). </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25689(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnTaxRatesLink(driver, testCaseName);

			PageTaxRatesMasterDataSettings.clickOnAddTaxRateBtn(driver, testCaseName);

			PageTaxRatesMasterDataSettings.fillNameTaxRate(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME));
			PageTaxRatesMasterDataSettings.fillTaxRate(driver, testCaseName, Integer.valueOf(CommonServices.getTestData(IConstantsData.TAX_RATE)));
			PageTaxRatesMasterDataSettings.SelectCountry(driver, testCaseName, CommonServices.getTestData(IConstantsData.COUNTRY_tax_option), 3);
			PageTaxRatesMasterDataSettings.fillTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE));
			PageTaxRatesMasterDataSettings.enterCity(driver, testCaseName, CommonServices.getTestData(IConstantsData.CITY));

			PageTaxRatesMasterDataSettings.clickOnAddTaxRateBtn(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jun-2015 </b> <b>Method :
	 * RTC_246473 <b>Description : Test for bug 218379 - 'Allow creating
	 * invoices for this order?' check is not enabled in PO receipt </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_246473(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			boolean disable = PageCreateReceipt.isAllowCreatingInvoicesForOrderDisabled(driver, testCaseName);
			Assert.assertTrue("Allow creating invoice is enabled", disable);
			PageCreateReceipt.clickOnIsThisTheLastGoodsReceiptForOrder(driver, testCaseName);
			boolean enable = PageCreateReceipt.isAllowCreatingInvoicesForOrderEnabled(driver, testCaseName);
			Assert.assertTrue("Allow creating invoice is disabled", enable);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jun-2015 </b> <b>Method :
	 * RTC_247866 <b>Description : Test for bug 218991 - I can submit standard
	 * PO even if its GL account is inactive for following scenario. </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_247866(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			AccountingItemSummary accountingItemSummary = standardPO.getAccountingItemSummary();
			accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.CHILD_GL_ACCOUNT));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

			PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
			PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
			PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
			PageGLAccountsMasterDataSettings.clickOnActiveLink(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCopyFromActions(driver, testCaseName);
			PageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
			boolean flag = PageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("GL account validation error is not present", flag);
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
			try
			{
				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
				PageMasterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
				PageGLAccountsMasterDataSettings.enterGLAccountInSearch(driver, testCaseName, CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
				PageGLAccountsMasterDataSettings.clickOnGO(driver, testCaseName);
				PageGLAccountsMasterDataSettings.clickOnDeactiveLink(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in activating deactivated gl account" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jun-2015 </b> <b>Method :
	 * RTC_258664 <b>Description : PO Dynamic Approver >> Length validation
	 * should be handled in change approver screen. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258664(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258668"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258670"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258713"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258714"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258647"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258643"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258645"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		boolean RTC_258664 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			/*
			 * StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			 * standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			 */
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			RTC_258664 = FlowPoListing.searchPO(driver, testCaseName, "OU_1-001/18/4874", IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("PO Not created", RTC_258664);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1400)", "");
			boolean flag = PageViewPurchaseOrder.isChangeApproverLinkPresent(driver, testCaseName);
			Assert.assertTrue("Change approver link is not present", flag);
			boolean status = PageViewPurchaseOrder.isStatusOfWorkflowPending(driver, testCaseName, 2);
			Assert.assertTrue("Status of workflow request is not in pending state", status);
			mappedTestCases.get(4).setTestResult(status);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHAR_USER));
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR_USER));
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER));
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
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
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Jun-2015 </b> <b>Method :
	 * RTC_263851 <b>Description : Test for bug 221181 - Unconfirmed status
	 * filter in PO listing is not working </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_263851(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandReleaseFilterNode(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandConfirmationStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnUnConfirmedStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,200)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jun-2015 </b> <b>Method :
	 * RTC_276021 <b>Description : Verify On creating a Blanket Order release
	 * against a Blanket PO, the project information should be carried with the
	 * CC/Budget info for the blanket order release [Verify in case of 'Assign
	 * cost to project=YES/Always'] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276021(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_226761"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
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
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			PageProjectsSettings.clickOnAlways(driver);
			PageProjectsSettings.clickOnSave(driver);

			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");

			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageBPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,500)", "");
			PageBPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			boolean flag = ModalPOItemSummaryCostAllocation.isGLAccountNotEmpty(driver, testCaseName);
			Assert.assertTrue("GL account field is empty", flag);
			mappedTestCases.get(0).setTestResult(flag);

			ModalItemSummaryCostAllocation.clickOnSave(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,1000)", "");
			PageViewPurchaseOrder.clickOnCostingLink(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 22-Jun-2015 </b> <b>Method :
	 * RTC_276022 <b>Description : Verify On creating a Blanket Order release
	 * against a Blanket PO, the project information should be carried with the
	 * CC/Budget info for the blanket order release [Verify in case of 'Assign
	 * cost to project=No/Never'] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_276022(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
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
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

			PageProjectsSettings.clickOnNever(driver);
			PageProjectsSettings.clickOnSave(driver);
			// navigate back to eproc
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			PageBPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,500)", "");
			PageBPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);

			ModalItemSummaryCostAllocation.clickOnSave(driver);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,1000)", "");
			PageViewPurchaseOrder.clickOnCostingLink(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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

				PageProjectsSettings.clickOnAlways(driver);
				PageProjectsSettings.clickOnSave(driver);
				//				MainPageHeaderLevelTab.clickOnSetUpTab(driver);
				//				MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
				//				MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
				//				PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
				//				PageCostBookingSettings.clickOnProjects(driver);
				//				PageProjectsSettings.clickOnAlways(driver);
				//				PageProjectsSettings.clickOnSave(driver);
			}
			catch (Exception e)
			{
				logger.error("Error in changing project setting to ALWAYS" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 23-Jun-2015 </b> <b>Method :
	 * RTC_295579 <b>Description : Test for bug 227407 - Error 500 thrown on
	 * recalling PO in following scenario . </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_295579(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnApprovalWorkflowLink(driver, testCaseName);
			PageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(driver, testCaseName);
			PageWorkflowSettings.clickOnSaveWorkflowSettings(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			FlowPoListing.recallApprovalRequestForPurchaseOrder(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				PageCustomizeSettings.clickOnApprovalWorkflowLink(driver, testCaseName);
				PageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(driver, testCaseName);
				PageWorkflowSettings.clickOnSaveWorkflowSettings(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing approval workflow setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 23-Jun-2015 </b> <b>Method :
	 * RTC_246955 <b>Description : Test for bug 218351 - [Intermittent]: User is
	 * able to create receipt and invoice for cancelled Blanket Order Release
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_246955(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean RTC_246955 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			FlowViewPO.cancelPo(driver, testCaseName);
			ActionBot.defaultLowSleep();
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ActionBot.defaultLowSleep();

			RTC_246955 = ActionBot.isElementPresent(driver, IPageStandardPO.LINK_CREATE_RECEIPT);
			Assert.assertTrue("Able to create receipt and invoice", !RTC_246955);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 24-Jun-2015 </b> <b>Method :
	 * RTC_60877 <b>Description : PO single screen>>Add Item : perform Data type
	 * validation on all the possible fields </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60877(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60875"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnFreeTextItem(driver);
			ModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, 123456789);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.MAX_CHARACTER_ITEMNAME));
			ModalPOFreeTextItemSummaryItem.clickOnItemTypeGoods(driver, testCaseName);

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_PRODUCT_CATAGORY));
			/*
			 * ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver,
			 * testCaseName, 0); boolean price =
			 * ModalPOFreeTextItemSummaryItem.isMarketPriceErrorPresent(driver,
			 * testCaseName); Assert.assertTrue(
			 * "Market price error is not present", price);
			 * mappedTestCases.get(0).setTestResult(price);
			 */

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Product_Category));
			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, "fraternal");

			ModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, CommonServices.getTestData(IConstantsData.PRODUCT_CATEGORY, 1));

			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 0);
			boolean price = ModalPOFreeTextItemSummaryItem.isMarketPriceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Market price error is not present", price);

			ModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, 568889986);

			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 0);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			boolean quantity = ModalPOFreeTextItemSummaryItem.isQuantityErrorPresent(driver, testCaseName);
			Assert.assertTrue("Quantity error is not present", quantity);
			mappedTestCases.get(0).setTestResult(price);

			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 1234566989);
			ModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.fillGLAccount(driver, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);

			//ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHARACTER_ITEMNAME));

			//PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);

			//ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHARACTER_ITEMNAME));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHARACTER_ITEMNAME));
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 24-Jun-2015 </b> <b>Method :
	 * RTC_60847 <b>Description : PO single screen : User should be able to
	 * mention following while creating PO : PO level attachments </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60847(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22553"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnPOAddAttachmentLink(driver, testCaseName);

			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FILE_WITH_DISTURBED_STRUCTURE;
			ModalPOAttachment.fillAttachmentFileName(driver, testCaseName, filePath);
			String size = ModalPOAttachment.getAttachmentSize(driver, testCaseName);
			boolean flag = !size.equalsIgnoreCase("0 KB") ? true : false;
			Assert.assertTrue("Attached file size is equal to zero", flag);
			ModalPOAttachment.clickOnDoneButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1050)", "");
			PageViewPurchaseOrder.clickOnLinkEnclosure(driver, testCaseName);
			boolean download = PageViewPurchaseOrder.isDownloadPOAttachmentLinkPresent(driver, testCaseName);
			Assert.assertTrue("Download PO attachment link is not present", download);
			mappedTestCases.get(0).setTestResult(download);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 24-Jun-2015 </b> <b>Method :
	 * RTC_60867 <b>Description : PO single screen : User should be able to
	 * mention following while adding item in PO : Item level attachmnets
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_60867(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_60868"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, standardPO.getItems().getCatelogItems().get(0).getItemID());
			ModalPOFreeTextItemSummaryAttachmentsAndComments.clickOnAttachmentsAndComments(driver, testCaseName);
			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_WITH_SPECIAL_CHARS;
			ModalPOFreeTextItemSummaryAttachmentsAndComments.fillAttachmentFileName(driver, testCaseName, filePath);
			String size = ModalPOFreeTextItemSummaryAttachmentsAndComments.getAttachmentSize(driver, testCaseName, IConstantsData.ITEM_WITH_SPECIAL_CHARS);
			boolean flag = !size.equalsIgnoreCase("0 KB") ? true : false;
			mappedTestCases.get(0).setTestResult(flag);
			Assert.assertTrue("Attached file size is equal to zero", flag);
			ModalItemSummaryCostAllocation.clickOnSave(driver);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Jun-2015 </b> <b>Method :
	 * RTC_22607 <b>Description : Verify that On clicking 'Download as PDF'
	 * link, file download should begin automatically. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_22607(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_22597"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_24548"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			boolean flag = ModalPOActions.isDownloadPOFromActionsPresent(driver, testCaseName);
			Assert.assertTrue("Download option is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			ModalPOActions.clickOnDownloadFromActions(driver, testCaseName);

			CommonUtilities.downloadFile();

			/*
			 * File file = new File(""); long size = file.getTotalSpace();
			 * String name = file.getName(); boolean flag = name.equals(poNo) ?
			 * true : false; Assert.assertTrue(
			 * "File download name does not match with the downloaded file",
			 * flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_77073 <b>Description : Catalog Item in PO via file : Perform data
	 * type validation on all columns in file. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_77073(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			// add item
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItemViaFileLink(driver, testCaseName);
			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_WITH_DATA_VALIDATION;
			ModalUploadItemViaFile.enterFilePath(driver, testCaseName, filePath);
			ModalUploadItemViaFile.clickOnUploadFile(driver, testCaseName);
			boolean flag = ModalUploadItemViaFile.isErrorDetailsOfValidationOfDataPresent(driver, testCaseName);
			Assert.assertTrue("Invalid data error details is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_76945 <b>Description : Copy PO : Check copying a PO of another buyer
	 * with custom delivery address. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_76945(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		String addressStreetName = IConstantsData.ADDRESS_STREET_NAME;
		int zipcode = Integer.parseInt(IConstantsData.ZIPCODE);
		String cityName = IConstantsData.CITY_NAME;
		String addressName = IConstantsData.ADDRESS_ADDRESS_NAME;

		String address = CommonServices.getTestData(IConstantsData.PO_MY_ADDRESS);
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			//	FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			ActionBot.scroll(driver, "-800");

			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnCreateNewAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillNewAddressName(driver, testCaseName, addressName);
			ModalPOSummaryDelivery.fillNewAddressStreetName(driver, testCaseName, addressStreetName);
			ModalPOSummaryDelivery.fillNewAddressPostalCode(driver, testCaseName, zipcode);
			ModalPOSummaryDelivery.selectCountryName(driver, testCaseName, 1);
			ModalPOSummaryDelivery.enterCityName(driver, testCaseName, cityName);
			ActionBot.click(driver, IModalPOSummaryDelivery.DELIVERY_MY_ADDRESS_SAVE_ADD);
			ActionBot.click(driver, IModalPOSummaryCostBooking.BUTTON_SAVE_PO_SUMMARY);

			ModalPOSummaryDelivery.clickONTaxCahneConfirmationYesBtn(driver, testCaseName);

			//String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(900,0)", "");
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillMyAddress(driver, testCaseName, addressName);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = (ActionBot.isElementDisplayed(driver, IPageViewPurchaseOrder.COPY_PO_LINK)) ? true : false;
			Assert.assertTrue(flag);
			PageViewPurchaseOrder.clickOnCopyPO(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_183963 <b>Description : Test for bug 208312 - User not able to Submit
	 * Draft PO created from Req if Payment method is P-Card. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_183963(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// keep automaticaly generate orders to NO
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getRequisition(driver);

			Item item = ObjectCreation.getItem("guidedItem");

			requisition.setItems(item);
			CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			// convert To Po
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
			ActionBot.defaultSleep();
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setDraftFilter(true);
			FlowPoListing.applyPoStatusFilter(driver, testCaseName, poStatusFilter);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_22623 <b>Description : Verify that The subject and body should be
	 * configurable via the "Customize" > "Email Notifications" > "PO templates"
	 * > "Email PO document" link. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_22623(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnDocumentInformationLink(driver, testCaseName);
			PageDocumentInformationSettings.clickOnPOInfo(driver, testCaseName);
			PageDocumentInformationSettings.fillPODetailsTemplate(driver, testCaseName, "Email details Template");
			PageDocumentInformationSettings.clickOnSave(driver, testCaseName);
			PageDocumentInformationSettings.fillPODetailsTemplate(driver, testCaseName, CommonServices.getTestData("POEmailDetailsTemplate"));
			PageDocumentInformationSettings.clickOnSave(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_20324 <b>Description : Requisition should get auto converted to PO
	 * incase auto PO setting is on and all details of requisition are filled
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20324(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_25687"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnSetUpTab(driver);
			MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, testCaseName);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
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
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String reqNo = PageViewPurchaseOrder.getRequisitionNumber(driver, testCaseName);
			boolean flag = reqNo.equals(requisition.getReqNo()) ? true : false;
			Assert.assertTrue("Req is not converted to PO", flag);
			mappedTestCases.get(0).setTestResult(flag);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(150,0)", "");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, testCaseName);
				PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Error in changing purchase order setting" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_20505 <b>Description : Try inserting a paragraph for description or
	 * Notes on suggested PO listing while creating a req-PO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_20505(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String convertedPurchaseOrder = null;
		boolean RTC_20505 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, requisition.getReqNo());
			PageBuyersDeskListing.clickOnCheckboxOfReqToBeSelected(driver, testCaseName, 1);
			PageBuyersDeskListing.clickOnConvertToPoButton(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnNotes(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.enterNotes(driver, testCaseName, IConstantsData.PO_TO_BE_GENERATED_NOTES);
			PagePurchaseOrderToBeGenerated.clickOnSaveNotes(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
			convertedPurchaseOrder = PageConvertedPurchaseOrder.getListOfPurchaseOrderGenerated(driver, testCaseName).get(0).getText();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			RTC_20505 = FlowPoListing.searchPo(driver, testCaseName, convertedPurchaseOrder, IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Paragraph description not allowed for notes while converting requisition to PO", RTC_20505);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 26-Jun-2015 </b> <b>Method :
	 * RTC_22606 <b>Description : Verify that we should able to download the PO
	 * document which is in released state by clicking the 'Download as PDF'
	 * action on the PO view screen. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_22606(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnTypeFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnStandardFilterOption(driver, testCaseName);
			PagePurchaseOrderListing.clickOnApplyTypeFilter(driver, testCaseName);
			PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isDownloadLinkPresent(driver, testCaseName);
			Assert.assertTrue("Download link is not present", flag);
			PageViewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
			CommonUtilities.downloadFile();

			/*
			 * File file = new File(""); long size = file.getTotalSpace();
			 * String name = file.getName(); boolean flag = name.equals(poNo) ?
			 * true : false; Assert.assertTrue(
			 * "File download name does not match with the downloaded file",
			 * flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jun-2015 </b> <b>Method :
	 * RTC_25038 <b>Description : Verify that User should be able to capture the
	 * foll. 'Delivery Information': as Shipped via* (name of the delivery
	 * company). </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_25038(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			//	standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnReleasedStatusCheckbox(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			ActionBot.defaultSleep();
			ActionBot.click(driver, By.xpath(".//*[@class='itmChk']//*[@id='chkAllItems']"));
			String shipping = PageCreateReceipt.enterShippedVia(driver, testCaseName, CommonServices.getTestData(IConstantsData.SHIPPED_VIA));
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scroll(0,200)", "");
			FlowReceipt.submitReceipt(driver, testCaseName);
			PageReceiptListing.clickOnViewReceiptButton(driver, testCaseName);
			String shippedVia = PageViewReceipt.getShippedViaLabel(driver, testCaseName);

			boolean flag = shippedVia.equalsIgnoreCase(shipping) ? true : false;
			Assert.assertTrue("Shipping information is not captured", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jun-2015 </b> <b>Method :
	 * RTC_23533 <b>Description : User should be able to view / download
	 * attachments from the suggested PO in IE and Mozilla </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_23533(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnPendingOrderStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
			ModalBuersDeskListingActions.clickOnConvertToPOAction(driver, testCaseName);
			PagePurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testCaseName, 0);
			PagePurchaseOrderToBeGenerated.clickOnAddAttachments(driver, testCaseName);
			String fileName = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FILE_WITH_DISTURBED_STRUCTURE;
			ModalPOAttachment.fillAttachmentFileName(driver, testCaseName, fileName);
			String size = ModalPOAttachment.getAttachmentSize(driver, testCaseName);
			boolean flag = !size.equalsIgnoreCase("0 KB") ? true : false;
			Assert.assertTrue("Attached file size is equal to zero", flag);
			ModalPOAttachment.clickOnDownloadAttachment(driver, testCaseName);
			CommonUtilities.downloadFile();
			ModalPOAttachment.clickOnDoneButton(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jun-2015 </b> <b>Method :
	 * RTC_27237 <b>Description : Verify that PO is 'Partially Invoiced' when
	 * at-least one Invoice has been created against it. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_27237(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnCreateInvoice(driver, testCaseName);
			PageCreateNonPOInvoice.fillInvoiceNo(driver, testCaseName, " " + CommonUtilities.getNonZeroRandomNumbers(3));
			Invoice invoice = new Invoice();
			invoice.setInvoiceDate(CommonUtilities.getTodaysDate());
			PageCreateNonPOInvoice.selectInvoiceDate(driver, testCaseName, invoice.getInvoiceDate().getDay(), invoice.getInvoiceDate().getMonth(),
				invoice.getInvoiceDate().getYear());
			PageCreateNonPOInvoice.clickOnFirstItemCheckbox(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnSubmitInvoiceButton(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnIgnoreAndSubmit(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.hoverAndClickOnIconInvoicedPOStatus(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jun-2015 </b> <b>Method :
	 * RTC_27252 <b>Description : Verify that PO is 'Invoiced' when all items in
	 * it are Invoiced. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_27238(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnCreateInvoice(driver, testCaseName);
			Invoice invoice = new Invoice();
			invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.hoverAndClickOnIconInvoicedPOStatus(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jun-2015 </b> <b>Method :
	 * RTC_259723 <b>Description : Test for bug 221139 - Cost center are not
	 * shown on focus in of cost center while editing billing and delivery info
	 * of purchase order . </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_259723(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnCostBookingPOSummary(driver);
			ModalPOSummaryCostBooking.clearCostCenterField(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnCancel(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Jun-2015 </b> <b>Method :
	 * RTC_258642 <b>Description : PO Dynamic Approver &gt;&gt; When actor is
	 * replaced in PO; following activity should get logged in audit trail:-
	 * Name | Timestamp | Modified workflow | Replaced %old actor name% by %new
	 * actor name%. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258642(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(1050,0)", "");
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.Third_Approver));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			jsx.executeScript("window.scrollBy(100,0)", "");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_227538 <b>Description : PO should be allowed to be created with same
	 * supplier but different supplier address catalog items </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_227538(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			String Name = PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageStandardPO.selectFirstSupplierAddress(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(150,0)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnSearchItem(driver);
			//check item
			PageStandardPO.fillAddItemsToPOField(driver, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
			PageStandardPO.clickOnSearch(driver);
			String itemSupplierName = PageStandardPO.getItemSupplierName(driver, testCaseName);
			boolean flag = itemSupplierName.equals(Name) ? true : false;
			Assert.assertTrue("Item is searched according to the supplier selected and different supplier item is not considerd", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_63512 <b>Description : Verify System should validate on submit if
	 * selected user has access to PO. If FALSE, display a warning pop-up "User
	 * selected as 'Checkout Buyer' does not seem to be a buyer. Do wish to
	 * continue?" (Yes [primary] | NO ). </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_63512(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setBuyer(CommonServices.getTestData(IConstantsData.MULTILINGUAL_CHAR_USER));
			standardPO.setNextAction(IConstantsData.NONE);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);
			boolean flag = PageStandardPO.isInvalidCheckoutBuyerPopupPresent(driver, testCaseName);
			Assert.assertTrue("Invalid checkout buyer popup is not present", flag);
			String text = PageStandardPO.getInvalidCheckoutBuyerText(driver, testCaseName);
			boolean flag1 = text.equals(IConstantsData.INVALID_CHECKOUT_BUYER) ? true : false;
			Assert.assertTrue("Invalid checkout buyer text is different", flag1);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_258640 <b>Description : PO Dynamic Approver >> Approver can add
	 * themselves as an actor (to reapprove PO) in Request while taking action
	 * on that Request. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258640(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258648"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			ActionBot.scroll(driver, "1050");

			//			// change approver
			//			boolean change = PageViewPurchaseOrder.isChangeApproverLinkPresent(driver, testCaseName);
			//
			//			MainPageHeaderLevelTab.clickOnPOTab(driver);
			//			PagePurchaseOrderListing.clickOnFilterStatusLink(driver, testCaseName);
			//			PagePurchaseOrderListing.clickOnExpandInProgressStatusFilter(driver, testCaseName);
			//			PagePurchaseOrderListing.clickOnInApprovalStatusFilter(driver, testCaseName);
			//			PagePurchaseOrderListing.clickOnFilterLink(driver, testCaseName);
			//			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			ActionBot.defaultMediumSleep();

			//MainPageHeaderLevelTab.clickOnPOTab(driver);
			FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			//PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,1400)", "");
			boolean flag = PageViewPurchaseOrder.isAddApproverLinkPresent(driver, testCaseName);
			Assert.assertTrue("Add approver link is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			String approver = PageViewPurchaseOrder.getFirstApproversNameInWorkflow(driver, testCaseName);
			System.out.println("qqq qqq qqq qq 1 " + approver);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, approver);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_295556 <b>Description : Test for bug 227398 - Two errors are shown if
	 * line no is left blank for more than one item while adding items via file
	 * in PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_295556(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,700)", "");
			//	PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItemViaFileLink(driver, testCaseName);
			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEMS_WITH_BLANK_LINE_NO;
			ModalUploadItemViaFile.enterFilePath(driver, testCaseName, filePath);
			ModalUploadItemViaFile.clickOnUploadFile(driver, testCaseName);
			boolean flag = ModalUploadItemViaFile.isBlankLineNumberErrorPresent(driver, testCaseName);
			Assert.assertTrue("Invalid data error details is not present", flag);
			ModalUploadItemViaFile.clickOnCloseErrorDetails(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_272094 <b>Description : Test for bug 221300 - Purchase Order: No
	 * validation for Product URL, manufacture URL and Image URL </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_272094(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnStandardPO(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,700)", "");
			PageStandardPO.clickOnAddItem(driver);
			PageStandardPO.clickOnAddItemViaFileLink(driver, testCaseName);
			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_WITH_INVALID_URLS;
			ModalUploadItemViaFile.enterFilePath(driver, testCaseName, filePath);
			ModalUploadItemViaFile.clickOnUploadFile(driver, testCaseName);
			ActionBot.defaultSleep();
			boolean flag = ModalUploadItemViaFile.isErrorDetailsOfValidationOfDataPresent(driver, testCaseName);
			Assert.assertTrue("Invalid data error details is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Jul-2015 </b> <b>Method :
	 * RTC_58405 <b>Description : Amend PO: Not received/invoiced items of
	 * manual PO only should be allowed to remove. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_58405(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_58407"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
			PagePOInvoiceListing.clickOnCreateInvoice(driver, testCaseName);
			PageCreateNonPOInvoice.fillInvoiceNo(driver, testCaseName, " " + CommonUtilities.getNonZeroRandomNumbers(3));
			Invoice invoice = new Invoice();
			invoice.setInvoiceDate(CommonUtilities.getTodaysDate());
			PageCreateNonPOInvoice.selectInvoiceDate(driver, testCaseName, invoice.getInvoiceDate().getDay(), invoice.getInvoiceDate().getMonth(),
				invoice.getInvoiceDate().getYear());
			PageCreateNonPOInvoice.clickOnFirstItemCheckbox(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnSubmitInvoiceButton(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnIgnoreAndSubmit(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnSubmitForConfirmation(driver, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,700)", "");
			boolean flag = PageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName);
			Assert.assertTrue("PO change comment is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);

			PageStandardPO.clickOnDeleteButton(driver, testCaseName, standardPO.getItems().getGuidedItems().get(0).getItemID());
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 09-Oct-2015 </b> <b>Method :
	 * RTC_258641 <b>Description : PO Dynamic Approver &gt;&gt; Audit trail
	 * entries of adding/replacing actor should be displayed in users time zone.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258641(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258709"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258715"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258716"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258790"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258696"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258685"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			ActionBot.scroll(driver, "1050");

			// change approver
			boolean change = PageViewPurchaseOrder.isChangeApproverLinkPresent(driver, testCaseName);
			Assert.assertTrue("Change approver link is not present", change);
			mappedTestCases.get(0).setTestResult(change);
			mappedTestCases.get(1).setTestResult(change);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// add approver
			boolean add = PageViewPurchaseOrder.isAddApproverLinkPresent(driver, testCaseName);
			mappedTestCases.get(4).setTestSkipped(add);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.DIFFERENT_USER));
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			boolean error = ModalAddApprover.isSelectNodesNamesErrorPresent(driver, testCaseName);
			Assert.assertTrue("Error in add approver is not present", error);
			mappedTestCases.get(5).setTestSkipped(error);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			// remove approver
			PageViewPurchaseOrder.clickOnRemoveApprover(driver, testCaseName);

			// Check audit trial
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			String action = PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, 1);
			boolean audit = action.equalsIgnoreCase("Modified workflow") ? true : false;
			Assert.assertTrue("Workflow hasnt modified even after performing changes on approver of workflow", audit);
			mappedTestCases.get(2).setTestResult(change);
			mappedTestCases.get(3).setTestResult(change);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 14-Oct-2015 </b> <b>Method :
	 * RTC_258651 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver with non-overlapping scope:' setting is 'Block'
	 * then error should be shown if old approver has totally different scope
	 * (Non-Overlapping scope) than new approver.[Check when any of the Location
	 * which is present in both users scope is deactivated] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258651(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258652"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258653"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258654"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow setting of non overlapping scope to BLOCK
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingAprroverWithNonOverlappingScope(IConstantsData.BLOCK);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// Inactivate Locations
			LocationSettings locationSettings = new LocationSettings();
			locationSettings.setChangStatus("ACTIVE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.LOCATION_NAME), locationSettings);
			locationSettings.setChangStatus("ACTIVE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location), locationSettings);
			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check for different purchasing scope with location deactivated
			// error
			boolean location_ps = PageViewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
			Assert.assertTrue("Different purchasing scope error is not present with locations deactivated", location_ps);
			mappedTestCases.get(2).setTestResult(location_ps);

			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			// activate locations
			LocationSettings locationSettings1 = new LocationSettings();
			locationSettings1.setChangStatus("DEACTIVATE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.LOCATION_NAME), locationSettings1);
			locationSettings1.setChangStatus("DEACTIVATE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location), locationSettings1);

			// deactivate BU
			BusinessUnitSettings businessUnitSettings = new BusinessUnitSettings();
			businessUnitSettings.setChangStatus("ACTIVE");
			FlowBusinessUnitSettings.changeStatusOfBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME), businessUnitSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check for different purchasing scope with business unit
			// deactivated error
			boolean businessUnit_ps = PageViewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
			Assert.assertTrue("Different purchasing scope error is not present with businessUnit deactivated", businessUnit_ps);
			mappedTestCases.get(0).setTestResult(businessUnit_ps);

			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			// activate business unit
			BusinessUnitSettings businessUnitSettings1 = new BusinessUnitSettings();
			businessUnitSettings1.setChangStatus("INACTIVE");
			FlowBusinessUnitSettings.changeStatusOfBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME), businessUnitSettings1);

			// deactivate Company
			CompanySettings companySettings = new CompanySettings();
			companySettings.setChangStatus("ACTIVE");
			FlowCompanySettings.changeStatusOfCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME), companySettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check for different purchasing scope with company deactivated
			// error
			boolean company_ps = PageViewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
			Assert.assertTrue("Different purchasing scope error is not present with businessUnit deactivated", company_ps);
			mappedTestCases.get(1).setTestResult(company_ps);

			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			/*
			 * //activate company CompanySettings companySettings1 = new
			 * CompanySettings(); companySettings1.setChangStatus("INACTIVE");
			 * FlowCompanySettings.changeStatusOfCompany(driver, testCaseName,
			 * CommonServices.getTestData(IConstantsData.
			 * ORGANIZATION_UNIT_OR_COMPANY_NAME), companySettings1);
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
				// activate company
				CompanySettings companySettings1 = new CompanySettings();
				companySettings1.setChangStatus("INACTIVE");
				FlowCompanySettings.changeStatusOfCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME), companySettings1);
			}
			catch (Exception e)
			{
				logger.error("Error while activating company" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Oct-2015 </b> <b>Method :
	 * RTC_258655 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver with non-overlapping scope:' setting is 'display
	 * warning' then pop up with 'review' and 'ignore and submit' option' should
	 * be displayed on change approver window if replaced approver has totally
	 * different scope (non-overlapping) than new approver. [Check when any of
	 * the Location which is present in both users scope is deactivated] </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258655(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258656"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258677"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258678"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow setting of non overlapping scope to DISPLAY
			// WARNING
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingAprroverWithNonOverlappingScope(IConstantsData.DISPLAY_WARNING);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// Inactivate Locations
			LocationSettings locationSettings = new LocationSettings();
			locationSettings.setChangStatus("ACTIVE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.LOCATION_NAME), locationSettings);
			locationSettings.setChangStatus("ACTIVE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location), locationSettings);
			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check CONFIRM modal when locations are deactivated
			boolean location_ps = PageViewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
			Assert.assertTrue("Confirm workflow modal is not present after deactivating locations", location_ps);
			mappedTestCases.get(2).setTestResult(location_ps);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			// activate locations
			LocationSettings locationSettings1 = new LocationSettings();
			locationSettings1.setChangStatus("DEACTIVATE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.LOCATION_NAME), locationSettings1);
			locationSettings1.setChangStatus("DEACTIVATE");
			FlowLocationSettings.changeStatusOfLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location), locationSettings1);

			// deactivate BU
			BusinessUnitSettings businessUnitSettings = new BusinessUnitSettings();
			businessUnitSettings.setChangStatus("ACTIVE");
			FlowBusinessUnitSettings.changeStatusOfBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME), businessUnitSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check CONFIRM modal when BU is deactivated
			boolean bu_ps = PageViewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
			Assert.assertTrue("Confirm workflow modal is not present after deactivating bu", bu_ps);
			mappedTestCases.get(0).setTestResult(bu_ps);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			// activate business unit
			BusinessUnitSettings businessUnitSettings1 = new BusinessUnitSettings();
			businessUnitSettings1.setChangStatus("INACTIVE");
			FlowBusinessUnitSettings.changeStatusOfBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME), businessUnitSettings1);

			// deactivate Company
			CompanySettings companySettings = new CompanySettings();
			companySettings.setChangStatus("ACTIVE");
			FlowCompanySettings.changeStatusOfCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME), companySettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_2));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check CONFIRM modal when company is deactivated
			boolean company_ps = PageViewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
			Assert.assertTrue("Confirm workflow modal is not present after deactivating company", company_ps);
			mappedTestCases.get(1).setTestResult(company_ps);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			// activate company
			CompanySettings companySettings1 = new CompanySettings();
			companySettings1.setChangStatus("INACTIVE");
			FlowCompanySettings.changeStatusOfCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME), companySettings1);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				WorkflowSettings workflow = new WorkflowSettings();
				workflow.setReplacingAprroverWithNonOverlappingScope(IConstantsData.BLOCK);
				FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflow);
			}
			catch (Exception e)
			{
				logger.error("Error while changing workflow settings" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}

	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 15-Oct-2015 </b> <b>Method :
	 * RTC_258701 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver having higher approval limit than the new
	 * approver:' setting is 'Block' then error should be shown if old approver
	 * has higher approval limit than new approver.[check where old approver and
	 * new approver have different currencies] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258701(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258702"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow higher limit setting to BLOCK
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingApproverHavingHigherApprovalLimitThanNewApprover(IConstantsData.BLOCK);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_HIGHER_APPROVAL_LIMIT));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check error when old approver has higher limit then new approver
			boolean limit = PageViewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
			Assert.assertTrue("Lower limit error is not present", limit);
			mappedTestCases.get(0).setTestResult(limit);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 15-Oct-2015 </b> <b>Method :
	 * RTC_258703 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver having higher approval limit than the new
	 * approver:' setting is 'display warning' then pop up with 'review' and
	 * 'ignore and submit' option' should be displayed on change approver window
	 * if replaced approver has higher approval limit than new approver. [check
	 * where old approver and new approver have different currencies] </font>
	 * <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258703(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258704"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow higher limit setting to DISPLAY WARNING
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingApproverHavingHigherApprovalLimitThanNewApprover(IConstantsData.BLOCK);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_HIGHER_APPROVAL_LIMIT));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check confirm modal when old approver has higher limit then new
			// approver
			boolean limit = PageViewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
			Assert.assertTrue("Confirm modal is not present for lower limit approver error", limit);

			mappedTestCases.get(0).setTestResult(limit);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				WorkflowSettings workflow = new WorkflowSettings();
				workflow.setReplacingAprroverWithNonOverlappingScope(IConstantsData.BLOCK);
				FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflow);
			}
			catch (Exception e)
			{
				logger.error("Error while changing workflow settings" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 16-Oct-2015 </b> <b>Method :
	 * RTC_258679 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver with a different designation' setting is 'Block'
	 * then error should be shown if old approver has different designation than
	 * new approver. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258679(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258796"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow higher designation setting to BLOCK
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingApproverHavingHigherDesignationThanNewApprover(IConstantsData.BLOCK);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check error when old approver has higher designation then new
			// approver
			boolean designation = PageViewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
			Assert.assertTrue("Lower designation error is not present", designation);
			mappedTestCases.get(0).setTestResult(designation);
			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Oct-2015 </b> <b>Method :
	 * RTC_258700 <b>Description : PO Dynamic Approver &gt;&gt; If 'When
	 * replacing an approver with a different designation:' setting is 'display
	 * warning' then pop up with 'review' and 'ignore and submit' option' should
	 * be displayed on change approver window if replaced approver has different
	 * designation than new approver. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258700(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258779"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// change workflow higher designation setting to BLOCK
			WorkflowSettings workflowSettings = new WorkflowSettings();
			workflowSettings.setReplacingApproverHavingHigherDesignationThanNewApprover(IConstantsData.DISPLAY_WARNING);
			FlowWorkflowSettings.changeWorkflowSettings(driver, testCaseName, workflowSettings);

			// open Inapproval status PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver with differnt sourcing status
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_WITH_PURCHASING_SCOPE_1));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// check confirm modal when old approver has higher designation then
			// new approver
			boolean designation = PageViewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
			Assert.assertTrue("Confirm modal is not present for lower designation approver error", designation);
			mappedTestCases.get(0).setTestResult(designation);

			PageViewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Oct-2015 </b> <b>Method :
	 * RTC_258718 <b>Description : PO Dynamic Approver >>When Prevent an
	 * approver from approving more than once is 'Yes'; an approver who is
	 * already present in the workflow as a named actor cannot be added again.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258718(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258766"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258769"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258775"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.getBillingRequisitionSummary().setLocation(CommonServices.getTestData(IConstantsData.Other_Location));
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// open PO and add approver
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");
			String approverName = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 2);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, approverName);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			// check approver name error
			boolean approverError = ModalAddApprover.isDuplicateWorkflowActorNameErrorPresent(driver, testCaseName);
			Assert.assertTrue("Duplicate Approver name error is not present", approverError);
			mappedTestCases.get(0).setTestResult(approverError);

			ModalAddApprover.clickOnCancelAddApprover(driver, testCaseName);

			// get requester name and add new approver
			String requesterName = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 1);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, requesterName);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			// check requester name error
			boolean requesterError = ModalAddApprover.isDuplicateWorkflowActorNameErrorPresent(driver, testCaseName);
			Assert.assertTrue("Duplicate Requester name error is not present", requesterError);
			mappedTestCases.get(1).setTestResult(requesterError);
			mappedTestCases.get(2).setTestResult(requesterError);

			ModalAddApprover.clickOnCancelAddApprover(driver, testCaseName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Oct-2015 </b> <b>Method :
	 * RTC_258657 <b>Description : PO Dynamic Approver &gt;&gt; Approver can add
	 * themselves as an actor next to current pending node in Request while
	 * taking action on that Request. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258657(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258658"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258688"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// open po
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// change approver
			PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
			PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, CommonServices.getTestData(IConstantsData.DIFFERENT_USER));
			PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

			// add same approver again
			String approverName = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 2);
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, approverName);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			// check is the new node and old approver same
			String actorName = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 3);
			boolean name = actorName.equalsIgnoreCase(approverName) ? true : false;
			Assert.assertTrue("Approver cannot add themselves as an actor in next node, which is wrong", name);
			mappedTestCases.get(0).setTestResult(name);
			mappedTestCases.get(1).setTestResult(name);

			// open PO again and check node
			ActionBot.scrollUp(driver, "1200");
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");

			// Add one more node
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 16-Oct-2015 </b> <b>Method :
	 * RTC_258659 <b>Description : PO global Approver >> Comments should be
	 * mandatory for global approver while approving Request. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_258659(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_258672"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create standard po
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// open PO in all approval page
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			MainPageHeaderLevelTab.clickOnApprovalTab(driver);
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			PageAllRequestsApproval.fillDocumentNo(driver, testCaseName, standardPO.getPoNumber());
			PageAllRequestsApproval.clickOnFirstRowApprovalDocumentNo(driver, testCaseName);
			ActionBot.scroll(driver, "1200");
			PageApprovalDocumentViewMode.clickOnApproveButton(driver, testCaseName);
			boolean comments = PageApprovalDocumentViewMode.isMandatoryCommentsErrorPresent(driver, testCaseName);
			Assert.assertTrue("Comments field is not mandatory", comments);
			mappedTestCases.get(0).setTestResult(comments);

			String approverName = PageApprovalDocumentViewMode.getWorkflowActorName(driver, testCaseName, 2);
			PageApprovalDocumentViewMode.clickOnAddApproverButton(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, approverName);
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);

			PageApprovalDocumentViewMode.fillApprovalComment(driver, testCaseName, IConstantsData.APPROVE_COMMENT);
			PageApprovalDocumentViewMode.clickOnApproveButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 11-Jan-2016 </b> <b>Method :
	 * RTC_377359 <b>Description : Type of map : UOM >> Preview PO > should
	 * display supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377359(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377349"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377344"));
		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom(CommonServices.getTestData(IConstantsData.ITEM_UOM_FILL));
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// open released PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			// click preview PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Preview modal is opened successfully");
			String quantity = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			boolean uom = quantity.contains(CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			Assert.assertTrue("UOM supplier code is shown wrong", uom);
			mappedTestCases.get(1).setTestResult(uom);
			String total = PagePreviewPOPage.getPreviewGrossTotal(driver, testCaseName);
			boolean currency = total.contains(CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			Assert.assertTrue("Currency supplier code is wrong", currency);
			mappedTestCases.get(0).setTestResult(currency);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Jan-2016 </b> <b>Method :
	 * RTC_377358 <b>Description : Type of map : UOM >> PO Print > should
	 * display supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377358(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377348"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377343"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// open released PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			// click print PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isPrintPOOptionPresent(driver, testCaseName);
			Assert.assertTrue("Print option is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Jan-2016 </b> <b>Method :
	 * RTC_377357 <b>Description : Type of map : UOM >> Download as PDF > should
	 * display supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377357(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377347"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377342"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377285"));
		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// open released PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			// click download PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isDownloadLinkPresent(driver, testCaseName);
			Assert.assertTrue("Download option is not present", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			PageViewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
			CommonUtilities.downloadFile();

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 12-Jan-2016 </b> <b>Method :
	 * RTC_377355 <b>Description : Type of map : UOM >> Review PO > should
	 * display supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377355(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377345"));
			}

			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);

			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");

			// standardPO.getItems().getGuidedItems().get(0).setUom("EACH");

			standardPO.setNextAction(IConstantsData.NONE);
			FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// click on review PO
			PageStandardPO.clickOnReViewPoLink(driver);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Review modal is opened successfully");
			String quantity = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			boolean uom = quantity.contains(CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			Assert.assertTrue("UOM supplier code is shown wrong", uom);
			String total = PagePreviewPOPage.getPreviewGrossTotal(driver, testCaseName);
			boolean currency = total.contains(CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			Assert.assertTrue("Currency supplier code is wrong", currency);
			mappedTestCases.get(0).setTestResult(currency);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 18-Jan-2016 </b> <b>Method :
	 * RTC_377323 <b>Description : Type of map : UOM >> Amend PO >> Preview PO >
	 * should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377323(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected UOM
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check preview PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Preview modal is opened successfully");
			String quantity = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			boolean uom = quantity.contains(CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));
			Assert.assertTrue("UOM supplier code is shown wrong even after changing supplier code", uom);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
				// Change UOM of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing UOM in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 18-Jan-2016 </b> <b>Method :
	 * RTC_377322 <b>Description : Type of map : UOM >> Amend PO >> PO Print >
	 * should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377322(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected UOM
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check print PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
			String quantity = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			boolean uom = quantity.contains(CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));
			Assert.assertTrue("UOM supplier code is shown wrong even after changing supplier code", uom);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change UOM of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing UOM in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377321 <b>Description : Type of map : UOM >> Amend PO >> Download as
	 * PDF > should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377321(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected UOM
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check download PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isDownloadLinkPresent(driver, testCaseName);
			Assert.assertTrue("Download option is not present", flag);
			PageViewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
			CommonUtilities.downloadFile();

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change UOM of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing UOM in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377319 <b>Description : Type of map : UOM >> Amend PO >> Review PO >
	 * should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377319(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.getItems().getGuidedItems().get(0).setUom("EACH");
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected UOM
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));

			// Amend released PO and review PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			PageStandardPO.clickOnReViewPoLink(driver);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Review modal is opened successfully");
			String quantity = PagePreviewPOPage.getPreviewPoQuantity(driver, testCaseName);
			boolean uom = quantity.contains(CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE));
			Assert.assertTrue("UOM supplier code is shown wrong", uom);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change UOM of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_UOM_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.UOM_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing UOM in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377313 <b>Description : Type of map : Currency >> Amend PO >> Preview
	 * PO > should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377313(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected Currency
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check preview PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Preview modal is opened successfully");
			String total = PagePreviewPOPage.getPreviewGrossTotal(driver, testCaseName);
			boolean currency = total.contains(CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));
			Assert.assertTrue("Currency supplier code is shown wrong even after changing supplier code", currency);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change Currency of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing Currency in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377312 <b>Description : Type of map : Currency >> Amend PO >> PO
	 * Print > should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377312(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected Currency
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check print PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
			String total = PagePreviewPOPage.getPreviewGrossTotal(driver, testCaseName);
			boolean currency = total.contains(CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));
			Assert.assertTrue("Currency supplier code is shown wrong even after changing supplier code", currency);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change Currency of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing Currency in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377311 <b>Description : Type of map : Currency >> Amend PO >>
	 * Download as PDF > should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377311(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected Currency
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));

			// Amend released PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Release Amended PO
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// open PO and check download PO
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			boolean flag = PageViewPurchaseOrder.isDownloadLinkPresent(driver, testCaseName);
			Assert.assertTrue("Download option is not present", flag);
			PageViewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
			CommonUtilities.downloadFile();

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change Currency of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing Currency in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}

	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_377309 <b>Description : Type of map : Currency >> Amend PO >> Review
	 * PO > should display updated supplier code. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377309(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create and release PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// change supplier code of selected Currency
			FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE),
				IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));

			// Amend released PO and Review PO
			PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "900");
			PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageStandardPO.fillFreightCharges(driver, testCaseName, CommonUtilities.getNonZeroRandomNumbers(3).toString());
			PageStandardPO.clickOnReViewPoLink(driver);
			String winHandlerBefore = driver.getWindowHandle();
			Set<String> winHandler = driver.getWindowHandles();
			for (String handler : winHandler)
			{
				driver.switchTo().window(handler);
			}
			ScreenShot.screenshot(driver, testCaseName, "Review modal is opened successfully");
			String total = PagePreviewPOPage.getPreviewGrossTotal(driver, testCaseName);
			boolean currency = total.contains(CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE));
			Assert.assertTrue("Currency supplier code is shown wrong", currency);
			driver.switchTo().window(winHandlerBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// Change Currency of supplier code map
				FlowSupplierCodeMapMasterDataSettings.editSupplierCode(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_CURRENCY_SUPPLIER_CODE),
					IConstantsData.SUPPLIER_SIDE_CODE_supplier_code_map_option, CommonServices.getTestData(IConstantsData.CURRENCY_SUPPLIER_CODE));
			}

			catch (Exception e)
			{
				logger.error("Exception while changing Currency in supplier code map" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 19-Jan-2016 </b> <b>Method :
	 * RTC_391802 <b>Description : Test for bug 244403 - Uploading wrong file in
	 * Add items via file leads to infinite loading. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_391802(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_391103"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_388865"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_388856"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_387474"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// check version in audit trail
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, requisition.getPurchaseOrdersList().get(0).getPoNo());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "1300");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			String no = PageViewPurchaseOrder.getAuditTrailVersion(driver, testCaseName, 1);
			boolean version = no.equals("v1") ? true : false;
			Assert.assertTrue("Audit trail version has changed which is wrong", version);
			mappedTestCases.get(0).setTestResult(version);

			// ammend PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, requisition.getPurchaseOrdersList().get(0).getPoNo());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.scroll(driver, "400");

			// add item via file
			PageStandardPO.clickOnAddItemViaFileLink(driver, testCaseName);
			String filePath = IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_FOR_AMEND_PO_ITEM_ERROR_CHECK;
			ModalUploadItemViaFile.enterFilePath(driver, testCaseName, filePath);
			ModalUploadItemViaFile.clickOnUploadFile(driver, testCaseName);
			boolean flag = ModalUploadItemViaFile.isErrorDetailsOfValidationOfDataPresent(driver, testCaseName);
			Assert.assertTrue("Invalid data error details is not present", flag);
			mappedTestCases.get(3).setTestResult(flag);
			ModalUploadItemViaFile.clickOnCloseErrorDetails(driver, testCaseName);

			// check req is in released state or not
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, requisition.getReqNo());
			String status1 = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			boolean condition = status1.equals("Released") ? true : false;
			Assert.assertTrue("Req is not in released state, even though its related PO is released, which is wrong", condition);
			mappedTestCases.get(1).setTestResult(condition);

			mappedTestCases.get(2).setTestResult(condition);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jan-2016 </b> <b>Method :
	 * RTC_388860 <b>Description : Test for bug 244526 - Server 500 error is
	 * thrown when user releases a PO. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_388860(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Keep Release order immediately - NO
			PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
			purchaseOrderSettings.setReleaseOrdersImmediately(false);
			purchaseOrderSettings.setNextAction(IConstantsData.NONE);
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);
			PagePurchaseOrderSetting.fillReleasePOAutomaticParkValue(driver, testCaseName, 5);
			PagePurchaseOrderSetting.clickOnSaveButton(driver, testCaseName);

			// create PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// approve PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(standardPO.getPoNumber());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// check parked status
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equalsIgnoreCase(IConstantsData.PARKED_FILTER);
			Assert.assertTrue("PO is not in parked state, which is wrong", flag);

			// Release parked PO
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultSleep();
			String state = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag1 = state.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			Assert.assertTrue("PO has not released successfuly", flag1);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
				// Keep Release order immediately - YES
				PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
				purchaseOrderSettings.setReleaseOrdersImmediately(true);
				purchaseOrderSettings.setNextAction(IConstantsData.SAVE);
				purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);
			}

			catch (Exception e)
			{
				logger.error("Error while changing release order immetiately to YES" + e, e);
			}

			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 21-Jan-2016 </b> <b>Method :
	 * RTC_377115 <b>Description : Remind supplier >> payment term displayed
	 * should be that selected in the purchase order. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377115(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377114"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377107"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377106"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// view PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			ActionBot.scroll(driver, "300");
			String PT = PageViewPurchaseOrder.getPaymentTerms(driver, testCaseName);
			boolean terms = PT.equals(standardPO.getPaymentTerms());
			Assert.assertTrue("Payment terms is not same as entered while creating PO", !terms);
			ActionBot.scrollUp(driver, "300");
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnRemindPoLink(driver, testCaseName);
			ModalRemindSupplier.fillRemindSupplierTo(driver, testCaseName, "eproc.autox@zycus.com");
			ModalRemindSupplier.fillMessageForRemindSupplier(driver, testCaseName, IConstantsData.EMAIL_PO_MESSAGE);
			ModalRemindSupplier.clickOnSendButton(driver, testCaseName);
			boolean flag = (ActionBot.isElementDisplayed(driver, IModalRemindSupplier.TEXTBOX_REMIND_MESSAGE)) ? false : true;
			//	boolean flag = ModalRemindSupplier.isSuccessMessagePresent(driver, testCaseName);
			Assert.assertTrue("Remind supplier email has not been successfuly send", flag);

			// copy PO

			if (ActionBot.isElementDisplayed(driver, IPageViewPurchaseOrder.COPY_PO_LINK))
			{
				PageViewPurchaseOrder.clickOnCopyPO(driver, testCaseName);
			}
			else
			{
				PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
				PageViewPurchaseOrder.clickOnCopyPO(driver, testCaseName);
			}
			PageStandardPO.enterSupplierName(driver, CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			String str1 = PageStandardPO.getPaymentTerms(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			String str2 = PageViewPurchaseOrder.getPaymentTerms(driver, testCaseName);
			boolean flag2 = str2.equals(str1) ? true : false;
			mappedTestCases.get(0).setTestResult(flag2);
			mappedTestCases.get(1).setTestResult(flag2);
			mappedTestCases.get(2).setTestResult(flag2);
			Assert.assertTrue("Payment terms is not same as entered before , after copying the same PO", flag2);

			// check ammended PO
			//			PagePurchaseOrderListing.clickOnViewAmmendedPO(driver, testCaseName);
			//PageAmmendedPO.clickOnFirstAmendPONo(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Jan-2016 </b> <b>Method :
	 * RTC_376850 <b>Description : user should be able to select the checkbox
	 * "Mark for adding approvers" in the predicted workflows of standard
	 * purchase order. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_376850(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_376849"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_376848"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_376847"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_376846"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_376845"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setNextAction(IConstantsData.NONE);

			FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			String poNo2 = FlowStandardPo.submitPoForProcessing(driver, testCaseName, true);
			if (poNo2 != null)
			{
				standardPO.setPoNumber(poNo2);
			}

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);
			// check status
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.contains(IConstantsData.READY_FOR_APPROVAL_FILTER_LABEL);
			Assert.assertTrue("PO hasnt went in Ready for approval state even when mark for adding approvers is checked YES", flag);
			mappedTestCases.get(0).setTestResult(flag);

			// add approver
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			ActionBot.scroll(driver, "1300");
			ActionBot.defaultSleep();
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.Third_Approver));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			ActionBot.defaultSleep();
			String actor = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 2);
			boolean flag1 = actor.equals(CommonServices.getTestData(IConstantsData.Third_Approver)) ? true : false;
			Assert.assertTrue("New actor has not been added successfully", flag1);
			mappedTestCases.get(1).setTestResult(flag1);
			mappedTestCases.get(2).setTestResult(flag1);
			ActionBot.defaultSleep();
			// add approver after named actor
			PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalAddApprover.fillApproverName(driver, testCaseName, CommonServices.getTestData(IConstantsData.Fourth_Approver));
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 2);
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
			ActionBot.defaultSleep();
			String actor1 = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, 3);
			boolean flag2 = actor1.equals(CommonServices.getTestData(IConstantsData.Fourth_Approver)) ? true : false;
			Assert.assertTrue("New actor has not been added after named actor successfully", flag1);
			mappedTestCases.get(3).setTestResult(flag2);
			mappedTestCases.get(4).setTestResult(flag2);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Jan-2016 </b> <b>Method :
	 * RTC_376842 <b>Description : For requisition > po; po should never go in
	 * ready for approval state </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_376842(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create req and convert to PO
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			CombineFlowImpl.reqToPO(driver, testCaseName, requisition);

			// check status of req
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, requisition.getPoNo());
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equals(IConstantsData.IN_APPROVAL_FILTER_LABEL) ? true : false;

			/*
			 * requisition = CombineFlowImpl.reqToPO(driver, testCaseName,
			 * requisition);
			 * 
			 * // check status of req
			 * MainPageHeaderLevelTab.clickOnPOTab(driver);
			 * PagePurchaseOrderListing.fillPoNo(driver, testCaseName,
			 * requisition.getPoNo()); String status =
			 * PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			 * boolean flag =
			 * status.equals(IConstantsData.IN_APPROVAL_FILTER_LABEL) ? true :
			 * false;
			 */

			Assert.assertTrue("Status of PO is not as required", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
	 * <b>Author: payal.alag </b> <b>Created On : 25-Jan-2016 </b> <b>Method :
	 * RTC_376841 <b>Description : For requisition > po;if auto po is on; po
	 * should never go in ready for approval state </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_376841(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// keep auto release PO seting ON
			PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
			purchaseOrderSettings.setAutomaticallyGenerateOrders(true);
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);

			// create req
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			Requisition requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// approve req
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			// check PO status
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equals(IConstantsData.IN_APPROVAL_FILTER_LABEL) ? true : false;
			Assert.assertTrue("Status of PO is not as required", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

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
				// keep auto release PO seting OFF
				PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
				purchaseOrderSettings.setAutomaticallyGenerateOrders(false);
				purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);
			}
			catch (Exception e)
			{
				logger.error("Error while keeping auto generate PO to NO" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 28-Jan-2016 </b> <b>Method :
	 * RTC_377163 <b>Description : Standard PO >> Verify that payment terms
	 * defaulted from SIM are also present in CMD. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377163(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377161"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377160"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377157"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377155"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377154"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user2 = null;
		try
		{
			// login in EPROC
			User user = LoginLogoutServices.login(driver, testCase);

			// create PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			// String pt = standardPO.getPaymentTerms();
			FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// get payemnt terms
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String pt = PageViewPurchaseOrder.getPaymentTerms(driver, testCaseName);

			// amend PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getFutureDayDate());
			PageStandardPO.fillRequiredByDate(driver, testCaseName, purchaseOrder.getCustomDate().getDay(), purchaseOrder.getCustomDate().getMonth(),
				purchaseOrder.getCustomDate().getYear());
			ActionBot.scroll(driver, "900");
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			// logout from EPROC
			LoginLogoutServices.logout(driver, testCase, user);

			// login in TMS
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
			user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

			// check payment terms
			TMS_paymentTermsSettings tms_paymentTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms(pt, null);
			String str = FlowTMSPaymentTermsSettingsFlow.getPaymentTerm(driver, testCaseName, tms_paymentTermsSettings, 3);
			boolean flag = str.equals(pt) ? true : false;
			Assert.assertTrue("Payment term used in eproc is not present in TMS, which is wrong", flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
			mappedTestCases.get(2).setTestResult(flag);
			mappedTestCases.get(3).setTestResult(flag);
			mappedTestCases.get(4).setTestResult(flag);

			// LoginLogoutServices.logout(driver, testCase, user2);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

		{
			CommonServices.assertionMethod(driver, testCase, user2, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user2, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user2, mappedTestCases);

		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 29-Jan-2016 </b> <b>Method :
	 * RTC_377159 <b>Description : Standard PO >> Verify that updated payment
	 * terms is displayed in the purchase order on every edit. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377159(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377158"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user2 = null;
		User user = null;

		try
		{
			// login in EPROC
			user = LoginLogoutServices.login(driver, testCase);

			// create PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			// logout from EPROC
			LoginLogoutServices.logout(driver, testCase, user);

			// login in TMS
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
			user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

			// change payment terms
			TMS_paymentTermsSettings tms_paymentTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM),
				"Temp33");
			String str = tms_paymentTermsSettings.getPaymentTermName();
			FlowTMSPaymentTermsSettingsFlow.editPaymentTerm(driver, testCaseName, tms_paymentTermsSettings, 1);

			// logout from TMS
			LoginLogoutServices.logout(driver, testCase, user2);

			// login in EPROC
			LoginLogoutServices.login(driver, testCase);

			// recall PO and check PT
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String paymentTerms = PageViewPurchaseOrder.getPaymentTerms(driver, testCaseName);
			boolean flag1 = paymentTerms.equals(str) ? true : false;
			Assert.assertTrue("Payment terms is not updated with the new payment term", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnRecallApprovalRequestFromActions(driver, testCaseName);
			ModalPORecallApprovalRequest.fillRecallComments(driver, testCaseName, IConstantsData.RECALL_COMMENT);
			ModalPORecallApprovalRequest.clickOnRecallButton(driver, testCaseName);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String pt = PageStandardPO.getSupplierPaymentTerms(driver, testCaseName);
			boolean flag = pt.equals(str) ? true : false;
			Assert.assertTrue("Payment term is not updated even though payment term is changed in cmd", !flag);

			// logout from eproc
			LoginLogoutServices.logout(driver, testCase, user);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

		{
			CommonServices.assertionMethod(driver, testCase, user2, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user2, e);
		}

		finally
		{
			try
			{
				// logout from eproc
				LoginLogoutServices.logout(driver, testCase, user);

				// login in TMS
				user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
				user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

				// change payment terms
				TMS_paymentTermsSettings tmTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms("Temp33", CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM));
				FlowTMSPaymentTermsSettingsFlow.editPaymentTerm(driver, testCaseName, tmTermsSettings, 1);

				// logout from TMS
				LoginLogoutServices.logout(driver, testCase, user2);
			}

			catch (Exception e)
			{
				logger.error("Error while changing payment terms in TMS" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user2, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 01-Feb-2016 </b> <b>Method :
	 * RTC_377153 <b>Description : Amend PO >> Verify that updated payment terms
	 * is displayed in the purchase order on every edit. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377153(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_377152"));

		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user2 = null;
		User user = null;

		try
		{
			// login in EPROC
			user = LoginLogoutServices.login(driver, testCase);

			// create PO
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM));
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			// logout from EPROC
			LoginLogoutServices.logout(driver, testCase, user);

			// login in TMS
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
			user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

			// change payment terms
			TMS_paymentTermsSettings tms_paymentTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM),
				"Temp33");
			String str = tms_paymentTermsSettings.getPaymentTermName();
			FlowTMSPaymentTermsSettingsFlow.editPaymentTerm(driver, testCaseName, tms_paymentTermsSettings, 1);

			// logout from TMS
			LoginLogoutServices.logout(driver, testCase, user2);

			// login in EPROC
			LoginLogoutServices.login(driver, testCase);

			// Ammend PO and check PT
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			String paymentTerms = PageViewPurchaseOrder.getPaymentTerms(driver, testCaseName);
			boolean flag1 = paymentTerms.equals(str) ? true : false;
			Assert.assertTrue("Payment terms is not updated with the new payment term", flag1);
			mappedTestCases.get(0).setTestResult(flag1);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			String pt = PageStandardPO.getSupplierPaymentTerms(driver, testCaseName);
			boolean flag = pt.equals(str) ? true : false;
			Assert.assertTrue("Payment term is not updated even though payment term is changed in cmd", !flag);

			// logout from eproc
			LoginLogoutServices.logout(driver, testCase, user);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)

		{
			CommonServices.assertionMethod(driver, testCase, user2, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user2, e);
		}

		finally
		{
			try
			{
				// logout from eproc
				LoginLogoutServices.logout(driver, testCase, user);

				// login in TMS
				user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
				user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

				// change payment terms
				TMS_paymentTermsSettings tmTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms("Temp33", CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM));
				FlowTMSPaymentTermsSettingsFlow.editPaymentTerm(driver, testCaseName, tmTermsSettings, 1);

				// logout from TMS
				LoginLogoutServices.logout(driver, testCase, user2);
			}

			catch (Exception e)
			{
				logger.error("Error while changing payment terms in TMS" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user2, mappedTestCases);
			}
		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 03-Feb-2016 </b> <b>Method :
	 * RTC_377113 <b>Description : For parked pos check releasing the po when
	 * payment term is deactivated. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_377113(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user2 = null;
		User user = null;

		try
		{
			// login in EPROC
			user = LoginLogoutServices.login(driver, testCase);

			// keep auto release to po NO
			PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
			purchaseOrderSettings.setReleaseOrdersImmediately(false);
			purchaseOrderSettings.setReleaseOrderDays(5);
			purchaseOrderSettings.setNextAction(IConstantsData.SAVE);
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);

			// create PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			StandardPO standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO.setPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM));
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);
			FlowPoListing.approveAndReleasePO(driver, testCaseName, standardPO.getPoNumber());

			// logout from EPROC
			LoginLogoutServices.logout(driver, testCase, user);

			// login in TMS
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
			user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

			// deactive payment term
			TMS_paymentTermsSettings tms_paymentTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM), null);

			tms_paymentTermsSettings.setChangeStatus(IConstantsData.ACTIVE_STATUS);
			FlowTMSPaymentTermsSettingsFlow.changeStatusOfPaymentTerm(driver, testCaseName, tms_paymentTermsSettings, 1);

			// logout from TMS
			LoginLogoutServices.logout(driver, testCase, user2);

			// login in EPROC
			LoginLogoutServices.login(driver, testCase);

			// Release parked PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, standardPO.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnReleasePOFromActions(driver, testCaseName);
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultSleep();
			ActionBot.defaultHighSleep();
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status.equals(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL) ? true : false;
			Assert.assertTrue("PO has not released with the deactivated payment term, which is wrong", flag);

			// keep auto release po to YES
			PurchaseOrderSettings purchaseOrderSettings1 = new PurchaseOrderSettings();
			purchaseOrderSettings1.setReleaseOrdersImmediately(true);
			purchaseOrderSettings1.setNextAction(IConstantsData.SAVE);
			purchaseOrderSettings1 = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings1);

			// logout from eproc
			LoginLogoutServices.logout(driver, testCase, user);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)

		{
			CommonServices.assertionMethod(driver, testCase, user2, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user2, e);
		}

		finally
		{
			try
			{
				/*
				 * //logout from eproc LoginLogoutServices.logout(driver,
				 * testCase, user);
				 * 
				 * //login in EPROC user = LoginLogoutServices.login(driver,
				 * testCase);
				 * 
				 * //keep auto release po to YES PurchaseOrderSettings
				 * purchaseOrderSettings1 = new PurchaseOrderSettings();
				 * purchaseOrderSettings1.setReleaseOrdersImmediately(true);
				 * purchaseOrderSettings1.setNextAction(IConstantsData.SAVE);
				 * purchaseOrderSettings1 =
				 * FlowPurchaseOrderSetting.changePOSetting(driver,
				 * testCaseName, purchaseOrderSettings1);
				 */

				// logout from eproc
				LoginLogoutServices.logout(driver, testCase, user);

				// login in TMS
				user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "Client_Admin");
				user2 = LoginLogoutServices.login(driver, testCase, user2, IConstants.TMS);

				// deactive payment term
				TMS_paymentTermsSettings tms_paymentTermsSettings = ObjectCreation.getDefaultObjectOfPaymentTerms(CommonServices.getTestData(IConstantsData.TEMP_PAYMENT_TERM),
					null);
				tms_paymentTermsSettings.setChangeStatus(IConstantsData.INACTIVE_STATUS);
				FlowTMSPaymentTermsSettingsFlow.changeStatusOfPaymentTerm(driver, testCaseName, tms_paymentTermsSettings, 1);

				// logout from TMS
				LoginLogoutServices.logout(driver, testCase, user2);
			}

			catch (Exception e)
			{
				logger.error("Error while changing payment terms in TMS" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user2);
			}
		}
	}
}
