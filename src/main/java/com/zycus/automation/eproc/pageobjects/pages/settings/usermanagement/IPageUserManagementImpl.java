package com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageUserManagementImpl implements IPageUserManagement
{

	Logger logger = Logger.getLogger(IPageUserManagementImpl.class);

	@Override
	public String fillSearchData(WebDriver driver, String testCaseName, String userToBeSearched) throws ActionBotException
	{
		ActionBot.sendKeys(driver, SEARCH_FIELD, userToBeSearched);
		ScreenShot.screenshot(driver, testCaseName, "After filling search user data");
		String userToBe_searched = ActionBot.findElement(driver, SEARCH_FIELD).getAttribute("value");
		logger.info("Entered search user data : " + userToBe_searched);

		return userToBe_searched;
	}

	@Override
	public String selectSearchedUserByType(WebDriver driver, String testCaseName, String searchUserByType) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SEARCH_TYPE));
		if (searchUserByType.equalsIgnoreCase(IConstantsData.SEARCH_USER_BY_EMAIL_ID))
		{
			select.selectByIndex(1);
		}
		else if (searchUserByType.equalsIgnoreCase(IConstantsData.SEARCH_USER_BY_NAME))
		{
			select.selectByIndex(0);
		}
		else
		{
			logger.info("Invalid option");
		}

		ScreenShot.screenshot(driver, testCaseName, "After selecting search user by type");
		String searchUserBy_type = select.getFirstSelectedOption().toString().trim();
		logger.info("Selected searched user by type : " + searchUserBy_type);
		return searchUserBy_type;
	}

	@Override
	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SEARCH_GO);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, USER_INFO_LIST_PROCESSING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Search Go Button");

	}

	@Override
	public void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RETURN_TO_SET_UP_MODULE_USER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Return To Set Up Module");
	}

	@Override
	public String getSearchedUserNameFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String searchedUserName = ActionBot.getTextWithInElement(driver, SEARCHED_USER_NAME_FIRST_ROW);
		ScreenShot.screenshot(driver, testCaseName, "Searched user name first row");
		logger.info("Searched User Name : " + searchedUserName);
		return searchedUserName;
	}

	@Override
	public void clickOnEditSearchedUserButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_ROW_EDIT_BUTTON);
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "User settings before editing");
	}

	@Override
	public void clickOnAddUserLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_USER);
	}

	@Override
	public void clickOnEditUserLinkRowise(WebDriver driver, String testCaseName, int i) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='userInfoList']//a[text()='Edit'])[" + i + "]"), 60);
		ActionBot.click(driver, By.xpath("(.//*[@id='userInfoList']//a[text()='Edit'])[" + i + "]"));
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, USER_CURRENCY, 60);
		return ActionBot.getTextWithInElement(driver, USER_CURRENCY);
	}

}
