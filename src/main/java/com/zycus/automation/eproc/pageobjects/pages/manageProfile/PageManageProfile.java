package com.zycus.automation.eproc.pageobjects.pages.manageProfile;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author kunal.ashar
 */

public class PageManageProfile
{

	static UI_Elements	TEXTBOX_LOCATION_NAME	= UIFactory.getElements("TEXTBOX_LOCATION_NAME");
	//CLIENT SPECIFIC- QTS
	static UI_Elements	DECIMAL_PRECISION		= UIFactory.getElements("DECIMAL_PRECISION");
	static UI_Elements	CANCEL_MANAGE_PROFILE	= UIFactory.getElements("CANCEL_MANAGE_PROFILE");
	static UI_Elements	DEFAULT_USER_CURRENCY	= UIFactory.getElements("DEFAULT_USER_CURRENCY");

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Change Cost center/ project/budget at line
	 * level <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 */
	public static String getUserDefaultLocation(WebDriver driver, String testCaseName) throws Exception
	{
		MainPageHeaderLevelTab.clickOnManageProfileTab(driver, testCaseName);
		String parentWindow = MainPageHeaderLevelTab.switchToUserProfileWindow(driver, testCaseName);
		String defaultLocation = ActionBot.findElement(driver, TEXTBOX_LOCATION_NAME).getAttribute("value");
		MainPageHeaderLevelTab.closeUserProfileWindow(driver, testCaseName, parentWindow);
		return defaultLocation;
	}

	/*
	 * Author: bhakti.sawant
	 * get decimal rounding off
	 */
	public static String getDecimalRoundingOff(WebDriver driver, String testCaseName) throws Exception
	{
		MainPageHeaderLevelTab.clickOnManageProfileTab(driver, testCaseName);
		ActionBot.scroll(driver, "900");
		String decimalPrecision = ActionBot.findElement(driver, DECIMAL_PRECISION).getText();
		cancelManageProfile(driver, testCaseName);
		return decimalPrecision;
	}

	/*
	 * Author: bhakti.sawant
	 * cancel Manage Profile
	 */
	public static void cancelManageProfile(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.click(driver, CANCEL_MANAGE_PROFILE);
		ActionBot.waitForPageLoad(driver);
	}

	public static String getDefaultCurrency(WebDriver driver, String testCaseName) throws Exception
	{
		MainPageHeaderLevelTab.clickOnManageProfileTab(driver, testCaseName);
		ActionBot.scroll(driver, "1000");
		String defaultCurrency = ActionBot.findElement(driver, DEFAULT_USER_CURRENCY).getText();
		cancelManageProfile(driver, testCaseName);
		return defaultCurrency;
	}
}
