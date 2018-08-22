package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPOFreeTextItemSummaryCostAllocation
{
	final UI_Elements	BUTTON_COST_BOOKING_FREE_TEXT		= UIFactory.getElements("BUTTON_COST_BOOKING_FREE_TEXT");
	final UI_Elements	FIELD_COST_CENTER_FREE_TEXT			= UIFactory.getElements("FIELD_COST_CENTER_FREE_TEXT");
	final UI_Elements	COSTING_AMOUNT_ERROR_ITEM_SUMMARY	= UIFactory.getElements("COSTING_AMOUNT_ERROR_ITEM_SUMMARY");
	final UI_Elements	TEXTBOX_GL_ACCOUNT					= UIFactory.getElements("TEXTBOX_GL_ACCOUNT");

	public void clickOnCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostingAmountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGLAccountFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException;
}
