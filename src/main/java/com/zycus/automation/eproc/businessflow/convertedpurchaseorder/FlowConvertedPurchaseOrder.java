package com.zycus.automation.eproc.businessflow.convertedpurchaseorder;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder.PageConvertedPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.reqViewPurchaseOrder.PageReqViewsPurchaseOrder;
import com.zycus.automation.exception.ActionBotException;

public class FlowConvertedPurchaseOrder
{

	public static PurchaseOrder getPurchaseOrderinfo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		purchaseOrder.setPoNo(PageConvertedPurchaseOrder.getPurchaseOrderSrNo(driver, testCaseName, index));

		purchaseOrder.setSupplierName(PageConvertedPurchaseOrder.getPurchaseOrderSupplier(driver, testCaseName, index));

		purchaseOrder.setBUName(PageConvertedPurchaseOrder.getPurchaseOrderBu(driver, testCaseName, index));

		purchaseOrder.setDeliveryDate(PageConvertedPurchaseOrder.getPurchaseOrderDeliverydate(driver, testCaseName, index));

		purchaseOrder.setPoTotal(PageConvertedPurchaseOrder.getPurchaseOrderPoTotal(driver, testCaseName, index));

		purchaseOrder.setBaseCurrency(PageConvertedPurchaseOrder.getPurchaseOrderBaseCurrency(driver, testCaseName, index));
		purchaseOrder.setStatus(PageConvertedPurchaseOrder.getPurchaseOrderStatus(driver, testCaseName, index));

		purchaseOrder.setReqNo(PageConvertedPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName, index));

		purchaseOrder.setItemName(PageConvertedPurchaseOrder.getPurchaseOrderItemName(driver, testCaseName, index));

		purchaseOrder.setDeliveryTo(PageConvertedPurchaseOrder.getPurchaseOrderDeliverTo(driver, testCaseName, index));
		purchaseOrder.setUnitPrice(PageConvertedPurchaseOrder.getPurchaseOrderUnitPrice(driver, testCaseName, index));
		purchaseOrder.setQty(PageConvertedPurchaseOrder.getPurchaseOrderQty(driver, testCaseName, index));
		purchaseOrder.setTotalPrice(PageConvertedPurchaseOrder.getPurchaseOrderTotalPrices(driver, testCaseName, index));

		return purchaseOrder;

	}

	public static PurchaseOrder getReqViewPurchaseOrderinfo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		purchaseOrder.setPoNo(PageReqViewsPurchaseOrder.getPurchaseOrderSrNo(driver, testCaseName, index));
		purchaseOrder.setSupplierName(PageReqViewsPurchaseOrder.getPurchaseOrderSupplier(driver, testCaseName, index));
		purchaseOrder.setBUName(PageReqViewsPurchaseOrder.getPurchaseOrderBu(driver, testCaseName, index));
		purchaseOrder.setDeliveryDate(PageReqViewsPurchaseOrder.getPurchaseOrderDeliverydate(driver, testCaseName, index));
		purchaseOrder.setPoTotal(PageReqViewsPurchaseOrder.getPurchaseOrderPoTotal(driver, testCaseName, index));
		purchaseOrder.setReqNo(PageReqViewsPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName));
		purchaseOrder.setStatus(PageReqViewsPurchaseOrder.getPurchaseOrderStatus(driver, testCaseName, index));
		PageReqViewsPurchaseOrder.clickOnExpandLink(driver, testCaseName, index);
		purchaseOrder.setItemNo(PageReqViewsPurchaseOrder.getPurchaseOrderItemNo(driver, testCaseName, index));
		purchaseOrder.setItemName(PageReqViewsPurchaseOrder.getPurchaseOrderItemName(driver, testCaseName, index));

		purchaseOrder.setQty(PageReqViewsPurchaseOrder.getPurchaseOrderQty(driver, testCaseName, index));
		purchaseOrder.setUnitPrice(PageReqViewsPurchaseOrder.getPurchaseOrderUnitPrice(driver, testCaseName, index));
		purchaseOrder.setTotalPrice(PageReqViewsPurchaseOrder.getPurchaseOrderTotalPrices(driver, testCaseName, index));

		return purchaseOrder;

	}
}
