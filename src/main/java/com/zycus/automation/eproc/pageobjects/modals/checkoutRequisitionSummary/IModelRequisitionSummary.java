package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelRequisitionSummary
{
	final static UI_Elements	BILLING_CURRENCY					= UIFactory.getElements("BILLING_CURRENCY");
	final static UI_Elements	BILLING_COMPANY						= UIFactory.getElements("BILLING_COMPANY");
	final static UI_Elements	BILLING_BU							= UIFactory.getElements("BILLING_BU");
	final static UI_Elements	BILLING_LOCATION					= UIFactory.getElements("BILLING_LOCATION");
	final static UI_Elements	BILLING_BILL_TO_ADDRESS				= UIFactory.getElements("BILLING_BILL_TO_ADDRESS");
	final static UI_Elements	BILLING_SEND_TO_ADDRESS				= UIFactory.getElements("BILLING_SEND_TO_ADDRESS");
	final static UI_Elements	SAVEREQSUMMARY						= UIFactory.getElements("SAVEREQSUMMARY");
	final static UI_Elements	CANCLEREQSUMMARY					= UIFactory.getElements("CANCLEREQSUMMARY");
	final static UI_Elements	DELIVERY_DELIVER_TO					= UIFactory.getElements("DELIVERY_DELIVER_TO");
	final static UI_Elements	DELIVERY_REQUIRED_BY				= UIFactory.getElements("DELIVERY_REQUIRED_BY");
	final static UI_Elements	DELIVERY_CLEAR_DATE					= UIFactory.getElements("DELIVERY_CLEAR_DATE");
	final static UI_Elements	DELIVERY_OPTION_OU_ADDRESS			= UIFactory.getElements("DELIVERY_OPTION_OU_ADDRESS");
	final static UI_Elements	DELIVERY_OPTION_OTHER_ADDRESSES		= UIFactory.getElements("DELIVERY_OPTION_OTHER_ADDRESSES");
	final static UI_Elements	DELIVERY_OPTION_MY_ADDRESSES		= UIFactory.getElements("DELIVERY_OPTION_MY_ADDRESSES");
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
	final static UI_Elements	COSTBOOKING_OPTION_SINGLE_CC		= UIFactory.getElements("COSTBOOKING_OPTION_SINGLE_CC");
	final static UI_Elements	COSTBOOKING_OPTION_MULTIPLE_CC		= UIFactory.getElements("COSTBOOKING_OPTION_MULTIPLE_CC");
	final static UI_Elements	COSTBOOKING_OPTION_LINEITEM_CC		= UIFactory.getElements("COSTBOOKING_OPTION_LINEITEM_CC");
	final static UI_Elements	COSTBOOKING_SINGLE_CC				= UIFactory.getElements("COSTBOOKING_SINGLE_CC");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_NAME		= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_NAME");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_AMOUNT		= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_AMOUNT");
	final static UI_Elements	COSTBOOKING_TOTAL_AMOUNT			= UIFactory.getElements("COSTBOOKING_TOTAL_AMOUNT");
	final static UI_Elements	COSTBOOKING_SINGLE_BUDGET			= UIFactory.getElements("COSTBOOKING_SINGLE_BUDGET");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_BUDGET		= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_BUDGET");

	boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	void clearDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException;

	String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException;

	String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException;

	String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException;

	String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException;

	String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException;

	String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException;

	String fillDeliveryMyAddress(WebDriver driver, String testCaseName, String deliveryMyAddress) throws ActionBotException;

	String fillDeliveryNewAddressCity(WebDriver driver, String testCaseName, String newAddressCity) throws ActionBotException;

	String fillDeliveryNewAddressCountry(WebDriver driver, String testCaseName, String newAddressCountry) throws ActionBotException;

	String fillDeliveryNewAddressCounty(WebDriver driver, String testCaseName, String newAddressCounty) throws ActionBotException;

	String fillDeliveryNewAddressName(WebDriver driver, String testCaseName, String newAddressName) throws ActionBotException;

	String fillDeliveryNewAddressState(WebDriver driver, String testCaseName, String newAddressState) throws ActionBotException;

	String fillDeliveryNewAddressStreet1(WebDriver driver, String testCaseName, String newAddressStreet1) throws ActionBotException;

	String fillDeliveryNewAddressStreet2(WebDriver driver, String testCaseName, String newAddressStreet2) throws ActionBotException;

	String fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, String newAddressZip) throws ActionBotException;

	String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException;

	String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException;

	String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException;

	String fillMultiCostCenterPercent(WebDriver driver, String testCaseName, String multiCostCenterPercent, int index) throws ActionBotException;

	String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, String multiCostCenterAmount, int index) throws ActionBotException;

	String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryOtherAddressesReflectedAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException;

}
