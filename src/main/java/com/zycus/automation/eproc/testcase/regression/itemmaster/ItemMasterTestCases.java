/**
 * 
 */
package com.zycus.automation.eproc.testcase.regression.itemmaster;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.ItemMasterCatalog;
import com.zycus.automation.bo.ItemMasterItem;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.itemmasterflow.FlowCreateItemMaster;
import com.zycus.automation.eproc.businessflow.itemmasterflow.FlowItemMasterListing;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.additemtocatalog.ModalAddItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.ModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon.ModelRequisitionSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.itemSummaryDelivery.ModalItemSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.itemmasteritemdetails.ModalItemMasterItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.PageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.itemmastercataloglisting.PageItemMasterCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
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
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

/**
 * @author ankita.sawant
 *
 */
public class ItemMasterTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(ItemMasterTestCases.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Item master >> Non-Inventory Items >>
	 * Sourcing status data should be properly stored for Non-inventory Items.
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void ECATALOG_688(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_681"));// 0
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_685"));// 1
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_683"));// 2
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_677"));// 3
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_687"));// 4
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_207"));// 5
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		ItemMasterCatalog itemMasterCatalog = new ItemMasterCatalog();
		ItemMasterItem itemMasterItem = new ItemMasterItem();
		String itemId = null, log = "", sourcingStatus = null;
		boolean flag = false, mandatoryIconFlag = true, catalogPublishedFlag = false, catalogDraftFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item Master object
			itemMasterCatalog = ObjectCreation.getDefaultItemMasterCatalogObject(IConstantsData.NonInventory_Item_Master_Type);
			itemMasterCatalog.setNextActionItemDetails(IConstantsData.NONE);
			itemMasterCatalog.setOrganizationUnit(null);
			itemMasterCatalog.setNextActionScopeAndValidity(IConstantsData.NONE);

			itemMasterItem = ObjectCreation.getDefaultItemMasterItemObjectForItemMasterCreation();
			itemMasterCatalog.getItemMasterItems().add(itemMasterItem);

			// create non-inventory item master catalog
			itemMasterCatalog = FlowCreateItemMaster.createItemMaster(driver, testCaseName, itemMasterCatalog);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			RTC_EPROC_283:
			{
				ActionBot.scroll(driver, "200");
				flag = ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
				ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "ERP part no field was editable while editing Item.");
			}

			RTC_EPROC_277:
			{
				ItemMasterItem searchedItemMasterItem = FlowCreateItemMaster.searchItemMasterItem(driver, testCaseName, IConstantsData.Search_By_ERP_Part_No,
					itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				flag = searchedItemMasterItem.getSourceRefNo().equalsIgnoreCase(itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1),
					"User was not able to Search Non-Inventory Items based on ERP Part No field in Scope and Validity page while creating Non-inventory Item master.");
			}

			// click on next button on item detail page
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);

			RTC_EPROC_281:
			{
				ItemMasterItem searchedItemMasterItem = FlowCreateItemMaster.searchItemMasterItem(driver, testCaseName, IConstantsData.Search_By_ERP_Part_No,
					itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				flag = searchedItemMasterItem.getSourceRefNo().equalsIgnoreCase(itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2),
					"User was not able to Search Non-Inventory Items based on ERP Part No field in Scope and Validity page while creating Non-inventory Item master.");
			}

			// to save catalog in draft state
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
			catalogDraftFlag = true;

			// search item master
			flag = FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
			Assert.assertTrue(flag, "Item Master was not searched");

			flag = PageItemMasterCatalogListing.getStatusOfFirstItemMaster(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			Assert.assertTrue(flag, "Status of Item Master was wrong. It should be Draft");

			// view item master
			FlowItemMasterListing.viewItemMaster(driver, testCaseName);

			// go to item details page
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			RTC_EPROC_287:
			{
				ActionBot.scroll(driver, "200");
				flag = !ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
				ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3), "ERP part no field was editable while editing Item in draft item master.");
			}

			// click on next button on item detail page
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
			itemMasterCatalog.setRegion(null);
			itemMasterCatalog.setOrganizationUnit(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
			// fill scope and validity
			FlowCreateItemMaster.fillScopeAndValidity(driver, testCaseName, itemMasterCatalog);
			// submit catalog
			PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);

			// search item master
			flag = FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
			Assert.assertTrue(flag, "Item Master was not searched");

			CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(5), "Error while searching item master after Publishing");

			// to wait till item master process backend information and changes
			// status to Published
			ActionBot.defaultMediumSleep();

			flag = PageItemMasterCatalogListing.getStatusOfFirstItemMaster(driver, testCaseName).equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL);
			catalogDraftFlag = false;
			catalogPublishedFlag = true;
			Assert.assertTrue(flag, "Status of Item Master was wrong. It should be PUBLISHED");

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			// empty cart
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);

			// search item master item
			FlowSearchListing.searchItem(driver, testCaseName, itemMasterCatalog.getItemMasterItems().get(0).getName());
			itemId = PageSearchListing.getItemId(driver, testCaseName, itemMasterCatalog.getItemMasterItems().get(0).getName());

			// to edit item details
			PageSearchListing.addToCart(driver, testCaseName, itemId);

			// select need a quote
			ModalItemMasterItemDetails.clickOnNeedAQuote(driver, testCaseName);
			if (ModalItemMasterItemDetails.isSupplierNameMandatory(driver, testCaseName))
			{
				log += "Supplier Name was mandatory for Need A Quote item";
				mandatoryIconFlag = false;
			}
			if (ModalItemMasterItemDetails.isPriceMandatory(driver, testCaseName))
			{
				log += "Price was mandatory for Need A Quote item";
				mandatoryIconFlag = false;
			}

			/**
			 * RTC_EPROC_261 : Item master >> Non-Inventory Items >> Sourcing
			 * status : Need a Quote >> Supplier and price should be
			 * non-mandatory.
			 **/
			// clear supplier and price
			ModalItemMasterItemDetails.fillSupplierName(driver, testCaseName, "");
			ModalItemMasterItemDetails.clearPrice(driver, testCaseName);

			// fill quantity
			itemMasterCatalog.getItemMasterItems().get(0)
				.setQuantity(Math.round(ModalItemMasterItemDetails.fillQuantity(driver, testCaseName, CommonUtilities.getNonZeroRandomNumber(2))));

			ModalItemMasterItemDetails.clickOnAddToCartButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();

			Item items = new Item();
			List<ItemMasterItem> itemMasterItems = new ArrayList<>();
			itemMasterItems.add(itemMasterCatalog.getItemMasterItems().get(0));
			items.setItemMasterItems(itemMasterItems);
			// check if item added
			flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
			CommonServices.setMappedTestCaseResult(mandatoryIconFlag && flag, mappedTestCases.get(4), log);

			// view item
			ModalShoppingCart.clickOnItemName(driver, testCaseName, itemMasterCatalog.getItemMasterItems().get(0).getName());
			sourcingStatus = ModalItemMasterItemDetails.getSourcingStatus(driver, testCaseName, itemId);
			ModalItemMasterItemDetails.clickOnCancelButton(driver, testCaseName);
			ModalShoppingCart.continueWithCart(driver, testCaseName);
			flag = sourcingStatus.equalsIgnoreCase(IConstantsData.Need_a_Quote);
			Assert.assertTrue(flag, "For Non-Inventory Items >> Sourcing status data was not stored properly");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (catalogDraftFlag)
				{
					FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
					FlowItemMasterListing.deleteItemMaster(driver, testCaseName);
				}
				else if (catalogPublishedFlag)
				{
					FlowItemMasterListing.deactivateAndDeleteItemMaster(driver, testCaseName, itemMasterCatalog.getItemMasterName());
				}
			}
			catch (Exception e)
			{
				logger.error("Error while delete/deactivate item master");
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Item master >> Non-Inventory Item master
	 * via File upload >> "ERP part no" field should be non-editable while
	 * editing Item which are uploaded via File. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void ECATALOG_679(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ItemMasterCatalog itemMasterCatalog = new ItemMasterCatalog();
		boolean flag = false, catalogDraftFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item Master object
			itemMasterCatalog = ObjectCreation.getDefaultItemMasterCatalogObject(IConstantsData.NonInventory_Item_Master_Type);
			itemMasterCatalog.setNextActionItemDetails(IConstantsData.NONE);
			itemMasterCatalog.setOrganizationUnit(null);
			itemMasterCatalog.setNextActionScopeAndValidity(IConstantsData.NONE);
			itemMasterCatalog.setItemMasterItems(null);
			itemMasterCatalog.setFileName(IConstants.ATTACHMENT_FILES_PATH + IConstantsData.FILE_ITEM_MASTER_TEMPLATE);

			// create non-inventory item master catalog
			itemMasterCatalog = FlowCreateItemMaster.createItemMaster(driver, testCaseName, itemMasterCatalog);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			ActionBot.scroll(driver, "200");
			flag = !ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
			ActionBot.threadSleep(1);
			ScreenShot.screenshot(driver, testCaseName, "Item Details");
			ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
			catalogDraftFlag = true;
			Assert.assertTrue(flag, "ERP part no field was editable while editing Item.");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (catalogDraftFlag)
				{
					FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
					FlowItemMasterListing.deleteItemMaster(driver, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error while deleting item master");
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Item master >> Inventory Item master draft
	 * edit>> "ERP part no" field should be non-editable while editing Item
	 * within draft Item master. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void ECATALOG_676(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_680"));// 0
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_682"));// 1
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_686"));// 2
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_684"));// 3
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		ItemMasterCatalog itemMasterCatalog = new ItemMasterCatalog();
		ItemMasterItem itemMasterItem = new ItemMasterItem();
		boolean flag = false, catalogDraftFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item Master object
			itemMasterCatalog = ObjectCreation.getDefaultItemMasterCatalogObject(IConstantsData.Inventory_Item_Master_Type);
			itemMasterCatalog.setNextActionItemDetails(IConstantsData.NONE);
			itemMasterCatalog.setOrganizationUnit(null);
			itemMasterCatalog.setNextActionScopeAndValidity(IConstantsData.NONE);

			itemMasterItem = ObjectCreation.getDefaultItemMasterItemObjectForItemMasterCreation();
			itemMasterCatalog.getItemMasterItems().add(itemMasterItem);

			// create non-inventory item master catalog
			itemMasterCatalog = FlowCreateItemMaster.createItemMaster(driver, testCaseName, itemMasterCatalog);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			/**
			 * RTC_EPROC_284 : Item master >> Inventory Item master >>
			 * "ERP part no" field should be non-editable while editing Item.
			 **/
			{
				ActionBot.scroll(driver, "200");
				flag = ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
				ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(0), "ERP part no field was editable while editing Item.");
			}

			/**
			 * RTC_EPROC_282 : Item master >>Inventory Item master >> User
			 * should be able to Search Inventory Items based on "ERP part no."
			 * field in Item details page while creating Inventory Item master.
			 **/
			/**
			 * RTC_EPROC_276 : Item master >> Inventory Item master >>
			 * "ERP part no" field should be present in Item listing present in
			 * Item details page while creating Inventory Item master.
			 **/
			{
				ItemMasterItem searchedItemMasterItem = FlowCreateItemMaster.searchItemMasterItem(driver, testCaseName, IConstantsData.Search_By_ERP_Part_No,
					itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				flag = searchedItemMasterItem.getSourceRefNo().equalsIgnoreCase(itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(1),
					"User was not able to Search Inventory Items based on ERP Part No field in Item details page while creating Inventory Item master.");
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(2),
					"ERP part no field was not present in Item listing present in Item details page while creating Inventory Item master.");
			}

			// click on next button on item detail page
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);

			/**
			 * RTC_EPROC_280 : Item master >> Inventory Item master >>
			 * "ERP part no" field should be present in Item listing of scope
			 * and validity page while creating Inventory Item master.
			 **/
			{
				ItemMasterItem searchedItemMasterItem = FlowCreateItemMaster.searchItemMasterItem(driver, testCaseName, IConstantsData.Search_By_ERP_Part_No,
					itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				flag = searchedItemMasterItem.getSourceRefNo().equalsIgnoreCase(itemMasterCatalog.getItemMasterItems().get(0).getSourceRefNo());
				CommonServices.setMappedTestCaseResult(flag, mappedTestCases.get(3),
					"User was not able to Search Inventory Items based on ERP Part No field in Scope and Validity page while creating Inventory Item master.");
			}

			// to save catalog in draft state
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
			catalogDraftFlag = true;

			// search item master
			flag = FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
			Assert.assertTrue(flag, "Item Master was not searched");

			flag = PageItemMasterCatalogListing.getStatusOfFirstItemMaster(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
			Assert.assertTrue(flag, "Status of Item Master was wrong. It should be Draft");

			// view item master
			FlowItemMasterListing.viewItemMaster(driver, testCaseName);

			// go to item details page
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			ActionBot.scroll(driver, "200");
			flag = ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
			ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
			Assert.assertTrue(flag, "ERP part no field was editable while editing Item in draft item master.");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (catalogDraftFlag)
				{
					FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
					FlowItemMasterListing.deleteItemMaster(driver, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error while deleting item master");
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Item master >> Inventory Item master via
	 * File upload>> "ERP part no" field should be non-editable while editing
	 * Items which are uploaded via File. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void ECATALOG_678(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		ItemMasterCatalog itemMasterCatalog = new ItemMasterCatalog();
		boolean flag = false, catalogDraftFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item Master object
			itemMasterCatalog = ObjectCreation.getDefaultItemMasterCatalogObject(IConstantsData.Inventory_Item_Master_Type);
			itemMasterCatalog.setNextActionItemDetails(IConstantsData.NONE);
			itemMasterCatalog.setOrganizationUnit(null);
			itemMasterCatalog.setNextActionScopeAndValidity(IConstantsData.NONE);
			itemMasterCatalog.setItemMasterItems(null);
			itemMasterCatalog.setFileName(IConstants.ATTACHMENT_FILES_PATH + IConstantsData.FILE_ITEM_MASTER_CSV);

			// create inventory item master catalog
			itemMasterCatalog = FlowCreateItemMaster.createItemMaster(driver, testCaseName, itemMasterCatalog);

			// to edit item master item
			PageCreateCatalog.clickOnEditFirstCatalogItem(driver, testCaseName);

			ActionBot.scroll(driver, "200");
			flag = ModalAddItemDetails.isERPIdEditable(driver, testCaseName);
			ActionBot.threadSleep(1);
			ScreenShot.screenshot(driver, testCaseName, "Item Details");
			ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
			catalogDraftFlag = true;
			Assert.assertTrue(flag, "ERP part no field was editable while editing Item.");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (catalogDraftFlag)
				{
					FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
					FlowItemMasterListing.deleteItemMaster(driver, testCaseName);
				}
			}
			catch (Exception e)
			{
				logger.error("Error while deleting item master");
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Verify If 'Asset Numbering Required'
	 * checkbox is selected for an item in item master, on adding such items on
	 * buyers desk, Create asset tags for this item field should be selected by
	 * default(non-editable) <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 2)
	public void ECATALOG_694(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<>();
		{
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_695"));// 0
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_697"));// 1
			mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("ECATALOG_696"));// 2
		}
		CommonServices.startTestCase(driver, testCase, mappedTestCases);
		User user = null;
		Item item = new Item();
		Requisition requisition = new Requisition();
		String error = null, assetNo = null, manSrNo = null, notes = null;
		boolean flag = false, flag1 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			user = LoginLogoutServices.login(driver, testCase);

			item = ObjectCreation.getItem(IConstantsData.ITEM_MASTER_ITEM);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setEditItemLevelInfo(false);
			requisition.setNextAction(IConstantsData.NONE);

			// add item to cart and create requisition
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			/**
			 * RTC_EPROC_366 : Verify As a requestor/buyer(buyer's desk), when
			 * User submits a requisition, system should validate the item
			 * master items which require asset numbering to check if asset
			 * numbers have been provided
			 **/
			// edit item
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);

			flag = ModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxSelected(driver, testCaseName);
			flag1 = ModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxEnabled(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag1 && flag, mappedTestCases.get(0),
				"On editing item master item Create asset tags for this item was unchecked and non-editable ");

			/**
			 * RTC_EPROC_372 : Verify On clicking on Submit requisition, System
			 * should check if asset tagging is done for all the items whose
			 * �Create Asset Tags� flag is checked
			 **/
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);

			FlowRequisition.submitReq(driver, testCaseName, false);

			error = PageRequisitionCheckOut.getAssetNoError(driver, testCaseName, item.getItemMasterItems().get(0).getItemId());
			flag = error.equalsIgnoreCase(IConstantsData.ErrorMsg_AssetNoRequired);
			CommonServices.setMappedTestCaseResult(flag1, mappedTestCases.get(1),
				"After On clicking on Submit requisition, System was not checking if asset tagging is done for all the items whose Create Asset Tags flag is checked");

			// edit item
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);
			ModalItemSummaryDelivery.clickOnTagAssetsLink(driver, testCaseName);

			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
			error = ModalItemSummaryDelivery.getAssetNoError(driver, testCaseName);
			flag = error.equalsIgnoreCase(IConstantsData.ErrorMsg_AssetNoMissing);
			Assert.assertTrue(flag, "Asseet no was not mandatory");

			/**
			 * RTC_EPROC_370 : Verify If 'Asset Numbering Required' checkbox is
			 * selected for an item in item master, on adding such items on
			 * buyers desk, Create asset tags for this item field should be
			 * selected by default(non-editable)
			 **/
			assetNo = "Asset_No_" + CommonUtilities.getNonZeroRandomNumber(2);
			manSrNo = "Manufacturer_Sr_No_" + CommonUtilities.getNonZeroRandomNumber(2);
			notes = "Notes_" + CommonUtilities.getNonZeroRandomNumber(2);
			// fill asset no
			ModalItemSummaryDelivery.fillFirstAssetNo(driver, testCaseName, assetNo);
			ModalItemSummaryDelivery.fillManufacturerSrNo(driver, testCaseName, manSrNo);
			ModalItemSummaryDelivery.fillNotes(driver, testCaseName, notes);

			// fill cost allocation information
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			FlowRequisition.fillCostBookingItemSummary(driver, testCaseName, requisition.getCostBookingItemSummary(), item.getItemMasterItems().get(0).getItemId());

			// submit requisition
			FlowRequisition.submitReq(driver, testCaseName, false);

			// search requisition
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at my requisition", requisition.isResult());

			// approve requisition
			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
				IConstantsData.APPROVE);

			approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			/**
			 * RTC_EPROC_371 : Verify If 'Asset Numbering Required' checkbox is
			 * selected for an item in item master, Create asset tags for this
			 * item field should not be editable to the requester/buyers
			 **/
			// search requisition at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at Buyers Desk", requisition.isResult());

			// view requisition at buyers desk
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			// edit item
			PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName);

			flag = ModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxSelected(driver, testCaseName);
			flag1 = ModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxEnabled(driver, testCaseName);
			CommonServices.setMappedTestCaseResult(flag1 && flag, mappedTestCases.get(2),
				"On editing item master item at buyers desk Create asset tags for this item was unchecked and non-editable ");

			/**
			 * RTC_EPROC_370 : Verify If 'Asset Numbering Required' checkbox is
			 * selected for an item in item master, on adding such items on
			 * buyers desk, Create asset tags for this item field should be
			 * selected by default(non-editable)
			 **/
			ModalItemSummaryDelivery.clickOnTagAssetsLink(driver, testCaseName);
			ModalItemSummaryDelivery.fillFirstAssetNo(driver, testCaseName, "");

			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);

			error = ModalItemSummaryDelivery.getAssetNoError(driver, testCaseName);
			flag = error.equalsIgnoreCase(IConstantsData.ErrorMsg_AssetNoMissing);
			Assert.assertTrue(flag, "Asset no was not mandatory");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
