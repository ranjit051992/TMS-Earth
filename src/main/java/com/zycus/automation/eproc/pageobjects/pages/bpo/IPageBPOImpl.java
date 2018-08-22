/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.bpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageBPOImpl implements IPageBPO
{

	Logger logger = Logger.getLogger(IPageBPOImpl.class);

	@Override
	public String fillOrderValue(WebDriver driver, String testCaseName, String orderValue) throws ActionBotException
	{
		//uncheck auto update
		if (ActionBot.isElementSelected(driver, CHECKBOX_AUTO_UPDATE_ORDER_VALUE))
		{
			clickOnAutoUpdate(driver, testCaseName);
		}
		String enteredOrderValue = ActionBot.sendKeys(driver, TEXTBOX_ORDER_VALUE, orderValue);
		logger.info("Entered Order Value : " + enteredOrderValue);
		return enteredOrderValue;
	}

	@Override
	public boolean clickOnAutoUpdate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_AUTO_UPDATE_ORDER_VALUE);
		return ActionBot.isElementSelected(driver, CHECKBOX_AUTO_UPDATE_ORDER_VALUE);
	}

	@Override
	public void clickOnDatePickerOfFromValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DATEPICKER_FROM_VALIDITY_BPO_AGREEMENT_DETAILS);
	}

	@Override
	public void clickOnDatePickerOfToValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.click(driver,
		// DATEPICKER_TO_VALIDITY_BPO_AGREEMENT_DETAILS);
		WebElement element = driver.findElement(By.xpath(".//*[@id='txtValidityToDate']/parent::div/img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	}

	@Override
	public void clickOnDatePickerOfUntilValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DATEPICKER_VALIDITY_UNTIL_BPO_AGREEMENT_DETAILS);
	}

	@Override
	public String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fromValidityDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS, "value");
		logger.info("Selected from validity date : " + fromValidityDate);
		return fromValidityDate;
	}

	@Override
	public String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String toValidityDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_VALIDITY_TO_DATE_BPO_AGREEMENT_DETAILS, "value");
		logger.info("Selected to validity date : " + toValidityDate);
		return toValidityDate;
	}

	@Override
	public String getUntilValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String untilValidityDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_VALIDITY_UNTIL_DATE_BPO_AGREEMENT_DETAILS, "value");
		logger.info("Selected until validity date : " + untilValidityDate);
		return untilValidityDate;
	}

	@Override
	public void clickOnPreventItemsOfOtherCategoryToBeOdredred(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PREVENT_ORDER_OF_ITEMS_OF_OTHER_CATEGORIES);
	}

	@Override
	public void clickOnPreventChangingPartNoAndItemDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PREVENT_CHANGE_OFPART_NO_AND_ITEM_DESCRIPTION);
	}

	@Override
	public void clickOnPreventExceedingBPOValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PREVENT_EXCEEDING_BPO_VALUE);
	}

	@Override
	public void clickOnRequireReceiptAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_REQUIRE_RECEIPT_AGAINST_BPO);
	}

	@Override
	public String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String orderValue = ActionBot.getAttributeOfElement(driver, TEXTBOX_ORDER_VALUE, "value");
		logger.info("Entered Order Value : " + orderValue);
		return orderValue;
	}

	@Override
	public String selectFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		clickOnDatePickerOfFromValidity(driver, testCaseName);
		ActionBot.selectDate(driver, day, month, year);
		return getFromValidityDate(driver, testCaseName);
	}

	@Override
	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		clickOnDatePickerOfToValidity(driver, testCaseName);
		ActionBot.selectDate(driver, day, month, year);
		return getToValidityDate(driver, testCaseName);
	}

	@Override
	public String selectUntilValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		clickOnDatePickerOfUntilValidity(driver, testCaseName);
		ActionBot.selectDate(driver, day, month, year);
		return getUntilValidityDate(driver, testCaseName);
	}

	@Override
	public void clickOnPreventExceedingTheBlanketOrderCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PREVENT_EXCEEDING_BLANKET_ORDER_VALUE_SETTINGS);

	}

	@Override
	public void clickOnPreventChangingPartNoCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PREVENT_CHANGING_PART_NO_SETTINGS);
	}

	@Override
	public void clickOnPreventItemsOfOtherCatagories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PREVENT_ITEMS_OF_THE_OTHER_CATAGORIES_SETTINGS);
	}

	@Override
	public void clickOnRollBackButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ROLLBACK_BPO);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_ROLL_BACK_BPO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on RollBack BPO");
	}

	@Override
	public void clickOnEditItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath(".//tr[.//*[text()='" + itemName + "']]//a[contains(@class,'edit')]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnFirstItemCopyLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_FIRST_ITEM);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isFromValiditydateDisplayedAslabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalAmt = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_AMOUNT_AT_TOP);
		logger.info("Total Amount : " + totalAmt);
		return totalAmt;
	}

	@Override
	public void clickOnOrderTypeRelease(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RADIO_BUTTON_ORDER_TYPE_RELEASE))
		{
			ActionBot.click(driver, RADIO_BUTTON_ORDER_TYPE_RELEASE);
		}
	}

	@Override
	public void clickOnOrderTypeDirectInvoicing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RADIO_BUTTON_ORDER_TYPE_DIRECT_INVOICE))
		{
			ActionBot.click(driver, RADIO_BUTTON_ORDER_TYPE_DIRECT_INVOICE);
		}
	}

	@Override
	public void clickOnAlertPopUpTaxesIfDefinedOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ALERT_POPUP_TAXES_IF_DEFINED_OK_BUTTON))
		{
			ActionBot.click(driver, ALERT_POPUP_TAXES_IF_DEFINED_OK_BUTTON);
		}
	}

}
