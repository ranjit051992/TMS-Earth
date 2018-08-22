package com.zycus.automation.eproc.pageobjects.modals.masterdataSettingsProjectSelectBU;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalSelectBUProjectSettings
{
	public static void clickOnBUCheckbox(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalSelectBUProjectSettings iModalSelectBUProjectSettings = FactoryPage.getInstanceOf(IModalSelectBUProjectSettingsImpl.class);
		iModalSelectBUProjectSettings.clickOnBUCheckbox(driver, testCaseName, index);
	}

	public static void clickOnSaveSelectedBU(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectBUProjectSettings iModalSelectBUProjectSettings = FactoryPage.getInstanceOf(IModalSelectBUProjectSettingsImpl.class);
		iModalSelectBUProjectSettings.clickOnSaveSelectedBU(driver, testCaseName);
	}

	public static void clickOnBUCheckbox(WebDriver driver, String testCaseName, String BUName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectBUProjectSettings iModalSelectBUProjectSettings = FactoryPage.getInstanceOf(IModalSelectBUProjectSettingsImpl.class);
		iModalSelectBUProjectSettings.clickOnBUCheckbox(driver, testCaseName, BUName);
	}
}
