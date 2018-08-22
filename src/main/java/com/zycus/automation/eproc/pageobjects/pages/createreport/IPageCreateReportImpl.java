/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreport;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreateReportImpl implements IPageCreateReport
{
	static Logger logger = Logger.getLogger(IPageCreateReportImpl.class);

	@Override
	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on next button");
		ActionBot.click(driver, BUTTON_NEXT_MODIFY_REPORT);
		PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on next button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel button");
		ActionBot.click(driver, BUTTON_CANCEL_MODIFY_REPORT);
		ActionBot.defaultSleep();
		// PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel button");
	}

	@Override
	public void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on back button");
		ActionBot.click(driver, BUTTON_BACK_MODIFY_REPORT);
		PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on back button");
	}

	@Override
	public void clickOnRunReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ActionBot.click(driver, BUTTON_RUN_REPORT);
		PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
	}

	@Override
	public void selectTabularReportType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_TABULAR_REPORT);
	}

	@Override
	public void selectSummaryReportType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SUMMARY_REPORT);
	}

	@Override
	public void selectMatrixReportType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_MATRIX_REPORT);
	}

	@Override
	public void selectShowAllGroups(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SHOW_ALL_GROUPS);
	}

	@Override
	public void selectShowTopLevelGroups(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SHOW_TOP_LEVEL_GROUPS);
	}

	@Override
	public void clickOnSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ALL_COLUMN);
	}

	@Override
	public void clickOnDeSelectAllColumns(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DESELECT_ALL_COLUMN);
	}

	@Override
	public List<WebElement> getListOfCloumnGroup1CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP1);
	}

	@Override
	public List<WebElement> getListOfCloumnGroup2CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		System.out.println("@@@@@ Size : " + ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP2).size());
		return ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP2);
	}

	@Override
	public List<WebElement> getListOfCloumnGroup3CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP3);
	}

	@Override
	public List<WebElement> getListOfCloumnGroup4CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP4);
	}

	@Override
	public List<WebElement> getListOfCloumnGroup5CheckBoxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_CHECKBOX_COLUMN_GROUP5);
	}

	@Override
	public void clickOnSummarizeReportBySum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_SUMMARIZE_REPORT_BY_SUM))
		{
			ActionBot.click(driver, CHECKBOX_SUMMARIZE_REPORT_BY_SUM);
		}
	}

	@Override
	public void clickOnSummarizeReportByAverage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_SUMMARIZE_REPORT_BY_AVERAGE))
		{
			ActionBot.click(driver, CHECKBOX_SUMMARIZE_REPORT_BY_AVERAGE);
		}
	}

	@Override
	public void clickOnSummarizeReportByMaximumValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_SUMMARIZE_REPORT_BY_MAXIMUM_VALUE))
		{
			ActionBot.click(driver, CHECKBOX_SUMMARIZE_REPORT_BY_MAXIMUM_VALUE);
		}
	}

	@Override
	public void clickOnSummarizeReportByMinimumValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_SUMMARIZE_REPORT_BY_MINIMUM_VALUE))
		{
			ActionBot.click(driver, CHECKBOX_SUMMARIZE_REPORT_BY_MINIMUM_VALUE);
		}
	}

	@Override
	public String selectDurationFilterOn(WebDriver driver, String testCaseName, String durationFilterOn) throws ActionBotException
	{
		String selectedDurationFilterOn = ActionBot.selectElement(driver, SELECT_DURATION_FILTER_ON, IConstantsData.SELECT_BY_VALUE, durationFilterOn);
		logger.info("Selected duration filter on : " + selectedDurationFilterOn);
		return selectedDurationFilterOn;
	}

	@Override
	public String selectDurationFilterPeriod(WebDriver driver, String testCaseName, String period) throws ActionBotException
	{
		String selectedPeriod = ActionBot.selectElement(driver, SELECT_PERIOD_DURATION_FILTER, IConstantsData.SELECT_BY_VALUE, period);
		logger.info("Selected period for duration filter : " + selectedPeriod);
		return selectedPeriod;
	}

	@Override
	public void clickOnStartDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_DURATION_START_DATE);
	}

	@Override
	public void clickOnEndDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_DURATION_END_DATE);
		ActionBot.defaultSleep();
	}

	@Override
	public String getStartDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String startDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_DURATION_START_DATE, "value");
		logger.info("Start Date : " + startDate);
		return startDate;
	}

	@Override
	public String getEndDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String endDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_DURATION_END_DATE, "value");
		logger.info("End Date : " + endDate);
		return endDate;
	}

	@Override
	public String selectStartDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		clickOnStartDatePicker(driver, testCaseName);

		ActionBot.selectDate(driver, day, month, year);

		return getStartDate(driver, testCaseName);
	}

	@Override
	public String selectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		clickOnEndDatePicker(driver, testCaseName);
		ActionBot.selectDate(driver, day, month, year);
		return getEndDate(driver, testCaseName);
	}

	@Override
	public void clickOnMatchAllConditions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_FILTER_MATCH_ALL_CONDITIONS);
	}

	@Override
	public void clickOnMatchAnyOfConditions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_FILTER_MATCH_ANY_CONDITIONS);
	}

	@Override
	public String selectChartType(WebDriver driver, String testCaseName, String chartType) throws ActionBotException
	{
		String selectedChartType = ActionBot.selectElement(driver, SELECT_CHART_TYPE, IConstantsData.SELECT_BY_VALUE, chartType);
		logger.info("Selected Chart Type : " + selectedChartType);
		return selectedChartType;
	}

	@Override
	public boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_CANCEL_MODIFY_REPORT);
	}

	@Override
	public String getSelectedChartType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_CHART_TYPE));
		String selectedChartType = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Chart Type : " + selectedChartType);
		return selectedChartType;
	}

}
