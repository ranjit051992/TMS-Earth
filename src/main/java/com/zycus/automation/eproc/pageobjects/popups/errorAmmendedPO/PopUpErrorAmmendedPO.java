package com.zycus.automation.eproc.pageobjects.popups.errorAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpErrorAmmendedPO
{
	public static boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpErrorAmmendedPO iPopUpErrorAmmendedPO = FactoryPage.getInstanceOf(IPopUpErrorAmmendedPOImpl.class);
		return iPopUpErrorAmmendedPO.isErrorMessageDisplayed(driver, testCaseName);
	}

	public static void clickOnOK(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpErrorAmmendedPO iPopUpErrorAmmendedPO = FactoryPage.getInstanceOf(IPopUpErrorAmmendedPOImpl.class);
		iPopUpErrorAmmendedPO.clickOnOK(driver, testCaseName);
	}

}
