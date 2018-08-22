/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageUserManagement
{

	static Logger logger = Logger.getLogger(IPageUserManagement.class);

	public static String fillSearchData(WebDriver driver, String testCaseName, String userToBeSearched) throws ActionBotException
	{
		String result = null;

		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			result = userManagement.fillSearchData(driver, testCaseName, userToBeSearched);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchData " + e, e);
		}
		return result;
	}

	public static String selectSearchedUserByType(WebDriver driver, String testCaseName, String searchUserByType) throws ActionBotException
	{
		String result = null;

		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			result = userManagement.selectSearchedUserByType(driver, testCaseName, searchUserByType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSearchedUserByType " + e, e);
		}
		return result;
	}

	public static void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			userManagement.clickOnSearchGoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSearchGoButton " + e, e);
		}

	}

	public static void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			userManagement.clickOnReturnToSetUpModule(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnToSetUpModule " + e, e);
		}

	}

	public static String getSearchedUserNameFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			result = userManagement.getSearchedUserNameFirstRow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSearchedUserNameFirstRow " + e, e);
		}
		return result;
	}

	public static void clickOnEditSearchedUserButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			userManagement.clickOnEditSearchedUserButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditSearchedUserButton " + e, e);
		}
	}

	public static void clickOnAddUserLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			userManagement.clickOnAddUserLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddUserLink " + e, e);
		}
	}

	public static String getUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			result = userManagement.getUserCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserCurrency " + e, e);
		}
		return result;
	}

	public static void clickOnEditUserLinkRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageUserManagement userManagement = FactoryPage.getInstanceOfIPageUserManagement();
			userManagement.clickOnEditUserLinkRowise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditUserLinkRowise " + e, e);
		}
	}

}
