package com.zycus.automation.eproc.pageobjects.modals.forkingReasonForOredering;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelReasonForOrderingImpl implements IModelReasonForOrdering
{

	@Override
	public void clickCancleReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, FORKING_CANCLE_REASON_FOR_ORDERING);
		ScreenShot.screenshot(driver, testCaseName, "Cancle Reason For Ordering");
	}

	@Override
	public void clickSaveReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, FORKING_SAVE_REASON_FOR_ORDERING);
		ScreenShot.screenshot(driver, testCaseName, "Save Reason For Ordering");
	}

	@Override
	public String provideReasonForOrdering(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, FORKING_REASON_FOR_ORDERING_TEXT);
		ele.sendKeys(supplierComment);
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

}
