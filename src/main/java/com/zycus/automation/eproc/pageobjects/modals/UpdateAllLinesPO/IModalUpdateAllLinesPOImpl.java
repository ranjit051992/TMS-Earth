package com.zycus.automation.eproc.pageobjects.modals.UpdateAllLinesPO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalUpdateAllLinesPOImpl implements IModalUpdateAllLinesPO
{

	static Logger	logger	= Logger.getLogger(IModalUpdateAllLinesPOImpl.class);
	int				i		= 0;

	@Override
	public void clickOnDropdownTaxType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DROPDOWN_TAX_TYPE_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on tax type");
	}

	@Override
	public String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{

		/*
		 * String tax_type = null; if (i < 5) {
		 * 
		 * i++; WebElement element = ActionBot.findElement( driver,
		 * By.xpath(".//*[@id='applyToMultipleTax']//tr[" + index +
		 * "]//select[@class='inptSlct dev_input dev_selectTaxType']")); Select
		 * select = new Select(element); select.selectByVisibleText(taxType);
		 * 
		 * ScreenShot.screenshot(driver, testCaseName,
		 * "After selecting tax type");
		 * 
		 * tax_type = select.getFirstSelectedOption().getText().trim();
		 * 
		 * if (tax_type.trim().endsWith(taxType)) { return tax_type; } else {
		 * 
		 * return selectTaxType(driver, testCaseName, taxType, index); } } else
		 * { i = 0; }
		 */

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='applyToMultipleTax']//tr[" + index + "]//*[contains(@class,'dev_inputTaxType')]"));
		ActionBot.fillAutoCompleteField(driver, ele, taxType);
		return taxType;
	}

	@Override
	public String fillTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException
	{

		String tax = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_TAX_NAME_UPDATE_ALL_LINES))
		{
			WebElement ele = ActionBot.findElement(driver,
				By.xpath(".//*[@id='applyToMultipleTax']//tr[" + index + "]//input[@class='inptTxt dev_input dev_txtTaxName ui-autocomplete-input']"));
			ele.clear();
			ele.sendKeys(taxName);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			ActionBot.defaultSleep();
			tax = ele.getAttribute("value").trim();
			ScreenShot.screenshot(driver, testCaseName, "After getting tax name");

		}
		return tax;
	}

	@Override
	public void clickOnApplyTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_APPLY_TAX);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on apply tax");
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnRadioButtonTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_TAX_NOT_APPLICABLE);

	}

	@Override
	public float fillTaxRate(WebDriver driver, String testCaseName, float taxRate) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_TAX_RATE_UPDATE_ALL_LINES);
		ActionBot.sendKeys(driver, TEXTBOX_TAX_RATE_UPDATE_ALL_LINES, "" + taxRate);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_TAX_RATE_UPDATE_ALL_LINES);
		if (temp != null)
		{
			float tax_rate = Float.parseFloat(temp);
			return tax_rate;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clickOnApplyWhereApplicableAndNotDefined(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_APPLY_WHERE_APPLICABLE_AND_NOT_DEFINED);

	}

	@Override
	public void clickOnOverrrideWhereDefined(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_OVERRIDE_WHERE_DEFINED);

	}

	@Override
	public void clickOnRemoveAllMultipleTaxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REMOVE_ALL_MULTIPLE_TAXES_UPDATE_ALL_LINES);

	}

	@Override
	public boolean isRemoveAllMultipleTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_REMOVE_ALL_MULTIPLE_TAXES_UPDATE_ALL_LINES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_UPDATE_ALL_LINES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void hoverOnErrorIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, ERROR_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAddTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_TAX_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ADD_TAX_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnRemoveTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_REMOVE_TAX_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_REMOVE_TAX_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isAddTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_TAX_UPDATE_ALL_LINES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isRemoveTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_REMOVE_TAX_UPDATE_ALL_LINES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTooltipForTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TOOLTIP_TAXES_UPDATE_ALL_LINES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void hoverOnTooltipTaxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, TOOLTIP_TAXES_UPDATE_ALL_LINES);

	}

	@Override
	public boolean isErrorTooltipiconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, UPDATE_ALL_LINE_ITEM_ERROR_TOOLTIP_ICON))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnCloseUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_UPDATE_ALL_LINE_MODAL);

	}

	@Override
	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{
		String taxtype = null;
		WebElement element = ActionBot.findElement(driver, By.xpath(TAX_TYPE_UPDATE_ALL_LINES.getValue() + "[" + index + "]"));
		taxtype = ActionBot.fillAutoCompleteField(driver, element, taxType);
		logger.info("Tax type is :" + taxtype);
		return taxtype;
	}

}
