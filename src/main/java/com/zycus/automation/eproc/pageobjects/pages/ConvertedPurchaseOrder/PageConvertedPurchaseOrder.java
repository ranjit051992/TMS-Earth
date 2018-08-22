package com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageConvertedPurchaseOrder
{

	static Logger logger = Logger.getLogger(PageConvertedPurchaseOrder.class);

	public static void clickOnReleaselink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			ConvertedPurchaseOrder.clickOnReleaselink(driver, testCaseName, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleaselink " + e, e);
		}

	}

	public static List<WebElement> getListOfPurchaseOrderGenerated(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageConvertedPurchaseOrder convertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			return convertedPurchaseOrder.getListOfPurchaseOrderGenerated(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfPurchaseOrderGenerated " + e, e);
		}
		return null;
	}

	public static String getPurchaseOrderAction(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderAction = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderAction = ConvertedPurchaseOrder.getPurchaseOrderAction(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderAction " + e, e);
		}
		return PurchaseOrderAction;
	}

	public static String getPurchaseOrderBaseCurrency(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderBaseCurrency = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderBaseCurrency = ConvertedPurchaseOrder.getPurchaseOrderBaseCurrency(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderBaseCurrency " + e, e);
		}
		return PurchaseOrderBaseCurrency;
	}

	public static String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderBu = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderBu = ConvertedPurchaseOrder.getPurchaseOrderBu(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderBu " + e, e);
		}
		return PurchaseOrderBu;
	}

	public static String getPurchaseOrderDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderDeliverTo = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderDeliverTo = ConvertedPurchaseOrder.getPurchaseOrderDeliverTo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderDeliverTo " + e, e);
		}
		return PurchaseOrderDeliverTo;
	}

	public static String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderDeliverydate = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderDeliverydate = ConvertedPurchaseOrder.getPurchaseOrderDeliverydate(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderDeliverydate " + e, e);
		}
		return PurchaseOrderDeliverydate;
	}

	public static String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderItemName = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderItemName = ConvertedPurchaseOrder.getPurchaseOrderItemName(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderPoTotal = ConvertedPurchaseOrder.getPurchaseOrderPoTotal(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderQty = ConvertedPurchaseOrder.getPurchaseOrderQty(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderQty " + e, e);

		}
		return PurchaseOrderQty;
	}

	public static String getPurchaseOrderReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderReqNo = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderReqNo = ConvertedPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderReqNo " + e, e);
		}
		return PurchaseOrderReqNo;
	}

	public static String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderSrNo = null;
		try
		{
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderSrNo = ConvertedPurchaseOrder.getPurchaseOrderSrNo(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderStatus = ConvertedPurchaseOrder.getPurchaseOrderStatus(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderSupplier = ConvertedPurchaseOrder.getPurchaseOrderSupplier(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderTotalPrices = ConvertedPurchaseOrder.getPurchaseOrderTotalPrices(driver, testCaseName, index);
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
			IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
			PurchaseOrderUnitPrice = ConvertedPurchaseOrder.getPurchaseOrderUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderUnitPrice " + e, e);
		}
		return PurchaseOrderUnitPrice;
	}

	public static void clickOnPOLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageConvertedPurchaseOrder ConvertedPurchaseOrder = FactoryPage.getInstanceOf(IPageConvertedPurchaseOrderImpl.class);
		ConvertedPurchaseOrder.clickOnPOLink(driver, testCaseName);
	}
}