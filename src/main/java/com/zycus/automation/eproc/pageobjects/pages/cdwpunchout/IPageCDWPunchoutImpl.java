/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cdwpunchout;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.returnfrompunchout.IPageReturnFromPunchout;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCDWPunchoutImpl implements IPageCDWPunchout
{
	static Logger logger = Logger.getLogger(IPageCDWPunchoutImpl.class);

	@Override
	public String fillSearchPunchoutItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String searchedItemName = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_PUNCHOUT_ITEM, itemName);
		logger.info("Entered item name : " + searchedItemName);
		ActionBot.defaultSleep();
		return searchedItemName;
	}

	@Override
	public void clickOnSearchButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH_PUNCHOUT_ITEM_GO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After searching item");
	}

	@Override
	public List<WebElement> getListOfSearchedProducts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_PUNCHOUT_PRODUCTS);
	}

	@Override
	public int fillItemQuantity(WebDriver driver, String testCaseName, int quantity, String itemName) throws ActionBotException
	{
		String quant = ActionBot.sendKeys(driver, By.xpath(".//*[contains(text(),'" + itemName + "')]/../../..//input[contains(@name,'Quantity')]"), Integer.toString(quantity));
		logger.info("Entered Quantity : " + quant);
		return Integer.parseInt(quant);
	}

	@Override
	public void clickOnAddToCartButton(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add to cart button");
		ActionBot.click(driver, By.xpath(".//*[contains(text(),'" + itemName + "')]/../../..//input[contains(@value,'Add To Cart')]"));
		waitTillProgressiveDivAddItemToCartPresent(driver, testCaseName);
		//ActionBot.findElement(driver, TEXTBOX_QUANTITY_OF_ADDED_PUNCHOUT_ITEM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add to cart button");
	}

	@Override
	public void waitTillProgressiveDivAddItemToCartPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_ADD_ITEM_TO_CART);
	}

	@Override
	public int getQuantityOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quant = ActionBot.getAttributeOfElement(driver, TEXTBOX_QUANTITY_OF_ADDED_PUNCHOUT_ITEM, "value");
		logger.info("Entered Quantity : " + quant);
		return Integer.parseInt(quant);
	}

	@Override
	public String getUnitPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_UNIT_PRICE_OF_ADDED_PUNCHOUT_ITEM);
		logger.info("Unit Price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public String getTotalPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalPrice = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_PRICE_OF_ADDED_PUNCHOUT_ITEM);
		logger.info("Total Price : " + totalPrice);
		return totalPrice;
	}

	@Override
	public void clickOnCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on checkout button");
		ActionBot.click(driver, BUTTON_PUNCHOUT_CHECKOUT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on checkout button");
		ActionBot.findElement(driver, BUTTON_TRANSFER_SUBMIT);
	}

	@Override
	public void clickOnTransferSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on transfer submit button");
		ActionBot.click(driver, BUTTON_TRANSFER_SUBMIT);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on transfer submit button");
		//ActionBot.findElement(driver, IPageReturnFromPunchout.BUTTON_ADD_TO_CARTD_AND_CHECKOUT);
	}

	@Override
	public String fillItemCategory(WebDriver driver, String testCaseName, String itemCategory) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXT_INPUT_CATEGORY))
		{
			ActionBot.fillAutoCompleteField(driver, TEXT_INPUT_CATEGORY, itemCategory);
			ScreenShot.screenshot(driver, testCaseName, "After filling punchout item category");
			ActionBot.defaultSleep();
			ActionBot.click(driver, LINK_SAVE);
			ActionBot.waitTillPopUpIsPresent(driver, CONFIRMATION_ITEM_CLASSIFIED);
			ScreenShot.screenshot(driver, testCaseName, "After saving punchout item category");
			ActionBot.defaultSleep();
		}
		return itemCategory;
	}

	@Override
	public String getAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String itemName = null;
		if (ActionBot.isElementDisplayed(driver, PUNCHOUT_ITEM_NAME))
		{
			itemName = ActionBot.getTextWithInElement(driver, PUNCHOUT_ITEM_NAME);
		}
		logger.info("Item name is :" + itemName);
		return itemName;
	}

}
