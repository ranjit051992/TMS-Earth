/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.Search;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author puneet.sharma
 *
 */
public class ModalShoppingCart
{

	static Logger logger = Logger.getLogger(ModalShoppingCart.class);
	static
	{

		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void emptyCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.emptyCart(driver, testCaseName);
			// ActionBot.defaultMediumSleep();
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method emptyCart " + e, e);
		}

	}

	public static void checkout(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.checkout(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  checkout" + e, e);
		}

	}

	public static void continueWithCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.continueWithCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  continueWithCart" + e, e);
		}

	}

	public static void deleteItemFromCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.deleteItemFromCart(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  deleteItemFromCart" + e, e);
		}
	}

	public static String fillItemQUantity(WebDriver driver, String testCaseName, String itemId, String quantity) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.fillItemQUantity(driver, testCaseName, itemId, quantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  fillItemQUantity" + e, e);
		}
		return null;
	}

	public static float getItemQUantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getItemQuantity(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  fillItemQUantity" + e, e);
		}
		return 0;
	}

	public static void updateItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.updateItemQuantity(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method updateItemQuantity " + e, e);
		}

	}

	public static String getItemAvailaibility(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getItemAvailaibility(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemAvailaibility " + e, e);
		}
		return null;
	}

	public static String getItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getItemName(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  getItemName" + e, e);
		}
		return null;
	}

	public static String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getItemId(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  getItemId" + e, e);
		}
		return null;
	}

	public static String getTotalPriceOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getTotalPriceOfItem(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  getTotalPriceOfItem" + e, e);
		}
		return null;
	}

	public static String getTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getTotalPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalPrice " + e, e);
		}
		return null;
	}

	public static void saveCartAsShopppingBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.saveCartAsShopppingBasket(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  saveCartAsShopppingBasket" + e, e);
		}

	}

	public static void closeCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.closeCart(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  closeCart" + e, e);
		}
	}

	public static boolean isModalAppear(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.isModalAppear(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  closeCart" + e, e);
		}
		return false;
	}

	public static List<WebElement> getItemList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			return iModalShoppingCart.getItemList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  getItemList" + e, e);
		}
		return null;
	}

	public static List<Search> getListOfItemsAndTheirQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemList = getItemList(driver, testCaseName);
		List<Search> itemFound = new ArrayList<Search>();
		for (WebElement list : itemList)
		{
			Search search = new Search();
			search.setId(list.getAttribute("data-item-id"));
			search.setItemName(list.getText());
			search.setSearchQuantity(getItemQUantity(driver, testCaseName, list.getAttribute("data-item-id")));
			itemFound.add(search);
		}

		return itemFound;
	}

	public static boolean isItemPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			flag = iModalShoppingCart.isItemPresent(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemPresent" + e, e);
		}
		return flag;
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IModalShoppingCart iModalShoppingCart = FactoryModal.getInstanceOfIModalShoppingCart();
			iModalShoppingCart.clickOnItemName(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemName" + e, e);
		}
	}
}
