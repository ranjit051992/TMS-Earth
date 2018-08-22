package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ItemDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemDetailsImpl implements IModalItemDetails
{

	static Logger logger = Logger.getLogger(IModalItemDetailsImpl.class);

	@Override
	public String getItemNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String itemNumber = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblSupplierPartId']")).getText();
		logger.info("Item Number on Item Details Pop is: " + itemNumber);

		return itemNumber;
	}

	@Override
	public String getIShortDescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String shortDesc = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "')]//*[@class='frmValWrap lblName']")).getText();
		logger.info("Short Desc on Item Details Pop is: " + shortDesc);

		return shortDesc;
	}

	@Override
	public String getLongdescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String longDesc = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblDescription']")).getText();
		logger.info("Long Desc on Item Details Pop is: " + longDesc);

		return longDesc;
	}

	@Override
	public String getItemType(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String itemType = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='lblItemType frmValWrap']")).getText();
		logger.info("Item Type on Item Details Pop is: " + itemType);

		return itemType;
	}

	@Override
	public String getReceiveBy(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String receiveBy = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='lblReceivedBy frmValWrap']")).getText();
		logger.info("receive By on Item Details Pop is: " + receiveBy);

		return receiveBy;
	}

	@Override
	public String getProductCategory(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String prodCategory = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblProductCategory']")).getText();
		logger.info("Product Category on Item Details Pop is: " + prodCategory);

		return prodCategory;
	}

	@Override
	public int getQuantity(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String quantity = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblQuantity']")).getText();
		logger.info("Product Category on Item Details Pop is: " + quantity);
		int getQuantity = Integer.parseInt(quantity);
		return getQuantity;
	}

	@Override
	public String getUOM(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String getUOM = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblUom']")).getText();
		logger.info("UOM on Item Details Pop is: " + getUOM);

		return getUOM;
	}

	@Override
	public float getPrice(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String getPrice = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='frmValWrap lblPrice']")).getText();
		logger.info("Price on Item Details Pop is: " + getPrice);
		float getPriceFrmItemDetails = Float.parseFloat(getPrice);
		logger.info("Price in Float data type on Item Details Pop is: " + getPriceFrmItemDetails);
		return getPriceFrmItemDetails;
	}

	@Override
	public String getSourcingStatus(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String sourcingStatus = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']//*[@class='lblSourcingStatus frmValWrap']")).getText();
		logger.info("Sourcing Status on Item Details Pop is: " + sourcingStatus);

		return sourcingStatus;
	}

	@Override
	public String getCurrency(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String getCurrency = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemID + "']/ol[2]//*[@class='frmValWrap lblCurrency']")).getText();
		logger.info("Currency on Item Details Pop is: " + getCurrency);

		return getCurrency;
	}

	@Override
	public String getAddressFrmRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String getAddressFrmRequirementDetails = ActionBot.findElement(driver, By.xpath(".//*[@id='df_dfSection_" + itemID + "']//*[@class='df-form-val df-clearfix']")).getText();
		logger.info("Address On Requirement details tab on Item Details Pop is: " + getAddressFrmRequirementDetails);

		return getAddressFrmRequirementDetails;
	}

	@Override
	public String getSupplierName(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String supplierName = ActionBot.findElement(driver, By.xpath(".//*[@id='frmSupplier_" + itemID + "']//*[@class='dev_existingSupplierLbl']")).getText();
		logger.info("Supplier NAme on Item Details Pop is: " + supplierName);

		return supplierName;
	}

	@Override
	public String getAddressFrmSuppliersTab(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String addressOnSuppTab = ActionBot.findElement(driver, ADDRESS_ON_SUPPLIER_TAB).getText();
		logger.info("Address On Suppliers tab on Item Details Pop is: " + addressOnSuppTab);

		return addressOnSuppTab;
	}

	@Override
	public String getContractNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		String contractNumber = ActionBot.findElement(driver, By.xpath(".//*[@id='frmSupplier_" + itemID + "']/div[2]/div[1]/div/div/fieldset/ol[1]/li[2]/div[1]/div")).getText();
		logger.info("contract Number on Item Details Pop is: " + contractNumber);

		return contractNumber;
	}

	@Override
	public void toClickShowExtraFields(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SHOW_EXTRA_FIELDS);

	}

	@Override
	public void toClickCopyBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, COPY_BTN);

	}

	@Override
	public void toClickCloseBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_BTN);

	}

}
