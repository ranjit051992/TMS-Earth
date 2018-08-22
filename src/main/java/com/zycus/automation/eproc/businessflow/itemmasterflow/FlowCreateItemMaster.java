/**
 * 
 */
package com.zycus.automation.eproc.businessflow.itemmasterflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ItemMasterCatalog;
import com.zycus.automation.bo.ItemMasterItem;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.pageobjects.modals.additemtocatalog.ModalAddItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.itemmasterlistingactions.ModalItemMasterListingActions;
import com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu.ModalSelectCompaniesAndBU;
import com.zycus.automation.eproc.pageobjects.modals.standarditemmastercolumn.ModalStandardItemMasterColumn;
import com.zycus.automation.eproc.pageobjects.modals.uploaditemsincatalog.ModalUploadItemsInCatalog;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.IPageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.IPageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.PageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.createitemmaster.PageCreateItemMaster;
import com.zycus.automation.eproc.pageobjects.pages.itemmastercataloglisting.PageItemMasterCatalogListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.Helper;

/**
 * @author ankita.sawant
 * 
 */
public class FlowCreateItemMaster
{
	static Logger logger = Logger.getLogger(FlowCreateItemMaster.class);

	public static ItemMasterCatalog createItemMaster(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog) throws Exception
	{
		// click on item master tab
		MainPageHeaderLevelTab.clickOnItemMasterSubTab(driver, testCaseName);
		PageItemMasterCatalogListing.clickOnAddItemMasterCatalogButton(driver, testCaseName);

		// to fill catalog wizard
		itemMasterCatalog = fillCreateItemMasterWizard(driver, testCaseName, itemMasterCatalog);

		if (itemMasterCatalog == null)
		{
			return null;
		}
		// submit catalog
		if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
		{
			return itemMasterCatalog;
		}
		else
		{

			if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.SUBMIT_CATALOG))
			{
				PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
			}
			// discard catalog
			else if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
			{
				PageCreateCatalog.clickOnDiscardCatalogButton(driver, testCaseName);
			}
			// close catalog
			else if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
			{
				PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
			}
		}
		return itemMasterCatalog;
	}

	public static ItemMasterCatalog fillCreateItemMasterWizard(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog) throws Exception
	{
		// to fill catalog details
		if (itemMasterCatalog.isFillItemMasterDetails())
		{
			itemMasterCatalog = fillItemMasterDetails(driver, testCaseName, itemMasterCatalog);

			// fill scope and validity

			if (itemMasterCatalog.isFillScopeAndValidity())
			{
				fillScopeAndValidity(driver, testCaseName, itemMasterCatalog);
			}

			if (ActionBot.isElementPresent(driver, IPageCreateCatalog.DUPLICATE_CATALOG_NAME_ERROR))

			{
				String errorMessage = ActionBot.findElement(driver, IPageCreateCatalog.DUPLICATE_CATALOG_NAME_ERROR).getText();
				if (errorMessage.equalsIgnoreCase(IConstantsData.ERROR_MSG_DUPLICATE_ITEM_MASTER))
				{
					itemMasterCatalog.setNextActionItemMasterDetails(IConstantsData.CANCEL);
				}
			}

		}
		// to decide next action
		if (itemMasterCatalog.getNextActionItemMasterDetails().equalsIgnoreCase(IConstantsData.NEXT))
		{
			PageCreateItemMaster.clickOnNextButton(driver, testCaseName);
		}
		else if (itemMasterCatalog.getNextActionItemMasterDetails().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateItemMaster.clickOnCancelButton(driver, testCaseName);
			return null;
		}
		else if (itemMasterCatalog.getNextActionItemMasterDetails().equalsIgnoreCase(IConstantsData.NONE))
		{
			ActionBot.defaultHighSleep();
			return null;
		}
		if (itemMasterCatalog.getFileName() != null)
		{
			PageCreateCatalog.clickOnUploadItemsViaFileButton(driver, testCaseName);
			ModalUploadItemsInCatalog.fillFileName(driver, testCaseName, itemMasterCatalog.getFileName());
			ModalUploadItemsInCatalog.clickOnUploadCatalogButton(driver, testCaseName);
			ActionBot.defaultHighSleep();
			//map column
			//mapColumnsOfItemMasterUploadFile(driver, testCaseName);
		}
		else
		{
			// to add item
			if (itemMasterCatalog.getItemMasterItems() != null)
			{
				itemMasterCatalog = addItemToItemMaster(driver, testCaseName, itemMasterCatalog);
			}
		}

		ActionBot.scroll(driver, "500");

		// to decide item details next action
		if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.NEXT))
		{
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
		}
		else if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
		{
			PageCreateItemMaster.clickOnDiscardItemMasterCatalogLink(driver, testCaseName);
		}
		else if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
		{
			PageCreateItemMaster.clickOnCancelButton(driver, testCaseName);
		}

		return itemMasterCatalog;
	}

	public static ItemMasterCatalog fillItemMasterDetails(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog) throws ActionBotException
	{
		if (itemMasterCatalog.getItemMasterName() != null)
		{
			itemMasterCatalog.setItemMasterName(PageCreateItemMaster.fillItemMasterName(driver, testCaseName, itemMasterCatalog.getItemMasterName()));
		}
		if (itemMasterCatalog.isItemMasterType_inventory())
		{
			PageCreateItemMaster.clickOnInventoryType(driver, testCaseName);
		}
		else if (itemMasterCatalog.isItemMasterType_nonInventory())
		{
			PageCreateItemMaster.clickOnNonInventoryType(driver, testCaseName);
		}

		itemMasterCatalog.setWarehouseFieldPresent(PageCreateItemMaster.isWarehouseFieldPresent(driver, testCaseName));

		ActionBot.defaultLowSleep();
		if (itemMasterCatalog.getWarehouse() != null)
		{
			itemMasterCatalog.setWarehouse(PageCreateItemMaster.fillWarehouseName(driver, testCaseName, itemMasterCatalog.getWarehouse()));
		}

		if (itemMasterCatalog.getDescription() != null)
		{
			itemMasterCatalog.setDescription(PageCreateItemMaster.fillItemMasterDescription(driver, testCaseName, itemMasterCatalog.getDescription()));
		}
		return itemMasterCatalog;
	}

	public static ItemMasterCatalog addItemToItemMaster(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog) throws Exception
	{
		List<ItemMasterItem> listOfItemMasterItems = new ArrayList<ItemMasterItem>();
		listOfItemMasterItems = itemMasterCatalog.getItemMasterItems();
		List<ItemMasterItem> listOfAddedItemMasterItems = new ArrayList<ItemMasterItem>();
		// listOfAddedItemMasterItems = itemMasterCatalog.getItemMasterItems();
		for (ItemMasterItem itemMasterItem : listOfItemMasterItems)
		{
			PageCreateItemMaster.clickOnAddItemMasterLink(driver, testCaseName);

			listOfAddedItemMasterItems.add(fillItemDetailsForm(driver, testCaseName, itemMasterItem));

			/*
			 * if (itemMasterCatalog.getNextActionAddItem().equalsIgnoreCase(
			 * IConstantsData.ADD_ITEM_TO_CATALOG)) {
			 * ModalAddItemDetails.clickOnAddItemButton(driver, testCaseName); }
			 * else if
			 * (itemMasterCatalog.getNextActionAddItem().equalsIgnoreCase(
			 * IConstantsData.ADD_ITEM_TO_CATALOG_AND_CONTINUE)) {
			 * ModalAddItemDetails.clickOnAddAndContinueButton(driver,
			 * testCaseName); } else if
			 * (itemMasterCatalog.getNextActionAddItem().equalsIgnoreCase(
			 * IConstantsData.CANCEL_ADD_ITEM_TO_CATALOG)) {
			 * ModalAddItemDetails.clickOnCloseAddItemButton(driver,
			 * testCaseName); } else { logger.info("Invalid Next Option"); }
			 */
			// break;
		}
		itemMasterCatalog.setItemMasterItems(listOfAddedItemMasterItems);
		return itemMasterCatalog;
	}

	public static ItemMasterItem fillItemDetailsForm(WebDriver driver, String testCaseName, ItemMasterItem itemMasterItem) throws Exception
	{

		// short Description
		if (itemMasterItem.getName() != null)
		{
			itemMasterItem.setName(ModalAddItemDetails.fillShortDescription(driver, testCaseName, itemMasterItem.getName()));
		}

		// category name
		if (itemMasterItem.getCategoryName() != null)
		{
			itemMasterItem.setCategoryName(ModalAddItemDetails.fillProductCategory(driver, testCaseName, itemMasterItem.getCategoryName()));
		}

		// ERP ID
		if (itemMasterItem.getSourceRefNo() != null)
		{
			itemMasterItem.setSourceRefNo(ModalAddItemDetails.fillERPPartId(driver, testCaseName, itemMasterItem.getSourceRefNo()));
		}

		// market price
		if (itemMasterItem.getMarketPrice() != null)
		{
			itemMasterItem.setMarketPrice(ModalAddItemDetails.fillMarketPrice(driver, testCaseName, itemMasterItem.getMarketPrice()));
		}

		// to add supplier
		if (itemMasterItem.isSupplierRequired())
		{
			ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 1);

			ActionBot.defaultSleep();

			// supplier Name
			if (itemMasterItem.getSupplierName() != null)
			{
				itemMasterItem.setSupplierName(ModalAddItemDetails.fillSupplierName(driver, testCaseName, itemMasterItem.getSupplierName()));
			}

			// supplier ID
			itemMasterItem.setSupplierId(Integer.parseInt(Helper.getRandomNumber(6)));
			if (itemMasterItem.getSupplierPartId() != null)
			{
				itemMasterItem.setSupplierPartId(ModalAddItemDetails.fillSupplierPartId(driver, testCaseName, itemMasterItem.getSupplierPartId()));
			}

			// price
			if (itemMasterItem.getPrice() != null)
			{
				itemMasterItem.setPrice(ModalAddItemDetails.fillPrice(driver, testCaseName, itemMasterItem.getPrice()));
			}

			// currency
			if (itemMasterItem.getCurrency() != null)
			{
				itemMasterItem.setCurrency(ModalAddItemDetails.fillItemCurrency(driver, testCaseName, itemMasterItem.getCurrency()));
			}
			PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
			if (ModalSelectCompaniesAndBU.isSelectAllBUsLinkPresent(driver, testCaseName))
			{
				ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
			}
			else
			{
				ModalSelectCompaniesAndBU.clickOnSelectOUInBUTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnFirstBUCheckbox(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			}
			ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
			if (ModalSelectCompaniesAndBU.isSelectAllLocationsLinkPresent(driver, testCaseName))
			{
				ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
			}
			else
			{
				ModalSelectCompaniesAndBU.clickOnselectOUInLocationsTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnIstCompanyCheckBox(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			}
			ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
			// to add supplier
			ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 2);
			ActionBot.defaultSleep();
			if (itemMasterItem.isAddSecondSupplier())
			{
				itemMasterItem.setSupplierName(ModalAddItemDetails.fillSupplierName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME_2)));
				itemMasterItem.setSupplierId(Integer.parseInt(Helper.getRandomNumber(6)));
				itemMasterItem.setSupplierPartId(ModalAddItemDetails.fillSupplierPartId(driver, testCaseName, itemMasterItem.getSupplierPartId()));
				itemMasterItem.setPrice(ModalAddItemDetails.fillPrice(driver, testCaseName, itemMasterItem.getPrice()));
				itemMasterItem.setCurrency(ModalAddItemDetails.fillItemCurrency(driver, testCaseName, itemMasterItem.getCurrency()));
				PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
				ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 2);
				ActionBot.defaultSleep();
			}
		}
		else

		{
			// to click on add button for Stock items
			ModalAddItemDetails.clickOnAddItemButton(driver, testCaseName);
		}

		return itemMasterItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search item master item at Scope and
	 * Validity page and item details page <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param searchBy
	 *        </font><b><br>
	 * @param searchText
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static ItemMasterItem searchItemMasterItem(WebDriver driver, String testCaseName, String searchBy, String searchText) throws ActionBotException
	{
		ItemMasterItem itemMasterItem = new ItemMasterItem();

		// search data
		PageCreateItemMaster.selectSearchItemIn(driver, testCaseName, searchBy);
		PageCreateItemMaster.fillSearchText(driver, testCaseName, searchText);
		PageCreateItemMaster.clickOnSearchGoButton(driver, testCaseName);

		// get searched data
		itemMasterItem.setSourceRefNo(PageCreateItemMaster.getERPPartId(driver, testCaseName));
		itemMasterItem.setManufacturerPartId(PageCreateItemMaster.getManufacturerartId(driver, testCaseName));
		itemMasterItem.setName(PageCreateItemMaster.getItemName(driver, testCaseName));
		itemMasterItem.setCategoryName(PageCreateItemMaster.getCategory(driver, testCaseName));
		itemMasterItem.setSupplierName(PageCreateItemMaster.getSupplier(driver, testCaseName));
		itemMasterItem.setCurrency(PageCreateItemMaster.getCurrency(driver, testCaseName));
		itemMasterItem.setPrice(Double.parseDouble(PageCreateItemMaster.getUnitPrice(driver, testCaseName)));

		return itemMasterItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> fill Scope And Validity <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param itemMasterCatalog
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void fillScopeAndValidity(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog) throws ActionBotException
	{
		// for carlson tenant
		// if (PageCreateCatalog.isSelectCatalogScopeLinkPresent(driver,
		// testCaseName))
		// {
		// PageCreateCatalog.clickOnSelectCatalogScopeLink(driver,
		// testCaseName);
		// if (itemMasterCatalog.getRegion() != null)
		// {
		// ModalSelectCompaniesAndBU.selectRegion(driver, testCaseName,
		// itemMasterCatalog.getRegion());
		// }
		// if (itemMasterCatalog.getCompany() != null)
		// {
		// // ModalSelectCompaniesAndBU.clickOnCompaniesTab(driver,
		// // testCaseName);
		// if
		// (itemMasterCatalog.getCompany().equalsIgnoreCase(IConstantsData.ALL))
		// {
		// // ModalSelectCompaniesAndBU.clickOnSelectOULink(driver,
		// // testCaseName);
		// ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver,
		// testCaseName);
		// // ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver,
		// // testCaseName);
		// }
		// }
		// if (itemMasterCatalog.getBusinessUnit() != null)
		// {
		// ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver,
		// testCaseName);
		// if
		// (itemMasterCatalog.getBusinessUnit().equalsIgnoreCase(IConstantsData.ALL))
		// {
		// ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver,
		// testCaseName);
		// }
		// }
		// if (itemMasterCatalog.getLocation() != null)
		// {
		// ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
		// if
		// (itemMasterCatalog.getLocation().equalsIgnoreCase(IConstantsData.ALL))
		// {
		// ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver,
		// testCaseName);
		// }
		// }
		// ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver,
		// testCaseName);
		// }
		// else
		// // for non carlson tenant
		// {
		// select OU
		/*
		 * if (itemMasterCatalog.getOrganizationUnit() != null) {
		 * PageCreateCatalog.clickOnSelectOrganizationUnitLink(driver,
		 * testCaseName); if (itemMasterCatalog.getOrganizationUnit() !=
		 * IConstantsData.ALL) {
		 * itemMasterCatalog.setOrganizationUnit(ModalSelectCompaniesAndBU.
		 * selectOU(driver, testCaseName,
		 * itemMasterCatalog.getOrganizationUnit())); } else {
		 * itemMasterCatalog.setOrganizationUnit(IConstantsData.ALL);
		 * ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName,
		 * itemMasterCatalog.getRegionName()); }
		 * ModalSelectCompaniesAndBU.clickOnSaveButton(driver, testCaseName); }
		 */

		if (PageCreateCatalog.isSelectCatalogScopeLinkPresent(driver, testCaseName))
			PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
		if (itemMasterCatalog.getRegion() != null)
			ModalSelectCompaniesAndBU.selectRegion(driver, testCaseName, itemMasterCatalog.getRegion());
		if (itemMasterCatalog.getCompany() != null)
		{
			if (itemMasterCatalog.getCompany().equalsIgnoreCase(IConstantsData.ALL))
				ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
			else if (itemMasterCatalog.getCompany().equalsIgnoreCase(IConstantsData.First_Company))
			{
				ModalSelectCompaniesAndBU.clickOnIstCompanyCheckBox(driver, testCaseName);
			}
		}
		if (itemMasterCatalog.getBusinessUnit() != null)
		{
			ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
			if (itemMasterCatalog.getBusinessUnit().equalsIgnoreCase(IConstantsData.ALL))
				ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
			else if (itemMasterCatalog.getBusinessUnit().equalsIgnoreCase(IConstantsData.First_BU))
			{
				ModalSelectCompaniesAndBU.clickOnSelectOUInBUTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnFirstBUCheckbox(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			}
		}
		if (itemMasterCatalog.getLocation() != null)
		{
			ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
			if (itemMasterCatalog.getLocation().equalsIgnoreCase(IConstantsData.ALL))
				ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
			else if (itemMasterCatalog.getLocation().equalsIgnoreCase(IConstantsData.First_Location))
			{
				ModalSelectCompaniesAndBU.clickOnselectOUInLocationsTab(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnIstCompanyCheckBox(driver, testCaseName);
				ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			}
		}
		ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
	}

	// }

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Map columns of Item master file upload
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void mapColumnsOfItemMasterUploadFile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// product category : mandatory
		/*
		 * ModalStandardItemMasterColumn.dragAndDropProductCategory(driver,
		 * testCaseName);
		 * 
		 * ModalStandardItemMasterColumn.dragAndDropDeliveryLeadTime(driver,
		 * testCaseName);
		 * ModalStandardItemMasterColumn.dragAndDropIsGreen(driver,
		 * testCaseName);
		 * ModalStandardItemMasterColumn.dragAndDropIsPreferred(driver,
		 * testCaseName);
		 * ModalStandardItemMasterColumn.dragAndDropSpecifications(driver,
		 * testCaseName);
		 * ModalStandardItemMasterColumn.dragAndDropSpecificationsName(driver,
		 * testCaseName);
		 */
		ModalStandardItemMasterColumn.clickOnOkButton(driver, testCaseName);
	}

	public static ItemMasterCatalog addSupplierToItemOfItemMasterOnUpdation(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog, String action)
		throws Exception
	{
		ItemMasterItem itemMasterItem = ObjectCreation.getDefaultItemMasterItemObjectForItemMasterCreation();
		List<ItemMasterItem> itemMasterItems;
		// no of items added in item master
		itemMasterItems = itemMasterCatalog.getItemMasterItems();

		// iterate on all the items to add supplier
		for (ItemMasterItem item : itemMasterItems)
		{

			// search item via item name
			FlowCreateItemMaster.searchItemMasterItem(driver, testCaseName, IConstantsData.ITEM_NAME, item.getName());

			// click on checkbox
			ModalAddItemDetails.clickItemCheckBoxItemMaster(driver, testCaseName, 1);

			// click on actions link
			ModalAddItemDetails.clickOnActionsLinkOfItemInItemMaster(driver, testCaseName, 1);

			// if edit
			if (action.equalsIgnoreCase(IConstantsData.EDIT_ITEM))
			{
				ModalAddItemDetails.clickOnEditItem(driver, testCaseName, 1);
				ModalAddItemDetails.clickButtonAddSupplierWhileUpdatingItem(driver, testCaseName);
				fillSupplierDetails(driver, testCaseName, itemMasterCatalog, itemMasterItem);
				ModalAddItemDetails.clickButtonAddSupplierWhileUpdatingItem(driver, testCaseName);

				if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.NEXT))
				{
					PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
					if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.SUBMIT))
					{
						PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
					}
					else if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
					{
						PageCreateItemMaster.clickOnDiscardItemMasterCatalogLink(driver, testCaseName);
						PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
						ActionBot.defaultSleep();
						ActionBot.waitForPageLoad(driver);
						ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.LABEL_SUCCESS_MESSAGE);
					}
					else if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
					{
						PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
					}
				}
				else if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
				{
					PageCreateItemMaster.clickOnDiscardItemMasterCatalogLink(driver, testCaseName);
				}
				else if (itemMasterCatalog.getNextActionItemDetails().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
				{
					PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
				}
				else if (itemMasterCatalog.getNextActionScopeAndValidity().equalsIgnoreCase(IConstantsData.NONE))
				{
					logger.info("No action selected");
				}

			}

			// if discard
			else if (action.equalsIgnoreCase(IConstantsData.DISCARD_ITEM))
			{
				ModalAddItemDetails.clickOnDiscardItem(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			// if none
			else if (action.equalsIgnoreCase(IConstantsData.NONE))
			{
				logger.info("No action selected");
			}
			else
			{
				logger.info("Invalid Action");
			}
		}
		return itemMasterCatalog;

	}

	public static ItemMasterCatalog updateItemMaster(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog, ItemMasterItem itemMasterItem) throws Exception

	{
		// click on item master tab
		MainPageHeaderLevelTab.clickOnItemMasterSubTab(driver, testCaseName);
		// search item master
		FlowItemMasterListing.searchItemMasterCatalog(driver, testCaseName, itemMasterCatalog.getItemMasterName());
		PageItemMasterCatalogListing.clickOnActionsLink(driver, testCaseName);
		ModalItemMasterListingActions.clickOnUpdateItemMasterLink(driver, testCaseName);
		PageCreateItemMaster.clickOnNextButton(driver, testCaseName);
		PageCreateItemMaster.clickOnAddItemMasterLink(driver, testCaseName);
		ModalAddItemDetails.fillShortDescription(driver, testCaseName, itemMasterItem.getDescription());
		ModalAddItemDetails.fillProductCategory(driver, testCaseName, itemMasterItem.getCategoryName());
		ModalAddItemDetails.fillERPPartId(driver, testCaseName, itemMasterItem.getSourceRefNo());
		ModalAddItemDetails.fillMarketPrice(driver, testCaseName, itemMasterItem.getMarketPrice());
		ModalAddItemDetails.clickOnAddItemButton(driver, testCaseName);
		PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
		PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
		ActionBot.defaultSleep();
		return itemMasterCatalog;
	}

	public static ItemMasterItem fillSupplierDetails(WebDriver driver, String testCaseName, ItemMasterCatalog itemMasterCatalog, ItemMasterItem itemMasterItem) throws Exception
	{

		ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 1);

		ActionBot.defaultSleep();

		// supplier Name
		if (itemMasterItem.getSupplierName() != null)
		{
			itemMasterItem.setSupplierName(ModalAddItemDetails.fillSupplierName(driver, testCaseName, itemMasterItem.getSupplierName()));
		}

		// supplier ID
		itemMasterItem.setSupplierId(Integer.parseInt(Helper.getRandomNumber(6)));
		if (itemMasterItem.getSupplierPartId() != null)
		{
			itemMasterItem.setSupplierPartId(ModalAddItemDetails.fillSupplierPartId(driver, testCaseName, itemMasterItem.getSupplierPartId()));
		}

		// price
		if (itemMasterItem.getPrice() != null)
		{
			itemMasterItem.setPrice(ModalAddItemDetails.fillPrice(driver, testCaseName, itemMasterItem.getPrice()));
		}

		// currency
		if (itemMasterItem.getCurrency() != null)
		{
			itemMasterItem.setCurrency(ModalAddItemDetails.fillItemCurrency(driver, testCaseName, itemMasterItem.getCurrency()));
		}

		PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
		ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
		// to add supplier
		ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 1);
		ActionBot.defaultSleep();
		if (itemMasterItem.isAddSecondSupplier())
		{
			itemMasterItem.setSupplierName(ModalAddItemDetails.fillSupplierName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME_2)));
			itemMasterItem.setSupplierId(Integer.parseInt(Helper.getRandomNumber(6)));
			itemMasterItem.setSupplierPartId(ModalAddItemDetails.fillSupplierPartId(driver, testCaseName, itemMasterItem.getSupplierPartId()));
			itemMasterItem.setPrice(ModalAddItemDetails.fillPrice(driver, testCaseName, itemMasterItem.getPrice()));
			itemMasterItem.setCurrency(ModalAddItemDetails.fillItemCurrency(driver, testCaseName, itemMasterItem.getCurrency()));
			PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
			ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
			ModalAddItemDetails.clickButtonAddSupplier(driver, testCaseName, 1);
			ActionBot.defaultSleep();
		}

		return itemMasterItem;
	}

}
