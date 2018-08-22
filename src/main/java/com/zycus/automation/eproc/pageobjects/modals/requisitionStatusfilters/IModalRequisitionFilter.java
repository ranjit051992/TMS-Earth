package com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalRequisitionFilter
{

	final static UI_Elements	DRAFT_FILTER				= UIFactory.getElements("DRAFT_FILTER");
	final static UI_Elements	READY_FOR_APPROVAL_FILTER	= UIFactory.getElements("READY_FOR_APPROVAL_FILTER");
	final static UI_Elements	IN_APPROVAL_FILTER			= UIFactory.getElements("IN_APPROVAL_FILTER");
	final static UI_Elements	WITH_BUYER_FILTER			= UIFactory.getElements("WITH_BUYER_FILTER");
	final static UI_Elements	SCHEDULED_FILTER			= UIFactory.getElements("SCHEDULED_FILTER");
	final static UI_Elements	RELEASED_FILTER				= UIFactory.getElements("RELEASED_FILTER");
	final static UI_Elements	PARTIALLY_ORDERED			= UIFactory.getElements("PARTIALLY_ORDERED");
	final static UI_Elements	NOT_RECEIVED_FILTER			= UIFactory.getElements("NOT_RECEIVED_FILTER");
	final static UI_Elements	PARTIALLY_RECEIVED_FILTER	= UIFactory.getElements("PARTIALLY_RECEIVED");
	final static UI_Elements	FULLY_RECEIVED_FILTER		= UIFactory.getElements("FULLY_RECEIVED_FILTER");
	final static UI_Elements	REJECTED_FILTER				= UIFactory.getElements("REJECTED_FILTER");
	final static UI_Elements	CLOSED_FILTER				= UIFactory.getElements("CLOSED_FILTER");
	final static UI_Elements	CANCELLED_FILTER			= UIFactory.getElements("CANCELLED_FILTER");
	final static UI_Elements	RETURNED_WITH_QUOTE_FILTER	= UIFactory.getElements("RETURNED_WITH_QUOTE_FILTER");
	final static UI_Elements	SET_FOR_OUOTE_FILTER		= UIFactory.getElements("SET_FOR_OUOTE_FILTER");

	// APPLY FILTER FUNCTIONS
	boolean clickToApplyDraftFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyReadyForApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyInApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyWithBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyScheduledFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyReleasedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyFullyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyRejectedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyClosedFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyCancelledFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplyReturnedWithQouteFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean clickToApplySetForQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException;

}
