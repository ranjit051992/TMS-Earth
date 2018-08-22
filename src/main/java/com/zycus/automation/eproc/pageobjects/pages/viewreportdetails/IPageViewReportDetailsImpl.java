/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewreportdetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageViewReportDetailsImpl implements IPageViewReportDetails
{
	static Logger logger = Logger.getLogger(IPageViewReportDetailsImpl.class);

	@Override
	public String clickOnRefreshButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_REFRESH_REPORT);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
		Date date = new Date();
		String currentDateAndTime = dateFormat.format(date);

		waitTillPageIsLoading(driver, testCaseName);
		return currentDateAndTime;
	}

	@Override
	public void clickOnModifyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_MODIFY_REPORT);
		waitTillPageIsLoading(driver, testCaseName);
	}

	@Override
	public void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_FILTER_REPORT);
	}

	@Override
	public void clickOnSaveAsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_AS_REPORT);
		waitTillPageIsLoading(driver, testCaseName);
	}

	@Override
	public void clickOnCloseReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_REPORT);
		ActionBot.defaultSleep();
		// waitTillPageIsLoading(driver, testCaseName);
	}

	@Override
	public void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_REPORT);
		waitTillPageIsLoading(driver, testCaseName);
	}

	@Override
	public void hoverOnMoreOptionsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_MORE_OPTIONS);
	}

	@Override
	public void clickOnShareReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		hoverOnMoreOptionsButton(driver, testCaseName);
		ActionBot.focusAndclick(driver, LINK_SHARE_REPORTS);
		waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on share report button");
	}

	@Override
	public void clickOnRevokeReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		hoverOnMoreOptionsButton(driver, testCaseName);
		ActionBot.defaultSleep();

		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(ActionBot.findElement(driver,
		 * LINK_MORE_OPTIONS)) .moveToElement(ActionBot.findElement(driver,
		 * LINK_SHARE_REPORTS)) .click(ActionBot.findElement(driver,
		 * LINK_REVOKE_REPORTS)).build().perform();
		 */
		ActionBot.focusAndclick(driver, LINK_REVOKE_REPORTS);
	}

	@Override
	public void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		hoverOnMoreOptionsButton(driver, testCaseName);
		ActionBot.focusAndclick(driver, LINK_DELETE_REPORTS);
	}

	@Override
	public String getReportName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reportName = ActionBot.getTextWithInElement(driver, LABEL_REPORT_NAME_ON_HEADER);
		logger.info("Report Name as on header : " + reportName);
		return reportName;
	}

	@Override
	public String getSummaryHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reportSummary = ActionBot.getTextWithInElement(driver, LABEL_REPORT_SUMMARY_HEADER);
		logger.info("Report Summary : " + reportSummary);
		return reportSummary;
	}

	@Override
	public String getAppliedFilterInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String filterInfo = ActionBot.getTextWithInElement(driver, LABEL_APPLIED_FILTER);
		logger.info("Applied filter information : " + filterInfo);
		return filterInfo;
	}

	@Override
	public List<String> getAddedColumnNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String log = "";
		List<String> addedColumnsNames = new ArrayList<String>();
		List<WebElement> elements = ActionBot.findElements(driver, LABEL_REPORT_SUMMARY_ADDED_COLUMNS);
		for (WebElement element : elements)
		{
			log += element.getText().trim() + "\n";
			addedColumnsNames.add(element.getText().trim());
		}
		logger.info("Added Column Names : \n" + log);

		return addedColumnsNames;
	}

	@Override
	public void waitTillPageIsLoading(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV_VIEW_REPORT_DETAILS);
	}

	@Override
	public boolean isCloseButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_CLOSE_REPORT);
	}

}
