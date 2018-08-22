/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.continueshopping;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.popups.defaults.PopUpDefaultScreenShots;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author puneet.sharma
 *
 */
public class IPopUpContinueShoppingImpl implements IPopUpContinueShopping
{

	@Override
	public boolean isPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.defaultMediumSleep();
		// PopUpDefaultScreenShots.isPopUpPresentScreenShotBefore(driver,
		// testCaseName);
		boolean result = ActionBot.isElementDisplayed(driver, CONTINUE_SHOPPING_POP_UP);
		PopUpDefaultScreenShots.isPopUpPresentScreenShotAfter(driver, testCaseName);
		return result;
	}

	@Override
	public void accept(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PopUpDefaultScreenShots.acceptScreenShotBefore(driver, testCaseName);
		PopUpDefaultScreenShots.acceptScreenShotAfter(driver, testCaseName);
	}

	@Override
	public void reject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PopUpDefaultScreenShots.rejectScreenShotBefore(driver, testCaseName);
		PopUpDefaultScreenShots.rejectScreenShotAfter(driver, testCaseName);
	}

	@Override
	public void closePopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		/// PopUpDefaultScreenShots.closePopUpScreenShotBefore(driver,
		/// testCaseName);
		ActionBot.click(driver, CLOSE);
		PopUpDefaultScreenShots.closePopUpScreenShotAfter(driver, testCaseName);
	}

	@Override
	public void moveOnPop(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		driver.switchTo().defaultContent();
	}

	@Override
	public void continueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitForElementToBeVisible(driver, 10, CONTINUE_SHOPPING);
		ActionBot.click(driver, CONTINUE_SHOPPING);
		PopUpDefaultScreenShots.after(driver, testCaseName, "continueShopping");
	}

}
