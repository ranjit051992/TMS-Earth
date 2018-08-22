/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poItemView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author amitkumar.dash
 *
 */
public class IModalPoItemViewImpl implements IModalPoItemView
{

	@Override
	public boolean checkIsCatalogItemSame(WebDriver driver, int index) throws ActionBotException
	{

		String catalogitem = ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[13]/div/table/tbody/tr[" + index + "]/td[3]/a")).getText();
		ActionBot.defaultMediumSleep();
		ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[13]/div/table/tbody/tr[" + index + "]/td[3]/a")).click();

		String modalitemdetails = ActionBot.findElement(driver, ITEM_DETAILS).getText();
		if (catalogitem.equalsIgnoreCase(modalitemdetails))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='wrapper']//a[@class='scLnk poItemLink']"));

	}

	@Override
	public boolean isAddtoBasket(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADDTOBASKET))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddtoCart(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADDTOCART))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddtoFavorites(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADDTOFAVORITES))
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
		int catalogitem = ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).getText().length();
		ActionBot.defaultMediumSleep();
		ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).click();

		int modalitemdetails = ActionBot.findElement(driver, ITEM_DETAILS).getText().length();
		if (catalogitem == modalitemdetails)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		String catalogitem = ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[15]/div/table/tbody/tr[" + index + "]/td[3]/a")).getText();
		ActionBot.defaultMediumSleep();
		ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[15]/div/table/tbody/tr[" + index + "]/td[3]/a")).click();

		String modalitemdetails = ActionBot.findElement(driver, ITEM_DETAILS).getText();
		if (catalogitem.equalsIgnoreCase(modalitemdetails))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		String catalogitem = ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).getText();
		ActionBot.defaultMediumSleep();
		ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).click();

		String modalitemdetails = ActionBot.findElement(driver, ITEM_DETAILS).getText();
		if (catalogitem.equalsIgnoreCase(modalitemdetails))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		String catalogitem = ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).getText();
		ActionBot.defaultMediumSleep();
		ActionBot.findElement(driver, By.xpath(".//*[@id='wrapper']//div[14]/div/table/tbody/tr[" + index + "]/td[3]/a")).click();

		String modalitemdetails = ActionBot.findElement(driver, ITEM_DETAILS).getText();
		if (catalogitem.equalsIgnoreCase(modalitemdetails))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isMarketPriceValuePresents(WebDriver driver) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, ITEM_DETAILS_MARKET_PRICE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
