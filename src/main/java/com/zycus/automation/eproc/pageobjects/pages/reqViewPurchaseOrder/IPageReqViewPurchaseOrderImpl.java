package com.zycus.automation.eproc.pageobjects.pages.reqViewPurchaseOrder;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageReqViewPurchaseOrderImpl implements IPageReqViewPurchaseOrder
{
	static Logger logger = Logger.getLogger(IPageReqViewPurchaseOrderImpl.class);

	@Override
	public void clickOnExpandLink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='collapseArrCell']/a"));

	}

	@Override
	public List<WebElement> getListOfPurchaseOrderGenerated(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Converted POs");
		return ActionBot.findElements(driver, PURCHASE_Orders_SRNO);
	}

	@Override
	public String getPurchaseOrderAction(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPurchaseOrderBaseCurrency(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		return null;
	}

	@Override
	public String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Bu");
		String PurchaseOrderBu = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='BUCell']"));
		logger.info("Purchase Order BU: " + PurchaseOrderBu);
		return PurchaseOrderBu;

	}

	@Override
	public String getPurchaseOrderDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Delivery date");
		String PurchaseOrderDeliverydate = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='wrapper']//table[@class='zytbl guiGrid guiGrid-collapsible']/tbody/tr[" + index + "]/td[6]"));
		logger.info("Purchase Order Delivery date: " + PurchaseOrderDeliverydate);
		return PurchaseOrderDeliverydate;

	}

	@Override
	public String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order ItemName");
		String PurchaseOrderItemName = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[2]/a"));
		logger.info("Purchase Order ItemName" + PurchaseOrderItemName);
		return PurchaseOrderItemName;
	}

	@Override
	public String getPurchaseOrderPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order PoTotal");
		String PurchaseOrderPoTotal = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='iNum priceClr']"));
		logger.info("Purchase Order PoTotal " + PurchaseOrderPoTotal);
		return PurchaseOrderPoTotal;
	}

	@Override
	public String getPurchaseOrderQty(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Qty");
		String PurchaseOrderQty = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[2]//tbody/tr[" + index + "]/td[3]"));
		logger.info("Purchase Order Qty" + PurchaseOrderQty);
		return PurchaseOrderQty;
	}

	@Override
	public String getPurchaseOrderItemNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Item no");
		String PurchaseOrderItemNo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[contains(@class,'reqno')]"));
		logger.info("Purchase Order Item no" + PurchaseOrderItemNo);
		return PurchaseOrderItemNo;
	}

	@Override
	public String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order SrNo");
		String Srno = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='itmNo']"));
		logger.info("Purchase Order SRNO: " + Srno);
		return Srno;
	}

	@Override
	public String getPurchaseOrderStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Status");
		String PurchaseOrderStatus = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='action poStatusSummary']"));
		logger.info("Purchase Order Status" + PurchaseOrderStatus);
		return PurchaseOrderStatus;
	}

	@Override
	public String getPurchaseOrderSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Supplier");
		String Supplier = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='iDesc']"));
		logger.info("Purchase Order SRNO: " + Supplier);
		return Supplier;
	}

	@Override
	public String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String PurchaseOrderTotalPrices = null;
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Total Prices");
		try
		{
			String xpath = "(.//*[contains(@class,'cContent')]//*[contains(@class,'searchItemsGrid')]//td[5])[" + index + "]";
			PurchaseOrderTotalPrices = ActionBot.findElement(driver, By.xpath(xpath)).getText();
		}
		catch (Exception e)
		{
			logger.info("Exception Oberved: " + e);
		}
		logger.info("Purchase Order Total Prices" + PurchaseOrderTotalPrices);
		return PurchaseOrderTotalPrices;
	}

	@Override
	public String getPurchaseOrderUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order UnitPrice");
		String PurchaseOrderUnitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[2]//tr[" + index + "]/td[4]"));
		logger.info("Purchase Order UnitPrice" + PurchaseOrderUnitPrice);
		return PurchaseOrderUnitPrice;
	}

	@Override
	public String getPurchaseOrderReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requisitionNO = null;
		requisitionNO = ActionBot.getTextWithInElement(driver, PO_REQ_NO);
		logger.info("PO requisition NO :" + requisitionNO);
		return requisitionNO;
	}

}
