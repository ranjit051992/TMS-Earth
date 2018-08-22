package com.zycus.automation.eproc.pageobjects.modals.masterdataSettingsProjectSelectBU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalSelectBUProjectSettingsImpl implements IModalSelectBUProjectSettings
{

	@Override
	public void clickOnBUCheckbox(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='buListTable']//tr[" + index + "]//input[@class='bulist_chkboxCode']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on checkbox of BU");

	}

	@Override
	public void clickOnSaveSelectedBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_BU);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save selected BU");

	}

	@Override
	public void clickOnBUCheckbox(WebDriver driver, String testCaseName, String BUName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='buListTable']//tr[.//*[text()='" + BUName + "']]//input[contains(@class,'bulist_chkboxCode')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on checkbox of BU");
	}
}
