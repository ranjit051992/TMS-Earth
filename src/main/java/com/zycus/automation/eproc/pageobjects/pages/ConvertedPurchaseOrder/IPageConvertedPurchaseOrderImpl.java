package com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageConvertedPurchaseOrderImpl implements IPageConvertedPurchaseOrder
{

	static Logger logger = Logger.getLogger(IPageConvertedPurchaseOrderImpl.class);

	@Override
	public void clickOnReleaselink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='action poActionSummary']/a"));

	}

	@Override
	public void clickOnReqNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnSrNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub

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

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Action");
		String PurchaseOrderAction = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/*[@class='action poActionSummary']"));
		logger.info("Purchase Order Action : " + PurchaseOrderAction);
		return PurchaseOrderAction;
	}

	@Override
	public String getPurchaseOrderBaseCurrency(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order BaseCurrency");
		List<WebElement> ele = ActionBot.findElements(driver, PO_BASE_CURRENCY_SUMMARY_PAGE);
		String PurchaseOrderBaseCurrency = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		logger.info("Purchase Order Base Currency : " + PurchaseOrderBaseCurrency);
		return PurchaseOrderBaseCurrency;
	}

	@Override
	public String getPurchaseOrderBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Bu");
		List<WebElement> ele = ActionBot.findElements(driver, PO_BU_SUMMARY_PAGE);
		String PurchaseOrderBu = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		logger.info("Purchase Order Business Unit: " + PurchaseOrderBu);
		return PurchaseOrderBu;

	}

	@Override
	public String getPurchaseOrderDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order DeliverTo");
		List<WebElement> ele = ActionBot.findElements(driver, DELIVER_TO_SUMMARY_PAGE);
		String PurchaseOrderDeliverTo = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		logger.info("Purchase Order Deliver To : " + PurchaseOrderDeliverTo);
		return PurchaseOrderDeliverTo;
	}

	@Override
	public String getPurchaseOrderDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Delivery date");
		List<WebElement> ele = ActionBot.findElements(driver, PO_DELIVERY_DATE_SUMMARY_PAGE);
		String PurchaseOrderDeliverydate = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		logger.info("Purchase Order Deliverydate : " + PurchaseOrderDeliverydate);
		return PurchaseOrderDeliverydate;
	}

	@Override
	public String getPurchaseOrderItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order ItemNameo");
		List<WebElement> ele = ActionBot.findElements(driver, PO_ITEM_NAME_SUMMARY_PAGE);
		String PurchaseOrderItemName = ActionBot.getTextWithInElement(driver, ele.get(index - 1));
		logger.info("Purchase Order Item Name : " + PurchaseOrderItemName);
		return PurchaseOrderItemName;
	}

	@Override
	public String getPurchaseOrderPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Delivery date");
		List<WebElement> ele = ActionBot.findElements(driver, PO_TOTAL_SUMMARY_PAGE);
		String PurchaseOrderPoTotal = ActionBot.getTextWithInElement(driver, ele.get(index - 1));
		logger.info("Purchase Order PoTotal : " + PurchaseOrderPoTotal);
		return PurchaseOrderPoTotal;
	}

	@Override
	public String getPurchaseOrderQty(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Qty");
		List<WebElement> ele = ActionBot.findElements(driver, ITEM_QUANTITY_SUMMARY_PAGE);
		String PurchaseOrderQty = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		return PurchaseOrderQty;
	}

	@Override
	public String getPurchaseOrderReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order ReqNo");
		List<WebElement> ele = ActionBot.findElements(driver, PO_REQ_NO_SUMMARY_PAGE);
		String PurchaseOrderReqNo = ActionBot.getTextWithInElement(driver, ele.get(index - 1));

		logger.info("Purchase Order Req No : " + PurchaseOrderReqNo);

		return PurchaseOrderReqNo;
	}

	@Override
	public String getPurchaseOrderSrNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order SrNo");
		List<WebElement> poSrNoList = ActionBot.findElements(driver, LINK_PURCHASE_ORDER_SR_NO_SUMMARY_PAGE);
		String Srno = ActionBot.getTextWithInElement(driver, poSrNoList.get(index - 1));
		logger.info("Purchase Order SrNo: " + Srno);
		return Srno;

	}

	@Override
	public String getPurchaseOrderStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Status");
		List<WebElement> list = ActionBot.findElements(driver, PURCHASE_ORDER_STATUS_SUMMARY_PAGE);
		String PurchaseOrderStatus = ActionBot.getTextWithInElement(driver, list.get(index - 1));
		logger.info("Purchase Order Status : " + PurchaseOrderStatus);
		return PurchaseOrderStatus;
	}

	@Override
	public String getPurchaseOrderSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Supplier");
		List<WebElement> list = ActionBot.findElements(driver, PURCHASE_ORDER_SUPPLIER_SUMMARY_PAGE);
		String Supplier = ActionBot.getTextWithInElement(driver, list.get(index - 1));
		logger.info("Purchase Order Supplier Name: " + Supplier);
		return Supplier;
	}

	@Override
	public String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order TotalPrices");
		List<WebElement> list = ActionBot.findElements(driver, PO_TOTAL_PRICE_SUMMARY_PAGE);
		String PurchaseOrderTotalPrices = ActionBot.getTextWithInElement(driver, list.get(index - 1));

		return PurchaseOrderTotalPrices;
	}

	@Override
	public String getPurchaseOrderUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order UnitPrice");
		List<WebElement> list = ActionBot.findElements(driver, PO_UNIT_PRICE_SUMMARY_PAGE);
		String PurchaseOrderUnitPrice = ActionBot.getTextWithInElement(driver, list.get(index - 1));

		logger.info("Purchase Order Unit Price : " + PurchaseOrderUnitPrice);
		return PurchaseOrderUnitPrice;
	}

	@Override
	public void clickOnPOLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_PO_CONVERTED_PO_PAGE);
		ActionBot.defaultSleep();

	}

}
