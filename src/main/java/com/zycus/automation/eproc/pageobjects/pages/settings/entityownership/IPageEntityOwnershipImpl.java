/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.entityownership;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageEntityOwnershipImpl implements IPageEntityOwnership
{
	static Logger logger = Logger.getLogger(IPageEntityOwnershipImpl.class);

	@Override
	public String fillCurrentOwnerName(WebDriver driver, String testCaseName, String currentOwnerName) throws ActionBotException
	{
		String enteredOwnerName = ActionBot.fillAutoCompleteField(driver, TEXTBOX_CURRENT_OWNER, currentOwnerName);
		ActionBot.defaultSleep();
		logger.info("Entered Current Owner Name : " + enteredOwnerName);
		return enteredOwnerName;
	}

	@Override
	public String fillNewOwnerName(WebDriver driver, String testCaseName, String newOwnerName) throws ActionBotException
	{
		String enteredOwnerName = ActionBot.fillAutoCompleteField(driver, TEXTBOX_NEW_OWNER, newOwnerName);
		ActionBot.defaultSleep();
		logger.info("Entered New Owner Name : " + enteredOwnerName);
		return enteredOwnerName;
	}

	@Override
	public void clickOnRequisitionCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_REQUISITION);
	}

	@Override
	public void clickOnStartChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Start Change Owner");
		ActionBot.click(driver, BUTTON_START_CHANGE_OWNER);
		ActionBot.waitForElementToBeDisplayed(driver, CHANGE_OWNER_PROCESSING_DIV, 20);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on After Change Owner");
	}

	@Override
	public void clickOnResetChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Reset Change Owner");
		ActionBot.click(driver, BUTTON_RESET_CHANGE_OWNER);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Reset Change Owner");
	}

	@Override
	public String fillSearchOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		String enteredOwnerName = ActionBot.sendKeys(driver, TEXTBOX_OWNERSHIP_SEARCH_BOX, ownerName);
		logger.info("Entered Owner Name for search : " + enteredOwnerName);
		return enteredOwnerName;
	}

	@Override
	public String selectSearchOwnerIn(WebDriver driver, String testCaseName, String searchOwnerIn) throws ActionBotException
	{
		String selectedOwner = ActionBot.selectElement(driver, SELECT_OWNERSHIP, IConstantsData.SELECT_BY_VISIBLE_TEXT, searchOwnerIn);
		logger.info("Selected Search Owner In Option : " + selectedOwner);
		return selectedOwner;
	}

	@Override
	public void clickOnSearchGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OWNERSHIP_SEARCH_GO);
	}

	@Override
	public void clickOnChangeOwner(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CHANGE_OWNER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on change owner");
	}

}
