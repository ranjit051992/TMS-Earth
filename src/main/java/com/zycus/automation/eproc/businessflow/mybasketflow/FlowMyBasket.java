/**
 * 
 */
package com.zycus.automation.eproc.businessflow.mybasketflow;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.Basket;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.pageobjects.modals.addtobasket.IModalAddToBasket;
import com.zycus.automation.eproc.pageobjects.modals.addtobasket.ModalAddToBasket;
import com.zycus.automation.eproc.pageobjects.pages.mybasket.PageMyBasket;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation.PopUpDeleteConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.ItemException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

/**
 * @author ankita.sawant
 */
public class FlowMyBasket
{

	static Logger logger = Logger.getLogger(FlowMyBasket.class);

	public static Basket addItemToExistingBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, ItemException
	{
		Item items = basket.getItem();
		String itemId = null;
		List<CatelogItem> catelogItems = items.getCatelogItems();

		// to select items
		for (CatelogItem catelogItem : catelogItems)
		{
			FlowSearchListing.searchItem(driver, testCaseName, catelogItem.getItemName());
			itemId = PageSearchListing.getItemId(driver, testCaseName, catelogItem.getItemName());
			catelogItem.setItemID(itemId);
		}
		PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, itemId);

		PageSearchListing.clickOnAddMultipleItemsToBasket(driver, testCaseName);

