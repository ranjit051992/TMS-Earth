/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.reportlistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalReportListingActions
{

	public static void clickOnViewReportDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalReportListingActions reportListingActions = FactoryPage.getInstanceOf(IModalReportListingActionsImpl.class);
		reportListingActions.clickOnViewReportDetailsLink(driver, testCaseName);
	}

	public static void clickOnShareReportLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalReportListingActions reportListingActions = FactoryPage.getInstanceOf(IModalReportListingActionsImpl.class);
		reportListingActions.clickOnShareReportLink(driver, testCaseName);
	}

	public static void clickOnDeleteReportLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalReportListingActions reportListingActions = FactoryPage.getInstanceOf(IModalReportListingActionsImpl.class);
		reportListingActions.clickOnDeleteReportLink(driver, testCaseName);
	}

	public static void clickOnShareReportLinkToShareAgain(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalReportListingActions reportListingActions = FactoryPage.getInstanceOf(IModalReportListingActionsImpl.class);
		reportListingActions.clickOnShareReportLinkToShareAgain(driver, testCaseName);
	}

}
