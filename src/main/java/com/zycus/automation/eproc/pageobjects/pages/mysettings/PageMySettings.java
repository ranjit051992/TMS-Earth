/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mysettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageMySettings
{

	public static String fillDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		return mySettings.fillDelegateApprovalFrom(driver, testCaseName, delegateFromUserName);
	}

	public static String fillDelegateApprovalTo(WebDriver driver, String testCaseName, String delegateToUserName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		return mySettings.fillDelegateApprovalTo(driver, testCaseName, delegateToUserName);
	}

	public static String getFromDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		return mySettings.getFromDelegateDate(driver, testCaseName);
	}

	public static String getToDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		return mySettings.getToDelegateDate(driver, testCaseName);
	}

	public static void clickOnEnableButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		mySettings.clickOnEnableButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		mySettings.clickOnCancelButton(driver, testCaseName);
	}

	public static String fillRevokeDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		return mySettings.fillRevokeDelegateApprovalFrom(driver, testCaseName, delegateFromUserName);
	}

	public static void clickOnRevokeButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMySettings mySettings = FactoryPage.getInstanceOf(IPageMySettingsImpl.class);
		mySettings.clickOnRevokeButton(driver, testCaseName);
	}

}
