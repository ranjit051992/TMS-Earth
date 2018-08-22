package com.zycus.automation.eproc.pageobjects.popups.checkoutDeleteConfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopupsDeleteConfirmation
{
	final static UI_Elements	CHECKOUT_DELETE_YES			= UIFactory.getElements("CHECKOUT_DELETE_YES");
	final static UI_Elements	CHECKOUT_DELETE_NO			= UIFactory.getElements("CHECKOUT_DELETE_NO");
	final static UI_Elements	CHECKOUT_DELETE_ITEM_NAME	= UIFactory.getElements("CHECKOUT_DELETE_ITEM_NAME");

	void clickDeleteConfirmationNo(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDeleteConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeleteItemName(WebDriver driver, String testCaseName) throws ActionBotException;

}
