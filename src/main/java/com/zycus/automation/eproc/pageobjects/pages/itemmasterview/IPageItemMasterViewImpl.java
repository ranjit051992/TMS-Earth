package com.zycus.automation.eproc.pageobjects.pages.itemmasterview;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageItemMasterViewImpl implements IPageItemMasterView
{

	@Override
	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LINK_ITEM_NAMES_VIEW_CATALOG);
		List<String> itemNames = new ArrayList<String>();
		for (WebElement element : elements)
		{
			itemNames.add(element.getText().trim());
		}
		return itemNames;
	}

	@Override
	public void clickOnFirstItem(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCaseName, "Before clicking first item");
			ActionBot.click(driver, ITEM_MASTER_FIRST_ITEM_LINK);
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCaseName, "After clicking first item");
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public int getSupplierCountOfFirstItem(WebDriver driver, String testCaseName)
	{
		try
		{
			return Integer.parseInt(ActionBot.getTextWithInElement(driver, SUPPLIER_COUNT_OF_FIRST_ITEM));
		}
		catch (NumberFormatException | ActionBotException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void clickOnSupplierCountLink(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, SUPPLIER_COUNT_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemNameLink(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, ITEM_NAME_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnViewScopeLink(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VIEW_SCOPE_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public boolean isSupplierCountLinkPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.moveToElement(driver, SUPPLIER_COUNT_LINK);
			return ActionBot.isElementPresent(driver, SUPPLIER_COUNT_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isItemNameLinkPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.moveToElement(driver, ITEM_NAME_LINK);
			return ActionBot.isElementPresent(driver, ITEM_NAME_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isViewScopeLinkPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.moveToElement(driver, VIEW_SCOPE_LINK);
			return ActionBot.isElementPresent(driver, VIEW_SCOPE_LINK);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getViewScopePopUpHeaderName(WebDriver driver, String testCaseName)
	{
		try
		{
			System.out.println(VIEW_SCOPE_POP_UP_HEADER.getBy());
			return ActionBot.getTextWithInElement(driver, VIEW_SCOPE_POP_UP_HEADER);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void clickOnCloseButton(WebDriver driver, String testCaseName)
	{

		try
		{
			ActionBot.click(driver, VIEW_SCOPE_POP_UP_CLOSE_BUTTON);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public boolean isCloseButtonPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_SCOPE_POP_UP_CLOSE_BUTTON);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isSupplierNameColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_SUPPLIER_NAME);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAddedOnColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_ADDED_ON);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isLastUpdatedOnColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_LAST_UPDATED_ON);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isValidityColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_VALIDITY);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isCurrencyColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_PRICE_CURRENCY);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isScopeColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_SCOPE);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isActiveColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_ACTIVE);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isStatusColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, VIEW_DETAILS_STATUS);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getValidityValue(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.moveToElement(driver, VALIDITY_VALUE);
			return ActionBot.getTextWithInElement(driver, VALIDITY_VALUE);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//under items tab
	@Override
	public boolean isItemStatusColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, STATUS_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemERPPartNoColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, ERP_PART_NO_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemManufacturePartIdColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, MANUFACTURE_PART_ID_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemNameColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, ITEM_NAME_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemCategoryNameColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, CATEGORY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemSupplierCountColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, SUPPLIER_COUNT_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemCurrencyColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, CURRENCY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isItemMarketPriceColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, MARKET_PRICE_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemUOMColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, UOM_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean isItemActionsColumnPresent(WebDriver driver, String testCaseName)
	{
		try
		{
			return ActionBot.isElementPresent(driver, ACTIONS_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void clickOnItemStatusColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_STATUS_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemERPPartNoColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_ERP_PART_NO_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemManufacturePartIdColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_MANUFACTURE_PART_ID_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemNameColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_ITEM_NAME_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemCategoryNameColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_CATEGORY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemSupplierCountColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_SUPPLIER_COUNT_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemCurrencyColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_CURRENCY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemMarketPriceColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_MARKET_PRICE_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemUOMColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_UOM_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnItemActionsColumn(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, VALUE_ACTIONS_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getValueOfItemERPPartNoColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_ERP_PART_NO_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemManufacturePartIdColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_MARKET_PRICE_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemNameColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_ITEM_NAME_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemCategoryNameColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_CATEGORY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemSupplierCountColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_SUPPLIER_COUNT_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemCurrencyColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_CURRENCY_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemMarketPriceColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_MARKET_PRICE_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemUOMColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_UOM_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getValueOfItemActionsColumn(WebDriver driver, String testCaseName)
	{
		String value = "";
		try
		{
			value = ActionBot.getTextWithInElement(driver, VALUE_ACTIONS_COLUMN);
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
