/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addbudgetperiod;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAddBudgetPeriod
{
	static UI_Elements	DATE_PICKER_START_DATE_FOR_ADD_PERIOD		= UIFactory.getElements("DATE_PICKER_START_DATE_FOR_ADD_PERIOD");
	static UI_Elements	DATE_PICKER_END_DATE_FOR_ADD_PERIOD			= UIFactory.getElements("DATE_PICKER_END_DATE_FOR_ADD_PERIOD");
	static UI_Elements	INPUT_START_DATE_FOR_ADD_PERIOD				= UIFactory.getElements("INPUT_START_DATE_FOR_ADD_PERIOD");
	static UI_Elements	INPUT_END_DATE_FOR_ADD_PERIOD				= UIFactory.getElements("INPUT_END_DATE_FOR_ADD_PERIOD");
	static UI_Elements	INPUT_PERIOD_NAME							= UIFactory.getElements("INPUT_PERIOD_NAME");
	static UI_Elements	TEXT_AREA_PERIOD_DESCRIPTION				= UIFactory.getElements("TEXT_AREA_PERIOD_DESCRIPTION");
	static UI_Elements	BUTTON_ADD_PERIOD							= UIFactory.getElements("BUTTON_ADD_PERIOD");
	static UI_Elements	BUTTON_CLOSE_ADD_PERIOD						= UIFactory.getElements("BUTTON_CLOSE_ADD_PERIOD");
	static UI_Elements	BUTTON_CLEAR_BUDGET_END_DATE_IN_ADD_PERIOD	= UIFactory.getElements("BUTTON_CLEAR_BUDGET_END_DATE_IN_ADD_PERIOD");

	public String selectStartDateForPeriod(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectEndDateForPeriod(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillPeriodName(WebDriver driver, String testCaseName, String periodName) throws ActionBotException;

	public String fillPeriodDescription(WebDriver driver, String testCaseName, String periodDescription) throws ActionBotException;

	public void clickOnAddPeriodButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePeriodButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPeriodName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddPeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isClosePeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
