/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemdetails;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalItemDetailsImpl implements IModalItemDetails
{

	static Logger logger = Logger.getLogger(IModalItemDetailsImpl.class);

	@Override
	public String getItemTitle(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String itemTitle = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_title_on_item_details_popup));
		logger.info("Item Title : " + itemTitle);
		ScreenShot.screenshot(driver, testCaseName, "Item Title");
		return itemTitle;
	}

	@Override
	public String getItemDesc(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String itemDesc = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_desc));
		logger.info("Item Description : " + itemDesc);
		ScreenShot.screenshot(driver, testCaseName, "Item Description");
		return itemDesc;
	}

	@Override
	public String getItemManufacturer(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String manufacturer = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_manufacturer));
		logger.info("Item Manufacturer : " + manufacturer);
		ScreenShot.screenshot(driver, testCaseName, "Item Manufacturer");
		return manufacturer;
	}

	@Override
	public void clickOnCloseItemDetailsMdoal(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//div[contains(@aria-describedby,'item_detail_popup_" + itemId + "')]//button"));
		ActionBot.findElement(driver, IPageSearchListing.ITEM_NAMES);
	}

	@Override
	public String getItemCategory(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String category = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_category));
		logger.info("Category Name : " + category);
		return category;
	}

	@Override
	public String getItemSpscCode(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String spscCode = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_spscCode));
		logger.info("SPSC Code : " + spscCode);
		return spscCode;
	}

	@Override
	public String getItemSupplierName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_supplierName));
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getItemSupplierContact(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String supplierContact = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_supplierContact));
		logger.info("Supplier Contact : " + supplierContact);
		return supplierContact;
	}

	@Override
	public String getItemDeliveryLeadTime(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String deliveryLeadTime = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_delivery_lead_time));
		logger.info("Delivery Lead Time : " + deliveryLeadTime);
		return deliveryLeadTime;
	}

	@Override
	public String getItemContractNo(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String supplierContractNo = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_contractNo));
		logger.info("Supplier Contract No : " + supplierContractNo);
		return supplierContractNo;
	}

	@Override
	public String getItemSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String specificationName = ActionBot.getTextWithInElement(driver, LABEL_SPECIFICATION_NAME_ITEM_DETAILS_POP_UP);
		logger.info("Specification Name : " + specificationName);
		return specificationName;
	}

	@Override
	public String getItemSpecificationKey(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException
	{
		String specificationKey = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_specification_key + divIndex + xpath2_specification_key));
		logger.info("Specification Key : " + specificationKey.substring(0, specificationKey.length() - 1));
		return specificationKey;
	}

	@Override
	public String getItemSpecificationValue(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException
	{
		String specificationValue = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_specification_value + divIndex + xpath2_specification_value));
		logger.info("Specification Value : " + specificationValue);
		return specificationValue;
	}

	@Override
	public List<WebElement> getAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_ATTACHMENTS_ITEM_DETAILS_POP_UP);
	}

	@Override
	public List<String> getAttachmentsNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> attachmentsNames = new ArrayList<String>();
		for (WebElement element : ActionBot.findElements(driver, LIST_ATTACHMENTS_ITEM_DETAILS_POP_UP))
		{
			attachmentsNames.add(element.getText().trim());
		}
		return attachmentsNames;
	}

	@Override
	public boolean isItemDetailsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_detailsTab));
	}

	@Override
	public boolean isItemSpecificationsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_specificationTab));
	}

	@Override
	public boolean isItemAttachmentsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_attachmentsTab));
	}

	@Override
	public void clickOnSpecificationTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_specificationTab));
		ScreenShot.screenshot(driver, testCaseName, "Specification Details");
	}

	@Override
	public void clickOnAttachmentTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_on_item_details_popup + itemId + xpath2_item_attachmentsTab));
		ScreenShot.screenshot(driver, testCaseName, "Attachment Details");
	}

	@Override
	public int getSizeOfSpecifications(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_SPECIFICATION_KEYS_ITEM_DETAILS_POP_UP).size();
	}
}
