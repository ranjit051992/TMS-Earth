package com.zycus.automation.services;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.UserUtil;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.DriverException;
import com.zycus.automation.exception.IExceptionConstants;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.utilities.loginlogout.Login;
import com.zycus.automation.utilities.loginlogout.Logout;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class LoginLogoutServices
{

	public static synchronized User login(WebDriver driver, TestCase testCase) throws Exception
	{
		User user = null;
		Login login = new Login();
		// before login
		user = login.beforeLogin(driver, testCase);
		try
		{
			login.login(driver, testCase, user);
			// after login
			login.afterLogin(driver, testCase, user);
		}
		catch (Exception e)
		{
			if (user != null)
			{
				if (!UserUtil.isUserAvaliable(user))
				{
					UserUtil.addUserToList(user);
				}
			}
			throw new LoginLogoutException(IExceptionConstants.LOGIN_EXCPECTION_MESSAGE + e, e);
		}
		return user;
	}

	public static void login(WebDriver driver, TestCase testCase, User user) throws LoginLogoutException
	{
		try
		{
			Login login = new Login();

			login.login(driver, testCase, user);
			login.afterLogin(driver, testCase, user);
		}
		catch (Exception e)
		{
			if (user != null)
			{
				if (!UserUtil.isUserAvaliable(user))
				{
					UserUtil.addUserToList(user);
				}
			}
			throw new LoginLogoutException(IExceptionConstants.LOGIN_EXCPECTION_MESSAGE + e, e);
		}
	}

	public static void logout(WebDriver driver, TestCase testCase, User user) throws ActionBotException, LoginLogoutException, DriverException
	{
		Logout logout = new Logout();
		logout.logout(driver, testCase);
	}

	public static void afterLogout(WebDriver driver, TestCase testCase, User user)
	{
		Logout logout = new Logout();
		logout.afterLogout(driver, testCase, user);
	}

	public static User login(WebDriver driver, TestCase testCase, String productName) throws ActionBotException, LoginLogoutException, Exception
	{
		User user = null;
		Login login = new Login();
		// before login
		user = login.beforeLogin(driver, testCase);
		try
		{
			login.login(driver, testCase, user, productName);

			// after login
			login.afterLogin(driver, testCase, user);
		}
		catch (Exception e)
		{
			if (user != null)
			{
				if (!UserUtil.isUserAvaliable(user))
				{
					UserUtil.addUserToList(user);
				}
			}
			throw new LoginLogoutException(IExceptionConstants.LOGIN_EXCPECTION_MESSAGE + e, e);
		}
		return user;
	}

	public static User login(WebDriver driver, TestCase testCase, User user, String productName) throws LoginLogoutException
	{
		try
		{
			Login login = new Login();
			login.login(driver, testCase, user, productName);
			login.afterLogin(driver, testCase, user);
		}
		catch (Exception e)
		{
			if (user != null)
			{
				if (!UserUtil.isUserAvaliable(user))
				{
					UserUtil.addUserToList(user);
				}
			}
			throw new LoginLogoutException(IExceptionConstants.LOGIN_EXCPECTION_MESSAGE + e, e);
		}
		return user;
	}

}
