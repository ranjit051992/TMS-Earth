package com.zycus.automation.eproc.pageobjects.tabs.TMS_MainPageHeaderLevelTabs;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageTMSmainHeaderLevelTabs
{
	static UI_Elements	TAB_MASTER_DATA_TMS		= UIFactory.getElements("TAB_MASTER_DATA_TMS");
	static UI_Elements	TAB_MASTER_DATA_TMS_2	= UIFactory.getElements("TAB_MASTER_DATA_TMS_2");

	public static void clickOnMasterDataSettingsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After logging in TMS product");
		if (ActionBot.isElementDisplayed(driver, TAB_MASTER_DATA_TMS))
		{
			ActionBot.click(driver, TAB_MASTER_DATA_TMS);
		}
		else
		{
			ActionBot.click(driver, TAB_MASTER_DATA_TMS_2);
		}

		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Master data setting tab");
	}
}
