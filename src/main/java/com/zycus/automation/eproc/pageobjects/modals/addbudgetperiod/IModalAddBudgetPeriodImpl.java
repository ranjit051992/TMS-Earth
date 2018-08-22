/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addbudgetperiod;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAddBudgetPeriodImpl implements IModalAddBudgetPeriod
{
	static Logger logger = Logger.getLogger(IModalAddBudgetPeriodImpl.class);

	@Override
	public String selectStartDateForPeriod(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_START_DATE_FOR_ADD_PERIOD);
		ActionBot.selectDate(driver, day, month, year);
		String selected_start_date = ActionBot.getAttributeOfElement(driver, INPUT_START_DATE_FOR_ADD_PERIOD, "value");
		logger.info("Selected Start Date : " + selected_start_date);
		return selected_start_date;
	}

	@Override
	public String selectEndDateForPeriod(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, DATE_PICKER_END_DATE_FOR_ADD_PERIOD);
		ActionBot.click(driver, DATE_PICKER_END_DATE_FOR_ADD_PERIOD);
		ActionBot.selectDate(driver, day, month, year);
		String selected_end_date = ActionBot.getAttributeOfElement(driver, INPUT_END_DATE_FOR_ADD_PERIOD, "value");
		logger.info("Selected End Date : " + selected_end_date);
		ActionBot.defaultSleep();
		return selected_end_date;
	}

	@Override
	public String fillPeriodName(WebDriver driver, String testCaseName, String periodName) throws ActionBotException
	{
		String entered_period_name = ActionBot.sendKeys(driver, INPUT_PERIOD_NAME, periodName);
		logger.info("Entered Period Name : " + entered_period_name);
		return entered_period_name;
	}

	@Override
	public String fillPeriodDescription(WebDriver driver, String testCaseName, String periodDescription) throws ActionBotException
	{
		String entered_period_desc = ActionBot.sendKeys(driver, TEXT_AREA_PERIOD_DESCRIPTION, periodDescription);
		logger.info("Entered Period Description : " + entered_period_desc);
		return entered_period_desc;
	}

	@Override
	public void clickOnAddPeriodButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding budget period");
		ActionBot.focusAndclick(driver, BUTTON_ADD_PERIOD);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After adding budget period");
	}

	@Override
	public void clickOnClosePeriodButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close budget period");
		ActionBot.click(driver, BUTTON_CLOSE_ADD_PERIOD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close budget period");
	}

	@Override
	public String getPeriodName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, INPUT_END_DATE_FOR_ADD_PERIOD);
		element.sendKeys(Keys.TAB);
		ActionBot.defaultSleep();
		element = ActionBot.findElement(driver, BUTTON_CLEAR_BUDGET_END_DATE_IN_ADD_PERIOD);
		element.sendKeys(Keys.TAB);
		ActionBot.defaultSleep();

		// ActionBot.click(driver, TEXT_AREA_PERIOD_DESCRIPTION);
		String periodName = ActionBot.getAttributeOfElement(driver, INPUT_PERIOD_NAME, "value");
		logger.info("Period Name : " + periodName);
		return periodName;
	}

	@Override
	public boolean isAddPeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_ADD_PERIOD);
	}

	@Override
	public boolean isClosePeriodButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_CLOSE_ADD_PERIOD);
	}

}
