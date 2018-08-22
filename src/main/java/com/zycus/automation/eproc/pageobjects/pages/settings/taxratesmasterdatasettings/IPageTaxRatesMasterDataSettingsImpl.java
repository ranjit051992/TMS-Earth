package com.zycus.automation.eproc.pageobjects.pages.settings.taxratesmasterdatasettings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageTaxRatesMasterDataSettingsImpl implements IPageTaxRatesMasterDataSetings
{

	@Override
	public void clickOnAddTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_TAX_RATE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add tax rate");

	}

	@Override
	public boolean isCityFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_CITY_TAX_RATE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCountyFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_COUNTY_TAX_RATE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean allowToEnterFreeTextCity(WebDriver driver, String testCaseName, String city) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_CITY_TAX_RATE);
		ele.clear();
		ele.sendKeys(city);
		ele.sendKeys(Keys.ENTER);
		if (ActionBot.isElementPresent(driver, AUTOCOMPLETE_CITY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnAddTaxRateBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_TAX_RATE_BUTTON);

	}

	@Override
	public String fillNameTaxRate(WebDriver driver, String testCaseName, String zycustax) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_NAME);
		ele.sendKeys(zycustax);
		String taxName = ActionBot.findElement(driver, TEXTBOX_NAME).getAttribute("value");
		return taxName;
	}

	@Override
	public String fillTaxType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, ADD_TAX_TYPE);
		Select sel = new Select(element);
		sel.selectByIndex(1);
		String taxType = ActionBot.findElement(driver, ADD_TAX_TYPE).getAttribute("value");
		return taxType;
	}

	@Override
	public void fillUniqueCode(WebDriver driver, String testCaseName, int Code) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_UNIQUE_CODE).sendKeys("" + Code);

	}

	@Override
	public void fillTaxRate(WebDriver driver, String testCaseName, int Rate) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_UNIQUE_CODE).sendKeys("" + Rate);
	}

	@Override
	public String fillCountry(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, COUNTRY_DROP_DOWN);
		Select sel = new Select(element);
		sel.selectByIndex(88);
		String country = ActionBot.findElement(driver, COUNTRY_DROP_DOWN).getAttribute("value");
		return country;
	}

	@Override
	public String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxName = ActionBot.findElement(driver, FIRST_TAX_NAME).getText();
		return taxName;
	}

	@Override
	public String getTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String taxRate = ActionBot.findElement(driver, By.xpath(".//*[@id='taxList']//tr[" + index + "]/td[@class='iNum']")).getText();
		return taxRate;
	}

	@Override
	public String SearchTax(WebDriver driver, String testCaseName, String searchTax) throws ActionBotException
	{
		String taxName = ActionBot.sendKeys(driver, SEARCH_TAX_TEXT_BOX, searchTax);
		return taxName;
	}

	@Override
	public void clickOnDeleteTaxLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAX_DELETE_LINK);

	}

	@Override
	public void clickOnDeleteTaxYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAX_DELETE_YES_BUTTON);

	}

	@Override
	public void clickOnTaxEditLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TAX_EDIT_LINK);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//		ActionBot.click(driver, TAX_EDIT_LINK);

	}

	@Override
	public int SelectCountry(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, COUNTRY_DROP_DOWN);
		Select sel = new Select(element);
		sel.selectByIndex(index);
		String country = ActionBot.findElement(driver, COUNTRY_DROP_DOWN).getAttribute("value");
		return index;
	}

	@Override
	public String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException
	{
		return ActionBot.selectElement(driver, TAX_SELECT_OPTION, IConstantsData.SELECT_BY_VISIBLE_TEXT, option);
	}

	@Override
	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAX_BUTTON_GO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on go button");

	}

	@Override
	public String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_CITY_TAX_RATE, city);

	}

	@Override
	public String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_COUNTY_TAX_RATE, county);
	}

	@Override
	public void clickOnApplyThisTaxManuallyBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_APPLY_THIS_TAX_MANUALLY);

	}

	@Override
	public void clickOnApplyThisAutomaticallyBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_APPLY_THIS_TAX_AUTOMATICALLY);

	}

}
