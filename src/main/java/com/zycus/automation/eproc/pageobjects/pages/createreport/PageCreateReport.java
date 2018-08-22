/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreport;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreateReport
{

	public static void selectTabularReportType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.selectTabularReportType(driver, testCaseName);
	}

	public static void selectSummaryReportType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.selectSummaryReportType(driver, testCaseName);
	}

	public static void selectMatrixReportType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.selectMatrixReportType(driver, testCaseName);
	}

	public static void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnNextButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnCancelButton(driver, testCaseName);
	}

	public static void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnBackButton(driver, testCaseName);
	}

	public static void clickOnRunReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnRunReportButton(driver, testCaseName);
	}

	public static void selectShowAllGroups(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.selectShowAllGroups(driver, testCaseName);
	}

	public static void selectShowTopLevelGroups(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.selectShowTopLevelGroups(driver, testCaseName);
	}

	public static void clickOnSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnSelectAllColumns(driver, testCaseName);
	}

	public static void clickOnDeSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnDeSelectAllColumns(driver, testCaseName);
	}

	public static List<WebElement> getListOfCloumnGroup1CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getListOfCloumnGroup1CheckBoxes(driver, testCaseName);
	}

	public static List<WebElement> getListOfCloumnGroup2CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getListOfCloumnGroup2CheckBoxes(driver, testCaseName);
	}

	public static List<WebElement> getListOfCloumnGroup3CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getListOfCloumnGroup3CheckBoxes(driver, testCaseName);
	}

	public static List<WebElement> getListOfCloumnGroup4CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getListOfCloumnGroup4CheckBoxes(driver, testCaseName);
	}

	public static List<WebElement> getListOfCloumnGroup5CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getListOfCloumnGroup5CheckBoxes(driver, testCaseName);
	}

	public static void clickOnSummarizeReportBySum(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnSummarizeReportBySum(driver, testCaseName);
	}

	public static void clickOnSummarizeReportByAverage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnSummarizeReportByAverage(driver, testCaseName);
	}

	public static void clickOnSummarizeReportByMaximumValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnSummarizeReportByMaximumValue(driver, testCaseName);
	}

	public static void clickOnSummarizeReportByMinimumValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnSummarizeReportByMinimumValue(driver, testCaseName);
	}

	public static String selectDurationFilterOn(WebDriver driver, String testCaseName, String durationFilterOn) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.selectDurationFilterOn(driver, testCaseName, durationFilterOn);
	}

	public static String selectDurationFilterPeriod(WebDriver driver, String testCaseName, String period) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.selectDurationFilterPeriod(driver, testCaseName, period);
	}

	public static void clickOnStartDatePicker(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnStartDatePicker(driver, testCaseName);
	}

	public static void clickOnEndDatePicker(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnEndDatePicker(driver, testCaseName);
	}

	public static String getStartDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getStartDate(driver, testCaseName);
	}

	public static String getEndDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getEndDate(driver, testCaseName);
	}

	public static String selectStartDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.selectStartDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static String selectEndDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.selectEndDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static void clickOnMatchAllConditions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnMatchAllConditions(driver, testCaseName);
	}

	public static void clickOnMatchAnyOfConditions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		createReport.clickOnMatchAnyOfConditions(driver, testCaseName);
	}

	public static String selectChartType(WebDriver driver, String testCaseName, String chartType) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.selectChartType(driver, testCaseName, chartType);
	}

	public static boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.isCancelButtonPresent(driver, testCaseName);
	}

	public static String getSelectedChartType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReport createReport = FactoryPage.getInstanceOf(IPageCreateReportImpl.class);
		return createReport.getSelectedChartType(driver, testCaseName);
	}

}
