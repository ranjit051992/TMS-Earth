/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsamountfilter;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAllRequestsAmountFilterImpl implements IModalAllRequestsAmountFilter
{

	Logger logger = Logger.getLogger(IModalAllRequestsAmountFilterImpl.class);

	@Override
	public double fillFromAmountRange(WebDriver driver, String testCaseName, double fromAmountRange) throws ActionBotException
	{
		String from_amount_range = Double.toString(fromAmountRange);
		ActionBot.sendKeys(driver, FROM_AMOUNT_RANGE, from_amount_range);
		ScreenShot.screenshot(driver, testCaseName, "After filling From Amount Range");
		from_amount_range = ActionBot.findElement(driver, FROM_AMOUNT_RANGE).getAttribute("value");
		logger.info("From Amount Range : " + from_amount_range);

		return Double.parseDouble(from_amount_range);

	}

	@Override
	public double fillToAmountRange(WebDriver driver, String testCaseName, double toAmountRange) throws ActionBotException
	{
		String to_amount_range = Double.toString(toAmountRange);
		ActionBot.sendKeys(driver, TO_AMOUNT_RANGE, to_amount_range);
		ScreenShot.screenshot(driver, testCaseName, "After filling To Amount Range");
		to_amount_range = ActionBot.findElement(driver, TO_AMOUNT_RANGE).getAttribute("value");
		logger.info("To Amount Range : " + to_amount_range);

		return Double.parseDouble(to_amount_range);

	}

	@Override
	public double getFromAmountRange(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After filling From Amount Range");
		String from_amount_range = ActionBot.findElement(driver, FROM_AMOUNT_RANGE).getAttribute("value");
		logger.info("From Amount Range : " + from_amount_range);

		return Double.parseDouble(from_amount_range);
	}

	@Override
	public double getToAmountRange(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After filling To Amount Range");
		String to_amount_range = ActionBot.findElement(driver, TO_AMOUNT_RANGE).getAttribute("value");
		logger.info("To Amount Range : " + to_amount_range);

		return Double.parseDouble(to_amount_range);
	}

	@Override
	public List<WebElement> selectAllCurrencies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allCurrencies = ActionBot.findElements(driver, SELECT_ALL_CURRENCIES);
		for (WebElement ele : allCurrencies)
		{
			ele.click();
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting all currencies");
		return allCurrencies;
	}

	@Override
	public void clickOnApplyAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_FILTER_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on apply amount filter button");
	}

	@Override
	public void clickOnCancelAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_CANCEL_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel button");
	}

	@Override
	public void clickOnClearAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_CLEAR_BUTTON);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Clear button");
	}

}
