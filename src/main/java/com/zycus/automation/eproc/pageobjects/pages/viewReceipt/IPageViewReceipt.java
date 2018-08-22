package com.zycus.automation.eproc.pageobjects.pages.viewReceipt;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageViewReceipt
{
	final static UI_Elements	LABEL_SHIPPED_VIA_TEXT	= UIFactory.getElements("LABEL_SHIPPED_VIA_TEXT");
	final static UI_Elements	ITEM_RECEIVED_TABLE_ID	= UIFactory.getElements("ITEM_RECEIVED_TABLE_ID");
	final static UI_Elements	ITEM_RETURNED_TABLE_ID	= UIFactory.getElements("ITEM_RETURNED_TABLE_ID");

	public String getShippedViaLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemInfoByHeaderName(WebDriver driver, String testCaseName, UI_Elements ui_Elements, String headerName, int index) throws ActionBotException;

}
