package com.zycus.automation.eproc.pageobjects.pages.reqViewPurchaseOrder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageReqViewPurchaseOrder
{

	final static UI_Elements	PURCHASE_Orders_SRNO			= UIFactory.getElements("PURCHASE_Orders_SRNO");

	final static UI_Elements	PURCHASE_Orders_SUPPLIER		= UIFactory.getElements("PURCHASE_Orders_SUPPLIER");

	final static UI_Elements	PURCHASE_Orders_BU				= UIFactory.getElements("PURCHASE_Orders_BU");

	final static UI_Elements	PURCHASE_Orders_DELIVERYDATE	= UIFactory.getElements("PURCHASE_Orders_DELIVERYDATE");

	final static UI_Elements	PURCHASE_Orders_POTOTAL			= UIFactory.getElements("PURCHASE_Orders_POTOTAL");

	final static UI_Elements	PURCHASE_Orders_BASECURRENCY	= UIFactory.getElements("PURCHASE_Orders_BASECURRENCY");

	final static UI_Elements	PURCHASE_Orders_STATUS			= UIFactory.getElements("PURCHASE_Orders_STATUS");

	final static UI_Elements	PURCHASE_Orders_ACTION			= UIFactory.getElements("PURCHASE_Orders_ACTION");

	final static UI_Elements	PURCHASE_Orders_REQNO			= UIFactory.getElements("PURCHASE_Orders_REQNO");

	final static UI_Elements	PURCHASE_Orders_ITEMNAME		= UIFactory.getElements("PURCHASE_Orders_ITEMNAME");

	final static UI_Elements	PURCHASE_Orders_DELIVERTO		= UIFactory.getElements("PURCHASE_Orders_DELIVERTO");

	final static UI_Elements	PURCHASE_Orders_UNITPRICE		= UIFactory.getElements("PURCHASE_Orders_UNITPRICE");

	final static UI_Elements	PURCHASE_Orders_QTY				= UIFactory.getElements("PURCHASE_Orders_QTY");

	final static UI_Elements	PURCHASE_Orders_TOTALPRICE		= UIFactory.getElements("PURCHASE_Orders_TOTALPRICE");

	final static UI_Elements	PURCHASE_Orders_EXPAND_BOTTOM	= UIFactory.getElements("PURCHASE_Orders_EXPAND_BOTTOM");

	final static UI_Elements	PO_REQ_NO						= UIFactory.getElements("PO_REQ_NO");

	void clickOnExpandLink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	List<WebElement> getListOfPurchaseOrderGenerated(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPurchaseOrderAction(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderBaseCurrency(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderQty(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderItemNo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderReqNo(WebDriver driver, String testCaseName) throws ActionBotException;
}
