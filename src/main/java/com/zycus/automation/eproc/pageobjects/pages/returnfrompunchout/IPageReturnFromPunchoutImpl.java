/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.returnfrompunchout;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageReturnFromPunchoutImpl implements IPageReturnFromPunchout
{
	static Logger logger = Logger.getLogger(IPageReturnFromPunchoutImpl.class);

	@Override
	public String getAddedPunchoutItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemName = ActionBot.getTextWithInElement(driver, LINK_ADDED_PUNCHOUT_ITEM_NAME);
		logger.info("Added item name : " + itemName);
		return itemName;
	}

	@Override
	public String getAddedPunchoutItemCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String category = ActionBot.getTextWithInElement(driver, LABEL_ADDED_PUNCHOUT_ITEM_CATEGORY);
		logger.info("Added item category : " + category);
		return category;
	}

	@Override
	public String getAddedPunchoutItemUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_ADDED_PUNCHOUT_ITEM_UNIT_PRICE);
		logger.info("Added item unit price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public int getAddedPunchoutItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = ActionBot.getTextWithInElement(driver, LABEL_ADDED_PUNCHOUT_ITEM_QUANTITY);
		logger.info("Added item quantity : " + quantity);
		return Integer.parseInt(quantity);
	}

	@Override
	public String getAddedPunchoutItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalPrice = ActionBot.getTextWithInElement(driver, LABEL_ADDED_PUNCHOUT_ITEM_TOTAL_PRICE);
		logger.info("Added item total price : " + totalPrice);
		return totalPrice;
	}

	@Override
	public void clickOnAddToCardAndCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add to cart and checkout button");
		ActionBot.click(driver, BUTTON_ADD_TO_CARTD_AND_CHECKOUT);
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, LINK_IGNORE_AND_SUBMIT))
		{
			ActionBot.click(driver, LINK_IGNORE_AND_SUBMIT);
			ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add to cart and checkout button");
		ActionBot.findElement(driver, IPageRequisitionCheckOut.TEXTBOX_REQUISITION_NAME);
	}

	@Override
	public void clickOnAddToCardAndContinueShoppingButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_TO_CARTD_AND_CONTINUE_SHOPPING);
	}

	@Override
	public void clickOnDiscardAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DISCARD_ALL_ITEMS);
	}

}
