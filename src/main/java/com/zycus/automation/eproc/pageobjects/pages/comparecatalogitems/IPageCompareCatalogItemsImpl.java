/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.comparecatalogitems;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCompareCatalogItemsImpl implements IPageCompareCatalogItems
{
	static Logger logger = Logger.getLogger(IPageCompareCatalogItemsImpl.class);

	@Override
	public List<WebElement> getListOfItemsCompared(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfComparedItems = new ArrayList<WebElement>();
		listOfComparedItems = ActionBot.findElements(driver, LABEL_COMPARED_ITEM_NAMES);
		ScreenShot.screenshot(driver, testCaseName, "List of Compared Items");
		return listOfComparedItems;
	}

	@Override
	public String getComparedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String itemName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_itemName + index + xpath2_itemName));
		logger.info("Item Name : " + itemName);
		return itemName;
	}

	@Override
	public String getComparedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_unitPrice + index + xpath2_withSpan));
		logger.info("Unit Price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public String getComparedItemAvailability(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String availability = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_availability + index + xpath2_withDiv));
		logger.info("Availability : " + availability);
		return availability;
	}

	@Override
	public String getComparedItemSupplierName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String supplier = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_supplierName + index + xpath2_withDiv));
		logger.info("Supplier : " + supplier);
		return supplier;
	}

	@Override
	public String getComparedItemSupplierPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String supplierPartId = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_supplierPartId + index + xpath2_withDiv));
		logger.info("Supplier Part Id : " + supplierPartId);
		return supplierPartId;
	}

	@Override
	public String getComparedItemMarketPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String marketPrice = null;
		if (ActionBot.isElementPresent(driver, By.xpath(xpath1_marketPrice + index + xpath2_withDiv)))
		{
			marketPrice = ActionBot.getTextWithInElement(driver,

				By.xpath(xpath1_marketPrice + index + xpath2_withDiv));
		}
		else
		{
			marketPrice = ActionBot.getTextWithInElement(driver,

				By.xpath(xpath1_marketPrice + index + xpath2_withSpan));
		}
		logger.info("Market Price : " + marketPrice);
		return marketPrice;
	}

	@Override
	public String getComparedItemManufacturerName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String manufacturerName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_manufacturerName + index + xpath2_withDiv));
		logger.info("Manufacturer Name : " + manufacturerName);
		return manufacturerName;
	}

	@Override
	public String getComparedItemManufacturerPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String manufacturerPartId = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_manufacturerPartId + index + xpath2_withDiv));
		logger.info("Manufacturer Part Id : " + manufacturerPartId);
		return manufacturerPartId;
	}

	@Override
	public String getComparedItemDescription(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String desc = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_description + index + xpath2_withDiv));
		logger.info("Description : " + desc);
		return desc;
	}

	@Override
	public String getComparedItemSpecKey(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String specKey = null;
		if (index == 1)
		{
			if (ActionBot.isElementPresent(driver, LABEL_SPECIFICATION_KEY1))
			{
				specKey = ActionBot.getTextWithInElement(driver, LABEL_SPECIFICATION_KEY1);
			}
		}
		else
		{
			if (ActionBot.isElementPresent(driver, LABEL_SPECIFICATION_KEY2))
			{
				specKey = ActionBot.getTextWithInElement(driver, LABEL_SPECIFICATION_KEY2);
			}
		}
		logger.info("Specification Key : " + specKey);
		return specKey;
	}

	@Override
	public String getComparedItemSpecValue(WebDriver driver, String testCaseName, int columnIndex, int valueIndex) throws ActionBotException
	{
		String spec_value = null;
		if (valueIndex == 1)
		{
			if (ActionBot.isElementPresent(driver, By.xpath(xpath1_specValue1 + columnIndex + xpath2_withDiv)))
			{
				spec_value = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_specValue1 + columnIndex + xpath2_withDiv));
			}
		}
		else
		{
			if (ActionBot.isElementPresent(driver, By.xpath(xpath1_specValue2 + columnIndex + xpath2_withDiv)))
			{
				spec_value = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_specValue2 + columnIndex + xpath2_withDiv));
			}
		}
		logger.info("Specification Value : " + spec_value);
		return spec_value;
	}

	@Override
	public String getComparedItemAttachment(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String attachment = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_attachment + index + xpath2_withDiv));
		logger.info("Attachment : " + attachment);
		return attachment;
	}

	@Override
	public List<String> getComparedItemAttachments(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		List<String> attachments = new ArrayList<String>();
		if (ActionBot.isElementPresent(driver, By.xpath(xpath1_attachment + index + xpath2_attachment)))
		{
			List<WebElement> elements = ActionBot.findElements(driver, By.xpath(xpath1_attachment + index + xpath2_attachment));
			for (WebElement element2 : elements)
			{
				attachments.add(element2.getText().trim());
			}
		}
		else
		{
			String attachment = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_attachment + index + xpath2_withDiv));
			logger.info("Attachment : " + attachment);
			attachments.add(attachment);
		}
		return attachments;
	}

	@Override
	public int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity, int index) throws ActionBotException
	{
		ActionBot.hover(driver, By.xpath("(.//*[@id='compareItemsGrid']/tbody//div[@class='pad']/a[@data-item-id='"+itemId+"'])"));
		By inputQuqntityField = By.xpath(xpath1_inputFieldQuantity + itemId + xpath2_inputFieldQuantity + index + "]");
		ActionBot.waitForElementToBeDisplayed(driver, inputQuqntityField, 60);
		ActionBot.moveToElement(driver, ActionBot.findElement(driver, inputQuqntityField));
		ActionBot.defaultSleep();
		String enteredQuantity = ActionBot.sendKeys(driver, inputQuqntityField, Integer.toString(quantity));
		logger.info("Entered Quantity : " + enteredQuantity);
		return Integer.parseInt(enteredQuantity);
	}

	@Override
	public int getQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		By inputQuantityField = By.xpath(xpath1_inputFieldQuantity + itemId + xpath2_inputFieldQuantity + index + "]");
		ActionBot.moveToElement(driver, ActionBot.findElement(driver, inputQuantityField));
		String enteredQuantity = ActionBot.getAttributeOfElement(driver, inputQuantityField, "value");
		logger.info("Entered Quantity : " + enteredQuantity);
		return Integer.parseInt(enteredQuantity);
	}

	@Override
	public void clickOnAddToCartButton(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_addToCartButton + index + xpath2_addToCartButton));
		ActionBot.defaultSleep();
	}
}
