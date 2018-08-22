/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createnonpoinvoice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreateNonPOInvoice
{
	static UI_Elements			TEXTBOX_INVOICE_NO						= UIFactory.getElements("TEXTBOX_INVOICE_NO");
	static UI_Elements			DATE_PICKER_INVOICE_DUE_DATE			= UIFactory.getElements("DATE_PICKER_INVOICE_DUE_DATE");
	static UI_Elements			DATE_PICKER_INVOICE_DATE				= UIFactory.getElements("DATE_PICKER_INVOICE_DATE");
	static UI_Elements			TEXTBOX_INVOICE_DATE					= UIFactory.getElements("TEXTBOX_INVOICE_DATE");
	static UI_Elements			TEXTBOX_INVOICE_DUE_DATE				= UIFactory.getElements("TEXTBOX_INVOICE_DUE_DATE");
	static UI_Elements			SELECT_INVOICE_MONTH					= UIFactory.getElements("SELECT_INVOICE_MONTH");
	static UI_Elements			SELECT_INVOICE_YEAR						= UIFactory.getElements("SELECT_INVOICE_YEAR");
	static UI_Elements			TEXTBOX_BUYER_INVOICE					= UIFactory.getElements("TEXTBOX_BUYER_INVOICE");
	static UI_Elements			SELECT_PURCHASE_TYPE_INVOICE			= UIFactory.getElements("SELECT_PURCHASE_TYPE_INVOICE");
	static UI_Elements			SELECT_PAYMENT_TERMS_INVOICE			= UIFactory.getElements("SELECT_PAYMENT_TERMS_INVOICE");
	static UI_Elements			LINK_EXPAND_ALL_INVOICE_ITEMS			= UIFactory.getElements("LINK_EXPAND_ALL_INVOICE_ITEMS");
	static UI_Elements			BUTTON_ADD_ITEM_TO_INVOICE				= UIFactory.getElements("BUTTON_ADD_ITEM_TO_INVOICE");
	static UI_Elements			LABEL_ADDED_ITEM_NAMES_TO_INVOICE		= UIFactory.getElements("LABEL_ADDED_ITEM_NAMES_TO_INVOICE");
	static UI_Elements			BUTTON_SUBMIT_INVOICE					= UIFactory.getElements("BUTTON_SUBMIT_INVOICE");
	static UI_Elements			BUTTON_SAVE_AS_DRAFT_INVOICE			= UIFactory.getElements("BUTTON_SAVE_AS_DRAFT_INVOICE");
	static UI_Elements			BUTTON_CANCEL_INVOICE					= UIFactory.getElements("BUTTON_CANCEL_INVOICE");
	static UI_Elements			SUBMIT_INVOICE_PROGRESSING_DIV			= UIFactory.getElements("SUBMIT_INVOICE_PROGRESSING_DIV");
	static UI_Elements			UPDATE_INVOICE_PROGRESSING_DIV			= UIFactory.getElements("UPDATE_INVOICE_PROGRESSING_DIV");
	static UI_Elements			INVOICE_ITEM_CHKBOX						= UIFactory.getElements("INVOICE_ITEM_CHKBOX");
	static UI_Elements			INVOICE_ITEM_QUANTITY					= UIFactory.getElements("INVOICE_ITEM_QUANTITY");
	static UI_Elements			ALERT_INVOICE_IGNORE_SUBMIT_LINK		= UIFactory.getElements("ALERT_INVOICE_IGNORE_SUBMIT_LINK");
	static UI_Elements			MODAL_SUBMIT_FOR_CONFIRMATION			= UIFactory.getElements("MODAL_SUBMIT_FOR_CONFIRMATION");
	static UI_Elements			FIRST_SUPPLIER_ADDRESS_NON_PO_INVOICE	= UIFactory.getElements("FIRST_SUPPLIER_ADDRESS_NON_PO_INVOICE");
	static UI_Elements			CHECKBOX_SELECT_ALL_ITEMS				= UIFactory.getElements("CHECKBOX_SELECT_ALL_ITEMS");
	static UI_Elements			CHECKBOX_SELECT_FIRST_ITEM				= UIFactory.getElements("CHECKBOX_SELECT_FIRST_ITEM");
	final static UI_Elements	LINK_ADD_ATTACHMENTS					= UIFactory.getElements("LINK_ADD_ATTACHMENTS");
	final static UI_Elements	FIRST_FILE_CHECKBOX						= UIFactory.getElements("FIRST_FILE_CHECKBOX");
	final static UI_Elements	BUTTON_DONE_INVOICE_ATTACHMENT			= UIFactory.getElements("BUTTON_DONE_INVOICE_ATTACHMENT");
	final static UI_Elements	COLLAPSE_SPAN							= UIFactory.getElements("COLLAPSE_SPAN");
	static UI_Elements			LOADER_CHECKING_INVOICE_DETAILS			= UIFactory.getElements("LOADER_CHECKING_INVOICE_DETAILS");
	final static UI_Elements	PO_NUMBER_CREATE_INVOCE					= UIFactory.getElements("PO_NUMBER_CREATE_INVOCE");

	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelEditingButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditBillingAndDeliveryInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIgnoreAndSubmit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnitemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSavAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitForConfirmation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBaseExchangeRate(WebDriver driver, String testCaseName, String baseExchangeRate) throws ActionBotException;

	public String fillBuyer(WebDriver driver, String testCaseName, String buyerName) throws ActionBotException;

	public String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public void fillInvoiceItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public List<WebElement> getListOfItemsAdded(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectInvoiceDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectInvoiceDueDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectPaymentTerms(WebDriver driver, String testCaseName, String paymentTerms) throws ActionBotException;

	public String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException;

	public void clickOnSelectAllItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddAttachments(WebDriver driver, String testCaseName) throws ActionBotException;

	/**
	 * @author bhakti.sawant
	 *         Invoice page add attachment
	 */
	public void addAttachment(WebDriver driver, String testCaseName, String fileName) throws ActionBotException;

	/**
	 * @author t.amarnath
	 *         Get the PO Number from which invoice is being created
	 */
	public String getPONumber(WebDriver driver, String testCaseName) throws ActionBotException;
}
