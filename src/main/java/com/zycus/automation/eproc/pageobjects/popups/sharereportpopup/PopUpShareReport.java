/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.sharereportpopup;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpShareReport
{

	public static void clickOnGoToReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpShareReport shareReport = FactoryPage.getInstanceOf(IPopUpShareReportImpl.class);
		shareReport.clickOnGoToReportButton(driver, testCaseName);
	}

	public static void clickOnStayOnSharePage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpShareReport shareReport = FactoryPage.getInstanceOf(IPopUpShareReportImpl.class);
		shareReport.clickOnStayOnSharePage(driver, testCaseName);
	}

	public static String getShareReportSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpShareReport shareReport = FactoryPage.getInstanceOf(IPopUpShareReportImpl.class);
		return shareReport.getShareReportSuccessMessage(driver, testCaseName);
	}

}
