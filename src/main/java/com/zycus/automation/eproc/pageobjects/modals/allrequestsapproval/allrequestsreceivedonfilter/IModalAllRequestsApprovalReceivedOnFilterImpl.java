package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsreceivedonfilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalAllRequestsApprovalReceivedOnFilterImpl implements IModalAllRequestsApprovalReceivedOnFilter
{
	Logger logger = Logger.getLogger(IModalAllRequestsApprovalReceivedOnFilterImpl.class);

	@Override
	public void clickOnFromDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FROM_DATE_PICKER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on From Date Picker");
	}

	@Override
	public void clickOnToDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TO_DATE_PICKER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on To Date Picker");
	}

	@Override
	public String selectFromDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DATE_MONTH));
		select.selectByValue(month);
		ScreenShot.screenshot(driver, testCaseName, "After selecting month");

		select = new Select(ActionBot.findElement(driver, SELECT_DATE_YEAR));
		select.selectByValue(year);
		ScreenShot.screenshot(driver, testCaseName, "After selecting year");

		ActionBot.click(driver, By.linkText(day));

		ScreenShot.screenshot(driver, testCaseName, "After selecting From Date");
		String selectedDate = ActionBot.findElement(driver, FROM_DATE_TEXT_FIELD).getAttribute("value");
		logger.info("Selected From Date : " + selectedDate);

		return selectedDate;

	}

	@Override
	public String selectToDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DATE_MONTH));
		select.selectByValue(month);
		ScreenShot.screenshot(driver, testCaseName, "After selecting month");

		select = new Select(ActionBot.findElement(driver, SELECT_DATE_YEAR));
		select.selectByValue(year);
		ScreenShot.screenshot(driver, testCaseName, "After selecting year");

		ActionBot.click(driver, By.linkText(day));

		ScreenShot.screenshot(driver, testCaseName, "After selecting To Date");
		String selectedDate = ActionBot.findElement(driver, TO_DATE_TEXT_FIELD).getAttribute("value");
		logger.info("Selected To Date : " + selectedDate);

		return selectedDate;
	}

	@Override
	public String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "From Date");
		String selectedDate = ActionBot.findElement(driver, FROM_DATE_TEXT_FIELD).getAttribute("value");
		logger.info("Selected From Date : " + selectedDate);

		return selectedDate;
	}

	@Override
	public String getToDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "To Date");
		String selectedDate = ActionBot.findElement(driver, TO_DATE_TEXT_FIELD).getAttribute("value");
		logger.info("Selected To Date : " + selectedDate);

		return selectedDate;
	}

	@Override
	public void clickOnReceivedOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_FILTER_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on apply received on filter button");
	}

	@Override
	public void clickOnReceivedOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_CANCEL_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on received on cancel button");
	}

	@Override
	public void clickOnReceivedOnClearButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_CLEAR_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking apply on received on clear button");
	}

}
