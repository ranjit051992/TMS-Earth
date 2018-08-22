package com.zycus.automation.eproc.pageobjects.popups.FreeTextSelectCategoryEForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPopUpSelectCategoryEFormImpl implements IPopUpSelectCategoryEForm
{

	@Override
	public void toClickContinueBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button[1]"));
		// ActionBot.defaultSleep();
		// ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BTN);

	}

}
