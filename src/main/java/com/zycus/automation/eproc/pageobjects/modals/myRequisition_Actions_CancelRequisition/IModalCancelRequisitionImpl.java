package com.zycus.automation.eproc.pageobjects.modals.myRequisition_Actions_CancelRequisition;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalCancelRequisitionImpl extends IModalCancelRequisitionUtil implements IModalCancelRequisition
{

	@Override
	public void fillCancelRequisitionComment(WebDriver driver, String testcaseName, String comment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, CANCEL_REQUISITION_COMMENT_BOX, comment);

	}

	@Override
	public void toClickCancelRequisitionBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testcaseName, "Before clicking on cancel requisition button");
		ActionBot.click(driver, CANCEL_REQUISITION_BTN);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on cancel requisition button");

	}

	@Override
	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BOX);

	}

}
