/**
 * 
 */
package com.zycus.automation.eproc.businessflow.createreportflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.Report;
import com.zycus.automation.eproc.pageobjects.pages.createreport.PageCreateReport;
import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 *
 */
public class FlowCreateReport
{
	static Logger logger = Logger.getLogger(FlowCreateReport.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Fill modify report wizard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param report </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static Report fillModifyReportWizard(WebDriver driver, String testCaseName, Report report) throws ActionBotException, FactoryMethodException
	{
		// Step 1 : report type
		if (report.getReportType() != null)
		{
			if (report.getReportType().equalsIgnoreCase(IConstantsData.TABULAR_REPORT_TYPE))
			{
				PageCreateReport.selectTabularReportType(driver, testCaseName);
			}
			else if (report.getReportType().equalsIgnoreCase(IConstantsData.SUMMARY_REPORT_TYPE))
			{
				PageCreateReport.selectSummaryReportType(driver, testCaseName);
			}
			else if (report.getReportType().equalsIgnoreCase(IConstantsData.MATRIX_REPORT_TYPE))
			{
				PageCreateReport.selectMatrixReportType(driver, testCaseName);
			}
			else
			{
				logger.info("Invalid report type");
			}
		}

		PageCreateReport.clickOnNextButton(driver, testCaseName);
		// Step 2 : Grouping for Summary Report
		if (report.isShowAllGroups())
		{
			PageCreateReport.selectShowAllGroups(driver, testCaseName);
		}
		else if (report.isShowTopLevelGroups())
		{
			PageCreateReport.selectShowTopLevelGroups(driver, testCaseName);
		}
		PageCreateReport.clickOnNextButton(driver, testCaseName);

		// Step 3 : Report Columns
		if (report.isSelectReoprtColumns())
		{
			report.setReportColumns(selectReportColumns(driver, testCaseName));
		}
		PageCreateReport.clickOnNextButton(driver, testCaseName);

		// Step 4 : Summarize report by
		if (report.isSummarizeReoprtBySum())
		{
			PageCreateReport.clickOnSummarizeReportBySum(driver, testCaseName);
		}
		if (report.isSummarizeReoprtByAverage())
		{
			PageCreateReport.clickOnSummarizeReportByAverage(driver, testCaseName);
		}
		if (report.isSummarizeReoprtByMaximumValue())
		{
			PageCreateReport.clickOnSummarizeReportByMaximumValue(driver, testCaseName);
		}
		if (report.isSummarizeReoprtByMinimumValue())
		{
			PageCreateReport.clickOnSummarizeReportByMinimumValue(driver, testCaseName);
		}

		PageCreateReport.clickOnNextButton(driver, testCaseName);

		// Step 5 : order report columns
		PageCreateReport.clickOnNextButton(driver, testCaseName);

		// setp 6 : Report Filter Selection
		if (report.getDurationFilterOn() != null)
		{
			report.setDurationFilterOn(PageCreateReport.selectDurationFilterOn(driver, testCaseName, report.getDurationFilterOn()));
		}

		if (report.getDurationFilterPeriod() != null)
		{
			report.setDurationFilterPeriod(PageCreateReport.selectDurationFilterPeriod(driver, testCaseName, report.getDurationFilterPeriod()));
		}

		if (report.getStartDate() != null)
		{
			report.getStartDate()
				.setDate(PageCreateReport.selectStartDate(driver, testCaseName, report.getStartDate().getDay(), report.getStartDate().getMonth(), report.getStartDate().getYear()));
		}

		if (report.getEndDate() != null)
		{
			report.getEndDate()
				.setDate(PageCreateReport.selectEndDate(driver, testCaseName, report.getEndDate().getDay(), report.getEndDate().getMonth(), report.getEndDate().getYear()));
		}

		if (report.isMatchAllConditions())
		{
			PageCreateReport.clickOnMatchAllConditions(driver, testCaseName);
		}
		if (report.isMatchAnyConditions())
		{
			PageCreateReport.clickOnMatchAnyOfConditions(driver, testCaseName);
		}
		PageCreateReport.clickOnNextButton(driver, testCaseName);

		// Step 7 : Charts and Highlights
		if (report.getChartType() != null)
		{
			report.setChartType(PageCreateReport.selectChartType(driver, testCaseName, report.getChartType()));
		}

		return report;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Select report columns <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static List<String> selectReportColumns(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		List<String> selectedReportColumns = new ArrayList<String>();
		WebElement element = null;
		String selectedColumnName = null;
		int size = 0;

		PageCreateReport.clickOnDeSelectAllColumns(driver, testCaseName);
		ActionBot.defaultSleep();
		// column group1
		for (int i = 0; i < 2; i++)
		{
			size = PageCreateReport.getListOfCloumnGroup1CheckBoxes(driver, testCaseName).size();
			int index = CommonUtilities.getRandomNumbersBetweenRange(2, 0, size);
			System.out.println("@@@@ Index : " + index);
			element = PageCreateReport.getListOfCloumnGroup1CheckBoxes(driver, testCaseName).get(index);
			if (!element.isSelected())
			{
				selectedColumnName = element.findElement(By.xpath(".//parent::td/label")).getText().trim();
				logger.info("Selected Column Name : " + selectedColumnName);
				element.click();
				selectedReportColumns.add(selectedColumnName);
			}
		}

		// column group2
		/*
		 * for (int i = 0; i < 2; i++) {
		 */
		ActionBot.scroll(driver);
		size = PageCreateReport.getListOfCloumnGroup2CheckBoxes(driver, testCaseName).size();
		int index = CommonUtilities.getRandomNumbersBetweenRange(2, 0, size);
		System.out.println("@@@@ Index : " + index);
		element = PageCreateReport.getListOfCloumnGroup2CheckBoxes(driver, testCaseName).get(index);
		// element = PageCreateReport.getListOfCloumnGroup2CheckBoxes(driver,
		// testCaseName).get(0);
		if (!element.isSelected())
		{
			selectedColumnName = element.findElement(By.xpath(".//parent::td/label")).getText().trim();
			logger.info("Selected Column Name : " + selectedColumnName);
			element.click();
			selectedReportColumns.add(selectedColumnName);
		}
		// }

		// column group3
		size = PageCreateReport.getListOfCloumnGroup3CheckBoxes(driver, testCaseName).size();
		element = PageCreateReport.getListOfCloumnGroup3CheckBoxes(driver, testCaseName).get(CommonUtilities.getRandomNumbersBetweenRange(2, 0, size));
		if (!element.isSelected())
		{
			selectedColumnName = element.findElement(By.xpath(".//parent::td/label")).getText().trim();
			logger.info("Selected Column Name : " + selectedColumnName);
			element.click();
			selectedReportColumns.add(selectedColumnName);
		}

		// column group4
		size = PageCreateReport.getListOfCloumnGroup4CheckBoxes(driver, testCaseName).size();
		element = PageCreateReport.getListOfCloumnGroup4CheckBoxes(driver, testCaseName).get(CommonUtilities.getRandomNumbersBetweenRange(2, 0, size));
		if (!element.isSelected())
		{
			selectedColumnName = element.findElement(By.xpath(".//parent::td/label")).getText().trim();
			logger.info("Selected Column Name : " + selectedColumnName);
			element.click();
			selectedReportColumns.add(selectedColumnName);
		}

		// column group5
		size = PageCreateReport.getListOfCloumnGroup5CheckBoxes(driver, testCaseName).size();
		element = PageCreateReport.getListOfCloumnGroup5CheckBoxes(driver, testCaseName).get(CommonUtilities.getRandomNumbersBetweenRange(2, 0, size));
		if (!element.isSelected())
		{
			selectedColumnName = element.findElement(By.xpath(".//parent::td/label")).getText().trim();
			logger.info("Selected Column Name : " + selectedColumnName);
			element.click();
			selectedReportColumns.add(selectedColumnName);
		}
		return selectedReportColumns;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Modify Report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param report </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static Report modifyReport(WebDriver driver, String testCaseName, Report report) throws ActionBotException, FactoryMethodException
	{
		PageViewReportDetails.clickOnModifyButton(driver, testCaseName);

		// fill modify report wizard
		report = fillModifyReportWizard(driver, testCaseName, report);

		// run report
		if (report.getNextAction().equalsIgnoreCase(IConstantsData.RUN_REPORT))
		{
			PageCreateReport.clickOnRunReportButton(driver, testCaseName);
		}
		else if (report.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_REPORT))
		{
			PageCreateReport.clickOnCancelButton(driver, testCaseName);
		}
		else if (report.getNextAction().equalsIgnoreCase(IConstantsData.BACK_REPORT))
		{
			PageCreateReport.clickOnBackButton(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid option for Modify Report");
		}
		return report;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check if report created with proper
	 * details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param report </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean checkIfReportCreatedWithProperDetails(WebDriver driver, String testCaseName, Report report) throws ActionBotException, FactoryMethodException
	{
		boolean addedColumnsFlag = false, appliedFilterFlag = false, chartTypeFlag = false, flag = false;

		// added columns
		List<String> addedColumns = PageViewReportDetails.getAddedColumnNames(driver, testCaseName);
		for (String var1 : report.getReportColumns())
		{
			for (String var2 : addedColumns)
			{
				if (var2.equalsIgnoreCase(var1))
				{
					addedColumnsFlag = true;
					break;
				}
				else
				{
					addedColumnsFlag = false;
				}
			}
		}

		// applied filter
		String appliedFilter = PageViewReportDetails.getAppliedFilterInfo(driver, testCaseName);
		String[] temp = StringUtils.split(appliedFilter, ":");
		appliedFilter = temp[1].trim();
		/*
		 * appliedFilterFlag =
		 * appliedFilter.equalsIgnoreCase(report.getStartDate().getDate().trim()
		 * + " to " + report.getEndDate().getDate().trim());
		 */
		appliedFilterFlag = appliedFilter.contains(report.getStartDate().getDate().trim());

		// chart type
		chartTypeFlag = PageCreateReport.getSelectedChartType(driver, testCaseName).equalsIgnoreCase(report.getChartType());

		logger.info("Added Columns Flag : " + addedColumnsFlag);
		logger.info("Applied Filter Flag : " + addedColumnsFlag);
		logger.info("Chart Type Flag : " + addedColumnsFlag);
		flag = addedColumnsFlag && appliedFilterFlag && chartTypeFlag;
		return flag;
	}
}
