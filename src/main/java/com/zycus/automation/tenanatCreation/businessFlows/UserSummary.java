package com.zycus.automation.tenanatCreation.businessFlows;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPage;
import com.zycus.automation.tenanatCreation.pageObjects.userSummary.FlowUserSummary;
import com.zycus.automation.tenanatCreation.pageObjects.userSummary.UserSummaryImpl;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class UserSummary
{
	static Logger logger = Logger.getLogger(UserSummary.class);

	public static void addRoles(WebDriver driver, String testCaseName, List<Roles> allRoles) throws ActionBotException
	{
		ActionBot.click(driver, UserSummaryImpl.ROLE_EDIT_ICON);
		FlowUserSummary.selectRoles(driver, testCaseName, allRoles);
		ActionBot.waitForElementToBeEnable(driver, TmsCompanyCreationPage.BUTTON_UPDATE_USER, ActionBot.timeOut);
		ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_UPDATE_USER);
		ActionBot.waitForElementToBeEnable(driver, TmsCompanyCreationPage.BUTTON_OK, ActionBot.timeOut);
		ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_OK);
		
	}
}
