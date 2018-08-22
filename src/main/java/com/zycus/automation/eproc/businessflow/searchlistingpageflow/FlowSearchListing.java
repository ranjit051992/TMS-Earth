/**
 * 
 */
package com.zycus.automation.eproc.businessflow.searchlistingpageflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.ItemMasterItem;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.Price;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.FlowFillGuidedItem;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.businessflow.shoppingcartflow.FlowShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.itemdetails.ModalItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.itemmasteritemdetails.ModalItemMasterItemDetails;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.IPageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.PageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.replaceItem.PageReplaceItem;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.ItemException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author puneet.sharma
 */
public class FlowSearchListing extends IFlowSearchListingUtil
{
	static Logger logger = Logger.getLogger(FlowSearchListing.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.businessflow.searchListingPage.
	 * IFlowSearchListing #addItem(com.zycus.automation.bo.CatelogItem,
	 * com.zycus.automation.bo.GuidedItem)
	 */

	public static Item addItem(WebDriver driver, String testCaseName, Item item) throws Exception
	{
		if (item.isEmptyCart())
		{
			FlowShoppingCart.emptyShoppingCart(driver, testCaseName);
		}
		List<CatelogItem> catelogItems = item.getCatelogItems();
		List<GuidedItem> guidedItems = item.getGuidedItems();
		List<ItemMasterItem> itemMasterItems = item.getItemMasterItems();

		Item addedItems = new Item();
		List<CatelogItem> addedCatelogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> addedGuidedItems = new ArrayList<GuidedItem>();
		List<ItemMasterItem> addedItemMasterItems = new ArrayList<>();
		if (catelogItems != null)
		{
			for (CatelogItem catelogItem : catelogItems)
			{

				catelogItem.setItemName(searchItem(driver, testCaseName, catelogItem.getItemName()));
				String itemId = PageSearchListing.getItemId(driver, testCaseName, catelogItem.getItemName());

				catelogItem.setItemID(itemId);
				// catelogItem.setItemName(PageSearchListing.getItem(driver,
				// testCaseName, itemId));
				// catelogItem.setDescription(PageSearchListing.getItemDescription(driver,
				// testCaseName, itemId));
				catelogItem.setDelieveryDays(PageSearchListing.getItemDeliveryDays(driver, testCaseName, itemId));
				Price itemPrice = PageSearchListing.getItemPrice(driver, testCaseName, itemId);
				Price unitPrice = PageSearchListing.getItemUnitPrice(driver, testCaseName, itemId);

				catelogItem.setUserCurrency(itemPrice.getPriceType());
				catelogItem.setItemPriceInUserCurrency(itemPrice.getPriceValue());
				catelogItem.setUnitCurrency(unitPrice.getPriceType());
				catelogItem.setUnitPrice(unitPrice.getPriceValue());
				catelogItem.setUnit_Price(unitPrice.getPrice());

				// catelogItem.setCategory(category);
				catelogItem.setSupplier(PageSearchListing.getItemSupplier(driver, testCaseName, itemId));
				catelogItem.setQuantity(PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, catelogItem.getQuantity()));

				PageSearchListing.addToCart(driver, testCaseName, itemId);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				ActionBot.waitTillPopUpIsPresent(driver, IPageSearchListing.ITEM_ADDED_TO_CART_SUCCESS_MESSAGE);
				addedCatelogItems.add(catelogItem);

			}
		}
		if (guidedItems != null)
		{
			searchItem(driver, testCaseName, guidedItems.get(0).getItemName());
			FlowFillGuidedItem.addGuidedItem(driver, testCaseName);
			for (GuidedItem guidedItem : guidedItems)
			{
				guidedItem = FlowFillGuidedItem.fillGuidedItemNAddToCart(driver, testCaseName, guidedItem);
				addedGuidedItems.add(guidedItem);
			}
		}
		if (itemMasterItems != null)
		{
			for (ItemMasterItem itemMasterItem : itemMasterItems)
			{

				itemMasterItem.setName(searchItem(driver, testCaseName, itemMasterItem.getName()));
				String itemId = PageSearchListing.getItemId(driver, testCaseName, itemMasterItem.getName());

				itemMasterItem.setItemId(itemId);

				PageSearchListing.getItemPrice(driver, testCaseName, itemId);
				Price unitPrice = PageSearchListing.getItemUnitPrice(driver, testCaseName, itemId);

				itemMasterItem.setPrice(unitPrice.getPriceValue());
				itemMasterItem.setCurrency(unitPrice.getPriceType());

				itemMasterItem.setSupplierName(PageSearchListing.getItemSupplier(driver, testCaseName, itemId));
				itemMasterItem.setQuantity(PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, itemMasterItem.getQuantity()));

				PageSearchListing.addToCart(driver, testCaseName, itemId);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

				// for non inventory items
				if (ModalItemMasterItemDetails.isAddToCartButtonPresent(driver, testCaseName))
				{
					// sourcing status
					if (itemMasterItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Quoted_by_supplier))
					{
						ModalItemMasterItemDetails.clickOnQuotedBySupplier(driver, testCaseName);
					}
					else
					{
						ModalItemMasterItemDetails.clickOnNeedAQuote(driver, testCaseName);
					}

					// quantity
					ModalItemMasterItemDetails.fillQuantity(driver, testCaseName, Float.parseFloat(Integer.toString(itemMasterItem.getQuantity())));

					// add to cart
					ModalItemMasterItemDetails.clickOnAddToCartButton(driver, testCaseName);

				}
				ActionBot.waitTillPopUpIsPresent(driver, IPageSearchListing.ITEM_ADDED_TO_CART_SUCCESS_MESSAGE);
				addedItemMasterItems.add(itemMasterItem);
			}
		}

		addedItems.setCatelogItems(addedCatelogItems);
		addedItems.setGuidedItems(addedGuidedItems);
		addedItems.setItemMasterItems(addedItemMasterItems);
		return addedItems;
	}

	public static String searchItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		return IFlowSearchListingUtil.searchItem(driver, testCaseName, itemName);
	}

	public static CatelogItem addItemToFavorite(WebDriver driver, String testCaseName, CatelogItem catelogItem) throws ActionBotException, ItemException
	{
		searchItem(driver, testCaseName, catelogItem.getItemName());
		catelogItem.setItemID(PageSearchListing.getItemId(driver, testCaseName, catelogItem.getItemName()));
		PageSearchListing.clickOnAddItemsToFavorite(driver, testCaseName, catelogItem.getItemID());
		catelogItem.setFavorite(true);
		return catelogItem;
	}

	public static void applyItemDescriptionFilter(WebDriver driver, String testCaseName, String itemDesc) throws ActionBotException
	{
		PageSearchListing.applyItemDescFilter(driver, testCaseName, itemDesc);
	}

	public static void applyItemPriceFilter(WebDriver driver, String testCaseName, String minPrice, String maxPrice) throws ActionBotException
	{
		if (minPrice != null)
		{
			PageSearchListing.applyMinItemPriceFilter(driver, testCaseName, minPrice);
		}
		if (maxPrice != null)
		{
			PageSearchListing.applyMaxItemPriceFilter(driver, testCaseName, maxPrice);
		}

	}

	public static boolean checkItemPriceFiler(WebDriver driver, String testCaseName, String minPrice, String maxPrice) throws ActionBotException
	{
		List<WebElement> itemPriceList = PageSearchListing.getItemPrice(driver, testCaseName);
		String itemPrice = null, log = "";
		int price;

		for (int i = 0; i < itemPriceList.size() - 1; i++)
		{
			itemPrice = itemPriceList.get(i).getText().trim();
			price = Integer.parseInt(CommonUtilities.getDecimalPrice(itemPrice.substring(4)).trim());
			// price = Integer.parseInt(itemPrice.substring(4,
			// itemPrice.indexOf(".")).replaceAll(",", ""));
			log += price + "\n";
			if (minPrice != null)
			{
				if (price < Integer.parseInt(minPrice))
				{
					return false;
				}
			}
			if (maxPrice != null)
			{
				if (price > Integer.parseInt(maxPrice))
				{
					return false;
				}
			}

		}
		logger.info("List of item price after applying filter : \n" + log);
		return true;
	}

	public static String applyManufacturersFilter(WebDriver driver, String testCaseName, String manufacturersName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before applying manufacturers filter");
		List<WebElement> manufacturersList = PageSearchListing.getItemManufacturersCheckBoxList(driver, testCaseName);
		String manufacturerName = null;
		for (WebElement element : manufacturersList)
		{
			if (manufacturersName != null)
			{
				if (element.getAttribute("title").equalsIgnoreCase(manufacturersName))
				{
					element.click();
					manufacturerName = element.getAttribute("title").trim();
					break;
				}
			}
			else
			{
				if (element.getAttribute("title").equalsIgnoreCase(IConstantsData.NONE))
				{
					element.click();
					manufacturerName = element.getAttribute("title").trim();
					break;
				}
			}
		}
		logger.info("Applying Manufacturers Filter with " + manufacturerName);
		PageSearchListing.waitTillSearchListLoaded(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After applying manufacturers filter");
		return manufacturerName;
	}

	public static String applySuppliersFilter(WebDriver driver, String testCaseName, String suppliersName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before applying supplier filter");
		PageSearchListing.clickOnExpandSupplierFilterButton(driver, testCaseName);
		List<WebElement> suppliersList = PageSearchListing.getItemSuppliersCheckBoxList(driver, testCaseName);
		String supplierName = null;
		for (WebElement element : suppliersList)
		{
			if (suppliersName != null)
			{
				if (element.getAttribute("data-supplier-id").equalsIgnoreCase(suppliersName))
				{
					element.click();
					supplierName = element.getAttribute("data-supplier-id").trim();
					break;
				}
			}
			else
			{
				element.click();
				supplierName = element.getAttribute("data-supplier-id").trim();
				break;
			}
		}
		logger.info("Applying Suppliers Filter with " + supplierName);
		PageSearchListing.waitTillSearchListLoaded(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After applying Supplier filter");
		return supplierName;
	}

	public static boolean checkManufacturersFilter(WebDriver driver, String testCaseName, String manufacturersName) throws ActionBotException, Exception
	{
		List<WebElement> itemNames = PageSearchListing.getItemName(driver, testCaseName);
		String log = "", itemName;
		for (int i = 0; i < itemNames.size() - 1; i++)
		{
			try
			{
				itemName = itemNames.get(i).getText().trim();
			}
			catch (StaleElementReferenceException e)
			{
				logger.error("StaleElementReferenceException occurred ... Locating element again..");
				itemNames = PageSearchListing.getItemName(driver, testCaseName);
				itemName = itemNames.get(i).getText().trim();
			}
			String itemId = PageSearchListing.getItemId(driver, testCaseName, itemName);
			PageSearchListing.clickOnItemName(driver, testCaseName, itemId);
			String manufacturerName = ModalItemDetails.getItemManufacturer(driver, testCaseName, itemId);
			ModalItemDetails.clickOnCloseItemDetailsMdoal(driver, testCaseName, itemId);
			log += manufacturerName + "\n";
			if (manufacturerName.equalsIgnoreCase("-"))
			{
				manufacturerName = "none";
			}
			if (!manufacturerName.equalsIgnoreCase(manufacturersName))
			{
				return false;
			}
		}
		logger.info("Filtered Manufacturers : \n" + log);
		return true;
	}

	public static boolean checkSuppliersFilter(WebDriver driver, String testCaseName, String suppliersName) throws ActionBotException
	{
		String filteredSupplierName, log = "";
		List<WebElement> supplierNames = PageSearchListing.getItemSuppliers(driver, testCaseName);
		for (int i = 0; i < supplierNames.size() - 1; i++)
		{
			filteredSupplierName = supplierNames.get(i).getText().trim();
			log += filteredSupplierName + "\n";
			if (!filteredSupplierName.equalsIgnoreCase(suppliersName))
			{
				return false;
			}
		}
		logger.info("Filtered supplier : " + log);
		return true;
	}

	public static List<String> compareCatalogItems(WebDriver driver, String testCaseName, List<String> itemsToBeCompare) throws ActionBotException
	{
		// select the item with the corresponding item name
		List<WebElement> itemNameList = PageSearchListing.getItemName(driver, testCaseName);
		String itemId = null, itemNameOnItemDetails;

		List<String> dataItemIds = new ArrayList<String>();
		for (String itemName : itemsToBeCompare)
		{
			for (WebElement element : itemNameList)
			{
				itemNameOnItemDetails = element.getText().trim();
				if (itemNameOnItemDetails.contains("..."))
				{
					itemNameOnItemDetails = element.getAttribute("title").trim();
				}
				/*
				 * //view item details FlowSearchListing.viewItemDetails(driver,
				 * testCaseName, itemId); itemNameOnItemDetails =
				 * ModalItemDetails.getItemTitle(driver, testCaseName, itemId);
				 * //close item details modal
				 * ModalItemDetails.clickOnCloseItemDetailsMdoal(driver,
				 * testCaseName, itemId);
				 */

				if (itemName.equalsIgnoreCase(itemNameOnItemDetails))
				{
					// get parent row in which this element resides
					element = element.findElement(IPageSearchListing.ANCSESTOR_TR.getBy());
					itemId = element.getAttribute("id").substring(14);
					// store data-itemid for assertion
					dataItemIds.add(itemId);

					// click checkbox
					ActionBot.click(driver, element, IPageSearchListing.INPUT);

					break;
				}
			}
		}
		// compare the items
		PageSearchListing.clickOnCompareMultipleItems(driver, testCaseName);
		return dataItemIds;
	}

	public static String viewItemDetails(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		List<WebElement> itemNameList = PageSearchListing.getItemName(driver, testCaseName);
		String itemId = null, itemNameOnItemDetails;

		for (WebElement element : itemNameList)
		{
			itemNameOnItemDetails = element.getText().trim();
			if (itemNameOnItemDetails.contains("..."))
			{
				itemNameOnItemDetails = element.getAttribute("title").trim();
			}
			if (itemNameOnItemDetails.equalsIgnoreCase(itemName))
			{
				// get parent row in which this element resides
				element = element.findElement(IPageSearchListing.ANCSESTOR_TR.getBy());
				itemId = element.getAttribute("id").substring(14);
			}
		}

		PageSearchListing.clickOnItemName(driver, testCaseName, itemId);
		return itemId;
	}

	public static CatelogItem getItemDetails(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		CatelogItem catelogItem = new CatelogItem();

		// item details
		catelogItem.setItemName(ModalItemDetails.getItemTitle(driver, testCaseName, itemId));
		catelogItem.setDescription(ModalItemDetails.getItemDesc(driver, testCaseName, itemId));
		catelogItem.setManufacturerName(ModalItemDetails.getItemManufacturer(driver, testCaseName, itemId));
		catelogItem.setCategory(ModalItemDetails.getItemCategory(driver, testCaseName, itemId));
		catelogItem.setSupplierPartID(ModalItemDetails.getItemSpscCode(driver, testCaseName, itemId));
		catelogItem.setSupplier(ModalItemDetails.getItemSupplierName(driver, testCaseName, itemId));
		catelogItem.setSupplierContact(ModalItemDetails.getItemSupplierContact(driver, testCaseName, itemId));
		catelogItem.setAvailability(ModalItemDetails.getItemDeliveryLeadTime(driver, testCaseName, itemId));
		catelogItem.setContractNo(ModalItemDetails.getItemContractNo(driver, testCaseName, itemId));

		// specification
		ModalItemDetails.clickOnSpecificationTab(driver, testCaseName, itemId);
		Map<String, String> spec_key_value_map = new HashMap<String, String>();
		int size = ModalItemDetails.getSizeOfSpecifications(driver, testCaseName);
		for (int i = 1; i <= size; i++)
		{
			spec_key_value_map.put(ModalItemDetails.getItemSpecificationKey(driver, testCaseName, i), ModalItemDetails.getItemSpecificationValue(driver, testCaseName, i));
		}

		catelogItem.setSpeckey_valueMap(spec_key_value_map);

		// attachment
		ModalItemDetails.clickOnAttachmentTab(driver, testCaseName, itemId);
		catelogItem.setAttachments(ModalItemDetails.getAttachmentsNames(driver, testCaseName));

		return catelogItem;
	}

	public static boolean verifyItemDetails(CatelogItem itemDetails, CatelogItem catelogItemDetailsFromPropertyFile) throws ActionBotException
	{
		boolean flag = true;
		String error = "";

		// item name
		if (!itemDetails.getItemName().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getItemName()))
		{
			error += "\n Item name on item details pop up was wrong";
			flag = false;
		}

		// description
		if (catelogItemDetailsFromPropertyFile.getDescription() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getDescription().equals("-"))
			{
				if (!itemDetails.getDescription().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Description on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				if (!itemDetails.getDescription().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getDescription()))
				{
					error += "\n Description on item details pop up was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!itemDetails.getDescription().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Description on item details pop up was wrong";
				flag = false;
			}
		}

		// manufacturer name
		if (catelogItemDetailsFromPropertyFile.getManufacturerName() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getManufacturerName().equals("-"))
			{
				if (!itemDetails.getManufacturerName().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Manufacturer Name on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				if (!itemDetails.getManufacturerName().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getManufacturerName()))
				{
					error += "\n Manufacturer Name on item details pop up was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!itemDetails.getManufacturerName().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Manufacturer Name on item details pop up was wrong";
				flag = false;
			}
		}

		// category
		if (catelogItemDetailsFromPropertyFile.getCategory() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getCategory().equals("-"))
			{
				if (!itemDetails.getCategory().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Category on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				if (!itemDetails.getCategory().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getCategory()))
				{
					error += "\n Category on item details pop up was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!itemDetails.getCategory().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Category on item details pop up was wrong";
				flag = false;
			}
		}

		// supplier name
		if (!itemDetails.getSupplier().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSupplier()))
		{
			error += "\n Supplier Name on item details pop up was wrong";
			flag = false;
		}

		// supplier contact
		if (catelogItemDetailsFromPropertyFile.getSupplierContact() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getSupplierContact().equals("-"))
			{
				if (!itemDetails.getSupplierContact().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Supplier Contact on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				if (!itemDetails.getSupplierContact().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSupplierContact()))
				{
					error += "\n Supplier Contact on item details pop up was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!itemDetails.getSupplierContact().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Supplier Contact on item details pop up was wrong";
				flag = false;
			}
		}

		// availability
		if (!itemDetails.getAvailability().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getAvailability()))
		{
			error += "\n Availability on item details pop up was wrong";
			flag = false;
		}

		// contract no
		if (catelogItemDetailsFromPropertyFile.getContractNo() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getContractNo().equals("-"))
			{
				if (!itemDetails.getContractNo().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Contract No on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				if (!itemDetails.getContractNo().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getContractNo()))
				{
					error += "\n Contract No on item details pop up was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!itemDetails.getContractNo().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Contract No on item details pop up was wrong";
				flag = false;
			}
		}

		// specification
		if (catelogItemDetailsFromPropertyFile.getSpeckey_valueMap() != null)
		{
			for (Map.Entry<String, String> specKeyValueFromPropertyFile : catelogItemDetailsFromPropertyFile.getSpeckey_valueMap().entrySet())
			{
				String key = specKeyValueFromPropertyFile.getKey();
				if (!itemDetails.getSpeckey_valueMap().get(key).equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSpeckey_valueMap().get(key)))
				{
					error += "\n Specification " + key + " on item details pop up was wrong";
					flag = false;
				}
			}
		}

		// attachment
		if (catelogItemDetailsFromPropertyFile.getAttachments() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getAttachments().equals("-"))
			{
				if (!itemDetails.getAttachments().get(0).equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Attachment on item details pop up was wrong";
					flag = false;
				}
			}
			else
			{
				for (String attachmentOnCompareScreen : itemDetails.getAttachments())
				{
					for (String attachmentOnPropertyFile : catelogItemDetailsFromPropertyFile.getAttachments())
					{
						if (attachmentOnCompareScreen.equalsIgnoreCase(attachmentOnPropertyFile))
						{
							flag = true;
							break;
						}
					}
					if (!flag)
					{
						error += "\n Attachment " + attachmentOnCompareScreen + " on item details pop up was wrong";
					}
				}
			}
		}
		else
		{
			if (!itemDetails.getAttachments().get(0).equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Attachment on item details pop up was wrong";
				flag = false;
			}
		}

		logger.info(error);
		return flag;

	}

	public static void selectItemAndAddToCartAndCheckout(WebDriver driver, String testCaseName, OnlineStore onlineStore) throws Exception
	{
		onlineStore.setAddItemTo(IConstantsData.ADD_TO_CART);
		selectItems_Cart_Basket_Favourite(driver, testCaseName, onlineStore);
		ActionBot.defaultLowSleep();
		PageSearchListing.clickOnCheckOutButton(driver, testCaseName);
	}

	public static String[] selectChoiceNumberOfItems(WebDriver driver, String testCaseName, OnlineStore onlineStore) throws Exception
	{
		int quantity = onlineStore.getQuantity();
		String item_ids[] = new String[quantity];
		quantity--;
		for (int i = 0; i <= quantity; i++)
		{
			onlineStore = FlowOnlineStore.getItemId(driver, testCaseName, i, onlineStore);
			String item_id = onlineStore.getItemId();
			PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, item_id);
			item_ids[i] = item_id;
		}
		return item_ids;
	}

	public static String[] selectChoiceNumberOfItemsWithQuantity(WebDriver driver, String testCaseName, int quantity, OnlineStore onlineStore) throws Exception
	{
		String item_qty = CommonServices.getTestData(IConstantsData.Item_Quantity, 2);
		int itemQuantity = Integer.parseInt(item_qty);
		String item_ids[] = new String[quantity];
		quantity--;
		for (int i = 0; i <= quantity; i++)
		{
			onlineStore = FlowOnlineStore.getItemId(driver, testCaseName, i, onlineStore);
			String item_id = onlineStore.getItemId();
			PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, item_id);
			PageSearchListing.fillItemQuantity(driver, testCaseName, item_id, itemQuantity);
			item_ids[i] = item_id;
		}
		return item_ids;
	}

	public static boolean selectChoiceNumberOfItemsWithVeryHighQuantityAddToCart(WebDriver driver, String testCaseName, int quantity, OnlineStore onlineStore, int itemQuantity)
		throws Exception
	{
		String item_ids[] = new String[quantity];
		boolean status = false;
		quantity--;
		for (int i = 0; i <= quantity; i++)
		{
			onlineStore = FlowOnlineStore.getItemId(driver, testCaseName, i, onlineStore);
			String item_id = onlineStore.getItemId();
			PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, item_id);
			PageSearchListing.fillItemQuantity(driver, testCaseName, item_id, itemQuantity);
			PageSearchListing.clicktoAddItemToCartIndexwise(driver, testCaseName, i + 1);
			if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
			{
				status = true;
				ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
			}
			else
			{
				status = false;
			}
			item_ids[i] = item_id;
		}
		return status;
	}

	public static String[] selectItems_Cart_Basket_Favourite(WebDriver driver, String testCaseName, OnlineStore onlineStore) throws Exception
	{
		String item_ids[] = selectChoiceNumberOfItems(driver, testCaseName, onlineStore);
		// if the user wants to add items to cart
		if (onlineStore.getAddItemTo().equals(IConstantsData.ADD_TO_CART))
		{
			PageSearchListing.clickOnAddMultipleItemsToCart(driver, testCaseName);
		}
		// if the user wants to add items to basket
		else if (onlineStore.getAddItemTo().equals(IConstantsData.ADD_TO_BASKET))
		{
			PageSearchListing.clickOnAddMultipleItemsToBasket(driver, testCaseName);
		}
		// if the user wants to add items to favorites list
		else
		{
			PageSearchListing.clickOnAddMultipleItemsToFavorite(driver, testCaseName);
		}
		return item_ids;
	}

	public static boolean addToExistingBasketIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		PageSearchListing.selectFromExistingBasket(driver, testCaseName, index);
		PageSearchListing.clickOnAddToBasketbutton(driver, testCaseName);
		return true;
	}

	public static String selectItemAndAddToFav(WebDriver driver, String testCaseName, String searchText, OnlineStore onlineStore)
		throws ActionBotException, ItemException, TestCaseException, InterruptedException
	{
		ActionBot.waitForPageLoad(driver);
		String itemId = PageSearchListing.getItemId(driver, testCaseName, searchText);
		PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, 10);
		Thread.sleep(5000);
		PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, itemId);
		PageSearchListing.clickOnAddMultipleItemsToFavorite(driver, testCaseName);
		return itemId;
	}

	public static boolean verifySuccessfulAdditionOfItemToFavouriteList(WebDriver driver, String testCaseName, String item_ids[])
		throws ActionBotException, ItemException, TestCaseException, InterruptedException
	{
		ActionBot.waitForOperations(10000);
		MainPageHeaderLevelTab.clickOnMyFavoritesSubTab(driver);
		int count = 0;
		for (String item_id : item_ids)
		{
			if (PageMyFavorites.selectFavoriteItem(driver, testCaseName, item_id))
			{
				count++;
			}
		}
		if (count == item_ids.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean verifyPresenceOfAllImportantDeliveryRecipientDetails(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException
	{
		ActionBot.waitForPageLoad(driver);
		if (!PageRequisitionCheckOut.isEditable(driver, testCaseName))
			PageMyFavorites.clickToCheckOutFromCart(driver, testCaseName);

		CustomDate customDate = CommonUtilities.getRequiredBy();
		PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, customDate.getDay(), customDate.getMonth(), customDate.getYear());
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		String business_unit_name = PageRequisitionCheckOut.fetchFetchBusinessUnit(driver, testCaseName);

		PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		String cost_center = PageRequisitionCheckOut.fetchCostCenter(driver, testCaseName);
		PageRequisitionCheckOut.clickCloseRequisitionSummary(driver, testCaseName);
		try
		{
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageRequisitionCheckOut.clickOnDeliveryItemEdit(driver, testCaseName);
		//String delivery_name = PageRequisitionCheckOut.fetchDeliveryRecipientName(driver, testCaseName);
		//String delivery_address = PageRequisitionCheckOut.fetchDeliveryAddress(driver, testCaseName);
		String delivery_address = ActionBot.findElement(driver, By.xpath(".//*[@id='shipToAddress_summary']")).getText();
		String delivery_name = ActionBot.findElement(driver, By.xpath(".//*[@id='deliverTo_item_summary']")).getText();
		ActionBot.findElement(driver, By.xpath("//*[@id=\"cancelRequisitionItemSummary\"]")).click();
		//*[@id="cancelRequisitionItemSummary"]
		boolean status = false;
		//System.out.println("zsgdfadf::" + business_unit_name);
		//System.out.println("zdhfkjsdhg::" + delivery_address);
		//System.out.println("zdgfshdf::" + cost_center);
		//System.out.println("gdfjagfj::" + delivery_name);
		if (business_unit_name != null && delivery_address != null && delivery_name != null && cost_center != null)
		{
			status = true;
		}
		return status;
	}

	public static void updateFirstItemCartQuantity(WebDriver driver, String testCaseName) throws Exception
	{

	}

	public static void toSortSearchListingInAscending(WebDriver driver, String testCaseName) throws Exception
	{
		PageSearchListing.toHoverOverTheSortingOptions(driver, testCaseName);
		PageSearchListing.clicktoSortSearchListingChoiceWise(driver, testCaseName, IPageSearchListing.ASCENDING_ORDER_LEAD_TIME_SORT);
		ActionBot.defaultMediumSleep();
	}

	public static void toSortSearchListingInDescending(WebDriver driver, String testCaseName) throws Exception
	{
		PageSearchListing.toHoverOverTheSortingOptions(driver, testCaseName);
		PageSearchListing.clicktoSortSearchListingChoiceWise(driver, testCaseName, IPageSearchListing.DESCENDING_ORDER_LEAD_TIME_SORT);
		ActionBot.defaultMediumSleep();
	}

	public static String toFetchLeadDaysOfAnItemIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.defaultLowSleep();
		PageSearchListing.clickItemDescriptionIndexwise(driver, testCaseName, index);
		String leadDays = "";
		ActionBot.defaultLowSleep();
		if (PageSearchListing.isLeadTimeVisibleIndexwise(driver, testCaseName, index))
		{
			leadDays = PageSearchListing.getItemDeliveryLeadDaysIndexwise(driver, testCaseName, index);
			PageReplaceItem.clickCloseOnItemPopUpByXpath(driver, testCaseName, IPageSearchListing.CLOSE_ITEM_DESCRIPTION_GENERIC);
		}
		else
		{
			ActionBot.defaultMediumSleep();
			leadDays = PageSearchListing.getLeadTimeIndexwise(driver, testCaseName);
			PageReplaceItem.clickCloseOnItemPopUpByXpath(driver, testCaseName, IPageSearchListing.CLOSE_ITEM_DESCRIPTION_GENERIC);
			ActionBot.defaultLowSleep();
		}
		if (leadDays == null || leadDays.equalsIgnoreCase(IConstantsData.NA))
			leadDays = IConstantsData.NA;
		else
		{
			leadDays = leadDays.split(" ")[0];
			leadDays = leadDays.replaceAll(",", " ");
		}
		return leadDays;
	}

	public static boolean verifySortByLeadTime(WebDriver driver, String testCaseName) throws Exception
	{
		boolean status1 = false;
		boolean status2 = false;

		// to verify ascending order
		ActionBot.defaultLowSleep();
		toSortSearchListingInAscending(driver, testCaseName);
		ActionBot.defaultLowSleep();
		String previousLeadTime = toFetchLeadDaysOfAnItemIndexwise(driver, testCaseName, 1);
		int i = 2, count = 0;
		ActionBot.defaultLowSleep();
		if (PageSearchListing.isItemPresentInSearchListingPageIndexwise(driver, testCaseName, 1))
		{
			previousLeadTime = toFetchLeadDaysOfAnItemIndexwise(driver, testCaseName, 1);
		}
		else
		{
			status1 = true;
		}
		while (PageSearchListing.isItemPresentInSearchListingPageIndexwise(driver, testCaseName, i))
		{
			ActionBot.defaultLowSleep();
			String newLeadTime = toFetchLeadDaysOfAnItemIndexwise(driver, testCaseName, i);
			if (previousLeadTime.equals(IConstantsData.NA) || newLeadTime.equals(IConstantsData.NA))
			{
				if (previousLeadTime.equals(IConstantsData.NA))
					count++;
			}
			else
			{
				if (Integer.parseInt(previousLeadTime) <= Integer.parseInt(newLeadTime))
					count++;
			}
			previousLeadTime = newLeadTime;
			i++;
		}
		i = i - 2;
		if (count == i)
			status1 = true;

		// to verify descending order
		ActionBot.refreshPage(driver, testCaseName);
		ActionBot.defaultLowSleep();
		toSortSearchListingInDescending(driver, testCaseName);
		i = 2;
		count = 0;
		ActionBot.defaultLowSleep();
		if (PageSearchListing.isItemPresentInSearchListingPageIndexwise(driver, testCaseName, 1))
		{
			previousLeadTime = toFetchLeadDaysOfAnItemIndexwise(driver, testCaseName, 1);
		}
		else
		{
			status2 = true;
		}
		ActionBot.defaultLowSleep();
		while (PageSearchListing.isItemPresentInSearchListingPageIndexwise(driver, testCaseName, i))
		{
			ActionBot.defaultLowSleep();
			String newLeadTime = toFetchLeadDaysOfAnItemIndexwise(driver, testCaseName, i);
			if (previousLeadTime.equals(IConstantsData.NA) || newLeadTime.equals(IConstantsData.NA))
			{
				if (newLeadTime.equals(IConstantsData.NA))
					count++;
			}
			else
			{
				if (Integer.parseInt(previousLeadTime) >= Integer.parseInt(newLeadTime))
					count++;
			}
			previousLeadTime = newLeadTime;
			i++;
		}
		i = i - 2;
		if (count == i)
			status2 = true;

		return (status1 && status2);
	}
}
