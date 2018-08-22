package com.zycus.automation.eproc.testcase.regression.Bpo;

import static org.junit.Assert.assertTrue;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.MasterDataTenantConfig;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.bo.PoStatusFilter;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.amendedpoflow.FlowAmendedPO;
import com.zycus.automation.eproc.businessflow.bpoflow.FlowBPO;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.FlowFillGuidedItem;
import com.zycus.automation.eproc.businessflow.flipinvoice.FlowFlipInvoice;
import com.zycus.automation.eproc.businessflow.masterdatatenantconfigflow.FlowMasterDataTenantConfig;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.nonpoinvoice.FlowNonPoInvoice;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.businessflow.viewpoflow.FlowViewPO;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.IModalPOFreeTextItemSummaryItemImpl;
import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.ModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation.ModalPOFreeTextItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery.ModalPOSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem.ModalBlanketOrdersForFreeTextItem;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.discountstandardpo.ModalDiscountPO;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.poactions.ModalPOActions;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.IModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.ModalPOSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.PageAmmendedPO;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.bpo.PageBPO;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.PageCreateNonPOInvoice;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.po.PagePO;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.IPageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.validation.VerifyShoppingItemsWithShoppingCarts;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class BPOtestcases extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(BPOtestcases.class);
	static String	bpoNo	= null;

	/*********************************************
	 * AmitKumar's TestCases
	 *****************************************************/

	/**
	 * 
	 * <b>Author: Amitkumar.dash </b> <b>Created On : 29-Sep-2015 </b> <b>Method :
	 * <b>Description : Activity log should be maintained for amended BPO document.
	 * </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_140504(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// 140519 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140519"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140522"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140527"));
		}
		CommonServices.startTestCase(driver, testCase);
		String deliverTo = CommonServices.getTestData(IConstantsData.DELIVER_TO_FIELD);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create bpo and release
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
			FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			// check delivery details editable or not
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCustomDate(CommonUtilities.getRequiredBy());
			PageStandardPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			// change other address and my address
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PageBPO.clickOnAlertPopUpTaxesIfDefinedOkButton(driver, testCaseName);

			PageStandardPO.clickOnEdit(driver);

			TabPOSummary.clickOnDeliveryPOSummary(driver);
			String dTo = ModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
			String dToName = ModalPOSummaryDelivery.fillDeliverTo(driver, testCaseName, deliverTo);
			// check validation
			boolean flag = dToName.equalsIgnoreCase(dTo);
			Assert.assertTrue(!flag);
			mappedTestCases.get(0).setTestResult(!flag);
			mappedTestCases.get(1).setTestResult(!flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
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
	 * <b>Author: Amitkumar.dash </b> <b>Created On : 29-Sep-2015 </b> <b>Method :
	 * RTC_191813 <b>Description : Test for bug 210299 - Incorrect validation shown
	 * for item qty displayed while amending bpo qty </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider")
	public void RTC_191813(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// 140519 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_191841"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_193138"));
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create bpo and release
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setNextAction(IConstantsData.NONE);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.clearQuantity(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			// fill item quantity
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 232);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			bpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
			bpoNo = bpo.getPoNumber();
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			// PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}
			FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
			// change item details quantity
			PageStandardPO.clickOnAmendItemSummaryEdit(driver);
			ModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.clearQuantity(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			// check delete link
			PageStandardPO.clickOnItemCopyLink(driver);
			PageStandardPO.clickOnItemDeleteLink(driver);
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				Assert.assertTrue(true);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}

			// check bpo from valid date
			ActionBot.scroll(driver);
			boolean flag = PageBPO.isFromValiditydateDisplayedAslabel(driver, testCaseName);
			Assert.assertTrue(flag);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	// passed
	/**
	 * 
	 * <b>Author: Amitkumar.dash </b> <b>Created On : 30-Sep-2015 </b> <b>Method :
	 * <b>Description : There should be setting at Tenant Configuration>>Purchase
	 * Order>>Control: Do not allow buyers to increase item unit price while
	 * amending BPO more than: [X] % (default: 5%) </font> <b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_140513(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			// 140514 : testcase to be mapped
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140514"));

		}
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create bpo and release
			MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
			PageCustomizeSettings.clickOnPurchaseOrderLink(driver, testCaseName);
			int exceedsPer = CommonUtilities.getNonZeroRandomNumbers(2);
			PagePurchaseOrderSetting.fillBPOTotalExceedsPer(driver, testCaseName, exceedsPer);
			PagePurchaseOrderSetting.clickOnBPOAmountIncreasedUptoLarger(driver, testCaseName);
			boolean flag = PagePurchaseOrderSetting.clickOnBPOAmountIncreasedUptoSmaller(driver, testCaseName);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/*********************************************
	 * Payal's TestCases
	 *****************************************************/

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 29-Sep-2015 </b> <b>Method :
	 * CreateBPO <b>Description : CreateBPO </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void CreateNewBPO(TestCase testCase) throws Exception
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
	 * <b>Author: payal.alag </b> <b>Created On : 29-Sep-2015 </b> <b>Method :
	 * RTC_140432 <b>Description : User should be able to amend a released BPO by
	 * clicking 'Amend BPO' action on view page. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// sameer
	@Test(dataProvider = "dataProvider")
	public void RTC_140432(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		String bpoNo = null;
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140433"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140434"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140436"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140438"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140439"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140440"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140444"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140445"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140446"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140451"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140459"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183655"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140477"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
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

			// ammend released bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// change other address and my address
			PageBPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryDelivery.fillMyAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.MY_ADDRESS));
			ModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
			ModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);
			PageBPO.clickOnAlertPopUpTaxesIfDefinedOkButton(driver, testCaseName);

			// change deliver to field
			PageBPO.clickOnEdit(driver);
			TabPOSummary.clickOnDeliveryPOSummary(driver);
			String oldDeliverTo = ModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
			ModalPOSummaryDelivery.fillDeliverTo(driver, testCaseName, CommonServices.getTestData(IConstantsData.DIFFERENT_USER));
			String newDeliverTo = ModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
			boolean deliverTo = newDeliverTo != oldDeliverTo ? true : false;
			Assert.assertTrue("Deliver To has not changed or its not editable which is wrong", deliverTo);
			mappedTestCases.get(0).setTestResult(deliverTo);
			mappedTestCases.get(1).setTestResult(deliverTo);
			mappedTestCases.get(2).setTestResult(deliverTo);
			mappedTestCases.get(3).setTestResult(deliverTo);
			ModalPOSummaryCostBooking.clickOnSave(driver, testCaseName);

			// change delivery terms
			PageBPO.selectDeliveryTerms(driver, CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));

			// change payment terms
			PageBPO.enterPaymentTerms(driver, CommonServices.getTestData(IConstantsData.PAYMENT_TERMS));

			// enter reference
			boolean reference = PageBPO.isEditableReference(driver, CommonServices.getTestData(IConstantsData.BUYER_NAME));
			Assert.assertTrue("Reference field is not editable , which is wrong", reference);
			mappedTestCases.get(4).setTestResult(reference);
			mappedTestCases.get(5).setTestResult(reference);
			mappedTestCases.get(6).setTestResult(reference);
			mappedTestCases.get(7).setTestResult(reference);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");

			// change quantity
			PageBPO.clickOnAmendItemSummaryEdit(driver);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 20);
			ModalPOFreeTextItemSummaryItem.clearMaxTotalPrice(driver, testCaseName);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,850)", "");

			// change tax
			PageBPO.selectTaxType(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_TYPE), 2);
			PageBPO.enterFreeTextTaxName(driver, testCaseName, CommonServices.getTestData(IConstantsData.TAX_NAME), 2);
			PageBPO.enterTaxRate(driver, testCaseName, 5, 2);
			PageBPO.clickOnTaxAmount(driver, testCaseName, 2);

			// enter discount
			PageBPO.clickOnModify(driver, testCaseName);
			ModalDiscountPO.fillDiscountAmount(driver, testCaseName, 500);
			ModalDiscountPO.clickOnSaveDiscount(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,550)", "");

			// enter notes and change comments
			PageBPO.enterNotes(driver, testCaseName, IConstantsData.PO_TO_BE_GENERATED_NOTES);
			PageBPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);

			// select receipt required setting
			PageBPO.clickOnRequireReceiptAgainstPO(driver, testCaseName);

			// save ammended bpo as draft
			PageBPO.clickOnSaveAsDraftPo(driver);

			String number = PageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);
			boolean no = number.equalsIgnoreCase(bpoNo) ? true : false;
			Assert.assertTrue("Bpo has not been saved succesfully", no);
			mappedTestCases.get(8).setTestResult(no);
			mappedTestCases.get(9).setTestResult(no);
			mappedTestCases.get(10).setTestResult(no);
			mappedTestCases.get(11).setTestResult(no);
			mappedTestCases.get(12).setTestResult(no);
			PageAmmendedPO.clickOnViewAllPO(driver, testCaseName);
			PagePurchaseOrderListing.clickOnViewAmmendedPO(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: payal.alag </b> <b>Created On : 30-Sep-2015 </b> <b>Method :
	 * RTC_140468 <b>Description : Amend BPO: In case of BPO ; allow adding more
	 * items to it. </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */

	@Test(dataProvider = "dataProvider")
	public void RTC_140468(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;

		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140470"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140471"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183979"));
			}

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

			// ammend bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// add item
			Item item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			item = FlowStandardPo.addItem(driver, testCaseName, item);

			bpo.getItems().getGuidedItems().get(0).setItemID(PageStandardPO.getItemId(driver, bpo.getItems().getGuidedItems().get(0).getShortDescription()));

			// delete items and submit
			logger.info("guided item id: " + bpo.getItems().getGuidedItems().get(0).getItemID());
			logger.info("catalog item id : " + item.getCatelogItems().get(0).getItemID());

			PageBPO.clickOnDeleteButton(driver, testCaseName, bpo.getItems().getGuidedItems().get(0).getItemID());

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			PageBPO.clickOnDeleteButton(driver, testCaseName, item.getCatelogItems().get(0).getItemID());
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageBPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			PageBPO.clickOnSubmitPOForProcessing(driver);

			// check item alert error
			boolean itemAlert = PageBPO.isValidationMapCheckErrorPresent(driver, testCaseName);
			Assert.assertTrue("Item alert message is not displayed even after deleting all items of bpo", itemAlert);
			mappedTestCases.get(0).setTestResult(itemAlert);
			PageBPO.clickOnOKForClickHereError(driver, testCaseName);

			// check for buttons
			boolean draft = PageBPO.isSaveAsDraftlinkpresent(driver);
			Assert.assertTrue("Save as draft button is not present", draft);
			mappedTestCases.get(1).setTestResult(draft);
			boolean submit = PageBPO.isSubmitPoForProcessingButtomPresent(driver);
			Assert.assertTrue("Submit button is not present", submit);
			mappedTestCases.get(2).setTestResult(submit);
			boolean cancel = PageBPO.isCancelLinkPresent(driver);
			Assert.assertTrue("Cancel button is not present", cancel);

			ActionBot.moveToElement(driver, IPageStandardPO.BUTTON_ADD_ITEM);
			ActionBot.defaultHighSleep();

			FlowStandardPo.searchItem(driver, testCaseName, item.getCatelogItems().get(0));

			List<WebElement> quantityInputs = PageStandardPO.fillQuantity(driver, testCaseName);

			List<WebElement> addButtons = PageStandardPO.Additem(driver, testCaseName);

			WebElement quantityElement = quantityInputs.get(0);
			ActionBot.scroll(driver, quantityElement);
			quantityElement.clear();
			quantityElement.sendKeys(Integer.toString(item.getCatelogItems().get(0).getQuantity()));
			logger.info("Entered Quantity : " + quantityElement.getAttribute("value").trim());
			ScreenShot.screenshot(driver, testCaseName, "After adding Quantity");
			ActionBot.defaultSleep();
			WebElement addBtnElement = addButtons.get(0);
			Actions actions = new Actions(driver);
			actions.moveToElement(addBtnElement).click().build().perform();

			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				ActionBot.defaultSleep();
			}
			else
			{
				PageBPO.clickOnItemName(driver, testCaseName);
			}
			ActionBot.sendKeys(driver, IModalPOFreeTextItemSummaryItemImpl.TEXTBOX_LINE_NO, Integer.toString(CommonUtilities.getNonZeroRandomNumbers(4)));
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
			ActionBot.defaultSleep();

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
	 * <b>Author: payal.alag </b> <b>Created On : 01-Oct-2015 </b> <b>Method :
	 * RTC_140474 <b>Description : Amend BPO>>Item Amend>>EDIT: It should allow to
	 * modify line items details for that same line </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// sameer
	@Test(dataProvider = "dataProvider")
	public void RTC_140474(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140475"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140472"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140473"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140469"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140465"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
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

			// ammend bpo
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo.getPoNumber());
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// edit item
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			PageBPO.clickOnAmendItemSummaryEdit(driver);
			ActionBot.jQueryScroll(driver, ".eformItemInpt.ui-front", 600);
			ModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, 20);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);

			// copy item
			PageBPO.clickOnFirstItemCopyLink(driver, testCaseName);

			// summit ammended bpo
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageBPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, bpoNo);
			jsx.executeScript("window.scrollBy(0,650)", "");
			String oldItem = PageViewPurchaseOrder.getItemNames(driver, testCaseName, 1);
			String copiedItem = PageViewPurchaseOrder.getItemNames(driver, testCaseName, 2);
			boolean item = copiedItem.equalsIgnoreCase(oldItem) ? true : false;
			Assert.assertTrue("Original item and copied item are not shown on different lines in view page , which is wrong", item);
			mappedTestCases.get(0).setTestResult(item);
			mappedTestCases.get(1).setTestResult(item);
			mappedTestCases.get(2).setTestResult(item);
			mappedTestCases.get(4).setTestResult(item);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status1 = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			boolean flag = status1.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			Assert.assertTrue("BPO is not in released state after submitting ammended bpo", flag);
			mappedTestCases.get(3).setTestResult(flag);
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);

		}
	}

	/**
	 * 
	 * <b>Author: payal.alag </b> <b>Created On : 06-Oct-2015 </b> <b>Method :
	 * RTC_140464 <b>Description : Amend BPO: Not received/invoiced items of BPO
	 * only should be allowed to remove. [Check case where invoice is returned and
	 * and resubmitted after item removal] </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// sameer
	@Test(dataProvider = "dataProvider")
	public void RTC_140464(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String bpoNo = null;
		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			// create bpo
			BPO bpo = ObjectCreation.getBPOCreation(IConstantsData.BOTH);
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

			// bor object creation
			BPO bpo_release = ObjectCreation.getDefaultObjectOfBOR();
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);

			// to change quantity of item
			Item item = bpo.getItems();
			item.getGuidedItems().get(0).setQuantity((float) bpo.getItems().getCatelogItems().get(0).getQuantity() - 2);
			bpo_release.setItems(item);
			bpo_release.setNextAction(IConstantsData.NONE);

			// to create release
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);
			String bpo_Release_No = bpo_release.getReleaseNo();

			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			// create invoice
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo_Release_No);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateInvoiceFromActions(driver, testCaseName);
			Invoice invoice = ObjectCreation.getDefaultFlipInvoiceObject();
			invoice.setNextAction(IConstantsData.NONE);
			invoice = FlowFlipInvoice.createFlipInvoice(driver, testCaseName, invoice);
			PageCreateNonPOInvoice.clickOnSelectAllItems(driver, testCaseName);
			PageCreateNonPOInvoice.clickOnFirstItemCheckbox(driver, testCaseName);
			PageCreateNonPOInvoice.fillBaseExchangeRate(driver, testCaseName, "1");
			FlowNonPoInvoice.submitInvoice(driver, testCaseName);

			// ammend bpo
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo_Release_No);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,550)", "");
			PageBPO.clickOnDeleteButton(driver, testCaseName, bpo_release.getItems().getGuidedItems().get(0).getItemID());
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,950)", "");
			PageBPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
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

	/*********************************************
	 * Ankita's TestCases
	 *****************************************************/

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>The blanket order should go through the same
	 * Statuses as the standard PO. Additionally, an 'Expired' status when the
	 * validity expires, after which it can only be closed or amended. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the type of BPO, it should be
	 * Blanket </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// sameer
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_135100(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		new BPO();
		BPO new_bpo = new BPO();
		boolean flag = false;
		String url, type, status, bpoNo;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of BPO was wrong, it should be draft", flag);

			// view BPO
			logger.info("============== View BPO ==============");
			FlowPoListing.viewPO(driver, testCaseName);

			// submit BPO
			logger.info("============== Submit BPO ==============");
			bpoNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (bpoNo != null)
			{
				bpo.setPoNumber(bpoNo);
			}

			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// view BPO
			FlowPoListing.viewPO(driver, testCaseName);

			// to close the BPO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnClosePoLink(driver, testCaseName);

			// to close BPO
			FlowViewPO.closePO(driver, testCaseName);

			// search Bpo
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			// check status
			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.CLOSED_FILTER_LABEL);
			assertTrue("Status of BPO was wrong, BPO it should be closed", flag);

			// copy BPO
			logger.info("============== Copying BPO ==============");
			FlowBPO.copyBPO(driver, testCaseName, bpo.getItems());

			// to create new BPO from copied BPO
			logger.info("============== Creating new BPO from copied BPO ==============");
			// data for new BPO
			new_bpo.setPoNumber("Copy_OF_" + bpo.getPoNumber());
			// from validity date
			CustomDate fromDate = CommonUtilities.getTodaysDate();
			new_bpo.setFromValidityDate(fromDate);
			// to validity date
			CustomDate toDate = CommonUtilities.getTodaysDate();
			toDate.setYear(toDate.getYear() + CommonUtilities.getNonZeroRandomNumbers(1));
			new_bpo.setToValidityDate(toDate);
			new_bpo = FlowBPO.fillBPOCreationForm(driver, testCaseName, new_bpo);

			// submit BPO
			logger.info("============== Submit BPO ==============");
			bpoNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (bpoNo != null)
			{
				new_bpo.setPoNumber(bpoNo);
			}

			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, new_bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// view BPO
			FlowPoListing.viewPO(driver, testCaseName);

			// cancel BPO
			FlowViewPO.cancelPo(driver, testCaseName);

			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, new_bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.CANCELLED_FILTER_LABEL);
			assertTrue("Status of BPO was wrong, BPO it should be Cancelled", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> Release No should be editable- serial number
	 * starting from 1, duplicates not allowed for same BPO, cannot change when
	 * amending release.-Check validations. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_136258(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_136256"));
		}
		User user = null;
		BPO bpo = new BPO();
		BPO bpo_release = new BPO();
		boolean flag = false, isPresentFlag = false;
		String url, type, status, error, log = "";
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpo.getPoNumber(), IConstantsData.BPO,
					IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search bpo
				flag = FlowPoListing.searchPo(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);

				driver.navigate().refresh();

				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// bor object creation
			bpo_release = ObjectCreation.getDefaultObjectOfBOR();
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);

			// to change quantity of item
			Item item = bpo.getItems();
			item.getCatelogItems().get(0).setMarketPrice(null);
			item.getCatelogItems().get(0).setQuantity(bpo.getItems().getCatelogItems().get(0).getQuantity() - 2);
			bpo_release.setItems(item);
			bpo_release.setNextAction(IConstantsData.NONE);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);

			// to check validations for release no :
			PageStandardPO.fillReleaseNo(driver, testCaseName, "");
			PageStandardPO.fillOrderDescription(driver, testCaseName, bpo.getOrderDescription());

			error = PageStandardPO.getReleaseNoError(driver, testCaseName);
			flag = error.equalsIgnoreCase(PropertyReader.messageProperty.getProperty(IConstantsData.Release_No_Error));
			assertTrue("Release no error was not present after adding blank release no", flag);

			String[] temp = StringUtils.split(bpo_release.getReleaseNo(), "-");
			// to fill release no
			PageStandardPO.fillReleaseNo(driver, testCaseName, temp[1].trim());
			PageStandardPO.fillOrderDescription(driver, testCaseName, bpo.getOrderDescription());
			bpo_release.setReleaseNo(PageStandardPO.getAutogeneratedPoNo(driver, testCaseName));

			// submit release
			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo_release.setReleaseNo(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

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
			assertTrue("Type of BPO was wrong, it should be Release.", flag);

			// to create another release

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of BPO was not Released", flag);

			// bor object creation
			BPO bpo_release1 = ObjectCreation.getDefaultObjectOfBOR();
			CostBookingItemSummary costBookingItemSummary1 = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary1.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release1.setCostBookingItemSummary(costBookingItemSummary1);
			temp = StringUtils.split(bpo_release.getReleaseNo(), "-");
			bpo_release1.setReleaseNo(temp[1].trim());
			bpo_release1.setNextAction(IConstantsData.NONE);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release1 = FlowBPO.createRelease(driver, testCaseName, bpo_release1);

			// submit BOR
			ActionBot.defaultSleep();
			// if PO change field is present
			if (PageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName))
			{
				PageStandardPO.fillPOChangeField(driver, IConstantsData.PO_CHANGE_COMMENT);
			}

			PageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			error = PopUpDefaultConfirmation.getPopUpMsg(driver, testCaseName);
			flag = error.equalsIgnoreCase(PropertyReader.messageProperty.getProperty(IConstantsData.AlreadyExisting_ReleaseNo_ErrorMsg));
			assertTrue("Duplicate Release no error was wrong", flag);

			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			bpo_release1.setReleaseNo(PageStandardPO.getPONo(driver, testCaseName));

			/*
			 * //submit release FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			 */

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.RELEASE_PO_TYPE);
			assertTrue("Error while searching release", flag);

			// amend release
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// to check release no is editable or not in amend release
			isPresentFlag = PageStandardPO.isLabelReleaseNoPresent(driver, testCaseName);

			// to check release no while amending release
			String releaseNo = PageStandardPO.getValueOfLabelReleaseNo(driver, testCaseName);
			temp = StringUtils.split(bpo_release.getReleaseNo(), "-");
			flag = releaseNo.equalsIgnoreCase(temp[1].trim());

			if (!isPresentFlag)
			{
				log += "Release no was editable while amending release. \n";
			}
			if (!flag)
			{
				log += "Release no was not same while amending release. ";
			}
			CommonServices.setMappedTestCaseResult(flag && isPresentFlag, mappedTestCases.get(0), log);

			assertTrue("Release no was editable while amending release", isPresentFlag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <font color="blue">Method :</b>If another buyer edits a drafted copy of
	 * amended BPO; a message modal should come with following saying: 'This
	 * purchase order has already been amended by another Buyer.' <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_140488(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140487"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140491"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_140489"));
		}
		User user = null;
		User user2 = new User();
		BPO bpo = new BPO();
		boolean flag = false;
		String url, type, status, bpoNo, label1, label2;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo.setBuyer(user.getDisplayName());

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

			bpoNo = bpo.getPoNumber();

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpoNo, IConstantsData.BPO, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search bpo
				flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// save as draft
			FlowStandardPo.savePOAsDraft(driver, testCaseName);

			flag = PageAmmendedPO.isAmendedPOPresentInListing(driver, testCaseName, bpoNo);
			assertTrue("Drafted amended BPO was not present in Amend BPO Listing", flag);

			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, bpoNo);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of Amended BPO was wrong, It should be Draft", flag);

			/**
			 * RTC_140487 : At a time only one copy of an amended BPO should be present in
			 * draft.
			 **/
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			ActionBot.waitForPageLoad(driver);

			// save as draft
			FlowStandardPo.savePOAsDraft(driver, testCaseName);

			flag = PageAmmendedPO.isAmendedPOPresentInListing(driver, testCaseName, bpoNo);
			assertTrue("Drafted amended BPO was not present in Amend BPO Listing", flag);

			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, bpoNo);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of Amended BPO was wrong, It should be Draft", flag);

			flag = PageAmmendedPO.getNoOfAmendedPOPresentInListing(driver, testCaseName, bpoNo) == 1;
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "At a time only one copy of an amended BPO was not present in draft.");

			/**
			 * RTC_140491 : User should have an action - 'Roll Back' on amend BPO view page.
			 **/
			// view amended BPO
			FlowAmendedPO.viewAmendedPO(driver, testCaseName, bpoNo);

			flag = PageAmmendedPO.isRollBackPresent(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "RollBack button was not present on amend BPO view Page");

			// rollBack
			FlowAmendedPO.rollBackBPO(driver, testCaseName);

			flag = PageAmmendedPO.isRollBackPresent(driver, testCaseName);
			assertTrue("RollBack button was present on BPO view Page", !flag);

			// save as draft
			FlowStandardPo.savePOAsDraft(driver, testCaseName);

			flag = PageAmmendedPO.isAmendedPOPresentInListing(driver, testCaseName, bpoNo);
			assertTrue("Drafted amended BPO was not present in Amend BPO Listing", flag);

			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, bpoNo);
			flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			assertTrue("Status of Amended BPO was wrong, It should be Draft", flag);

			// logout
			LoginLogoutServices.logout(driver, testCase, user);

			// log in with another user
			user2 = UserUtilHelper.getAvailableUserFromList();
			UserUtilHelper.removeUserFromList(user2);
			UserUtilHelper.addUserToList(user);

			LoginLogoutServices.login(driver, testCase, user2);

			// view amended POs Page
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.clickOnViewAmmendedPO(driver, testCaseName);

			// click on amended BPO
			PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, bpoNo);

			/**
			 * RTC_140489 : If another buyer edits a drafted copy of amended BPO; a message
			 * modal should come with Action: 'Continue' (primary action) | 'Cancel'
			 **/
			label1 = PopUpDefaultConfirmation.getTextOfYesButton(driver, testCaseName);
			label2 = PopUpDefaultConfirmation.getTextOfNoButton(driver, testCaseName);

			flag = label1.equalsIgnoreCase("Continue") && label2.equalsIgnoreCase("Cancel");
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2),
				"If another buyer edits a drafted copy of amended BPO; a message modal was not come with Action: 'Continue' (primary action) | 'Cancel'");

			/**
			 * RTC_140488 : If another buyer edits a drafted copy of amended BPO; a message
			 * modal should come with following saying: 'This purchase order has already
			 * been amended by another Buyer.'
			 **/
			flag = PopUpDefaultConfirmation.getPopUpMsg(driver, testCaseName).trim().equalsIgnoreCase(IConstantsData.Already_Amended_By_Another_Buyer_ErrorMsg);
			assertTrue(
				"If another buyer edits a drafted copy of amended BPO; a message modal was not come with following saying: 'This purchase order has already been amended by another Buyer.'",
				flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <font color="blue">Method :</b> Test for bug 208445 - User coming blank for
	 * amendment confirmed activity in version document <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_183691(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183951"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183689"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_183661"));
		}
		User user = null;
		new User();
		BPO bpo = new BPO();
		boolean flag = false;
		String url, type, status, bpoNo;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBuyer(user.getDisplayName());
			bpo.getItems().getGuidedItems().get(0).setZeroPriceItem(true);
			bpo.getItems().getGuidedItems().get(0).setMaxUnitPrice(1236f);
			bpo.getItems().getGuidedItems().get(0).setMaxTotalPrice(1000000f);
			bpo.setAutoUpdate(false);
			bpo.setOrderValue("90000");

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

			bpoNo = bpo.getPoNumber();

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpoNo, IConstantsData.BPO, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search bpo
				flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// bor object creation
			BPO bpo_release = ObjectCreation.getDefaultObjectOfBOR();
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);

			// to change quantity of item
			Item item = bpo.getItems();
			item.getGuidedItems().get(0).setPrice(0);
			// to uncheck zero price item
			item.getGuidedItems().get(0).setZeroPriceItem(false);
			item.getGuidedItems().get(0).setQuantity(bpo.getItems().getGuidedItems().get(0).getQuantity() - 2);
			bpo_release.setItems(item);
			// bpo_release.setNextAction(IConstantsData.NONE);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);

			/*
			 * //submit release String poNo = FlowStandardPo.submitPoForProcessing(driver,
			 * testCaseName); if (poNo != null) { bpo_release.setReleaseNo(poNo); }
			 * PageViewPurchaseOrder.getPONo(driver, testCaseName);
			 */
			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.RELEASE_PO_TYPE);
			assertTrue("Error while searching release", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE);
			assertTrue("Type of BOR was wrong, it should be Release.", flag);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			/**
			 * RTC_183951 : Test for bug 208432 - BPO total is not displayed with currency
			 * in BPO amendment screen on top.
			 **/
			flag = PageBPO.getTotalAmount(driver, testCaseName).equalsIgnoreCase(bpo.getTotalPrice());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "BPO total is not displayed with currency in BPO amendment screen on top.");

			// submit amended BPO
			String poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			/**
			 * RTC_183689 : Test for bug 208446 - Incorrect message shown on amendment
			 * submit event.
			 **/
			flag = PageAmmendedPO.getSuccessMsg(driver, testCaseName).equalsIgnoreCase(PropertyReader.messageProperty.getProperty(IConstantsData.BPO_Amended_Successfully_Msg));
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Incorrect message shown on amendment submit event.");

			/**
			 * RTC_183661 : Test for bug 208406 - In a scenario, Unable to amend BPO against
			 * which release is created.
			 **/
			flag = PageAmmendedPO.isAmendedPOPresentInListing(driver, testCaseName, bpoNo);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Unable to amend BPO against which release is created.");
			assertTrue("Amended BPO was not present in Amend BPO Listing", flag);

			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, bpoNo);
			flag = status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);
			assertTrue("Status of Amended BPO was wrong, It should be In Approval", flag);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			// view BPO
			FlowPoListing.viewPO(driver, testCaseName);

			ActionBot.scroll(driver, "400");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			String winHandleBefore = driver.getWindowHandle();

			PageViewPurchaseOrder.clickOnAuditTrailVersion(driver, testCaseName, 2);

			Set<String> winHandles = driver.getWindowHandles();
			for (String winHandle : winHandles)
			{
				driver.switchTo().window(winHandle);
			}

			// to check user name on version of BPO
			driver.manage().window().maximize();
			ActionBot.scroll(driver, "400");
			PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
			String action = PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, 3);
			String userName = PageViewPurchaseOrder.getAuditTrailUser(driver, testCaseName, 3);

			flag = action.equalsIgnoreCase(PropertyReader.dataProperty.getProperty(IConstantsData.AUDIT_TRAIL_ACTION_AMENDMENT_CONFIRMED)) && userName.equalsIgnoreCase("System");
			assertTrue("User coming blank for amendment confirmed activity in version ducument", flag);

			driver.switchTo().window(winHandleBefore);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <font color="blue">Method :</b> Category-PT-GL Map >> BPO Amend >> Accounting
	 * details should be defaulted recursively for new items. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_276140(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276135"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276138"));
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_276139"));
		}
		User user = null;
		BPO bpo = new BPO();
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		GLMap glMapC1P2GLAcc2Company1 = new GLMap();
		GLMap glMapC1AnyPurchaseTypeGLAcc3Company1 = new GLMap();
		GLMap glMapC2P1GLAcc2Company1 = new GLMap();
		boolean flag = false;
		String url, type, status, bpoNo, poNo, itemName1, glAccount;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// GL Maps
			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);
			glMapC1P2GLAcc2Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType2_AnyCC_Amount_GLType2_GLAccount2_Company1);
			glMapC1AnyPurchaseTypeGLAcc3Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_AnyPurchaseType_AnyCC_Amount_GLType3_GLAccount3_Company1);
			glMapC2P1GLAcc2Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category2_PurchaseType1_AnyCC_Amount_GLType2_GLAccount2_Company1);

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			//bpo.setBuyer(user.getUserSettings().getDisplayName());
			bpo.setPurchaseType(glMapC1P1GLAcc1Company1.getPurchaseType());

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);

			itemName1 = bpo.getItems().getGuidedItems().get(0).getItemName();
			bpoNo = bpo.getPoNumber();
			glAccount = CommonUtilities.getProperGLAccount(bpo.getCostBookingItemSummary().getAccountingItemSummary().getGlAccount());

			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);
			// search BPO
			logger.info("============== Searching BPO ==============");
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching BPO", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Type of BPO was wrong, it should be Blanket.", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the BPO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, bpoNo, IConstantsData.BPO, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search bpo
				flag = FlowPoListing.searchPo(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching  BPO", flag);
				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of BPO was not Released", flag);
			}

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// add item
			Item items = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			items.getGuidedItems().get(0).setCategory(category);
			items.getGuidedItems().get(0).setNextAction(IConstantsData.NONE);

			items = FlowStandardPo.addItem(driver, testCaseName, items);
			items.getGuidedItems().get(0).getItemName();

			// save item
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

			// to check defaulted gl account
			PageStandardPO.clickOnEditItemSummaryButtonUsingItemName(driver, testCaseName, items.getGuidedItems().get(0).getShortDescription());
			// PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName,
			// items.getGuidedItems().get(0).getItemID());
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount2 = ModalPOItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
			glAccount2 = CommonUtilities.getProperGLAccount(glAccount2);

			logger.info("GL Account for " + glMapC1P1GLAcc1Company1.getCategory() + " is : " + glMapC1P1GLAcc1Company1.getGlAccount());
			flag = glAccount2.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0),
				"Category-PT-GL Map >> BPO Amend >> Accounting details was not defaulted from Cat-PT-GL map configured for document company.");

			ModalPOItemSummaryCostAllocation.clearGLAccount(driver, testCaseName);
			WebElement element = ActionBot.findElement(driver, IModalPOItemSummaryCostAllocation.TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);

			List<String> availableGlAccounts = ModalPOItemSummaryCostAllocation.getListOfGLAccountsNames(driver, testCaseName);
			ModalPOItemSummaryCostAllocation.clickOnCancel(driver);

			String log = "";
			flag = false;
			for (String glAccounts : availableGlAccounts)
			{
				log += glAccounts + "\n";
				if (glAccounts.equalsIgnoreCase(glMapC1P1GLAcc1Company1.getGlAccount()) || glAccounts.equalsIgnoreCase(glMapC1P2GLAcc2Company1.getGlAccount())
					|| glAccounts.equalsIgnoreCase(glMapC1AnyPurchaseTypeGLAcc3Company1.getGlAccount()))
				{
					flag = true;
				}
				else if (glAccounts.length() != 0)
				{
					flag = true;
				}
			}

			logger.info("List of GL Accounts : \n" + log);
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1), "Category-PT-GL Map >> BPO Amend >> User should be able to select all the GL Types and Accounts.");

			/**
			 * RTC_276139 : Category-PT-GL Map >> BPO Amend >> Accounting details should be
			 * redefaulted on Category change
			 **/
			GuidedItem guidedItem = new GuidedItem();
			ModalGuidedItemSelectCategory category2 = new ModalGuidedItemSelectCategory();
			category2.setCategory(glMapC2P1GLAcc2Company1.getCategory());
			guidedItem.setCategory(category2);
			guidedItem.setNextAction(IConstantsData.NONE);

			PageStandardPO.clickOnEditItemSummaryButtonUsingItemName(driver, testCaseName, items.getGuidedItems().get(0).getShortDescription());
			// PageStandardPO.clickOnItemName(driver, testCaseName,
			// bpo.getItems().getGuidedItems().get(0).getItemID());
			guidedItem = FlowStandardPo.fillGuidedItemForm(driver, testCaseName, guidedItem);
			// save item
			ModalPOItemSummaryCostAllocation.clickOnSave(driver, testCaseName);

			// to check defaulted gl account
			PageStandardPO.clickOnEditItemSummaryButtonUsingItemName(driver, testCaseName, items.getGuidedItems().get(0).getShortDescription());
			/*
			 * PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName,
			 * bpo.getItems().getGuidedItems().get(0) .getItemID());
			 */
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			String glAccount1 = ModalPOItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
			glAccount1 = CommonUtilities.getProperGLAccount(glAccount1);

			logger.info("GL Account for " + glMapC2P1GLAcc2Company1.getCategory() + " is : " + glMapC2P1GLAcc2Company1.getGlAccount());
			flag = glAccount1.equalsIgnoreCase(glMapC2P1GLAcc2Company1.getGlAccount());
			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2), "Category-PT-GL Map >> BPO Amend >> Accounting details was not redefaulted on Category change");

			// submit amended BPO
			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			// view BPO
			FlowPoListing.viewPO(driver, testCaseName);

			// to check accounting data
			ActionBot.scroll(driver);
			PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
			for (int i = 0; i < 2; i++)
			{
				if (PageViewPurchaseOrder.getItemNameInAccountingSection(driver, testCaseName, i).equalsIgnoreCase(itemName1))
				{
					flag = PageViewPurchaseOrder.getGLAccountInAccountingSection(driver, testCaseName, i).equalsIgnoreCase(glAccount);
				}
				else
				{
					flag = PageViewPurchaseOrder.getGLAccountInAccountingSection(driver, testCaseName, i).equalsIgnoreCase(glAccount1);
				}
			}
			assertTrue("Wrong accounting details shown on BPO view page", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <font color="blue">Method :</b> Test for bug 208624 - Unable to submit
	 * release if user amended BPO & add another free text item & setting of prevent
	 * changing Part id & description is checked. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_184092(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		boolean flag = false;
		String url, type, bpoNo, poNo;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			url = driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo.setBuyer(user.getDisplayName());
			bpo.setPreventChangingPartNoAndItemDescription(true);
			bpo.setAutoUpdate(true);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			// copy item
			Item item = bpo.getItems();
			item.getCatelogItems().get(0).setItemID(null);
			flag = FlowStandardPo.copyItem(driver, testCaseName, item);
			assertTrue("Item was not getting copied while amending BPO", flag);

			// view copied item
			PageStandardPO.clickOnItemName(driver, testCaseName, null);

			// change item no
			ModalPOFreeTextItemSummaryItem.fillFreeTextItemNo(driver, testCaseName, "458236");

			// accounting details
			ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
			AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
			accountingItemSummary = ObjectCreation.getDefaultObjectOfAccounting();
			FlowStandardPo.fillAccountingDetails(driver, testCaseName, accountingItemSummary);

			// submit amended BPO
			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			// bor object creation
			BPO bpo_release = ObjectCreation.getDefaultObjectOfBOR();
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
			bpo_release.setCostBookingItemSummary(costBookingItemSummary);

			// to create release
			logger.info("============== Creating BOR ==============");
			bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo_release);

			/*
			 * //submit release poNo = FlowStandardPo.submitPoForProcessing(driver,
			 * testCaseName); if (poNo != null) { bpo_release.setReleaseNo(poNo); }
			 * PageViewPurchaseOrder.getPONo(driver, testCaseName);
			 */
			driver.navigate().refresh();
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			driver.get(url);

			// search release
			logger.info("============== Searching Release ==============");
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpo_release.getReleaseNo(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.RELEASE_PO_TYPE);
			assertTrue("Error while searching release", flag);

			type = PagePurchaseOrderListing.getFirstPOType(driver, testCaseName);
			flag = type.equalsIgnoreCase(IConstantsData.RELEASE_PO_TYPE);
			assertTrue("Type of BOR was wrong, it should be Release.", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> Test for bug 208405 - After amending expire
	 * BPO & changed its 'To Date', status of BPO is not changed to Release again.
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_187725(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		String testCaseName = null, bpoNo = null, poNo;
		boolean flag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// applying expired filter
			PoStatusFilter poStatusFilter = new PoStatusFilter();
			poStatusFilter.setExpired(true);
			// apply expired status filter
			logger.info("====================== Applying Expired Filter =======================");
			FlowPoListing.applyPOStatusFilterWithDocFilter(driver, testCaseName, poStatusFilter, IConstantsData.BLANKET_PO_TYPE);

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			bpoNo = PageBPO.getPONumberAfterAmmendingPO(driver, testCaseName);

			ActionBot.scroll(driver);
			// change To Date
			CustomDate customDate = CommonUtilities.getTodaysDate();
			customDate.setDate(PageBPO.selectToValidityDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear()));

			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpoNo = poNo;
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of BPO was not Released", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b>Test for bug 208878 - Incorrect validation
	 * errors thrown while amending bpo <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_187847(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		boolean flag = false;
		String bpoNo, poNo;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBuyer(user.getDisplayName());

			bpo.setAutoUpdate(false);
			bpo.setOrderValue("100000");

			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setNextAction(IConstantsData.SAVE);
			guidedItem.setItemType(null);
			guidedItem.setSourcingStatus(null);
			guidedItem.setReceiveBy(null);
			// guidedItem.setQuantity(0);
			guidedItem.setZeroPriceItem(true);
			bpo.getItems().getGuidedItems().add(guidedItem);
			// bpo.getItems().getGuidedItems().get(0).setQuantity(0);
			bpo.getItems().getGuidedItems().get(0).setZeroPriceItem(true);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			bpoNo = bpo.getPoNumber();

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			PageStandardPO.fillOrderDescription(driver, testCaseName, "qwerty");

			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpoNo = poNo;
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b>Test for bug 208951 - In a scenario, blocking
	 * user from submitting BPO amendment. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_188940(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		boolean flag = false;
		String bpoNo, poNo;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.BOTH);
			bpo.setBuyer(user.getDisplayName());
			bpo.getItems().getGuidedItems().get(0).setZeroPriceItem(true);

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);

			ActionBot.scroll(driver, "400");

			// copy item
			Item item = new Item();
			item.setCatelogItems(bpo.getItems().getCatelogItems());
			item.getCatelogItems().get(0).setItemID(null);

			flag = FlowStandardPo.copyItem(driver, testCaseName, item);
			assertTrue("Catalog Item was not getting copied while amending BPO", flag);

			PageBPO.clickOnAutoUpdate(driver, testCaseName);

			// submit amended BPO
			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			// PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b>Category-PT-GL Map >> BPO Amend >> Enforce
	 * Setting Change: Validation Rules shouldn't be applied on Submit [Yes To No]
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_276121(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		boolean flag = false, settingChangedFlag = false;
		String bpoNo, poNo, testCaseName = null;
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		MasterDataTenantConfig masterDataTenantConfig = new MasterDataTenantConfig();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			// GL Maps
			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);

			// change EnforcePurchaseTypeBasedValidationOfFLAccounts to YES
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(true);
			settingChangedFlag = true;
			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBuyer(user.getDisplayName());
			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			bpo.getItems().getGuidedItems().get(0).setCategory(category);

			bpo.getCostBookingItemSummary().getAccountingItemSummary().setGlAccount(glMapC1P1GLAcc1Company1.getGlAccount());

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();

			// change EnforcePurchaseTypeBasedValidationOfFLAccounts to NO
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);
			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);
			settingChangedFlag = false;

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of BPO was not Released", flag);

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();

			// submit amended BPO
			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (settingChangedFlag)
				{
					masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);
					masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);
				}
			}
			catch (Exception e)
			{
				logger.error("Expection occurred while chaning master data setting to default value." + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Category-PT-GL Map >> BPO Amend >> Enforce
	 * Setting Change: Validation Rules shouldn't be applied on Submit [Yes To No]
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	// passed
	@Test(dataProvider = "dataProvider", priority = 1)
	public void RTC_276134(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		BPO bpo = new BPO();
		boolean flag = false, settingChangedFlag = false;
		String bpoNo, poNo, testCaseName = null;
		GLMap glMapC1P1GLAcc1Company1 = new GLMap();
		MasterDataTenantConfig masterDataTenantConfig = new MasterDataTenantConfig();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();

			glMapC1P1GLAcc1Company1 = ObjectCreation.getGLMapObject(IConstantsData.Category1_PurchaseType1_AnyCC_Amount_GLType1_GLAccount1_Company1);

			// change EnforcePurchaseTypeBasedValidationOfFLAccounts to NO
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);
			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.CATALOG_ITEM);
			bpo.setBuyer(user.getDisplayName());

			// BPO creation
			logger.info("============== Creating BPO ==============");
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			bpoNo = bpo.getPoNumber();

			// change EnforcePurchaseTypeBasedValidationOfFLAccounts to YES
			masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(true);
			settingChangedFlag = true;
			masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
			assertTrue("Status of BPO was not Released", flag);

			// amend BPO
			logger.info("============== Amending BPO ==============");
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOActions.clickOnAmendPOFromActions(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();

			// add free text item
			Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory(glMapC1P1GLAcc1Company1.getCategory());
			item.getGuidedItems().get(0).setCategory(category);
			item.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

			FlowStandardPo.addItem(driver, testCaseName, item);

			PageBPO.clickOnAutoUpdate(driver, testCaseName);

			// submit amended BPO
			poNo = FlowStandardPo.submitPoForProcessing(driver, testCaseName);
			if (poNo != null)
			{
				bpo.setPoNumber(poNo);
			}
			PageViewPurchaseOrder.getPONo(driver, testCaseName);

			// search bpo
			flag = FlowPoListing.searchBPO(driver, testCaseName, bpoNo, IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);
			assertTrue("Error while searching  BPO", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (settingChangedFlag)
				{
					masterDataTenantConfig.setEnforcePurchaseTypeBasedValidationOfGLAccounts(false);
					masterDataTenantConfig = FlowMasterDataTenantConfig.changeMasterDataTenantConfig(driver, testCaseName, masterDataTenantConfig);
				}
			}
			catch (Exception e)
			{
				logger.error("Exception occurred while changing master data setting to default value" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/*************************************************************/

	// Rohini Shinge's Testcases Start

	/*************************************************************/

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Link Item to BPO modal User should have
	 * following columns in the BPO listing Description(BPO description) [Check with
	 * Multilingual data]
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11754(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// Set oreder description
			bpo.setOrderDescription("n van de cebraMittwoch&nbsp; Elefanten Tastatur Rissbildung Frosch Durcheinander Denkmal Frage van Zebra");

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with order description
			String searchedBPOName = ModalBlanketOrdersForFreeTextItem.fillBPOName(driver, testCaseName, bpo.getOrderDescription());
			searchedBPOName = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			searchedBPOName = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPOName.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * Method :</b>Link Item to BPO modal>>User should have following columns in the
	 * BPO listing : BPO number/BPO description [Check for special chars handling]
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11756(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		try
		{

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// Set order description
			bpo.setOrderDescription("~!@#$%^&amp;*()_+{}|:;\"abc\"\"\"&lt;&gt;&lt;&gt");

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with PO Number
			String searchedBPONumber = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			searchedBPONumber = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPONumber.equals(bpo.getPoNumber()));

			// Apply filter with order description
			String searchedBPOName = ModalBlanketOrdersForFreeTextItem.fillBPOName(driver, testCaseName, bpo.getOrderDescription());
			searchedBPOName = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPOName.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :User should be able to create
	 * receipt against PR as usual.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11791(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		StandardPO standardPO = new StandardPO();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);

			// BPO Creation
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			String poNo = standardPO.getPoNumber();

			// create receipt against that PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			Receipt receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setNextAction(IConstantsData.SUBMIT_INVOICE);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);
			boolean status = receipt.getStatus().equalsIgnoreCase("Confirmed") ? true : false;
			Assert.assertTrue("Receipt is not created against PR", status);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to sort / filter the listing on following column : BPO number
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11759(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with BPO number
			String searchedBPONumber = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			searchedBPONumber = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPONumber.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to filter the listing on following column : BPO Description
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11760(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11760 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with order description
			ModalBlanketOrdersForFreeTextItem.fillBPOName(driver, testCaseName, bpo.getOrderDescription());
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			EPROC_11760 = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName).equalsIgnoreCase(bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", EPROC_11760);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to filter the listing on following column : Created by
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11761(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11761 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setRequester("");
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with requester
			ModalBlanketOrdersForFreeTextItem.fillCreatedByForBPO(driver, testCaseName, bpo.getRequester());
			EPROC_11761 = ModalBlanketOrdersForFreeTextItem.getFirstBPOCreatedBy(driver, testCaseName).equalsIgnoreCase(bpo.getRequester());
			Assert.assertTrue("Unable to find BPO", EPROC_11761);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should have following columns in the BPO listing : Description(BPO
	 * description) [Check for XSS data]
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11753(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11753 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);

			// Set order description
			bpo.setOrderDescription(CommonServices.getTestData(IConstantsData.Script_char_item_name));

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			//click on requisition tab
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			//go to online store
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			//search random things
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));

			//click on search button
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Click On Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			//fill supplier name from created BPO
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			//Click on show all BPO
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with order description
			ModalBlanketOrdersForFreeTextItem.fillBPOName(driver, testCaseName, bpo.getOrderDescription());
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			EPROC_11753 = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName).equalsIgnoreCase(bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", EPROC_11753);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should have following columns in the BPO listing : BPO number [Check for XSS
	 * data]
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11755(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11755 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);

			// set PO number
			bpo.setPoNumber(CommonServices.getTestData(IConstantsData.Script_char_item_name));

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with PO Number
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			EPROC_11755 = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName).equalsIgnoreCase(bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", EPROC_11755);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should have following columns in the BPO listing : BPO number [Check with
	 * multilingual data]
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11757(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11757 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setPoNumber("n van de cebraMittwoch&nbsp; Elefanten Tastatur Rissbildung");
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with exsiting supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with PO Number
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			EPROC_11757 = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName).equalsIgnoreCase(bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", EPROC_11757);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>Allowed
	 * BPOs for selection should be decided on following criteria : BPOs from
	 * selected supplier only
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11766(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Match supplier
			String modalTitleSupplier = driver.findElement(By.xpath("//*[@id=\"BPOGridDialogGuidedMe\"]/div[1]/div[1]/span")).getText();

			Assert.assertTrue("BPOs not from selected supplier only", CommonServices.getTestData(IConstantsData.SUPPLIER_NAME).equals(modalTitleSupplier));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to sort / filter the listing on following column : BPO number
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11804(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		boolean EPROC_11804 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			// Get Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			EPROC_11804 = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName).equalsIgnoreCase(bpo.getPoNumber());
			// Apply filter with BPO number
			Assert.assertTrue("Unable to find BPO", EPROC_11804);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Contract/BPO # entered should be
	 * visible when viewing the item on PR/BPR.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11805(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		String contractNumber = null;
		boolean EPROC_11805 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			contractNumber = Float.toString(CommonUtilities.getNonZeroRandomNumber(2));
			// Get BPO Object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.getItems().getGuidedItems().get(0).setContractNo(contractNumber);
			bpo.setContractNo(CommonUtilities.getNonZeroRandomNumbers(2));

			// Create BPO and release
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			// Go to PO listing
			MainPageHeaderLevelTab.clickOnPOTab(driver);

			// Search BPO
			FlowPoListing.searchBPO(driver, testCaseName, bpo.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO, IConstantsData.BLANKET_PO_TYPE);

			// View BPO
			PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

			// View added item
			PageViewPurchaseOrder.clickOnItemName(driver, testCaseName);

			EPROC_11805 = PageViewPurchaseOrder.getContractNumber(driver, testCaseName).equalsIgnoreCase(contractNumber);
			Assert.assertTrue("Contract Number not present", EPROC_11805);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :PR to BOR>>Copy recently ordered
	 * BPO item : All validations as of normal addition of BPO item should be there.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11802(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_11802 = false;
		String itemName = null;
		List<String> cartItems = new ArrayList<>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Get guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// click on RecentlyOrderedFreeTextItems
			PageFreeTextForm.clickOnRecentlyOrderedFreeTextItems(driver, testCaseName);

			PageFreeTextForm.clickRecentlyOrderedItemsIndexwise(driver, testCaseName, 1);

			// Copy Item
			PageFreeTextForm.clickCopyItem(driver, testCaseName);
			itemName = PageFreeTextForm.getShortDescription(driver, testCaseName);
			// Submit
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);
			PageFreeTextForm.clickOnLinkViewCart(driver, testCaseName);
			for (WebElement element : ModalShoppingCart.getItemList(driver, testCaseName))
			{
				System.out.println(element.getText());
				if (element.getText().equalsIgnoreCase(itemName))
				{
					EPROC_11802 = true;
					break;
				}
			}
			Assert.assertTrue("Item not added to cart", EPROC_11802);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :PR to BOR>>Select BPO modal>>User
	 * should be able to paginate properly in case records are across pages.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11801(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// go to guided item screen
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// check pagination and records on BPO modal
			int no1 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 3);

			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			int no2 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 4);

			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			int no3 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, 6);

			ModalBlanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
			int no4 = ModalBlanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);

			boolean flag = (no4 == no1) ? true : false;
			Assert.assertTrue("Incorrect count of records is shown", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method : <b>Description : User should be
	 * able to create receipt against BOR created from PR as usual.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11792(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		StandardPO standardPO = new StandardPO();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get Object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);

			// BPO Creation
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			String poNo = standardPO.getPoNumber();

			// create receipt against that PO
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, poNo);
			PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
			ModalPOActions.clickOnCreateReceiptFromActions(driver, testCaseName);
			Receipt receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setNextAction(IConstantsData.SUBMIT_INVOICE);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);
			boolean status = receipt.getStatus().equalsIgnoreCase("Confirmed") ? true : false;
			Assert.assertTrue("Receipt is not created against BOR", status);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method : <b>Description : Buyer desk return
	 * for Need a quote item>>All Validations as of PR submit should be present on
	 * Submit for approval event from buyer desk.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11816(TestCase testCase) throws Exception
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
		boolean EPROC_11816 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			requisition = ObjectCreation.getRequisition(driver);
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			// Choose sourcing status as Need a quote
			guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItems.add(guidedItem);
			item.setGuidedItems(guidedItems);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			// Submit for approval at buyers desk
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
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
			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			PageAllRequestsApproval.searchRequisitionByName(driver, testCaseName, requisition.getReqName());
			EPROC_11816 = PageAllRequestsApproval.getFirstRowDocumentName(driver, testCaseName).equalsIgnoreCase(requisition.getReqName());
			Assert.assertTrue("Requisition not sent for approval", EPROC_11816);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : BPO to PR>>User should be able to
	 * link a item with all price types with an BPO
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11817(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);

		User user = null;
		Requisition requisition = new Requisition();
		Item items = new Item();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// Add 1st item
			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem1.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem1.setBPONo(bpoNo);
			guidedItem1.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem1);

			// Add 2nd item
			GuidedItem guidedItem2 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem2.setSourcingStatus(IConstantsData.Estimated_price);
			guidedItem2.setBPONo(bpoNo);
			guidedItem2.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem2);

			// Add 3rd item
			GuidedItem guidedItem3 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem3.setSourcingStatus(IConstantsData.Need_a_Quote);
			guidedItem3.setBPONo(bpoNo);
			guidedItem3.setActivity(IConstantsData.AddAnotherItem);
			guidedItems.add(guidedItem3);

			items.setGuidedItems(guidedItems);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// To set non mandatory fields for requisition
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			// Create requisition
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			String searchedName = PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			Assert.assertTrue("Requisition not created with all price types", searchedName.equals(requisition.getReqName()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Link Item to BPO modal>>Allowed BPOs
	 * for selection should be decided on following criteria : Only active BPOs
	 * should come in listing[!expired / !closed / !cancelled]
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11764(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String cancelledPONumber = null;
		boolean EPROC_11764 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Go to PO Listing Page
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			//click on expired status filter
			PagePurchaseOrderListing.clickOnCancelledStatusFilter(driver, testCaseName);
			//get first PO number
			cancelledPONumber = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			//go to online store
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			//go to guided item screen
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);
			// fill the cancelled PO number
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, cancelledPONumber);
			EPROC_11764 = ModalBlanketOrdersForFreeTextItem.isNoResultsTablePresent(driver, testCaseName);
			Assert.assertTrue("Cancelled BPO not found", EPROC_11764);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Link Item to BPO modal>>Allowed BPOs
	 * for selection should be decided on following criteria : Only active BPOs
	 * should come in listing[!parked / !expired / !closed / !cancelled] - Same
	 * check should be present on Req submit and Convert to Release
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11765(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		String cancelledPONumber = null;
		boolean EPROC_11765 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			//click on expired status filter
			PagePurchaseOrderListing.clickOnCancelledStatusFilter(driver, testCaseName);
			//get first PO number
			cancelledPONumber = PagePurchaseOrderListing.getFirstPoNo(driver, testCaseName);
			// Go to guided item screen
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Fill BPO number
			ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, cancelledPONumber);
			ActionBot.defaultSleep();
			EPROC_11765 = ModalBlanketOrdersForFreeTextItem.isNoResultsTablePresent(driver, testCaseName);
			Assert.assertTrue("Expired BPO not found", EPROC_11765);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :BOR creation from PR>>System/buyer
	 * should be able to generate release from BPO items if following criteria
	 * allows: Supplier is active
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11821(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		List<GuidedItem> guidedItem = new ArrayList<>();
		Requisition requisition = new Requisition();
		Item items = new Item();
		BPO bpo = new BPO();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getDefaultObjectOfBOR();

			// Create BPO
			FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItem.get(0).setBPONo("COM001/17/10379");

			// Requester negotiated price
			guidedItem.get(0).setSourcingStatus(IConstantsData.Quoted_by_supplier);

			// Set item
			items.setGuidedItems(guidedItem);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setItems(items);

			// Create requisition
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// Create release
			BPO bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo);

			// Check for release
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String searched_PO = PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo_release.getReleaseNo());

			Assert.assertTrue("Release not created", searched_PO.equals(bpo_release.getReleaseNo()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Select BPO modal>>Following column
	 * should be present : Unutilized amount
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11796(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// Go to guided item screen
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowSearchListing.searchItem(driver, testCaseName, "Laptop");
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Check column present or not
			boolean isPresent = ModalBlanketOrdersForFreeTextItem.isBalanceAmountColumnPresent(driver, testCaseName);

			org.testng.Assert.assertTrue(isPresent, "Amount column not present");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Requester should be able to submit
	 * single PR containing items from multiple BPOs
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11797(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// create 2 guided items with different BPO
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));

			guidedItems.get(0).setBPONo(CommonServices.getTestData(IConstantsData.Item_BPO_Number));
			guidedItems.get(1).setBPONo(CommonServices.getTestData(IConstantsData.Item_BPO_Number));

			item.setGuidedItems(guidedItems);

			// creating requisition
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// Check whether requisition is created or not
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);

			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			boolean flag = PageMyRequisition.getFirstReqName(driver, testCaseName).contains(requisition.getReqName());
			org.testng.Assert.assertTrue(flag, "Requester not able to submit single PR containing items from multiple BPOs");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>On Requisition Submit :
	 * Following validation should be present from mentioned screens: Unauthorized
	 * category
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11769(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurment link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>On Requisition Submit :
	 * Following validation should be present from mentioned screens: BPO Item level
	 * balance amount check
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11773(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		BPO bpo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			// to get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);

			// to set non mandatory fields for req
			requisition.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			requisition.setReasonForOrdering(IConstantsData.REASON_FOR_ORDERING);
			requisition.setRequired(true);

			requisition.getItems().getGuidedItems().get(0).setBPONo(bpo.getPoNumber());
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
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
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check price validation
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>On Add / Update Item :
	 * Following validation should be present from mentioned screens: Is allowed
	 * Amount to be checked against total BPO balance amount
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11781(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setPreventExceedingBlanketValues(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setPrice(Float.parseFloat(bpo.getOrderValue()));
			guidedItem.setQuantity((float) 1);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean res = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			boolean flag = !res;
			org.testng.Assert.assertTrue(flag, "Validation not present for total BPO balance amount");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>On Add / Update Item :
	 * Following validation should be present from mentioned screens: Is allowed
	 * Category
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11780(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>Convert to PO from buyer
	 * desk listing : Following validation should be present from mentioned screens:
	 * BPO level balance amount(Order value) check
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11789(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setPreventExceedingBlanketValues(true);
			bpo.setOrderValue("6000");

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setPrice(8000);
			guidedItem.setQuantity((float) 123);
			guidedItem.setBPONo(bpo.getPoNumber());
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean res = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			boolean flag = !res;
			org.testng.Assert.assertTrue(flag, "Validation not present");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>Convert to PO from buyer
	 * desk listing : Following validation should be present from mentioned screens:
	 * BPO level balance amount(Order value) check
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11785(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		GuidedItem guidedItem = new GuidedItem();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setPreventExceedingBlanketValues(true);
			bpo.setOrderValue("6000");

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setPrice(8000);
			guidedItem.setQuantity((float) 123);
			guidedItem.setBPONo(bpo.getPoNumber());
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean res = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			boolean flag = !res;
			org.testng.Assert.assertTrue(flag, "Validation not present");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>On Requisition Submit :
	 * Following validation should be present from mentioned screens: Unauthorized
	 * category
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11774(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>Convert to PO from
	 * buyer desk listing : Following validation should be present from mentioned
	 * screens: Unauthorized category
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11783(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>Convert to PO from
	 * buyer desk listing : Following validation should be present from mentioned
	 * screens: Unauthorized category
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11787(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Buyer desk>>Link Item to BPO >>
	 * Category check against BPO should happen on Save Requisition or Convert to PO
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11815(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Checkout screen>>Link Item to BPO >>
	 * Category check against BPO should happen on Update Item event.
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11809(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Desktop Computers");

			ModalGuidedItemSelectCategory categoryForBPO = new ModalGuidedItemSelectCategory();
			categoryForBPO.setCategory("Desktop Calculator");

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setCategory(categoryForBPO);
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);
			// Prevent category change
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create Object
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setCategory(category);
			guidedItem.setBPONo(bpo.getPoNumber());

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> Description :BOR creation from PR>>System/buyer
	 * should be able to generate release from BPO items if following criteria
	 * allows: Price-type is "Requester negotiated price" or "Buyer negotiated".
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11822(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		List<GuidedItem> guidedItem = new ArrayList<>();
		Requisition requisition = new Requisition();
		Item items = new Item();
		BPO bpo = new BPO();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);

			// Create BPO
			FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItem.get(0).setBPONo(bpo.getPoNumber());

			// Requester negotiated price
			guidedItem.get(0).setSourcingStatus(IConstantsData.Quoted_by_supplier);

			// Set item
			items.setGuidedItems(guidedItem);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setItems(items);

			// Create requisition
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// Create release
			BPO bpo_release = FlowBPO.createRelease(driver, testCaseName, bpo);

			// Check for release
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			String searched_PO = PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpo_release.getReleaseNo());

			Assert.assertTrue("Release not created", searched_PO.equals(bpo_release.getReleaseNo()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>On Requisition Submit :
	 * Following validation should be present from mentioned screens: Unathorized
	 * supplier part ID
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11770(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setPartNumber("12415645679680790");
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			// Prevent Part no Change
			bpo.setPreventChangingPartNoAndItemDescription(true);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setPartNumber("98087886765654612344");
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for part ID");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>On Buyer desk Convert to
	 * PO : Following validation should be present from mentioned screens: Part ID
	 * check
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11776(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setPartNumber("12415645679680790");
			guidedItemsForBPO.get(0).setNextAction(IConstantsData.SAVE);
			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);

			// Prevent Part no Change
			bpo.setPreventChangingPartNoAndItemDescription(true);
			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setPartNumber("98087886765654612344");
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for part ID");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>Convert to PO from
	 * buyer desk listing : Following validation should be present from mentioned
	 * screens: Part ID check
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11784(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setPartNumber("12415645679680790");

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			// Prevent Part no Change
			bpo.setPreventChangingPartNoAndItemDescription(true);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setPartNumber("98087886765654612344");
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for part ID");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>Convert to PO from
	 * buyer desk listing : Following validation should be present from mentioned
	 * screens: Part ID check
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11788(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		BPO bpo = new BPO();
		Item item = new Item();
		GuidedItem guidedItem = new GuidedItem();
		List<GuidedItem> guidedItemsForBPO = new ArrayList<>();

		try
		{

			user = LoginLogoutServices.login(driver, testCase);

			// Guided Item for BPO
			guidedItemsForBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemsForBPO.get(0).setPartNumber("12415645679680790");

			item.setGuidedItems(guidedItemsForBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(item);

			// Create BPO
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);
			// Prevent Part no Change
			bpo.setPreventChangingPartNoAndItemDescription(true);

			// Create guided item
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setPartNumber("98087886765654612344");
			// guidedItem.setBPONo("COM001/17/10461");

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);
			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for part ID");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to sort / filter the listing on following column : VALID
	 * UNTILL [Max and min valid untill date should be loaded as from and to date
	 * respectively]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11758(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_11758 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// click on valid until filter
			EPROC_11758 = ModalBlanketOrdersForFreeTextItem.isFromDateAndToDateFilterPresent(driver, testCaseName);
			Assert.assertTrue("Valid until sorting not present", EPROC_11758);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to sort / filter the listing on following column : VALID
	 * UNTILL [Max and min valid untill date should be loaded as from and to date
	 * respectively]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11803(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_11803 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);
			EPROC_11803 = ModalBlanketOrdersForFreeTextItem.isFromDateAndToDateFilterPresent(driver, testCaseName);
			Assert.assertTrue("From and to date filter not present", EPROC_11803);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to browse>>filter>>sort>>select BPO from BPO listing [Check in
	 * FF 16 to latest]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11762(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// click on valid until filter
			boolean flag = ModalBlanketOrdersForFreeTextItem.isValidUntilSortingPresent(driver, testCaseName);
			Assert.assertTrue("Valied Until Sorting is not present", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>User
	 * should be able to browse>>filter>>sort>>select BPO from BPO listing [Check in
	 * IE9]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11763(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_11763 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// click on valid until filter
			EPROC_11763 = ModalBlanketOrdersForFreeTextItem.isValidUntilSortingPresent(driver, testCaseName);
			Assert.assertTrue("Valied Until Sorting is not present", EPROC_11763);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>On Buyer desk Convert
	 * to PO : Following validation should be present from mentioned screens: BPO
	 * item balance amount check for category
	 * 
	 */

	@Test(dataProvider = "dataProvider")

	public void EPROC_11778(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		BPO bpo = null;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			// create bpo
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo = FlowBPO.createBPO(driver, testCaseName, bpo);
			String bpoNo = bpo.getPoNumber();
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePurchaseOrderListing.fillPoNo(driver, testCaseName, bpoNo);
			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			// approve bpo
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				FlowPoListing.approveAndReleaseBPO(driver, testCaseName, bpo.getPoNumber());
			}

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
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check price validation
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method :Validation>>Convert to PO from buyer
	 * desk listing : Following validation should be present from mentioned screens:
	 * BPO item(category) level balance amount check
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11786(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();

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
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check price validation
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>On Add / Update Item :
	 * Following validation should be present from mentioned screens: Is allowed
	 * Amount to be checked against Maximum total balance amount in BPO for that
	 * category.
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11782(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();

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
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check price validation
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Validation>>Convert to PO from
	 * buyer desk listing : Following validation should be present from mentioned
	 * screens: BPO item(category) level balance amount check
	 * 
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_11790(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();

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
			amount = "";
			for (String str : temp)
			{
				amount += str;
			}
			ModalPOItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
			ModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
			PageBPO.clickOnSubmitPOForProcessing(driver, testCaseName);

			// check price validation
			boolean price = PageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
			Assert.assertTrue("Price exceeding max value error is not present", price);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> Description :PR to BOR>>Validation on I'm Done
	 * : All validations should be present as of fresh PR submit in case of recalled
	 * PR
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11800(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_11799"));
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

			requisition.getItems().getGuidedItems().get(0).setBPONo("OU_1-00418553");

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Go to BuyerDesk to send for Approval
			/*
			 * MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			 * PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			 * PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
			 * PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);
			 */
			// Recall req
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
			PageMyRequisition.fillReqName(driver, testCaseName, requisition.getReqName());
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnRecallApproveRequestLink(driver, testCaseName);
			ModalMyRequisitionActions.performRecallActions(driver, testCaseName, IConstantsData.RECALL);
			// Open and submit req again as fresh req
			//MainPageHeaderLevelTab.clickOnPOTab(driver);
			MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
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
	 * <b>Author: Rohini Shinge </b> Description :System should generate same
	 * release for multiple items from same BPO if forking and splitting on other
	 * criteria allows.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11793(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		List<GuidedItem> guidedItems = new ArrayList<>();
		Item item = new Item();
		Requisition requisition = new Requisition();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// BPO creation
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Guided items
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));

			guidedItems.get(0).setBPONo(bpo.getPoNumber());
			guidedItems.get(1).setBPONo(bpo.getPoNumber());

			// Set guided items in requisition
			item.setGuidedItems(guidedItems);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setItems(item);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// Create requisition
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			FlowBPO.createRelease(driver, testCaseName, bpo);
			System.out.println("zsdhgkjdhgkj");

			System.out.println("asgdfjagsfjh::" + bpo.getReleaseNo());

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :System should generate different
	 * releases for items from different BPOs in addition to forking and splitting
	 * on other criterias.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11794(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo1 = new BPO();
		BPO bpo2 = new BPO();
		List<GuidedItem> guidedItems = new ArrayList<>();
		Item item = new Item();
		Requisition requisition = new Requisition();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get BPO object
			bpo1 = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// BPO creation
			bpo1 = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo1);

			// Get BPO object
			bpo2 = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			// BPO creation
			bpo2 = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo2);

			// Guided items
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));

			guidedItems.get(0).setBPONo(bpo1.getPoNumber());
			guidedItems.get(1).setBPONo(bpo2.getPoNumber());

			// Set guided items in requisition
			item.setGuidedItems(guidedItems);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);
			requisition.setItems(item);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// Create requisition
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
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> Description :BPO to PR>>All category
	 * validations should happen recursively till parent category.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11819(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		Item itemBPO = new Item();
		List<GuidedItem> guidedItemBPO = new ArrayList<>();
		GuidedItem guidedItem = new GuidedItem();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Child category for BPO guided item
			ModalGuidedItemSelectCategory categoryBPO = new ModalGuidedItemSelectCategory();
			categoryBPO.setCategory("Computer services");

			// Parent category for req guided item
			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Engineering and Research and Technology Based Services");

			// Create guided item
			guidedItemBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemBPO.get(0).setCategory(categoryBPO);
			guidedItemBPO.get(0).setNextAction(IConstantsData.SAVE);

			itemBPO.setGuidedItems(guidedItemBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(itemBPO);
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create and release BPO
			FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item for req
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setCategory(category);

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);

			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>Allowed
	 * BPOs for selection should be decided on following criteria : All active BPOs
	 * in user's PS+default CBL
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11767(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// Get default CBL
			PagePO.clickOnBPO(driver, testCaseName);
			String DeafultCBL = ActionBot.findElement(driver, By.xpath("//*[@id=\"frmPurchaseOrder\"]/div[12]/div/div/span")).getText();
			String[] CBLarr = DeafultCBL.split(">");
			String DefaultCompany = CBLarr[0].trim();
			String DefaultBU = CBLarr[1].trim();
			String DefaultLocation = CBLarr[2].trim();

			// Create BPO with default CBL
			billingRequisitionSummary.setCompany(DefaultCompany);
			billingRequisitionSummary.setBusinessUnit(DefaultBU);
			billingRequisitionSummary.setLocation(DefaultLocation);
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBillingRequisitionSummary(billingRequisitionSummary);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with BPO Number
			String searchedBPO = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			searchedBPO = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPO.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Link Item to BPO modal>>Allowed
	 * BPOs for selection should be decided on following criteria : All active BPOs
	 * in user's PS+default CBL [Check should be there on submit
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11768(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// Get default CBL
			PagePO.clickOnBPO(driver, testCaseName);
			String DeafultCBL = ActionBot.findElement(driver, By.xpath("//*[@id=\"frmPurchaseOrder\"]/div[12]/div/div/span")).getText();
			String[] CBLarr = DeafultCBL.split(">");
			String DefaultCompany = CBLarr[0].trim();
			String DefaultBU = CBLarr[1].trim();
			String DefaultLocation = CBLarr[2].trim();

			// Create BPO with default CBL
			billingRequisitionSummary.setCompany(DefaultCompany);
			billingRequisitionSummary.setBusinessUnit(DefaultBU);
			billingRequisitionSummary.setLocation(DefaultLocation);
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBillingRequisitionSummary(billingRequisitionSummary);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Place order with existing supplier
			PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);
			PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, bpo.getSupplierName());
			PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);

			// Apply filter with BPO Number
			String searchedBPO = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			searchedBPO = ModalBlanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
			Assert.assertTrue("Unable to find BPO", searchedBPO.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Checkout screen>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * Only active BPOs falling in document scope(CBL)
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11807(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get default CBL
			MainPageHeaderLevelTab.clickOnPOTab(driver);
			PagePO.clickOnBPO(driver, testCaseName);
			String DeafultCBL = ActionBot.findElement(driver, By.xpath("//*[@id=\"frmPurchaseOrder\"]/div[12]/div/div/span")).getText();
			String[] CBLarr = DeafultCBL.split(">");
			String DefaultCompany = CBLarr[0].trim();
			String DefaultBU = CBLarr[1].trim();
			String DefaultLocation = CBLarr[2].trim();

			// Create BPO with default CBL
			billingRequisitionSummary.setCompany(DefaultCompany);
			billingRequisitionSummary.setBusinessUnit(DefaultBU);
			billingRequisitionSummary.setLocation(DefaultLocation);
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBillingRequisitionSummary(billingRequisitionSummary);
			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			//Added
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			Requisition requisition = new Requisition();
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// To add items
			Item items = new Item();
			if (requisition.getItems() != null)
			{
				items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
				requisition.setItems(items);

				boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
				assertTrue("Item added to cart are wrong", flag);
				ModalShoppingCart.continueWithCart(driver, testCaseName);
			}

			// To checkout
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// On checkout page
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// Apply filter with BPO Number
			String searchedBPO = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", searchedBPO.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Checkout screen>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * Only active BPOs should come in listing[!expired / !closed / !cancelled]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11806(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			Requisition requisition = new Requisition();
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// To add items
			Item items = new Item();
			if (requisition.getItems() != null)
			{
				items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
				requisition.setItems(items);

				boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
				assertTrue("Item added to cart are wrong", flag);
				ModalShoppingCart.continueWithCart(driver, testCaseName);
			}

			// To checkout
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// On checkout page
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// Apply filter with BPO Number("COM001/16/1331"->Expired BPO)

			String searchedBPO = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, "COM001/16/1331");
			Assert.assertTrue("Unable to find BPO", searchedBPO.equals("COM001/16/1331"));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Checkout screen>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * BPOs from selected supplier only
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11808(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = new Requisition();
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// To add items
			Item items = new Item();
			if (requisition.getItems() != null)
			{
				items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
				requisition.setItems(items);

				boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
				assertTrue("Item added to cart are wrong", flag);
				ModalShoppingCart.continueWithCart(driver, testCaseName);
			}

			// To checkout
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// On checkout page
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);
			// Match supplier
			String modalTitleSupplier = driver.findElement(By.xpath("//*[@id=\"dev_BPOGridDialog\"]/div[1]/div[1]/span")).getText();

			Assert.assertTrue("BPOs not from selected supplier", requisition.getItems().getGuidedItems().get(0).getSupplierNameInSuppInfo().equals(modalTitleSupplier));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Buyer desk>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * Only active BPOs should come in listing[!expired / !closed / !cancelled]
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11812(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// Edit req on buyer desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// OU_1-0021715302--->expired bpo on speedy
			String searched_bpo = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, "OU_1-0021715302");

			Assert.assertTrue("Unable find BPO which is expired", searched_bpo.equals("OU_1-0021715302"));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :Buyer desk>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * BPOs from selected supplier only
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11814(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// Edit req on buyer desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);

			// Switch to supplier tab
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);

			// Get supplier
			String supplierName = ModalGuidedItemDetails.getSupplierName(driver, testCaseName);

			// Open show po modal
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			String modalTitle = ActionBot.findElement(driver, By.xpath("//*[@id=\"dev_BPOGridDialog\"]/div[1]/div[1]/span")).getText();
			Assert.assertTrue("BPOs not from selected supplier only", modalTitle.equals(supplierName));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method : Buyer should be able to change the
	 * BPO related info from REQ edit screen on buyer desk also while editing
	 * item.(IN IE)
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11810(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// Edit req on buyer desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);

			// Switch to supplier tab
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);

			// Open show BPO modal
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// Select BPO from modal
			ModalBlanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.clickOnSelectBPOButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> Description :Buyer desk>>Link Item to BPO
	 * modal>>Allowed BPOs for selection should be decided on following criteria :
	 * Only active BPOs falling in document scope(CBL)
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11813(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Requisition requisition = new Requisition();
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
		BPO bpo = new BPO();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnPOTab(driver);
			// Get default CBL
			PagePO.clickOnBPO(driver, testCaseName);
			String DeafultCBL = ActionBot.findElement(driver, By.xpath("//*[@id=\"frmPurchaseOrder\"]/div[12]/div/div/span")).getText();
			String[] CBLarr = DeafultCBL.split(">");
			String DefaultCompany = CBLarr[0].trim();
			String DefaultBU = CBLarr[1].trim();
			String DefaultLocation = CBLarr[2].trim();

			// Create BPO with default CBL
			billingRequisitionSummary.setCompany(DefaultCompany);
			billingRequisitionSummary.setBusinessUnit(DefaultBU);
			billingRequisitionSummary.setLocation(DefaultLocation);
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setBillingRequisitionSummary(billingRequisitionSummary);

			bpo = FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// Edit req on buyer desk
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);

			// Switch to supplier tab
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);

			// Open show po modal
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			String searchedBPO = ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, bpo.getPoNumber());
			Assert.assertTrue("Unable to find BPO", searchedBPO.equals(bpo.getPoNumber()));

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> Description :BPO to PR>>All category
	 * validations should happen recursively till parent category.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11820(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		BPO bpo = new BPO();
		Item itemBPO = new Item();
		List<GuidedItem> guidedItemBPO = new ArrayList<>();
		GuidedItem guidedItem = new GuidedItem();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			// Child category for BPO guided item
			ModalGuidedItemSelectCategory categoryBPO = new ModalGuidedItemSelectCategory();
			categoryBPO.setCategory("Computer services");

			// Parent category for req guided item
			ModalGuidedItemSelectCategory category = new ModalGuidedItemSelectCategory();
			category.setCategory("Engineering and Research and Technology Based Services");

			// Create guided item
			guidedItemBPO.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItemBPO.get(0).setCategory(categoryBPO);
			guidedItemBPO.get(0).setNextAction(IConstantsData.SAVE);

			itemBPO.setGuidedItems(guidedItemBPO);

			// Get BPO object
			bpo = ObjectCreation.getBPOCreation(IConstantsData.GUIDED_ITEM);
			bpo.setItems(itemBPO);
			bpo.setPreventOrderOfItemsOfOtherCategorie(true);

			// Create and release BPO
			FlowBPO.createAndReleaseBPO(driver, testCaseName, bpo);

			// Create guided item for req
			guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setBPONo(bpo.getPoNumber());
			guidedItem.setCategory(category);

			// To guided procurement page
			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			PageOnlineStore.fillSearchText(driver, testCaseName, CommonUtilities.getRandomStringWithSize(7));
			PageOnlineStore.clickSearchButton(driver, testCaseName);

			// Guided procurement link
			PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);

			// Fill guided item form
			FlowFillGuidedItem.fillGuidedItem(driver, testCaseName, guidedItem);
			PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);

			ActionBot.scrollUp(driver, "2000");

			boolean flag = PageFreeTextForm.isErrorMessageVisible(driver, testCaseName);

			flag = !flag;

			org.testng.Assert.assertTrue(flag, "Validation not present for unauthorized category");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
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
	 * <b>Author: Rohini Shinge </b> <b>Method :Requester should be able to change
	 * the BPO related info from checkout screen also while editing item.
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11798(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean EPROC_11798 = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			Requisition requisition = new Requisition();
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// To add items
			Item items = new Item();
			if (requisition.getItems() != null)
			{
				items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
				requisition.setItems(items);

				boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
				assertTrue("Item added to cart are wrong", flag);
				ModalShoppingCart.continueWithCart(driver, testCaseName);
			}

			// To checkout
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

			// On checkout page
			PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// Select BPO from modal
			ModalBlanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.clickOnSelectBPOButton(driver, testCaseName);
			EPROC_11798 = ModalBlanketOrdersForFreeTextItem.getContractNumber(driver, testCaseName) != null;
			Assert.assertTrue("BPO not filled", EPROC_11798);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}

		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);

		}
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b>Method : Buyer should be able to change the
	 * BPO related info from REQ edit screen on buyer desk also while editing item.
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_11811(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// Get requisition object
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			// Edit req on buyer desk
			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);

			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			PageBuyersDesk.clickOnItemNoLink(driver, testCaseName);

			// Switch to supplier tab
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);

			// Open show po modal
			ModalGuidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);

			// Select BPO from modal
			ModalBlanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
			ModalBlanketOrdersForFreeTextItem.clickOnSelectBPOButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}

		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}

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
