package com.zycus.automation.eproc.pageobjects.popups.rollBackAmmendedPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpRollBackAmmendedPO
{
	public static boolean isRollBackCancelPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpRollBackAmmendedPO iPopUpRollBackAmmendedPO = FactoryPage.getInstanceOf(IPopUpRollBackAmmendedPOImpl.class);
		return iPopUpRollBackAmmendedPO.isRollBackCancelPresent(driver, testCaseName);
	}

	public static boolean isRollBackContinuePresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPopUpRollBackAmmendedPO iPopUpRollBackAmmendedPO = FactoryPage.getInstanceOf(IPopUpRollBackAmmendedPOImpl.class);
		return iPopUpRollBackAmmendedPO.isRollBackContinuePresent(driver, testCaseName);
	}

	public static void clickOnCancelRollBack(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpRollBackAmmendedPO iPopUpRollBackAmmendedPO = FactoryPage.getInstanceOf(IPopUpRollBackAmmendedPOImpl.class);
		iPopUpRollBackAmmendedPO.clickOnCancelRollBack(driver, testCaseName);
	}
}
