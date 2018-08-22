package com.zycus.automation.eproc.pageobjects.tabs.freeTextFrom_ItemDetails_Tab;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;

public interface ITabsItemDetailsTab
{

	// No UI Elements are declared as they are directly called in functions
	// because of dynamic Item ID

	void toClickItemTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	void toClickRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

	void toClickSuppliersTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException;

}
