package com.zycus.automation.eproc.pageobjects.modals.itemSummaryTax;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalItemSummaryTaxImpl implements IModalItemSummaryTax
{
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CommonServices.class);

	@Override
	public String selectTaxType(WebDriver driver, String testCaseName, String selectBy, String value, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElements(driver, MODAL_ITEM_SUMMARY_SELECT_TAX).get(index);
		return ActionBot.selectElement(driver, element, selectBy, value);
	}

	@Override
	public String fillTaxAmount(WebDriver driver, String testCaseName, String taxAmount) throws ActionBotException
	{
		ActionBot.clear(driver, MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT);
		ActionBot.sendKeys(driver, MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT, taxAmount);
		return taxAmount;
	}

	@Override
	public String getTaxrate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxRate = null;
		taxRate = ActionBot.findElement(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE).getAttribute("value");
		return taxRate;

	}

	@Override
	public String fillTaxName(WebDriver driver, String testCaseName, String taxName) throws ActionBotException
	{
		String enteredtaxName = null;
		if (ActionBot.isElementPresent(driver, MODAL_ITEM_SUMMARY_SELECT_TAXNAME))
		{
			WebElement element = ActionBot.findElement(driver, MODAL_ITEM_SUMMARY_SELECT_TAXNAME);
			element.clear();
			element.sendKeys(taxName);
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);

			enteredtaxName = element.getAttribute("value");

		}
		return enteredtaxName;

	}

	@Override
	public void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_TAXES_TAB);
	}

	@Override
	public void clickOnAddNewTaxbtn(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='poItemTaxes']//tr[" + index + "]//a[contains(@class,'addTax')]"));

	}

	@Override
	public boolean isTaxSubTotalDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, MODAL_ITEM_TAX_SUB_TOTAL))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fillTaxRate(WebDriver driver, String testCaseName, String taxRate) throws ActionBotException
	{
		ActionBot.clear(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE);
		ActionBot.sendKeys(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE, taxRate);
		ActionBot.defaultSleep();
		String tax = ActionBot.getTextWithInElement(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE);
		return tax;
	}

	@Override
	public void clickOnTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT);

	}

	@Override
	public String selectTaxTypeOfItemLevelTax(WebDriver driver, String testCaseName, String taxType) throws ActionBotException
	{

		/*
		 * Select select = new Select(ActionBot.findElement(driver,
		 * MODAL_ITEM_SUMMARY_SELECT_TAX));
		 * 
		 * select.selectByVisibleText(taxType); ScreenShot.screenshot(driver,
		 * testCaseName, "After selecting compound tax type");
		 * 
		 * String tax_type = select.getFirstSelectedOption().getText().trim();
		 */

		ActionBot.fillAutoCompleteField(driver, MODAL_ITEM_SUMMARY_SELECT_TAX, taxType);

		return taxType;
	}

	@Override
	public boolean isErrorOnItemlevelTaxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ITEM_LEVEL_TAX_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clearTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE);

	}

	@Override
	public void clearTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_SELECT_TAXRATE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnRemoveTaxItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_REMOVE_ITEM_LEVEL_TAXES);

	}

	@Override
	public String selectNextRowTaxTye(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{
		/*
		 * Select select = new Select(ActionBot.findElement( driver,
		 * By.xpath(".//*[@id='poItemTaxes']//tr[" + index +
		 * "]//*[contains(@class,'dev_inputTaxType')]")));
		 * 
		 * select.selectByVisibleText(taxType); ScreenShot.screenshot(driver,
		 * testCaseName, "After selecting compound tax type");
		 * 
		 * String tax_type = select.getFirstSelectedOption().getText().trim();
		 */

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='poItemTaxes']//tr[" + index + "]//*[contains(@class,'dev_inputTaxType')]"));
		ActionBot.fillAutoCompleteField(driver, ele, taxType);
		return taxType;
	}

	@Override
	public String enterNextRowTaxName(WebDriver driver, String testCaseName, String TaxName, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver,
			By.xpath(".//*[@id='poItemTaxes']//tr[" + index + "]//input[@class='inptTxt dev_input dev_txtTaxName ui-autocomplete-input']"));
		ele.clear();
		ele.sendKeys(TaxName);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String enterNextRowTaxRate(WebDriver driver, String testCaseName, String taxRate, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='poItemTaxes']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"));
		ele.clear();
		ele.sendKeys(taxRate);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public void clickOnNextRowTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='poItemTaxes']//tr[" + index + "]//input[@class='inptTxt qtyTxtbx dev_input dev_txtTaxAmount']"));

	}

	@Override
	public String getTaxeName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, MODAL_ITEM_SUMMARY_SELECT_TAXNAME).getAttribute("value");
	}

	@Override
	public boolean isLabelPlusXTaxesFromTheHeaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_PLUS_X_TAXES_FROM_HEADER_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPlusXTaxesFromTheHeaderALabel(WebDriver driver, String testCaseName) throws ActionBotException, Exception
	{
		WebElement element = ActionBot.getElement(driver, LABEL_PLUS_X_TAXES_FROM_HEADER_ITEM_SUMMARY);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("LBL") ? true : false;
		return bl;
	}

	@Override
	public String getUnitItemPriceToApplyTaxOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_UNIT_TOTAL_PRICE_AT_TAX_ITEM_SUMMARY);

	}

	@Override
	public boolean isNegationSignPresentInUnitItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, LABEL_UNIT_TOTAL_PRICE_AT_TAX_ITEM_SUMMARY);
		String str = ActionBot.getTextWithInElement(driver, LABEL_UNIT_TOTAL_PRICE_AT_TAX_ITEM_SUMMARY);
		if (str.contains("-"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTooltipPresentInTaxSection(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TOOLTIP_TAXES_SECTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void hoverOnTooltipOfTaxSection(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, TOOLTIP_TAXES_SECTION);

	}

	@Override
	public boolean isRemovalAllTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, MODAL_ITEM_REMOVE_ALL_TAX_LINK))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, ITEM_MODAL_TAX_CURRENCY_TYPE);
	}

	@Override
	public String getTaxSubTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, MODAL_ITEM_TAX_SUB_TOTAL).getText();
		//steps are commented bcoz price with currency is needed
		//String temp[] = StringUtils.split(str.trim(), " ");
		//String total = temp[1].trim();
		logger.info("The sub total is: " + str);
		return str;
	}

	@Override
	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{
		String TaxType = null;
		WebElement element = ActionBot.findElement(driver, By.xpath(MODAL_ITEM_SUMMARY_SELECT_TAX.getValue() + "[" + index + "]"));
		TaxType = ActionBot.fillAutoCompleteField(driver, element, taxType);
		logger.info("Tax Type is :" + TaxType);
		return TaxType;
	}

	@Override
	public String fillTaxNameByIndex(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException
	{
		String taxname = null;
		WebElement element = ActionBot.findElement(driver, By.xpath(MODAL_ITEM_SUMMARY_SELECT_TAXNAME.getValue() + "[" + index + "]"));
		taxname = ActionBot.fillAutoCompleteField(driver, element, taxName);
		logger.info("Tax name is " + taxname);
		return taxname;
	}

}
