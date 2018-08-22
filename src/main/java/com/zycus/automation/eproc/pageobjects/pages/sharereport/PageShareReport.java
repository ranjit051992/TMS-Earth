/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.sharereport;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageShareReport
{

	public static String selectUserForSharingReport(WebDriver driver, String testCaseName, String emailId) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		return shareReport.selectUserForSharingReport(driver, testCaseName, emailId);
	}

	public static String getEmailIdOfSelectedUser(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		return shareReport.getEmailIdOfSelectedUser(driver, testCaseName);
	}

	public static void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		shareReport.clickOnShareReportButton(driver, testCaseName);
	}

	public static void clickOnRemoveAllSelectedUsersButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		shareReport.clickOnRemoveAllSelectedUsersButton(driver, testCaseName);
	}

	public static boolean isSharedWithIconPresent(WebDriver driver, String testCaseName, String sharedWith) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		return shareReport.isSharedWithIconPresent(driver, testCaseName, sharedWith);
	}

	public static void clickOnBackToReportListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageShareReport shareReport = FactoryPage.getInstanceOf(IPageShareReportImpl.class);
		shareReport.clickOnBackToReportListing(driver, testCaseName);
	}

}
