package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryMiscellaneous;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelItemSummaryMiscellaneous
{
	final static UI_Elements TEXT_FIELD_MISCELLANEOUS_TAB = UIFactory.getElements("TEXT_FIELD_MISCELLANEOUS_TAB");

	//methods

	public String getFieldType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void enterFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;
}
