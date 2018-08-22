package com.zycus.automation.utilities.loginlogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.UserUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.businessflow.usermanagementflow.FlowUserManagement;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.LoginLogout;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class Login implements ILogin
{

	@Override
	public void login(WebDriver driver, TestCase testCase, User user) throws TestCaseException, ActionBotException, LoginLogoutException
	{
		UI_Elements product_Tab = null;
		if (ConfigProperty.getConfig("URL_type").toString().equalsIgnoreCase(IConstants.SSO))
		{
			product_Tab = EPROC_PRODUCT_SELECTION_TAB;
		}

		LoginLogout.login(driver, testCase, user.getUsername(), user.getPassword(), product_Tab, PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EPROC, null);

		/*
		 * LoginLogout.login(driver, testCase, user.getUsername(),
		 * user.getPassword(), product_Tab,
		 * By.xpath(".//*[@id='btnBigSearch']"), null);
		 */
	}

	@Override
	public void login(WebDriver driver, TestCase testCase, User user, String productName) throws TestCaseException, ActionBotException, LoginLogoutException
	{
		UI_Elements product_Tab = null;
		By productHomePageUniqueElement = null;
		if (ConfigProperty.getConfig("URL_type").toString().equalsIgnoreCase(IConstants.SSO))
		{
			if (productName.equalsIgnoreCase(IConstants.eProc))
			{
				product_Tab = EPROC_PRODUCT_SELECTION_TAB;
				productHomePageUniqueElement = PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EPROC;
			}
			else if (productName.equalsIgnoreCase(IConstants.eInvoice))
			{
				product_Tab = EINVOICE_PRODUCT_SELECTION_TAB;
				productHomePageUniqueElement = PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EINVOICE;
			}
			else if (productName.equalsIgnoreCase(IConstants.TMS))
			{
				product_Tab = TMS_PRODUCT_SELECTION_TAB;
				productHomePageUniqueElement = PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_TMS;
			}
			else if (productName.equalsIgnoreCase(IConstants.product_name_iContract))
			{
				product_Tab = ICONTRACT_PRODUCT_SELECTION_TAB;
				productHomePageUniqueElement = PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_ICONTRACT.getBy();
			}
		}

		LoginLogout.login(driver, testCase, user.getUsername(), user.getPassword(), product_Tab, productHomePageUniqueElement, productName);
	}

	@Override
	public User beforeLogin(WebDriver driver, TestCase testCase)
	{
		User user = UserUtil.getDefaultUsernameAndPassword();
		if (user != null)
		{
			
			if (!UserUtil.isUserAvaliable(user))
			{
				// user = UserUtil.getAvailableUser().get(0);
				user = UserUtil.getUserWithSpecificAttribute(Enum_UserList.ROLE, IConstants.Global_Role);
			}
		}
		UserUtil.removeUserFromList(user);
		return user;
	}

	@Override
	public void afterLogin(WebDriver driver, TestCase testCase, User user) throws TestCaseException, ActionBotException
	{
		ScreenShot.screenshot(driver, testCase.getTestMethodName(), "After logging Starting testcase ");
		ActionBot.defaultSleep();
		PageOnlineStore.clickOnGotItButton(driver, testCase.getTestMethodName());
		PageOnlineStore.clickOnOkButtonForBandwidthCheck(driver, testCase.getTestMethodName());
		PageOnlineStore.clickOnCancelCNSNotification(driver, testCase.getTestMethodName());

		// to switch to classic view from Rainbow
		PageOnlineStore.switchToClassicView(driver, testCase, user);

		if (ConfigProperty.getConfig("allowUserSetting").trim().equalsIgnoreCase("yes"))
		{
			user.setSearchUserByOption(IConstantsData.SEARCH_USER_BY_EMAIL_ID);
			user.setDisplayName(CommonUtilities.getUserDisplayName(driver, "User Settings"));
			user.setUserSettings(FlowUserManagement.getUserSettings(driver, "User Settings", user));
		}
	}

	@Override
	public void login(WebDriver driver, TestCase testCase, String role) throws TestCaseException, ActionBotException, LoginLogoutException
	{

	}

}
