package com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageUpcomingRequisitionsImpl implements IPageUpcomingRequisitions
{

	@Override
	public String fillRequisitionNumber(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, TEXTBOX_REQUISTION_NUMBER);
		element.clear();
		element.sendKeys(reqNo);
		element.sendKeys(Keys.RETURN);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filling req no");

		String req_No = element.getAttribute("value");
		return req_No;
	}

	@Override
	public String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String req = ActionBot.getTextWithInElement(driver, LINK_UPCOMING_REQ_FIRST_ROW_REQ_NO);
		return req;
	}

	@Override
	public String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		return ActionBot.sendKeys(driver, TEXTBOX_REQUISTION_NAME, reqName);
	}

	@Override
	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UPCOMING_AMOUNT_FILTER);
	}

	@Override
	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, UPCOMING_MINIMUM_AMOUNT_RANGE, amount);
	}

	@Override
	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, UPCOMING_MAX_AMOUNT_RANGE, amount);
	}

	@Override
	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, UPCOMING_AMOUNT_FILTER_Button);
	}

	@Override
	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String amountString = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='upcomingRequisitions']//td[contains(@class,'totAmount')])[" + index + "]"));
		String amountString2 = "";
		for (int i = 0; i < amountString.length(); i++)
		{
			if (amountString.charAt(i) != ',')
			{
				amountString2 += amountString.charAt(i);
			}
		}
		String amount = amountString2.substring(4, amountString2.length() - 1);
		return amount;
	}

	@Override
	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='upcomingRequisitions']//td[contains(@class,'requisitionNo')])[" + index + "]"));
	}
}
