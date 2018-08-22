package com.zycus.automation.eproc.testcase.regression.multipleItems;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.ApiConsole;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.ceformflow.FlowCEform;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.IFlowMyRequisitionUtil;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.pageobjects.modals.createfieldofceform.ModalCreateFieldOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.createsectionofceform.ModalCreateSectionOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform.ModalFieldPropertiesOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.IModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation.ModalPOItemSummaryCostAllocation;
import com.zycus.automation.eproc.pageobjects.modals.selectbuofceform.ModalSelectBUOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform.ModalSelectCategoryOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSBusinessUnitPageMasterDataSetting.TMSPageBusinessUnitSetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSCompanyPageMasterDataSettings.TMSPageCompanySetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSCostCentersPageMasterDataSetting.TMSPageCostCenterSetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSLocationsPageMasterDataSetting.TMSPageLocationsSetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSProjectPageMasterDataSettings.TMSPageProjectSetting;
import com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSmasterDataSettings.PageTMSMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.PageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createpeform.PageCreatePEform;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.tabs.TMS_MainPageHeaderLevelTabs.PageTMSmainHeaderLevelTabs;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.iConsole.businessFlows.apiConsoleFlow.FlowApiConsole;
import com.zycus.automation.requisitionparser.test.CommonUtil;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.framework.dom_parser.framework.WriteExcel;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;
import com.zycus.zsn.automation.bo.CatalogItem;

import jxl.demo.Write;

public class MultipleItems extends TestDataProvider
{

