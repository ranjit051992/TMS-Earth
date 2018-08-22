/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.systemtenantconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class PageSystemTenantConfiguration
{
	static Logger		logger								= Logger.getLogger(PageSystemTenantConfiguration.class);

	static UI_Elements	LINK_SYSTEM_TENANT_CONFIGURATION	= UIFactory.getElements("LINK_SYSTEM_TENANT_CONFIGURATION");
	static UI_Elements	SELECT_TENANT_NAMES					= UIFactory.getElements("SELECT_TENANT_NAMES");
	static UI_Elements	SELECT_SYSTEM_TENANT_CUSTOM_LANG	= UIFactory.getElements("SELECT_SYSTEM_TENANT_CUSTOM_LANG");
	static UI_Elements	LINK_PREVIEW_CUSTOM_LANG			= UIFactory.getElements("LINK_PREVIEW_CUSTOM_LANG");
	static UI_Elements	LABEL_STANDARD_NAMES				= UIFactory.getElements("LABEL_STANDARD_NAMES");
	static UI_Elements	LABEL_CUSTOMIZED_NAMES				= UIFactory.getElements("LABEL_CUSTOMIZED_NAMES");
	static UI_Elements	BUTTON_CLOSE_CUSTOM_LANG			= UIFactory.getElements("BUTTON_CLOSE_CUSTOM_LANG");
	static UI_Elements	BUTTON_UPDATE_SYSTEM_TENANT_CONFIG	= UIFactory.getElements("BUTTON_UPDATE_SYSTEM_TENANT_CONFIG");

	public static void clickOnSystemTenantConfigurationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SYSTEM_TENANT_CONFIGURATION);
	}

	public static String selectTenantNames(WebDriver driver, String testCaseName, String tenantName) throws ActionBotException
	{
		String selectedTenantName = ActionBot.selectElement(driver, SELECT_TENANT_NAMES, IConstantsData.SELECT_BY_VISIBLE_TEXT, tenantName);
		logger.info("Selected Tenant Name : " + selectedTenantName);
		return selectedTenantName;
	}

	public static String selectCustomLang(WebDriver driver, String testCaseName, String customLangName) throws ActionBotException
	{
		String selectedCustomLangName = ActionBot.selectElement(driver, SELECT_SYSTEM_TENANT_CUSTOM_LANG, IConstantsData.SELECT_BY_VISIBLE_TEXT, customLangName);
		logger.info("Selected Custom Lang Name : " + selectedCustomLangName);
		return selectedCustomLangName;
	}

	public static void clickOnPreviewCustomLang(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PREVIEW_CUSTOM_LANG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Preview Custom Lang");
	}

	public static List<String> getListOfStandardNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LABEL_STANDARD_NAMES);
		List<String> standardNames = new ArrayList<>();
		for (WebElement element : elements)
		{
			standardNames.add(element.getText().trim());
		}
		return standardNames;
	}

	public static List<String> getListOfCustomizedNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LABEL_CUSTOMIZED_NAMES);
		List<String> customizedNames = new ArrayList<>();
		for (WebElement element : elements)
		{
			customizedNames.add(element.getText().trim());
		}
		return customizedNames;
	}

	public static void clickOnCloseCustomLangButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_CUSTOM_LANG);
	}

	public static void clickOnUpdateConfigTenantButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Update System Tenant Config");
		ActionBot.click(driver, BUTTON_UPDATE_SYSTEM_TENANT_CONFIG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update System Tenant Config");
	}

}
