package com.zycus.automation.eproc.pageobjects.popups.checkoutAddItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopupsAddItem
{
	final static UI_Elements	CHECKOUT_ADD_ITEM_SAVE		= UIFactory.getElements("CHECKOUT_ADD_ITEM_SAVE");
	final static UI_Elements	CHECKOUT_ADD_ITEM_DONTSAVE	= UIFactory.getElements("CHECKOUT_ADD_ITEM_DONTSAVE");

	void clickAddItemDontSave(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickAddItemSave(WebDriver driver, String testCaseName) throws ActionBotException;

}
