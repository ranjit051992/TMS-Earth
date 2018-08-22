/**
 * 
 */
package com.zycus.automation.eproc.validation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.Search;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author puneet.sharma
 *
 */
public class VerifyShoppingItemsWithShoppingCarts
{

	public static boolean verifyWhetherItemsAreAddedInCartOrNot(List<Search> itemsAdded, List<Search> itemsFound)
	{

		int counter = 0;

		for (Search search1 : itemsAdded)
		{
			for (Search search2 : itemsFound)
			{

				if (search1.getItemName().trim().equalsIgnoreCase(search2.getItemName().trim()))
				{
					if (search1.getSearchQuantity() == search2.getSearchQuantity())
					{
						counter++;
					}
					else if (search2.getSearchQuantity() == 0.0)
					{
						counter++;
					}
				}
			}
		}
		if (counter == itemsAdded.size())
		{
			return true;
		}
		return false;
	}

	/**
	 * Method to check if multiple items added
	 * 
	 * @param driver
	 * @param itemIds
	 * @param quantities
	 * @return
	 * @throws Exception
	 */
	public static boolean checkIfItemsAddedToCart(WebDriver driver, String testCaseName, Item items) throws Exception
	{
		List<Search> itemsAdded = FlowRequisition.getListOfListAdded(items);
		PageOnlineStore.clickOnViewCart(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		List<Search> itemsFound = ModalShoppingCart.getListOfItemsAndTheirQuantity(driver, testCaseName);

		// to add item id of guided item
		if (items.getGuidedItems() != null)
		{
			List<GuidedItem> guidedItems = items.getGuidedItems();
			for (GuidedItem guidedItem : guidedItems)
			{
				for (Search search : itemsFound)
				{
					if (guidedItem.getShortDescription().equalsIgnoreCase(search.getItemName()))
					{
						guidedItem.setItemID(search.getId());
						break;
					}
				}
			}
		}

		// to verify items
		return VerifyShoppingItemsWithShoppingCarts.verifyWhetherItemsAreAddedInCartOrNot(itemsAdded, itemsFound);
	}

}
