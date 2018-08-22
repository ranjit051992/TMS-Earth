/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.revokereports;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRevokeReport
{
	public static boolean selectUserToRevokeReport(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException, FactoryMethodException
	{
		IModalRevokeReport revokeReport = FactoryPage.getInstanceOf(IModalRevokeReportImpl.class);
		return revokeReport.selectUserToRevokeReport(driver, testCaseName, userEmailId);
	}

	public static void clickOnRevokeReportButton(WebDriver driver, String testCaseName, String userEmailId) throws ActionBotException, FactoryMethodException
	{
		IModalRevokeReport revokeReport = FactoryPage.getInstanceOf(IModalRevokeReportImpl.class);
		revokeReport.clickOnRevokeReportButton(driver, testCaseName, userEmailId);
	}

	public static void clickOnCloseRevokeReportModalButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRevokeReport revokeReport = FactoryPage.getInstanceOf(IModalRevokeReportImpl.class);
		revokeReport.clickOnCloseRevokeReportModalButton(driver, testCaseName);
	}
}
