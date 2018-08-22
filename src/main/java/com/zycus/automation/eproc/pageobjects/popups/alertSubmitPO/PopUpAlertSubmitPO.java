package com.zycus.automation.eproc.pageobjects.popups.alertSubmitPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpAlertSubmitPO
{
	public static boolean isAlertPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertSubmitPO iPopUpAlertSubmitPO = FactoryPage.getInstanceOf(IPopUpAlertSubmitPOImpl.class);
		return iPopUpAlertSubmitPO.isAlertPopUpPresent(driver, testCaseName);
	}

	public static boolean isAlertMessageCorrect(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertSubmitPO iPopUpAlertSubmitPO = FactoryPage.getInstanceOf(IPopUpAlertSubmitPOImpl.class);
		return iPopUpAlertSubmitPO.isAlertMessageCorrect(driver, testCaseName);
	}

	public static void clickOnOK(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertSubmitPO iPopUpAlertSubmitPO = FactoryPage.getInstanceOf(IPopUpAlertSubmitPOImpl.class);
		iPopUpAlertSubmitPO.clickOnOK(driver, testCaseName);
	}

	public static boolean isAlertOKPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertSubmitPO iPopUpAlertSubmitPO = FactoryPage.getInstanceOf(IPopUpAlertSubmitPOImpl.class);
		return iPopUpAlertSubmitPO.isAlertOKPresent(driver, testCaseName);
	}

	public static void clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpAlertSubmitPO iPopUpAlertSubmitPO = FactoryPage.getInstanceOf(IPopUpAlertSubmitPOImpl.class);
		iPopUpAlertSubmitPO.clickOnYes(driver, testCaseName);
	}
}
