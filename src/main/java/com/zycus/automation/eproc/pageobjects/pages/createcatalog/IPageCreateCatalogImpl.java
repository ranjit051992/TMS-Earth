/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createcatalog;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice.IPageCreateNonPOInvoiceImpl;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageCreateCatalogImpl implements IPageCreateCatalog
{
	static Logger logger = Logger.getLogger(IPageCreateCatalogImpl.class);

	@Override
	public String fillCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CATALOG_NAME, catalogName);
		String catalog_name = ActionBot.getTextWithInElement(driver, TEXTBOX_CATALOG_NAME);
		logger.info("Entered Catalog Name : " + catalog_name);
		return catalog_name;
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION);
		ActionBot.fillAutoCompleteField(driver, element, supplierName);
		String supplier_name = element.getAttribute("value");
		logger.info("Entered Supplier Name : " + supplier_name);
		return supplier_name;
	}

	@Override
	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_SELECT_SUPPLIER_ADDRESS);
		// ActionBot.click(driver, TEXTBOX_SELECT_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		if (!ActionBot.isElementPresent(driver, IPageCreateNonPOInvoiceImpl.FIRST_SUPPLIER_ADDRESS_NON_PO_INVOICE))
		{
			ActionBot.click(driver, TEXTBOX_SELECT_SUPPLIER_ADDRESS);
			ActionBot.defaultSleep();
		}

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * SUPPLIER_ADDRESS_SUGGESTION_LIST)).build().perform();
		 */ActionBot.click(driver, IPageCreateNonPOInvoiceImpl.FIRST_SUPPLIER_ADDRESS_NON_PO_INVOICE);

		String selectedSupplierAddress = ActionBot.findElement(driver, TEXTBOX_SELECT_SUPPLIER_ADDRESS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;
	}

	@Override
	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on next button");
		ActionBot.click(driver, BUTTON_NEXT_CREATE_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on next button");
	}

	@Override
	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ADD_ITEM_TO_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add item button");
	}

	@Override
	public void clickOnNextLinkScopeValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on next button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, BUTTON_NEXT_LNK_SCOPE_VALIDITY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on next button");
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnSelectOrganizationUnitLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ORGANIZATION_UNIT);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on select organization link");
	}

	@Override
	public void clickOnSubmitCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit catalog button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, BUTTON_SUBMIT_CATALOG);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_PUBLISH_CATALOG);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit catalog button");
	}

	@Override
	public void clickOnDiscardCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DISCARD_CATALOG);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Discard Catalog Button");
	}

	@Override
	public void clickOnCloseCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_CATALOG);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Catalog Button");
	}

	@Override
	public void clickOnEditFirstCatalogItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_FIRST_CATALOG_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on catalog item actions");
	}

	@Override
	public List<WebElement> getListOfItemsInCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_EDIT_FIRST_CATALOG_ITEM);
	}

	@Override
	public String getItemCatagory(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String category = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='itemListGrid']//tr[.//*[contains(text(),'" + itemName + "')]]/*[contains(@class,'sCategoryName')]"));
		logger.info("Category : " + category);
		return category;
	}

	@Override
	public String getItemSupplier(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='itemListGrid']//tr[.//*[contains(text(),'" + itemName + "')]]/*[contains(@class,'sSupplierName')]"));
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getItemCurrency(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String currency = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='itemListGrid']//tr[.//*[contains(text(),'" + itemName + "')]]/*[contains(@class,'sCurrency')]"));
		logger.info("Item Currency : " + currency);
		return currency;
	}

	@Override
	public double getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='itemListGrid']//tr[.//*[contains(text(),'" + itemName + "')]]/*[contains(@class,'sPrice')]"));
		logger.info("Unit Price : " + unitPrice);
		double price = Double.parseDouble(CommonUtilities.getDecimalPrice(unitPrice));
		return price;
	}

	@Override
	public String getItemSupplierPartId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String supplierPartId = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='itemListGrid']//tr[.//*[contains(text(),'" + itemName + "')]]/*[contains(@class,'sCategoryName')]"));
		logger.info("Supplier Part Id : " + supplierPartId);
		return supplierPartId;
	}

	@Override
	public void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPLOAD_ITEMS_VIA_FILE);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before uploading file");
	}

	@Override
	public void clickOnSelectCatalogScopeLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select Scope of Catalog");
	}

	@Override
	public boolean isSelectCatalogScopeLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
	}

	@Override
	public String selectFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_FROM_SCOPE_VALIDITY_DATE);
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
	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_TO_SCOPE_VALIDITY_DATE);
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
	public String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException
	{
		String contract_number = ActionBot.sendKeys(driver, TEXTBOX_CONTRACT_NUMBER, contractNumber);
		logger.info("Entered Contract number : " + contract_number);
		return contract_number;
	}

	@Override
	public boolean isScopeEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
		return ActionBot.isElementPresent(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
	}

	@Override
	public boolean isFromValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
	}

	@Override
	public boolean isToValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
	}

	@Override
	public boolean isScopePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
		return ActionBot.isElementPresent(driver, LINK_SCOPE_SELECTED_CATALOG_CREATION);
	}

	@Override
	public boolean isScopeMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, SCOPE_MANDATORY_TAG);
		return ActionBot.isElementPresent(driver, SCOPE_MANDATORY_TAG);
	}

	@Override
	public boolean isFromValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_FROM_SCOPE_VALIDITY_DATE);
	}

	@Override
	public boolean isToValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
		return ActionBot.isElementPresent(driver, TEXTBOX_TO_SCOPE_VALIDITY_DATE);
	}

	@Override
	public boolean isCatalogPresentAfterSearch(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_NO_RECORDS_FOUND);
	}

}
