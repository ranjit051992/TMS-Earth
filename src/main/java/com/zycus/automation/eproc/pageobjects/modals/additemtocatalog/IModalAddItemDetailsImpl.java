/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.additemtocatalog;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 * 
 */
public class IModalAddItemDetailsImpl implements IModalAddItemDetails
{
	static Logger	logger	= Logger.getLogger(IModalAddItemDetailsImpl.class);

	@Override
	public String fillSupplierPartId(WebDriver driver, String testCaseName, String supplierPartId) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_PART_ID, supplierPartId);
		String supplier_part_id = ActionBot.getTextWithInElement(driver, TEXTBOX_SUPPLIER_PART_ID);
		logger.info("Entered Supplier Part ID : " + supplier_part_id);
		return supplier_part_id;
	}

	@Override
	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM, shortDescription);
		String shor_desc = ActionBot.getTextWithInElement(driver, TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM);
		logger.info("Entered Short Description : " + shor_desc);
		return shor_desc;
	}

	@Override
	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws Exception
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM);
		if (productCategory != null)
		{
			element.clear();
			element.sendKeys(productCategory);
			ActionBot.defaultMediumSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
		}
		else
		{
			if (ActionBot.findElement(driver, TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM).getAttribute("value").length() == 0)
			{
				productCategory = CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING);
				element.clear();
				element.sendKeys(productCategory);
				ActionBot.defaultSleep();
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				// ActionBot.click(driver, By.partialLinkText(productCategory));
			}
		}
		String selectedProductCategory = element.getAttribute("value");
		logger.info("Selected Product Category : " + selectedProductCategory);

		return selectedProductCategory;
	}

	@Override
	public double fillPrice(WebDriver driver, String testCaseName, double price) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRICE_CATALOG_ITEM, Double.toString(price));
		String enteredPrice = ActionBot.getTextWithInElement(driver, TEXTBOX_PRICE_CATALOG_ITEM);
		logger.info("Entered Price : " + enteredPrice);
		return Double.parseDouble(enteredPrice);
	}

	@Override
	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_CATALOG_ITEM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add Item Button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnAddAndContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_AND_CONTINUE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add And Continue Button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCloseAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_ADD_ITEM);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Close Button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_SELECTED_SUPPLIER_NAME);
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String fillItemCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM);
		if (currency != null)
		{
			element.clear();
			element.sendKeys(currency);
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
		}
		else if ((element.getAttribute("value") == null) || (element.getAttribute("value").trim().equals("")))
		{
			element.clear();
			element.sendKeys("USD");
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
		}
		ActionBot.defaultSleep();
		String selectedCurrency = element.getAttribute("value");
		logger.info("Selected Currency : " + selectedCurrency);
		return selectedCurrency;
	}

	@Override
	public void clickOnUpdateCatalogItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPDATE_CATALOG_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update Catalog Item Button");
	}

	@Override
	public String fillItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException
	{
		String desc = ActionBot.sendKeys(driver, TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION, itemLongDescription);
		logger.info("Entered Item Long Description : " + desc);
		return desc;
	}

	@Override
	public String fillItemUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException
	{
		String uom = ActionBot.fillAutoCompleteField(driver, TEXTBOX_ITEM_UOM_CATALOG_CREATION, UOM);
		logger.info("Enetered UOM : " + uom);
		return uom;
	}

	@Override
	public String getSupplierId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierPartId = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_ID_CATALOG_CREATION);
		logger.info("Supplier Part Id : " + supplierPartId);
		return supplierPartId;
	}

	@Override
	public String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String uom = ActionBot.getAttributeOfElement(driver, TEXTBOX_ITEM_UOM_CATALOG_CREATION, "value");
		logger.info("UOM : " + uom);
		return uom;
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String supplier_Name = ActionBot.fillAutoCompleteField(driver, TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION, supplierName);
		logger.info("Entered Supplier Name : " + supplier_Name);
		return supplier_Name;
	}

	@Override
	public String fillERPPartId(WebDriver driver, String testCaseName, String erpPartId) throws ActionBotException
	{
		String ERP_Part_Id = ActionBot.sendKeys(driver, TEXTBOX_ERP_PART_ID, erpPartId);
		logger.info("ERP Part ID : " + ERP_Part_Id);
		return ERP_Part_Id;
	}

	@Override
	public String fillMarketPrice(WebDriver driver, String testCaseName, String marketPrice) throws ActionBotException
	{

		// String market_price = ActionBot.sendKeys(driver,
		// TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG,
		// Double.toString(marketPrice));
		ActionBot.clear(driver, TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG);
		String market_price = ActionBot.sendKeys(driver, TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG, marketPrice);

		logger.info("Entered Market Price : " + market_price);
		return market_price;
	}

	@Override
	public boolean isERPIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementPresent(driver, TEXTBOX_ERP_PART_ID);
	}

	@Override
	public void clickButtonAddSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@value='Add Supplier'])[" + index + "]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking button Add Supplier");

	}

	@Override
	public void clickItemCheckBoxItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_FIRST_ITEM_FROM_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking the checkbox of First Item of item master");

	}

	@Override
	public void clickOnActionsLinkOfItemInItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIONS_OF_ITEM_IN_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking the actions link ");

	}

	@Override
	public void clickOnEditItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_ITEM_OF_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking the edit link ");

	}

	@Override
	public void clickOnDiscardItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DISCARD_ITEM_OF_ITEM_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking the discard link ");

	}

	@Override
	public void clickButtonAddSupplierWhileUpdatingItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_SUPPLIER_WHILE_UPDATING_ITEM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking add supplier ");

	}

	@Override
	public boolean isERPIdPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_ERP_PART_ID))
			return true;
		return false;
	}

	@Override
	public String fillProductURL(WebDriver driver, String testCaseName, String productURL) throws ActionBotException
	{
		String product_URL = ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_URL, productURL);
		logger.info("Entered Product URL: " + product_URL);
		return product_URL;
	}

	@Override
	public String fillManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException
	{
		String manufacturer_name = ActionBot.sendKeys(driver, TEXTBOX_MANUFACTURER_NAME, manufacturerName);
		logger.info("Entered Manufacturer Name: " + manufacturer_name);
		return manufacturer_name;
	}

	@Override
	public String fillManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException
	{
		String manufacturer_part_id = ActionBot.sendKeys(driver, TEXTBOX_MANUFACTURER_PART_ID, manufacturerPartId);
		logger.info("Entered Manufacturer Part Id: " + manufacturer_part_id);
		return manufacturer_part_id;
	}

	@Override
	public String fillManufacturerURL(WebDriver driver, String testCaseName, String manufacturerURL) throws ActionBotException
	{
		String manufacturer_URL = ActionBot.sendKeys(driver, TEXTBOX_MANUFACTURER_URL, manufacturerURL);
		logger.info("Entered manufacturer URL: " + manufacturer_URL);
		return manufacturer_URL;
	}

	@Override
	public int fillDeliveryLeadDays(WebDriver driver, String testCaseName, int deliveryLeadDays) throws ActionBotException
	{
		int delivery_lead_days = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_LEAD_TIME, Integer.toString(deliveryLeadDays)));
		logger.info("Entered delivery lead days " + delivery_lead_days);
		return delivery_lead_days;
	}

	@Override
	public boolean checkIsGreen(WebDriver driver, String testCaseName, boolean isGreen) throws ActionBotException
	{
		if (isGreen)
		{
			ActionBot.click(driver, RADIO_BUTTON_IS_GREEN_YES);
		}
		return isGreen;
	}

	@Override
	public boolean checkIsPreferred(WebDriver driver, String testCaseName, boolean isPreferred) throws ActionBotException
	{
		if (isPreferred)
		{
			ActionBot.click(driver, IS_PREFFERED_YES);
		}
		return isPreferred;
	}

	@Override
	public String fillSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException
	{
		String specification_name = ActionBot.sendKeys(driver, TEXTBOX_SPECIFICATION_NAME, specificationName);
		logger.info("Entered specification name: " + specification_name);
		return specification_name;
	}

	@Override
	public String fillSpecificationType(WebDriver driver, String testCaseName, String specificationType) throws ActionBotException
	{
		String specification_type = ActionBot.sendKeys(driver, SPECIFICATIONS_TYPE, specificationType);
		logger.info("Entered specification type: " + specification_type);
		return specification_type;
	}

	@Override
	public String fillSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException
	{
		String specification_value = ActionBot.sendKeys(driver, SPECIFICATIONS_VALUE, specificationValue);
		logger.info("Entered specification value: " + specification_value);
		return specification_value;
	}

	@Override
	public boolean uploadAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			WebElement element = ActionBot.getElement(driver, BUTTON_ITEM_BROWSE);
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("catelog_item_specification"));
			ActionBot.defaultMediumSleep();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void fillAttachmentURL(WebDriver driver, String testCaseName, List<String> attachmentURL) throws ActionBotException
	{
		for (String URL : attachmentURL)
		{
			ActionBot.sendKeys(driver, ATTACHMENT_URL, URL);
			ActionBot.click(driver, ATTACHMENT_URL_ADD_BUTTON);
			ActionBot.defaultMediumSleep();
		}
	}

	@Override
	public String fillERPPartNo(WebDriver driver, String testCaseName, String ERPPartNo) throws ActionBotException
	{
		String erp_part_no = ActionBot.sendKeys(driver, TEXTBOX_ERP_PART_NO, ERPPartNo);
		logger.info("Entered ERP Part No: " + erp_part_no);
		return erp_part_no;
	}

	@Override
	public String fillItemDescription(WebDriver driver, String testCaseName, String itemDescription) throws ActionBotException
	{
		String item_description = ActionBot.sendKeys(driver, TEXTBOX_ITEM_DESCRIPTION, itemDescription);
		logger.info("Entered Item description is: " + item_description);
		return item_description;

	}

	@Override
	public boolean selectItemImage(WebDriver driver, String testCaseName, String imageFile) throws ActionBotException
	{
		try
		{
			WebElement element = ActionBot.getElement(driver, SELECT_ITEM_IMAGE);
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig(imageFile));
			ActionBot.defaultMediumSleep();
			if (ActionBot.isElementPresent(driver, SELECT_ITEM_IMAGE_ERROR_MESSAGE))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isSelectItemImagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, SELECT_ITEM_IMAGE);
	}

	@Override
	public boolean isAssetNumberingFieldEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			if (ActionBot.isElementDisplayed(driver, ASSET_NUMBERING_REQUIRED_YES) && ActionBot.isElementDisplayed(driver, ASSET_NUMBERING_REQUIRED_NO))
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAttachmentLinkEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			ActionBot.moveToElement(driver, ATTACHMENT_URL);
			return (ActionBot.isElementPresent(driver, ATTACHMENT_URL) && ActionBot.isElementPresent(driver, ADD_ITEM_MASTER_ITEM_UPLOAD_ATTACHMENT_SELECT_FILE_BUTTON));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isManufacturePartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_MANUFACTURER_PART_ID);
		return ActionBot.isElementPresent(driver, TEXTBOX_MANUFACTURER_PART_ID);
	}

	@Override
	public boolean isManufacturerNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_MANUFACTURER_NAME);
		return ActionBot.isElementPresent(driver, TEXTBOX_MANUFACTURER_NAME);
	}

	@Override
	public boolean isSpecificationsNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_SPECIFICATION_NAME);
		return ActionBot.isElementPresent(driver, TEXTBOX_SPECIFICATION_NAME);
	}

	@Override
	public boolean isSpecificationsTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, SPECIFICATIONS_TYPE);
		return ActionBot.isElementPresent(driver, SPECIFICATIONS_TYPE);
	}

	@Override
	public boolean isSpecificationsValueEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, SPECIFICATIONS_VALUE);
		return ActionBot.isElementPresent(driver, SPECIFICATIONS_VALUE);
	}

	@Override
	public boolean isCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_ITEM_CURRENCY);
		return ActionBot.isElementPresent(driver, TEXTBOX_ITEM_CURRENCY);
	}

	@Override
	public boolean isMarketPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG);
		return ActionBot.isElementPresent(driver, TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG);
	}

	@Override
	public boolean isUOMEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_ITEM_UOM_CATALOG_CREATION);
		return ActionBot.isElementEnabled(driver, TEXTBOX_ITEM_UOM_CATALOG_CREATION);
	}

	@Override
	public boolean isReceiveByEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LABEL_RECEIVE_BY_QUANTITY);
		return ActionBot.isElementEnabled(driver, LABEL_RECEIVE_BY_QUANTITY);
	}

	@Override
	public boolean isItemTypeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LABEL_ITEM_TYPE_GOODS);
		return ActionBot.isElementPresent(driver, LABEL_ITEM_TYPE_GOODS);
	}

	@Override
	public boolean isProductCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM);
		return ActionBot.isElementEnabled(driver, TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM);
	}

	@Override
	public boolean isItemDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION);
		return ActionBot.isElementPresent(driver, TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION);
	}

	@Override
	public boolean isShortDescriptionEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM);
		return ActionBot.isElementEnabled(driver, TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION);
	}

	@Override
	public boolean isERPPartNoEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementDisplayed(driver, TEXTBOX_ERP_PART_NO);
	}

	@Override
	public boolean isShortDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.moveToElement(driver, SHORT_DESCRIPTION_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, SHORT_DESCRIPTION_MANDATORY_TAG);
	}

	@Override
	public boolean isERPPartNoMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ERP_PART_NO_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, ERP_PART_NO_MANDATORY_TAG);
	}

	@Override
	public boolean isItemTypeMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ITEM_TYPE_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, ITEM_TYPE_MANDATORY_TAG);
	}

	@Override
	public boolean isProductCategoryMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.moveToElement(driver, PRODUCT_CATEGORY_MANDATORY_TAG);
		//ActionBot.defaultMediumSleep();
		return ActionBot.isElementPresent(driver, PRODUCT_CATEGORY_MANDATORY_TAG);
	}

	@Override
	public boolean isUOMMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, UOM_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, UOM_MANDATORY_TAG);
	}

	@Override
	public boolean isSelectFileButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, BUTTON_SELECT_FILE_IN_ITEM_DETAILS);
		return ActionBot.isElementPresent(driver, BUTTON_SELECT_FILE_IN_ITEM_DETAILS);
	}

	@Override
	public void clickOnUpdateSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UPDATE_SUPPLIER_BUTTON);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillSearchBoxSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, SEARCH_TEXTBOX_SUPPLIER, supplierName);

	}

	@Override
	public void clickOnGoButtonSupplierSearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUPPLIER_SEARCH_GO_BUTTON);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnClearSearchResults(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_SEARCH_SUPPLIER);
		ActionBot.defaultSleep();
	}

	@Override
	public List<String> getListOfSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.moveToElement(driver, LIST_OF_SUPPLIERS);

		ActionBot.waitForElementToBePresent(driver, 10, LIST_OF_SUPPLIERS);

		List<String> suppliers = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, LIST_OF_SUPPLIERS);
		for (WebElement element : elements)
		{
			suppliers.add(element.getText());
		}
		return suppliers;
	}

	@Override
	public boolean isCancelAndCloseIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CLOSE_BUTTON_ADD_ITEM_DETAILS);
	}

	@Override
	public List<String> getColumnNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> supplierColumnName = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, SUPPLIER_COLUMN_NAMES);
		for (WebElement webElement : elements)
		{
			supplierColumnName.add(webElement.getText());
		}
		return supplierColumnName;
	}

	@Override
	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, ITEM_NAME_LIST_OF_ITEMS);
		List<String> items = new ArrayList<>();
		for (WebElement element : elements)
		{
			items.add(element.getText());
		}
		return items;
	}

	@Override
	public String getAddedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, SUPPLIER_ADDED_ON);
	}

	@Override
	public String getLastUpdatedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, SUPPLIER_LAST_UPDATED_ON);
	}

	@Override
	public String getSupplierStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, SUPPLIER_STATUS);
	}

	@Override
	public void uploadAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		WebElement element;
		try
		{
			element = ActionBot.getElement(driver, ADD_ITEM_MASTER_ITEM_UPLOAD_ATTACHMENT_SELECT_FILE_BUTTON);
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig(fileName));
			ActionBot.defaultMediumSleep();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void fillSingleAttachmentURL(WebDriver driver, String testCaseName, String URL) throws ActionBotException
	{
		ActionBot.sendKeys(driver, ATTACHMENT_URL, URL);
		ActionBot.click(driver, ATTACHMENT_URL_ADD_BUTTON);
		ActionBot.defaultMediumSleep();
	}

	@Override
	public String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXTBOX_SPECIFICATION_NAME);
	}

	@Override
	public String getMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXTBOX_MARKET_PRICE_ADD_ITEM_IN_CATALOG);
	}

	@Override
	public boolean isSupplierPartIdEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, TEXTBOX_SUPPLIER_PART_ID);
	}

	@Override
	public boolean isProductURLEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_PRODUCT_URL);
		return ActionBot.isElementPresent(driver, TEXTBOX_PRODUCT_URL);
	}

	@Override
	public boolean isDeliveryTimeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_LEAD_TIME);
		return ActionBot.isElementPresent(driver, TEXTBOX_LEAD_TIME);
	}

	@Override
	public boolean isItemCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM);
		return ActionBot.isElementPresent(driver, TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM);
	}

	@Override
	public boolean isSupplierPriceEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, TEXTBOX_PRICE_CATALOG_ITEM);
	}

	@Override
	public boolean isSupplierNameEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION);
	}

	@Override
	public boolean isPreferredYesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, IS_PREFFERED_YES);
		return ActionBot.isElementPresent(driver, IS_PREFFERED_YES);
	}

	@Override
	public boolean isPreferredNoPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, IS_PREFFERED_NO);
		return ActionBot.isElementPresent(driver, IS_PREFFERED_NO);
	}

	@Override
	public boolean isProductURLPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_PRODUCT_URL);
		return ActionBot.isElementPresent(driver, TEXTBOX_PRODUCT_URL);
	}

	@Override
	public boolean isDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_LEAD_TIME);
		return ActionBot.isElementPresent(driver, TEXTBOX_LEAD_TIME);
	}

	@Override
	public boolean isItemCurrencyMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ITEM_CURRENCY_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, ITEM_CURRENCY_MANDATORY_TAG);
	}

	@Override
	public boolean isSupplierPriceMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ITEM_PRICE_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, ITEM_PRICE_MANDATORY_TAG);
	}

	@Override
	public boolean isSupplierPartIdMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, SUPPLIER_PART_ID_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, SUPPLIER_PART_ID_MANDATORY_TAG);
	}

	@Override
	public boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, SUPPLIER_NAME_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, SUPPLIER_NAME_MANDATORY_TAG);
	}

	@Override
	public void clickOnSupplierActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_LINK_SUPPLIER);
	}

	@Override
	public void clickOnEditSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EDIT_LINK_SUPPLIER);
	}

	@Override
	public void clickOnDiscardSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DISCARD_LINK_SUPPLIER);

	}

	@Override
	public void clickOnItemScopeOfAddSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_SCOPE);
		ActionBot.defaultMediumSleep();
	}

	@Override
	public boolean isItemScopeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ITEM_SCOPE_LABEL_ADD_SUPPLIER_PAGE);
		return ActionBot.isElementPresent(driver, ITEM_SCOPE_LABEL_ADD_SUPPLIER_PAGE);
	}

	@Override
	public boolean isUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_UPDATE_ALL_LINES_ITEM_MASTER);
		if (ActionBot.isElementPresent(driver, LINK_UPDATE_ALL_LINES_ITEM_MASTER))
			return true;
		return false;
	}

	@Override
	public void clickOnUpdateAllLinesPresentInSupplierPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, LINK_UPDATE_ALL_LINES_ITEM_MASTER);

	}

	@Override
	public boolean isUpdateItemProductCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_PRODUCT_CATEGORY);
		return ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_PRODUCT_CATEGORY);

	}

	@Override
	public boolean isUpdateItemCurrencyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_CURRENCY);
		if (ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_CURRENCY))
			return true;
		return false;
	}

	@Override
	public boolean isUpdateItemUOMPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_UOM);
		return (ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_UOM));

	}

	@Override
	public boolean isUpdateItemManufacturerNamePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_MANUFACTURER_NAME);
		return ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_MANUFACTURER_NAME);

	}

	@Override
	public boolean isUpdateItemManufacturerURLPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_MANUFACTURER_URL);
		return ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_MANUFACTURER_URL);

	}

	@Override
	public boolean isUpdateItemDeliveryLeadTimePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_UPDATE_ITEM_DELIVERY_LEAD_TIME);
		return (ActionBot.isElementPresent(driver, TEXTBOX_UPDATE_ITEM_DELIVERY_LEAD_TIME));

	}

	@Override
	public void fillUpdateItemProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void fillUpdateItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void fillUpdateItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void fillUpdateItemManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void fillUpdateItemManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void fillUpdateItemDeliveryLeadTime(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUpdateItemUpdateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUpdateItemCloseLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUpdateItemCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickOnUpdateItemUpdateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, UPDATE_ITEM_UPDATE_BUTTON);
	}

	@Override
	public String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_CURRENCY_CATALOG_ITEM);
	}

	@Override
	public void clickOnUpdateItemCloseLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, UPDATE_ITEM_CLOSE_LINK);
	}

	@Override
	public void clickOnUpdateItemCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, UPDATE_ITEM_CLOSE);
	}

	@Override
	public List<String> getListOfAddedAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> listOfAttachments = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, ATTACHMENT_FILE_LIST_ATTACHMENT_NAME);
		for (WebElement element : elements)
		{
			listOfAttachments.add(element.getText());
		}
		return null;
	}

	@Override
	public void clickOnUpdateSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, BUTTON_UPDATE_SUPPLIER);
		ActionBot.click(driver, BUTTON_UPDATE_SUPPLIER);
	}

	@Override
	public void clickOnAddExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, BUTTON_ADD_EXISTING_SUPPLIER);
		ActionBot.click(driver, BUTTON_ADD_EXISTING_SUPPLIER);

	}

	@Override
	public boolean isCurrencyItemEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, TEXTBOX_CURRENCY_ITEM);
	}

	@Override
	public boolean isCurrencyItemPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_CURRENCY_ITEM);
	}

	@Override
	public void setActiveSupplierYes(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, ACTIVE_SUPPLIER_YES);
	}

	@Override
	public void setActiveSupplierNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIVE_SUPPLIER_NO);
	}

	@Override
	public boolean isDuplicateERPPartNoErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, Duplicate_ERP_Part_Number_Link);
	}

	@Override
	public boolean isSupplierNameMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementDisplayed(driver, Supplier_Name_Mandatory_Error_Message);

	}

	@Override
	public boolean isSupplierPartIdMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, Supplier_Part_ID_Mandatory_Error_Message);
	}

	@Override
	public boolean isSupplierItemPriceMandatoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, Supplier_Item_Price_Mandatory_Error_Message);

	}

	@Override
	public void clickSecondItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, CHECKBOX_SECOND_ITEM_FROM_ITEM_MASTER);
		ActionBot.click(driver, CHECKBOX_SECOND_ITEM_FROM_ITEM_MASTER);

	}

	@Override
	public void clickThirdItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, CHECKBOX_THIRD_ITEM_FROM_ITEM_MASTER);
		ActionBot.click(driver, CHECKBOX_THIRD_ITEM_FROM_ITEM_MASTER);

	}

	@Override
	public void clickOnEditSecondItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, EDIT_SECOND_ITEM);
		ActionBot.click(driver, EDIT_SECOND_ITEM);

	}

	@Override
	public void clickOnEditThirdItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, EDIT_THIRD_ITEM);
		ActionBot.click(driver, EDIT_THIRD_ITEM);

	}

	@Override
	public void clickOnActionsLinkSecondItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ACTIONS_LINK_SECOND_ITEM);
		ActionBot.click(driver, ACTIONS_LINK_SECOND_ITEM);

	}

	@Override
	public void clickOnActionsLinkThirdItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ACTIONS_LINK_THIRD_ITEM);
		ActionBot.click(driver, ACTIONS_LINK_THIRD_ITEM);

	}

	@Override
	public boolean isFromValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
	}

	@Override
	public boolean isToValidityDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
	}

	@Override
	public String fillFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_FROM);
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String fromScopeValidityDate = ActionBot.findElement(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("From Scope Validity Date : " + fromScopeValidityDate);

		return fromScopeValidityDate;

	}

	@Override
	public String fillToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_TO);
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String toScopeValidityDate = ActionBot.findElement(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("To Scope Validity Date : " + toScopeValidityDate);

		return toScopeValidityDate;
	}

	@Override
	public boolean isErrorBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_BOX);
	}

	@Override
	public boolean isInvalidERPPartNoErrorMessageForFilePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_ERP_PART_NO_FILE);
	}

	@Override
	public boolean isDuplicateSupplierPartIDPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_DUPLICATE_ERP_PART_NO_FILE);
	}

	@Override
	public boolean isMissingShortDescriptionErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_MISSING_SHORT_DESCRIPTION);

	}

	@Override
	public int getNumberOfCharactersShortDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count;
		String value = ActionBot.getTextWithInElement(driver, TEXTBOX_SHORT_DESCRIPTION_CATALOG_ITEM);
		return count = value.length();
	}

	@Override
	public int getNumberOfCharactersManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count;
		String value = ActionBot.getTextWithInElement(driver, TEXTBOX_MANUFACTURER_NAME);
		return count = value.length();
	}

	@Override
	public boolean isInvalidUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_UNIT_OF_MEASURE);
	}

	@Override
	public int getNumberOfCharactersItemDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count;
		String value = ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_DESCRIPTION_CATALOG_CREATION);
		return count = value.length();
	}

	@Override
	public boolean isMissingCurrencyErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_MISSING_CURRENCY);
	}

	@Override
	public boolean isMissingUnitOfMeasureErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_MISSING_UNIT_OF_MEASURE);
	}

	@Override
	public boolean isCurrencyInvalidOrInactiveErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INACTIVE_OR_INVALID_CURRENCY);

	}

	@Override
	public int getNumberOfCharactersManufacturePartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count;
		String value = ActionBot.getTextWithInElement(driver, TEXTBOX_MANUFACTURER_PART_ID);
		return count = value.length();
	}

	@Override
	public int getNumberOfCharactersProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count;
		String value = ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_CATEGORY_CATALOG_ITEM);
		return count = value.length();
	}

	@Override
	public boolean isMissingProductCategoryErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_MISSING_PRODUCT_CATEGORY);
	}

	@Override
	public boolean isInvalidPriceErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_PRICE);
	}

	@Override
	public boolean isInvalidSupplierPartIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_SUPPLIER_ID);
	}

	@Override
	public boolean isMissingSupplierIdErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_MISSING_SUPPLIER_ID);
	}

	@Override
	public boolean isInvalidLeadTimeErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_LEAD_TIME);
	}

}
