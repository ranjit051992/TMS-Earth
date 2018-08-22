/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.sharereportpopup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPopUpShareReportImpl implements IPopUpShareReport
{
	static Logger logger = Logger.getLogger(IPopUpShareReportImpl.class);

	@Override
	public void clickOnGoToReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Go to report button");
		ActionBot.click(driver, BUTTON_GO_TO_REPORT);
		PageViewReportDetails.waitTillPageIsLoading(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Go to report button");
	}

	@Override
	public void clickOnStayOnSharePage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Stay on share page button");
		ActionBot.click(driver, BUTTON_STAY_ON_SHARE_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Stay on share page button");
	}

	@Override
	public String getShareReportSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String message = ActionBot.getTextWithInElement(driver, LABEL_SHARE_REPORT_SUCCESS_MESSAGE);
		logger.info("Share report success message : " + message);
		return message;
	}
}
