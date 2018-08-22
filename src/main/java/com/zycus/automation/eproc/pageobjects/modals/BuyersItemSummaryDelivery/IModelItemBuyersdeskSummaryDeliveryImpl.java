package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery.IModelItemSummaryDelivery;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelItemBuyersdeskSummaryDeliveryImpl implements IModelItemSummaryDelivery
{

	static Logger logger = Logger.getLogger(IModelItemBuyersdeskSummaryDeliveryImpl.class);

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

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='location_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiSplitAddress);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String multiSplitDeliverTo, String itemID, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='deliverTo_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiSplitDeliverTo);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
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
		if (amt != null)
		{
			return amt;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		String date = ActionBot.findElement(driver, By.xpath(".//*[@id='deliveryOn_" + itemID + "_" + index + "']")).getAttribute("value");
		if (date != null)
		{
			return date;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliverySingleSplitDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverTo = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_DELIVER_TO).getText();
		if (deliverTo != null)
		{
			return deliverTo;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliverySingleSplitDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliveryAdd = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS).getText();
		if (deliveryAdd != null)
		{
			return deliveryAdd;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliverySingleSplitRequiredDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliveryReqDate = ActionBot.findElement(driver, DELIVERY_SINGLE_SPLIT_REQUIRED_DATE).getText();
		if (deliveryReqDate != null)
		{
			return deliveryReqDate;
		}
		else
		{
			return null;
		}
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
	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemID, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fillQuantityOrAmountOfDelivery(WebDriver driver, String testCaseName, int amount) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, ITEMSUMMARY_ITEM_QUANTITY, " " + amount);
		return amount;
	}

	@Override
	public boolean isDeliveryOnDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeliveryUptoDatePresentForSelection(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String selectDeliveryUptoDate(WebDriver driver, String testCaseName, String day, String month, String year, String itemID, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeliveryMultiSplitUptoDate(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFromDateRequiredErrorPresent(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFromDateRequiredError(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillQuantityAtHeaderLevel(WebDriver driver, String testCaseName, String quantity) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInvalidQuantityError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvalidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnableAssetTaggingCheckboxEnabledOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnableAssetTaggingCheckboxSelectedOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLabelValueOfEnableAssetTaggingCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String fillAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manufacturerSrNo) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickCreateAssetTagsForThisItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

}
