/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deletereport;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalDeleteReport
{

	public static void clickOnDeleteReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDeleteReport deleteReport = FactoryPage.getInstanceOf(IModalDeleteReportImpl.class);
		deleteReport.clickOnDeleteReportButton(driver, testCaseName);
	}

	public static void clickOnCloseDeleteReportModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDeleteReport deleteReport = FactoryPage.getInstanceOf(IModalDeleteReportImpl.class);
		deleteReport.clickOnCloseDeleteReportModal(driver, testCaseName);
	}

}
