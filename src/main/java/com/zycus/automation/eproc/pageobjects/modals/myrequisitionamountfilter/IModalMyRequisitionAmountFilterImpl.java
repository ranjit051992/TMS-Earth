package com.zycus.automation.eproc.pageobjects.modals.myrequisitionamountfilter;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalMyRequisitionAmountFilterImpl extends IModalMyRequisitionAmountFilterUtil implements IModalMyRequisitionAmountFilter
{

	static Logger logger = Logger.getLogger(IModalMyRequisitionAmountFilterImpl.class);

	@Override
	public int fillFromAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException
	{
		String frmAmt = String.valueOf(amount);
		ActionBot.sendKeys(driver, FROM_AMOUNT, frmAmt);
		String enteredAmt = ActionBot.findElement(driver, FROM_AMOUNT).getAttribute("value");
		logger.info("from Amount is:" + enteredAmt);
		int fromAmount = Integer.parseInt(enteredAmt);
		return fromAmount;
	}

	@Override
	public int fillToAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException
	{
		String toAmt = String.valueOf(amount);
		ActionBot.sendKeys(driver, TO_AMOUNT, toAmt);
		String enteredAmt = ActionBot.findElement(driver, TO_AMOUNT).getAttribute("value");
		logger.info("To Amount is:" + enteredAmt);
		int toAmount = Integer.parseInt(enteredAmt);
		return toAmount;
	}

	@Override
	public boolean checkINRCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CURRENCY_INR);
		if (ActionBot.findElement(driver, CURRENCY_INR).isSelected())
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	@Override
	public boolean checkUSDCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CURRENCY_INR);
		if (ActionBot.findElement(driver, CURRENCY_INR).isSelected())
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	@Override
	public void toClickClearFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_FILTER);

	}

	@Override
	public void toClickFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, FILTER_BTN_AMOUNT_FILTER);

	}

	@Override
	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BTN_AMOUNT_FILTER);

	}

}
