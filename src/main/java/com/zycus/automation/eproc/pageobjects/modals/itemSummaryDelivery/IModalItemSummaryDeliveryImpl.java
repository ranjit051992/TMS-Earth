package com.zycus.automation.eproc.pageobjects.modals.itemSummaryDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalItemSummaryDeliveryImpl implements IModalItemSummaryDelivery
{
	static Logger logger = Logger.getLogger(IModalItemSummaryDeliveryImpl.class);

	@Override
	public String fillRequiredByDateAtItemLevel(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, REQ_BY_DATE_ITEM_LEVEL);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQ_BY_DATE_ITEM_LEVEL).getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		return requiredByDate;
	}

	@Override
	public void clickOnItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_DELIVERY_TAB);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delivery tab");

	}

	@Override
	public boolean isCreateAssetTagForThisItemCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
	}

	@Override
	public boolean isCreateAssetTagForThisItemCheckboxEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
	}

	@Override
	public String getValueOFCreateAssetTagForThisItemCheckboxLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
		logger.info("Label Value : " + labelValue);
		return labelValue;
	}

	@Override
	public void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY);
	}

	@Override
	public String fillFirstAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException
	{
		String enteredValue = ActionBot.sendKeys(driver, TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY, assetNo);
		logger.info("Entered Asset No : " + enteredValue);
		return enteredValue;
	}

	@Override
	public String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manuSrNo) throws ActionBotException
	{
		String enteredValue = ActionBot.sendKeys(driver, TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY, manuSrNo);
		logger.info("Entered Manufacturer Sr No : " + enteredValue);
		return enteredValue;
	}

	@Override
	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		String enteredValue = ActionBot.sendKeys(driver, TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY, notes);
		logger.info("Entered Notes : " + enteredValue);
		return enteredValue;
	}

	@Override
	public String getAssetNoError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String error = ActionBot.getAttributeOfElement(driver, ERROR_ICON_ASSET_NO_REQUIRED, "title");
		logger.info("Error Message : " + error);
		return error;
	}

	@Override
	public String changeDeliveryOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException
	{
		String address1 = null;
		if (!ActionBot.isElementSelected(driver, DELIVERY_MYADDRESS_RADIO_BUTTON))
		{

			ActionBot.click(driver, DELIVERY_MYADDRESS_RADIO_BUTTON);
			address1 = ActionBot.fillAutoCompleteField(driver, PO_OTHER_ADDRESS, address);

		}
		return address1;
	}

}
