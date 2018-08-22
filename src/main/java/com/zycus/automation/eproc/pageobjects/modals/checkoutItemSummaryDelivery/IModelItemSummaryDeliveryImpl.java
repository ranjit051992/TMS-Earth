package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelItemSummaryDeliveryImpl implements IModelItemSummaryDelivery
{
	static Logger logger = Logger.getLogger(IModelItemSummaryDeliveryImpl.class);

	@Override
	public void clickDeliveryAddMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='delivery_" + itemID + "_" + index + "']//*[@class='icon add']"));
		ScreenShot.screenshot(driver, testCaseName, "Add New Entry");
	}

	@Override
	public void clickDeliveryDeleteMultiSplit(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='delivery_" + itemID + "_" + index + "']//*[@class='icon remove']"));
		ScreenShot.screenshot(driver, testCaseName, "Delete Entry");
	}

	@Override
	public String fillDeliveryMultiSplitAddress(WebDriver driver, String testCaseName, String multiSplitAddress, String itemID, int index) throws ActionBotException
	{
		logger.info("deliver to multi split address :"+multiSplitAddress);
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='location_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiSplitAddress);
		ActionBot.defaultHighSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ARROW_DOWN);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		
		String deliveryAddress = ele.getAttribute("value").trim();
		logger.info("Delivery Address : " + deliveryAddress);

		return deliveryAddress;
	}

	@Override
	public String fillDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String multiSplitDeliverTo, String itemID, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='deliverTo_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiSplitDeliverTo);
		ActionBot.defaultHighSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		
		String deliverTo = ele.getAttribute("value").trim();
		logger.info("Deliver To : " + deliverTo);
		return deliverTo;
	}

	@Override
	public int fillDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, int multiSplitQuantity, String itemID, int index) throws ActionBotException
	{
		String quantity = Integer.toString(multiSplitQuantity);
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='quantity_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(quantity);
		quantity = ele.getAttribute("value").trim();
		logger.info("Delivery split Quantity : " + quantity);
		ScreenShot.screenshot(driver, testCaseName, "After editing delievry split quantity");

		return Integer.parseInt(quantity);
	}

	@Override
	public String getDeliveryMultiSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String amt = ActionBot.findElement(driver, By.xpath(".//*[@id='price_" + itemID + "_" + index + "']")).getText();
		logger.info("Amount : " + amt);
		return amt;
	}

	@Override
	public String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String date = ActionBot.findElement(driver, By.xpath(".//*[@id='deliveryOn_" + itemID + "_" + index + "']")).getAttribute("value");
		logger.info("Delivery Date : " + date);
		return date;
	}

	@Override
	public String getDeliverySingleSplitDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverTo = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_DELIVER_TO).getText();
		logger.info("Deliver To : " + deliverTo);
		return deliverTo;
	}

	@Override
	public String getDeliverySingleSplitDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryAdd = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS).getText();
		logger.info("Delivery Address : " + deliveryAdd);
		return deliveryAdd;
	}

	@Override
	public String getDeliverySingleSplitRequiredDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryReqDate = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_REQUIRED_DATE).getText();
		logger.info("Delivery Date : " + deliveryReqDate);
		return deliveryReqDate;
	}

	@Override
	public boolean selectDeliveryOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_OPTION_MULTI_SPLIT);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectDeliveryOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_OPTION_SINGLE_SPLIT);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemId, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='delivery_" + itemId + "_" + index + "']//span[contains(@class,'deliveryOnCnt')]/img"));
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, By.id("deliveryOn_" + itemId + "_" + index + "")).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");

		return requiredByDate;
	}

	@Override
	public String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String deliverTo = null;
		WebElement ele = null;
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='deliverTo_" + itemId + "_" + index + "']")))
		{
			ele = ActionBot.findElement(driver, By.xpath(".//*[@id='deliverTo_" + itemId + "_" + index + "']"));
			deliverTo = ele.getAttribute("value").trim();
		}
		else
		{
			deliverTo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='lblDeliverTo_" + itemId + "_" + index + "']"));
		}
		logger.info("Deliver To : " + deliverTo);
		return deliverTo;
	}

	@Override
	public String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='location_" + itemId + "_" + index + "']"));
		String deliverAddress = ele.getAttribute("value").trim();
		logger.info("Deliver Address : " + deliverAddress);
		return deliverAddress;
	}

	@Override
	public int fillQuantityOrAmountOfDelivery(WebDriver driver, String testCaseName, int amount) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDeliveryOnDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		boolean datePickerFlag = false, dateInputFlag = false;
		String log = "";
		datePickerFlag = ActionBot.isElementPresent(driver, By.xpath(".//*[@id='delivery_" + itemId + "_" + index + "']//span[contains(@class,'deliveryOnCnt')]/img"));
		dateInputFlag = ActionBot.isElementPresent(driver, By.id("deliveryOn_" + itemId + "_" + index + ""));
		if (!datePickerFlag)
		{
			log += "Date picker for delivery on date was not present";
		}
		if (!dateInputFlag)
		{
			log += "Delivery On date input was not present";
		}
		logger.info(log);
		return dateInputFlag && datePickerFlag;
	}

	@Override
	public boolean isDeliveryUptoDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		boolean datePickerFlag = false, dateInputFlag = false;
		String log = "";
		datePickerFlag = ActionBot.isElementPresent(driver, By.xpath(".//*[@id='delivery_" + itemId + "_" + index + "']//span[contains(@class,'deliveryUptoCnt')]/img"));
		dateInputFlag = ActionBot.isElementPresent(driver, By.id("deliveryUpto_" + itemId + "_" + index + ""));
		if (!datePickerFlag)
		{
			log += "Date picker for delivery on date was not present";
		}
		if (!dateInputFlag)
		{
			log += "Delivery On date input was not present";
		}
		logger.info(log);
		return dateInputFlag && datePickerFlag;
	}

	@Override
	public String selectDeliveryUptoDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemID, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='delivery_" + itemID + "_" + index + "']//span[contains(@class,'deliveryUptoCnt')]/img"));
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, By.id("deliveryUpto_" + itemID + "_" + index + "")).getAttribute("value").trim();
		logger.info("Selected Delivery Upto Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing Delivery Upto date");

		return requiredByDate;
	}

	@Override
	public String getDeliveryMultiSplitUptoDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		String requiredByDate = ActionBot.findElement(driver, By.id("deliveryUpto_" + itemID + "_" + index + "")).getAttribute("value").trim();
		logger.info("Selected Delivery Upto Date : " + requiredByDate);

		return requiredByDate;
	}

	@Override
	public boolean isFromDateRequiredErrorPresent(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver,
			By.xpath(".//*[@id='delivery_" + itemId + "_" + index + "']//span[contains(@class,'error')]/span[contains(@class,'inlineError')]"));
	}

	@Override
	public String getFromDateRequiredError(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String error = ActionBot.getAttributeOfElement(driver,
			By.xpath(".//*[@id='delivery_" + itemId + "_" + index + "']//span[contains(@class,'error')]/span[contains(@class,'inlineError')]"), "title");
		logger.info("From date required Error : " + error);
		return error;
	}

	@Override
	public String fillQuantityAtHeaderLevel(WebDriver driver, String testCaseName, String quantity) throws ActionBotException
	{
		String enteredQuantity = ActionBot.sendKeys(driver, ITEMSUMMARY_ITEM_QUANTITY, quantity);
		logger.info("Entered Quantity : " + enteredQuantity);
		return enteredQuantity;
	}

	@Override
	public String getInvalidQuantityError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String errorMsg = ActionBot.getAttributeOfElement(driver, ERROR_INVALID_QUANTITY_ITEM_LEVEL_DELIVERY_DETAILS, "title");
		logger.info("Invalid Quantity Error Message : " + errorMsg);
		return errorMsg;
	}

	@Override
	public boolean isInvalidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ERROR_INVALID_QUANTITY_ITEM_LEVEL_DELIVERY_DETAILS);
	}

	@Override
	public boolean isEnableAssetTaggingCheckboxEnabledOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String classValue = ActionBot.getAttributeOfElement(driver, CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY, "class");
		boolean flag = classValue.contains("disableMe");
		return flag;
	}

	@Override
	public boolean isEnableAssetTaggingCheckboxSelectedOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
	}

	@Override
	public String getLabelValueOfEnableAssetTaggingCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, LABEL_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
		return labelValue;
	}

	@Override
	public void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY);
	}

	@Override
	public String fillAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException
	{
		String enteredAssetNo = ActionBot.sendKeys(driver, TEXTBOX_ASSET_NO_DELIVERY_ITEM_SUMMARY, assetNo);
		logger.info("Entered Asset No : " + enteredAssetNo);
		return enteredAssetNo;
	}

	@Override
	public String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manufacturerSrNo) throws ActionBotException
	{
		String manuSrNo = ActionBot.sendKeys(driver, TEXTBOX_MANUFACTURER_SR_NO_DELIVERY_ITEM_SUMMARY, manufacturerSrNo);
		logger.info("Entered Manufacturer Sr No : " + manuSrNo);
		return manuSrNo;
	}

	@Override
	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		String enteredNotes = ActionBot.sendKeys(driver, TEXTBOX_NOTES_DELIVERY_ITEM_SUMMARY, notes);
		logger.info("Entered Notes : " + enteredNotes);
		return enteredNotes;
	}

	@Override
	public void clickCreateAssetTagsForThisItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ENABLE_ASSET_TAGGING_DELIVERY_ITEM_SUMMARY);
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitForElementToBeDisplayed(driver, LINK_TAG_ASSETS_DELIVERY_ITEM_SUMMARY, 30);
	}
}
