package com.zycus.automation.eproc.pageobjects.modals.myrequisitionstatusfilters;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalMyRequisitionStatusFilters
{
	final static UI_Elements	DRAFT_FILTER						= UIFactory.getElements("DRAFT_FILTER");
	final static UI_Elements	READY_FOR_APPROVAL_FILTER			= UIFactory.getElements("READY_FOR_APPROVAL_FILTER");
	final static UI_Elements	IN_APPROVAL_FILTER					= UIFactory.getElements("IN_APPROVAL_FILTER");
	final static UI_Elements	WITH_BUYER_FILTER					= UIFactory.getElements("WITH_BUYER_FILTER");
	final static UI_Elements	RETURNED_FOR_AMENDMENT				= UIFactory.getElements("RETURNED_FOR_AMENDMENT");
	final static UI_Elements	SCHEDULED_FILTER					= UIFactory.getElements("SCHEDULED_FILTER");
	final static UI_Elements	RELEASED_FILTER						= UIFactory.getElements("RELEASED_FILTER");
	final static UI_Elements	PARTIALLY_ORDERED					= UIFactory.getElements("PARTIALLY_ORDERED");
	final static UI_Elements	NOT_RECEIVED_FILTER					= UIFactory.getElements("NOT_RECEIVED_FILTER");
	final static UI_Elements	PARTIALLY_RECEIVED_FILTER			= UIFactory.getElements("PARTIALLY_RECEIVED");
	final static UI_Elements	FULLY_RECEIVED_FILTER				= UIFactory.getElements("FULLY_RECEIVED_FILTER");
	final static UI_Elements	REJECTED_FILTER						= UIFactory.getElements("REJECTED_FILTER");
	final static UI_Elements	CLOSED_FILTER						= UIFactory.getElements("CLOSED_FILTER");
	final static UI_Elements	CANCELLED_FILTER					= UIFactory.getElements("CANCELLED_FILTER");
	final static UI_Elements	RETURNED_WITH_QUOTE_FILTER			= UIFactory.getElements("RETURNED_WITH_QUOTE_FILTER");
	final static UI_Elements	SET_FOR_OUOTE_FILTER				= UIFactory.getElements("SET_FOR_OUOTE_FILTER");
	final static UI_Elements	CLEAR_FILTER_BTN					= UIFactory.getElements("CLEAR_FILTER_BTN");
	final static UI_Elements	FILTER_BTN							= UIFactory.getElements("FILTER_BTN");
	final static UI_Elements	CANCEL_BTN_STATUS_FILTER			= UIFactory.getElements("CANCEL_BTN_STATUS_FILTER");
	final static UI_Elements	EXPAND_RELEASED_BTN					= UIFactory.getElements("EXPAND_RELEASED_BTN");
	final static UI_Elements	IN_PROCESS_EXPAND					= UIFactory.getElements("IN_PROCESS_EXPAND");

	UI_Elements					CHECKBOX_TRANSFERRED_TO_ME_FILTER	= UIFactory.getElements("CHECKBOX_TRANSFERRED_TO_ME_FILTER");

	boolean clickOnApplyDraftFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyReadyForApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyInApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyWithBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyReturnForAmendmentFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyScheduledFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyReleasedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyNotReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyPartiallyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyFullyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyRejectedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyClosedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyCancelledFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplyReturnedWithQouteFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickOnApplySetForQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnClearFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnExpandReleasedBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnTransferredToMeCheckbox(WebDriver driver, String testcaseName) throws ActionBotException;
}
