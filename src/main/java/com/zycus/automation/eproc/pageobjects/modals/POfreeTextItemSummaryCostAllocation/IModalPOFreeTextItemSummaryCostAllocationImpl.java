package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GLMap;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOFreeTextItemSummaryCostAllocationImpl implements IModalPOFreeTextItemSummaryCostAllocation
{
	static Logger logger = Logger.getLogger(IModalPOFreeTextItemSummaryCostAllocationImpl.class);

	@Override
	public void clickOnCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_COST_BOOKING_FREE_TEXT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cost booking");

	}

	@Override
	public String getCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver, FIELD_COST_CENTER_FREE_TEXT);
		ScreenShot.screenshot(driver, testCaseName, "After fetching cost center");
		return costCenter;
	}

	@Override
	public boolean isCostingAmountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, COSTING_AMOUNT_ERROR_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = ActionBot.getTextWithInElement(driver, TEXTBOX_GL_ACCOUNT);
		String temp[] = StringUtils.split(glAccount, ":");
		String gl_Account = temp[1].trim();
		GLMap glMap = new GLMap();
		if (gl_Account.equalsIgnoreCase(glMap.getGlAccount()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = null;
		glAccount = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT).getAttribute("value").trim();
		logger.info("GL Account : " + glAccount);
		return glAccount;
	}

	@Override
	public boolean isGLAccountFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT);
		String glAccount = ActionBot.getTextWithInElement(driver, TEXTBOX_GL_ACCOUNT);
		if (glAccount != null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
