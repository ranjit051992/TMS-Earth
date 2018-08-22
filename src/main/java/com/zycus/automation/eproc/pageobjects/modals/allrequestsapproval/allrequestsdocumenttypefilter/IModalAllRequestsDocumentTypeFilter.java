package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsdocumenttypefilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalAllRequestsDocumentTypeFilter
{

	UI_Elements	REQUISITION_DOCUMENT_TYPE_FILTER	= UIFactory.getElements("REQUISITION_DOCUMENT_TYPE_FILTER");
	UI_Elements	PURCHASE_ORDER_DOCUMENT_TYPE_FILTER	= UIFactory.getElements("PURCHASE_ORDER_DOCUMENT_TYPE_FILTER");
	UI_Elements	PO_AMEND_DOCUMENT_TYPE_FILTER		= UIFactory.getElements("PO_AMEND_DOCUMENT_TYPE_FILTER");
	UI_Elements	INVOICE_DOCUMENT_TYPE_FILTER		= UIFactory.getElements("INVOICE_DOCUMENT_TYPE_FILTER");
	UI_Elements	DOCUMENT_TYPE_FILTER_BUTTON			= UIFactory.getElements("DOCUMENT_TYPE_FILTER_BUTTON");
	UI_Elements	DOCUMENT_TYPE_CANCEL_BUTTON			= UIFactory.getElements("DOCUMENT_TYPE_CANCEL_BUTTON");
	UI_Elements	DOCUMENT_TYPE_CLEAR_BUTTON			= UIFactory.getElements("DOCUMENT_TYPE_CLEAR_BUTTON");

	public boolean clickToApplyRequisitionDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyPurchaseOrderDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyPOAmendDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickToApplyInvoiceDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequisitionDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPurchaseOrderDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOAmendDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvoiceDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyDocumentTypeFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentTypeCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentTypeClearButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
