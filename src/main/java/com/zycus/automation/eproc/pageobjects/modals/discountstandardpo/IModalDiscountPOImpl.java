package com.zycus.automation.eproc.pageobjects.modals.discountstandardpo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalDiscountPOImpl implements IModalDiscountPO
{

	@Override
	public Integer fillDiscountAmount(WebDriver driver, String testCaseName, int discount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DISCOUNT_AMOUNT, "" + discount);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_DISCOUNT_AMOUNT);
		int no = Integer.parseInt(str);
		ScreenShot.screenshot(driver, testCaseName, "After entering discount amount");
		return no;
	}

	@Override
	public void clickOnSaveDiscount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_DISCOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save");

	}

	@Override
	public Integer getDiscountedPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str1 = ActionBot.getTextWithInElement(driver, DISCOUNTED_PRICE);
		int number = Integer.parseInt(str1);
		return number;
	}

	@Override
	public boolean isDiscountedPriceEqualToDiscountedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_AMOUNT);
		int discountedAmount = Integer.parseInt(str);
		String str1 = ActionBot.getTextWithInElement(driver, DISCOUNTED_PRICE);
		int discountedPrice = Integer.parseInt(str1);
		if (discountedPrice == discountedAmount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ITEM_LEVEL_DISCOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item level discount");

	}

	@Override
	public String selectItemLevelDiscountType(WebDriver driver, String testCaseName, String type) throws ActionBotException
	{
		String discount_type;

		Select select = new Select(ActionBot.findElement(driver, SELECT_ITEM_LEVEL_DISCOUNT_TYPE));
		select.selectByVisibleText(type);

		ScreenShot.screenshot(driver, testCaseName, "After selecting discount type");

		discount_type = select.getFirstSelectedOption().getText().trim();
		return discount_type;
	}

	@Override
	public Integer enterItemLevelDiscountValue(WebDriver driver, String testCaseName, int value) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE);
		ActionBot.sendKeys(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE, "" + value);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE);
		int no = Integer.parseInt(str);
		return no;
	}

	@Override
	public void clickOnItemLevelTotalDiscount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_AMOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on total amount");

	}

	@Override
	public Double getItemLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_AMOUNT);
		str = str.replaceAll("[^0-9.]", "");
		double discountedAmount = Double.parseDouble(str);
		return discountedAmount;
	}

	@Override
	public Double getHeaderLevelTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str1 = ActionBot.getTextWithInElement(driver, DISCOUNTED_PRICE);
		str1 = str1.replaceAll("[^0-9.]", "");
		double discountedPrice = Double.parseDouble(str1);
		return discountedPrice;
	}

	@Override
	public boolean isTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemLevelTotalDiscountAmountCannotBeGreaterItemSubTotalmsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TOTAL_DISCOUNT_CANNOT_BE_GREATER_ITEM_SUB_TOTAL_MSG_ITEM_LEVEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnDiscountModalCancelLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_MODAL_DISCOUNT);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isAlertInDiscountPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ALERT_DISCOUNT_MODAL_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isHeaderLevelDiscountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ICON_DISCOUNT_MORE_THEN_ITEM_PRICE_HEADER_LEVEL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isHeaderLevelDiscountErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, ERROR_ICON_DISCOUNT_MORE_THEN_ITEM_PRICE_HEADER_LEVEL);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, ERROR_MESSAGE_DISCOUNT_MORE_THEN_ITEM_PRICE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isItemLevelErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ICON_ITEM_LEVEL_DISCOUNT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isApplyToAllErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_APPLY_TO_ALL_ITEM_LEVEL_DISCOUNT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Integer fillApplyToAllDiscount(WebDriver driver, String testCaseName, int discount) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_APPLY_TO_ALL_DISCOUNT);
		ActionBot.sendKeys(driver, TEXTBOX_APPLY_TO_ALL_DISCOUNT, "" + discount);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_APPLY_TO_ALL_DISCOUNT);
		int no = Integer.parseInt(str);
		return no;
	}

	@Override
	public void clickOnApplyToAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPLY_TO_ALL_DISCOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on apply to all link");

	}

	@Override
	public String getTotalPoAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poTotal = ActionBot.getTextWithInElement(driver, TOTAL_PO_AMOUNT);
		return poTotal;
	}

	@Override
	public void clickOnDiscountOnEntireOrder(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_DISCOUNT_ON_ENTIRE_ORDER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on entire order discount radio button");

	}

	@Override
	public boolean isAlertOfHeaderLevelDiscountNotAllowedPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ALERT_DISCOUNT_AT_HEADER_LEVEL_NOT_ALLOWED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String selectItemLevelDiscountIndexwise(WebDriver driver, String testCaseName, int index, String discountType) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, SELECT_ITEM_LEVEL_DISCOUNT_TYPE);
		Select select = new Select(elements.get(index - 1));
		select.selectByVisibleText(discountType);
		ScreenShot.screenshot(driver, testCaseName, "After selecting discount type");
		discountType = select.getFirstSelectedOption().getText().trim();
		return discountType;
	}

	@Override
	public void fillItemLevelDiscountValueIndexwise(WebDriver driver, String testCaseName, int index, int discountValue) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, TEXTBOX_ITEM_LEVEL_DISCOUNT_VALUE);
		elements.get(index - 1).clear();
		elements.get(index - 1).sendKeys(Integer.toString(discountValue));

	}
}
