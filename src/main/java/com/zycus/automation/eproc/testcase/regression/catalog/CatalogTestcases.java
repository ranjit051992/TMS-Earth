/**
 * 
 */
package com.zycus.automation.eproc.testcase.regression.catalog;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.Catalog;
import com.zycus.automation.bo.User;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.IFlowAllRequestsApprovalUtilies;
import com.zycus.automation.eproc.businessflow.catalogflow.FlowCatalog;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.businessflow.viewcatalogflow.FlowViewCatalog;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.PageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

/**
 * @author ankita.sawant
 *
 */
public class CatalogTestcases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(CatalogTestcases.class);

	/*
	 * protected static List<Object> getProviders() {
	 * 
	 * List<Object> providers = new ArrayList<Object>(); providers.add(new
	 * JacksonJsonProvider()); return providers; }
	 * 
	 */

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Requisition Checkout Page>>Item details
	 * modal: Verify Item details modal with multilingual characters in the
	 * following fields: Short Description; Supplier Part Id; Price; Item image;
	 * Quantity box; UOM; Description; Manufacturer; Category; SPSC Code;
	 * Supplier; Delivery Lead Time (days); Contract No; Specification Name;
	 * Specification Key; Specification Value; Attachment files and web links
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	/*
	 * @Test(dataProvider = "dataProvider") public void
	 * ItemMasterTestCase(TestCase testCase) throws Exception { try {
	 * ItemMasterItem itemMasterItem = new ItemMasterItem();
	 * 
	 * itemMasterItem.setScopeId("def68304-7e50-463c-95f5-7af9dcb4e600");
	 * itemMasterItem.setSupplierId(629867); itemMasterItem.setSupplierName(
	 * "EBAY OFFICE SUPPLIERS");
	 * itemMasterItem.setSupplierAuxPartId("supplierAuxPartId");
	 * itemMasterItem.setCatalogVersion(3);
	 * itemMasterItem.setCatalogItemId(123);
	 * itemMasterItem.setSupplierPartId("supplierAuxPartId");
	 * itemMasterItem.setCategoryName("Freedom of speech defense associations");
	 * itemMasterItem.setName("lcd_787678"); itemMasterItem.setDescription(
	 * "API New description"); itemMasterItem.setUom("EA");
	 * itemMasterItem.setCurrency("INR"); itemMasterItem.setSourceType(123);
	 * itemMasterItem.setSourceRefNo("API New ERP ID");
	 * itemMasterItem.setPrice(13d); itemMasterItem.setMarketPrice(15d);
	 * itemMasterItem.setLeadTime(2);
	 * itemMasterItem.setCategoryCode("82151503");
	 * itemMasterItem.setManufacturerPartId("manufacturerPartId");
	 * itemMasterItem.setManufacturerName("manufacturerName");
	 * itemMasterItem.setSupplierProductURL("supplierProductURL");
	 * itemMasterItem.setManufacturerProductURL(
	 * "https://eproc.eprocdev.zycus.net:7010/eproc/"); itemMasterItem
	 * .setImageURL(
	 * "https://www.google.co.in/search?q=famous+brand+logo&espv=2&biw=1600&bih=775&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi51bXCm6TMAhVPkY4KHXI7AeoQ_AUIBigB#imgrc=yu4fKGNNtq0BJM%3A"
	 * ); itemMasterItem .setThumbnailURL(
	 * "https://www.google.co.in/search?q=famous+brand+logo&espv=2&biw=1600&bih=775&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi51bXCm6TMAhVPkY4KHXI7AeoQ_AUIBigB#tbm=isch&q=nike+logo&imgrc=BtMlRck0yEoj6M%3A"
	 * ); itemMasterItem.setActive(true); itemMasterItem.setHidden(false);
	 * itemMasterItem.setGreenItem(false);
	 * itemMasterItem.setPreferredItem(false);
	 * itemMasterItem.setOutOfStock(false); List<ItemAttribute> itemAttributes =
	 * new ArrayList<>(); ItemAttribute attribute = new ItemAttribute();
	 * attribute.setKey("Color"); attribute.setValue("Red");
	 * itemAttributes.add(attribute);
	 * itemMasterItem.setItemAttributes(itemAttributes);
	 * 
	 * String apiUrl =
	 * "http://192.168.1.186:8010/eproc/rest/catalog/addUpdateItem?tenantId=" +
	 * CommonServices.getTestData(IConstantsData.TENANT_ID) +
	 * "&itemMaster=Automation_Test&userId=ankita_autox@zycus.com";
	 * System.out.println("URL : " + apiUrl); WebClient client =
	 * WebClient.create(apiUrl, getProviders());
	 * 
	 * /** Client client = ClientBuilder.newClient(); WebTarget target =
	 * client.target(apiUrl);
	 **/

	/*
	 * ObjectMapper mapper = new ObjectMapper(); String json =
	 * mapper.writeValueAsString(itemMasterItem); logger.info("JSON : " + json);
	 * 
	 * Response response =
	 * client.accept("application/json").type("application/json").post(json);
	 * /**Response response = target.request().put(Entity.json(itemMasterItem));
	 * response.readEntity(String.class);
	 * logger.info(response.readEntity(String.class));
	 **/

	/*
	 * int status = response.getStatus(); logger.info("Status : " + status);
	 * 
	 * if (status == 200) { logger.info("Successful ...."); } } catch
	 * (AssertionError e) { e.printStackTrace(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 */

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Hide items in catalog and check <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void hideUnhideItemInCatalogs(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Catalog catalog = new Catalog();
		String status;
		boolean flag = false, catalogCreatedFlag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			catalog = ObjectCreation.getDefaultCatalogObject();

			// create catalog
			catalog = FlowCatalog.createCatalog(driver, testCaseName, catalog);
			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			catalogCreatedFlag = true;
			assertTrue("Catalog was not created", flag);

			// to approve catalog

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();

			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
			approvalAllRequests.setDocumentType(IConstantsData.CATALOG);
			approvalAllRequests.setDocumentName(catalog.getCatalogName());
			FlowCatalog.approveCatalog(driver, testCaseName, approvalAllRequests);

			IFlowAllRequestsApprovalUtilies.performApproveThroughActionsDropdown(driver, testCaseName, approvalAllRequests, 1);

			// Publish catalog
			status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
			flag = status.equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL);
			assertTrue("Status of catalog was not published", flag);

			// to view the catalog
			FlowCatalog.viewCatalog(driver, testCaseName);

			// hide item
			flag = FlowViewCatalog.hideItem(driver, testCaseName, catalog.getCatelogItems().get(0).getItemName());
			// System.out.println("============== Hide Flag : " + flag);
			assertTrue("Error while hiding item in catalog", flag);

			ActionBot.scrollUp(driver, "300");
			// search item
			MainPageHeaderLevelTab.clickOnCatalogSubTab(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowSearchListing.searchItem(driver, testCaseName, catalog.getCatelogItems().get(0).getItemName());
			List<WebElement> searchedItemNames = PageSearchListing.getItemName(driver, testCaseName);
			flag = true;
			for (WebElement element : searchedItemNames)
			{
				if (element.getText().equalsIgnoreCase(catalog.getCatelogItems().get(0).getItemName()))
				{
					flag = false;
					break;
				}
			}
			assertTrue("Hidden item was shown in search listing page", flag);

			// search catalog
			flag = FlowCatalog.searchCatalog(driver, testCaseName, catalog.getCatalogName());
			catalogCreatedFlag = true;
			assertTrue("Error while searching Catalog", flag);

			// to view the catalog
			FlowCatalog.viewCatalog(driver, testCaseName);

			// unhide item
			flag = FlowViewCatalog.unHideItem(driver, testCaseName, catalog.getCatelogItems().get(0).getItemName());
			// System.out.println("============== UnHide Flag : " + flag);
			assertTrue("Error while unhiding item in catalog", flag);

			// search item
			ActionBot.scrollUp(driver, "300");
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowSearchListing.searchItem(driver, testCaseName, catalog.getCatelogItems().get(0).getItemName());
			searchedItemNames = PageSearchListing.getItemName(driver, testCaseName);
			flag = false;
			for (WebElement element : searchedItemNames)
			{
				if (element.getText().equalsIgnoreCase(catalog.getCatelogItems().get(0).getItemName()))
				{
					flag = true;
					break;
				}
			}
			assertTrue("UnHidden item was not shown in search listing page", flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
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
				if (catalogCreatedFlag)
				{
					FlowCatalog.deactivateAndDeleteCatalog(driver, testCaseName, catalog);
				}
			}
			catch (Exception e)
			{
				logger.error("Exception occurred while deactivating catalog : " + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Hide items in catalog and check <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	/*
	 * @Test(dataProvider = "dataProvider", retryAnalyzer =
	 * CustomRetryListener.class) public void itemMasterCatalogs(TestCase
	 * testCase) throws Exception { WebDriver driver =
	 * DriverSelector.getDriver(testCase); String testCaseName =
	 * testCase.getTestMethodName(); Map<String, String> map = new
	 * HashMap<String, String>(); CommonServices.startTestCase(driver,
	 * testCase); User user = null; ItemMasterCatalog itemMasterCatalog = new
	 * ItemMasterCatalog(); String itemMasterName = null; boolean flag = false,
	 * catalogCreatedFlag = false; try { user =
	 * LoginLogoutServices.login(driver, testCase);
	 * 
	 * itemMasterCatalog = ObjectCreation.getDefaultItemMasterCatalogObject();
	 * 
	 * //item master catalog itemMasterCatalog =
	 * FlowCreateItemMaster.createItemMaster(driver, testCaseName,
	 * itemMasterCatalog); itemMasterName =
	 * itemMasterCatalog.getItemMasterName(); //search item master catalog flag
	 * = FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName,
	 * itemMasterName); catalogCreatedFlag = true; assertTrue(
	 * "Catalog was not created", flag); itemMasterCatalog .getItemMasterItems()
	 * .get(0) .setCatalogVersion(
	 * Integer.parseInt(PageItemMasterCatalogListing.getVersionOfItemMaster(
	 * driver, testCaseName)));
	 * 
	 * itemMasterCatalog.getItemMasterItems().get(0).setActive(true);
	 * itemMasterCatalog.getItemMasterItems().get(0).setHidden(false);
	 * 
	 * String apiUrl =
	 * "http://192.168.1.186:8010/eproc/rest/catalog/addUpdateItem?tenantId=" +
	 * CommonServices.getTestData(IConstantsData.TENANT_ID) + "&itemMaster=" +
	 * itemMasterCatalog.getItemMasterName() + "&userId=" + user.getUsername();
	 * System.out.println("URL : " + apiUrl); WebClient client =
	 * WebClient.create(apiUrl, getProviders()); ObjectMapper mapper = new
	 * ObjectMapper(); String json =
	 * mapper.writeValueAsString(itemMasterCatalog.getItemMasterItems().get(0));
	 * logger.info("JSON : " + json);
	 * 
	 * Response response =
	 * client.accept("application/text").type("application/text").post(json);
	 * int status = response.getStatus(); logger.info("Status : " + status);
	 * 
	 * if (status == 200) { logger.info("Successful ...."); }
	 * 
	 * //search item //MainPageHeaderLevelTab.clickOnCatalogSubTab(driver,
	 * testCaseName); MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	 * FlowSearchListing.searchItem(driver, testCaseName,
	 * itemMasterCatalog.getItemMasterItems().get(0).getName());
	 * List<WebElement> searchedItemNames =
	 * PageSearchListing.getItemName(driver, testCaseName); flag = true; for
	 * (WebElement element : searchedItemNames) { if
	 * (element.getText().equalsIgnoreCase(itemMasterCatalog.getItemMasterItems(
	 * ).get(0).getName())) { flag = false; break; } } assertTrue(
	 * "Hidden item was shown in search listing page", flag);
	 * CommonServices.successfulExecutionOfTestCase(driver, testCase); } catch
	 * (AssertionError e) { CommonServices.assertionMethod(driver, testCase,
	 * user, e); } catch (Exception e) { CommonServices.exceptionMethod(driver,
	 * testCase, user, e); } finally { try { if (catalogCreatedFlag) {
	 * FlowItemMasterListing.deactivateAndDeleteItemMaster(driver, testCaseName,
	 * itemMasterName); } } catch (Exception e) { logger.error(
	 * "Exception occurred while deactivating catalog : " + e, e); } finally {
	 * CommonServices.afterExecutionOfTestcase(driver, testCase, map, user); } }
	 * }
	 */

}
