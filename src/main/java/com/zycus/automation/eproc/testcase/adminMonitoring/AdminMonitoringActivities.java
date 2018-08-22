package com.zycus.automation.eproc.testcase.adminMonitoring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.zycus.automation.bo.AdminMonitoring;
import com.zycus.automation.bo.User;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.pageobjects.pages.adminMonitoringActivity.PageAdminMonitoringActivity;
import com.zycus.automation.eproc.pageobjects.pages.adminMonitoringActivity.PagePasswordManager;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.loginlogout.ILogin;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

/**
 * @author kunal.ashar
 */

public class AdminMonitoringActivities extends TestDataProvider
{

	static Logger logger = Logger.getLogger(AdminMonitoringActivities.class);

	/**
	 * <b>Author: kunal.ashar</b> <b><br>
	 * <font color="blue">Method :</b>To re-trigger activities from admin page
	 */
	@Test(dataProvider = "dataProvider")
	public void adminMonitoringActivity(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		User user = new User();
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		try
		{

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase);

			// to get values for admin Monitoring
			AdminMonitoring adminMonitoring = ObjectCreation.getDefaultAdminMonitoringActivities();

			// Password manager login
			PagePasswordManager.loginPasswordManager(driver, testCaseName, adminMonitoring);

			String pwin = driver.getWindowHandle();

			// search for userAccount
			PagePasswordManager.searchUserAccount(driver, testCaseName, adminMonitoring);

			// to click on Resource Name and click on resoure url
			PagePasswordManager.navigateToResourcePage(driver, testCaseName);

			// to switch to eproc window and close it due to cookies issue
			Set<String> allWin = driver.getWindowHandles();
			allWin.remove(pwin);
			for (String str : allWin)
			{
				driver.switchTo().window(str);
				driver.close();
			}

			// again clicking on url
			ActionBot.defaultSleep();
			driver.switchTo().window(pwin);
			ActionBot.click(driver, PagePasswordManager.LINK_RESOURCE_URL);
			ActionBot.defaultSleep();

			// switching to eproc window
			allWin = driver.getWindowHandles();
			allWin.remove(pwin);
			for (String str : allWin)
			{
				driver.switchTo().window(str);
				ActionBot.waitForPageLoad(driver);
			}

			// to select eProc from product selection tab
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(ActionBot.findElement(driver, ILogin.EPROC_PRODUCT_SELECTION_TAB)).click().build().perform();
			ActionBot.waitForPageLoad(driver);

			// to navigate to admin page
			logger.info("\n================== Navigating to admin page =====================================");
			logger.info("\n====URL: " + adminMonitoring.getAdminUrl() + " =====");
			driver.get(adminMonitoring.getAdminUrl());
			ScreenShot.screenshot(driver, testCaseName, "After navigating to Admin Page");

			// to select activity to perform
			PageAdminMonitoringActivity.selectActivityToPerform(driver, testCaseName, adminMonitoring.getActivity());

			// to Search and perform actions
			PageAdminMonitoringActivity.searchEventsAndPerformAction(driver, testCaseName, adminMonitoring);

			// to start retrigger activity
			PageAdminMonitoringActivity.retriggerEvent(driver, testCaseName, adminMonitoring);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

}
