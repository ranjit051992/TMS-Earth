package com.zycus.automation.eproc.businessflow.receiptItemInfo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.ReceiptItem;
import com.zycus.automation.eproc.pageobjects.pages.viewReceipt.IPageViewReceipt;
import com.zycus.automation.eproc.pageobjects.pages.viewReceipt.PageViewReceipt;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * 
 * @author omkar.jagdale
 *
 */
public class FlowReceiptInfo
{

	public static List<ReceiptItem> getReceiptItemInfo(WebDriver driver, String testCaseName, String receiptItemStatus) throws ActionBotException, FactoryMethodException
	{

		List<ReceiptItem> receiptItems = null;

		if (receiptItemStatus.equalsIgnoreCase(IConstantsData.RECEIVED))
		{
			return getItemReceivedInfo(driver, testCaseName);
		}

		if (receiptItemStatus.equalsIgnoreCase(IConstantsData.RETURNED_STATUS))
		{
			return getItemReturnedInfo(driver, testCaseName);
		}

		if (receiptItemStatus.equalsIgnoreCase(IConstantsData.BOTH))
		{
			receiptItems = new ArrayList<>();
			receiptItems.addAll(getItemReceivedInfo(driver, testCaseName));
			receiptItems.addAll(getItemReturnedInfo(driver, testCaseName));
		}

		return receiptItems;

	}

	public static List<ReceiptItem> getItemReceivedInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		List<ReceiptItem> receiptItems = null;
		List<WebElement> webElements = ActionBot.findElements(driver, By.xpath(IPageViewReceipt.ITEM_RECEIVED_TABLE_ID.getValue() + "//tr"));
		if (webElements.size() > 1)
		{
			receiptItems = new ArrayList<>();
			String itemNameAndSupplier[];
			for (int index = 1; index < webElements.size(); index++)
			{
				ReceiptItem receiptItem = new ReceiptItem();
				receiptItem.setStatus(IConstantsData.RECEIVED);
				itemNameAndSupplier = PageViewReceipt
					.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.ITEM_NAME_AND_SUPPLIER, index).split("(?i)Supplier");
				receiptItem.setItemName(itemNameAndSupplier[0]);
				receiptItem.setSupplierName(itemNameAndSupplier[1].replaceAll("[^A-Za-z& ]", ""));
				receiptItem.setItemRate(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.RATE, index));
				receiptItem
					.setRequisitionNo(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.REQUISITION_NO, index));
				receiptItem.setUnitPrice(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.UNIT_PRICE, index));
				receiptItem.setOrderedQuantity(
					PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.ORDERED_FILTER_LABEL, index));
				receiptItem
					.setReceivedQuantity(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.RECEIVED, index));
				receiptItem
					.setApprovedQuantity(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.APPROVED, index));
				receiptItem.setAcceptedGoodsValue(
					PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RECEIVED_TABLE_ID, IConstantsData.VALUE_OF_ACCEPTED_GOODS, index));
				//add item to list
				receiptItems.add(receiptItem);
			}
			return receiptItems;
		}

		return receiptItems;
	}

	public static List<ReceiptItem> getItemReturnedInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		List<ReceiptItem> receiptItems = null;
		List<WebElement> webElements = ActionBot.findElements(driver, By.xpath(IPageViewReceipt.ITEM_RETURNED_TABLE_ID.getValue() + "//tr"));
		if (webElements.size() > 1)
		{
			receiptItems = new ArrayList<>();

			String itemNameAndSupplier[];
			for (int index = 1; index < webElements.size(); index++)
			{
				ReceiptItem receiptItem = new ReceiptItem();
				receiptItem.setStatus(IConstantsData.RETURNED_STATUS);
				itemNameAndSupplier = PageViewReceipt
					.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.ITEM_NAME_AND_SUPPLIER, index).split("(?i)Supplier");
				receiptItem.setItemName(itemNameAndSupplier[0]);
				receiptItem.setSupplierName(itemNameAndSupplier[1].replaceAll("[^A-Za-z& ]", ""));
				receiptItem
					.setRequisitionNo(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.REQUISITION_NO, index));
				receiptItem.setReturnedQuantity(
					PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.RETURNED_QUANTITY_AMOUNT, index));
				receiptItem.setReturnedGoodsOrServiceValue(
					PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.VALUE_OF_RETURNED_GOODS_SERVICE, index));
				receiptItem.setReasonForReturn(
					PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.REASON_FOR_RETURN, index));
				receiptItem
					.setReturnMethod(PageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, IPageViewReceipt.ITEM_RETURNED_TABLE_ID, IConstantsData.RETURN_METHOD, index));
				//add item to list
				receiptItems.add(receiptItem);
			}
			return receiptItems;
		}
		return receiptItems;

	}

}
