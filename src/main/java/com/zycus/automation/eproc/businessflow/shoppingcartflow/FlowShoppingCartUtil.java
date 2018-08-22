/**
 * 
 */
package com.zycus.automation.eproc.businessflow.shoppingcartflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Search;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.popups.continueshopping.PopUpContinueShopping;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author puneet.sharma
 *
 */
public class FlowShoppingCartUtil
{
	static Logger logger = Logger.getLogger(FlowShoppingCartUtil.class);

	public static boolean isCartEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemsInCart = PageOnlineStore.getTotalItemsInCart(driver, testCaseName);
		int totalItemsInCart = (itemsInCart != null) ? Integer.parseInt(itemsInCart) : 0;
		return (totalItemsInCart > 0) ? false : true;
	}

	public static void waitTillCartOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		while (!ModalShoppingCart.isModalAppear(driver, testCaseName))
		{
			ActionBot.defaultLowSleep();
			continue;
		}
	}

	public static void waitTillContinueShoppingPopAppear(WebDriver driver, String testCaseName) throws ActionBotException
	{
		while (!PopUpContinueShopping.isPopUpPresent(driver, testCaseName))
		{
			ActionBot.defaultLowSleep();
			if (PopUpContinueShopping.isPopUpPresent(driver, testCaseName))
			{
				break;
			}
			else
			{
				continue;
			}
		}
	}

	protected List<Search> getListOfItemsInCart(WebDriver driver)
	{

		return null;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check item removed from cart or not
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean isItemRemovedFromCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return !(ModalShoppingCart.isItemPresent(driver, testCaseName, itemId));
	}

}
