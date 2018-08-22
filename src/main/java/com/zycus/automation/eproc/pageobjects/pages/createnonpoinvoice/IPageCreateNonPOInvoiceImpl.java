/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.standardpo.IPageStandardPO;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreateNonPOInvoiceImpl implements IPageCreateNonPOInvoice
{
	static Logger logger = Logger.getLogger(IPageCreateNonPOInvoiceImpl.class);

	@Override
	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_INVOICE_NO, invoiceNo);
		String invoice_no = ActionBot.findElement(driver, TEXTBOX_INVOICE_NO).getAttribute("value");
		logger.info("Entered Invoice No : " + invoice_no);
		return invoice_no;
	}

	@Override
	public String selectInvoiceDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_INVOICE_DATE);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_INVOICE_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_INVOICE_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String invoiceDate = ActionBot.findElement(driver, TEXTBOX_INVOICE_DATE).getAttribute("value").trim();
		logger.info("Selected Invoice Date : " + invoiceDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing Invoice date");
		return invoiceDate;
	}

	@Override
	public String selectInvoiceDueDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DATE_PICKER_INVOICE_DUE_DATE))
		{
			ActionBot.click(driver, DATE_PICKER_INVOICE_DUE_DATE);
			// year
			Select select = new Select(ActionBot.findElement(driver, SELECT_INVOICE_YEAR));
			select.selectByValue(year);

			// month
			select = new Select(ActionBot.findElement(driver, SELECT_INVOICE_MONTH));
			select.selectByValue(month);

			// day
			ActionBot.click(driver, By.linkText(day));

			String invoiceDueDate = ActionBot.findElement(driver, TEXTBOX_INVOICE_DUE_DATE).getAttribute("value").trim();
			logger.info("Selected Invoice Due Date : " + invoiceDueDate);
			ScreenShot.screenshot(driver, testCaseName, "After changing Invoice Due date");
			return invoiceDueDate;
		}
		else
			return null;

	}

	@Override
	public String fillBuyer(WebDriver driver, String testCaseName, String buyerName) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_BUYER_INVOICE, buyerName);
		//		WebElement element = ActionBot.findElement(driver, TEXTBOX_BUYER_INVOICE);
		//		element.clear();
		//		element.sendKeys(buyerName);
		//		ActionBot.defaultSleep();
		//		element.sendKeys(Keys.ARROW_DOWN);
		//		element.sendKeys(Keys.RETURN);
		//		String buyer_name = ActionBot.findElement(driver, TEXTBOX_BUYER_INVOICE).getAttribute("value");
		//		logger.info("Buyer Name : " + buyer_name);
		//return buyer_name;
	}

	@Override
	public String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PURCHASE_TYPE_INVOICE));
		if (purchaseType != null)
		{
			select.selectByValue(purchaseType);
		}
		else
		{
			select.selectByIndex(0);
		}
		String selectedPurchaseType = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Purchase Type : " + selectedPurchaseType);
		return selectedPurchaseType;
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_SUPPLIER_NAME);
		element.clear();
		element.sendKeys(supplierName);
		ActionBot.defaultMediumSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.RETURN);
		String supplier_name = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_SUPPLIER_NAME).getAttribute("value");
		logger.info("Supplier Name : " + supplier_name);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filling Supplier Name");
		return supplier_name;
	}

	@Override
	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageStandardPO.TEXTBOX_SUPPLIER_ADDRESS);
		ActionBot.click(driver, IPageStandardPO.TEXTBOX_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * IPageCreateCatalog.SUPPLIER_ADDRESS_SUGGESTION_LIST))
		 * .build().perform(); ActionBot.click(driver,
		 * IPageStandardPO.TEXTBOX_SUPPLIER_ADDRESS);
		 */
		// ActionBot.click(driver, IPageFreeTextForm.FIRST_SUPPLIER__ADDRESS);
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * By.xpath(".//*[contains(@id,'ui-id-')][1]/a"))).build() .perform();
		 */
		ActionBot.click(driver, FIRST_SUPPLIER_ADDRESS_NON_PO_INVOICE);

		String selectedSupplierAddress = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_SUPPLIER_ADDRESS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;

	}

	@Override
	public String selectPaymentTerms(WebDriver driver, String testCaseName, String paymentTerms) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PAYMENT_TERMS_INVOICE));
		if (paymentTerms != null)
		{
			select.selectByValue(paymentTerms);
		}
		else
		{
			select.selectByIndex(0);
		}
		String selectedPaymentTerms = select.getFirstSelectedOption().toString().trim();
		logger.info("Selected Payment Terms : " + selectedPaymentTerms);
		return selectedPaymentTerms;
	}

	@Override
	public String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_CURRENCY_TYPE);
		element.clear();
		element.sendKeys(currency);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.RETURN);
		String selected_currency = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_CURRENCY_TYPE).getAttribute("value");
		logger.info("Selected Currency : " + selected_currency);
		return selected_currency;
	}

	@Override
	public String fillBaseExchangeRate(WebDriver driver, String testCaseName, String baseExchangeRate) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_CURRENCY_VALUE);
		element.clear();
		element.sendKeys(baseExchangeRate);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.RETURN);
		String selected_base_exchange_rate = ActionBot.findElement(driver, IPageStandardPO.TEXTBOX_CURRENCY_VALUE).getAttribute("value");
		logger.info("Selected Base Exchange Rate : " + selected_base_exchange_rate);
		return selected_base_exchange_rate;
	}

	@Override
	public void clickOnEditBillingAndDeliveryInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageStandardPO.BUTTON_EDIT);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Edit Billing and Delivery Info");
	}

	@Override
	public void clickOnExpandAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXPAND_ALL_INVOICE_ITEMS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Expand All");
	}

	@Override
	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_ITEM_TO_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add Item");
	}

	@Override
	public void clickOnSubmitInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SUBMIT_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, SUBMIT_INVOICE_PROGRESSING_DIV);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Sumbit Invoice");
	}

	@Override
	public void clickOnSavAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SAVE_AS_DRAFT_INVOICE);
		ActionBot.waitTillPopUpIsPresent(driver, UPDATE_INVOICE_PROGRESSING_DIV);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save As Draft");
	}

	@Override
	public void clickOnCancelEditingButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_INVOICE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Invoice");
	}

	@Override
	public List<WebElement> getListOfItemsAdded(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LABEL_ADDED_ITEM_NAMES_TO_INVOICE);
	}

	@Override
	public void clickOnIgnoreAndSubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALERT_INVOICE_IGNORE_SUBMIT_LINK);
	}

	@Override
	public void clickOnitemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, INVOICE_ITEM_CHKBOX);
	}

	@Override
	public void clickOnSubmitForConfirmation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_SUBMIT_FOR_CONFIRMATION);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void fillInvoiceItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		ActionBot.findElements(driver, INVOICE_ITEM_QUANTITY).get(0).sendKeys("" + quantity);
	}

	@Override
	public void clickOnSelectAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, ActionBot.findElement(driver, CHECKBOX_SELECT_ALL_ITEMS));
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_SELECT_ALL_ITEMS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on select all items");
	}

	@Override
	public void clickOnFirstItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_FIRST_ITEM);

	}

	@Override
	public void clickOnAddAttachments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_ADD_ATTACHMENTS))
		{
			ActionBot.click(driver, LINK_ADD_ATTACHMENTS);
		}

	}

	/**
	 * @author bhakti.sawant
	 *         method for adding attachment via select file
	 */
	@Override
	public void addAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		clickOnAddAttachments(driver, testCaseName);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element2 = (WebElement) js.executeScript("return document.getElementById('attachmentInput_invoiceAttachment');");
		js.executeScript("document.getElementById('attachmentInput_invoiceAttachment').style.visibility='visible';");

		//element2.sendKeys("C:\\Automation_File_Attachment\\Git_Commit_Process.pdf");
		element2.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig(fileName));

		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCreateNonPOInvoice.BUTTON_DONE_INVOICE_ATTACHMENT);
		ActionBot.waitForPageLoad(driver);

		//if collapse button present then click it
		if (ActionBot.isElementDisplayed(driver, COLLAPSE_SPAN))
		{
			ActionBot.click(driver, COLLAPSE_SPAN);
			ActionBot.waitForPageLoad(driver);
		}

	}

	@Override
	public String getPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PO_NUMBER_CREATE_INVOCE);
	}

}
