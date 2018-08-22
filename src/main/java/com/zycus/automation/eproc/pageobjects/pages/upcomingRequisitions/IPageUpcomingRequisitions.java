package com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageUpcomingRequisitions
{
	final static UI_Elements		TEXTBOX_REQUISTION_NUMBER			= UIFactory.getElements("TEXTBOX_REQUISTION_NUMBER");
	final static UI_Elements		LINK_UPCOMING_REQ_FIRST_ROW_REQ_NO	= UIFactory.getElements("LINK_UPCOMING_REQ_FIRST_ROW_REQ_NO");
	final static UI_Elements		TEXTBOX_REQUISTION_NAME				= UIFactory.getElements("TEXTBOX_REQUISTION_NAME");

	public final static UI_Elements	UPCOMING_AMOUNT_FILTER				= UIFactory.getElements("UPCOMING_AMOUNT_FILTER");
	public final static UI_Elements	UPCOMING_MINIMUM_AMOUNT_RANGE		= UIFactory.getElements("UPCOMING_MINIMUM_AMOUNT_RANGE");
	public final static UI_Elements	UPCOMING_MAX_AMOUNT_RANGE			= UIFactory.getElements("UPCOMING_MAX_AMOUNT_RANGE");
	public final static UI_Elements	UPCOMING_AMOUNT_FILTER_Button		= UIFactory.getElements("UPCOMING_AMOUNT_FILTER_Button");
	public final static UI_Elements	UPCOMING_CHECK_INR_INPUT_CURRENCIES	= UIFactory.getElements("UPCOMING_CHECK_INR_INPUT_CURRENCIES");

	public String fillRequisitionNumber(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException;

	public String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException;

	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;
}
