package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelRequisitionSummaryCommonImpl implements IModelRequisitionSummaryCommon
{

	@Override
	public void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CANCLEREQSUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Cancle Requisition Summary");

	}

	@Override
	public void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, SAVEREQSUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Save Requisition Summary");
	}

}
