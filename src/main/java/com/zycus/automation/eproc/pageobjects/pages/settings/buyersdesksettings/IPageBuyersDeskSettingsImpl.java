package com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageBuyersDeskSettingsImpl implements IPageBuyersDeskSettings, IConstants
{
	// static Logger logger = Logger.getLogger(IBuyersDeskSettingsImpl.class);

	@Override
	public boolean clickOnNotifyRequesterOnChangeToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_YES);
		if (ActionBot.isElementSelected(driver, NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnNotifyRequesterOnChangeToReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_NO);
		if (ActionBot.isElementSelected(driver, NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getNotifyRequesterOnChangeToReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementSelected(driver, NOTIFY_REQUESTER_ON_CHANGE_TO_REQ_YES))
		{
			return YES;
		}
		else
		{
			return NO;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToReplaceItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_YES);
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToReplaceItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_NO);
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAllowBuyerToReplaceItemsInReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_REPLACE_ITEM_IN_REQ_YES))
		{
			return YES;
		}
		else
		{
			return NO;
		}
	}

	@Override
	public Integer fillReceivedByQuantity_Minimum(WebDriver driver, String testCaseName, int receivedByQuantityMin) throws ActionBotException
	{
		String receivedByQuantity_min = Integer.toString(receivedByQuantityMin);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN_BY_VALUE, receivedByQuantity_min);
		ScreenShot.screenshot(driver, testCaseName, "After filling received by quantity minimum value");

		receivedByQuantity_min = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_min);

	}

	@Override
	public Integer fillReceivedByQuantity_Maximum(WebDriver driver, String testCaseName, int receivedByQuantityMax) throws ActionBotException
	{
		String receivedByQuantity_max = Integer.toString(receivedByQuantityMax);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE, receivedByQuantity_max);
		ScreenShot.screenshot(driver, testCaseName, "After filling received by quantity maximum value");

		receivedByQuantity_max = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_max);
	}

	@Override
	public Integer getReceivedByQuantity_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receivedByQuantity_min;
		ScreenShot.screenshot(driver, testCaseName, "Received by quantity minimum value");

		receivedByQuantity_min = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_min);
	}

	@Override
	public Integer getReceivedByQuantity_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receivedByQuantity_max;
		ScreenShot.screenshot(driver, testCaseName, "Received by quantity maximum value");

		receivedByQuantity_max = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_max);
	}

	@Override
	public Integer fillReceivedByAmount_Minimum(WebDriver driver, String testCaseName, int receivedByAmountMin) throws ActionBotException
	{
		String receivedByAmount_min = Integer.toString(receivedByAmountMin);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MIN_BY_VALUE, receivedByAmount_min);
		ScreenShot.screenshot(driver, testCaseName, "After filling received by amount minimum value");

		receivedByAmount_min = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByAmount_min);
	}

	@Override
	public Integer fillReceivedByAmount_Maximum(WebDriver driver, String testCaseName, int receivedByAmountMax) throws ActionBotException
	{
		String receivedByAmount_max = Integer.toString(receivedByAmountMax);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MAX_BY_VALUE, receivedByAmount_max);
		ScreenShot.screenshot(driver, testCaseName, "After filling received by amount maximum value");

		receivedByAmount_max = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByAmount_max);
	}

	@Override
	public Integer getReceivedByAmount_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receivedByQuantity_min;
		ScreenShot.screenshot(driver, testCaseName, "Received by amount minimum value");

		receivedByQuantity_min = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_min);
	}

	@Override
	public Integer getReceivedByAmount_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receivedByQuantity_max;
		ScreenShot.screenshot(driver, testCaseName, "Received by amount maximum value");

		receivedByQuantity_max = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_AMOUNT_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(receivedByQuantity_max);
	}

	@Override
	public Integer fillPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName, int minPriceSubTotalOfNonCatalogItems) throws ActionBotException
	{
		String min_PriceSubTotalOfNonCatalogItems = Integer.toString(minPriceSubTotalOfNonCatalogItems);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MIN_BY_VALUE, min_PriceSubTotalOfNonCatalogItems);
		ScreenShot.screenshot(driver, testCaseName, "After filling price sub total of non catalog items");

		min_PriceSubTotalOfNonCatalogItems = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(min_PriceSubTotalOfNonCatalogItems);
	}

	@Override
	public Integer fillPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName, int maxPriceSubTotalOfNonCatalogItems) throws ActionBotException
	{
		String max_PriceSubTotalOfNonCatalogItems = Integer.toString(maxPriceSubTotalOfNonCatalogItems);

		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MAX_BY_VALUE, max_PriceSubTotalOfNonCatalogItems);
		ScreenShot.screenshot(driver, testCaseName, "After filling price sub total of non catalog items");

		max_PriceSubTotalOfNonCatalogItems = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(max_PriceSubTotalOfNonCatalogItems);
	}

	@Override
	public Integer getPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Minimum price sub total of non catalog items");
		String min_PriceSubTotalOfNonCatalogItems = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MIN_BY_VALUE).getAttribute("value");

		return Integer.parseInt(min_PriceSubTotalOfNonCatalogItems);
	}

	@Override
	public Integer getPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Maximum price sub total of non catalog items");
		String max_PriceSubTotalOfNonCatalogItems = ActionBot.findElement(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_NON_CATALOG_MAX_BY_VALUE).getAttribute("value");

		return Integer.parseInt(max_PriceSubTotalOfNonCatalogItems);
	}

	@Override
	public boolean clickSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_SAVE_BUTTON);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUYERS_DESK_SETTING_SUCCESS_MSG))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean clickCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_CANCEL_BUTTON);
		ActionBot.defaultSleep();
		return true;
	}

	@Override
	public Integer fillAllowBuyerItemRcvByQuantityTextBox(WebDriver driver, String testCaseName, int receivedByQuantity) throws ActionBotException
	{
		String quantityAmount = Integer.toString(receivedByQuantity);

		ActionBot.sendKeys(driver, BUYERS_DESK_SETTING__ITEM_RECIEVED_BY_QUANTITY, quantityAmount);
		ScreenShot.screenshot(driver, testCaseName, "After filling price ");

		quantityAmount = ActionBot.findElement(driver, BUYERS_DESK_SETTING__ITEM_RECIEVED_BY_QUANTITY).getAttribute("value");

		return Integer.parseInt(quantityAmount);
	}

	@Override
	public Integer fillPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName, int PriceSubTotalOfCatalogItems) throws ActionBotException
	{
		ActionBot.sendKeys(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MAX_BY_VALUE, "" + PriceSubTotalOfCatalogItems);
		String str = ActionBot.getTextWithInElement(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MAX_BY_VALUE);
		if (str != null)
		{
			int i = Integer.parseInt(str);
			return i;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clearPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, ALLOW_BUYER_TO_CHANGE_PRICE_SUBTOTAL_OF_CATALOG_MAX_BY_VALUE);

	}

	@Override
	public void clearQuantitySubTotalReceivedByQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, ALLOW_BUYER_TO_CHANGE_QUANTIY_WHEN_RECIEVED_BY_QTY_MAX_BY_VALUE);

	}

	@Override
	public boolean clickOnAllowBuyerToAddItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_YES);
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToAddItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_NO);
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_ADD_ITEM_IN_REQ_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowPR_Smaller(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ALLOW_PR_SMALLER);
		if (ActionBot.isElementSelected(driver, RADIO_BUTTON_ALLOW_PR_SMALLER))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clickOnAllowPR_Larger(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ALLOW_PR_LARGER);
		if (ActionBot.isElementSelected(driver, RADIO_BUTTON_ALLOW_PR_LARGER))
		{
			return true;
		}
		return false;
	}

	@Override
	public String enterAllowPr_TotalAmount(WebDriver driver, String testCaseName, String prTotalAmount) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ALLOW_PR_PERCENT_OF_TOTAL_AMOUNT);
		ActionBot.sendKeys(driver, TEXT_ALLOW_PR_PERCENT_OF_TOTAL_AMOUNT, prTotalAmount);
		return prTotalAmount;
	}

	@Override
	public String enterAllowPr_CurrencyUnits(WebDriver driver, String testCaseName, String prCurrencyUnits) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ALLOW_PR_CURRENCY_UNITS);
		ActionBot.sendKeys(driver, TEXT_ALLOW_PR_CURRENCY_UNITS, prCurrencyUnits);
		return prCurrencyUnits;
	}

	@Override
	public void clearAllowPr_TotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ALLOW_PR_PERCENT_OF_TOTAL_AMOUNT);
	}

	@Override
	public void clearAllowPr_CurrencyUnits(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ALLOW_PR_CURRENCY_UNITS);
	}

	@Override
	public void clearItemReceivedByAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ITEM_RECEIVED_BY_AMOUNT);
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_SAVE_BUTTON);
	}

	@Override
	public String enterItemReceivedByAmount(WebDriver driver, String testCaseName, String itemAmount) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_ITEM_RECEIVED_BY_AMOUNT);
		ActionBot.sendKeys(driver, TEXT_ITEM_RECEIVED_BY_AMOUNT, itemAmount);
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_SAVE_BUTTON);
		return itemAmount;
	}

	@Override
	public void clearPriceControlVirtualItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_PRICE_CONTROL_VIRTUAL_ITEM);
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_SAVE_BUTTON);
	}

	@Override
	public String enterPriceControlVirtualItem(WebDriver driver, String testCaseName, String priceControlValue) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_PRICE_CONTROL_VIRTUAL_ITEM, priceControlValue);
		ActionBot.click(driver, BUYERS_DESK_SETTINGS_SAVE_BUTTON);
		return priceControlValue;
	}

	@Override
	public boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_YES);
		return ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_YES);
	}

	@Override
	public boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_NO);
		return ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_SUBMIT_REQUISITION_WITHOUT_SAVING_AS_DRAFT_NO);
	}

}
