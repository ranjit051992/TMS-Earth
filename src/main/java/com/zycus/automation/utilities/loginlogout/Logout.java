package com.zycus.automation.utilities.loginlogout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.UserUtil;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.DriverException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.LoginLogout;

public class Logout implements ILogout
{
	@Override
	public void afterLogout(WebDriver driver, TestCase testCase, User user)
	{
		if (user != null)
		{
			if (!UserUtil.isUserAvaliable(user))
			{
				UserUtil.addUserToList(user);
			}
		}

	}

	@Override
	public void logout(WebDriver driver, TestCase testCase) throws LoginLogoutException, DriverException, ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_LOGOUT))
		{
			LoginLogout.logout(driver, testCase, BUTTON_LOGOUT.getBy());
		}
		else
		{
			LoginLogout.logout(driver, testCase, BUTTON_LOGOUT_ON_MASTER_DATA.getBy());
		}
		ActionBot.findElement(driver, LoginLogout.TEXTBOX_LOGIN_EMAIL_TEMP);
	}
}