		// to add item to existing basket
		basket = selectExistingBasket(driver, testCaseName, basket);
		return basket;

	}

	public static Basket selectExistingBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException
	{
		ModalAddToBasket.clickOnSelectExistingBasket(driver, testCaseName);
		basket.setBasketName(ModalAddToBasket.selectExistingBasket(driver, testCaseName, basket.getBasketName()));
		ModalAddToBasket.clickOnAddToBasketButton(driver, testCaseName);
		ModalAddToBasket.waitTillAddToBasketSuccessMessage(driver, testCaseName);
		return basket;

	}

	public static Basket openAnExistingMap(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		FlowMyBasket.searchBasket(driver, testCaseName, basket);
		ActionBot.waitForOperations(10000);
		PageMyBasket.clickFirstBasket(driver, testCaseName);
		return basket;
	}

	public static Basket addItemNewBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, ItemException
	{
		Item items = basket.getItem();
		String itemId = null;
		List<CatelogItem> catelogItems = items.getCatelogItems();

		// to select items
		for (CatelogItem catelogItem : catelogItems)
		{
			FlowSearchListing.searchItem(driver, testCaseName, catelogItem.getItemName());
			itemId = PageSearchListing.getItemId(driver, testCaseName, catelogItem.getItemName());
			catelogItem.setItemID(itemId);
		}
		PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, itemId);

		PageSearchListing.clickOnAddMultipleItemsToBasket(driver, testCaseName);

		// to add item to existing basket
		basket = createNewBasket(driver, testCaseName, basket);
		return basket;

	}

	public static Basket createNewBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException
	{
		ModalAddToBasket.clickOnCreateNewBasket(driver, testCaseName);
		basket.setBasketName(ModalAddToBasket.fillNewBasketName(driver, testCaseName, basket.getBasketName()));
		ActionBot.defaultMediumSleep();
		ModalAddToBasket.clickOnAddToBasketButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		return basket;
	}

	public static Basket searchBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		PageMyBasket.fillBasketSearchTextBox(driver, testCaseName, basket.getBasketName());
		if (basket.getBasketName() != null)
		{
			PageMyBasket.selectBasketSearchBy(driver, testCaseName, IConstantsData.SEARCH_BY_BASKET_NAME);
		}
		else
		{
			logger.info("Invalid option for search by");
		}
		PageMyBasket.clickOnSearchGoButton(driver, testCaseName);
		basket.setResult(checkIfBasketSearched(driver, testCaseName, basket));
		return basket;
	}

	public static boolean checkIfBasketSearched(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException
	{
		boolean flag = false;
		if (basket.getBasketName() != null)
		{
			flag = basket.getBasketName().equalsIgnoreCase(PageMyBasket.getSearchedBasketName(driver, testCaseName));
		}
		return flag;
	}

	public static void viewBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageMyBasket.clickOnViewBasketLink(driver, testCaseName);
	}

	public static boolean removeItemFromBasket(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		boolean flag = false;
		PageMyBasket.clickOnCheckBoxForItem(driver, testCaseName, itemId);
		PageMyBasket.clickOnDeleteFromBasket(driver, testCaseName);
		if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
		{
			PopUpDeleteConfirmation.clickOnYesButton(driver, testCaseName);
		}
		PageMyBasket.waitTillItemDeletedSuccessMsg(driver, testCaseName);
		flag = checkIfItemRemovedFromBasket(driver, testCaseName, itemId);
		return flag;
	}

	public static boolean checkIfItemRemovedFromBasket(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		boolean flag = false;

		if (ActionBot.isElementPresent(driver, IPageSearchListing.EMPTY_DATA_TABLE))
		{
			flag = true;
		}
		else
		{
			List<WebElement> listOfItems = PageMyBasket.getListOfItemsInBasket(driver, testCaseName);
			if (listOfItems.size() > 0)
			{
				for (WebElement ele : listOfItems)
				{
					if (ele.getAttribute("itemid").equalsIgnoreCase(itemId))
					{
						flag = false;
						break;
					}
					else
					{
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	public static Basket removeItemFromBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException
	{
		viewBasket(driver, testCaseName);
		for (CatelogItem catelogItem : basket.getItem().getCatelogItems())
		{
			basket.setResult(removeItemFromBasket(driver, testCaseName, catelogItem.getItemID()));
		}
		return basket;
	}

	//	public static boolean removeExistingBasketFromList(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, InterruptedException, FactoryMethodException
	//	{
	//		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
	//		Thread.sleep(5000);
	//
	//		basket = FlowMyBasket.searchBasket(driver, testCaseName, basket);
	//		int i = 0;
	//		i++;
	//		if (PageMyBasket.isBasketVisible(driver, testCaseName, i))
	//		{
	//
	//			basket = FlowMyBasket.searchBasket(driver, testCaseName, basket);
	//			if (ActionBot.isElementDisplayed(driver, IPageMyBasket.FIRST_BASKET_IN_LIST))
	//			{
	//
	//				PageMyBasket.clickActionButon(driver, testCaseName);
	//				if (PageMyBasket.isDeletBasketButtonPresent(driver, testCaseName, i))
	//				{
	//					PageMyBasket.clickDeleteBasket(driver, testCaseName, 1);
	//				}
	//			}
	//		}
	//		return true;
	//	}

	public static void removeExistingFirstItemFromTheBasket(WebDriver driver, String testCaseName, Basket basket)
		throws ActionBotException, InterruptedException, FactoryMethodException
	{
		Thread.sleep(5000);
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		PageMyBasket.fillBasketSearchTextBox(driver, testCaseName, basket.getBasketName());
		PageMyBasket.clickOnSearchGoButton(driver, testCaseName);
		PageMyBasket.clickFirstBasket(driver, testCaseName);
		PageMyBasket.clickFirstItemCheckBoxInBasket(driver, testCaseName);
		PageMyBasket.clickOnDeleteFromBasket(driver, testCaseName);
	}

	public static String fetchbasketCapacity(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, InterruptedException, FactoryMethodException
	{
		Thread.sleep(5000);
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		PageMyBasket.fillBasketSearchTextBox(driver, testCaseName, basket.getBasketName());
		PageMyBasket.clickOnSearchGoButton(driver, testCaseName);
		String capacity = PageMyBasket.fetchBasketcapacity(driver, testCaseName, 1);
		return capacity;
	}

	public static void addItemToExistingBasket(WebDriver driver, String testCaseName, String item_id) throws ActionBotException, InterruptedException, FactoryMethodException

	{
		PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, item_id);
		PageSearchListing.clickOnAddMultipleItemsToBasket(driver, testCaseName);
	}

	public static boolean verifyItemNo_ItemNameSupplier_ItemPrice_ItemQuantity_present(WebDriver driver, String testCaseName)
		throws ActionBotException, InterruptedException, FactoryMethodException
	{
		boolean status = false;
		if (PageMyBasket.checkMentionedItemNumberDetailInMyBasket(driver, testCaseName))
		{
			if (PageMyBasket.checkMentionedItemNameSupplierNameDetailInMyBasket(driver, testCaseName))
			{
				if (PageMyBasket.checkMentionedItemPriceDetailInMyBasket(driver, testCaseName))
				{
					if (PageMyBasket.checkMentionedItemQtyDetailInMyBasket(driver, testCaseName))
					{
						status = true;
					}
				}
			}
		}
		return status;
	}

	public static void viewNewlyCreatedBasket(WebDriver driver, String testCaseName, Basket basket) throws ActionBotException, InterruptedException, FactoryMethodException
	{
		Thread.sleep(3000);
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		basket = FlowMyBasket.searchBasket(driver, testCaseName, basket);
		PageMyBasket.clickFirstBasket(driver, testCaseName);
	}

	public static boolean verifyCreationOfBasketWithSameName(WebDriver driver, String testCaseName, OnlineStore onlineStore, TestCase testCase, Map<String, String> map, User user,
		Basket basket) throws NumberFormatException, Exception
	{
		boolean status = false;
		int c = 1;
		Thread.sleep(3000);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		do
		{
			// fill in the search text box and click search
			onlineStore = FlowOnlineStore.search_FreeText_CatalogItem(driver, testCaseName, onlineStore, null);
			if (onlineStore.isResult() == false && onlineStore.getItemType().equals(IConstantsData.CATALOG_ITEM))
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}
			onlineStore.setAddItemTo(IConstantsData.ADD_TO_BASKET);

			// to add a item to new basket
			FlowSearchListing.selectItems_Cart_Basket_Favourite(driver, testCaseName, onlineStore);

			// to create basket
			try
			{
				FlowMyBasket.createNewBasket(driver, testCaseName, basket);
				if (ActionBot.isElementDisplayed(driver, IModalAddToBasket.BUTTON_ADD_TO_BASKET_CREATE_BASKET))
				{
					status = true;
					PageMyBasket.clickToCancelCreationBasket(driver, testCaseName);
				}
			}
			catch (Exception ee)
			{
				if (c == 2)
					status = true;
				ActionBot.defaultLowSleep();
				PageMyBasket.clickToCancelCreationBasket(driver, testCaseName);
			}
			if (c == 1)
			{
				MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
				FlowOnlineStore.clearCart(driver, testCaseName);
			}
			c++;
		} while (c <= 2);
		return status;
	}

	public static void toNavigateToShoppingBasketSubTab_SearchBasket_AddBasketToCart(WebDriver driver, String testCaseName, Basket basket) throws NumberFormatException, Exception
	{
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		basket = FlowMyBasket.searchBasket(driver, testCaseName, basket);
		PageMyBasket.clickActionButon(driver, testCaseName);
		PageMyBasket.clickToAddBasketToCart(driver, testCaseName);
	}

	public static void toNavigateToShoppingBasketSubTab_ClickFirstBasket(WebDriver driver, String testCaseName, Basket basket) throws NumberFormatException, Exception
	{
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		PageMyBasket.clickFirstBasket(driver, testCaseName);
	}

	public static boolean toVerifyItemQuantityInBasket(WebDriver driver, String testCaseName, Basket basket, int qty) throws NumberFormatException, Exception
	{
		String quantity = PageMyBasket.toFetchQtyOfFirstItemInCurrentBasket(driver, testCaseName);
		boolean status = quantity.equals(Integer.toString(qty));
		return status;
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Perform complete share operation on an existing basket assuming Actions dropdown button is already clicked for a basket.
	 */
	public static Basket shareExistingBasket(WebDriver driver, String testCaseName, Basket basket) throws Exception
	{
		//get sharing scope to be filled
		String sharingScope = basket.getSharingScope();

		//click Share option in Actions
		PageMyBasket.clickBasketShareAction(driver, testCaseName);
		ActionBot.defaultLowSleep();

		//select sharing scope
		PageMyBasket.selectBasketSharingScope(driver, testCaseName, sharingScope);

		//fill additional details as per sharing scope
		if (sharingScope.equalsIgnoreCase(IConstantsData.DEPARTMENT_SCOPE))
		{
			//select department by department code
			PageMyBasket.searchAndSelectDepartmentInDepartmentSharingScope(driver, testCaseName, basket.getDepartmentCode());
		}
		else if (sharingScope.equalsIgnoreCase(IConstantsData.ORGANIZATION_UNITS_SCOPE))
		{
			//select company by company code
			PageMyBasket.searchAndSelectCompanyInOrganizationUnitsSharingScope(driver, testCaseName, basket.getCompanyCode());

			//select all business unit link
			PageMyBasket.clickBusinessUnitInBasketShareScope(driver, testCaseName);
			PageMyBasket.selectAllBusinessUnits(driver, testCaseName);

			//select all locations link
			PageMyBasket.clickLocationsInBasketShareScope(driver, testCaseName);
			PageMyBasket.selectAllLocations(driver, testCaseName);
		}

		//click final share button
		PageMyBasket.clickToShareBasket(driver, testCaseName);

		return basket;
	}

	public static boolean toVerifyAllActionsPresentInBasket(WebDriver driver, String testCaseName) throws NumberFormatException, Exception
	{
		int count = 0;
		ActionBot.defaultSleep();
		PageMyBasket.clickBasketActionIndexwise(driver, testCaseName, 1);
		if (PageMyBasket.isDeletBasketButtonPresent(driver, testCaseName, 1))
			count++;
		if (PageMyBasket.isShareBasketActionPresent(driver, testCaseName, 1))
			count++;
		if (PageMyBasket.isAddBasketToCartActionPresent(driver, testCaseName, 1))
			count++;

		logger.info("Action count::" + count);
		if (count == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Performs action on given basket.
	 */
	public static Basket searchAndPerformBasketAction(WebDriver driver, String testCaseName, Basket basket) throws Exception
	{
		String basketAction = basket.getBasketAction();

		//navigate to shopping basket
		MainPageHeaderLevelTab.clickOnShoppingBasketSubTab(driver);

		//search basket
		FlowMyBasket.searchBasket(driver, testCaseName, basket);

		if (!basket.isViewBasket())
		{
			//click Actions tab
			PageMyBasket.clickActionButon(driver, testCaseName);

			if (basketAction.equalsIgnoreCase(IConstantsData.ADD_BASKET_TO_CART))
			{
				PageMyBasket.clickToAddBasketToCart(driver, testCaseName);
			}
			else if (basketAction.equalsIgnoreCase(IConstantsData.DELETE_BASKET))
			{
				PageMyBasket.clickDeleteBasket(driver, testCaseName);
			}
			else if (basketAction.equalsIgnoreCase(IConstantsData.SHARE_BASKET))
			{
				shareExistingBasket(driver, testCaseName, basket);
			}
			else if (basketAction.equalsIgnoreCase(IConstantsData.UNSHARE_BASKET))
			{
				//create method to unshare basket and call that method here
			}
			else if (basketAction.equalsIgnoreCase(IConstantsData.UPDATE_SHARING_SCOPE))
			{
				//create method to update sharing scope and call that method here
			}
			else if (basketAction.equalsIgnoreCase(IConstantsData.NONE))
			{
				logger.info("No Action to be performed for basket");
			}
			else
			{
				logger.info("Invalid next action is specified for basket");
			}
		}
		else
		{
			//checks view basket
			PageMyBasket.clickOnViewBasketLink(driver, testCaseName);
		}
		return basket;
	}

}
