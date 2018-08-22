/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.othernotification;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageOtherNotificationSetting
{

	public static void clickOnBuyersDeskInfoLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageOtherNotificationSetting otherNotificationSetting = FactoryPage.getInstanceOf(IPageOtherNotificationSettingImpl.class);
		otherNotificationSetting.clickOnBuyersDeskInfoLink(driver, testCaseName);
	}

	public static void clickOnPOReleasedInfoLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageOtherNotificationSetting otherNotificationSetting = FactoryPage.getInstanceOf(IPageOtherNotificationSettingImpl.class);
		otherNotificationSetting.clickOnPOReleasedInfoLink(driver, testCaseName);
	}

	public static String getSubjectTemplate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageOtherNotificationSetting otherNotificationSetting = FactoryPage.getInstanceOf(IPageOtherNotificationSettingImpl.class);
		return otherNotificationSetting.getSubjectTemplate(driver, testCaseName);
	}

	public static String getBodyTemplate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageOtherNotificationSetting otherNotificationSetting = FactoryPage.getInstanceOf(IPageOtherNotificationSettingImpl.class);
		return otherNotificationSetting.getBodyTemplate(driver, testCaseName);
	}

}
