package com.zycus.automation.eproc.pageobjects.popups.alertAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpAlertAmmendedPO
{
	public static boolean isAlertPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		return iPopUpAlertAmmendedPO.isAlertPresent(driver, testCaseName);
	}

	public static boolean isAlertMessageSameAsDescribed(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		return iPopUpAlertAmmendedPO.isAlertMessageSameAsDescribed(driver, testCaseName);
	}

	public static boolean isContinuePresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		return iPopUpAlertAmmendedPO.isContinuePresent(driver, testCaseName);
	}

	public static boolean isCancelPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		return iPopUpAlertAmmendedPO.isCancelPresent(driver, testCaseName);
	}

	public static void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		iPopUpAlertAmmendedPO.clickOnCancel(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on continue button of alert amend pop up
	 */
	public static void clickOnContinueButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertAmmendedPO iPopUpAlertAmmendedPO = FactoryPage.getInstanceOf(IPopUpAlertAmmendedPOImpl.class);
		iPopUpAlertAmmendedPO.clickOnContinueButton(driver, testCaseName);
	}
}
