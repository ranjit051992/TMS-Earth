/**
 * 
 */
package com.zycus.automation.eproc.businessflow.viewreportdetailsflow;

import static org.junit.Assert.assertTrue;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Report;
import com.zycus.automation.eproc.businessflow.reportlistingflow.FlowReportListing;
import com.zycus.automation.eproc.pageobjects.modals.reportlistingactions.ModalReportListingActions;
import com.zycus.automation.eproc.pageobjects.modals.revokereports.ModalRevokeReport;
import com.zycus.automation.eproc.pageobjects.modals.savereportas.ModalSaveReportAs;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.reportlisting.PageReportListing;
import com.zycus.automation.eproc.pageobjects.pages.sharereport.PageShareReport;
import com.zycus.automation.eproc.pageobjects.pages.viewreportdetails.PageViewReportDetails;
import com.zycus.automation.eproc.pageobjects.popups.revokereportconfirmationpopup.PopUpRevokeReportConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.sharereportpopup.PopUpShareReport;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowViewReportDetails
{
	static Logger logger = Logger.getLogger(FlowViewReportDetails.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To save as report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param report </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static Report saveReportAs(WebDriver driver, String testCaseName, Report report) throws ActionBotException, FactoryMethodException
	{
		PageViewReportDetails.clickOnSaveAsButton(driver, testCaseName);
		report.setReportName(ModalSaveReportAs.fillReportName(driver, testCaseName, report.getReportName()));
		ModalSaveReportAs.clickOnCreateNewFolder(driver, testCaseName);
		report.setFolderName(ModalSaveReportAs.fillFolderName(driver, testCaseName, report.getFolderName()));
		ModalSaveReportAs.clickOnSaveReportButton(driver, testCaseName);
		if (ActionBot.isAlertPresent(driver, testCaseName))
		{
			driver.switchTo().alert().accept();
		}
		return report;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check if report saved <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param reportName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean checkIfReportSaved(WebDriver driver, String testCaseName, String reportName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		String report_name_as_on_view_page = PageViewReportDetails.getReportName(driver, testCaseName);
		String[] temp = StringUtils.split(report_name_as_on_view_page, ":");
		report_name_as_on_view_page = temp[1].trim();
		flag = report_name_as_on_view_page.equalsIgnoreCase(reportName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To share report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param userEmailId </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean shareReport(WebDriver driver, String testCaseName, String reportName, String userEmailId) throws ActionBotException, FactoryMethodException
	{
		PageViewReportDetails.clickOnShareReportButton(driver, testCaseName);
		PageShareReport.selectUserForSharingReport(driver, testCaseName, userEmailId);
		PageShareReport.clickOnShareReportButton(driver, testCaseName);
		PopUpShareReport.clickOnGoToReportButton(driver, testCaseName);
		ActionBot.defaultSleep();
		return checkIfReportIsShared(driver, testCaseName, reportName, userEmailId);
	}

	public static boolean refreshReport(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		String currentDateAndTime = PageViewReportDetails.clickOnRefreshButton(driver, testCaseName);
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
		 * Date date = new Date(); String currentDateAndTime =
		 * dateFormat.format(date);
		 */
		logger.info("Current Date and Time : " + currentDateAndTime);

		String dateAndTimeAsOnViewPage = PageViewReportDetails.getSummaryHeader(driver, testCaseName);
		String[] temp = StringUtils.split(dateAndTimeAsOnViewPage, "|");
		dateAndTimeAsOnViewPage = temp[1].trim();
		temp = StringUtils.split(dateAndTimeAsOnViewPage, ":");
		dateAndTimeAsOnViewPage = temp[1].trim() + ":" + temp[2].trim();
		logger.info("Last Refresh Date and Time as on Report View Page: " + dateAndTimeAsOnViewPage);

		flag = currentDateAndTime.equalsIgnoreCase(dateAndTimeAsOnViewPage);

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check if report shared <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param reportName </font><b><br>
	 * @param sharedWith </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean checkIfReportIsShared(WebDriver driver, String testCaseName, String reportName, String sharedWith) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;

		flag = FlowReportListing.searchReport(driver, testCaseName, IConstantsData.SEARCH_REPORT_BY_ALL, reportName);
		assertTrue("Error while searching report", flag);

		PageReportListing.clickOnFirstReportActionsLink(driver, testCaseName);
		ModalReportListingActions.clickOnShareReportLinkToShareAgain(driver, testCaseName);

		flag = PageShareReport.isSharedWithIconPresent(driver, testCaseName, sharedWith);
		PageShareReport.clickOnBackToReportListing(driver, testCaseName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Revoke report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param userEmailId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean revokeReport(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PageViewReportDetails.clickOnRevokeReportButton(driver, testCaseName);
		ModalRevokeReport.selectUserToRevokeReport(driver, testCaseName, userEmailId);
		ModalRevokeReport.clickOnRevokeReportButton(driver, testCaseName, userEmailId);
		PopUpRevokeReportConfirmation.clickOnYesButton(driver, testCaseName);
		//ActionBot.defaultMediumSleep();
		flag = ((PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1)
			&& (PageAllRequestsApproval.getMessageOnEmptyTable(driver, testCaseName).equalsIgnoreCase(IConstantsData.NotSharedWithAnyUser)));
		ModalRevokeReport.clickOnCloseRevokeReportModalButton(driver, testCaseName);

		return flag;
	}
}
