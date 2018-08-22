package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelRequisitionSummaryDelivery
{

	final static UI_Elements	DELIVERY_DELIVER_TO					= UIFactory.getElements("DELIVERY_DELIVER_TO");
	final static UI_Elements	DELIVERY_REQUIRED_BY				= UIFactory.getElements("DELIVERY_REQUIRED_BY");
	final static UI_Elements	DELIVERY_CLEAR_DATE					= UIFactory.getElements("DELIVERY_CLEAR_DATE");
	final static UI_Elements	DELIVERY_OPTION_OU_ADDRESS			= UIFactory.getElements("DELIVERY_OPTION_OU_ADDRESS");
	final static UI_Elements	DELIVERY_OPTION_OTHER_ADDRESSES		= UIFactory.getElements("DELIVERY_OPTION_OTHER_ADDRESSES");
	final static UI_Elements	DELIVERY_OPTION_MY_ADDRESSES		= UIFactory.getElements("DELIVERY_OPTION_MY_ADDRESSES");
	final static UI_Elements	DELIVERY_OPTION_MY_ADDRESSES_ACTIVE	= UIFactory.getElements("DELIVERY_OPTION_MY_ADDRESSES_ACTIVE");
	final static UI_Elements	DELIVERY_OU_ADDRESS					= UIFactory.getElements("DELIVERY_OU_ADDRESS");
	final static UI_Elements	DELIVERY_OTHER_ADDRESS				= UIFactory.getElements("DELIVERY_OTHER_ADDRESS");
	final static UI_Elements	DELIVERY_REFLECTED_OTHER_ADDRESS	= UIFactory.getElements("DELIVERY_REFLECTED_OTHER_ADDRESS");
	final static UI_Elements	DELIVERY_MY_ADDRESS					= UIFactory.getElements("DELIVERY_MY_ADDRESS");
	final static UI_Elements	DELIVERY_MY_ADDRESS_CREATE_NEW		= UIFactory.getElements("DELIVERY_MY_ADDRESS_CREATE_NEW");
	final static UI_Elements	DELIVERY_MY_ADDRESS_NAME			= UIFactory.getElements("DELIVERY_MY_ADDRESS_NAME");
	final static UI_Elements	DELIVERY_MY_ADDRESS_STREET1			= UIFactory.getElements("DELIVERY_MY_ADDRESS_STREET1");
	final static UI_Elements	DELIVERY_MY_ADDRESS_STREET2			= UIFactory.getElements("DELIVERY_MY_ADDRESS_STREET2");
	final static UI_Elements	DELIVERY_MY_ADDRESS_CITY			= UIFactory.getElements("DELIVERY_MY_ADDRESS_CITY");
	final static UI_Elements	DELIVERY_MY_ADDRESS_COUNTY			= UIFactory.getElements("DELIVERY_MY_ADDRESS_COUNTY");
	final static UI_Elements	DELIVERY_MY_ADDRESS_COUNTRY			= UIFactory.getElements("DELIVERY_MY_ADDRESS_COUNTRY");
	final static UI_Elements	DELIVERY_MY_ADDRESS_STATE			= UIFactory.getElements("DELIVERY_MY_ADDRESS_STATE");
	final static UI_Elements	DELIVERY_MY_ADDRESS_ZIP				= UIFactory.getElements("DELIVERY_MY_ADDRESS_ZIP");
	final static UI_Elements	DELIVERY_MY_ADDRESS_SAVE_ADD		= UIFactory.getElements("DELIVERY_MY_ADDRESS_SAVE_ADD");
	final static UI_Elements	DELIVERY_REQUIRED_BY_DATE_PICKER	= UIFactory.getElements("DELIVERY_REQUIRED_BY_DATE_PICKER");
	final static UI_Elements	SELECT_DELIVERY_MONTH				= UIFactory.getElements("SELECT_DELIVERY_MONTH");
	final static UI_Elements	SELECT_DELIVERY_YEAR				= UIFactory.getElements("SELECT_DELIVERY_YEAR");
	final static UI_Elements	DELIVERY_REQUIRED_BY_DATE			= UIFactory.getElements("DELIVERY_REQUIRED_BY_DATE");
	final static UI_Elements	DELIVERY_OTHER_ADDRESS_SELECTED		= UIFactory.getElements("DELIVERY_OTHER_ADDRESS_SELECTED");

	boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	void clearDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException;

	String fillDeliveryMyAddress(WebDriver driver, String testCaseName, String deliveryMyAddress) throws ActionBotException;

	String fillDeliveryNewAddressCity(WebDriver driver, String testCaseName, String newAddressCity) throws ActionBotException;

	String fillDeliveryNewAddressCountry(WebDriver driver, String testCaseName, String newAddressCountry) throws ActionBotException;

	String fillDeliveryNewAddressCounty(WebDriver driver, String testCaseName, String newAddressCounty) throws ActionBotException;

	String fillDeliveryNewAddressName(WebDriver driver, String testCaseName, String newAddressName) throws ActionBotException;

	String fillDeliveryNewAddressState(WebDriver driver, String testCaseName, String newAddressState) throws ActionBotException;

	String fillDeliveryNewAddressStreet1(WebDriver driver, String testCaseName, String newAddressStreet1) throws ActionBotException;

	String fillDeliveryNewAddressStreet2(WebDriver driver, String testCaseName, String newAddressStreet2) throws ActionBotException;

	int fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, int newAddressZip) throws ActionBotException;

	String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException;

	String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryOtherAddressesReflectedAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isDeliveryMyAddressTab(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;
}
