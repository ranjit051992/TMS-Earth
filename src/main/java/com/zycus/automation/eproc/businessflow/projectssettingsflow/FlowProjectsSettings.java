package com.zycus.automation.eproc.businessflow.projectssettingsflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.ProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.IPageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.PageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class FlowProjectsSettings
{

	static Logger				logger					= Logger.getLogger(FlowProjectsSettings.class);
	final static UI_Elements	SUCCESSFUL_SAVE_MESSAGE	= UIFactory.getElements("SUCCESSFUL_SAVE_MESSAGE");

	/**
	 * 
	 * <b>Created On</b> : 19-Nov-2014 : 1:14:16 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : changeProjectsSettings <b>Description</b> : Changes
	 * the settings of project in customize settings
	 * 
	 * @param driver
	 * @param projectsSettings
	 * @param testCaseName
	 * @return
	 * @throws LoginLogoutException
	 * @throws ActionBotException
	 */
	public static ProjectsSettings changeProjectsSettings(WebDriver driver, ProjectsSettings projectsSettings, String testCaseName)
		throws LoginLogoutException, ActionBotException, FactoryMethodException
	{
		// navigates to TMS
		driver.get(ConfigProperty.getConfig("TMS_URL"));

		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
		MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
		PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

		if (projectsSettings.getAssignProjecttoPurchaseCost().equalsIgnoreCase(IPageProjectsSettings.ALWAYS))
		{
			PageProjectsSettings.clickOnAlways(driver);
		}
		if (projectsSettings.getAssignProjecttoPurchaseCost().equalsIgnoreCase(IPageProjectsSettings.NEVER))
		{
			PageProjectsSettings.clickOnNever(driver);
		}
		if (projectsSettings.getAssignProjecttoPurchaseCost().equalsIgnoreCase(IPageProjectsSettings.LET_USERS_DECIDE))
		{
			ActionBot.defaultSleep();
			PageProjectsSettings.clickOnLetUsersDecide(driver);
		}
		ScreenShot.screenshot(driver, testCaseName, "change in settings");

		PageProjectsSettings.clickOnSave(driver);
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESSFUL_SAVE_MESSAGE);
		// navigate back to eproc
		driver.get(ConfigProperty.getConfig("Product_URL"));
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
		return projectsSettings;
	}

	public static String getProjectsSettings(WebDriver driver, String testCaseName) throws LoginLogoutException, ActionBotException, FactoryMethodException
	{

		// navigates to Master data
		PageCustomizeSettings.clickOnMasterDataLink(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnCustomize(driver, testCaseName);

		// click on cost booking link
		PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);

		// get value of radio button clicked
		return PageProjectsSettings.getAssignProjectToPurchaseCost(driver);
	}
}
