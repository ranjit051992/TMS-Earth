package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ReadyToCheckout;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalFreeTextReadyToCheckOutImpl implements IModalFreeTextReadyToCheckOut
{

	static Logger logger = Logger.getLogger(IModalFreeTextReadyToCheckOutImpl.class);

	@Override
	public void toClickCheckoutBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKOUT_BTN);

	}

	@Override
	public void toClickAddAnotherItemBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, ADD_ANOTHER_ITEM, 5);
		ActionBot.click(driver, ADD_ANOTHER_ITEM);

	}

	@Override
	public void toClickViewItemsInCartLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testcaseName, "Before clicking on view items in cart button");
		ActionBot.click(driver, VIEW_ITEMS_IN_CART);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on view items in cart button");
	}

	@Override
	public String getItemName(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String itemName = ActionBot.findElement(driver, ITEM_NAME_FREE_TEXT_PAGE).getText();
		logger.info("Item Name of Guided item is : " + itemName);

		return itemName;
	}

	@Override
	public String getItemAmountAndCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String itemAmount = ActionBot.findElement(driver, ITEM_AMOUNT_N_CURR).getText();
		logger.info("Item Amount of Guided item is : " + itemAmount);

		String itemCurrency = itemAmount.substring(0, 3);
		logger.info("Item currency of Guided item is : " + itemCurrency);

		return itemAmount;
	}

	@Override
	public String getCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String category = ActionBot.findElement(driver, CATEGORY).getText();
		logger.info("Item Category of Guided item is : " + category);

		return category;
	}

	@Override
	public String getSPSCCode(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String spscCode = ActionBot.findElement(driver, SPSC_CODE).getText();
		logger.info("Item SPSC Code of Guided item is : " + spscCode);

		return spscCode;
	}

}
