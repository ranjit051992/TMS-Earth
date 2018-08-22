package com.zycus.automation.utilities.loginlogout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.DriverException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public interface ILogout
{
	final static UI_Elements	BUTTON_LOGOUT					= UIFactory.getElements("BUTTON_LOGOUT");
	final static UI_Elements	BUTTON_LOGOUT_ON_MASTER_DATA	= UIFactory.getElements("BUTTON_LOGOUT_ON_MASTER_DATA");

	public void afterLogout(WebDriver driver, TestCase testCase, User user);

	public void logout(WebDriver driver, TestCase testCase) throws LoginLogoutException, DriverException, ActionBotException;
}
