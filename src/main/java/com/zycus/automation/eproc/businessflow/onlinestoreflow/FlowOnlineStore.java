package com.zycus.automation.eproc.businessflow.onlinestoreflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.PageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class FlowOnlineStore
{

	static Logger logger = Logger.getLogger(FlowOnlineStore.class);

	public static OnlineStore searchItem(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException, Exception
	{

		String searchItem = onlinestore.getSearchItem();
		PageOnlineStore.fillSearchText(driver, testCaseName, searchItem);
		PageOnlineStore.clickSearchButton(driver, testCaseName);
		/*
		 * List<WebElement> itemNames = PageSearchListing.getItemName(driver,
		 * testCaseName); String name = itemNames.get(index).getText(); String
		 * itemId = PageSearchListing.getItemId(driver, testCaseName, name);
		 * onlinestore.setItemId(itemId);
		 */
		return onlinestore;
	}

	public static OnlineStore getItemId(WebDriver driver, String testCaseName, int index, OnlineStore onlinestore) throws ActionBotException, Exception
	{

		List<WebElement> itemNames = PageSearchListing.getItemName(driver, testCaseName);
		String name = itemNames.get(index).getText();
		onlinestore.setitemName(name);
		String itemId = PageSearchListing.getItemId(driver, testCaseName, name);
		onlinestore.setItemId(itemId);
		return onlinestore;
	}

	public static OnlineStore fillItemQuantity(WebDriver driver, String testCaseName, String itemId, int quantity, OnlineStore onlinestore)
		throws ActionBotException, TestCaseException
	{

		PageSearchListing.fillItemQuantity(driver, testCaseName, itemId, quantity);

		return onlinestore;
	}

	public static OnlineStore clickAddToCart(WebDriver driver, String testCaseName, String itemId, OnlineStore onlinestore) throws ActionBotException, TestCaseException
	{

		PageSearchListing.addToCart(driver, testCaseName, itemId);

		return onlinestore;
	}

	public static OnlineStore clickOnViewCart(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException
	{

		PageOnlineStore.clickOnViewCart(driver, testCaseName);

		return onlinestore;
	}

	public static OnlineStore saveCartAsBasket(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException
	{

		ModalShoppingCart.saveCartAsShopppingBasket(driver, testCaseName);

		return onlinestore;
	}

	public static OnlineStore clickOnItemName(WebDriver driver, String testCaseName, String itemId, OnlineStore onlinestore) throws ActionBotException
	{

		PageSearchListing.clickOnItemName(driver, testCaseName, itemId);

		return onlinestore;
	}

	public static OnlineStore getItemTitleInPopup(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException, FactoryMethodException
	{

		String itemTitleInPopup = PageViewPurchaseOrder.getItemTitle(driver, testCaseName);

		onlinestore.setItemTitleInPopup(itemTitleInPopup);

		return onlinestore;
	}

	public static OnlineStore closeItemPopup(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws FactoryMethodException, ActionBotException
	{

		PageViewPurchaseOrder.closeItemPopup(driver, testCaseName);

		return onlinestore;

	}

	public static OnlineStore makeItemAsFavorite(WebDriver driver, String testCaseName, String itemId, OnlineStore onlinestore) throws ActionBotException
	{

		PageSearchListing.makeItemAsFavorite(driver, testCaseName, itemId);

		return onlinestore;

	}

	public static OnlineStore clickOnAddMultipleItemsToFavorite(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException
	{

		PageSearchListing.clickOnAddMultipleItemsToFavorite(driver, testCaseName);

		return onlinestore;
	}

	public static OnlineStore clickOnItemActions(WebDriver driver, String testCaseName, String itemId, OnlineStore onlinestore) throws ActionBotException
	{

		PageSearchListing.clickOnItemActions(driver, testCaseName, itemId);

		return onlinestore;
	}

	public static OnlineStore clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemId, OnlineStore onlinestore) throws ActionBotException
	{

		PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, itemId);

		return onlinestore;
	}

	public static OnlineStore addSingleItemAndCheckout(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws Exception
	{
		// Searching for item
		FlowOnlineStore.searchItem(driver, testCaseName, onlinestore);
		FlowOnlineStore.getItemId(driver, testCaseName, 0, onlinestore);

		// filling item quantity
		FlowOnlineStore.fillItemQuantity(driver, testCaseName, onlinestore.getItemId(), onlinestore.getQuantity(), onlinestore);

		// adding item to cart and clicking on Checkout button
		FlowOnlineStore.clickAddToCart(driver, testCaseName, onlinestore.getItemId(), onlinestore);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.waitTillPopUpIsPresent(driver, IPageSearchListing.ITEM_ADDED_TO_CART_SUCCESS_MESSAGE);

		PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

		return onlinestore;
	}

	public static void clearCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int total_items = Integer.parseInt(PageOnlineStore.getTotalItemsInCart(driver, testCaseName));
		if (total_items > 0)
		{
			PageOnlineStore.clickOnViewCart(driver, testCaseName);
			PageOnlineStore.clickOnEmptyCart(driver, testCaseName);
			PageOnlineStore.clickOnYesdeleteCartContinueShopping(driver, testCaseName);
			PageOnlineStore.clickOnNoCartContinueShopping(driver, testCaseName);
		}

	}

	public static void updateItemQuantityInCart(WebDriver driver, String testCaseName, int index) throws NumberFormatException, Exception
	{
		String item_qty = CommonServices.getTestData(IConstantsData.Item_Quantity, 2);
		int qty = Integer.parseInt(item_qty);
		PageOnlineStore.updateItemQtyInCart(driver, testCaseName, index, qty);
		PageOnlineStore.clickUpdateItemQtyInCart(driver, testCaseName, index);
	}

	public static boolean fillGuidedProcurement_AddToCart_Checkout(WebDriver driver, String testCaseName, CEform cEform) throws NumberFormatException, Exception
	{
		int qty = 0;
		boolean status = false, supplier_count = false;
		;
		float fl_price = 0f;
		PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
		String item_qty = CommonServices.getTestData(IConstantsData.Item_Quantity, 2);
		qty = Integer.parseInt(item_qty);
		fl_price = Float.parseFloat(item_qty);
		String des = Helper.getRandomString(4);
		PageFreeTextForm.fillShortDescription(driver, testCaseName, des);
		selectCategoryDescriptionForFreeTextItem(driver, testCaseName, cEform);
		// PageFreeTextForm.clickCloseCategoryDailogueButton(driver,
		// testCaseName);
		if (PageFreeTextForm.getShortDescription(driver, testCaseName).equals(des))
		{
			status = true;
		}
		PageFreeTextForm.fillQuantity(driver, testCaseName, qty);
		PageFreeTextForm.fillPrice(driver, testCaseName, fl_price);
		PageFreeTextForm.fillSourcingStatus(driver, testCaseName, 1);
		PageFreeTextForm.clickToAddFreeTextItemIndexwise(driver, testCaseName, 1);

		//ActionBot.findElement(driver, By.xpath(".//*[@id='editGuidedItemDOM']/div/div[2]/div/a")).click();
		ActionBot.findElement(driver, IPageFreeTextForm.CLOSE_ITEM_MODAL).click();
		//PageFreeTextForm.clickOnRecentlyOrderedFreeTextItems(driver, testCaseName);
		//PageFreeTextForm.clickCopyItem(driver, testCaseName);

		boolean status_isContractNoFieldPresent = selectExistingSupplierForFreeText(driver, testCaseName);
		supplier_count = PageFreeTextForm.countSupplier(driver, testCaseName) == 0 ? false : true;
		PageFreeTextForm.clickOnAddToCartButton(driver, testCaseName);
		PageFreeTextForm.clickToCheckout(driver, testCaseName);
		return status && status_isContractNoFieldPresent && supplier_count;
	}

	public static boolean veiwFreeTextItemCheckContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws NumberFormatException, Exception
	{
		boolean status = false;
		ActionBot.waitForPageLoad(driver);
		PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
		PageFreeTextForm.veiwRecentlyOrderedItemLink(driver, testCaseName);
		PageFreeTextForm.clickRecentlyOrderedItemsIndexwise(driver, testCaseName, 1);
		PageFreeTextForm.clickSupplierSubTab(driver, testCaseName);
		String recievedContractNumber = PageFreeTextForm.getContractNumberFromItemDetailPopup(driver, testCaseName);
		if (recievedContractNumber.equals(contractNumber))
			status = true;
		clickCloseOnItemPopUp(driver, testCaseName, "(.//button[@title='Close'])");
		return status;
	}

	public static boolean veiwFreeTextItemCheckItemCurrency(WebDriver driver, String testCaseName, String currency) throws NumberFormatException, Exception
	{
		boolean status = false;
		ActionBot.waitForPageLoad(driver);
		PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
		String freeTextCurrency = PageFreeTextForm.getItemCurrencyFromItemDetailPopup(driver, testCaseName, currency);
		if (freeTextCurrency.equals(currency))
			status = true;
		return status;
	}

	public static boolean checkSuccessfullCopyOfRecentlyOrderedFreeTextItem(WebDriver driver, String testCaseName) throws NumberFormatException, Exception
	{
		boolean status = false;
		ActionBot.waitForPageLoad(driver);
		PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
		PageFreeTextForm.veiwRecentlyOrderedItemLink(driver, testCaseName);
		PageFreeTextForm.clickRecentlyOrderedItemsIndexwise(driver, testCaseName, 2);
		String price = PageFreeTextForm.getItemPriceFromItemDetailPopup(driver, testCaseName);
		String quantity = PageFreeTextForm.getItemQuantityFromItemDetailPopup(driver, testCaseName);
		PageFreeTextForm.clickCopyItem(driver, testCaseName);
		logger.info("\nPageFreeTextForm.getPrice()______" + PageFreeTextForm.getPrice(driver, testCaseName) + "___");
		logger.info("\nprice______" + price + "___");
		if (PageFreeTextForm.getPrice(driver, testCaseName).equals(price.substring(0, price.length() - 1)))
		{
			if (Integer.parseInt(PageFreeTextForm.getQuantity(driver, testCaseName)) == Integer.parseInt((quantity)))
			{
				status = true;
			}
		}
		return status;
	}

	public static void clickCloseOnItemPopUp(WebDriver driver, String testCaseName, String genericXpath) throws Exception
	{
		int size = ActionBot.findElements(driver, By.xpath(genericXpath)).size();
		for (int index = 1; index <= size; index++)
		{
			try
			{
				ActionBot.waitForElementToBeDisplayed(driver, By.xpath(genericXpath + "[" + index + "]"), 3);
			}
			catch (Exception e)
			{
			}
			if (ActionBot.isElementDisplayed(driver, By.xpath(genericXpath + "[" + index + "]")))
			{
				ActionBot.click(driver, By.xpath(genericXpath + "[" + index + "]"));
				break;
			}
		}
	}

	public static boolean selectExistingSupplierForFreeText(WebDriver driver, String testCaseName) throws NumberFormatException, Exception
	{
		String supplierName = null, supplierContractNo = null;
		PageFreeTextForm.clickSuggestedSupplierRadioLink(driver, testCaseName);
		PageFreeTextForm.clickOnSelectExistingSupplierLink(driver, testCaseName);

		//PageFreeTextForm.searchForSupplierName(driver, testCaseName, IConstantsData.Supplier_ebay);

		//fill supplier name
		supplierName = PageFreeTextForm.fillExistingSuggestSupplierName(driver, testCaseName, CommonServices.getTestData(IConstantsData.SUPPLIER_NAME, 0));
		if (supplierName == null)
		{
			supplierName = PageFreeTextForm.fillExistingSuggestSupplierName(driver, testCaseName, IConstantsData.Supplier_eproc);
			if (supplierName == null)
			{
				supplierName = PageFreeTextForm.fillExistingSuggestSupplierName(driver, testCaseName, IConstantsData.Supplier_ebay);
				if (supplierName == null)
					return false;
			}
		}
		supplierContractNo = PageFreeTextForm.fillExistingSuggestSupplierContractNo(driver, testCaseName, Helper.getRandomNumber(4));
		PageFreeTextForm.selectExistingSuggestSupplierAddress(driver, testCaseName);
		PageFreeTextForm.clickOnAddExistingSuggestSupplierButton(driver, testCaseName);
		PageMyFavorites.clickOnConfirmation_YES_NO(driver, testCaseName, IConstantsData.CONFIRMATION_YES);

		/*
		 * supplierContractNo = PageFreeTextForm.fillExistingSuggestSupplierContractNo(driver, testCaseName,Helper.getRandomNumber(4));
		 * PageFreeTextForm.clickOnAddExistingSuggestSupplierButton(driver, testCaseName);
		 * PageMyFavorites.clickOnConfirmation_YES_NO(driver, testCaseName, IConstantsData.CONFIRMATION_YES);
		 */
		//boolean status = PageFreeTextForm.isContractNoFieldPresent(driver, testCaseName);
		boolean status = supplierContractNo != null;
		return status;
	}

	public static boolean selectCategoryDescriptionForFreeTextItem(WebDriver driver, String testCaseName, CEform cEform) throws NumberFormatException, Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageFreeTextForm.clickSelectCategoryLink(driver, testCaseName);
		boolean status_categoryAutocomple_searchBox = PageFreeTextForm.selectCategoryFromTheSearchBox(driver, testCaseName, cEform.getCategory());
		boolean status_isContinueWithoutCategoryPresent = PageFreeTextForm.isContinueWithoutCategoryPresent(driver, testCaseName, 1);

		PageFreeTextForm.continueWithoutCategory(driver, testCaseName);
		boolean status_isRequirementDetailPresent = !(FlowBuyersDesk.isRequirementDetailTabThereAfterCategoryFreeTextItemChange(driver, testCaseName, cEform));
		PageFreeTextForm.clickSelectCategoryLink(driver, testCaseName);

		PageFreeTextForm.clickSelectEFormLink(driver, testCaseName, cEform.getCeformDisplayName());
		boolean status_selectEForm = PageFreeTextForm.clickEFormNamewise(driver, testCaseName, cEform.getCeformDisplayName());
		PageFreeTextForm.clickCategoryUnderEFormIndexwise(driver, testCaseName, 1);

		// PageFreeTextForm.clickCloseCategoryDailogueButton(driver,
		// testCaseName);
		PageFreeTextForm.clickSelectCategoryLink(driver, testCaseName);

		PageFreeTextForm.selectCategoryFromTheSearchBox(driver, testCaseName, cEform.getCategory());
		PageFreeTextForm.clickEFormInCategoryNameWise(driver, testCaseName, cEform.getCeformDisplayName());
		boolean status_EFormLoaded = PageFreeTextForm.isEformFieldVisible(driver, testCaseName, cEform.getFieldName());
		boolean status_yellowBandPresent = PageFreeTextForm.isYellowBandPresent(driver, testCaseName);
		boolean status_catalogItem_punchoutsLinkPresent = PageFreeTextForm.isCatalogItemPunchoutsHyperlinkPresent(driver, testCaseName);
		/*
		 * PageFreeTextForm.clickCatalogItemLink(driver, testCaseName); boolean
		 * status_isListingPage=PageSearchListing.isSearchListingPage(driver,
		 * testCaseName); driver.navigate().back();
		 */
		return status_categoryAutocomple_searchBox && status_selectEForm && status_isContinueWithoutCategoryPresent && status_isRequirementDetailPresent && status_EFormLoaded
			&& status_yellowBandPresent && status_catalogItem_punchoutsLinkPresent;
	}

	public static OnlineStore search_FreeText_CatalogItem(WebDriver driver, String testCaseName, OnlineStore onlineStore, CEform cEform) throws NumberFormatException, Exception
	{
		ActionBot.defaultMediumSleep();
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		PageOnlineStore.fillSearchText(driver, testCaseName, onlineStore.getSearchItem());
		PageOnlineStore.clickSearchButton(driver, testCaseName);

		if (PageOnlineStore.isGuidedProcurementLinkVisible(driver, testCaseName))
		{
			// if the searched item is catalog item
			if (onlineStore.getItemType().equals(IConstantsData.CATALOG_ITEM))
			{
				onlineStore.setResult(false);
			}
			// if the searched item is guided item
			else if (onlineStore.getItemType().equals(IConstantsData.GUIDED_ITEM))
			{
				if (onlineStore.getNextAction().equals(IConstantsData.SEARCH))
				{
					PageOnlineStore.clickOnGuidedProcurementLink(driver, testCaseName);
					ActionBot.waitForPageLoad(driver);
				}
				else if (onlineStore.getNextAction().equals(IConstantsData.Checkout))
				{
					onlineStore.setResult(fillGuidedProcurement_AddToCart_Checkout(driver, testCaseName, cEform));
				}

			}
		}
		else
		{
			onlineStore.setResult(true);
		}
		return onlineStore;
	}

	public static OnlineStore clearCartAndSearchProduct(WebDriver driver, String testCaseName, OnlineStore onlineStore, CEform cEform) throws NumberFormatException, Exception
	{
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		ActionBot.defaultLowSleep();
		FlowOnlineStore.clearCart(driver, testCaseName);
		onlineStore = FlowOnlineStore.search_FreeText_CatalogItem(driver, testCaseName, onlineStore, cEform);
		return onlineStore;
	}

	public static OnlineStore isCategoryDisplayed(WebDriver driver, String testCaseName, OnlineStore onlinestore) throws ActionBotException, Exception
	{
		searchItem(driver, testCaseName, onlinestore);
		boolean flag = PageOnlineStore.isRelatedCategoryDisplayed(driver, testCaseName);
		onlinestore.setCategoryDisplayed(flag);
		return onlinestore;

	}

}
