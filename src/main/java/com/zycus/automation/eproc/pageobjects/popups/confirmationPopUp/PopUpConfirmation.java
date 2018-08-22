package com.zycus.automation.eproc.pageobjects.popups.confirmationPopUp;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpConfirmation
{
	public static void clickOnConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopUpConfirmation iPopUpConfirmation = FactoryPage.getInstanceOf(IPopUpConfirmationImpl.class);
		iPopUpConfirmation.clickOnConfirmationYes(driver, testCaseName);
	}
}
