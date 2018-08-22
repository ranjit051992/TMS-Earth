/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatebudgetvalidity;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalUpdateBudgetValidityImpl implements IModalUpdateBudgetValidity
{
	static Logger logger = Logger.getLogger(IModalUpdateBudgetValidityImpl.class);

	@Override
	public String selectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DATE_PICKER_UPDATE_VALIDITY_END_DATE);
		ActionBot.click(driver, DATE_PICKER_UPDATE_VALIDITY_END_DATE);
		ActionBot.selectDate(driver, day, month, year);
		ActionBot.defaultSleep();
		String selectedEndDate = ActionBot.getAttributeOfElement(driver, INPUT_UPDATE_VALIDITY_END_DATE, "value");
		logger.info("Selected End Date : " + selectedEndDate);
		ScreenShot.screenshot(driver, testCaseName, "After selecting end date");
		return selectedEndDate;
	}

	@Override
	public void clickOnUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Update Budget Validity");
		ActionBot.click(driver, BUTTON_UPDATE_BUDGET_VALIDITY);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_STATUS_OVERLAY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update Budget Validity");
	}

	@Override
	public void clickOnCloseUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Close Update Budget Validity");
		ActionBot.click(driver, BUTTON_CLOSE_BUDGET_VALIDITY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Update Budget Validity");
	}

}
