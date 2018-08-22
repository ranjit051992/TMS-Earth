/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addtobasket;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAddToBasketImpl implements IModalAddToBasket
{

	static Logger logger = Logger.getLogger(IModalAddToBasketImpl.class);

	@Override
	public void clickOnSelectExistingBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_EXISTING_BASKET);
	}

	@Override
	public String selectExistingBasket(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		String selectedBasketName;
		Select select = new Select(ActionBot.findElement(driver, SELECT_BASKET));
		select.selectByVisibleText(basketName);
		selectedBasketName = select.getFirstSelectedOption().getText();
		logger.info("Selected existing basket : " + selectedBasketName);
		ScreenShot.screenshot(driver, testCaseName, "After selecting existing basket");
		return selectedBasketName;
	}

	@Override
	public void clickOnCreateNewBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, SELECT_NEW_BASKET, 10);
		ActionBot.click(driver, SELECT_NEW_BASKET);
	}

	@Override
	public String fillNewBasketName(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BASKET_NAME, basketName);
		String newBasketName = ActionBot.findElement(driver, TEXT_BASKET_NAME).getAttribute("value");
		logger.info("Created Basket Name : " + newBasketName);
		ScreenShot.screenshot(driver, testCaseName, "After filling new basket name");
		return newBasketName;
	}

	@Override
	public void clickOnAddToBasketButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_ADD_TO_BASKET_CREATE_BASKET, 10);
		ActionBot.click(driver, BUTTON_ADD_TO_BASKET_CREATE_BASKET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add to basket button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ADD_TO_BASKET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel button");
	}

	@Override
	public void waitTillAddToBasketSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, ADD_TO_BASKET_SUCCESS_MSG);
		ActionBot.defaultSleep();
	}

}
