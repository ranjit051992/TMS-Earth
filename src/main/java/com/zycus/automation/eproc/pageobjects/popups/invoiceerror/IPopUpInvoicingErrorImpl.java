/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoiceerror;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPopUpInvoicingErrorImpl implements IPopUpInvoicingError
{

	@Override
	public boolean isIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_IGNORE_AND_SUBMIT_INVOICE);
	}

	@Override
	public boolean isReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_REVIEW_INVOICE);
	}

	@Override
	public void clickOnIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (isIgnoreAndSubmitInvoiceButtonPresent(driver, testCaseName))
		{
			ActionBot.click(driver, BUTTON_IGNORE_AND_SUBMIT_INVOICE);
			ActionBot.defaultMediumSleep();
			ScreenShot.screenshot(driver, testCaseName, "After clicking on ignore and submit button");
		}
	}

	@Override
	public void clickOnReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (isReviewInvoiceButtonPresent(driver, testCaseName))
		{
			ActionBot.click(driver, BUTTON_REVIEW_INVOICE);
			ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Review button");
	}

}
