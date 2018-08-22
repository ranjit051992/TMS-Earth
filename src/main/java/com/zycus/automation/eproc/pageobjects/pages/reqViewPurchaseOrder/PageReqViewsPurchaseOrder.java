package com.zycus.automation.eproc.pageobjects.pages.reqViewPurchaseOrder;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageReqViewsPurchaseOrder
{
	static Logger logger = Logger.getLogger(PageReqViewsPurchaseOrder.class);

	public static void clickOnExpandLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			reqViewPurchaseOrder.clickOnExpandLink(driver, testCaseName, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleaselink " + e, e);
		}

	}

	public static String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderBu = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderBu = reqViewPurchaseOrder.getPurchaseOrderBu(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderBu " + e, e);
		}
		return PurchaseOrderBu;
	}

	public static String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderDeliverydate = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderDeliverydate = reqViewPurchaseOrder.getPurchaseOrderDeliverydate(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderBu " + e, e);
		}
		return PurchaseOrderDeliverydate;
	}

	public static String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderItemName = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderItemName = reqViewPurchaseOrder.getPurchaseOrderItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderItemName " + e, e);
		}
		return PurchaseOrderItemName;
	}

	public static String getPurchaseOrderPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderPoTotal = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderPoTotal = reqViewPurchaseOrder.getPurchaseOrderPoTotal(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderPoTotal " + e, e);
		}
		return PurchaseOrderPoTotal;
	}

	public static String getPurchaseOrderQty(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderQty = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderQty = reqViewPurchaseOrder.getPurchaseOrderQty(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderQty " + e, e);
		}
		return PurchaseOrderQty;
	}

	public static String getPurchaseOrderItemNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderItemNo = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderItemNo = reqViewPurchaseOrder.getPurchaseOrderItemNo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderItemNo " + e, e);

		}
		return PurchaseOrderItemNo;
	}

	public static String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderSrNo = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderSrNo = reqViewPurchaseOrder.getPurchaseOrderSrNo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderSrNo " + e, e);
		}
		return PurchaseOrderSrNo;

	}

	public static String getPurchaseOrderStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderStatus = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderStatus = reqViewPurchaseOrder.getPurchaseOrderStatus(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderStatus " + e, e);
		}
		return PurchaseOrderStatus;
	}

	public static String getPurchaseOrderSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderSupplier = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderSupplier = reqViewPurchaseOrder.getPurchaseOrderSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderSupplier " + e, e);
		}
		return PurchaseOrderSupplier;
	}

	public static String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderTotalPrices = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderTotalPrices = reqViewPurchaseOrder.getPurchaseOrderTotalPrices(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderTotalPrices " + e, e);
		}
		return PurchaseOrderTotalPrices;
	}

	public static String getPurchaseOrderUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderUnitPrice = null;
		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			PurchaseOrderUnitPrice = reqViewPurchaseOrder.getPurchaseOrderUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderUnitPrice " + e, e);
		}
		return PurchaseOrderUnitPrice;
	}

	/**
	 * @author omkar.jagdale
	 *         method to get Requisition Number
	 */
	public static String getPurchaseOrderReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageReqViewPurchaseOrder reqViewPurchaseOrder = FactoryPage.getInstanceOf(IPageReqViewPurchaseOrderImpl.class);
			return reqViewPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderReqNo " + e, e);
		}

		return null;
	}
}