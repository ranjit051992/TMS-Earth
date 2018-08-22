/**
 * 
 */
package com.zycus.automation.eproc.businessflow.reportlistingflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.deletereport.ModalDeleteReport;
import com.zycus.automation.eproc.pageobjects.modals.reportlistingactions.ModalReportListingActions;
import com.zycus.automation.eproc.pageobjects.pages.reportlisting.PageReportListing;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class FlowReportListing
{
	static Logger logger = Logger.getLogger(FlowReportListing.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchReportBy </font><b><br>
	 * @param reoprtName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchReport(WebDriver driver, String testCaseName, String searchReportBy, String reoprtName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		MainPageHeaderLevelTab.clickOnReportTab(driver, testCaseName);
		if (searchReportBy != null)
		{
			PageReportListing.selectSearchReportBy(driver, testCaseName, searchReportBy);
		}
		PageReportListing.fillSearchReportName(driver, testCaseName, reoprtName);
		PageReportListing.clickOnSearchReportButton(driver, testCaseName);

		if (!PageReportListing.isReportNotFoundLabelPresent(driver, testCaseName))
		{
			flag = PageReportListing.getFirstReportName(driver, testCaseName).equalsIgnoreCase(reoprtName);
		}
		else
		{
			logger.info("No reports found.");
		}

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void viewFirstReport(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageReportListing.clickOnFirstReportName(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To delete report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean deleteReport(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageReportListing.clickOnFirstReportActionsLink(driver, testCaseName);
		ModalReportListingActions.clickOnDeleteReportLink(driver, testCaseName);
		ModalDeleteReport.clickOnDeleteReportButton(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking delete button");
		if (ActionBot.isAlertPresent(driver, testCaseName))
		{
			driver.switchTo().alert().accept();
		}
		ScreenShot.screenshot(driver, testCaseName, "After handling alert box");
		ActionBot.defaultSleep();
		return PageReportListing.isReportNotFoundLabelPresent(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To delete folder <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean deleteFolder(WebDriver driver, String testCaseName, String folderName) throws ActionBotException, FactoryMethodException
	{
		PageReportListing.clickOnDeleteFolderIcon(driver, testCaseName, folderName);
		ModalDeleteReport.clickOnDeleteReportButton(driver, testCaseName);
		return true;
	}
}
