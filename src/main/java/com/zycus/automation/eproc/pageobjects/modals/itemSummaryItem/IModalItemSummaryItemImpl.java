package com.zycus.automation.eproc.pageobjects.modals.itemSummaryItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.IPageViewPurchaseOrder;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemSummaryItemImpl implements IModalItemSummaryItem
{

	@Override
	public Integer clearAndEnterQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY);
		ActionBot.clear(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY);
		ActionBot.sendKeys(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY, "" + quantity);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY);
		if (temp != null)
		{
			int no = Integer.parseInt(temp);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int getQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.findElements(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY);
		String quantity = ActionBot.getTextWithInElement(driver, TEXTBOX_QUANTITY_ITEM_SUMMARY);
		if (quantity != null)
		{
			int number = Integer.parseInt(quantity);
			return number;
		}
		return 0;
	}

	@Override
	public String getModalItemContractNo(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CONTRACT_NO))
		{
			return ActionBot.getTextWithInElement(driver, TEXTBOX_CONTRACT_NO);
		}
		if (ActionBot.isElementDisplayed(driver, MODAL_ITEM_CONTRACT_NO))
		{
			return ActionBot.findElement(driver, MODAL_ITEM_CONTRACT_NO).getAttribute("value");
		}
		else if (ActionBot.isElementDisplayed(driver, By.xpath(MODAL_ITEM_CONTRACT_NO.getValue() + "/..")))
		{
			return ActionBot.getTextWithInElement(driver, By.xpath(MODAL_ITEM_CONTRACT_NO.getValue() + "/.."));
		}
		return null;
	}

	@Override
	public String fillModalItemContractNo(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException
	{
		/*
		 * ActionBot.clear(driver, MODAL_ITEM_CONTRACT_NO);
		 * ActionBot.defaultSleep();
		 */
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CONTRACT_NO))
		{
			ActionBot.sendKeys(driver, TEXTBOX_CONTRACT_NO, contractNo);
			return contractNo;
		}
		if (ActionBot.isElementDisplayed(driver, MODAL_ITEM_CONTRACT_NO))
		{
			ActionBot.sendKeys(driver, MODAL_ITEM_CONTRACT_NO, contractNo);
			return contractNo;
		}
		else
		{
			return null;
		}

	}

	@Override
	public void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_ITEM_DETAILS_TAB);

	}

	@Override
	public String getModalItemCurrencylabel(WebDriver driver) throws ActionBotException
	{
		// return ActionBot.getTextWithInElement(driver,
		// MODAL_ITEM_PRICE_CURRENCY_LABEL);
		WebElement element = ActionBot.findElements(driver, MODAL_ITEM_PRICE_CURRENCY_LABEL).get(0);
		return element.getText();

	}

	@Override
	public float clearAndEnterMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException
	{
		ActionBot.findElement(driver, IPageViewPurchaseOrder.TEXT_GET_MARKET_PRICE_AMEND_PO);
		ActionBot.clear(driver, IPageViewPurchaseOrder.TEXT_GET_MARKET_PRICE_AMEND_PO);
		ActionBot.sendKeys(driver, IPageViewPurchaseOrder.TEXT_GET_MARKET_PRICE_AMEND_PO, "" + marketPrice);
		String temp = ActionBot.getTextWithInElement(driver, IPageViewPurchaseOrder.TEXT_GET_MARKET_PRICE_AMEND_PO);
		if (temp != null)
		{
			return Float.parseFloat(temp);
		}
		else
		{
			return 0f;
		}
	}

	@Override
	public float getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String marketPrice = ActionBot.getTextWithInElement(driver, IPageViewPurchaseOrder.TEXT_GET_MARKET_PRICE_AMEND_PO);
		if (marketPrice != null)
		{
			return Float.parseFloat(marketPrice);
		}
		return 0;
	}

}
