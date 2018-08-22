package com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOSummaryDelivery
{
	final UI_Elements			ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY	= UIFactory.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY");
	final UI_Elements			DELIVER_TO									= UIFactory.getElements("DELIVER_TO");
	final UI_Elements			MODAL_DELIVERY_DATE							= UIFactory.getElements("MODAL_DELIVERY_DATE");
	final UI_Elements			MODAL_CLEAR_DELIVERY_DATE					= UIFactory.getElements("MODAL_CLEAR_DELIVERY_DATE");

	final static UI_Elements	REQUIRED_BY_DATE_PICKER						= UIFactory.getElements("REQUIRED_BY_DATE_PICKER");
	final static UI_Elements	SELECT_MONTH								= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements	SELECT_YEAR									= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements	REQUIRED_BY_DATE							= UIFactory.getElements("REQUIRED_BY_DATE");

	final UI_Elements			RADIO_BUTTON_OTHER_ADDRESS_PO_SUMMARY		= UIFactory.getElements("RADIO_BUTTON_OTHER_ADDRESS_PO_SUMMARY");
	final UI_Elements			TEXTBOX_OTHER_ADDRESS						= UIFactory.getElements("TEXTBOX_OTHER_ADDRESS");
	final UI_Elements			CHANGED_ADDRESS								= UIFactory.getElements("CHANGED_ADDRESS");
	final UI_Elements			DELIVERY_ADDRESS_HEADER						= UIFactory.getElements("DELIVERY_ADDRESS_HEADER");
	final UI_Elements			CHECKBOX_MY_ADDRESS_PO_SUMMARY				= UIFactory.getElements("CHECKBOX_MY_ADDRESS_PO_SUMMARY");
	final UI_Elements			TEXTBOX_CITY_PO_SUMMARY						= UIFactory.getElements("TEXTBOX_CITY_PO_SUMMARY");
	final UI_Elements			TEXTBOX_COUNTY_PO_SUMMARY					= UIFactory.getElements("TEXTBOX_COUNTY_PO_SUMMARY");
	final static UI_Elements	LINK_CREATE_NEW_ADDRESS_PO_SUMMARY			= UIFactory.getElements("LINK_CREATE_NEW_ADDRESS_PO_SUMMARY");
	final static UI_Elements	LINK_SELECT_FROM_LIST_ADDRESS_PO_SUMMARY	= UIFactory.getElements("LINK_SELECT_FROM_LIST_ADDRESS_PO_SUMMARY");
	final static UI_Elements	TAXES_NOT_APPLICABLE_POPUP_CONFIRM			= UIFactory.getElements("TAXES_NOT_APPLICABLE_POPUP_CONFIRM");
	final static UI_Elements	BUTTON_CONFORMATION_YES_POPUP				= UIFactory.getElements("BUTTON_CONFORMATION_YES_POPUP");
	final static UI_Elements	OU_ADDRESS_DELIVERY_PO_SUMMARY				= UIFactory.getElements("OU_ADDRESS_DELIVERY_PO_SUMMARY");
	final static UI_Elements	DELIVERY_OUADDRESS_RADIO_BTM				= UIFactory.getElements("DELIVERY_OUADDRESS_RADIO_BTM");
	final static UI_Elements	PO_MY_ADDRESS								= UIFactory.getElements("PO_MY_ADDRESS");
	final static UI_Elements	NEW_ADDRESS_NAME							= UIFactory.getElements("NEW_ADDRESS_NAME");
	final static UI_Elements	NEW_ADDRESS_ZIP_CODE						= UIFactory.getElements("NEW_ADDRESS_ZIP_CODE");
	final static UI_Elements	NEW_ADDRESS_STREET_NAME						= UIFactory.getElements("NEW_ADDRESS_STREET_NAME");
	final static UI_Elements	NEW_ADDRESS_COUNTRY_NAME					= UIFactory.getElements("NEW_ADDRESS_COUNTRY_NAME");
	final static UI_Elements	BUTTON_OK_CHANGE_ADDRESS_ALERT		= UIFactory.getElements("BUTTON_OK_CHANGE_ADDRESS_ALERT");
	
	final static UI_Elements	DELIVERY_MY_ADDRESS_SAVE_ADD		= UIFactory.getElements("DELIVERY_MY_ADDRESS_SAVE_ADD");
	
	final static UI_Elements	RADIO_BUTTON_DELIVER_TO_SINGLE_PERSON		= UIFactory.getElements("RADIO_BUTTON_DELIVER_TO_SINGLE_PERSON");
	
	
	// public String setRequiredBy(WebDriver driver, String testCaseName) throws
	// ActionBotException;
	public void clickOnClearReqByLink(WebDriver driver) throws ActionBotException;

	public void clickOnOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOtherAddressTextBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, InterruptedException;

	public String fillNewAddressName(WebDriver driver, String testCaseName, String addressName) throws ActionBotException, InterruptedException;

	public String fillNewAddressStreetName(WebDriver driver, String testCaseName, String addressStreetName) throws ActionBotException, InterruptedException;

	public int fillNewAddressPostalCode(WebDriver driver, String testCaseName, int zipcode) throws ActionBotException, InterruptedException;

	public String fillRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String isEditableDeliveryField(WebDriver driver, String testCaseName, String DeliverTo) throws ActionBotException;

	public boolean isHeaderAddressSameAsAddressSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTaxexChangeConfirmationPopUpDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMyAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickONTaxChangeConfirmationYesBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterCityName(WebDriver driver, String testCaseName, String cityName) throws ActionBotException;

	public String enterCountyName(WebDriver driver, String testCaseName, String countyName) throws ActionBotException;

	public int selectCountryName(WebDriver driver, String testCaseName, int countryName) throws ActionBotException;

	public String enterFreeTextCountyName(WebDriver driver, String testCaseName, String freeTextCountyName) throws ActionBotException;

	public void clickOnCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getChangedAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOUAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOUAdressCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillMyAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException;

	public String getDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillDeliverTo(WebDriver driver, String testCaseName, String deliverTo) throws ActionBotException;
}
