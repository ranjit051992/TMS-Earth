package com.zycus.automation.eproc.pageobjects.modals.itemDetailsPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemDetailsImpl implements IModalItemDetails
{

	@Override
	public boolean checkIsCatalogItemSameAsSelected(WebDriver driver, int index) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS).getText();
		String str1 = ActionBot.findElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']"))
			.getText();
		if (str.equalsIgnoreCase(str1))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isAddPresentInItemDetail(WebDriver driver, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='b-button b-primary addItemButton']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isMaxCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		int item = ActionBot.findElement(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS).getText().length();
		int itemName = ActionBot.findElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']"))
			.getText().length();
		if (item == itemName)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		String str = ActionBot.findElement(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS).getText();
		ModalItemDetails.clickOnCloseButton(driver);
		String str1 = ActionBot.findElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']"))
			.getText();
		if (str.equalsIgnoreCase(str1))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		String str = ActionBot.findElement(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS).getText();
		ModalItemDetails.clickOnCloseButton(driver);
		String str1 = ActionBot.findElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']"))
			.getText();
		if (str.equalsIgnoreCase(str1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		String str = ActionBot.findElement(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS).getText();
		/*
		 * String str1 = ActionBot.findElement( driver,
		 * By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index +
		 * "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']"
		 * )).getText();
		 */
		ModalItemDetails.clickOnCloseButton(driver);
		String str1 = ActionBot.findElement(driver, TEXTBOX_ADD_ITEMS_TO_PO).getText();

		if (str.contains(str1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddToCartPresentInItemDetail(WebDriver driver) throws ActionBotException

	{
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_TO_CART_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddToFavoritesPresentInItemDetail(WebDriver driver) throws ActionBotException

	{
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_TO_FAVORITES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddToBasketPresentInItemDetail(WebDriver driver) throws ActionBotException

	{
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_TO_BASKET))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isItemNamePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CATALOG_ITEM_LABEL_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	//Click on close button in the modal
	@Override
	public void clickOnCloseButton(WebDriver driver) throws ActionBotException
	{
		try
		{
			if (ActionBot.isElementPresent(driver, BUTTON_CLOSE_MODAL_ITEM_DETAILS))
			{
				ActionBot.click(driver, BUTTON_CLOSE_MODAL_ITEM_DETAILS);
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

	}
}
