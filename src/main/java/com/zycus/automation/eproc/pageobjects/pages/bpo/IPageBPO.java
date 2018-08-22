/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.bpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageBPO
{
	static UI_Elements	TEXTBOX_ORDER_VALUE										= UIFactory.getElements("TEXTBOX_ORDER_VALUE");
	static UI_Elements	CHECKBOX_AUTO_UPDATE_ORDER_VALUE						= UIFactory.getElements("CHECKBOX_AUTO_UPDATE_ORDER_VALUE");
	static UI_Elements	DATEPICKER_FROM_VALIDITY_BPO_AGREEMENT_DETAILS			= UIFactory.getElements("DATEPICKER_FROM_VALIDITY_BPO_AGREEMENT_DETAILS");
	static UI_Elements	DATEPICKER_TO_VALIDITY_BPO_AGREEMENT_DETAILS			= UIFactory.getElements("DATEPICKER_TO_VALIDITY_BPO_AGREEMENT_DETAILS");
	static UI_Elements	DATEPICKER_VALIDITY_UNTIL_BPO_AGREEMENT_DETAILS			= UIFactory.getElements("DATEPICKER_VALIDITY_UNTIL_BPO_AGREEMENT_DETAILS");
	static UI_Elements	CHECKBOX_PREVENT_ORDER_OF_ITEMS_OF_OTHER_CATEGORIES		= UIFactory.getElements("CHECKBOX_PREVENT_ORDER_OF_ITEMS_OF_OTHER_CATEGORIES");
	static UI_Elements	CHECKBOX_PREVENT_CHANGE_OFPART_NO_AND_ITEM_DESCRIPTION	= UIFactory.getElements("CHECKBOX_PREVENT_CHANGE_OFPART_NO_AND_ITEM_DESCRIPTION");
	static UI_Elements	CHECKBOX_PREVENT_EXCEEDING_BPO_VALUE					= UIFactory.getElements("CHECKBOX_PREVENT_EXCEEDING_BPO_VALUE");
	static UI_Elements	CHECKBOX_REQUIRE_RECEIPT_AGAINST_BPO					= UIFactory.getElements("CHECKBOX_REQUIRE_RECEIPT_AGAINST_BPO");
	static UI_Elements	TEXTBOX_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS		= UIFactory.getElements("TEXTBOX_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS");

	static UI_Elements	TEXTBOX_VALIDITY_TO_DATE_BPO_AGREEMENT_DETAILS			= UIFactory.getElements("TEXTBOX_VALIDITY_TO_DATE_BPO_AGREEMENT_DETAILS");

	static UI_Elements	TEXTBOX_VALIDITY_UNTIL_DATE_BPO_AGREEMENT_DETAILS		= UIFactory.getElements("TEXTBOX_VALIDITY_UNTIL_DATE_BPO_AGREEMENT_DETAILS");
	static UI_Elements	PREVENT_EXCEEDING_BLANKET_ORDER_VALUE_SETTINGS			= UIFactory.getElements("PREVENT_EXCEEDING_BLANKET_ORDER_VALUE_SETTINGS");
	static UI_Elements	PREVENT_CHANGING_PART_NO_SETTINGS						= UIFactory.getElements("PREVENT_CHANGING_PART_NO_SETTINGS");
	static UI_Elements	PREVENT_ITEMS_OF_THE_OTHER_CATAGORIES_SETTINGS			= UIFactory.getElements("PREVENT_ITEMS_OF_THE_OTHER_CATAGORIES_SETTINGS");
	UI_Elements			BUTTON_ROLLBACK_BPO										= UIFactory.getElements("BUTTON_ROLLBACK_BPO");
	UI_Elements			PROGRESSING_DIV_ROLL_BACK_BPO							= UIFactory.getElements("PROGRESSING_DIV_ROLL_BACK_BPO");
	static UI_Elements	LINK_COPY_FIRST_ITEM									= UIFactory.getElements("LINK_COPY_FIRST_ITEM");
	static UI_Elements	LABEL_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS			= UIFactory.getElements("LABEL_VALIDITY_FROM_DATE_BPO_AGREEMENT_DETAILS");
	UI_Elements			LABEL_TOTAL_AMOUNT_AT_TOP								= UIFactory.getElements("LABEL_TOTAL_AMOUNT_AT_TOP");
	UI_Elements			RADIO_BUTTON_ORDER_TYPE_RELEASE							= UIFactory.getElements("RADIO_BUTTON_ORDER_TYPE_RELEASE");
	UI_Elements			RADIO_BUTTON_ORDER_TYPE_DIRECT_INVOICE					= UIFactory.getElements("RADIO_BUTTON_ORDER_TYPE_DIRECT_INVOICE");
	UI_Elements			ALERT_POPUP_TAXES_IF_DEFINED_OK_BUTTON					= UIFactory.getElements("ALERT_POPUP_TAXES_IF_DEFINED_OK_BUTTON");

	public void clickOnAlertPopUpTaxesIfDefinedOkButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillOrderValue(WebDriver driver, String testCaseName, String orderValue) throws ActionBotException;

	public String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAutoUpdate(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFromValiditydateDisplayedAslabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDatePickerOfFromValidity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDatePickerOfToValidity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDatePickerOfUntilValidity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getUntilValidityDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventItemsOfOtherCategoryToBeOdredred(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventChangingPartNoAndItemDescription(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventExceedingBPOValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventExceedingTheBlanketOrderCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventChangingPartNoCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreventItemsOfOtherCatagories(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRequireReceiptAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectUntilValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public void clickOnRollBackButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnFirstItemCopyLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOrderTypeRelease(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOrderTypeDirectInvoicing(WebDriver driver, String testCaseName) throws ActionBotException;

}
