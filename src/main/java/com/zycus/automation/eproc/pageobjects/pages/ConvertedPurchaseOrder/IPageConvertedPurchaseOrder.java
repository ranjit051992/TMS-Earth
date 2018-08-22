package com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageConvertedPurchaseOrder
{

	final static UI_Elements	PURCHASE_Orders_SRNO					= UIFactory.getElements("PURCHASE_Orders_SRNO");

	final static UI_Elements	PURCHASE_Orders_SUPPLIER				= UIFactory.getElements("PURCHASE_Orders_SUPPLIER");

	final static UI_Elements	PURCHASE_Orders_BU						= UIFactory.getElements("PURCHASE_Orders_BU");

	final static UI_Elements	PURCHASE_Orders_DELIVERYDATE			= UIFactory.getElements("PURCHASE_Orders_DELIVERYDATE");

	final static UI_Elements	PURCHASE_Orders_POTOTAL					= UIFactory.getElements("PURCHASE_Orders_POTOTAL");

	final static UI_Elements	PURCHASE_Orders_BASECURRENCY			= UIFactory.getElements("PURCHASE_Orders_BASECURRENCY");

	final static UI_Elements	PURCHASE_Orders_STATUS					= UIFactory.getElements("PURCHASE_Orders_STATUS");

	final static UI_Elements	PURCHASE_Orders_ACTION					= UIFactory.getElements("PURCHASE_Orders_ACTION");

	final static UI_Elements	PURCHASE_Orders_REQNO					= UIFactory.getElements("PURCHASE_Orders_REQNO");

	final static UI_Elements	PURCHASE_Orders_ITEMNAME				= UIFactory.getElements("PURCHASE_Orders_ITEMNAME");

	final static UI_Elements	PURCHASE_Orders_DELIVERTO				= UIFactory.getElements("PURCHASE_Orders_DELIVERTO");

	final static UI_Elements	PURCHASE_Orders_UNITPRICE				= UIFactory.getElements("PURCHASE_Orders_UNITPRICE");

	final static UI_Elements	PURCHASE_Orders_QTY						= UIFactory.getElements("PURCHASE_Orders_QTY");

	final static UI_Elements	PURCHASE_Orders_TOTALPRICE				= UIFactory.getElements("PURCHASE_Orders_TOTALPRICE");

	final static UI_Elements	LINK_VIEW_PO_CONVERTED_PO_PAGE			= UIFactory.getElements("LINK_VIEW_PO_CONVERTED_PO_PAGE");

	final static UI_Elements	LINK_PURCHASE_ORDER_SR_NO_SUMMARY_PAGE	= UIFactory.getElements("LINK_PURCHASE_ORDER_SR_NO_SUMMARY_PAGE");

	final static UI_Elements	PURCHASE_ORDER_STATUS_SUMMARY_PAGE		= UIFactory.getElements("PURCHASE_ORDER_STATUS_SUMMARY_PAGE");

	final static UI_Elements	PURCHASE_ORDER_SUPPLIER_SUMMARY_PAGE	= UIFactory.getElements("PURCHASE_ORDER_SUPPLIER_SUMMARY_PAGE");

	final static UI_Elements	PO_BU_SUMMARY_PAGE						= UIFactory.getElements("PO_BU_SUMMARY_PAGE");

	final static UI_Elements	PO_DELIVERY_DATE_SUMMARY_PAGE			= UIFactory.getElements("PO_DELIVERY_DATE_SUMMARY_PAGE");

	final static UI_Elements	PO_TOTAL_SUMMARY_PAGE					= UIFactory.getElements("PO_TOTAL_SUMMARY_PAGE");

	final static UI_Elements	PO_BASE_CURRENCY_SUMMARY_PAGE			= UIFactory.getElements("PO_BASE_CURRENCY_SUMMARY_PAGE");

	final static UI_Elements	PO_REQ_NO_SUMMARY_PAGE					= UIFactory.getElements("PO_REQ_NO_SUMMARY_PAGE");

	final static UI_Elements	PO_ITEM_NAME_SUMMARY_PAGE				= UIFactory.getElements("PO_ITEM_NAME_SUMMARY_PAGE");

	final static UI_Elements	DELIVER_TO_SUMMARY_PAGE					= UIFactory.getElements("DELIVER_TO_SUMMARY_PAGE");

	final static UI_Elements	PO_UNIT_PRICE_SUMMARY_PAGE				= UIFactory.getElements("PO_UNIT_PRICE_SUMMARY_PAGE");

	final static UI_Elements	PO_TOTAL_PRICE_SUMMARY_PAGE				= UIFactory.getElements("PO_TOTAL_PRICE_SUMMARY_PAGE");

	final static UI_Elements	ITEM_QUANTITY_SUMMARY_PAGE				= UIFactory.getElements("ITEM_QUANTITY_SUMMARY_PAGE");

	String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderBaseCurrency(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderAction(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderQty(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickOnSrNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickOnReqNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickOnReleaselink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	List<WebElement> getListOfPurchaseOrderGenerated(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPOLink(WebDriver driver, String testCaseName) throws ActionBotException;

}
