/**
 * 
 */
package com.zycus.automation.eproc.businessflow.usermanagementflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.bo.UserSettings;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public interface IFlowUserManagement
{

	public User searchUser(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException;

	public UserSettings changeUserSettings(WebDriver driver, String testCaseName, User user, UserSettings userSettings) throws ActionBotException, FactoryMethodException;

	public UserSettings getUserSettings(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException;

	public User addUser(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException;

	public String getUserCostCenter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;
}
