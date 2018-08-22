package com.zycus.automation.eproc.pageobjects.pages.settings.costbookingsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageCostBookingSettings
{

	final UI_Elements	BUTTON_PROJECTS		= UIFactory.getElements("BUTTON_PROJECTS");
	final UI_Elements	BUTTON_BUDGET		= UIFactory.getElements("BUTTON_BUDGET");
	final UI_Elements	BUTTON_ACCOUNTING	= UIFactory.getElements("BUTTON_ACCOUNTING");

	public void clickOnProjects(WebDriver driver);

	public void clickOnBudget(WebDriver driver) throws ActionBotException;

	public void clickOnAccounting(WebDriver driver, String testCaseName) throws ActionBotException;

}
