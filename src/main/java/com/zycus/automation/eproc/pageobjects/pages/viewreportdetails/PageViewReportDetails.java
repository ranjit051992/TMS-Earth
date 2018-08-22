/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewreportdetails;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageViewReportDetails
{
	static Logger logger = Logger.getLogger(PageViewReportDetails.class);

	public static String clickOnRefreshButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.clickOnRefreshButton(driver, testCaseName);
	}

	public static void clickOnModifyButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnModifyButton(driver, testCaseName);
	}

	public static void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnFilterButton(driver, testCaseName);
	}

	public static void clickOnSaveAsButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnSaveAsButton(driver, testCaseName);
	}

	public static void clickOnCloseReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnCloseReportButton(driver, testCaseName);
	}

	public static void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnSaveReportButton(driver, testCaseName);
	}

	public static void hoverOnMoreOptionsButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.hoverOnMoreOptionsButton(driver, testCaseName);
	}

	public static void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnShareReportButton(driver, testCaseName);
	}

	public static void clickOnRevokeReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnRevokeReportButton(driver, testCaseName);
	}

	public static void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.clickOnDeleteReportButton(driver, testCaseName);
	}

	public static String getReportName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.getReportName(driver, testCaseName);
	}

	public static String getSummaryHeader(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.getSummaryHeader(driver, testCaseName);
	}

	public static String getAppliedFilterInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.getAppliedFilterInfo(driver, testCaseName);
	}

	public static List<String> getAddedColumnNames(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.getAddedColumnNames(driver, testCaseName);
	}

	public static void waitTillPageIsLoading(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		viewReportDetails.waitTillPageIsLoading(driver, testCaseName);
	}

	public static boolean isCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReportDetails viewReportDetails = FactoryPage.getInstanceOf(IPageViewReportDetailsImpl.class);
		return viewReportDetails.isCloseButtonPresent(driver, testCaseName);
	}

}
