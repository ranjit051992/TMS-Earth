package com.zycus.automation.tenanatCreation.pageObjects.userSummary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.tenanatCreation.bo.Roles;

public class FlowUserSummary
{

	static Logger logger = Logger.getLogger(FlowUserSummary.class);

	public static void selectRoles(WebDriver driver, String testCaseName, List<Roles> roles) throws ActionBotException
	{
		try
		{
			UserSummaryImpl userSummary = FactoryPage.getInstanceOf(UserSummaryImpl.class);
			userSummary.selectRoles(driver, testCaseName, roles);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRoles " + e, e);
		}
	}
}
