package com.zycus.automation.eproc.pageobjects.pages.purchaseOrderDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PagePurchaseOrderDetails
{

	public static void clickOnCostBookingLink(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		pagePurchaseOrder.clickOnCostBookingLink(driver);

	}

	public static String getProjectTaskName(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		return pagePurchaseOrder.getProjectTaskName(driver);

	}

	public static void clickOnReqLink(WebDriver driver, String testCasename) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		pagePurchaseOrder.clickOnReqLink(driver, testCasename);

	}

	public static boolean veirfyOpenedRequisitionDetailsNewWindow(WebDriver driver, String testCasename, String parentWindow) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		return pagePurchaseOrder.veirfyOpenedRequisitionDetailsNewWindow(driver, testCasename, parentWindow);

	}

	public static String getCommentForSupplier(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		return pagePurchaseOrder.getCommentForSupplier(driver);

	}

	public static boolean isCommentForSupplierAvailable(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		return pagePurchaseOrder.isCommentForSupplierAvailable(driver);

	}

	public static boolean isAllItemsAvailable(WebDriver driver, int item_count) throws FactoryMethodException, ActionBotException
	{
		IPagePurchaseOrderDetails pagePurchaseOrder = FactoryPage.getInstanceOf(PagePurchaseOrderDetailsImpl.class);
		return pagePurchaseOrder.isAllItemsAvailable(driver, item_count);

	}
}
