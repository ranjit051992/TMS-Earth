package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ItemDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemDetails
{

	final static UI_Elements	ITEM_NUMBER				= UIFactory.getElements("ITEM_NUMBER");
	final static UI_Elements	SHORT_DESCRIPTION		= UIFactory.getElements("SHORT_DESCRIPTION");
	final static UI_Elements	LONG_DESCRIPTION		= UIFactory.getElements("LONG_DESCRIPTION");
	final static UI_Elements	ITEM_TYPE				= UIFactory.getElements("ITEM_TYPE");
	final static UI_Elements	RECEIVE_BILLBY			= UIFactory.getElements("RECEIVE_BILLBY");
	final static UI_Elements	PRODUCT_CATEGORY		= UIFactory.getElements("PRODUCT_CATEGORY");
	final static UI_Elements	QUANTITY				= UIFactory.getElements("QUANTITY");
	final static UI_Elements	UOM						= UIFactory.getElements("UOM");
	final static UI_Elements	PRICE					= UIFactory.getElements("PRICE");
	final static UI_Elements	SOURCING_STATUS			= UIFactory.getElements("SOURCING_STATUS");
	final static UI_Elements	CURRENCY				= UIFactory.getElements("CURRENCY");
	final static UI_Elements	SHOW_EXTRA_FIELDS		= UIFactory.getElements("SHOW_EXTRA_FIELDS");
	final static UI_Elements	ADDRESS					= UIFactory.getElements("ADDRESS");
	final static UI_Elements	SUPPLIER_NAME			= UIFactory.getElements("SUPPLIER_NAME");
	final static UI_Elements	CONTRACT_NUMBER			= UIFactory.getElements("CONTRACT_NUMBER");
	final static UI_Elements	ADDRESS_ON_SUPPLIER_TAB	= UIFactory.getElements("ADDRESS_ON_SUPPLIER_TAB");
	final static UI_Elements	COPY_BTN				= UIFactory.getElements("COPY_BTN");
	final static UI_Elements	CLOSE_BTN				= UIFactory.getElements("CLOSE_BTN");

	String getItemNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getIShortDescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getLongdescription(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getItemType(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getReceiveBy(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getProductCategory(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	int getQuantity(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getUOM(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	float getPrice(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getSourcingStatus(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getCurrency(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	void toClickShowExtraFields(WebDriver driver, String testcaseName) throws ActionBotException;

	String getAddressFrmRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getSupplierName(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	String getAddressFrmSuppliersTab(WebDriver driver, String testcaseName) throws ActionBotException;

	String getContractNumber(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	void toClickCopyBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCloseBtn(WebDriver driver, String testcaseName) throws ActionBotException;
}
