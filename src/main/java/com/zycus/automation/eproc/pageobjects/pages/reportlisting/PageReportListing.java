/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.reportlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageReportListing
{
	static Logger logger = Logger.getLogger(PageReportListing.class);

	public static String selectSearchReportBy(WebDriver driver, String testCaseName, String searchReportBy) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.selectSearchReportBy(driver, testCaseName, searchReportBy);
	}

	public static String fillSearchReportName(WebDriver driver, String testCaseName, String reportToBeSearch) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.fillSearchReportName(driver, testCaseName, reportToBeSearch);
	}

	public static String getFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.getFirstReportName(driver, testCaseName);
	}

	public static void clickOnSearchReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		reportListing.clickOnSearchReportButton(driver, testCaseName);
	}

	public static void clickOnFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		reportListing.clickOnFirstReportName(driver, testCaseName);
	}

	public static void clickOnFirstReportActionsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		reportListing.clickOnFirstReportActionsLink(driver, testCaseName);
	}

	public static boolean isReportNotFoundLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.isReportNotFoundLabelPresent(driver, testCaseName);
	}

	public static void clickOnDeleteFolderIcon(WebDriver driver, String testCaseName, String folderName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		reportListing.clickOnDeleteFolderIcon(driver, testCaseName, folderName);
	}

	public static String getFirstFolderNameInReportListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.getFirstFolderNameInReportListing(driver, testCaseName);
	}

	public static String getFirstLastRefreshOnInReportListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReportListing reportListing = FactoryPage.getInstanceOf(IPageReportListingImpl.class);
		return reportListing.getFirstLastRefreshOnInReportListing(driver, testCaseName);
	}

}
