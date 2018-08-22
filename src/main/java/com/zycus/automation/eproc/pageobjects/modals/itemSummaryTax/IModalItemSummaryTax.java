/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemSummaryTax;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author amitkumar.dash
 *
 */
public interface IModalItemSummaryTax
{
	final static UI_Elements	MODAL_ITEM_SUMMARY_SELECT_TAX				= UIFactory.getElements("MODAL_ITEM_SUMMARY_SELECT_TAX");
	final static UI_Elements	MODAL_ITEM_REMOVE_ALL_TAX_LINK				= UIFactory.getElements("MODAL_ITEM_REMOVE_ALL_TAX_LINK");
	final static UI_Elements	MODAL_ITEM_SUMMARY_SELECT_TAXNAME			= UIFactory.getElements("MODAL_ITEM_SUMMARY_SELECT_TAXNAME");
	final static UI_Elements	MODAL_ITEM_SUMMARY_SELECT_TAXRATE			= UIFactory.getElements("MODAL_ITEM_SUMMARY_SELECT_TAXRATE");
	final static UI_Elements	MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT			= UIFactory.getElements("MODAL_ITEM_SUMMARY_SELECT_TAXAMOUNT");
	final static UI_Elements	MODAL_ITEM_SUMMARY_TAXES_TAB				= UIFactory.getElements("MODAL_ITEM_SUMMARY_TAXES_TAB");
	final static UI_Elements	ITEM_ADD_NEW_TAXES							= UIFactory.getElements("ITEM_ADD_NEW_TAXES");
	final static UI_Elements	MODAL_ITEM_TAX_SUB_TOTAL					= UIFactory.getElements("MODAL_ITEM_TAX_SUB_TOTAL");
	final static UI_Elements	ERROR_ITEM_LEVEL_TAX_ITEM_SUMMARY			= UIFactory.getElements("ERROR_ITEM_LEVEL_TAX_ITEM_SUMMARY");
	final static UI_Elements	BUTTON_REMOVE_ITEM_LEVEL_TAXES				= UIFactory.getElements("BUTTON_REMOVE_ITEM_LEVEL_TAXES");
	final static UI_Elements	LABEL_PLUS_X_TAXES_FROM_HEADER_ITEM_SUMMARY	= UIFactory.getElements("LABEL_PLUS_X_TAXES_FROM_HEADER_ITEM_SUMMARY");
	final static UI_Elements	LABEL_UNIT_TOTAL_PRICE_AT_TAX_ITEM_SUMMARY	= UIFactory.getElements("LABEL_UNIT_TOTAL_PRICE_AT_TAX_ITEM_SUMMARY");
	final static UI_Elements	TOOLTIP_TAXES_SECTION						= UIFactory.getElements("TOOLTIP_TAXES_SECTION");
	final static UI_Elements	ITEM_MODAL_TAX_CURRENCY_TYPE				= UIFactory.getElements("ITEM_MODAL_TAX_CURRENCY_TYPE");

	public String selectTaxType(WebDriver driver, String testCaseName, String selectBy, String value, int index) throws ActionBotException;

	public String fillTaxAmount(WebDriver driver, String testCaseName, String taxAmount) throws ActionBotException;

	public String getTaxrate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddNewTaxbtn(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isTaxSubTotalDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTaxName(WebDriver driver, String testCaseName, String TaxName) throws ActionBotException;

	public String fillTaxRate(WebDriver driver, String testCaseName, String taxRate) throws ActionBotException;

	public String getTaxeName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectTaxTypeOfItemLevelTax(WebDriver driver, String testCaseName, String taxType) throws ActionBotException;

	public boolean isErrorOnItemlevelTaxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearTaxRate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxRate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveTaxItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectNextRowTaxTye(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;

	public String enterNextRowTaxName(WebDriver driver, String testCaseName, String TaxName, int index) throws ActionBotException;

	public String enterNextRowTaxRate(WebDriver driver, String testCaseName, String taxRate, int index) throws ActionBotException;

	public void clickOnNextRowTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isLabelPlusXTaxesFromTheHeaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRemovalAllTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPlusXTaxesFromTheHeaderALabel(WebDriver driver, String testCaseName) throws ActionBotException, Exception;

	public String getUnitItemPriceToApplyTaxOn(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNegationSignPresentInUnitItemPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTooltipPresentInTaxSection(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnTooltipOfTaxSection(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxSubTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;

	public String fillTaxNameByIndex(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException;

}
