/**
 * 
 */
package com.zycus.automation.eproc.businessflow.shoppingcartflow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.popups.continueshopping.PopUpContinueShopping;
import com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation.PopUpDeleteConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.PopUpEmptyCartConfirmation;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author puneet.sharma
 *
 */
public class FlowShoppingCart
{
	static Logger logger = Logger.getLogger(FlowShoppingCart.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean emptyShoppingCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// EMPTY CART
		if (!FlowShoppingCartUtil.isCartEmpty(driver, testCaseName))
		{
			PageOnlineStore.clickOnViewCart(driver, testCaseName);
			// waitTillCartOpen(driver, testCaseName);
			ModalShoppingCart.emptyCart(driver, testCaseName);
			// PopUpEmptyCartConfirmation.moveOnPop(driver, testCaseName);
			PopUpEmptyCartConfirmation.yes(driver, testCaseName);
			// waitTillContinueShoppingPopAppear(driver, testCaseName);
			PopUpContinueShopping.continueShopping(driver, testCaseName);
			return (FlowShoppingCartUtil.isCartEmpty(driver, testCaseName)) ? true : false;
		}
		return true;

	}

	public static boolean removeItemFromCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ModalShoppingCart.deleteItemFromCart(driver, testCaseName, itemId);
		PopUpDeleteConfirmation.clickOnYesButton(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		return (FlowShoppingCartUtil.isItemRemovedFromCart(driver, testCaseName, itemId));
	}

	public static String getItemId(WebDriver driver, String testCaseName, String itemName, String nextAction) throws ActionBotException
	{
		String itemId = ModalShoppingCart.getItemId(driver, testCaseName, itemName);
		if (nextAction.equalsIgnoreCase(IConstantsData.Checkout))
		{
			ModalShoppingCart.checkout(driver, testCaseName);
		}
		else if (nextAction.equalsIgnoreCase(IConstantsData.ContinueShopping))
		{
			ModalShoppingCart.continueWithCart(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}
		return itemId;
	}
}
