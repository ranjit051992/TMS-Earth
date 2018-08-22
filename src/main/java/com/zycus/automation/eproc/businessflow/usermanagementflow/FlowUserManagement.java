/**
 * 
 */
package com.zycus.automation.eproc.businessflow.usermanagementflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.bo.UserSettings;
import com.zycus.automation.eproc.businessflow.FactoryBusinessFlow;
import com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement.PageUserManagement;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowUserManagement
{
	static Logger logger = Logger.getLogger(FlowUserManagement.class);

	public static User searchUser(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException
	{
		User user1 = null;
		try
		{
			IFlowUserManagementImpl flowUserManagementImpl = FactoryBusinessFlow.getInstanceOfIFlowUserManagement();
			user1 = flowUserManagementImpl.searchUser(driver, testCaseName, user);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchUser " + e, e);
		}
		return user1;
	}

	public static UserSettings changeUserSettings(WebDriver driver, String testCaseName, User user, UserSettings userSettings) throws ActionBotException
	{
		UserSettings settings = null;
		try
		{
			IFlowUserManagementImpl flowUserManagementImpl = FactoryBusinessFlow.getInstanceOfIFlowUserManagement();
			settings = flowUserManagementImpl.changeUserSettings(driver, testCaseName, user, userSettings);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method changeUserSettings " + e, e);
		}
		return settings;
	}

	public static UserSettings getUserSettings(WebDriver driver, String testCaseName, User user) throws ActionBotException
	{
		UserSettings settings = null;
		try
		{
			IFlowUserManagementImpl flowUserManagementImpl = FactoryBusinessFlow.getInstanceOfIFlowUserManagement();
			settings = flowUserManagementImpl.getUserSettings(driver, testCaseName, user);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserSettings " + e, e);
		}
		return settings;
	}

	public static User addUser(WebDriver driver, String testCaseName, User user) throws ActionBotException
	{
		try
		{
			IFlowUserManagementImpl flowUserManagementImpl = FactoryBusinessFlow.getInstanceOfIFlowUserManagement();
			return flowUserManagementImpl.addUser(driver, testCaseName, user);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserSettings " + e, e);
		}
		return null;
	}

	public static void searchUserByEmailId(WebDriver driver, String testCaseName, String userName) throws ActionBotException
	{
		PageUserManagement.fillSearchData(driver, testCaseName, userName);
		PageUserManagement.selectSearchedUserByType(driver, testCaseName, "Email Id");
		PageUserManagement.clickOnSearchGoButton(driver, testCaseName);
	}

	public static String getUserCostCenter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IFlowUserManagementImpl flowUserManagementImpl = FactoryBusinessFlow.getInstanceOfIFlowUserManagement();
		return flowUserManagementImpl.getUserCostCenter(driver, testCaseName);
	}

}
