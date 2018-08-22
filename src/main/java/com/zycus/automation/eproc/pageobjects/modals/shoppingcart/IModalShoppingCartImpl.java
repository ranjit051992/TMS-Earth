package com.zycus.automation.eproc.pageobjects.modals.shoppingcart;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalShoppingCartImpl implements IModalShoppingCart
{

	static Logger logger = Logger.getLogger(IModalShoppingCartImpl.class);

	@Override
	public void emptyCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName, "before empty cart click
		// in cart");
		ActionBot.click(driver, ICON_EMPTY_CART);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "after empty cart click in cart");
	}

	@Override
	public void checkout(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before checkout click in cart");
		ActionBot.click(driver, BUTTON_CHECKOUT_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "after checkout click in cart");
	}

	@Override
	public void continueWithCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before continue shopping click in cart");
		ActionBot.click(driver, BUTTON_CONTINUE_SHOPPING);
		ScreenShot.screenshot(driver, testCaseName, "after continue shopping click in cart");
	}

	@Override
	public void deleteItemFromCart(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String xpathExpression = ITEM_DELETE + itemId + END_OF_XPATH;
		ScreenShot.screenshot(driver, testCaseName, "before delete item click in cart");
		ActionBot.click(driver, By.xpath(xpathExpression));
		ScreenShot.screenshot(driver, testCaseName, "after delete item click in cart");
	}

	@Override
	public String fillItemQUantity(WebDriver driver, String testCaseName, String itemId, String quantity) throws ActionBotException
	{
		String xpathExpression = ITEM_QUANTITY + itemId + END_OF_XPATH;
		ScreenShot.screenshot(driver, testCaseName, "before  typing quantity of item in cart");
		ActionBot.sendKeys(driver, By.xpath(xpathExpression), quantity);
		ScreenShot.screenshot(driver, testCaseName, "after typing quantity of item in cart");
		quantity = ActionBot.getTextWithInElement(driver, By.xpath(xpathExpression)).trim();
		return quantity;
	}

	@Override
	public float getItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String xpathExpression = ITEM_QUANTITY + itemId + END_OF_XPATH;

		ScreenShot.screenshot(driver, testCaseName, "get quantity of item in cart");
		String quantity = ActionBot.getTextWithInElement(driver, By.xpath(xpathExpression)).trim();
		return (quantity != null) ? Float.parseFloat(quantity) : 0;
	}

	@Override
	public void updateItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String xpathExpression = ITEM_UPDATE + itemId + END_OF_XPATH;
		ScreenShot.screenshot(driver, testCaseName, "before updating quantity in cart");
		ActionBot.click(driver, By.xpath(xpathExpression));
		ScreenShot.screenshot(driver, testCaseName, "after updating quantity in cart");
	}

	@Override
	public String getItemAvailaibility(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String extraXpathExpression = "//td[@class='avail']//*[@class='lbl']";
		String xpathExpression = ITEM_AVAILABILITY + itemId + END_OF_XPATH + extraXpathExpression;
		ScreenShot.screenshot(driver, testCaseName, "availiablity of item in cart");
		String availability = ActionBot.getTextWithInElement(driver, By.xpath(xpathExpression)).trim();
		return availability;
	}

	@Override
	public String getItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String extraXpathExpression = "//a[@class='showItemDetails']";
		String xpathExpression = ITEM_NAME + itemId + END_OF_XPATH + extraXpathExpression;
		ScreenShot.screenshot(driver, testCaseName, "item name in cart");
		String itemName = ActionBot.getTextWithInElement(driver, By.xpath(xpathExpression)).trim();
		return itemName;
	}

	@Override
	public String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		List<WebElement> itemList = getItemList(driver, testCaseName);
		String itemId = null;
		for (WebElement list : itemList)
		{
			if (list.getText().trim().equalsIgnoreCase(itemName))
			{
				itemId = list.getAttribute("data-itemid");
			}
		}
		logger.info("Item Id : " + itemId);
		return itemId;
	}

	@Override
	public String getTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "total price of cart");
		String cartTotalPrice = ActionBot.getTextWithInElement(driver, LABEL_CART_TOTAL_PRICE).trim();
		return cartTotalPrice;
	}

	@Override
	public void saveCartAsShopppingBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before  save cart as shopping basket click in cart");
		ActionBot.click(driver, ICON_SAVE_CART_AS_SHOPPING_BASKET);
		ScreenShot.screenshot(driver, testCaseName, "after  save cart as shopping basket click in cart");
	}

	@Override
	public void closeCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before closing cart");
		ActionBot.click(driver, X_CLOSE_SHOPPING_CART);
		ScreenShot.screenshot(driver, testCaseName, "after closing cart ");
	}

	@Override
	public String getTotalPriceOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String xpathExpression = ITEM_PRICE + itemId + END_OF_XPATH;
		ScreenShot.screenshot(driver, testCaseName, "total price of per item in cart");
		String totalPriceOfItem = ActionBot.getTextWithInElement(driver, By.xpath(xpathExpression)).trim();
		return totalPriceOfItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.modals.shoppingcart.
	 * IModalShoppingCart#isModalAppear(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public boolean isModalAppear(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, MODAL_SHOPPING_CART);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.modals.shoppingcart.
	 * IModalShoppingCart#getItemList(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public List<WebElement> getItemList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "List of items");
		By itemName = By.cssSelector(".showItemDetails");
		return ActionBot.findElements(driver, itemName);
	}

	@Override
	public boolean isItemPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "To check item is present or not");
		return ActionBot.isElementPresent(driver, By.xpath(".//*[@id='grid_item_row_" + itemId + "']/td[2]/a"));
	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//a[text()='" + itemName + "']"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Item Name");
	}
}
