/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author payal.alag
 *
 */
public interface IModalPurchaseOrderSummaryBilling
{
	final UI_Elements			DELIVERY_ADDRESS_PO_SUMMARY			= UIFactory.getElements("DELIVERY_ADDRESS_PO_SUMMARY");
	final UI_Elements			BILL_TO_ADDRESS_PO_SUMMARY			= UIFactory.getElements("BILL_TO_ADDRESS_PO_SUMMARY");
	final UI_Elements			CURRENT_LOCATION					= UIFactory.getElements("CURRENT_LOCATION");
	final UI_Elements			OTHER_LOCATION						= UIFactory.getElements("OTHER_LOCATION");
	final UI_Elements			RADIO_BUTTON_OF_OTHER_LOCATION		= UIFactory.getElements("RADIO_BUTTON_OF_OTHER_LOCATION");
	final static UI_Elements	LABEL_COMPANY_PO_SUMMARY_OU			= UIFactory.getElements("LABEL_COMPANY_PO_SUMMARY_OU");
	final static UI_Elements	LABEL_BUSINESS_UNIT_PO_SUMMARY_OU	= UIFactory.getElements("LABEL_BUSINESS_UNIT_PO_SUMMARY_OU");
	final static UI_Elements	LABEL_LOCATION_PO_SUMMARY_OU		= UIFactory.getElements("LABEL_LOCATION_PO_SUMMARY_OU");
	final static UI_Elements	OU_COMPANY_PO_SUMMARY				= UIFactory.getElements("OU_COMPANY_PO_SUMMARY");
	final static UI_Elements	OU_BUSINESS_UNIT_PO_SUMMARY			= UIFactory.getElements("OU_BUSINESS_UNIT_PO_SUMMARY");
	final static UI_Elements	OU_LOCATION_PO_SUMMARY				= UIFactory.getElements("OU_LOCATION_PO_SUMMARY");

	public String getLocationOfDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLocationOfBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCurrentLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOtherLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnButtonOfOtherLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCompanyInOUNonEditable(WebDriver driver, String testCaseName) throws Exception;

	public boolean isBusinessUnitInOUNonEditable(WebDriver driver, String testCaseName) throws Exception;

	public boolean isLocationInOUNonEditable(WebDriver driver, String testCaseName) throws Exception;

	public String fillCompany(WebDriver driver, String testCaseName, String company) throws Exception;

	public String fillBusinessUnit(WebDriver driver, String testCaseName, String bu) throws Exception;

	public String fillLocation(WebDriver driver, String testCaseName, String location) throws Exception;

	public String getCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLocation(WebDriver driver, String testCaseName) throws ActionBotException;

}
