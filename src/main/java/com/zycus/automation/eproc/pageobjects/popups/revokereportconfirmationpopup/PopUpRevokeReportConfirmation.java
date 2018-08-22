/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.revokereportconfirmationpopup;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpRevokeReportConfirmation
{

	public static void clickOnYesButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpRevokeReportConfirmation revokeReportConfirmation = FactoryPage.getInstanceOf(IPopUpRevokeReportConfirmationImpl.class);
		revokeReportConfirmation.clickOnYesButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpRevokeReportConfirmation revokeReportConfirmation = FactoryPage.getInstanceOf(IPopUpRevokeReportConfirmationImpl.class);
		revokeReportConfirmation.clickOnCancelButton(driver, testCaseName);

	}

	public static String getConfirmationMessage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpRevokeReportConfirmation revokeReportConfirmation = FactoryPage.getInstanceOf(IPopUpRevokeReportConfirmationImpl.class);
		return revokeReportConfirmation.getConfirmationMessage(driver, testCaseName);
	}

}
