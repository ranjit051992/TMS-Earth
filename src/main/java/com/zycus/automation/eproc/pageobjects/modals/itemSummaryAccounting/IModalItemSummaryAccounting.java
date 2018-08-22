package com.zycus.automation.eproc.pageobjects.modals.itemSummaryAccounting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalItemSummaryAccounting
{
	final UI_Elements	BUTTON_ACCOUNTING_ITEM_SUMMARY		= UIFactory.getElements("BUTTON_ACCOUNTING_ITEM_SUMMARY");
	final UI_Elements	TEXTBOX_GL_TYPE_ITEM_SUMMARY_LABEL	= UIFactory.getElements("TEXTBOX_GL_TYPE_ITEM_SUMMARY_LABEL");
	final UI_Elements	TEXTBOX_GL_TYPE_ITEM_SUMMARY		= UIFactory.getElements("TEXTBOX_GL_TYPE_ITEM_SUMMARY");
	final UI_Elements	TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY		= UIFactory.getElements("TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY");
	final UI_Elements	BUTTON_SAVE_ITEM_SUMMARY			= UIFactory.getElements("BUTTON_SAVE_ITEM_SUMMARY");
	final UI_Elements	BUTTON_CANCEL_ITEM_SUMMARY			= UIFactory.getElements("BUTTON_CANCEL_ITEM_SUMMARY");
	final UI_Elements	ACCOUNTING_ERROR_MSG				= UIFactory.getElements("ACCOUNTING_ERROR_MSG");
	final UI_Elements	MODAL_ITEM_SUMMARY_DELIVERY			= UIFactory.getElements("MODAL_ITEM_SUMMARY_DELIVERY");
	final UI_Elements	REQ_BY_DATE_ITEM_LEVEL				= UIFactory.getElements("REQ_BY_DATE_ITEM_LEVEL");
	final UI_Elements	SELECT_MONTH						= UIFactory.getElements("SELECT_MONTH");
	final UI_Elements	SELECT_YEAR							= UIFactory.getElements("SELECT_YEAR");

	final UI_Elements	CONTRACT_NO							= UIFactory.getElements("CONTRACT_NO");
	public void clickOnAccounting(WebDriver driver) throws ActionBotException;

	public void clickOnCancel(WebDriver driver) throws ActionBotException;

	public void clickOnDelivery(WebDriver driver) throws ActionBotException;

	public void clickOnSave(WebDriver driver) throws ActionBotException;

	public String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException;

	public String fillGLType(WebDriver driver, String glType) throws ActionBotException;

	public String fillReqByDateAtItemLevel(WebDriver driver, String day, String month, String year) throws ActionBotException;

	public String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException;

	public boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException;

	public boolean isGLTypeFieldFilledEditable(WebDriver driver, String glType) throws ActionBotException;

	public boolean isGLTypeFieldFilled(WebDriver driver) throws ActionBotException;
}
