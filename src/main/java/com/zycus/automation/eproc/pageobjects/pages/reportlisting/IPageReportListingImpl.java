/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.reportlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.IPageViewReportDetails;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageReportListingImpl implements IPageReportListing
{
	static Logger logger = Logger.getLogger(IPageReportListingImpl.class);

	@Override
	public String selectSearchReportBy(WebDriver driver, String testCaseName, String searchReportBy) throws ActionBotException
	{
		String selectedSearchReportBy = ActionBot.selectElement(driver, SELECT_SEARCH_REPORT_BY, IConstantsData.SELECT_BY_VISIBLE_TEXT, searchReportBy);
		logger.info("Selected searched report by : " + selectedSearchReportBy);
		return selectedSearchReportBy;
	}

	@Override
	public String fillSearchReportName(WebDriver driver, String testCaseName, String reportToBeSearch) throws ActionBotException
	{
		String reportName = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_REPORT, reportToBeSearch);
		logger.info("Entered report name for searching : " + reportName);
		return reportName;
	}

	@Override
	public String getFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reportName = ActionBot.getTextWithInElement(driver, LINK_FIRST_REPORT_NAME_IN_REPORT_LISTING_TABLE);
		logger.info("First Report Name : " + reportName);
		return reportName;
	}

	@Override
	public void clickOnSearchReportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on search report button");
		ActionBot.click(driver, BUTTON_SEARCH_REPORT);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, IPageViewReportDetails.LOADING_DIV_VIEW_REPORT_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on search report button");
	}

	@Override
	public void clickOnFirstReportName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on first report name");
		ActionBot.click(driver, LINK_FIRST_REPORT_NAME_IN_REPORT_LISTING_TABLE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first report name");
	}

	@Override
	public void clickOnFirstReportActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REPORTS_ACTIONS);
	}

	@Override
	public boolean isReportNotFoundLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		if (ActionBot.isElementDisplayed(driver, LABEL_NO_REPORTS_FOUND))
		{
			String value = ActionBot.getTextWithInElement(driver, LABEL_NO_REPORTS_FOUND).trim();
			logger.info("Empty table message : " + value);
			flag = value.equalsIgnoreCase(IConstantsData.NoReportsFoundMessage);
		}
		return flag;
	}

	@Override
	public void clickOnDeleteFolderIcon(WebDriver driver, String testCaseName, String folderName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='overviewScrollPan_RMS']//a[.//*[contains(text(),'" + folderName + "')]]/label[@class='deleteRepIcon_RMS']"));
	}

	@Override
	public String getFirstFolderNameInReportListing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String folderName = ActionBot.getTextWithInElement(driver, LABEL_FOLDER_NAME_ON_REPORT_LISTING);
		logger.info("Folder Name : " + folderName);
		return folderName;
	}

	@Override
	public String getFirstLastRefreshOnInReportListing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String lastRefreshOn = ActionBot.getTextWithInElement(driver, LABEL_LAST_REFRESH_ON_REPORT_LISTING);
		logger.info("Last Refresh On : " + lastRefreshOn);
		return lastRefreshOn;
	}

}
