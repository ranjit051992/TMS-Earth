package com.zycus.automation.eproc.pageobjects.pages.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPagePOImpl implements IPagePO

{

	@Override
	public void clickOnAdd(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD);
	}

	@Override
	public void clickOnStandardPO(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.hover(driver, BUTTON_ADD);
		// ActionBot.defaultHighSleep();
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(ActionBot.findElement(driver,
		 * BUTTON_ADD)).build().perform();
		 */
		// ActionBot.waitForOperations(5000);

		ActionBot.focusAndclick(driver, BUTTON_STANDARD_PO);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String enterPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PO_NUMBER, poNumber);
		ScreenShot.screenshot(driver, testCaseName, "After entering the po number");
		WebElement element = ActionBot.findElement(driver, TEXTBOX_PO_NUMBER);
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		return null;
	}

	@Override
	public void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_ACTIONS);

	}

	@Override
	public void clickOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_NUMBER);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on po number");

	}

	@Override
	public void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_AMMENDED_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view ammended PO");

	}

	@Override
	public boolean isViewAmmendedPOPrsent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_VIEW_AMMENDED_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnBPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD);
		// ActionBot.hover(driver, BUTTON_ADD);
		ActionBot.click(driver, BUTTON_BLANKET_PO);
		ActionBot.defaultSleep();
	}

}
