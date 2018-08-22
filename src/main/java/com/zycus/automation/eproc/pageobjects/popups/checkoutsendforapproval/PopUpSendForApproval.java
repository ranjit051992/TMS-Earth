/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PopUpSendForApproval
{

	static Logger logger = Logger.getLogger(PopUpSendForApproval.class);

	public static boolean isSendForApprovalYesButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpSendForApproval sendForApproval = FactoryPage.getInstanceOf(PopUpSendForApprovalImpl.class);
			return sendForApproval.isSendForApprovalYesButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  isSendForApprovalYesButtonPresent" + e, e);
		}
		return false;
	}

	public static boolean isSendForApprovalNoButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpSendForApproval sendForApproval = FactoryPage.getInstanceOf(PopUpSendForApprovalImpl.class);
			return sendForApproval.isSendForApprovalNoButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  isSendForApprovalYesButtonPresent" + e, e);
		}
		return false;
	}

	public static void clickOnSendForApprovalYesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpSendForApproval sendForApproval = FactoryPage.getInstanceOf(PopUpSendForApprovalImpl.class);
			sendForApproval.clickOnSendForApprovalYesButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  clickOnSendForApprovalYesButton" + e, e);
		}
	}

	public static void clickOnSendForApprovalNoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopUpSendForApproval sendForApproval = FactoryPage.getInstanceOf(PopUpSendForApprovalImpl.class);
			sendForApproval.clickOnSendForApprovalNoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  clickOnSendForApprovalNoButton" + e, e);
		}
	}

}
