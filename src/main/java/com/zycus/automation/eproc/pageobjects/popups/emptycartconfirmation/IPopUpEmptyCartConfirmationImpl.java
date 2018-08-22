/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.popups.defaults.PopUpDefaultScreenShots;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author puneet.sharma
 *
 */
public class IPopUpEmptyCartConfirmationImpl implements IPopUpEmptyCartConfirmation
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.
	 * IPopUpEmptyCartConfirmation#isPopUpPresent(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public boolean isPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.defaultMediumSleep();
		// PopUpDefaultScreenShots.isPopUpPresentScreenShotBefore(driver,
		// testCaseName);
		boolean result = ActionBot.isElementDisplayed(driver, CHECKOUT_CONFIRMATION_POP_UP);
		PopUpDefaultScreenShots.isPopUpPresentScreenShotAfter(driver, testCaseName);
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.
	 * IPopUpEmptyCartConfirmation#yes(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public void accept(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// PopUpDefaultScreenShots.acceptScreenShotBefore(driver, testCaseName);
		driver.switchTo().defaultContent();
		ActionBot.click(driver, YES);
		PopUpDefaultScreenShots.acceptScreenShotAfter(driver, testCaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.
	 * IPopUpEmptyCartConfirmation#no(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public void reject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// PopUpDefaultScreenShots.rejectScreenShotBefore(driver, testCaseName);
		ActionBot.click(driver, NO);
		PopUpDefaultScreenShots.rejectScreenShotAfter(driver, testCaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.
	 * IPopUpEmptyCartConfirmation#closePopUp(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public void closePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// PopUpDefaultScreenShots.closePopUpScreenShotBefore(driver,
		// testCaseName);
		ActionBot.click(driver, CLOSE);
		PopUpDefaultScreenShots.closePopUpScreenShotAfter(driver, testCaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.
	 * IPopUpEmptyCartConfirmation#moveOnPop(org.openqa.selenium.WebDriver,
	 * java.lang.String)
	 */
	@Override
	public void moveOnPop(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.defaultLowSleep();
		driver.switchTo().defaultContent();

	}

}
