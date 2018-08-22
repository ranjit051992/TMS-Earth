package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsdocumenttypefilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalAllRequestsDocumentTypeFilterImpl implements IModalAllRequestsDocumentTypeFilter
{

	@Override
	public boolean clickToApplyRequisitionDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQUISITION_DOCUMENT_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting Requisition Document Type Filter");
		return ActionBot.isElementSelected(driver, REQUISITION_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean clickToApplyPurchaseOrderDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PURCHASE_ORDER_DOCUMENT_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting Purchase Order Document Type Filter");
		return ActionBot.isElementSelected(driver, PURCHASE_ORDER_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean clickToApplyPOAmendDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PO_AMEND_DOCUMENT_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting PO Amend Document Type Filter");
		return ActionBot.isElementSelected(driver, PO_AMEND_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean clickToApplyInvoiceDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, INVOICE_DOCUMENT_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting Invoice Document Type Filter");
		return ActionBot.isElementSelected(driver, INVOICE_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean isRequisitionDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Requisition Document Type Filter");
		return ActionBot.isElementSelected(driver, REQUISITION_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean isPurchaseOrderDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Document Type Filter");
		return ActionBot.isElementSelected(driver, PURCHASE_ORDER_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean isPOAmendDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "PO Amend Document Type Filter");
		return ActionBot.isElementSelected(driver, PO_AMEND_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public boolean isInvoiceDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Invoice Document Type Filter");
		return ActionBot.isElementSelected(driver, INVOICE_DOCUMENT_TYPE_FILTER);
	}

	@Override
	public void clickOnApplyDocumentTypeFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_TYPE_FILTER_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Document Type Filer Button");
	}

	@Override
	public void clickOnDocumentTypeCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_TYPE_CANCEL_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Document Type Cancel Button");
	}

	@Override
	public void clickOnDocumentTypeClearButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_TYPE_CLEAR_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Document Type Clear Button");
	}

}