	static Logger logger = Logger.getLogger(MultipleItems.class);

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Add new Item To Existing po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void addMoreItemToPo(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		StandardPO standardPO = new StandardPO();
		User user = null;
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase, IConstants.eProc);

			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.GUIDED_ITEM);
			standardPO.setNextAction(IConstantsData.SAVE_PO_AS_DRAFT);

			// catelog item list
			List<GuidedItem> guidedItemList = new ArrayList<GuidedItem>();

			for (int i = 0; i < 5; i++)
			{
				// catelog item
				GuidedItem guidedItem = new GuidedItem();
				guidedItem = ObjectCreation.getDefaultGuidedItemObject(null);
				// Add item
				guidedItemList.add(guidedItem);
			}

			standardPO.getItems().setGuidedItems(guidedItemList);
			standardPO.setPoNumber("COM001/17/1222");

			FlowPoListing.searchPo(driver, testCaseName, "COM001/17/1222", IConstantsData.SEARCH_BY_PO_NO);
			FlowPoListing.viewPO(driver, testCaseName);

			ActionBot.defaultSleep();
			ActionBot.scroll(driver);
			try
			{
				standardPO.setItems(FlowStandardPo.addItem(driver, testCaseName, standardPO.getItems()));
				ActionBot.defaultSleep();
				ActionBot.scroll(driver);
			}
			catch (Exception e)
			{
				logger.info("Exception while adding item : " + e, e);
			}
			finally
			{
				if (ActionBot.isElementPresent(driver, IModalPOItemSummaryCostAllocation.BUTTON_CANCEL_ITEM_SUMMARY))
				{
					ModalPOItemSummaryCostAllocation.clickOnCancel(driver);
				}
				standardPO.setItems(FlowStandardPo.addItem(driver, testCaseName, standardPO.getItems()));
				ActionBot.defaultSleep();
				ActionBot.scroll(driver);
			}

			PageStandardPO.clickOnExpandAll(driver);
			// item level info
			// catalog item
			for (CatelogItem catelogItem : standardPO.getItems().getCatelogItems())
			{
				String itemID = catelogItem.getItemID();
				PageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);

				ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
				if (catelogItem.getCostBookingItemSummary() != null)
				{
					/*
					 * catelogItem.setCostBookingItemSummary(FlowStandardPo.
					 * fillItemSummaryCostBooking(driver, testCaseName,
					 * catelogItem.getCostBookingItemSummary()));
					 */
				}
				else if (standardPO.getAccountingItemSummary() != null)
				{
					// ModalPOItemSummaryAccounting.clickOnAccounting(driver);
					// ModalPOItemSummaryCostAllocation.clickOnCostBookingTab(driver,
					// testCaseName);
					FlowStandardPo.fillAccountingDetails(driver, testCaseName, standardPO.getAccountingItemSummary());
				}
			}

			// terms and condition
			standardPO.setTermsAndConditions(PageStandardPO.getTermsAndConditions(driver, testCaseName));

			// notes
			if (standardPO.getNotes() == null)
			{
				standardPO.setNotes(PageStandardPO.enterNotes(driver, testCaseName, standardPO.getNotes()));
			}

			FlowStandardPo.savePOAsDraft(driver, testCaseName);

			driver.navigate().refresh();
			ActionBot.defaultMediumSleep();
			// driver.get(url);
			// search po

			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				FlowStandardPo.savePOAsDraft(driver, testCaseName);
			}
			catch (Exception e)
			{
				logger.error("Exception while saving po as draft" + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> To edit company in tms in loop <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void editCompanyInTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();

		try
		{
			CommonServices.startTestCase(driver, testCase);
			String companyName = "T3-Acme Engineering Services 1";

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			// login and navigate to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// to navigate to company page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkCompany(driver, testCaseName);

			for (int i = 1; i <= 1000; i++)
			{
				// search for company
				TMSPageCompanySetting.fillSearchBox(driver, testCaseName, companyName);
				TMSPageCompanySetting.selectSearchInCompany(driver, testCaseName, IConstantsData.COMPANY);
				TMSPageCompanySetting.clickButtonGo(driver, testCaseName);

				// edit and update
				TMSPageCompanySetting.clickLinkEditCompany(driver, testCaseName);
				TMSPageCompanySetting.clickButtonEditCompany(driver, testCaseName);
				logger.info("Company Updated " + i + " times");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 50
				if (i % 50 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("Company refreshed after count: " + i);
				}
			}

			// navigate to eproc for logout
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> To edit project in tms in loop <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void editProjectInTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();

		try
		{
			CommonServices.startTestCase(driver, testCase);
			String projectName = "T3-Acme Engineering Services 1";

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			// login and navigate to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// to navigate to projects page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkProjects(driver, testCaseName);

			for (int i = 1; i <= 1000; i++)
			{
				// search for project
				TMSPageProjectSetting.fillSearchBox(driver, testCaseName, projectName);
				TMSPageProjectSetting.selectSearchIn(driver, testCaseName, IConstantsData.PROJECT_TASK_NAME);
				TMSPageProjectSetting.clickButtonGo(driver, testCaseName);

				// edit and update
				TMSPageProjectSetting.clickLinkEditProject(driver, testCaseName);
				TMSPageProjectSetting.clickButtonAddProject(driver, testCaseName);
				logger.info("project Updated " + i + " times");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 50
				if (i % 50 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("Project refreshed after count: " + i);
				}
			}

			// navigate to eproc for logout
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> To edit business unit in tms in loop <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void editBusinessUnitInTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();

		try
		{
			CommonServices.startTestCase(driver, testCase);
			String buName = "T3-Acme Engineering Services";

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			// login and navigate to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// to navigate to bu page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkBusinessUnit(driver, testCaseName);

			for (int i = 1; i <= 1000; i++)
			{
				// search for bu
				TMSPageBusinessUnitSetting.fillSearchBox(driver, testCaseName, buName);
				TMSPageBusinessUnitSetting.selectSearchInBusinessUnit(driver, testCaseName, IConstantsData.BUSINESS_UNIT);
				TMSPageBusinessUnitSetting.clickButtonGo(driver, testCaseName);

				// edit and update
				TMSPageBusinessUnitSetting.clickLinkEditBU(driver, testCaseName);
				TMSPageBusinessUnitSetting.clickButtonEditBU(driver, testCaseName);
				logger.info("BU Updated " + i + " times");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 50
				if (i % 50 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("BU refreshed after count: " + i);
				}
			}

			// navigate to eproc for logout
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> To edit locations in tms in loop <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void editLocationsInTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();

		try
		{
			CommonServices.startTestCase(driver, testCase);
			String locationName = "T3-Pittsford Chamber of Commerce";

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			// login and navigate to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// to navigate to locations page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkLocations(driver, testCaseName);

			for (int i = 1; i <= 1000; i++)
			{
				// search for locations
				TMSPageLocationsSetting.fillSearchBox(driver, testCaseName, locationName);
				TMSPageLocationsSetting.selectSearchInLocations(driver, testCaseName, IConstantsData.NAME);
				TMSPageLocationsSetting.clickButtonGo(driver, testCaseName);

				// edit and update
				TMSPageLocationsSetting.clickLinkEditLocations(driver, testCaseName);
				TMSPageLocationsSetting.clickButtonEditLocations(driver, testCaseName);
				logger.info("Loc Updated " + i + " times");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 50
				if (i % 50 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("Location refreshed after count: " + i);
				}
			}

			// navigate to eproc for logout
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b> To edit locations in tms in loop <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the invoice number in the
	 * invoice list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void editCostCenterInTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();

		try
		{
			CommonServices.startTestCase(driver, testCase);
			String ccName = "T3-Finance Department";

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			// login and navigate to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);

			// to navigate to cost center page
			PageTMSmainHeaderLevelTabs.clickOnMasterDataSettingsTab(driver, testCaseName);
			PageTMSMasterDataSettings.clickOnLinkCostCenters(driver, testCaseName);

			for (int i = 1; i <= 1000; i++)
			{
				// search for cost center
				TMSPageCostCenterSetting.fillSearchBox(driver, testCaseName, ccName);
				TMSPageCostCenterSetting.selectSearchInCostCenter(driver, testCaseName, IConstantsData.NAME);
				TMSPageCostCenterSetting.clickButtonGo(driver, testCaseName);

				// edit and update
				TMSPageCostCenterSetting.clickLinkEditCostCenter(driver, testCaseName);
				TMSPageCostCenterSetting.clickButtonEditCostCenter(driver, testCaseName);
				logger.info("CC Updated " + i + " times");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 50
				if (i % 50 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("CC refreshed after count: " + i);
				}
			}

			// navigate to eproc for logout
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
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
	 * <font color="blue">Method :</b>create a requisition with all values. <br>
	 * 
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createMultipleRequisition(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		Requisition requisition = new Requisition();
		Item item = new Item();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			for (int i = 1; i <= 500; i++)
			{
				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);

				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				BillingRequisitionSummary billingreqsummary = new BillingRequisitionSummary();
				billingreqsummary.setCompany("T3-Acme Engineering Services 1");
				billingreqsummary.setBusinessUnit("T3-Acme Engineering Services");
				billingreqsummary.setLocation("T3-Pittsford Chamber of Commerce");
				billingreqsummary.setNextAction(IConstantsData.SAVE);

				requisition.setBillingRequisitionSummary(billingreqsummary);

				requisition.setCostBookingRequisitionSummary(null);

				// navigate to online store page
				MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

				// to create req
				requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

				logger.info("Created " + i + " Requisition");

				// to refresh browser at interval of 30
				if (i % 30 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("Req refreshed after count: " + i);
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>create a requisition with all values. <br>
	 * 
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void createMultiplePurchaseOrder(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		// float price = (float) 968549733695.36;
		Item item = new Item();
		try
		{

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			// to login with custom user
			user.setUsername("kunal.qa@zycus.com");
			user.setPassword("eProc@123");
			LoginLogoutServices.login(driver, testCase, user);

			StandardPO standardPO = new StandardPO();
			List<CatelogItem> listOfCatalogItems = new ArrayList<CatelogItem>();

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			listOfCatalogItems = item.getCatelogItems();

			// to set max quantity
			for (CatelogItem catelogItem : listOfCatalogItems)
			{
				catelogItem.setQuantity(500);
			}

			for (int i = 1; i <= 500; i++)
			{

				// to get standard PO object
				standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
				standardPO.getItems().getCatelogItems().get(0).setQuantity(500);

				standardPO.setSupplierName("DELL MARKETINGEDIT");
				standardPO.setBuyer(user.getUsername());
				standardPO.setCurrencyType("INR");
				standardPO.setRemoveAllTaxes(true);

				BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
				billingRequisitionSummary.setCompany("T3-Acme Engineering Services 1");
				billingRequisitionSummary.setBusinessUnit("T3-Acme Engineering Services");
				billingRequisitionSummary.setLocation("T3-Pittsford Chamber of Commerce");
				billingRequisitionSummary.setNextAction(IConstantsData.SAVE);
				standardPO.setBillingRequisitionSummary(billingRequisitionSummary);
				standardPO.setCostBookingRequisitionSummary(null);

				// to create standard PO
				standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

				logger.info("Created " + i + " PO");
				ActionBot.defaultSleep();

				// to refresh browser at interval of 30
				if (i % 30 == 0)
				{
					driver.navigate().refresh();
					ActionBot.waitForPageLoad(driver);
					logger.info("PO refreshed after count: " + i);
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> test data creation for api testing.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void getRequisitionExternalID_API_DataCreation(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		Requisition requisition = new Requisition();
		Item item = new Item();
		List<String> externalIdList = new LinkedList<String>();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			//int iteration_Count = Integer.parseInt(CommonServices.getTestData("Iteration_Count"));
			int iteration_Count = 1;
			//to iterate and create multiple requisition
			for (int i = 1; i <= iteration_Count; i++)
			{
				// to get Item object
				item = ObjectCreation.getItem(IConstantsData.BOTH);
				// to get requisition object
				requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				requisition.setOnBehalfOf(null);
				requisition.setEditHeaderLevelInfo(false);
				requisition.setEditItemLevelInfo(false);
				requisition.setNextAction(IConstantsData.SUBMIT_REQ);

				// to create req
				requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

				/*if (!requisition.isExternalAgentAvailable())
				{
					Assert.assertTrue(false, "External agent not available in Workflow Trail");
				}*/

				// to search req in my req tab
				requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
				assertTrue("Requisition was not searched in my requisition tab", requisition.isResult());

				//to add req external id to list object
				if (requisition.getRequisitionExternalId() != null)
				{
					externalIdList.add(requisition.getRequisitionExternalId());
				}
				
				WriteExcel.excelCreationForAPI_DataDumping(requisition.toString(),testCaseName);
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
			//to write external id in excel file
			WriteExcel.writeExternalID_API_DataCreation(externalIdList);

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}		
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> test data creation for api testing.
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void getPOExternalID_API_DataCreation(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		List<String> externalIdList = new LinkedList<String>();
		StandardPO standardPO = new StandardPO();
		Item item = new Item();
		Boolean flag = false;
		String status = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			user = LoginLogoutServices.login(driver, testCase);

			int iteration_Count = Integer.parseInt(CommonServices.getTestData("Iteration_Count"));

			//to iterate and create multiple PO
			for (int i = 1; i <= iteration_Count; i++)
			{

				// standard PO object creation
				standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
				standardPO.setOrderDescription(CommonServices.getTestData(IConstantsData.ORDER_DESCRIPTION) + "_" + i);
				standardPO.getItems().getCatelogItems().get(0).setQuantity(1);
				standardPO.setEditHeaderLevelInfo(false);
				standardPO.setAttachments(null);
				standardPO.setRemoveAllTaxes(true);

				// to create standard PO
				standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

				//search created po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				//po status
				status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);

				//to approve po if status is in approval
				if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
				{
					// to approve PO
					ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
					approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(), IConstantsData.PURCHASE_ORDER,
						IConstantsData.APPROVE);

					FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

					ActionBot.defaultSleep();

					// search po
					flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
					assertTrue("Error while searching PO", flag);

					flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);

					//if po is not released post approval
					if (!flag)
					{
						//Manually releasing PO
						PagePurchaseOrderListing.clickOnActionsDropdownLink(driver, testCaseName, 1);
						ModalViewPOActions.clickOnReleasePoLink(driver, testCaseName);
						ModalViewPOActions.clickOnReleasePoButton(driver, testCaseName);
					}

					ActionBot.defaultSleep();
				}

				//to amend PO
				PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
				PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
				ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

				// to get item object having guided item
				item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
				item.getGuidedItems().get(0).setQuantity(10f);
				item.getGuidedItems().get(0).setPrice(2000);
				item.getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);

				ActionBot.scroll(driver, "650");

				// to Amend PO
				item = FlowStandardPo.addItem(driver, testCaseName, item);
				ActionBot.waitForPageLoad(driver);

				// to submit PO for processing
				FlowStandardPo.submitPoForProcessing(driver, testCaseName);

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
			//to write external id in excel file
			WriteExcel.writeExternalID_API_DataCreation(externalIdList);

			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}


	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Create Multiple process Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Check for the pform name in the
	 * list </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void createMultiplePForm(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		try
		{
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			PEform pEform = new PEform();
			for (int i = 1; i <= 60; i++)
			{
				pEform = ObjectCreation.getDefaultPEformObject();
				pEform.setPeformName("Automation_" + CommonUtilities.getNonZeroRandomNumber(6) + "_50");

				// navigate to eForm page
				MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);
				PageCEformListing.clickOnOnlineEditor(driver, testCaseName);

				// fill eform detials
				if (pEform.getPeformName() != null)
				{
					pEform.setPeformName(PageCreatePEform.fillPEformName(driver, testCaseName, pEform.getPeformName()));
				}
				if (pEform.getProcessName() != null)
				{
					pEform.setProcessName(PageCreatePEform.selectProcessForPEform(driver, testCaseName, pEform.getProcessName()));
				}

				if (pEform.isChangeOU())
				{
					// to select OU
					PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
					// need to change code later
					ModalSelectBUOfCEform.selectIstOrganisationUnit(driver, testCaseName);
					// select bu
					ActionBot.defaultSleep();
					ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
					ActionBot.defaultSleep();
					ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
					ActionBot.defaultSleep();
					ActionBot.defaultSleep();
					ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
					// save modal
					ModalSelectBUOfCEform.clickBtnSaveSelectedOu(driver, testCaseName);
					ActionBot.defaultSleep();
					ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
				}

				// to save and continue
				PageCreatePEform.clickOnSavePEformButton(driver, testCaseName);

				// to add section
				pEform.setSectionName(CommonUtilities.getSectionName());
				PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
				// to fill section details
				pEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, pEform.getSectionName()));
				ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

				// to add multiple fields on eform
				for (int a = 1; a <= 50; a++)
				{
					if (pEform.isAddSectionAndField())
					{
						pEform.setFieldName(CommonUtilities.getFieldName() + "_" + a);
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
						// to fill field properties
						pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, pEform.getFieldName()));
						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
					}
				}

				// publish eform
				PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
				ActionBot.waitForPageLoad(driver);
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
}
